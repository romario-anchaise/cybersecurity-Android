// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.Comparator;

/* JADX INFO: renamed from: X0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0060g implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        F0.i.e(str, "a");
        F0.i.e(str2, "b");
        int iMin = Math.min(str.length(), str2.length());
        for (int i2 = 4; i2 < iMin; i2++) {
            char cCharAt = str.charAt(i2);
            char cCharAt2 = str2.charAt(i2);
            if (cCharAt != cCharAt2) {
                if (F0.i.f(cCharAt, cCharAt2) >= 0) {
                    return 1;
                }
                return -1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return 0;
        }
        if (length >= length2) {
            return 1;
        }
        return -1;
    }
}
