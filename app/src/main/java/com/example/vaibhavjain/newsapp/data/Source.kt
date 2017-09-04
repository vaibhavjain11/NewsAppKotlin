package com.example.vaibhavjain.newsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by vaibhavjain on 03/09/17.
 */

class Source{

    @SerializedName("name")
    @Expose
    var name : String?=null
    var id:String?=null
}