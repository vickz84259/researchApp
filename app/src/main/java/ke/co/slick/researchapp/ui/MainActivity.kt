package ke.co.slick.researchapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.ui.searchresults.SearchResultsActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

const val EXTRA_QUERY = "ke.co.slick.researchapp.QUERY"
const val EXTRA_API = "ke.co.slick.researchapp.SELECTED_API"

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var selectedItem: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter.createFromResource(
                this, R.array.apis_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        selectedItem = adapter.getItem(0).toString()
        setTitle()

        apiSpinner.adapter = adapter
        apiSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedItem = parent?.getItemAtPosition(position).toString()
        setTitle()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    fun setTitle() {
        var value = "Search the"
        value = when (selectedItem) {
            "USPTO" -> "$value U.S. Patents and Trademark Office"
            "PubAg" -> "$value U.S. Department of Argiculture"
            else -> "Enter your search query below"
        }

        titleTextView.text = value
    }

    fun sendQuery(view: View) {
        val query = editText.text.toString()
        val intent = Intent(this, SearchResultsActivity::class.java).apply {
            putExtra(EXTRA_QUERY, query)
            putExtra(EXTRA_API, selectedItem)
        }

        startActivity(intent)
        Timber.i("Starting SearchResultsActivity")
    }
}
