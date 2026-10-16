// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements w0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f1702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h2.e f1704c;

    public /* synthetic */ p(a0 a0Var, long j3, h2.e eVar) {
        this.f1702a = a0Var;
        this.f1703b = j3;
        this.f1704c = eVar;
    }

    @Override // w0.a
    public final void a(Object[] objArr) {
        long j3 = this.f1704c.f1982d;
        a0 a0Var = this.f1702a;
        a0Var.r();
        JSONObject jSONObjectL = a0.l(objArr);
        long j4 = this.f1703b;
        if (jSONObjectL == null || !jSONObjectL.optBoolean("ok", false) || a0.N(jSONObjectL.opt("generation")) != j3) {
            Log.w("SocketControlClient", "capabilities update not acknowledged revision=" + j4);
        } else if (a0Var.A.compareAndSet(j4, 0L)) {
            StringBuilder sbJ = a0.a.j(j4, "capabilities update acknowledged revision=", " generation=");
            sbJ.append(j3);
            Log.i("SocketControlClient", sbJ.toString());
        }
    }
}
