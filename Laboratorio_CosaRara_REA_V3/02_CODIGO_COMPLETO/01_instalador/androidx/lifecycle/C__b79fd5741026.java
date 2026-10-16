// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, EnumC0076n enumC0076n) {
        F0.i.e(activity, "activity");
        F0.i.e(enumC0076n, "event");
        if (activity instanceof InterfaceC0082u) {
            AbstractC0078p lifecycle = ((InterfaceC0082u) activity).getLifecycle();
            if (lifecycle instanceof w) {
                ((w) lifecycle).f(enumC0076n);
            }
        }
    }

    public static void b(Activity activity) {
        F0.i.e(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            E.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new E.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new E(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
