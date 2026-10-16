// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class j extends a1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f2308f;
    public final /* synthetic */ int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2309h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, o oVar, int i2, int i3, int i4) {
        super(str, true);
        this.f2307e = i4;
        this.f2308f = oVar;
        this.g = i2;
        this.f2309h = i3;
    }

    @Override // a1.a
    public final long a() {
        switch (this.f2307e) {
            case 0:
                int i2 = this.g;
                int i3 = this.f2309h;
                o oVar = this.f2308f;
                oVar.getClass();
                try {
                    oVar.f2341w.t(i2, i3, true);
                    return -1L;
                } catch (IOException e2) {
                    oVar.a(2, 2, e2);
                    return -1L;
                }
            case 1:
                A a2 = this.f2308f.f2329k;
                int i4 = this.f2309h;
                a2.getClass();
                F0.h.g(i4, "errorCode");
                synchronized (this.f2308f) {
                    this.f2308f.f2343y.remove(Integer.valueOf(this.g));
                }
                return -1L;
            default:
                o oVar2 = this.f2308f;
                try {
                    int i5 = this.g;
                    int i6 = this.f2309h;
                    oVar2.getClass();
                    F0.h.g(i6, "statusCode");
                    oVar2.f2341w.u(i5, i6);
                    return -1L;
                } catch (IOException e3) {
                    oVar2.a(2, 2, e3);
                    return -1L;
                }
        }
    }
}
