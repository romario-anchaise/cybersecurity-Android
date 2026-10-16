// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.database.Observable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class G extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((W) ((H) ((Observable) this).mObservers.get(size))).f1873a;
            recyclerView.h(null);
            recyclerView.f1799f0.f1879e = true;
            recyclerView.T(true);
            if (!recyclerView.f1796e.j()) {
                recyclerView.requestLayout();
            }
        }
    }

    public final void c(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            W w2 = (W) ((H) ((Observable) this).mObservers.get(size));
            RecyclerView recyclerView = w2.f1873a;
            recyclerView.h(null);
            C0084b c0084b = recyclerView.f1796e;
            c0084b.getClass();
            if (i2 != i3) {
                ArrayList arrayList = (ArrayList) c0084b.f1893c;
                arrayList.add(c0084b.l(null, 8, i2, i3));
                c0084b.f1891a |= 8;
                if (arrayList.size() == 1) {
                    w2.a();
                }
            }
        }
    }

    public final void d(int i2, int i3, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            W w2 = (W) ((H) ((Observable) this).mObservers.get(size));
            RecyclerView recyclerView = w2.f1873a;
            recyclerView.h(null);
            C0084b c0084b = recyclerView.f1796e;
            if (i3 < 1) {
                c0084b.getClass();
            } else {
                ArrayList arrayList = (ArrayList) c0084b.f1893c;
                arrayList.add(c0084b.l(obj, 4, i2, i3));
                c0084b.f1891a = 4 | c0084b.f1891a;
                if (arrayList.size() == 1) {
                    w2.a();
                }
            }
        }
    }

    public final void e(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            W w2 = (W) ((H) ((Observable) this).mObservers.get(size));
            RecyclerView recyclerView = w2.f1873a;
            recyclerView.h(null);
            C0084b c0084b = recyclerView.f1796e;
            if (i3 < 1) {
                c0084b.getClass();
            } else {
                ArrayList arrayList = (ArrayList) c0084b.f1893c;
                arrayList.add(c0084b.l(null, 1, i2, i3));
                c0084b.f1891a |= 1;
                if (arrayList.size() == 1) {
                    w2.a();
                }
            }
        }
    }

    public final void f(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            W w2 = (W) ((H) ((Observable) this).mObservers.get(size));
            RecyclerView recyclerView = w2.f1873a;
            recyclerView.h(null);
            C0084b c0084b = recyclerView.f1796e;
            if (i3 < 1) {
                c0084b.getClass();
            } else {
                ArrayList arrayList = (ArrayList) c0084b.f1893c;
                arrayList.add(c0084b.l(null, 2, i2, i3));
                c0084b.f1891a |= 2;
                if (arrayList.size() == 1) {
                    w2.a();
                }
            }
        }
    }

    public final void g() {
        F f2;
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((W) ((H) ((Observable) this).mObservers.get(size))).f1873a;
            if (recyclerView.f1794d != null && (f2 = recyclerView.f1811m) != null && f2.canRestoreState()) {
                recyclerView.requestLayout();
            }
        }
    }
}
