// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import E0.p;
import F0.m;
import H.C0028c;
import androidx.recyclerview.widget.C0099q;
import f1.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import k1.C;
import k1.C0193i;
import k1.F;
import k1.n;
import k1.z;
import p036u0.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3535a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        List<g> listP;
        String str = z.f3517b;
        z zVarQ = C0028c.q("/", false);
        p034t0.d[] dVarArr = {new p034t0.d(zVarQ, new g(zVarQ))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.p(1));
        p034t0.d dVar = dVarArr[0];
        linkedHashMap.put(dVar.f4126a, dVar.f4127b);
        C0099q c0099q = new C0099q(1);
        if (arrayList.size() <= 1) {
            listP = p036u0.f.B(arrayList);
        } else {
            Object[] array = arrayList.toArray(new Object[0]);
            F0.i.e(array, "<this>");
            if (array.length > 1) {
                Arrays.sort(array, c0099q);
            }
            listP = p036u0.e.p(array);
        }
        for (g gVar : listP) {
            if (((g) linkedHashMap.put(gVar.f3550a, gVar)) == null) {
                while (true) {
                    z zVar = gVar.f3550a;
                    z zVarB = zVar.b();
                    if (zVarB == null) {
                        break;
                    }
                    g gVar2 = (g) linkedHashMap.get(zVarB);
                    if (gVar2 != null) {
                        gVar2.f3556h.add(zVar);
                        break;
                    }
                    g gVar3 = new g(zVarB);
                    linkedHashMap.put(zVarB, gVar3);
                    gVar3.f3556h.add(zVar);
                    gVar = gVar3;
                }
            }
        }
        return linkedHashMap;
    }

    public static final String c(int i2) {
        l.k(16);
        String string = Integer.toString(i2, 16);
        F0.i.d(string, "toString(...)");
        return "0x".concat(string);
    }

    public static final g d(C c2) throws IOException {
        Long lValueOf;
        int iT = c2.t();
        if (iT != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iT));
        }
        c2.A(4L);
        short sW = c2.w();
        int i2 = sW & 65535;
        if ((sW & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i2));
        }
        int iW = c2.w() & 65535;
        short sW2 = c2.w();
        int i3 = sW2 & 65535;
        short sW3 = c2.w();
        int i4 = sW3 & 65535;
        if (i3 == -1) {
            lValueOf = null;
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((i4 >> 9) & 127) + 1980, ((i4 >> 5) & 15) - 1, sW3 & 31, (i3 >> 11) & 31, (i3 >> 5) & 63, (sW2 & 31) << 1);
            lValueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
        }
        Long l2 = lValueOf;
        c2.t();
        m mVar = new m();
        mVar.f179a = ((long) c2.t()) & 4294967295L;
        m mVar2 = new m();
        mVar2.f179a = ((long) c2.t()) & 4294967295L;
        int iW2 = c2.w() & 65535;
        int iW3 = c2.w() & 65535;
        int iW4 = c2.w() & 65535;
        c2.A(8L);
        m mVar3 = new m();
        mVar3.f179a = ((long) c2.t()) & 4294967295L;
        String strX = c2.x(iW2);
        if (M0.e.S(strX, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j2 = mVar2.f179a == 4294967295L ? 8 : 0L;
        if (mVar.f179a == 4294967295L) {
            j2 += (long) 8;
        }
        if (mVar3.f179a == 4294967295L) {
            j2 += (long) 8;
        }
        long j3 = j2;
        F0.l lVar = new F0.l();
        e(c2, iW3, new h(lVar, j3, mVar2, c2, mVar, mVar3));
        if (j3 > 0 && !lVar.f178a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String strX2 = c2.x(iW4);
        String str = z.f3517b;
        return new g(C0028c.q("/", false).d(strX), M0.m.L(strX, "/", false), strX2, mVar.f179a, mVar2.f179a, iW, l2, mVar3.f179a);
    }

    public static final void e(C c2, int i2, p pVar) throws IOException {
        long j2 = i2;
        while (j2 != 0) {
            if (j2 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iW = c2.w() & 65535;
            long jW = ((long) c2.w()) & 65535;
            long j3 = j2 - ((long) 4);
            if (j3 < jW) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            c2.z(jW);
            C0193i c0193i = c2.f3442b;
            long j4 = c0193i.f3482b;
            pVar.c(Integer.valueOf(iW), Long.valueOf(jW));
            long j5 = (c0193i.f3482b + jW) - j4;
            if (j5 < 0) {
                throw new IOException(F0.h.b(iW, "unsupported zip: too many bytes processed for "));
            }
            if (j5 > 0) {
                c0193i.K(j5);
            }
            j2 = j3 - jW;
        }
    }

    public static final n f(C c2, n nVar) throws IOException {
        F0.n nVar2 = new F0.n();
        nVar2.f180a = nVar != null ? nVar.f3495f : null;
        F0.n nVar3 = new F0.n();
        F0.n nVar4 = new F0.n();
        int iT = c2.t();
        if (iT != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iT));
        }
        c2.A(2L);
        short sW = c2.w();
        int i2 = sW & 65535;
        if ((sW & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i2));
        }
        c2.A(18L);
        long jW = ((long) c2.w()) & 65535;
        int iW = c2.w() & 65535;
        c2.A(jW);
        if (nVar == null) {
            c2.A(iW);
            return null;
        }
        e(c2, iW, new i(c2, nVar2, nVar3, nVar4));
        return new n(nVar.f3490a, nVar.f3491b, null, nVar.f3493d, (Long) nVar4.f180a, (Long) nVar2.f180a, (Long) nVar3.f180a);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    public static final int g(F f2, int i2) {
        int i3;
        F0.i.e(f2, "<this>");
        int i4 = i2 + 1;
        int length = f2.f3453e.length;
        int[] iArr = f2.f3454f;
        F0.i.e(iArr, "<this>");
        int i5 = length - 1;
        int i6 = 0;
        while (i6 <= i5) {
            i3 = (i6 + i5) >>> 1;
            int i7 = iArr[i3];
            if (i7 < i4) {
                i6 = i3 + 1;
            } else {
                if (i7 <= i4) {
                    if (i3 >= 0) {
                        return i3;
                    }
                    return ~i3;
                }
                i5 = i3 - 1;
            }
        }
        i3 = (-i6) - 1;
        if (i3 >= 0) {
            return i3;
        }
        return ~i3;
    }
}
