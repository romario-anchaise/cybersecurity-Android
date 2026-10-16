// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import w2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f3302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f3303f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, g gVar, long j3) {
        super(str, true);
        this.f3302e = gVar;
        this.f3303f = j3;
    }

    @Override // l2.a
    public final long a() {
        j jVar;
        g gVar = this.f3302e;
        synchronized (gVar) {
            try {
                if (!gVar.f3323t && (jVar = gVar.f3314j) != null) {
                    int i3 = gVar.f3325v ? gVar.f3324u : -1;
                    gVar.f3324u++;
                    gVar.f3325v = true;
                    if (i3 != -1) {
                        gVar.c(new SocketTimeoutException("sent ping but didn't receive pong within " + gVar.f3307c + "ms (after " + (i3 - 1) + " successful ping/pongs)"), null);
                    } else {
                        try {
                            k kVar = k.f5778f;
                            kVar.getClass();
                            jVar.d(9, kVar);
                        } catch (IOException e3) {
                            gVar.c(e3, null);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f3303f;
    }
}
