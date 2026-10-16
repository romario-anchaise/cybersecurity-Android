// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0023x;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.recyclerview.widget.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0093k extends K {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f1971s;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f1972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f1974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f1975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f1976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f1977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f1978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f1979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f1980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f1981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f1982r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((c0) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.K
    public final boolean a(c0 c0Var, c0 c0Var2, C0023x c0023x, C0023x c0023x2) {
        int i2;
        int i3;
        int i4 = c0023x.f86a;
        int i5 = c0023x.f87b;
        if (c0Var2.shouldIgnore()) {
            int i6 = c0023x.f86a;
            i3 = c0023x.f87b;
            i2 = i6;
        } else {
            i2 = c0023x2.f86a;
            i3 = c0023x2.f87b;
        }
        if (c0Var == c0Var2) {
            return g(c0Var, i4, i5, i2, i3);
        }
        float translationX = c0Var.itemView.getTranslationX();
        float translationY = c0Var.itemView.getTranslationY();
        float alpha = c0Var.itemView.getAlpha();
        l(c0Var);
        c0Var.itemView.setTranslationX(translationX);
        c0Var.itemView.setTranslationY(translationY);
        c0Var.itemView.setAlpha(alpha);
        l(c0Var2);
        c0Var2.itemView.setTranslationX(-((int) ((i2 - i4) - translationX)));
        c0Var2.itemView.setTranslationY(-((int) ((i3 - i5) - translationY)));
        c0Var2.itemView.setAlpha(0.0f);
        ArrayList arrayList = this.f1975k;
        C0091i c0091i = new C0091i();
        c0091i.f1945a = c0Var;
        c0091i.f1946b = c0Var2;
        c0091i.f1947c = i4;
        c0091i.f1948d = i5;
        c0091i.f1949e = i2;
        c0091i.f1950f = i3;
        arrayList.add(c0091i);
        return true;
    }

    @Override // androidx.recyclerview.widget.K
    public final void d(c0 c0Var) {
        View view = c0Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f1974j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((C0092j) arrayList.get(size)).f1960a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(c0Var);
                arrayList.remove(size);
            }
        }
        j(this.f1975k, c0Var);
        if (this.f1972h.remove(c0Var)) {
            view.setAlpha(1.0f);
            c(c0Var);
        }
        if (this.f1973i.remove(c0Var)) {
            view.setAlpha(1.0f);
            c(c0Var);
        }
        ArrayList arrayList2 = this.f1978n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(arrayList3, c0Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f1977m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            for (int size4 = arrayList5.size() - 1; size4 >= 0; size4--) {
                if (((C0092j) arrayList5.get(size4)).f1960a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(c0Var);
                    arrayList5.remove(size4);
                    if (!arrayList5.isEmpty()) {
                        break;
                    }
                    arrayList4.remove(size3);
                    break;
                }
            }
        }
        ArrayList arrayList6 = this.f1976l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(c0Var)) {
                view.setAlpha(1.0f);
                c(c0Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f1981q.remove(c0Var);
        this.f1979o.remove(c0Var);
        this.f1982r.remove(c0Var);
        this.f1980p.remove(c0Var);
        i();
    }

    @Override // androidx.recyclerview.widget.K
    public final void e() {
        ArrayList arrayList = this.f1974j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0092j c0092j = (C0092j) arrayList.get(size);
            View view = c0092j.f1960a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(c0092j.f1960a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f1972h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((c0) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f1973i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            c0 c0Var = (c0) arrayList3.get(size3);
            c0Var.itemView.setAlpha(1.0f);
            c(c0Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f1975k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            C0091i c0091i = (C0091i) arrayList4.get(size4);
            c0 c0Var2 = c0091i.f1945a;
            if (c0Var2 != null) {
                k(c0091i, c0Var2);
            }
            c0 c0Var3 = c0091i.f1946b;
            if (c0Var3 != null) {
                k(c0091i, c0Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.f1977m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    C0092j c0092j2 = (C0092j) arrayList6.get(size6);
                    View view2 = c0092j2.f1960a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(c0092j2.f1960a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f1976l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    c0 c0Var4 = (c0) arrayList8.get(size8);
                    c0Var4.itemView.setAlpha(1.0f);
                    c(c0Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f1978n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    C0091i c0091i2 = (C0091i) arrayList10.get(size10);
                    c0 c0Var5 = c0091i2.f1945a;
                    if (c0Var5 != null) {
                        k(c0091i2, c0Var5);
                    }
                    c0 c0Var6 = c0091i2.f1946b;
                    if (c0Var6 != null) {
                        k(c0091i2, c0Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.f1981q);
            h(this.f1980p);
            h(this.f1979o);
            h(this.f1982r);
            ArrayList arrayList11 = this.f1715b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.K
    public final boolean f() {
        return (this.f1973i.isEmpty() && this.f1975k.isEmpty() && this.f1974j.isEmpty() && this.f1972h.isEmpty() && this.f1980p.isEmpty() && this.f1981q.isEmpty() && this.f1979o.isEmpty() && this.f1982r.isEmpty() && this.f1977m.isEmpty() && this.f1976l.isEmpty() && this.f1978n.isEmpty()) ? false : true;
    }

    public final boolean g(c0 c0Var, int i2, int i3, int i4, int i5) {
        View view = c0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) c0Var.itemView.getTranslationY());
        l(c0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            c(c0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        ArrayList arrayList = this.f1974j;
        C0092j c0092j = new C0092j();
        c0092j.f1960a = c0Var;
        c0092j.f1961b = translationX;
        c0092j.f1962c = translationY;
        c0092j.f1963d = i4;
        c0092j.f1964e = i5;
        arrayList.add(c0092j);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f1715b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void j(ArrayList arrayList, c0 c0Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0091i c0091i = (C0091i) arrayList.get(size);
            if (k(c0091i, c0Var) && c0091i.f1945a == null && c0091i.f1946b == null) {
                arrayList.remove(c0091i);
            }
        }
    }

    public final boolean k(C0091i c0091i, c0 c0Var) {
        if (c0091i.f1946b == c0Var) {
            c0091i.f1946b = null;
        } else {
            if (c0091i.f1945a != c0Var) {
                return false;
            }
            c0091i.f1945a = null;
        }
        c0Var.itemView.setAlpha(1.0f);
        c0Var.itemView.setTranslationX(0.0f);
        c0Var.itemView.setTranslationY(0.0f);
        c(c0Var);
        return true;
    }

    public final void l(c0 c0Var) {
        if (f1971s == null) {
            f1971s = new ValueAnimator().getInterpolator();
        }
        c0Var.itemView.animate().setInterpolator(f1971s);
        d(c0Var);
    }
}
