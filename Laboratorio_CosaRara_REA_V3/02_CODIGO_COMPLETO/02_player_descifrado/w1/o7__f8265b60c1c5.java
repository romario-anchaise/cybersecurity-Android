// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n8 f4732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j7 f4733l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m7 f4734m;
    public final List n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f4735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f4736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f4737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map f4738r;

    public o7(long j3, long j4, long j5, int i3, int i4, int i5, String str, boolean z2, n8 n8Var, List list, j7 j7Var, long j6, int i6, m7 m7Var, List list2, String str2, List list3) {
        this.f4722a = j3;
        this.f4723b = j4;
        this.f4724c = j5;
        this.f4725d = Math.max(0L, j6);
        this.f4726e = i6;
        this.f4727f = i3;
        this.f4728g = i4;
        this.f4729h = i5;
        this.f4730i = str == null ? "" : str;
        this.f4731j = z2;
        this.f4732k = n8Var;
        this.f4733l = j7Var;
        this.f4734m = m7Var;
        this.n = Collections.unmodifiableList(new ArrayList(list));
        this.f4735o = Collections.unmodifiableList(new ArrayList(list2 == null ? Collections.EMPTY_LIST : list2));
        this.f4736p = str2 != null ? str2 : "";
        this.f4737q = Collections.unmodifiableList(new ArrayList(list3 == null ? Collections.EMPTY_LIST : list3));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            linkedHashMap.put(g7Var.f4105a, g7Var);
        }
        this.f4738r = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void a(StringBuilder sb, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            r(sb, (String) list.get(i3));
        }
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() <= 256 ? str : str.substring(0, 256);
    }

    public static String c(String str, int i3) {
        if (str == null) {
            str = "";
        }
        return str.length() <= i3 ? str : str.substring(0, i3);
    }

    public static List d(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    str = "";
                }
                if (!str.isEmpty()) {
                    linkedHashMap.put(str, Boolean.TRUE);
                }
            }
        }
        return Collections.unmodifiableList(new ArrayList(linkedHashMap.keySet()));
    }

    public static boolean e(g7 g7Var) {
        if (g7Var == null) {
            return false;
        }
        String str = g7Var.f4115k;
        if (g7Var.f4117m == 0 && g7Var.f4112h.isEmpty() && g7Var.f4113i.isEmpty() && g7Var.f4114j.isEmpty() && (g7Var.f4116l & (-9)) == 0) {
            return (str.isEmpty() || "region".equals(str)) ? false : true;
        }
        return true;
    }

    public static int f(String str) {
        if ("ime_candidate".equals(str)) {
            return 5;
        }
        if ("ime".equals(str)) {
            return 4;
        }
        if ("accessibility_overlay".equals(str)) {
            return 3;
        }
        if ("system".equals(str)) {
            return 2;
        }
        return "application".equals(str) ? 1 : 0;
    }

    public static void g(StringBuilder sb, List list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            f7 f7Var = (f7) list.get(i3);
            f7Var.getClass();
            sb.append("{\"id\":");
            r(sb, f7Var.f4013a);
            sb.append(",\"roots\":[");
            a(sb, f7Var.f4014b);
            sb.append("]}");
        }
    }

    public static void h(StringBuilder sb, List list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            k7 k7Var = (k7) list.get(i3);
            List list2 = k7Var.f4405g;
            sb.append("{\"id\":");
            r(sb, k7Var.f4399a);
            sb.append(",\"kind\":");
            r(sb, k7Var.f4400b);
            sb.append(",\"layer\":");
            sb.append(k7Var.f4401c);
            sb.append(",\"order\":");
            sb.append(k7Var.f4402d);
            sb.append(",\"roots\":[");
            a(sb, k7Var.f4403e);
            sb.append("],\"bounds\":");
            k7Var.f4404f.a(sb);
            sb.append(",\"blockingRects\":[");
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (i4 > 0) {
                    sb.append(',');
                }
                ((l7) list2.get(i4)).a(sb);
            }
            sb.append("]}");
        }
    }

    public static List i(List list, List list2) {
        String str;
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            if (g7Var != null && (str = g7Var.f4105a) != null) {
                linkedHashSet.add(str);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            f7 f7Var = (f7) it2.next();
            if (f7Var != null) {
                List list3 = f7Var.f4014b;
                if (!list3.isEmpty()) {
                    Iterator it3 = list3.iterator();
                    do {
                        if (!it3.hasNext()) {
                            arrayList.add(f7Var);
                            break;
                        }
                    } while (linkedHashSet.contains((String) it3.next()));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static e2.n1 k(o7 o7Var, int i3, n7 n7Var) {
        String str = o7Var.f4730i;
        n8 n8Var = o7Var.f4732k;
        j7 j7Var = o7Var.f4733l;
        String str2 = j7Var.f4342b;
        boolean z2 = j7Var.f4343c;
        List list = Collections.EMPTY_LIST;
        o7 o7VarY = y(o7Var, list, new j7("ambiguous", str2, 0, z2, list, list), list, list, str, n8Var);
        if (n7Var.e(o7VarY) > i3) {
            o7VarY = y(o7Var, list, new j7("ambiguous", "wire_limit", 0, j7Var.f4343c, list, list), list, list, "", null);
        }
        return new e2.n1(o7VarY);
    }

    public static boolean m(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static long n(int i3, long j3) {
        return (j3 ^ ((long) i3)) * 1099511628211L;
    }

    public static long o(String str, long j3) {
        if (str == null) {
            return n(0, j3);
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            j3 = (j3 ^ ((long) str.charAt(i3))) * 1099511628211L;
        }
        return j3;
    }

    public static LinkedHashSet p(List list) {
        String str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            if (g7Var != null && (str = g7Var.f4105a) != null) {
                linkedHashSet.add(str);
            }
        }
        return linkedHashSet;
    }

    public static List q(List list, List list2) {
        String str;
        String str2;
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            if (g7Var != null && (str2 = g7Var.f4105a) != null && !str2.isEmpty()) {
                linkedHashMap.put(str2, g7Var);
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            g7 g7Var2 = (g7) it2.next();
            if (g7Var2 != null) {
                String str3 = g7Var2.f4105a;
                String str4 = g7Var2.f4106b;
                if (str4 != null && !str4.equals(str3) && linkedHashMap.containsKey(str4)) {
                    ArrayList arrayList = (ArrayList) linkedHashMap2.get(str4);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap2.put(str4, arrayList);
                    }
                    arrayList.add(str3);
                }
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            k7 k7Var = (k7) it3.next();
            if (k7Var != null) {
                for (String str5 : k7Var.f4403e) {
                    if (linkedHashMap.containsKey(str5) && !linkedHashMap3.containsKey(str5)) {
                        linkedHashMap3.put(str5, k7Var.f4399a);
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        Iterator it4 = list2.iterator();
        while (it4.hasNext()) {
            k7 k7Var2 = (k7) it4.next();
            if (k7Var2 != null) {
                ArrayList arrayList2 = new ArrayList(k7Var2.f4403e);
                while (!arrayList2.isEmpty()) {
                    String str6 = (String) arrayList2.remove(arrayList2.size() - 1);
                    if (linkedHashMap.containsKey(str6) && !linkedHashMap4.containsKey(str6) && ((str = (String) linkedHashMap3.get(str6)) == null || k7Var2.f4399a.equals(str))) {
                        linkedHashMap4.put(str6, Boolean.TRUE);
                        List list3 = (List) linkedHashMap2.get(str6);
                        if (list3 != null) {
                            arrayList2.addAll(list3);
                        }
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            g7 g7Var3 = (g7) it5.next();
            if (g7Var3 != null && linkedHashMap4.containsKey(g7Var3.f4105a)) {
                arrayList3.add(g7Var3);
            }
        }
        return Collections.unmodifiableList(arrayList3);
    }

    public static void r(StringBuilder sb, String str) {
        sb.append('\"');
        if (str == null) {
            str = "";
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt < ' ') {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c A[PHI: r12
  0x005c: PHI (r12v1 java.lang.String) = 
  (r12v0 java.lang.String)
  (r12v0 java.lang.String)
  (r12v0 java.lang.String)
  (r12v0 java.lang.String)
  (r12v9 java.lang.String)
 binds: [B:11:0x0034, B:13:0x0038, B:15:0x003e, B:17:0x004c, B:21:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    public static e2.n1 s(o7 o7Var, int i3, n7 n7Var) {
        List list;
        int i4;
        ArrayList arrayListE;
        o7 o7VarK;
        if (o7Var != null) {
            List list2 = o7Var.f4737q;
            j7 j7Var = o7Var.f4733l;
            if (i3 > 0) {
                i7 i7Var = new i7(o7Var);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (n7Var.e(i7Var.k(linkedHashSet)) > i3) {
                    return k(o7Var, i3, n7Var);
                }
                o7 o7Var2 = i7Var.f4255a;
                j7 j7Var2 = o7Var2.f4733l;
                List<k7> list3 = o7Var2.f4735o;
                LinkedHashMap linkedHashMap = i7Var.f4260f;
                String str = "";
                if (j7Var2 != null && j7Var2.f4343c && j7Var2.a()) {
                    List list4 = (List) j7Var2.f4345e;
                    List list5 = (List) j7Var2.f4345e;
                    if (!list4.isEmpty()) {
                        if (!list3.isEmpty()) {
                            boolean z2 = false;
                            for (k7 k7Var : list3) {
                                z2 |= k7Var != null && "application".equals(k7Var.f4400b);
                            }
                            Iterator it = list5.iterator();
                            String str2 = "";
                            while (true) {
                                if (!it.hasNext()) {
                                    list = list2;
                                    if (z2) {
                                        if (str2.isEmpty()) {
                                            i4 = 0;
                                            str = (String) list5.get(0);
                                            break;
                                        }
                                        str = str2;
                                    }
                                } else {
                                    String str3 = (String) it.next();
                                    Integer num = (Integer) linkedHashMap.get(str3);
                                    if (num == null && str2.isEmpty()) {
                                        str2 = str3;
                                    }
                                    list = list2;
                                    if (num == null || !"application".equals(((k7) list3.get(num.intValue())).f4400b)) {
                                        list2 = list;
                                    } else {
                                        str = str3;
                                    }
                                }
                                i4 = 0;
                                break;
                            }
                        }
                        str = (String) list5.get(0);
                        list = list2;
                        i4 = 0;
                    } else {
                        list = list2;
                        i4 = 0;
                    }
                } else {
                    list = list2;
                    i4 = 0;
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                if (j7Var != null && j7Var.f4343c && !"ambiguous".equals(j7Var.f4341a)) {
                    linkedHashSet2.addAll((List) j7Var.f4345e);
                    linkedHashSet2.addAll((List) j7Var.f4346f);
                }
                boolean zIsEmpty = str.isEmpty();
                if (!linkedHashSet2.isEmpty() && !w(i7Var, linkedHashSet, linkedHashSet2, i3, n7Var)) {
                    return k(o7Var, i3, n7Var);
                }
                if (i7Var.f()) {
                    for (int i5 = i4; i5 < list.size(); i5++) {
                        x(i7Var, linkedHashSet, i5, i3, n7Var);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i6 = i4; i6 < list3.size(); i6++) {
                    if (list3.get(i6) != null) {
                        arrayList.add(Integer.valueOf(i6));
                    }
                }
                Collections.sort(arrayList, new h7(i7Var, 0));
                int size = arrayList.size();
                int i7 = i4;
                while (i7 < size) {
                    Object obj = arrayList.get(i7);
                    i7++;
                    Integer num2 = (Integer) obj;
                    k7 k7Var2 = (k7) o7Var.f4735o.get(num2.intValue());
                    if ((!i7Var.f() || !"application".equals(k7Var2.f4400b)) && (i7.c(i7Var, num2.intValue()) || i7Var.g(num2.intValue()))) {
                        w(i7Var, linkedHashSet, k7Var2.f4403e, i3, n7Var);
                    }
                }
                if (!i7Var.f()) {
                    for (int i8 = 0; i8 < list.size(); i8++) {
                        x(i7Var, linkedHashSet, i8, i3, n7Var);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                LinkedHashMap linkedHashMap2 = i7Var.f4256b;
                for (g7 g7Var : linkedHashMap2.values()) {
                    if (e(g7Var)) {
                        arrayList2.add(g7Var.f4105a);
                    }
                }
                Collections.sort(arrayList2, new h7(i7Var, 1));
                int size2 = arrayList2.size();
                int i9 = 0;
                while (i9 < size2) {
                    Object obj2 = arrayList2.get(i9);
                    i9++;
                    String str4 = (String) obj2;
                    if (str4 != null && !str4.isEmpty()) {
                        Integer num3 = (Integer) i7Var.f4262h.get(str4);
                        if (num3 != null) {
                            x(i7Var, linkedHashSet, num3.intValue(), i3, n7Var);
                        } else if ((!linkedHashSet.contains(str4) || ((g7) i7Var.k(linkedHashSet).f4738r.get(str4)) == null) && (arrayListE = i7Var.e(str4)) != null && !arrayListE.isEmpty()) {
                            LinkedHashSet linkedHashSet3 = new LinkedHashSet(linkedHashSet);
                            linkedHashSet3.addAll(arrayListE);
                            Integer num4 = (Integer) linkedHashMap.get(str4);
                            if (num4 == null || i7Var.f()) {
                                o7VarK = i7Var.k(linkedHashSet3);
                                if (((g7) o7VarK.f4738r.get(str4)) == null && n7Var.e(o7VarK) <= i3) {
                                    linkedHashSet.clear();
                                    linkedHashSet.addAll(linkedHashSet3);
                                }
                            } else {
                                Iterator it2 = ((k7) list3.get(num4.intValue())).f4403e.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        ArrayList arrayListE2 = i7Var.e((String) it2.next());
                                        if (arrayListE2 != null && !arrayListE2.isEmpty()) {
                                            linkedHashSet3.addAll(arrayListE2);
                                        }
                                    } else {
                                        o7VarK = i7Var.k(linkedHashSet3);
                                        if (((g7) o7VarK.f4738r.get(str4)) == null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                o7 o7VarK2 = i7Var.k(linkedHashSet);
                if (zIsEmpty) {
                    return !list.isEmpty() ? new e2.n1(o7VarK2) : new e2.n1(o7VarK2);
                }
                List list6 = o7VarK2.n;
                if (!str.isEmpty()) {
                    Iterator it3 = list6.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            g7 g7Var2 = (g7) it3.next();
                            if (g7Var2 != null && str.equals(g7Var2.f4105a)) {
                                break;
                            }
                        }
                    }
                    if ((!list.isEmpty() || !o7VarK2.f4737q.isEmpty()) && n7Var.e(o7VarK2) <= i3) {
                    }
                }
                return k(o7Var, i3, n7Var);
            }
        }
        o2.i("source, measurer and positive budget required");
        return null;
    }

    public static j7 t(j7 j7Var, LinkedHashSet linkedHashSet, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        List<String> list = (List) j7Var.f4345e;
        String str = j7Var.f4341a;
        for (String str2 : list) {
            if (linkedHashSet.contains(str2)) {
                arrayList.add(str2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : (List) j7Var.f4346f) {
            if (linkedHashSet.contains(str3)) {
                arrayList2.add(str3);
            }
        }
        boolean z4 = "ambiguous".equals(str) || (z2 && arrayList.isEmpty() && arrayList2.isEmpty() && !z3);
        if (z4) {
            arrayList.clear();
            arrayList2.clear();
        }
        if (z4) {
            str = "ambiguous";
        } else if (z2) {
            str = "transition";
        }
        return new j7(str, j7Var.f4342b, z2 ? 0 : j7Var.f4344d, j7Var.f4343c, arrayList, arrayList2);
    }

    public static String u(int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7) {
        long jN = n(i3, -3750763034362895579L);
        boolean zIsEmpty = (str2 == null ? "" : str2).isEmpty();
        if (zIsEmpty) {
            str2 = str;
        }
        long jO = o(str2, jN);
        if (!zIsEmpty) {
            jO = o(str, jO);
        }
        long jO2 = o(str3, jO);
        if (zIsEmpty) {
            int i8 = i7 / 4;
            jO2 = n(i8, n(i6 / 4, n(i5 / 4, n(i4 / 4, jO2))));
        }
        return Long.toUnsignedString(jO2, 36);
    }

    public static List v(List list, List list2) {
        String str;
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            if (g7Var != null && (str = g7Var.f4105a) != null) {
                linkedHashMap.put(str, Boolean.TRUE);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            k7 k7Var = (k7) it2.next();
            if (k7Var != null) {
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : k7Var.f4403e) {
                    if (linkedHashMap.containsKey(str2)) {
                        arrayList2.add(str2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    arrayList.add(new k7(k7Var.f4399a, k7Var.f4400b, k7Var.f4401c, k7Var.f4402d, arrayList2, k7Var.f4404f, k7Var.f4405g));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean w(i7 i7Var, LinkedHashSet linkedHashSet, Collection collection, int i3, n7 n7Var) {
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null || str.isEmpty()) {
                    return false;
                }
                linkedHashSet2.add(str);
            }
        }
        if (linkedHashSet2.isEmpty()) {
            return false;
        }
        LinkedHashSet linkedHashSet3 = new LinkedHashSet(linkedHashSet);
        for (String str2 : linkedHashSet2) {
            LinkedHashMap linkedHashMap = i7Var.f4262h;
            ArrayList arrayList = i7Var.f4263i;
            Integer num = (Integer) linkedHashMap.get(str2);
            if (num == null) {
                ArrayList arrayListE = i7Var.e(str2);
                if (arrayListE == null || arrayListE.isEmpty()) {
                    return false;
                }
                linkedHashSet3.addAll(arrayListE);
            } else {
                if (!i7Var.f4264j || num.intValue() < 0 || num.intValue() >= arrayList.size()) {
                    return false;
                }
                linkedHashSet3.addAll((Collection) arrayList.get(num.intValue()));
            }
        }
        o7 o7VarK = i7Var.k(linkedHashSet3);
        for (String str3 : linkedHashSet2) {
            if ((str3 == null ? null : (g7) o7VarK.f4738r.get(str3)) == null) {
                return false;
            }
        }
        if (n7Var.e(o7VarK) > i3) {
            return false;
        }
        linkedHashSet.clear();
        linkedHashSet.addAll(linkedHashSet3);
        return true;
    }

    public static boolean x(i7 i7Var, LinkedHashSet linkedHashSet, int i3, int i4, n7 n7Var) {
        boolean z2 = i7Var.f4264j;
        ArrayList arrayList = i7Var.f4263i;
        if (!z2 || i3 < 0 || i3 >= arrayList.size()) {
            return false;
        }
        Set set = (Set) arrayList.get(i3);
        if (set.isEmpty()) {
            return false;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(linkedHashSet);
        linkedHashSet2.addAll(set);
        o7 o7VarK = i7Var.k(linkedHashSet2);
        f7 f7Var = (f7) i7Var.f4255a.f4737q.get(i3);
        for (f7 f7Var2 : o7VarK.f4737q) {
            if (f7Var2 == null) {
                f7Var.getClass();
            } else if (f7Var.f4013a.equals(f7Var2.f4013a) && f7Var.f4014b.equals(f7Var2.f4014b)) {
                if (n7Var.e(o7VarK) > i4) {
                    return false;
                }
                linkedHashSet.clear();
                linkedHashSet.addAll(linkedHashSet2);
                return true;
            }
        }
        return false;
    }

    public static o7 y(o7 o7Var, List list, j7 j7Var, List list2, List list3, String str, n8 n8Var) {
        m7 m7Var = o7Var.f4734m;
        return new o7(o7Var.f4722a, o7Var.f4723b, o7Var.f4724c, o7Var.f4727f, o7Var.f4728g, o7Var.f4729h, str, true, n8Var, list, j7Var, o7Var.f4725d, o7Var.f4726e, m7Var == null ? new m7("wire_limit", o7Var.n.size()) : new m7(m7Var.f4534a, m7Var.f4535b, m7Var.f4536c, m7Var.f4537d, m7Var.f4538e, m7Var.f4539f, m7Var.f4540g, "wire_limit"), list2, o7Var.f4736p, list3);
    }

    public final o7 j(List list, j7 j7Var, String str) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            g7 g7Var = (g7) it.next();
            if (g7Var.f4117m != 0) {
                g7Var = new g7(g7Var.f4105a, g7Var.f4106b, g7Var.f4107c, g7Var.f4108d, g7Var.f4109e, g7Var.f4110f, g7Var.f4111g, g7Var.f4112h, g7Var.f4113i, g7Var.f4114j, g7Var.f4115k, g7Var.f4116l, 0, g7Var.n);
            }
            arrayList.add(g7Var);
        }
        j7 j7Var2 = j7Var == null ? this.f4733l : j7Var;
        j7 j7Var3 = new j7("ambiguous".equals(j7Var2.f4341a) ? "ambiguous" : "transition", j7Var2.f4342b, j7Var2.f4344d, j7Var2.f4343c, (List) j7Var2.f4345e, (List) j7Var2.f4346f);
        m7 m7Var = this.f4734m;
        m7 m7Var2 = m7Var == null ? new m7(str, this.n.size()) : new m7(m7Var.f4534a, m7Var.f4535b, m7Var.f4536c, m7Var.f4537d, m7Var.f4538e, m7Var.f4539f, m7Var.f4540g, str);
        List list2 = this.f4735o;
        List listV = v(list2, arrayList);
        List listQ = arrayList;
        if (!list2.isEmpty()) {
            listQ = q(arrayList, listV);
        }
        List listI = i(this.f4737q, listQ);
        return new o7(this.f4722a, this.f4723b, this.f4724c, this.f4727f, this.f4728g, this.f4729h, this.f4730i, true, this.f4732k, listQ, t(j7Var3, p(listQ), false, !listI.isEmpty()), this.f4725d, this.f4726e, m7Var2, listV, this.f4736p, listI);
    }

    public final byte[] l() {
        List list = this.n;
        StringBuilder sb = new StringBuilder(Math.max(1024, list.size() * 96));
        sb.append("{\"v\":2,\"kind\":\"full\",\"generation\":");
        sb.append(this.f4722a);
        sb.append(",\"revision\":");
        sb.append(this.f4723b);
        sb.append(",\"baseRevision\":0,\"ts\":");
        sb.append(this.f4724c);
        long j3 = this.f4725d;
        if (j3 > 0) {
            sb.append(",\"streamEpoch\":");
            sb.append(j3);
        }
        int i3 = this.f4726e;
        if (i3 >= 0) {
            sb.append(",\"displayId\":");
            sb.append(i3);
        }
        sb.append(",\"display\":{\"w\":");
        int i4 = this.f4727f;
        sb.append(i4);
        sb.append(",\"h\":");
        int i5 = this.f4728g;
        sb.append(i5);
        sb.append(",\"rotation\":");
        sb.append(this.f4729h);
        sb.append(",\"contentRect\":[0,0,");
        sb.append(i4);
        sb.append(',');
        sb.append(i5);
        sb.append("]},\"pkg\":");
        r(sb, this.f4730i);
        sb.append(",\"truncated\":");
        sb.append(this.f4731j);
        sb.append(",\"scene\":");
        j7 j7Var = this.f4733l;
        j7Var.getClass();
        sb.append("{\"state\":");
        r(sb, j7Var.f4341a);
        sb.append(",\"id\":");
        r(sb, j7Var.f4342b);
        sb.append(",\"confidence\":");
        sb.append(j7Var.f4344d);
        if (j7Var.f4343c) {
            sb.append(",\"authority\":\"device\",\"contentSurfaceIds\":[");
            a(sb, (List) j7Var.f4345e);
            sb.append("],\"persistentChromeIds\":[");
            a(sb, (List) j7Var.f4346f);
            sb.append(']');
        }
        sb.append('}');
        boolean zEquals = "layers-v1".equals(this.f4736p);
        List list2 = this.f4735o;
        if (zEquals) {
            sb.append(",\"surfacePolicy\":");
            r(sb, "layers-v1");
            sb.append(",\"applicationLayers\":[");
            g(sb, this.f4737q);
            sb.append(']');
            if (!list2.isEmpty()) {
                sb.append(",\"surfaces\":[");
                h(sb, list2);
                sb.append(']');
            }
        } else if (!list2.isEmpty()) {
            sb.append(",\"surfacePolicy\":");
            r(sb, "device-v1");
            sb.append(",\"surfaces\":[");
            h(sb, list2);
            sb.append(']');
        }
        n8 n8Var = this.f4732k;
        if (n8Var != null) {
            n8Var.a(sb);
        } else {
            sb.append(",\"pattern\":null");
        }
        m7 m7Var = this.f4734m;
        if (m7Var != null) {
            sb.append(",\"trace\":");
            sb.append("{\"id\":");
            r(sb, m7Var.f4534a);
            sb.append(",\"durationUs\":{\"collect\":");
            sb.append(m7Var.f4535b);
            sb.append(",\"resolve\":");
            sb.append(m7Var.f4536c);
            sb.append("},\"visitedCount\":");
            sb.append(m7Var.f4540g);
            String str = m7Var.f4541h;
            if (!str.isEmpty()) {
                sb.append(",\"truncatedReason\":");
                r(sb, str);
            }
            sb.append('}');
        }
        sb.append(",\"nodes\":[");
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (i6 > 0) {
                sb.append(',');
            }
            g7 g7Var = (g7) list.get(i6);
            sb.append("{\"id\":");
            String str2 = g7Var.f4105a;
            String str3 = g7Var.f4114j;
            String str4 = g7Var.f4113i;
            String str5 = g7Var.f4112h;
            String str6 = g7Var.f4106b;
            r(sb, str2);
            if (str6 != null && !str6.isEmpty()) {
                sb.append(",\"p\":");
                r(sb, str6);
            }
            sb.append(",\"b\":[");
            sb.append(g7Var.f4107c);
            sb.append(',');
            sb.append(g7Var.f4108d);
            sb.append(',');
            sb.append(g7Var.f4109e);
            sb.append(',');
            sb.append(g7Var.f4110f);
            sb.append(']');
            sb.append(",\"c\":");
            r(sb, g7Var.f4111g);
            if (!str5.isEmpty()) {
                sb.append(",\"t\":");
                r(sb, str5);
            }
            if (!str4.isEmpty()) {
                sb.append(",\"d\":");
                r(sb, str4);
            }
            if (!str3.isEmpty()) {
                sb.append(",\"e\":");
                r(sb, str3);
            }
            sb.append(",\"role\":");
            r(sb, g7Var.f4115k);
            sb.append(",\"f\":");
            sb.append(g7Var.f4116l);
            sb.append(",\"a\":");
            sb.append(g7Var.f4117m);
            sb.append(",\"z\":");
            sb.append(g7Var.n);
            sb.append('}');
        }
        sb.append(']');
        sb.append('}');
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }

    public o7(long j3, long j4, long j5, int i3, int i4, int i5, String str, boolean z2, n8 n8Var, List list, j7 j7Var, long j6, int i6, m7 m7Var, List list2, List list3) {
        this(j3, j4, j5, i3, i4, i5, str, z2, n8Var, list, j7Var, j6, i6, m7Var, list2, "layers-v1", list3);
    }
}
