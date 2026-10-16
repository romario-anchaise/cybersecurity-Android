// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import E0.l;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class j extends F0.j implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f2751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f2752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f2753d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(f fVar, ViewTreeObserver viewTreeObserver, k kVar) {
        super(1);
        this.f2751b = fVar;
        this.f2752c = viewTreeObserver;
        this.f2753d = kVar;
    }

    @Override // E0.l
    public final Object d(Object obj) {
        k kVar = this.f2753d;
        ViewTreeObserver viewTreeObserver = this.f2752c;
        f fVar = this.f2751b;
        fVar.getClass();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(kVar);
        } else {
            fVar.f2743a.getViewTreeObserver().removeOnPreDrawListener(kVar);
        }
        return p034t0.h.f4132b;
    }
}
