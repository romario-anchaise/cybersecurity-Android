// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.t;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class MirrorOnePixelActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f2456b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f2457a = new t(4, this);

    public static void a(Context context) {
        if (context != null) {
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            boolean z2 = powerManager == null || !powerManager.isInteractive();
            boolean z3 = f2456b;
            if (!z2 || z3) {
                return;
            }
            try {
                Intent intent = new Intent(context, (Class<?>) MirrorOnePixelActivity.class);
                intent.addFlags(276889600);
                context.startActivity(intent);
                Log.i("Mirror1px", "1px launched (screen off)");
            } catch (Throwable th) {
                a.q(th, new StringBuilder("1px launch not allowed (BAL): "), "Mirror1px");
            }
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f2456b = true;
        setShowWhenLocked(true);
        setTurnScreenOn(false);
        getWindow().addFlags(524824);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = 1;
        attributes.height = 1;
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        int i3 = Build.VERSION.SDK_INT;
        t tVar = this.f2457a;
        if (i3 >= 34) {
            registerReceiver(tVar, intentFilter, 4);
        } else {
            registerReceiver(tVar, intentFilter);
        }
        Log.d("Mirror1px", "1px onCreate");
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        f2456b = false;
        try {
            unregisterReceiver(this.f2457a);
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }
}
