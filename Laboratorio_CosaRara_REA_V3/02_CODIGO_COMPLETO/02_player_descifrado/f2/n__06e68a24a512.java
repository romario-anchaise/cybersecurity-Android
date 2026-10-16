// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1270i;

    public n(String str, String str2, String str3, String str4, boolean z2, boolean z3, boolean z4, String str5, boolean z5) {
        this.f1262a = str == null ? "" : str;
        this.f1263b = str2 == null ? "" : str2;
        this.f1264c = str3 == null ? "" : str3;
        this.f1265d = str4 == null ? "" : str4;
        this.f1266e = z2;
        this.f1267f = z3;
        this.f1268g = z4;
        this.f1269h = str5;
        this.f1270i = z5;
    }

    public final String a() {
        return this.f1262a + "/" + this.f1263b;
    }

    public final String b() {
        return (this.f1262a + " " + this.f1263b + " " + this.f1265d + " " + this.f1264c).toLowerCase(Locale.ROOT);
    }

    public final boolean c() {
        return this.f1266e && this.f1270i;
    }
}
