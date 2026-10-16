// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class n extends a1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f2317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2318f;
    public final /* synthetic */ long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String str, o oVar, int i2, long j2) {
        super(str, true);
        this.f2317e = oVar;
        this.f2318f = i2;
        this.g = j2;
    }

    @Override // a1.a
    public final long a() {
        o oVar = this.f2317e;
        try {
            oVar.f2341w.v(this.f2318f, this.g);
            return -1L;
        } catch (IOException e2) {
            oVar.a(2, 2, e2);
            return -1L;
        }
    }
}
