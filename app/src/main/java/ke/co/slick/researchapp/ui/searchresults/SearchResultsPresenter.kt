package ke.co.slick.researchapp.ui.searchresults

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ke.co.slick.researchapp.data.DataManager
import timber.log.Timber
import javax.inject.Inject

class SearchResultsPresenter @Inject constructor(val dataManager: DataManager) :
        SearchResultsContract.Presenter {

    var view: SearchResultsContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: SearchResultsContract.View) {
        this.view = view
        Timber.i("view attached")
    }

    override fun detach() {
        this.view = null
        compositeDisposable.dispose()

        Timber.d("observable disposed")
    }

    override fun search(query: String) {
        val observable = dataManager.getSearchResults(query)
        compositeDisposable.add(
                observable
                    .subscribeOn(Schedulers.io())
                    .map { it.response.docs }
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { Timber.d("Observable subscribed") }
                    .doOnComplete { Timber.d("Observable completed") }
                    .subscribe { view?.displayResults(it) }
        )
    }
}