// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Comparator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h7 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i7 f4205b;

    public /* synthetic */ h7(i7 i7Var, int i3) {
        this.f4204a = i3;
        this.f4205b = i7Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4204a) {
            case 0:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                int iIntValue = num.intValue();
                i7 i7Var = this.f4205b;
                boolean zC = i7.c(i7Var, iIntValue);
                o7 o7Var = i7Var.f4255a;
                if (zC != i7.c(i7Var, num2.intValue())) {
                    return zC ? -1 : 1;
                }
                k7 k7Var = (k7) o7Var.f4735o.get(num.intValue());
                k7 k7Var2 = (k7) o7Var.f4735o.get(num2.intValue());
                int iCompare = Integer.compare(o7.f(k7Var2.f4400b), o7.f(k7Var.f4400b));
                if (iCompare != 0 || (iCompare = Integer.compare(k7Var2.f4401c, k7Var.f4401c)) != 0 || (iCompare = Integer.compare(k7Var2.f4402d, k7Var.f4402d)) != 0) {
                    return iCompare;
                }
                int iCompare2 = Integer.compare(num.intValue(), num2.intValue());
                return iCompare2 != 0 ? iCompare2 : k7Var.f4399a.compareTo(k7Var2.f4399a);
            default:
                String str = (String) obj;
                String str2 = (String) obj2;
                i7 i7Var2 = this.f4205b;
                LinkedHashMap linkedHashMap = i7Var2.f4257c;
                int iCompare3 = Integer.compare(i7.a(i7Var2, str), i7.a(i7Var2, str2));
                if (iCompare3 != 0) {
                    return iCompare3;
                }
                int iCompare4 = Integer.compare(i7.b(i7Var2, str2), i7.b(i7Var2, str));
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                Integer num3 = (Integer) linkedHashMap.get(str);
                int iIntValue2 = num3 == null ? Integer.MAX_VALUE : num3.intValue();
                Integer num4 = (Integer) linkedHashMap.get(str2);
                int iCompare5 = Integer.compare(iIntValue2, num4 != null ? num4.intValue() : Integer.MAX_VALUE);
                return iCompare5 != 0 ? iCompare5 : str.compareTo(str2);
        }
    }
}
