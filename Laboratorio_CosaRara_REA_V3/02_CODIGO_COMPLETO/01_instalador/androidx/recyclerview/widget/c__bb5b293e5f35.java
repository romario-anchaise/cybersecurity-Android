// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0005e;
import java.io.EOFException;

/* JADX INFO: renamed from: androidx.recyclerview.widget.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0085c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1905c;

    public C0085c(k1.C c2) {
        this.f1903a = 1;
        F0.i.e(c2, "source");
        this.f1905c = c2;
        this.f1904b = 262144L;
    }

    public void a(int i2) {
        if (i2 < 64) {
            this.f1904b &= ~(1 << i2);
            return;
        }
        C0085c c0085c = (C0085c) this.f1905c;
        if (c0085c != null) {
            c0085c.a(i2 - 64);
        }
    }

    public int b(int i2) {
        C0085c c0085c = (C0085c) this.f1905c;
        if (c0085c == null) {
            return i2 >= 64 ? Long.bitCount(this.f1904b) : Long.bitCount(this.f1904b & ((1 << i2) - 1));
        }
        if (i2 < 64) {
            return Long.bitCount(this.f1904b & ((1 << i2) - 1));
        }
        return Long.bitCount(this.f1904b) + c0085c.b(i2 - 64);
    }

    public void c() {
        if (((C0085c) this.f1905c) == null) {
            this.f1905c = new C0085c();
        }
    }

    public boolean d(int i2) {
        if (i2 < 64) {
            return (this.f1904b & (1 << i2)) != 0;
        }
        c();
        return ((C0085c) this.f1905c).d(i2 - 64);
    }

    public void e(int i2, boolean z2) {
        if (i2 >= 64) {
            c();
            ((C0085c) this.f1905c).e(i2 - 64, z2);
            return;
        }
        long j2 = this.f1904b;
        boolean z3 = (Long.MIN_VALUE & j2) != 0;
        long j3 = (1 << i2) - 1;
        this.f1904b = ((j2 & (~j3)) << 1) | (j2 & j3);
        if (z2) {
            i(i2);
        } else {
            a(i2);
        }
        if (z3 || ((C0085c) this.f1905c) != null) {
            c();
            ((C0085c) this.f1905c).e(0, z3);
        }
    }

    public X0.n f() throws EOFException {
        C0005e c0005e = new C0005e(10);
        while (true) {
            String strY = ((k1.C) this.f1905c).y(this.f1904b);
            this.f1904b -= (long) strY.length();
            if (strY.length() == 0) {
                return c0005e.B();
            }
            int iX = M0.e.X(strY, ':', 1, false, 4);
            if (iX != -1) {
                String strSubstring = strY.substring(0, iX);
                F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = strY.substring(iX + 1);
                F0.i.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                c0005e.z(strSubstring, strSubstring2);
            } else if (strY.charAt(0) == ':') {
                String strSubstring3 = strY.substring(1);
                F0.i.d(strSubstring3, "this as java.lang.String).substring(startIndex)");
                c0005e.z("", strSubstring3);
            } else {
                c0005e.z("", strY);
            }
        }
    }

    public boolean g(int i2) {
        if (i2 >= 64) {
            c();
            return ((C0085c) this.f1905c).g(i2 - 64);
        }
        long j2 = 1 << i2;
        long j3 = this.f1904b;
        boolean z2 = (j3 & j2) != 0;
        long j4 = j3 & (~j2);
        this.f1904b = j4;
        long j5 = j2 - 1;
        this.f1904b = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
        C0085c c0085c = (C0085c) this.f1905c;
        if (c0085c != null) {
            if (c0085c.d(0)) {
                i(63);
            }
            ((C0085c) this.f1905c).g(0);
        }
        return z2;
    }

    public void h() {
        this.f1904b = 0L;
        C0085c c0085c = (C0085c) this.f1905c;
        if (c0085c != null) {
            c0085c.h();
        }
    }

    public void i(int i2) {
        if (i2 < 64) {
            this.f1904b |= 1 << i2;
        } else {
            c();
            ((C0085c) this.f1905c).i(i2 - 64);
        }
    }

    public String toString() {
        switch (this.f1903a) {
            case 0:
                if (((C0085c) this.f1905c) == null) {
                    return Long.toBinaryString(this.f1904b);
                }
                return ((C0085c) this.f1905c).toString() + "xx" + Long.toBinaryString(this.f1904b);
            default:
                return super.toString();
        }
    }

    public C0085c() {
        this.f1903a = 0;
        this.f1904b = 0L;
    }
}
