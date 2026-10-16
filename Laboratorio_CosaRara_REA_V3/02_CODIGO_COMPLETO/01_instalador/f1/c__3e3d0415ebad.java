// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import H.C0028c;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import g1.o;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class c extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f2705e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1.i f2707d;

    static {
        boolean z2 = false;
        if (C0028c.v() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f2705e = z2;
    }

    public c() throws NoSuchMethodException {
        o oVar;
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            oVar = new o(cls);
        } catch (Exception e2) {
            n.f2736a.getClass();
            n.i("unable to load android socket classes", 5, e2);
            oVar = null;
        }
        ArrayList arrayListX = p036u0.e.x(new g1.n[]{oVar, new g1.m(g1.f.f2763f), new g1.m(g1.k.f2773a), new g1.m(g1.h.f2769a)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListX) {
            if (((g1.n) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f2706c = arrayList;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", null);
            method2 = cls2.getMethod("open", String.class);
            method = cls2.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f2707d = new g1.i(method3, method2, method);
    }

    @Override // f1.n
    public final d b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        g1.b bVar = x509TrustManagerExtensions != null ? new g1.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new j1.a(c(x509TrustManager));
    }

    @Override // f1.n
    public final j1.d c(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object next;
        F0.i.e(list, "protocols");
        Iterator it = this.f2706c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((g1.n) next).a(sSLSocket));
        g1.n nVar = (g1.n) next;
        if (nVar != null) {
            nVar.d(sSLSocket, str, list);
        }
    }

    @Override // f1.n
    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        F0.i.e(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        Object next;
        Iterator it = this.f2706c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((g1.n) next).a(sSLSocket));
        g1.n nVar = (g1.n) next;
        if (nVar != null) {
            return nVar.b(sSLSocket);
        }
        return null;
    }

    @Override // f1.n
    public final Object g() {
        g1.i iVar = this.f2707d;
        iVar.getClass();
        Method method = iVar.f2770a;
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, null);
            Method method2 = iVar.f2771b;
            F0.i.b(method2);
            method2.invoke(objInvoke, "response.body().close()");
            return objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // f1.n
    public final boolean h(String str) {
        F0.i.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // f1.n
    public final void j(Object obj, String str) {
        F0.i.e(str, "message");
        g1.i iVar = this.f2707d;
        iVar.getClass();
        if (obj != null) {
            try {
                Method method = iVar.f2772c;
                F0.i.b(method);
                method.invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        n.i(str, 5, null);
    }
}
