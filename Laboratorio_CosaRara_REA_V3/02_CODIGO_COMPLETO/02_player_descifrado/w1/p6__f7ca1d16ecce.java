// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g7 f4806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4818m;
    public final boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final l7 f4820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f4821q;

    public p6(g7 g7Var, String str, int i3, int i4, boolean z2, boolean z3, String str2, String str3, String str4, int i5, int i6, boolean z4, String str5, String str6, boolean z5, int i7, l7 l7Var, List list) {
        this.f4806a = g7Var;
        this.f4807b = str;
        this.f4808c = i3;
        this.f4809d = i4;
        this.f4810e = z2;
        this.f4811f = z3;
        this.f4812g = str2 == null ? "" : str2;
        this.f4813h = str3 == null ? "" : str3;
        this.f4814i = str4 == null ? "" : str4;
        this.f4815j = Math.max(0, i5);
        this.f4816k = i6;
        this.f4817l = z4;
        this.f4818m = str5 != null ? str5 : "";
        this.n = z5;
        this.f4819o = Math.max(0, i7);
        this.f4820p = l7Var == null ? new l7(0, 0, 0, 0) : l7Var;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l7 l7Var2 = (l7) it.next();
                if (l7Var2 != null && l7Var2.b()) {
                    arrayList.add(l7Var2);
                }
            }
        }
        this.f4821q = Collections.unmodifiableList(arrayList);
    }
}
