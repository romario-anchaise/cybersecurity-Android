// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h1.c f2188d;

    public n(c0 c0Var, h hVar, List list, p1.a aVar) {
        this.f2185a = c0Var;
        this.f2186b = hVar;
        this.f2187c = list;
        this.f2188d = new h1.c(new k.b(aVar));
    }

    public final List a() {
        return (List) this.f2188d.a();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f2185a == this.f2185a && nVar.f2186b.equals(this.f2186b) && q1.e.a(nVar.a(), a()) && nVar.f2187c.equals(this.f2187c);
    }

    public final int hashCode() {
        return this.f2187c.hashCode() + ((a().hashCode() + ((this.f2186b.hashCode() + ((this.f2185a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(i1.k.A(listA));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                type2.getClass();
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f2185a);
        sb.append(" cipherSuite=");
        sb.append(this.f2186b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f2187c;
        ArrayList arrayList2 = new ArrayList(i1.k.A(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                type.getClass();
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
