// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import p013i.l;
import p013i.n;

/* JADX INFO: renamed from: j.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0150i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0146g f3201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0154k f3202b;

    public RunnableC0150i(C0154k c0154k, C0146g c0146g) {
        this.f3202b = c0154k;
        this.f3201a = c0146g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar;
        C0154k c0154k = this.f3202b;
        n nVar = c0154k.f3208c;
        if (nVar != null && (lVar = nVar.f2935e) != null) {
            lVar.f(nVar);
        }
        View view = (View) c0154k.f3212h;
        if (view != null && view.getWindowToken() != null) {
            C0146g c0146g = this.f3201a;
            if (c0146g.b()) {
                c0154k.f3223s = c0146g;
            } else if (c0146g.f3001e != null) {
                c0146g.d(0, 0, false, false);
                c0154k.f3223s = c0146g;
            }
        }
        c0154k.f3225u = null;
    }
}
