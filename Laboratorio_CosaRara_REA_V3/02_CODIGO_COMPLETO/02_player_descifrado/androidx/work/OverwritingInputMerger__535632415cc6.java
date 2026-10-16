// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work;

import g2.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import p.e;
import p.g;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends g {
    @Override // p.g
    public final e a(ArrayList arrayList) throws Throwable {
        o0 o0Var = new o0(1);
        HashMap map = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            map.putAll(Collections.unmodifiableMap(((e) obj).f2843a));
        }
        o0Var.b(map);
        e eVar = new e(o0Var.f1701a);
        e.b(eVar);
        return eVar;
    }
}
