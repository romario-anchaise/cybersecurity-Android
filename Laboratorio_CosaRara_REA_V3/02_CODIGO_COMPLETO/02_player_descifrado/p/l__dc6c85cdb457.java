// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.content.Context;
import androidx.work.WorkerParameters;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WorkerParameters f2851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f2852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2853d;

    public l(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            o2.i("Application Context is null");
            throw null;
        }
        if (workerParameters == null) {
            o2.i("WorkerParameters is null");
            throw null;
        }
        this.f2850a = context;
        this.f2851b = workerParameters;
    }

    public a0.l a() {
        a0.l lVar = new a0.l();
        lVar.j(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return lVar;
    }

    public abstract a0.l e();

    public final void f() {
        this.f2852c = true;
        b();
    }

    public void b() {
    }
}
