package ke.co.slick.researchapp.util

import android.content.Context
import ke.co.slick.researchapp.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Utility @Inject constructor(private val context: Context) {

    val pubagApiKey = context.getString(R.string.pubag_api_key)

    val usptoString = context.getString(R.string.uspto_api)
    val pubagString = context.getString(R.string.pubag_api)
}