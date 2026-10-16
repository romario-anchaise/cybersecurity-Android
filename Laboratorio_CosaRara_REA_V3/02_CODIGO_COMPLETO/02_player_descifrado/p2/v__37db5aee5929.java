// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;
import java.util.ArrayDeque;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f2978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f2983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t f2985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s f2986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f2987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u f2988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2989m;
    public IOException n;

    public v(int i3, n nVar, boolean z2, boolean z3, i2.o oVar) {
        nVar.getClass();
        this.f2977a = i3;
        this.f2978b = nVar;
        this.f2982f = nVar.f2940s.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f2983g = arrayDeque;
        this.f2985i = new t(this, nVar.f2939r.a(), z3);
        this.f2986j = new s(this, z2);
        this.f2987k = new u(this);
        this.f2988l = new u(this);
        if (oVar == null) {
            if (g()) {
                return;
            }
            o2.k("remotely-initiated streams should have headers");
            throw null;
        }
        if (g()) {
            o2.k("locally-initiated streams shouldn't have headers yet");
            throw null;
        }
        arrayDeque.add(oVar);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001c  */
    public final void a() {
        boolean z2;
        boolean zH;
        byte[] bArr = j2.b.f2361a;
        synchronized (this) {
            try {
                t tVar = this.f2985i;
                if (tVar.f2971d || !tVar.f2974g) {
                    z2 = false;
                } else {
                    s sVar = this.f2986j;
                    if (sVar.f2966c || sVar.f2968e) {
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
            this.f2978b.y(this.f2977a);
        }
    }

    public final void b() throws IOException {
        s sVar = this.f2986j;
        if (sVar.f2968e) {
            o2.l("stream closed");
            return;
        }
        if (sVar.f2966c) {
            o2.l("stream finished");
            return;
        }
        int i3 = this.f2989m;
        if (i3 != 0) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            if (i3 == 0) {
                throw null;
            }
            throw new b0(i3);
        }
    }

    public final void c(int i3, IOException iOException) {
        if (i3 == 0) {
            throw null;
        }
        if (d(i3, iOException)) {
            n nVar = this.f2978b;
            nVar.getClass();
            nVar.f2946y.C(this.f2977a, i3);
        }
    }

    public final boolean d(int i3, IOException iOException) {
        byte[] bArr = j2.b.f2361a;
        synchronized (this) {
            if (this.f2989m != 0) {
                return false;
            }
            this.f2989m = i3;
            this.n = iOException;
            notifyAll();
            if (this.f2985i.f2971d && this.f2986j.f2966c) {
                return false;
            }
            this.f2978b.y(this.f2977a);
            return true;
        }
    }

    public final void e(int i3) {
        if (i3 == 0) {
            throw null;
        }
        if (d(i3, null)) {
            this.f2978b.C(this.f2977a, i3);
        }
    }

    public final s f() {
        synchronized (this) {
            if (!this.f2984h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f2986j;
    }

    public final boolean g() {
        boolean z2 = (this.f2977a & 1) == 1;
        this.f2978b.getClass();
        return true == z2;
    }

    public final synchronized boolean h() {
        try {
            if (this.f2989m != 0) {
                return false;
            }
            t tVar = this.f2985i;
            if (tVar.f2971d || tVar.f2974g) {
                s sVar = this.f2986j;
                if ((sVar.f2966c || sVar.f2968e) && this.f2984h) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(i2.o oVar, boolean z2) {
        boolean zH;
        oVar.getClass();
        byte[] bArr = j2.b.f2361a;
        synchronized (this) {
            try {
                if (this.f2984h && z2) {
                    this.f2985i.getClass();
                } else {
                    this.f2984h = true;
                    this.f2983g.add(oVar);
                }
                if (z2) {
                    this.f2985i.f2971d = true;
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
        this.f2978b.y(this.f2977a);
    }
}
