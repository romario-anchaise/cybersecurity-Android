// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: m1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorC0197a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f3832a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f3832a.post(runnable);
    }
}
