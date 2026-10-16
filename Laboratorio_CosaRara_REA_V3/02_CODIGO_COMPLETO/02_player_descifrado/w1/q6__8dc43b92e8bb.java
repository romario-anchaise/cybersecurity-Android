// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f4908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f4909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f4910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f4914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4915m;

    public q6(String str, String str2, int i3, List list, List list2, List list3, List list4, List list5, int i4, int i5, String str3, List list6, String str4) {
        String str5;
        String str6 = "";
        this.f4903a = str == null ? "" : str;
        this.f4904b = str2 == null ? "" : str2;
        this.f4905c = Math.max(0, Math.min(100, i3));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g7 g7Var = (g7) it.next();
            if (g7Var != null && (str5 = g7Var.f4105a) != null && !str5.isEmpty()) {
                linkedHashSet.add(str5);
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            g7 g7Var2 = (g7) it2.next();
            if (g7Var2 != null) {
                String str7 = g7Var2.f4106b;
                if (str7 == null || (linkedHashSet.contains(str7) && !str7.equals(g7Var2.f4105a))) {
                    arrayList.add(g7Var2);
                } else {
                    arrayList.add(new g7(g7Var2.f4105a, null, g7Var2.f4107c, g7Var2.f4108d, g7Var2.f4109e, g7Var2.f4110f, g7Var2.f4111g, g7Var2.f4112h, g7Var2.f4113i, g7Var2.f4114j, g7Var2.f4115k, g7Var2.f4116l, g7Var2.f4117m, g7Var2.n));
                }
                str6 = str6;
            }
        }
        String str8 = str6;
        this.f4906d = Collections.unmodifiableList(arrayList);
        this.f4907e = n4.d(list2);
        this.f4908f = n4.d(list3);
        this.f4909g = Collections.unmodifiableList(new ArrayList(list4 == null ? Collections.EMPTY_LIST : list4));
        this.f4910h = Collections.unmodifiableList(new ArrayList(list5 == null ? Collections.EMPTY_LIST : list5));
        this.f4911i = Math.max(0, i4);
        this.f4912j = Math.max(0, i5);
        this.f4913k = str3 == null ? str8 : str3;
        this.f4914l = n4.d(list6);
        this.f4915m = str4 == null ? str8 : str4;
    }

    public final q6 a(int i3) {
        List list = this.f4906d;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(n4.E0((g7) it.next()));
        }
        return new q6("transition", this.f4904b, i3, arrayList, this.f4907e, this.f4908f, this.f4909g, this.f4910h, this.f4911i, this.f4912j, this.f4913k, this.f4914l, this.f4915m);
    }

    public final q6 b(int i3, int i4, String str) {
        return new q6(this.f4903a, this.f4904b, this.f4905c, this.f4906d, this.f4907e, this.f4908f, this.f4909g, this.f4910h, i3, i4, str, this.f4914l, this.f4915m);
    }

    public final q6 c(String str, int i3) {
        List list = this.f4906d;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(n4.E0((g7) it.next()));
        }
        List list2 = Collections.EMPTY_LIST;
        return new q6(str, this.f4904b, i3, arrayList, list2, list2, this.f4909g, this.f4910h, this.f4911i, this.f4912j, this.f4913k, this.f4914l, this.f4915m);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q6(String str, String str2, int i3, List list, List list2, List list3, List list4) {
        List list5 = Collections.EMPTY_LIST;
        this(str, str2, i3, list, list2, list3, list4, list5, 0, 0, "", list5, "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public q6(String str, int i3) {
        List list = Collections.EMPTY_LIST;
        this("ambiguous", str, i3, list, list, list, list);
    }
}
