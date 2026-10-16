// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f44a;

    public h0(View view) {
        this.f44a = new WeakReference(view);
    }

    public final void a(float f2) {
        View view = (View) this.f44a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
    }

    public final void b() {
        View view = (View) this.f44a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j2) {
        View view = (View) this.f44a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    public final void d(i0 i0Var) {
        View view = (View) this.f44a.get();
        if (view != null) {
            if (i0Var != null) {
                view.animate().setListener(new f0(i0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f2) {
        View view = (View) this.f44a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
    }
}
