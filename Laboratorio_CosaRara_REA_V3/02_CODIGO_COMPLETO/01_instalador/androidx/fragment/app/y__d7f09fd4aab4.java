// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1625a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    public static /* synthetic */ void a(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ int b(int i2) {
        if (i2 != 0) {
            return i2 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] c(int i2) {
        int[] iArr = new int[i2];
        System.arraycopy(f1625a, 0, iArr, 0, i2);
        return iArr;
    }
}
