// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import k1.C0193i;
import k1.I;
import k1.K;

/* JADX INFO: loaded from: classes.dex */
public final class u implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0193i f2367c = new C0193i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0193i f2368d = new C0193i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w f2370f;

    public u(w wVar, long j2, boolean z2) {
        this.f2370f = wVar;
        this.f2365a = j2;
        this.f2366b = z2;
    }

    public final void a(long j2) {
        byte[] bArr = Y0.b.f1119a;
        this.f2370f.f2373b.r(j2);
    }

    @Override // k1.I
    public final K c() {
        return this.f2370f.f2381k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j2;
        w wVar = this.f2370f;
        synchronized (wVar) {
            this.f2369e = true;
            C0193i c0193i = this.f2368d;
            j2 = c0193i.f3482b;
            c0193i.t();
            F0.i.c(wVar, "null cannot be cast to non-null type java.lang.Object");
            wVar.notifyAll();
        }
        if (j2 > 0) {
            a(j2);
        }
        this.f2370f.a();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0089 A[LOOP:0: B:4:0x0010->B:45:0x0089, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0093 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:72:0x008c A[SYNTHETIC] */
    @Override // k1.I
    public final long m(C0193i c0193i, long j2) throws Throwable {
        int i2;
        Throwable c2;
        boolean z2;
        long jM;
        F0.i.e(c0193i, "sink");
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        while (true) {
            w wVar = this.f2370f;
            synchronized (wVar) {
                wVar.f2381k.h();
                try {
                    synchronized (wVar) {
                        i2 = wVar.f2383m;
                    }
                    if (z2) {
                        if (jM != -1) {
                            return jM;
                        }
                        if (c2 == null) {
                            return -1L;
                        }
                        throw c2;
                    }
                    j3 = 0;
                } catch (Throwable th) {
                    wVar.f2381k.k();
                    throw th;
                }
            }
            if (i2 == 0 || this.f2366b) {
                c2 = null;
            } else {
                c2 = wVar.f2384n;
                if (c2 == null) {
                    synchronized (wVar) {
                        int i3 = wVar.f2383m;
                        F0.h.f(i3);
                        c2 = new C(i3);
                    }
                }
            }
            if (this.f2369e) {
                throw new IOException("stream closed");
            }
            C0193i c0193i2 = this.f2368d;
            long j4 = c0193i2.f3482b;
            z2 = false;
            if (j4 > j3) {
                jM = c0193i2.m(c0193i, Math.min(j2, j4));
                long j5 = wVar.f2374c + jM;
                wVar.f2374c = j5;
                long j6 = j5 - wVar.f2375d;
                if (c2 == null && j6 >= wVar.f2373b.f2334p.a() / 2) {
                    wVar.f2373b.v(wVar.f2372a, j6);
                    wVar.f2375d = wVar.f2374c;
                }
            } else {
                if (!this.f2366b && c2 == null) {
                    wVar.k();
                    z2 = true;
                }
                jM = -1;
            }
            wVar.f2381k.k();
            if (z2) {
                if (jM != -1) {
                    return jM;
                }
                if (c2 == null) {
                    return -1L;
                }
                throw c2;
            }
            j3 = 0;
        }
    }
}
