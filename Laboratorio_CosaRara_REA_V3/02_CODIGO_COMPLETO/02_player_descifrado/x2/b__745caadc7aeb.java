// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x2;

import w2.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f5967a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('a' <= c3 && c3 < 'g') {
            return c3 - 'W';
        }
        if ('A' <= c3 && c3 < 'G') {
            return c3 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c3);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    public static final int b(u uVar, int i3) {
        int i4;
        int[] iArr = uVar.f5812h;
        int i5 = i3 + 1;
        int length = uVar.f5811g.length;
        iArr.getClass();
        int i6 = length - 1;
        int i7 = 0;
        while (i7 <= i6) {
            i4 = (i7 + i6) >>> 1;
            int i8 = iArr[i4];
            if (i8 < i5) {
                i7 = i4 + 1;
            } else {
                if (i8 <= i5) {
                    if (i4 >= 0) {
                        return i4;
                    }
                    return ~i4;
                }
                i6 = i4 - 1;
            }
        }
        i4 = (-i7) - 1;
        if (i4 >= 0) {
            return i4;
        }
        return ~i4;
    }
}
