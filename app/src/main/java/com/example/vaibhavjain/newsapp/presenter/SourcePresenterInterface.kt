package com.example.vaibhavjain.newsapp.presenter

import com.example.vaibhavjain.newsapp.data.Source

/**
 * Created by vaibhavjain on 03/09/17.
 */
interface SourcePresenterInterface {

    fun fetchSourcesList(sourceList : List<Source>)
    fun onError()
}