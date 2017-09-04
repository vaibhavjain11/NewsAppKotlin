package com.example.vaibhavjain.newsapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.vaibhavjain.newsapp.R

class ArticleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        var url:String?=""
        var title:String? = ""
        var bundle = intent.extras
        if(bundle!=null){
            url = bundle.getString("url")
            title = bundle.getString("title")
        }

        supportActionBar!!.title = title
        var webView = findViewById<WebView>(R.id.webview)

        webView.webViewClient = WebViewClient()


        webView.loadUrl(url)

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
