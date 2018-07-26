package ke.co.slick.researchapp.data

import ke.co.slick.researchapp.data.apis.UsptoApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(val usptoApi: UsptoApi) {

    fun getSearchResults(query: String) = usptoApi.search(query)
}