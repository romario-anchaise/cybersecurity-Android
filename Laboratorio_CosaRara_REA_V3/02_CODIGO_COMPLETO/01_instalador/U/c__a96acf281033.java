// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p035u;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static int a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }

    public static boolean b(Drawable drawable, int i2) {
        return drawable.setLayoutDirection(i2);
    }
}
