// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O0;

import F0.i;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import p029q.j;
import p034t0.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            objB = new c(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            objB = j.b(th);
        }
        if (objB instanceof e) {
            objB = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 28) {
            Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            i.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) objInvoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
