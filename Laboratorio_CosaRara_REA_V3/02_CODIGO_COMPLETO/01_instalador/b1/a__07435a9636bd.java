// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import X0.D;
import X0.r;
import X0.w;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2098a = new a();

    @Override // X0.r
    public final D a(c1.f fVar) throws IOException {
        j jVar = fVar.f2184a;
        jVar.getClass();
        synchronized (jVar) {
            try {
                if (!jVar.f2141l) {
                    throw new IllegalStateException("released");
                }
                if (jVar.f2140k) {
                    throw new IllegalStateException("Check failed.");
                }
                if (jVar.f2139j) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar2 = jVar.g;
        F0.i.b(fVar2);
        w wVar = jVar.f2131a;
        F0.i.e(wVar, "client");
        try {
            e eVar = new e(jVar, fVar2, fVar2.a(fVar.f2189f, fVar.g, fVar.f2190h, wVar.f1071f, !F0.i.a((String) fVar.f2188e.f1098b, "GET")).j(wVar, fVar));
            jVar.f2138i = eVar;
            jVar.f2143n = eVar;
            synchronized (jVar) {
                jVar.f2139j = true;
                jVar.f2140k = true;
            }
            if (jVar.f2142m) {
                throw new IOException("Canceled");
            }
            return c1.f.a(fVar, 0, eVar, null, 61).b(fVar.f2188e);
        } catch (o e2) {
            fVar2.c(e2.f2169b);
            throw e2;
        } catch (IOException e3) {
            fVar2.c(e3);
            throw new o(e3);
        }
    }
}
