// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        str.getClass();
        str2.getClass();
        int iMin = Math.min(str.length(), str2.length());
        for (int i3 = 4; i3 < iMin; i3++) {
            char cCharAt = str.charAt(i3);
            char cCharAt2 = str2.charAt(i3);
            if (cCharAt != cCharAt2) {
                return q1.e.b(cCharAt, cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
