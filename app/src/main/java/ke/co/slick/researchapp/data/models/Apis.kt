package ke.co.slick.researchapp.data.models

import com.squareup.moshi.JsonClass

sealed class ApiResponse

@JsonClass(generateAdapter = true)
data class PubagResponse(
        val version: Int,
        val hitCount: Int,
        val request: Request,
        val resultList: List<Result>
) : ApiResponse()

@JsonClass(generateAdapter = true)
data class UsptoResponse(val response: Response) : ApiResponse()