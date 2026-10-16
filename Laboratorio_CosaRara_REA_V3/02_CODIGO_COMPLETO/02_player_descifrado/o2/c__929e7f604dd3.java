// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import i2.q;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import m2.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f2795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f2798i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, q qVar) {
        super(gVar);
        qVar.getClass();
        this.f2798i = gVar;
        this.f2795f = qVar;
        this.f2796g = -1L;
        this.f2797h = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f2790d) {
            return;
        }
        if (this.f2797h) {
            byte[] bArr = j2.b.f2361a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = j2.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((m) this.f2798i.f2808c).k();
                d();
            }
        }
        this.f2790d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (r9.f2797h == false) goto L25;
     */
    @Override // o2.a, w2.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long f(long r10, w2.h r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.c.f(long, w2.h):long");
    }
}
