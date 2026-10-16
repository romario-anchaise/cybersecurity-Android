// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f6042b;

    public /* synthetic */ c(j jVar, int i3) {
        this.f6041a = i3;
        this.f6042b = jVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f6041a) {
            case 0:
                this.f6042b.a("transport closed");
                break;
            default:
                this.f6042b.a("socket closed");
                break;
        }
    }
}
