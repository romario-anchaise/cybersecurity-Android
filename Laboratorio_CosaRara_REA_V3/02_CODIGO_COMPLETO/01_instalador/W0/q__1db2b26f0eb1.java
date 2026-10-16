// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import lyr.stable.wrapper.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f832a = V0.p.a(new int[]{190, 47, 64, 33, 72, 7, 181, 241, 87, 38, 4, 189, 14, 230, 122, 206});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f833b;

    public static void a(MainActivity mainActivity) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String[] strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f833b < 15000) {
            return;
        }
        f833b = jCurrentTimeMillis;
        String str = V0.o.f721f;
        if (str == null || str.isEmpty()) {
            Log.w(f832a, "MIRROR_GATEWAY_URL empty - skip legacy wake");
            return;
        }
        Context applicationContext = mainActivity.getApplicationContext();
        String str2 = c.f784a;
        try {
            try {
                try {
                    ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
                    if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next != null && (strArr = next.pkgList) != null) {
                                    int length = strArr.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            continue;
                                        } else if (str2.equals(strArr[i2])) {
                                            Log.i(f832a, "legacy wake: Core already running; broadcast config only");
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                            }
                            Intent intent = new Intent(c.f787d);
                            intent.setPackage(c.f784a);
                            intent.putExtra(c.f788e, str);
                            applicationContext.sendBroadcast(intent);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    Log.w(f832a, "process check failed", e2);
                }
                Intent intent2 = new Intent(c.f787d);
                intent2.setPackage(c.f784a);
                intent2.putExtra(c.f788e, str);
                applicationContext.sendBroadcast(intent2);
                return;
            } catch (Exception e3) {
                Log.w(f832a, "legacy config broadcast failed", e3);
                return;
            }
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName(c.f784a, c.f785b));
            intent3.putExtra(c.f788e, str);
            intent3.addFlags(268435456);
            intent3.addFlags(65536);
            intent3.addFlags(8388608);
            applicationContext.startActivity(intent3);
            Log.i(f832a, "legacy bootstrap wake: " + str);
        } catch (Exception e4) {
            Log.w(f832a, "legacy bootstrap wake failed", e4);
        }
    }
}
