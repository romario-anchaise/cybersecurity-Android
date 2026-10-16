// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import N0.C0033e;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class k implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f2755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f2756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0033e f2757d;

    public k(f fVar, ViewTreeObserver viewTreeObserver, C0033e c0033e) {
        this.f2755b = fVar;
        this.f2756c = viewTreeObserver;
        this.f2757d = c0033e;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        f fVar = this.f2755b;
        h hVarC = fVar.c();
        if (hVarC != null) {
            ViewTreeObserver viewTreeObserver = this.f2756c;
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                fVar.f2743a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if (!this.f2754a) {
                this.f2754a = true;
                this.f2757d.b(hVarC);
            }
        }
        return true;
    }
}
