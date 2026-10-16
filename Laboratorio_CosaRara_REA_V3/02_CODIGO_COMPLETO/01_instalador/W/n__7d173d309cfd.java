// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import java.io.Closeable;
import k1.C;
import k1.InterfaceC0195k;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class n extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1.o f766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Closeable f768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C f770f;

    public n(z zVar, k1.o oVar, String str, Closeable closeable) {
        this.f765a = zVar;
        this.f766b = oVar;
        this.f767c = str;
        this.f768d = closeable;
    }

    @Override // W.o
    public final f1.l a() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.f769e = true;
            C c2 = this.f770f;
            if (c2 != null) {
                p016j0.f.a(c2);
            }
            Closeable closeable = this.f768d;
            if (closeable != null) {
                p016j0.f.a(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // W.o
    public final synchronized InterfaceC0195k f() {
        if (this.f769e) {
            throw new IllegalStateException("closed");
        }
        C c2 = this.f770f;
        if (c2 != null) {
            return c2;
        }
        C cF = f1.l.f(this.f766b.i(this.f765a));
        this.f770f = cF;
        return cF;
    }
}
