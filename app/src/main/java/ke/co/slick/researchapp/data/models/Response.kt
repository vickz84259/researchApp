package ke.co.slick.researchapp.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
        val numFound: Int,
        val start: Int,
        val docs: List<Doc>
)