package ke.co.slick.researchapp.ui.searchresults

import ke.co.slick.researchapp.ui.base.BasePresenter
import ke.co.slick.researchapp.ui.base.BaseView

interface SearchResultsContract {

    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter<View>
}