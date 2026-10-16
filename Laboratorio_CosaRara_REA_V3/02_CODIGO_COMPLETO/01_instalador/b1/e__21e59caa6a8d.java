// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import X0.C;
import X0.D;
import X0.F;
import e1.C0108a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f2114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c1.d f2115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f2117e;

    public e(j jVar, f fVar, c1.d dVar) {
        F0.i.e(jVar, "call");
        F0.i.e(fVar, "finder");
        this.f2113a = jVar;
        this.f2114b = fVar;
        this.f2115c = dVar;
        this.f2117e = dVar.h();
    }

    public final IOException a(boolean z2, boolean z3, IOException iOException) {
        if (iOException != null) {
            d(iOException);
        }
        j jVar = this.f2113a;
        if (z3) {
            if (iOException != null) {
                F0.i.e(jVar, "call");
            } else {
                F0.i.e(jVar, "call");
            }
        }
        if (z2) {
            if (iOException != null) {
                F0.i.e(jVar, "call");
            } else {
                F0.i.e(jVar, "call");
            }
        }
        return jVar.k(this, z3, z2, iOException);
    }

    public final F b(D d2) throws IOException {
        c1.d dVar = this.f2115c;
        try {
            String strA = D.a(d2, "Content-Type");
            long jC = dVar.c(d2);
            return new F(strA, jC, f1.l.f(new d(this, dVar.b(d2), jC)), 1);
        } catch (IOException e2) {
            F0.i.e(this.f2113a, "call");
            d(e2);
            throw e2;
        }
    }

    public final C c(boolean z2) throws IOException {
        try {
            C cF = this.f2115c.f(z2);
            if (cF != null) {
                cF.f903m = this;
            }
            return cF;
        } catch (IOException e2) {
            F0.i.e(this.f2113a, "call");
            d(e2);
            throw e2;
        }
    }

    public final void d(IOException iOException) {
        this.f2116d = true;
        this.f2114b.c(iOException);
        m mVarH = this.f2115c.h();
        j jVar = this.f2113a;
        synchronized (mVarH) {
            try {
                F0.i.e(jVar, "call");
                if (!(iOException instanceof e1.C)) {
                    if (!(mVarH.g != null) || (iOException instanceof C0108a)) {
                        mVarH.f2156j = true;
                        if (mVarH.f2159m == 0) {
                            m.d(jVar.f2131a, mVarH.f2149b, iOException);
                            mVarH.f2158l++;
                        }
                    }
                } else if (((e1.C) iOException).f2275a == 8) {
                    int i2 = mVarH.f2160n + 1;
                    mVarH.f2160n = i2;
                    if (i2 > 1) {
                        mVarH.f2156j = true;
                        mVarH.f2158l++;
                    }
                } else if (((e1.C) iOException).f2275a != 9 || !jVar.f2142m) {
                    mVarH.f2156j = true;
                    mVarH.f2158l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
