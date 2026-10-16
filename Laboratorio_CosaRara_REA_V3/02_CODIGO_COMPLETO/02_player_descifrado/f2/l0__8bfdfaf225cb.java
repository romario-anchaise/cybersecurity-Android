// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1255c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AccessibilityService f1256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x1.r f1257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1258f;

    public /* synthetic */ l0(AccessibilityService accessibilityService, int i3, x1.r rVar) {
        this.f1256d = accessibilityService;
        this.f1258f = i3;
        this.f1257e = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1255c) {
            case 0:
                AccessibilityService accessibilityService = this.f1256d;
                ArrayList arrayListQ = p0.q(accessibilityService);
                int size = arrayListQ.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListQ.get(i3);
                    i3++;
                    if (p0.d0((AccessibilityNodeInfo) obj)) {
                        p0.Z(500L, this.f1258f, new n0(accessibilityService, this.f1257e, 0));
                        break;
                    }
                }
                p0.Z(500L, this.f1258f, new n0(accessibilityService, this.f1257e, 0));
                break;
            default:
                p0.I(this.f1256d, this.f1258f + 1, this.f1257e);
                break;
        }
    }

    public /* synthetic */ l0(AccessibilityService accessibilityService, x1.r rVar, int i3) {
        this.f1256d = accessibilityService;
        this.f1257e = rVar;
        this.f1258f = i3;
    }
}
