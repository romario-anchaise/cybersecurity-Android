// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import A.C0005e;
import H.C0028c;
import H.s;
import H.x;
import N0.C;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import b1.p;
import java.io.File;
import k1.o;
import k1.z;
import p016j0.l;

/* JADX INFO: loaded from: classes.dex */
public final class d extends F0.j implements E0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f662c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(x xVar, int i2) {
        super(0);
        this.f661b = i2;
        this.f662c = xVar;
    }

    @Override // E0.a
    public final Object a() {
        int i2;
        int largeMemoryClass;
        X.j jVarA;
        switch (this.f661b) {
            case 0:
                Context context = (Context) this.f662c.f246a;
                Bitmap.Config config = p016j0.f.f3375a;
                double d2 = 0.2d;
                try {
                    Object objB = p031r.d.b(context, ActivityManager.class);
                    F0.i.b(objB);
                    if (((ActivityManager) objB).isLowRamDevice()) {
                        d2 = 0.15d;
                    }
                } catch (Exception unused) {
                }
                p pVar = new p();
                if (d2 > 0.0d) {
                    Bitmap.Config config2 = p016j0.f.f3375a;
                    try {
                        Object objB2 = p031r.d.b(context, ActivityManager.class);
                        F0.i.b(objB2);
                        ActivityManager activityManager = (ActivityManager) objB2;
                        largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                    } catch (Exception unused2) {
                        largeMemoryClass = 256;
                    }
                    double d3 = d2 * ((double) largeMemoryClass);
                    double d4 = 1024;
                    i2 = (int) (d3 * d4 * d4);
                    break;
                } else {
                    i2 = 0;
                }
                return new d0.c(i2 > 0 ? new s(i2, pVar) : new C0005e(14, pVar), pVar);
            default:
                l lVar = l.f3390a;
                Context context2 = (Context) this.f662c.f246a;
                synchronized (lVar) {
                    try {
                        jVarA = l.f3391b;
                        if (jVarA == null) {
                            X.a aVar = new X.a();
                            aVar.f845b = o.f3497a;
                            aVar.f846c = 0.02d;
                            aVar.f847d = 10485760L;
                            aVar.f848e = 262144000L;
                            aVar.f849f = C.f386b;
                            Bitmap.Config config3 = p016j0.f.f3375a;
                            File cacheDir = context2.getCacheDir();
                            if (cacheDir == null) {
                                throw new IllegalStateException("cacheDir == null");
                            }
                            cacheDir.mkdirs();
                            File fileI = C0.a.I(cacheDir);
                            String str = z.f3517b;
                            aVar.f844a = C0028c.s(fileI);
                            jVarA = aVar.a();
                            l.f3391b = jVarA;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return jVarA;
        }
    }
}
