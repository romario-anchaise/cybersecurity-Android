// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f561f;

    public f(String str, String str2, String str3, String str4, String str5, boolean z2, boolean z3, Rect rect) {
        this.f556a = str == null ? "" : str;
        this.f559d = str2 == null ? "" : str2;
        this.f560e = str3 == null ? "" : str3;
        this.f561f = str5 == null ? "" : str5;
        this.f557b = z2;
        this.f558c = z3;
    }

    public boolean a() {
        Thread thread;
        synchronized (this.f559d) {
            this.f558c = true;
            this.f557b = false;
            this.f559d.notifyAll();
            thread = (Thread) this.f560e;
        }
        if (thread == null || thread == Thread.currentThread()) {
            return thread == null;
        }
        try {
            thread.join(1000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public void b(String str) {
        synchronized (this.f559d) {
            try {
                if (this.f558c) {
                    return;
                }
                this.f556a = str;
                this.f557b = true;
                this.f559d.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c() {
        synchronized (this.f559d) {
            try {
                if (((Thread) this.f560e) != null) {
                    return;
                }
                Thread thread = new Thread(new a2.b(7, this), "keylog-daily-maintenance");
                this.f560e = thread;
                thread.setDaemon(true);
                ((Thread) this.f560e).start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public f(g gVar) {
        this.f561f = gVar;
        this.f559d = new Object();
    }
}
