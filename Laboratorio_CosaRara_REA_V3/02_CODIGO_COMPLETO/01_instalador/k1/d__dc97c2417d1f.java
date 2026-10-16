// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: k1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0188d implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3468a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3470c;

    public C0188d(InputStream inputStream, K k2) {
        F0.i.e(inputStream, "input");
        this.f3469b = inputStream;
        this.f3470c = k2;
    }

    @Override // k1.I
    public final K c() {
        switch (this.f3468a) {
            case 0:
                return (H) this.f3469b;
            default:
                return (K) this.f3470c;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f3468a) {
            case 0:
                C0188d c0188d = (C0188d) this.f3470c;
                H h2 = (H) this.f3469b;
                h2.h();
                try {
                    try {
                        c0188d.close();
                        if (h2.i()) {
                            throw h2.k(null);
                        }
                        return;
                    } catch (IOException e2) {
                        if (!h2.i()) {
                            throw e2;
                        }
                        throw h2.k(e2);
                    }
                } catch (Throwable th) {
                    h2.i();
                    throw th;
                }
            default:
                ((InputStream) this.f3469b).close();
                return;
        }
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) throws IOException {
        switch (this.f3468a) {
            case 0:
                F0.i.e(c0193i, "sink");
                C0188d c0188d = (C0188d) this.f3470c;
                H h2 = (H) this.f3469b;
                h2.h();
                try {
                    try {
                        long jM = c0188d.m(c0193i, j2);
                        if (h2.i()) {
                            throw h2.k(null);
                        }
                        return jM;
                    } catch (IOException e2) {
                        if (h2.i()) {
                            throw h2.k(e2);
                        }
                        throw e2;
                    }
                } catch (Throwable th) {
                    h2.i();
                    throw th;
                }
            default:
                F0.i.e(c0193i, "sink");
                if (j2 == 0) {
                    return 0L;
                }
                if (j2 < 0) {
                    throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
                }
                try {
                    ((K) this.f3470c).f();
                    D dM = c0193i.M(1);
                    int i2 = ((InputStream) this.f3469b).read(dM.f3444a, dM.f3446c, (int) Math.min(j2, 8192 - dM.f3446c));
                    if (i2 == -1) {
                        if (dM.f3445b == dM.f3446c) {
                            c0193i.f3481a = dM.a();
                            E.a(dM);
                        }
                        return -1L;
                    }
                    dM.f3446c += i2;
                    long j3 = i2;
                    c0193i.f3482b += j3;
                    return j3;
                } catch (AssertionError e3) {
                    if (f1.l.D(e3)) {
                        throw new IOException(e3);
                    }
                    throw e3;
                }
        }
    }

    public final String toString() {
        switch (this.f3468a) {
            case 0:
                return "AsyncTimeout.source(" + ((C0188d) this.f3470c) + ')';
            default:
                return "source(" + ((InputStream) this.f3469b) + ')';
        }
    }

    public C0188d(H h2, C0188d c0188d) {
        this.f3469b = h2;
        this.f3470c = c0188d;
    }
}
