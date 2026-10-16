// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4432a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f4433b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(Handler handler, Context context) {
        super(handler);
        this.f4433b = context;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        switch (this.f4432a) {
            case 0:
                n.t(this.f4433b);
                break;
            default:
                ((ScreenMirrorService) this.f4433b).J4("settings");
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(ScreenMirrorService screenMirrorService, Handler handler) {
        super(handler);
        this.f4433b = screenMirrorService;
    }
}
