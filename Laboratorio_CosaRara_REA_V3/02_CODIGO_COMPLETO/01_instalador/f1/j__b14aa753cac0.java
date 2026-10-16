// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import X0.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class j extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f2727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f2728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f2729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f2730f;
    public final Class g;

    public j(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f2727c = method;
        this.f2728d = method2;
        this.f2729e = method3;
        this.f2730f = cls;
        this.g = cls2;
    }

    @Override // f1.n
    public final void a(SSLSocket sSLSocket) {
        try {
            this.f2729e.invoke(null, sSLSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((x) obj) != x.f1090b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(p036u0.h.q(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((x) it.next()).f1096a);
        }
        try {
            this.f2727c.invoke(null, sSLSocket, Proxy.newProxyInstance(n.class.getClassLoader(), new Class[]{this.f2730f, this.g}, new i(arrayList2)));
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f2728d.invoke(null, sSLSocket));
            F0.i.c(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            i iVar = (i) invocationHandler;
            boolean z2 = iVar.f2725b;
            if (!z2 && iVar.f2726c == null) {
                n.i("ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 4, null);
                return null;
            }
            if (z2) {
                return null;
            }
            return iVar.f2726c;
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }
}
