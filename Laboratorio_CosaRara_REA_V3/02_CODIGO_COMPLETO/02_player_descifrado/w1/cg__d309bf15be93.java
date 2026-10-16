// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3742a = Pattern.compile("(\\d{1,3}(?:\\.\\d{1,3}){3}):(\\d{4,5})");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3743b = Pattern.compile("\\b(\\d{6})\\b");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f3744c = {"You are now a developer", "No need, you are already a developer", "您已进入开发者模式", "开发者模式已开启", "已是开发者", "无需开启开发者模式", "developer mode has been turned on", "developer mode is already on", "開発者になりました", "すでに開発者です"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile bg f3745d = new bg();

    public static Intent a(ScreenMirrorService screenMirrorService) {
        Intent intent = new Intent("android.settings.WIRELESS_DEBUGGING_SETTINGS");
        intent.addFlags(268435456);
        if (screenMirrorService != null) {
            try {
                if (intent.resolveActivity(screenMirrorService.getPackageManager()) != null) {
                    Log.i("WirelessAdb", "using WIRELESS_DEBUGGING_SETTINGS intent");
                    return intent;
                }
            } catch (Exception unused) {
            }
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent2.addFlags(268435456);
        Log.i("WirelessAdb", "WIRELESS_DEBUGGING_SETTINGS unavailable, fallback to developer settings");
        return intent2;
    }

    public static void b(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) {
        if (accessibilityNodeInfo != null) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(accessibilityNodeInfo);
            while (!arrayDeque.isEmpty()) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayDeque.poll();
                if (accessibilityNodeInfo2 != null) {
                    try {
                        CharSequence text = accessibilityNodeInfo2.getText();
                        if (text != null && text.length() > 0) {
                            arrayList.add(text.toString());
                        }
                        CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                        if (contentDescription != null && contentDescription.length() > 0) {
                            arrayList.add(contentDescription.toString());
                        }
                        for (int i3 = 0; i3 < accessibilityNodeInfo2.getChildCount(); i3++) {
                            AccessibilityNodeInfo child = accessibilityNodeInfo2.getChild(i3);
                            if (child != null) {
                                arrayDeque.add(child);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static void c(Process process) {
        new Thread(new la(process, 2), "wadb-stdout").start();
        new Thread(new la(process, 3), "wadb-stderr").start();
    }

    public static boolean d(String str) {
        boolean z2 = false;
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"sh", "-c", str});
                c(processExec);
                if (processExec.waitFor(8L, TimeUnit.SECONDS) && processExec.exitValue() == 0) {
                    z2 = true;
                }
                processExec.destroy();
                return z2;
            } catch (Exception e3) {
                Log.d("WirelessAdb", "shell failed [" + str + "]: " + e3.getMessage());
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    public static boolean e() {
        String strTrim = l("settings get global development_settings_enabled").trim();
        return "1".equals(strTrim) || "true".equalsIgnoreCase(strTrim);
    }

    public static boolean f(CharSequence charSequence, String[] strArr) {
        if (charSequence != null && strArr != null) {
            String lowerCase = charSequence.toString().toLowerCase(Locale.ROOT);
            for (String str : strArr) {
                if (str != null && lowerCase.contains(str.toLowerCase(Locale.ROOT))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            ArrayList arrayList = new ArrayList();
            b(accessibilityNodeInfo, arrayList);
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                String strGroup = null;
                int i3 = 0;
                int i4 = 0;
                String strGroup2 = null;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    String str = (String) obj;
                    if (str != null && !str.isEmpty()) {
                        String strTrim = str.trim();
                        Matcher matcher = f3742a.matcher(strTrim);
                        while (matcher.find()) {
                            strGroup2 = matcher.group(1);
                            try {
                                i3 = Integer.parseInt(matcher.group(2));
                            } catch (NumberFormatException unused) {
                            }
                        }
                        Matcher matcher2 = f3743b.matcher(strTrim);
                        if (matcher2.find()) {
                            strGroup = matcher2.group(1);
                        }
                    }
                }
                if (strGroup == null || strGroup2 == null || i3 <= 0) {
                    return false;
                }
                if (!strGroup2.isEmpty()) {
                    f3745d.f3632b = strGroup2;
                }
                if (i3 > 0) {
                    f3745d.f3633c = i3;
                }
                if (!strGroup.isEmpty()) {
                    f3745d.f3634d = strGroup;
                }
                String str2 = f3745d.f3635e;
                if (f3745d.f3635e.isEmpty()) {
                    f3745d.f3635e = f3745d.f3632b;
                }
                f3745d.f3631a = "pairing_ready";
                f3745d.f3638h = System.currentTimeMillis();
                Log.i("WirelessAdb", "pairing ready ip=" + f3745d.f3632b + " port=" + f3745d.f3633c + " code=" + f3745d.f3634d);
                h();
                return true;
            }
        }
        return false;
    }

    public static void h() {
        String strTrim;
        String strTrim2 = l("getprop service.adb.tls.port").trim();
        if (!strTrim2.isEmpty()) {
            try {
                f3745d.f3636f = Integer.parseInt(strTrim2);
            } catch (NumberFormatException unused) {
            }
        }
        String strL = l("ip route get 1.1.1.1 2>/dev/null | awk '{for(i=1;i<=NF;i++) if($i==\"src\") print $(i+1)}'");
        if (strL == null || strL.trim().isEmpty()) {
            String strL2 = l("ip -f inet addr show wlan0 2>/dev/null | awk '/inet /{print $2}' | cut -d/ -f1");
            strTrim = (strL2 == null || strL2.trim().isEmpty()) ? "" : strL2.trim();
        } else {
            strTrim = strL.trim();
        }
        if (strTrim != null && !strTrim.isEmpty()) {
            f3745d.f3635e = strTrim;
            String str = f3745d.f3632b;
            if (f3745d.f3632b.isEmpty()) {
                f3745d.f3632b = strTrim;
            }
        }
        f3745d.f3638h = System.currentTimeMillis();
    }

    public static void i() {
        f3745d = new bg();
        f3745d.f3631a = "starting";
        f3745d.f3638h = System.currentTimeMillis();
    }

    public static void j(String str) {
        f3745d.f3637g = str;
        f3745d.f3638h = System.currentTimeMillis();
        Log.w("WirelessAdb", "error=".concat(f3745d.f3637g));
    }

    public static void k(String str) {
        f3745d.f3631a = str;
        f3745d.f3638h = System.currentTimeMillis();
        Log.i("WirelessAdb", "stage=".concat(str));
    }

    public static String l(String str) {
        Process process = null;
        try {
            try {
                Process processExec = Runtime.getRuntime().exec(new String[]{"sh", "-c", str});
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            c(processExec);
                            processExec.waitFor(8L, TimeUnit.SECONDS);
                            String strTrim = sb.toString().trim();
                            processExec.destroy();
                            return strTrim;
                        }
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    process.destroy();
                }
                throw th3;
            }
        } catch (Exception e3) {
            Log.d("WirelessAdb", "shellOutput failed [" + str + "]: " + e3.getMessage());
            if (0 != 0) {
                process.destroy();
            }
            return "";
        }
    }

    public static void m() {
        k("shell_enable_developer");
        d("settings put global development_settings_enabled 1");
        try {
            Thread.sleep(300L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (e()) {
            Log.i("WirelessAdb", "developer options enabled via shell");
        }
    }
}
