// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.List;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f814a = V0.p.a(new int[]{176, 41, 64, 54, 107, 20, 151, 254, 95, 43, 41, 170});

    public static void a(MainActivity mainActivity) {
        ResolveInfo resolveInfo;
        ActivityInfo activityInfo;
        String str = f814a;
        try {
            Intent launchIntentForPackage = mainActivity.getPackageManager().getLaunchIntentForPackage(c.f784a);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                mainActivity.startActivity(launchIntentForPackage);
                Log.i(str, "launchB step1 launch-intent");
                return;
            }
        } catch (Exception e2) {
            Log.w(str, "launchB step1 failed", e2);
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(c.f784a);
            intent.addFlags(268435456);
            List<ResolveInfo> listQueryIntentActivities = mainActivity.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                mainActivity.startActivity(intent);
                Log.i(str, "launchB step2 MAIN+package");
                return;
            }
        } catch (Exception e3) {
            Log.w(str, "launchB step2 failed", e3);
        }
        try {
            Intent intent2 = new Intent();
            String str2 = c.f784a;
            intent2.setPackage(str2);
            intent2.addFlags(268435456);
            List<ResolveInfo> listQueryIntentActivities2 = mainActivity.getPackageManager().queryIntentActivities(intent2, 512);
            if (listQueryIntentActivities2 != null && !listQueryIntentActivities2.isEmpty() && (resolveInfo = listQueryIntentActivities2.get(0)) != null && (activityInfo = resolveInfo.activityInfo) != null) {
                intent2.setClassName(str2, activityInfo.name);
                mainActivity.startActivity(intent2);
                Log.i(str, "launchB step3 " + resolveInfo.activityInfo.name);
                return;
            }
        } catch (Exception e4) {
            Log.w(str, "launchB step3 failed", e4);
        }
        try {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.parse("package:" + c.f784a));
            intent3.addFlags(268435456);
            mainActivity.startActivity(intent3);
            Log.i(str, "launchB step4 details");
        } catch (Exception e5) {
            Log.w(str, "launchB step4 failed", e5);
        }
    }
}
