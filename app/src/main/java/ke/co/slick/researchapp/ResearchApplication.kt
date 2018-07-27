package ke.co.slick.researchapp

import android.app.Application
import ke.co.slick.researchapp.di.DaggerSingletonComponent
import ke.co.slick.researchapp.di.SingletonComponent

class ResearchApplication : Application() {

    lateinit var component: SingletonComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerSingletonComponent.create()
    }
}