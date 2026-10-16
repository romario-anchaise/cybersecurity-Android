// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2052a = false;

    public synchronized boolean a(Runnable runnable) {
        if (this.f2052a) {
            return false;
        }
        runnable.run();
        return true;
    }
}
