// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class H extends AbstractC0045q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p036u0.d f392e;

    public abstract void A();

    public final void w() {
        long j2 = this.f390c - 4294967296L;
        this.f390c = j2;
        if (j2 <= 0 && this.f391d) {
            A();
        }
    }

    public abstract Thread x();

    public final void y(boolean z2) {
        this.f390c = (z2 ? 4294967296L : 1L) + this.f390c;
        if (z2) {
            return;
        }
        this.f391d = true;
    }

    public final boolean z() throws IllegalAccessException, InvocationTargetException {
        p036u0.d dVar = this.f392e;
        if (dVar == null) {
            return false;
        }
        B b2 = (B) (dVar.isEmpty() ? null : dVar.removeFirst());
        if (b2 == null) {
            return false;
        }
        b2.run();
        return true;
    }
}
