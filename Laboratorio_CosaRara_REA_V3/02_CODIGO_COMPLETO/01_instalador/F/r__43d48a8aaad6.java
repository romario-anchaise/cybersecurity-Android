// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.J;
import A.X;
import H.s;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import f1.l;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2516d;

    public /* synthetic */ r(int i2, Object obj) {
        this.f2515c = i2;
        this.f2516d = obj;
    }

    @Override // A.i0
    public final void a() {
        Object obj = this.f2516d;
        switch (this.f2515c) {
            case 0:
                RunnableC0126p runnableC0126p = (RunnableC0126p) obj;
                runnableC0126p.f2512b.f2592v.setAlpha(1.0f);
                z zVar = runnableC0126p.f2512b;
                zVar.f2595y.d(null);
                zVar.f2595y = null;
                break;
            case 1:
                z zVar2 = (z) obj;
                zVar2.f2592v.setAlpha(1.0f);
                zVar2.f2595y.d(null);
                zVar2.f2595y = null;
                break;
            default:
                s sVar = (s) obj;
                ((z) sVar.f233c).f2592v.setVisibility(8);
                z zVar3 = (z) sVar.f233c;
                PopupWindow popupWindow = zVar3.f2593w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (zVar3.f2592v.getParent() instanceof View) {
                    View view = (View) zVar3.f2592v.getParent();
                    WeakHashMap weakHashMap = X.f14a;
                    J.c(view);
                }
                zVar3.f2592v.e();
                zVar3.f2595y.d(null);
                zVar3.f2595y = null;
                ViewGroup viewGroup = zVar3.f2548A;
                WeakHashMap weakHashMap2 = X.f14a;
                J.c(viewGroup);
                break;
        }
    }

    @Override // f1.l, A.i0
    public void c() {
        Object obj = this.f2516d;
        switch (this.f2515c) {
            case 0:
                ((RunnableC0126p) obj).f2512b.f2592v.setVisibility(0);
                break;
            case 1:
                z zVar = (z) obj;
                zVar.f2592v.setVisibility(0);
                if (zVar.f2592v.getParent() instanceof View) {
                    View view = (View) zVar.f2592v.getParent();
                    WeakHashMap weakHashMap = X.f14a;
                    J.c(view);
                }
                break;
        }
    }
}
