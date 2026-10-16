// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import A.h0;
import android.view.View;
import android.view.animation.BaseInterpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseInterpolator f2836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f1.l f2837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2838e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2835b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f2839f = new k(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2834a = new ArrayList();

    public final void a() {
        if (this.f2838e) {
            Iterator it = this.f2834a.iterator();
            while (it.hasNext()) {
                ((h0) it.next()).b();
            }
            this.f2838e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f2838e) {
            return;
        }
        for (h0 h0Var : this.f2834a) {
            long j2 = this.f2835b;
            if (j2 >= 0) {
                h0Var.c(j2);
            }
            BaseInterpolator baseInterpolator = this.f2836c;
            if (baseInterpolator != null && (view = (View) h0Var.f44a.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.f2837d != null) {
                h0Var.d(this.f2839f);
            }
            View view2 = (View) h0Var.f44a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f2838e = true;
    }
}
