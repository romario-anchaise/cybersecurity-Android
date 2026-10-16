// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4805d;

    public /* synthetic */ p5(Object obj, long j3, long j4, long j5) {
        this.f4805d = obj;
        this.f4802a = j3;
        this.f4803b = j4;
        this.f4804c = j5;
    }

    public boolean a() {
        x7 x7Var = (x7) this.f4805d;
        long j3 = this.f4802a;
        long j4 = this.f4803b;
        synchronized (x7Var) {
            if (x7Var.f5510c == j3 && x7Var.f5511d == j4) {
                x7Var.f5512e = true;
                return true;
            }
            return false;
        }
    }

    public void b() {
        x7 x7Var = (x7) this.f4805d;
        long j3 = this.f4802a;
        long j4 = this.f4803b;
        long j5 = this.f4804c;
        synchronized (x7Var) {
            if (x7Var.f5510c == j3 && x7Var.f5511d == j4) {
                x7Var.f5510c = 0L;
                x7Var.f5511d = Long.MIN_VALUE;
                x7Var.f5512e = false;
                x7Var.f5513f = false;
                x7Var.f5514g = j5;
            }
        }
    }

    public boolean c() {
        return x7.a((x7) this.f4805d, this.f4802a, this.f4803b, true, 0);
    }

    public synchronized nd d() {
        nd ndVar = (nd) this.f4805d;
        if (ndVar != null) {
            return ndVar;
        }
        nd ndVar2 = new nd(this.f4802a, this.f4803b, this.f4804c);
        this.f4805d = ndVar2;
        this.f4802a = 0L;
        this.f4803b = 0L;
        this.f4804c = 0L;
        return ndVar2;
    }

    public int e() {
        x7 x7Var = (x7) this.f4805d;
        long j3 = this.f4802a;
        long j4 = this.f4803b;
        synchronized (x7Var) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j5 = x7Var.f5510c;
            if (j5 != 0 && j5 == j3) {
                long j6 = x7Var.f5511d;
                if (j6 == j4 && !x7Var.f5513f && x7.c(j6, jUptimeMillis) >= 6000) {
                    x7Var.f5513f = true;
                    x7Var.f5508a.e(jUptimeMillis);
                    if (x7Var.f5512e) {
                        return 3;
                    }
                    x7Var.f5510c = 0L;
                    x7Var.f5511d = Long.MIN_VALUE;
                    x7Var.f5512e = false;
                    x7Var.f5513f = false;
                    return 2;
                }
            }
            return 1;
        }
    }
}
