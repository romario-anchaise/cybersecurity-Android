// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.o2s2m.gae1fc3b2uc0u.R;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final class l extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f713a;

    public l(MainActivity mainActivity) {
        this.f713a = mainActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        String str2 = MainActivity.f3569m0;
        MainActivity mainActivity = this.f713a;
        if (!mainActivity.e()) {
            mainActivity.r();
            return;
        }
        mainActivity.f3634t = true;
        mainActivity.f3606b.setVisibility(8);
        mainActivity.j();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = MainActivity.f3569m0;
        MainActivity mainActivity = this.f713a;
        if (!mainActivity.e()) {
            webView.stopLoading();
            mainActivity.r();
        } else {
            mainActivity.f3606b.setVisibility(0);
            mainActivity.f3606b.setProgress(0);
            mainActivity.i();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame()) {
            MainActivity mainActivity = this.f713a;
            mainActivity.f3629o.setText(mainActivity.getString(R.string.error_message));
            mainActivity.g.setVisibility(8);
            mainActivity.f3612e.setVisibility(0);
            mainActivity.f3604a.setVisibility(4);
            mainActivity.f3606b.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String path;
        Uri url = webResourceRequest.getUrl();
        String str = MainActivity.f3569m0;
        this.f713a.getClass();
        boolean z2 = false;
        if (url != null) {
            String scheme = url.getScheme();
            if ("about".equalsIgnoreCase(scheme) || ("file".equalsIgnoreCase(scheme) && (path = url.getPath()) != null && path.startsWith("/android_asset/"))) {
                z2 = true;
            }
        }
        return !z2;
    }
}
