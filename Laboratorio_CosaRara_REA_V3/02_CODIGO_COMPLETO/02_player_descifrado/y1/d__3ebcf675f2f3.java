// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

import android.view.accessibility.AccessibilityNodeInfo;
import i2.w;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f6136c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f6137d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w f6138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f6139f;

    @Override // java.lang.AutoCloseable
    public final void close() {
        ArrayList arrayList = this.f6136c;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            try {
                ((AccessibilityNodeInfo) obj).recycle();
            } catch (Throwable unused) {
            }
        }
        arrayList.clear();
        this.f6137d.clear();
    }

    public final void d(h hVar, AccessibilityNodeInfo accessibilityNodeInfo) {
        ((ArrayList) this.f6138e.f2273e).add(hVar);
        this.f6137d.add(accessibilityNodeInfo);
    }

    public final void w() {
        if (this.f6139f == null) {
            w wVar = this.f6138e;
            wVar.getClass();
            w wVar2 = new w();
            String str = wVar.f2269a;
            String str2 = j.f6206a;
            if (str == null) {
                str = "";
            }
            wVar2.f2269a = str;
            String str3 = (String) wVar.f2270b;
            wVar2.f2270b = str3 != null ? str3 : "";
            wVar2.f2271c = Collections.unmodifiableList(new ArrayList((ArrayList) wVar.f2271c));
            wVar2.f2272d = Collections.unmodifiableList(new ArrayList((ArrayList) wVar.f2272d));
            wVar2.f2273e = Collections.unmodifiableList(new ArrayList((ArrayList) wVar.f2273e));
            this.f6139f = wVar2;
        }
    }
}
