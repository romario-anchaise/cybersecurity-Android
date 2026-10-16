// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import A.C0005e;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f893b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f896e;
    public G g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public D f898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public D f899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public D f900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b1.e f903m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f894c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0005e f897f = new C0005e(10);

    public static void b(D d2, String str) {
        if (d2 != null) {
            if (d2.g != null) {
                throw new IllegalArgumentException(str.concat(".body != null").toString());
            }
            if (d2.f910h != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (d2.f911i != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (d2.f912j != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final D a() {
        int i2 = this.f894c;
        if (i2 < 0) {
            throw new IllegalStateException(("code < 0: " + this.f894c).toString());
        }
        y yVar = this.f892a;
        if (yVar == null) {
            throw new IllegalStateException("request == null");
        }
        x xVar = this.f893b;
        if (xVar == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.f895d;
        if (str != null) {
            return new D(yVar, xVar, str, i2, this.f896e, this.f897f.B(), this.g, this.f898h, this.f899i, this.f900j, this.f901k, this.f902l, this.f903m);
        }
        throw new IllegalStateException("message == null");
    }
}
