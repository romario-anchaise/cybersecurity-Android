// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b2.d f2274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f2275b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f2278e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a0 f2280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y f2281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y f2282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y f2283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g0.k f2286m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2276c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n1 f2279f = new n1(9);

    public static void b(y yVar, String str) {
        if (yVar != null) {
            if (yVar.f2293i != null) {
                o2.h(str.concat(".body != null"));
                return;
            }
            if (yVar.f2294j != null) {
                o2.h(str.concat(".networkResponse != null"));
            } else if (yVar.f2295k != null) {
                o2.h(str.concat(".cacheResponse != null"));
            } else {
                if (yVar.f2296l == null) {
                    return;
                }
                o2.h(str.concat(".priorResponse != null"));
            }
        }
    }

    public final y a() {
        int i3 = this.f2276c;
        if (i3 < 0) {
            b2.a.g("code < 0: ", this.f2276c);
            return null;
        }
        b2.d dVar = this.f2274a;
        if (dVar == null) {
            o2.k("request == null");
            return null;
        }
        v vVar = this.f2275b;
        if (vVar == null) {
            o2.k("protocol == null");
            return null;
        }
        String str = this.f2277d;
        if (str != null) {
            return new y(dVar, vVar, str, i3, this.f2278e, this.f2279f.g(), this.f2280g, this.f2281h, this.f2282i, this.f2283j, this.f2284k, this.f2285l, this.f2286m);
        }
        o2.k("message == null");
        return null;
    }
}
