// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.Bitmap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f1003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.a f1004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1.a f1005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f1010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1011i;

    public u() {
        c0 c0Var = c0.f729a;
        t tVar = t.f998k;
        z zVar = new z(0, g0.f807a, g0.class, "currentGain", "currentGain()F", 3);
        this.f1003a = c0Var;
        this.f1004b = tVar;
        this.f1005c = zVar;
        this.f1006d = new h1.d(ThreadLocalRandom.current().nextLong()).f1951c;
        this.f1007e = 0L;
        int i3 = e2.f786a.get();
        this.f1008f = i3;
        this.f1009g = i3;
        this.f1010h = 10;
    }

    public final void a(int i3, long j3) {
        if (j3 > 250 || i3 > 1500000) {
            this.f1011i = 0;
            c();
            return;
        }
        if (j3 > 120 || i3 > 750000) {
            this.f1011i = 0;
            return;
        }
        int i4 = this.f1011i + 1;
        this.f1011i = i4;
        if (i4 >= 4) {
            this.f1011i = 0;
            if (this.f1010h < 10) {
                this.f1010h++;
                return;
            }
            int i5 = this.f1009g;
            int i6 = this.f1008f;
            if (i5 < i6) {
                this.f1009g = Math.min(i6, i5 + 3);
            }
        }
    }

    public final byte[] b(f fVar, m0 m0Var, e0 e0Var, float f3, int i3, int i4) throws Throwable {
        int[] iArr;
        int[] iArr2;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        y.r rVar = fVar.f789c;
        Bitmap bitmapC = ((AtomicBoolean) rVar.f6033b).get() ? null : (Bitmap) rVar.f6032a;
        c0 c0Var = this.f1003a;
        if (c0Var == null) {
            c0Var = null;
        }
        if (bitmapC == null || c0Var == null) {
            int i5 = fVar.f787a;
            int i6 = fVar.f788b;
            y.r rVar2 = fVar.f789c;
            synchronized (rVar2) {
                if (((AtomicBoolean) rVar2.f6033b).get()) {
                    throw new IllegalStateException("captured frame is released");
                }
                iArr = (int[]) rVar2.f6034c;
                if (iArr == null) {
                    Bitmap bitmap4 = (Bitmap) rVar2.f6032a;
                    if (bitmap4 == null) {
                        throw new IllegalStateException("captured frame has no pixel resource");
                    }
                    int[] iArr3 = new int[i5 * i6];
                    bitmap4.getPixels(iArr3, 0, i5, 0, 0, i5, i6);
                    rVar2.f6034c = iArr3;
                    iArr = iArr3;
                }
            }
            int i7 = m0Var.f868a;
            int i8 = m0Var.f869b;
            if (i5 <= 0 || i6 <= 0 || iArr.length != i5 * i6) {
                o2.i("Failed requirement.");
                return null;
            }
            e0 e0VarH = b1.h(i7, i8, i3);
            int i9 = e0VarH.f781a;
            int i10 = e0VarH.f782b;
            int i11 = i9 * i10;
            int[] iArr4 = new int[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr4[i12] = -16777216;
            }
            d0 d0VarD = b1.d(i5, i6, i9, i10);
            int i13 = d0VarD.f746e;
            int i14 = d0VarD.f747f;
            int i15 = d0VarD.f744c;
            int i16 = d0VarD.f745d;
            int[] iArr5 = new int[i13];
            int[] iArr6 = iArr;
            int[] iArr7 = new int[i13];
            int[] iArr8 = new int[i13];
            int i17 = 0;
            while (i17 < i13) {
                int i18 = i17;
                float f4 = (((i17 + 0.5f) * i5) / i13) - 0.5f;
                int i19 = i5 - 1;
                int i20 = i15;
                float fD = y.f.d(f4, 0.0f, i19);
                int i21 = (int) fD;
                iArr5[i18] = i21;
                iArr7[i18] = Math.min(i19, i21 + 1);
                iArr8[i18] = y.f.e(q2.k.p((fD - i21) * 256.0f), 256);
                i17 = i18 + 1;
                i15 = i20;
                iArr4 = iArr4;
            }
            int i22 = i15;
            int[] iArr9 = iArr4;
            int i23 = 0;
            while (i23 < i14) {
                int i24 = i6 - 1;
                int i25 = i23;
                float fD2 = y.f.d((((i23 + 0.5f) * i6) / i14) - 0.5f, 0.0f, i24);
                int i26 = (int) fD2;
                int iMin = Math.min(i24, i26 + 1);
                int iE = y.f.e(q2.k.p((fD2 - i26) * 256.0f), 256);
                int i27 = i26 * i5;
                int i28 = iMin * i5;
                int i29 = ((i16 + i25) * i9) + i22;
                int i30 = 0;
                while (i30 < i13) {
                    int i31 = iArr5[i30];
                    int i32 = iArr7[i30];
                    int i33 = i29 + i30;
                    int i34 = iArr6[i27 + i31];
                    int i35 = iArr6[i27 + i32];
                    int i36 = iArr6[i28 + i31];
                    int i37 = iArr6[i28 + i32];
                    int i38 = i28;
                    int i39 = iArr8[i30];
                    int i40 = i30;
                    int i41 = 256 - i39;
                    int i42 = 256 - iE;
                    int i43 = iE;
                    iArr9[i33] = (b1.a(i34, i41, i35, i39, i36, i37, i42, i43, 24) << 24) | (b1.a(i34, i41, i35, i39, i36, i37, i42, i43, 16) << 16) | (b1.a(i34, i41, i35, i39, i36, i37, i42, i43, 8) << 8) | b1.a(i34, i41, i35, i39, i36, i37, i42, i43, 0);
                    i30 = i40 + 1;
                    iE = i43;
                    i28 = i38;
                }
                i23 = i25 + 1;
            }
            if (i9 != e0Var.f781a || i10 != e0Var.f782b) {
                o2.k("Check failed.");
                return null;
            }
            g0 g0Var = g0.f807a;
            float fC = g0.c(f3);
            if (fC <= 1.0f) {
                iArr2 = iArr9;
            } else {
                int[] iArr10 = new int[i11];
                for (int i44 = 0; i44 < i11; i44++) {
                    int i45 = iArr9[i44];
                    int i46 = 255;
                    int i47 = (i45 >>> 24) & 255;
                    int iP = q2.k.p(((i45 >>> 16) & 255) * fC);
                    if (iP > 255) {
                        iP = 255;
                    }
                    int iP2 = q2.k.p(((i45 >>> 8) & 255) * fC);
                    if (iP2 > 255) {
                        iP2 = 255;
                    }
                    int iP3 = q2.k.p((i45 & 255) * fC);
                    if (iP3 <= 255) {
                        i46 = iP3;
                    }
                    iArr10[i44] = (i47 << 24) | (iP << 16) | (iP2 << 8) | i46;
                }
                iArr2 = iArr10;
            }
            this.f1003a.getClass();
            if (iArr2.length != i11) {
                o2.i("Failed requirement.");
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i9, i10, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.getClass();
            try {
                bitmapCreateBitmap.setPixels(iArr2, 0, i9, 0, 0, i9, i10);
                bitmap = bitmapCreateBitmap;
                try {
                    byte[] bArrA = c0.a(bitmap, i4);
                    bitmap.recycle();
                    return bArrA;
                } catch (Throwable th) {
                    th = th;
                    bitmap.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmap = bitmapCreateBitmap;
            }
        } else {
            if (bitmapC.getWidth() == e0Var.f781a && bitmapC.getHeight() == e0Var.f782b) {
                bitmap2 = null;
            } else {
                bitmapC = b1.c(bitmapC, e0Var.f781a, e0Var.f782b);
                bitmap2 = bitmapC;
            }
            try {
                Bitmap bitmapA = g0.a(bitmapC, f3);
                bitmap3 = bitmapA != bitmapC ? bitmapA : null;
                try {
                    byte[] bArrA2 = c0.a(bitmapA, i4);
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    return bArrA2;
                } catch (Throwable th3) {
                    th = th3;
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bitmap3 = null;
            }
        }
    }

    public final void c() {
        int i3 = this.f1009g;
        if (i3 > 40) {
            this.f1009g = Math.max(40, i3 - 3);
        }
        if (this.f1010h > 4) {
            this.f1010h--;
        }
    }
}
