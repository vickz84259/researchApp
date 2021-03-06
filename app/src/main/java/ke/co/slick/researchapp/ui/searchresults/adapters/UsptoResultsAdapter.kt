package ke.co.slick.researchapp.ui.searchresults.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ke.co.slick.researchapp.R
import ke.co.slick.researchapp.data.models.Doc
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.uspto_result.*

class UsptoResultsAdapter(private val dataSet: List<Doc>) :
        RecyclerView.Adapter<UsptoResultsAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View?) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        val documentType = resultDocumentType
        val title = resultTitle
        val applicationNumber = resultAppNo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.uspto_result, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]

        holder.documentType.text = item.documentType
        holder.title.text = item.title
        holder.applicationNumber.text = item.applicationNumber
    }

    override fun getItemCount() = dataSet.size
}