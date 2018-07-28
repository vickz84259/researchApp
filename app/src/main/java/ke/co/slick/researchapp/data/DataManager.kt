package ke.co.slick.researchapp.data

import com.squareup.moshi.Moshi
import io.reactivex.Observable
import ke.co.slick.researchapp.data.apis.UsptoApi
import ke.co.slick.researchapp.data.models.UsptoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
        private val usptoApi: UsptoApi,
        private val cacheManager: CacheManager
) {

    private val moshi = Moshi.Builder().build()
    private val jsonAdapter = moshi.adapter(UsptoResponse::class.java)

    private fun getFromCache(query: String): UsptoResponse {
        val jsonData = cacheManager.getCache(query)
        return jsonAdapter.fromJson(jsonData) ?: throw NullPointerException()
    }

    private fun storeInCache(query: String, usptoResponse: UsptoResponse) {
        val jsonData = jsonAdapter.toJson(usptoResponse)
        cacheManager.storeCache(query, jsonData)
    }

    fun getSearchResults(query: String): Observable<UsptoResponse> {
        val modifiedQuery = "uspto:$query"

        return when (cacheManager.isCacheAvailable(modifiedQuery)) {
            true -> Observable.just(getFromCache(modifiedQuery))
            false -> usptoApi.search(query).doOnNext { storeInCache(modifiedQuery, it) }
        }
    }
}