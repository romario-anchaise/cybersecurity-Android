// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Q;

import F0.h;
import android.os.Bundle;
import androidx.activity.i;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0071i;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.J;
import androidx.lifecycle.N;
import androidx.lifecycle.T;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f519b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f518a = i2;
        this.f519b = obj;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        switch (this.f518a) {
            case 0:
                if (enumC0076n != EnumC0076n.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                interfaceC0082u.getLifecycle().c(this);
                i iVar = (i) this.f519b;
                Bundle bundleA = iVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
                if (bundleA == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                for (String str : stringArrayList) {
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(c.class);
                        F0.i.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                Object objNewInstance = declaredConstructor.newInstance(null);
                                F0.i.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                                T viewModelStore = iVar.getViewModelStore();
                                e savedStateRegistry = iVar.getSavedStateRegistry();
                                viewModelStore.getClass();
                                LinkedHashMap linkedHashMap = viewModelStore.f1668a;
                                for (String str2 : new HashSet(linkedHashMap.keySet())) {
                                    F0.i.e(str2, "key");
                                    N n2 = (N) linkedHashMap.get(str2);
                                    F0.i.b(n2);
                                    I.a(n2, savedStateRegistry, iVar.getLifecycle());
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    savedStateRegistry.d();
                                }
                            } catch (Exception e2) {
                                throw new RuntimeException("Failed to instantiate " + str, e2);
                            }
                        } catch (NoSuchMethodException e3) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
                        }
                    } catch (ClassNotFoundException e4) {
                        throw new RuntimeException(h.e("Class ", str, " wasn't found"), e4);
                    }
                }
                return;
            case 1:
                new HashMap();
                InterfaceC0071i[] interfaceC0071iArr = (InterfaceC0071i[]) this.f519b;
                if (interfaceC0071iArr.length > 0) {
                    InterfaceC0071i interfaceC0071i = interfaceC0071iArr[0];
                    throw null;
                }
                if (interfaceC0071iArr.length <= 0) {
                    return;
                }
                InterfaceC0071i interfaceC0071i2 = interfaceC0071iArr[0];
                throw null;
            default:
                if (enumC0076n != EnumC0076n.ON_CREATE) {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0076n).toString());
                }
                interfaceC0082u.getLifecycle().c(this);
                ((J) this.f519b).b();
                return;
        }
    }
}
