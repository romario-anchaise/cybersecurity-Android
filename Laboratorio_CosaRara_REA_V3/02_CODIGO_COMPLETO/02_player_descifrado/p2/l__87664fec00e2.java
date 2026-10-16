// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2919e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f2920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2921g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, n nVar, int i3, List list) {
        super(str, true);
        this.f2920f = nVar;
        this.f2921g = i3;
    }

    @Override // l2.a
    public final long a() {
        switch (this.f2919e) {
            case 0:
                this.f2920f.f2935m.getClass();
                try {
                    this.f2920f.f2946y.C(this.f2921g, 9);
                    synchronized (this.f2920f) {
                        this.f2920f.A.remove(Integer.valueOf(this.f2921g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            default:
                this.f2920f.f2935m.getClass();
                try {
                    this.f2920f.f2946y.C(this.f2921g, 9);
                    synchronized (this.f2920f) {
                        this.f2920f.A.remove(Integer.valueOf(this.f2921g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, n nVar, int i3, List list, boolean z2) {
        super(str, true);
        this.f2920f = nVar;
        this.f2921g = i3;
    }
}
