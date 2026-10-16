// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u0;

import g0.s;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3256a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f3259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f3260e;

    public e() {
        s sVar = new s();
        sVar.f1486b = new Object();
        this.f3257b = sVar;
    }

    public final boolean a() {
        boolean z2;
        synchronized (this.f3256a) {
            try {
                z2 = false;
                if (this.f3258c && this.f3260e == null) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public final void b() {
        boolean z2;
        Exception exc;
        String strConcat;
        Boolean bool;
        if (this.f3258c) {
            synchronized (this.f3256a) {
                z2 = this.f3258c;
            }
            if (!z2) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            synchronized (this.f3256a) {
                exc = this.f3260e;
            }
            if (exc != null) {
                strConcat = "failure";
            } else if (a()) {
                synchronized (this.f3256a) {
                    if (!this.f3258c) {
                        throw new IllegalStateException("Task is not yet complete");
                    }
                    Exception exc2 = this.f3260e;
                    if (exc2 != null) {
                        throw new h1.a(exc2);
                    }
                    bool = this.f3259d;
                }
                strConcat = "result ".concat(String.valueOf(bool));
            } else {
                strConcat = "unknown issue";
            }
        }
    }
}
