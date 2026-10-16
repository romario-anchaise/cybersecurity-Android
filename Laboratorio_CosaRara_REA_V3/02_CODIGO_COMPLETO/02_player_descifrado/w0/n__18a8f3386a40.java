// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f3413b;

    public /* synthetic */ n(o oVar, int i3) {
        this.f3412a = i3;
        this.f3413b = oVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f3412a) {
            case 0:
                s.e(this.f3413b.f3414c);
                break;
            case 1:
                s.f(this.f3413b.f3414c, (e1.d) objArr[0]);
                break;
            case 2:
                if (!this.f3413b.f3414c.f3425b) {
                    super/*x0.c*/.a("connect_error", objArr[0]);
                }
                break;
            default:
                s sVar = this.f3413b.f3414c;
                String str = objArr.length > 0 ? (String) objArr[0] : null;
                Logger logger = s.f3424m;
                sVar.j(str);
                break;
        }
    }
}
