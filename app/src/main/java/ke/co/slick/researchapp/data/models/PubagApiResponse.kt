package ke.co.slick.researchapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PubagResponse(
        val version: Int,
        val hitCount: Int,
        val request: Request,
        val requestList: List<Result>
)

@JsonClass(generateAdapter = true)
data class Request(
        val query: String,
        val page: Int,
        val totalPages: Int,
        val pageSize: Int
)

@JsonClass(generateAdapter = true)
data class Result(
        val id: String,
        @Json(name = "agid") val agId: String,
        val title: String,
        val timestamp: String,
        val author: List<String>,
        @Json(name = "author_primary") val authorPrimary: String,
        val subject: List<String>,
        val source: String,
        val journal: String,
        val abstract: String,
        val date: String,
        @Json(name = "publication_year") val publicationYear: String,
        @Json(name = "publication_year_rev") val publicationYearRev: String,
        val issn: String,
        val type: String,
        val page: String,
        val issue: String,
        val volume: String,
        @Json(name = "startpage") val startPage: String,
        @Json(name = "endpage") val endPage: String,
        val pageoffset: String,
        @Json(name = "doi_url") val doiUrl: String,
        val doi: String,
        @Json(name = "text_availability") val textAvailability: List<String>,
        val language: String
)