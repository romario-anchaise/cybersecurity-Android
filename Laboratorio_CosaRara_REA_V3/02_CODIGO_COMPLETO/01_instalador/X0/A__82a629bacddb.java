// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import k1.InterfaceC0194j;

/* JADX INFO: loaded from: classes.dex */
public final class A extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f891d;

    public A(s sVar, int i2, byte[] bArr, int i3) {
        this.f888a = sVar;
        this.f889b = i2;
        this.f890c = bArr;
        this.f891d = i3;
    }

    @Override // X0.B
    public final long a() {
        return this.f889b;
    }

    @Override // X0.B
    public final s b() {
        return this.f888a;
    }

    @Override // X0.B
    public final void c(InterfaceC0194j interfaceC0194j) {
        interfaceC0194j.e(this.f890c, this.f891d, this.f889b);
    }
}
