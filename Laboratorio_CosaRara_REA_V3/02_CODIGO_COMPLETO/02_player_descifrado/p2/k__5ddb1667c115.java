// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f2915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w2.h f2917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2918h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str, n nVar, int i3, w2.h hVar, int i4, boolean z2) {
        super(str, true);
        this.f2915e = nVar;
        this.f2916f = i3;
        this.f2917g = hVar;
        this.f2918h = i4;
    }

    @Override // l2.a
    public final long a() {
        try {
            z zVar = this.f2915e.f2935m;
            w2.h hVar = this.f2917g;
            int i3 = this.f2918h;
            zVar.getClass();
            hVar.skip(i3);
            this.f2915e.f2946y.C(this.f2916f, 9);
            synchronized (this.f2915e) {
                this.f2915e.A.remove(Integer.valueOf(this.f2916f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
