// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import i2.o;
import i2.u;
import i2.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import m2.m;
import w1.o2;
import w2.i;
import w2.j;
import w2.q;
import w2.r;
import w2.v;
import w2.x;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f2811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2812g;

    public g(u uVar, m mVar, r rVar, q qVar) {
        rVar.getClass();
        qVar.getClass();
        this.f2807b = uVar;
        this.f2808c = mVar;
        this.f2809d = rVar;
        this.f2810e = qVar;
        rVar.getClass();
        d0.d dVar = new d0.d();
        dVar.f532b = rVar;
        dVar.f531a = 262144L;
        this.f2811f = dVar;
    }

    @Override // n2.e
    public long a(y yVar) {
        if (!n2.f.a(yVar)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(y.d(yVar, "Transfer-Encoding"))) {
            return -1L;
        }
        return j2.b.k(yVar);
    }

    @Override // n2.e
    public void b(b2.d dVar) {
        Proxy.Type type = ((m) this.f2808c).f2741b.f2121b.type();
        type.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f265b);
        sb.append(' ');
        i2.q qVar = (i2.q) dVar.f266c;
        if (qVar.f2208i || type != Proxy.Type.HTTP) {
            String strB = qVar.b();
            String strD = qVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(qVar);
        }
        sb.append(" HTTP/1.1");
        j((o) dVar.f267d, sb.toString());
    }

    @Override // n2.e
    public v c(b2.d dVar, long j3) {
        if ("chunked".equalsIgnoreCase(((o) dVar.f267d).a("Transfer-Encoding"))) {
            if (this.f2806a == 1) {
                this.f2806a = 2;
                return new b(this);
            }
            b2.a.g("state: ", this.f2806a);
            return null;
        }
        if (j3 == -1) {
            o2.k("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.f2806a == 1) {
            this.f2806a = 2;
            return new e(this);
        }
        b2.a.g("state: ", this.f2806a);
        return null;
    }

    @Override // n2.e
    public void cancel() {
        Socket socket = ((m) this.f2808c).f2742c;
        if (socket != null) {
            j2.b.e(socket);
        }
    }

    @Override // n2.e
    public void d() {
        ((i) this.f2810e).flush();
    }

    @Override // n2.e
    public void e() {
        ((i) this.f2810e).flush();
    }

    @Override // n2.e
    public x f(y yVar) {
        if (!n2.f.a(yVar)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(y.d(yVar, "Transfer-Encoding"))) {
            i2.q qVar = (i2.q) yVar.f2287c.f266c;
            if (this.f2806a == 4) {
                this.f2806a = 5;
                return new c(this, qVar);
            }
            b2.a.g("state: ", this.f2806a);
            return null;
        }
        long jK = j2.b.k(yVar);
        if (jK != -1) {
            return i(jK);
        }
        if (this.f2806a != 4) {
            b2.a.g("state: ", this.f2806a);
            return null;
        }
        this.f2806a = 5;
        ((m) this.f2808c).k();
        return new f(this);
    }

    @Override // n2.e
    public i2.x g(boolean z2) throws IOException {
        d0.d dVar = (d0.d) this.f2811f;
        int i3 = this.f2806a;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            b2.a.g("state: ", this.f2806a);
            return null;
        }
        try {
            String strG = ((j) dVar.f532b).g(dVar.f531a);
            dVar.f531a -= (long) strG.length();
            g.j jVarX = q2.c.x(strG);
            int i4 = jVarX.f1413b;
            i2.x xVar = new i2.x();
            xVar.f2275b = (i2.v) jVarX.f1414c;
            xVar.f2276c = i4;
            xVar.f2277d = (String) jVarX.f1415d;
            xVar.f2279f = dVar.g().c();
            if (z2 && i4 == 100) {
                return null;
            }
            if (i4 == 100) {
                this.f2806a = 3;
                return xVar;
            }
            if (102 > i4 || i4 >= 200) {
                this.f2806a = 4;
                return xVar;
            }
            this.f2806a = 3;
            return xVar;
        } catch (EOFException e3) {
            throw new IOException("unexpected end of stream on ".concat(((m) this.f2808c).f2741b.f2120a.f2114h.f()), e3);
        }
    }

    @Override // n2.e
    public m h() {
        return (m) this.f2808c;
    }

    public d i(long j3) {
        if (this.f2806a == 4) {
            this.f2806a = 5;
            return new d(this, j3);
        }
        b2.a.g("state: ", this.f2806a);
        return null;
    }

    public void j(o oVar, String str) {
        i iVar = (i) this.f2810e;
        if (this.f2806a != 0) {
            b2.a.g("state: ", this.f2806a);
            return;
        }
        iVar.q(str).q("\r\n");
        int size = oVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            iVar.q(oVar.b(i3)).q(": ").q(oVar.e(i3)).q("\r\n");
        }
        iVar.q("\r\n");
        this.f2806a = 1;
    }

    public g(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f2806a = i3;
        this.f2807b = str == null ? "" : str;
        this.f2808c = str2 == null ? "" : str2;
        this.f2809d = str3 == null ? "" : str3;
        this.f2810e = str4 == null ? "" : str4;
        this.f2811f = str5 == null ? "" : str5;
        this.f2812g = str6;
    }
}
