package ke.co.slick.researchapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ui.searchresults.SearchResultsActivity
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_QUERY = "ke.co.slick.researchapp.QUERY"

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendQuery(view: View) {
        val query = editText.text.toString()
        val intent = Intent(this, SearchResultsActivity::class.java).apply {
            putExtra(EXTRA_QUERY, query)
        }

        startActivity(intent)
    }
}
