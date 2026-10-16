// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import w1.o7;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2687d;

    public b(o7 o7Var, boolean z2, boolean z3, int i3) {
        this.f2687d = o7Var;
        this.f2684a = z2;
        this.f2685b = z3;
        this.f2686c = Math.max(0, i3);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Serializable, java.lang.String[]] */
    public i2.i a(SSLSocket sSLSocket) throws UnknownServiceException {
        i2.i iVar;
        int i3;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i4 = this.f2686c;
        List list = (List) this.f2687d;
        int size = list.size();
        while (true) {
            if (i4 >= size) {
                iVar = null;
                break;
            }
            iVar = (i2.i) list.get(i4);
            if (iVar.b(sSLSocket)) {
                this.f2686c = i4 + 1;
                break;
            }
            i4++;
        }
        if (iVar == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.f2685b);
            sb.append(", modes=");
            sb.append(list);
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            enabledProtocols2.getClass();
            String string = Arrays.toString(enabledProtocols2);
            string.getClass();
            sb.append(", supported protocols=");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i5 = this.f2686c;
        int size2 = list.size();
        while (true) {
            i3 = 0;
            if (i5 >= size2) {
                z2 = false;
                break;
            }
            if (((i2.i) list.get(i5)).b(sSLSocket)) {
                z2 = true;
                break;
            }
            i5++;
        }
        this.f2684a = z2;
        boolean z3 = this.f2685b;
        String[] strArr = iVar.f2170d;
        ?? r1 = iVar.f2169c;
        if (r1 != 0) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            enabledCipherSuites2.getClass();
            enabledCipherSuites = j2.b.p(enabledCipherSuites2, r1, i2.h.f2147c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (strArr != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            enabledProtocols3.getClass();
            enabledProtocols = j2.b.p(enabledProtocols3, strArr, k1.a.f2399b);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        supportedCipherSuites.getClass();
        i2.g gVar = i2.h.f2147c;
        byte[] bArr = j2.b.f2361a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (gVar.compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z3 && i3 != -1) {
            enabledCipherSuites.getClass();
            String str = supportedCipherSuites[i3];
            str.getClass();
            enabledCipherSuites = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        b2.c cVar = new b2.c();
        cVar.f260a = iVar.f2167a;
        cVar.f262c = r1;
        cVar.f263d = strArr;
        cVar.f261b = iVar.f2168b;
        enabledCipherSuites.getClass();
        cVar.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        enabledProtocols.getClass();
        cVar.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        i2.i iVarA = cVar.a();
        if (iVarA.c() != null) {
            sSLSocket.setEnabledProtocols(iVarA.f2170d);
        }
        if (iVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(iVarA.f2169c);
        }
        return iVar;
    }

    public b(List list) {
        list.getClass();
        this.f2687d = list;
    }

    public b(boolean z2, boolean z3, int i3, List list) {
        this.f2684a = z2;
        this.f2685b = z3;
        this.f2686c = i3;
        this.f2687d = list;
    }
}
