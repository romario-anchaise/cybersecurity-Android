// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class jc implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AccessibilityNodeInfo f4368e;

    public jc(String str, String str2, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4366c = str;
        this.f4367d = str2;
        this.f4368e = accessibilityNodeInfo;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        try {
            this.f4368e.recycle();
        } catch (Throwable unused) {
        }
    }
}
