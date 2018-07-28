package ke.co.slick.researchapp.data.apis

import io.reactivex.Observable
import ke.co.slick.researchapp.data.models.UsptoResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL = "https://developer.uspto.gov/ibd-api/"

interface UsptoApi {

    @Headers("Accept: application/json")
    @GET("v1/patent/application")
    fun search(
            @Query("searchText") searchText: String,
            @Query("start") start: Int = 0,
            @Query("rows") rows: Int = 10
    ): Observable<UsptoResponse>
}