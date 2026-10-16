// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f5754a = new g();

    public static f a() throws InterruptedException {
        f fVar = f.f5765l;
        fVar.getClass();
        f fVar2 = fVar.f5767f;
        if (fVar2 == null) {
            long jNanoTime = System.nanoTime();
            f.f5762i.await(f.f5763j, TimeUnit.MILLISECONDS);
            f fVar3 = f.f5765l;
            fVar3.getClass();
            if (fVar3.f5767f != null || System.nanoTime() - jNanoTime < f.f5764k) {
                return null;
            }
            return f.f5765l;
        }
        long jNanoTime2 = fVar2.f5768g - System.nanoTime();
        if (jNanoTime2 > 0) {
            f.f5762i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        f fVar4 = f.f5765l;
        fVar4.getClass();
        fVar4.f5767f = fVar2.f5767f;
        fVar2.f5767f = null;
        return fVar2;
    }

    public static void b(long j3, h hVar, int i3, ArrayList arrayList, int i4, int i5, ArrayList arrayList2) {
        int i6;
        int i7;
        ArrayList arrayList3;
        long j4;
        int i8;
        int i9 = i3;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i4 >= i5) {
            o2.i("Failed requirement.");
            return;
        }
        for (int i10 = i4; i10 < i5; i10++) {
            if (((k) arrayList4.get(i10)).c() < i9) {
                o2.i("Failed requirement.");
                return;
            }
        }
        k kVar = (k) arrayList.get(i4);
        k kVar2 = (k) arrayList4.get(i5 - 1);
        if (i9 == kVar.c()) {
            int iIntValue = ((Number) arrayList5.get(i4)).intValue();
            int i11 = i4 + 1;
            k kVar3 = (k) arrayList4.get(i11);
            i6 = i11;
            i7 = iIntValue;
            kVar = kVar3;
        } else {
            i6 = i4;
            i7 = -1;
        }
        if (kVar.f(i9) == kVar2.f(i9)) {
            int iMin = Math.min(kVar.c(), kVar2.c());
            int i12 = 0;
            for (int i13 = i9; i13 < iMin && kVar.f(i13) == kVar2.f(i13); i13++) {
                i12++;
            }
            long j5 = 4;
            long j6 = (hVar.f5777d / j5) + j3 + ((long) 2) + ((long) i12) + 1;
            hVar.L(-i12);
            hVar.L(i7);
            int i14 = i9 + i12;
            while (i9 < i14) {
                hVar.L(kVar.f(i9) & 255);
                i9++;
            }
            if (i6 + 1 == i5) {
                if (i14 == ((k) arrayList4.get(i6)).c()) {
                    hVar.L(((Number) arrayList5.get(i6)).intValue());
                    return;
                } else {
                    o2.k("Check failed.");
                    return;
                }
            }
            h hVar2 = new h();
            hVar.L(((int) ((hVar2.f5777d / j5) + j6)) * (-1));
            b(j6, hVar2, i14, arrayList4, i6, i5, arrayList5);
            hVar.I(hVar2);
            return;
        }
        int i15 = 1;
        for (int i16 = i6 + 1; i16 < i5; i16++) {
            if (((k) arrayList4.get(i16 - 1)).f(i9) != ((k) arrayList4.get(i16)).f(i9)) {
                i15++;
            }
        }
        long j7 = 4;
        long j8 = (hVar.f5777d / j7) + j3 + ((long) 2) + ((long) (i15 * 2));
        hVar.L(i15);
        hVar.L(i7);
        for (int i17 = i6; i17 < i5; i17++) {
            int iF = ((k) arrayList4.get(i17)).f(i9);
            if (i17 == i6 || iF != ((k) arrayList4.get(i17 - 1)).f(i9)) {
                hVar.L(iF & 255);
            }
        }
        h hVar3 = new h();
        int i18 = i6;
        while (i18 < i5) {
            byte bF = ((k) arrayList4.get(i18)).f(i9);
            int i19 = i18 + 1;
            int i20 = i19;
            while (true) {
                if (i20 >= i5) {
                    i20 = i5;
                    break;
                } else if (bF != ((k) arrayList4.get(i20)).f(i9)) {
                    break;
                } else {
                    i20++;
                }
            }
            if (i19 == i20 && i9 + 1 == ((k) arrayList4.get(i18)).c()) {
                hVar.L(((Number) arrayList5.get(i18)).intValue());
                arrayList3 = arrayList5;
                j4 = j8;
                i8 = i20;
            } else {
                hVar.L(((int) ((hVar3.f5777d / j7) + j8)) * (-1));
                arrayList3 = arrayList5;
                j4 = j8;
                i8 = i20;
                b(j4, hVar3, i9 + 1, arrayList, i18, i8, arrayList3);
                arrayList4 = arrayList;
            }
            j8 = j4;
            i18 = i8;
            arrayList5 = arrayList3;
        }
        hVar.I(hVar3);
    }

    public static final void c(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            StringBuilder sbJ = a0.a.j(j3, "size=", " offset=");
            sbJ.append(j4);
            sbJ.append(" byteCount=");
            sbJ.append(j5);
            throw new ArrayIndexOutOfBoundsException(sbJ.toString());
        }
    }

    public static final boolean d(AssertionError assertionError) {
        Logger logger = o.f5792a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? v1.d.B(message, "getsockname failed") : false) {
                return true;
            }
        }
        return false;
    }
}
