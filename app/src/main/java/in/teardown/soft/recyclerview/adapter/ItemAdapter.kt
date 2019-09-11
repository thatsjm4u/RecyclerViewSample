package `in`.teardown.soft.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items: ArrayList<String>, var context: Context): RecyclerView.Adapter<Item>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        return Item(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Item, position: Int) {
        holder.textView.text = items.get(position)
    }

}

class Item(var rowView: View): RecyclerView.ViewHolder(rowView) {
    lateinit var textView: TextView
    init {
        textView = rowView.findViewById(android.R.id.text1)
    }
}