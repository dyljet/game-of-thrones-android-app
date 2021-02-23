package com.example.gameofquestions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ViewerGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer_guide);
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://www.hbo.com/game-of-thrones");
    }
}
