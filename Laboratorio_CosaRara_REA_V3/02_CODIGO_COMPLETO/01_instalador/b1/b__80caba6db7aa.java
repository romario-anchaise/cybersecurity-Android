// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import X0.C0060g;
import X0.C0061h;
import X0.C0062i;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2102d;

    public b(List list) {
        F0.i.e(list, "connectionSpecs");
        this.f2099a = list;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.Serializable, java.lang.String[]] */
    public final X0.j a(SSLSocket sSLSocket) throws UnknownServiceException {
        X0.j jVar;
        int i2;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i3 = this.f2100b;
        List list = this.f2099a;
        int size = list.size();
        while (true) {
            if (i3 >= size) {
                jVar = null;
                break;
            }
            jVar = (X0.j) list.get(i3);
            if (jVar.b(sSLSocket)) {
                this.f2100b = i3 + 1;
                break;
            }
            i3++;
        }
        if (jVar == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.f2102d);
            sb.append(", modes=");
            sb.append(list);
            sb.append(", supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            F0.i.b(enabledProtocols2);
            String string = Arrays.toString(enabledProtocols2);
            F0.i.d(string, "toString(this)");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i4 = this.f2100b;
        int size2 = list.size();
        while (true) {
            i2 = 0;
            if (i4 >= size2) {
                z2 = false;
                break;
            }
            if (((X0.j) list.get(i4)).b(sSLSocket)) {
                z2 = true;
                break;
            }
            i4++;
        }
        this.f2101c = z2;
        boolean z3 = this.f2102d;
        String[] strArr = jVar.f991c;
        if (strArr != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            F0.i.d(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = Y0.b.p(enabledCipherSuites2, strArr, C0061h.f965c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        ?? r6 = jVar.f992d;
        if (r6 != 0) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            F0.i.d(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = Y0.b.p(enabledProtocols3, r6, p038v0.a.f4149b);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        F0.i.d(supportedCipherSuites, "supportedCipherSuites");
        C0060g c0060g = C0061h.f965c;
        byte[] bArr = Y0.b.f1119a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (c0060g.compare(supportedCipherSuites[i2], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i2++;
        }
        if (z3 && i2 != -1) {
            F0.i.d(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i2];
            F0.i.d(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            F0.i.d(objArrCopyOf, "copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        C0062i c0062i = new C0062i();
        c0062i.f983a = jVar.f989a;
        c0062i.f985c = strArr;
        c0062i.f986d = r6;
        c0062i.f984b = jVar.f990b;
        F0.i.d(enabledCipherSuites, "cipherSuitesIntersection");
        c0062i.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        F0.i.d(enabledProtocols, "tlsVersionsIntersection");
        c0062i.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        X0.j jVarA = c0062i.a();
        if (jVarA.c() != null) {
            sSLSocket.setEnabledProtocols(jVarA.f992d);
        }
        if (jVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(jVarA.f991c);
        }
        return jVar;
    }
}
