// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1970f;
    public final Object g;

    public j0(int i2) {
        this.f1965a = 1;
        this.f1966b = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1970f = new p010f0.n();
        this.g = new p022m0.e();
    }

    public void a() {
        ArrayList arrayList = (ArrayList) this.f1970f;
        View view = (View) arrayList.get(arrayList.size() - 1);
        g0 g0Var = (g0) view.getLayoutParams();
        this.f1967c = ((StaggeredGridLayoutManager) this.g).f1853q.b(view);
        g0Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f1970f).clear();
        this.f1966b = Integer.MIN_VALUE;
        this.f1967c = Integer.MIN_VALUE;
        this.f1968d = 0;
    }

    public void c(Object obj, Object obj2, Object obj3) {
        F0.i.e(obj, "key");
        F0.i.e(obj2, "oldValue");
    }

    public int d() {
        boolean z2 = ((StaggeredGridLayoutManager) this.g).f1858v;
        ArrayList arrayList = (ArrayList) this.f1970f;
        return z2 ? f(arrayList.size() - 1, -1) : f(0, arrayList.size());
    }

    public int e() {
        boolean z2 = ((StaggeredGridLayoutManager) this.g).f1858v;
        ArrayList arrayList = (ArrayList) this.f1970f;
        return z2 ? f(0, arrayList.size()) : f(arrayList.size() - 1, -1);
    }

    public int f(int i2, int i3) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        int iK = staggeredGridLayoutManager.f1853q.k();
        int iG = staggeredGridLayoutManager.f1853q.g();
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View view = (View) ((ArrayList) this.f1970f).get(i2);
            int iE = staggeredGridLayoutManager.f1853q.e(view);
            int iB = staggeredGridLayoutManager.f1853q.b(view);
            boolean z2 = iE <= iG;
            boolean z3 = iB >= iK;
            if (z2 && z3 && (iE < iK || iB > iG)) {
                return N.C(view);
            }
            i2 += i4;
        }
        return -1;
    }

    public Object g(Object obj) {
        F0.i.e(obj, "key");
        synchronized (((p022m0.e) this.g)) {
            p010f0.n nVar = (p010f0.n) this.f1970f;
            nVar.getClass();
            Object obj2 = nVar.f2680a.get(obj);
            if (obj2 != null) {
                this.f1968d++;
                return obj2;
            }
            this.f1969e++;
            return null;
        }
    }

    public int h(int i2) {
        int i3 = this.f1967c;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (((ArrayList) this.f1970f).size() == 0) {
            return i2;
        }
        a();
        return this.f1967c;
    }

    public View i(int i2, int i3) {
        ArrayList arrayList = (ArrayList) this.f1970f;
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        View view = null;
        if (i3 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1858v && N.C(view2) >= i2) || ((!staggeredGridLayoutManager.f1858v && N.C(view2) <= i2) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                View view3 = (View) arrayList.get(i4);
                if ((staggeredGridLayoutManager.f1858v && N.C(view3) <= i2) || ((!staggeredGridLayoutManager.f1858v && N.C(view3) >= i2) || !view3.hasFocusable())) {
                    break;
                }
                i4++;
                view = view3;
            }
        }
        return view;
    }

    public int j(int i2) {
        int i3 = this.f1966b;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (((ArrayList) this.f1970f).size() == 0) {
            return i2;
        }
        View view = (View) ((ArrayList) this.f1970f).get(0);
        g0 g0Var = (g0) view.getLayoutParams();
        this.f1966b = ((StaggeredGridLayoutManager) this.g).f1853q.e(view);
        g0Var.getClass();
        return this.f1966b;
    }

    public Object k(Object obj, Object obj2) {
        Object objPut;
        F0.i.e(obj, "key");
        synchronized (((p022m0.e) this.g)) {
            this.f1967c += l(obj, obj2);
            p010f0.n nVar = (p010f0.n) this.f1970f;
            nVar.getClass();
            objPut = nVar.f2680a.put(obj, obj2);
            if (objPut != null) {
                this.f1967c -= l(obj, objPut);
            }
        }
        if (objPut != null) {
            c(obj, objPut, obj2);
        }
        n(this.f1966b);
        return objPut;
    }

    public int l(Object obj, Object obj2) {
        int iM = m(obj, obj2);
        if (iM >= 0) {
            return iM;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    public int m(Object obj, Object obj2) {
        F0.i.e(obj, "key");
        F0.i.e(obj2, "value");
        return 1;
    }

    public void n(int i2) {
        Object next;
        Object key;
        Object value;
        while (true) {
            synchronized (((p022m0.e) this.g)) {
                try {
                    if (this.f1967c < 0 || (((p010f0.n) this.f1970f).f2680a.isEmpty() && this.f1967c != 0)) {
                        break;
                    }
                    if (this.f1967c > i2 && !((p010f0.n) this.f1970f).f2680a.isEmpty()) {
                        Set setEntrySet = ((p010f0.n) this.f1970f).f2680a.entrySet();
                        F0.i.d(setEntrySet, "map.entries");
                        if (setEntrySet instanceof List) {
                            List list = (List) setEntrySet;
                            next = list.isEmpty() ? null : list.get(0);
                        } else {
                            Iterator it = setEntrySet.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        p010f0.n nVar = (p010f0.n) this.f1970f;
                        nVar.getClass();
                        F0.i.e(key, "key");
                        nVar.f2680a.remove(key);
                        this.f1967c -= l(key, value);
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            c(key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public String toString() {
        String str;
        switch (this.f1965a) {
            case 1:
                synchronized (((p022m0.e) this.g)) {
                    try {
                        int i2 = this.f1968d;
                        int i3 = this.f1969e + i2;
                        str = "LruCache[maxSize=" + this.f1966b + ",hits=" + this.f1968d + ",misses=" + this.f1969e + ",hitRate=" + (i3 != 0 ? (i2 * 100) / i3 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public j0(StaggeredGridLayoutManager staggeredGridLayoutManager, int i2) {
        this.f1965a = 0;
        this.g = staggeredGridLayoutManager;
        this.f1970f = new ArrayList();
        this.f1966b = Integer.MIN_VALUE;
        this.f1967c = Integer.MIN_VALUE;
        this.f1968d = 0;
        this.f1969e = i2;
    }
}
