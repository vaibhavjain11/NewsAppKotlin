package com.example.vaibhavjain.newsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by vaibhavjain on 03/09/17.
 */
class ArticleData {

    @SerializedName("status")
    @Expose
    var status:String?=null
    @SerializedName("source")
    @Expose
    var source:String?=null
    @SerializedName("articles")
    @Expose
    var articles:List<Article>?=null

    class Article{

        var author:String?=null
        var title:String?=null
        var description:String?=null
        var url:String?=null
        var urlToImage:String?=null

    }

}