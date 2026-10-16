// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.io.Closeable;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.d f2287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f2288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f2291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f2292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a0 f2293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y f2294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f2295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y f2296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f2297m;
    public final long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g0.k f2298o;

    public y(b2.d dVar, v vVar, String str, int i3, n nVar, o oVar, a0 a0Var, y yVar, y yVar2, y yVar3, long j3, long j4, g0.k kVar) {
        dVar.getClass();
        vVar.getClass();
        str.getClass();
        this.f2287c = dVar;
        this.f2288d = vVar;
        this.f2289e = str;
        this.f2290f = i3;
        this.f2291g = nVar;
        this.f2292h = oVar;
        this.f2293i = a0Var;
        this.f2294j = yVar;
        this.f2295k = yVar2;
        this.f2296l = yVar3;
        this.f2297m = j3;
        this.n = j4;
        this.f2298o = kVar;
    }

    public static String d(y yVar, String str) {
        yVar.getClass();
        String strA = yVar.f2292h.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a0 a0Var = this.f2293i;
        if (a0Var != null) {
            a0Var.close();
        } else {
            o2.k("response is not eligible for a body and must not be closed");
        }
    }

    public final String toString() {
        return "Response{protocol=" + this.f2288d + ", code=" + this.f2290f + ", message=" + this.f2289e + ", url=" + ((q) this.f2287c.f266c) + '}';
    }

    public final x w() {
        x xVar = new x();
        xVar.f2274a = this.f2287c;
        xVar.f2275b = this.f2288d;
        xVar.f2276c = this.f2290f;
        xVar.f2277d = this.f2289e;
        xVar.f2278e = this.f2291g;
        xVar.f2279f = this.f2292h.c();
        xVar.f2280g = this.f2293i;
        xVar.f2281h = this.f2294j;
        xVar.f2282i = this.f2295k;
        xVar.f2283j = this.f2296l;
        xVar.f2284k = this.f2297m;
        xVar.f2285l = this.n;
        xVar.f2286m = this.f2298o;
        return xVar;
    }
}
