// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import i2.v;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f3147c;

    static {
        String property = System.getProperty("java.specification.version");
        Integer numV = property != null ? v1.k.v(property, 10) : null;
        boolean z2 = false;
        if (numV == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z2 = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numV.intValue() >= 9) {
            z2 = true;
        }
        f3147c = z2;
    }

    @Override // q2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
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
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // q2.m
    public final String e(SSLSocket sSLSocket) {
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
