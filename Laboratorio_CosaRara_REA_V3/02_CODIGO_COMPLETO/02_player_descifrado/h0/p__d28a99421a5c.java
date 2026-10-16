// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0.b f1921c;

    public p(e0.b bVar) {
        if ((bVar.f659d == 0 || bVar.f660e == null) ? false : true) {
            this.f1921c = bVar;
        } else {
            o2.i("ResolvableConnectionException can only be created with a connection result containing a resolution.");
            throw null;
        }
    }
}
