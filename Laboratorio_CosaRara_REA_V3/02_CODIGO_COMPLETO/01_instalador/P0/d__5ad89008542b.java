// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p028p0;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p018k0.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4001a;

    static {
        a bVar;
        try {
            bVar = new c();
        } catch (ReflectiveOperationException unused) {
            bVar = new b();
        }
        f4001a = bVar;
    }

    public static void a(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(')');
    }

    public static String b(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        a(constructor, sb);
        return sb.toString();
    }

    public static String c(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String d(AccessibleObject accessibleObject, boolean z2) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + c((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            a(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + b((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z2 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static String e(Exception exc) {
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        return "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat((message == null || !message.contains("to module com.google.gson")) ? "reflection-inaccessible" : "reflection-inaccessible-to-module-gson");
    }

    public static void f(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            throw new p("Failed making " + d(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + e(e2), e2);
        }
    }
}
