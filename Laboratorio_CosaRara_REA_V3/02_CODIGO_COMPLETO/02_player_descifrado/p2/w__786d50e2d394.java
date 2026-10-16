// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f2990h = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.i f2991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w2.h f2992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f2995g;

    public w(w2.q qVar) {
        qVar.getClass();
        this.f2991c = qVar;
        w2.h hVar = new w2.h();
        this.f2992d = hVar;
        this.f2993e = 16384;
        this.f2995g = new d(hVar);
    }

    public final synchronized void A(int i3, ArrayList arrayList, boolean z2) {
        if (this.f2994f) {
            throw new IOException("closed");
        }
        this.f2995g.d(arrayList);
        long j3 = this.f2992d.f5777d;
        long jMin = Math.min(this.f2993e, j3);
        int i4 = j3 == jMin ? 4 : 0;
        if (z2) {
            i4 |= 1;
        }
        y(i3, (int) jMin, 1, i4);
        this.f2991c.t(jMin, this.f2992d);
        if (j3 > jMin) {
            long j4 = j3 - jMin;
            while (j4 > 0) {
                long jMin2 = Math.min(this.f2993e, j4);
                j4 -= jMin2;
                y(i3, (int) jMin2, 9, j4 == 0 ? 4 : 0);
                this.f2991c.t(jMin2, this.f2992d);
            }
        }
    }

    public final synchronized void B(boolean z2, int i3, int i4) {
        if (this.f2994f) {
            throw new IOException("closed");
        }
        y(0, 8, 6, z2 ? 1 : 0);
        this.f2991c.writeInt(i3);
        this.f2991c.writeInt(i4);
        this.f2991c.flush();
    }

    public final synchronized void C(int i3, int i4) {
        try {
            if (i4 == 0) {
                throw null;
            }
            if (this.f2994f) {
                throw new IOException("closed");
            }
            if (g.d.a(i4) == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            y(i3, 4, 3, 0);
            this.f2991c.writeInt(g.d.a(i4));
            this.f2991c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void D(int i3, long j3) {
        if (this.f2994f) {
            throw new IOException("closed");
        }
        if (j3 == 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j3).toString());
        }
        y(i3, 4, 8, 0);
        this.f2991c.writeInt((int) j3);
        this.f2991c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f2994f = true;
        this.f2991c.close();
    }

    public final synchronized void d(a0 a0Var) {
        try {
            a0Var.getClass();
            if (this.f2994f) {
                throw new IOException("closed");
            }
            int i3 = this.f2993e;
            int i4 = a0Var.f2874a;
            if ((i4 & 32) != 0) {
                i3 = ((int[]) a0Var.f2875b)[5];
            }
            this.f2993e = i3;
            if (((i4 & 2) != 0 ? ((int[]) a0Var.f2875b)[1] : -1) != -1) {
                d dVar = this.f2995g;
                int i5 = (i4 & 2) != 0 ? ((int[]) a0Var.f2875b)[1] : -1;
                dVar.getClass();
                int iMin = Math.min(i5, 16384);
                int i6 = dVar.f2896d;
                if (i6 != iMin) {
                    if (iMin < i6) {
                        dVar.f2894b = Math.min(dVar.f2894b, iMin);
                    }
                    dVar.f2895c = true;
                    dVar.f2896d = iMin;
                    int i7 = dVar.f2900h;
                    if (iMin < i7) {
                        if (iMin == 0) {
                            b[] bVarArr = dVar.f2897e;
                            Arrays.fill(bVarArr, 0, bVarArr.length, (Object) null);
                            dVar.f2898f = dVar.f2897e.length - 1;
                            dVar.f2899g = 0;
                            dVar.f2900h = 0;
                        } else {
                            dVar.a(i7 - iMin);
                        }
                    }
                }
            }
            y(0, 0, 4, 1);
            this.f2991c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void flush() {
        if (this.f2994f) {
            throw new IOException("closed");
        }
        this.f2991c.flush();
    }

    public final synchronized void w(boolean z2, int i3, w2.h hVar, int i4) {
        if (this.f2994f) {
            throw new IOException("closed");
        }
        y(i3, i4, 0, z2 ? 1 : 0);
        if (i4 > 0) {
            w2.i iVar = this.f2991c;
            hVar.getClass();
            iVar.t(i4, hVar);
        }
    }

    public final void y(int i3, int i4, int i5, int i6) {
        Level level = Level.FINE;
        Logger logger = f2990h;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(false, i3, i4, i5, i6));
        }
        if (i4 > this.f2993e) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f2993e + ": " + i4).toString());
        }
        if ((Integer.MIN_VALUE & i3) != 0) {
            o2.h(a0.a.g("reserved bit set: ", i3));
            return;
        }
        byte[] bArr = j2.b.f2361a;
        w2.i iVar = this.f2991c;
        iVar.getClass();
        iVar.writeByte((i4 >>> 16) & 255);
        iVar.writeByte((i4 >>> 8) & 255);
        iVar.writeByte(i4 & 255);
        iVar.writeByte(i5 & 255);
        iVar.writeByte(i6 & 255);
        iVar.writeInt(i3 & Integer.MAX_VALUE);
    }

    public final synchronized void z(byte[] bArr, int i3, int i4) {
        try {
            if (i4 == 0) {
                throw null;
            }
            if (this.f2994f) {
                throw new IOException("closed");
            }
            if (g.d.a(i4) == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            y(0, bArr.length + 8, 7, 0);
            this.f2991c.writeInt(i3);
            this.f2991c.writeInt(g.d.a(i4));
            if (bArr.length != 0) {
                this.f2991c.write(bArr);
            }
            this.f2991c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }
}
