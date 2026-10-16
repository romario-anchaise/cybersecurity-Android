// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package U0;

import R0.t;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public final class f extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f648e;

    public f(long j2, f fVar, int i2) {
        super(j2, fVar, i2);
        this.f648e = new AtomicReferenceArray(e.f647f);
    }

    @Override // R0.t
    public final int d() {
        return e.f647f;
    }

    @Override // R0.t
    public final void e(int i2) {
        this.f648e.set(i2, e.f646e);
        if (t.f572d.incrementAndGet(this) == e.f647f) {
            b();
        }
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f573c + ", hashCode=" + hashCode() + ']';
    }
}
