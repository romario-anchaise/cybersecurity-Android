// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd f5508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5510c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5513f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5511d = Long.MIN_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5514g = Long.MIN_VALUE;

    public x7(o2 o2Var, rd rdVar) {
        this.f5508a = rdVar;
    }

    public static boolean a(x7 x7Var, long j3, long j4, boolean z2, int i3) {
        synchronized (x7Var) {
            try {
                if (x7Var.f5510c == j3 && x7Var.f5511d == j4) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    x7Var.f5510c = 0L;
                    x7Var.f5511d = Long.MIN_VALUE;
                    x7Var.f5512e = false;
                    x7Var.f5513f = false;
                    rd rdVar = x7Var.f5508a;
                    if (z2) {
                        rdVar.d(c(j4, jUptimeMillis), jUptimeMillis);
                    } else {
                        rdVar.c(i3, jUptimeMillis);
                    }
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long c(long j3, long j4) {
        if (j3 == Long.MIN_VALUE || j4 <= j3) {
            return 0L;
        }
        return j4 - j3;
    }

    public final synchronized long b() {
        long j3;
        rd rdVar = this.f5508a;
        synchronized (rdVar) {
            j3 = rdVar.f5019a;
        }
        return j3;
    }

    public final long d(long j3, boolean z2) {
        long jF;
        if (this.f5513f || c(this.f5511d, j3) >= 6000) {
            return 1000L;
        }
        long jMax = Math.max(1L, 6000 - c(this.f5511d, j3));
        rd rdVar = this.f5508a;
        if (z2) {
            jF = rdVar.f();
        } else {
            synchronized (rdVar) {
                jF = rdVar.f5019a;
            }
        }
        return Math.max(1L, Math.min(jMax, jF));
    }

    public final synchronized void e() {
        if (this.f5510c == 0) {
            return;
        }
        this.f5510c = 0L;
        this.f5511d = Long.MIN_VALUE;
        this.f5512e = false;
        this.f5513f = false;
    }

    public final synchronized long f() {
        long j3;
        long jMax;
        long jMax2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f5510c != 0) {
            jMax2 = d(jUptimeMillis, false);
        } else {
            long j4 = this.f5514g;
            if (j4 == Long.MIN_VALUE) {
                jMax = 0;
            } else {
                long jC = c(j4, jUptimeMillis);
                rd rdVar = this.f5508a;
                synchronized (rdVar) {
                    j3 = rdVar.f5019a;
                }
                jMax = Math.max(0L, j3 - jC);
            }
            jMax2 = Math.max(0L, jMax);
        }
        return jMax2;
    }

    public final d0.d g(boolean z2) {
        long j3;
        long jF;
        long jMax;
        long j4;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f5510c != 0) {
            return new d0.d((Object) null, d(jUptimeMillis, z2));
        }
        long j5 = this.f5514g;
        if (j5 == Long.MIN_VALUE) {
            jMax = 0;
        } else {
            long jC = c(j5, jUptimeMillis);
            rd rdVar = this.f5508a;
            if (z2) {
                jF = rdVar.f();
            } else {
                synchronized (rdVar) {
                    j3 = rdVar.f5019a;
                }
                jF = j3;
            }
            jMax = Math.max(0L, jF - jC);
        }
        if (jMax > 0) {
            return new d0.d((Object) null, jMax);
        }
        do {
            j4 = 1 + this.f5509b;
            this.f5509b = j4;
        } while (j4 == 0);
        long j6 = this.f5514g;
        this.f5510c = j4;
        this.f5511d = jUptimeMillis;
        this.f5512e = false;
        this.f5513f = false;
        this.f5514g = jUptimeMillis;
        return new d0.d(new p5(this, j4, jUptimeMillis, j6), 0L);
    }
}
