// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f2922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f2924g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, n nVar, int i3, long j3) {
        super(str, true);
        this.f2922e = nVar;
        this.f2923f = i3;
        this.f2924g = j3;
    }

    @Override // l2.a
    public final long a() {
        n nVar = this.f2922e;
        try {
            nVar.f2946y.D(this.f2923f, this.f2924g);
            return -1L;
        } catch (IOException e3) {
            nVar.d(2, 2, e3);
            return -1L;
        }
    }
}
