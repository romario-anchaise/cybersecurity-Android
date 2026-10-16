// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: androidx.recyclerview.widget.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0101t implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f2037e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0099q f2038f = new C0099q(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f2039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f2042d;

    public static c0 c(RecyclerView recyclerView, int i2, long j2) {
        int iH = recyclerView.f1798f.h();
        for (int i3 = 0; i3 < iH; i3++) {
            c0 c0VarI = RecyclerView.I(recyclerView.f1798f.g(i3));
            if (c0VarI.mPosition == i2 && !c0VarI.isInvalid()) {
                return null;
            }
        }
        U u2 = recyclerView.f1792c;
        try {
            recyclerView.O();
            c0 c0VarK = u2.k(i2, j2);
            if (c0VarK != null) {
                if (!c0VarK.isBound() || c0VarK.isInvalid()) {
                    u2.a(c0VarK, false);
                } else {
                    u2.h(c0VarK.itemView);
                }
            }
            return c0VarK;
        } finally {
            recyclerView.P(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.f1823s) {
            if (RecyclerView.f1764y0 && !this.f2039a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f2040b == 0) {
                this.f2040b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        r rVar = recyclerView.f1797e0;
        rVar.f2028a = i2;
        rVar.f2029b = i3;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0135  */
    public final void b(long j2) {
        C0100s c0100s;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        C0100s c0100s2;
        ArrayList arrayList = this.f2039a;
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i3);
            if (recyclerView3.getWindowVisibility() == 0) {
                r rVar = recyclerView3.f1797e0;
                rVar.b(recyclerView3, false);
                i2 += rVar.f2031d;
            }
        }
        ArrayList arrayList2 = this.f2042d;
        arrayList2.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i5);
            if (recyclerView4.getWindowVisibility() == 0) {
                r rVar2 = recyclerView4.f1797e0;
                int iAbs = Math.abs(rVar2.f2029b) + Math.abs(rVar2.f2028a);
                for (int i6 = 0; i6 < rVar2.f2031d * 2; i6 += 2) {
                    if (i4 >= arrayList2.size()) {
                        c0100s2 = new C0100s();
                        arrayList2.add(c0100s2);
                    } else {
                        c0100s2 = (C0100s) arrayList2.get(i4);
                    }
                    int[] iArr = rVar2.f2030c;
                    int i7 = iArr[i6 + 1];
                    c0100s2.f2032a = i7 <= iAbs;
                    c0100s2.f2033b = iAbs;
                    c0100s2.f2034c = i7;
                    c0100s2.f2035d = recyclerView4;
                    c0100s2.f2036e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(arrayList2, f2038f);
        for (int i8 = 0; i8 < arrayList2.size() && (recyclerView = (c0100s = (C0100s) arrayList2.get(i8)).f2035d) != null; i8++) {
            c0 c0VarC = c(recyclerView, c0100s.f2036e, c0100s.f2032a ? Long.MAX_VALUE : j2);
            if (c0VarC != null && c0VarC.mNestedRecyclerView != null && c0VarC.isBound() && !c0VarC.isInvalid() && (recyclerView2 = c0VarC.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.f1768C && recyclerView2.f1798f.h() != 0) {
                    K k2 = recyclerView2.f1777L;
                    if (k2 != null) {
                        k2.e();
                    }
                    N n2 = recyclerView2.f1813n;
                    U u2 = recyclerView2.f1792c;
                    if (n2 != null) {
                        n2.c0(u2);
                        recyclerView2.f1813n.d0(u2);
                    }
                    u2.f1866a.clear();
                    u2.f();
                }
                r rVar3 = recyclerView2.f1797e0;
                rVar3.b(recyclerView2, true);
                if (rVar3.f2031d != 0) {
                    try {
                        int i9 = p039w.j.f4157a;
                        p039w.i.a("RV Nested Prefetch");
                        Y y2 = recyclerView2.f1799f0;
                        F f2 = recyclerView2.f1811m;
                        y2.f1877c = 1;
                        y2.f1878d = f2.getItemCount();
                        y2.f1880f = false;
                        y2.g = false;
                        y2.f1881h = false;
                        for (int i10 = 0; i10 < rVar3.f2031d * 2; i10 += 2) {
                            c(recyclerView2, rVar3.f2030c[i10], j2);
                        }
                        p039w.i.b();
                    } catch (Throwable th) {
                        int i11 = p039w.j.f4157a;
                        p039w.i.b();
                        throw th;
                    }
                }
            }
            c0100s.f2032a = false;
            c0100s.f2033b = 0;
            c0100s.f2034c = 0;
            c0100s.f2035d = null;
            c0100s.f2036e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i2 = p039w.j.f4157a;
            p039w.i.a("RV Prefetch");
            ArrayList arrayList = this.f2039a;
            if (arrayList.isEmpty()) {
                this.f2040b = 0L;
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i3);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.f2040b = 0L;
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2041c);
                this.f2040b = 0L;
            }
        } finally {
            this.f2040b = 0L;
            int i4 = p039w.j.f4157a;
            p039w.i.b();
        }
    }
}
