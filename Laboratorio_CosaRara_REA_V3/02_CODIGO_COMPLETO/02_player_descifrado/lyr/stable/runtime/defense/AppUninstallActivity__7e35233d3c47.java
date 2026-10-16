// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.defense;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import x1.b;
import x1.w;
import x1.x;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class AppUninstallActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2578c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2579a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2580b;

    public final void a(String str) {
        long j3;
        if (this.f2580b) {
            return;
        }
        this.f2580b = true;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("lyr.stable.runtime.defense.EXTRA_APP_UNINSTALL_TARGET_PACKAGE") : null;
        String stringExtra2 = intent != null ? intent.getStringExtra("lyr.stable.runtime.defense.EXTRA_APP_UNINSTALL_REQUEST_ID") : null;
        if (stringExtra == null || stringExtra.trim().isEmpty()) {
            w wVar = w.f5942k;
            if (wVar != null) {
                wVar.k("error", "", stringExtra2, "missing target package", "app_uninstall_activity");
                return;
            }
            return;
        }
        try {
            getPackageManager().getPackageInfo(stringExtra, 0);
            Log.w("AppUninstallActivity", "Launching app uninstall prompt: package=" + stringExtra + " source=" + str);
            w wVar2 = w.f5942k;
            if (wVar2 != null) {
                wVar2.k("trampoline_foreground", stringExtra, stringExtra2, null, "app_uninstall_activity");
            }
            try {
                try {
                    x xVar = x.f5960m;
                    if (xVar != null) {
                        xVar.a(stringExtra);
                    }
                    Intent intent2 = new Intent("android.intent.action.DELETE");
                    intent2.setData(Uri.parse("package:".concat(stringExtra)));
                    intent2.putExtra("android.intent.extra.RETURN_RESULT", false);
                    intent2.addFlags(268435456);
                    intent2.addFlags(65536);
                    startActivity(intent2);
                    w wVar3 = w.f5942k;
                    if (wVar3 != null) {
                        String str2 = stringExtra2;
                        try {
                            wVar3.k("prompt_opened", stringExtra, str2, null, "app_uninstall_activity");
                        } catch (Exception e3) {
                            e = e3;
                            stringExtra2 = str2;
                            Log.e("AppUninstallActivity", "Failed to launch app uninstall prompt: ".concat(stringExtra), e);
                            String message = e.getMessage();
                            if (message == null) {
                                message = e.getClass().getSimpleName();
                            }
                            String str3 = message;
                            w wVar4 = w.f5942k;
                            if (wVar4 != null) {
                                j3 = 4000;
                                try {
                                    wVar4.k("error", stringExtra, stringExtra2, str3, "app_uninstall_activity");
                                } catch (Throwable th) {
                                    th = th;
                                    this.f2579a.postDelayed(new b(this, 2), j3);
                                    throw th;
                                }
                            } else {
                                j3 = 4000;
                            }
                            this.f2579a.postDelayed(new b(this, 2), j3);
                            return;
                        }
                    }
                    this.f2579a.postDelayed(new b(this, 2), 4000L);
                } catch (Throwable th2) {
                    th = th2;
                    j3 = 4000;
                    this.f2579a.postDelayed(new b(this, 2), j3);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            w wVar5 = w.f5942k;
            if (wVar5 != null) {
                wVar5.k("not_installed", stringExtra, stringExtra2, "package is not installed", "app_uninstall_activity");
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        getWindow().addFlags(2621568);
        getWindow().addFlags(4194304);
        overridePendingTransition(0, 0);
        this.f2579a.postDelayed(new b(this, 1), 350L);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2579a.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f2579a.postDelayed(new b(this, 0), 350L);
    }
}
