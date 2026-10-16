// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import w1.a8;
import w1.o2;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile long f5878m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f5880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.f f5881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f5882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f5883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v8 f5884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f5885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5886h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5887i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5888j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5889k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5890l;

    public i(ScreenMirrorService screenMirrorService, a aVar) {
        h hVar = new h();
        hVar.f5877a = Long.MIN_VALUE;
        this.f5882d = hVar;
        this.f5883e = new Handler(Looper.getMainLooper());
        if (aVar == null) {
            o2.i("service and legacyGuard are required");
            throw null;
        }
        this.f5879a = aVar;
        this.f5880b = new g(screenMirrorService);
        this.f5881c = new y1.f(screenMirrorService);
        this.f5884f = new v8(14, this);
    }

    public final boolean a() {
        long jMax = Math.max(this.f5885g, f5878m);
        return jMax > 0 && SystemClock.uptimeMillis() <= jMax;
    }

    public final void b(long j3) {
        if (j3 <= 0) {
            return;
        }
        int i3 = this.f5889k + 1;
        this.f5889k = i3;
        long jMax = Math.max(1L, j3 - SystemClock.uptimeMillis());
        this.f5883e.postDelayed(new a8(this, i3, j3, 2), jMax);
    }

    public final void c(boolean z2) {
        this.f5890l = true;
        this.f5880b.w(this.f5879a.f5839c);
        boolean zA = a();
        y1.f fVar = this.f5881c;
        String packageName = fVar.f6142a.getPackageName();
        String name = fVar.f6142a.getClass().getName();
        if (y1.j.f6206a.equals(packageName == null ? "" : packageName.toString().trim().toLowerCase(Locale.ROOT)) && "lyr.stable.runtime.ScreenMirrorService".equals(y1.j.a(name))) {
            fVar.j();
            fVar.f6157q = fVar.i(true);
            fVar.f6147f.a();
            fVar.k();
            fVar.n = true;
            y1.b bVar = fVar.f6146e;
            synchronized (bVar.f6125a) {
                bVar.f6129e = true;
            }
        } else {
            fVar.n = false;
            y1.b bVar2 = fVar.f6146e;
            synchronized (bVar2.f6125a) {
                bVar2.f6129e = false;
                bVar2.d();
            }
            try {
                bVar2.f6126b.f3005a.removeCallbacks(bVar2.f6128d);
            } catch (Throwable unused) {
            }
            Log.w("A11ySelfDefense", "refused non-core service identity");
        }
        this.f5881c.m(zA);
        if (zA) {
            b(Math.max(this.f5885g, f5878m));
        } else if (z2) {
            y1.f fVar2 = this.f5881c;
            if (y.f.i(fVar2.n, fVar2.f6155o, fVar2.f6156p, fVar2.e())) {
                fVar2.f6144c.post(new y1.c(fVar2, 0));
            }
        }
        if (zA || !z2) {
            return;
        }
        this.f5880b.o();
    }

    public final void d() {
        this.f5890l = false;
        this.f5882d.a();
        this.f5886h = false;
        this.f5887i = false;
        this.f5888j = false;
        this.f5880b.A();
        y1.f fVar = this.f5881c;
        fVar.n = false;
        y1.b bVar = fVar.f6146e;
        synchronized (bVar.f6125a) {
            bVar.f6129e = false;
            bVar.d();
        }
        try {
            q.c cVar = bVar.f6126b;
            cVar.f3005a.removeCallbacks(bVar.f6128d);
        } catch (Throwable unused) {
        }
        fVar.f6147f.a();
        fVar.f6144c.removeCallbacksAndMessages(null);
        fVar.f6143b.quitSafely();
        this.f5883e.removeCallbacksAndMessages(null);
    }
}
