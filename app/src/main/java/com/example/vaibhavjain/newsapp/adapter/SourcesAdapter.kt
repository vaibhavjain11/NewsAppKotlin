package com.example.vaibhavjain.newsapp

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import com.example.vaibhavjain.newsapp.activity.ArticleActivity
import com.example.vaibhavjain.newsapp.data.Source

/**
 * Created by vaibhavjain on 03/09/17.
 */
class SourcesAdapter(val context: Context, val sourceList: List<Source>) : RecyclerView.Adapter<SourcesAdapter.SourceHolder>() {

    interface onViewClickListener{
        fun onItemClick()
    }

    override fun onBindViewHolder(holder: SourceHolder, position: Int) {
        holder.bindItems(sourceList.get(position))
        holder.itemView.setOnClickListener{
            var intent = Intent(context,ArticleActivity::class.java)
            intent.putExtra("source",sourceList.get(position).id)
            intent.putExtra("name",sourceList.get(position).name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return sourceList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SourceHolder{

        var view = LayoutInflater.from(context).inflate(R.layout.item_source_layout,parent,false)
        view.setOnClickListener{

        }
        return SourceHolder(view)
    }

    class SourceHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(s : Source){
            var sourceTextView = itemView.findViewById<TextView>(R.id.sourceName)
            sourceTextView.setText(s.name)
        }

    }
}