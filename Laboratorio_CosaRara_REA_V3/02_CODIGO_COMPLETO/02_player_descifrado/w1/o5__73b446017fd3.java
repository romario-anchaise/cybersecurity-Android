// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o5 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f4714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n5 f4716g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f4711b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f4712c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f4713d = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4710a = 2;

    public static void j(od odVar, boolean z2, int i3, boolean z3) {
        if (odVar == null || odVar.f4758d.get()) {
            return;
        }
        if (z2 && z3 && i3 == 14) {
            odVar.c(5, 15);
            return;
        }
        if (!z2) {
            i3 = 11;
        }
        odVar.c(6, i3);
    }

    public static void k(n5 n5Var, n5 n5Var2, od odVar, int i3, boolean z2) {
        od odVar2 = n5Var.f4625e;
        boolean z3 = true;
        j(odVar2, n5Var2 == null || (n5Var == n5Var2 && (odVar == null || odVar2 == odVar)), i3, z2);
        od odVar3 = n5Var.f4633m;
        if (odVar3 != null) {
            if (n5Var2 != null && (n5Var != n5Var2 || (odVar != null && odVar3 != odVar))) {
                z3 = false;
            }
            j(odVar3, z3, i3, z2);
        }
    }

    public final synchronized void a(int i3, Object obj) {
        if (obj == null) {
            if (this.f4716g != null) {
            }
            i(null, null, i3);
            b();
            return;
        }
        if (this.f4714e != obj) {
            return;
        }
        if (this.f4716g != null && this.f4711b.isEmpty() && this.f4714e == null) {
            return;
        }
        i(null, null, i3);
        b();
        return;
        throw th;
    }

    public final void b() {
        this.f4716g = null;
        this.f4711b.clear();
        this.f4712c.clear();
        this.f4713d.clear();
        this.f4714e = null;
        this.f4715f = 0L;
    }

    public final synchronized boolean c(n5 n5Var, od odVar, int i3) {
        try {
            if (!odVar.f4758d.get() && this.f4716g == n5Var && (n5Var.f4625e == odVar || n5Var.f4633m == odVar)) {
                i(n5Var, odVar, i3);
                b();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d(n5 n5Var, od odVar, int i3) {
        if (n5Var != null) {
            try {
                if (!odVar.f4758d.get() && this.f4716g != n5Var && this.f4711b.contains(n5Var) && (n5Var.f4625e == odVar || n5Var.f4633m == odVar)) {
                    Iterator it = this.f4711b.iterator();
                    boolean z2 = false;
                    while (it.hasNext()) {
                        n5 n5Var2 = (n5) it.next();
                        if (n5Var2 == n5Var) {
                            z2 = true;
                        }
                        if (z2) {
                            k(n5Var2, n5Var, odVar, i3, true);
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean e(n5 n5Var, int i3) {
        if (n5Var != null) {
            if (this.f4716g == n5Var) {
                i(n5Var, null, i3);
                b();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000c  */
    public final synchronized boolean f(n5 n5Var) {
        boolean z2;
        if (n5Var == null) {
            z2 = false;
        } else if (this.f4716g == n5Var) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final void g(long j3, od odVar) {
        m5 m5Var = new m5(odVar.f4756b, odVar.f4757c, j3, odVar);
        ArrayDeque arrayDeque = this.f4713d;
        arrayDeque.addLast(m5Var);
        while (arrayDeque.size() > 64) {
            arrayDeque.removeFirst();
        }
    }

    public final n5 h(long j3) {
        n5 n5Var = this.f4716g;
        if (n5Var != null && n5Var.f4622b == j3) {
            return n5Var;
        }
        for (n5 n5Var2 : this.f4711b) {
            if (n5Var2.f4622b == j3) {
                return n5Var2;
            }
        }
        return null;
    }

    public final void i(n5 n5Var, od odVar, int i3) {
        n5 n5Var2 = this.f4716g;
        if (n5Var2 != null) {
            k(n5Var2, n5Var, odVar, i3, false);
        }
        Iterator it = this.f4711b.iterator();
        while (it.hasNext()) {
            k((n5) it.next(), n5Var, odVar, i3, true);
        }
    }
}
