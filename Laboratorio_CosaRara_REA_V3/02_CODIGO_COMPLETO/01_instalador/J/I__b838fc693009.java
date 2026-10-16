// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {
    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }
}
