package com.example.vaibhavjain.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.vaibhavjain.newsapp.R
import com.example.vaibhavjain.newsapp.activity.ArticleDetailActivity
import com.example.vaibhavjain.newsapp.data.ArticleData

/**
 * Created by vaibhavjain on 03/09/17.
 */
class ArticleAdapter(var context: Context,var list:List<ArticleData.Article>): RecyclerView.Adapter<ArticleAdapter.ArticleHolder>(), Filterable{

    var filter : ItemFilter = ItemFilter()
    var filteredList : List<ArticleData.Article> = list

    override fun getFilter(): Filter {
        return filter
    }

    override fun onBindViewHolder(holder: ArticleHolder?, position: Int) {

        holder!!.bindItems(filteredList.get(position))
        holder!!.titleText!!.text = filteredList.get(position).title


        Glide.with(context)
                .load(filteredList.get(position).urlToImage)
                .apply(RequestOptions.centerCropTransform().diskCacheStrategy(DiskCacheStrategy.DATA))
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(holder!!.imageView)

        holder.itemView.setOnClickListener{
            var intent = Intent(context,ArticleDetailActivity::class.java)
            intent.putExtra("url",filteredList.get(position).url)
            intent.putExtra("title",filteredList.get(position).title)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
     return filteredList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArticleHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.item_article,parent,false)
       return ArticleHolder(view)

    }




    inner class ArticleHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var imageView:ImageView?=null
        var titleText: TextView? = null

        fun bindItems(a:ArticleData.Article){
            imageView = itemView.findViewById<ImageView>(R.id.imageView)
            titleText = itemView.findViewById<TextView>(R.id.title)


        }

    }

    inner class ItemFilter : Filter(){

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            var filterSting = constraint.toString().toLowerCase()
            var filterResults = FilterResults()

            var l = list
            var fList = ArrayList<ArticleData.Article>()
            for(item in l){
                if(item.title!!.toString().toLowerCase().contains(filterSting)){
                    fList.add(item)
                }
            }

            filterResults.values = fList
            filterResults.count = fList.size
            return filterResults

        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            filteredList = p1!!.values as List<ArticleData.Article>
            notifyDataSetChanged()
        }

    }

}