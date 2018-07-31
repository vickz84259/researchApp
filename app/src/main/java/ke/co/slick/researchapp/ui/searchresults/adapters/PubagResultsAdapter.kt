package ke.co.slick.researchapp.ui.searchresults.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.data.models.Result
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pubag_result.*

class PubagResultsAdapter(private val dataSet: List<Result>) :
        RecyclerView.Adapter<PubagResultsAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        val source = journalSource
        val abstract = abstractText
        val issnText = issn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.pubag_result, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]

        holder.source.text = "${item.journal} ${item.source} ${item.page}"
        holder.abstract.text = item.abstract
        holder.issnText.text = item.issn
    }
}