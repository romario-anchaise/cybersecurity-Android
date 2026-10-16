// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0003c;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends C0003c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f1916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f1917e;

    public e0(RecyclerView recyclerView) {
        this.f1916d = recyclerView;
        d0 d0Var = this.f1917e;
        if (d0Var != null) {
            this.f1917e = d0Var;
        } else {
            this.f1917e = new d0(this);
        }
    }

    @Override // A.C0003c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f1916d.K()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().O(accessibilityEvent);
        }
    }

    @Override // A.C0003c
    public final void d(View view, B.m mVar) {
        this.f28a.onInitializeAccessibilityNodeInfo(view, mVar.f103a);
        RecyclerView recyclerView = this.f1916d;
        if (recyclerView.K() || recyclerView.getLayoutManager() == null) {
            return;
        }
        N layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f1742b;
        layoutManager.P(recyclerView2.f1792c, recyclerView2.f1799f0, mVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0079 A[PHI: r7
  0x0079: PHI (r7v8 int) = (r7v4 int), (r7v13 int) binds: [B:32:0x0096, B:24:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // A.C0003c
    public final boolean g(View view, int i2, Bundle bundle) {
        int iB;
        int iZ;
        if (super.g(view, i2, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f1916d;
        if (recyclerView.K() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        N layoutManager = recyclerView.getLayoutManager();
        U u2 = layoutManager.f1742b.f1792c;
        int iHeight = layoutManager.f1753n;
        int iWidth = layoutManager.f1752m;
        Rect rect = new Rect();
        if (layoutManager.f1742b.getMatrix().isIdentity() && layoutManager.f1742b.getGlobalVisibleRect(rect)) {
            iHeight = rect.height();
            iWidth = rect.width();
        }
        if (i2 == 4096) {
            iB = layoutManager.f1742b.canScrollVertically(1) ? (iHeight - layoutManager.B()) - layoutManager.y() : 0;
            if (layoutManager.f1742b.canScrollHorizontally(1)) {
                iZ = (iWidth - layoutManager.z()) - layoutManager.A();
            } else {
                iZ = 0;
            }
        } else if (i2 != 8192) {
            iB = 0;
            iZ = 0;
        } else {
            iB = layoutManager.f1742b.canScrollVertically(-1) ? -((iHeight - layoutManager.B()) - layoutManager.y()) : 0;
            if (layoutManager.f1742b.canScrollHorizontally(-1)) {
                iZ = -((iWidth - layoutManager.z()) - layoutManager.A());
            } else {
                iZ = 0;
            }
        }
        if (iB == 0 && iZ == 0) {
            return false;
        }
        layoutManager.f1742b.c0(iZ, iB, true);
        return true;
    }
}
