package com.example.vaibhavjain.newsapp.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.example.vaibhavjain.newsapp.R
import com.example.vaibhavjain.newsapp.adapter.ArticleAdapter
import com.example.vaibhavjain.newsapp.data.ArticleData
import com.example.vaibhavjain.newsapp.presenter.ArticlePresenter
import com.example.vaibhavjain.newsapp.presenter.ArticlePresenterInterface
import com.example.vaibhavjain.newsapp.utils.Utility
import kotlinx.android.synthetic.main.activity_main.*

class ArticleActivity : AppCompatActivity(), ArticlePresenterInterface {

    var source:String? = ""
    var name:String? = ""

    override fun onError() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
    }

    var listView : RecyclerView?= null
    var adapter : ArticleAdapter?=null
    var etSearch: TextView?=null
    override fun showArticles(list: List<ArticleData.Article>) {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        adapter = ArticleAdapter(this,list)
        listView!!.adapter = adapter

        etSearch!!.visibility = View.VISIBLE
        etSearch!!.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                adapter!!.getFilter().filter(p0)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var bundle = intent.extras

        if(bundle!=null) {
             source = bundle.getString("source")
             name = bundle.getString("name")
        }

        supportActionBar!!.title = name
        listView = findViewById<RecyclerView>(R.id.articleList)
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        listView!!.layoutManager = layoutManager

        etSearch = findViewById<EditText>(R.id.editText)
        etSearch!!.visibility = View.GONE
        if(Utility.checkInternetConnection(this)) {
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
            var articlePresenter = ArticlePresenter(this, source!!)
            articlePresenter.fetchResults(source!!)

        }
        else{
            Snackbar.make(listView!!,"Please check internet connection", Snackbar.LENGTH_LONG).show()
        }



    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
            if(item!!.itemId == android.R.id.home){
                finish()
            }
        return super.onOptionsItemSelected(item)
    }

}
