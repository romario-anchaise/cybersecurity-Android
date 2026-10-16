// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import H.x;
import X0.D;
import X0.InterfaceC0058e;
import X0.w;
import X0.y;
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

/* JADX INFO: loaded from: classes.dex */
public final class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f2131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f2134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f2135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f2136f;
    public f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f2137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f2138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f2142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile e f2143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile m f2144o;

    public j(w wVar, y yVar) {
        F0.i.e(wVar, "client");
        F0.i.e(yVar, "originalRequest");
        this.f2131a = wVar;
        this.f2132b = yVar;
        this.f2133c = (n) wVar.f1067b.f34b;
        wVar.f1070e.getClass();
        i iVar = new i(this);
        iVar.g(0, TimeUnit.MILLISECONDS);
        this.f2134d = iVar;
        this.f2135e = new AtomicBoolean();
        this.f2141l = true;
    }

    public static final String b(j jVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(jVar.f2142m ? "canceled " : "");
        sb.append("call");
        sb.append(" to ");
        sb.append(((X0.p) jVar.f2132b.f1099c).g());
        return sb.toString();
    }

    public final void c(m mVar) {
        byte[] bArr = Y0.b.f1119a;
        if (this.f2137h != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.f2137h = mVar;
        mVar.f2162p.add(new h(this, this.f2136f));
    }

    public final void cancel() {
        Socket socket;
        if (this.f2142m) {
            return;
        }
        this.f2142m = true;
        e eVar = this.f2143n;
        if (eVar != null) {
            eVar.f2115c.cancel();
        }
        m mVar = this.f2144o;
        if (mVar == null || (socket = mVar.f2150c) == null) {
            return;
        }
        Y0.b.e(socket);
    }

    public final Object clone() {
        return new j(this.f2131a, this.f2132b);
    }

    public final IOException d(IOException iOException) {
        IOException interruptedIOException;
        Socket socketM;
        byte[] bArr = Y0.b.f1119a;
        m mVar = this.f2137h;
        if (mVar != null) {
            synchronized (mVar) {
                socketM = m();
            }
            if (this.f2137h == null) {
                if (socketM != null) {
                    Y0.b.e(socketM);
                }
            } else if (socketM != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (this.f2134d.i()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            F0.i.b(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final void e(InterfaceC0058e interfaceC0058e) {
        g gVar;
        if (!this.f2135e.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        f1.n nVar = f1.n.f2736a;
        this.f2136f = f1.n.f2736a.g();
        x xVar = this.f2131a.f1066a;
        g gVar2 = new g(this, interfaceC0058e);
        xVar.getClass();
        synchronized (xVar) {
            ((ArrayDeque) xVar.f247b).add(gVar2);
            String str = ((X0.p) this.f2132b.f1099c).f1024d;
            Iterator it = ((ArrayDeque) xVar.f248c).iterator();
            do {
                if (!it.hasNext()) {
                    Iterator it2 = ((ArrayDeque) xVar.f247b).iterator();
                    do {
                        if (!it2.hasNext()) {
                            gVar = null;
                            break;
                        }
                        gVar = (g) it2.next();
                    } while (!F0.i.a(((X0.p) gVar.f2128c.f2132b.f1099c).f1024d, str));
                } else {
                    gVar = (g) it.next();
                }
            } while (!F0.i.a(((X0.p) gVar.f2128c.f2132b.f1099c).f1024d, str));
            if (gVar != null) {
                gVar2.f2127b = gVar.f2127b;
            }
        }
        xVar.h();
    }

    public final D g() {
        if (!this.f2135e.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.f2134d.h();
        f1.n nVar = f1.n.f2736a;
        this.f2136f = f1.n.f2736a.g();
        try {
            x xVar = this.f2131a.f1066a;
            synchronized (xVar) {
                ((ArrayDeque) xVar.f249d).add(this);
            }
            D dI = i();
            x xVar2 = this.f2131a.f1066a;
            xVar2.getClass();
            xVar2.b((ArrayDeque) xVar2.f249d, this);
            return dI;
        } catch (Throwable th) {
            x xVar3 = this.f2131a.f1066a;
            xVar3.getClass();
            xVar3.b((ArrayDeque) xVar3.f249d, this);
            throw th;
        }
    }

    public final void h(boolean z2) {
        e eVar;
        synchronized (this) {
            if (!this.f2141l) {
                throw new IllegalStateException("released");
            }
        }
        if (z2 && (eVar = this.f2143n) != null) {
            eVar.f2115c.cancel();
            eVar.f2113a.k(eVar, true, true, null);
        }
        this.f2138i = null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0085  */
    public final D i() throws Throwable {
        ArrayList arrayList = new ArrayList();
        p036u0.l.r(this.f2131a.f1068c, arrayList);
        arrayList.add(new c1.a(this.f2131a));
        arrayList.add(new c1.a(this.f2131a.f1074j));
        this.f2131a.getClass();
        arrayList.add(new Z0.b());
        arrayList.add(a.f2098a);
        p036u0.l.r(this.f2131a.f1069d, arrayList);
        arrayList.add(new c1.b());
        y yVar = this.f2132b;
        w wVar = this.f2131a;
        boolean z2 = false;
        try {
            D dB = new c1.f(this, arrayList, 0, null, yVar, wVar.f1086v, wVar.f1087w, wVar.f1088x).b(this.f2132b);
            if (this.f2142m) {
                Y0.b.d(dB);
                throw new IOException("Canceled");
            }
            l(null);
            return dB;
        } catch (IOException e2) {
            try {
                IOException iOExceptionL = l(e2);
                F0.i.c(iOExceptionL, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionL;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                if (!z2) {
                    l(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z2) {
                l(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0020 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0022 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001c), top: B:53:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0026 A[Catch: all -> 0x0018, TryCatch #1 {all -> 0x0018, blocks: (B:8:0x0013, B:17:0x0022, B:19:0x0026, B:20:0x0028, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001c), top: B:53:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final IOException k(e eVar, boolean z2, boolean z3, IOException iOException) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        F0.i.e(eVar, "exchange");
        if (!eVar.equals(this.f2143n)) {
            return iOException;
        }
        synchronized (this) {
            z4 = false;
            if (z2) {
                try {
                    if (this.f2139j) {
                        if (z2) {
                            this.f2139j = false;
                        }
                        if (z3) {
                            this.f2140k = false;
                        }
                        z6 = this.f2139j;
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
                    } else if (z3 || !this.f2140k) {
                        z5 = false;
                    } else {
                        if (z2) {
                            this.f2139j = false;
                        }
                        if (z3) {
                            this.f2140k = false;
                        }
                        z6 = this.f2139j;
                        if (z6 || this.f2140k) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (!z6 && !this.f2140k && !this.f2141l) {
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
            this.f2143n = null;
            m mVar = this.f2137h;
            if (mVar != null) {
                synchronized (mVar) {
                    mVar.f2159m++;
                }
            }
        }
        return z5 ? d(iOException) : iOException;
    }

    public final IOException l(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.f2141l) {
                this.f2141l = false;
                if (!this.f2139j && !this.f2140k) {
                    z2 = true;
                }
            }
        }
        return z2 ? d(iOException) : iOException;
    }

    public final Socket m() {
        m mVar = this.f2137h;
        F0.i.b(mVar);
        byte[] bArr = Y0.b.f1119a;
        ArrayList arrayList = mVar.f2162p;
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (F0.i.a(((Reference) it.next()).get(), this)) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i2);
        this.f2137h = null;
        if (arrayList.isEmpty()) {
            mVar.f2163q = System.nanoTime();
            n nVar = this.f2133c;
            nVar.getClass();
            byte[] bArr2 = Y0.b.f1119a;
            boolean z2 = mVar.f2156j;
            a1.c cVar = nVar.f2165b;
            if (z2) {
                mVar.f2156j = true;
                ConcurrentLinkedQueue concurrentLinkedQueue = nVar.f2167d;
                concurrentLinkedQueue.remove(mVar);
                if (concurrentLinkedQueue.isEmpty()) {
                    cVar.a();
                }
                Socket socket = mVar.f2151d;
                F0.i.b(socket);
                return socket;
            }
            cVar.c(nVar.f2166c, 0L);
        }
        return null;
    }
}
