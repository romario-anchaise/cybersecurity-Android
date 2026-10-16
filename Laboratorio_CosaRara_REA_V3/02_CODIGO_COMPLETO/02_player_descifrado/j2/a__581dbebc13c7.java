// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j2;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2360b;

    public /* synthetic */ a(String str, boolean z2) {
        this.f2359a = str;
        this.f2360b = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return a0.a.l(runnable, this.f2359a, this.f2360b);
    }
}
