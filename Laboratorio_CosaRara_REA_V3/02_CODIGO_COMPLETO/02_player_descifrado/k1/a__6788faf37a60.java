// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2399b = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2400c = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2401a;

    public /* synthetic */ a(int i3) {
        this.f2401a = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2401a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                comparable4.getClass();
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f2401a) {
            case 0:
                return f2400c;
            default:
                return f2399b;
        }
    }
}
