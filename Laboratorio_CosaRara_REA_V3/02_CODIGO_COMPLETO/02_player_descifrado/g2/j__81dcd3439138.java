// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import w1.b8;
import w1.c8;
import w1.d8;
import w1.f2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f1634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1638h;

    public /* synthetic */ j(d8 d8Var, b8 b8Var, c8 c8Var, f2 f2Var, long j3) {
        this.f1633c = 1;
        this.f1635e = d8Var;
        this.f1636f = b8Var;
        this.f1637g = c8Var;
        this.f1638h = f2Var;
        this.f1634d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c8 c8Var;
        switch (this.f1633c) {
            case 0:
                a0 a0Var = (a0) this.f1635e;
                long j3 = this.f1634d;
                String str = (String) this.f1636f;
                IOException iOException = (IOException) this.f1637g;
                h2.g gVar = (h2.g) this.f1638h;
                AtomicLong atomicLong = a0Var.f1533x;
                if (a0Var.f1528s.get() && !a0Var.f1529t.get() && a0Var.O.get() == null && atomicLong.get() == j3 && atomicLong.compareAndSet(j3, 1 + j3)) {
                    a0Var.F(str, iOException, gVar);
                    break;
                }
                break;
            case 1:
                d8 d8Var = (d8) this.f1635e;
                b8 b8Var = (b8) this.f1636f;
                c8 c8Var2 = (c8) this.f1637g;
                f2 f2Var = (f2) this.f1638h;
                long j4 = this.f1634d;
                d8Var.r();
                if (j4 == d8Var.f3802e && d8Var.f3800c == 5 && d8Var.c(b8Var) && b8Var == d8Var.f3803f && b8Var.f3583h && b8Var.f3580e == f2Var && (c8Var = b8Var.f3581f) != null && c8Var.equals(c8Var2) && b8Var.f3576a.equals(c8Var2)) {
                    b8Var.f3580e = null;
                    b8Var.f3581f = null;
                    d8Var.f3800c = 4;
                    d8Var.y();
                    f2Var.run();
                } else {
                    d8Var.y();
                }
                break;
            default:
                x1.w wVar = (x1.w) this.f1635e;
                long j5 = this.f1634d;
                String str2 = (String) this.f1636f;
                String str3 = (String) this.f1637g;
                String str4 = (String) this.f1638h;
                if (wVar.f5946d == j5 && wVar.f5949g < j5) {
                    if (!wVar.d(str2)) {
                        wVar.l("self_uninstall_wrapper_uninstalled", str3, null, "connection_service", str4);
                        wVar.m(System.currentTimeMillis(), str3, str4);
                    } else {
                        wVar.l("self_uninstall_wrapper_prompt_not_observed", str3, "wrapper uninstall prompt not observed", "connection_service", str4);
                        wVar.m(System.currentTimeMillis(), str3, str4);
                        wVar.j(str3, str4);
                    }
                }
                break;
        }
    }

    public /* synthetic */ j(Object obj, long j3, String str, Serializable serializable, Object obj2, int i3) {
        this.f1633c = i3;
        this.f1635e = obj;
        this.f1634d = j3;
        this.f1636f = str;
        this.f1637g = serializable;
        this.f1638h = obj2;
    }
}
