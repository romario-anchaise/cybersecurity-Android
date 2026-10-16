// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f563e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f564f = AtomicLongFieldUpdater.newUpdater(n.class, "_state");
    public static final u g = new u(0, "REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f568d;

    public n(int i2, boolean z2) {
        this.f565a = i2;
        this.f566b = z2;
        int i3 = i2 - 1;
        this.f567c = i3;
        this.f568d = new AtomicReferenceArray(i2);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i2 & i3) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f564f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j2) != 0) {
                return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
            }
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f567c;
            if (((i3 + 2) & i4) == (i2 & i4)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f568d;
            if (!this.f566b && atomicReferenceArray.get(i3 & i4) != null) {
                int i5 = this.f565a;
                if (i5 < 1024 || ((i3 - i2) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j2, ((-1152921503533105153L) & j2) | (((long) ((i3 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i3 & i4, runnable);
                n nVarC = this;
                while ((atomicLongFieldUpdater.get(nVarC) & 1152921504606846976L) != 0) {
                    nVarC = nVarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = nVarC.f568d;
                    int i6 = nVarC.f567c & i3;
                    Object obj = atomicReferenceArray2.get(i6);
                    if ((obj instanceof m) && ((m) obj).f562a == i3) {
                        atomicReferenceArray2.set(i6, runnable);
                    } else {
                        nVarC = null;
                    }
                    if (nVarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        do {
            atomicLongFieldUpdater = f564f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, 2305843009213693952L | j2));
        return true;
    }

    public final n c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        while (true) {
            atomicLongFieldUpdater = f564f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                break;
            }
            long j3 = j2 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j2, j3)) {
                j2 = j3;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f563e;
            n nVar = (n) atomicReferenceFieldUpdater.get(this);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n(this.f565a * 2, this.f566b);
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i4 = this.f567c;
                int i5 = i2 & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object mVar = this.f568d.get(i5);
                if (mVar == null) {
                    mVar = new m(i2);
                }
                nVar2.f568d.set(nVar2.f567c & i2, mVar);
                i2++;
            }
            atomicLongFieldUpdater.set(nVar2, (-1152921504606846977L) & j2);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, nVar2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f564f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                return g;
            }
            int i2 = (int) (j2 & 1073741823);
            int i3 = this.f567c;
            int i4 = i2 & i3;
            if ((((int) ((1152921503533105152L & j2) >> 30)) & i3) == i4) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f568d;
            Object obj = atomicReferenceArray.get(i4);
            boolean z2 = this.f566b;
            if (obj == null) {
                if (z2) {
                    return null;
                }
            } else {
                if (obj instanceof m) {
                    return null;
                }
                long j3 = (i2 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j2, (j2 & (-1073741824)) | j3)) {
                    atomicReferenceArray.set(i4, null);
                    return obj;
                }
                if (z2) {
                    n nVarC = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f564f;
                        long j4 = atomicLongFieldUpdater2.get(nVarC);
                        int i5 = (int) (j4 & 1073741823);
                        if ((j4 & 1152921504606846976L) != 0) {
                            nVarC = nVarC.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(nVarC, j4, (j4 & (-1073741824)) | j3)) {
                                nVarC.f568d.set(nVarC.f567c & i5, null);
                                nVarC = null;
                            } else {
                                continue;
                            }
                        }
                        if (nVarC == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
