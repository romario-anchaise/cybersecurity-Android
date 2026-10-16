// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f779a = V0.p.a(new int[]{146, 50, 70, 33, 78, 23, 151, 228, 85, 44, 34, 135, 17, 249, 106, 206, 144, 35, 28, 57, 84, 26, 140});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f780b = V0.p.a(new int[]{132, 52, 83, 35, 87, 16, 144, 207, 93, 55, 56, 170, 11, 244, 106, 200, 154, 41, 92});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f781c = V0.p.a(new int[]{128, 41, 71, 33, 68, 16, 189, 251, 89, 58});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f782d = Pattern.compile("^src_[a-f0-9]{32}$");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f783e = new Object();

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        synchronized (f783e) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(f780b, 0);
                String str = f781c;
                boolean zContains = sharedPreferences.contains(str);
                String string = zContains ? sharedPreferences.getString(str, "") : "";
                if (zContains) {
                    if (string == null || !f782d.matcher(string).matches()) {
                        string = "";
                    }
                    return string;
                }
                String strB = b(context);
                if (strB == null || !f782d.matcher(strB).matches()) {
                    strB = "";
                }
                return (strB.isEmpty() || sharedPreferences.edit().putString(str, strB).commit()) ? strB : "";
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String b(Context context) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(f779a);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[512];
                    int i2 = 0;
                    while (true) {
                        int i3 = inputStreamOpen.read(bArr);
                        if (i3 == -1) {
                            String strOptString = new JSONObject(new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8)).optString(f781c, "");
                            byteArrayOutputStream.close();
                            inputStreamOpen.close();
                            return strOptString;
                        }
                        i2 += i3;
                        if (i2 > 4096) {
                            byteArrayOutputStream.close();
                            inputStreamOpen.close();
                            return "";
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
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
        } catch (Throwable unused) {
            return "";
        }
    }
}
