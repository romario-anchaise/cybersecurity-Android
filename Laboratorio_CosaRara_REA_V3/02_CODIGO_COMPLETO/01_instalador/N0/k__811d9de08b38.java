// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: N0.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0039k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f439b = AtomicIntegerFieldUpdater.newUpdater(C0039k.class, "_handled");
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f440a;

    public C0039k(Throwable th, boolean z2) {
        this.f440a = th;
        this._handled = z2 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f440a + ']';
    }
}
