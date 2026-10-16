// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f285d = new c(1, 0, 1);

    @Override // J0.a
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f278a == cVar.f278a) {
                    if (this.f279b == cVar.f279b) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // J0.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f278a * 31) + this.f279b;
    }

    @Override // J0.a
    public final boolean isEmpty() {
        return this.f278a > this.f279b;
    }

    @Override // J0.a
    public final String toString() {
        return this.f278a + ".." + this.f279b;
    }
}
