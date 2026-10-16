// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import A.C0005e;
import X0.InterfaceC0057d;
import java.io.IOException;
import java.util.ArrayList;
import k1.C0193i;
import k1.C0196l;

/* JADX INFO: loaded from: classes.dex */
public final class y implements InterfaceC0201e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f3867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f3869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0057d f3870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC0209m f3871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f3872f;
    public b1.j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f3873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3874i;

    public y(N n2, Object obj, Object[] objArr, InterfaceC0057d interfaceC0057d, InterfaceC0209m interfaceC0209m) {
        this.f3867a = n2;
        this.f3868b = obj;
        this.f3869c = objArr;
        this.f3870d = interfaceC0057d;
        this.f3871e = interfaceC0209m;
    }

    @Override // m1.InterfaceC0201e
    public final synchronized X0.y a() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return c().f2132b;
    }

    public final b1.j b() {
        X0.p pVarA;
        N n2 = this.f3867a;
        Object[] objArr = this.f3869c;
        int length = objArr.length;
        W[] wArr = n2.f3816j;
        if (length != wArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + wArr.length + ")");
        }
        L l2 = new L(n2.f3810c, n2.f3809b, n2.f3811d, n2.f3812e, n2.f3813f, n2.g, n2.f3814h, n2.f3815i);
        if (n2.f3817k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
            wArr[i2].a(l2, objArr[i2]);
        }
        X0.o oVar = l2.f3777d;
        if (oVar != null) {
            pVarA = oVar.a();
        } else {
            String str = l2.f3776c;
            X0.p pVar = l2.f3775b;
            pVar.getClass();
            F0.i.e(str, "link");
            X0.o oVarF = pVar.f(str);
            pVarA = oVarF != null ? oVarF.a() : null;
            if (pVarA == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + pVar + ", Relative: " + l2.f3776c);
            }
        }
        X0.B zVar = l2.f3783k;
        if (zVar == null) {
            H.s sVar = l2.f3782j;
            if (sVar != null) {
                zVar = new X0.l((ArrayList) sVar.f232b, (ArrayList) sVar.f233c);
            } else {
                C.h hVar = l2.f3781i;
                if (hVar != null) {
                    ArrayList arrayList2 = (ArrayList) hVar.f113c;
                    if (arrayList2.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    zVar = new X0.u((C0196l) hVar.f111a, (X0.s) hVar.f112b, Y0.b.w(arrayList2));
                } else if (l2.f3780h) {
                    long j2 = 0;
                    Y0.b.c(j2, j2, j2);
                    zVar = new X0.A(null, 0, new byte[0], 0);
                }
            }
        }
        X0.s sVar2 = l2.g;
        C0005e c0005e = l2.f3779f;
        if (sVar2 != null) {
            if (zVar != null) {
                zVar = new X0.z(zVar, sVar2);
            } else {
                c0005e.y("Content-Type", sVar2.f1032a);
            }
        }
        V.a aVar = l2.f3778e;
        aVar.getClass();
        aVar.f650b = pVarA;
        aVar.f652d = c0005e.B().c();
        aVar.g(l2.f3774a, zVar);
        aVar.k(C0214s.class, new C0214s(this.f3868b, n2.f3808a, arrayList));
        X0.y yVarC = aVar.c();
        X0.w wVar = (X0.w) this.f3870d;
        wVar.getClass();
        return new b1.j(wVar, yVarC);
    }

    public final b1.j c() throws IOException {
        b1.j jVar = this.g;
        if (jVar != null) {
            return jVar;
        }
        Throwable th = this.f3873h;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            b1.j jVarB = b();
            this.g = jVarB;
            return jVarB;
        } catch (IOException | Error | RuntimeException e2) {
            W.s(e2);
            this.f3873h = e2;
            throw e2;
        }
    }

    @Override // m1.InterfaceC0201e
    public final void cancel() {
        b1.j jVar;
        this.f3872f = true;
        synchronized (this) {
            jVar = this.g;
        }
        if (jVar != null) {
            jVar.cancel();
        }
    }

    public final Object clone() {
        return new y(this.f3867a, this.f3868b, this.f3869c, this.f3870d, this.f3871e);
    }

    public final O d(X0.D d2) throws IOException {
        X0.C cJ = d2.j();
        X0.G g = d2.g;
        cJ.g = new x(g.f(), g.a());
        X0.D dA = cJ.a();
        int i2 = dA.f907d;
        if (i2 < 200 || i2 >= 300) {
            try {
                g.j().g(new C0193i());
                g.f();
                g.a();
                if (dA.f()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                O o2 = new O(dA, null);
                g.close();
                return o2;
            } catch (Throwable th) {
                g.close();
                throw th;
            }
        }
        if (i2 == 204 || i2 == 205) {
            g.close();
            if (dA.f()) {
                return new O(dA, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        C0218w c0218w = new C0218w(g);
        try {
            Object objP = this.f3871e.p(c0218w);
            if (dA.f()) {
                return new O(dA, objP);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        } catch (RuntimeException e2) {
            IOException iOException = c0218w.f3864d;
            if (iOException == null) {
                throw e2;
            }
            throw iOException;
        }
    }

    @Override // m1.InterfaceC0201e
    /* JADX INFO: renamed from: f */
    public final InterfaceC0201e clone() {
        return new y(this.f3867a, this.f3868b, this.f3869c, this.f3870d, this.f3871e);
    }

    @Override // m1.InterfaceC0201e
    public final O j() {
        b1.j jVarC;
        synchronized (this) {
            if (this.f3874i) {
                throw new IllegalStateException("Already executed.");
            }
            this.f3874i = true;
            jVarC = c();
        }
        if (this.f3872f) {
            jVarC.cancel();
        }
        return d(jVarC.g());
    }

    @Override // m1.InterfaceC0201e
    public final boolean n() {
        boolean z2 = true;
        if (this.f3872f) {
            return true;
        }
        synchronized (this) {
            b1.j jVar = this.g;
            if (jVar == null || !jVar.f2142m) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // m1.InterfaceC0201e
    public final void r(InterfaceC0204h interfaceC0204h) {
        b1.j jVar;
        Throwable th;
        synchronized (this) {
            try {
                if (this.f3874i) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f3874i = true;
                jVar = this.g;
                th = this.f3873h;
                if (jVar == null && th == null) {
                    try {
                        b1.j jVarB = b();
                        this.g = jVarB;
                        jVar = jVarB;
                    } catch (Throwable th2) {
                        th = th2;
                        W.s(th);
                        this.f3873h = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            interfaceC0204h.j(this, th);
            return;
        }
        if (this.f3872f) {
            jVar.cancel();
        }
        jVar.e(new H.s(this, interfaceC0204h, 15, false));
    }
}
