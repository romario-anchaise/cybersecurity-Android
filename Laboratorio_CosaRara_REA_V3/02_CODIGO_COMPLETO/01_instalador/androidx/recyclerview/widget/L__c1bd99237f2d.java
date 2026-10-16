// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1721b;

    public /* synthetic */ L(int i2, Object obj) {
        this.f1720a = i2;
        this.f1721b = obj;
    }

    public int a(View view) {
        switch (this.f1720a) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f1721b).getClass();
                return view.getRight() + ((O) view.getLayoutParams()).f1755b.right + ((ViewGroup.MarginLayoutParams) o2).rightMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f1721b).getClass();
                return view.getBottom() + ((O) view.getLayoutParams()).f1755b.bottom + ((ViewGroup.MarginLayoutParams) o3).bottomMargin;
        }
    }

    public int b(View view) {
        switch (this.f1720a) {
            case 0:
                O o2 = (O) view.getLayoutParams();
                ((N) this.f1721b).getClass();
                return (view.getLeft() - ((O) view.getLayoutParams()).f1755b.left) - ((ViewGroup.MarginLayoutParams) o2).leftMargin;
            default:
                O o3 = (O) view.getLayoutParams();
                ((N) this.f1721b).getClass();
                return (view.getTop() - ((O) view.getLayoutParams()).f1755b.top) - ((ViewGroup.MarginLayoutParams) o3).topMargin;
        }
    }

    public int c() {
        switch (this.f1720a) {
            case 0:
                N n2 = (N) this.f1721b;
                return n2.f1752m - n2.A();
            default:
                N n3 = (N) this.f1721b;
                return n3.f1753n - n3.y();
        }
    }

    public int d() {
        switch (this.f1720a) {
            case 0:
                return ((N) this.f1721b).z();
            default:
                return ((N) this.f1721b).B();
        }
    }
}
