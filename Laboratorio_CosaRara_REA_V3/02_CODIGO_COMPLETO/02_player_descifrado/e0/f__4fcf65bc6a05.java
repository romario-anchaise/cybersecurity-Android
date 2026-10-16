// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.PendingIntentCompat;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f673b;

    static {
        AtomicBoolean atomicBoolean = h.f674a;
        f672a = 12451000;
        f673b = new f();
    }

    public Intent a(int i3, Context context, String str) {
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && q2.k.i(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(f672a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                b2.m mVarA = m0.b.a(context);
                sb.append(mVarA.f358a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public final PendingIntent b(int i3, Context context, String str) {
        Intent intentA = a(i3, context, str);
        if (intentA == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, 0, intentA, 134217728, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:109:0x0210  */
    /* JADX WARN: Code duplicated, block: B:110:0x0212  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0176  */
    /* JADX WARN: Code duplicated, block: B:91:0x0199  */
    /* JADX WARN: Code duplicated, block: B:93:0x019e  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a9  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0199, please report this as an issue */
    public int c(Context context, int i3) {
        boolean z2;
        PackageInfo packageInfo;
        int i4;
        int i5;
        ApplicationInfo applicationInfo;
        AtomicBoolean atomicBoolean = h.f674a;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        boolean z3 = true;
        if (!"com.google.android.gms".equals(context.getPackageName()) && !h.f675b.get()) {
            synchronized (h0.o.f1918a) {
                try {
                    if (!h0.o.f1919b) {
                        h0.o.f1919b = true;
                        try {
                            Bundle bundle = m0.b.a(context).f358a.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle != null) {
                                bundle.getString("com.google.app.id");
                                h0.o.f1920c = bundle.getInt("com.google.android.gms.version");
                            }
                        } catch (PackageManager.NameNotFoundException e3) {
                            Log.wtf("MetadataValueReader", "This should never happen.", e3);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i6 = h0.o.f1920c;
            if (i6 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (i6 != 12451000) {
                int i7 = f672a;
                StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 104 + String.valueOf(i6).length() + 194);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i7);
                sb.append(" but found ");
                sb.append(i6);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new GooglePlayServicesIncorrectManifestValueException(sb.toString());
            }
        }
        if (q2.k.i(context)) {
            z2 = false;
        } else {
            if (q2.k.f3150c == null) {
                q2.k.f3150c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (q2.k.f3150c.booleanValue()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        int i8 = 9;
        if (z2) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 134225984);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 134217792);
            synchronized (i.class) {
                if (i.f677a == null) {
                    l lVar = p.f689a;
                    synchronized (p.class) {
                        if (p.f691c == null) {
                            p.f691c = context.getApplicationContext();
                        } else {
                            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                        }
                    }
                    i iVar = new i();
                    context.getApplicationContext();
                    i.f677a = iVar;
                }
            }
            if (!i.f(packageInfo2)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else if (z2) {
                h0.o.c(packageInfo);
                if (!i.f(packageInfo)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else if (z2 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    i4 = packageInfo2.versionCode;
                    if (i4 == -1) {
                        i5 = -1;
                    } else {
                        i5 = i4 / 1000;
                    }
                    if (i5 < (i3 != -1 ? i3 / 1000 : -1)) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 49 + String.valueOf(i3).length() + 11 + String.valueOf(i4).length());
                        sb2.append("Google Play services out of date for ");
                        sb2.append(packageName);
                        sb2.append(".  Requires ");
                        sb2.append(i3);
                        sb2.append(" but found ");
                        sb2.append(i4);
                        Log.w("GooglePlayServicesUtil", sb2.toString());
                        i8 = 2;
                    } else {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e4) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e4);
                                i8 = 1;
                            }
                        }
                        if (applicationInfo.enabled) {
                            i8 = 0;
                        } else {
                            i8 = 3;
                        }
                    }
                } else {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            } else if (z2) {
                i4 = packageInfo2.versionCode;
                if (i4 == -1) {
                    i5 = -1;
                } else {
                    i5 = i4 / 1000;
                }
                if (i5 < (i3 != -1 ? i3 / 1000 : -1)) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(packageName).length() + 49 + String.valueOf(i3).length() + 11 + String.valueOf(i4).length());
                    sb3.append("Google Play services out of date for ");
                    sb3.append(packageName);
                    sb3.append(".  Requires ");
                    sb3.append(i3);
                    sb3.append(" but found ");
                    sb3.append(i4);
                    Log.w("GooglePlayServicesUtil", sb3.toString());
                    i8 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i8 = 3;
                    } else {
                        i8 = 0;
                    }
                }
            } else {
                i4 = packageInfo2.versionCode;
                if (i4 == -1) {
                    i5 = -1;
                } else {
                    i5 = i4 / 1000;
                }
                if (i5 < (i3 != -1 ? i3 / 1000 : -1)) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(packageName).length() + 49 + String.valueOf(i3).length() + 11 + String.valueOf(i4).length());
                    sb4.append("Google Play services out of date for ");
                    sb4.append(packageName);
                    sb4.append(".  Requires ");
                    sb4.append(i3);
                    sb4.append(" but found ");
                    sb4.append(i4);
                    Log.w("GooglePlayServicesUtil", sb4.toString());
                    i8 = 2;
                } else {
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        i8 = 3;
                    } else {
                        i8 = 0;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
        }
        if (i8 != 18) {
            if (i8 == 1) {
                try {
                    Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                    while (it.hasNext()) {
                        if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                        }
                    }
                    z3 = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                } catch (PackageManager.NameNotFoundException | Exception unused4) {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        if (z3) {
            return 18;
        }
        return i8;
    }
}
