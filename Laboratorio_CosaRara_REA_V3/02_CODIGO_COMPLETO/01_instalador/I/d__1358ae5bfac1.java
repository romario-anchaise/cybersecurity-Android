// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.X;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p015j.I;
import p015j.J;
import p015j.O0;
import p015j.P;
import p015j.T;

/* JADX INFO: renamed from: i.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0130d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2882b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0130d(int i2, Object obj) {
        this.f2881a = i2;
        this.f2882b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object obj = this.f2882b;
        switch (this.f2881a) {
            case 0:
                h hVar = (h) obj;
                if (hVar.b()) {
                    ArrayList arrayList = hVar.f2897h;
                    if (arrayList.size() > 0 && !((C0133g) arrayList.get(0)).f2889a.f3077x) {
                        View view = hVar.f2904o;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C0133g) it.next()).f2889a.i();
                            }
                        } else {
                            hVar.dismiss();
                        }
                        break;
                    }
                }
                break;
            case 1:
                F f2 = (F) obj;
                if (f2.b()) {
                    O0 o2 = f2.f2849h;
                    if (!o2.f3077x) {
                        View view2 = f2.f2854m;
                        if (view2 != null && view2.isShown()) {
                            o2.i();
                        } else {
                            f2.dismiss();
                        }
                    }
                }
                break;
            case 2:
                T t2 = (T) obj;
                if (!t2.getInternalPopup().b()) {
                    t2.f3121f.f(J.b(t2), J.a(t2));
                }
                ViewTreeObserver viewTreeObserver = t2.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    I.a(viewTreeObserver, this);
                }
                break;
            default:
                P p2 = (P) obj;
                T t3 = p2.f3099F;
                p2.getClass();
                WeakHashMap weakHashMap = X.f14a;
                if (A.I.b(t3) && t3.getGlobalVisibleRect(p2.f3097D)) {
                    p2.s();
                    p2.i();
                } else {
                    p2.dismiss();
                }
                break;
        }
    }
}
