// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v;

import java.util.ArrayList;
import w.e;
import w.f;
import y.m;
import y.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f3272e;

    public b(e eVar) {
        eVar.getClass();
        this.f3268a = eVar;
        this.f3269b = new ArrayList();
        this.f3270c = new ArrayList();
    }

    public abstract boolean a(o oVar);

    public abstract boolean b(Object obj);

    public final void c(Iterable iterable) {
        iterable.getClass();
        this.f3269b.clear();
        this.f3270c.clear();
        ArrayList arrayList = this.f3269b;
        for (Object obj : iterable) {
            if (a((o) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = this.f3269b;
        ArrayList arrayList3 = this.f3270c;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            arrayList3.add(((o) obj2).f5999a);
        }
        boolean zIsEmpty = this.f3269b.isEmpty();
        e eVar = this.f3268a;
        if (zIsEmpty) {
            eVar.b(this);
        } else {
            eVar.getClass();
            synchronized (eVar.f3363c) {
                try {
                    if (eVar.f3364d.add(this)) {
                        if (eVar.f3364d.size() == 1) {
                            eVar.f3365e = eVar.a();
                            p.m.d().a(f.f3366a, eVar.getClass().getSimpleName() + ": initial state = " + eVar.f3365e);
                            eVar.d();
                        }
                        Object obj3 = eVar.f3365e;
                        this.f3271d = obj3;
                        d(this.f3272e, obj3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d(this.f3272e, this.f3271d);
    }

    public final void d(m mVar, Object obj) {
        if (this.f3269b.isEmpty() || mVar == null) {
            return;
        }
        if (obj == null || b(obj)) {
            ArrayList arrayList = this.f3269b;
            arrayList.getClass();
            synchronized (mVar.f5995e) {
                u.b bVar = (u.b) mVar.f5993c;
                if (bVar != null) {
                    bVar.d(arrayList);
                }
            }
            return;
        }
        ArrayList arrayList2 = this.f3269b;
        arrayList2.getClass();
        synchronized (mVar.f5995e) {
            try {
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    if (mVar.b(((o) obj2).f5999a)) {
                        arrayList3.add(obj2);
                    }
                }
                int size2 = arrayList3.size();
                while (i3 < size2) {
                    Object obj3 = arrayList3.get(i3);
                    i3++;
                    p.m.d().a(u.c.f3249a, "Constraints met for " + ((o) obj3));
                }
                u.b bVar2 = (u.b) mVar.f5993c;
                if (bVar2 != null) {
                    bVar2.c(arrayList3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
