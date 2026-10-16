// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2726c;

    public i(ArrayList arrayList) {
        this.f2724a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        F0.i.e(obj, "proxy");
        F0.i.e(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (F0.i.a(name, "supports") && F0.i.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (F0.i.a(name, "unsupported") && F0.i.a(Void.TYPE, returnType)) {
            this.f2725b = true;
            return null;
        }
        boolean zA = F0.i.a(name, "protocols");
        ArrayList arrayList = this.f2724a;
        if (zA && objArr.length == 0) {
            return arrayList;
        }
        if ((F0.i.a(name, "selectProtocol") || F0.i.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                F0.i.c(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List) obj2;
                int size = list.size();
                if (size >= 0) {
                    int i2 = 0;
                    while (true) {
                        Object obj3 = list.get(i2);
                        F0.i.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj3;
                        if (arrayList.contains(str)) {
                            this.f2726c = str;
                            return str;
                        }
                        if (i2 != size) {
                            i2++;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f2726c = str2;
                return str2;
            }
        }
        if ((!F0.i.a(name, "protocolSelected") && !F0.i.a(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj4 = objArr[0];
        F0.i.c(obj4, "null cannot be cast to non-null type kotlin.String");
        this.f2726c = (String) obj4;
        return null;
    }
}
