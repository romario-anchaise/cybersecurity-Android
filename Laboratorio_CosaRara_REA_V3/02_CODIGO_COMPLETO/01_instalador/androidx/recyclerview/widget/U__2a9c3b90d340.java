// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0001a;
import A.C0003c;
import A.C0023x;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1871f;
    public T g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1872h;

    public U(RecyclerView recyclerView) {
        this.f1872h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f1866a = arrayList;
        this.f1867b = null;
        this.f1868c = new ArrayList();
        this.f1869d = Collections.unmodifiableList(arrayList);
        this.f1870e = 2;
        this.f1871f = 2;
    }

    public final void a(c0 c0Var, boolean z2) {
        RecyclerView.i(c0Var);
        View view = c0Var.itemView;
        RecyclerView recyclerView = this.f1872h;
        e0 e0Var = recyclerView.f1812m0;
        if (e0Var != null) {
            d0 d0Var = e0Var.f1917e;
            A.X.h(view, d0Var != null ? (C0003c) d0Var.f1912e.remove(view) : null);
        }
        if (z2) {
            ArrayList arrayList = recyclerView.f1815o;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
            F f2 = recyclerView.f1811m;
            if (f2 != null) {
                f2.onViewRecycled(c0Var);
            }
            if (recyclerView.f1799f0 != null) {
                recyclerView.g.G(c0Var);
            }
            if (RecyclerView.f1765z0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + c0Var);
            }
        }
        c0Var.mBindingAdapter = null;
        c0Var.mOwnerRecyclerView = null;
        T tC = c();
        tC.getClass();
        int itemViewType = c0Var.getItemViewType();
        ArrayList arrayList2 = tC.a(itemViewType).f1837a;
        if (((S) tC.f1863a.get(itemViewType)).f1838b <= arrayList2.size()) {
            f1.d.f(c0Var.itemView);
        } else {
            if (RecyclerView.f1764y0 && arrayList2.contains(c0Var)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            c0Var.resetInternal();
            arrayList2.add(c0Var);
        }
    }

    public final int b(int i2) {
        RecyclerView recyclerView = this.f1872h;
        if (i2 >= 0 && i2 < recyclerView.f1799f0.b()) {
            return !recyclerView.f1799f0.f1880f ? i2 : recyclerView.f1796e.g(i2, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + recyclerView.f1799f0.b() + recyclerView.y());
    }

    public final T c() {
        if (this.g == null) {
            T t2 = new T();
            t2.f1863a = new SparseArray();
            t2.f1864b = 0;
            t2.f1865c = Collections.newSetFromMap(new IdentityHashMap());
            this.g = t2;
            d();
        }
        return this.g;
    }

    public final void d() {
        RecyclerView recyclerView;
        F f2;
        T t2 = this.g;
        if (t2 == null || (f2 = (recyclerView = this.f1872h).f1811m) == null || !recyclerView.f1823s) {
            return;
        }
        t2.f1865c.add(f2);
    }

    public final void e(F f2, boolean z2) {
        T t2 = this.g;
        if (t2 == null) {
            return;
        }
        Set set = t2.f1865c;
        set.remove(f2);
        if (set.size() != 0 || z2) {
            return;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = t2.f1863a;
            if (i2 >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((S) sparseArray.get(sparseArray.keyAt(i2))).f1837a;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                f1.d.f(((c0) arrayList.get(i3)).itemView);
            }
            i2++;
        }
    }

    public final void f() {
        ArrayList arrayList = this.f1868c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.f1761E0) {
            r rVar = this.f1872h.f1797e0;
            int[] iArr = rVar.f2030c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            rVar.f2031d = 0;
        }
    }

    public final void g(int i2) {
        if (RecyclerView.f1765z0) {
            Log.d("RecyclerView", "Recycling cached view at index " + i2);
        }
        ArrayList arrayList = this.f1868c;
        c0 c0Var = (c0) arrayList.get(i2);
        if (RecyclerView.f1765z0) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + c0Var);
        }
        a(c0Var, true);
        arrayList.remove(i2);
    }

    public final void h(View view) {
        c0 c0VarI = RecyclerView.I(view);
        boolean zIsTmpDetached = c0VarI.isTmpDetached();
        RecyclerView recyclerView = this.f1872h;
        if (zIsTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (c0VarI.isScrap()) {
            c0VarI.unScrap();
        } else if (c0VarI.wasReturnedFromScrap()) {
            c0VarI.clearReturnedFromScrapFlag();
        }
        i(c0VarI);
        if (recyclerView.f1777L == null || c0VarI.isRecyclable()) {
            return;
        }
        recyclerView.f1777L.d(c0VarI);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d7 A[LOOP:2: B:57:0x00cc->B:61:0x00d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x00da A[EDGE_INSN: B:87:0x00da->B:62:0x00da BREAK  A[LOOP:1: B:53:0x00b7->B:60:0x00d4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00da A[EDGE_INSN: B:88:0x00da->B:62:0x00da BREAK  A[LOOP:1: B:53:0x00b7->B:60:0x00d4, LOOP_LABEL: LOOP:1: B:53:0x00b7->B:60:0x00d4], SYNTHETIC] */
    public final void i(c0 c0Var) {
        boolean z2;
        int i2;
        int i3;
        r rVar;
        int i4;
        int i5;
        boolean zIsScrap = c0Var.isScrap();
        boolean z3 = false;
        boolean z4 = true;
        RecyclerView recyclerView = this.f1872h;
        if (zIsScrap || c0Var.itemView.getParent() != null) {
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(c0Var.isScrap());
            sb.append(" isAttached:");
            sb.append(c0Var.itemView.getParent() != null);
            sb.append(recyclerView.y());
            throw new IllegalArgumentException(sb.toString());
        }
        if (c0Var.isTmpDetached()) {
            StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb2.append(c0Var);
            throw new IllegalArgumentException(F0.h.c(recyclerView, sb2));
        }
        if (c0Var.shouldIgnore()) {
            throw new IllegalArgumentException(F0.h.c(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }
        boolean zDoesTransientStatePreventRecycling = c0Var.doesTransientStatePreventRecycling();
        F f2 = recyclerView.f1811m;
        boolean z5 = f2 != null && zDoesTransientStatePreventRecycling && f2.onFailedToRecycleView(c0Var);
        boolean z6 = RecyclerView.f1764y0;
        ArrayList arrayList = this.f1868c;
        if (z6 && arrayList.contains(c0Var)) {
            StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
            sb3.append(c0Var);
            throw new IllegalArgumentException(F0.h.c(recyclerView, sb3));
        }
        if (z5 || c0Var.isRecyclable()) {
            if (this.f1871f <= 0 || c0Var.hasAnyOfTheFlags(526)) {
                z2 = false;
            } else {
                int size = arrayList.size();
                if (size >= this.f1871f && size > 0) {
                    g(0);
                    size--;
                }
                if (RecyclerView.f1761E0 && size > 0) {
                    r rVar2 = recyclerView.f1797e0;
                    int i6 = c0Var.mPosition;
                    if (rVar2.f2030c != null) {
                        int i7 = rVar2.f2031d * 2;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i7) {
                                i2 = size - 1;
                                loop1: while (i2 >= 0) {
                                    i3 = ((c0) arrayList.get(i2)).mPosition;
                                    rVar = recyclerView.f1797e0;
                                    if (rVar.f2030c != null) {
                                        break;
                                    }
                                    i4 = rVar.f2031d * 2;
                                    i5 = 0;
                                    while (true) {
                                        if (i5 < i4) {
                                            break loop1;
                                        } else if (rVar.f2030c[i5] == i3) {
                                            break;
                                        } else {
                                            i5 += 2;
                                        }
                                    }
                                    i2--;
                                }
                                size = i2 + 1;
                            } else if (rVar2.f2030c[i8] != i6) {
                                i8 += 2;
                            }
                        }
                    } else {
                        i2 = size - 1;
                        loop1: while (i2 >= 0) {
                            i3 = ((c0) arrayList.get(i2)).mPosition;
                            rVar = recyclerView.f1797e0;
                            if (rVar.f2030c != null) {
                                break;
                                break;
                            }
                            i4 = rVar.f2031d * 2;
                            i5 = 0;
                            while (true) {
                                if (i5 < i4) {
                                    break loop1;
                                    break loop1;
                                } else if (rVar.f2030c[i5] == i3) {
                                    break;
                                } else {
                                    i5 += 2;
                                }
                            }
                            i2--;
                        }
                        size = i2 + 1;
                    }
                }
                arrayList.add(size, c0Var);
                z2 = true;
            }
            if (z2) {
                z4 = false;
            } else {
                a(c0Var, true);
            }
            z3 = z2;
        } else {
            if (RecyclerView.f1765z0) {
                Log.d("RecyclerView", "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + recyclerView.y());
            }
            z4 = false;
        }
        recyclerView.g.G(c0Var);
        if (z3 || z4 || !zDoesTransientStatePreventRecycling) {
            return;
        }
        f1.d.f(c0Var.itemView);
        c0Var.mBindingAdapter = null;
        c0Var.mOwnerRecyclerView = null;
    }

    public final void j(View view) {
        K k2;
        c0 c0VarI = RecyclerView.I(view);
        boolean zHasAnyOfTheFlags = c0VarI.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f1872h;
        if (!zHasAnyOfTheFlags && c0VarI.isUpdated() && (k2 = recyclerView.f1777L) != null) {
            C0093k c0093k = (C0093k) k2;
            if (c0VarI.getUnmodifiedPayloads().isEmpty() && c0093k.g && !c0VarI.isInvalid()) {
                if (this.f1867b == null) {
                    this.f1867b = new ArrayList();
                }
                c0VarI.setScrapContainer(this, true);
                this.f1867b.add(c0VarI);
                return;
            }
        }
        if (c0VarI.isInvalid() && !c0VarI.isRemoved() && !recyclerView.f1811m.hasStableIds()) {
            throw new IllegalArgumentException(F0.h.c(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        c0VarI.setScrapContainer(this, false);
        this.f1866a.add(c0VarI);
    }

    /* JADX WARN: Code duplicated, block: B:188:0x035f A[EDGE_INSN: B:188:0x035f->B:189:0x0360 BREAK  A[LOOP:6: B:183:0x0347->B:187:0x035c]] */
    /* JADX WARN: Code duplicated, block: B:298:0x0531  */
    /* JADX WARN: Code duplicated, block: B:299:0x053d  */
    /* JADX WARN: Code duplicated, block: B:301:0x0543  */
    /* JADX WARN: Code duplicated, block: B:302:0x054f  */
    /* JADX WARN: Code duplicated, block: B:307:0x0559  */
    /* JADX WARN: Code duplicated, block: B:35:0x0081 A[EDGE_INSN: B:35:0x0081->B:36:0x0082 BREAK  A[LOOP:0: B:14:0x0027->B:20:0x0041]] */
    /* JADX WARN: Code duplicated, block: B:74:0x011c  */
    public final c0 k(int i2, long j2) {
        boolean z2;
        c0 c0VarCreateViewHolder;
        boolean z3;
        boolean z4;
        boolean z5;
        ViewGroup.LayoutParams layoutParams;
        O o2;
        boolean z6;
        RecyclerView recyclerViewD;
        c0 c0Var;
        c0 c0Var2;
        View view;
        int iB;
        boolean z7;
        int size;
        int iG;
        int i3 = -1;
        RecyclerView recyclerView = this.f1872h;
        if (i2 < 0 || i2 >= recyclerView.f1799f0.b()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + recyclerView.f1799f0.b() + recyclerView.y());
        }
        Y y2 = recyclerView.f1799f0;
        if (y2.f1880f) {
            ArrayList arrayList = this.f1867b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        if (recyclerView.f1811m.hasStableIds() && (iG = recyclerView.f1796e.g(i2, 0)) > 0 && iG < recyclerView.f1811m.getItemCount()) {
                            long itemId = recyclerView.f1811m.getItemId(iG);
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size) {
                                    c0VarCreateViewHolder = null;
                                    break;
                                }
                                c0 c0Var3 = (c0) this.f1867b.get(i5);
                                if (!c0Var3.wasReturnedFromScrap() && c0Var3.getItemId() == itemId) {
                                    c0Var3.addFlags(32);
                                    c0VarCreateViewHolder = c0Var3;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            c0VarCreateViewHolder = null;
                            break;
                        }
                    } else {
                        c0VarCreateViewHolder = (c0) this.f1867b.get(i4);
                        if (!c0VarCreateViewHolder.wasReturnedFromScrap() && c0VarCreateViewHolder.getLayoutPosition() == i2) {
                            c0VarCreateViewHolder.addFlags(32);
                            break;
                        }
                        i4++;
                    }
                }
            } else {
                c0VarCreateViewHolder = null;
                break;
            }
            z2 = c0VarCreateViewHolder != null;
        } else {
            z2 = false;
            c0VarCreateViewHolder = null;
        }
        ArrayList arrayList2 = this.f1868c;
        ArrayList arrayList3 = this.f1866a;
        if (c0VarCreateViewHolder == null) {
            int size2 = arrayList3.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size2) {
                    ArrayList arrayList4 = recyclerView.f1798f.f1908c;
                    int size3 = arrayList4.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size3) {
                            view = null;
                            break;
                        }
                        view = (View) arrayList4.get(i7);
                        c0 c0VarI = RecyclerView.I(view);
                        if (c0VarI.getLayoutPosition() == i2 && !c0VarI.isInvalid() && !c0VarI.isRemoved()) {
                            break;
                        }
                        i7++;
                    }
                    if (view == null) {
                        int size4 = arrayList2.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size4) {
                                c0VarCreateViewHolder = null;
                                break;
                            }
                            c0VarCreateViewHolder = (c0) arrayList2.get(i8);
                            if (!c0VarCreateViewHolder.isInvalid() && c0VarCreateViewHolder.getLayoutPosition() == i2 && !c0VarCreateViewHolder.isAttachedToTransitionOverlay()) {
                                arrayList2.remove(i8);
                                if (!RecyclerView.f1765z0) {
                                    break;
                                }
                                Log.d("RecyclerView", "getScrapOrHiddenOrCachedHolderForPosition(" + i2 + ") found match in cache: " + c0VarCreateViewHolder);
                                break;
                            }
                            i8++;
                        }
                    } else {
                        c0 c0VarI2 = RecyclerView.I(view);
                        C0086d c0086d = recyclerView.f1798f;
                        int iIndexOfChild = c0086d.f1906a.f1703a.indexOfChild(view);
                        if (iIndexOfChild < 0) {
                            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                        }
                        C0085c c0085c = c0086d.f1907b;
                        if (!c0085c.d(iIndexOfChild)) {
                            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                        }
                        c0085c.a(iIndexOfChild);
                        c0086d.j(view);
                        C0086d c0086d2 = recyclerView.f1798f;
                        int iIndexOfChild2 = c0086d2.f1906a.f1703a.indexOfChild(view);
                        if (iIndexOfChild2 == -1) {
                            iB = -1;
                        } else {
                            C0085c c0085c2 = c0086d2.f1907b;
                            if (c0085c2.d(iIndexOfChild2)) {
                                iB = -1;
                            } else {
                                iB = iIndexOfChild2 - c0085c2.b(iIndexOfChild2);
                            }
                        }
                        if (iB == -1) {
                            StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                            sb.append(c0VarI2);
                            throw new IllegalStateException(F0.h.c(recyclerView, sb));
                        }
                        recyclerView.f1798f.c(iB);
                        j(view);
                        c0VarI2.addFlags(8224);
                        c0VarCreateViewHolder = c0VarI2;
                        break;
                    }
                } else {
                    c0 c0Var4 = (c0) arrayList3.get(i6);
                    if (!c0Var4.wasReturnedFromScrap() && c0Var4.getLayoutPosition() == i2 && !c0Var4.isInvalid() && (y2.f1880f || !c0Var4.isRemoved())) {
                        c0Var4.addFlags(32);
                        c0VarCreateViewHolder = c0Var4;
                        break;
                    }
                    i6++;
                }
            }
            if (c0VarCreateViewHolder != null) {
                if (!c0VarCreateViewHolder.isRemoved()) {
                    int i9 = c0VarCreateViewHolder.mPosition;
                    if (i9 < 0 || i9 >= recyclerView.f1811m.getItemCount()) {
                        StringBuilder sb2 = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                        sb2.append(c0VarCreateViewHolder);
                        throw new IndexOutOfBoundsException(F0.h.c(recyclerView, sb2));
                    }
                    z7 = (y2.f1880f || recyclerView.f1811m.getItemViewType(c0VarCreateViewHolder.mPosition) == c0VarCreateViewHolder.getItemViewType()) && (!recyclerView.f1811m.hasStableIds() || c0VarCreateViewHolder.getItemId() == recyclerView.f1811m.getItemId(c0VarCreateViewHolder.mPosition));
                } else {
                    if (RecyclerView.f1764y0 && !y2.f1880f) {
                        throw new IllegalStateException(F0.h.c(recyclerView, new StringBuilder("should not receive a removed view unless it is pre layout")));
                    }
                    z7 = y2.f1880f;
                }
                if (z7) {
                    z2 = true;
                } else {
                    c0VarCreateViewHolder.addFlags(4);
                    if (c0VarCreateViewHolder.isScrap()) {
                        recyclerView.removeDetachedView(c0VarCreateViewHolder.itemView, false);
                        c0VarCreateViewHolder.unScrap();
                    } else if (c0VarCreateViewHolder.wasReturnedFromScrap()) {
                        c0VarCreateViewHolder.clearReturnedFromScrapFlag();
                    }
                    i(c0VarCreateViewHolder);
                    c0VarCreateViewHolder = null;
                }
            }
        }
        if (c0VarCreateViewHolder == null) {
            int iG2 = recyclerView.f1796e.g(i2, 0);
            if (iG2 < 0 || iG2 >= recyclerView.f1811m.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + iG2 + ").state:" + y2.b() + recyclerView.y());
            }
            int itemViewType = recyclerView.f1811m.getItemViewType(iG2);
            if (recyclerView.f1811m.hasStableIds()) {
                long itemId2 = recyclerView.f1811m.getItemId(iG2);
                int size5 = arrayList3.size() - 1;
                while (true) {
                    if (size5 < 0) {
                        int size6 = arrayList2.size() - 1;
                        while (true) {
                            if (size6 >= 0) {
                                c0Var2 = (c0) arrayList2.get(size6);
                                if (c0Var2.getItemId() != itemId2 || c0Var2.isAttachedToTransitionOverlay()) {
                                    size6--;
                                } else {
                                    if (itemViewType == c0Var2.getItemViewType()) {
                                        arrayList2.remove(size6);
                                        break;
                                    }
                                    g(size6);
                                }
                            }
                            c0Var2 = null;
                            break;
                        }
                    }
                    c0Var2 = (c0) arrayList3.get(size5);
                    if (c0Var2.getItemId() == itemId2 && !c0Var2.wasReturnedFromScrap()) {
                        if (itemViewType == c0Var2.getItemViewType()) {
                            c0Var2.addFlags(32);
                            if (!c0Var2.isRemoved() || y2.f1880f) {
                                break;
                                break;
                            }
                            c0Var2.setFlags(2, 14);
                            break;
                        }
                        arrayList3.remove(size5);
                        recyclerView.removeDetachedView(c0Var2.itemView, false);
                        c0 c0VarI3 = RecyclerView.I(c0Var2.itemView);
                        c0VarI3.mScrapContainer = null;
                        c0VarI3.mInChangeScrap = false;
                        c0VarI3.clearReturnedFromScrapFlag();
                        i(c0VarI3);
                        i3 = -1;
                    }
                    size5 += i3;
                }
                if (c0Var2 != null) {
                    c0Var2.mPosition = iG2;
                    c0VarCreateViewHolder = c0Var2;
                    z2 = true;
                } else {
                    c0VarCreateViewHolder = c0Var2;
                }
            }
            if (c0VarCreateViewHolder == null) {
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline(" + i2 + ") fetching from shared pool");
                }
                S s2 = (S) c().f1863a.get(itemViewType);
                if (s2 == null) {
                    c0Var = null;
                    break;
                }
                ArrayList arrayList5 = s2.f1837a;
                if (!arrayList5.isEmpty()) {
                    int size7 = arrayList5.size() - 1;
                    while (true) {
                        if (size7 < 0) {
                            c0Var = null;
                            break;
                        }
                        if (!((c0) arrayList5.get(size7)).isAttachedToTransitionOverlay()) {
                            c0Var = (c0) arrayList5.remove(size7);
                            break;
                        }
                        size7--;
                    }
                } else {
                    c0Var = null;
                    break;
                }
                if (c0Var != null) {
                    c0Var.resetInternal();
                    boolean z8 = RecyclerView.f1764y0;
                }
                c0VarCreateViewHolder = c0Var;
            }
            if (c0VarCreateViewHolder == null) {
                long nanoTime = recyclerView.getNanoTime();
                if (j2 != Long.MAX_VALUE) {
                    long j3 = this.g.a(itemViewType).f1839c;
                    if (!(j3 == 0 || j3 + nanoTime < j2)) {
                        return null;
                    }
                }
                c0VarCreateViewHolder = recyclerView.f1811m.createViewHolder(recyclerView, itemViewType);
                if (RecyclerView.f1761E0 && (recyclerViewD = RecyclerView.D(c0VarCreateViewHolder.itemView)) != null) {
                    c0VarCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewD);
                }
                long nanoTime2 = recyclerView.getNanoTime() - nanoTime;
                S sA = this.g.a(itemViewType);
                long j4 = sA.f1839c;
                if (j4 != 0) {
                    nanoTime2 = (nanoTime2 / 4) + ((j4 / 4) * 3);
                }
                sA.f1839c = nanoTime2;
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                }
            }
        }
        if (z2 && !y2.f1880f && c0VarCreateViewHolder.hasAnyOfTheFlags(8192)) {
            c0VarCreateViewHolder.setFlags(0, 8192);
            if (y2.f1882i) {
                K.b(c0VarCreateViewHolder);
                K k2 = recyclerView.f1777L;
                c0VarCreateViewHolder.getUnmodifiedPayloads();
                k2.getClass();
                C0023x c0023x = new C0023x();
                c0023x.a(c0VarCreateViewHolder);
                recyclerView.U(c0VarCreateViewHolder, c0023x);
            }
        }
        if (!y2.f1880f || !c0VarCreateViewHolder.isBound()) {
            if (!c0VarCreateViewHolder.isBound() || c0VarCreateViewHolder.needsUpdate() || c0VarCreateViewHolder.isInvalid()) {
                if (RecyclerView.f1764y0 && c0VarCreateViewHolder.isRemoved()) {
                    StringBuilder sb3 = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                    sb3.append(c0VarCreateViewHolder);
                    throw new IllegalStateException(F0.h.c(recyclerView, sb3));
                }
                int iG3 = recyclerView.f1796e.g(i2, 0);
                C0003c c0003c = null;
                c0VarCreateViewHolder.mBindingAdapter = null;
                c0VarCreateViewHolder.mOwnerRecyclerView = recyclerView;
                int itemViewType2 = c0VarCreateViewHolder.getItemViewType();
                long nanoTime3 = recyclerView.getNanoTime();
                if (j2 != Long.MAX_VALUE) {
                    long j5 = this.g.a(itemViewType2).f1840d;
                    if (j5 == 0 || j5 + nanoTime3 < j2) {
                    }
                }
                if (c0VarCreateViewHolder.isTmpDetached()) {
                    recyclerView.attachViewToParent(c0VarCreateViewHolder.itemView, recyclerView.getChildCount(), c0VarCreateViewHolder.itemView.getLayoutParams());
                    z3 = true;
                } else {
                    z3 = false;
                }
                recyclerView.f1811m.bindViewHolder(c0VarCreateViewHolder, iG3);
                if (z3) {
                    recyclerView.detachViewFromParent(c0VarCreateViewHolder.itemView);
                }
                long nanoTime4 = recyclerView.getNanoTime() - nanoTime3;
                S sA2 = this.g.a(c0VarCreateViewHolder.getItemViewType());
                long j6 = sA2.f1840d;
                if (j6 != 0) {
                    nanoTime4 = (nanoTime4 / 4) + ((j6 / 4) * 3);
                }
                sA2.f1840d = nanoTime4;
                AccessibilityManager accessibilityManager = recyclerView.f1767B;
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    View view2 = c0VarCreateViewHolder.itemView;
                    WeakHashMap weakHashMap = A.X.f14a;
                    if (A.G.c(view2) == 0) {
                        z4 = true;
                        A.G.s(view2, 1);
                    } else {
                        z4 = true;
                    }
                    e0 e0Var = recyclerView.f1812m0;
                    if (e0Var != null) {
                        d0 d0Var = e0Var.f1917e;
                        if (d0Var != null) {
                            View.AccessibilityDelegate accessibilityDelegateC = A.X.c(view2);
                            if (accessibilityDelegateC != null) {
                                c0003c = accessibilityDelegateC instanceof C0001a ? ((C0001a) accessibilityDelegateC).f19a : new C0003c(accessibilityDelegateC);
                            }
                            if (c0003c != null && c0003c != d0Var) {
                                d0Var.f1912e.put(view2, c0003c);
                            }
                        }
                        A.X.h(view2, d0Var);
                    }
                } else {
                    z4 = true;
                }
                if (y2.f1880f) {
                    c0VarCreateViewHolder.mPreLayoutPosition = i2;
                }
                z5 = z4;
            }
            layoutParams = c0VarCreateViewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
                o2 = (O) recyclerView.generateDefaultLayoutParams();
                c0VarCreateViewHolder.itemView.setLayoutParams(o2);
            } else if (recyclerView.checkLayoutParams(layoutParams)) {
                o2 = (O) layoutParams;
            } else {
                o2 = (O) recyclerView.generateLayoutParams(layoutParams);
                c0VarCreateViewHolder.itemView.setLayoutParams(o2);
            }
            o2.f1754a = c0VarCreateViewHolder;
            if (z2 || !z5) {
                z6 = false;
            } else {
                z6 = z4;
            }
            o2.f1757d = z6;
            return c0VarCreateViewHolder;
        }
        c0VarCreateViewHolder.mPreLayoutPosition = i2;
        z5 = false;
        z4 = true;
        layoutParams = c0VarCreateViewHolder.itemView.getLayoutParams();
        if (layoutParams == null) {
            o2 = (O) recyclerView.generateDefaultLayoutParams();
            c0VarCreateViewHolder.itemView.setLayoutParams(o2);
        } else if (recyclerView.checkLayoutParams(layoutParams)) {
            o2 = (O) recyclerView.generateLayoutParams(layoutParams);
            c0VarCreateViewHolder.itemView.setLayoutParams(o2);
        } else {
            o2 = (O) layoutParams;
        }
        o2.f1754a = c0VarCreateViewHolder;
        if (z2) {
            z6 = false;
        } else {
            z6 = false;
        }
        o2.f1757d = z6;
        return c0VarCreateViewHolder;
    }

    public final void l(c0 c0Var) {
        if (c0Var.mInChangeScrap) {
            this.f1867b.remove(c0Var);
        } else {
            this.f1866a.remove(c0Var);
        }
        c0Var.mScrapContainer = null;
        c0Var.mInChangeScrap = false;
        c0Var.clearReturnedFromScrapFlag();
    }

    public final void m() {
        N n2 = this.f1872h.f1813n;
        this.f1871f = this.f1870e + (n2 != null ? n2.f1748i : 0);
        ArrayList arrayList = this.f1868c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f1871f; size--) {
            g(size);
        }
    }
}
