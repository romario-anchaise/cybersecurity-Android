// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ke implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f4426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4427f;

    public /* synthetic */ ke(cf cfVar, Context context, String str, int i3) {
        this.f4424c = i3;
        this.f4425d = cfVar;
        this.f4426e = context;
        this.f4427f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4424c) {
            case 0:
                this.f4425d.H0(this.f4426e, this.f4427f);
                break;
            default:
                cf cfVar = this.f4425d;
                Context context = this.f4426e;
                String str = this.f4427f;
                if (context != null) {
                    h2.h hVarG = cf.g(context);
                    int iH = cf.h(hVarG);
                    int i3 = cfVar.f3737x0;
                    if (i3 >= 0 && iH != i3) {
                        g2.a0 a0Var = cfVar.f3727s0;
                        if (a0Var == null) {
                            Log.i("TunnelManager", "capabilities changed while " + cfVar.f3706h + "; next registration will refresh reason=" + str);
                        } else {
                            a0Var.T = g2.a0.i(hVarG);
                            a0Var.A.set(a0Var.f1535z.incrementAndGet());
                            a0Var.m();
                            cfVar.f3737x0 = iH;
                            StringBuilder sb = new StringBuilder("capabilities updated mask=");
                            sb.append(i3);
                            sb.append("->");
                            sb.append(iH);
                            sb.append(" reason=");
                            a0.a.o(sb, str, "TunnelManager");
                        }
                    } else {
                        Log.d("TunnelManager", "capabilities unchanged reason=" + str);
                    }
                } else {
                    Log.d("TunnelManager", "capability refresh skipped - no context");
                }
                break;
        }
    }
}
