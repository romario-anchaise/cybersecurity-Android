// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import X0.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class k extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f2731c;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numJ = property != null ? M0.l.J(property) : null;
        boolean z2 = false;
        if (numJ == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z2 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numJ.intValue() >= 9) {
            z2 = true;
        }
        f2731c = z2;
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
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
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
