// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.function.LongSupplier;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class za implements LongSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5726a;

    public /* synthetic */ za(ScreenMirrorService screenMirrorService) {
        this.f5726a = screenMirrorService;
    }

    @Override // java.util.function.LongSupplier
    public final long getAsLong() {
        return this.f5726a.f2536r2;
    }
}
