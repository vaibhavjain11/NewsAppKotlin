package com.example.vaibhavjain.newsapp


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.Visibility
import android.view.View
import android.widget.ProgressBar
import com.example.vaibhavjain.newsapp.data.Source
import com.example.vaibhavjain.newsapp.presenter.SourcePresenter
import com.example.vaibhavjain.newsapp.presenter.SourcePresenterInterface
import com.example.vaibhavjain.newsapp.utils.Utility

class MainActivity : AppCompatActivity() , SourcePresenterInterface{
    override fun onError() {
        findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
    }


    var recyclerView : RecyclerView? = null;
    var adapter : SourcesAdapter? = null;
    override fun fetchSourcesList(sourceList: List<Source>) {
            findViewById<ProgressBar>(R.id.progress).visibility = View.GONE
            adapter = SourcesAdapter(this,sourceList);
            recyclerView!!.adapter = adapter

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView =  findViewById<RecyclerView>(R.id.recylcerView) as RecyclerView
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView!!.layoutManager = linearLayoutManager

        if(Utility.checkInternetConnection(this)) {
            findViewById<ProgressBar>(R.id.progress).setVisibility(View.VISIBLE)
            var sourcePresenter = SourcePresenter(this)
            sourcePresenter.fetchRecords()
        }
        else{
            Snackbar.make(recyclerView!!,"Please check internet connection",Snackbar.LENGTH_LONG).show()
        }

    }
}
