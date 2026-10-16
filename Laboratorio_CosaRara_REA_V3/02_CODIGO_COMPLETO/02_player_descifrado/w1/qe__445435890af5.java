// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qe implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Serializable f4956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4957h;

    public /* synthetic */ qe(Object obj, int i3, Object obj2, Serializable serializable, Object obj3, int i4) {
        this.f4952c = i4;
        this.f4954e = obj;
        this.f4953d = i3;
        this.f4955f = obj2;
        this.f4956g = serializable;
        this.f4957h = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4952c) {
            case 0:
                cf cfVar = (cf) this.f4954e;
                int i3 = this.f4953d;
                g2.a0 a0Var = (g2.a0) this.f4955f;
                String str = (String) this.f4956g;
                e3 e3Var = (e3) this.f4957h;
                g2.d0 d0VarW = null;
                try {
                    try {
                        if (cf.M(i3, a0Var, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get())) {
                            d0VarW = a0Var.w();
                            d0VarW.f1578k.write((str + "\n").getBytes(StandardCharsets.UTF_8));
                            d0VarW.f1578k.flush();
                            boolean zM = cf.M(i3, a0Var, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get());
                            try {
                                d0VarW.close();
                                break;
                            } catch (IOException e3) {
                                a0.a.m(e3, new StringBuilder("meta report stream close failed: "), "TunnelManager");
                            }
                            cf.q(e3Var, zM);
                            return;
                        }
                    } catch (Exception e4) {
                        Log.w("TunnelManager", "meta report failed: " + e4.getMessage());
                        if (d0VarW != null) {
                            try {
                                d0VarW.close();
                            } catch (IOException e5) {
                                a0.a.m(e5, new StringBuilder("meta report stream close failed: "), "TunnelManager");
                            }
                        }
                        break;
                    }
                    cf.q(e3Var, false);
                    return;
                } catch (Throwable th) {
                    if (d0VarW != null) {
                        try {
                            d0VarW.close();
                        } catch (IOException e6) {
                            a0.a.m(e6, new StringBuilder("meta report stream close failed: "), "TunnelManager");
                        }
                        break;
                    }
                    cf.q(e3Var, false);
                    throw th;
                }
            default:
                g.j jVar = (g.j) this.f4954e;
                int i4 = this.f4953d;
                AtomicReference atomicReference = (AtomicReference) this.f4955f;
                IOException iOException = (IOException) this.f4956g;
                h2.g gVar = (h2.g) this.f4957h;
                cf cfVar2 = (cf) jVar.f1415d;
                g2.a0 a0Var2 = (g2.a0) atomicReference.get();
                if (i4 != cfVar2.f3708i.get() || a0Var2 == null || a0Var2 != cfVar2.f3727s0 || cfVar2.f3705g0) {
                    return;
                }
                cfVar2.H(System.currentTimeMillis());
                Log.i("TunnelManager", "reconnect instability episode retained after connect failure generation=" + i4 + " failure=" + iOException.getClass().getSimpleName());
                try {
                    h2.g gVarG = a0Var2.g(5);
                    if (gVar == null) {
                        gVar = gVarG;
                    }
                } catch (RuntimeException unused) {
                    Log.w("TunnelManager", "failed to stop failed connection attempt");
                }
                cfVar2.U(i4, 2, iOException, gVar);
                return;
        }
    }
}
