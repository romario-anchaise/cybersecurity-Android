// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.C0005e;

/* JADX INFO: renamed from: i.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0132f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0133g f2885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f2886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f2887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0005e f2888d;

    public RunnableC0132f(C0005e c0005e, C0133g c0133g, p pVar, n nVar) {
        this.f2888d = c0005e;
        this.f2885a = c0133g;
        this.f2886b = pVar;
        this.f2887c = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0133g c0133g = this.f2885a;
        if (c0133g != null) {
            C0005e c0005e = this.f2888d;
            ((h) c0005e.f34b).f2915z = true;
            c0133g.f2890b.c(false);
            ((h) c0005e.f34b).f2915z = false;
        }
        p pVar = this.f2886b;
        if (pVar.isEnabled() && pVar.hasSubMenu()) {
            this.f2887c.q(pVar, null, 4);
        }
    }
}
