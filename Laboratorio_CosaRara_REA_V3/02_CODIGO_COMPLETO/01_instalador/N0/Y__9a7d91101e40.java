// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f408b = AtomicIntegerFieldUpdater.newUpdater(Y.class, "_isCompleting");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f409c = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_rootCause");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f410d = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f411a;

    public Y(b0 b0Var, Throwable th) {
        this.f411a = b0Var;
        this._rootCause = th;
    }

    @Override // N0.L
    public final boolean a() {
        return d() == null;
    }

    @Override // N0.L
    public final b0 b() {
        return this.f411a;
    }

    public final void c(Throwable th) {
        Throwable thD = d();
        if (thD == null) {
            f409c.set(this, th);
            return;
        }
        if (th == thD) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f410d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable d() {
        return (Throwable) f409c.get(this);
    }

    public final boolean e() {
        return d() != null;
    }

    public final boolean f() {
        return f408b.get(this) != 0;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f410d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable thD = d();
        if (thD != null) {
            arrayList.add(0, thD);
        }
        if (th != null && !th.equals(thD)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC0049v.g);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + f410d.get(this) + ", list=" + this.f411a + ']';
    }
}
