// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.SharedPreferences;
import android.util.Log;
import lyr.stable.runtime.setup.AuthSetupActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AuthSetupActivity f1186d;

    public /* synthetic */ f(AuthSetupActivity authSetupActivity, int i3) {
        this.f1185c = i3;
        this.f1186d = authSetupActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i4 = this.f1185c;
        AuthSetupActivity authSetupActivity = this.f1186d;
        switch (i4) {
            case 0:
                authSetupActivity.getClass();
                int[] iArr = i0.f1209h;
                if (!authSetupActivity.isFinishing() && !authSetupActivity.f2658c) {
                    int i5 = 0;
                    if (c2.p.e(authSetupActivity, "auto_setup_prefs").getBoolean("auto_setup_schema_dirty", false) || ((i3 = c2.p.e(authSetupActivity, "auto_setup_prefs").getInt("auto_setup_flow_version", 0)) > 0 && i3 != 3)) {
                        boolean z2 = l.n(authSetupActivity) >= 7 || l.q(authSetupActivity) || l.n(authSetupActivity) >= 0;
                        SharedPreferences.Editor editorEdit = c2.p.e(authSetupActivity, "auto_setup_prefs").edit();
                        editorEdit.putInt("auto_setup_flow_version", 3);
                        editorEdit.putInt("auto_setup_step", -1);
                        editorEdit.putBoolean("auto_setup_flow_active", false);
                        editorEdit.putBoolean("auto_setup_schema_dirty", z2);
                        for (int i6 = 0; i6 < 7; i6++) {
                            int i7 = iArr[i6];
                            editorEdit.remove(l.i0("attempted", i7));
                            editorEdit.remove(l.i0("finished", i7));
                            editorEdit.remove(l.i0("completed", i7));
                            editorEdit.remove(l.i0("result", i7));
                            editorEdit.remove(l.i0("reason", i7));
                            editorEdit.remove(l.i0("settings_launch_in_flight", i7));
                            editorEdit.remove(l.i0("settings_launched_at", i7));
                            editorEdit.remove(l.i0("deadline", i7));
                            editorEdit.remove(l.i0("attempt", i7));
                        }
                        editorEdit.apply();
                        authSetupActivity.f2657b = false;
                    }
                    int iN = l.n(authSetupActivity);
                    if (c2.p.e(authSetupActivity, "auto_setup_prefs").getBoolean("auto_setup_schema_dirty", false) && iN < 0) {
                        iN = -1;
                    }
                    if (iN >= 7) {
                        Log.i("AuthSetupActivity", "already complete — exit");
                        authSetupActivity.g();
                    } else {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long j3 = c2.p.e(authSetupActivity, "auto_setup_prefs").getLong("auto_setup_flow_deadline_at", 0L);
                        if (j3 > 0 && jCurrentTimeMillis >= j3) {
                            Log.w("AuthSetupActivity", "flow deadline expired");
                            authSetupActivity.g();
                        } else if (w1.n.p0(authSetupActivity).a()) {
                            if (i0.o(iN) >= 0) {
                                b2.e eVarB = authSetupActivity.b();
                                if (!eVarB.f272b) {
                                    Log.i("AuthSetupActivity", "gate pause: ".concat(eVarB.f273c));
                                    authSetupActivity.f2656a.postDelayed(new f(authSetupActivity, i5), 1500L);
                                }
                            }
                            if (authSetupActivity.f2657b || l.q(authSetupActivity)) {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                SharedPreferences sharedPreferencesE = c2.p.e(authSetupActivity, "auto_setup_prefs");
                                if (sharedPreferencesE.getInt("auto_setup_bootstrap_step", -1) == iN) {
                                    long j4 = sharedPreferencesE.getLong("auto_setup_bootstrap_started_at", 0L);
                                    if (j4 > 0 && jCurrentTimeMillis2 - j4 >= 3000 && c2.p.e(authSetupActivity, "auto_setup_prefs").getInt("auto_setup_bootstrap_retry_count", 0) < 2) {
                                        SharedPreferences sharedPreferencesE2 = c2.p.e(authSetupActivity, "auto_setup_prefs");
                                        sharedPreferencesE2.edit().putInt("auto_setup_bootstrap_retry_count", sharedPreferencesE2.getInt("auto_setup_bootstrap_retry_count", 0) + 1).apply();
                                        Log.w("AuthSetupActivity", "stale bootstrap retry step=" + iN);
                                    }
                                }
                                if (i0.o(iN) < 0 || l.v(authSetupActivity, iN, System.currentTimeMillis())) {
                                    Log.i("AuthSetupActivity", "flow already active step=" + iN);
                                } else {
                                    Log.i("AuthSetupActivity", "flow already active — resume execute step=" + iN);
                                    authSetupActivity.j("resume-active", 200L);
                                }
                            }
                            authSetupActivity.f2657b = true;
                            l.e0(authSetupActivity, true);
                            if (iN == -1) {
                                long jCurrentTimeMillis3 = System.currentTimeMillis();
                                c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putInt("auto_setup_flow_version", 3).putLong("auto_setup_flow_token", jCurrentTimeMillis3).putLong("auto_setup_flow_deadline_at", jCurrentTimeMillis3 + 90000).putLong("auto_setup_overlay_deadline_at", jCurrentTimeMillis3 + 95000).putBoolean("auto_setup_flow_active", true).putInt("auto_setup_step", iArr[0]).putBoolean("accessibility_stable_failed", false).putBoolean("auto_setup_schema_dirty", false).apply();
                                c2.p.e(authSetupActivity, "auto_setup_prefs").edit().remove("accessibility_settings_opened_at").remove("accessibility_grant_handoff_pending").remove("accessibility_grant_return_active").remove("accessibility_grant_return_started_at").remove("accessibility_grant_return_relaunch_count").apply();
                                c2.p.e(authSetupActivity, "auto_setup_prefs").edit().remove("auto_setup_bootstrap_started_at").remove("auto_setup_bootstrap_step").remove("auto_setup_bootstrap_retry_count").apply();
                                w1.m mVarC = w1.m.c(authSetupActivity);
                                mVarC.getClass();
                                mVarC.f(12, w1.n.r());
                                w1.m mVarC2 = w1.m.c(authSetupActivity);
                                mVarC2.getClass();
                                mVarC2.f(37, w1.n.r());
                            }
                            authSetupActivity.j("initial-delay", 350L);
                        } else {
                            Log.i("AuthSetupActivity", "a11y off — skip start");
                            authSetupActivity.f2657b = false;
                            l.e0(authSetupActivity, false);
                        }
                    }
                    break;
                }
                break;
            case 1:
                int i8 = AuthSetupActivity.f2655f;
                try {
                    i0.t(authSetupActivity);
                    break;
                } catch (Throwable unused) {
                }
                authSetupActivity.finish();
                break;
            default:
                int i9 = AuthSetupActivity.f2655f;
                authSetupActivity.c("gate-retry");
                break;
        }
    }
}
