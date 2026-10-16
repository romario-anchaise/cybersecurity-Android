// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class l extends a1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f2312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2313f;
    public final /* synthetic */ C0193i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f2314h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, o oVar, int i2, C0193i c0193i, int i3, boolean z2) {
        super(str, true);
        this.f2312e = oVar;
        this.f2313f = i2;
        this.g = c0193i;
        this.f2314h = i3;
    }

    @Override // a1.a
    public final long a() {
        try {
            A a2 = this.f2312e.f2329k;
            C0193i c0193i = this.g;
            int i2 = this.f2314h;
            a2.getClass();
            c0193i.K(i2);
            this.f2312e.f2341w.u(this.f2313f, 9);
            synchronized (this.f2312e) {
                this.f2312e.f2343y.remove(Integer.valueOf(this.f2313f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
