// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f5783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f5784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Inflater f5785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f5786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CRC32 f5787g;

    public m(x xVar) {
        xVar.getClass();
        r rVar = new r(xVar);
        this.f5784d = rVar;
        Inflater inflater = new Inflater(true);
        this.f5785e = inflater;
        this.f5786f = new n(rVar, inflater);
        this.f5787g = new CRC32();
    }

    public static void d(int i3, int i4, String str) throws IOException {
        if (i4 != i3) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i3)}, 3)));
        }
    }

    @Override // w2.x
    public final z a() {
        return this.f5784d.f5798c.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f5786f.close();
    }

    @Override // w2.x
    public final long f(long j3, h hVar) throws IOException {
        long j4;
        m mVar = this;
        byte b3 = mVar.f5783c;
        CRC32 crc32 = mVar.f5787g;
        r rVar = mVar.f5784d;
        if (b3 == 0) {
            rVar.p(10L);
            h hVar2 = rVar.f5799d;
            byte bY = hVar2.y(3L);
            boolean z2 = ((bY >> 1) & 1) == 1;
            if (z2) {
                mVar.w(hVar2, 0L, 10L);
            }
            d(8075, rVar.readShort(), "ID1ID2");
            rVar.skip(8L);
            if (((bY >> 2) & 1) == 1) {
                rVar.p(2L);
                if (z2) {
                    w(hVar2, 0L, 2L);
                }
                short s3 = hVar2.readShort();
                long j5 = ((short) (((s3 & 255) << 8) | ((s3 & 65280) >>> 8))) & 65535;
                rVar.p(j5);
                if (z2) {
                    w(hVar2, 0L, j5);
                }
                rVar.skip(j5);
            }
            if (((bY >> 3) & 1) == 1) {
                long jW = rVar.w((byte) 0, 0L, Long.MAX_VALUE);
                if (jW == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    j4 = 2;
                    w(hVar2, 0L, jW + 1);
                } else {
                    j4 = 2;
                }
                rVar.skip(jW + 1);
            } else {
                j4 = 2;
            }
            if (((bY >> 4) & 1) == 1) {
                j4 = j4;
                long jW2 = rVar.w((byte) 0, 0L, Long.MAX_VALUE);
                if (jW2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    mVar = this;
                    mVar.w(hVar2, 0L, jW2 + 1);
                } else {
                    mVar = this;
                }
                rVar.skip(jW2 + 1);
            } else {
                mVar = this;
            }
            if (z2) {
                rVar.p(j4);
                short s4 = hVar2.readShort();
                d((short) (((s4 & 255) << 8) | ((s4 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            mVar.f5783c = (byte) 1;
        }
        if (mVar.f5783c == 1) {
            long j6 = hVar.f5777d;
            long jF = mVar.f5786f.f(8192L, hVar);
            if (jF != -1) {
                mVar.w(hVar, j6, jF);
                return jF;
            }
            mVar.f5783c = (byte) 2;
        }
        if (mVar.f5783c == 2) {
            d(rVar.y(), (int) crc32.getValue(), "CRC");
            d(rVar.y(), (int) mVar.f5785e.getBytesWritten(), "ISIZE");
            mVar.f5783c = (byte) 3;
            if (!rVar.d()) {
                o2.l("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    public final void w(h hVar, long j3, long j4) {
        s sVar = hVar.f5776c;
        sVar.getClass();
        while (true) {
            int i3 = sVar.f5803c;
            int i4 = sVar.f5802b;
            if (j3 < i3 - i4) {
                break;
            }
            j3 -= (long) (i3 - i4);
            sVar = sVar.f5806f;
            sVar.getClass();
        }
        while (j4 > 0) {
            int i5 = (int) (((long) sVar.f5802b) + j3);
            int iMin = (int) Math.min(sVar.f5803c - i5, j4);
            this.f5787g.update(sVar.f5801a, i5, iMin);
            j4 -= (long) iMin;
            sVar = sVar.f5806f;
            sVar.getClass();
            j3 = 0;
        }
    }
}
