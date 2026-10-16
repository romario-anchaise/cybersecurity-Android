// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k1.C0193i;
import k1.C0196l;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f2357d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1.C f2358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f2359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0110c f2360c;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        F0.i.d(logger, "getLogger(Http2::class.java.name)");
        f2357d = logger;
    }

    public s(k1.C c2) {
        F0.i.e(c2, "source");
        this.f2358a = c2;
        r rVar = new r(c2);
        this.f2359b = rVar;
        this.f2360c = new C0110c(rVar);
    }

    public final boolean a(boolean z2, k kVar) throws IOException {
        int i2;
        int iR;
        int i3;
        Object[] array;
        F0.i.e(kVar, "handler");
        int i4 = 0;
        try {
            this.f2358a.z(9L);
            int iS = Y0.b.s(this.f2358a);
            if (iS > 16384) {
                throw new IOException(F0.h.b(iS, "FRAME_SIZE_ERROR: "));
            }
            int iJ = this.f2358a.j() & 255;
            byte bJ = this.f2358a.j();
            int i5 = bJ & 255;
            int iR2 = this.f2358a.r();
            int i6 = Integer.MAX_VALUE & iR2;
            Logger logger = f2357d;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(f.a(i6, iS, iJ, i5, true));
            }
            if (z2 && iJ != 4) {
                StringBuilder sb = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = f.f2301b;
                sb.append(iJ < strArr.length ? strArr[iJ] : Y0.b.i("0x%02x", Integer.valueOf(iJ)));
                throw new IOException(sb.toString());
            }
            switch (iJ) {
                case 0:
                    f(kVar, iS, i5, i6);
                    return true;
                case 1:
                    n(kVar, iS, i5, i6);
                    return true;
                case 2:
                    if (iS != 5) {
                        throw new IOException("TYPE_PRIORITY length: " + iS + " != 5");
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    k1.C c2 = this.f2358a;
                    c2.r();
                    c2.j();
                    return true;
                case 3:
                    if (iS != 4) {
                        throw new IOException("TYPE_RST_STREAM length: " + iS + " != 4");
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int iR3 = this.f2358a.r();
                    int[] iArrC = androidx.fragment.app.y.c(14);
                    int length = iArrC.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 < length) {
                            i2 = iArrC[i7];
                            if (androidx.fragment.app.y.b(i2) != iR3) {
                                i7++;
                            }
                        } else {
                            i2 = 0;
                        }
                    }
                    if (i2 == 0) {
                        throw new IOException(F0.h.b(iR3, "TYPE_RST_STREAM unexpected error code: "));
                    }
                    o oVar = kVar.f2311b;
                    oVar.getClass();
                    if (i6 != 0 && (iR2 & 1) == 0) {
                        i4 = 1;
                    }
                    if (i4 != 0) {
                        oVar.f2327i.c(new j(oVar.f2322c + '[' + i6 + "] onReset", oVar, i6, i2, 1), 0L);
                    } else {
                        w wVarJ = oVar.j(i6);
                        if (wVarJ != null) {
                            wVarJ.j(i2);
                        }
                    }
                    return true;
                case 4:
                    if (i6 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((bJ & 1) == 0) {
                        if (iS % 6 != 0) {
                            throw new IOException(F0.h.b(iS, "TYPE_SETTINGS length % 6 != 0: "));
                        }
                        B b2 = new B();
                        J0.a aVarB = f1.d.B(f1.d.F(0, iS), 6);
                        int i8 = aVarB.f278a;
                        int i9 = aVarB.f279b;
                        int i10 = aVarB.f280c;
                        if ((i10 > 0 && i8 <= i9) || (i10 < 0 && i9 <= i8)) {
                            while (true) {
                                k1.C c3 = this.f2358a;
                                short sV = c3.v();
                                byte[] bArr = Y0.b.f1119a;
                                int i11 = sV & 65535;
                                iR = c3.r();
                                if (i11 != 2) {
                                    if (i11 == 3) {
                                        i11 = 4;
                                    } else if (i11 == 4) {
                                        if (iR < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                        i11 = 7;
                                    } else if (i11 == 5 && (iR < 16384 || iR > 16777215)) {
                                    }
                                } else if (iR != 0 && iR != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                b2.c(i11, iR);
                                if (i8 != i9) {
                                    i8 += i10;
                                }
                            }
                            throw new IOException(F0.h.b(iR, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                        }
                        o oVar2 = kVar.f2311b;
                        oVar2.f2326h.c(new i(oVar2.f2322c + " applyAndAckSettings", kVar, b2, 2), 0L);
                    } else if (iS != 0) {
                        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                    }
                    return true;
                case 5:
                    r(kVar, iS, i5, i6);
                    return true;
                case 6:
                    if (iS != 8) {
                        throw new IOException(F0.h.b(iS, "TYPE_PING length != 8: "));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    int iR4 = this.f2358a.r();
                    int iR5 = this.f2358a.r();
                    if ((bJ & 1) != 0) {
                        o oVar3 = kVar.f2311b;
                        synchronized (oVar3) {
                            try {
                                if (iR4 == 1) {
                                    oVar3.f2330l++;
                                } else if (iR4 == 2) {
                                    oVar3.f2332n++;
                                } else if (iR4 == 3) {
                                    oVar3.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        kVar.f2311b.f2326h.c(new j(kVar.f2311b.f2322c + " ping", kVar.f2311b, iR4, iR5, 0), 0L);
                    }
                    return true;
                case 7:
                    if (iS < 8) {
                        throw new IOException(F0.h.b(iS, "TYPE_GOAWAY length < 8: "));
                    }
                    if (i6 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int iR6 = this.f2358a.r();
                    int iR7 = this.f2358a.r();
                    int i12 = iS - 8;
                    int[] iArrC2 = androidx.fragment.app.y.c(14);
                    int length2 = iArrC2.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 < length2) {
                            i3 = iArrC2[i13];
                            if (androidx.fragment.app.y.b(i3) != iR7) {
                                i13++;
                            }
                        } else {
                            i3 = 0;
                        }
                    }
                    if (i3 == 0) {
                        throw new IOException(F0.h.b(iR7, "TYPE_GOAWAY unexpected error code: "));
                    }
                    C0196l c0196lN = C0196l.f3483d;
                    if (i12 > 0) {
                        c0196lN = this.f2358a.n(i12);
                    }
                    F0.i.e(c0196lN, "debugData");
                    c0196lN.c();
                    o oVar4 = kVar.f2311b;
                    synchronized (oVar4) {
                        array = oVar4.f2321b.values().toArray(new w[0]);
                        oVar4.f2325f = true;
                    }
                    w[] wVarArr = (w[]) array;
                    int length3 = wVarArr.length;
                    while (i4 < length3) {
                        w wVar = wVarArr[i4];
                        if (wVar.f2372a > iR6 && wVar.g()) {
                            wVar.j(8);
                            kVar.f2311b.j(wVar.f2372a);
                        }
                        i4++;
                    }
                    return true;
                case 8:
                    if (iS != 4) {
                        throw new IOException(F0.h.b(iS, "TYPE_WINDOW_UPDATE length !=4: "));
                    }
                    long jR = ((long) this.f2358a.r()) & 2147483647L;
                    if (jR == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    if (i6 != 0) {
                        w wVarF = kVar.f2311b.f(i6);
                        if (wVarF != null) {
                            synchronized (wVarF) {
                                wVarF.f2377f += jR;
                                if (jR > 0) {
                                    wVarF.notifyAll();
                                }
                            }
                        }
                        break;
                    } else {
                        o oVar5 = kVar.f2311b;
                        synchronized (oVar5) {
                            oVar5.f2339u += jR;
                            oVar5.notifyAll();
                        }
                    }
                    return true;
                default:
                    this.f2358a.A(iS);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2358a.close();
    }

    public final void f(k kVar, int i2, int i3, int i4) throws IOException {
        int i5;
        w wVar;
        boolean z2;
        boolean z3;
        if (i4 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z4 = (i3 & 1) != 0;
        if ((i3 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        if ((i3 & 8) != 0) {
            byte bJ = this.f2358a.j();
            byte[] bArr = Y0.b.f1119a;
            i5 = bJ & 255;
        } else {
            i5 = 0;
        }
        int iA = q.a(i2, i3, i5);
        k1.C c2 = this.f2358a;
        kVar.getClass();
        F0.i.e(c2, "source");
        kVar.f2311b.getClass();
        long j2 = 0;
        if (i4 != 0 && (i4 & 1) == 0) {
            o oVar = kVar.f2311b;
            oVar.getClass();
            C0193i c0193i = new C0193i();
            long j3 = iA;
            c2.z(j3);
            c2.m(c0193i, j3);
            oVar.f2327i.c(new l(oVar.f2322c + '[' + i4 + "] onData", oVar, i4, c0193i, iA, z4), 0L);
        } else {
            w wVarF = kVar.f2311b.f(i4);
            if (wVarF == null) {
                kVar.f2311b.u(i4, 2);
                long j4 = iA;
                kVar.f2311b.r(j4);
                c2.A(j4);
            } else {
                byte[] bArr2 = Y0.b.f1119a;
                u uVar = wVarF.f2379i;
                long j5 = iA;
                uVar.getClass();
                long j6 = j5;
                while (true) {
                    if (j6 <= j2) {
                        wVar = wVarF;
                        uVar.a(j5);
                        break;
                    }
                    synchronized (uVar.f2370f) {
                        z2 = uVar.f2366b;
                        wVar = wVarF;
                        z3 = uVar.f2368d.f3482b + j6 > uVar.f2365a;
                    }
                    if (z3) {
                        c2.A(j6);
                        uVar.f2370f.e(4);
                        break;
                    }
                    if (z2) {
                        c2.A(j6);
                        break;
                    }
                    long jM = c2.m(uVar.f2367c, j6);
                    if (jM == -1) {
                        throw new EOFException();
                    }
                    j6 -= jM;
                    w wVar2 = uVar.f2370f;
                    synchronized (wVar2) {
                        try {
                            if (uVar.f2369e) {
                                uVar.f2367c.t();
                                j2 = 0;
                            } else {
                                C0193i c0193i2 = uVar.f2368d;
                                j2 = 0;
                                boolean z5 = c0193i2.f3482b == 0;
                                c0193i2.P(uVar.f2367c);
                                if (z5) {
                                    wVar2.notifyAll();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    wVarF = wVar;
                }
                if (z4) {
                    wVar.i(Y0.b.f1120b, true);
                }
            }
        }
        this.f2358a.A(i5);
    }

    public final List j(int i2, int i3, int i4, int i5) throws IOException {
        r rVar = this.f2359b;
        rVar.f2355e = i2;
        rVar.f2352b = i2;
        rVar.f2356f = i3;
        rVar.f2353c = i4;
        rVar.f2354d = i5;
        while (true) {
            C0110c c0110c = this.f2360c;
            k1.C c2 = c0110c.f2286c;
            boolean zA = c2.a();
            ArrayList arrayList = c0110c.f2285b;
            if (zA) {
                List listB = p036u0.f.B(arrayList);
                arrayList.clear();
                return listB;
            }
            byte bJ = c2.j();
            byte[] bArr = Y0.b.f1119a;
            int i6 = bJ & 255;
            if (i6 == 128) {
                throw new IOException("index == 0");
            }
            if ((bJ & 128) == 128) {
                int iE = c0110c.e(i6, 127);
                int i7 = iE - 1;
                if (i7 >= 0) {
                    C0109b[] c0109bArr = e.f2298a;
                    if (i7 <= c0109bArr.length - 1) {
                        arrayList.add(c0109bArr[i7]);
                    }
                }
                int length = c0110c.f2288e + 1 + (i7 - e.f2298a.length);
                if (length >= 0) {
                    C0109b[] c0109bArr2 = c0110c.f2287d;
                    if (length < c0109bArr2.length) {
                        C0109b c0109b = c0109bArr2[length];
                        F0.i.b(c0109b);
                        arrayList.add(c0109b);
                    }
                }
                throw new IOException(F0.h.b(iE, "Header index too large "));
            }
            if (i6 == 64) {
                C0109b[] c0109bArr3 = e.f2298a;
                C0196l c0196lD = c0110c.d();
                e.a(c0196lD);
                c0110c.c(new C0109b(c0196lD, c0110c.d()));
            } else if ((bJ & 64) == 64) {
                c0110c.c(new C0109b(c0110c.b(c0110c.e(i6, 63) - 1), c0110c.d()));
            } else if ((bJ & 32) == 32) {
                int iE2 = c0110c.e(i6, 31);
                c0110c.f2284a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + c0110c.f2284a);
                }
                int i8 = c0110c.g;
                if (iE2 < i8) {
                    if (iE2 == 0) {
                        C0109b[] c0109bArr4 = c0110c.f2287d;
                        p036u0.e.w(c0109bArr4, 0, c0109bArr4.length);
                        c0110c.f2288e = c0110c.f2287d.length - 1;
                        c0110c.f2289f = 0;
                        c0110c.g = 0;
                    } else {
                        c0110c.a(i8 - iE2);
                    }
                }
            } else if (i6 == 16 || i6 == 0) {
                C0109b[] c0109bArr5 = e.f2298a;
                C0196l c0196lD2 = c0110c.d();
                e.a(c0196lD2);
                arrayList.add(new C0109b(c0196lD2, c0110c.d()));
            } else {
                arrayList.add(new C0109b(c0110c.b(c0110c.e(i6, 15) - 1), c0110c.d()));
            }
        }
    }

    public final void n(k kVar, int i2, int i3, int i4) throws IOException {
        int i5;
        if (i4 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z2 = false;
        boolean z3 = (i3 & 1) != 0;
        if ((i3 & 8) != 0) {
            byte bJ = this.f2358a.j();
            byte[] bArr = Y0.b.f1119a;
            i5 = bJ & 255;
        } else {
            i5 = 0;
        }
        if ((i3 & 32) != 0) {
            k1.C c2 = this.f2358a;
            c2.r();
            c2.j();
            byte[] bArr2 = Y0.b.f1119a;
            kVar.getClass();
            i2 -= 5;
        }
        List listJ = j(q.a(i2, i3, i5), i5, i3, i4);
        kVar.getClass();
        kVar.f2311b.getClass();
        if (i4 != 0 && (i4 & 1) == 0) {
            z2 = true;
        }
        if (z2) {
            o oVar = kVar.f2311b;
            oVar.getClass();
            oVar.f2327i.c(new m(oVar.f2322c + '[' + i4 + "] onHeaders", oVar, i4, listJ, z3), 0L);
            return;
        }
        o oVar2 = kVar.f2311b;
        synchronized (oVar2) {
            w wVarF = oVar2.f(i4);
            if (wVarF != null) {
                wVarF.i(Y0.b.u(listJ), z3);
                return;
            }
            if (oVar2.f2325f) {
                return;
            }
            if (i4 <= oVar2.f2323d) {
                return;
            }
            if (i4 % 2 == oVar2.f2324e % 2) {
                return;
            }
            w wVar = new w(i4, oVar2, false, z3, Y0.b.u(listJ));
            oVar2.f2323d = i4;
            oVar2.f2321b.put(Integer.valueOf(i4), wVar);
            oVar2.g.e().c(new i(oVar2.f2322c + '[' + i4 + "] onStream", oVar2, wVar, 1), 0L);
        }
    }

    public final void r(k kVar, int i2, int i3, int i4) throws IOException {
        int i5;
        if (i4 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i3 & 8) != 0) {
            byte bJ = this.f2358a.j();
            byte[] bArr = Y0.b.f1119a;
            i5 = bJ & 255;
        } else {
            i5 = 0;
        }
        int iR = this.f2358a.r() & Integer.MAX_VALUE;
        List listJ = j(q.a(i2 - 4, i3, i5), i5, i3, i4);
        kVar.getClass();
        o oVar = kVar.f2311b;
        oVar.getClass();
        synchronized (oVar) {
            if (oVar.f2343y.contains(Integer.valueOf(iR))) {
                oVar.u(iR, 2);
                return;
            }
            oVar.f2343y.add(Integer.valueOf(iR));
            oVar.f2327i.c(new m(oVar.f2322c + '[' + iR + "] onRequest", oVar, iR, listJ), 0L);
        }
    }
}
