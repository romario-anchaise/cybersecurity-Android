// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import android.media.ImageReader;
import g2.m0;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import w1.e2;
import w1.ie;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f542a;

    public /* synthetic */ b(int i3) {
        this.f542a = i3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0069 A[Catch: InterruptedException -> 0x006d, PHI: r1
  0x0069: PHI (r1v4 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:34:0x0067, B:62:0x00c2] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {InterruptedException -> 0x006d, blocks: (B:61:0x00be, B:35:0x0069, B:33:0x0063, B:28:0x005a), top: B:82:0x0058, inners: #11 }] */
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Future<?> futureSubmit;
        t tVar;
        switch (this.f542a) {
            case 0:
                HashMap map = g.A;
                return;
            case 1:
                ((ImageReader) obj).close();
                return;
            default:
                e2 e2Var = (e2) obj;
                boolean z2 = true;
                if (e2Var.f3853g.compareAndSet(false, true)) {
                    a2.o oVar = e2Var.f3850d;
                    synchronized (oVar) {
                        futureSubmit = null;
                        if (oVar.f123b) {
                            tVar = null;
                        } else {
                            oVar.f123b = true;
                            tVar = (t) oVar.f124c;
                            oVar.f124c = null;
                            oVar.f122a++;
                        }
                    }
                    if (tVar != null) {
                        try {
                            ((m0) tVar.f613d).close();
                            break;
                        } catch (IOException unused) {
                        }
                        try {
                            ((ie) tVar.f614e).run();
                            break;
                        } catch (Throwable unused2) {
                        }
                    }
                    try {
                        futureSubmit = e2Var.f3851e.submit(new a2.b(13, e2Var));
                    } catch (RejectedExecutionException unused3) {
                        e2Var.u();
                    }
                    ExecutorService executorService = e2Var.f3851e;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    boolean z3 = futureSubmit == null;
                    try {
                        try {
                            try {
                                if (futureSubmit != null) {
                                    try {
                                        try {
                                            futureSubmit.get(10L, timeUnit);
                                        } catch (InterruptedException unused4) {
                                            executorService.shutdown();
                                            if (!executorService.awaitTermination(10L, timeUnit)) {
                                                executorService.shutdownNow();
                                            }
                                            Thread.currentThread().interrupt();
                                            z2 = z3;
                                        }
                                    } catch (TimeoutException unused5) {
                                        futureSubmit.cancel(true);
                                        executorService.shutdown();
                                        if (!executorService.awaitTermination(10L, timeUnit)) {
                                            executorService.shutdownNow();
                                        }
                                        z2 = z3;
                                    } catch (Exception unused6) {
                                        executorService.shutdown();
                                        if (!executorService.awaitTermination(10L, timeUnit)) {
                                            executorService.shutdownNow();
                                        }
                                    }
                                } else {
                                    z2 = z3;
                                }
                                executorService.shutdown();
                                if (!executorService.awaitTermination(10L, timeUnit)) {
                                    executorService.shutdownNow();
                                }
                            } catch (InterruptedException unused7) {
                                executorService.shutdownNow();
                                Thread.currentThread().interrupt();
                            }
                            break;
                        } catch (InterruptedException unused8) {
                            executorService.shutdownNow();
                            Thread.currentThread().interrupt();
                            z2 = z3;
                        }
                        if (z2) {
                            executorService.isShutdown();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        executorService.shutdown();
                        try {
                            if (!executorService.awaitTermination(10L, timeUnit)) {
                                executorService.shutdownNow();
                            }
                            break;
                        } catch (InterruptedException unused9) {
                            executorService.shutdownNow();
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                }
                return;
        }
    }
}
