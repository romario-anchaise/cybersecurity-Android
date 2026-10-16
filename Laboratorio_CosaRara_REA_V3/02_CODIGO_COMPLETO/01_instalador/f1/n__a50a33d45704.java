// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import H.C0028c;
import X0.w;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f2736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f2737b;

    /* JADX WARN: Code duplicated, block: B:26:0x0071 A[PHI: r1
  0x0071: PHI (r1v3 f1.n) = (r1v1 f1.n), (r1v4 f1.n) binds: [B:65:0x0155, B:25:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:67:0x0159  */
    static {
        n nVar;
        String property;
        n jVar = null;
        if (C0028c.v()) {
            for (Map.Entry entry : g1.c.f2761b.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger = Logger.getLogger(str);
                if (g1.c.f2760a.add(logger)) {
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(g1.d.f2762a);
                }
            }
            nVar = a.f2701d ? new a() : null;
            if (nVar == null) {
                jVar = c.f2705e ? new c() : null;
                F0.i.b(jVar);
                nVar = jVar;
            }
        } else if ("Conscrypt".equals(Security.getProviders()[0].getName())) {
            nVar = h.f2722d ? new h() : null;
            if (nVar == null) {
                if (!"BC".equals(Security.getProviders()[0].getName())) {
                    if (e.f2719d) {
                        nVar = new e();
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                            if (m.f2734d) {
                                nVar = new m();
                            } else {
                                nVar = null;
                            }
                            if (nVar == null) {
                                if (k.f2731c) {
                                    nVar = new k();
                                } else {
                                    nVar = null;
                                }
                                if (nVar == null) {
                                    property = System.getProperty("java.specification.version", "unknown");
                                    F0.i.d(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                        Method method2 = cls.getMethod("get", SSLSocket.class);
                                        Method method3 = cls.getMethod("remove", SSLSocket.class);
                                        F0.i.d(method, "putMethod");
                                        F0.i.d(method2, "getMethod");
                                        F0.i.d(method3, "removeMethod");
                                        F0.i.d(cls3, "clientProviderClass");
                                        F0.i.d(cls4, "serverProviderClass");
                                        jVar = new j(method, method2, method3, cls3, cls4);
                                    }
                                    if (jVar != null) {
                                        nVar = jVar;
                                    } else {
                                        nVar = new n();
                                    }
                                }
                            }
                        } else {
                            if (k.f2731c) {
                                nVar = new k();
                            } else {
                                nVar = null;
                            }
                            if (nVar == null) {
                                property = System.getProperty("java.specification.version", "unknown");
                                F0.i.d(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                    Method method5 = cls5.getMethod("get", SSLSocket.class);
                                    Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                    F0.i.d(method4, "putMethod");
                                    F0.i.d(method5, "getMethod");
                                    F0.i.d(method6, "removeMethod");
                                    F0.i.d(cls7, "clientProviderClass");
                                    F0.i.d(cls8, "serverProviderClass");
                                    jVar = new j(method4, method5, method6, cls7, cls8);
                                }
                                if (jVar != null) {
                                    nVar = jVar;
                                } else {
                                    nVar = new n();
                                }
                            }
                        }
                    }
                } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (k.f2731c) {
                        nVar = new k();
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        F0.i.d(property, "jvmVersion");
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                            Method method8 = cls9.getMethod("get", SSLSocket.class);
                            Method method9 = cls9.getMethod("remove", SSLSocket.class);
                            F0.i.d(method7, "putMethod");
                            F0.i.d(method8, "getMethod");
                            F0.i.d(method9, "removeMethod");
                            F0.i.d(cls11, "clientProviderClass");
                            F0.i.d(cls12, "serverProviderClass");
                            jVar = new j(method7, method8, method9, cls11, cls12);
                        }
                        if (jVar != null) {
                            nVar = jVar;
                        } else {
                            nVar = new n();
                        }
                    }
                } else {
                    if (m.f2734d) {
                        nVar = new m();
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        if (k.f2731c) {
                            nVar = new k();
                        } else {
                            nVar = null;
                        }
                        if (nVar == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            F0.i.d(property, "jvmVersion");
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                Method method11 = cls13.getMethod("get", SSLSocket.class);
                                Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                F0.i.d(method10, "putMethod");
                                F0.i.d(method11, "getMethod");
                                F0.i.d(method12, "removeMethod");
                                F0.i.d(cls15, "clientProviderClass");
                                F0.i.d(cls16, "serverProviderClass");
                                jVar = new j(method10, method11, method12, cls15, cls16);
                            }
                            if (jVar != null) {
                                nVar = jVar;
                            } else {
                                nVar = new n();
                            }
                        }
                    }
                }
            }
        } else if (!"BC".equals(Security.getProviders()[0].getName())) {
            if (e.f2719d) {
                nVar = new e();
            } else {
                nVar = null;
            }
            if (nVar == null) {
                if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (k.f2731c) {
                        nVar = new k();
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        F0.i.d(property, "jvmVersion");
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                            Method method14 = cls17.getMethod("get", SSLSocket.class);
                            Method method15 = cls17.getMethod("remove", SSLSocket.class);
                            F0.i.d(method13, "putMethod");
                            F0.i.d(method14, "getMethod");
                            F0.i.d(method15, "removeMethod");
                            F0.i.d(cls19, "clientProviderClass");
                            F0.i.d(cls110, "serverProviderClass");
                            jVar = new j(method13, method14, method15, cls19, cls110);
                        }
                        if (jVar != null) {
                            nVar = jVar;
                        } else {
                            nVar = new n();
                        }
                    }
                } else {
                    if (m.f2734d) {
                        nVar = new m();
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        if (k.f2731c) {
                            nVar = new k();
                        } else {
                            nVar = null;
                        }
                        if (nVar == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            F0.i.d(property, "jvmVersion");
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                Method method17 = cls111.getMethod("get", SSLSocket.class);
                                Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                F0.i.d(method16, "putMethod");
                                F0.i.d(method17, "getMethod");
                                F0.i.d(method18, "removeMethod");
                                F0.i.d(cls113, "clientProviderClass");
                                F0.i.d(cls114, "serverProviderClass");
                                jVar = new j(method16, method17, method18, cls113, cls114);
                            }
                            if (jVar != null) {
                                nVar = jVar;
                            } else {
                                nVar = new n();
                            }
                        }
                    }
                }
            }
        } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
            if (k.f2731c) {
                nVar = new k();
            } else {
                nVar = null;
            }
            if (nVar == null) {
                property = System.getProperty("java.specification.version", "unknown");
                try {
                    F0.i.d(property, "jvmVersion");
                    if (Integer.parseInt(property) < 9) {
                        try {
                            Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                            Method method110 = cls115.getMethod("get", SSLSocket.class);
                            Method method111 = cls115.getMethod("remove", SSLSocket.class);
                            F0.i.d(method19, "putMethod");
                            F0.i.d(method110, "getMethod");
                            F0.i.d(method111, "removeMethod");
                            F0.i.d(cls117, "clientProviderClass");
                            F0.i.d(cls118, "serverProviderClass");
                            jVar = new j(method19, method110, method111, cls117, cls118);
                        } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                if (jVar != null) {
                    nVar = jVar;
                } else {
                    nVar = new n();
                }
            }
        } else {
            if (m.f2734d) {
                nVar = new m();
            } else {
                nVar = null;
            }
            if (nVar == null) {
                if (k.f2731c) {
                    nVar = new k();
                } else {
                    nVar = null;
                }
                if (nVar == null) {
                    property = System.getProperty("java.specification.version", "unknown");
                    F0.i.d(property, "jvmVersion");
                    if (Integer.parseInt(property) < 9) {
                        Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                        Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                        Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                        Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                        Method method113 = cls119.getMethod("get", SSLSocket.class);
                        Method method114 = cls119.getMethod("remove", SSLSocket.class);
                        F0.i.d(method112, "putMethod");
                        F0.i.d(method113, "getMethod");
                        F0.i.d(method114, "removeMethod");
                        F0.i.d(cls1111, "clientProviderClass");
                        F0.i.d(cls1112, "serverProviderClass");
                        jVar = new j(method112, method113, method114, cls1111, cls1112);
                    }
                    if (jVar != null) {
                        nVar = jVar;
                    } else {
                        nVar = new n();
                    }
                }
            }
        }
        f2736a = nVar;
        f2737b = Logger.getLogger(w.class.getName());
    }

    public static void i(String str, int i2, Throwable th) {
        F0.i.e(str, "message");
        f2737b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public d b(X509TrustManager x509TrustManager) {
        return new j1.a(c(x509TrustManager));
    }

    public j1.d c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        F0.i.d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new j1.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        F0.i.e(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i2);
    }

    public String f(SSLSocket sSLSocket) {
        return null;
    }

    public Object g() {
        if (f2737b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean h(String str) {
        F0.i.e(str, "hostname");
        return true;
    }

    public void j(Object obj, String str) {
        F0.i.e(str, "message");
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext k() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        F0.i.d(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory l(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextK = k();
            sSLContextK.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextK.getSocketFactory();
            F0.i.d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS: " + e2, e2);
        }
    }

    public X509TrustManager m() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        F0.i.b(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                F0.i.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        F0.i.d(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }
}
