// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p034t0;

import F0.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4128a;

    public e(Throwable th) {
        i.e(th, "exception");
        this.f4128a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            if (i.a(this.f4128a, ((e) obj).f4128a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4128a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f4128a + ')';
    }
}
