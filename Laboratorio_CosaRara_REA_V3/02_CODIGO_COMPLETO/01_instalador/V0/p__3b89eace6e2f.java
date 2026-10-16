// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f733a = {243, 70, 50, 83, 39, 117, 226, 144, 60, 67, 76, 216, 98, 150, 31, 188};

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder(iArr.length);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            sb.append((char) (iArr[i2] ^ f733a[i2 % 16]));
        }
        return sb.toString();
    }
}
