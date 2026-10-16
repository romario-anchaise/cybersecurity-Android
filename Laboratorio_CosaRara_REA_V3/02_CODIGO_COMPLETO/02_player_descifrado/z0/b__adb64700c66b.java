// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import a2.i;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import y.l;
import y0.h;
import y0.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends o {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f6283o = Logger.getLogger(b.class.getName());
    public boolean n;

    @Override // y0.o
    public final void e() {
        h hVar = new h(1, this);
        int i3 = this.f6117k;
        Logger logger = f6283o;
        if (i3 == 2) {
            logger.fine("transport open - closing");
            hVar.a(new Object[0]);
        } else {
            logger.fine("transport not open - deferring close");
            d("open", hVar);
        }
    }

    @Override // y0.o
    public final void f() {
        h();
    }

    @Override // y0.o
    public final void g(a1.b[] bVarArr) {
        this.f6108b = false;
        l lVar = new l(this, new i(21, this));
        a1.c cVar = a1.f.f43a;
        if (bVarArr.length == 0) {
            lVar.a("0:");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = bVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            boolean z2 = i3 == length + (-1);
            a1.b bVar = bVarArr[i3];
            a1.d dVar = new a1.d(sb, z2);
            Object obj = bVar.f40b;
            if (obj instanceof byte[]) {
                try {
                    dVar.a("b".concat(new String(y.f.h((byte[]) obj), "US-ASCII")));
                } catch (UnsupportedEncodingException e3) {
                    throw new AssertionError(e3);
                }
            } else {
                a1.f.b(bVar, dVar);
            }
            i3++;
        }
        lVar.a(sb.toString());
    }

    public final void h() {
        f6283o.fine("polling");
        this.n = true;
        e eVar = (e) this;
        e.f6292p.fine("xhr poll");
        d dVarI = eVar.i(null);
        dVarI.c("data", new c(eVar, 3));
        dVarI.c("error", new c(eVar, 4));
        dVarI.f();
        a("poll", new Object[0]);
    }
}
