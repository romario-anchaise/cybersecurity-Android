// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends m0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f1d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2e = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f3c;

    public static b z() {
        if (f1d != null) {
            return f1d;
        }
        synchronized (b.class) {
            try {
                if (f1d == null) {
                    b bVar = new b();
                    bVar.f3c = new d();
                    f1d = bVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1d;
    }
}
