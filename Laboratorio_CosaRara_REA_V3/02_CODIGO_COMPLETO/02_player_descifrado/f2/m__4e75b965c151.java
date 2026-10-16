// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        o oVar = (o) obj;
        o oVar2 = (o) obj2;
        int i3 = oVar.f1275b;
        n nVar = oVar.f1274a;
        int i4 = oVar2.f1275b;
        n nVar2 = oVar2.f1274a;
        if (i3 != i4) {
            return i4 - i3;
        }
        if (nVar.c() != nVar2.c()) {
            return nVar.c() ? -1 : 1;
        }
        return nVar.a().compareTo(nVar2.a());
    }
}
