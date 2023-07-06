package com.hypetrack.whitelisting

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity


internal class WhitelistingActivity : AppCompatActivity() {

    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.com_hypertrack_whitelisting_activity_main)
        webView = findViewById<WebView>(R.id.webView)

        webView?.webViewClient = WebViewClient()

        if (savedInstanceState == null) {
            webView?.loadUrl("file:///android_asset/content/vivo/funtouch-12/index.html")
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        webView?.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webView?.restoreState(savedInstanceState)
    }
}



