package ke.co.slick.researchapp

import android.app.Application
import ke.co.slick.researchapp.di.ContextModule
import ke.co.slick.researchapp.di.DaggerSingletonComponent
import ke.co.slick.researchapp.di.SingletonComponent
import timber.log.Timber

class ResearchApplication : Application() {

    lateinit var component: SingletonComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerSingletonComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}