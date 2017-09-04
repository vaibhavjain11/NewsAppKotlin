package com.example.vaibhavjain.newsapp.presenter

import android.content.Context
import com.example.vaibhavjain.newsapp.data.Source
import com.example.vaibhavjain.newsapp.intractor.SourceIntractor
import com.example.vaibhavjain.newsapp.intractor.SourceIntractorInterface

/**
 * Created by vaibhavjain on 03/09/17.
 */
class SourcePresenter(var context: SourcePresenterInterface) : SourceIntractorInterface {
    override fun onError() {
        context.onError()
    }

    override fun getSources(sList: List<Source>) {

        if(context is SourcePresenterInterface) {
            context.fetchSourcesList(sList)
        }
    }

    fun fetchRecords() {

        var sourceIntractor = SourceIntractor(this)
        sourceIntractor.fetchSourcesFromApi()
    }


}