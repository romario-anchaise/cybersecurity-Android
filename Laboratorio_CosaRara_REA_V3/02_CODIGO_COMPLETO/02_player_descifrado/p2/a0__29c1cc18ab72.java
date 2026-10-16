// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.util.HashMap;
import w1.w5;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2875b;

    public a0(HashMap map, int i3) {
        this.f2875b = new HashMap(map);
        this.f2874a = i3;
    }

    public int a() {
        if ((this.f2874a & 128) != 0) {
            return ((int[]) this.f2875b)[7];
        }
        return 65535;
    }

    public void b(int i3, int i4) {
        if (i3 >= 0) {
            int[] iArr = (int[]) this.f2875b;
            if (i3 >= iArr.length) {
                return;
            }
            this.f2874a = (1 << i3) | this.f2874a;
            iArr[i3] = i4;
        }
    }

    public a0() {
        this.f2875b = new int[10];
    }

    public /* synthetic */ a0(int i3, Object obj) {
        this.f2875b = obj;
        this.f2874a = i3;
    }
}
