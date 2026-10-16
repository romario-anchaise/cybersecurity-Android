// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import e2.n1;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements n2.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f2948g = j2.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f2949h = j2.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2.m f2950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n2.g f2951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile v f2953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i2.v f2954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f2955f;

    public o(i2.u uVar, m2.m mVar, n2.g gVar, n nVar) {
        uVar.getClass();
        nVar.getClass();
        this.f2950a = mVar;
        this.f2951b = gVar;
        this.f2952c = nVar;
        List list = uVar.f2254t;
        i2.v vVar = i2.v.f2265h;
        this.f2954e = list.contains(vVar) ? vVar : i2.v.f2264g;
    }

    @Override // n2.e
    public final long a(i2.y yVar) {
        if (n2.f.a(yVar)) {
            return j2.b.k(yVar);
        }
        return 0L;
    }

    @Override // n2.e
    public final void b(b2.d dVar) throws IOException {
        int i3;
        v vVar;
        boolean z2;
        if (this.f2953d != null) {
            return;
        }
        boolean z3 = ((g.j) dVar.f268e) != null;
        i2.o oVar = (i2.o) dVar.f267d;
        ArrayList arrayList = new ArrayList(oVar.size() + 4);
        arrayList.add(new b(b.f2878f, dVar.f265b));
        w2.k kVar = b.f2879g;
        i2.q qVar = (i2.q) dVar.f266c;
        qVar.getClass();
        String strB = qVar.b();
        String strD = qVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new b(kVar, strB));
        String strA = oVar.a("Host");
        if (strA != null) {
            arrayList.add(new b(b.f2881i, strA));
        }
        arrayList.add(new b(b.f2880h, qVar.f2200a));
        int size = oVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            String strB2 = oVar.b(i4);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strB2.toLowerCase(locale);
            lowerCase.getClass();
            if (!f2948g.contains(lowerCase) || (lowerCase.equals("te") && q1.e.a(oVar.e(i4), "trailers"))) {
                arrayList.add(new b(lowerCase, oVar.e(i4)));
            }
        }
        n nVar = this.f2952c;
        nVar.getClass();
        boolean z4 = !z3;
        synchronized (nVar.f2946y) {
            synchronized (nVar) {
                try {
                    if (nVar.f2929g > 1073741823) {
                        nVar.z(8);
                    }
                    if (nVar.f2930h) {
                        throw new a();
                    }
                    i3 = nVar.f2929g;
                    nVar.f2929g = i3 + 2;
                    vVar = new v(i3, nVar, z4, false, null);
                    z2 = !z3 || nVar.f2943v >= nVar.f2944w || vVar.f2981e >= vVar.f2982f;
                    if (vVar.h()) {
                        nVar.f2926d.put(Integer.valueOf(i3), vVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            nVar.f2946y.A(i3, arrayList, z4);
        }
        if (z2) {
            nVar.f2946y.flush();
        }
        this.f2953d = vVar;
        boolean z5 = this.f2955f;
        v vVar2 = this.f2953d;
        if (z5) {
            vVar2.getClass();
            vVar2.e(9);
            o2.l("Canceled");
            return;
        }
        vVar2.getClass();
        u uVar = vVar2.f2987k;
        long j3 = this.f2951b.f2769g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        uVar.g(j3, timeUnit);
        v vVar3 = this.f2953d;
        vVar3.getClass();
        vVar3.f2988l.g(this.f2951b.f2770h, timeUnit);
    }

    @Override // n2.e
    public final w2.v c(b2.d dVar, long j3) {
        v vVar = this.f2953d;
        vVar.getClass();
        return vVar.f();
    }

    @Override // n2.e
    public final void cancel() {
        this.f2955f = true;
        v vVar = this.f2953d;
        if (vVar != null) {
            vVar.e(9);
        }
    }

    @Override // n2.e
    public final void d() {
        v vVar = this.f2953d;
        vVar.getClass();
        vVar.f().close();
    }

    @Override // n2.e
    public final void e() {
        this.f2952c.flush();
    }

    @Override // n2.e
    public final w2.x f(i2.y yVar) {
        v vVar = this.f2953d;
        vVar.getClass();
        return vVar.f2985i;
    }

    @Override // n2.e
    public final i2.x g(boolean z2) throws IOException {
        i2.o oVar;
        v vVar = this.f2953d;
        if (vVar == null) {
            o2.l("stream wasn't created");
            return null;
        }
        synchronized (vVar) {
            vVar.f2987k.i();
            while (vVar.f2983g.isEmpty() && vVar.f2989m == 0) {
                try {
                    try {
                        vVar.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    vVar.f2987k.l();
                    throw th;
                }
            }
            vVar.f2987k.l();
            if (vVar.f2983g.isEmpty()) {
                IOException iOException = vVar.n;
                if (iOException != null) {
                    throw iOException;
                }
                int i3 = vVar.f2989m;
                if (i3 != 0) {
                    throw new b0(i3);
                }
                throw null;
            }
            Object objRemoveFirst = vVar.f2983g.removeFirst();
            objRemoveFirst.getClass();
            oVar = (i2.o) objRemoveFirst;
        }
        i2.v vVar2 = this.f2954e;
        vVar2.getClass();
        ArrayList arrayList = new ArrayList(20);
        int size = oVar.size();
        g.j jVarX = null;
        for (int i4 = 0; i4 < size; i4++) {
            String strB = oVar.b(i4);
            String strE = oVar.e(i4);
            if (q1.e.a(strB, ":status")) {
                jVarX = q2.c.x("HTTP/1.1 " + strE);
            } else if (!f2949h.contains(strB)) {
                strB.getClass();
                strE.getClass();
                arrayList.add(strB);
                arrayList.add(v1.d.J(strE).toString());
            }
        }
        if (jVarX == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        i2.x xVar = new i2.x();
        xVar.f2275b = vVar2;
        xVar.f2276c = jVarX.f1413b;
        xVar.f2277d = (String) jVarX.f1415d;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        n1 n1Var = new n1(9);
        ArrayList arrayList2 = (ArrayList) n1Var.f905c;
        arrayList2.getClass();
        strArr.getClass();
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        arrayList2.addAll(listAsList);
        xVar.f2279f = n1Var;
        if (z2 && xVar.f2276c == 100) {
            return null;
        }
        return xVar;
    }

    @Override // n2.e
    public final m2.m h() {
        return this.f2950a;
    }
}
