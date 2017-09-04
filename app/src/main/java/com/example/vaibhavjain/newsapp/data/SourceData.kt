package com.example.vaibhavjain.newsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by vaibhavjain on 03/09/17.
 */
class SourceData{

    @SerializedName("status")
    @Expose
    var status : String?=null
    @SerializedName("sources")
    @Expose
    var list : List<Source>?=null
}