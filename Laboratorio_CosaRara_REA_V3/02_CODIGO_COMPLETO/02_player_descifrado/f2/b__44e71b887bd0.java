// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.ComponentName;
import android.os.Build;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.setup.A11yGuideActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ A11yGuideActivity f1132d;

    public /* synthetic */ b(A11yGuideActivity a11yGuideActivity, int i3) {
        this.f1131c = i3;
        this.f1132d = a11yGuideActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f1131c;
        A11yGuideActivity a11yGuideActivity = this.f1132d;
        switch (i3) {
            case 0:
                int i4 = A11yGuideActivity.f2644k;
                a11yGuideActivity.b();
                break;
            case 1:
                if (a11yGuideActivity.f2648d && !a11yGuideActivity.f2649e && a11yGuideActivity.f2647c && !a11yGuideActivity.isFinishing() && !a11yGuideActivity.isDestroyed()) {
                    boolean zA = w1.n.p0(a11yGuideActivity).a();
                    e eVar = a11yGuideActivity.f2646b;
                    boolean z2 = eVar != null && eVar.f1179a < eVar.f1180b.size();
                    a11yGuideActivity.f2648d = false;
                    if (!zA && z2) {
                        Log.w("A11yGuide", "settings route did not pause guide; trying fallback");
                        a11yGuideActivity.f2651g.postDelayed(a11yGuideActivity.f2653i, 120L);
                    } else {
                        a11yGuideActivity.a();
                    }
                    break;
                }
                break;
            default:
                if (a11yGuideActivity.f2646b != null) {
                    Log.i("A11yGuide", "a11y route session already active");
                } else {
                    ComponentName componentName = new ComponentName(a11yGuideActivity, (Class<?>) ScreenMirrorService.class);
                    CharSequence packageName = componentName.getPackageName();
                    try {
                        packageName = a11yGuideActivity.getApplicationInfo().loadLabel(a11yGuideActivity.getPackageManager());
                        break;
                    } catch (Throwable unused) {
                    }
                    try {
                        int i5 = Build.VERSION.SDK_INT;
                        String str = Build.MANUFACTURER;
                        a11yGuideActivity.f2646b = l.d0(i5, componentName, packageName);
                        a11yGuideActivity.b();
                    } catch (Throwable th) {
                        a11yGuideActivity.a();
                        Log.w("A11yGuide", "open a11y settings failed", th);
                    }
                }
                break;
        }
    }
}
