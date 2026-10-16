// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import k1.InterfaceC0195k;
import k1.v;

/* JADX INFO: loaded from: classes.dex */
public final class q extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1.l f772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0195k f774c;

    public q(InterfaceC0195k interfaceC0195k, f1.l lVar) {
        this.f772a = lVar;
        this.f774c = interfaceC0195k;
    }

    @Override // W.o
    public final f1.l a() {
        return this.f772a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f773b = true;
        InterfaceC0195k interfaceC0195k = this.f774c;
        if (interfaceC0195k != null) {
            p016j0.f.a(interfaceC0195k);
        }
    }

    @Override // W.o
    public final synchronized InterfaceC0195k f() {
        InterfaceC0195k interfaceC0195k;
        try {
            if (this.f773b) {
                throw new IllegalStateException("closed");
            }
            interfaceC0195k = this.f774c;
            if (interfaceC0195k == null) {
                v vVar = k1.o.f3497a;
                F0.i.b(null);
                vVar.i(null);
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return interfaceC0195k;
    }
}
