// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j4 {
    public static int a(Context context) {
        if (context == null) {
            return 5;
        }
        String packageName = context.getPackageName();
        String str = "";
        String processName = Application.getProcessName();
        if (processName == null || processName.isEmpty()) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
                if (runningAppProcesses != null) {
                    int iMyPid = Process.myPid();
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                            String str2 = runningAppProcessInfo.processName;
                            if (str2 == null) {
                                break;
                            }
                            str = str2;
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        } else {
            str = processName;
        }
        if (packageName.equals(str)) {
            return 1;
        }
        if (packageName.concat(":a11y").equals(str)) {
            return 2;
        }
        if (packageName.concat(":keepalive").equals(str)) {
            return 3;
        }
        return (packageName.concat(":assist1").equals(str) || packageName.concat(":assist2").equals(str)) ? 4 : 5;
    }

    public static int b(int i3, int i4, long j3) {
        return (Long.hashCode(j3) + i3) * i4;
    }

    public static String c(int i3, String str, String str2) {
        return str + i3 + str2;
    }

    public static void d(StringBuilder sb, String str, long j3, String str2) {
        sb.append(str);
        sb.append(j3);
        sb.append(str2);
    }

    public static /* synthetic */ String e(int i3) {
        if (i3 == 1) {
            return "RESOURCE_ID";
        }
        if (i3 == 2) {
            return "PAGE_CLASS";
        }
        if (i3 != 3) {
            return i3 != 4 ? "null" : "NONE";
        }
        return "TEXT_FALLBACK";
    }

    public static /* synthetic */ String f(int i3) {
        if (i3 == 1) {
            return "NONE";
        }
        if (i3 == 2) {
            return "LABEL";
        }
        if (i3 != 3) {
            return i3 != 4 ? "null" : "PACKAGE";
        }
        return "COMPONENT";
    }

    public static /* synthetic */ String g(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "PROJECTION";
            case 3:
                return "RUNTIME_DIALOG";
            case 4:
                return "SETTINGS_TOGGLE";
            case 5:
                return "DIALOG_CONFIRM";
            case 6:
                return "WIRELESS_ADB";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String h(int i3) {
        if (i3 == 1) {
            return "SKIP_ALREADY_LOCKED";
        }
        if (i3 == 2) {
            return "DPM_LOCK_NOW";
        }
        if (i3 != 3) {
            return i3 != 4 ? "null" : "UNAVAILABLE";
        }
        return "A11Y_LOCK_SCREEN";
    }

    public static /* synthetic */ String i(int i3) {
        switch (i3) {
            case 1:
                return "NONE";
            case 2:
                return "HELD";
            case 3:
                return "SCREEN_OFF";
            case 4:
                return "EVENT_BUDGETED";
            case 5:
                return "CLICK_CANCEL";
            case 6:
                return "BACK_CONFIRM";
            case 7:
                return "BACK_DETAIL";
            case 8:
                return "BACK_LIST";
            case 9:
                return "OFFENDING_ALREADY_HANDLED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String j(int i3) {
        if (i3 == 1) {
            return "OTHER";
        }
        if (i3 == 2) {
            return "CONFIRM_DIALOG";
        }
        if (i3 != 3) {
            return i3 != 4 ? "null" : "SERVICES_LIST";
        }
        return "OWN_DETAIL";
    }

    public static /* synthetic */ String k(int i3) {
        switch (i3) {
            case 1:
                return "APP_INFO";
            case 2:
                return "UNINSTALL";
            case 3:
                return "DISABLE";
            case 4:
                return "FORCE_STOP";
            case 5:
                return "CLEAR_DATA";
            case 6:
                return "STORAGE";
            case 7:
                return "DEVICE_ADMIN_DEACTIVATE";
            case 8:
                return "PACKAGE_INSTALLER_CONFIRM";
            case 9:
                return "SYSTEMUI_FGS_STOP";
            case 10:
                return "OEM_SECURITY_CENTER";
            case 11:
                return "NONE";
            default:
                return "null";
        }
    }
}
