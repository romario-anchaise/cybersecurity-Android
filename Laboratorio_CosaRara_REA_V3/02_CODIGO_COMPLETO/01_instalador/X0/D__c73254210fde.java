// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class D implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f909f;
    public final G g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final D f910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final D f911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final D f912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1.e f915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public C0056c f916n;

    public D(y yVar, x xVar, String str, int i2, m mVar, n nVar, G g, D d2, D d3, D d4, long j2, long j3, b1.e eVar) {
        F0.i.e(yVar, "request");
        F0.i.e(xVar, "protocol");
        F0.i.e(str, "message");
        this.f904a = yVar;
        this.f905b = xVar;
        this.f906c = str;
        this.f907d = i2;
        this.f908e = mVar;
        this.f909f = nVar;
        this.g = g;
        this.f910h = d2;
        this.f911i = d3;
        this.f912j = d4;
        this.f913k = j2;
        this.f914l = j3;
        this.f915m = eVar;
    }

    public static String a(D d2, String str) {
        d2.getClass();
        String strA = d2.f909f.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        G g = this.g;
        if (g == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        g.close();
    }

    public final boolean f() {
        int i2 = this.f907d;
        return 200 <= i2 && i2 < 300;
    }

    public final C j() {
        C c2 = new C();
        c2.f892a = this.f904a;
        c2.f893b = this.f905b;
        c2.f894c = this.f907d;
        c2.f895d = this.f906c;
        c2.f896e = this.f908e;
        c2.f897f = this.f909f.c();
        c2.g = this.g;
        c2.f898h = this.f910h;
        c2.f899i = this.f911i;
        c2.f900j = this.f912j;
        c2.f901k = this.f913k;
        c2.f902l = this.f914l;
        c2.f903m = this.f915m;
        return c2;
    }

    public final String toString() {
        return "Response{protocol=" + this.f905b + ", code=" + this.f907d + ", message=" + this.f906c + ", url=" + ((p) this.f904a.f1099c) + '}';
    }
}
