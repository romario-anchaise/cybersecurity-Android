// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0064b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1669a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1670b;

    public C0064b(HashMap map) {
        this.f1670b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0076n enumC0076n = (EnumC0076n) entry.getValue();
            List arrayList = (List) this.f1669a.get(enumC0076n);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1669a.put(enumC0076n, arrayList);
            }
            arrayList.add((C0065c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n, InterfaceC0081t interfaceC0081t) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0065c c0065c = (C0065c) list.get(size);
                c0065c.getClass();
                try {
                    int i2 = c0065c.f1671a;
                    Method method = c0065c.f1672b;
                    if (i2 == 0) {
                        method.invoke(interfaceC0081t, null);
                    } else if (i2 == 1) {
                        method.invoke(interfaceC0081t, interfaceC0082u);
                    } else if (i2 == 2) {
                        method.invoke(interfaceC0081t, interfaceC0082u, enumC0076n);
                    }
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException("Failed to call observer method", e3.getCause());
                }
            }
        }
    }
}
