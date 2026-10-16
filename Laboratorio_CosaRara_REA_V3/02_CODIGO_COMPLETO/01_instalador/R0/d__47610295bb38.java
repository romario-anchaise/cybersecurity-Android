// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.InterfaceC0047t;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC0047t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p040w0.i f544a;

    public d(p040w0.i iVar) {
        this.f544a = iVar;
    }

    @Override // N0.InterfaceC0047t
    public final p040w0.i c() {
        return this.f544a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f544a + ')';
    }
}
