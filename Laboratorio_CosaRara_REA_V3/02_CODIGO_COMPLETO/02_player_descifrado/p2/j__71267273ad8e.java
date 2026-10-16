// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f2912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2914h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, n nVar, int i3, int i4, int i5) {
        super(str, true);
        this.f2911e = i5;
        this.f2912f = nVar;
        this.f2913g = i3;
        this.f2914h = i4;
    }

    @Override // l2.a
    public final long a() {
        switch (this.f2911e) {
            case 0:
                n nVar = this.f2912f;
                try {
                    nVar.f2946y.B(true, this.f2913g, this.f2914h);
                    return -1L;
                } catch (IOException e3) {
                    nVar.d(2, 2, e3);
                    return -1L;
                }
            case 1:
                z zVar = this.f2912f.f2935m;
                int i3 = this.f2914h;
                zVar.getClass();
                if (i3 == 0) {
                    throw null;
                }
                synchronized (this.f2912f) {
                    this.f2912f.A.remove(Integer.valueOf(this.f2913g));
                }
                return -1L;
            default:
                n nVar2 = this.f2912f;
                try {
                    int i4 = this.f2913g;
                    int i5 = this.f2914h;
                    if (i5 == 0) {
                        throw null;
                    }
                    nVar2.f2946y.C(i4, i5);
                    return -1L;
                } catch (IOException e4) {
                    nVar2.d(2, 2, e4);
                    return -1L;
                }
        }
    }
}
