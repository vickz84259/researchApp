package ke.co.slick.researchapp.ui.searchresults

import ke.co.slick.researchapp.data.models.Doc
import ke.co.slick.researchapp.ui.base.BasePresenter
import ke.co.slick.researchapp.ui.base.BaseView

interface SearchResultsContract {

    interface View : BaseView<Presenter> {
        fun displayResults(results: List<Doc>)
    }

    interface Presenter : BasePresenter<View> {
        fun search(query: String)
    }
}