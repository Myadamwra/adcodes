package com.example.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wb = (WebView) findViewById(R.id.webview);
        wb.setWebViewClient(new WebViewClient());
        wb.loadUrl("https://www.google.com");

        WebSettings webset = wb.getSettings();
        webset.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()){
            wb.goBack();
        }else{super.onBackPressed();}

    }
}