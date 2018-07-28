package ke.co.slick.researchapp.data.apis

import io.reactivex.Observable
import ke.co.slick.researchapp.data.models.PubagResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val PUBAG_BASE_URL = "https://api.nal.usda.gov/pubag/rest/"

interface PubagApi {

    @Headers("Content-Type: application/json")
    @GET("search/")
    fun search(
            @Query("query") query: String,
            @Query("api_key") apiKey: String
    ): Observable<PubagResponse>
}