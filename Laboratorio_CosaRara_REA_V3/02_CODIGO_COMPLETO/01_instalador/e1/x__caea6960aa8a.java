// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f2385f = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1.B f2386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f2387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f2390e;

    public x(k1.B b2) {
        F0.i.e(b2, "sink");
        this.f2386a = b2;
        C0193i c0193i = new C0193i();
        this.f2387b = c0193i;
        this.f2388c = 16384;
        this.f2390e = new d(c0193i);
    }

    public final synchronized void a(B b2) {
        try {
            F0.i.e(b2, "peerSettings");
            if (this.f2389d) {
                throw new IOException("closed");
            }
            int i2 = this.f2388c;
            int i3 = b2.f2273a;
            if ((i3 & 32) != 0) {
                i2 = b2.f2274b[5];
            }
            this.f2388c = i2;
            if (((i3 & 2) != 0 ? b2.f2274b[1] : -1) != -1) {
                d dVar = this.f2390e;
                int i4 = (i3 & 2) != 0 ? b2.f2274b[1] : -1;
                dVar.getClass();
                int iMin = Math.min(i4, 16384);
                int i5 = dVar.f2294e;
                if (i5 != iMin) {
                    if (iMin < i5) {
                        dVar.f2292c = Math.min(dVar.f2292c, iMin);
                    }
                    dVar.f2293d = true;
                    dVar.f2294e = iMin;
                    int i6 = dVar.f2297i;
                    if (iMin < i6) {
                        if (iMin == 0) {
                            C0109b[] c0109bArr = dVar.f2295f;
                            p036u0.e.w(c0109bArr, 0, c0109bArr.length);
                            dVar.g = dVar.f2295f.length - 1;
                            dVar.f2296h = 0;
                            dVar.f2297i = 0;
                        } else {
                            dVar.a(i6 - iMin);
                        }
                    }
                }
            }
            j(0, 0, 4, 1);
            this.f2386a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f2389d = true;
        this.f2386a.close();
    }

    public final synchronized void f(boolean z2, int i2, C0193i c0193i, int i3) {
        if (this.f2389d) {
            throw new IOException("closed");
        }
        j(i2, i3, 0, z2 ? 1 : 0);
        if (i3 > 0) {
            F0.i.b(c0193i);
            this.f2386a.i(c0193i, i3);
        }
    }

    public final synchronized void flush() {
        if (this.f2389d) {
            throw new IOException("closed");
        }
        this.f2386a.flush();
    }

    public final void j(int i2, int i3, int i4, int i5) {
        Level level = Level.FINE;
        Logger logger = f2385f;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(i2, i3, i4, i5, false));
        }
        if (i3 > this.f2388c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f2388c + ": " + i3).toString());
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            throw new IllegalArgumentException(F0.h.b(i2, "reserved bit set: ").toString());
        }
        byte[] bArr = Y0.b.f1119a;
        k1.B b2 = this.f2386a;
        F0.i.e(b2, "<this>");
        b2.o((i3 >>> 16) & 255);
        b2.o((i3 >>> 8) & 255);
        b2.o(i3 & 255);
        b2.o(i4 & 255);
        b2.o(i5 & 255);
        b2.f(i2 & Integer.MAX_VALUE);
    }

    public final synchronized void n(byte[] bArr, int i2, int i3) {
        F0.h.g(i3, "errorCode");
        if (this.f2389d) {
            throw new IOException("closed");
        }
        if (androidx.fragment.app.y.b(i3) == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        j(0, bArr.length + 8, 7, 0);
        this.f2386a.f(i2);
        this.f2386a.f(androidx.fragment.app.y.b(i3));
        if (bArr.length != 0) {
            this.f2386a.d(bArr);
        }
        this.f2386a.flush();
    }

    public final synchronized void r(boolean z2, int i2, ArrayList arrayList) {
        if (this.f2389d) {
            throw new IOException("closed");
        }
        this.f2390e.d(arrayList);
        long j2 = this.f2387b.f3482b;
        long jMin = Math.min(this.f2388c, j2);
        int i3 = j2 == jMin ? 4 : 0;
        if (z2) {
            i3 |= 1;
        }
        j(i2, (int) jMin, 1, i3);
        this.f2386a.i(this.f2387b, jMin);
        if (j2 > jMin) {
            long j3 = j2 - jMin;
            while (j3 > 0) {
                long jMin2 = Math.min(this.f2388c, j3);
                j3 -= jMin2;
                j(i2, (int) jMin2, 9, j3 == 0 ? 4 : 0);
                this.f2386a.i(this.f2387b, jMin2);
            }
        }
    }

    public final synchronized void t(int i2, int i3, boolean z2) {
        if (this.f2389d) {
            throw new IOException("closed");
        }
        j(0, 8, 6, z2 ? 1 : 0);
        this.f2386a.f(i2);
        this.f2386a.f(i3);
        this.f2386a.flush();
    }

    public final synchronized void u(int i2, int i3) {
        F0.h.g(i3, "errorCode");
        if (this.f2389d) {
            throw new IOException("closed");
        }
        if (androidx.fragment.app.y.b(i3) == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        j(i2, 4, 3, 0);
        this.f2386a.f(androidx.fragment.app.y.b(i3));
        this.f2386a.flush();
    }

    public final synchronized void v(int i2, long j2) {
        if (this.f2389d) {
            throw new IOException("closed");
        }
        if (j2 == 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
        }
        j(i2, 4, 8, 0);
        this.f2386a.f((int) j2);
        this.f2386a.flush();
    }
}
