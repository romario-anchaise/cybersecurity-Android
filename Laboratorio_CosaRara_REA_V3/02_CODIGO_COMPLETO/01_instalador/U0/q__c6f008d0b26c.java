// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p028p0.a;
import p034t0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class q extends a {
    public static int p(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map q(ArrayList arrayList) {
        o oVar = o.f4147a;
        int size = arrayList.size();
        if (size == 0) {
            return oVar;
        }
        if (size == 1) {
            d dVar = (d) arrayList.get(0);
            i.e(dVar, "pair");
            Map mapSingletonMap = Collections.singletonMap(dVar.f4126a, dVar.f4127b);
            i.d(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(p(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            linkedHashMap.put(dVar2.f4126a, dVar2.f4127b);
        }
        return linkedHashMap;
    }

    public static Map r(Map map) {
        i.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return o.f4147a;
        }
        if (size != 1) {
            return s(map);
        }
        i.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        i.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static LinkedHashMap s(Map map) {
        i.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
