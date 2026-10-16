// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class f implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f3177f = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f3180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f3181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f3182e;

    public f(Class cls) throws NoSuchMethodException {
        this.f3178a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        declaredMethod.getClass();
        this.f3179b = declaredMethod;
        this.f3180c = cls.getMethod("setHostname", String.class);
        this.f3181d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f3182e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // r2.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f3178a.isInstance(sSLSocket);
    }

    @Override // r2.m
    public final String b(SSLSocket sSLSocket) {
        if (this.f3178a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f3181d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, v1.a.f3277a);
                }
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                Throwable cause = e4.getCause();
                if (!(cause instanceof NullPointerException) || !q1.e.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e4);
                }
            }
        }
        return null;
    }

    @Override // r2.m
    public final boolean c() {
        int i3 = q2.b.f3133c;
        return false;
    }

    @Override // r2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (this.f3178a.isInstance(sSLSocket)) {
            try {
                this.f3179b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f3180c.invoke(sSLSocket, str);
                }
                Method method = this.f3182e;
                q2.m mVar = q2.m.f3156a;
                method.invoke(sSLSocket, q2.c.h(list));
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        }
    }
}
