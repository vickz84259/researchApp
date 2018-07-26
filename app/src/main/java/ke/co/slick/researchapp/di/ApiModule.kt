package ke.co.slick.researchapp.di

import dagger.Module
import dagger.Provides
import ke.co.slick.researchapp.data.apis.BASE_URL
import ke.co.slick.researchapp.data.apis.UsptoApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesApi(retrofit: Retrofit) = retrofit.create(UsptoApi::class.java)

    @Singleton
    @Provides
    fun providesRetrofit(
            converterFactory: MoshiConverterFactory,
            adapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providesConverterFactory() = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun providesRxJavaAdapterFactory() = RxJava2CallAdapterFactory.create()

}