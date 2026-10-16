// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l7 f4404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f4405g;

    public k7(String str, String str2, int i3, int i4, ArrayList arrayList, l7 l7Var, List list) {
        this.f4399a = o7.c(str, 96);
        if (!"application".equals(str2) && !"ime".equals(str2) && !"ime_candidate".equals(str2) && !"accessibility_overlay".equals(str2) && !"system".equals(str2)) {
            str2 = "other";
        }
        this.f4400b = str2;
        this.f4401c = i3;
        this.f4402d = Math.max(0, i4);
        this.f4403e = o7.d(arrayList);
        this.f4404f = l7Var == null ? new l7(0, 0, 0, 0) : l7Var;
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l7 l7Var2 = (l7) it.next();
                if (l7Var2 != null && l7Var2.b()) {
                    arrayList2.add(l7Var2);
                }
            }
        }
        this.f4405g = Collections.unmodifiableList(arrayList2);
    }
}
