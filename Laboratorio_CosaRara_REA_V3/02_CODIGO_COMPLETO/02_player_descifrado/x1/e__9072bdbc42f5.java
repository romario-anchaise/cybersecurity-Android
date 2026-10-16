// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import g2.k0;
import java.util.function.BooleanSupplier;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements BooleanSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5850c;

    public /* synthetic */ e(Object obj, long j3, int i3) {
        this.f5848a = i3;
        this.f5849b = obj;
        this.f5850c = j3;
    }

    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        switch (this.f5848a) {
            case 0:
                return ((g) this.f5849b).a(this.f5850c);
            case 1:
                return ((g) this.f5849b).a(this.f5850c);
            case 2:
                return ((g) this.f5849b).a(this.f5850c);
            default:
                k0 k0Var = (k0) this.f5849b;
                return k0Var.C() && k0Var.f1663q.get() == this.f5850c;
        }
    }
}
