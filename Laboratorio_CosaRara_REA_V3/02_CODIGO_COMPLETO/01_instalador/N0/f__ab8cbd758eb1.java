// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: N0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0034f extends C0039k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f426c = AtomicIntegerFieldUpdater.newUpdater(C0034f.class, "_resumed");
    private volatile int _resumed;

    public C0034f(C0033e c0033e, Throwable th, boolean z2) {
        super(th, z2);
        this._resumed = 0;
    }
}
