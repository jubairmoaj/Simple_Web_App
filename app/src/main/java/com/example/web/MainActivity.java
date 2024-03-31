package com.example.web;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false; // Prevents the default behavior of loading the URL in a browser
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setDomStorageEnabled(true); // Enable DOM storage API
        webSettings.setSupportZoom(true); // Enable zoom
        webSettings.setBuiltInZoomControls(true); // Enable built-in zoom controls
        webSettings.setDisplayZoomControls(false); // Hide zoom controls
        webSettings.setUseWideViewPort(true); // Use wide viewport
        webSettings.setLoadWithOverviewMode(true); // Load the WebView with an overview mode
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // Use cache mode
        webSettings.setAllowFileAccess(true); // Allow file access
        // Additional settings can be enabled here based on requirements

        webView.loadUrl("https://seugpt.vercel.app/");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack(); // Go back in webview history
        } else {
            super.onBackPressed();
        }
    }
}
