package ke.co.slick.researchapp.ui.searchresults

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ke.co.slick.researchapp.data.DataManager
import timber.log.Timber
import javax.inject.Inject

class SearchResultsPresenter @Inject constructor(
        private val dataManager: DataManager
) : SearchResultsContract.Presenter {

    private var view: SearchResultsContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: SearchResultsContract.View) {
        this.view = view
        Timber.i("view attached")
    }

    override fun detach() {
        view = null
        compositeDisposable.dispose()

        Timber.d("observable disposed")
    }

    override fun search(query: String, apiString: String) {
        val observable = dataManager.getSearchResults(query, apiString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { view?.displayResults(it) }

        compositeDisposable.add(observable)
    }
}