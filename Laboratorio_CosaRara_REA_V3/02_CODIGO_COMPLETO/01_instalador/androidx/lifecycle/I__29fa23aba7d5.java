// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f1645a = new O();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final O f1646b = new O();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O f1647c = new O();

    public static final void a(N n2, Q.e eVar, AbstractC0078p abstractC0078p) {
        Object obj;
        F0.i.e(eVar, "registry");
        F0.i.e(abstractC0078p, "lifecycle");
        HashMap map = n2.f1660a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = n2.f1660a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        G g = (G) obj;
        if (g == null || g.f1644c) {
            return;
        }
        g.h(eVar, abstractC0078p);
        EnumC0077o enumC0077oB = abstractC0078p.b();
        if (enumC0077oB == EnumC0077o.f1682b || enumC0077oB.compareTo(EnumC0077o.f1684d) >= 0) {
            eVar.d();
        } else {
            abstractC0078p.a(new C0069g(eVar, abstractC0078p));
        }
    }

    public static F b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new F();
            }
            HashMap map = new HashMap();
            for (String str : bundle2.keySet()) {
                F0.i.d(str, "key");
                map.put(str, bundle2.get(str));
            }
            return new F(map);
        }
        ClassLoader classLoader = F.class.getClassLoader();
        F0.i.b(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = parcelableArrayList.get(i2);
            F0.i.c(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
        }
        return new F(linkedHashMap);
    }

    public static final F c(M.c cVar) {
        O o2 = f1645a;
        LinkedHashMap linkedHashMap = cVar.f359a;
        Q.g gVar = (Q.g) linkedHashMap.get(o2);
        if (gVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        U u2 = (U) linkedHashMap.get(f1646b);
        if (u2 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f1647c);
        String str = (String) linkedHashMap.get(O.f1664b);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        Q.d dVarB = gVar.getSavedStateRegistry().b();
        J j2 = dVarB instanceof J ? (J) dVarB : null;
        if (j2 == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = d(u2).f1652d;
        F f2 = (F) linkedHashMap2.get(str);
        if (f2 != null) {
            return f2;
        }
        Class[] clsArr = F.f1636f;
        j2.b();
        Bundle bundle2 = j2.f1650c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = j2.f1650c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = j2.f1650c;
        if (bundle5 != null && bundle5.isEmpty()) {
            j2.f1650c = null;
        }
        F fB = b(bundle3, bundle);
        linkedHashMap2.put(str, fB);
        return fB;
    }

    public static final K d(U u2) {
        return (K) new C.h(u2.getViewModelStore(), new H(), u2 instanceof InterfaceC0072j ? ((InterfaceC0072j) u2).getDefaultViewModelCreationExtras() : M.a.f358b).j("androidx.lifecycle.internal.SavedStateHandlesVM", K.class);
    }
}
