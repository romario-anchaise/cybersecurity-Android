// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.app.LocaleManager;
import android.os.LocaleList;

/* JADX INFO: renamed from: f.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0124n {
    public static LocaleList a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static void b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
