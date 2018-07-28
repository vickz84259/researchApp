package ke.co.slick.researchapp.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun isCacheAvailable(query: String) = sharedPreferences.contains(query)

    fun getCache(query: String) = sharedPreferences.getString(query, "")

    fun storeCache(query: String, value: String) {
        sharedPreferences.edit().putString(query, value).apply()
    }

    fun clearCache(query: String?) {
        val editor = sharedPreferences.edit()

        if (query is String) editor.remove(query).apply() else editor.clear().apply()
    }
}