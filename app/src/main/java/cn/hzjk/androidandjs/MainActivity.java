package cn.hzjk.androidandjs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.wv);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl("http://192.168.1.38/hzjrH5/jiaohu.html");
        //js访问android，定义接口
        webView.addJavascriptInterface(this, "control");
    }

    @JavascriptInterface
    public void toastMessage(String s){
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        finish();
    }
}
