// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f3380b;

    public /* synthetic */ d(k kVar, int i3) {
        this.f3379a = i3;
        this.f3380b = kVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f3379a) {
            case 0:
                this.f3380b.a("transport", objArr);
                break;
            case 1:
                y.e eVar = this.f3380b.f3406o;
                Object obj = objArr[0];
                try {
                    if (obj instanceof String) {
                        eVar.b((String) obj);
                    } else if (obj instanceof byte[]) {
                        eVar.c((byte[]) obj);
                    }
                } catch (e1.b e3) {
                    k.f3393r.fine("error while decoding the packet: " + e3.getMessage());
                    return;
                }
                break;
            case 2:
                Exception exc = (Exception) objArr[0];
                k.f3393r.log(Level.FINE, "error", (Throwable) exc);
                this.f3380b.a("error", exc);
                break;
            default:
                String str = (String) objArr[0];
                k.f3393r.fine("onclose");
                k kVar = this.f3380b;
                kVar.e();
                kVar.f3399g.f3276d = 0;
                kVar.f3408q = 1;
                kVar.a("close", str);
                if (kVar.f3394b && !kVar.f3395c) {
                    kVar.g();
                    break;
                }
                break;
        }
    }
}
