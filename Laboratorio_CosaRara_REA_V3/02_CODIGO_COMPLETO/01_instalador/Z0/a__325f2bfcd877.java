// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p046z0;

import F0.i;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f4203a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        i.b(methods);
        int length = methods.length;
        int i2 = 0;
        while (true) {
            method = null;
            if (i2 >= length) {
                break;
            }
            Method method2 = methods[i2];
            if (i.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                i.d(parameterTypes, "getParameterTypes(...)");
                if (i.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i2++;
        }
        f4203a = method;
        int length2 = methods.length;
        for (int i3 = 0; i3 < length2 && !i.a(methods[i3].getName(), "getSuppressed"); i3++) {
        }
    }
}
