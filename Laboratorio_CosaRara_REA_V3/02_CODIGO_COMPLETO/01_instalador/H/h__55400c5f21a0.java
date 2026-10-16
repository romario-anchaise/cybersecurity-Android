// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.N;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f201c;

    public h(N n2) {
        this.f199a = Integer.MIN_VALUE;
        this.f201c = new Rect();
        this.f200b = n2;
    }

    public static h a(N n2, int i2) {
        if (i2 == 0) {
            return new androidx.recyclerview.widget.A(n2, 0);
        }
        if (i2 == 1) {
            return new androidx.recyclerview.widget.A(n2, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.f199a) {
            return 0;
        }
        return l() - this.f199a;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i2);

    public h(k kVar) {
        this.f199a = 0;
        this.f201c = new e();
        this.f200b = kVar;
    }
}
