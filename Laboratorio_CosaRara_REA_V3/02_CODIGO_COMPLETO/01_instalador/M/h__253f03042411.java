// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.i;
import java.util.ConcurrentModificationException;
import p023n.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3685a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3686b = new Object();

    public static final int a(f fVar, Object obj, int i2) {
        i.e(fVar, "<this>");
        int i3 = fVar.f3680c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iA = a.a(fVar.f3680c, i2, fVar.f3678a);
            if (iA < 0 || i.a(obj, fVar.f3679b[iA])) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i3 && fVar.f3678a[i4] == i2) {
                if (i.a(obj, fVar.f3679b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && fVar.f3678a[i5] == i2; i5--) {
                if (i.a(obj, fVar.f3679b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
