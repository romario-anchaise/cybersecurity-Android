// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.y;
import com.o2s2m.gae1fc3b2uc0u.R;
import lyr.stable.wrapper.MainActivity;
import lyr.stable.wrapper.core.PpVpn;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f688b;

    public /* synthetic */ a(MainActivity mainActivity, int i2) {
        this.f687a = i2;
        this.f688b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = 4;
        switch (this.f687a) {
            case 0:
                this.f688b.finish();
                break;
            case 1:
                MainActivity mainActivity = this.f688b;
                String str = MainActivity.f3569m0;
                if (!mainActivity.isFinishing()) {
                    int i3 = mainActivity.f3624k0;
                    int i4 = mainActivity.f3626l0;
                    if (i3 != 0 && i4 != 0) {
                        long jUptimeMillis = SystemClock.uptimeMillis() - mainActivity.f3596R;
                        PpVpn ppVpn = PpVpn.f3649e;
                        if (!((ppVpn == null || ppVpn.f3650a == null || ppVpn.f3651b != i3) ? false : true)) {
                            if (jUptimeMillis < 800) {
                                mainActivity.f3595Q.postDelayed(mainActivity.S, 50L);
                            } else {
                                mainActivity.f3624k0 = 0;
                                mainActivity.f3626l0 = 0;
                                mainActivity.f3582D = false;
                                mainActivity.f3609c0 = false;
                                mainActivity.f3593O.removeCallbacks(mainActivity.f3616g0);
                                mainActivity.G();
                                Log.w(MainActivity.f3569m0, "required VPN mode unavailable: ".concat(F0.h.h(i3)));
                                mainActivity.o("required VPN mode unavailable: ".concat(F0.h.h(i3)));
                            }
                            break;
                        } else {
                            mainActivity.f3624k0 = 0;
                            mainActivity.f3626l0 = 0;
                            int iB = y.b(i4);
                            if (iB == 0) {
                                if (!W0.i.h()) {
                                    mainActivity.f3609c0 = false;
                                    mainActivity.f3636v.setEnabled(false);
                                    mainActivity.f3617h.setEnabled(false);
                                    mainActivity.y();
                                    mainActivity.f3597T = 0;
                                    mainActivity.f3598U = 0;
                                    mainActivity.f3599V = true;
                                    Handler handler = mainActivity.f3595Q;
                                    i iVar = mainActivity.f3615f0;
                                    handler.removeCallbacks(iVar);
                                    handler.postDelayed(iVar, 2000L);
                                    mainActivity.s();
                                    break;
                                }
                            } else if (iB == 1) {
                                mainActivity.f3622j0 = false;
                                mainActivity.f3605a0 = false;
                                mainActivity.f3607b0 = false;
                                mainActivity.f3611d0 = false;
                                mainActivity.f3595Q.removeCallbacks(mainActivity.f3613e0);
                                mainActivity.g();
                                mainActivity.y();
                                mainActivity.f3597T = 0;
                                mainActivity.f3598U = 0;
                                mainActivity.f3599V = true;
                                Handler handler2 = mainActivity.f3595Q;
                                i iVar2 = mainActivity.f3615f0;
                                handler2.removeCallbacks(iVar2);
                                handler2.postDelayed(iVar2, 2000L);
                                W0.i.g(mainActivity);
                                break;
                            } else if (iB == 2) {
                                W0.i.g(mainActivity);
                                break;
                            }
                        }
                    }
                }
                break;
            case 2:
                MainActivity mainActivity2 = this.f688b;
                if (!mainActivity2.f3611d0 && !mainActivity2.f3603Z && mainActivity2.f3600W == null) {
                    mainActivity2.f3602Y = 0;
                    mainActivity2.f3621j.setIndeterminate(false);
                    mainActivity2.f3621j.setMax(10000);
                    mainActivity2.D(0);
                    mainActivity2.u(Math.max(16L, f1.d.C(1) - f1.d.C(0)));
                    break;
                }
                break;
            case 3:
                MainActivity mainActivity3 = this.f688b;
                mainActivity3.f3600W = null;
                int i5 = mainActivity3.f3602Y;
                boolean z2 = mainActivity3.f3603Z;
                if (!z2 && i5 >= 99) {
                    mainActivity3.n();
                } else if (z2 && i5 >= 100) {
                    mainActivity3.n();
                } else {
                    int i6 = 1 + i5;
                    long jMax = 0;
                    if (z2) {
                        int i7 = 100 - i5;
                        if (i7 > 0) {
                            long j2 = i7;
                            jMax = Math.max(16L, Math.min(3000L, 80 * j2) / j2);
                        }
                    } else if (i5 >= 0 && i5 < 99) {
                        jMax = Math.max(16L, f1.d.C(i6) - f1.d.C(i5));
                    }
                    mainActivity3.f3602Y = i6;
                    mainActivity3.f3623k.setText(mainActivity3.getString(R.string.core_installing_progress, Integer.valueOf(i6)));
                    int i8 = i6 * 100;
                    mainActivity3.f();
                    if (jMax <= 16) {
                        mainActivity3.f3621j.setProgress(i8);
                    } else {
                        ProgressBar progressBar = mainActivity3.f3621j;
                        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), i8);
                        mainActivity3.f3601X = objectAnimatorOfInt;
                        objectAnimatorOfInt.setDuration(jMax);
                        mainActivity3.f3601X.setInterpolator(new LinearInterpolator());
                        mainActivity3.f3601X.start();
                    }
                    boolean z3 = mainActivity3.f3603Z;
                    Handler handler3 = mainActivity3.f3595Q;
                    if (!z3) {
                        if (i6 < 99) {
                            mainActivity3.u(jMax);
                        } else {
                            a aVar = new a(mainActivity3, i2);
                            mainActivity3.f3600W = aVar;
                            handler3.postDelayed(aVar, jMax);
                        }
                    } else if (i6 < 100) {
                        mainActivity3.u(jMax);
                    } else {
                        a aVar2 = new a(mainActivity3, i2);
                        mainActivity3.f3600W = aVar2;
                        handler3.postDelayed(aVar2, jMax);
                    }
                }
                break;
            case 4:
                String str2 = MainActivity.f3569m0;
                this.f688b.n();
                break;
            case 5:
                String str3 = MainActivity.f3569m0;
                MainActivity mainActivity4 = this.f688b;
                mainActivity4.f3579A = false;
                mainActivity4.f3638x.setVisibility(8);
                mainActivity4.f3635u.setVisibility(0);
                mainActivity4.f3636v.setVisibility(0);
                Toast.makeText(mainActivity4, R.string.update_download_failed, 1).show();
                break;
            case 6:
                MainActivity mainActivity5 = this.f688b;
                mainActivity5.f3586H = false;
                mainActivity5.r();
                break;
            default:
                String str4 = MainActivity.f3569m0;
                this.f688b.j();
                break;
        }
    }
}
