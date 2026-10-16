// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v3 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5291a;

    public /* synthetic */ v3(int i3) {
        this.f5291a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f5291a) {
            case 0:
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file.isDirectory() != file2.isDirectory()) {
                    return file.isDirectory() ? -1 : 1;
                }
                return file.getName().compareToIgnoreCase(file2.getName());
            case 1:
                v6 v6Var = (v6) obj;
                v6 v6Var2 = (v6) obj2;
                int iCompare = Integer.compare(v6Var.f5298c, v6Var2.f5298c);
                return iCompare != 0 ? iCompare : v6Var.f5296a.compareTo(v6Var2.f5296a);
            case 2:
                return Integer.compare(((g7) obj).n, ((g7) obj2).n);
            case 3:
                p6 p6Var = (p6) obj;
                p6 p6Var2 = (p6) obj2;
                int iCompare2 = Integer.compare(p6Var.f4806a.n, p6Var2.f4806a.n);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompareTo = p6Var.f4807b.compareTo(p6Var2.f4807b);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompare3 = Integer.compare(p6Var.f4815j, p6Var2.f4815j);
                return iCompare3 != 0 ? iCompare3 : Integer.compare(p6Var.f4816k, p6Var2.f4816k);
            case 4:
                v6 v6Var3 = (v6) obj;
                v6 v6Var4 = (v6) obj2;
                int iCompare4 = Integer.compare(v6Var4.f5303h, v6Var3.f5303h);
                return iCompare4 != 0 ? iCompare4 : Integer.compare(v6Var4.f5298c, v6Var3.f5298c);
            case 5:
                k7 k7Var = (k7) obj;
                k7 k7Var2 = (k7) obj2;
                int iCompare5 = Integer.compare(k7Var.f4401c, k7Var2.f4401c);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                int iCompare6 = Integer.compare(k7Var.f4402d, k7Var2.f4402d);
                return iCompare6 != 0 ? iCompare6 : k7Var.f4399a.compareTo(k7Var2.f4399a);
            case 6:
                o6 o6Var = (o6) obj;
                o6 o6Var2 = (o6) obj2;
                p6 p6Var3 = o6Var.f4718b;
                String str = p6Var3 == null ? "" : p6Var3.f4818m;
                p6 p6Var4 = o6Var2.f4718b;
                int iCompareTo2 = str.compareTo(p6Var4 != null ? p6Var4.f4818m : "");
                return iCompareTo2 != 0 ? iCompareTo2 : o6Var.f4717a.compareTo(o6Var2.f4717a);
            case 7:
                a7 a7Var = (a7) obj;
                a7 a7Var2 = (a7) obj2;
                int iCompare7 = Boolean.compare(a7Var2.f3473d, a7Var.f3473d);
                if (iCompare7 != 0) {
                    return iCompare7;
                }
                int iCompare8 = Boolean.compare(a7Var2.f3474e, a7Var.f3474e);
                if (iCompare8 != 0) {
                    return iCompare8;
                }
                int iCompare9 = Integer.compare(a7Var2.f3475f, a7Var.f3475f);
                return iCompare9 != 0 ? iCompare9 : Integer.compare(a7Var.f3471b, a7Var2.f3471b);
            case 8:
                a7 a7Var3 = ((b7) obj2).f3569a;
                boolean z2 = a7Var3.f3473d;
                a7 a7Var4 = ((b7) obj).f3569a;
                int iCompare10 = Boolean.compare(z2, a7Var4.f3473d);
                if (iCompare10 != 0) {
                    return iCompare10;
                }
                int iCompare11 = Boolean.compare(a7Var3.f3474e, a7Var4.f3474e);
                if (iCompare11 != 0) {
                    return iCompare11;
                }
                int iCompare12 = Integer.compare(n4.s(a7Var3, false), n4.s(a7Var4, false));
                return iCompare12 != 0 ? iCompare12 : Integer.compare(a7Var3.f3475f, a7Var4.f3475f);
            default:
                b7 b7Var = (b7) obj;
                b7 b7Var2 = (b7) obj2;
                int iCompare13 = Integer.compare(b7Var.f3569a.f3475f, b7Var2.f3569a.f3475f);
                return iCompare13 != 0 ? iCompare13 : Integer.compare(b7Var.f3569a.f3471b, b7Var2.f3569a.f3471b);
        }
    }
}
