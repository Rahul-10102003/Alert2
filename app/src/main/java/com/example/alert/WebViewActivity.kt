package com.example.alert

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.example.alert.databinding.ActivityWebViewBinding


class WebViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWebViewBinding
//    val callback=object :OnBackPressedCallback(false){
//        override fun handleOnBackPressed() {
//            TODO("Not yet implemented")
//        }
//    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val settings: WebSettings =findViewById<WebView>(R.id.webview).settings
//
//        settings.builtInZoomControls = true
//        settings.loadWithOverviewMode = true
//        settings.useWideViewPort = true
//        settings.setSupportMultipleWindows(true)
//        settings.javaScriptEnabled
//        findViewById<WebView>(R.id.webview).webViewClient= WebViewClient()
//        findViewById<WebView>(R.id.webview).loadUrl("https://www.youtube.com/")
    val webSettings: WebSettings = binding.webview.settings
//    binding.webview.settings.setSupportMultipleWindows(true);
    webSettings.javaScriptEnabled = true

    binding.webview.webViewClient = WebViewClient()
    // this will load the url of the website
    binding.webview.loadUrl("https://www.youtube.com/@browntownmusic")

    // if you want to enable zoom feature
    binding.webview.settings.setSupportZoom(true)

//        val decorView = window.decorView
//        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
//        decorView.systemUiVisibility = uiOptions

//        val webView=WebView(this)
//        webView.webViewClient=WebViewClient()
//        binding.webView.useWideViewPort=true
//        webView.settings.setSupportMultipleWindows(true)
//        webView.settings.loadWithOverviewMode=true
//        webView.settings.javaScriptEnabled = true
//        setContentView(webView)
//        webView.loadUrl("https://www.youtube.com/@sonymusicindiaVEVO")

    onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if(binding.webview.canGoBack()){
            binding.webview.goBack()
            } else {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    })
    }



}

//    override fun onBackPressed() {
//        if(binding.webview.canGoBack()){
//            binding.webview.goBack()
//            }else{
//        super.onBackPressed()
//            }
//    }
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        // Check whether the key event is the Back button and if there's history.
//        if (keyCode == KeyEvent.KEYCODE_BACK && findViewById<WebView>(R.id.webview).canGoBack()) {
//            findViewById<WebView>(R.id.webview).goBack()
//            return true
//        }
//        // If it isn't the Back button or there isn't web page history, bubble up to
//        // the default system behavior. Probably exit the activity.
//        return super.onKeyDown(keyCode, event)
//    }



