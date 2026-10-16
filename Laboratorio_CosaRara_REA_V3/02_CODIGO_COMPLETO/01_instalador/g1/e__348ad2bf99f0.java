// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class e implements l {
    @Override // g1.l
    public final boolean a(SSLSocket sSLSocket) {
        return M0.m.R(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // g1.l
    public final n b(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        return new f(superclass);
    }
}
