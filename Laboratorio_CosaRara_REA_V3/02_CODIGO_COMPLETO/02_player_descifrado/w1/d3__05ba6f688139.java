// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d3 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f3 f3765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3766e;

    public /* synthetic */ d3(f3 f3Var, long j3, int i3) {
        this.f3764c = i3;
        this.f3765d = f3Var;
        this.f3766e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        y.l lVarB;
        switch (this.f3764c) {
            case 0:
                f3 f3Var = this.f3765d;
                long j3 = this.f3766e;
                try {
                    lVarB = f3Var.b();
                    try {
                        synchronized (f3Var.f3974j) {
                            if (f3Var.f3976l == null || f3Var.f3979p != j3) {
                                lVarB.g(false);
                            } else {
                                f3Var.f(lVarB);
                            }
                        }
                        return;
                    } catch (Exception e3) {
                        e = e3;
                        if (lVarB != null) {
                            lVarB.g(false);
                        }
                        Log.w("TelemetryReporter", "telemetry report failed: " + e.getMessage());
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                    lVarB = null;
                }
                break;
            default:
                f3 f3Var2 = this.f3765d;
                long j4 = this.f3766e;
                try {
                    f3Var2.c(j4);
                    synchronized (f3Var2.f3974j) {
                        try {
                            if (f3Var2.f3979p != j4) {
                                return;
                            }
                            f3Var2.f3977m = null;
                            if (f3Var2.n && f3Var2.f3976l != null) {
                                f3Var2.n = false;
                                f3Var2.e(j4);
                            }
                            return;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (f3Var2.f3974j) {
                        try {
                            if (f3Var2.f3979p != j4) {
                                return;
                            }
                            f3Var2.f3977m = null;
                            if (f3Var2.n && f3Var2.f3976l != null) {
                                f3Var2.n = false;
                                f3Var2.e(j4);
                            }
                            throw th2;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
        }
    }
}
