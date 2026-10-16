// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3141c;

    public h(ArrayList arrayList) {
        this.f3139a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        obj.getClass();
        method.getClass();
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (q1.e.a(name, "supports") && q1.e.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (q1.e.a(name, "unsupported") && q1.e.a(Void.TYPE, returnType)) {
            this.f3140b = true;
            return null;
        }
        boolean zA = q1.e.a(name, "protocols");
        ArrayList arrayList = this.f3139a;
        if (zA && objArr.length == 0) {
            return arrayList;
        }
        if ((q1.e.a(name, "selectProtocol") || q1.e.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                if (size >= 0) {
                    int i3 = 0;
                    while (true) {
                        Object obj3 = list.get(i3);
                        obj3.getClass();
                        String str = (String) obj3;
                        if (arrayList.contains(str)) {
                            this.f3141c = str;
                            return str;
                        }
                        if (i3 != size) {
                            i3++;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f3141c = str2;
                return str2;
            }
        }
        if ((!q1.e.a(name, "protocolSelected") && !q1.e.a(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        this.f3141c = (String) obj4;
        return null;
    }
}
