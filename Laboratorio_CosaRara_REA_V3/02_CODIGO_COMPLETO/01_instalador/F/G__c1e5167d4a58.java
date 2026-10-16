// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class G implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
