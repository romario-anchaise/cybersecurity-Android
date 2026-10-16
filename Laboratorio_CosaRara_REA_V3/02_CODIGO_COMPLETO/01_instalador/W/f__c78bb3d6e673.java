// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p039w;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static LocaleList a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    public static LocaleList b() {
        return LocaleList.getAdjustedDefault();
    }

    public static LocaleList c() {
        return LocaleList.getDefault();
    }
}
