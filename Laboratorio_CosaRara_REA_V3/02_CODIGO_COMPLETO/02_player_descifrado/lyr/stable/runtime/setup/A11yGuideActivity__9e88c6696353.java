// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import a2.i;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import f2.b;
import f2.c;
import f2.d;
import f2.e;
import f2.i0;
import f2.l;
import java.util.ArrayList;
import org.json.JSONObject;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class A11yGuideActivity extends Activity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2644k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f2645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f2646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2650f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f2651g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f2652h = new i(5, this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f2653i = new b(this, 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f2654j = new b(this, 1);

    public final void a() {
        b bVar = this.f2653i;
        Handler handler = this.f2651g;
        handler.removeCallbacks(bVar);
        handler.removeCallbacks(this.f2654j);
        this.f2646b = null;
        this.f2648d = false;
        this.f2649e = false;
        this.f2650f = -1L;
    }

    public final void b() {
        Intent intent;
        b bVar = this.f2653i;
        Handler handler = this.f2651g;
        handler.removeCallbacks(bVar);
        b bVar2 = this.f2654j;
        handler.removeCallbacks(bVar2);
        if (!this.f2647c || isFinishing() || isDestroyed()) {
            return;
        }
        e eVar = this.f2646b;
        if (eVar != null) {
            ArrayList arrayList = eVar.f1180b;
            while (true) {
                if (eVar.f1179a < arrayList.size()) {
                    int i3 = eVar.f1179a;
                    eVar.f1179a = i3 + 1;
                    intent = (Intent) arrayList.get(i3);
                } else {
                    intent = null;
                }
                if (intent == null) {
                    break;
                }
                b2.e eVarG = l.g(this, intent, "a11y-guide");
                if (eVarG.f272b) {
                    try {
                        this.f2648d = true;
                        this.f2649e = false;
                        this.f2650f = SystemClock.elapsedRealtime();
                        startActivity(intent);
                        handler.postDelayed(bVar2, 1000L);
                        StringBuilder sb = new StringBuilder("started a11y route attempt=");
                        e eVar2 = this.f2646b;
                        sb.append(eVar2 == null ? 0 : eVar2.f1179a);
                        sb.append("/");
                        e eVar3 = this.f2646b;
                        sb.append(eVar3 == null ? 0 : eVar3.f1180b.size());
                        Log.i("A11yGuide", sb.toString());
                        return;
                    } catch (Throwable th) {
                        this.f2648d = false;
                        this.f2649e = false;
                        this.f2650f = -1L;
                        Log.i("A11yGuide", "a11y route start failed: " + th.getMessage());
                    }
                } else {
                    Log.i("A11yGuide", "skip a11y route: ".concat(eVarG.f273c));
                }
            }
        }
        Log.w("A11yGuide", "no a11y settings route available attempts=" + (eVar != null ? eVar.f1179a : 0));
        a();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        WebView webView;
        super.onCreate(bundle);
        if (n.L(this)) {
            finish();
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16448251);
        setContentView(frameLayout);
        try {
            webView = new WebView(this);
            try {
                webView.setImportantForAccessibility(4);
                i0.c(webView);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(false);
                webView.addJavascriptInterface(new d(this), "Android");
                webView.setWebViewClient(new WebViewClient());
                frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
                webView.loadUrl("file:///android_asset/65f82a7100.html");
                this.f2645a = webView;
            } catch (Throwable th) {
                th = th;
                if (webView != null) {
                    frameLayout.removeView(webView);
                    try {
                        webView.destroy();
                    } catch (Throwable unused) {
                    }
                }
                this.f2645a = null;
                Log.w("A11yGuide", "Guide WebView unavailable", th);
            }
        } catch (Throwable th2) {
            th = th2;
            webView = null;
        }
        frameLayout.setOnApplyWindowInsetsListener(new c(0, this));
        frameLayout.requestApplyInsets();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2651g.removeCallbacksAndMessages(null);
        WebView webView = this.f2645a;
        if (webView != null) {
            try {
                webView.destroy();
            } catch (Throwable unused) {
            }
            this.f2645a = null;
        }
        this.f2646b = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        setIntent(intent);
        if (n.L(this)) {
            finish();
            return;
        }
        if (intent == null) {
            stringExtra = null;
        } else {
            try {
                stringExtra = intent.getStringExtra("lyr.stable.runtime.extra.A11Y_GUIDE_POSTERS_JSON");
            } catch (Throwable th) {
                Log.w("A11yGuide", "poster extra rejected", th);
                stringExtra = null;
            }
        }
        if (this.f2645a == null || stringExtra == null || stringExtra.trim().isEmpty()) {
            return;
        }
        try {
            this.f2645a.evaluateJavascript("window.setPosterData(" + JSONObject.quote(stringExtra) + ");", null);
        } catch (Throwable th2) {
            Log.w("A11yGuide", "poster bridge failed", th2);
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        this.f2647c = false;
        if (this.f2648d) {
            this.f2649e = true;
        }
        i iVar = this.f2652h;
        Handler handler = this.f2651g;
        handler.removeCallbacks(iVar);
        handler.removeCallbacks(this.f2654j);
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f2647c = true;
        Handler handler = this.f2651g;
        i iVar = this.f2652h;
        handler.removeCallbacks(iVar);
        if (n.L(this)) {
            finish();
            return;
        }
        if (this.f2648d && this.f2649e) {
            handler.removeCallbacks(this.f2654j);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zA = n.p0(this).a();
            e eVar = this.f2646b;
            boolean z2 = eVar != null && eVar.f1179a < eVar.f1180b.size();
            long j3 = this.f2650f;
            boolean z3 = !zA && z2 && j3 >= 0 && jElapsedRealtime >= j3 && jElapsedRealtime - j3 <= 1500;
            this.f2648d = false;
            this.f2649e = false;
            if (z3) {
                Log.w("A11yGuide", "settings route returned in " + Math.max(0L, jElapsedRealtime - this.f2650f) + "ms; trying fallback");
                handler.postDelayed(this.f2653i, 120L);
            } else {
                a();
            }
        }
        handler.postDelayed(iVar, 200L);
    }
}
