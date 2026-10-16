// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: H.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThreadFactoryC0026a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f190a;

    public /* synthetic */ ThreadFactoryC0026a(String str) {
        this.f190a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f190a);
        thread.setPriority(10);
        return thread;
    }
}
