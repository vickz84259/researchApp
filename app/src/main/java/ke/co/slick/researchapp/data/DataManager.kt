package ke.co.slick.researchapp.data

import io.reactivex.Observable
import ke.co.slick.researchapp.data.apis.PubagApi
import ke.co.slick.researchapp.data.apis.UsptoApi
import ke.co.slick.researchapp.data.models.ApiResponse
import ke.co.slick.researchapp.util.Utility
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
        private val usptoApi: UsptoApi,
        private val pubagApi: PubagApi,
        private val utility: Utility
) {

    fun getSearchResults(query: String, apiString: String): Observable<out ApiResponse> {
        return when (apiString) {
            utility.usptoString -> usptoApi.search(query)
            utility.pubagString -> pubagApi.search(query, utility.pubagApiKey)
            else -> throw NullPointerException()
        }
    }
}