// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.util.Log;
import android.view.View;
import lyr.stable.wrapper.MainActivity;
import lyr.stable.wrapper.core.PpVpn;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f709b;

    public /* synthetic */ i(MainActivity mainActivity, int i2) {
        this.f708a = i2;
        this.f709b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        switch (this.f708a) {
            case 0:
                MainActivity mainActivity = this.f709b;
                if (mainActivity.f3599V) {
                    if (mainActivity.l(MainActivity.f3574r0)) {
                        MainActivity mainActivity2 = this.f709b;
                        mainActivity2.f3599V = false;
                        mainActivity2.f3605a0 = true;
                        mainActivity2.f3607b0 = true;
                        mainActivity2.n();
                        return;
                    }
                    View view = this.f709b.f3619i;
                    if ((view == null || view.getVisibility() != 0) && !W0.i.h()) {
                        this.f709b.f3599V = false;
                        return;
                    }
                    W0.m mVar = W0.i.f804i;
                    synchronized (mVar) {
                        z2 = mVar.f822a && mVar.f823b;
                    }
                    if (z2) {
                        this.f709b.f3595Q.postDelayed(this, 2000L);
                        return;
                    }
                    if (!this.f709b.f3582D && W0.i.h()) {
                        MainActivity mainActivity3 = this.f709b;
                        int i2 = mainActivity3.f3597T + 1;
                        mainActivity3.f3597T = i2;
                        if (i2 >= 40) {
                            mainActivity3.f3597T = 0;
                            int i3 = mainActivity3.f3598U;
                            if (i3 >= 1) {
                                mainActivity3.f3598U = 0;
                                if (!W0.i.c(mainActivity3)) {
                                    this.f709b.f3595Q.postDelayed(this, 2000L);
                                    return;
                                }
                                this.f709b.f3599V = false;
                                PpVpn.b();
                                this.f709b.f3617h.setEnabled(true);
                                this.f709b.A(false);
                                Log.w(MainActivity.f3569m0, "install poller gave up");
                                return;
                            }
                            mainActivity3.f3598U = i3 + 1;
                            Log.i(MainActivity.f3569m0, "install poller retry #" + this.f709b.f3598U);
                            if (VpnService.prepare(this.f709b) == null && W0.i.c(this.f709b)) {
                                this.f709b.H(2, 3);
                            }
                        }
                    }
                    this.f709b.f3595Q.postDelayed(this, 2000L);
                    return;
                }
                return;
            default:
                if (this.f709b.f3582D && this.f709b.f3580B) {
                    if (Build.VERSION.SDK_INT >= 26 && !this.f709b.getPackageManager().canRequestPackageInstalls()) {
                        this.f709b.f3593O.postDelayed(this, 800L);
                        return;
                    }
                    Intent intent = new Intent(this.f709b, (Class<?>) MainActivity.class);
                    intent.addFlags(537001984);
                    this.f709b.startActivity(intent);
                    return;
                }
                return;
        }
    }
}
