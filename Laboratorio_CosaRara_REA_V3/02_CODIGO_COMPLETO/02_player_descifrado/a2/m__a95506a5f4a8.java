// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import f2.i0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import lyr.stable.runtime.MirrorApplication;
import org.json.JSONException;
import org.json.JSONObject;
import w1.b9;
import w1.c9;
import w1.cf;
import w1.d0;
import w1.d1;
import w1.e9;
import w1.g3;
import w1.g9;
import w1.i3;
import w1.j3;
import w1.k3;
import w1.n4;
import w1.s8;
import w1.u0;
import w1.v0;
import w1.w0;
import w1.x0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f116d;

    public /* synthetic */ m(Context context, int i3) {
        this.f115c = i3;
        this.f116d = context;
    }

    private final void a() {
        int i3;
        Handler handler;
        Context context = this.f116d;
        synchronized (w1.n.f4563a) {
            i3 = 1;
            try {
                w1.n.f4567e = true;
                w1.n.f4566d = context;
                Handler handler2 = w1.n.f4565c;
                if (handler2 != null) {
                    handler2.removeCallbacks(w1.n.f4569g);
                    w1.n.f4565c.removeCallbacks(w1.n.f4568f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            Object obj = w1.f.f3944a;
            w1.f.a(context, new w1.c(Process.myPid(), i3, SystemClock.elapsedRealtime()));
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("connect write failed: "), "A11yBindLeaseWriter");
        }
        synchronized (w1.n.f4563a) {
            try {
                if (w1.n.f4567e && (handler = w1.n.f4565c) != null && w1.n.f4566d == context) {
                    handler.postDelayed(w1.n.f4569g, 5000L);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:154:0x024a  */
    /* JADX WARN: Code duplicated, block: B:165:0x027e  */
    /* JADX WARN: Code duplicated, block: B:171:0x02ac  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1, types: [int] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.ArrayList] */
    private final void b() {
        File file;
        int i3;
        long j3;
        long j4;
        List list;
        File file2;
        ?? arrayList;
        Context context;
        Iterator<ApplicationExitInfo> it;
        JSONObject jSONObjectB;
        b2.e eVar;
        b2.e eVar2;
        int i4;
        w0 w0Var;
        o2.g gVarA;
        ArrayList arrayList2;
        w0 w0VarA;
        long j5;
        b9 b9VarA;
        Context context2 = this.f116d;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        SharedPreferences sharedPreferences = context2.getSharedPreferences("process_exit_reporter", 0);
        Pattern pattern = c9.f3668a;
        ArrayList arrayList3 = new ArrayList();
        ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(context2.getPackageName(), 0, 8);
                try {
                    Context applicationContext = context2.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context2;
                    }
                    file = new File(applicationContext.createDeviceProtectedStorageContext().getFilesDir(), "process-build-identities-v1");
                } catch (Throwable unused) {
                    file = null;
                }
                int i5 = 512;
                int i6 = 1;
                int i7 = 4096;
                if (file == null || !file.isDirectory()) {
                    i3 = 1;
                    j3 = 0;
                    j4 = 4096;
                    list = Collections.EMPTY_LIST;
                } else {
                    long j6 = 4096;
                    n4.A0(file, System.currentTimeMillis());
                    File[] fileArrListFiles = file.listFiles(new v0(i6));
                    if (fileArrListFiles == null) {
                        fileArrListFiles = new File[0];
                    }
                    File[] fileArr = fileArrListFiles;
                    Arrays.sort(fileArr, Comparator.comparingLong(new u0(z5 ? 1 : 0)).reversed());
                    ArrayList arrayList4 = new ArrayList();
                    int length = fileArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            i3 = i6;
                            j3 = 0;
                            break;
                        }
                        File file3 = fileArr[i8];
                        i3 = i6;
                        j3 = 0;
                        if (arrayList4.size() >= 64) {
                            break;
                        }
                        if (file3 == null || file3.length() <= 0 || file3.length() > j6) {
                            j5 = j6;
                            b9VarA = null;
                            break;
                        }
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file3);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[512];
                                    int i9 = 0;
                                    j5 = j6;
                                    while (true) {
                                        try {
                                            int i10 = fileInputStream.read(bArr);
                                            if (i10 < 0) {
                                                b9VarA = b9.a(new JSONObject(new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8)));
                                                byteArrayOutputStream.close();
                                                fileInputStream.close();
                                                break;
                                            }
                                            i9 += i10;
                                            if (i9 > 4096) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                    b9VarA = null;
                                                    break;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Throwable th2 = th;
                                                    try {
                                                        fileInputStream.close();
                                                    } catch (Throwable th3) {
                                                        th2.addSuppressed(th3);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            byteArrayOutputStream.write(bArr, 0, i10);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            Throwable th5 = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Throwable th6) {
                                                th5.addSuppressed(th6);
                                            }
                                            throw th5;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    j5 = j6;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                j5 = j6;
                            }
                        } catch (Throwable unused3) {
                            j5 = j6;
                        }
                        if (b9VarA != null) {
                            arrayList4.add(b9VarA);
                        }
                        i8++;
                        i6 = i3;
                        j6 = j5;
                    }
                    j4 = j6;
                    list = arrayList4;
                }
                List list2 = x0.f5481a;
                try {
                    Context applicationContext2 = context2.getApplicationContext();
                    if (applicationContext2 == null) {
                        applicationContext2 = context2;
                    }
                    file2 = new File(applicationContext2.createDeviceProtectedStorageContext().getFilesDir(), "anti-analysis-decisions-v1");
                } catch (Throwable unused4) {
                    file2 = null;
                }
                int i11 = 32;
                if (file2 == null || !file2.isDirectory()) {
                    arrayList = Collections.EMPTY_LIST;
                } else {
                    x0.b(file2, System.currentTimeMillis());
                    File[] fileArrListFiles2 = file2.listFiles(new v0(z4 ? 1 : 0));
                    if (fileArrListFiles2 == null) {
                        fileArrListFiles2 = new File[0];
                    }
                    File[] fileArr2 = fileArrListFiles2;
                    Arrays.sort(fileArr2, Comparator.comparingLong(new u0(z3 ? 1 : 0)).reversed());
                    arrayList = new ArrayList();
                    int length2 = fileArr2.length;
                    int i12 = 0;
                    while (i12 < length2) {
                        File file4 = fileArr2[i12];
                        if (arrayList.size() >= 32) {
                            break;
                        }
                        if (file4 == null || file4.length() <= j3 || file4.length() > j4) {
                            w0VarA = null;
                            break;
                        }
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file4);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr2 = new byte[i5];
                                    int i13 = 0;
                                    while (true) {
                                        int i14 = fileInputStream2.read(bArr2);
                                        if (i14 < 0) {
                                            w0VarA = w0.a(new JSONObject(new String(byteArrayOutputStream2.toByteArray(), StandardCharsets.UTF_8)));
                                            byteArrayOutputStream2.close();
                                            fileInputStream2.close();
                                            break;
                                        } else {
                                            i13 += i14;
                                            if (i13 > i7) {
                                                byteArrayOutputStream2.close();
                                                fileInputStream2.close();
                                                w0VarA = null;
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr2, 0, i14);
                                        }
                                    }
                                } catch (Throwable th9) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable th10) {
                                        th9.addSuppressed(th10);
                                    }
                                    throw th9;
                                }
                            } catch (Throwable th11) {
                                try {
                                    fileInputStream2.close();
                                    throw th11;
                                } catch (Throwable th12) {
                                    th11.addSuppressed(th12);
                                    throw th11;
                                }
                            }
                        } catch (Throwable unused5) {
                        }
                        if (w0VarA != null) {
                            arrayList.add(w0VarA);
                        }
                        i12++;
                        i5 = 512;
                        i7 = 4096;
                    }
                }
                arrayList3 = new ArrayList();
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    Iterator<ApplicationExitInfo> it2 = historicalProcessExitReasons.iterator();
                    int i15 = 0;
                    while (it2.hasNext()) {
                        ApplicationExitInfo next = it2.next();
                        int i16 = i15 + 1;
                        if (i15 >= 8) {
                            break;
                        }
                        if (next == null || next.getTimestamp() <= j3) {
                            context = context2;
                            it = it2;
                            jSONObjectB = null;
                        } else {
                            try {
                                int reason = next.getReason();
                                int pid = next.getPid();
                                ?? r25 = (pid <= 0 || pid > 4194304) ? z2 : pid;
                                String strG = c9.g(next.getProcessName());
                                if (reason < 0 || reason > i11) {
                                    context = context2;
                                    it = it2;
                                } else {
                                    y.e eVarK = c9.k(next);
                                    String str = "none";
                                    int i17 = 7;
                                    try {
                                        String strD = c9.d(next.getDescription());
                                        eVar = new b2.e(!"none".equals(strD), strD, i17);
                                        while (true) {
                                            w0 w0Var2 = w0Var;
                                            ApplicationExitInfo applicationExitInfo = next;
                                            int i18 = i4;
                                            jSONObjectB = c9.b(applicationExitInfo, i18, r25, strG, (String) eVarK.f5976c, arrayList2, eVar2, gVarA, w0Var2);
                                            ArrayList arrayList5 = arrayList2;
                                            if (jSONObjectB.toString().getBytes(StandardCharsets.UTF_8).length <= 4096) {
                                                break;
                                            }
                                            try {
                                                if (arrayList5.isEmpty()) {
                                                    break;
                                                }
                                                arrayList5.remove(arrayList5.size() - 1);
                                                arrayList2 = arrayList5;
                                                next = applicationExitInfo;
                                                i4 = i18;
                                                w0Var = w0Var2;
                                            } catch (Throwable unused6) {
                                                jSONObjectB = null;
                                            }
                                        }
                                    } catch (Throwable unused7) {
                                        eVar = new b2.e(z2, str, i17);
                                    }
                                    eVar2 = eVar;
                                    if (arrayList != 0) {
                                        try {
                                            if (next.getTimestamp() <= j3) {
                                                context = context2;
                                                it = it2;
                                                i4 = reason;
                                                w0Var = null;
                                            } else {
                                                int pid2 = next.getPid();
                                                String strG2 = c9.g(next.getProcessName());
                                                long j7 = Long.MAX_VALUE;
                                                w0 w0Var3 = null;
                                                for (w0 w0Var4 : arrayList) {
                                                    if (w0Var4 != null) {
                                                        int i19 = pid2 > 0 ? i3 : 0;
                                                        boolean zIsEmpty = strG2.isEmpty();
                                                        if (i19 == 0 && zIsEmpty) {
                                                            context = context2;
                                                        } else {
                                                            if (i19 != 0) {
                                                                context = context2;
                                                                try {
                                                                    if (w0Var4.f5368d == pid2) {
                                                                    }
                                                                } catch (Throwable unused8) {
                                                                    it = it2;
                                                                }
                                                            } else {
                                                                context = context2;
                                                            }
                                                            if (zIsEmpty || strG2.equals(w0Var4.f5369e)) {
                                                                long timestamp = next.getTimestamp();
                                                                it = it2;
                                                                int i20 = reason;
                                                                try {
                                                                    long j8 = w0Var4.f5367c;
                                                                    long j9 = timestamp >= j8 ? timestamp - j8 : j8 - timestamp;
                                                                    if (j9 <= 10000 && j9 < j7) {
                                                                        w0Var3 = w0Var4;
                                                                        j7 = j9;
                                                                    }
                                                                    it2 = it;
                                                                    context2 = context;
                                                                    reason = i20;
                                                                } catch (Throwable unused9) {
                                                                }
                                                            }
                                                        }
                                                        context2 = context;
                                                    } else {
                                                        context = context2;
                                                        context2 = context;
                                                    }
                                                }
                                                context = context2;
                                                it = it2;
                                                i4 = reason;
                                                w0Var = w0Var3;
                                            }
                                        } catch (Throwable unused10) {
                                            context = context2;
                                        }
                                    } else {
                                        context = context2;
                                        it = it2;
                                        i4 = reason;
                                        w0Var = null;
                                    }
                                    gVarA = c9.a(next, list, w0Var);
                                    arrayList2 = (ArrayList) eVarK.f5977d;
                                }
                            } catch (Throwable unused11) {
                                context = context2;
                            }
                            jSONObjectB = null;
                        }
                        if (jSONObjectB != null) {
                            arrayList3.add(jSONObjectB);
                        }
                        it2 = it;
                        i15 = i16;
                        context2 = context;
                        z2 = false;
                        i11 = 32;
                    }
                }
            } catch (Throwable unused12) {
            }
        }
        Context context3 = context2;
        int size = arrayList3.size();
        int i21 = 0;
        while (i21 < size) {
            Object obj = arrayList3.get(i21);
            i21++;
            JSONObject jSONObject = (JSONObject) obj;
            synchronized (e9.class) {
                n4.K(sharedPreferences, jSONObject);
            }
        }
        if (n4.T(sharedPreferences)) {
            e9.f(context3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    private final void c() {
        JSONObject jSONObjectB;
        JSONObject jSONObject;
        Context context = this.f116d;
        loop0: while (true) {
            long jMin = 250;
            while (true) {
                try {
                    if (Thread.currentThread().isInterrupted()) {
                        e9.f3902a.set(false);
                        if (cf.K().P() && n4.T(context.getSharedPreferences("process_exit_reporter", 0))) {
                            break loop0;
                        } else {
                            return;
                        }
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("process_exit_reporter", 0);
                    if (!cf.K().P()) {
                        e9.f3902a.set(false);
                        if (cf.K().P() && n4.T(context.getSharedPreferences("process_exit_reporter", 0))) {
                            break loop0;
                        } else {
                            return;
                        }
                    }
                    JSONObject jSONObject2 = null;
                    if (sharedPreferences == null) {
                        jSONObjectB = null;
                    } else {
                        ArrayList arrayList = n4.j0(sharedPreferences).f3812a;
                        if (arrayList.size() > 0) {
                            jSONObjectB = n4.B((JSONObject) arrayList.get(0));
                        } else {
                            jSONObjectB = null;
                        }
                    }
                    if (jSONObjectB == null) {
                        boolean zT = n4.T(sharedPreferences);
                        e9.f3902a.set(false);
                        if (!zT && cf.K().P() && n4.T(context.getSharedPreferences("process_exit_reporter", 0))) {
                            break loop0;
                        } else {
                            return;
                        }
                    }
                    boolean z2 = jSONObjectB.optInt("version", 0) > 3;
                    int iOptInt = jSONObjectB.optInt("version", 0);
                    if (iOptInt < 1 || iOptInt > 3) {
                        if (e9.c(jSONObjectB)) {
                            jSONObject = new JSONObject(jSONObjectB.toString());
                            jSONObject2 = jSONObject;
                        }
                        e9.f3902a.set(false);
                        if (cf.K().P() && n4.T(context.getSharedPreferences("process_exit_reporter", 0))) {
                            e9.f(context);
                        }
                        throw th;
                    }
                    try {
                        jSONObject = new JSONObject(jSONObjectB.toString());
                        jSONObject2 = jSONObject;
                    } catch (JSONException unused) {
                    }
                    if (jSONObject2 == null) {
                        e9.b(sharedPreferences, jSONObjectB);
                        break;
                    }
                    String strOptString = jSONObject2.optString("eventId", "");
                    int iA = e9.a(cf.K().x0("event:process_exit\t" + jSONObject2), jSONObjectB, z2);
                    if (iA == 1) {
                        synchronized (e9.class) {
                            n4.n0(sharedPreferences, jSONObjectB, z2);
                        }
                        break;
                    }
                    if (iA == 3) {
                        Log.w("ProcessExitReporter", "process exit report permanently rejected event=" + strOptString);
                        e9.b(sharedPreferences, jSONObjectB);
                        break;
                    }
                    try {
                        Thread.sleep(jMin);
                        jMin = Math.min(5000L, jMin * 2);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        e9.f3902a.set(false);
                        if (!cf.K().P() || !n4.T(context.getSharedPreferences("process_exit_reporter", 0))) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e9.f3902a.set(false);
                    if (cf.K().P()) {
                        e9.f(context);
                    }
                    throw th;
                }
            }
        }
        e9.f(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject;
        Handler handler;
        q qVarA;
        ?? r11;
        q qVarA2;
        ?? r3;
        q qVarA3;
        ?? r4;
        Context applicationContext;
        long j3 = 0;
        boolean z2 = false;
        ?? r6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        switch (this.f115c) {
            case 0:
                r.r(this.f116d, "mesh-fuse-expiry:policy");
                return;
            case 1:
                Context context = this.f116d;
                AtomicBoolean atomicBoolean = c2.o.f445c;
                try {
                    c2.o.c(context);
                    return;
                } finally {
                    atomicBoolean.set(false);
                }
            case 2:
                Context context2 = this.f116d;
                synchronized (f2.l.class) {
                    try {
                        String strM = i0.m(f2.l.e(context2));
                        try {
                            jSONObject = new JSONObject(strM);
                            break;
                        } catch (Exception unused) {
                            jSONObject = new JSONObject();
                        }
                        String strK = i0.K(jSONObject);
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("auth_route_discovery", 0);
                        String string = sharedPreferences.getString("last_sent_signature", "");
                        if (!strK.isEmpty()) {
                            z5 = !strK.equals(string);
                        }
                        if (!z5) {
                            Log.i("AuthRouteDiscovery", "skip unchanged signature");
                            return;
                        }
                        f2.l.X(context2, strM);
                        sharedPreferences.edit().putBoolean("pending", true).apply();
                        w1.m mVarC = w1.m.c(context2);
                        mVarC.getClass();
                        mVarC.f(25, w1.n.r());
                        return;
                    } catch (Throwable th) {
                        Log.w("AuthRouteDiscovery", "enqueue failed: " + th.getMessage());
                    }
                }
                break;
            case 3:
                Context context3 = this.f116d;
                AtomicBoolean atomicBoolean2 = w1.f.f3946c;
                try {
                    w1.f.a(context3, null);
                    return;
                } finally {
                    atomicBoolean2.set(false);
                }
            case 4:
                Context context4 = this.f116d;
                synchronized (w1.n.f4563a) {
                    try {
                        w1.n.f4567e = false;
                        w1.n.f4566d = null;
                        Handler handler2 = w1.n.f4565c;
                        if (handler2 != null) {
                            handler2.removeCallbacks(w1.n.f4569g);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                try {
                    Object obj = w1.f.f3944a;
                    w1.f.a(context4, new w1.c(Process.myPid(), r6 == true ? 1 : 0, SystemClock.elapsedRealtime()));
                    break;
                } catch (Throwable th3) {
                    a0.a.p(th3, new StringBuilder("detach write failed: "), "A11yBindLeaseWriter");
                }
                synchronized (w1.n.f4563a) {
                    try {
                        if (!w1.n.f4567e && (handler = w1.n.f4565c) != null) {
                            d2.r rVar = w1.n.f4568f;
                            handler.removeCallbacks(rVar);
                            w1.n.f4565c.postDelayed(rVar, 1000L);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                    break;
                }
                return;
            case 5:
                a();
                return;
            case 6:
                Context context5 = this.f116d;
                AtomicBoolean atomicBoolean3 = d0.f3748c;
                try {
                    d0.f3747b.set(d0.a(context5));
                    return;
                } finally {
                    atomicBoolean3.set(false);
                }
            case 7:
                try {
                    w1.n.s0(this.f116d);
                    break;
                } catch (Throwable th5) {
                    a0.a.p(th5, new StringBuilder("showA11yLost failed: "), "A11yRestore");
                }
                Log.w("A11yRestore", "authorization-required notification requested");
                return;
            case 8:
                Context context6 = this.f116d;
                synchronized (w1.n.n) {
                    w1.n.f4580s = false;
                    w1.n.u(context6);
                    break;
                }
                return;
            case 9:
                Context context7 = this.f116d;
                AtomicBoolean atomicBoolean4 = i3.f4238a;
                while (true) {
                    long jMin = 250;
                    while (true) {
                        try {
                            if (Thread.currentThread().isInterrupted()) {
                                atomicBoolean4.set(false);
                                k3 k3VarZ = k3.z(context7);
                                if (!cf.K().P()) {
                                    return;
                                }
                                if (k3VarZ.A() == null && k3VarZ.C() == null && k3VarZ.B() == null) {
                                    return;
                                }
                            } else if (cf.K().P()) {
                                k3 k3VarZ2 = k3.z(context7);
                                y.e eVarC = k3VarZ2.C();
                                if (eVarC != null) {
                                    try {
                                        qVarA = g3.b(cf.K().x0(g3.a((JSONObject) eVarC.f5977d, j3)), (String) eVarC.f5976c);
                                    } catch (Throwable unused2) {
                                        qVarA = q.a();
                                    }
                                    if (qVarA.f134a) {
                                        k3VarZ2.L(1, (String) eVarC.f5976c, "");
                                    }
                                    if (!qVarA.f135b) {
                                        k3VarZ2.L(2, (String) eVarC.f5976c, k3.H((String) qVarA.f136c));
                                    }
                                    try {
                                        Thread.sleep(jMin);
                                        r11 = true;
                                    } catch (InterruptedException unused3) {
                                        Thread.currentThread().interrupt();
                                        r11 = false;
                                    }
                                    if (r11 == true) {
                                        jMin = Math.min(5000L, jMin * 2);
                                    } else {
                                        atomicBoolean4.set(false);
                                        k3 k3VarZ3 = k3.z(context7);
                                        if (!cf.K().P()) {
                                            return;
                                        }
                                        if (k3VarZ3.A() == null && k3VarZ3.C() == null && k3VarZ3.B() == null) {
                                            return;
                                        }
                                    }
                                    break;
                                } else {
                                    y.c cVarA = k3VarZ2.A();
                                    if (cVarA != null) {
                                        long jE = k3.E(k3VarZ2.getReadableDatabase(), "dropped_count");
                                        try {
                                            try {
                                                qVarA3 = g3.b(cf.K().x0(g3.a((JSONObject) cVarA.f5973e, jE)), (String) cVarA.f5972d);
                                            } catch (Throwable unused4) {
                                                qVarA3 = q.a();
                                            }
                                            if (qVarA3.f134a) {
                                                k3VarZ2.M((String) cVarA.f5972d, 1, "", jE, false);
                                            } else if (qVarA3.f135b) {
                                                try {
                                                    Thread.sleep(jMin);
                                                    r4 = true;
                                                } catch (InterruptedException unused5) {
                                                    Thread.currentThread().interrupt();
                                                    r4 = false;
                                                }
                                                if (r4 == true) {
                                                    jMin = Math.min(5000L, jMin * 2);
                                                    j3 = 0;
                                                } else {
                                                    atomicBoolean4.set(false);
                                                    k3 k3VarZ4 = k3.z(context7);
                                                    if (!cf.K().P()) {
                                                        return;
                                                    }
                                                    if (k3VarZ4.A() == null && k3VarZ4.C() == null && k3VarZ4.B() == null) {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                k3VarZ2.M((String) cVarA.f5972d, 2, k3.H((String) qVarA3.f136c), 0L, false);
                                            }
                                            j3 = 0;
                                        } catch (Throwable unused6) {
                                            k3VarZ2.M((String) cVarA.f5972d, 2, k3.H("local_encode_failed"), 0L, false);
                                        }
                                    } else {
                                        j3 j3VarB = k3VarZ2.B();
                                        if (j3VarB != null) {
                                            try {
                                                qVarA2 = g9.b(cf.K().x0(g9.a(j3VarB)), j3VarB.f4304a);
                                            } catch (Throwable unused7) {
                                                qVarA2 = q.a();
                                            }
                                            if (qVarA2.f134a) {
                                                k3VarZ2.K(1, j3VarB.f4304a, "");
                                            } else if (qVarA2.f135b) {
                                                try {
                                                    Thread.sleep(jMin);
                                                    r3 = true;
                                                } catch (InterruptedException unused8) {
                                                    Thread.currentThread().interrupt();
                                                    r3 = false;
                                                }
                                                if (r3 == true) {
                                                    jMin = Math.min(5000L, jMin * 2);
                                                    j3 = 0;
                                                } else {
                                                    atomicBoolean4.set(false);
                                                    k3 k3VarZ5 = k3.z(context7);
                                                    if (!cf.K().P()) {
                                                        return;
                                                    }
                                                    if (k3VarZ5.A() == null && k3VarZ5.C() == null && k3VarZ5.B() == null) {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                k3VarZ2.K(2, j3VarB.f4304a, k3.H((String) qVarA2.f136c));
                                            }
                                            j3 = 0;
                                        }
                                        atomicBoolean4.set(false);
                                        k3 k3VarZ6 = k3.z(context7);
                                        if (!cf.K().P()) {
                                            return;
                                        }
                                        if (k3VarZ6.A() == null && k3VarZ6.C() == null && k3VarZ6.B() == null) {
                                            return;
                                        }
                                    }
                                }
                            } else {
                                atomicBoolean4.set(false);
                                k3 k3VarZ7 = k3.z(context7);
                                if (!cf.K().P()) {
                                    return;
                                }
                                if (k3VarZ7.A() == null && k3VarZ7.C() == null && k3VarZ7.B() == null) {
                                    return;
                                }
                            }
                        } catch (Throwable th6) {
                            atomicBoolean4.set(false);
                            k3 k3VarZ8 = k3.z(context7);
                            if (cf.K().P() && (k3VarZ8.A() != null || k3VarZ8.C() != null || k3VarZ8.B() != null)) {
                                i3.a(context7);
                            }
                            throw th6;
                        }
                        break;
                    }
                }
                i3.a(context7);
                return;
            case 10:
                Context context8 = this.f116d;
                if (!MirrorApplication.d(context8) || w1.f.b(context8).b(SystemClock.elapsedRealtime())) {
                    return;
                }
                c.c(context8);
                return;
            case 11:
                s8.f(this.f116d, true);
                return;
            case 12:
                b();
                return;
            case 13:
                c();
                return;
            case 14:
                Context context9 = this.f116d;
                if (c2.p.k(context9)) {
                    d1.d(context9);
                    return;
                }
                return;
            case 15:
                Context context10 = this.f116d;
                if (context10 == null || !c2.p.k(context10)) {
                    return;
                }
                d1.d(context10);
                return;
            case 16:
                Context context11 = this.f116d;
                AtomicBoolean atomicBoolean5 = e9.f3902a;
                applicationContext = context11 != null ? context11.getApplicationContext() : null;
                if (applicationContext != null) {
                    e9.f(applicationContext);
                    return;
                }
                return;
            case 17:
                Context context12 = this.f116d;
                AtomicBoolean atomicBoolean6 = i3.f4238a;
                applicationContext = context12 != null ? context12.getApplicationContext() : null;
                if (applicationContext != null) {
                    i3.a(applicationContext);
                    return;
                }
                return;
            case 18:
                c2.c.e(this.f116d, "socket-connected", false);
                return;
            case 19:
                f2.l.l(this.f116d);
                return;
            default:
                Context context13 = this.f116d;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                c2.p.o(SystemClock.elapsedRealtime());
                Log.i("TunnelManager", "strong lock after-flush executed succeeded=" + w1.n.R(context13).startsWith("LOCK_OK") + " durationMs=" + Math.max(0L, SystemClock.elapsedRealtime() - jElapsedRealtime));
                return;
        }
    }
}
