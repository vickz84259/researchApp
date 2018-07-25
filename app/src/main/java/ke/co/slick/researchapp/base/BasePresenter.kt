package ke.co.slick.researchapp.base

interface BasePresenter<T> {
    fun attach(view: T)

    fun detach()
}