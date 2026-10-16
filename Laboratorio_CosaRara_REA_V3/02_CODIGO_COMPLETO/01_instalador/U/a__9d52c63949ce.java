// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p035u;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i2) {
        return drawableContainerState.getChild(i2);
    }

    public static Drawable c(InsetDrawable insetDrawable) {
        return insetDrawable.getDrawable();
    }

    public static boolean d(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void e(Drawable drawable, boolean z2) {
        drawable.setAutoMirrored(z2);
    }
}
