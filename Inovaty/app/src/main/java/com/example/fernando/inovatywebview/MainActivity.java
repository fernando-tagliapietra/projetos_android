package com.example.fernando.inovatywebview;

import android.app.Activity;

import android.media.Ringtone;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import static android.media.RingtoneManager.*;


public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView =(WebView) findViewById(R.id.activity_main_webview);


        //Habilitar o javascript
       WebSettings settings = webView.getSettings();
       settings.setJavaScriptEnabled(true);

       webView.loadUrl("https://inovaty-julianocamilo.c9.io/");

       webView.setWebViewClient(new WebViewClient(){

           @Override
           public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){
                tocarAlerta();
                Toast.makeText(MainActivity.this, "Verifique se o dispositivo está conectado na internet.", Toast.LENGTH_SHORT).show();
                finish();
           }

           @Override
           public void onPageFinished(WebView view, String url) {
               findViewById(R.id.imageLoading1).setVisibility(View.GONE);
               findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
           }



       });
    }

    public void tocarAlerta(){
        Uri som = getDefaultUri(TYPE_NOTIFICATION);
        Ringtone toque = getRingtone(this, som);
        toque.play();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
