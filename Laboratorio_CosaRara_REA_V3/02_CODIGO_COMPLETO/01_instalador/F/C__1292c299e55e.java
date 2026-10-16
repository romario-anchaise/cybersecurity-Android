// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import p021m.i;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class[] f2402b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f2403c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2404d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f2405e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f2406f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f2407h = new i(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f2408a = new Object[2];

    public final View a(Context context, String str, String str2) {
        String strConcat;
        i iVar = f2407h;
        Constructor constructor = (Constructor) iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2402b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2408a);
    }
}
