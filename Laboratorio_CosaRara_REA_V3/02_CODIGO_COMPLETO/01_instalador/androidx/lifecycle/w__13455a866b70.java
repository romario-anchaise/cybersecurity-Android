// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractC0078p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1690a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p019l.a f1691b = new p019l.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EnumC0077o f1692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f1693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1695f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final P0.b f1697i;

    public w(InterfaceC0082u interfaceC0082u) {
        EnumC0077o enumC0077o = EnumC0077o.f1682b;
        this.f1692c = enumC0077o;
        this.f1696h = new ArrayList();
        this.f1693d = new WeakReference(interfaceC0082u);
        this.f1697i = new P0.b(enumC0077o);
    }

    @Override // androidx.lifecycle.AbstractC0078p
    public final void a(InterfaceC0081t interfaceC0081t) {
        InterfaceC0080s c0069g;
        InterfaceC0082u interfaceC0082u;
        ArrayList arrayList = this.f1696h;
        int i2 = 1;
        F0.i.e(interfaceC0081t, "observer");
        e("addObserver");
        EnumC0077o enumC0077o = this.f1692c;
        EnumC0077o enumC0077o2 = EnumC0077o.f1681a;
        if (enumC0077o != enumC0077o2) {
            enumC0077o2 = EnumC0077o.f1682b;
        }
        v vVar = new v();
        HashMap map = x.f1698a;
        boolean z2 = interfaceC0081t instanceof InterfaceC0080s;
        boolean z3 = interfaceC0081t instanceof InterfaceC0067e;
        Object obj = null;
        if (z2 && z3) {
            c0069g = new C0069g((InterfaceC0067e) interfaceC0081t, (InterfaceC0080s) interfaceC0081t);
        } else if (z3) {
            c0069g = new C0069g((InterfaceC0067e) interfaceC0081t, (InterfaceC0080s) null);
        } else if (z2) {
            c0069g = (InterfaceC0080s) interfaceC0081t;
        } else {
            Class<?> cls = interfaceC0081t.getClass();
            if (x.b(cls) == 2) {
                Object obj2 = x.f1699b.get(cls);
                F0.i.b(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    x.a((Constructor) list.get(0), interfaceC0081t);
                    throw null;
                }
                int size = list.size();
                InterfaceC0071i[] interfaceC0071iArr = new InterfaceC0071i[size];
                if (size > 0) {
                    x.a((Constructor) list.get(0), interfaceC0081t);
                    throw null;
                }
                c0069g = new Q.b(i2, interfaceC0071iArr);
            } else {
                c0069g = new C0069g(interfaceC0081t);
            }
        }
        vVar.f1689b = c0069g;
        vVar.f1688a = enumC0077o2;
        p019l.a aVar = this.f1691b;
        p019l.c cVarA = aVar.a(interfaceC0081t);
        if (cVarA != null) {
            obj = cVarA.f3524b;
        } else {
            HashMap map2 = aVar.f3519e;
            p019l.c cVar = new p019l.c(interfaceC0081t, vVar);
            aVar.f3533d++;
            p019l.c cVar2 = aVar.f3531b;
            if (cVar2 == null) {
                aVar.f3530a = cVar;
                aVar.f3531b = cVar;
            } else {
                cVar2.f3525c = cVar;
                cVar.f3526d = cVar2;
                aVar.f3531b = cVar;
            }
            map2.put(interfaceC0081t, cVar);
        }
        if (((v) obj) == null && (interfaceC0082u = (InterfaceC0082u) this.f1693d.get()) != null) {
            boolean z4 = this.f1694e != 0 || this.f1695f;
            EnumC0077o enumC0077oD = d(interfaceC0081t);
            this.f1694e++;
            while (vVar.f1688a.compareTo(enumC0077oD) < 0 && this.f1691b.f3519e.containsKey(interfaceC0081t)) {
                arrayList.add(vVar.f1688a);
                C0074l c0074l = EnumC0076n.Companion;
                EnumC0077o enumC0077o3 = vVar.f1688a;
                c0074l.getClass();
                EnumC0076n enumC0076nB = C0074l.b(enumC0077o3);
                if (enumC0076nB == null) {
                    throw new IllegalStateException("no event up from " + vVar.f1688a);
                }
                vVar.a(interfaceC0082u, enumC0076nB);
                arrayList.remove(arrayList.size() - 1);
                enumC0077oD = d(interfaceC0081t);
            }
            if (!z4) {
                h();
            }
            this.f1694e--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0078p
    public final EnumC0077o b() {
        return this.f1692c;
    }

    @Override // androidx.lifecycle.AbstractC0078p
    public final void c(InterfaceC0081t interfaceC0081t) {
        F0.i.e(interfaceC0081t, "observer");
        e("removeObserver");
        p019l.a aVar = this.f1691b;
        p019l.c cVarA = aVar.a(interfaceC0081t);
        if (cVarA != null) {
            aVar.f3533d--;
            WeakHashMap weakHashMap = aVar.f3532c;
            if (!weakHashMap.isEmpty()) {
                Iterator it = weakHashMap.keySet().iterator();
                while (it.hasNext()) {
                    ((p019l.e) it.next()).a(cVarA);
                }
            }
            p019l.c cVar = cVarA.f3526d;
            if (cVar != null) {
                cVar.f3525c = cVarA.f3525c;
            } else {
                aVar.f3530a = cVarA.f3525c;
            }
            p019l.c cVar2 = cVarA.f3525c;
            if (cVar2 != null) {
                cVar2.f3526d = cVar;
            } else {
                aVar.f3531b = cVar;
            }
            cVarA.f3525c = null;
            cVarA.f3526d = null;
        }
        aVar.f3519e.remove(interfaceC0081t);
    }

    public final EnumC0077o d(InterfaceC0081t interfaceC0081t) {
        v vVar;
        HashMap map = this.f1691b.f3519e;
        p019l.c cVar = map.containsKey(interfaceC0081t) ? ((p019l.c) map.get(interfaceC0081t)).f3526d : null;
        EnumC0077o enumC0077o = (cVar == null || (vVar = (v) cVar.f3524b) == null) ? null : vVar.f1688a;
        ArrayList arrayList = this.f1696h;
        EnumC0077o enumC0077o2 = arrayList.isEmpty() ? null : (EnumC0077o) arrayList.get(arrayList.size() - 1);
        EnumC0077o enumC0077o3 = this.f1692c;
        F0.i.e(enumC0077o3, "state1");
        if (enumC0077o == null || enumC0077o.compareTo(enumC0077o3) >= 0) {
            enumC0077o = enumC0077o3;
        }
        return (enumC0077o2 == null || enumC0077o2.compareTo(enumC0077o) >= 0) ? enumC0077o : enumC0077o2;
    }

    public final void e(String str) {
        p017k.a aVar;
        if (this.f1690a) {
            if (p017k.a.f3402d != null) {
                aVar = p017k.a.f3402d;
            } else {
                synchronized (p017k.a.class) {
                    try {
                        if (p017k.a.f3402d == null) {
                            p017k.a.f3402d = new p017k.a(0);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar = p017k.a.f3402d;
            }
            ((p017k.a) aVar.f3403c).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(F0.h.e("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(EnumC0076n enumC0076n) {
        F0.i.e(enumC0076n, "event");
        e("handleLifecycleEvent");
        g(enumC0076n.a());
    }

    public final void g(EnumC0077o enumC0077o) {
        EnumC0077o enumC0077o2 = this.f1692c;
        if (enumC0077o2 == enumC0077o) {
            return;
        }
        EnumC0077o enumC0077o3 = EnumC0077o.f1682b;
        EnumC0077o enumC0077o4 = EnumC0077o.f1681a;
        if (enumC0077o2 == enumC0077o3 && enumC0077o == enumC0077o4) {
            throw new IllegalStateException(("no event down from " + this.f1692c + " in component " + this.f1693d.get()).toString());
        }
        this.f1692c = enumC0077o;
        if (this.f1695f || this.f1694e != 0) {
            this.g = true;
            return;
        }
        this.f1695f = true;
        h();
        this.f1695f = false;
        if (this.f1692c == enumC0077o4) {
            this.f1691b = new p019l.a();
        }
    }

    public final void h() {
        InterfaceC0082u interfaceC0082u = (InterfaceC0082u) this.f1693d.get();
        if (interfaceC0082u == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            p019l.a aVar = this.f1691b;
            if (aVar.f3533d != 0) {
                p019l.c cVar = aVar.f3530a;
                F0.i.b(cVar);
                EnumC0077o enumC0077o = ((v) cVar.f3524b).f1688a;
                p019l.c cVar2 = this.f1691b.f3531b;
                F0.i.b(cVar2);
                EnumC0077o enumC0077o2 = ((v) cVar2.f3524b).f1688a;
                if (enumC0077o == enumC0077o2 && this.f1692c == enumC0077o2) {
                    break;
                }
                this.g = false;
                EnumC0077o enumC0077o3 = this.f1692c;
                p019l.c cVar3 = this.f1691b.f3530a;
                F0.i.b(cVar3);
                if (enumC0077o3.compareTo(((v) cVar3.f3524b).f1688a) < 0) {
                    p019l.a aVar2 = this.f1691b;
                    p019l.b bVar = new p019l.b(aVar2.f3531b, aVar2.f3530a, 1);
                    aVar2.f3532c.put(bVar, Boolean.FALSE);
                    while (bVar.hasNext() && !this.g) {
                        Map.Entry entry = (Map.Entry) bVar.next();
                        F0.i.d(entry, "next()");
                        InterfaceC0081t interfaceC0081t = (InterfaceC0081t) entry.getKey();
                        v vVar = (v) entry.getValue();
                        while (vVar.f1688a.compareTo(this.f1692c) > 0 && !this.g && this.f1691b.f3519e.containsKey(interfaceC0081t)) {
                            C0074l c0074l = EnumC0076n.Companion;
                            EnumC0077o enumC0077o4 = vVar.f1688a;
                            c0074l.getClass();
                            EnumC0076n enumC0076nA = C0074l.a(enumC0077o4);
                            if (enumC0076nA == null) {
                                throw new IllegalStateException("no event down from " + vVar.f1688a);
                            }
                            this.f1696h.add(enumC0076nA.a());
                            vVar.a(interfaceC0082u, enumC0076nA);
                            ArrayList arrayList = this.f1696h;
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
                p019l.c cVar4 = this.f1691b.f3531b;
                if (!this.g && cVar4 != null && this.f1692c.compareTo(((v) cVar4.f3524b).f1688a) > 0) {
                    p019l.a aVar3 = this.f1691b;
                    aVar3.getClass();
                    p019l.d dVar = new p019l.d(aVar3);
                    aVar3.f3532c.put(dVar, Boolean.FALSE);
                    while (dVar.hasNext() && !this.g) {
                        Map.Entry entry2 = (Map.Entry) dVar.next();
                        InterfaceC0081t interfaceC0081t2 = (InterfaceC0081t) entry2.getKey();
                        v vVar2 = (v) entry2.getValue();
                        while (vVar2.f1688a.compareTo(this.f1692c) < 0 && !this.g && this.f1691b.f3519e.containsKey(interfaceC0081t2)) {
                            this.f1696h.add(vVar2.f1688a);
                            C0074l c0074l2 = EnumC0076n.Companion;
                            EnumC0077o enumC0077o5 = vVar2.f1688a;
                            c0074l2.getClass();
                            EnumC0076n enumC0076nB = C0074l.b(enumC0077o5);
                            if (enumC0076nB == null) {
                                throw new IllegalStateException("no event up from " + vVar2.f1688a);
                            }
                            vVar2.a(interfaceC0082u, enumC0076nB);
                            ArrayList arrayList2 = this.f1696h;
                            arrayList2.remove(arrayList2.size() - 1);
                        }
                    }
                }
            } else {
                break;
            }
        }
        this.g = false;
        this.f1697i.a(this.f1692c);
    }
}
