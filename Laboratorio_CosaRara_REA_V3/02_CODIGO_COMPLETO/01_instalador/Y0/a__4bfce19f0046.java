// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Y0;

import F0.i;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1118b;

    public /* synthetic */ a(String str, boolean z2) {
        this.f1117a = str;
        this.f1118b = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f1117a;
        i.e(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(this.f1118b);
        return thread;
    }
}
