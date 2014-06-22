package com.chezih.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;



public class MainActivity extends Activity {

    Button ynetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ynetButton = (Button) findViewById(R.id.buttonWebView);

      ynetButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              WebView myWebView = (WebView) findViewById(R.id.webview);
              WebSettings webSettings = myWebView.getSettings();
              webSettings.setJavaScriptEnabled(true);
              myWebView.loadUrl("http://www.ynet.co.il");
              myWebView.setWebViewClient(new WebViewClient(){

                  @Override
                  public boolean shouldOverrideUrlLoading(WebView view, String url){
                      view.loadUrl(url);
                      return true;
                  }
              });

          }
      });
    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (Uri.parse(url).getHost().equals("http://www.ynet.co.il")) {
//                // This is my web site, so do not override; let my WebView load the page
//                return false;
//            }
//            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
//        }
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


