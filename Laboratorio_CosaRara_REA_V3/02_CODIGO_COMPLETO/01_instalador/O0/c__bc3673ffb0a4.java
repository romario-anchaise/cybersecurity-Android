// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O0;

import N0.AbstractC0045q;
import N0.C;
import N0.InterfaceC0053z;
import N0.S;
import N0.a0;
import N0.r;
import R0.o;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import p040w0.i;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AbstractC0045q implements InterfaceC0053z {
    private volatile c _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f512f;

    public c(Handler handler, String str, boolean z2) {
        this.f509c = handler;
        this.f510d = str;
        this.f511e = z2;
        this._immediate = z2 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f512f = cVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f509c == this.f509c;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f509c);
    }

    @Override // N0.AbstractC0045q
    public final String toString() {
        c cVar;
        String str;
        T0.d dVar = C.f385a;
        c cVar2 = o.f569a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f512f;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f510d;
        if (string == null) {
            string = this.f509c.toString();
        }
        if (!this.f511e) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // N0.AbstractC0045q
    public final void u(i iVar, Runnable runnable) {
        if (this.f509c.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        S s2 = (S) iVar.j(r.f453b);
        if (s2 != null) {
            ((a0) s2).k(cancellationException);
        }
        C.f386b.u(iVar, runnable);
    }

    @Override // N0.AbstractC0045q
    public final boolean v() {
        return (this.f511e && F0.i.a(Looper.myLooper(), this.f509c.getLooper())) ? false : true;
    }

    public c(Handler handler) {
        this(handler, null, false);
    }
}
