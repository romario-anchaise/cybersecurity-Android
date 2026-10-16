// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.Collections;
import java.util.List;
import w1.cf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1092d;

    public y1() {
        cf cfVarK = cf.K();
        cfVarK.getClass();
        this.f1090b = cfVarK;
        this.f1091c = new Object();
    }

    public void a(String str) {
        synchronized (this.f1091c) {
            if (this.f1089a) {
                return;
            }
            this.f1089a = true;
            a0 a0Var = (a0) this.f1092d;
            this.f1092d = null;
            if (a0Var != null) {
                a0Var.b();
            }
        }
    }

    public int[] b() {
        synchronized (this) {
            try {
                if (!this.f1089a) {
                    return null;
                }
                long[] jArr = (long[]) this.f1090b;
                int length = jArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i4 + 1;
                    boolean z2 = jArr[i3] > 0;
                    boolean[] zArr = (boolean[]) this.f1091c;
                    boolean z3 = zArr[i4];
                    int[] iArr = (int[]) this.f1092d;
                    if (z2 != z3) {
                        iArr[i4] = z2 ? 1 : 2;
                    } else {
                        iArr[i4] = 0;
                    }
                    zArr[i4] = z2;
                    i3++;
                    i4 = i5;
                }
                this.f1089a = false;
                return (int[]) ((int[]) this.f1092d).clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(List list, p1 p1Var) {
        boolean z2;
        g2.p0 p0Var;
        list.getClass();
        synchronized (this.f1091c) {
            z2 = (this.f1089a || ((a0) this.f1092d) == null) ? false : true;
        }
        if (!z2 || list.isEmpty()) {
            p1Var.f(Boolean.FALSE);
            return;
        }
        cf cfVar = (cf) this.f1090b;
        d2.c cVar = new d2.c(p1Var, this, 2);
        g2.k0 k0Var = cfVar.D;
        if (list.isEmpty() || k0Var == null || !k0Var.C()) {
            cVar.b(false);
            return;
        }
        d2.o oVar = new d2.o(19, cVar);
        g2.u0 u0Var = g2.u0.f1754m;
        if (k0Var.C() && !list.isEmpty() && list.size() <= 240) {
            byte[] bArr = (byte[]) list.get(0);
            if (q2.k.s(bArr)) {
                int i3 = 42;
                int iL = q2.k.l(42, bArr);
                if (list.size() == iL) {
                    long length = 0;
                    int i4 = 0;
                    while (i4 < list.size()) {
                        byte[] bArr2 = (byte[]) list.get(i4);
                        if (q2.k.s(bArr2) && q2.k.l(40, bArr2) == i4 && q2.k.l(i3, bArr2) == iL && bArr.length >= 40 && bArr2.length >= 40) {
                            for (int i5 = 4; i5 < 40; i5++) {
                                if (bArr[i5] == bArr2[i5]) {
                                }
                            }
                            length += ((long) bArr2.length) - 44;
                            i4++;
                            i3 = 42;
                        }
                    }
                    if (length == q2.k.k(36, bArr)) {
                        g2.r0 r0Var = (g2.r0) k0Var.f1666t.get();
                        if (r0Var.f1723a) {
                            try {
                                p0Var = new g2.p0(u0Var, "screen:webp:frame", Collections.singletonList(q2.k.f(1, list, r0Var.f1724b)), new d2.o(6, oVar));
                            } catch (IllegalArgumentException unused) {
                                ((d2.c) oVar.f603d).b(false);
                                return;
                            }
                        } else {
                            p0Var = new g2.p0(u0Var, "screen:webp", list, new d2.o(6, oVar));
                        }
                        if (k0Var.f1652e.i(p0Var)) {
                            k0Var.O();
                        }
                        k0Var.E();
                        return;
                    }
                }
            }
        }
        ((d2.c) oVar.f603d).b(false);
    }

    public boolean d(a0 a0Var) {
        boolean z2;
        synchronized (this.f1091c) {
            if (this.f1089a || ((a0) this.f1092d) != null) {
                z2 = false;
            } else {
                this.f1092d = a0Var;
                z2 = true;
            }
        }
        if (!z2) {
            a0Var.b();
            return false;
        }
        try {
            a0Var.d();
            return true;
        } catch (Throwable unused) {
            synchronized (this.f1091c) {
                if (((a0) this.f1092d) == a0Var) {
                    this.f1092d = null;
                }
                a0Var.b();
                return false;
            }
        }
    }

    public y1(List list, List list2, List list3, boolean z2) {
        this.f1090b = list;
        this.f1091c = list2;
        this.f1092d = list3;
        this.f1089a = z2;
    }

    public y1(int i3) {
        this.f1090b = new long[i3];
        this.f1091c = new boolean[i3];
        this.f1092d = new int[i3];
    }
}
