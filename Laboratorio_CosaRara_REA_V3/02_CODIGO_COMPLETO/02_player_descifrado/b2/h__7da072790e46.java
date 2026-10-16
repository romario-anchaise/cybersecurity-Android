// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f296d = new h(-1, "", false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f299c;

    public h(long j3, String str, boolean z2) {
        this.f297a = z2;
        this.f298b = (str == null ? "" : str).trim();
        this.f299c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f299c == hVar.f299c && this.f297a == hVar.f297a && this.f298b.equals(hVar.f298b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f297a), this.f298b, Long.valueOf(this.f299c));
    }
}
