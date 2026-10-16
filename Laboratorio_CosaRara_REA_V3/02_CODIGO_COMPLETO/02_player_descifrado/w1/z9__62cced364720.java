// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.Looper;
import java.util.function.Consumer;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z9 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5725b;

    public /* synthetic */ z9(int i3, Object obj) {
        this.f5724a = i3;
        this.f5725b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i3 = this.f5724a;
        Object obj2 = this.f5725b;
        switch (i3) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) obj2;
                Boolean bool = (Boolean) obj;
                Handler handler = screenMirrorService.z2;
                if (handler != null) {
                    ba baVar = new ba(screenMirrorService, bool, 1);
                    if (Looper.myLooper() != handler.getLooper()) {
                        handler.post(baVar);
                    } else {
                        baVar.run();
                    }
                    break;
                }
                break;
            default:
                cf.l((g2.d0) obj2, (String) obj);
                break;
        }
    }
}
