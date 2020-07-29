package test.testq.aidl.itv.cn.jstest;

import android.app.Activity;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

public class JavaScriptActivity extends Activity {
    private WebView webView;
    KeyboardView
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_main);
        initWebView();
        webView.loadUrl("https://www.baidu.com");
    }

  private void initWebView(){
      webView = findViewById(R.id.webView_js);
      WebSettings webSettings = webView.getSettings();
      webSettings.setJavaScriptEnabled(true);
      webView.addJavascriptInterface(new JSInterface(this),"ANDROID_CLIENT");

      webView.setWebChromeClient(new WebChromeClient());
      webView.setWebViewClient(new WebViewClient() {

          @Override
          public void onPageFinished(WebView view, String url) {
              view.loadUrl("javascript:window.ANDROID_CLIENT.showSource("
                      + "document.getElementsByTagName('html')[0].innerHTML);");
              super.onPageFinished(view, url);
          }
      });
  }
}
