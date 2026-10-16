// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.function.BooleanSupplier;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BooleanSupplier f5899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5901f;

    public /* synthetic */ l(BooleanSupplier booleanSupplier, Object obj, int i3, int i4) {
        this.f5898c = i4;
        this.f5899d = booleanSupplier;
        this.f5901f = obj;
        this.f5900e = i3;
    }

    @Override // x1.m
    /* JADX INFO: renamed from: run */
    public final boolean mo0run() {
        switch (this.f5898c) {
            case 0:
                return this.f5899d.getAsBoolean() && ((AccessibilityNodeInfo) this.f5901f).performAction(this.f5900e);
            default:
                return this.f5899d.getAsBoolean() && ((AccessibilityService) this.f5901f).performGlobalAction(this.f5900e);
        }
    }
}
