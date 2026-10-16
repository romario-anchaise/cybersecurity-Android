// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.H;
import A.X;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f3354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3355b;

    static {
        f3355b = Build.VERSION.SDK_INT >= 27;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f3354a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean a(View view) {
        WeakHashMap weakHashMap = X.f14a;
        return H.d(view) == 1;
    }
}
