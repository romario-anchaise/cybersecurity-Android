// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Serializable f2998c;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Serializable, p2.x[]] */
    public x(int i3) {
        switch (i3) {
            case 1:
                this.f2998c = new long[64];
                break;
            default:
                this.f2998c = new x[256];
                this.f2996a = 0;
                this.f2997b = 0;
                break;
        }
    }

    public void a(long j3) {
        long[] jArr = (long[]) this.f2998c;
        jArr[this.f2997b] = Math.max(0L, j3);
        this.f2997b = (this.f2997b + 1) % jArr.length;
        int i3 = this.f2996a;
        if (i3 < jArr.length) {
            this.f2996a = i3 + 1;
        }
    }

    public long b(int i3) {
        int i4 = this.f2996a;
        if (i4 == 0) {
            return 0L;
        }
        long[] jArrCopyOf = Arrays.copyOf((long[]) this.f2998c, i4);
        Arrays.sort(jArrCopyOf);
        int i5 = this.f2996a;
        return jArrCopyOf[Math.max(0, Math.min(i5 - 1, (((i3 * i5) + 99) / 100) - 1))];
    }

    public x(int i3, int i4, String str) {
        this.f2998c = str;
        this.f2996a = i3;
        this.f2997b = i4;
    }

    public x(int i3, int i4) {
        this.f2998c = null;
        this.f2996a = i3;
        int i5 = i4 & 7;
        this.f2997b = i5 == 0 ? 8 : i5;
    }
}
