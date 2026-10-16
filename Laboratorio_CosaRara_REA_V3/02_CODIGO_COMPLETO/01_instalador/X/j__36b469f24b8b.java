// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class j implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new i(runnable);
    }
}
