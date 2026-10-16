// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements w0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1611c;

    public /* synthetic */ i(Object obj, Object obj2, int i3) {
        this.f1609a = i3;
        this.f1610b = obj;
        this.f1611c = obj2;
    }

    @Override // w0.a
    public final void a(Object[] objArr) {
        IOException iOException;
        switch (this.f1609a) {
            case 0:
                a0 a0Var = (a0) this.f1610b;
                p pVar = (p) this.f1611c;
                a0Var.t();
                pVar.a(objArr);
                break;
            case 1:
                a0 a0Var2 = (a0) this.f1610b;
                w wVar = (w) this.f1611c;
                JSONObject jSONObjectL = a0.l(objArr);
                if (jSONObjectL == null) {
                    iOException = new IOException("Socket.IO logical stream data ack missing");
                } else {
                    Object objOpt = jSONObjectL.opt("ok");
                    if ((objOpt instanceof Boolean) && ((Boolean) objOpt).booleanValue()) {
                        iOException = null;
                    } else {
                        JSONObject jSONObjectOptJSONObject = jSONObjectL.optJSONObject("error");
                        iOException = new IOException("Socket.IO logical stream data rejected: " + (jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("code", "rejected") : "rejected") + ": " + (jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("message", "logical stream data rejected") : "logical stream data rejected"));
                    }
                }
                if (a0Var2.G(wVar)) {
                    if (iOException != null) {
                        wVar.f1773b.d(wVar.f1774c, wVar.f1775d, iOException);
                    } else {
                        a0Var2.r();
                    }
                    break;
                }
                break;
            default:
                k0 k0Var = (k0) this.f1610b;
                try {
                    k0Var.f1654g.execute(new e2.q0(k0Var, (s0) this.f1611c, objArr, 2));
                } catch (RejectedExecutionException unused) {
                    return;
                }
                break;
        }
    }
}
