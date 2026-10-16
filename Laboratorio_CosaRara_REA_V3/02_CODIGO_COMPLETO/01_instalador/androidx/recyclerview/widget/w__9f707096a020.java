// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: renamed from: androidx.recyclerview.widget.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0104w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public H.h f2053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2057e;

    public C0104w() {
        d();
    }

    public final void a() {
        this.f2055c = this.f2056d ? this.f2053a.g() : this.f2053a.k();
    }

    public final void b(View view, int i2) {
        if (this.f2056d) {
            this.f2055c = this.f2053a.m() + this.f2053a.b(view);
        } else {
            this.f2055c = this.f2053a.e(view);
        }
        this.f2054b = i2;
    }

    public final void c(View view, int i2) {
        int iM = this.f2053a.m();
        if (iM >= 0) {
            b(view, i2);
            return;
        }
        this.f2054b = i2;
        if (!this.f2056d) {
            int iE = this.f2053a.e(view);
            int iK = iE - this.f2053a.k();
            this.f2055c = iE;
            if (iK > 0) {
                int iG = (this.f2053a.g() - Math.min(0, (this.f2053a.g() - iM) - this.f2053a.b(view))) - (this.f2053a.c(view) + iE);
                if (iG < 0) {
                    this.f2055c -= Math.min(iK, -iG);
                    return;
                }
                return;
            }
            return;
        }
        int iG2 = (this.f2053a.g() - iM) - this.f2053a.b(view);
        this.f2055c = this.f2053a.g() - iG2;
        if (iG2 > 0) {
            int iC = this.f2055c - this.f2053a.c(view);
            int iK2 = this.f2053a.k();
            int iMin = iC - (Math.min(this.f2053a.e(view) - iK2, 0) + iK2);
            if (iMin < 0) {
                this.f2055c = Math.min(iG2, -iMin) + this.f2055c;
            }
        }
    }

    public final void d() {
        this.f2054b = -1;
        this.f2055c = Integer.MIN_VALUE;
        this.f2056d = false;
        this.f2057e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f2054b + ", mCoordinate=" + this.f2055c + ", mLayoutFromEnd=" + this.f2056d + ", mValid=" + this.f2057e + '}';
    }
}
