// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class A extends H.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1700d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(N n2, int i2) {
        super(n2);
        this.f1700d = i2;
    }

    @Override // H.h
    public final int b(View view) {
        switch (this.f1700d) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                return view.getRight() + ((O) view.getLayoutParams()).f1755b.right + ((ViewGroup.MarginLayoutParams) o2).rightMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                return view.getBottom() + ((O) view.getLayoutParams()).f1755b.bottom + ((ViewGroup.MarginLayoutParams) o3).bottomMargin;
        }
    }

    @Override // H.h
    public final int c(View view) {
        switch (this.f1700d) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                Rect rect = ((O) view.getLayoutParams()).f1755b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) o2).leftMargin + ((ViewGroup.MarginLayoutParams) o2).rightMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                Rect rect2 = ((O) view.getLayoutParams()).f1755b;
                return view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) o3).topMargin + ((ViewGroup.MarginLayoutParams) o3).bottomMargin;
        }
    }

    @Override // H.h
    public final int d(View view) {
        switch (this.f1700d) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                Rect rect = ((O) view.getLayoutParams()).f1755b;
                return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) o2).topMargin + ((ViewGroup.MarginLayoutParams) o2).bottomMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                Rect rect2 = ((O) view.getLayoutParams()).f1755b;
                return view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) o3).leftMargin + ((ViewGroup.MarginLayoutParams) o3).rightMargin;
        }
    }

    @Override // H.h
    public final int e(View view) {
        switch (this.f1700d) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                return (view.getLeft() - ((O) view.getLayoutParams()).f1755b.left) - ((ViewGroup.MarginLayoutParams) o2).leftMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f200b).getClass();
                return (view.getTop() - ((O) view.getLayoutParams()).f1755b.top) - ((ViewGroup.MarginLayoutParams) o3).topMargin;
        }
    }

    @Override // H.h
    public final int f() {
        switch (this.f1700d) {
            case 0:
                return ((N) this.f200b).f1752m;
            default:
                return ((N) this.f200b).f1753n;
        }
    }

    @Override // H.h
    public final int g() {
        switch (this.f1700d) {
            case 0:
                N n2 = (N) this.f200b;
                return n2.f1752m - n2.A();
            default:
                N n3 = (N) this.f200b;
                return n3.f1753n - n3.y();
        }
    }

    @Override // H.h
    public final int h() {
        switch (this.f1700d) {
            case 0:
                return ((N) this.f200b).A();
            default:
                return ((N) this.f200b).y();
        }
    }

    @Override // H.h
    public final int i() {
        switch (this.f1700d) {
            case 0:
                return ((N) this.f200b).f1750k;
            default:
                return ((N) this.f200b).f1751l;
        }
    }

    @Override // H.h
    public final int j() {
        switch (this.f1700d) {
            case 0:
                return ((N) this.f200b).f1751l;
            default:
                return ((N) this.f200b).f1750k;
        }
    }

    @Override // H.h
    public final int k() {
        switch (this.f1700d) {
            case 0:
                return ((N) this.f200b).z();
            default:
                return ((N) this.f200b).B();
        }
    }

    @Override // H.h
    public final int l() {
        switch (this.f1700d) {
            case 0:
                N n2 = (N) this.f200b;
                return (n2.f1752m - n2.z()) - n2.A();
            default:
                N n3 = (N) this.f200b;
                return (n3.f1753n - n3.B()) - n3.y();
        }
    }

    @Override // H.h
    public final int n(View view) {
        switch (this.f1700d) {
            case 0:
                N n2 = (N) this.f200b;
                Rect rect = (Rect) this.f201c;
                n2.F(view, rect);
                return rect.right;
            default:
                N n3 = (N) this.f200b;
                Rect rect2 = (Rect) this.f201c;
                n3.F(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // H.h
    public final int o(View view) {
        switch (this.f1700d) {
            case 0:
                N n2 = (N) this.f200b;
                Rect rect = (Rect) this.f201c;
                n2.F(view, rect);
                return rect.left;
            default:
                N n3 = (N) this.f200b;
                Rect rect2 = (Rect) this.f201c;
                n3.F(view, rect2);
                return rect2.top;
        }
    }

    @Override // H.h
    public final void p(int i2) {
        switch (this.f1700d) {
            case 0:
                ((N) this.f200b).J(i2);
                break;
            default:
                ((N) this.f200b).K(i2);
                break;
        }
    }
}
