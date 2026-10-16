// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j0 f4235d;

    public /* synthetic */ i0(j0 j0Var, int i3) {
        this.f4234c = i3;
        this.f4235d = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        boolean z3;
        switch (this.f4234c) {
            case 0:
                try {
                    this.f4235d.c();
                    return;
                } catch (Throwable th) {
                    Log.e("A11yEventReporter", "periodic a11y sweep survived failure", th);
                    return;
                }
            default:
                j0 j0Var = this.f4235d;
                AtomicBoolean atomicBoolean = j0Var.f4298f;
                AtomicBoolean atomicBoolean2 = j0Var.f4297e;
                AtomicBoolean atomicBoolean3 = j0Var.f4296d;
                while (true) {
                    try {
                        if (atomicBoolean3.get() && atomicBoolean2.getAndSet(false)) {
                            try {
                                j0Var.f4293a.j0();
                            } catch (Throwable th2) {
                                Log.w("A11yEventReporter", "bounded outbox prune failed: " + th2.getMessage());
                            }
                            j0Var.b();
                        }
                    } catch (Throwable th3) {
                        try {
                            Log.e("A11yEventReporter", "a11y sweep survived runtime failure", th3);
                            if (!z2) {
                                return;
                            } else {
                                if (!z3) {
                                    return;
                                }
                            }
                        } finally {
                            atomicBoolean.set(false);
                            if (atomicBoolean3.get() && atomicBoolean2.get()) {
                                j0Var.c();
                            }
                        }
                    }
                }
                atomicBoolean.set(false);
                if (!atomicBoolean3.get() || !atomicBoolean2.get()) {
                    return;
                }
                return;
        }
    }
}
