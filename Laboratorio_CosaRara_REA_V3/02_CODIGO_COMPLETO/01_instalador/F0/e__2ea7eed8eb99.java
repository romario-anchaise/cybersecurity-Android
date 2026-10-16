// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

import E0.r;
import E0.s;
import E0.t;
import E0.u;
import E0.v;
import E0.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements K0.b, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f172c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f173a;

    static {
        List listP = p036u0.e.p(new Class[]{E0.a.class, E0.l.class, E0.p.class, E0.q.class, r.class, s.class, t.class, u.class, v.class, w.class, E0.b.class, E0.c.class, E0.d.class, E0.e.class, E0.f.class, E0.g.class, E0.h.class, E0.i.class, E0.j.class, E0.k.class, E0.m.class, E0.n.class, E0.o.class});
        ArrayList arrayList = new ArrayList(p036u0.h.q(listP));
        int i2 = 0;
        for (Object obj : listP) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new p034t0.d((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f171b = p036u0.q.q(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        i.d(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            i.b(str);
            sb.append(M0.e.g0(str, '.', str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f171b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(p036u0.q.p(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            linkedHashMap.put(key, M0.e.g0(str2, '.', str2));
        }
        f172c = linkedHashMap;
    }

    public e(Class cls) {
        i.e(cls, "jClass");
        this.f173a = cls;
    }

    @Override // F0.d
    public final Class a() {
        return this.f173a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && f1.l.C(this).equals(f1.l.C((K0.b) obj));
    }

    public final int hashCode() {
        return f1.l.C(this).hashCode();
    }

    public final String toString() {
        return this.f173a.toString() + " (Kotlin reflection is not available)";
    }
}
