// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static void a(Window.Callback callback, boolean z2) {
        callback.onPointerCaptureChanged(z2);
    }
}
