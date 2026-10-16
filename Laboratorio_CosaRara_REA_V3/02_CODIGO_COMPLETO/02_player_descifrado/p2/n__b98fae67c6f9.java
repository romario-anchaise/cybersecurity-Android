// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Closeable {
    public static final a0 B;
    public final LinkedHashSet A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f2925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2926d = new LinkedHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l2.e f2931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l2.c f2932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l2.c f2933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l2.c f2934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z f2935m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f2936o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2937p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2938q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a0 f2939r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a0 f2940s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2941t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f2943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f2944w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Socket f2945x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final w f2946y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final y.l f2947z;

    static {
        a0 a0Var = new a0();
        a0Var.b(7, 65535);
        a0Var.b(5, 16384);
        B = a0Var;
    }

    public n(b2.d dVar) {
        this.f2925c = (h) dVar.f270g;
        String str = dVar.f265b;
        if (str == null) {
            q1.e.c("connectionName");
            throw null;
        }
        this.f2927e = str;
        this.f2929g = 3;
        l2.e eVar = (l2.e) dVar.f266c;
        this.f2931i = eVar;
        this.f2932j = eVar.e();
        this.f2933k = eVar.e();
        this.f2934l = eVar.e();
        this.f2935m = z.f3002a;
        a0 a0Var = new a0();
        a0Var.b(7, 16777216);
        this.f2939r = a0Var;
        a0 a0Var2 = B;
        this.f2940s = a0Var2;
        this.f2944w = a0Var2.a();
        Socket socket = (Socket) dVar.f267d;
        if (socket == null) {
            q1.e.c("socket");
            throw null;
        }
        this.f2945x = socket;
        w2.q qVar = (w2.q) dVar.f269f;
        if (qVar == null) {
            q1.e.c("sink");
            throw null;
        }
        this.f2946y = new w(qVar);
        w2.r rVar = (w2.r) dVar.f268e;
        if (rVar == null) {
            q1.e.c("source");
            throw null;
        }
        this.f2947z = new y.l(this, new r(rVar), false);
        this.A = new LinkedHashSet();
    }

    public final synchronized void A(long j3) {
        long j4 = this.f2941t + j3;
        this.f2941t = j4;
        long j5 = j4 - this.f2942u;
        if (j5 >= this.f2939r.a() / 2) {
            D(0, j5);
            this.f2942u += j5;
        }
    }

    public final void B(int i3, boolean z2, w2.h hVar, long j3) {
        long j4;
        long j5;
        int iMin;
        long j6;
        if (j3 == 0) {
            this.f2946y.w(z2, i3, hVar, 0);
            return;
        }
        while (j3 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j4 = this.f2943v;
                            j5 = this.f2944w;
                            if (j4 >= j5) {
                                if (!this.f2926d.containsKey(Integer.valueOf(i3))) {
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
                iMin = Math.min((int) Math.min(j3, j5 - j4), this.f2946y.f2993e);
                j6 = iMin;
                this.f2943v += j6;
            }
            j3 -= j6;
            this.f2946y.w(z2 && j3 == 0, i3, hVar, iMin);
        }
    }

    public final void C(int i3, int i4) {
        if (i4 == 0) {
            throw null;
        }
        this.f2932j.c(new j(this.f2927e + '[' + i3 + "] writeSynReset", this, i3, i4, 2), 0L);
    }

    public final void D(int i3, long j3) {
        this.f2932j.c(new m(this.f2927e + '[' + i3 + "] windowUpdate", this, i3, j3), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d(1, 9, null);
    }

    public final void d(int i3, int i4, IOException iOException) {
        int i5;
        Object[] array = null;
        if (i3 == 0 || i4 == 0) {
            throw null;
        }
        byte[] bArr = j2.b.f2361a;
        try {
            z(i3);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.f2926d.isEmpty()) {
                array = this.f2926d.values().toArray(new v[0]);
                this.f2926d.clear();
            }
        }
        v[] vVarArr = (v[]) array;
        if (vVarArr != null) {
            for (v vVar : vVarArr) {
                try {
                    vVar.c(i4, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f2946y.close();
        } catch (IOException unused3) {
        }
        try {
            this.f2945x.close();
        } catch (IOException unused4) {
        }
        this.f2932j.e();
        this.f2933k.e();
        this.f2934l.e();
    }

    public final void flush() {
        this.f2946y.flush();
    }

    public final synchronized v w(int i3) {
        return (v) this.f2926d.get(Integer.valueOf(i3));
    }

    public final synchronized v y(int i3) {
        v vVar;
        vVar = (v) this.f2926d.remove(Integer.valueOf(i3));
        notifyAll();
        return vVar;
    }

    public final void z(int i3) {
        if (i3 == 0) {
            throw null;
        }
        synchronized (this.f2946y) {
            synchronized (this) {
                if (this.f2930h) {
                    return;
                }
                this.f2930h = true;
                this.f2946y.z(j2.b.f2361a, this.f2928f, i3);
            }
        }
    }
}
