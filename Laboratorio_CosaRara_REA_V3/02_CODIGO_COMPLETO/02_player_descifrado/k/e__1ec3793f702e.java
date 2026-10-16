// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f2378d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, Throwable th) {
        super(th);
        if (i3 == 0) {
            throw null;
        }
        this.f2377c = i3;
        this.f2378d = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f2378d;
    }
}
