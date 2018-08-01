package ke.co.slick.researchapp.ui.searchresults.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.data.models.Record
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.springer_result.*

class SpringerResultsAdapter(private val dataset: List<Record>) :
        RecyclerView.Adapter<SpringerResultsAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        val titleView = title
        val publicationName = publisher
        val doiView = doi
        val issnView = issn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.springer_result, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]

        holder.titleView.text = item.title
        holder.publicationName.text = item.publicationName

        holder.doiView.text = item.doi
        holder.issnView.text = item.issn
    }
}