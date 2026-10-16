// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import e2.n1;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import w1.ee;
import w1.m0;
import w1.o2;
import w1.vd;
import w1.y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f1471e;

    public /* synthetic */ j(Object obj, Object obj2, int i3) {
        this.f1469c = i3;
        this.f1471e = obj;
        this.f1470d = obj2;
    }

    private final void a() {
        y.o oVar;
        q.h hVar = ((x.a) this.f1471e).f5819a.f3060f;
        String str = (String) this.f1470d;
        synchronized (hVar.f3035l) {
            try {
                q.u uVar = (q.u) hVar.f3029f.get(str);
                if (uVar == null) {
                    uVar = (q.u) hVar.f3030g.get(str);
                }
                oVar = uVar != null ? uVar.f3089f : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (oVar == null || !oVar.c()) {
            return;
        }
        synchronized (((x.a) this.f1471e).f5821c) {
            ((x.a) this.f1471e).f5824f.put(m0.a.h(oVar), oVar);
            ((x.a) this.f1471e).f5825g.add(oVar);
            x.a aVar = (x.a) this.f1471e;
            aVar.f5826h.r(aVar.f5825g);
        }
    }

    private final void b() {
        try {
            ((Runnable) this.f1471e).run();
            synchronized (((z.l) this.f1470d).f6250f) {
                ((z.l) this.f1470d).a();
            }
        } catch (Throwable th) {
            synchronized (((z.l) this.f1470d).f6250f) {
                ((z.l) this.f1470d).a();
                throw th;
            }
        }
    }

    private final void c() {
        z0.g gVar = ((z0.f) this.f1471e).f6294a;
        gVar.a("responseHeaders", (TreeMap) this.f1470d);
        gVar.f6117k = 2;
        gVar.f6108b = true;
        gVar.a("open", new Object[0]);
    }

    private final void d() {
        z0.g gVar = ((z0.f) this.f1471e).f6294a;
        String str = (String) this.f1470d;
        Logger logger = z0.g.f6295o;
        gVar.a("packet", a1.f.a(str));
    }

    private final void e() {
        z0.g gVar = ((z0.f) this.f1471e).f6294a;
        byte[] bArrJ = ((w2.k) this.f1470d).j();
        Logger logger = z0.g.f6295o;
        a1.c cVar = a1.f.f43a;
        gVar.a("packet", new a1.b(bArrJ, "message"));
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01a1  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        h0.e eVar;
        Exception exc;
        String str;
        String str2;
        String str3;
        String[] strArr;
        a1.b bVarA;
        int i3;
        exc = null;
        Exception exc2 = null;
        exc = null;
        Exception exc3 = null;
        int i4 = 1;
        int i5 = 0;
        switch (this.f1469c) {
            case 0:
                e0.b bVar = (e0.b) this.f1470d;
                k kVar = (k) this.f1471e;
                com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) kVar.f1473d;
                h hVar = (h) ((c) kVar.f1477h).f1447j.get((a) kVar.f1474e);
                if (hVar == null) {
                    return;
                }
                if (bVar.f659d != 0) {
                    hVar.o(bVar, null);
                    return;
                }
                kVar.f1472c = true;
                if (aVar.l()) {
                    if (!kVar.f1472c || (eVar = (h0.e) kVar.f1475f) == null) {
                        return;
                    }
                    aVar.f(eVar, (Set) kVar.f1476g);
                    return;
                }
                try {
                    aVar.f(null, aVar.l() ? aVar.f498w : Collections.EMPTY_SET);
                    return;
                } catch (SecurityException e3) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e3);
                    aVar.b("Failed to get service from broker.");
                    hVar.o(new e0.b(10, null, null), null);
                    return;
                }
            case 1:
                if (((q.u) this.f1471e).f3100r.f32c instanceof a0.b) {
                    return;
                }
                try {
                    ((a0.j) this.f1470d).get();
                    p.m.d().a(q.u.f3085t, "Starting work for " + ((q.u) this.f1471e).f3089f.f6001c);
                    q.u uVar = (q.u) this.f1471e;
                    uVar.f3100r.k(uVar.f3090g.e());
                    return;
                } catch (Throwable th) {
                    ((q.u) this.f1471e).f3100r.j(th);
                    return;
                }
            case 2:
                String str4 = (String) this.f1470d;
                q.u uVar2 = (q.u) this.f1471e;
                y.o oVar = uVar2.f3089f;
                try {
                    p.k kVar2 = (p.k) uVar2.f3100r.get();
                    if (kVar2 == null) {
                        p.m.d().b(q.u.f3085t, oVar.f6001c + " returned a null result. Treating it as a failure.");
                    } else {
                        p.m.d().a(q.u.f3085t, oVar.f6001c + " returned a " + kVar2 + ".");
                        uVar2.f3092i = kVar2;
                    }
                    break;
                } catch (CancellationException e4) {
                    p.m mVarD = p.m.d();
                    String str5 = q.u.f3085t;
                    String str6 = str4 + " was cancelled";
                    if (mVarD.f2856a <= 4) {
                        Log.i(str5, str6, e4);
                    }
                } catch (InterruptedException | ExecutionException e5) {
                    p.m.d().c(q.u.f3085t, str4 + " failed because it threw an exception/error", e5);
                } finally {
                    uVar2.b();
                }
                return;
            case 3:
                p.m mVarD2 = p.m.d();
                String str7 = r.a.f3158d;
                StringBuilder sb = new StringBuilder("Scheduling work ");
                y.o oVar2 = (y.o) this.f1470d;
                sb.append(oVar2.f5999a);
                mVarD2.a(str7, sb.toString());
                ((r.a) this.f1471e).f3159a.e(oVar2);
                return;
            case 4:
                synchronized (((u0.d) this.f1471e).f3254c) {
                    y.c cVar = (y.c) ((u0.d) this.f1471e).f3255d;
                    ((Map) ((y.e) cVar.f5973e).f5977d).remove((u0.b) cVar.f5972d);
                    break;
                }
                return;
            case 5:
                synchronized (((u0.d) this.f1471e).f3254c) {
                    d0.d dVar = (d0.d) ((u0.d) this.f1471e).f3255d;
                    u0.e eVar2 = (u0.e) this.f1470d;
                    synchronized (eVar2.f3256a) {
                        exc = eVar2.f3260e;
                        break;
                    }
                    h0.o.c(exc);
                    dVar.b(exc);
                }
                return;
            case 6:
                w0.k kVar3 = (w0.k) this.f1471e;
                URI uri = kVar3.f3401i;
                LinkedList linkedList = kVar3.f3403k;
                Logger logger = w0.k.f3393r;
                Level level = Level.FINE;
                if (logger.isLoggable(level)) {
                    int i6 = kVar3.f3408q;
                    if (i6 == 1) {
                        str = "CLOSED";
                    } else if (i6 != 2) {
                        str = i6 != 3 ? "null" : "OPEN";
                    } else {
                        str = "OPENING";
                    }
                    logger.fine("readyState ".concat(str));
                }
                int i7 = kVar3.f3408q;
                if (i7 == 3 || i7 == 2) {
                    return;
                }
                if (logger.isLoggable(level)) {
                    logger.fine("opening " + uri);
                }
                w0.j jVar = new w0.j(uri, kVar3.f3404l);
                kVar3.f3405m = jVar;
                kVar3.f3408q = 2;
                int i8 = 0;
                kVar3.f3395c = false;
                jVar.c("transport", new w0.d(kVar3, i8));
                w0.e eVar3 = new w0.e(this, kVar3, i8);
                jVar.c("open", eVar3);
                w0.l lVar = new w0.l(jVar, "open", eVar3);
                w0.e eVar4 = new w0.e(this, kVar3, 1);
                jVar.c("error", eVar4);
                w0.l lVar2 = new w0.l(jVar, "error", eVar4);
                long j3 = kVar3.f3400h;
                w0.f fVar = new w0.f(j3, lVar, jVar);
                if (j3 == 0) {
                    f1.b.a(fVar);
                    return;
                }
                if (j3 > 0) {
                    logger.fine(String.format("connection attempt will timeout after %d", Long.valueOf(j3)));
                    Timer timer = new Timer();
                    int i9 = 0;
                    timer.schedule(new w0.g(i9, fVar), j3);
                    linkedList.add(new w0.h(timer, i9));
                }
                linkedList.add(lVar);
                linkedList.add(lVar2);
                w0.j jVar2 = kVar3.f3405m;
                jVar2.getClass();
                f1.b.a(new y0.e(jVar2, 5));
                return;
            case 7:
                Object[] objArr = (Object[]) this.f1470d;
                w0.r rVar = (w0.r) this.f1471e;
                boolean[] zArr = rVar.f3421a;
                if (zArr[0]) {
                    return;
                }
                zArr[0] = true;
                Logger logger2 = w0.s.f3424m;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(String.format("sending ack %s", objArr.length != 0 ? objArr : null));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : objArr) {
                    jSONArray.put(obj);
                }
                e1.d dVar2 = new e1.d(3, jSONArray);
                dVar2.f695b = rVar.f3422b;
                rVar.f3423c.l(dVar2);
                return;
            case 8:
                m0 m0Var = (m0) this.f1470d;
                while (true) {
                    try {
                        m0Var.getClass();
                        if (Debug.isDebuggerConnected()) {
                            str2 = "debugger";
                        } else {
                            try {
                                if (y0.d(m0Var)) {
                                    str2 = "frida-maps";
                                } else {
                                    try {
                                        m0Var.getClass();
                                        str2 = m0.A() != 0 ? "traced" : null;
                                    } catch (Throwable unused) {
                                    }
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                    if (str2 != null) {
                        y0.b(str2, m0Var, (m0) this.f1471e);
                        return;
                    } else {
                        try {
                            Thread.sleep(((long) (Math.random() * 1500.0d)) + 1500);
                        } catch (Throwable unused4) {
                            return;
                        }
                    }
                    return;
                }
            case 9:
                y.e eVar5 = (y.e) this.f1470d;
                if (((h2.i) eVar5.f5976c).a(new a2.h(eVar5, this, 23))) {
                    ((Runnable) this.f1471e).run();
                    return;
                }
                return;
            case 10:
                synchronized (((ee) this.f1471e).f3928c) {
                    ee eeVar = (ee) this.f1471e;
                    if (eeVar.f3938m == this && !eeVar.f3939o) {
                        vd vdVar = eeVar.f3937l;
                        vd vdVar2 = (vd) this.f1470d;
                        if (vdVar == vdVar2) {
                            eeVar.f3938m = null;
                            eeVar.z(vdVar2);
                            return;
                        }
                    }
                    return;
                }
            case 11:
                a();
                return;
            case 12:
                y0.l lVar3 = (y0.l) this.f1471e;
                String str8 = (String) this.f1470d;
                lVar3.getClass();
                lVar3.l(new a1.b(str8, "message"));
                return;
            case 13:
                y0.l lVar4 = (y0.l) this.f1471e;
                byte[] bArr = (byte[]) this.f1470d;
                lVar4.getClass();
                lVar4.l(new a1.b(bArr, "message"));
                return;
            case 14:
                y0.l lVar5 = (y0.l) this.f1470d;
                x0.a[] aVarArr = (x0.a[]) this.f1471e;
                lVar5.d("upgrade", aVarArr[0]);
                lVar5.d("upgradeError", aVarArr[0]);
                return;
            case 15:
                y0.o oVar3 = (y0.o) this.f1471e;
                if (oVar3.f6117k != 2) {
                    throw new RuntimeException("Transport not open");
                }
                oVar3.g((a1.b[]) this.f1470d);
                return;
            case 16:
                b();
                return;
            case 17:
                if (((z.p) this.f1471e).f6259c.f32c instanceof a0.b) {
                    return;
                }
                try {
                    p.f fVar2 = (p.f) ((a0.l) this.f1470d).get();
                    if (fVar2 == null) {
                        throw new IllegalStateException("Worker was marked important (" + ((z.p) this.f1471e).f6261e.f6001c + ") but did not provide ForegroundInfo");
                    }
                    p.m.d().a(z.p.f6258i, "Updating notification for " + ((z.p) this.f1471e).f6261e.f6001c);
                    z.p pVar = (z.p) this.f1471e;
                    a0.l lVar6 = pVar.f6259c;
                    z.r rVar2 = pVar.f6263g;
                    Context context = pVar.f6260d;
                    UUID uuid = pVar.f6262f.f2851b.f206a;
                    rVar2.getClass();
                    a0.l lVar7 = new a0.l();
                    rVar2.f6270a.b(new z.q(rVar2, lVar7, uuid, fVar2, context));
                    lVar6.k(lVar7);
                    return;
                } catch (Throwable th2) {
                    ((z.p) this.f1471e).f6259c.j(th2);
                    return;
                }
            case 18:
                z0.b.f6283o.fine("paused");
                ((z0.b) this.f1470d).f6117k = 4;
                ((a2.i) ((j) this.f1471e).f1470d).run();
                return;
            case 19:
                z0.b bVar2 = (z0.b) this.f1471e;
                bVar2.f6117k = 4;
                j jVar3 = new j(this, bVar2, 18);
                boolean z2 = bVar2.n;
                if (!z2 && bVar2.f6108b) {
                    jVar3.run();
                    return;
                }
                int i10 = 0;
                int[] iArr = {0};
                if (z2) {
                    z0.b.f6283o.fine("we are currently polling - waiting to pause");
                    iArr[0] = iArr[0] + 1;
                    bVar2.d("pollComplete", new z0.a(iArr, jVar3, i10));
                }
                if (bVar2.f6108b) {
                    return;
                }
                z0.b.f6283o.fine("we are currently writing - waiting to pause");
                iArr[0] = iArr[0] + 1;
                bVar2.d("drain", new z0.a(iArr, jVar3, 1));
                return;
            case 20:
                ((z0.c) this.f1471e).f6285b.a("responseHeaders", ((Object[]) this.f1470d)[0]);
                return;
            case 21:
                Object[] objArr2 = (Object[]) this.f1470d;
                if (objArr2.length > 0) {
                    Object obj2 = objArr2[0];
                    if (obj2 instanceof Exception) {
                        exc3 = (Exception) obj2;
                    }
                }
                z0.e eVar6 = ((z0.c) this.f1471e).f6285b;
                Logger logger3 = z0.e.f6292p;
                eVar6.a("error", new y0.a("xhr post error", exc3));
                return;
            case 22:
                Object[] objArr3 = (Object[]) this.f1470d;
                Object obj3 = objArr3.length > 0 ? objArr3[0] : null;
                z0.e eVar7 = ((z0.c) this.f1471e).f6285b;
                String str9 = (String) obj3;
                eVar7.getClass();
                Logger logger4 = z0.b.f6283o;
                if (logger4.isLoggable(Level.FINE)) {
                    logger4.fine("polling got data " + str9);
                }
                n1 n1Var = new n1(eVar7);
                a1.b bVar3 = a1.f.f45c;
                if (str9 == null || str9.length() == 0) {
                    n1Var.i(bVar3);
                } else {
                    String[] strArrSplit = str9.split(String.valueOf((char) 30));
                    int length = strArrSplit.length;
                    int i11 = 0;
                    while (i11 < length) {
                        String str10 = strArrSplit[i11];
                        if (str10 == null) {
                            strArr = strArrSplit;
                            bVarA = bVar3;
                        } else {
                            if (str10.charAt(i5) == 'b') {
                                byte[] bytes = str10.substring(i4).getBytes();
                                int length2 = bytes.length;
                                int i12 = (length2 * 3) / 4;
                                byte[] bArr2 = new byte[i12];
                                int[] iArr2 = a1.a.f37g;
                                int i13 = 0;
                                int i14 = 0;
                                int i15 = 0;
                                int i16 = 0;
                                while (true) {
                                    if (i13 < length2) {
                                        if (i14 == 0) {
                                            while (true) {
                                                int i17 = i13 + 4;
                                                strArr = strArrSplit;
                                                if (i17 <= length2) {
                                                    int i18 = (iArr2[bytes[i13] & 255 ? 1 : 0] << 18) | (iArr2[bytes[i13 + 1] & 255 ? 1 : 0] << 12) | (iArr2[bytes[i13 + 2] & 255 ? 1 : 0] << 6) | iArr2[bytes[i13 + 3] & 255 ? 1 : 0];
                                                    if (i18 >= 0) {
                                                        bArr2[i16 + 2] = (byte) i18;
                                                        bArr2[i16 + 1] = (byte) (i18 >> 8);
                                                        bArr2[i16] = (byte) (i18 >> 16);
                                                        i16 += 3;
                                                        i15 = i18;
                                                        i13 = i17;
                                                        strArrSplit = strArr;
                                                    } else {
                                                        i15 = i18;
                                                    }
                                                }
                                            }
                                            if (i13 >= length2) {
                                                i4 = 1;
                                            }
                                            o2.i("bad base-64");
                                            return;
                                        }
                                        strArr = strArrSplit;
                                        int i19 = i13 + 1;
                                        int i20 = iArr2[bytes[i13] & 255 ? 1 : 0];
                                        if (i14 != 0) {
                                            if (i14 != 1) {
                                                if (i14 != 2) {
                                                    if (i14 != 3) {
                                                        if (i14 != 4) {
                                                            if (i14 == 5 && i20 != -1) {
                                                                o2.i("bad base-64");
                                                                return;
                                                            }
                                                        } else if (i20 == -2) {
                                                            i14++;
                                                        } else if (i20 != -1) {
                                                            o2.i("bad base-64");
                                                            return;
                                                        }
                                                    } else if (i20 >= 0) {
                                                        int i21 = i20 | (i15 << 6);
                                                        bArr2[i16 + 2] = (byte) i21;
                                                        bArr2[i16 + 1] = (byte) (i21 >> 8);
                                                        bArr2[i16] = (byte) (i21 >> 16);
                                                        i16 += 3;
                                                        i15 = i21;
                                                        i14 = 0;
                                                    } else if (i20 == -2) {
                                                        bArr2[i16 + 1] = (byte) (i15 >> 2);
                                                        bArr2[i16] = (byte) (i15 >> 10);
                                                        i16 += 2;
                                                        i14 = 5;
                                                    } else if (i20 != -1) {
                                                        o2.i("bad base-64");
                                                        return;
                                                    }
                                                } else if (i20 >= 0) {
                                                    i20 |= i15 << 6;
                                                } else if (i20 == -2) {
                                                    bArr2[i16] = (byte) (i15 >> 4);
                                                    i16++;
                                                    i14 = 4;
                                                } else if (i20 != -1) {
                                                    o2.i("bad base-64");
                                                    return;
                                                }
                                            } else if (i20 >= 0) {
                                                i20 |= i15 << 6;
                                            } else if (i20 != -1) {
                                                o2.i("bad base-64");
                                                return;
                                            }
                                            i14++;
                                            i15 = i20;
                                        } else if (i20 >= 0) {
                                            i14++;
                                            i15 = i20;
                                        } else if (i20 != -1) {
                                            o2.i("bad base-64");
                                            return;
                                        }
                                        i13 = i19;
                                        i4 = 1;
                                        strArrSplit = strArr;
                                    } else {
                                        strArr = strArrSplit;
                                    }
                                }
                                if (i14 != i4) {
                                    if (i14 != 2) {
                                        if (i14 == 3) {
                                            int i22 = i16 + 1;
                                            bArr2[i16] = (byte) (i15 >> 10);
                                            i16 += 2;
                                            bArr2[i22] = (byte) (i15 >> 2);
                                        } else if (i14 == 4) {
                                        }
                                        i3 = i16;
                                    } else {
                                        i3 = i16 + 1;
                                        bArr2[i16] = (byte) (i15 >> 4);
                                    }
                                    if (i3 != i12) {
                                        byte[] bArr3 = new byte[i3];
                                        System.arraycopy(bArr2, 0, bArr3, 0, i3);
                                        bArr2 = bArr3;
                                    }
                                    bVarA = new a1.b(bArr2, "message");
                                }
                                o2.i("bad base-64");
                                return;
                            }
                            strArr = strArrSplit;
                            bVarA = a1.f.a(str10);
                        }
                        if (bVar3.f39a.equals(bVarA.f39a) && ((String) bVar3.f40b).equals(bVarA.f40b)) {
                            n1Var.i(bVar3);
                        } else if (n1Var.i(bVarA)) {
                            i11++;
                            strArrSplit = strArr;
                            i4 = 1;
                            i5 = 0;
                        }
                    }
                }
                if (eVar7.f6117k != 3) {
                    eVar7.n = false;
                    eVar7.a("pollComplete", new Object[0]);
                    if (eVar7.f6117k == 2) {
                        eVar7.h();
                        return;
                    }
                    if (logger4.isLoggable(Level.FINE)) {
                        int i23 = eVar7.f6117k;
                        StringBuilder sb2 = new StringBuilder("ignoring poll - transport state '");
                        if (i23 == 1) {
                            str3 = "OPENING";
                        } else if (i23 == 2) {
                            str3 = "OPEN";
                        } else if (i23 != 3) {
                            str3 = i23 != 4 ? "null" : "PAUSED";
                        } else {
                            str3 = "CLOSED";
                        }
                        sb2.append(str3);
                        sb2.append("'");
                        logger4.fine(sb2.toString());
                        return;
                    }
                    return;
                }
                return;
            case 23:
                Object[] objArr4 = (Object[]) this.f1470d;
                if (objArr4.length > 0) {
                    Object obj4 = objArr4[0];
                    if (obj4 instanceof Exception) {
                        exc2 = (Exception) obj4;
                    }
                }
                z0.e eVar8 = ((z0.c) this.f1471e).f6285b;
                Logger logger5 = z0.e.f6292p;
                eVar8.getClass();
                eVar8.a("error", new y0.a("xhr poll error", exc2));
                return;
            case 24:
                c();
                return;
            case 25:
                d();
                return;
            case 26:
                e();
                return;
            default:
                z0.g gVar = ((z0.f) this.f1471e).f6294a;
                Exception exc4 = (Exception) this.f1470d;
                Logger logger6 = z0.g.f6295o;
                gVar.a("error", new y0.a("websocket error", exc4));
                return;
        }
    }

    public /* synthetic */ j(Object obj, Object obj2, int i3, boolean z2) {
        this.f1469c = i3;
        this.f1470d = obj;
        this.f1471e = obj2;
    }
}
