// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.I;
import A.X;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class F0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f3043b;

    public /* synthetic */ F0(I0 i1, int i2) {
        this.f3042a = i2;
        this.f3043b = i1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        I0 i1 = this.f3043b;
        switch (this.f3042a) {
            case 0:
                C0178w0 c0178w0 = i1.f3057c;
                if (c0178w0 != null) {
                    c0178w0.setListSelectionHidden(true);
                    c0178w0.requestLayout();
                }
                break;
            default:
                C0178w0 c0178w1 = i1.f3057c;
                if (c0178w1 != null) {
                    WeakHashMap weakHashMap = X.f14a;
                    if (I.b(c0178w1) && i1.f3057c.getCount() > i1.f3057c.getChildCount() && i1.f3057c.getChildCount() <= i1.f3066m) {
                        i1.f3078y.setInputMethodMode(2);
                        i1.i();
                        break;
                    }
                }
                break;
        }
    }
}
