// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0094l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1989b;

    public /* synthetic */ RunnableC0094l(int i2, Object obj) {
        this.f1988a = i2;
        this.f1989b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f1989b;
        switch (this.f1988a) {
            case 0:
                C0098p c0098p = (C0098p) obj;
                int i2 = c0098p.f2000A;
                ValueAnimator valueAnimator = c0098p.f2026z;
                if (i2 == 1) {
                    valueAnimator.cancel();
                } else if (i2 != 2) {
                }
                c0098p.f2000A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                break;
            default:
                ((StaggeredGridLayoutManager) obj).t0();
                break;
        }
    }
}
