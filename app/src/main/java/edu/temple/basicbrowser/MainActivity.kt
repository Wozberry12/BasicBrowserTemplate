package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = WebViewClient()
        //Step 1
        webView.settings.javaScriptEnabled = true
        ////Step 2 & step 3
        var newString =""


        if(!(urlEditText.toString().contains("https://")) || !(urlEditText.toString().contains("http://"))){

            newString = "https//:" + urlEditText.toString()

            webView.loadUrl(newString)
        }
        else{
            webView.loadUrl(urlEditText.toString())
        }
        //Step 4-Step Title - object: {}
        webView.webViewClient = object: WebViewClient()
        {
            override fun onPageFinished(view:WebView?,url:String?){
                super.onPageFinished(view, url)

            }
        }

    }
}