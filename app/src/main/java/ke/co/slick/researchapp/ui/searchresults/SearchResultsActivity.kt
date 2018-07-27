package ke.co.slick.researchapp.ui.searchresults

import android.app.Activity
import android.os.Bundle
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ResearchApplication
import ke.co.slick.researchapp.data.models.Doc
import ke.co.slick.researchapp.ui.EXTRA_QUERY
import javax.inject.Inject

class SearchResultsActivity : Activity(),
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

    override fun onResume() {
        super.onResume()

        presenter.attach(this)
        presenter.search(query)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun displayResults(results: List<Doc>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
