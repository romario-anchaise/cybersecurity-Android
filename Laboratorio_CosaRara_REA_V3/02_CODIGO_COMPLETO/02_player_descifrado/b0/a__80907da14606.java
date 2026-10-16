// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import p0.e;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f253c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f254d;

    public a() {
        e eVar = new e(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f254d = eVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f253c) {
            case 0:
                ((Handler) ((r) this.f254d).f6033b).post(runnable);
                break;
            default:
                ((e) this.f254d).post(runnable);
                break;
        }
    }

    public a(r rVar) {
        this.f254d = rVar;
    }
}
