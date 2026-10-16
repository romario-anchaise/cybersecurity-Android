// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m extends a1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2315e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f2316f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, o oVar, int i2, List list) {
        super(str, true);
        this.f2316f = oVar;
        this.g = i2;
    }

    @Override // a1.a
    public final long a() {
        switch (this.f2315e) {
            case 0:
                this.f2316f.f2329k.getClass();
                try {
                    this.f2316f.f2341w.u(this.g, 9);
                    synchronized (this.f2316f) {
                        this.f2316f.f2343y.remove(Integer.valueOf(this.g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            default:
                this.f2316f.f2329k.getClass();
                try {
                    this.f2316f.f2341w.u(this.g, 9);
                    synchronized (this.f2316f) {
                        this.f2316f.f2343y.remove(Integer.valueOf(this.g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, o oVar, int i2, List list, boolean z2) {
        super(str, true);
        this.f2316f = oVar;
        this.g = i2;
    }
}
