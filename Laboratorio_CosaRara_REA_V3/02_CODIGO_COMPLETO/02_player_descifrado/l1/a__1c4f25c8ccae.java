// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import java.lang.reflect.Method;
import q1.e;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f2407a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        methods.getClass();
        int length = methods.length;
        int i3 = 0;
        while (true) {
            method = null;
            if (i3 >= length) {
                break;
            }
            Method method2 = methods[i3];
            if (e.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                parameterTypes.getClass();
                if (e.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i3++;
        }
        f2407a = method;
        int length2 = methods.length;
        for (int i4 = 0; i4 < length2 && !e.a(methods[i4].getName(), "getSuppressed"); i4++) {
        }
    }
}
