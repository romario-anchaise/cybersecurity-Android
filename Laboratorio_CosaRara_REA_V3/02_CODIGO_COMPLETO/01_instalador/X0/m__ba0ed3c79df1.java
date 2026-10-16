// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f1008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0061h f1009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p034t0.g f1011d;

    public m(I i2, C0061h c0061h, List list, E0.a aVar) {
        this.f1008a = i2;
        this.f1009b = c0061h;
        this.f1010c = list;
        this.f1011d = new p034t0.g(new W.e(aVar));
    }

    public final List a() {
        return (List) this.f1011d.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.f1008a == this.f1008a && F0.i.a(mVar.f1009b, this.f1009b) && F0.i.a(mVar.a(), a()) && F0.i.a(mVar.f1010c, this.f1010c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1010c.hashCode() + ((a().hashCode() + ((this.f1009b.hashCode() + ((this.f1008a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(p036u0.h.q(listA));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                F0.i.d(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f1008a);
        sb.append(" cipherSuite=");
        sb.append(this.f1009b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f1010c;
        ArrayList arrayList2 = new ArrayList(p036u0.h.q(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                F0.i.d(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
