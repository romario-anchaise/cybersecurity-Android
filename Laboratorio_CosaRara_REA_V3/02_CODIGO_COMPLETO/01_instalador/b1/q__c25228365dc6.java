// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import A.C0005e;
import X0.C;
import X0.C0054a;
import X0.D;
import X0.w;
import X0.x;
import X0.y;
import androidx.recyclerview.widget.C0085c;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import k1.B;
import k1.G;
import k1.I;

/* JADX INFO: loaded from: classes.dex */
public final class q implements c1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f2177f;
    public Iterable g;

    public q(C0054a c0054a, C0005e c0005e, j jVar) {
        List listL;
        F0.i.e(c0005e, "routeDatabase");
        F0.i.e(jVar, "call");
        this.f2173b = c0054a;
        this.f2174c = c0005e;
        this.f2175d = jVar;
        p036u0.n nVar = p036u0.n.f4146a;
        this.f2176e = nVar;
        this.f2177f = nVar;
        this.g = new ArrayList();
        X0.p pVar = c0054a.f941h;
        F0.i.e(pVar, "url");
        URI uriH = pVar.h();
        if (uriH.getHost() == null) {
            listL = Y0.b.l(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = c0054a.g.select(uriH);
            listL = (listSelect == null || listSelect.isEmpty()) ? Y0.b.l(Proxy.NO_PROXY) : Y0.b.w(listSelect);
        }
        this.f2176e = listL;
        this.f2172a = 0;
    }

    @Override // c1.d
    public void a() {
        ((B) this.f2176e).flush();
    }

    @Override // c1.d
    public I b(D d2) {
        if (!c1.e.a(d2)) {
            return j(0L);
        }
        if ("chunked".equalsIgnoreCase(D.a(d2, "Transfer-Encoding"))) {
            X0.p pVar = (X0.p) d2.f904a.f1099c;
            if (this.f2172a == 4) {
                this.f2172a = 5;
                return new d1.c(this, pVar);
            }
            throw new IllegalStateException(("state: " + this.f2172a).toString());
        }
        long jK = Y0.b.k(d2);
        if (jK != -1) {
            return j(jK);
        }
        if (this.f2172a == 4) {
            this.f2172a = 5;
            ((m) this.f2174c).k();
            return new d1.f(this);
        }
        throw new IllegalStateException(("state: " + this.f2172a).toString());
    }

    @Override // c1.d
    public long c(D d2) {
        if (!c1.e.a(d2)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(D.a(d2, "Transfer-Encoding"))) {
            return -1L;
        }
        return Y0.b.k(d2);
    }

    @Override // c1.d
    public void cancel() {
        Socket socket = ((m) this.f2174c).f2150c;
        if (socket != null) {
            Y0.b.e(socket);
        }
    }

    @Override // c1.d
    public void d() {
        ((B) this.f2176e).flush();
    }

    @Override // c1.d
    public G e(y yVar, long j2) {
        F0.i.e(yVar, "request");
        if ("chunked".equalsIgnoreCase(((X0.n) yVar.f1100d).a("Transfer-Encoding"))) {
            if (this.f2172a == 1) {
                this.f2172a = 2;
                return new d1.b(this);
            }
            throw new IllegalStateException(("state: " + this.f2172a).toString());
        }
        if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f2172a == 1) {
            this.f2172a = 2;
            return new d1.e(this);
        }
        throw new IllegalStateException(("state: " + this.f2172a).toString());
    }

    @Override // c1.d
    public C f(boolean z2) {
        C0085c c0085c = (C0085c) this.f2177f;
        int i2 = this.f2172a;
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalStateException(("state: " + this.f2172a).toString());
        }
        try {
            String strY = ((k1.C) c0085c.f1905c).y(c0085c.f1904b);
            c0085c.f1904b -= (long) strY.length();
            c1.g gVarM = f1.l.M(strY);
            int i3 = gVarM.f2193b;
            C c2 = new C();
            c2.f893b = (x) gVarM.f2194c;
            c2.f894c = i3;
            c2.f895d = (String) gVarM.f2195d;
            c2.f897f = c0085c.f().c();
            if (z2 && i3 == 100) {
                return null;
            }
            if (i3 == 100) {
                this.f2172a = 3;
                return c2;
            }
            if (102 > i3 || i3 >= 200) {
                this.f2172a = 4;
                return c2;
            }
            this.f2172a = 3;
            return c2;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on ".concat(((m) this.f2174c).f2149b.f926a.f941h.g()), e2);
        }
    }

    @Override // c1.d
    public void g(y yVar) {
        F0.i.e(yVar, "request");
        Proxy.Type type = ((m) this.f2174c).f2149b.f927b.type();
        F0.i.d(type, "connection.route().proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append((String) yVar.f1098b);
        sb.append(' ');
        X0.p pVar = (X0.p) yVar.f1099c;
        if (pVar.f1029j || type != Proxy.Type.HTTP) {
            String strB = pVar.b();
            String strD = pVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(pVar);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        F0.i.d(string, "StringBuilder().apply(builderAction).toString()");
        k((X0.n) yVar.f1100d, string);
    }

    @Override // c1.d
    public m h() {
        return (m) this.f2174c;
    }

    public boolean i() {
        return this.f2172a < ((List) this.f2176e).size() || !((ArrayList) this.g).isEmpty();
    }

    public d1.d j(long j2) {
        if (this.f2172a == 4) {
            this.f2172a = 5;
            return new d1.d(this, j2);
        }
        throw new IllegalStateException(("state: " + this.f2172a).toString());
    }

    public void k(X0.n nVar, String str) {
        F0.i.e(str, "requestLine");
        if (this.f2172a != 0) {
            throw new IllegalStateException(("state: " + this.f2172a).toString());
        }
        B b2 = (B) this.f2176e;
        b2.k(str);
        b2.k("\r\n");
        int size = nVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            b2.k(nVar.b(i2));
            b2.k(": ");
            b2.k(nVar.d(i2));
            b2.k("\r\n");
        }
        b2.k("\r\n");
        this.f2172a = 1;
    }

    public q(w wVar, m mVar, k1.C c2, B b2) {
        F0.i.e(mVar, "connection");
        F0.i.e(c2, "source");
        F0.i.e(b2, "sink");
        this.f2173b = wVar;
        this.f2174c = mVar;
        this.f2175d = c2;
        this.f2176e = b2;
        this.f2177f = new C0085c(c2);
    }
}
