// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f2962f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.j f2963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f2964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f2965e;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        logger.getClass();
        f2962f = logger;
    }

    public r(w2.r rVar) {
        rVar.getClass();
        this.f2963c = rVar;
        q qVar = new q(rVar);
        this.f2964d = qVar;
        this.f2965e = new c(qVar);
    }

    public final void A(y.l lVar, int i3, int i4, int i5) throws IOException {
        int i6;
        if (i5 == 0) {
            o2.l("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
            return;
        }
        if ((i4 & 8) != 0) {
            byte b3 = this.f2963c.readByte();
            byte[] bArr = j2.b.f2361a;
            i6 = b3 & 255;
        } else {
            i6 = 0;
        }
        int i7 = this.f2963c.readInt() & Integer.MAX_VALUE;
        List listY = y(p.a(i3 - 4, i4, i6), i6, i4, i5);
        n nVar = (n) lVar.f5992d;
        synchronized (nVar) {
            if (nVar.A.contains(Integer.valueOf(i7))) {
                nVar.C(i7, 2);
                return;
            }
            nVar.A.add(Integer.valueOf(i7));
            nVar.f2933k.c(new l(nVar.f2927e + '[' + i7 + "] onRequest", nVar, i7, listY), 0L);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2963c.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(boolean z2, y.l lVar) throws IOException {
        int i3;
        boolean z3;
        int i4;
        Object[] array;
        boolean z4 = false;
        try {
            this.f2963c.p(9L);
            int iT = j2.b.t(this.f2963c);
            if (iT > 16384) {
                o2.l(a0.a.g("FRAME_SIZE_ERROR: ", iT));
                return false;
            }
            int i5 = this.f2963c.readByte() & 255;
            byte b3 = this.f2963c.readByte();
            int i6 = b3 & 255;
            int i7 = this.f2963c.readInt();
            int i8 = i7 & Integer.MAX_VALUE;
            Logger logger = f2962f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(f.a(true, i8, iT, i5, i6));
            }
            if (z2 && i5 != 4) {
                StringBuilder sb = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = f.f2904b;
                sb.append(i5 < strArr.length ? strArr[i5] : j2.b.i("0x%02x", Integer.valueOf(i5)));
                throw new IOException(sb.toString());
            }
            switch (i5) {
                case 0:
                    w(lVar, iT, i6, i8);
                    return true;
                case 1:
                    z(lVar, iT, i6, i8);
                    return true;
                case 2:
                    if (iT != 5) {
                        o2.l(j4.c(iT, "TYPE_PRIORITY length: ", " != 5"));
                        return false;
                    }
                    if (i8 == 0) {
                        o2.l("TYPE_PRIORITY streamId == 0");
                        return false;
                    }
                    w2.j jVar = this.f2963c;
                    jVar.readInt();
                    jVar.readByte();
                    return true;
                case 3:
                    if (iT != 4) {
                        o2.l(j4.c(iT, "TYPE_RST_STREAM length: ", " != 4"));
                        return false;
                    }
                    if (i8 == 0) {
                        o2.l("TYPE_RST_STREAM streamId == 0");
                        return false;
                    }
                    int i9 = this.f2963c.readInt();
                    int[] iArrB = g.d.b(14);
                    int length = iArrB.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            int i11 = iArrB[i10];
                            if (g.d.a(i11) == i9) {
                                i3 = i11;
                            } else {
                                i10++;
                            }
                        } else {
                            i3 = 0;
                        }
                    }
                    if (i3 == 0) {
                        o2.l(a0.a.g("TYPE_RST_STREAM unexpected error code: ", i9));
                        return false;
                    }
                    n nVar = (n) lVar.f5992d;
                    if ((i8 != 0 && (i7 & 1) == 0) == true) {
                        nVar.f2933k.c(new j(nVar.f2927e + '[' + i8 + "] onReset", nVar, i8, i3, 1), 0L);
                        return true;
                    }
                    v vVarY = nVar.y(i8);
                    if (vVarY == null) {
                        return true;
                    }
                    synchronized (vVarY) {
                        try {
                            if (i3 == 0) {
                                throw null;
                            }
                            if (vVarY.f2989m == 0) {
                                vVarY.f2989m = i3;
                                vVarY.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return true;
                case 4:
                    w2.j jVar2 = this.f2963c;
                    if (i8 != 0) {
                        o2.l("TYPE_SETTINGS streamId != 0");
                        return false;
                    }
                    if ((b3 & 1) == 0) {
                        if (iT % 6 != 0) {
                            o2.l(a0.a.g("TYPE_SETTINGS length % 6 != 0: ", iT));
                            return false;
                        }
                        a0 a0Var = new a0();
                        s1.a aVarM = y.f.m(y.f.o(0, iT), 6);
                        int i12 = aVarM.f3229c;
                        int i13 = aVarM.f3230d;
                        int i14 = aVarM.f3231e;
                        if ((i14 > 0 && i12 <= i13) || (i14 < 0 && i13 <= i12)) {
                            while (true) {
                                short s3 = jVar2.readShort();
                                byte[] bArr = j2.b.f2361a;
                                int i15 = s3 & 65535;
                                int i16 = jVar2.readInt();
                                if (i15 == 2) {
                                    z3 = z4;
                                    if (i16 != 0 && i16 != 1) {
                                        o2.l("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                        return z3;
                                    }
                                } else if (i15 == 3) {
                                    z3 = z4;
                                    i15 = 4;
                                } else if (i15 == 4) {
                                    z3 = z4;
                                    if (i16 < 0) {
                                        o2.l("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        return z3;
                                    }
                                    i15 = 7;
                                } else if (i15 != 5) {
                                    z3 = z4;
                                } else {
                                    z3 = z4;
                                    if (i16 < 16384 || i16 > 16777215) {
                                        o2.l(a0.a.g("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", i16));
                                        return z3;
                                    }
                                }
                                a0Var.b(i15, i16);
                                if (i12 != i13) {
                                    i12 += i14;
                                    z4 = z3;
                                }
                            }
                        }
                        n nVar2 = (n) lVar.f5992d;
                        nVar2.f2932j.c(new i(nVar2.f2927e + " applyAndAckSettings", lVar, a0Var, 2), 0L);
                        return true;
                    }
                    if (iT != 0) {
                        o2.l("FRAME_SIZE_ERROR ack frame should be empty!");
                        return false;
                    }
                    break;
                case 5:
                    A(lVar, iT, i6, i8);
                    return true;
                case 6:
                    if (iT != 8) {
                        o2.l(a0.a.g("TYPE_PING length != 8: ", iT));
                        return false;
                    }
                    if (i8 != 0) {
                        o2.l("TYPE_PING streamId != 0");
                        return false;
                    }
                    int i17 = this.f2963c.readInt();
                    int i18 = this.f2963c.readInt();
                    Object[] objArr = (b3 & 1) != 0 ? 1 : 0;
                    n nVar3 = (n) lVar.f5992d;
                    if (objArr == 0) {
                        nVar3.f2932j.c(new j(((n) lVar.f5992d).f2927e + " ping", (n) lVar.f5992d, i17, i18, 0), 0L);
                        return true;
                    }
                    synchronized (nVar3) {
                        try {
                            if (i17 == 1) {
                                nVar3.n++;
                            } else if (i17 == 2) {
                                nVar3.f2937p++;
                            } else if (i17 == 3) {
                                nVar3.notifyAll();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return true;
                case 7:
                    if (iT < 8) {
                        o2.l(a0.a.g("TYPE_GOAWAY length < 8: ", iT));
                        return false;
                    }
                    if (i8 != 0) {
                        o2.l("TYPE_GOAWAY streamId != 0");
                        return false;
                    }
                    int i19 = this.f2963c.readInt();
                    int i20 = this.f2963c.readInt();
                    int i21 = iT - 8;
                    int[] iArrB2 = g.d.b(14);
                    int length2 = iArrB2.length;
                    int i22 = 0;
                    while (true) {
                        if (i22 < length2) {
                            i4 = iArrB2[i22];
                            if (g.d.a(i4) != i20) {
                                i22++;
                            }
                        } else {
                            i4 = 0;
                        }
                    }
                    if (i4 == 0) {
                        o2.l(a0.a.g("TYPE_GOAWAY unexpected error code: ", i20));
                        return false;
                    }
                    w2.k kVarE = w2.k.f5778f;
                    if (i21 > 0) {
                        kVarE = this.f2963c.e(i21);
                    }
                    kVarE.getClass();
                    kVarE.c();
                    n nVar4 = (n) lVar.f5992d;
                    synchronized (nVar4) {
                        array = nVar4.f2926d.values().toArray(new v[0]);
                        nVar4.f2930h = true;
                    }
                    for (v vVar : (v[]) array) {
                        if (vVar.f2977a > i19 && vVar.g()) {
                            synchronized (vVar) {
                                if (vVar.f2989m == 0) {
                                    vVar.f2989m = 8;
                                    vVar.notifyAll();
                                }
                                break;
                            }
                            ((n) lVar.f5992d).y(vVar.f2977a);
                        }
                    }
                    break;
                    break;
                case 8:
                    if (iT != 4) {
                        o2.l(a0.a.g("TYPE_WINDOW_UPDATE length !=4: ", iT));
                        return false;
                    }
                    long j3 = 2147483647L & ((long) this.f2963c.readInt());
                    if (j3 == 0) {
                        o2.l("windowSizeIncrement was 0");
                        return false;
                    }
                    n nVar5 = (n) lVar.f5992d;
                    if (i8 == 0) {
                        synchronized (nVar5) {
                            nVar5.f2944w += j3;
                            nVar5.notifyAll();
                        }
                        return true;
                    }
                    v vVarW = nVar5.w(i8);
                    if (vVarW != null) {
                        synchronized (vVarW) {
                            vVarW.f2982f += j3;
                            if (j3 > 0) {
                                vVarW.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    break;
                default:
                    this.f2963c.skip(iT);
                    return true;
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void w(y.l lVar, int i3, int i4, int i5) throws IOException {
        int i6;
        boolean z2;
        boolean z3;
        if (i5 == 0) {
            o2.l("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        }
        boolean z4 = (i4 & 1) != 0;
        if ((i4 & 32) != 0) {
            o2.l("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            return;
        }
        if ((i4 & 8) != 0) {
            byte b3 = this.f2963c.readByte();
            byte[] bArr = j2.b.f2361a;
            i6 = b3 & 255;
        } else {
            i6 = 0;
        }
        int iA = p.a(i3, i4, i6);
        w2.j jVar = this.f2963c;
        jVar.getClass();
        n nVar = (n) lVar.f5992d;
        if (i5 != 0 && (i5 & 1) == 0) {
            w2.h hVar = new w2.h();
            long j3 = iA;
            jVar.p(j3);
            jVar.f(j3, hVar);
            nVar.f2933k.c(new k(nVar.f2927e + '[' + i5 + "] onData", nVar, i5, hVar, iA, z4), 0L);
        } else {
            v vVarW = nVar.w(i5);
            if (vVarW == null) {
                ((n) lVar.f5992d).C(i5, 2);
                long j4 = iA;
                ((n) lVar.f5992d).A(j4);
                jVar.skip(j4);
            } else {
                byte[] bArr2 = j2.b.f2361a;
                t tVar = vVarW.f2985i;
                long j5 = iA;
                tVar.getClass();
                long j6 = j5;
                while (true) {
                    if (j6 <= 0) {
                        tVar.d(j5);
                        break;
                    }
                    synchronized (tVar.f2975h) {
                        z2 = tVar.f2971d;
                        z3 = tVar.f2973f.f5777d + j6 > tVar.f2970c;
                    }
                    if (z3) {
                        jVar.skip(j6);
                        tVar.f2975h.e(4);
                        break;
                    }
                    if (z2) {
                        jVar.skip(j6);
                        break;
                    }
                    long jF = jVar.f(j6, tVar.f2972e);
                    if (jF == -1) {
                        throw new EOFException();
                    }
                    j6 -= jF;
                    v vVar = tVar.f2975h;
                    synchronized (vVar) {
                        try {
                            if (tVar.f2974g) {
                                w2.h hVar2 = tVar.f2972e;
                                hVar2.skip(hVar2.f5777d);
                            } else {
                                w2.h hVar3 = tVar.f2973f;
                                boolean z5 = hVar3.f5777d == 0;
                                hVar3.I(tVar.f2972e);
                                if (z5) {
                                    vVar.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                if (z4) {
                    vVarW.i(j2.b.f2362b, true);
                }
            }
        }
        this.f2963c.skip(i6);
    }

    public final List y(int i3, int i4, int i5, int i6) throws IOException {
        q qVar = this.f2964d;
        qVar.f2960g = i3;
        qVar.f2957d = i3;
        qVar.f2961h = i4;
        qVar.f2958e = i5;
        qVar.f2959f = i6;
        c cVar = this.f2965e;
        w2.r rVar = cVar.f2888c;
        ArrayList arrayList = cVar.f2887b;
        while (!rVar.d()) {
            byte b3 = rVar.readByte();
            byte[] bArr = j2.b.f2361a;
            int i7 = b3 & 255;
            if (i7 == 128) {
                o2.l("index == 0");
                return null;
            }
            if ((b3 & 128) == 128) {
                int iE = cVar.e(i7, 127);
                int i8 = iE - 1;
                if (i8 >= 0) {
                    b[] bVarArr = e.f2901a;
                    if (i8 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i8]);
                    }
                }
                int length = cVar.f2890e + 1 + (i8 - e.f2901a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.f2889d;
                    if (length < bVarArr2.length) {
                        b bVar = bVarArr2[length];
                        bVar.getClass();
                        arrayList.add(bVar);
                    }
                }
                o2.l(a0.a.g("Header index too large ", iE));
                return null;
            }
            if (i7 == 64) {
                b[] bVarArr3 = e.f2901a;
                w2.k kVarD = cVar.d();
                e.a(kVarD);
                cVar.c(new b(kVarD, cVar.d()));
            } else if ((b3 & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i7, 63) - 1), cVar.d()));
            } else if ((b3 & 32) == 32) {
                int iE2 = cVar.e(i7, 31);
                cVar.f2886a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    b2.a.k("Invalid dynamic table size update ", cVar.f2886a);
                    return null;
                }
                int i9 = cVar.f2892g;
                if (iE2 < i9) {
                    if (iE2 == 0) {
                        b[] bVarArr4 = cVar.f2889d;
                        Arrays.fill(bVarArr4, 0, bVarArr4.length, (Object) null);
                        cVar.f2890e = cVar.f2889d.length - 1;
                        cVar.f2891f = 0;
                        cVar.f2892g = 0;
                    } else {
                        cVar.a(i9 - iE2);
                    }
                }
            } else if (i7 == 16 || i7 == 0) {
                b[] bVarArr5 = e.f2901a;
                w2.k kVarD2 = cVar.d();
                e.a(kVarD2);
                arrayList.add(new b(kVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i7, 15) - 1), cVar.d()));
            }
        }
        List listE = i1.i.E(arrayList);
        arrayList.clear();
        return listE;
    }

    public final void z(y.l lVar, int i3, int i4, int i5) throws IOException {
        int i6;
        if (i5 == 0) {
            o2.l("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z2 = false;
        boolean z3 = (i4 & 1) != 0;
        if ((i4 & 8) != 0) {
            byte b3 = this.f2963c.readByte();
            byte[] bArr = j2.b.f2361a;
            i6 = b3 & 255;
        } else {
            i6 = 0;
        }
        if ((i4 & 32) != 0) {
            w2.j jVar = this.f2963c;
            jVar.readInt();
            jVar.readByte();
            byte[] bArr2 = j2.b.f2361a;
            i3 -= 5;
        }
        List listY = y(p.a(i3, i4, i6), i6, i4, i5);
        n nVar = (n) lVar.f5992d;
        if (i5 != 0 && (i5 & 1) == 0) {
            z2 = true;
        }
        if (z2) {
            nVar.f2933k.c(new l(nVar.f2927e + '[' + i5 + "] onHeaders", nVar, i5, listY, z3), 0L);
            return;
        }
        synchronized (nVar) {
            v vVarW = nVar.w(i5);
            if (vVarW != null) {
                vVarW.i(j2.b.v(listY), z3);
                return;
            }
            if (nVar.f2930h) {
                return;
            }
            if (i5 <= nVar.f2928f) {
                return;
            }
            if (i5 % 2 == nVar.f2929g % 2) {
                return;
            }
            v vVar = new v(i5, nVar, false, z3, j2.b.v(listY));
            nVar.f2928f = i5;
            nVar.f2926d.put(Integer.valueOf(i5), vVar);
            nVar.f2931i.e().c(new i(nVar.f2927e + '[' + i5 + "] onStream", nVar, vVar, 1), 0L);
        }
    }
}
