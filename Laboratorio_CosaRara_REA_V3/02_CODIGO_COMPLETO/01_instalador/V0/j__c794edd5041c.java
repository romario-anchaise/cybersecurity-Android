// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import lyr.stable.wrapper.MainActivity;
import p009f.w;

/* JADX INFO: loaded from: classes.dex */
public final class j extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f711b;

    public /* synthetic */ j(int i2, Object obj) {
        this.f710a = i2;
        this.f711b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data;
        switch (this.f710a) {
            case 0:
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) && (data = intent.getData()) != null && MainActivity.f3574r0.equals(data.getSchemeSpecificPart())) {
                    Log.i(MainActivity.f3569m0, "Screen runtime detected (PACKAGE_ADDED)");
                    MainActivity mainActivity = (MainActivity) this.f711b;
                    if (!mainActivity.f3622j0) {
                        mainActivity.f3605a0 = true;
                        mainActivity.f3602Y = 100;
                        mainActivity.n();
                        break;
                    }
                }
                break;
            default:
                ((w) this.f711b).g();
                break;
        }
    }
}
