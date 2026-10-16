// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package P0;

import F0.i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Q0.a implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f514c = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");
    private volatile Object _state;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f515b;

    public b(Object obj) {
        this._state = obj;
    }

    public final void a(Object obj) {
        int i2;
        if (obj == null) {
            obj = Q0.a.f529a;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f514c;
            if (i.a(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i3 = this.f515b;
            if ((i3 & 1) != 0) {
                this.f515b = i3 + 2;
                return;
            }
            int i4 = i3 + 1;
            this.f515b = i4;
            while (true) {
                synchronized (this) {
                    i2 = this.f515b;
                    if (i2 == i4) {
                        this.f515b = i4 + 1;
                        return;
                    }
                }
                i4 = i2;
            }
        }
    }
}
