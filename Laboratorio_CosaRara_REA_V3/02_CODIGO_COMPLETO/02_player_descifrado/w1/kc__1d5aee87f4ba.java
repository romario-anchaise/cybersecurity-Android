// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class kc implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4414c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccessibilityNodeInfo f4415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4416e;

    public kc(AccessibilityNodeInfo accessibilityNodeInfo, z1.k kVar) {
        this.f4415d = accessibilityNodeInfo;
        this.f4416e = kVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        switch (this.f4414c) {
            case 0:
                try {
                    this.f4415d.recycle();
                } catch (Throwable unused) {
                    return;
                }
                break;
            default:
                x1.g.p(this.f4415d);
                break;
        }
    }

    public boolean d(int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACTION_ARGUMENT_SELECTION_START_INT", i3);
        bundle.putInt("ACTION_ARGUMENT_SELECTION_END_INT", i4);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4415d;
        boolean zPerformAction = accessibilityNodeInfo.performAction(131072, bundle);
        try {
            accessibilityNodeInfo.refresh();
        } catch (Throwable unused) {
        }
        return zPerformAction;
    }

    public boolean w(String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4415d;
        boolean zPerformAction = accessibilityNodeInfo.performAction(2097152, bundle);
        if (zPerformAction) {
            try {
                accessibilityNodeInfo.refresh();
            } catch (Throwable unused) {
            }
        }
        return zPerformAction;
    }

    public kc(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        this.f4416e = str;
        this.f4415d = accessibilityNodeInfo;
    }
}
