// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0023x;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public D f1714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1719f;

    public static void b(c0 c0Var) {
        int i2 = c0Var.mFlags;
        if (!c0Var.isInvalid() && (i2 & 4) == 0) {
            c0Var.getOldPosition();
            c0Var.getAbsoluteAdapterPosition();
        }
    }

    public abstract boolean a(c0 c0Var, c0 c0Var2, C0023x c0023x, C0023x c0023x2);

    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076  */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x0076, please report this as an issue */
    public final void c(c0 c0Var) {
        D d2 = this.f1714a;
        if (d2 != null) {
            boolean z2 = true;
            c0Var.setIsRecyclable(true);
            if (c0Var.mShadowedHolder != null && c0Var.mShadowingHolder == null) {
                c0Var.mShadowedHolder = null;
            }
            c0Var.mShadowingHolder = null;
            if (c0Var.shouldBeKeptAsChild()) {
                return;
            }
            View view = c0Var.itemView;
            RecyclerView recyclerView = d2.f1703a;
            recyclerView.d0();
            C0086d c0086d = recyclerView.f1798f;
            C0085c c0085c = c0086d.f1907b;
            D d3 = c0086d.f1906a;
            int i2 = c0086d.f1909d;
            if (i2 != 1) {
                if (i2 == 2) {
                    throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
                }
                try {
                    c0086d.f1909d = 2;
                    int iIndexOfChild = d3.f1703a.indexOfChild(view);
                    if (iIndexOfChild == -1) {
                        c0086d.j(view);
                    } else if (c0085c.d(iIndexOfChild)) {
                        c0085c.g(iIndexOfChild);
                        c0086d.j(view);
                        d3.h(iIndexOfChild);
                    } else {
                        c0086d.f1909d = 0;
                    }
                    c0086d.f1909d = 0;
                    if (z2) {
                        c0 c0VarI = RecyclerView.I(view);
                        U u2 = recyclerView.f1792c;
                        u2.l(c0VarI);
                        u2.i(c0VarI);
                        if (RecyclerView.f1765z0) {
                            Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                        }
                    }
                    recyclerView.e0(!z2);
                    if (z2 && c0Var.isTmpDetached()) {
                        recyclerView.removeDetachedView(c0Var.itemView, false);
                        return;
                    }
                } catch (Throwable th) {
                    c0086d.f1909d = 0;
                    throw th;
                }
            }
            if (c0086d.f1910e != view) {
                throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
            }
            z2 = false;
            if (z2) {
                c0 c0VarI2 = RecyclerView.I(view);
                U u3 = recyclerView.f1792c;
                u3.l(c0VarI2);
                u3.i(c0VarI2);
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                }
            }
            recyclerView.e0(!z2);
            if (z2) {
            }
        }
    }

    public abstract void d(c0 c0Var);

    public abstract void e();

    public abstract boolean f();
}
