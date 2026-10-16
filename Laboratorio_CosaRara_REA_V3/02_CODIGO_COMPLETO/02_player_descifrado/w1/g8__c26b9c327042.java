// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g8 implements AutoCloseable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Handler f4118j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f4119k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccessibilityService f4120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View[] f4121d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4125h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f8 f4122e = new f8(this, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a2.i f4123f = new a2.i(15, this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4126i = true;

    public g8(AccessibilityService accessibilityService, View[] viewArr) {
        this.f4120c = accessibilityService;
        this.f4121d = viewArr;
    }

    public static int A(WindowManager windowManager) {
        if (windowManager == null) {
            return -1;
        }
        try {
            return windowManager.getCurrentWindowMetrics().getBounds().height();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void C(View view) {
        if (view == null) {
            return;
        }
        view.setFitsSystemWindows(false);
        view.setSystemUiVisibility(5894);
    }

    public static g8 w(AccessibilityService accessibilityService, View... viewArr) {
        View[] viewArr2 = (View[]) viewArr.clone();
        final g8 g8Var = new g8(accessibilityService, viewArr2);
        for (View view : viewArr2) {
            if (view != null) {
                C(view);
                view.setOnApplyWindowInsetsListener(new f2.c(1, g8Var));
                view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: w1.e8
                    @Override // android.view.View.OnSystemUiVisibilityChangeListener
                    public final void onSystemUiVisibilityChange(int i3) {
                        if ((i3 & 5894) != 5894) {
                            this.f3901a.D();
                        }
                    }
                });
            }
        }
        f4118j.post(g8Var.f4123f);
        return g8Var;
    }

    public static void y(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags |= 1792;
        layoutParams.layoutInDisplayCutoutMode = 3;
        layoutParams.setFitInsetsTypes(0);
    }

    public final void B(CharSequence charSequence) {
        if (this.f4124g) {
            return;
        }
        if (charSequence != null && charSequence.toString().toLowerCase(Locale.ROOT).contains("systemui")) {
            z();
        }
        D();
    }

    public final void D() {
        if (this.f4124g) {
            return;
        }
        Handler handler = f4118j;
        f8 f8Var = this.f4122e;
        handler.removeCallbacks(f8Var);
        handler.postDelayed(f8Var, 16L);
    }

    public final void E(boolean z2) {
        this.f4126i = z2;
        if (!z2 || this.f4124g) {
            return;
        }
        f4118j.post(new f8(this, 0));
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f4124g) {
            return;
        }
        this.f4124g = true;
        f8 f8Var = this.f4122e;
        Handler handler = f4118j;
        handler.removeCallbacks(f8Var);
        handler.removeCallbacks(this.f4123f);
        for (View view : this.f4121d) {
            if (view != null) {
                try {
                    view.setOnApplyWindowInsetsListener(null);
                    view.setOnSystemUiVisibilityChangeListener(null);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void d(boolean z2) {
        if (this.f4124g) {
            return;
        }
        for (View view : this.f4121d) {
            if (view != null) {
                view.setSystemUiVisibility(5894);
                try {
                    WindowInsetsController windowInsetsController = view.getWindowInsetsController();
                    if (windowInsetsController != null) {
                        windowInsetsController.setSystemBarsBehavior(2);
                        windowInsetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (z2) {
            z();
        }
    }

    public final void z() {
        if (!this.f4126i || Build.VERSION.SDK_INT < 31 || this.f4120c == null) {
            return;
        }
        synchronized (q1.f4884b) {
            try {
                if (q1.f4886d > 0) {
                    return;
                }
                if (q1.f4887e > 0) {
                    if (SystemClock.elapsedRealtime() <= q1.f4887e) {
                        return;
                    } else {
                        q1.f4887e = 0L;
                    }
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = f4119k;
                if (j3 <= 0 || jElapsedRealtime - j3 >= 750) {
                    f4119k = jElapsedRealtime;
                    try {
                        this.f4120c.performGlobalAction(15);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
