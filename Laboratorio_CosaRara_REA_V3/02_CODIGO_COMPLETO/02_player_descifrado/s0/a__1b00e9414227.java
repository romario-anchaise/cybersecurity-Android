// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s0;

import h0.o;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3228a = new a();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && o.e(null, null) && o.e(null, null) && o.e(null, null) && o.e(null, null) && o.e(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
