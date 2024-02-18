package br.edu.ifsp.scl.sdm.dummyproducts.adapter

import android.content.Context
import android.widget.ArrayAdapter
import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.edu.ifsp.scl.sdm.dummyproducts.model.Product

class ProductAdapter(
    private val activityContext: Context,
    private val productList: MutableList<Product>,
): ArrayAdapter<Product>(activityContext, R.layout.simple_list_item_1, productList) {
    private data class ProductHolder(val productTitleTv: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val productView = convertView ?: LayoutInflater.from(activityContext).inflate(R.layout.simple_list_item_1, parent, false).apply {
            tag = ProductHolder(findViewById(R.id.text1))
        }

        (productView.tag as ProductHolder).productTitleTv.text = productList[position].title

        return productView
    }
}