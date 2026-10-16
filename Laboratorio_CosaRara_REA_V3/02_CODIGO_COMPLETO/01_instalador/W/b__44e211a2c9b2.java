// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import F0.i;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    static {
        int i2 = Build.VERSION.SDK_INT;
        a aVar = a.f4152a;
        if (i2 >= 30) {
            aVar.a(30);
        }
        if (i2 >= 30) {
            aVar.a(31);
        }
        if (i2 >= 30) {
            aVar.a(33);
        }
        if (i2 >= 30) {
            aVar.a(1000000);
        }
    }

    public static final boolean a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33) {
            if (i2 >= 32) {
                String str = Build.VERSION.CODENAME;
                i.d(str, "CODENAME");
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    i.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    i.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if (upperCase.compareTo(upperCase2) >= 0) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
