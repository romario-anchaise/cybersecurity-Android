// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j1 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4301a;

    public /* synthetic */ j1(int i3) {
        this.f4301a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4301a) {
            case 0:
                return ((Integer) obj).compareTo((Integer) obj2);
            default:
                return Integer.compare(((p4) obj2).f4786j, ((p4) obj).f4786j);
        }
    }
}
