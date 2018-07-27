package ke.co.slick.researchapp.ui.base

interface BasePresenter<T> {
    fun attach(view: T)

    fun detach()
}