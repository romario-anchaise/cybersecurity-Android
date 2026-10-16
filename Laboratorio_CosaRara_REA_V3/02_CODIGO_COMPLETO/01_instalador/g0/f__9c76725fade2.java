// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import N0.C0033e;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f2743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2744b;

    public f(ImageView imageView, boolean z2) {
        this.f2743a = imageView;
        this.f2744b = z2;
    }

    public static f1.d b(int i2, int i3, int i4) {
        if (i2 == -2) {
            return b.f2739m;
        }
        int i5 = i2 - i4;
        if (i5 > 0) {
            return new a(i5);
        }
        int i6 = i3 - i4;
        if (i6 > 0) {
            return new a(i6);
        }
        return null;
    }

    @Override // g0.i
    public Object a(V.h hVar) {
        h hVarC = c();
        if (hVarC != null) {
            return hVarC;
        }
        C0033e c0033e = new C0033e(p029q.j.l(hVar), 1);
        c0033e.q();
        ViewTreeObserver viewTreeObserver = this.f2743a.getViewTreeObserver();
        k kVar = new k(this, viewTreeObserver, c0033e);
        viewTreeObserver.addOnPreDrawListener(kVar);
        c0033e.s(new j(this, viewTreeObserver, kVar));
        return c0033e.p();
    }

    public h c() {
        int paddingRight;
        ImageView imageView = this.f2743a;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i2 = layoutParams != null ? layoutParams.width : -1;
        int width = imageView.getWidth();
        boolean z2 = this.f2744b;
        if (z2) {
            paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        } else {
            paddingRight = 0;
        }
        f1.d dVarB = b(i2, width, paddingRight);
        if (dVarB == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        f1.d dVarB2 = b(layoutParams2 != null ? layoutParams2.height : -1, imageView.getHeight(), z2 ? imageView.getPaddingTop() + imageView.getPaddingBottom() : 0);
        if (dVarB2 == null) {
            return null;
        }
        return new h(dVarB, dVarB2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (F0.i.a(this.f2743a, fVar.f2743a) && this.f2744b == fVar.f2744b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f2744b) + (this.f2743a.hashCode() * 31);
    }
}
