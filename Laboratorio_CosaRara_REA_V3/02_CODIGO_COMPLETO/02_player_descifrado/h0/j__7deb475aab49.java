// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f1904b = new j(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1905a;

    public /* synthetic */ j(String str) {
        this.f1905a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return o.e(this.f1905a, ((j) obj).f1905a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1905a});
    }
}
