// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w6 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5399a;

    public w6(boolean z2) {
        this.f5399a = z2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        a7 a7Var = (a7) obj;
        a7 a7Var2 = (a7) obj2;
        boolean z2 = this.f5399a;
        int iCompare = Integer.compare(n4.c(a7Var2, z2), n4.c(a7Var, z2));
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(a7Var2.f3475f, a7Var.f3475f);
        return iCompare2 != 0 ? iCompare2 : Integer.compare(a7Var.f3471b, a7Var2.f3471b);
    }
}
