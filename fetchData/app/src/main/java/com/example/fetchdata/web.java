package com.example.fetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.*;


public class web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.linkedin.com/");
    }
}
