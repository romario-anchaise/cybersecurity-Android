// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class P implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f3820a = new Object[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ V.a f3821b;

    public P(V.a aVar) {
        this.f3821b = aVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        r rVarB;
        r rVar;
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f3820a;
        }
        C0198b c0198b = J.f3769b;
        if (c0198b.e(method)) {
            return c0198b.d(obj, method, objArr);
        }
        V.a aVar = this.f3821b;
        while (true) {
            Object objPutIfAbsent = ((ConcurrentHashMap) aVar.f650b).get(method);
            if (!(objPutIfAbsent instanceof r)) {
                if (objPutIfAbsent == null) {
                    Object obj2 = new Object();
                    synchronized (obj2) {
                        try {
                            objPutIfAbsent = ((ConcurrentHashMap) aVar.f650b).putIfAbsent(method, obj2);
                            if (objPutIfAbsent == null) {
                                try {
                                    rVarB = r.b(aVar, method);
                                    ((ConcurrentHashMap) aVar.f650b).put(method, rVarB);
                                } catch (Throwable th) {
                                    ((ConcurrentHashMap) aVar.f650b).remove(method);
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                synchronized (objPutIfAbsent) {
                    try {
                        Object obj3 = ((ConcurrentHashMap) aVar.f650b).get(method);
                        if (obj3 != null) {
                            rVar = (r) obj3;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                break;
            }
            rVarB = (r) objPutIfAbsent;
            rVar = rVarB;
        }
        return rVar.a(new y(rVar.f3850a, obj, objArr, rVar.f3851b, rVar.f3852c), objArr);
    }
}
