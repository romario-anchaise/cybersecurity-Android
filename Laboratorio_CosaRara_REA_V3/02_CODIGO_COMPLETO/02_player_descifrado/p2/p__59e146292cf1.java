// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static int a(int i3, int i4, int i5) {
        if ((i4 & 8) != 0) {
            i3--;
        }
        if (i5 <= i3) {
            return i3 - i5;
        }
        o2.l(a0.a.f(i5, i3, "PROTOCOL_ERROR padding ", " > remaining length "));
        return 0;
    }
}
