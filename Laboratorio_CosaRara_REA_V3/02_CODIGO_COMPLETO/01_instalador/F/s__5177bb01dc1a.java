// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.res.Configuration;
import android.os.LocaleList;
import p039w.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static g b(Configuration configuration) {
        return g.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(g gVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(gVar.f4155a.f4156a.toLanguageTags()));
    }

    public static void d(Configuration configuration, g gVar) {
        configuration.setLocales(LocaleList.forLanguageTags(gVar.f4155a.f4156a.toLanguageTags()));
    }
}
