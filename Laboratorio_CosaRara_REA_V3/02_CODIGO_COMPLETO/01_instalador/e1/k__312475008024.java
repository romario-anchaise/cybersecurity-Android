// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class k implements E0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f2310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f2311b;

    public k(o oVar, s sVar) {
        this.f2311b = oVar;
        this.f2310a = sVar;
    }

    @Override // E0.a
    public final Object a() {
        o oVar = this.f2311b;
        s sVar = this.f2310a;
        try {
            if (!sVar.a(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            while (sVar.a(false, this)) {
            }
            oVar.a(1, 9, null);
            Y0.b.d(sVar);
            return p034t0.h.f4132b;
        } catch (IOException e2) {
            oVar.a(2, 2, e2);
        } catch (Throwable th) {
            oVar.a(3, 3, null);
            Y0.b.d(sVar);
            throw th;
        }
    }
}
