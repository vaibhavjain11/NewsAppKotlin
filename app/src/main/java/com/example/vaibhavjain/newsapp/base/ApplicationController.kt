package com.example.vaibhavjain.newsapp.base

import android.app.Application
import com.example.vaibhavjain.newsapp.api.AppService
import io.reactivex.disposables.Disposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vaibhavjain on 03/09/17.
 */
class ApplicationController : Application() {

    companion object {

        var appService : AppService?=null

        fun getRetrofit() : AppService {


                if(appService == null) {
                    var logging = HttpLoggingInterceptor();
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    var okHttpClent = OkHttpClient.Builder()
                    okHttpClent.addInterceptor(logging)
                    var retrofit = Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl("https://newsapi.org/v1/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClent.build())
                            .build()

                    appService = retrofit.create(AppService::class.java)
                }
                return appService!!

        }
    }


    override fun onCreate() {
        super.onCreate()

    }
}