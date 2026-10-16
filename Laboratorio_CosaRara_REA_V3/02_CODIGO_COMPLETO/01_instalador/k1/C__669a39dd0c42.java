// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class C implements InterfaceC0195k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f3441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f3442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3443c;

    public C(I i2) {
        F0.i.e(i2, "source");
        this.f3441a = i2;
        this.f3442b = new C0193i();
    }

    public final void A(long j2) {
        if (this.f3443c) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            C0193i c0193i = this.f3442b;
            if (c0193i.f3482b == 0 && this.f3441a.m(c0193i, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, c0193i.f3482b);
            c0193i.K(jMin);
            j2 -= jMin;
        }
    }

    public final boolean a() {
        if (this.f3443c) {
            throw new IllegalStateException("closed");
        }
        C0193i c0193i = this.f3442b;
        return c0193i.w() && this.f3441a.m(c0193i, 8192L) == -1;
    }

    @Override // k1.InterfaceC0195k
    public final C0193i b() {
        return this.f3442b;
    }

    @Override // k1.I
    public final K c() {
        return this.f3441a.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f3443c) {
            return;
        }
        this.f3443c = true;
        this.f3441a.close();
        this.f3442b.t();
    }

    public final long f(byte b2, long j2, long j3) {
        long j4;
        D d2;
        C c2 = this;
        long j5 = j3;
        if (c2.f3443c) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        if (0 > j5) {
            throw new IllegalArgumentException(F0.h.d("fromIndex=0 toIndex=", j5).toString());
        }
        while (jMax < j5) {
            C0193i c0193i = c2.f3442b;
            c0193i.getClass();
            long j6 = 0;
            if (0 > jMax || jMax > j5) {
                throw new IllegalArgumentException(("size=" + c0193i.f3482b + " fromIndex=" + jMax + " toIndex=" + j5).toString());
            }
            long j7 = c0193i.f3482b;
            long j8 = j5 > j7 ? j7 : j5;
            long j9 = -1;
            if (jMax != j8 && (d2 = c0193i.f3481a) != null) {
                if (j7 - jMax < jMax) {
                    while (j7 > jMax) {
                        d2 = d2.g;
                        F0.i.b(d2);
                        j7 -= (long) (d2.f3446c - d2.f3445b);
                    }
                    long j10 = jMax;
                    while (j7 < j8) {
                        int iMin = (int) Math.min(d2.f3446c, (((long) d2.f3445b) + j8) - j7);
                        for (int i2 = (int) ((((long) d2.f3445b) + j10) - j7); i2 < iMin; i2++) {
                            if (d2.f3444a[i2] == b2) {
                                j9 = ((long) (i2 - d2.f3445b)) + j7;
                                break;
                            }
                        }
                        j10 = j7 + ((long) (d2.f3446c - d2.f3445b));
                        d2 = d2.f3449f;
                        F0.i.b(d2);
                        j7 = j10;
                    }
                } else {
                    while (true) {
                        long j11 = ((long) (d2.f3446c - d2.f3445b)) + j6;
                        if (j11 > jMax) {
                            break;
                        }
                        d2 = d2.f3449f;
                        F0.i.b(d2);
                        j6 = j11;
                    }
                    long j12 = jMax;
                    while (j6 < j8) {
                        int iMin2 = (int) Math.min(d2.f3446c, (((long) d2.f3445b) + j8) - j6);
                        for (int i3 = (int) ((((long) d2.f3445b) + j12) - j6); i3 < iMin2; i3++) {
                            if (d2.f3444a[i3] == b2) {
                                j9 = ((long) (i3 - d2.f3445b)) + j6;
                                break;
                            }
                        }
                        j12 = ((long) (d2.f3446c - d2.f3445b)) + j6;
                        d2 = d2.f3449f;
                        F0.i.b(d2);
                        j6 = j12;
                    }
                }
            }
            j4 = -1;
            if (j9 != -1) {
                return j9;
            }
            long j13 = c0193i.f3482b;
            if (j13 < j3) {
                c2 = this;
                if (c2.f3441a.m(c0193i, 8192L) != -1) {
                    jMax = Math.max(jMax, j13);
                    j5 = j3;
                }
            }
            return j4;
        }
        j4 = -1;
        return j4;
    }

    @Override // k1.InterfaceC0195k
    public final long g(InterfaceC0194j interfaceC0194j) {
        C0193i c0193i;
        long j2 = 0;
        while (true) {
            c0193i = this.f3442b;
            if (this.f3441a.m(c0193i, 8192L) == -1) {
                break;
            }
            long jU = c0193i.u();
            if (jU > 0) {
                j2 += jU;
                interfaceC0194j.i(c0193i, jU);
            }
        }
        long j3 = c0193i.f3482b;
        if (j3 <= 0) {
            return j2;
        }
        long j4 = j2 + j3;
        interfaceC0194j.i(c0193i, j3);
        return j4;
    }

    @Override // k1.InterfaceC0195k
    public final int h(y yVar) throws EOFException {
        C0193i c0193i;
        F0.i.e(yVar, "options");
        if (this.f3443c) {
            throw new IllegalStateException("closed");
        }
        do {
            c0193i = this.f3442b;
            int iB = l1.a.b(c0193i, yVar, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                c0193i.K(yVar.f3515a[iB].c());
                return iB;
            }
        } while (this.f3441a.m(c0193i, 8192L) != -1);
        return -1;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f3443c;
    }

    public final byte j() {
        z(1L);
        return this.f3442b.B();
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        if (this.f3443c) {
            throw new IllegalStateException("closed");
        }
        C0193i c0193i2 = this.f3442b;
        if (c0193i2.f3482b == 0 && this.f3441a.m(c0193i2, 8192L) == -1) {
            return -1L;
        }
        return c0193i2.m(c0193i, Math.min(j2, c0193i2.f3482b));
    }

    public final C0196l n(long j2) {
        z(j2);
        return this.f3442b.D(j2);
    }

    @Override // k1.InterfaceC0195k
    public final boolean q(long j2) {
        C0193i c0193i;
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        if (this.f3443c) {
            throw new IllegalStateException("closed");
        }
        do {
            c0193i = this.f3442b;
            if (c0193i.f3482b >= j2) {
                return true;
            }
        } while (this.f3441a.m(c0193i, 8192L) != -1);
        return false;
    }

    public final int r() {
        z(4L);
        return this.f3442b.F();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        F0.i.e(byteBuffer, "sink");
        C0193i c0193i = this.f3442b;
        if (c0193i.f3482b == 0 && this.f3441a.m(c0193i, 8192L) == -1) {
            return -1;
        }
        return c0193i.read(byteBuffer);
    }

    @Override // k1.InterfaceC0195k
    public final InputStream s() {
        return new C0191g(this, 1);
    }

    public final int t() {
        z(4L);
        int iF = this.f3442b.F();
        return ((iF & 255) << 24) | (((-16777216) & iF) >>> 24) | ((16711680 & iF) >>> 8) | ((65280 & iF) << 8);
    }

    public final String toString() {
        return "buffer(" + this.f3441a + ')';
    }

    public final long u() throws EOFException {
        long jF;
        z(8L);
        C0193i c0193i = this.f3442b;
        if (c0193i.f3482b < 8) {
            throw new EOFException();
        }
        D d2 = c0193i.f3481a;
        F0.i.b(d2);
        int i2 = d2.f3445b;
        int i3 = d2.f3446c;
        if (i3 - i2 < 8) {
            jF = ((((long) c0193i.F()) & 4294967295L) << 32) | (4294967295L & ((long) c0193i.F()));
        } else {
            byte[] bArr = d2.f3444a;
            int i4 = i2 + 7;
            long j2 = ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40) | ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8);
            int i5 = i2 + 8;
            long j3 = j2 | (((long) bArr[i4]) & 255);
            c0193i.f3482b -= 8;
            if (i5 == i3) {
                c0193i.f3481a = d2.a();
                E.a(d2);
            } else {
                d2.f3445b = i5;
            }
            jF = j3;
        }
        return ((jF & 255) << 56) | (((-72057594037927936L) & jF) >>> 56) | ((71776119061217280L & jF) >>> 40) | ((280375465082880L & jF) >>> 24) | ((1095216660480L & jF) >>> 8) | ((4278190080L & jF) << 8) | ((16711680 & jF) << 24) | ((65280 & jF) << 40);
    }

    public final short v() {
        z(2L);
        return this.f3442b.G();
    }

    public final short w() {
        z(2L);
        return this.f3442b.H();
    }

    public final String x(long j2) {
        z(j2);
        C0193i c0193i = this.f3442b;
        c0193i.getClass();
        return c0193i.I(j2, M0.a.f360a);
    }

    public final String y(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("limit < 0: ", j2).toString());
        }
        long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        long jF = f((byte) 10, 0L, j3);
        C0193i c0193i = this.f3442b;
        if (jF != -1) {
            return l1.a.a(c0193i, jF);
        }
        if (j3 < Long.MAX_VALUE && q(j3) && c0193i.x(j3 - 1) == 13 && q(1 + j3) && c0193i.x(j3) == 10) {
            return l1.a.a(c0193i, j3);
        }
        C0193i c0193i2 = new C0193i();
        c0193i.v(c0193i2, 0L, Math.min(32, c0193i.f3482b));
        throw new EOFException("\\n not found: limit=" + Math.min(c0193i.f3482b, j2) + " content=" + c0193i2.D(c0193i2.f3482b).d() + (char) 8230);
    }

    public final void z(long j2) {
        if (!q(j2)) {
            throw new EOFException();
        }
    }
}
