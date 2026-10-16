// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1571b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f1573d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.activity.o f1575f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f1578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f1580l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f1581m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final n f1582n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p002b.f f1583o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p002b.f f1584p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p002b.f f1585q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayDeque f1586r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1587s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1588t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1589u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f1590v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f1591w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList f1592x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public u f1593y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o f1594z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1570a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H.s f1572c = new H.s(5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f1574e = new k(this);
    public final m g = new m(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f1576h = new AtomicInteger();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f1577i = Collections.synchronizedMap(new HashMap());

    public r() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new CopyOnWriteArrayList();
        this.f1578j = new CopyOnWriteArrayList();
        this.f1579k = -1;
        this.f1582n = new n(this);
        this.f1586r = new ArrayDeque();
        this.f1594z = new o(this);
    }

    public final void a() {
        this.f1571b = false;
        this.f1591w.clear();
        this.f1590v.clear();
    }

    public final HashSet b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1572c.v().iterator();
        if (!it.hasNext()) {
            return hashSet;
        }
        y.a(it.next());
        throw null;
    }

    public final void c(int i2) {
        try {
            this.f1571b = true;
            Iterator it = ((HashMap) this.f1572c.f233c).values().iterator();
            while (it.hasNext()) {
                y.a(it.next());
            }
            h(i2, false);
            Iterator it2 = b().iterator();
            if (it2.hasNext()) {
                ((c) it2.next()).a();
                throw null;
            }
            this.f1571b = false;
            e(true);
        } catch (Throwable th) {
            this.f1571b = false;
            throw th;
        }
    }

    public final void d(boolean z2) {
        if (this.f1571b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1580l == null) {
            if (!this.f1589u) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1580l.f1549b.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2 && (this.f1587s || this.f1588t)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f1590v == null) {
            this.f1590v = new ArrayList();
            this.f1591w = new ArrayList();
        }
        this.f1571b = false;
    }

    public final boolean e(boolean z2) {
        boolean z3;
        d(z2);
        boolean z4 = false;
        while (true) {
            ArrayList arrayList = this.f1590v;
            ArrayList arrayList2 = this.f1591w;
            synchronized (this.f1570a) {
                try {
                    if (this.f1570a.isEmpty()) {
                        z3 = false;
                    } else {
                        int size = this.f1570a.size();
                        int i2 = 0;
                        z3 = false;
                        while (i2 < size) {
                            ((a) this.f1570a.get(i2)).c(arrayList, arrayList2);
                            i2++;
                            z3 = true;
                        }
                        this.f1570a.clear();
                        this.f1580l.f1549b.removeCallbacks(this.f1594z);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z3) {
                j();
                ((HashMap) this.f1572c.f233c).values().removeAll(Collections.singleton(null));
                return z4;
            }
            this.f1571b = true;
            try {
                i(this.f1590v, this.f1591w);
                a();
                z4 = true;
            } catch (Throwable th2) {
                a();
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    public final void f(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        int i4 = i2;
        boolean z2 = ((a) arrayList.get(i4)).f1530o;
        ArrayList arrayList3 = this.f1592x;
        if (arrayList3 == null) {
            this.f1592x = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f1592x.addAll(this.f1572c.w());
        int i5 = i4;
        boolean z3 = false;
        while (true) {
            int i6 = 1;
            if (i5 >= i3) {
                this.f1592x.clear();
                if (!z2 && this.f1579k >= 1) {
                    for (int i7 = i4; i7 < i3; i7++) {
                        Iterator it = ((a) arrayList.get(i7)).f1517a.iterator();
                        while (it.hasNext()) {
                            ((w) it.next()).getClass();
                        }
                    }
                }
                for (int i8 = i4; i8 < i3; i8++) {
                    a aVar = (a) arrayList.get(i8);
                    if (((Boolean) arrayList2.get(i8)).booleanValue()) {
                        aVar.a(-1);
                        ArrayList arrayList4 = aVar.f1517a;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            w wVar = (w) arrayList4.get(size);
                            wVar.getClass();
                            int i9 = wVar.f1617a;
                            s sVar = aVar.f1531p;
                            switch (i9) {
                                case 1:
                                    throw null;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + wVar.f1617a);
                                case 3:
                                    throw null;
                                case 4:
                                    throw null;
                                case 5:
                                    throw null;
                                case 6:
                                    throw null;
                                case 7:
                                    throw null;
                                case 8:
                                    sVar.getClass();
                                    break;
                                case 9:
                                    sVar.getClass();
                                    break;
                                case 10:
                                    sVar.getClass();
                                    throw null;
                            }
                        }
                    } else {
                        aVar.a(1);
                        ArrayList arrayList5 = aVar.f1517a;
                        int size2 = arrayList5.size();
                        for (int i10 = 0; i10 < size2; i10++) {
                            w wVar2 = (w) arrayList5.get(i10);
                            wVar2.getClass();
                            int i11 = wVar2.f1617a;
                            s sVar2 = aVar.f1531p;
                            switch (i11) {
                                case 1:
                                    throw null;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + wVar2.f1617a);
                                case 3:
                                    throw null;
                                case 4:
                                    throw null;
                                case 5:
                                    throw null;
                                case 6:
                                    throw null;
                                case 7:
                                    throw null;
                                case 8:
                                    sVar2.getClass();
                                    break;
                                case 9:
                                    sVar2.getClass();
                                    break;
                                case 10:
                                    sVar2.getClass();
                                    throw null;
                            }
                        }
                    }
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
                for (int i12 = i4; i12 < i3; i12++) {
                    a aVar2 = (a) arrayList.get(i12);
                    if (zBooleanValue) {
                        for (int size3 = aVar2.f1517a.size() - 1; size3 >= 0; size3--) {
                            ((w) aVar2.f1517a.get(size3)).getClass();
                        }
                    } else {
                        Iterator it2 = aVar2.f1517a.iterator();
                        while (it2.hasNext()) {
                            ((w) it2.next()).getClass();
                        }
                    }
                }
                h(this.f1579k, true);
                HashSet hashSet = new HashSet();
                for (int i13 = i4; i13 < i3; i13++) {
                    Iterator it3 = ((a) arrayList.get(i13)).f1517a.iterator();
                    while (it3.hasNext()) {
                        ((w) it3.next()).getClass();
                    }
                }
                Iterator it4 = hashSet.iterator();
                if (it4.hasNext()) {
                    ((c) it4.next()).getClass();
                    throw null;
                }
                while (i4 < i3) {
                    a aVar3 = (a) arrayList.get(i4);
                    if (((Boolean) arrayList2.get(i4)).booleanValue() && aVar3.f1532q >= 0) {
                        aVar3.f1532q = -1;
                    }
                    aVar3.getClass();
                    i4++;
                }
                return;
            }
            a aVar4 = (a) arrayList.get(i5);
            if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                int i14 = 1;
                ArrayList arrayList6 = this.f1592x;
                ArrayList arrayList7 = aVar4.f1517a;
                int size4 = arrayList7.size() - 1;
                while (size4 >= 0) {
                    w wVar3 = (w) arrayList7.get(size4);
                    int i15 = wVar3.f1617a;
                    if (i15 == i14) {
                        arrayList6.remove((Object) null);
                    } else if (i15 != 3) {
                        switch (i15) {
                            case 6:
                                arrayList6.add(null);
                                break;
                            case 7:
                                arrayList6.remove((Object) null);
                                break;
                            case 10:
                                wVar3.g = wVar3.f1622f;
                                break;
                        }
                    } else {
                        arrayList6.add(null);
                    }
                    size4--;
                    i14 = 1;
                }
            } else {
                ArrayList arrayList8 = this.f1592x;
                int i16 = 0;
                while (true) {
                    ArrayList arrayList9 = aVar4.f1517a;
                    if (i16 < arrayList9.size()) {
                        int i17 = ((w) arrayList9.get(i16)).f1617a;
                        if (i17 == i6) {
                            arrayList8.add(null);
                        } else {
                            if (i17 == 2) {
                                throw null;
                            }
                            if (i17 == 3 || i17 == 6) {
                                arrayList8.remove((Object) null);
                                arrayList9.add(i16, new w());
                            } else if (i17 == 7) {
                                arrayList8.add(null);
                            } else if (i17 == 8) {
                                arrayList9.add(i16, new w());
                            }
                            i16++;
                        }
                        i16++;
                        i6 = 1;
                    }
                }
            }
            z3 = z3 || aVar4.g;
            i5++;
        }
    }

    public final void g() {
        H.s sVar = this.f1572c;
        ArrayList arrayList = (ArrayList) sVar.f232b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) != null) {
                throw new ClassCastException();
            }
        }
        Iterator it = ((HashMap) sVar.f233c).values().iterator();
        while (it.hasNext()) {
            y.a(it.next());
        }
    }

    public final void h(int i2, boolean z2) {
        if (this.f1580l == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i2 != this.f1579k) {
            this.f1579k = i2;
            H.s sVar = this.f1572c;
            Iterator it = ((ArrayList) sVar.f232b).iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            Iterator it2 = ((HashMap) sVar.f233c).values().iterator();
            while (it2.hasNext()) {
                y.a(it2.next());
            }
            Iterator it3 = sVar.v().iterator();
            if (it3.hasNext()) {
                y.a(it3.next());
                throw null;
            }
        }
    }

    public final void i(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((a) arrayList.get(i2)).f1530o) {
                if (i3 != i2) {
                    f(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((a) arrayList.get(i3)).f1530o) {
                        i3++;
                    }
                }
                f(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            f(arrayList, arrayList2, i3, size);
        }
    }

    public final void j() {
        synchronized (this.f1570a) {
            try {
                if (!this.f1570a.isEmpty()) {
                    m mVar = this.g;
                    mVar.f1560a = true;
                    androidx.activity.j jVar = mVar.f1562c;
                    if (jVar != null) {
                        jVar.a(Boolean.TRUE);
                    }
                    return;
                }
                m mVar2 = this.g;
                ArrayList arrayList = this.f1573d;
                boolean z2 = (arrayList != null ? arrayList.size() : 0) > 0;
                mVar2.f1560a = z2;
                androidx.activity.j jVar2 = mVar2.f1562c;
                if (jVar2 != null) {
                    jVar2.a(Boolean.valueOf(z2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        g gVar = this.f1580l;
        if (gVar != null) {
            sb.append(gVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1580l)));
            sb.append("}");
        } else {
            sb.append("null");
        }
        sb.append("}}");
        return sb.toString();
    }
}
