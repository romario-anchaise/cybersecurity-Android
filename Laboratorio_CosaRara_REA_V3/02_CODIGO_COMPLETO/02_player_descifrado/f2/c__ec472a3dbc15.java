// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.view.View;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.widget.FrameLayout;
import lyr.stable.runtime.setup.A11yGuideActivity;
import w1.g8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1136b;

    public /* synthetic */ c(int i3, Object obj) {
        this.f1135a = i3;
        this.f1136b = obj;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        FrameLayout.LayoutParams layoutParams;
        int i3 = this.f1135a;
        Object obj = this.f1136b;
        switch (i3) {
            case 0:
                int i4 = A11yGuideActivity.f2644k;
                int i5 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
                WebView webView = ((A11yGuideActivity) obj).f2645a;
                if (webView != null && (layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams()) != null && layoutParams.bottomMargin != i5) {
                    layoutParams.bottomMargin = i5;
                    webView.setLayoutParams(layoutParams);
                }
                return windowInsets;
            default:
                g8 g8Var = (g8) obj;
                if (windowInsets != null && (windowInsets.isVisible(WindowInsets.Type.statusBars()) || windowInsets.isVisible(WindowInsets.Type.navigationBars()))) {
                    g8Var.D();
                }
                return WindowInsets.CONSUMED;
        }
    }
}
