package com.example.vaibhavjain.newsapp.intractor

import com.example.vaibhavjain.newsapp.data.ArticleData

/**
 * Created by vaibhavjain on 03/09/17.
 */
interface ArticleInteractorInterface {

    fun getArticles(list:List<ArticleData.Article>)
    fun onError()
}