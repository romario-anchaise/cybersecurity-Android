// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.recyclerview.widget.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0086d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D f1906a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f1910e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1909d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0085c f1907b = new C0085c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1908c = new ArrayList();

    public C0086d(D d2) {
        this.f1906a = d2;
    }

    public final void a(View view, int i2, boolean z2) {
        RecyclerView recyclerView = this.f1906a.f1703a;
        int childCount = i2 < 0 ? recyclerView.getChildCount() : f(i2);
        this.f1907b.e(childCount, z2);
        if (z2) {
            i(view);
        }
        recyclerView.addView(view, childCount);
        c0 c0VarI = RecyclerView.I(view);
        F f2 = recyclerView.f1811m;
        if (f2 == null || c0VarI == null) {
            return;
        }
        f2.onViewAttachedToWindow(c0VarI);
    }

    public final void b(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        RecyclerView recyclerView = this.f1906a.f1703a;
        int childCount = i2 < 0 ? recyclerView.getChildCount() : f(i2);
        this.f1907b.e(childCount, z2);
        if (z2) {
            i(view);
        }
        c0 c0VarI = RecyclerView.I(view);
        if (c0VarI != null) {
            if (!c0VarI.isTmpDetached() && !c0VarI.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(c0VarI);
                throw new IllegalArgumentException(F0.h.c(recyclerView, sb));
            }
            if (RecyclerView.f1765z0) {
                Log.d("RecyclerView", "reAttach " + c0VarI);
            }
            c0VarI.clearTmpDetachFlag();
        } else if (RecyclerView.f1764y0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(F0.h.c(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void c(int i2) {
        int iF = f(i2);
        this.f1907b.g(iF);
        RecyclerView recyclerView = this.f1906a.f1703a;
        View childAt = recyclerView.getChildAt(iF);
        if (childAt != null) {
            c0 c0VarI = RecyclerView.I(childAt);
            if (c0VarI != null) {
                if (c0VarI.isTmpDetached() && !c0VarI.shouldIgnore()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(c0VarI);
                    throw new IllegalArgumentException(F0.h.c(recyclerView, sb));
                }
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "tmpDetach " + c0VarI);
                }
                c0VarI.addFlags(256);
            }
        } else if (RecyclerView.f1764y0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iF);
            throw new IllegalArgumentException(F0.h.c(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iF);
    }

    public final View d(int i2) {
        return this.f1906a.f1703a.getChildAt(f(i2));
    }

    public final int e() {
        return this.f1906a.f1703a.getChildCount() - this.f1908c.size();
    }

    public final int f(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.f1906a.f1703a.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            C0085c c0085c = this.f1907b;
            int iB = i2 - (i3 - c0085c.b(i3));
            if (iB == 0) {
                while (c0085c.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    public final View g(int i2) {
        return this.f1906a.f1703a.getChildAt(i2);
    }

    public final int h() {
        return this.f1906a.f1703a.getChildCount();
    }

    public final void i(View view) {
        this.f1908c.add(view);
        D d2 = this.f1906a;
        c0 c0VarI = RecyclerView.I(view);
        if (c0VarI != null) {
            c0VarI.onEnteredHiddenState(d2.f1703a);
        }
    }

    public final void j(View view) {
        if (this.f1908c.remove(view)) {
            D d2 = this.f1906a;
            c0 c0VarI = RecyclerView.I(view);
            if (c0VarI != null) {
                c0VarI.onLeftHiddenState(d2.f1703a);
            }
        }
    }

    public final String toString() {
        return this.f1907b.toString() + ", hidden list:" + this.f1908c.size();
    }
}
