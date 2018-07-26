package ke.co.slick.researchapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ResearchApplication
import javax.inject.Inject

class SearchResultsActivity : AppCompatActivity(), SearchResultsContract.View {

    @Inject
    override lateinit var presenter: SearchResultsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        val app = application as ResearchApplication
        app.component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
    }
}
