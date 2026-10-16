// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.Closeable;
import java.util.Arrays;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f5769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f5771e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f5773g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5772f = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5774h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5775i = -1;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5769c == null) {
            o2.k("not attached to a buffer");
            return;
        }
        this.f5769c = null;
        this.f5771e = null;
        this.f5772f = -1L;
        this.f5773g = null;
        this.f5774h = -1;
        this.f5775i = -1;
    }

    public final void d(long j3) {
        h hVar = this.f5769c;
        if (hVar == null) {
            o2.k("not attached to a buffer");
            return;
        }
        if (!this.f5770d) {
            o2.k("resizeBuffer() only permitted for read/write buffers");
            return;
        }
        long j4 = hVar.f5777d;
        if (j3 <= j4) {
            if (j3 < 0) {
                o2.j("newSize < 0: ", j3);
                return;
            }
            long j5 = j4 - j3;
            while (j5 > 0) {
                s sVar = hVar.f5776c;
                sVar.getClass();
                s sVar2 = sVar.f5807g;
                sVar2.getClass();
                int i3 = sVar2.f5803c;
                long j6 = i3 - sVar2.f5802b;
                if (j6 > j5) {
                    sVar2.f5803c = i3 - ((int) j5);
                    break;
                } else {
                    hVar.f5776c = sVar2.a();
                    t.a(sVar2);
                    j5 -= j6;
                }
            }
            this.f5771e = null;
            this.f5772f = j3;
            this.f5773g = null;
            this.f5774h = -1;
            this.f5775i = -1;
        } else if (j3 > j4) {
            long j7 = j3 - j4;
            int i4 = 1;
            boolean z2 = true;
            for (long j8 = 0; j7 > j8; j8 = 0) {
                s sVarF = hVar.F(i4);
                int iMin = (int) Math.min(j7, 8192 - sVarF.f5803c);
                int i5 = sVarF.f5803c + iMin;
                sVarF.f5803c = i5;
                j7 -= (long) iMin;
                if (z2) {
                    this.f5771e = sVarF;
                    this.f5772f = j4;
                    this.f5773g = sVarF.f5801a;
                    this.f5774h = i5 - iMin;
                    this.f5775i = i5;
                    z2 = false;
                }
                i4 = 1;
            }
        }
        hVar.f5777d = j3;
    }

    public final int w(long j3) {
        h hVar = this.f5769c;
        if (hVar == null) {
            o2.k("not attached to a buffer");
            return 0;
        }
        if (j3 >= -1) {
            long j4 = hVar.f5777d;
            if (j3 <= j4) {
                if (j3 == -1 || j3 == j4) {
                    this.f5771e = null;
                    this.f5772f = j3;
                    this.f5773g = null;
                    this.f5774h = -1;
                    this.f5775i = -1;
                    return -1;
                }
                s sVar = hVar.f5776c;
                s sVar2 = this.f5771e;
                long j5 = 0;
                if (sVar2 != null) {
                    long j6 = this.f5772f - ((long) (this.f5774h - sVar2.f5802b));
                    if (j6 > j3) {
                        sVar2 = sVar;
                        sVar = sVar2;
                        j4 = j6;
                    } else {
                        j5 = j6;
                    }
                } else {
                    sVar2 = sVar;
                }
                if (j4 - j3 > j3 - j5) {
                    while (true) {
                        sVar2.getClass();
                        long j7 = ((long) (sVar2.f5803c - sVar2.f5802b)) + j5;
                        if (j3 < j7) {
                            break;
                        }
                        sVar2 = sVar2.f5806f;
                        j5 = j7;
                    }
                } else {
                    while (j4 > j3) {
                        sVar.getClass();
                        sVar = sVar.f5807g;
                        sVar.getClass();
                        j4 -= (long) (sVar.f5803c - sVar.f5802b);
                    }
                    sVar2 = sVar;
                    j5 = j4;
                }
                if (this.f5770d) {
                    sVar2.getClass();
                    if (sVar2.f5804d) {
                        byte[] bArr = sVar2.f5801a;
                        s sVar3 = new s(Arrays.copyOf(bArr, bArr.length), sVar2.f5802b, sVar2.f5803c, false, true);
                        if (hVar.f5776c == sVar2) {
                            hVar.f5776c = sVar3;
                        }
                        sVar2.b(sVar3);
                        s sVar4 = sVar3.f5807g;
                        sVar4.getClass();
                        sVar4.a();
                        sVar2 = sVar3;
                    }
                }
                this.f5771e = sVar2;
                this.f5772f = j3;
                sVar2.getClass();
                this.f5773g = sVar2.f5801a;
                int i3 = sVar2.f5802b + ((int) (j3 - j5));
                this.f5774h = i3;
                int i4 = sVar2.f5803c;
                this.f5775i = i4;
                return i4 - i3;
            }
        }
        StringBuilder sbJ = a0.a.j(j3, "offset=", " > size=");
        sbJ.append(hVar.f5777d);
        throw new ArrayIndexOutOfBoundsException(sbJ.toString());
    }
}
