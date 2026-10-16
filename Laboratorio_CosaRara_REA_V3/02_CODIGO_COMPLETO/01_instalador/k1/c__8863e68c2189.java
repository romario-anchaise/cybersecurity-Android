// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: k1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0187c implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3467c;

    public /* synthetic */ C0187c(Object obj, int i2, Object obj2) {
        this.f3465a = i2;
        this.f3466b = obj;
        this.f3467c = obj2;
    }

    @Override // k1.G
    public final K c() {
        switch (this.f3465a) {
            case 0:
                return (H) this.f3466b;
            default:
                return (K) this.f3467c;
        }
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f3465a) {
            case 0:
                C0187c c0187c = (C0187c) this.f3467c;
                H h2 = (H) this.f3466b;
                h2.h();
                try {
                    try {
                        c0187c.close();
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
                ((OutputStream) this.f3466b).close();
                return;
        }
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f3465a) {
            case 0:
                C0187c c0187c = (C0187c) this.f3467c;
                H h2 = (H) this.f3466b;
                h2.h();
                try {
                    try {
                        c0187c.flush();
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
                ((OutputStream) this.f3466b).flush();
                return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x009b A[LOOP:1: B:12:0x0062->B:25:0x009b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x009d A[SYNTHETIC] */
    @Override // k1.G
    public final void i(C0193i c0193i, long j2) throws IOException {
        H h2;
        switch (this.f3465a) {
            case 0:
                F0.i.e(c0193i, "source");
                f1.d.g(c0193i.f3482b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    D d2 = c0193i.f3481a;
                    F0.i.b(d2);
                    try {
                        try {
                            while (j3 < 65536) {
                                j3 += (long) (d2.f3446c - d2.f3445b);
                                if (j3 >= j2) {
                                    j3 = j2;
                                    C0187c c0187c = (C0187c) this.f3467c;
                                    h2 = (H) this.f3466b;
                                    h2.h();
                                    c0187c.i(c0193i, j3);
                                    if (!h2.i()) {
                                        throw h2.k(null);
                                    }
                                    j2 -= j3;
                                } else {
                                    d2 = d2.f3449f;
                                    F0.i.b(d2);
                                }
                            }
                            c0187c.i(c0193i, j3);
                            if (!h2.i()) {
                                throw h2.k(null);
                            }
                            j2 -= j3;
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
                    C0187c c0187c2 = (C0187c) this.f3467c;
                    h2 = (H) this.f3466b;
                    h2.h();
                }
                break;
            default:
                F0.i.e(c0193i, "source");
                f1.d.g(c0193i.f3482b, 0L, j2);
                while (j2 > 0) {
                    ((K) this.f3467c).f();
                    D d3 = c0193i.f3481a;
                    F0.i.b(d3);
                    int iMin = (int) Math.min(j2, d3.f3446c - d3.f3445b);
                    ((OutputStream) this.f3466b).write(d3.f3444a, d3.f3445b, iMin);
                    int i2 = d3.f3445b + iMin;
                    d3.f3445b = i2;
                    long j4 = iMin;
                    j2 -= j4;
                    c0193i.f3482b -= j4;
                    if (i2 == d3.f3446c) {
                        c0193i.f3481a = d3.a();
                        E.a(d3);
                    }
                }
                return;
        }
    }

    public final String toString() {
        switch (this.f3465a) {
            case 0:
                return "AsyncTimeout.sink(" + ((C0187c) this.f3467c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f3466b) + ')';
        }
    }
}
