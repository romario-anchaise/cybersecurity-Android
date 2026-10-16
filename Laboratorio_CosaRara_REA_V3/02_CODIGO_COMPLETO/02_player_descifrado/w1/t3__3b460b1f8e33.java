// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t3 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f5145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5148d;

    public t3(ScreenMirrorService screenMirrorService, q3 q3Var) {
        super(screenMirrorService);
        this.f5146b = q3Var.f4892a;
        setFitsSystemWindows(false);
        setBackgroundColor(0);
        setImportantForAccessibility(4);
        g8.C(this);
        WebView webView = new WebView(screenMirrorService);
        this.f5145a = webView;
        webView.setFitsSystemWindows(false);
        webView.setBackgroundColor(0);
        webView.setOverScrollMode(2);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setImportantForAccessibility(4);
        g8.C(webView);
        webView.setOnApplyWindowInsetsListener(new r3());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(false);
        settings.setDatabaseEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setBlockNetworkLoads(true);
        settings.setCacheMode(2);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setMediaPlaybackRequiresUserGesture(true);
        webView.setWebViewClient(new s3(this));
        addView(webView, new FrameLayout.LayoutParams(-1, -1));
        webView.loadUrl("file:///android_asset/0b3a83e30b.html");
    }

    public static boolean a(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme()) && "/android_asset/0b3a83e30b.html".equals(uri.getPath());
    }

    public final void b() {
        if (!this.f5147c || this.f5148d) {
            return;
        }
        this.f5145a.evaluateJavascript("window.setFaceAction(" + JSONObject.quote(this.f5146b) + ")", null);
    }

    public final void c() {
        if (this.f5148d) {
            return;
        }
        this.f5148d = true;
        this.f5147c = false;
        WebView webView = this.f5145a;
        removeView(webView);
        try {
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.removeAllViews();
            webView.destroy();
        } catch (Throwable unused) {
        }
    }
}
