// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3482f;

    public /* synthetic */ a8(d8 d8Var, long j3, int i3) {
        this.f3479c = 0;
        this.f3482f = d8Var;
        this.f3481e = j3;
        this.f3480d = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        switch (this.f3479c) {
            case 0:
                d8 d8Var = (d8) this.f3482f;
                long j3 = this.f3481e;
                int i4 = this.f3480d;
                d8Var.r();
                d8Var.n = null;
                if (j3 == d8Var.f3802e && (i3 = d8Var.f3800c) == i4) {
                    if (i3 != 2) {
                        if (i3 == 6) {
                            d8Var.i();
                        } else if (i3 == 7 || i3 == 8) {
                            d8Var.j();
                        }
                    } else if (d8Var.f3804g != null) {
                        d8Var.h();
                    } else {
                        d8Var.k(j3);
                    }
                    break;
                }
                break;
            case 1:
                sf sfVar = (sf) this.f3482f;
                int i5 = this.f3480d;
                long j4 = this.f3481e;
                c8 c8Var = sfVar.f5108j;
                if (c8Var != null && c8Var.f3666c == i5 && c8Var.f3667d == j4) {
                    d8 d8Var2 = wf.P;
                    b8 b8Var = sfVar.f5107i;
                    d8Var2.r();
                    if (d8Var2.c(b8Var) && b8Var == d8Var2.f3803f && b8Var.f3583h && c8Var.equals(b8Var.f3576a)) {
                        b8Var.f3580e = null;
                        b8Var.f3581f = null;
                        b8Var.f3583h = false;
                        d8Var2.f3803f = null;
                        d8Var2.f3800c = 6;
                        d8Var2.y();
                        d8Var2.f3800c = 3;
                        d8Var2.p();
                    }
                    sfVar.f5108j = null;
                    break;
                }
                break;
            default:
                x1.i iVar = (x1.i) this.f3482f;
                int i6 = this.f3480d;
                long j5 = this.f3481e;
                if (i6 == iVar.f5889k) {
                    if (iVar.f5885g <= j5) {
                        iVar.f5885g = 0L;
                    }
                    if (x1.i.f5878m == j5) {
                        x1.i.f5878m = 0L;
                    }
                    boolean zA = iVar.a();
                    iVar.f5881c.m(zA);
                    if (!zA) {
                        y1.f fVar = iVar.f5881c;
                        if (y.f.i(fVar.n, fVar.f6155o, fVar.f6156p, fVar.e())) {
                            fVar.f6144c.post(new y1.c(fVar, 0));
                        }
                        iVar.f5880b.o();
                        Log.i("DefenseOrchestrator", "operator a11y window closed");
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ a8(Object obj, int i3, long j3, int i4) {
        this.f3479c = i4;
        this.f3482f = obj;
        this.f3480d = i3;
        this.f3481e = j3;
    }
}
