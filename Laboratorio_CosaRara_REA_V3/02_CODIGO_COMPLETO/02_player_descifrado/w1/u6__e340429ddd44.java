// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u6 {
    static {
        new u6(Collections.EMPTY_MAP, Collections.EMPTY_SET);
    }

    public u6(Map map, Set set) {
        Collections.unmodifiableMap(new LinkedHashMap(map == null ? Collections.EMPTY_MAP : map));
        Collections.unmodifiableSet(new LinkedHashSet(set == null ? Collections.EMPTY_SET : set));
    }
}
