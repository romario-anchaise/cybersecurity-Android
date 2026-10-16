// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ChangedPackages;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile d1 f3751i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3752a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.n1 f3753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1 f3754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z1.h f3755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c1 f3758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FutureTask f3759h;

    public d1(Context context) {
        d0.d dVar;
        Context applicationContext = context.getApplicationContext();
        context = applicationContext != null ? applicationContext : context;
        b1 b1Var = new b1(c2.p.e(context, "launcher_inventory_v1"));
        this.f3753b = new e2.n1(context.getPackageManager());
        this.f3754c = b1Var;
        this.f3755d = new z1.h();
        this.f3756e = 21600000L;
        c1 c1Var = null;
        try {
            d0.d dVarE = b1Var.e();
            dVar = new d0.d(dVarE.f531a, (c1) dVarE.f532b);
        } catch (RuntimeException unused) {
            dVar = new d0.d(1L, (c1) null);
        }
        c1 c1Var2 = (c1) dVar.f532b;
        long j3 = dVar.f531a;
        this.f3757f = j3;
        if (c1Var2 != null && c1Var2.f3643a == j3) {
            c1Var = c1Var2;
        }
        this.f3758g = c1Var;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        a2.t tVar = new a2.t(3, this);
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(tVar, intentFilter, 2);
            } else {
                context.registerReceiver(tVar, intentFilter);
            }
        } catch (RuntimeException unused2) {
        }
        if (this.f3758g != null) {
            PackageManager packageManager = context.getPackageManager();
            c1 c1Var3 = this.f3758g;
            long j4 = c1Var3.f3649g;
            int i3 = c1Var3.f3648f;
            if (j4 <= 0 || SystemClock.elapsedRealtime() >= c1Var3.f3649g) {
                try {
                    ChangedPackages changedPackages = packageManager.getChangedPackages(i3);
                    if (changedPackages == null || changedPackages.getPackageNames() == null || changedPackages.getPackageNames().isEmpty() || changedPackages.getSequenceNumber() == i3) {
                        return;
                    }
                } catch (RuntimeException unused3) {
                    return;
                }
            }
            e("");
        }
    }

    public static String a(String str, int i3) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Math.min(str.length(), i3));
        int iCharCount = 0;
        for (int i4 = 0; iCharCount < str.length() && i4 < i3; i4++) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (Character.isISOControl(iCodePointAt)) {
                iCodePointAt = 32;
            }
            sb.appendCodePoint(iCodePointAt);
        }
        return sb.toString().trim();
    }

    public static c1 b(JSONObject jSONObject) {
        long j3 = jSONObject.getLong("revision");
        long j4 = jSONObject.getLong("syncedAtMs");
        int i3 = jSONObject.getInt("total");
        JSONArray jSONArray = jSONObject.getJSONArray("apps");
        if (j3 <= 0 || j4 <= 0 || i3 < 0 || jSONArray.length() > 1024) {
            o2.l("invalid persisted launcher inventory");
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
            String strA = a(jSONObject2.optString("package", ""), 255);
            if (strA.isEmpty()) {
                o2.l("persisted launcher package missing");
                return null;
            }
            arrayList.add(new e1(strA, a(jSONObject2.optString("label", strA), 256), jSONObject2.optBoolean("system", false), jSONObject2.optBoolean("enabled", true), jSONObject2.optBoolean("launchable", true), a(jSONObject2.optString("versionName", ""), 128)));
        }
        return new c1(j3, j4, i3, jSONObject.optBoolean("truncated", i3 > arrayList.size()), arrayList);
    }

    public static JSONObject c(c1 c1Var) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = c1Var.f3647e.iterator();
            while (it.hasNext()) {
                jSONArray.put(f1.g((e1) it.next()));
            }
            return new JSONObject().put("revision", c1Var.f3643a).put("syncedAtMs", c1Var.f3644b).put("total", c1Var.f3645c).put("truncated", c1Var.f3646d).put("apps", jSONArray);
        } catch (Exception e3) {
            throw new IllegalStateException("encode launcher inventory", e3);
        }
    }

    public static d1 d(Context context) {
        d1 d1Var;
        if (context == null) {
            throw new NullPointerException("context");
        }
        d1 d1Var2 = f3751i;
        if (d1Var2 != null) {
            return d1Var2;
        }
        synchronized (d1.class) {
            try {
                d1Var = f3751i;
                if (d1Var == null) {
                    d1Var = new d1(context);
                    f3751i = d1Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d1Var;
    }

    public final void e(String str) {
        synchronized (this.f3752a) {
            long j3 = this.f3757f;
            long j4 = 1;
            if (j3 > 0 && j3 != Long.MAX_VALUE) {
                j4 = 1 + j3;
            }
            this.f3757f = j4;
            this.f3758g = null;
            this.f3754c.f3540a.edit().putLong("revision", j4).apply();
        }
        ConcurrentHashMap concurrentHashMap = f1.f3961a;
        if (str == null || str.isEmpty()) {
            concurrentHashMap.clear();
        } else {
            concurrentHashMap.remove(str);
        }
    }
}
