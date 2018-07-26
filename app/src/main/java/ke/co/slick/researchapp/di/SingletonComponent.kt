package ke.co.slick.researchapp.di

import dagger.Component
import ke.co.slick.researchapp.ui.SearchResultsActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])
interface SingletonComponent {
    fun inject(activity: SearchResultsActivity)
}