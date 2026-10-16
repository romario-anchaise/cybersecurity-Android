// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.InstallSourceInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Debug;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import e2.b1;
import e2.u1;
import f2.q0;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import w1.a0;
import w1.a3;
import w1.b0;
import w1.b3;
import w1.c3;
import w1.k0;
import w1.n;
import w1.o2;
import w1.w2;
import w1.y2;
import w1.z2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f358a;

    public m(Context context, int i3) {
        Context applicationContext;
        switch (i3) {
            case 1:
                Context applicationContext2 = context.getApplicationContext();
                this.f358a = applicationContext2 != null ? applicationContext2 : context;
                return;
            case 2:
            default:
                if (context == null) {
                    o2.i("context == null");
                    throw null;
                }
                Context applicationContext3 = context.getApplicationContext();
                context = applicationContext3 != null ? applicationContext3 : context;
                if (context.isDeviceProtectedStorage()) {
                    o2.k("AppForegroundGuard requires credential-encrypted context");
                    throw null;
                }
                this.f358a = context;
                return;
            case 3:
                try {
                    applicationContext = context.getApplicationContext();
                    break;
                } catch (SecurityException | RuntimeException unused) {
                    applicationContext = null;
                }
                this.f358a = applicationContext != null ? applicationContext : context;
                return;
        }
    }

    public static String b(String str) {
        String upperCase = str == null ? "" : str.trim().toUpperCase(Locale.ROOT);
        if (upperCase.length() != 2) {
            return "";
        }
        for (int i3 = 0; i3 < upperCase.length(); i3++) {
            char cCharAt = upperCase.charAt(i3);
            if (cCharAt < 'A' || cCharAt > 'Z') {
                return "";
            }
        }
        return upperCase;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x019a A[PHI: r12 r13 r20 r47 r48 r50
  0x019a: PHI (r12v8 java.lang.String) = (r12v6 java.lang.String), (r12v9 java.lang.String) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x019a: PHI (r13v19 java.lang.String) = (r13v9 java.lang.String), (r13v20 java.lang.String) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x019a: PHI (r20v4 java.lang.Integer) = (r20v2 java.lang.Integer), (r20v5 java.lang.Integer) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x019a: PHI (r47v4 java.lang.String) = (r47v2 java.lang.String), (r47v5 java.lang.String) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x019a: PHI (r48v4 long) = (r48v2 long), (r48v5 long) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x019a: PHI (r50v17 android.content.Context) = (r50v8 android.content.Context), (r50v18 android.content.Context) binds: [B:158:0x024d, B:114:0x0190] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:147:0x022d  */
    /* JADX WARN: Code duplicated, block: B:159:0x024f  */
    /* JADX WARN: Code duplicated, block: B:161:0x0257  */
    /* JADX WARN: Code duplicated, block: B:166:0x0260  */
    /* JADX WARN: Code duplicated, block: B:167:0x0263  */
    /* JADX WARN: Code duplicated, block: B:168:0x0266  */
    /* JADX WARN: Code duplicated, block: B:169:0x0269  */
    /* JADX WARN: Code duplicated, block: B:178:0x0286  */
    /* JADX WARN: Code duplicated, block: B:189:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:193:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:194:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:197:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:200:0x02da  */
    /* JADX WARN: Code duplicated, block: B:201:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:204:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:205:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:208:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:210:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:213:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:214:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:218:0x0308 A[Catch: SecurityException | RuntimeException -> 0x0336, TryCatch #13 {SecurityException | RuntimeException -> 0x0336, blocks: (B:216:0x0300, B:218:0x0308, B:221:0x030f), top: B:333:0x0300 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x0336  */
    /* JADX WARN: Code duplicated, block: B:245:0x034d  */
    /* JADX WARN: Code duplicated, block: B:254:0x037d  */
    /* JADX WARN: Code duplicated, block: B:260:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:263:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:269:0x03c3 A[PHI: r6
  0x03c3: PHI (r6v10 java.lang.String) = 
  (r6v0 java.lang.String)
  (r6v5 java.lang.String)
  (r6v6 java.lang.String)
  (r6v7 java.lang.String)
  (r6v8 java.lang.String)
 binds: [B:268:0x03c1, B:285:0x03f6, B:284:0x03f3, B:283:0x03f0, B:282:0x03ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:273:0x03d3 A[Catch: all -> 0x03d0, TryCatch #34 {all -> 0x03d0, blocks: (B:270:0x03c6, B:273:0x03d3), top: B:363:0x03c6 }] */
    /* JADX WARN: Code duplicated, block: B:275:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:277:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:279:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:281:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:282:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:283:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:284:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:285:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:321:0x0404 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:0x034f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x023c A[EXC_TOP_SPLITTER, PHI: r11 r13 r14 r46 r50
  0x023c: PHI (r11v11 int) = (r11v10 int), (r11v12 int) binds: [B:151:0x023a, B:155:0x0248] A[DONT_GENERATE, DONT_INLINE]
  0x023c: PHI (r13v6 java.lang.String) = (r13v5 java.lang.String), (r13v8 java.lang.String) binds: [B:151:0x023a, B:155:0x0248] A[DONT_GENERATE, DONT_INLINE]
  0x023c: PHI (r14v5 w1.c3) = (r14v4 w1.c3), (r14v6 w1.c3) binds: [B:151:0x023a, B:155:0x0248] A[DONT_GENERATE, DONT_INLINE]
  0x023c: PHI (r46v4 java.util.concurrent.atomic.AtomicInteger) = (r46v3 java.util.concurrent.atomic.AtomicInteger), (r46v6 java.util.concurrent.atomic.AtomicInteger) binds: [B:151:0x023a, B:155:0x0248] A[DONT_GENERATE, DONT_INLINE]
  0x023c: PHI (r50v5 android.content.Context) = (r50v4 android.content.Context), (r50v7 android.content.Context) binds: [B:151:0x023a, B:155:0x0248] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:343:0x02b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:0x03c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e2  */
    /* JADX WARN: Instruction removed from duplicated block: B:115:0x019a, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public z2 a(String str, String str2) throws Throwable {
        String string;
        String string2;
        String string3;
        String str3;
        String str4;
        String str5;
        boolean z2;
        String str6;
        long j3;
        long j4;
        String str7;
        int i3;
        Integer numValueOf;
        Boolean boolValueOf;
        int i4;
        String str8;
        String str9;
        NetworkCapabilities networkCapabilities;
        String str10;
        byte b3;
        int i5;
        String str11;
        AtomicInteger atomicInteger;
        int i6;
        c3 c3Var;
        boolean zAwait;
        int i7;
        int dataNetworkType;
        KeyguardManager keyguardManager;
        Context context;
        String lowerCase;
        DevicePolicyManager devicePolicyManager;
        String id;
        TelephonyManager telephonyManager;
        String strB;
        String strB2;
        String string4;
        String string5;
        String str12;
        AppOpsManager appOpsManager;
        int iUnsafeCheckOpNoThrow;
        KeyguardManager keyguardManager2;
        String installingPackageName;
        String initiatingPackageName;
        String str13 = "required";
        String str14 = "password";
        String str15 = "captured_pin";
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context2 = this.f358a;
        String str16 = "";
        try {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("captured_pin", 0);
            string = sharedPreferences.getString("pin", "");
            try {
                string2 = sharedPreferences.getString("password", "");
            } catch (Throwable unused) {
                string2 = "";
            }
        } catch (Throwable unused2) {
            string = "";
        }
        try {
            string3 = context2.getSharedPreferences("unlock_seq", 0).getString("pattern_dots", "");
        } catch (Throwable unused3) {
            string3 = "";
        }
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string3 == null) {
            string3 = "";
        }
        if (string2.length() >= 4) {
            string = string2;
        }
        String[] strArr = {string, string3};
        boolean zK = n.K(context2);
        k0 k0VarP0 = n.p0(context2);
        boolean z3 = zK || k0VarP0.a();
        boolean z4 = z3 || n.C0(context2);
        try {
            q0 q0VarZ = f2.l.Z(context2);
            String str17 = q0VarZ.f1309b;
            try {
                str13 = q0VarZ.f1310c;
                str5 = str13;
                z2 = q0VarZ.f1308a;
                str4 = str17;
            } catch (Throwable unused4) {
                str3 = str13;
                str13 = str17;
                str4 = str13;
                str5 = str3;
                z2 = true;
            }
        } catch (Throwable unused5) {
            str3 = "required";
        }
        String strC = "normal";
        try {
            b1.b(context2, jCurrentTimeMillis);
            u1 u1VarI = b1.i(context2);
            strC = a0.a.c(u1VarI.f1015a);
            str6 = u1VarI.f1016b;
            try {
                j3 = u1VarI.f1017c;
            } catch (Throwable unused6) {
                j3 = 0;
            }
        } catch (Throwable unused7) {
            str6 = "";
        }
        String str18 = strC;
        String str19 = str6;
        try {
            w2 w2VarB = y2.y(context2).B();
            j4 = (w2VarB == null || !("pin".equals(w2VarB.f5386c) || "password".equals(w2VarB.f5386c))) ? 0L : w2VarB.f5388e;
        } catch (Throwable unused8) {
            j4 = 0;
        }
        try {
            str7 = Build.VERSION.RELEASE;
        } catch (RuntimeException unused9) {
            str7 = "";
        }
        try {
            i3 = Build.VERSION.SDK_INT;
        } catch (RuntimeException unused10) {
            i3 = 0;
        }
        BatteryManager batteryManager = (BatteryManager) f(BatteryManager.class);
        c3 c3Var2 = null;
        boolValueOf = null;
        Boolean boolValueOf2 = null;
        if (batteryManager == null) {
            numValueOf = null;
        } else {
            try {
                int intProperty = batteryManager.getIntProperty(4);
                if (intProperty < 0 || intProperty > 100) {
                    numValueOf = null;
                } else {
                    numValueOf = Integer.valueOf(intProperty);
                }
            } catch (SecurityException | RuntimeException unused11) {
            }
        }
        BatteryManager batteryManager2 = (BatteryManager) f(BatteryManager.class);
        if (batteryManager2 == null) {
            boolValueOf = null;
        } else {
            try {
                boolValueOf = Boolean.valueOf(batteryManager2.isCharging());
            } catch (SecurityException | RuntimeException unused12) {
                boolValueOf = null;
            }
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) f(ConnectivityManager.class);
        try {
            try {
                try {
                    try {
                        try {
                            if (connectivityManager != null) {
                                i4 = i3;
                                try {
                                    Network activeNetwork = connectivityManager.getActiveNetwork();
                                    if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                                        str9 = "none";
                                    } else {
                                        try {
                                            if (networkCapabilities.hasTransport(1)) {
                                                str10 = "unknown";
                                                b3 = 1;
                                            } else {
                                                str10 = "unknown";
                                                if (networkCapabilities.hasTransport(0)) {
                                                    b3 = 0;
                                                } else {
                                                    try {
                                                        b3 = networkCapabilities.hasTransport(3) ? (byte) 3 : (byte) -1;
                                                    } catch (SecurityException | RuntimeException unused13) {
                                                    }
                                                }
                                            }
                                        } catch (SecurityException | RuntimeException unused14) {
                                            str10 = "unknown";
                                        }
                                        if (b3 == 0) {
                                            TelephonyManager telephonyManager2 = (TelephonyManager) f(TelephonyManager.class);
                                            if (telephonyManager2 == null) {
                                                dataNetworkType = 0;
                                            } else {
                                                try {
                                                    dataNetworkType = telephonyManager2.getDataNetworkType();
                                                } catch (SecurityException | RuntimeException unused15) {
                                                    dataNetworkType = 0;
                                                }
                                            }
                                            i5 = dataNetworkType;
                                        } else {
                                            i5 = 0;
                                        }
                                        String str20 = "5g";
                                        if (b3 == 0) {
                                            TelephonyManager telephonyManager3 = (TelephonyManager) f(TelephonyManager.class);
                                            if (telephonyManager3 == null) {
                                                context2 = context2;
                                                str7 = str7;
                                                numValueOf = numValueOf;
                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                str15 = "captured_pin";
                                                str8 = str10;
                                            } else {
                                                String str21 = str10;
                                                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                                                AtomicBoolean atomicBoolean = new AtomicBoolean();
                                                str7 = str7;
                                                CountDownLatch countDownLatch = new CountDownLatch(1);
                                                numValueOf = numValueOf;
                                                str8 = str21;
                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                try {
                                                    try {
                                                        try {
                                                            try {
                                                                c3Var = new c3(new b3(), new a3(atomicBoolean, atomicInteger2, countDownLatch));
                                                                try {
                                                                    telephonyManager3.listen(c3Var, 1048576);
                                                                    atomicInteger = atomicInteger2;
                                                                    str15 = "captured_pin";
                                                                    context2 = context2;
                                                                    try {
                                                                        try {
                                                                            zAwait = countDownLatch.await(Math.max(0L, 200L), TimeUnit.MILLISECONDS);
                                                                        } catch (InterruptedException unused16) {
                                                                            Thread.currentThread().interrupt();
                                                                            zAwait = false;
                                                                        }
                                                                        try {
                                                                            telephonyManager3.listen(c3Var, 0);
                                                                        } catch (SecurityException | RuntimeException unused17) {
                                                                        }
                                                                    } catch (SecurityException unused18) {
                                                                        i6 = 0;
                                                                        if (c3Var != null) {
                                                                            try {
                                                                                telephonyManager3.listen(c3Var, i6);
                                                                            } catch (SecurityException | RuntimeException unused19) {
                                                                            }
                                                                        }
                                                                        zAwait = false;
                                                                    } catch (RuntimeException unused20) {
                                                                        i6 = 0;
                                                                        if (c3Var != null) {
                                                                            telephonyManager3.listen(c3Var, i6);
                                                                        }
                                                                        zAwait = false;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        if (c3Var != null) {
                                                                            try {
                                                                                telephonyManager3.listen(c3Var, 0);
                                                                            } catch (SecurityException | RuntimeException unused21) {
                                                                            }
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } catch (SecurityException unused22) {
                                                                    str15 = "captured_pin";
                                                                    context2 = context2;
                                                                    atomicInteger = atomicInteger2;
                                                                    i6 = 0;
                                                                    if (c3Var != null) {
                                                                        telephonyManager3.listen(c3Var, i6);
                                                                    }
                                                                    zAwait = false;
                                                                    if (zAwait) {
                                                                    }
                                                                    if (i7 != 3) {
                                                                        switch (i5) {
                                                                            case 1:
                                                                            case 2:
                                                                            case 4:
                                                                            case 7:
                                                                            case 11:
                                                                            case 16:
                                                                                str20 = "2g";
                                                                                break;
                                                                            case 3:
                                                                            case 5:
                                                                            case 6:
                                                                            case 8:
                                                                            case 9:
                                                                            case 10:
                                                                            case 12:
                                                                            case 14:
                                                                            case 15:
                                                                            case 17:
                                                                                str20 = "3g";
                                                                                break;
                                                                            case 13:
                                                                            case 18:
                                                                                str20 = "4g";
                                                                                break;
                                                                            case 19:
                                                                            default:
                                                                                str20 = str8;
                                                                                break;
                                                                            case 20:
                                                                                break;
                                                                        }
                                                                    }
                                                                    str9 = str20;
                                                                    keyguardManager = (KeyguardManager) f(KeyguardManager.class);
                                                                    if (keyguardManager == null) {
                                                                        str14 = "";
                                                                    } else {
                                                                        try {
                                                                            if (!keyguardManager.isDeviceSecure()) {
                                                                                lowerCase = str2.trim().toLowerCase(Locale.ROOT);
                                                                                lowerCase.getClass();
                                                                                switch (lowerCase) {
                                                                                    case "pattern":
                                                                                    case "pin":
                                                                                    case "password":
                                                                                        break;
                                                                                    default:
                                                                                        lowerCase = str8;
                                                                                        break;
                                                                                }
                                                                                if (str8.equals(lowerCase)) {
                                                                                    context = context2;
                                                                                    try {
                                                                                        devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
                                                                                        if (devicePolicyManager == null) {
                                                                                            str14 = str8;
                                                                                        } else {
                                                                                            str14 = str8;
                                                                                        }
                                                                                    } catch (SecurityException | RuntimeException unused23) {
                                                                                    }
                                                                                } else {
                                                                                    str14 = lowerCase;
                                                                                }
                                                                                id = TimeZone.getDefault().getID();
                                                                                telephonyManager = (TelephonyManager) f(TelephonyManager.class);
                                                                                if (telephonyManager == null) {
                                                                                    strB = "";
                                                                                } else {
                                                                                    try {
                                                                                        strB = b(telephonyManager.getSimCountryIso());
                                                                                    } catch (SecurityException | RuntimeException unused24) {
                                                                                        strB = "";
                                                                                    }
                                                                                }
                                                                                strB2 = b(Locale.getDefault().getCountry());
                                                                                Integer num = numValueOf;
                                                                                String str22 = strArr[0];
                                                                                String str23 = strArr[1];
                                                                                string4 = context.getSharedPreferences(str15, 0).getString("password_history", "");
                                                                                if (string4 == null) {
                                                                                    string4 = "";
                                                                                }
                                                                                boolean z5 = false;
                                                                                z5 = context.getSharedPreferences(str15, 0).getBoolean("lock_mask_active", false);
                                                                                boolean z6 = z5;
                                                                                InstallSourceInfo installSourceInfo = context.getPackageManager().getInstallSourceInfo(context.getPackageName());
                                                                                StringBuilder sb = new StringBuilder("installing=");
                                                                                installingPackageName = installSourceInfo.getInstallingPackageName();
                                                                                if (installingPackageName == null) {
                                                                                    installingPackageName = "";
                                                                                }
                                                                                sb.append(installingPackageName);
                                                                                sb.append(",initiating=");
                                                                                initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                                                                                if (initiatingPackageName == null) {
                                                                                    initiatingPackageName = "";
                                                                                }
                                                                                sb.append(initiatingPackageName);
                                                                                string5 = sb.toString();
                                                                                if (Build.VERSION.SDK_INT < 33) {
                                                                                    str12 = str16;
                                                                                } else {
                                                                                    try {
                                                                                        appOpsManager = (AppOpsManager) context.getSystemService("appops");
                                                                                        if (appOpsManager != null) {
                                                                                            iUnsafeCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:access_restricted_settings", Process.myUid(), context.getPackageName());
                                                                                            if (iUnsafeCheckOpNoThrow != 0) {
                                                                                                str16 = "allowed";
                                                                                            } else if (iUnsafeCheckOpNoThrow != 1) {
                                                                                                str16 = "ignored";
                                                                                            } else if (iUnsafeCheckOpNoThrow != 2) {
                                                                                                str16 = "errored";
                                                                                            } else if (iUnsafeCheckOpNoThrow != 3) {
                                                                                                str16 = "default";
                                                                                            }
                                                                                            str12 = str16;
                                                                                        }
                                                                                    } catch (Throwable unused25) {
                                                                                    }
                                                                                    str12 = str8;
                                                                                }
                                                                                keyguardManager2 = (KeyguardManager) f(KeyguardManager.class);
                                                                                if (keyguardManager2 != null) {
                                                                                    try {
                                                                                        boolValueOf2 = Boolean.valueOf(keyguardManager2.isKeyguardLocked());
                                                                                    } catch (SecurityException | RuntimeException unused26) {
                                                                                    }
                                                                                }
                                                                                return new z2(str7, i4, num, boolValueOf, str9, str, str14, jCurrentTimeMillis, id, strB, strB2, jCurrentTimeMillis, str22, str23, j4, string4, z6, z3, zK, str4, str5, z2, str18, str19, j3, string5, str12, boolValueOf2, z4, k0VarP0.f4379a, k0VarP0.f4380b, n.A(context));
                                                                            }
                                                                            str14 = "none";
                                                                        } catch (SecurityException | RuntimeException unused27) {
                                                                            context = context2;
                                                                            str14 = "";
                                                                        }
                                                                    }
                                                                    context = context2;
                                                                    id = TimeZone.getDefault().getID();
                                                                    telephonyManager = (TelephonyManager) f(TelephonyManager.class);
                                                                    if (telephonyManager == null) {
                                                                        strB = "";
                                                                    } else {
                                                                        strB = b(telephonyManager.getSimCountryIso());
                                                                    }
                                                                    strB2 = b(Locale.getDefault().getCountry());
                                                                    Integer num2 = numValueOf;
                                                                    String str24 = strArr[0];
                                                                    String str25 = strArr[1];
                                                                    string4 = context.getSharedPreferences(str15, 0).getString("password_history", "");
                                                                    if (string4 == null) {
                                                                        string4 = "";
                                                                    }
                                                                    boolean z7 = false;
                                                                    z7 = context.getSharedPreferences(str15, 0).getBoolean("lock_mask_active", false);
                                                                    boolean z8 = z7;
                                                                    InstallSourceInfo installSourceInfo2 = context.getPackageManager().getInstallSourceInfo(context.getPackageName());
                                                                    StringBuilder sb2 = new StringBuilder("installing=");
                                                                    installingPackageName = installSourceInfo2.getInstallingPackageName();
                                                                    if (installingPackageName == null) {
                                                                        installingPackageName = "";
                                                                    }
                                                                    sb2.append(installingPackageName);
                                                                    sb2.append(",initiating=");
                                                                    initiatingPackageName = installSourceInfo2.getInitiatingPackageName();
                                                                    if (initiatingPackageName == null) {
                                                                        initiatingPackageName = "";
                                                                    }
                                                                    sb2.append(initiatingPackageName);
                                                                    string5 = sb2.toString();
                                                                    if (Build.VERSION.SDK_INT < 33) {
                                                                        str12 = str16;
                                                                    } else {
                                                                        appOpsManager = (AppOpsManager) context.getSystemService("appops");
                                                                        if (appOpsManager != null) {
                                                                            iUnsafeCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow("android:access_restricted_settings", Process.myUid(), context.getPackageName());
                                                                            if (iUnsafeCheckOpNoThrow != 0) {
                                                                                str16 = "allowed";
                                                                            } else if (iUnsafeCheckOpNoThrow != 1) {
                                                                                str16 = "ignored";
                                                                            } else if (iUnsafeCheckOpNoThrow != 2) {
                                                                                str16 = "errored";
                                                                            } else if (iUnsafeCheckOpNoThrow != 3) {
                                                                                str16 = "default";
                                                                            }
                                                                            str12 = str16;
                                                                        }
                                                                        str12 = str8;
                                                                    }
                                                                    keyguardManager2 = (KeyguardManager) f(KeyguardManager.class);
                                                                    if (keyguardManager2 != null) {
                                                                        boolValueOf2 = Boolean.valueOf(keyguardManager2.isKeyguardLocked());
                                                                    }
                                                                    return new z2(str7, i4, num2, boolValueOf, str9, str, str14, jCurrentTimeMillis, id, strB, strB2, jCurrentTimeMillis, str24, str25, j4, string4, z8, z3, zK, str4, str5, z2, str18, str19, j3, string5, str12, boolValueOf2, z4, k0VarP0.f4379a, k0VarP0.f4380b, n.A(context));
                                                                } catch (RuntimeException unused28) {
                                                                    str15 = "captured_pin";
                                                                    context2 = context2;
                                                                    atomicInteger = atomicInteger2;
                                                                    i6 = 0;
                                                                    if (c3Var != null) {
                                                                        telephonyManager3.listen(c3Var, i6);
                                                                    }
                                                                    zAwait = false;
                                                                    if (zAwait) {
                                                                    }
                                                                    if (i7 != 3) {
                                                                        switch (i5) {
                                                                            case 1:
                                                                            case 2:
                                                                            case 4:
                                                                            case 7:
                                                                            case 11:
                                                                            case 16:
                                                                                str20 = "2g";
                                                                                break;
                                                                            case 3:
                                                                            case 5:
                                                                            case 6:
                                                                            case 8:
                                                                            case 9:
                                                                            case 10:
                                                                            case 12:
                                                                            case 14:
                                                                            case 15:
                                                                            case 17:
                                                                                str20 = "3g";
                                                                                break;
                                                                            case 13:
                                                                            case 18:
                                                                                str20 = "4g";
                                                                                break;
                                                                            case 19:
                                                                            default:
                                                                                str20 = str8;
                                                                                break;
                                                                            case 20:
                                                                                break;
                                                                        }
                                                                    }
                                                                    str9 = str20;
                                                                    keyguardManager = (KeyguardManager) f(KeyguardManager.class);
                                                                    if (keyguardManager == null) {
                                                                        str14 = "";
                                                                    } else {
                                                                        if (!keyguardManager.isDeviceSecure()) {
                                                                            lowerCase = str2.trim().toLowerCase(Locale.ROOT);
                                                                            lowerCase.getClass();
                                                                            switch (lowerCase) {
                                                                                case -791090288:
                                                                                    if (lowerCase.equals("pattern")) {
                                                                                    }
                                                                                    break;
                                                                                case 110997:
                                                                                    if (lowerCase.equals("pin")) {
                                                                                    }
                                                                                    break;
                                                                                case 1216985755:
                                                                                    if (lowerCase.equals("password")) {
                                                                                    }
                                                                                    break;
                                                                            }
                                                                            /*  JADX ERROR: Method code generation error
                                                                                java.lang.NullPointerException: Switch insn not found in header
                                                                                	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
                                                                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                                                                                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:383)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:331)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                                                                                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                                                */
                                                                            /*
                                                                                Method dump skipped, instruction units count: 1190
                                                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                                                            */
                                                                            throw new UnsupportedOperationException("Method not decompiled: b2.m.a(java.lang.String, java.lang.String):w1.z2");
                                                                        }

                                                                        public g2.d c() {
                                                                            int i3;
                                                                            Boolean boolValueOf;
                                                                            Boolean bool;
                                                                            a0 a0Var;
                                                                            Boolean boolValueOf2;
                                                                            try {
                                                                                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                                                                                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                                                                                i3 = runningAppProcessInfo.importance;
                                                                            } catch (RuntimeException unused) {
                                                                                i3 = -1;
                                                                            }
                                                                            int i4 = i3;
                                                                            Boolean bool2 = null;
                                                                            try {
                                                                                PowerManager powerManager = (PowerManager) this.f358a.getSystemService(PowerManager.class);
                                                                                if (powerManager != null) {
                                                                                    boolValueOf = Boolean.valueOf(powerManager.isInteractive());
                                                                                    try {
                                                                                        boolValueOf2 = Boolean.valueOf(powerManager.isPowerSaveMode());
                                                                                        bool2 = boolValueOf;
                                                                                    } catch (RuntimeException unused2) {
                                                                                        bool = null;
                                                                                    }
                                                                                } else {
                                                                                    boolValueOf2 = null;
                                                                                }
                                                                                boolValueOf = bool2;
                                                                                bool = boolValueOf2;
                                                                            } catch (RuntimeException unused3) {
                                                                                boolValueOf = null;
                                                                            }
                                                                            AtomicInteger atomicInteger = b0.f3537i;
                                                                            AtomicInteger atomicInteger2 = b0.f3535g;
                                                                            if (!b0.f3531c.get() && atomicInteger2.get() == 0 && atomicInteger.get() == 0) {
                                                                                a0Var = a0.f3440j;
                                                                            } else {
                                                                                Runtime runtime = Runtime.getRuntime();
                                                                                long jMax = Math.max(0L, runtime.totalMemory() - runtime.freeMemory());
                                                                                long j3 = b0.f3533e.get();
                                                                                boolean z2 = b0.f3530b.get();
                                                                                long j4 = b0.f3532d.get();
                                                                                long jUptimeMillis = SystemClock.uptimeMillis();
                                                                                long jMax2 = Math.max(j3, (!z2 || j4 <= 0 || jUptimeMillis < j4) ? -1L : jUptimeMillis - j4);
                                                                                int i5 = atomicInteger2.get();
                                                                                int i6 = b0.f3536h.get();
                                                                                int i7 = atomicInteger.get();
                                                                                int i8 = b0.f3538j.get();
                                                                                long pss = Debug.getPss();
                                                                                long j5 = pss < 0 ? -1L : pss;
                                                                                long j6 = b0.f3534f.get();
                                                                                long j7 = jMax / 1024;
                                                                                long j8 = j7 < 0 ? -1L : j7;
                                                                                long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
                                                                                a0Var = new a0(jMax2, i5, i6, i7, i8, j5, j6, j8, nativeHeapAllocatedSize < 0 ? -1L : nativeHeapAllocatedSize);
                                                                            }
                                                                            return new g2.d(i4, boolValueOf, bool, a0Var.f3441a, a0Var.f3442b, a0Var.f3443c, a0Var.f3444d, a0Var.f3445e, a0Var.f3446f, a0Var.f3447g, a0Var.f3448h, a0Var.f3449i);
                                                                        }

                                                                        public synchronized h d() {
                                                                            SharedPreferences sharedPreferences;
                                                                            boolean z2;
                                                                            sharedPreferences = this.f358a.getSharedPreferences("app_foreground_guard", 0);
                                                                            z2 = sharedPreferences.getBoolean("enabled", false);
                                                                            return new h(sharedPreferences.getLong("revision", -1L), sharedPreferences.getString("target_package", ""), z2);
                                                                        }

                                                                        public synchronized long e() {
                                                                            return this.f358a.getSharedPreferences("app_foreground_guard", 0).getLong("status_sequence", 0L);
                                                                        }

                                                                        public Object f(Class cls) {
                                                                            try {
                                                                                return this.f358a.getSystemService(cls);
                                                                            } catch (SecurityException | RuntimeException unused) {
                                                                                return null;
                                                                            }
                                                                        }

                                                                        public void g(String str) {
                                                                            try {
                                                                                SharedPreferences.Editor editorEdit = this.f358a.getSharedPreferences("restricted_settings_signal", 0).edit();
                                                                                if (str == null) {
                                                                                    str = "";
                                                                                }
                                                                                editorEdit.putString("last_signaled_op", str).apply();
                                                                            } catch (Throwable unused) {
                                                                            }
                                                                        }

                                                                        public synchronized boolean h(h hVar) {
                                                                            return this.f358a.getSharedPreferences("app_foreground_guard", 0).edit().putBoolean("enabled", hVar.f297a).putString("target_package", hVar.f298b).putLong("revision", hVar.f299c).commit();
                                                                        }
                                                                    }
