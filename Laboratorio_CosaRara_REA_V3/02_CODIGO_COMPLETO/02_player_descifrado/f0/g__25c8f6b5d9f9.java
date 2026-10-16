// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends UnsupportedOperationException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0.d f1108c;

    public g(e0.d dVar) {
        this.f1108c = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f1108c));
    }
}
