// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.os.LocaleList;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class Y {
    public static LocaleList a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    public static void b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
