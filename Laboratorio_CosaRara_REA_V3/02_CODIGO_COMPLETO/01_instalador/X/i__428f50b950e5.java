// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4185a;

    public i(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f4185a = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f4185a);
        super.run();
    }
}
