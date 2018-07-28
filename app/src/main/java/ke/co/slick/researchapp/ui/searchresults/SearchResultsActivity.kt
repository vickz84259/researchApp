package ke.co.slick.researchapp.ui.searchresults

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ResearchApplication
import ke.co.slick.researchapp.data.models.Doc
import ke.co.slick.researchapp.ui.EXTRA_QUERY
import kotlinx.android.synthetic.main.activity_search_results.*
import timber.log.Timber
import javax.inject.Inject

class SearchResultsActivity : AppCompatActivity(), SearchResultsContract.View {

    @Inject
    override lateinit var presenter: SearchResultsContract.Presenter
    private lateinit var query: String

    override fun onCreate(savedInstanceState: Bundle?) {
        val app = application as ResearchApplication
        app.component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        query = intent.getStringExtra(EXTRA_QUERY)
        Timber.d("Param query in onCreate: %s", query)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("query", query)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        query = savedInstanceState.getString("query")

        Timber.d("Param query after restoring state: %s", query)
    }

    override fun onResume() {
        Timber.i("onResume called")

        super.onResume()

        presenter.attach(this)
        presenter.search(query)
    }

    override fun onDestroy() {
        Timber.i("onDestory called")

        super.onDestroy()
        presenter.detach()
    }

    override fun displayResults(results: List<Doc>) {
        Timber.i("SearchResultsActivity displayResults called")
        recyclerView.adapter = SearchResultsAdapter(results)
    }
}
