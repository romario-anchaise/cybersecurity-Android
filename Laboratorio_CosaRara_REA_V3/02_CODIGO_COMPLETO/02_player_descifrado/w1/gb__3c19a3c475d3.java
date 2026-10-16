// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.InputStream;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gb implements BooleanSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f4139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InputStream f4141c;

    public /* synthetic */ gb(j2 j2Var, int i3, InputStream inputStream) {
        this.f4139a = j2Var;
        this.f4140b = i3;
        this.f4141c = inputStream;
    }

    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        rd rdVar = ScreenMirrorService.n6;
        j2 j2Var = this.f4139a;
        return j2Var == null || j2Var.b(this.f4140b, this.f4141c);
    }
}
