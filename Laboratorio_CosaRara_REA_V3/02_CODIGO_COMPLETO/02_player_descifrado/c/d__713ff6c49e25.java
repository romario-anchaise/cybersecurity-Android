// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f372a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object[] f373b = new Object[0];

    public static int a(int[] iArr, int i3, int i4) {
        int i5 = i3 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            int i8 = iArr[i7];
            if (i8 < i4) {
                i6 = i7 + 1;
            } else {
                if (i8 <= i4) {
                    return i7;
                }
                i5 = i7 - 1;
            }
        }
        return ~i6;
    }
}
