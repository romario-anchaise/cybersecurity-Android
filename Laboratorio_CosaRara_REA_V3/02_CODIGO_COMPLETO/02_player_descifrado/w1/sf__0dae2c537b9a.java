// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class sf implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1 f5102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rf f5103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f5104f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f5105g = new AtomicInteger(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b8 f5107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c8 f5108j;

    public sf(long j3, boolean z2, b8 b8Var, rf rfVar) {
        wf.O.incrementAndGet();
        this.f5101c = j3;
        this.f5106h = z2;
        this.f5107i = b8Var;
        this.f5103e = rfVar;
        this.f5102d = q1.a();
    }

    public static void d(sf sfVar, int i3) {
        if (i3 == 0) {
            i3 = 4;
        }
        if (sfVar.f5104f.compareAndSet(false, true)) {
            sfVar.f5105g.compareAndSet(0, i3);
            sfVar.f5102d.close();
            rf rfVar = sfVar.f5103e;
            if (rfVar != null) {
                rfVar.a(sfVar, i3);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f5104f.compareAndSet(false, true)) {
            this.f5102d.close();
            if (this.f5107i != null) {
                wf.b(new v8(12, this));
            }
        }
    }

    public final boolean isOpen() {
        if (this.f5104f.get()) {
            return false;
        }
        if (this.f5106h) {
            return true;
        }
        b8 b8Var = this.f5107i;
        return (b8Var == null || b8Var.f3582g) ? false : true;
    }
}
