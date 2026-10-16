// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import i2.x;
import i2.y;
import java.io.IOException;
import java.net.Socket;
import p2.b0;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements h0.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f1474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f1476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f1477h;

    public k(m2.i iVar, i2.m mVar, m2.e eVar, n2.e eVar2) {
        mVar.getClass();
        eVar.getClass();
        this.f1473d = iVar;
        this.f1474e = mVar;
        this.f1475f = eVar;
        this.f1476g = eVar2;
        this.f1477h = eVar2.h();
    }

    @Override // h0.b
    public void a(e0.b bVar) {
        ((c) this.f1477h).f1450m.post(new j(this, bVar, 0));
    }

    public IOException b(boolean z2, boolean z3, IOException iOException) {
        i2.m mVar = (i2.m) this.f1474e;
        m2.i iVar = (m2.i) this.f1473d;
        if (iOException != null) {
            f(iOException);
        }
        if (z3) {
            if (iOException != null) {
                mVar.getClass();
            } else {
                mVar.getClass();
            }
        }
        if (z2) {
            if (iOException != null) {
                mVar.getClass();
            } else {
                mVar.getClass();
            }
        }
        return iVar.h(this, z3, z2, iOException);
    }

    public m2.l c() {
        m2.i iVar = (m2.i) this.f1473d;
        if (iVar.f2726m) {
            o2.k("Check failed.");
            return null;
        }
        iVar.f2726m = true;
        iVar.f2721h.j();
        m2.m mVarH = ((n2.e) this.f1476g).h();
        mVarH.getClass();
        Socket socket = mVarH.f2743d;
        socket.getClass();
        w2.r rVar = mVarH.f2747h;
        rVar.getClass();
        w2.q qVar = mVarH.f2748i;
        qVar.getClass();
        socket.setSoTimeout(0);
        mVarH.k();
        return new m2.l(rVar, qVar, this);
    }

    public n2.h d(y yVar) throws IOException {
        n2.e eVar = (n2.e) this.f1476g;
        try {
            String strD = y.d(yVar, "Content-Type");
            long jA = eVar.a(yVar);
            return new n2.h(strD, jA, new w2.r(new m2.d(this, eVar.f(yVar), jA)));
        } catch (IOException e3) {
            ((i2.m) this.f1474e).getClass();
            f(e3);
            throw e3;
        }
    }

    public x e(boolean z2) throws IOException {
        try {
            x xVarG = ((n2.e) this.f1476g).g(z2);
            if (xVarG == null) {
                return xVarG;
            }
            xVarG.f2286m = this;
            return xVarG;
        } catch (IOException e3) {
            ((i2.m) this.f1474e).getClass();
            f(e3);
            throw e3;
        }
    }

    public void f(IOException iOException) {
        this.f1472c = true;
        ((m2.e) this.f1475f).b(iOException);
        m2.m mVarH = ((n2.e) this.f1476g).h();
        m2.i iVar = (m2.i) this.f1473d;
        synchronized (mVarH) {
            try {
                if (!(iOException instanceof b0)) {
                    if (!(mVarH.f2746g != null) || (iOException instanceof p2.a)) {
                        mVarH.f2749j = true;
                        if (mVarH.f2752m == 0) {
                            m2.m.d(iVar.f2716c, mVarH.f2741b, iOException);
                            mVarH.f2751l++;
                        }
                    }
                } else if (((b0) iOException).f2885c == 8) {
                    int i3 = mVarH.n + 1;
                    mVarH.n = i3;
                    if (i3 > 1) {
                        mVarH.f2749j = true;
                        mVarH.f2751l++;
                    }
                } else if (((b0) iOException).f2885c != 9 || !iVar.f2730r) {
                    mVarH.f2749j = true;
                    mVarH.f2751l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(e0.b bVar) {
        h hVar = (h) ((c) this.f1477h).f1447j.get((a) this.f1474e);
        if (hVar != null) {
            h0.o.a(hVar.f1466k.f1450m);
            com.google.android.gms.common.internal.a aVar = hVar.f1457b;
            aVar.b("onSignInFailed for " + aVar.getClass().getName() + " with " + String.valueOf(bVar));
            hVar.o(bVar, null);
        }
    }

    public k(c cVar, com.google.android.gms.common.internal.a aVar, a aVar2) {
        this.f1477h = cVar;
        this.f1475f = null;
        this.f1476g = null;
        this.f1472c = false;
        this.f1473d = aVar;
        this.f1474e = aVar2;
    }
}
