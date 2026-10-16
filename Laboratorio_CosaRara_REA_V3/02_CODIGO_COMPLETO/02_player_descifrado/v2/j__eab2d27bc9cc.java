// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;
import w1.o2;
import w2.k;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.i f3345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f3346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w2.h f3350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w2.h f3351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f3353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final byte[] f3354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w2.g f3355m;

    public j(w2.i iVar, Random random, boolean z2, boolean z3, long j3) {
        iVar.getClass();
        this.f3345c = iVar;
        this.f3346d = random;
        this.f3347e = z2;
        this.f3348f = z3;
        this.f3349g = j3;
        this.f3350h = new w2.h();
        this.f3351i = iVar.s();
        this.f3354l = new byte[4];
        this.f3355m = new w2.g();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        a aVar = this.f3353k;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void d(int i3, k kVar) throws IOException {
        if (this.f3352j) {
            o2.l("closed");
            return;
        }
        int iC = kVar.c();
        if (iC > 125) {
            o2.i("Payload size must be less than or equal to 125");
            return;
        }
        w2.h hVar = this.f3351i;
        hVar.J(i3 | 128);
        hVar.J(iC | 128);
        byte[] bArr = this.f3354l;
        bArr.getClass();
        this.f3346d.nextBytes(bArr);
        hVar.G(bArr.length, bArr);
        if (iC > 0) {
            long j3 = hVar.f5777d;
            hVar.H(kVar);
            w2.g gVar = this.f3355m;
            gVar.getClass();
            hVar.A(gVar);
            gVar.w(j3);
            y.f.n(gVar, bArr);
            gVar.close();
        }
        this.f3345c.flush();
    }

    public final void w(int i3, k kVar) throws IOException {
        long j3;
        if (this.f3352j) {
            o2.l("closed");
            return;
        }
        w2.h hVar = this.f3350h;
        hVar.H(kVar);
        int i4 = i3 | 128;
        if (!this.f3347e || kVar.f5779c.length < this.f3349g) {
            j3 = 0;
        } else {
            a aVar = this.f3353k;
            if (aVar == null) {
                aVar = new a(0, this.f3348f);
                this.f3353k = aVar;
            }
            o2.e eVar = (o2.e) aVar.f3294g;
            w2.h hVar2 = aVar.f3292e;
            if (hVar2.f5777d != 0) {
                o2.i("Failed requirement.");
                return;
            }
            if (aVar.f3291d) {
                ((Deflater) aVar.f3293f).reset();
            }
            eVar.t(hVar.f5777d, hVar);
            eVar.flush();
            k kVar2 = b.f3295a;
            long j4 = hVar2.f5777d;
            byte[] bArr = kVar2.f5779c;
            long length = j4 - ((long) bArr.length);
            int length2 = bArr.length;
            if (length < 0 || length2 < 0) {
                j3 = 0;
            } else {
                j3 = 0;
                if (j4 - length >= length2 && bArr.length >= length2) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            long j5 = hVar2.f5777d - ((long) 4);
                            w2.g gVarA = hVar2.A(w2.b.f5754a);
                            try {
                                gVarA.d(j5);
                                gVarA.close();
                                break;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    y.f.c(gVarA, th);
                                    throw th2;
                                }
                            }
                        }
                        if (hVar2.y(((long) i5) + length) == kVar2.f5779c[i5]) {
                            i5++;
                        }
                    }
                }
                hVar.t(hVar2.f5777d, hVar2);
                i4 = i3 | 192;
            }
            hVar2.J(0);
            hVar.t(hVar2.f5777d, hVar2);
            i4 = i3 | 192;
        }
        long j6 = hVar.f5777d;
        w2.h hVar3 = this.f3351i;
        hVar3.J(i4);
        if (j6 <= 125) {
            hVar3.J(((int) j6) | 128);
        } else if (j6 <= 65535) {
            hVar3.J(254);
            hVar3.M((int) j6);
        } else {
            hVar3.J(255);
            s sVarF = hVar3.F(8);
            byte[] bArr2 = sVarF.f5801a;
            int i6 = sVarF.f5803c;
            bArr2[i6] = (byte) ((j6 >>> 56) & 255);
            bArr2[i6 + 1] = (byte) ((j6 >>> 48) & 255);
            bArr2[i6 + 2] = (byte) ((j6 >>> 40) & 255);
            bArr2[i6 + 3] = (byte) ((j6 >>> 32) & 255);
            bArr2[i6 + 4] = (byte) ((j6 >>> 24) & 255);
            bArr2[i6 + 5] = (byte) ((j6 >>> 16) & 255);
            bArr2[i6 + 6] = (byte) ((j6 >>> 8) & 255);
            bArr2[i6 + 7] = (byte) (j6 & 255);
            sVarF.f5803c = i6 + 8;
            hVar3.f5777d += 8;
        }
        byte[] bArr3 = this.f3354l;
        bArr3.getClass();
        this.f3346d.nextBytes(bArr3);
        hVar3.G(bArr3.length, bArr3);
        if (j6 > j3) {
            w2.g gVar = this.f3355m;
            gVar.getClass();
            hVar.A(gVar);
            gVar.w(j3);
            y.f.n(gVar, bArr3);
            gVar.close();
        }
        hVar3.t(j6, hVar);
        this.f3345c.i();
    }
}
