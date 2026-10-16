// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import F0.h;
import java.io.IOException;
import java.util.BitSet;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class Q extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        boolean z2;
        BitSet bitSet = new BitSet();
        aVar.a();
        int iJ = aVar.J();
        int i2 = 0;
        while (iJ != 2) {
            int iB = androidx.fragment.app.y.b(iJ);
            if (iB == 5 || iB == 6) {
                int iB2 = aVar.B();
                if (iB2 == 0) {
                    z2 = false;
                } else {
                    if (iB2 != 1) {
                        throw new p("Invalid bitset value " + iB2 + ", expected 0 or 1; at path " + aVar.v(true));
                    }
                    z2 = true;
                }
            } else {
                if (iB != 7) {
                    throw new p("Invalid bitset value type: " + h.i(iJ) + "; at path " + aVar.v(false));
                }
                z2 = aVar.z();
            }
            if (z2) {
                bitSet.set(i2);
            }
            i2++;
            iJ = aVar.J();
        }
        aVar.r();
        return bitSet;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        bVar.f();
        int length = bitSet.length();
        for (int i2 = 0; i2 < length; i2++) {
            bVar.B(bitSet.get(i2) ? 1L : 0L);
        }
        bVar.r();
    }
}
