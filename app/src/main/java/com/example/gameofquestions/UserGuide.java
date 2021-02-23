package com.example.gameofquestions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class UserGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_guide);
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("file:///android_asset/userGuide.html");



    }
}