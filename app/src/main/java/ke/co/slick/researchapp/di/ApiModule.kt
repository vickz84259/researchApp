package ke.co.slick.researchapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ke.co.slick.researchapp.data.apis.PUBAG_BASE_URL
import ke.co.slick.researchapp.data.apis.PubagApi
import ke.co.slick.researchapp.data.apis.SPRINGER_BASE_URL
import ke.co.slick.researchapp.data.apis.SpringerApi
import ke.co.slick.researchapp.data.apis.USPTO_BASE_URL
import ke.co.slick.researchapp.data.apis.UsptoApi
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesSpringerApi(
            converterFactory: MoshiConverterFactory,
            adapterFactory: RxJava2CallAdapterFactory,
            client: OkHttpClient
    ): SpringerApi {
        return Retrofit.Builder()
            .baseUrl(SPRINGER_BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(SpringerApi::class.java)
    }

    @Singleton
    @Provides
    fun providesPubagApi(
            converterFactory: MoshiConverterFactory,
            adapterFactory: RxJava2CallAdapterFactory,
            client: OkHttpClient
    ): PubagApi {
        return Retrofit.Builder()
            .baseUrl(PUBAG_BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(PubagApi::class.java)
    }

    @Singleton
    @Provides
    fun providesUsptoApi(
            converterFactory: MoshiConverterFactory,
            adapterFactory: RxJava2CallAdapterFactory,
            client: OkHttpClient
    ): UsptoApi {
        return Retrofit.Builder()
            .baseUrl(USPTO_BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
            .create(UsptoApi::class.java)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(context: Context): OkHttpClient {
        val cacheSize: Long = 10 * 1024 * 1024 // 10MB
        val cache = Cache(context.cacheDir, cacheSize)

        val networkCacheInterceptor = Interceptor { chain ->
            val response = chain.proceed(chain.request())

            var cacheControl = CacheControl.Builder()
                .maxAge(1, TimeUnit.DAYS)
                .build()

            response.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build()
        }

        return OkHttpClient.Builder()
            .cache(cache)
            .addNetworkInterceptor(networkCacheInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesConverterFactory() = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun providesRxJavaAdapterFactory() = RxJava2CallAdapterFactory.create()

}