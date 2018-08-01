package ke.co.slick.researchapp.data.apis

import io.reactivex.Observable
import ke.co.slick.researchapp.data.models.SpringerResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val SPRINGER_BASE_URL = "https://api.springernature.com/"

interface SpringerApi {

    @GET("openaccess/json")
    fun search(
            @Query("q") query: String,
            @Query("api_key") apiKey: String
    ): Observable<SpringerResponse>
}