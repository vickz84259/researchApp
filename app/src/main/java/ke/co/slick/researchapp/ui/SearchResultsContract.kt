package ke.co.slick.researchapp.ui

import ke.co.slick.researchapp.base.BasePresenter
import ke.co.slick.researchapp.base.BaseView

interface SearchResultsContract {

    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter<View>
}