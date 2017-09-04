package com.example.vaibhavjain.newsapp.api

import com.example.vaibhavjain.newsapp.data.ArticleData
import com.example.vaibhavjain.newsapp.data.SourceData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by vaibhavjain on 03/09/17.
 */
interface AppService {

    @GET("sources")
    fun getSourcesList() : Observable<SourceData>

    @GET("articles")
    fun getArticles(@QueryMap map:HashMap<String,String>) : Observable<ArticleData>
}