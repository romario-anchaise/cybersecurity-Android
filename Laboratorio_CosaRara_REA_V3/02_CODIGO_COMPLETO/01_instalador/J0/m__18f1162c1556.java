// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p016j0;

import H.C0028c;
import V.k;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import b1.p;
import d0.c;
import f1.l;
import java.lang.ref.WeakReference;
import p008e0.e;
import p034t0.h;

/* JADX INFO: loaded from: classes.dex */
public final class m implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f3394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3396e = true;

    public m(k kVar) {
        this.f3392a = new WeakReference(kVar);
    }

    public final synchronized void a() {
        h hVar;
        try {
            k kVar = (k) this.f3392a.get();
            if (kVar != null) {
                if (this.f3394c == null) {
                    e eVarD = kVar.f683e.f3385b ? l.d(kVar.f679a, this) : new C0028c(13);
                    this.f3394c = eVarD;
                    this.f3396e = eVarD.f();
                }
                hVar = h.f4132b;
            } else {
                hVar = null;
            }
            if (hVar == null) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            if (this.f3395d) {
                return;
            }
            this.f3395d = true;
            Context context = this.f3393b;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            e eVar = this.f3394c;
            if (eVar != null) {
                eVar.d();
            }
            this.f3392a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onConfigurationChanged(Configuration configuration) {
        try {
            if ((((k) this.f3392a.get()) != null ? h.f4132b : null) == null) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final synchronized void onTrimMemory(int i2) {
        h hVar;
        try {
            k kVar = (k) this.f3392a.get();
            if (kVar != null) {
                c cVar = (c) kVar.f681c.getValue();
                if (cVar != null) {
                    cVar.f2200a.u(i2);
                    p pVar = cVar.f2201b;
                    synchronized (pVar) {
                        if (i2 >= 10 && i2 != 20) {
                            pVar.b();
                        }
                    }
                }
                hVar = h.f4132b;
            } else {
                hVar = null;
            }
            if (hVar == null) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
