// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class u implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V.a f237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0028c f238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f241f;
    public ThreadPoolExecutor g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f1.l f242h;

    public u(Context context, V.a aVar) {
        C0028c c0028c = v.f243d;
        this.f239d = new Object();
        p028p0.a.a(context, "Context cannot be null");
        this.f236a = context.getApplicationContext();
        this.f237b = aVar;
        this.f238c = c0028c;
    }

    public final void a() {
        synchronized (this.f239d) {
            try {
                this.f242h = null;
                Handler handler = this.f240e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f240e = null;
                ThreadPoolExecutor threadPoolExecutor = this.g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f241f = null;
                this.g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p041x.h b() {
        try {
            C0028c c0028c = this.f238c;
            Context context = this.f236a;
            V.a aVar = this.f237b;
            c0028c.getClass();
            b1.p pVarA = p041x.c.a(context, aVar);
            int i2 = pVarA.f2170a;
            if (i2 != 0) {
                throw new RuntimeException("fetchFonts failed (" + i2 + ")");
            }
            p041x.h[] hVarArr = (p041x.h[]) pVarA.f2171b;
            if (hVarArr == null || hVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return hVarArr[0];
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("provider not found", e2);
        }
    }

    @Override // H.k
    public final void v(f1.l lVar) {
        synchronized (this.f239d) {
            this.f242h = lVar;
        }
        synchronized (this.f239d) {
            try {
                if (this.f242h == null) {
                    return;
                }
                if (this.f241f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0026a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.g = threadPoolExecutor;
                    this.f241f = threadPoolExecutor;
                }
                this.f241f.execute(new t(0, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
