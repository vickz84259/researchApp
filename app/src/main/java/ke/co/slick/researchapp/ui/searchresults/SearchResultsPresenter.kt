package ke.co.slick.researchapp.ui.searchresults

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ke.co.slick.researchapp.data.DataManager
import javax.inject.Inject

class SearchResultsPresenter @Inject constructor(val dataManager: DataManager) :
        SearchResultsContract.Presenter {

    var view: SearchResultsContract.View? = null
    val compositeDisposable = CompositeDisposable()

    override fun attach(view: SearchResultsContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
        compositeDisposable.dispose()
    }

    override fun search(query: String) {
        val observable = dataManager.getSearchResults(query)
        compositeDisposable.add(
                observable
                    .subscribeOn(Schedulers.io())
                    .map { it.docs }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { view?.displayResults(it) }
        )
    }
}