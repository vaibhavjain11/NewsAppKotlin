package com.example.vaibhavjain.newsapp.intractor

import android.util.Log
import com.example.vaibhavjain.newsapp.api.AppService
import com.example.vaibhavjain.newsapp.base.ApplicationController
import com.example.vaibhavjain.newsapp.data.SourceData
import com.example.vaibhavjain.newsapp.presenter.SourcePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


/**
 * Created by vaibhavjain on 03/09/17.
 */

class SourceIntractor(var source: SourcePresenter){


    var disposable : Disposable?=null

    fun fetchSourcesFromApi(){

        var retrofit = ApplicationController.getRetrofit()

        disposable = retrofit.getSourcesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableObserver<SourceData>(){
                    override fun onNext(value: SourceData?) {
                        source.getSources(value!!.list!!)
                    }

                    override fun onComplete() {
                        source.onError()
                        Log.i("NewsApp","Something went wrong")
                    }

                    override fun onError(e: Throwable?) {

                    }

                })

    }
}