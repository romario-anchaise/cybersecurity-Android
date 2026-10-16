// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p008e0;

import A.C0005e;
import F0.i;
import M0.e;
import X0.D;
import X0.n;
import android.graphics.Bitmap;
import java.io.EOFException;
import k1.B;
import k1.C;
import p016j0.f;
import p028p0.a;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2253a = a.m(new a(this, 0));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2254b = a.m(new a(this, 1));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f2258f;

    public b(C c2) throws EOFException {
        this.f2255c = Long.parseLong(c2.y(Long.MAX_VALUE));
        this.f2256d = Long.parseLong(c2.y(Long.MAX_VALUE));
        this.f2257e = Integer.parseInt(c2.y(Long.MAX_VALUE)) > 0;
        int i2 = Integer.parseInt(c2.y(Long.MAX_VALUE));
        C0005e c0005e = new C0005e(10);
        for (int i3 = 0; i3 < i2; i3++) {
            String strY = c2.y(Long.MAX_VALUE);
            Bitmap.Config config = f.f3375a;
            int iX = e.X(strY, ':', 0, false, 6);
            if (iX == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(strY).toString());
            }
            String strSubstring = strY.substring(0, iX);
            i.d(strSubstring, "substring(...)");
            String string = e.j0(strSubstring).toString();
            String strSubstring2 = strY.substring(iX + 1);
            i.d(strSubstring2, "substring(...)");
            c0005e.A(string, strSubstring2);
        }
        this.f2258f = c0005e.B();
    }

    public final void a(B b2) {
        b2.l(this.f2255c);
        b2.o(10);
        b2.l(this.f2256d);
        b2.o(10);
        b2.l(this.f2257e ? 1L : 0L);
        b2.o(10);
        n nVar = this.f2258f;
        b2.l(nVar.size());
        b2.o(10);
        int size = nVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            b2.k(nVar.b(i2));
            b2.k(": ");
            b2.k(nVar.d(i2));
            b2.o(10);
        }
    }

    public b(D d2) {
        this.f2255c = d2.f913k;
        this.f2256d = d2.f914l;
        this.f2257e = d2.f908e != null;
        this.f2258f = d2.f909f;
    }
}
