package ke.co.slick.researchapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(val response: Response)

@JsonClass(generateAdapter = true)
data class Response(
        val numFound: Int,
        val start: Int,
        val docs: List<Doc>
)

@JsonClass(generateAdapter = true)
data class Doc(
        val applicationType: String,
        val documentId: String,
        val applicationNumber: String,
        val documentType: String,
        val patentNumber: String?,
        val publicationDate: String,
        val documentDate: String,
        val productionDate: String,
        val applicationDate: String,
        val applicant: List<String>,
        val inventor: List<String>,
        val assignee: List<String>?,
        val title: String,
        val archiveUrl: String,
        val pdfPath: String,
        val year: String,
        @Json(name = "_version_") val version: Long
)