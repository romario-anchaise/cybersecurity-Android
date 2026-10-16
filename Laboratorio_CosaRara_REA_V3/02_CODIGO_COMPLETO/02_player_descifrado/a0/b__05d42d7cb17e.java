// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f9d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f11b;

    static {
        if (j.f28f) {
            f9d = null;
            f8c = null;
        } else {
            f9d = new b(false, null);
            f8c = new b(true, null);
        }
    }

    public b(boolean z2, Throwable th) {
        this.f10a = z2;
        this.f11b = th;
    }
}
