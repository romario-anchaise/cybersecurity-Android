// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0087e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0093k f1915c;

    public /* synthetic */ RunnableC0087e(C0093k c0093k, ArrayList arrayList, int i2) {
        this.f1913a = i2;
        this.f1915c = c0093k;
        this.f1914b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1913a) {
            case 0:
                ArrayList arrayList = this.f1914b;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    C0093k c0093k = this.f1915c;
                    if (!zHasNext) {
                        arrayList.clear();
                        c0093k.f1977m.remove(arrayList);
                    } else {
                        C0092j c0092j = (C0092j) it.next();
                        c0 c0Var = c0092j.f1960a;
                        c0093k.getClass();
                        View view = c0Var.itemView;
                        int i2 = c0092j.f1963d - c0092j.f1961b;
                        int i3 = c0092j.f1964e - c0092j.f1962c;
                        if (i2 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i3 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        c0093k.f1980p.add(c0Var);
                        viewPropertyAnimatorAnimate.setDuration(c0093k.f1718e).setListener(new C0089g(c0093k, c0Var, i2, view, i3, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.f1914b;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    C0093k c0093k2 = this.f1915c;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        c0093k2.f1978n.remove(arrayList2);
                    } else {
                        C0091i c0091i = (C0091i) it2.next();
                        c0093k2.getClass();
                        c0 c0Var2 = c0091i.f1945a;
                        View view2 = c0Var2 == null ? null : c0Var2.itemView;
                        c0 c0Var3 = c0091i.f1946b;
                        View view3 = c0Var3 != null ? c0Var3.itemView : null;
                        ArrayList arrayList3 = c0093k2.f1982r;
                        long j2 = c0093k2.f1719f;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j2);
                            arrayList3.add(c0091i.f1945a);
                            duration.translationX(c0091i.f1949e - c0091i.f1947c);
                            duration.translationY(c0091i.f1950f - c0091i.f1948d);
                            duration.alpha(0.0f).setListener(new C0090h(c0093k2, c0091i, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(c0091i.f1946b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j2).alpha(1.0f).setListener(new C0090h(c0093k2, c0091i, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                        it2 = it2;
                    }
                    break;
                }
                break;
            default:
                ArrayList arrayList4 = this.f1914b;
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it3.hasNext();
                    C0093k c0093k3 = this.f1915c;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        c0093k3.f1976l.remove(arrayList4);
                    } else {
                        c0 c0Var4 = (c0) it3.next();
                        c0093k3.getClass();
                        View view4 = c0Var4.itemView;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        c0093k3.f1979o.add(c0Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(c0093k3.f1716c).setListener(new C0088f(c0093k3, c0Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
