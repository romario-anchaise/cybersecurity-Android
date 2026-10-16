// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f245b;

    public w(int i2) {
        this.f244a = new SparseArray(i2);
    }

    public final void a(q qVar, int i2, int i3) {
        int iA = qVar.a(i2);
        SparseArray sparseArray = this.f244a;
        w wVar = sparseArray == null ? null : (w) sparseArray.get(iA);
        if (wVar == null) {
            wVar = new w(1);
            sparseArray.put(qVar.a(i2), wVar);
        }
        if (i3 > i2) {
            wVar.a(qVar, i2 + 1, i3);
        } else {
            wVar.f245b = qVar;
        }
    }
}
