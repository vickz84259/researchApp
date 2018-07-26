package ke.co.slick.researchapp.ui

import javax.inject.Inject

class SearchResultsPresenter @Inject constructor() : SearchResultsContract.Presenter {

    var view: SearchResultsContract.View? = null

    override fun attach(view: SearchResultsContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}