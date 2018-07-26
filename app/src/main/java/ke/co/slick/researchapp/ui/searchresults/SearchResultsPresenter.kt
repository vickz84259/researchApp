package ke.co.slick.researchapp.ui.searchresults

import ke.co.slick.researchapp.data.DataManager
import javax.inject.Inject

class SearchResultsPresenter @Inject constructor(val dataManager: DataManager) :
        SearchResultsContract.Presenter {

    var view: SearchResultsContract.View? = null

    override fun attach(view: SearchResultsContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}