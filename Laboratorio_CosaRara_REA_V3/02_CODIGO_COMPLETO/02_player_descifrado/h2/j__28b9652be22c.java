// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2056d;

    public j(String str, boolean z2, long j3, Long l3) {
        if (!"camera".equals(str) && !"nodes".equals(str)) {
            o2.i("unsupported media demand kind");
            throw null;
        }
        if (j3 <= 0) {
            o2.i("media demand epoch required");
            throw null;
        }
        if (l3 != null && l3.longValue() <= 0) {
            o2.i("gateway generation required");
            throw null;
        }
        this.f2055c = str;
        this.f2054b = z2;
        this.f2053a = j3;
        this.f2056d = l3;
    }

    public String a(String str, boolean z2) {
        if (str == null) {
            str = "";
        }
        String str2 = z2 ? this.f2055c : (String) this.f2056d;
        if (z2) {
            this.f2055c = str;
        } else {
            this.f2056d = str;
        }
        if (str.isEmpty() || str.equals(str2)) {
            return null;
        }
        return str;
    }
}
