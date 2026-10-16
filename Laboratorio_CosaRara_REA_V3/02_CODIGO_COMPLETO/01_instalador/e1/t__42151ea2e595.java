// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import k1.C0193i;
import k1.G;
import k1.K;

/* JADX INFO: loaded from: classes.dex */
public final class t implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f2362b = new C0193i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f2364d;

    public t(w wVar, boolean z2) {
        this.f2364d = wVar;
        this.f2361a = z2;
    }

    public final void a(boolean z2) {
        long jMin;
        boolean z3;
        w wVar = this.f2364d;
        synchronized (wVar) {
            wVar.f2382l.h();
            while (wVar.f2376e >= wVar.f2377f && !this.f2361a && !this.f2363c) {
                try {
                    synchronized (wVar) {
                        int i2 = wVar.f2383m;
                        if (i2 != 0) {
                            break;
                        } else {
                            wVar.k();
                        }
                    }
                } catch (Throwable th) {
                    wVar.f2382l.k();
                    throw th;
                }
            }
            wVar.f2382l.k();
            wVar.b();
            jMin = Math.min(wVar.f2377f - wVar.f2376e, this.f2362b.f3482b);
            wVar.f2376e += jMin;
            z3 = z2 && jMin == this.f2362b.f3482b;
        }
        this.f2364d.f2382l.h();
        try {
            w wVar2 = this.f2364d;
            wVar2.f2373b.t(wVar2.f2372a, z3, this.f2362b, jMin);
        } finally {
            this.f2364d.f2382l.k();
        }
    }

    @Override // k1.G
    public final K c() {
        return this.f2364d.f2382l;
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z2;
        w wVar = this.f2364d;
        byte[] bArr = Y0.b.f1119a;
        synchronized (wVar) {
            if (this.f2363c) {
                return;
            }
            synchronized (wVar) {
                z2 = wVar.f2383m == 0;
            }
            w wVar2 = this.f2364d;
            if (!wVar2.f2380j.f2361a) {
                if (this.f2362b.f3482b > 0) {
                    while (this.f2362b.f3482b > 0) {
                        a(true);
                    }
                } else if (z2) {
                    wVar2.f2373b.t(wVar2.f2372a, true, null, 0L);
                }
            }
            synchronized (this.f2364d) {
                this.f2363c = true;
            }
            this.f2364d.f2373b.flush();
            this.f2364d.a();
        }
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() {
        w wVar = this.f2364d;
        byte[] bArr = Y0.b.f1119a;
        synchronized (wVar) {
            wVar.b();
        }
        while (this.f2362b.f3482b > 0) {
            a(false);
            this.f2364d.f2373b.flush();
        }
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "source");
        byte[] bArr = Y0.b.f1119a;
        C0193i c0193i2 = this.f2362b;
        c0193i2.i(c0193i, j2);
        while (c0193i2.f3482b >= 16384) {
            a(false);
        }
    }
}
