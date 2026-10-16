// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O0;

import N0.InterfaceC0046s;
import N0.r;
import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p040w0.i;

/* JADX INFO: loaded from: classes.dex */
public final class b extends p040w0.a implements InterfaceC0046s {
    private volatile Object _preHandler;

    public b() {
        super(r.f452a);
        this._preHandler = this;
    }

    @Override // N0.InterfaceC0046s
    public void f(i iVar, Throwable th) {
        Method declaredMethod;
        int i2 = Build.VERSION.SDK_INT;
        if (26 > i2 || i2 >= 28) {
            return;
        }
        Object obj = this._preHandler;
        if (obj != this) {
            declaredMethod = (Method) obj;
        } else {
            try {
                declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
                if (!Modifier.isPublic(declaredMethod.getModifiers()) || !Modifier.isStatic(declaredMethod.getModifiers())) {
                    declaredMethod = null;
                }
            } catch (Throwable unused) {
            }
            this._preHandler = declaredMethod;
        }
        Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, null) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}
