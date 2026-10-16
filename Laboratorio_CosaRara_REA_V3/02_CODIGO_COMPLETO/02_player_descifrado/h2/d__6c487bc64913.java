// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1978i;

    public d(String str, String str2, String str3, long j3, String str4, String str5, String str6, String str7, String str8) {
        this.f1970a = str == null ? "" : str;
        this.f1971b = str2 == null ? "" : str2;
        this.f1972c = str3 == null ? "" : str3;
        this.f1973d = j3;
        this.f1974e = str4 == null ? "" : str4;
        this.f1975f = str5 == null ? "" : str5;
        this.f1976g = str6 == null ? "" : str6;
        this.f1977h = str7 == null ? "" : str7;
        this.f1978i = str8 == null ? "" : str8;
    }

    public final boolean a(String str, String str2, r rVar) {
        if ((!str.isEmpty() && !this.f1971b.equals(str)) || !this.f1974e.equals(str2)) {
            return false;
        }
        String str3 = (String) rVar.f6032a;
        if (str3 == null) {
            str3 = "";
        }
        if (!this.f1975f.equals(str3) || !this.f1976g.equals("")) {
            return false;
        }
        if (this.f1977h.equals((String) rVar.f6033b)) {
            return this.f1978i.equals((String) rVar.f6034c);
        }
        return false;
    }
}
