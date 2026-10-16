// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p016j0;

import X.j;
import android.os.SystemClock;
import f1.d;
import g0.a;
import g0.h;

/* JADX INFO: loaded from: classes.dex */
public final class l implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f3390a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f3391b;

    @Override // p016j0.i
    public boolean a(h hVar) {
        d dVar = hVar.f2749a;
        if ((dVar instanceof a ? ((a) dVar).f2738m : Integer.MAX_VALUE) > 100) {
            d dVar2 = hVar.f2750b;
            if ((dVar2 instanceof a ? ((a) dVar2).f2738m : Integer.MAX_VALUE) > 100) {
                return true;
            }
        }
        return false;
    }

    @Override // p016j0.i
    public boolean b() {
        boolean z2;
        synchronized (h.f3379a) {
            try {
                int i2 = h.f3381c;
                h.f3381c = i2 + 1;
                if (i2 >= 30 || SystemClock.uptimeMillis() > h.f3382d + ((long) 30000)) {
                    h.f3381c = 0;
                    h.f3382d = SystemClock.uptimeMillis();
                    String[] list = h.f3380b.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    h.f3383e = list.length < 800;
                }
                z2 = h.f3383e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
