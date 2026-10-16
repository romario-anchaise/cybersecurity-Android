// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import A.C0005e;
import A.G;
import A.X;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import java.util.WeakHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import p009f.K;
import p015j.C0178w0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f123b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f122a = i2;
        this.f123b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1.a aVarC;
        long jNanoTime;
        switch (this.f122a) {
            case 0:
                h hVar = (h) this.f123b;
                if (hVar.f138o) {
                    boolean z2 = hVar.f136m;
                    a aVar = hVar.f125a;
                    if (z2) {
                        hVar.f136m = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f118e = jCurrentAnimationTimeMillis;
                        aVar.g = -1L;
                        aVar.f119f = jCurrentAnimationTimeMillis;
                        aVar.f120h = 0.5f;
                    }
                    if ((aVar.g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.g + ((long) aVar.f121i)) || !hVar.e()) {
                        hVar.f138o = false;
                        return;
                    }
                    boolean z3 = hVar.f137n;
                    ListView listView = hVar.f127c;
                    if (z3) {
                        hVar.f137n = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        listView.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar.f119f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar.a(jCurrentAnimationTimeMillis2);
                    long j2 = jCurrentAnimationTimeMillis2 - aVar.f119f;
                    aVar.f119f = jCurrentAnimationTimeMillis2;
                    i.b(hVar.f140q, (int) (j2 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar.f117d));
                    WeakHashMap weakHashMap = X.f14a;
                    G.m(listView, this);
                    return;
                }
                return;
            case 1:
                break;
            case 2:
                K k2 = (K) this.f123b;
                p009f.u uVar = k2.f2418b;
                Menu menuP = k2.p();
                p013i.n nVar = menuP instanceof p013i.n ? (p013i.n) menuP : null;
                if (nVar != null) {
                    nVar.w();
                }
                try {
                    menuP.clear();
                    if (!uVar.onCreatePanelMenu(0, menuP) || !uVar.onPreparePanel(0, null, menuP)) {
                        menuP.clear();
                    }
                    if (nVar != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (nVar != null) {
                        nVar.v();
                    }
                }
                break;
            case 3:
                C0178w0 c0178w0 = (C0178w0) this.f123b;
                c0178w0.f3344l = null;
                c0178w0.drawableStateChanged();
                return;
            case 4:
                ((Toolbar) this.f123b).v();
                return;
            default:
                Object obj = ((C0005e) this.f123b).f34b;
                return;
        }
        while (true) {
            a1.d dVar = (a1.d) this.f123b;
            synchronized (dVar) {
                aVarC = dVar.c();
            }
            if (aVarC == null) {
                return;
            }
            a1.c cVar = aVarC.f1225c;
            F0.i.b(cVar);
            a1.d dVar2 = (a1.d) this.f123b;
            boolean zIsLoggable = a1.d.f1236i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                C0005e c0005e = cVar.f1229a.f1237a;
                jNanoTime = System.nanoTime();
                f1.d.a(aVarC, cVar, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                a1.d.a(dVar2, aVarC);
                if (zIsLoggable) {
                    C0005e c0005e2 = cVar.f1229a.f1237a;
                    f1.d.a(aVarC, cVar, "finished run in ".concat(f1.d.o(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th) {
                try {
                    ((ThreadPoolExecutor) dVar2.f1237a.f34b).execute(this);
                    throw th;
                } catch (Throwable th2) {
                    if (zIsLoggable) {
                        C0005e c0005e3 = cVar.f1229a.f1237a;
                        f1.d.a(aVarC, cVar, "failed a run in ".concat(f1.d.o(System.nanoTime() - jNanoTime)));
                    }
                    throw th2;
                }
            }
        }
    }

    public b(C0005e c0005e, int i2) {
        this.f122a = 5;
        this.f123b = c0005e;
    }
}
