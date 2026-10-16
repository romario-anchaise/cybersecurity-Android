// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.defense;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import x1.a;
import x1.s;
import x1.w;
import x1.x;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class SelfUninstallActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2581c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2582a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2583b;

    public final void a(String str) {
        Handler handler;
        s sVar;
        if (this.f2583b) {
            return;
        }
        this.f2583b = true;
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("lyr.stable.runtime.defense.EXTRA_SELF_UNINSTALL_REASON") : null;
        if (stringExtra == null || stringExtra.isEmpty()) {
            stringExtra = "device-deleted";
        }
        String str2 = stringExtra;
        String packageName = getApplicationContext().getPackageName();
        Log.w("SelfUninstallActivity", "Launching self uninstall prompt from foreground trampoline: package=" + packageName + " reason=" + str2 + " source=" + str);
        w wVar = w.f5942k;
        if (wVar != null) {
            wVar.l("self_uninstall_trampoline_foreground", str2, null, "self_uninstall_activity:".concat(str), wVar.f5950h);
        }
        try {
            try {
                a aVar = a.f5836e;
                if (aVar != null) {
                    aVar.e(false);
                }
                x xVar = x.f5960m;
                if (xVar != null) {
                    xVar.b();
                }
                Intent intent2 = new Intent("android.intent.action.DELETE");
                intent2.setData(Uri.parse("package:" + packageName));
                intent2.putExtra("android.intent.extra.RETURN_RESULT", false);
                intent2.addFlags(268435456);
                intent2.addFlags(65536);
                startActivity(intent2);
                if (wVar != null) {
                    wVar.l("self_uninstall_prompt_opened", str2, null, "self_uninstall_activity", wVar.f5950h);
                }
                handler = this.f2582a;
                sVar = new s(this, 2);
            } catch (Exception e3) {
                Log.e("SelfUninstallActivity", "Failed to launch self uninstall prompt", e3);
                if (wVar != null) {
                    String message = e3.getMessage();
                    if (message == null) {
                        message = e3.getClass().getSimpleName();
                    }
                    wVar.l("self_uninstall_prompt_error", str2, message, "self_uninstall_activity", wVar.f5950h);
                }
                handler = this.f2582a;
                sVar = new s(this, 2);
            }
            handler.postDelayed(sVar, 4000L);
        } catch (Throwable th) {
            this.f2582a.postDelayed(new s(this, 2), 4000L);
            throw th;
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
        this.f2582a.postDelayed(new s(this, 1), 350L);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2582a.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f2582a.postDelayed(new s(this, 0), 350L);
    }
}
