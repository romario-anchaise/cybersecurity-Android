// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f1653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P f1654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f1655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0078p f1656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Q.e f1657e;

    public L(Application application, androidx.activity.i iVar, Bundle bundle) {
        P p2;
        this.f1657e = iVar.getSavedStateRegistry();
        this.f1656d = iVar.getLifecycle();
        this.f1655c = bundle;
        this.f1653a = application;
        if (application != null) {
            if (P.f1665c == null) {
                P.f1665c = new P(application);
            }
            p2 = P.f1665c;
            F0.i.b(p2);
        } else {
            p2 = new P(null);
        }
        this.f1654b = p2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final N a(String str, Class cls) {
        Object obj;
        Application application;
        AbstractC0078p abstractC0078p = this.f1656d;
        if (abstractC0078p == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0063a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f1653a == null) ? M.a(cls, M.f1659b) : M.a(cls, M.f1658a);
        if (constructorA == null) {
            if (this.f1653a != null) {
                return this.f1654b.b(cls);
            }
            if (S.f1667a == null) {
                S.f1667a = new S();
            }
            S s2 = S.f1667a;
            F0.i.b(s2);
            return s2.b(cls);
        }
        Q.e eVar = this.f1657e;
        F0.i.b(eVar);
        Bundle bundle = this.f1655c;
        Bundle bundleA = eVar.a(str);
        Class[] clsArr = F.f1636f;
        F fB = I.b(bundleA, bundle);
        G g = new G(str, fB);
        g.h(eVar, abstractC0078p);
        EnumC0077o enumC0077oB = abstractC0078p.b();
        if (enumC0077oB == EnumC0077o.f1682b || enumC0077oB.compareTo(EnumC0077o.f1684d) >= 0) {
            eVar.d();
        } else {
            abstractC0078p.a(new C0069g(eVar, abstractC0078p));
        }
        N nB = (!zIsAssignableFrom || (application = this.f1653a) == null) ? M.b(cls, constructorA, fB) : M.b(cls, constructorA, application, fB);
        synchronized (nB.f1660a) {
            try {
                obj = nB.f1660a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == null) {
                    nB.f1660a.put("androidx.lifecycle.savedstate.vm.tag", g);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            g = obj;
        }
        if (nB.f1662c) {
            N.a(g);
        }
        return nB;
    }

    @Override // androidx.lifecycle.Q
    public final N b(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.Q
    public final N c(Class cls, M.c cVar) {
        O o2 = O.f1664b;
        LinkedHashMap linkedHashMap = cVar.f359a;
        String str = (String) linkedHashMap.get(o2);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(I.f1645a) == null || linkedHashMap.get(I.f1646b) == null) {
            if (this.f1656d != null) {
                return a(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(O.f1663a);
        boolean zIsAssignableFrom = AbstractC0063a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? M.a(cls, M.f1659b) : M.a(cls, M.f1658a);
        if (constructorA == null) {
            return this.f1654b.c(cls, cVar);
        }
        return (!zIsAssignableFrom || application == null) ? M.b(cls, constructorA, I.c(cVar)) : M.b(cls, constructorA, application, I.c(cVar));
    }
}
