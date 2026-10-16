// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f1172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f1174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1175m;
    public final boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f1176o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f1177p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f1178q;

    public d0(SharedPreferences sharedPreferences) {
        boolean zBooleanValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : e0.f1184d) {
            Boolean bool = (Boolean) e0.f1183c.get(str);
            if (bool == null) {
                zBooleanValue = false;
            } else if (sharedPreferences == null) {
                zBooleanValue = bool.booleanValue();
            } else {
                try {
                    zBooleanValue = sharedPreferences.getBoolean(str, bool.booleanValue());
                } catch (Throwable unused) {
                    zBooleanValue = bool.booleanValue();
                }
            }
            linkedHashMap.put(str, Boolean.valueOf(zBooleanValue));
        }
        this.f1163a = Collections.unmodifiableMap(linkedHashMap);
        this.f1164b = a("aA");
        this.f1165c = a("rA");
        a("aD");
        this.f1166d = a("rD");
        a("aB");
        a("rB");
        a("aU");
        this.f1167e = a("rU");
        this.f1168f = a("aC");
        this.f1169g = a("rC");
        a("aBo");
        this.f1170h = a("rBo");
        a("aF");
        this.f1171i = a("rF");
        a("aCam");
        this.f1172j = a("rCam");
        a("aMic");
        this.f1173k = a("rMic");
        a("aSms");
        this.f1174l = a("rSms");
        a("aSS");
        this.f1175m = a("rSS");
        a("aRC");
        this.n = a("rRC");
        a("aRA");
        a("rRA");
        a("aRN");
        a("rRN");
        a("aHP");
        a("rHP");
        a("aDP");
        this.f1176o = a("rDP");
        a("aLOC");
        this.f1177p = a("rLOC");
        a("aCP");
        this.f1178q = a("rCP");
    }

    public final boolean a(String str) {
        return Boolean.TRUE.equals(this.f1163a.get(str));
    }
}
