// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final class k extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f712a;

    public k(MainActivity mainActivity) {
        this.f712a = mainActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        permissionRequest.deny();
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        MainActivity mainActivity = this.f712a;
        if (i2 >= 100) {
            mainActivity.f3606b.setVisibility(8);
        } else {
            mainActivity.f3606b.setVisibility(0);
            mainActivity.f3606b.setProgress(i2);
        }
    }
}
