// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0023x;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1703a;

    public /* synthetic */ D(RecyclerView recyclerView) {
        this.f1703a = recyclerView;
    }

    public void a(C0083a c0083a) {
        int i2 = c0083a.f1887a;
        RecyclerView recyclerView = this.f1703a;
        if (i2 == 1) {
            recyclerView.f1813n.S(c0083a.f1888b, c0083a.f1890d);
            return;
        }
        if (i2 == 2) {
            recyclerView.f1813n.V(c0083a.f1888b, c0083a.f1890d);
        } else if (i2 == 4) {
            recyclerView.f1813n.W(c0083a.f1888b, c0083a.f1890d);
        } else {
            if (i2 != 8) {
                return;
            }
            recyclerView.f1813n.U(c0083a.f1888b, c0083a.f1890d);
        }
    }

    public c0 b(int i2) {
        RecyclerView recyclerView = this.f1703a;
        int iH = recyclerView.f1798f.h();
        c0 c0Var = null;
        for (int i3 = 0; i3 < iH; i3++) {
            c0 c0VarI = RecyclerView.I(recyclerView.f1798f.g(i3));
            if (c0VarI != null && !c0VarI.isRemoved() && c0VarI.mPosition == i2) {
                if (!recyclerView.f1798f.f1908c.contains(c0VarI.itemView)) {
                    c0Var = c0VarI;
                    break;
                }
                c0Var = c0VarI;
            }
        }
        if (c0Var == null) {
            return null;
        }
        if (!recyclerView.f1798f.f1908c.contains(c0Var.itemView)) {
            return c0Var;
        }
        if (RecyclerView.f1765z0) {
            Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
        }
        return null;
    }

    public void c(int i2, int i3, Object obj) {
        int i4;
        int i5;
        RecyclerView recyclerView = this.f1703a;
        int iH = recyclerView.f1798f.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < iH; i7++) {
            View viewG = recyclerView.f1798f.g(i7);
            c0 c0VarI = RecyclerView.I(viewG);
            if (c0VarI != null && !c0VarI.shouldIgnore() && (i5 = c0VarI.mPosition) >= i2 && i5 < i6) {
                c0VarI.addFlags(2);
                c0VarI.addChangePayload(obj);
                ((O) viewG.getLayoutParams()).f1756c = true;
            }
        }
        U u2 = recyclerView.f1792c;
        ArrayList arrayList = u2.f1868c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c0 c0Var = (c0) arrayList.get(size);
            if (c0Var != null && (i4 = c0Var.mPosition) >= i2 && i4 < i6) {
                c0Var.addFlags(2);
                u2.g(size);
            }
        }
        recyclerView.f1806j0 = true;
    }

    public void d(int i2, int i3) {
        RecyclerView recyclerView = this.f1703a;
        int iH = recyclerView.f1798f.h();
        for (int i4 = 0; i4 < iH; i4++) {
            c0 c0VarI = RecyclerView.I(recyclerView.f1798f.g(i4));
            if (c0VarI != null && !c0VarI.shouldIgnore() && c0VarI.mPosition >= i2) {
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i4 + " holder " + c0VarI + " now at position " + (c0VarI.mPosition + i3));
                }
                c0VarI.offsetPosition(i3, false);
                recyclerView.f1799f0.f1879e = true;
            }
        }
        ArrayList arrayList = recyclerView.f1792c.f1868c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            c0 c0Var = (c0) arrayList.get(i5);
            if (c0Var != null && c0Var.mPosition >= i2) {
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i5 + " holder " + c0Var + " now at position " + (c0Var.mPosition + i3));
                }
                c0Var.offsetPosition(i3, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1804i0 = true;
    }

    public void e(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        RecyclerView recyclerView = this.f1703a;
        int iH = recyclerView.f1798f.h();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        boolean z2 = false;
        for (int i12 = 0; i12 < iH; i12++) {
            c0 c0VarI = RecyclerView.I(recyclerView.f1798f.g(i12));
            if (c0VarI != null && (i11 = c0VarI.mPosition) >= i5 && i11 <= i4) {
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i12 + " holder " + c0VarI);
                }
                if (c0VarI.mPosition == i2) {
                    c0VarI.offsetPosition(i3 - i2, false);
                } else {
                    c0VarI.offsetPosition(i6, false);
                }
                recyclerView.f1799f0.f1879e = true;
            }
        }
        U u2 = recyclerView.f1792c;
        u2.getClass();
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
            i9 = -1;
        } else {
            i7 = i2;
            i8 = i3;
            i9 = 1;
        }
        ArrayList arrayList = u2.f1868c;
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            c0 c0Var = (c0) arrayList.get(i13);
            if (c0Var != null && (i10 = c0Var.mPosition) >= i8 && i10 <= i7) {
                if (i10 == i2) {
                    c0Var.offsetPosition(i3 - i2, z2);
                } else {
                    c0Var.offsetPosition(i9, z2);
                }
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i13 + " holder " + c0Var);
                }
            }
            i13++;
            z2 = false;
        }
        recyclerView.requestLayout();
        recyclerView.f1804i0 = true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    public void f(c0 c0Var, C0023x c0023x, C0023x c0023x2) {
        boolean zG;
        RecyclerView recyclerView = this.f1703a;
        recyclerView.getClass();
        c0Var.setIsRecyclable(false);
        C0093k c0093k = (C0093k) recyclerView.f1777L;
        if (c0023x != null) {
            c0093k.getClass();
            int i2 = c0023x.f86a;
            int i3 = c0023x2.f86a;
            if (i2 == i3 && c0023x.f87b == c0023x2.f87b) {
                c0093k.l(c0Var);
                c0Var.itemView.setAlpha(0.0f);
                c0093k.f1973i.add(c0Var);
                zG = true;
            } else {
                zG = c0093k.g(c0Var, i2, c0023x.f87b, i3, c0023x2.f87b);
            }
        } else {
            c0093k.l(c0Var);
            c0Var.itemView.setAlpha(0.0f);
            c0093k.f1973i.add(c0Var);
            zG = true;
        }
        if (zG) {
            recyclerView.R();
        }
    }

    public void g(c0 c0Var, C0023x c0023x, C0023x c0023x2) {
        boolean zG;
        RecyclerView recyclerView = this.f1703a;
        recyclerView.f1792c.l(c0Var);
        recyclerView.g(c0Var);
        c0Var.setIsRecyclable(false);
        C0093k c0093k = (C0093k) recyclerView.f1777L;
        c0093k.getClass();
        int i2 = c0023x.f86a;
        int i3 = c0023x.f87b;
        View view = c0Var.itemView;
        int left = c0023x2 == null ? view.getLeft() : c0023x2.f86a;
        int top = c0023x2 == null ? view.getTop() : c0023x2.f87b;
        if (c0Var.isRemoved() || (i2 == left && i3 == top)) {
            c0093k.l(c0Var);
            c0093k.f1972h.add(c0Var);
            zG = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zG = c0093k.g(c0Var, i2, i3, left, top);
        }
        if (zG) {
            recyclerView.R();
        }
    }

    public void h(int i2) {
        RecyclerView recyclerView = this.f1703a;
        View childAt = recyclerView.getChildAt(i2);
        if (childAt != null) {
            c0 c0VarI = RecyclerView.I(childAt);
            F f2 = recyclerView.f1811m;
            if (f2 != null && c0VarI != null) {
                f2.onViewDetachedFromWindow(c0VarI);
            }
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i2);
    }
}
