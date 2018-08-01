package ke.co.slick.researchapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpringerResult(
        val total: String,
        val start: String,
        val pageLength: String
)

@JsonClass(generateAdapter = true)
data class Record(
        val identifier: String,
        val title: String,
        val publicationName: String,
        val issn: String,
        val isbn: String,
        val doi: String,
        val publisher: String,
        val publicationDate: String,
        val volume: String,
        val number: String,
        val startingPage: String,
        val endingPage: String,
        val url: String,
        val copyright: String
)