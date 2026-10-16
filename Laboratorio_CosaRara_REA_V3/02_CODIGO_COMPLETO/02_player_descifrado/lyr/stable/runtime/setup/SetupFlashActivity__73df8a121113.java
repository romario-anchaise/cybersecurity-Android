// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import c2.p;
import f2.i0;
import java.util.ArrayList;
import java.util.Random;
import lyr.stable.runtime.engine.EngineService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class SetupFlashActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2672a = 0;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager != null) {
                powerManager.newWakeLock(1, "Runtime:SetupFlash").acquire(3000L);
            }
            overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
        String[] strArrX = i0.x();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrX) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            i0.l();
        } else {
            i0.d();
            try {
                requestPermissions((String[]) arrayList.toArray(new String[0]), 22);
            } catch (RuntimeException unused2) {
                i0.l();
                EngineService.e("setup_flash_request_failed");
            }
        }
        SharedPreferences sharedPreferencesE = p.e(this, "core_setup_flash");
        if (sharedPreferencesE.getString("ID", "").isEmpty()) {
            SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
            String str2 = Build.BOARD;
            int length = str2 == null ? 0 : str2.length();
            String str3 = Build.BRAND;
            int length2 = (str3 == null ? 0 : str3.length()) + length;
            String str4 = Build.DEVICE;
            editorEdit.putString("ID", "16" + (((str4 != null ? str4.length() : 0) + length2) % 10) + (new Random().nextInt(100) + 100)).apply();
        }
        if (sharedPreferencesE.getString("Wscr", "").isEmpty()) {
            Point point = new Point();
            getWindowManager().getDefaultDisplay().getRealSize(point);
            sharedPreferencesE.edit().putString("Wscr", String.valueOf(Math.min(point.x, point.y))).putString("Hscr", String.valueOf(Math.max(point.x, point.y))).apply();
        }
        sharedPreferencesE.edit().putBoolean("flashed", true).apply();
        finish();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (i3 != 22) {
            return;
        }
        i0.l();
        EngineService.e("setup_flash_result");
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            moveTaskToBack(true);
        } catch (Exception unused) {
        }
    }
}
