// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f2373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2377f;
    public final ArrayDeque g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f2379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f2380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v f2381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final v f2382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IOException f2384n;

    public w(int i2, o oVar, boolean z2, boolean z3, X0.n nVar) {
        F0.i.e(oVar, "connection");
        this.f2372a = i2;
        this.f2373b = oVar;
        this.f2377f = oVar.f2335q.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.g = arrayDeque;
        this.f2379i = new u(this, oVar.f2334p.a(), z3);
        this.f2380j = new t(this, z2);
        this.f2381k = new v(this);
        this.f2382l = new v(this);
        if (nVar == null) {
            if (!g()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (g()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(nVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001b  */
    public final void a() {
        boolean z2;
        boolean zH;
        byte[] bArr = Y0.b.f1119a;
        synchronized (this) {
            try {
                u uVar = this.f2379i;
                if (uVar.f2366b || !uVar.f2369e) {
                    z2 = false;
                } else {
                    t tVar = this.f2380j;
                    if (tVar.f2361a || tVar.f2363c) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                zH = h();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            c(9, null);
        } else {
            if (zH) {
                return;
            }
            this.f2373b.j(this.f2372a);
        }
    }

    public final void b() throws IOException {
        t tVar = this.f2380j;
        if (tVar.f2363c) {
            throw new IOException("stream closed");
        }
        if (tVar.f2361a) {
            throw new IOException("stream finished");
        }
        if (this.f2383m != 0) {
            IOException iOException = this.f2384n;
            if (iOException != null) {
                throw iOException;
            }
            int i2 = this.f2383m;
            F0.h.f(i2);
            throw new C(i2);
        }
    }

    public final void c(int i2, IOException iOException) {
        F0.h.g(i2, "rstStatusCode");
        if (d(i2, iOException)) {
            o oVar = this.f2373b;
            oVar.getClass();
            F0.h.g(i2, "statusCode");
            oVar.f2341w.u(this.f2372a, i2);
        }
    }

    public final boolean d(int i2, IOException iOException) {
        byte[] bArr = Y0.b.f1119a;
        synchronized (this) {
            if (this.f2383m != 0) {
                return false;
            }
            this.f2383m = i2;
            this.f2384n = iOException;
            notifyAll();
            if (this.f2379i.f2366b && this.f2380j.f2361a) {
                return false;
            }
            this.f2373b.j(this.f2372a);
            return true;
        }
    }

    public final void e(int i2) {
        F0.h.g(i2, "errorCode");
        if (d(i2, null)) {
            this.f2373b.u(this.f2372a, i2);
        }
    }

    public final t f() {
        synchronized (this) {
            if (!this.f2378h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f2380j;
    }

    public final boolean g() {
        boolean z2 = (this.f2372a & 1) == 1;
        this.f2373b.getClass();
        return true == z2;
    }

    public final synchronized boolean h() {
        if (this.f2383m != 0) {
            return false;
        }
        u uVar = this.f2379i;
        if (uVar.f2366b || uVar.f2369e) {
            t tVar = this.f2380j;
            if ((tVar.f2361a || tVar.f2363c) && this.f2378h) {
                return false;
            }
        }
        return true;
    }

    public final void i(X0.n nVar, boolean z2) {
        boolean zH;
        F0.i.e(nVar, "headers");
        byte[] bArr = Y0.b.f1119a;
        synchronized (this) {
            try {
                if (this.f2378h && z2) {
                    this.f2379i.getClass();
                } else {
                    this.f2378h = true;
                    this.g.add(nVar);
                }
                if (z2) {
                    this.f2379i.f2366b = true;
                }
                zH = h();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.f2373b.j(this.f2372a);
    }

    public final synchronized void j(int i2) {
        F0.h.g(i2, "errorCode");
        if (this.f2383m == 0) {
            this.f2383m = i2;
            notifyAll();
        }
    }

    public final void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
