package ke.co.slick.researchapp.ui.searchresults

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ResearchApplication
import ke.co.slick.researchapp.ui.EXTRA_QUERY
import javax.inject.Inject

class SearchResultsActivity : AppCompatActivity(),
        SearchResultsContract.View {

    @Inject
    override lateinit var presenter: SearchResultsContract.Presenter
    lateinit var query: String

    override fun onCreate(savedInstanceState: Bundle?) {
        val app = application as ResearchApplication
        app.component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        query = intent.getStringExtra(EXTRA_QUERY)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("query", query)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        query = savedInstanceState.getString("query")
    }
}
