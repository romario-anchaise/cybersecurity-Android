// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f198e = false;

    public i(e eVar, a aVar) {
        this.f196c = eVar;
        this.f197d = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        if (this.f198e) {
            return;
        }
        e eVar = this.f196c;
        eVar.getClass();
        int[] iArr = c.f178a;
        a aVar = this.f197d;
        switch (iArr[aVar.ordinal()]) {
            case 1:
            case 2:
                bVar = b.f174e;
                break;
            case 3:
            case 4:
                bVar = b.f175f;
                break;
            case 5:
                bVar = b.f176g;
                break;
            case 6:
                bVar = b.f172c;
                break;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
        if (eVar.f181b != bVar) {
            eVar.f181b = bVar;
            if (eVar.f184e || eVar.f183d != 0) {
                eVar.f185f = true;
            } else {
                eVar.f184e = true;
                b.a aVar2 = eVar.f180a;
                if (((f) eVar.f182c.get()) == null) {
                    o2.k("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
                } else {
                    if (aVar2.f252d != 0) {
                        throw null;
                    }
                    eVar.f185f = false;
                }
                eVar.f184e = false;
            }
        }
        this.f198e = true;
    }
}
