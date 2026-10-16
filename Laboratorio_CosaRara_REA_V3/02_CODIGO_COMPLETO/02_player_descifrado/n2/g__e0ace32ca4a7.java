// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import g0.k;
import i2.q;
import i2.r;
import i2.y;
import java.util.ArrayList;
import m2.i;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f2763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f2766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b2.d f2767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2771i;

    public g(i iVar, ArrayList arrayList, int i3, k kVar, b2.d dVar, int i4, int i5, int i6) {
        this.f2763a = iVar;
        this.f2764b = arrayList;
        this.f2765c = i3;
        this.f2766d = kVar;
        this.f2767e = dVar;
        this.f2768f = i4;
        this.f2769g = i5;
        this.f2770h = i6;
    }

    public static g a(g gVar, int i3, k kVar, b2.d dVar, int i4) {
        if ((i4 & 1) != 0) {
            i3 = gVar.f2765c;
        }
        int i5 = i3;
        if ((i4 & 2) != 0) {
            kVar = gVar.f2766d;
        }
        k kVar2 = kVar;
        if ((i4 & 4) != 0) {
            dVar = gVar.f2767e;
        }
        b2.d dVar2 = dVar;
        int i6 = gVar.f2768f;
        int i7 = gVar.f2769g;
        int i8 = gVar.f2770h;
        dVar2.getClass();
        return new g(gVar.f2763a, gVar.f2764b, i5, kVar2, dVar2, i6, i7, i8);
    }

    public final y b(b2.d dVar) {
        dVar.getClass();
        ArrayList arrayList = this.f2764b;
        int size = arrayList.size();
        int i3 = this.f2765c;
        if (i3 >= size) {
            o2.k("Check failed.");
            return null;
        }
        this.f2771i++;
        k kVar = this.f2766d;
        if (kVar != null) {
            m2.e eVar = (m2.e) kVar.f1475f;
            q qVar = (q) dVar.f266c;
            eVar.getClass();
            qVar.getClass();
            q qVar2 = eVar.f2702b.f2114h;
            if (qVar.f2204e != qVar2.f2204e || !q1.e.a(qVar.f2203d, qVar2.f2203d)) {
                b2.a.i("network interceptor ", arrayList.get(i3 - 1), " must retain the same host and port");
                return null;
            }
            if (this.f2771i != 1) {
                b2.a.i("network interceptor ", arrayList.get(i3 - 1), " must call proceed() exactly once");
                return null;
            }
        }
        int i4 = i3 + 1;
        g gVarA = a(this, i4, null, dVar, 58);
        r rVar = (r) arrayList.get(i3);
        y yVarA = rVar.a(gVarA);
        if (yVarA == null) {
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        if (kVar != null && i4 < arrayList.size() && gVarA.f2771i != 1) {
            b2.a.i("network interceptor ", rVar, " must call proceed() exactly once");
            return null;
        }
        if (yVarA.f2293i != null) {
            return yVarA;
        }
        b2.a.i("interceptor ", rVar, " returned a response with no body");
        return null;
    }
}
