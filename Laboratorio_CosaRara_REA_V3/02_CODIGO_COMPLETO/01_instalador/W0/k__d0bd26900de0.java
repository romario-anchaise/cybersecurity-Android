// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f815d = V0.p.a(new int[]{176, 41, 64, 54, 106, 20, 140, 249, 90, 38, 63, 172});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f816e = V0.p.a(new int[]{144, 41, 64, 54, 120, 24, 131, 254, 85, 37, 41, 171, 22, 184, 117, 207, 156, 40});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f819c;

    public k(int i2, String str, boolean z2) {
        this.f817a = i2;
        this.f818b = str;
        this.f819c = z2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static k a(Context context) {
        boolean z2;
        String str = f815d;
        try {
            InputStream inputStreamOpen = context.getAssets().open(f816e);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, StandardCharsets.UTF_8));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    int iOptInt = jSONObject.optInt("versionCode", 0);
                    String strOptString = jSONObject.optString("versionName", "0");
                    String strOptString2 = jSONObject.optString("package", "");
                    String strOptString3 = jSONObject.optString("payloadSha256", "");
                    boolean zEquals = V0.o.f720e.equals(strOptString2);
                    if (!zEquals) {
                        Log.e(str, "embedded core package mismatch: " + strOptString2);
                    }
                    if (zEquals) {
                        z2 = true;
                        if ((V0.o.f719d != null) && (iOptInt != V0.o.f730p || !V0.o.f731q.equals(strOptString) || !V0.o.f732r.equals(strOptString3))) {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        Log.e(str, "embedded core profile mismatch: package=" + strOptString2 + " version=" + iOptInt + "/" + strOptString);
                    }
                    k kVar = new k(iOptInt, strOptString2, z2);
                    bufferedReader.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return kVar;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                throw th4;
            }
        } catch (Exception e2) {
            Log.w(str, "load failed", e2);
            return new k(0, "", false);
        }
    }

    public static boolean b(Context context) {
        int i2;
        int longVersionCode;
        k kVarA = a(context);
        if (!kVarA.f819c || (i2 = kVarA.f817a) <= 0) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(kVarA.f818b, 0);
            longVersionCode = Build.VERSION.SDK_INT >= 28 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            longVersionCode = -1;
        }
        return longVersionCode >= 0 && longVersionCode < i2;
    }
}
