// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p031r;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static int a(Context context, int i2) {
        return context.getColor(i2);
    }

    public static <T> T b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static String c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
