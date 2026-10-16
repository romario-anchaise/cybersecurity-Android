// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import i2.v;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f3142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f3143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f3144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f3145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f3146g;

    public i(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f3142c = method;
        this.f3143d = method2;
        this.f3144e = method3;
        this.f3145f = cls;
        this.f3146g = cls2;
    }

    @Override // q2.m
    public final void a(SSLSocket sSLSocket) {
        try {
            this.f3144e.invoke(null, sSLSocket);
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to remove ALPN", e4);
        }
    }

    @Override // q2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((v) obj) != v.f2261d) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(i1.k.A(arrayList));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((v) obj2).f2268c);
        }
        try {
            this.f3142c.invoke(null, sSLSocket, Proxy.newProxyInstance(m.class.getClassLoader(), new Class[]{this.f3145f, this.f3146g}, new h(arrayList2)));
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to set ALPN", e4);
        }
    }

    @Override // q2.m
    public final String e(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f3143d.invoke(null, sSLSocket));
            invocationHandler.getClass();
            h hVar = (h) invocationHandler;
            boolean z2 = hVar.f3140b;
            if (!z2 && hVar.f3141c == null) {
                m.g("ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 4, null);
                return null;
            }
            if (z2) {
                return null;
            }
            return hVar.f3141c;
        } catch (IllegalAccessException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        } catch (InvocationTargetException e4) {
            throw new AssertionError("failed to get ALPN selected protocol", e4);
        }
    }
}
