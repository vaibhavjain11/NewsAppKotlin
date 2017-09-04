package com.example.vaibhavjain.newsapp.intractor

import android.util.Log
import com.example.vaibhavjain.newsapp.base.ApplicationController
import com.example.vaibhavjain.newsapp.data.ArticleData
import com.example.vaibhavjain.newsapp.presenter.ArticlePresenterInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by vaibhavjain on 03/09/17.
 */
class ArticleInteractor(var presenter:ArticleInteractorInterface) {


    var disposable : Disposable?=null

    fun fetchArticles(name:String){
        var params = HashMap<String,String>()
        params.put("source",name)
        params.put("apiKey", "dcacd019adee49bf927ac235d90639b9")

        var retrofit = ApplicationController.getRetrofit()

        disposable = retrofit.getArticles(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableObserver<ArticleData>(){
                    override fun onComplete() {

                    }

                    override fun onNext(value: ArticleData?) {
                        presenter.getArticles(value!!.articles!!)
                    }

                    override fun onError(e: Throwable?) {
                        presenter.onError()
                        Log.e("NewsApp","Something went wrong")
                    }

                })
                //.subscribe({result -> presenter.getArticles(result.articles!!)})

    }

}