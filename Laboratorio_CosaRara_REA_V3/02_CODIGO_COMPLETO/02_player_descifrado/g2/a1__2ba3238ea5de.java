// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import w1.g7;
import w1.p6;
import w1.r6;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1538c;

    public a1(long j3, int i3, List list) {
        this.f1536a = j3;
        this.f1537b = i3;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                r6 r6Var = (r6) it.next();
                if (r6Var != null && r6Var.f4989e > r6Var.f4987c && r6Var.f4990f > r6Var.f4988d) {
                    arrayList.add(r6Var);
                }
                if (arrayList.size() >= 8) {
                    break;
                }
            }
        }
        this.f1538c = Collections.unmodifiableList(arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
    }

    public boolean a(long j3) {
        if (this.f1537b == 0) {
            return false;
        }
        long j4 = this.f1536a;
        return j4 >= 0 && j3 >= j4 && j3 - j4 <= 2500;
    }

    public int b(p6 p6Var, long j3) {
        List list = (List) this.f1538c;
        if (p6Var == null || !a(j3)) {
            return -1;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            r6 r6Var = (r6) list.get(i3);
            String str = r6Var.f4986b;
            String str2 = p6Var.f4813h;
            g7 g7Var = p6Var.f4806a;
            int i4 = r6Var.f4985a;
            if ((i4 < 0 || i4 == p6Var.f4808c) && ((str.isEmpty() || (!str2.isEmpty() && str.equals(str2))) && Math.abs(r6Var.f4987c - g7Var.f4107c) <= 4 && Math.abs(r6Var.f4988d - g7Var.f4108d) <= 4 && Math.abs(r6Var.f4989e - g7Var.f4109e) <= 4 && Math.abs(r6Var.f4990f - g7Var.f4110f) <= 4)) {
                return i3;
            }
        }
        return -1;
    }

    public a1(int i3, long j3, String str) {
        this.f1538c = str;
        this.f1536a = j3;
        this.f1537b = i3;
    }
}
