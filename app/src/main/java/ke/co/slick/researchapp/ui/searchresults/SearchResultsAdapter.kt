package ke.co.slick.researchapp.ui.searchresults

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.data.models.Doc
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_result.*

class SearchResultsAdapter(private val dataSet: List<Doc>) :
        RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        val documentType = resultDocumentType
        val title = resultTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_result, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]

        holder.documentType.text = item.documentType
        holder.title.text = item.title
    }

    override fun getItemCount() = dataSet.size
}