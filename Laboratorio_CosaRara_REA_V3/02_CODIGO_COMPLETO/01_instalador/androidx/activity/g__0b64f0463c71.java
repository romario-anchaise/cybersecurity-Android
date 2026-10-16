// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }
}
