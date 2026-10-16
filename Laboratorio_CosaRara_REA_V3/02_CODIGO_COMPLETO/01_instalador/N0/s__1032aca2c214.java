// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import H.s;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p018k0.h;
import p018k0.j;
import p018k0.m;
import p018k0.p;
import p018k0.y;
import p018k0.z;
import p020l0.b;
import p022m0.r;
import p028p0.d;
import p032r0.a;

/* JADX INFO: renamed from: n0.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0236s implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f3956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f3957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p022m0.h f3958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0227i f3959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3960e;

    public C0236s(s sVar, h hVar, p022m0.h hVar2, C0227i c0227i, List list) {
        this.f3956a = sVar;
        this.f3957b = hVar;
        this.f3958c = hVar2;
        this.f3959d = c0227i;
        this.f3960e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (r.f3738a.a(obj, accessibleObject)) {
            return;
        }
        throw new p(d.d(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    public static void c(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + d.c(field) + " and " + d.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Class cls = aVar.f4029a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        p028p0.a aVar2 = d.f4001a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new j(2);
        }
        p022m0.d.f(this.f3960e);
        return d.f4001a.l(cls) ? new r(cls, d(mVar, aVar, cls, true)) : new C0234p(this.f3956a.t(aVar), d(mVar, aVar, cls, false));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[LOOP:2: B:77:0x0177->B:104:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    /* JADX WARN: Code duplicated, block: B:60:0x0116  */
    /* JADX WARN: Code duplicated, block: B:61:0x0135  */
    /* JADX WARN: Code duplicated, block: B:63:0x0143  */
    /* JADX WARN: Code duplicated, block: B:64:0x0146  */
    /* JADX WARN: Code duplicated, block: B:67:0x014c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0154  */
    /* JADX WARN: Code duplicated, block: B:71:0x0156  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:76:0x0173  */
    /* JADX WARN: Code duplicated, block: B:79:0x017d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0198  */
    /* JADX WARN: Code duplicated, block: B:97:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x01a3 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r32v0, types: [n0.s] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    public final C0235q d(m mVar, a aVar, Class cls, boolean z2) {
        Type type;
        ?? r27;
        ?? r28;
        Method method;
        b bVar;
        String strValue;
        String[] strArrAlternate;
        boolean z3;
        ?? r15;
        ?? r4;
        List listSingletonList;
        String str;
        a aVar2;
        Class cls2;
        ?? r23;
        int modifiers;
        ?? r24;
        p020l0.a aVar3;
        a aVar4;
        String str2;
        ?? r29;
        y yVarB;
        boolean z4;
        a aVar5;
        y yVar;
        C0232n c0232n;
        String str3;
        C0232n c0232n2;
        C0232n c0232n3;
        y c0238u;
        if (cls.isInterface()) {
            return C0235q.f3949c;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        a aVar6 = aVar;
        Class cls3 = cls;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            if (cls3 != cls && declaredFields.length > 0) {
                p022m0.d.f(this.f3960e);
            }
            int length = declaredFields.length;
            ?? r16 = 0;
            int i2 = 0;
            while (true) {
                type = aVar6.f4030b;
                if (i2 < length) {
                    Field field = declaredFields[i2];
                    boolean zE = e(field, true);
                    boolean zE2 = e(field, r16);
                    if (zE || zE2) {
                        if (z2) {
                            if (Modifier.isStatic(field.getModifiers())) {
                                r27 = r16;
                            } else {
                                Method methodH = d.f4001a.h(cls3, field);
                                d.f(methodH);
                                if (methodH.getAnnotation(b.class) != null && field.getAnnotation(b.class) == null) {
                                    throw new p(F0.h.e("@SerializedName on ", d.d(methodH, r16), " is not supported"));
                                }
                                r28 = zE2;
                                method = methodH;
                            }
                            if (method == null) {
                                d.f(field);
                            }
                            Type typeJ = p022m0.d.j(type, cls3, field.getGenericType(), new HashMap());
                            bVar = (b) field.getAnnotation(b.class);
                            if (bVar == null) {
                                listSingletonList = Collections.singletonList(this.f3957b.b(field));
                            } else {
                                strValue = bVar.value();
                                strArrAlternate = bVar.alternate();
                                if (strArrAlternate.length == 0) {
                                    listSingletonList = Collections.singletonList(strValue);
                                } else {
                                    z3 = true;
                                    ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
                                    arrayList.add(strValue);
                                    Collections.addAll(arrayList, strArrAlternate);
                                    r15 = arrayList;
                                    r4 = 0;
                                }
                                str = (String) r15.get(r4);
                                aVar2 = new a(typeJ);
                                cls2 = aVar2.f4029a;
                                if (cls2 == null && cls2.isPrimitive()) {
                                    r23 = z3;
                                } else {
                                    r23 = r4;
                                }
                                modifiers = field.getModifiers();
                                if (Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
                                    r24 = r4;
                                } else {
                                    r24 = z3;
                                }
                                aVar3 = (p020l0.a) field.getAnnotation(p020l0.a.class);
                                if (aVar3 != null) {
                                    aVar4 = aVar2;
                                    str2 = str;
                                    r29 = 0;
                                    yVarB = this.f3959d.a(this.f3956a, mVar, aVar4, aVar3, false);
                                } else {
                                    aVar4 = aVar2;
                                    str2 = str;
                                    r29 = r4;
                                    yVarB = null;
                                }
                                if (yVarB != null) {
                                    z4 = z3;
                                } else {
                                    z4 = r29 == true ? 1 : 0;
                                }
                                aVar5 = aVar4;
                                if (yVarB == null) {
                                    yVarB = mVar.b(aVar5);
                                }
                                if (zE) {
                                    if (z4) {
                                        c0238u = yVarB;
                                    } else {
                                        c0238u = new C0238u(mVar, yVarB, aVar5.f4030b);
                                    }
                                    yVar = c0238u;
                                } else {
                                    yVar = yVarB;
                                }
                                c0232n = new C0232n(str2, field, false, method, yVar, yVarB, r23, r24);
                                if (r28 != 0) {
                                    for (String str4 : r15) {
                                        c0232n3 = (C0232n) linkedHashMap.put(str4, c0232n);
                                        if (c0232n3 == null) {
                                            c(cls, str4, c0232n3.f3940b, field);
                                            throw null;
                                        }
                                    }
                                }
                                if (zE) {
                                    str3 = str2;
                                    c0232n2 = (C0232n) linkedHashMap2.put(str3, c0232n);
                                    if (c0232n2 == null) {
                                        c(cls, str3, c0232n2.f3940b, field);
                                        throw null;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            r4 = r16;
                            z3 = true;
                            r15 = listSingletonList;
                            str = (String) r15.get(r4);
                            aVar2 = new a(typeJ);
                            cls2 = aVar2.f4029a;
                            if (cls2 == null) {
                                r23 = r4;
                            } else {
                                r23 = r4;
                            }
                            modifiers = field.getModifiers();
                            if (Modifier.isStatic(modifiers)) {
                                r24 = r4;
                            } else {
                                r24 = r4;
                            }
                            aVar3 = (p020l0.a) field.getAnnotation(p020l0.a.class);
                            if (aVar3 != null) {
                                aVar4 = aVar2;
                                str2 = str;
                                r29 = 0;
                                yVarB = this.f3959d.a(this.f3956a, mVar, aVar4, aVar3, false);
                            } else {
                                aVar4 = aVar2;
                                str2 = str;
                                r29 = r4;
                                yVarB = null;
                            }
                            if (yVarB != null) {
                                z4 = z3;
                            } else {
                                z4 = r29 == true ? 1 : 0;
                            }
                            aVar5 = aVar4;
                            if (yVarB == null) {
                                yVarB = mVar.b(aVar5);
                            }
                            if (zE) {
                                if (z4) {
                                    c0238u = yVarB;
                                } else {
                                    c0238u = new C0238u(mVar, yVarB, aVar5.f4030b);
                                }
                                yVar = c0238u;
                            } else {
                                yVar = yVarB;
                            }
                            c0232n = new C0232n(str2, field, false, method, yVar, yVarB, r23, r24);
                            if (r28 != 0) {
                                while (r1.hasNext()) {
                                    c0232n3 = (C0232n) linkedHashMap.put(str4, c0232n);
                                    if (c0232n3 == null) {
                                        c(cls, str4, c0232n3.f3940b, field);
                                        throw null;
                                    }
                                }
                            }
                            if (zE) {
                                str3 = str2;
                                c0232n2 = (C0232n) linkedHashMap2.put(str3, c0232n);
                                if (c0232n2 == null) {
                                    c(cls, str3, c0232n2.f3940b, field);
                                    throw null;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            r27 = zE2;
                        }
                        method = null;
                        r28 = r27;
                        if (method == null) {
                            d.f(field);
                        }
                        Type typeJ2 = p022m0.d.j(type, cls3, field.getGenericType(), new HashMap());
                        bVar = (b) field.getAnnotation(b.class);
                        if (bVar == null) {
                            listSingletonList = Collections.singletonList(this.f3957b.b(field));
                        } else {
                            strValue = bVar.value();
                            strArrAlternate = bVar.alternate();
                            if (strArrAlternate.length == 0) {
                                listSingletonList = Collections.singletonList(strValue);
                            } else {
                                z3 = true;
                                ArrayList arrayList2 = new ArrayList(strArrAlternate.length + 1);
                                arrayList2.add(strValue);
                                Collections.addAll(arrayList2, strArrAlternate);
                                r15 = arrayList2;
                                r4 = 0;
                            }
                            str = (String) r15.get(r4);
                            aVar2 = new a(typeJ2);
                            cls2 = aVar2.f4029a;
                            if (cls2 == null) {
                                r23 = r4;
                            } else {
                                r23 = r4;
                            }
                            modifiers = field.getModifiers();
                            if (Modifier.isStatic(modifiers)) {
                                r24 = r4;
                            } else {
                                r24 = r4;
                            }
                            aVar3 = (p020l0.a) field.getAnnotation(p020l0.a.class);
                            if (aVar3 != null) {
                                aVar4 = aVar2;
                                str2 = str;
                                r29 = 0;
                                yVarB = this.f3959d.a(this.f3956a, mVar, aVar4, aVar3, false);
                            } else {
                                aVar4 = aVar2;
                                str2 = str;
                                r29 = r4;
                                yVarB = null;
                            }
                            if (yVarB != null) {
                                z4 = z3;
                            } else {
                                z4 = r29 == true ? 1 : 0;
                            }
                            aVar5 = aVar4;
                            if (yVarB == null) {
                                yVarB = mVar.b(aVar5);
                            }
                            if (zE) {
                                if (z4) {
                                    c0238u = yVarB;
                                } else {
                                    c0238u = new C0238u(mVar, yVarB, aVar5.f4030b);
                                }
                                yVar = c0238u;
                            } else {
                                yVar = yVarB;
                            }
                            c0232n = new C0232n(str2, field, false, method, yVar, yVarB, r23, r24);
                            if (r28 != 0) {
                                while (r1.hasNext()) {
                                    c0232n3 = (C0232n) linkedHashMap.put(str4, c0232n);
                                    if (c0232n3 == null) {
                                        c(cls, str4, c0232n3.f3940b, field);
                                        throw null;
                                    }
                                }
                            }
                            if (zE) {
                                str3 = str2;
                                c0232n2 = (C0232n) linkedHashMap2.put(str3, c0232n);
                                if (c0232n2 == null) {
                                    c(cls, str3, c0232n2.f3940b, field);
                                    throw null;
                                }
                            } else {
                                continue;
                            }
                        }
                        r4 = r16;
                        z3 = true;
                        r15 = listSingletonList;
                        str = (String) r15.get(r4);
                        aVar2 = new a(typeJ2);
                        cls2 = aVar2.f4029a;
                        if (cls2 == null) {
                            r23 = r4;
                        } else {
                            r23 = r4;
                        }
                        modifiers = field.getModifiers();
                        if (Modifier.isStatic(modifiers)) {
                            r24 = r4;
                        } else {
                            r24 = r4;
                        }
                        aVar3 = (p020l0.a) field.getAnnotation(p020l0.a.class);
                        if (aVar3 != null) {
                            aVar4 = aVar2;
                            str2 = str;
                            r29 = 0;
                            yVarB = this.f3959d.a(this.f3956a, mVar, aVar4, aVar3, false);
                        } else {
                            aVar4 = aVar2;
                            str2 = str;
                            r29 = r4;
                            yVarB = null;
                        }
                        if (yVarB != null) {
                            z4 = z3;
                        } else {
                            z4 = r29 == true ? 1 : 0;
                        }
                        aVar5 = aVar4;
                        if (yVarB == null) {
                            yVarB = mVar.b(aVar5);
                        }
                        if (zE) {
                            if (z4) {
                                c0238u = yVarB;
                            } else {
                                c0238u = new C0238u(mVar, yVarB, aVar5.f4030b);
                            }
                            yVar = c0238u;
                        } else {
                            yVar = yVarB;
                        }
                        c0232n = new C0232n(str2, field, false, method, yVar, yVarB, r23, r24);
                        if (r28 != 0) {
                            while (r1.hasNext()) {
                                c0232n3 = (C0232n) linkedHashMap.put(str4, c0232n);
                                if (c0232n3 == null) {
                                    c(cls, str4, c0232n3.f3940b, field);
                                    throw null;
                                }
                            }
                        }
                        if (zE) {
                            str3 = str2;
                            c0232n2 = (C0232n) linkedHashMap2.put(str3, c0232n);
                            if (c0232n2 == null) {
                                c(cls, str3, c0232n2.f3940b, field);
                                throw null;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        i2 = i2;
                        r29 = r16;
                    }
                    i2++;
                    r16 = r29;
                }
            }
            aVar6 = new a(p022m0.d.j(type, cls3, cls3.getGenericSuperclass(), new HashMap()));
            cls3 = aVar6.f4029a;
        }
        return new C0235q(linkedHashMap, new ArrayList(linkedHashMap2.values()));
    }

    public final boolean e(Field field, boolean z2) {
        boolean z3;
        p022m0.h hVar = this.f3958c;
        hVar.getClass();
        if ((field.getModifiers() & 136) != 0 || field.isSynthetic() || hVar.c(field.getType(), z2)) {
            z3 = true;
        } else {
            List list = z2 ? hVar.f3710a : hVar.f3711b;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            z3 = false;
        }
        return !z3;
    }
}
