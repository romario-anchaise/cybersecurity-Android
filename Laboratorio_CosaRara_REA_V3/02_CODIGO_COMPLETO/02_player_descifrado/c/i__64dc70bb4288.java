// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import androidx.work.impl.WorkDatabase;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f388c;

    public i(WorkDatabase workDatabase) {
        workDatabase.getClass();
        this.f386a = workDatabase;
        this.f387b = new AtomicBoolean(false);
        this.f388c = new h1.c(new k.b(1, this));
    }

    public static boolean l(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public k.i a() {
        WorkDatabase workDatabase = (WorkDatabase) this.f386a;
        workDatabase.a();
        if (((AtomicBoolean) this.f387b).compareAndSet(false, true)) {
            return (k.i) ((h1.c) this.f388c).a();
        }
        String strK = k();
        workDatabase.getClass();
        workDatabase.a();
        workDatabase.b();
        return workDatabase.h().r().y(strK);
    }

    public abstract void b();

    public abstract Object c(int i3, int i4);

    public abstract Map d();

    public abstract int e();

    public abstract int f(Object obj);

    public abstract int g(Object obj);

    public abstract void h(Object obj, Object obj2);

    public abstract void i(int i3);

    public abstract Object j(int i3, Object obj);

    public abstract String k();

    public void m(k.i iVar) {
        iVar.getClass();
        if (iVar == ((k.i) ((h1.c) this.f388c).a())) {
            ((AtomicBoolean) this.f387b).set(false);
        }
    }

    public Object[] n(Object[] objArr, int i3) {
        int iE = e();
        if (objArr.length < iE) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iE);
        }
        for (int i4 = 0; i4 < iE; i4++) {
            objArr[i4] = c(i4, i3);
        }
        if (objArr.length > iE) {
            objArr[iE] = null;
        }
        return objArr;
    }
}
