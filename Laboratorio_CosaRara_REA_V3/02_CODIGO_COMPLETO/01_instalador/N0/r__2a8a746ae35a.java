// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import N0.C0041m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import p028p0.a;
import p028p0.d;

/* JADX INFO: loaded from: classes.dex */
public final class r extends AbstractC0233o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f3952e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Constructor f3953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f3954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f3955d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        f3952e = map;
    }

    public r(Class cls, C0235q c0235q) {
        super(c0235q);
        this.f3955d = new HashMap();
        a aVar = d.f4001a;
        Constructor constructorI = aVar.i(cls);
        this.f3953b = constructorI;
        d.f(constructorI);
        String[] strArrJ = aVar.j(cls);
        for (int i2 = 0; i2 < strArrJ.length; i2++) {
            this.f3955d.put(strArrJ[i2], Integer.valueOf(i2));
        }
        Class<?>[] parameterTypes = this.f3953b.getParameterTypes();
        this.f3954c = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            this.f3954c[i3] = f3952e.get(parameterTypes[i3]);
        }
    }

    @Override // p024n0.AbstractC0233o
    public final Object c() {
        return (Object[]) this.f3954c.clone();
    }

    @Override // p024n0.AbstractC0233o
    public final Object d(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f3953b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e2) {
            a aVar = d.f4001a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new RuntimeException("Failed to invoke constructor '" + d.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new RuntimeException("Failed to invoke constructor '" + d.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + d.b(constructor) + "' with args " + Arrays.toString(objArr), e5.getCause());
        }
    }

    @Override // p024n0.AbstractC0233o
    public final void e(Object obj, s0.a aVar, C0232n c0232n) {
        Object[] objArr = (Object[]) obj;
        HashMap map = this.f3955d;
        String str = c0232n.f3941c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            throw new IllegalStateException("Could not find the index in the constructor '" + d.b(this.f3953b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int iIntValue = num.intValue();
        Object objA = c0232n.g.a(aVar);
        if (objA != null || !c0232n.f3945h) {
            objArr[iIntValue] = objA;
            return;
        }
        throw new C0041m("null is not allowed as value for record component '" + str + "' of primitive type; at path " + aVar.v(false));
    }
}
