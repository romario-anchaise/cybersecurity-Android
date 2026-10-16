// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p038v0;

import F0.i;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4149b = new a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4150c = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4151a;

    public /* synthetic */ a(int i2) {
        this.f4151a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4151a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                i.e(comparable, "a");
                i.e(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                i.e(comparable3, "a");
                i.e(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f4151a) {
            case 0:
                return f4150c;
            default:
                return f4149b;
        }
    }
}
