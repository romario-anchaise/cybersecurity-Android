// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o7 f4255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4256b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f4257c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f4258d = new LinkedHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f4259e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f4260f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4261g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f4262h = new LinkedHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f4263i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4266l;

    /* JADX WARN: Code duplicated, block: B:97:0x01fd  */
    public i7(o7 o7Var) {
        List list;
        String str;
        this.f4264j = true;
        this.f4255a = o7Var;
        List<g7> list2 = o7Var.n;
        List list3 = o7Var.f4735o;
        int iMax = Integer.MIN_VALUE;
        int i3 = 0;
        int iMax2 = Integer.MIN_VALUE;
        for (g7 g7Var : list2) {
            if (g7Var == null || (str = g7Var.f4105a) == null || str.isEmpty() || this.f4256b.containsKey(str)) {
                i3++;
            } else {
                this.f4256b.put(str, g7Var);
                this.f4257c.put(str, Integer.valueOf(i3));
                iMax2 = Math.max(iMax2, g7Var.n);
                i3++;
            }
        }
        for (g7 g7Var2 : this.f4256b.values()) {
            String str2 = g7Var2.f4106b;
            String str3 = g7Var2.f4105a;
            String str4 = g7Var2.f4106b;
            if (str2 != null && !str2.isEmpty() && !str4.equals(str3) && this.f4256b.containsKey(str4)) {
                ArrayList arrayList = (ArrayList) this.f4258d.get(str4);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f4258d.put(str4, arrayList);
                }
                arrayList.add(str3);
            }
        }
        for (int i4 = 0; i4 < list3.size(); i4++) {
            k7 k7Var = (k7) list3.get(i4);
            if (k7Var != null) {
                iMax = Math.max(iMax, k7Var.f4401c);
                for (String str5 : k7Var.f4403e) {
                    if (this.f4256b.containsKey(str5) && !this.f4259e.containsKey(str5)) {
                        this.f4259e.put(str5, Integer.valueOf(i4));
                    }
                }
            }
        }
        this.f4265k = iMax;
        this.f4266l = iMax2;
        LinkedHashMap linkedHashMap = this.f4260f;
        LinkedHashMap linkedHashMap2 = this.f4259e;
        o7 o7Var2 = this.f4255a;
        for (int i5 = 0; i5 < o7Var2.f4735o.size(); i5++) {
            k7 k7Var2 = (k7) o7Var2.f4735o.get(i5);
            if (k7Var2 != null) {
                for (String str6 : k7Var2.f4403e) {
                    Integer num = (Integer) linkedHashMap2.get(str6);
                    if (num != null && num.intValue() == i5) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str6);
                        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                            String str7 = (String) arrayList2.get(i6);
                            Integer num2 = (Integer) linkedHashMap2.get(str7);
                            if ((num2 == null || num2.intValue() == i5) && ((Integer) linkedHashMap.get(str7)) == null) {
                                linkedHashMap.put(str7, Integer.valueOf(i5));
                                List list4 = (List) this.f4258d.get(str7);
                                if (list4 != null) {
                                    arrayList2.addAll(list4);
                                }
                            }
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap3 = this.f4262h;
        ArrayList arrayList3 = this.f4263i;
        LinkedHashMap linkedHashMap4 = this.f4261g;
        o7 o7Var3 = this.f4255a;
        int i7 = 0;
        while (true) {
            List list5 = o7Var3.f4737q;
            list = o7Var3.f4737q;
            if (i7 >= list5.size()) {
                break;
            }
            arrayList3.add(new LinkedHashSet());
            f7 f7Var = (f7) list.get(i7);
            if (f7Var != null) {
                List<String> list6 = f7Var.f4014b;
                if (f7Var.f4013a.isEmpty() || list6.isEmpty()) {
                    this.f4264j = false;
                } else {
                    for (String str8 : list6) {
                        if (!this.f4256b.containsKey(str8) || linkedHashMap4.containsKey(str8)) {
                            this.f4264j = false;
                        } else {
                            linkedHashMap4.put(str8, Integer.valueOf(i7));
                        }
                    }
                }
            } else {
                this.f4264j = false;
            }
            i7++;
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            f7 f7Var2 = (f7) list.get(i8);
            if (f7Var2 != null) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) arrayList3.get(i8);
                for (String str9 : f7Var2.f4014b) {
                    Integer num3 = (Integer) linkedHashMap4.get(str9);
                    if (num3 != null && num3.intValue() == i8) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(str9);
                        for (int i9 = 0; i9 < arrayList4.size(); i9++) {
                            String str10 = (String) arrayList4.get(i9);
                            Integer num4 = (Integer) linkedHashMap4.get(str10);
                            if (num4 == null || num4.intValue() == i8) {
                                Integer num5 = (Integer) linkedHashMap3.get(str10);
                                if (num5 != null && num5.intValue() != i8) {
                                    this.f4264j = false;
                                } else if (linkedHashSet.add(str10)) {
                                    linkedHashMap3.put(str10, Integer.valueOf(i8));
                                    List list7 = (List) this.f4258d.get(str10);
                                    if (list7 != null) {
                                        arrayList4.addAll(list7);
                                    }
                                }
                            }
                        }
                    }
                }
                if (linkedHashSet.isEmpty()) {
                    this.f4264j = false;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    public static int a(i7 i7Var, String str) {
        boolean z2;
        g7 g7Var = (g7) i7Var.f4256b.get(str);
        Integer num = (Integer) i7Var.f4260f.get(str);
        k7 k7Var = num == null ? null : (k7) i7Var.f4255a.f4735o.get(num.intValue());
        if (k7Var != null) {
            String str2 = k7Var.f4400b;
            if ("ime".equals(str2) || "ime_candidate".equals(str2) || k7Var.f4401c == i7Var.f4265k) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else if (g7Var == null || g7Var.n != i7Var.f4266l) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3 = (g7Var == null || (g7Var.f4117m == 0 && (g7Var.f4116l & 512) == 0)) ? false : true;
        if (z2 || z3) {
            return 0;
        }
        List list = (List) i7Var.f4258d.get(str);
        return (list == null || list.isEmpty()) ? 1 : 2;
    }

    public static int b(i7 i7Var, String str) {
        Integer num = (Integer) i7Var.f4260f.get(str);
        if (num != null) {
            return ((k7) i7Var.f4255a.f4735o.get(num.intValue())).f4401c;
        }
        g7 g7Var = (g7) i7Var.f4256b.get(str);
        if (g7Var == null) {
            return Integer.MIN_VALUE;
        }
        return g7Var.n;
    }

    public static boolean c(i7 i7Var, int i3) {
        LinkedHashMap linkedHashMap = i7Var.f4260f;
        o7 o7Var = i7Var.f4255a;
        Iterator it = ((List) o7Var.f4733l.f4345e).iterator();
        while (it.hasNext()) {
            Integer num = (Integer) linkedHashMap.get((String) it.next());
            if (num != null && num.intValue() == i3) {
                return true;
            }
        }
        Iterator it2 = ((List) o7Var.f4733l.f4346f).iterator();
        while (it2.hasNext()) {
            Integer num2 = (Integer) linkedHashMap.get((String) it2.next());
            if (num2 != null && num2.intValue() == i3) {
                return true;
            }
        }
        return false;
    }

    public final void d(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, LinkedHashSet linkedHashSet3, LinkedHashSet linkedHashSet4, ArrayList arrayList) {
        g7 g7Var;
        if (linkedHashSet4.contains(str) || !linkedHashSet.contains(str) || (g7Var = (g7) this.f4256b.get(str)) == null || !linkedHashSet3.add(str)) {
            return;
        }
        String str2 = g7Var.f4106b;
        boolean z2 = linkedHashSet2.contains(str) || str2 == null || str2.isEmpty() || str2.equals(str) || !linkedHashSet.contains(str2);
        if (!z2) {
            d(str2, linkedHashSet, linkedHashSet2, linkedHashSet3, linkedHashSet4, arrayList);
        }
        linkedHashSet3.remove(str);
        if (linkedHashSet4.add(str)) {
            if (z2) {
                str2 = null;
            }
            String str3 = str2;
            String str4 = g7Var.f4106b;
            int i3 = g7Var.f4117m;
            if (!o7.m(str4, str3) || i3 != 0) {
                g7Var = new g7(g7Var.f4105a, str3, g7Var.f4107c, g7Var.f4108d, g7Var.f4109e, g7Var.f4110f, g7Var.f4111g, g7Var.f4112h, g7Var.f4113i, g7Var.f4114j, g7Var.f4115k, g7Var.f4116l, 0, g7Var.n);
            }
            arrayList.add(g7Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    public final ArrayList e(String str) {
        LinkedHashMap linkedHashMap;
        String str2;
        Integer num;
        LinkedHashMap linkedHashMap2 = this.f4256b;
        g7 g7Var = (g7) linkedHashMap2.get(str);
        if (g7Var == null) {
            return null;
        }
        LinkedHashMap linkedHashMap3 = this.f4260f;
        Integer num2 = (Integer) linkedHashMap3.get(str);
        if (!this.f4255a.f4735o.isEmpty() && num2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String str3 = g7Var.f4105a;
            if (!linkedHashSet.add(str3)) {
                return null;
            }
            arrayList.add(str3);
            linkedHashMap = this.f4259e;
            if (num2 != null) {
                Integer num3 = (Integer) linkedHashMap.get(str3);
                if (num3 != null && num3.equals(num2)) {
                    break;
                }
                if (!num2.equals((Integer) linkedHashMap3.get(str3))) {
                    return null;
                }
                str2 = g7Var.f4106b;
                if (str2 != null) {
                }
                if (num2 != null) {
                    break;
                }
                return null;
            }
            str2 = g7Var.f4106b;
            if (str2 != null || str2.isEmpty() || str2.equals(str3)) {
                if (num2 != null) {
                    break;
                }
                return null;
            }
            g7Var = (g7) linkedHashMap2.get(str2);
            if (g7Var == null) {
                if (num2 == null) {
                    break;
                }
                return null;
            }
        }
        if (num2 != null && ((num = (Integer) linkedHashMap.get((String) arrayList.get(arrayList.size() - 1))) == null || !num.equals(num2))) {
            return null;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final boolean f() {
        return "layers-v1".equals(this.f4255a.f4736p);
    }

    public final boolean g(int i3) {
        k7 k7Var = (k7) this.f4255a.f4735o.get(i3);
        if (k7Var == null) {
            return false;
        }
        String str = k7Var.f4400b;
        return "ime".equals(str) || "ime_candidate".equals(str) || "accessibility_overlay".equals(str) || k7Var.f4401c == this.f4265k;
    }

    public final List h(LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2) {
        i7 i7Var;
        LinkedHashSet linkedHashSet3;
        LinkedHashSet linkedHashSet4;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
        for (String str : this.f4256b.keySet()) {
            if (linkedHashSet.contains(str)) {
                i7Var = this;
                linkedHashSet3 = linkedHashSet;
                linkedHashSet4 = linkedHashSet2;
                i7Var.d(str, linkedHashSet3, linkedHashSet4, linkedHashSet6, linkedHashSet5, arrayList);
            } else {
                i7Var = this;
                linkedHashSet3 = linkedHashSet;
                linkedHashSet4 = linkedHashSet2;
            }
            this = i7Var;
            linkedHashSet = linkedHashSet3;
            linkedHashSet2 = linkedHashSet4;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final boolean i(int i3, LinkedHashSet linkedHashSet) {
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.f4260f.get((String) it.next());
            if (num != null && num.intValue() == i3) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(int i3, LinkedHashSet linkedHashSet) {
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Integer num = (Integer) this.f4260f.get(str);
            g7 g7Var = (g7) this.f4256b.get(str);
            if (num != null && num.intValue() == i3 && o7.e(g7Var)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0197  */
    public final o7 k(LinkedHashSet linkedHashSet) {
        LinkedHashMap linkedHashMap;
        boolean z2;
        o7 o7Var;
        o7 o7Var2 = this.f4255a;
        List list = o7Var2.f4735o;
        j7 j7Var = o7Var2.f4733l;
        List list2 = o7Var2.f4735o;
        boolean zIsEmpty = list.isEmpty();
        LinkedHashMap linkedHashMap2 = this.f4262h;
        boolean z3 = true;
        if (zIsEmpty) {
            boolean[] zArrL = l(linkedHashSet);
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Integer num = (Integer) linkedHashMap2.get(str);
                if (num == null || (num.intValue() >= 0 && num.intValue() < zArrL.length && zArrL[num.intValue()])) {
                    linkedHashSet2.add(str);
                }
            }
            List listM = m(zArrL);
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            Iterator it2 = listM.iterator();
            while (it2.hasNext()) {
                linkedHashSet3.addAll(((f7) it2.next()).f4014b);
            }
            List listH = h(linkedHashSet2, linkedHashSet3);
            return o7.y(o7Var2, listH, o7.t(j7Var, o7.p(listH), true, !listM.isEmpty()), Collections.EMPTY_LIST, listM, o7Var2.f4730i, o7Var2.f4732k);
        }
        boolean[] zArrL2 = l(linkedHashSet);
        int size = list2.size();
        boolean[] zArr = new boolean[size];
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        for (String str2 : (List) j7Var.f4345e) {
            if (linkedHashSet.contains(str2)) {
                linkedHashSet4.add(str2);
            }
        }
        for (String str3 : (List) j7Var.f4346f) {
            if (linkedHashSet.contains(str3)) {
                linkedHashSet4.add(str3);
            }
        }
        int i3 = 0;
        while (true) {
            int size2 = list2.size();
            linkedHashMap = this.f4260f;
            if (i3 >= size2) {
                break;
            }
            k7 k7Var = (k7) list2.get(i3);
            boolean z4 = z3;
            ArrayList arrayList2 = new ArrayList();
            boolean[] zArr2 = zArr;
            if (k7Var != null) {
                Iterator it3 = k7Var.f4403e.iterator();
                while (it3.hasNext()) {
                    Iterator it4 = it3;
                    String str4 = (String) it3.next();
                    Integer num2 = (Integer) linkedHashMap.get(str4);
                    if (!linkedHashSet.contains(str4) || num2 == null) {
                        o7Var = o7Var2;
                    } else {
                        o7Var = o7Var2;
                        if (num2.intValue() == i3) {
                            arrayList2.add(str4);
                        }
                    }
                    it3 = it4;
                    o7Var2 = o7Var;
                }
            }
            o7 o7Var3 = o7Var2;
            arrayList.add(arrayList2);
            if (f() && k7Var != null && "application".equals(k7Var.f4400b)) {
                int size3 = arrayList2.size();
                int i4 = 0;
                while (true) {
                    if (i4 < size3) {
                        Object obj = arrayList2.get(i4);
                        i4++;
                        Integer num3 = (Integer) this.f4261g.get((String) obj);
                        if (num3 == null || num3.intValue() < 0 || num3.intValue() >= zArrL2.length || !zArrL2[num3.intValue()]) {
                        }
                    }
                }
            } else if (!f()) {
                k7 k7Var2 = (k7) list2.get(i3);
                if (k7Var2 != null) {
                    List list3 = k7Var2.f4403e;
                    if (!list3.isEmpty()) {
                        Iterator it5 = list3.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                String str5 = (String) it5.next();
                                Integer num4 = (Integer) this.f4259e.get(str5);
                                if (num4 == null || num4.intValue() != i3 || !linkedHashSet.contains(str5)) {
                                }
                            } else {
                                z2 = (g(i3) || i(i3, linkedHashSet4) || j(i3, linkedHashSet)) ? z4 : false;
                            }
                        }
                    }
                }
            } else if (arrayList2.isEmpty() || (!g(i3) && !i(i3, linkedHashSet4) && !j(i3, linkedHashSet))) {
            }
            zArr2[i3] = z2;
            i3++;
            z3 = z4;
            zArr = zArr2;
            o7Var2 = o7Var3;
        }
        o7 o7Var4 = o7Var2;
        boolean z5 = z3;
        boolean[] zArr3 = zArr;
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        Iterator it6 = linkedHashSet.iterator();
        while (it6.hasNext()) {
            String str6 = (String) it6.next();
            Integer num5 = (Integer) linkedHashMap.get(str6);
            Integer num6 = (Integer) linkedHashMap2.get(str6);
            if (!f() || num5 == null || !"application".equals(((k7) list2.get(num5.intValue())).f4400b) || num6 != null) {
                if (num6 == null || (num6.intValue() >= 0 && num6.intValue() < zArrL2.length && zArrL2[num6.intValue()])) {
                    if (num5 != null && num5.intValue() >= 0 && num5.intValue() < size && zArr3[num5.intValue()]) {
                        linkedHashSet5.add(str6);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
        for (int i5 = 0; i5 < list2.size(); i5++) {
            if (zArr3[i5]) {
                ArrayList arrayList4 = new ArrayList();
                for (String str7 : (List) arrayList.get(i5)) {
                    if (linkedHashSet5.contains(str7)) {
                        arrayList4.add(str7);
                        linkedHashSet6.add(str7);
                    }
                }
                if (!arrayList4.isEmpty()) {
                    k7 k7Var3 = (k7) list2.get(i5);
                    arrayList3.add(new k7(k7Var3.f4399a, k7Var3.f4400b, k7Var3.f4401c, k7Var3.f4402d, arrayList4, k7Var3.f4404f, k7Var3.f4405g));
                }
            }
        }
        List listM2 = m(zArrL2);
        Iterator it7 = listM2.iterator();
        while (it7.hasNext()) {
            linkedHashSet6.addAll(((f7) it7.next()).f4014b);
        }
        List listH2 = h(linkedHashSet5, linkedHashSet6);
        return o7.y(o7Var4, listH2, o7.t(j7Var, o7.p(listH2), z5, !listM2.isEmpty()), arrayList3, listM2, o7Var4.f4730i, o7Var4.f4732k);
    }

    public final boolean[] l(LinkedHashSet linkedHashSet) {
        o7 o7Var = this.f4255a;
        int size = o7Var.f4737q.size();
        boolean[] zArr = new boolean[size];
        if (this.f4264j) {
            int i3 = 0;
            while (i3 < size) {
                LinkedHashSet linkedHashSet2 = (LinkedHashSet) this.f4263i.get(i3);
                f7 f7Var = (f7) o7Var.f4737q.get(i3);
                boolean zContains = !linkedHashSet2.isEmpty();
                Iterator it = linkedHashSet2.iterator();
                while (it.hasNext()) {
                    zContains &= linkedHashSet.contains((String) it.next());
                }
                for (String str : f7Var.f4014b) {
                    Integer num = (Integer) this.f4261g.get(str);
                    zContains &= num != null && num.intValue() == i3 && linkedHashSet.contains(str);
                }
                zArr[i3] = zContains;
                i3++;
            }
        }
        return zArr;
    }

    public final List m(boolean[] zArr) {
        if (zArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < zArr.length; i3++) {
            if (zArr[i3]) {
                arrayList.add((f7) this.f4255a.f4737q.get(i3));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
