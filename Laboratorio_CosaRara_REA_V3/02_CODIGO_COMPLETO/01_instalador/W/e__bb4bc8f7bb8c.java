// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import java.util.Locale;
import p043y.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale[] f4153a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f4153a;
        for (Locale locale3 : localeArr) {
            if (locale3.equals(locale)) {
                return false;
            }
        }
        for (Locale locale4 : localeArr) {
            if (locale4.equals(locale2)) {
                return false;
            }
        }
        String strC = a.c(a.a(a.b(locale)));
        if (!strC.isEmpty()) {
            return strC.equals(a.c(a.a(a.b(locale2))));
        }
        String country = locale.getCountry();
        return country.isEmpty() || country.equals(locale2.getCountry());
    }
}
