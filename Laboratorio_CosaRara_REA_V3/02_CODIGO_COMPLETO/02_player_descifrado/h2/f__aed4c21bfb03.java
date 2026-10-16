// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f1992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f1993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1999m;
    public final long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f2000o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f2001p;

    public f(long j3, long j4, long j5, long j6, int i3, Boolean bool, Boolean bool2, long j7, int i4, int i5, int i6, int i7, long j8, long j9, long j10, long j11) {
        this.f1987a = g.f(j3);
        this.f1988b = g.f(j4);
        this.f1989c = g.f(j5);
        this.f1990d = g.f(j6);
        this.f1991e = i3 < 0 ? -1 : i3;
        this.f1992f = bool;
        this.f1993g = bool2;
        this.f1994h = g.f(j7);
        this.f1995i = i4 < 0 ? -1 : i4;
        this.f1996j = i5 < 0 ? -1 : i5;
        this.f1997k = i6 < 0 ? -1 : i6;
        this.f1998l = i7 >= 0 ? i7 : -1;
        this.f1999m = g.f(j8);
        this.n = g.f(j9);
        this.f2000o = g.f(j10);
        this.f2001p = g.f(j11);
    }

    public static JSONObject a(f fVar) throws JSONException {
        fVar.getClass();
        JSONObject jSONObject = new JSONObject();
        g.h(jSONObject, "healthGapProcessCpuMs", fVar.f1987a);
        g.h(jSONObject, "healthGapThreadCpuMs", fVar.f1988b);
        g.h(jSONObject, "healthGapBlockingGcCount", fVar.f1989c);
        g.h(jSONObject, "healthGapBlockingGcTimeMs", fVar.f1990d);
        g.g(jSONObject, "processImportance", fVar.f1991e);
        Boolean bool = fVar.f1992f;
        if (bool != null) {
            jSONObject.put("screenInteractive", bool);
        }
        Boolean bool2 = fVar.f1993g;
        if (bool2 != null) {
            jSONObject.put("powerSaveMode", bool2);
        }
        g.h(jSONObject, "mainLooperMaxDelayMs", fVar.f1994h);
        g.g(jSONObject, "trimMemoryCount", fVar.f1995i);
        g.g(jSONObject, "criticalTrimMemoryCount", fVar.f1996j);
        g.g(jSONObject, "lowMemoryCount", fVar.f1997k);
        g.g(jSONObject, "lastTrimMemoryLevel", fVar.f1998l);
        g.h(jSONObject, "pssKb", fVar.f1999m);
        g.h(jSONObject, "maxPressurePssKb", fVar.n);
        g.h(jSONObject, "javaHeapKb", fVar.f2000o);
        g.h(jSONObject, "nativeHeapKb", fVar.f2001p);
        return jSONObject;
    }
}
