// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p028p0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f3997a = Class.class.getMethod("isRecord", null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3998b = Class.class.getMethod("getRecordComponents", null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f3999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f4000d;

    public c() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.f3999c = cls.getMethod("getName", null);
        this.f4000d = cls.getMethod("getType", null);
    }

    @Override // p028p0.a
    public final Method h(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.11.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p028p0.a
    public final Constructor i(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f3998b.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = (Class) this.f4000d.invoke(objArr[i2], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.11.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p028p0.a
    public final String[] j(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f3998b.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                strArr[i2] = (String) this.f3999c.invoke(objArr[i2], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.11.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p028p0.a
    public final boolean l(Class cls) {
        try {
            return ((Boolean) this.f3997a.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.11.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }
}
