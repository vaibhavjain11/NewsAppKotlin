package com.example.vaibhavjain.newsapp.presenter

import com.example.vaibhavjain.newsapp.data.ArticleData
import com.example.vaibhavjain.newsapp.intractor.ArticleInteractor
import com.example.vaibhavjain.newsapp.intractor.ArticleInteractorInterface

/**
 * Created by vaibhavjain on 03/09/17.
 */
class ArticlePresenter(var context:ArticlePresenterInterface,var name:String):ArticleInteractorInterface {
    override fun onError() {
        context.onError()
    }

    var interactor : ArticleInteractor = ArticleInteractor(this)
    override fun getArticles(list: List<ArticleData.Article>) {
        context.showArticles(list)
    }

    fun fetchResults(name:String){
        interactor.fetchArticles(name)
    }

}