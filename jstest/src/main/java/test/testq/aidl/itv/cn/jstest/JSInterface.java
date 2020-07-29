package test.testq.aidl.itv.cn.jstest;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JSInterface {
    private final String TAG = JSInterface.class.getSimpleName();

    private Context context;

    public JSInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void showSource(String html) {
        //TODO 打印HTML
        Log.d(TAG, html);
    }

    @JavascriptInterface
    public void showDescription(String str) {
        //TODO 描述
        Log.d(TAG, str);
    }
}
