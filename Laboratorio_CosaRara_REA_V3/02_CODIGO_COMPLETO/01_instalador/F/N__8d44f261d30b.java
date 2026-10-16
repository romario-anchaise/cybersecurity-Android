// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.J;
import A.X;
import H.s;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import f1.l;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class N extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ P f2431d;

    public /* synthetic */ N(P p2, int i2) {
        this.f2430c = i2;
        this.f2431d = p2;
    }

    @Override // A.i0
    public final void a() {
        View view;
        P p2 = this.f2431d;
        switch (this.f2430c) {
            case 0:
                if (p2.f2451o && (view = p2.g) != null) {
                    view.setTranslationY(0.0f);
                    p2.f2441d.setTranslationY(0.0f);
                }
                p2.f2441d.setVisibility(8);
                p2.f2441d.setTransitioning(false);
                p2.f2455s = null;
                s sVar = p2.f2447k;
                if (sVar != null) {
                    sVar.e(p2.f2446j);
                    p2.f2446j = null;
                    p2.f2447k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = p2.f2440c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = X.f14a;
                    J.c(actionBarOverlayLayout);
                }
                break;
            default:
                p2.f2455s = null;
                p2.f2441d.requestLayout();
                break;
        }
    }
}
