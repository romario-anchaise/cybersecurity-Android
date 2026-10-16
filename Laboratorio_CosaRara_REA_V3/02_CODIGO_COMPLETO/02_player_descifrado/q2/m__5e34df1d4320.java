// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import android.util.Log;
import i2.u;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
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

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile m f3156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3157b;

    /* JADX WARN: Code duplicated, block: B:33:0x008b  */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x00be  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:64:0x013f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    static {
        m mVar;
        String property;
        i iVar = null;
        if (c.r()) {
            for (Map.Entry entry : r2.c.f3175b.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger = Logger.getLogger(str);
                if (r2.c.f3174a.add(logger)) {
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(r2.d.f3176a);
                }
            }
            mVar = a.f3131d ? new a() : null;
            if (mVar == null) {
                int i3 = b.f3133c;
                throw null;
            }
        } else if ("Conscrypt".equals(Security.getProviders()[0].getName())) {
            mVar = g.f3137d ? new g() : null;
            if (mVar == null) {
                if (!"BC".equals(Security.getProviders()[0].getName())) {
                    if (d.f3134d) {
                        mVar = new d();
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                            if (l.f3154d) {
                                mVar = new l();
                            } else {
                                mVar = null;
                            }
                            if (mVar == null) {
                                if (j.f3147c) {
                                    mVar = new j();
                                } else {
                                    mVar = null;
                                }
                                if (mVar == null) {
                                    property = System.getProperty("java.specification.version", "unknown");
                                    property.getClass();
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                        Method method2 = cls.getMethod("get", SSLSocket.class);
                                        Method method3 = cls.getMethod("remove", SSLSocket.class);
                                        method.getClass();
                                        method2.getClass();
                                        method3.getClass();
                                        cls3.getClass();
                                        cls4.getClass();
                                        iVar = new i(method, method2, method3, cls3, cls4);
                                    }
                                    if (iVar != null) {
                                        mVar = iVar;
                                    } else {
                                        mVar = new m();
                                    }
                                }
                            }
                        } else {
                            if (j.f3147c) {
                                mVar = new j();
                            } else {
                                mVar = null;
                            }
                            if (mVar == null) {
                                property = System.getProperty("java.specification.version", "unknown");
                                property.getClass();
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                    Method method5 = cls5.getMethod("get", SSLSocket.class);
                                    Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                    method4.getClass();
                                    method5.getClass();
                                    method6.getClass();
                                    cls7.getClass();
                                    cls8.getClass();
                                    iVar = new i(method4, method5, method6, cls7, cls8);
                                }
                                if (iVar != null) {
                                    mVar = iVar;
                                } else {
                                    mVar = new m();
                                }
                            }
                        }
                    }
                } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (j.f3147c) {
                        mVar = new j();
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        property.getClass();
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                            Method method8 = cls9.getMethod("get", SSLSocket.class);
                            Method method9 = cls9.getMethod("remove", SSLSocket.class);
                            method7.getClass();
                            method8.getClass();
                            method9.getClass();
                            cls11.getClass();
                            cls12.getClass();
                            iVar = new i(method7, method8, method9, cls11, cls12);
                        }
                        if (iVar != null) {
                            mVar = iVar;
                        } else {
                            mVar = new m();
                        }
                    }
                } else {
                    if (l.f3154d) {
                        mVar = new l();
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        if (j.f3147c) {
                            mVar = new j();
                        } else {
                            mVar = null;
                        }
                        if (mVar == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            property.getClass();
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                Method method11 = cls13.getMethod("get", SSLSocket.class);
                                Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                method10.getClass();
                                method11.getClass();
                                method12.getClass();
                                cls15.getClass();
                                cls16.getClass();
                                iVar = new i(method10, method11, method12, cls15, cls16);
                            }
                            if (iVar != null) {
                                mVar = iVar;
                            } else {
                                mVar = new m();
                            }
                        }
                    }
                }
            }
        } else if (!"BC".equals(Security.getProviders()[0].getName())) {
            if (d.f3134d) {
                mVar = new d();
            } else {
                mVar = null;
            }
            if (mVar == null) {
                if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (j.f3147c) {
                        mVar = new j();
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        property = System.getProperty("java.specification.version", "unknown");
                        property.getClass();
                        if (Integer.parseInt(property) < 9) {
                            Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                            Method method14 = cls17.getMethod("get", SSLSocket.class);
                            Method method15 = cls17.getMethod("remove", SSLSocket.class);
                            method13.getClass();
                            method14.getClass();
                            method15.getClass();
                            cls19.getClass();
                            cls110.getClass();
                            iVar = new i(method13, method14, method15, cls19, cls110);
                        }
                        if (iVar != null) {
                            mVar = iVar;
                        } else {
                            mVar = new m();
                        }
                    }
                } else {
                    if (l.f3154d) {
                        mVar = new l();
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        if (j.f3147c) {
                            mVar = new j();
                        } else {
                            mVar = null;
                        }
                        if (mVar == null) {
                            property = System.getProperty("java.specification.version", "unknown");
                            property.getClass();
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                Method method17 = cls111.getMethod("get", SSLSocket.class);
                                Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                method16.getClass();
                                method17.getClass();
                                method18.getClass();
                                cls113.getClass();
                                cls114.getClass();
                                iVar = new i(method16, method17, method18, cls113, cls114);
                            }
                            if (iVar != null) {
                                mVar = iVar;
                            } else {
                                mVar = new m();
                            }
                        }
                    }
                }
            }
        } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
            if (j.f3147c) {
                mVar = new j();
            } else {
                mVar = null;
            }
            if (mVar == null) {
                property = System.getProperty("java.specification.version", "unknown");
                try {
                    property.getClass();
                    if (Integer.parseInt(property) < 9) {
                        try {
                            Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                            Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                            Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                            Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                            Method method110 = cls115.getMethod("get", SSLSocket.class);
                            Method method111 = cls115.getMethod("remove", SSLSocket.class);
                            method19.getClass();
                            method110.getClass();
                            method111.getClass();
                            cls117.getClass();
                            cls118.getClass();
                            iVar = new i(method19, method110, method111, cls117, cls118);
                        } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                if (iVar != null) {
                    mVar = iVar;
                } else {
                    mVar = new m();
                }
            }
        } else {
            if (l.f3154d) {
                mVar = new l();
            } else {
                mVar = null;
            }
            if (mVar == null) {
                if (j.f3147c) {
                    mVar = new j();
                } else {
                    mVar = null;
                }
                if (mVar == null) {
                    property = System.getProperty("java.specification.version", "unknown");
                    property.getClass();
                    if (Integer.parseInt(property) < 9) {
                        Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                        Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                        Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                        Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                        Method method113 = cls119.getMethod("get", SSLSocket.class);
                        Method method114 = cls119.getMethod("remove", SSLSocket.class);
                        method112.getClass();
                        method113.getClass();
                        method114.getClass();
                        cls1111.getClass();
                        cls1112.getClass();
                        iVar = new i(method112, method113, method114, cls1111, cls1112);
                    }
                    if (iVar != null) {
                        mVar = iVar;
                    } else {
                        mVar = new m();
                    }
                }
            }
        }
        f3156a = mVar;
        f3157b = Logger.getLogger(u.class.getName());
    }

    public static void g(String str, int i3, Throwable th) {
        f3157b.log(i3 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public m0.a b(X509TrustManager x509TrustManager) {
        return new u2.a(c(x509TrustManager));
    }

    public u2.b c(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        acceptedIssuers.getClass();
        return new u2.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
    }

    public String e(SSLSocket sSLSocket) {
        return null;
    }

    public boolean f(String str) {
        str.getClass();
        return true;
    }

    public SSLContext h() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }

    public SSLSocketFactory i(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextH = h();
            sSLContextH.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextH.getSocketFactory();
            socketFactory.getClass();
            return socketFactory;
        } catch (GeneralSecurityException e3) {
            throw new AssertionError("No System TLS: " + e3, e3);
        }
    }

    public X509TrustManager j() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        b2.a.b("Unexpected default trust managers: ".concat(string));
        return null;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }
}
