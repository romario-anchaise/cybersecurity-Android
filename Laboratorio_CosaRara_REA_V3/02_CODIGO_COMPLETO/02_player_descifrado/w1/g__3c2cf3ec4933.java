// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4058c;

    public /* synthetic */ g(int i3) {
        this.f4058c = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Handler handler;
        Context context2;
        Handler handler2;
        String str;
        int i3 = 2;
        switch (this.f4058c) {
            case 0:
                synchronized (n.f4563a) {
                    if (n.f4567e && n.f4565c != null && (context = n.f4566d) != null) {
                        try {
                            Object obj = f.f3944a;
                            f.a(context, new c(Process.myPid(), i3, SystemClock.elapsedRealtime()));
                            break;
                        } catch (Throwable th) {
                            a0.a.p(th, new StringBuilder("heartbeat failed: "), "A11yBindLeaseWriter");
                        }
                        synchronized (n.f4563a) {
                            try {
                                if (n.f4567e && (handler = n.f4565c) != null && n.f4566d == context) {
                                    handler.postDelayed(this, 5000L);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        return;
                    }
                    return;
                }
            case 1:
                Object obj2 = n.f4570h;
                synchronized (obj2) {
                    context2 = n.f4573k;
                    handler2 = n.f4572j;
                    break;
                }
                if (context2 == null || handler2 == null) {
                    return;
                }
                try {
                    boolean zA = n.p0(context2).a();
                    e eVarA = f.a(context2, null);
                    int iH = n.h(zA, eVarA.f3824b, eVarA.f3827e, eVarA.f3829g, SystemClock.elapsedRealtime());
                    synchronized (obj2) {
                        try {
                            if (iH != n.f4574l) {
                                StringBuilder sb = new StringBuilder("state=");
                                if (iH == 1) {
                                    str = "BOUND";
                                } else if (iH == 2) {
                                    str = "ENABLED_UNBOUND";
                                } else if (iH != 3) {
                                    str = iH != 4 ? "null" : "GRACE";
                                } else {
                                    str = "DISABLED";
                                }
                                sb.append(str);
                                sb.append(" settingsEnabled=");
                                sb.append(zA);
                                Log.i("A11yBindMonitor", sb.toString());
                                n.f4574l = iH;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                        break;
                    }
                } catch (Throwable th4) {
                    a0.a.p(th4, new StringBuilder("observation failed: "), "A11yBindMonitor");
                }
                synchronized (n.f4570h) {
                    try {
                        if (n.f4572j == handler2) {
                            handler2.postDelayed(this, 5000L);
                        }
                    } catch (Throwable th5) {
                        throw th5;
                    }
                    break;
                }
                return;
            default:
                AtomicBoolean atomicBoolean = b0.f3530b;
                if (atomicBoolean.get()) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    long andSet = b0.f3532d.getAndSet(jUptimeMillis > 9223372036854774807L ? Long.MAX_VALUE : jUptimeMillis + 1000);
                    if (andSet > 0 && jUptimeMillis >= andSet) {
                        b0.f3533e.accumulateAndGet(jUptimeMillis - andSet, new z());
                    }
                    if (atomicBoolean.get()) {
                        b0.f3529a.postDelayed(this, 1000L);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
