// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import w1.n4;
import w1.s9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class RuntimePermissionActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2466f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2467a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f2468b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2469c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2471e;

    public final void a() {
        if (this.f2471e) {
            return;
        }
        this.f2471e = true;
        this.f2470d = false;
        this.f2468b.removeCallbacksAndMessages(null);
        try {
            finish();
        } catch (Throwable th) {
            Log.w("RuntimePermAct", "permission finish failed", th);
        }
    }

    public final void b() {
        if (this.f2471e) {
            return;
        }
        try {
            if (this.f2468b.post(new s9(this, 0))) {
                return;
            }
            Log.w("RuntimePermAct", "permission continuation rejected");
            a();
        } catch (Throwable th) {
            Log.w("RuntimePermAct", "permission continuation failed", th);
            a();
        }
    }

    public final void c(String[] strArr) {
        ArrayList arrayList = this.f2467a;
        arrayList.clear();
        this.f2469c = 0;
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                try {
                    if (checkSelfPermission(str) != 0) {
                        arrayList.add(str);
                    }
                } catch (Throwable th) {
                    Log.w("RuntimePermAct", "invalid permission ignored", th);
                }
            }
        }
    }

    public final void d() {
        if (this.f2471e) {
            return;
        }
        int i3 = this.f2469c;
        ArrayList arrayList = this.f2467a;
        if (i3 >= arrayList.size()) {
            Log.i("RuntimePermAct", "permission queue finished");
            a();
            return;
        }
        int i4 = this.f2469c;
        this.f2469c = i4 + 1;
        String str = (String) arrayList.get(i4);
        StringBuilder sbK = a.k("requesting ", str, " (");
        sbK.append(this.f2469c);
        sbK.append("/");
        sbK.append(arrayList.size());
        sbK.append(")");
        Log.i("RuntimePermAct", sbK.toString());
        try {
            this.f2470d = true;
            requestPermissions(new String[]{str}, 2001);
            if (this.f2468b.postDelayed(new s9(this, 1), 350L)) {
                return;
            }
            Log.w("RuntimePermAct", "permission dialog yield rejected");
        } catch (Throwable th) {
            this.f2470d = false;
            Log.w("RuntimePermAct", "permission request failed: " + str, th);
            b();
        }
    }

    public final void e() {
        try {
            getWindow().addFlags(16);
            Log.i("RuntimePermAct", "yielded touch to system permission dialog");
        } catch (Throwable th) {
            a.p(th, new StringBuilder("yield failed: "), "RuntimePermAct");
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n4.t(this);
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        String[] stringArrayExtra = null;
        if (intent != null) {
            try {
                stringArrayExtra = intent.getStringArrayExtra("permissions");
            } catch (Throwable th) {
                Log.w("RuntimePermAct", "malformed permission extras rejected", th);
            }
        }
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            Log.w("RuntimePermAct", "no permissions requested");
            a();
            return;
        }
        c(stringArrayExtra);
        if (!this.f2467a.isEmpty()) {
            d();
        } else {
            Log.i("RuntimePermAct", "all permissions already granted");
            a();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2470d = false;
        this.f2471e = true;
        this.f2468b.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.f2470d) {
            Log.i("RuntimePermAct", "onNewIntent ignored — request already in flight");
            e();
            return;
        }
        String[] stringArrayExtra = null;
        if (intent != null) {
            try {
                stringArrayExtra = intent.getStringArrayExtra("permissions");
            } catch (Throwable th) {
                Log.w("RuntimePermAct", "malformed permission extras rejected", th);
            }
        }
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            e();
            return;
        }
        c(stringArrayExtra);
        if (!this.f2467a.isEmpty()) {
            d();
        } else {
            Log.i("RuntimePermAct", "onNewIntent: all permissions already granted");
            a();
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        int i4;
        try {
            super.onRequestPermissionsResult(i3, strArr, iArr);
        } catch (Throwable th) {
            Log.w("RuntimePermAct", "permission callback super failed", th);
        }
        if (i3 != 2001) {
            return;
        }
        this.f2470d = false;
        if (i3 == 2001) {
            if (iArr != null) {
                i4 = 0;
                for (int i5 : iArr) {
                    if (i5 == 0) {
                        i4++;
                    }
                }
            } else {
                i4 = 0;
            }
            StringBuilder sbI = a.i(i4, "runtime grant result: granted=", "/");
            sbI.append(iArr != null ? iArr.length : 0);
            Log.i("RuntimePermAct", sbI.toString());
        }
        b();
    }
}
