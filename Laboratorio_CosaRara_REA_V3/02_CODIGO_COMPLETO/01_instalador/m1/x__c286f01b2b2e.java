// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import k1.InterfaceC0195k;

/* JADX INFO: loaded from: classes.dex */
public final class x extends X0.G {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.s f3865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3866c;

    public x(X0.s sVar, long j2) {
        this.f3865b = sVar;
        this.f3866c = j2;
    }

    @Override // X0.G
    public final long a() {
        return this.f3866c;
    }

    @Override // X0.G
    public final X0.s f() {
        return this.f3865b;
    }

    @Override // X0.G
    public final InterfaceC0195k j() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
