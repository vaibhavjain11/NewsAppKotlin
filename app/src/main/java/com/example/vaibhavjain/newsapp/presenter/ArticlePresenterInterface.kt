package com.example.vaibhavjain.newsapp.presenter

import com.example.vaibhavjain.newsapp.data.ArticleData

/**
 * Created by vaibhavjain on 03/09/17.
 */
interface ArticlePresenterInterface {

    fun showArticles(list:List<ArticleData.Article>)
    fun onError()
}