// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import d2.y;
import i1.o;
import i2.q;
import i2.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f2716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b2.d f2717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f2719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i2.m f2720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f2721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f2722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f2723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f2724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m f2725l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2726m;
    public g0.k n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f2730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile g0.k f2731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile m f2732t;

    public i(u uVar, b2.d dVar, boolean z2) {
        uVar.getClass();
        this.f2716c = uVar;
        this.f2717d = dVar;
        this.f2718e = z2;
        this.f2719f = (y) uVar.f2239d.f905c;
        this.f2720g = uVar.f2242g.c(this);
        h hVar = new h(this);
        hVar.g(0, TimeUnit.MILLISECONDS);
        this.f2721h = hVar;
        this.f2722i = new AtomicBoolean();
        this.f2729q = true;
    }

    public static final String a(i iVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(iVar.f2730r ? "canceled " : "");
        sb.append(iVar.f2718e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(((q) iVar.f2717d.f266c).f());
        return sb.toString();
    }

    public final void b(m mVar) {
        byte[] bArr = j2.b.f2361a;
        if (this.f2725l != null) {
            o2.k("Check failed.");
        } else {
            this.f2725l = mVar;
            mVar.f2754p.add(new g(this, this.f2723j));
        }
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        Socket socketJ;
        byte[] bArr = j2.b.f2361a;
        m mVar = this.f2725l;
        if (mVar != null) {
            synchronized (mVar) {
                socketJ = j();
            }
            if (this.f2725l == null) {
                if (socketJ != null) {
                    j2.b.e(socketJ);
                }
                this.f2720g.getClass();
            } else if (socketJ != null) {
                o2.k("Check failed.");
                return null;
            }
        }
        if (!this.f2726m && this.f2721h.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        i2.m mVar2 = this.f2720g;
        if (iOException == null) {
            mVar2.getClass();
            return interruptedIOException;
        }
        interruptedIOException.getClass();
        mVar2.getClass();
        return interruptedIOException;
    }

    public final Object clone() {
        return new i(this.f2716c, this.f2717d, this.f2718e);
    }

    public final void d() {
        Socket socket;
        if (this.f2730r) {
            return;
        }
        this.f2730r = true;
        g0.k kVar = this.f2731s;
        if (kVar != null) {
            ((n2.e) kVar.f1476g).cancel();
        }
        m mVar = this.f2732t;
        if (mVar != null && (socket = mVar.f2742c) != null) {
            j2.b.e(socket);
        }
        this.f2720g.getClass();
    }

    public final void e(i2.e eVar) {
        if (!this.f2722i.compareAndSet(false, true)) {
            o2.k("Already Executed");
            return;
        }
        q2.m mVar = q2.m.f3156a;
        q2.m.f3156a.getClass();
        f fVar = null;
        this.f2723j = q2.m.f3157b.isLoggable(Level.FINE) ? new Throwable("response.body().close()") : null;
        this.f2720g.getClass();
        y.i iVar = this.f2716c.f2238c;
        f fVar2 = new f(this, eVar);
        iVar.getClass();
        synchronized (iVar) {
            ((ArrayDeque) iVar.f5984b).add(fVar2);
            if (!this.f2718e) {
                String str = ((q) this.f2717d.f266c).f2203d;
                Iterator it = ((ArrayDeque) iVar.f5985c).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        for (f fVar3 : (ArrayDeque) iVar.f5984b) {
                            if (q1.e.a(((q) fVar3.f2713e.f2717d.f266c).f2203d, str)) {
                            }
                        }
                        break;
                    }
                    fVar3 = (f) it.next();
                    if (q1.e.a(((q) fVar3.f2713e.f2717d.f266c).f2203d, str)) {
                    }
                    fVar = fVar3;
                    break;
                }
                if (fVar != null) {
                    fVar2.f2712d = fVar.f2712d;
                }
            }
        }
        iVar.d();
    }

    public final void f(boolean z2) {
        g0.k kVar;
        synchronized (this) {
            if (!this.f2729q) {
                throw new IllegalStateException("released");
            }
        }
        if (z2 && (kVar = this.f2731s) != null) {
            ((n2.e) kVar.f1476g).cancel();
            ((i) kVar.f1473d).h(kVar, true, true, null);
        }
        this.n = null;
    }

    public final i2.y g() {
        ArrayList arrayList = new ArrayList();
        o.B(arrayList, this.f2716c.f2240e);
        arrayList.add(new n2.a(this.f2716c));
        arrayList.add(new n2.a(this.f2716c.f2247l));
        this.f2716c.getClass();
        arrayList.add(new k2.b());
        arrayList.add(a.f2683a);
        if (!this.f2718e) {
            o.B(arrayList, this.f2716c.f2241f);
        }
        arrayList.add(new n2.b(this.f2718e));
        b2.d dVar = this.f2717d;
        u uVar = this.f2716c;
        try {
            try {
                i2.y yVarB = new n2.g(this, arrayList, 0, null, dVar, uVar.f2258x, uVar.f2259y, uVar.f2260z).b(dVar);
                if (this.f2730r) {
                    j2.b.d(yVarB);
                    throw new IOException("Canceled");
                }
                i(null);
                return yVarB;
            } catch (IOException e3) {
                IOException iOExceptionI = i(e3);
                iOExceptionI.getClass();
                throw iOExceptionI;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                i(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:8:0x0011, B:17:0x0020, B:19:0x0024, B:20:0x0026, B:22:0x002a, B:27:0x0033, B:29:0x0037, B:14:0x001a), top: B:53:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0024 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:8:0x0011, B:17:0x0020, B:19:0x0024, B:20:0x0026, B:22:0x002a, B:27:0x0033, B:29:0x0037, B:14:0x001a), top: B:53:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0030  */
    public final IOException h(g0.k kVar, boolean z2, boolean z3, IOException iOException) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        kVar.getClass();
        if (kVar.equals(this.f2731s)) {
            synchronized (this) {
                z4 = false;
                if (z2) {
                    try {
                        if (this.f2727o) {
                            if (z2) {
                                this.f2727o = false;
                            }
                            if (z3) {
                                this.f2728p = false;
                            }
                            z6 = this.f2727o;
                            if (z6) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            if (!z6) {
                                z4 = true;
                            }
                            z5 = z4;
                            z4 = z7;
                        } else if (z3 || !this.f2728p) {
                            z5 = false;
                        } else {
                            if (z2) {
                                this.f2727o = false;
                            }
                            if (z3) {
                                this.f2728p = false;
                            }
                            z6 = this.f2727o;
                            if (z6 || this.f2728p) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            if (!z6 && !this.f2728p && !this.f2729q) {
                                z4 = true;
                            }
                            z5 = z4;
                            z4 = z7;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z3) {
                    }
                    z5 = false;
                }
            }
            if (z4) {
                this.f2731s = null;
                m mVar = this.f2725l;
                if (mVar != null) {
                    synchronized (mVar) {
                        mVar.f2752m++;
                    }
                }
            }
            if (z5) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.f2729q) {
                this.f2729q = false;
                if (!this.f2727o && !this.f2728p) {
                    z2 = true;
                }
            }
        }
        return z2 ? c(iOException) : iOException;
    }

    public final Socket j() {
        m mVar = this.f2725l;
        mVar.getClass();
        byte[] bArr = j2.b.f2361a;
        ArrayList arrayList = mVar.f2754p;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i3 = -1;
                break;
            }
            Object obj = arrayList.get(i4);
            i4++;
            if (q1.e.a(((Reference) obj).get(), this)) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            o2.k("Check failed.");
            return null;
        }
        arrayList.remove(i3);
        this.f2725l = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        mVar.f2755q = System.nanoTime();
        y yVar = this.f2719f;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) yVar.f652b;
        l2.c cVar = (l2.c) yVar.f654d;
        byte[] bArr2 = j2.b.f2361a;
        if (!mVar.f2749j) {
            cVar.c((l2.b) yVar.f651a, 0L);
            return null;
        }
        mVar.f2749j = true;
        concurrentLinkedQueue.remove(mVar);
        if (concurrentLinkedQueue.isEmpty()) {
            cVar.a();
        }
        Socket socket = mVar.f2743d;
        socket.getClass();
        return socket;
    }
}
