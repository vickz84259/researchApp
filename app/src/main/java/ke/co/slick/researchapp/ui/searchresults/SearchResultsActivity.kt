package ke.co.slick.researchapp.ui.searchresults

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ResearchApplication
import ke.co.slick.researchapp.data.models.ApiResponse
import ke.co.slick.researchapp.data.models.PubagResponse
import ke.co.slick.researchapp.data.models.UsptoResponse
import ke.co.slick.researchapp.ui.EXTRA_API
import ke.co.slick.researchapp.ui.EXTRA_QUERY
import ke.co.slick.researchapp.ui.searchresults.adapters.PubagResultsAdapter
import ke.co.slick.researchapp.ui.searchresults.adapters.UsptoResultsAdapter
import kotlinx.android.synthetic.main.activity_search_results.*
import javax.inject.Inject

class SearchResultsActivity : AppCompatActivity(), SearchResultsContract.View {

    @Inject
    override lateinit var presenter: SearchResultsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        val app = application as ResearchApplication
        app.component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
    }

    override fun onResume() {
        super.onResume()

        val query = intent.getStringExtra(EXTRA_QUERY)
        val apiString = intent.getStringExtra(EXTRA_API)

        presenter.attach(this)
        presenter.search(query, apiString)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun displayResults(result: ApiResponse) {
        recyclerView.adapter = when (result) {
            is PubagResponse -> PubagResultsAdapter(result.resultList)
            is UsptoResponse -> UsptoResultsAdapter(result.response.docs)
        }
    }
}
