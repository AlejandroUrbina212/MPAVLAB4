package com.app.mpav_lab4.mpav_lab4

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewFragment : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_webview, container, false)

        (activity as AppCompatActivity).supportActionBar!!.title = arguments!!.getString("repoTitle")

        val repoUrl = arguments!!.getString("repoUrl")
        val projectWebView = view!!.findViewById<WebView>(R.id.projectWebView)
        projectWebView.loadUrl(repoUrl)

        val webSettings = projectWebView!!.settings
        webSettings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        projectWebView.webViewClient = WebViewClient()

        return view
    }
}