// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import i2.r;
import i2.u;
import i2.y;
import java.io.IOException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2683a = new a();

    @Override // i2.r
    public final y a(n2.g gVar) throws IOException {
        i iVar = gVar.f2763a;
        synchronized (iVar) {
            try {
                if (!iVar.f2729q) {
                    throw new IllegalStateException("released");
                }
                if (iVar.f2728p) {
                    throw new IllegalStateException("Check failed.");
                }
                if (iVar.f2727o) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar = iVar.f2724k;
        eVar.getClass();
        u uVar = iVar.f2716c;
        uVar.getClass();
        try {
            g0.k kVar = new g0.k(iVar, iVar.f2720g, eVar, eVar.a(gVar.f2768f, gVar.f2769g, gVar.f2770h, uVar.f2243h, !q1.e.a(gVar.f2767e.f265b, "GET")).j(uVar, gVar));
            iVar.n = kVar;
            iVar.f2731s = kVar;
            synchronized (iVar) {
                iVar.f2727o = true;
                iVar.f2728p = true;
            }
            if (!iVar.f2730r) {
                return n2.g.a(gVar, 0, kVar, null, 61).b(gVar.f2767e);
            }
            o2.l("Canceled");
            return null;
        } catch (IOException e3) {
            eVar.b(e3);
            throw new n(e3);
        } catch (n e4) {
            eVar.b(e4.f2757d);
            throw e4;
        }
    }
}
