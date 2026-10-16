// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge f5000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ge f5001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q9 f5002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q9 f5003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5007h = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5008i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5009j;

    public r9(ge geVar, ge geVar2) {
        this.f5000a = geVar;
        this.f5001b = geVar2;
    }

    public final void a() {
        int i3;
        q9 q9Var;
        synchronized (this) {
            try {
                if (!this.f5005f && (i3 = this.f5004e) != 0 && ((q9Var = this.f5003d) == null || q9Var.f4933g == 0)) {
                    boolean z2 = true;
                    this.f5005f = true;
                    ge geVar = i3 == 2 ? this.f5001b : this.f5000a;
                    try {
                        geVar.run();
                        synchronized (this) {
                            try {
                                this.f5005f = false;
                                if (this.f5004e <= i3) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    this.f5003d = null;
                                    this.f5004e = 0;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z2) {
                            a();
                        }
                    } catch (Throwable th2) {
                        synchronized (this) {
                            try {
                                this.f5005f = false;
                                if (this.f5004e <= i3) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    this.f5003d = null;
                                    this.f5004e = 0;
                                }
                                if (z2) {
                                    a();
                                }
                                throw th2;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final boolean b(q9 q9Var) {
        return q9Var != null && !q9Var.f4934h && this.f5002c == q9Var && q9Var.f4930d == this.f5009j;
    }

    public final void c(q9 q9Var) {
        synchronized (this) {
            try {
                if (this.f5002c != q9Var) {
                    return;
                }
                this.f5002c = null;
                this.f5009j++;
                q9Var.f4934h = true;
                d(q9Var, 1);
                a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(q9 q9Var, int i3) {
        int i4 = this.f5004e;
        if (i4 == 0) {
            this.f5003d = q9Var;
            this.f5004e = i3;
        } else if (this.f5003d == q9Var) {
            this.f5004e = Math.max(i4, i3);
        }
    }
}
