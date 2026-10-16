// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static OnBackInvokedCallback a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new k(0, runnable);
    }

    public static void b(Object obj, int i2, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
    }

    public static void c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
