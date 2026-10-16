// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f2410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2411d;

    public a(String str, boolean z2) {
        str.getClass();
        this.f2408a = str;
        this.f2409b = z2;
        this.f2411d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f2408a;
    }
}
