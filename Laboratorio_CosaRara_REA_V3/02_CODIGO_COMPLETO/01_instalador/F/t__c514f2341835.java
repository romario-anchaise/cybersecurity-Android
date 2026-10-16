// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import B.d;
import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.k;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, z zVar) {
        Objects.requireNonNull(zVar);
        k kVar = new k(1, zVar);
        d.i(obj).registerOnBackInvokedCallback(1000000, kVar);
        return kVar;
    }

    public static void c(Object obj, Object obj2) {
        d.i(obj).unregisterOnBackInvokedCallback(d.f(obj2));
    }
}
