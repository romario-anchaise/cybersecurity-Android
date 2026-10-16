// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

import android.os.SystemClock;
import e2.n1;
import w1.o2;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q.c f6126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n1 f6127c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6133i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6125a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v8 f6128d = new v8(17, this);

    public b(o2 o2Var, q.c cVar, n1 n1Var) {
        this.f6126b = cVar;
        this.f6127c = n1Var;
    }

    public final void a(int i3) {
        if (i3 != 0) {
            boolean z2 = true;
            if (i3 == 1) {
                return;
            }
            synchronized (this.f6125a) {
                try {
                    if (this.f6129e) {
                        if (this.f6130f) {
                            z2 = false;
                        } else {
                            this.f6130f = true;
                            this.f6131g = SystemClock.uptimeMillis();
                            this.f6132h = 0;
                            this.f6133i++;
                        }
                        if (z2) {
                            e();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b() {
        synchronized (this.f6125a) {
            d();
        }
        try {
            q.c cVar = this.f6126b;
            cVar.f3005a.removeCallbacks(this.f6128d);
        } catch (Throwable unused) {
        }
    }

    public final void c(int i3) {
        synchronized (this.f6125a) {
            try {
                if (this.f6133i != i3) {
                    return;
                }
                d();
                try {
                    q.c cVar = this.f6126b;
                    cVar.f3005a.removeCallbacks(this.f6128d);
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        if (this.f6130f) {
            this.f6133i++;
        }
        this.f6130f = false;
        this.f6132h = 0;
        this.f6131g = 0L;
    }

    public final boolean e() {
        synchronized (this.f6125a) {
            if (this.f6129e && this.f6130f) {
                try {
                    q.c cVar = this.f6126b;
                    cVar.f3005a.removeCallbacks(this.f6128d);
                    q.c cVar2 = this.f6126b;
                    cVar2.f3005a.postDelayed(this.f6128d, 80L);
                    return true;
                } catch (Throwable unused) {
                    synchronized (this.f6125a) {
                        d();
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
