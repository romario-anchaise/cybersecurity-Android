// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1381a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

    public static /* synthetic */ int a(int i3) {
        if (i3 != 0) {
            return i3 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] b(int i3) {
        int[] iArr = new int[i3];
        System.arraycopy(f1381a, 0, iArr, 0, i3);
        return iArr;
    }
}
