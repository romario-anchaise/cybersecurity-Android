// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.EnumMap;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumMap f1725c;

    public r0(boolean z2, int i3, int i4, int i5, int i6, int i7) {
        this.f1723a = z2;
        if (i7 <= 0 || i7 > 33554432) {
            o2.i("invalid max media frame bytes");
            throw null;
        }
        this.f1724b = i7;
        EnumMap enumMap = new EnumMap(v0.class);
        this.f1725c = enumMap;
        a(i3);
        enumMap.put(v0.f1766d, Integer.valueOf(i3));
        a(i4);
        enumMap.put(v0.f1767e, Integer.valueOf(i4));
        a(i5);
        enumMap.put(v0.f1768f, Integer.valueOf(i5));
        a(i6);
        enumMap.put(v0.f1769g, Integer.valueOf(i6));
    }

    public static void a(int i3) {
        if (i3 <= 0 || i3 > 240) {
            o2.i("invalid media window");
        }
    }

    public final String toString() {
        if (!this.f1723a) {
            return "v1";
        }
        return "v2" + this.f1725c + ",maxFrameBytes=" + this.f1724b;
    }
}
