// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f3961a = new ConcurrentHashMap();

    public static byte[] a(c1 c1Var) {
        if (c1Var == null) {
            o2.i("snapshot and positive maxBytes required");
            return null;
        }
        List list = c1Var.f3647e;
        byte[] bytes = d1.c(c1Var).toString().getBytes(StandardCharsets.UTF_8);
        if (bytes.length <= 522240) {
            return bytes;
        }
        int size = list.size();
        byte[] bArr = null;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = ((size - i3) >>> 1) + i3;
            byte[] bytes2 = d1.c(new c1(c1Var.f3643a, c1Var.f3644b, c1Var.f3645c, true, list.subList(0, i4))).toString().getBytes(StandardCharsets.UTF_8);
            if (bytes2.length <= 522240) {
                i3 = i4 + 1;
                bArr = bytes2;
            } else {
                size = i4 - 1;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        o2.l("launcher inventory metadata exceeds payload bound");
        return null;
    }

    public static String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "unknown";
            }
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"error\":\"unknown\"}";
        }
    }

    public static String c(ScreenMirrorService screenMirrorService, String str) {
        if (screenMirrorService == null) {
            return b("service_not_bound");
        }
        if (str == null || str.isEmpty()) {
            return b("empty_package");
        }
        if (screenMirrorService.J3()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", "device_locked");
                if (!str.isEmpty()) {
                    jSONObject.put("package", str);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return "{\"error\":\"launch_failed\"}";
            }
        }
        f2.q0 q0VarD = d(screenMirrorService, str);
        String str2 = q0VarD.f1309b;
        String str3 = q0VarD.f1310c;
        boolean z2 = q0VarD.f1308a;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (z2) {
                jSONObject2.put("ok", true);
            } else {
                if (str3.isEmpty()) {
                    str3 = "launch_failed";
                }
                jSONObject2.put("error", str3);
            }
            if (!str2.isEmpty()) {
                jSONObject2.put("package", str2);
            }
            return jSONObject2.toString();
        } catch (Exception unused2) {
            return z2 ? "{\"ok\":true}" : "{\"error\":\"launch_failed\"}";
        }
    }

    public static f2.q0 d(ScreenMirrorService screenMirrorService, String str) {
        if (screenMirrorService == null) {
            return new f2.q0(false, "", "no_context");
        }
        if (str == null || str.isEmpty()) {
            return new f2.q0(false, "", "empty_package");
        }
        try {
            Intent launchIntentForPackage = screenMirrorService.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return new f2.q0(false, str, "not_launchable");
            }
            launchIntentForPackage.addFlags(268435456);
            screenMirrorService.startActivity(launchIntentForPackage);
            return new f2.q0(true, str, "");
        } catch (Exception e3) {
            StringBuilder sbK = a0.a.k("launch failed ", str, ": ");
            sbK.append(e3.getMessage());
            Log.w("AppLauncher", sbK.toString());
            return new f2.q0(false, str, e3.getMessage() != null ? e3.getMessage() : "launch_failed");
        }
    }

    public static String e(Context context, String str) {
        ConcurrentHashMap concurrentHashMap = f3961a;
        String str2 = (String) concurrentHashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
            if (applicationIcon == null) {
                return null;
            }
            int intrinsicWidth = applicationIcon.getIntrinsicWidth();
            int intrinsicHeight = applicationIcon.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                intrinsicWidth = 96;
                intrinsicHeight = 96;
            }
            float f3 = intrinsicWidth;
            float f4 = intrinsicHeight;
            float fMin = Math.min(96.0f / f3, 96.0f / f4);
            int iMax = Math.max(1, Math.round(f3 * fMin));
            int iMax2 = Math.max(1, Math.round(f4 * fMin));
            int i3 = (96 - iMax) / 2;
            int i4 = (96 - iMax2) / 2;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            applicationIcon.setBounds(i3, i4, iMax + i3, iMax2 + i4);
            applicationIcon.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            bitmapCreateBitmap.compress(compressFormat, 80, byteArrayOutputStream);
            if (byteArrayOutputStream.size() > 12288) {
                byteArrayOutputStream.reset();
                bitmapCreateBitmap.compress(compressFormat, 60, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() > 12288) {
                byteArrayOutputStream.reset();
                bitmapCreateBitmap.compress(compressFormat, 40, byteArrayOutputStream);
            }
            bitmapCreateBitmap.recycle();
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            concurrentHashMap.put(str, strEncodeToString);
            return strEncodeToString;
        } catch (Throwable th) {
            a0.a.q(th, a0.a.k("resolveIconBase64 failed ", str, ": "), "AppLauncher");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if ((r2 - r10) <= r8) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static w1.c1 f(android.content.Context r12) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.f1.f(android.content.Context):w1.c1");
    }

    public static JSONObject g(e1 e1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("package", e1Var.f3840a);
        jSONObject.put("label", e1Var.f3841b);
        jSONObject.put("system", e1Var.f3842c);
        jSONObject.put("enabled", e1Var.f3843d);
        jSONObject.put("launchable", e1Var.f3844e);
        jSONObject.put("versionName", e1Var.f3845f);
        return jSONObject;
    }
}
