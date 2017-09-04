package com.example.vaibhavjain.newsapp.intractor

import com.example.vaibhavjain.newsapp.data.Source

/**
 * Created by vaibhavjain on 03/09/17.
 */
interface SourceIntractorInterface {

    fun getSources(sList: List<Source>)
    fun onError()
}