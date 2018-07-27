package ke.co.slick.researchapp.di

import dagger.Binds
import dagger.Module
import ke.co.slick.researchapp.ui.searchresults.SearchResultsContract
import ke.co.slick.researchapp.ui.searchresults.SearchResultsPresenter

@Module
abstract class UIModule {

    @Binds
    abstract fun providePresenter(presenter: SearchResultsPresenter): SearchResultsContract.Presenter
}