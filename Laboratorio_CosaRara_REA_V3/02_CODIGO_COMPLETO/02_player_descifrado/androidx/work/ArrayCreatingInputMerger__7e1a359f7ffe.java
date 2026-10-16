// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work;

import g2.o0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p.e;
import p.g;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends g {
    @Override // p.g
    public final e a(ArrayList arrayList) throws Throwable {
        Object objNewInstance;
        o0 o0Var = new o0(1);
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((e) obj).f2843a);
            mapUnmodifiableMap.getClass();
            for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value != null ? value.getClass() : String.class;
                Object obj2 = map.get(str);
                str.getClass();
                if (obj2 != null) {
                    Class<?> cls2 = obj2.getClass();
                    if (cls2.equals(cls)) {
                        value.getClass();
                        int length = Array.getLength(obj2);
                        int length2 = Array.getLength(value);
                        Class<?> componentType = obj2.getClass().getComponentType();
                        componentType.getClass();
                        Object objNewInstance2 = Array.newInstance(componentType, length + length2);
                        System.arraycopy(obj2, 0, objNewInstance2, 0, length);
                        System.arraycopy(value, 0, objNewInstance2, length, length2);
                        objNewInstance2.getClass();
                        value = objNewInstance2;
                    } else {
                        if (!q1.e.a(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj2);
                        objNewInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj2, 0, objNewInstance, 0, length3);
                        Array.set(objNewInstance, length3, value);
                        objNewInstance.getClass();
                        value = objNewInstance;
                    }
                } else if (!cls.isArray()) {
                    objNewInstance = Array.newInstance(cls, 1);
                    Array.set(objNewInstance, 0, value);
                    objNewInstance.getClass();
                    value = objNewInstance;
                }
                value.getClass();
                map.put(str, value);
            }
        }
        o0Var.b(map);
        e eVar = new e(o0Var.f1701a);
        e.b(eVar);
        return eVar;
    }
}
