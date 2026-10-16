// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import H.C0028c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public class f implements n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f2763f = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f2764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f2765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f2766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f2767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f2768e;

    public f(Class cls) throws NoSuchMethodException {
        this.f2764a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        F0.i.d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f2765b = declaredMethod;
        this.f2766c = cls.getMethod("setHostname", String.class);
        this.f2767d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f2768e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // g1.n
    public final boolean a(SSLSocket sSLSocket) {
        return this.f2764a.isInstance(sSLSocket);
    }

    @Override // g1.n
    public final String b(SSLSocket sSLSocket) {
        if (!this.f2764a.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f2767d.invoke(sSLSocket, null);
            if (bArr != null) {
                return new String(bArr, M0.a.f360a);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if ((cause instanceof NullPointerException) && F0.i.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e3);
        }
    }

    @Override // g1.n
    public final boolean c() {
        boolean z2 = f1.c.f2705e;
        return f1.c.f2705e;
    }

    @Override // g1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        if (this.f2764a.isInstance(sSLSocket)) {
            try {
                this.f2765b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f2766c.invoke(sSLSocket, str);
                }
                Method method = this.f2768e;
                f1.n nVar = f1.n.f2736a;
                method.invoke(sSLSocket, C0028c.m(list));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
