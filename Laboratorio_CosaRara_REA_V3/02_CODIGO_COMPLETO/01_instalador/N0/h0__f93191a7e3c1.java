// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f428a = new ThreadLocal();

    public static H a() {
        ThreadLocal threadLocal = f428a;
        H h2 = (H) threadLocal.get();
        if (h2 != null) {
            return h2;
        }
        C0031c c0031c = new C0031c(Thread.currentThread());
        threadLocal.set(c0031c);
        return c0031c;
    }
}
