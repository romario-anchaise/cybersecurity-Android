// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Closeable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final B f2319z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2321b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2325f;
    public final a1.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a1.c f2326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a1.c f2327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a1.c f2328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final A f2329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final B f2334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public B f2335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f2337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Socket f2340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x f2341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f2342x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f2343y;

    static {
        B b2 = new B();
        b2.c(7, 65535);
        b2.c(5, 16384);
        f2319z = b2;
    }

    public o(X0.y yVar) {
        this.f2320a = (h) yVar.g;
        String str = (String) yVar.f1098b;
        if (str == null) {
            F0.i.h("connectionName");
            throw null;
        }
        this.f2322c = str;
        this.f2324e = 3;
        a1.d dVar = (a1.d) yVar.f1099c;
        this.g = dVar;
        this.f2326h = dVar.e();
        this.f2327i = dVar.e();
        this.f2328j = dVar.e();
        this.f2329k = A.f2272a;
        B b2 = new B();
        b2.c(7, 16777216);
        this.f2334p = b2;
        B b3 = f2319z;
        this.f2335q = b3;
        this.f2339u = b3.a();
        Socket socket = (Socket) yVar.f1100d;
        if (socket == null) {
            F0.i.h("socket");
            throw null;
        }
        this.f2340v = socket;
        k1.B b4 = (k1.B) yVar.f1102f;
        if (b4 == null) {
            F0.i.h("sink");
            throw null;
        }
        this.f2341w = new x(b4);
        k1.C c2 = (k1.C) yVar.f1101e;
        if (c2 == null) {
            F0.i.h("source");
            throw null;
        }
        this.f2342x = new k(this, new s(c2));
        this.f2343y = new LinkedHashSet();
    }

    public final void a(int i2, int i3, IOException iOException) {
        int i4;
        Object[] array;
        F0.h.g(i2, "connectionCode");
        F0.h.g(i3, "streamCode");
        byte[] bArr = Y0.b.f1119a;
        try {
            n(i2);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f2321b.isEmpty()) {
                array = null;
            } else {
                array = this.f2321b.values().toArray(new w[0]);
                this.f2321b.clear();
            }
        }
        w[] wVarArr = (w[]) array;
        if (wVarArr != null) {
            for (w wVar : wVarArr) {
                try {
                    wVar.c(i3, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f2341w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f2340v.close();
        } catch (IOException unused4) {
        }
        this.f2326h.e();
        this.f2327i.e();
        this.f2328j.e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(1, 9, null);
    }

    public final synchronized w f(int i2) {
        return (w) this.f2321b.get(Integer.valueOf(i2));
    }

    public final void flush() {
        this.f2341w.flush();
    }

    public final synchronized w j(int i2) {
        w wVar;
        wVar = (w) this.f2321b.remove(Integer.valueOf(i2));
        notifyAll();
        return wVar;
    }

    public final void n(int i2) {
        F0.h.g(i2, "statusCode");
        synchronized (this.f2341w) {
            synchronized (this) {
                if (this.f2325f) {
                    return;
                }
                this.f2325f = true;
                this.f2341w.n(Y0.b.f1119a, this.f2323d, i2);
            }
        }
    }

    public final synchronized void r(long j2) {
        long j3 = this.f2336r + j2;
        this.f2336r = j3;
        long j4 = j3 - this.f2337s;
        if (j4 >= this.f2334p.a() / 2) {
            v(0, j4);
            this.f2337s += j4;
        }
    }

    public final void t(int i2, boolean z2, C0193i c0193i, long j2) {
        long j3;
        long j4;
        int iMin;
        long j5;
        if (j2 == 0) {
            this.f2341w.f(z2, i2, c0193i, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j3 = this.f2338t;
                            j4 = this.f2339u;
                            if (j3 >= j4) {
                                if (!this.f2321b.containsKey(Integer.valueOf(i2))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j2, j4 - j3), this.f2341w.f2388c);
                j5 = iMin;
                this.f2338t += j5;
            }
            j2 -= j5;
            this.f2341w.f(z2 && j2 == 0, i2, c0193i, iMin);
        }
    }

    public final void u(int i2, int i3) {
        F0.h.g(i3, "errorCode");
        this.f2326h.c(new j(this.f2322c + '[' + i2 + "] writeSynReset", this, i2, i3, 2), 0L);
    }

    public final void v(int i2, long j2) {
        this.f2326h.c(new n(this.f2322c + '[' + i2 + "] windowUpdate", this, i2, j2), 0L);
    }
}
