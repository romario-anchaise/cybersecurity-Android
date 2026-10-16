// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d1;

import F0.h;
import F0.i;
import X0.n;
import X0.p;
import X0.w;
import androidx.recyclerview.widget.C0085c;
import b1.m;
import b1.q;
import f1.l;
import java.io.EOFException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k1.C;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f2216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2218f;
    public final /* synthetic */ q g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(q qVar, p pVar) {
        super(qVar);
        i.e(pVar, "url");
        this.g = qVar;
        this.f2216d = pVar;
        this.f2217e = -1L;
        this.f2218f = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2211b) {
            return;
        }
        if (this.f2218f && !Y0.b.h(this, TimeUnit.MILLISECONDS)) {
            ((m) this.g.f2174c).k();
            a();
        }
        this.f2211b = true;
    }

    @Override // d1.a, k1.I
    public final long m(C0193i c0193i, long j2) throws ProtocolException, EOFException {
        C0193i c0193i2;
        long j3;
        i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(h.d("byteCount < 0: ", j2).toString());
        }
        if (this.f2211b) {
            throw new IllegalStateException("closed");
        }
        if (!this.f2218f) {
            return -1L;
        }
        long j4 = this.f2217e;
        q qVar = this.g;
        if (j4 == 0 || j4 == -1) {
            if (j4 != -1) {
                ((C) qVar.f2175d).y(Long.MAX_VALUE);
            }
            try {
                C c2 = (C) qVar.f2175d;
                c2.z(1L);
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    boolean zQ = c2.q(i3);
                    c0193i2 = c2.f3442b;
                    if (!zQ) {
                        break;
                    }
                    byte bX = c0193i2.x(i2);
                    if ((bX >= 48 && bX <= 57) || ((bX >= 97 && bX <= 102) || (bX >= 65 && bX <= 70))) {
                        i2 = i3;
                    }
                    if (i2 != 0) {
                        break;
                    }
                    l.k(16);
                    String string = Integer.toString(bX, 16);
                    i.d(string, "toString(...)");
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
                }
                this.f2217e = c0193i2.E();
                String string2 = M0.e.j0(((C) qVar.f2175d).y(Long.MAX_VALUE)).toString();
                if (this.f2217e < 0 || (string2.length() > 0 && !M0.m.R(string2, ";", false))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f2217e + string2 + '\"');
                }
                if (this.f2217e == 0) {
                    this.f2218f = false;
                    qVar.g = ((C0085c) qVar.f2177f).f();
                    w wVar = (w) qVar.f2173b;
                    i.b(wVar);
                    n nVar = (n) qVar.g;
                    i.b(nVar);
                    c1.e.b(wVar.f1074j, this.f2216d, nVar);
                    a();
                }
                if (!this.f2218f) {
                    return -1L;
                }
                j3 = -1;
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        } else {
            j3 = -1;
        }
        long jM = super.m(c0193i, Math.min(j2, this.f2217e));
        if (jM != j3) {
            this.f2217e -= jM;
            return jM;
        }
        ((m) qVar.f2174c).k();
        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
        a();
        throw protocolException;
    }
}
