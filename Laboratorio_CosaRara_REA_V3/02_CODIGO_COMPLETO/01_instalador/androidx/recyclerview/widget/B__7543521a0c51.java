// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1702b;

    public /* synthetic */ B(RecyclerView recyclerView, int i2) {
        this.f1701a = i2;
        this.f1702b = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView = this.f1702b;
        switch (this.f1701a) {
            case 0:
                if (recyclerView.f1827u && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.f1823s) {
                        recyclerView.requestLayout();
                    } else if (!recyclerView.f1833x) {
                        recyclerView.m();
                    } else {
                        recyclerView.f1831w = true;
                    }
                    break;
                }
                break;
            default:
                K k2 = recyclerView.f1777L;
                if (k2 != null) {
                    C0093k c0093k = (C0093k) k2;
                    ArrayList arrayList = c0093k.f1972h;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = c0093k.f1974j;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = c0093k.f1975k;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = c0093k.f1973i;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (!zIsEmpty || !zIsEmpty2 || !zIsEmpty4 || !zIsEmpty3) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean zHasNext = it.hasNext();
                            long j2 = c0093k.f1717d;
                            if (zHasNext) {
                                c0 c0Var = (c0) it.next();
                                View view = c0Var.itemView;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                c0093k.f1981q.add(c0Var);
                                viewPropertyAnimatorAnimate.setDuration(j2).alpha(0.0f).setListener(new C0088f(c0093k, c0Var, viewPropertyAnimatorAnimate, view)).start();
                                it = it;
                            } else {
                                arrayList.clear();
                                if (!zIsEmpty2) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    c0093k.f1977m.add(arrayList5);
                                    arrayList2.clear();
                                    RunnableC0087e runnableC0087e = new RunnableC0087e(c0093k, arrayList5, 0);
                                    if (zIsEmpty) {
                                        runnableC0087e.run();
                                    } else {
                                        View view2 = ((C0092j) arrayList5.get(0)).f1960a.itemView;
                                        WeakHashMap weakHashMap = A.X.f14a;
                                        A.G.n(view2, runnableC0087e, j2);
                                    }
                                }
                                if (!zIsEmpty3) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    c0093k.f1978n.add(arrayList6);
                                    arrayList3.clear();
                                    RunnableC0087e runnableC0087e2 = new RunnableC0087e(c0093k, arrayList6, 1);
                                    if (zIsEmpty) {
                                        runnableC0087e2.run();
                                    } else {
                                        View view3 = ((C0091i) arrayList6.get(0)).f1945a.itemView;
                                        WeakHashMap weakHashMap2 = A.X.f14a;
                                        A.G.n(view3, runnableC0087e2, j2);
                                    }
                                }
                                if (!zIsEmpty4) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    c0093k.f1976l.add(arrayList7);
                                    arrayList4.clear();
                                    RunnableC0087e runnableC0087e3 = new RunnableC0087e(c0093k, arrayList7, 2);
                                    if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                                        runnableC0087e3.run();
                                    } else {
                                        if (zIsEmpty) {
                                            j2 = 0;
                                        }
                                        long jMax = Math.max(!zIsEmpty2 ? c0093k.f1718e : 0L, zIsEmpty3 ? 0L : c0093k.f1719f) + j2;
                                        View view4 = ((c0) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = A.X.f14a;
                                        A.G.n(view4, runnableC0087e3, jMax);
                                    }
                                }
                            }
                        }
                    }
                }
                recyclerView.f1810l0 = false;
                break;
        }
    }
}
