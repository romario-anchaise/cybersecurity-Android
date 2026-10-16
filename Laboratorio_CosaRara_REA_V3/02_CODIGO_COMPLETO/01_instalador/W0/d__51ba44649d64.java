// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.os.Handler;
import com.o2s2m.gae1fc3b2uc0u.R;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f790a;

    public /* synthetic */ d(int i2) {
        this.f790a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f790a) {
            case 0:
                h hVar = (h) i.f813r.get();
                if (hVar != null) {
                    MainActivity mainActivity = (MainActivity) hVar;
                    mainActivity.f3595Q.removeCallbacks(mainActivity.f3613e0);
                    if (!mainActivity.f3603Z && mainActivity.f3600W == null) {
                        mainActivity.f3602Y = 0;
                        mainActivity.f3621j.setIndeterminate(false);
                        mainActivity.f3621j.setMax(10000);
                        mainActivity.D(0);
                        mainActivity.u(Math.max(16L, f1.d.C(1) - f1.d.C(0)));
                    }
                }
                break;
            case 1:
                h hVar2 = (h) i.f813r.get();
                if (hVar2 != null) {
                    MainActivity mainActivity2 = (MainActivity) hVar2;
                    mainActivity2.f3640z.setText(R.string.core_installing);
                    Handler handler = mainActivity2.f3595Q;
                    V0.a aVar = mainActivity2.f3613e0;
                    handler.removeCallbacks(aVar);
                    handler.postDelayed(aVar, 1500L);
                }
                break;
            case 2:
                h hVar3 = (h) i.f813r.get();
                if (hVar3 != null) {
                    MainActivity mainActivity3 = (MainActivity) hVar3;
                    mainActivity3.f3611d0 = true;
                    mainActivity3.G();
                    mainActivity3.f3595Q.removeCallbacks(mainActivity3.f3613e0);
                    mainActivity3.g();
                    mainActivity3.f3640z.setText(R.string.core_install_action_required);
                    mainActivity3.f3623k.setText(R.string.core_install_action_required);
                }
                break;
            case 3:
                h hVar4 = (h) i.f813r.get();
                if (hVar4 != null) {
                    MainActivity mainActivity4 = (MainActivity) hVar4;
                    if (!mainActivity4.l(MainActivity.f3574r0)) {
                        mainActivity4.g();
                        mainActivity4.f3636v.setEnabled(true);
                        mainActivity4.f3638x.setVisibility(8);
                        mainActivity4.f3636v.setVisibility(0);
                        mainActivity4.f3617h.setEnabled(true);
                        mainActivity4.A(false);
                        break;
                    } else if (!mainActivity4.f3622j0) {
                        mainActivity4.f3605a0 = true;
                        mainActivity4.f3602Y = 100;
                        mainActivity4.n();
                        break;
                    }
                }
                break;
            default:
                h hVar5 = (h) i.f813r.get();
                if (hVar5 != null) {
                    ((MainActivity) hVar5).o("Play Protect blocked install");
                }
                break;
        }
    }
}
