// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.net.Uri;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l9 extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Uri uri;
        String str2;
        String path;
        if (str == null || (uri = Uri.parse(str)) == null || (str2 = p9.f4861z) == null || str2.isEmpty() || (path = uri.getPath()) == null || !path.startsWith(p9.f4861z)) {
            return;
        }
        p9.f4837a.post(new d2.r(18));
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i3, SafeBrowsingResponse safeBrowsingResponse) {
        safeBrowsingResponse.backToSafety(true);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String scheme = webResourceRequest.getUrl().getScheme();
        if (scheme == null || !(scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("data") || scheme.equalsIgnoreCase("about"))) {
            return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        String path;
        Uri url = webResourceRequest.getUrl();
        if (url != null && "reminder".equalsIgnoreCase(url.getScheme()) && "close".equalsIgnoreCase(url.getHost())) {
            p9.f4837a.post(new d2.r(19));
            return true;
        }
        Uri url2 = webResourceRequest.getUrl();
        if (url2 != null && (str = p9.f4861z) != null && !str.isEmpty() && (path = url2.getPath()) != null && path.startsWith(p9.f4861z)) {
            return false;
        }
        String scheme = webResourceRequest.getUrl().getScheme();
        return scheme == null || !(scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("data") || scheme.equalsIgnoreCase("about"));
    }
}
