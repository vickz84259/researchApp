package ke.co.slick.researchapp.data

import com.squareup.moshi.Moshi
import io.reactivex.Observable
import ke.co.slick.researchapp.data.apis.UsptoApi
import ke.co.slick.researchapp.data.models.ApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
        private val usptoApi: UsptoApi,
        private val cacheManager: CacheManager
) {

    private val moshi = Moshi.Builder().build()
    private val jsonAdapter = moshi.adapter(ApiResponse::class.java)

    private fun getFromCache(query: String): ApiResponse {
        val jsonData = cacheManager.getCache(query)
        return jsonAdapter.fromJson(jsonData) ?: throw NullPointerException()
    }

    private fun storeInCache(query: String, apiResponse: ApiResponse) {
        val jsonData = jsonAdapter.toJson(apiResponse)
        cacheManager.storeCache(query, jsonData)
    }

    fun getSearchResults(query: String): Observable<ApiResponse> {
        val modifiedQuery = "uspto:$query"

        return when (cacheManager.isCacheAvailable(modifiedQuery)) {
            true -> Observable.just(getFromCache(modifiedQuery))
            false -> usptoApi.search(query).doOnNext { storeInCache(modifiedQuery, it) }
        }
    }
}