package ke.co.slick.researchapp.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.data.apis.USPTO_BASE_URL
import ke.co.slick.researchapp.data.apis.UsptoApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesSharedPreferences(context: Context): SharedPreferences {
        val filename = context.getString(R.string.preference_file)
        return context.getSharedPreferences(filename, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providesUsptoApi(
            converterFactory: MoshiConverterFactory,
            adapterFactory: RxJava2CallAdapterFactory
    ): UsptoApi {
        return Retrofit.Builder()
            .baseUrl(USPTO_BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(UsptoApi::class.java)
    }

    @Singleton
    @Provides
    fun providesConverterFactory() = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun providesRxJavaAdapterFactory() = RxJava2CallAdapterFactory.create()

}