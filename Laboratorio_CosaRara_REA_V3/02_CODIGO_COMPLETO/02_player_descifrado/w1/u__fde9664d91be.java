// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f5211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f5213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f5214g;

    public /* synthetic */ u(x xVar, long j3, long j4, Runnable runnable, int i3) {
        this.f5210c = i3;
        this.f5214g = xVar;
        this.f5211d = j3;
        this.f5212e = j4;
        this.f5213f = runnable;
    }

    private final void a() {
        synchronized (this.f5214g.f5463c) {
            try {
                x xVar = this.f5214g;
                if (!xVar.f5480u && this.f5211d == xVar.f5474o) {
                    Long l3 = xVar.f5473m.isEmpty() ? null : (Long) this.f5214g.f5473m.first();
                    if (l3 != null && l3.longValue() <= this.f5212e) {
                        if (!this.f5214g.f5468h.post(this)) {
                            this.f5214g.f5470j.n++;
                        }
                        return;
                    }
                    x xVar2 = this.f5214g;
                    Runnable runnable = this.f5213f;
                    long j3 = this.f5211d;
                    u uVar = new u(xVar2, j3, this.f5212e, runnable, 1);
                    synchronized (xVar2.f5463c) {
                        if (xVar2.f5480u || j3 != xVar2.f5474o) {
                            return;
                        }
                        try {
                            if (xVar2.f5469i.post(uVar)) {
                                return;
                            }
                            xVar2.f5471k.n++;
                        } catch (Throwable unused) {
                            xVar2.f5471k.n++;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.f5210c) {
            case 0:
                a();
                return;
            default:
                synchronized (this.f5214g.f5463c) {
                    try {
                        x xVar = this.f5214g;
                        if (!xVar.f5480u && this.f5211d == xVar.f5474o) {
                            Long l3 = xVar.n.isEmpty() ? null : (Long) this.f5214g.n.first();
                            if (l3 != null && l3.longValue() <= this.f5212e) {
                                if (!this.f5214g.f5469i.post(this)) {
                                    this.f5214g.f5471k.n++;
                                }
                                return;
                            }
                            long jNanoTime = System.nanoTime();
                            try {
                                this.f5213f.run();
                                x xVar2 = this.f5214g;
                                xVar2.J(xVar2.f5471k, jNanoTime);
                                synchronized (this.f5214g.f5463c) {
                                    this.f5214g.f5463c.notifyAll();
                                    break;
                                }
                                return;
                            } catch (Throwable th) {
                                try {
                                    Log.e("A11yEventPipeline", "ordered collection task failed", th);
                                    x xVar3 = this.f5214g;
                                    xVar3.B(xVar3.f5471k);
                                    synchronized (obj) {
                                        return;
                                    }
                                } finally {
                                    x xVar4 = this.f5214g;
                                    xVar4.J(xVar4.f5471k, jNanoTime);
                                    synchronized (this.f5214g.f5463c) {
                                        this.f5214g.f5463c.notifyAll();
                                    }
                                }
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
        }
    }
}
