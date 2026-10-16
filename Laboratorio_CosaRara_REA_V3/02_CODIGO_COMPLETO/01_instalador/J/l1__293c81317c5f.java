// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.k;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class l1 {
    public static OnBackInvokedDispatcher a(View view) {
        return view.findOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new k(0, runnable);
    }

    public static void c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    public static void d(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
