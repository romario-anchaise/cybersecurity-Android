// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s3 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t3 f5048a;

    public s3(t3 t3Var) {
        this.f5048a = t3Var;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        t3 t3Var = this.f5048a;
        if (t3Var.f5148d) {
            return;
        }
        if (t3.a(str == null ? null : Uri.parse(str))) {
            t3Var.f5147c = true;
            t3Var.b();
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (t3.a(str == null ? null : Uri.parse(str))) {
            return null;
        }
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return webResourceRequest == null || !t3.a(webResourceRequest.getUrl());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return !t3.a(str == null ? null : Uri.parse(str));
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || !t3.a(webResourceRequest.getUrl())) {
            return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }
}
