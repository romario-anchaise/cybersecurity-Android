// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f5798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f5799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5800e;

    public r(x xVar) {
        xVar.getClass();
        this.f5798c = xVar;
        this.f5799d = new h();
    }

    @Override // w2.x
    public final z a() {
        return this.f5798c.a();
    }

    @Override // w2.j
    public final void b(long j3, h hVar) throws EOFException {
        h hVar2 = this.f5799d;
        try {
            p(j3);
            hVar2.b(j3, hVar);
        } catch (EOFException e3) {
            hVar.I(hVar2);
            throw e3;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f5800e) {
            return;
        }
        this.f5800e = true;
        this.f5798c.close();
        h hVar = this.f5799d;
        hVar.skip(hVar.f5777d);
    }

    public final boolean d() {
        if (this.f5800e) {
            o2.k("closed");
            return false;
        }
        h hVar = this.f5799d;
        return hVar.w() && this.f5798c.f(8192L, hVar) == -1;
    }

    @Override // w2.j
    public final k e(long j3) throws EOFException {
        p(j3);
        return this.f5799d.e(j3);
    }

    @Override // w2.x
    public final long f(long j3, h hVar) {
        hVar.getClass();
        if (j3 < 0) {
            o2.j("byteCount < 0: ", j3);
            return 0L;
        }
        if (this.f5800e) {
            o2.k("closed");
            return 0L;
        }
        h hVar2 = this.f5799d;
        if (hVar2.f5777d == 0 && this.f5798c.f(8192L, hVar2) == -1) {
            return -1L;
        }
        return hVar2.f(Math.min(j3, hVar2.f5777d), hVar);
    }

    @Override // w2.j
    public final String g(long j3) throws EOFException {
        if (j3 < 0) {
            o2.j("limit < 0: ", j3);
            return null;
        }
        long j4 = j3 == Long.MAX_VALUE ? Long.MAX_VALUE : j3 + 1;
        long jW = w((byte) 10, 0L, j4);
        h hVar = this.f5799d;
        if (jW != -1) {
            return x2.a.a(jW, hVar);
        }
        if (j4 < Long.MAX_VALUE && z(j4) && hVar.y(j4 - 1) == 13 && z(j4 + 1) && hVar.y(j4) == 10) {
            return x2.a.a(j4, hVar);
        }
        h hVar2 = new h();
        hVar.d(hVar2, 0L, Math.min(32, hVar.f5777d));
        throw new EOFException("\\n not found: limit=" + Math.min(hVar.f5777d, j3) + " content=" + hVar2.e(hVar2.f5777d).d() + (char) 8230);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f5800e;
    }

    @Override // w2.j
    public final int k(p pVar) {
        h hVar;
        pVar.getClass();
        if (this.f5800e) {
            o2.k("closed");
            return 0;
        }
        do {
            hVar = this.f5799d;
            int iB = x2.a.b(hVar, pVar, true);
            if (iB != -2) {
                if (iB == -1) {
                    break;
                }
                hVar.skip(pVar.f5793c[iB].c());
                return iB;
            }
        } while (this.f5798c.f(8192L, hVar) != -1);
        return -1;
    }

    @Override // w2.j
    public final String n() {
        return g(Long.MAX_VALUE);
    }

    @Override // w2.j
    public final void p(long j3) throws EOFException {
        if (!z(j3)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        h hVar = this.f5799d;
        if (hVar.f5777d == 0 && this.f5798c.f(8192L, hVar) == -1) {
            return -1;
        }
        return hVar.read(byteBuffer);
    }

    @Override // w2.j
    public final byte readByte() throws EOFException {
        p(1L);
        return this.f5799d.readByte();
    }

    @Override // w2.j
    public final void readFully(byte[] bArr) throws EOFException {
        h hVar = this.f5799d;
        bArr.getClass();
        try {
            p(bArr.length);
            hVar.readFully(bArr);
        } catch (EOFException e3) {
            int i3 = 0;
            while (true) {
                long j3 = hVar.f5777d;
                if (j3 <= 0) {
                    throw e3;
                }
                int i4 = hVar.read(bArr, i3, (int) j3);
                if (i4 == -1) {
                    throw new AssertionError();
                }
                i3 += i4;
            }
        }
    }

    @Override // w2.j
    public final int readInt() throws EOFException {
        p(4L);
        return this.f5799d.readInt();
    }

    @Override // w2.j
    public final long readLong() throws EOFException {
        p(8L);
        return this.f5799d.readLong();
    }

    @Override // w2.j
    public final short readShort() throws EOFException {
        p(2L);
        return this.f5799d.readShort();
    }

    @Override // w2.j
    public final void skip(long j3) throws EOFException {
        if (this.f5800e) {
            o2.k("closed");
            return;
        }
        while (j3 > 0) {
            h hVar = this.f5799d;
            if (hVar.f5777d == 0 && this.f5798c.f(8192L, hVar) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j3, hVar.f5777d);
            hVar.skip(jMin);
            j3 -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.f5798c + ')';
    }

    @Override // w2.j
    public final long u() throws EOFException {
        h hVar;
        p(1L);
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            boolean z2 = z(i4);
            hVar = this.f5799d;
            if (!z2) {
                break;
            }
            byte bY = hVar.y(i3);
            if ((bY < 48 || bY > 57) && ((bY < 97 || bY > 102) && (bY < 65 || bY > 70))) {
                if (i3 != 0) {
                    break;
                }
                q2.c.g(16);
                q2.c.g(16);
                String string = Integer.toString(bY, 16);
                string.getClass();
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i3 = i4;
        }
        return hVar.u();
    }

    @Override // w2.j
    public final String v(Charset charset) {
        x xVar = this.f5798c;
        h hVar = this.f5799d;
        hVar.I(xVar);
        return hVar.C(hVar.f5777d, charset);
    }

    public final long w(byte b3, long j3, long j4) {
        if (this.f5800e) {
            o2.k("closed");
            return 0L;
        }
        if (0 > j4) {
            o2.j("fromIndex=0 toIndex=", j4);
            return 0L;
        }
        long jMax = 0;
        while (jMax < j4) {
            h hVar = this.f5799d;
            byte b4 = b3;
            long j5 = j4;
            long jZ = hVar.z(b4, jMax, j5);
            if (jZ != -1) {
                return jZ;
            }
            long j6 = hVar.f5777d;
            if (j6 >= j5 || this.f5798c.f(8192L, hVar) == -1) {
                break;
            }
            jMax = Math.max(jMax, j6);
            b3 = b4;
            j4 = j5;
        }
        return -1L;
    }

    public final int y() throws EOFException {
        p(4L);
        int i3 = this.f5799d.readInt();
        return ((i3 & 255) << 24) | (((-16777216) & i3) >>> 24) | ((16711680 & i3) >>> 8) | ((65280 & i3) << 8);
    }

    public final boolean z(long j3) {
        h hVar;
        if (j3 < 0) {
            o2.j("byteCount < 0: ", j3);
            return false;
        }
        if (this.f5800e) {
            o2.k("closed");
            return false;
        }
        do {
            hVar = this.f5799d;
            if (hVar.f5777d >= j3) {
                return true;
            }
        } while (this.f5798c.f(8192L, hVar) != -1);
        return false;
    }
}
