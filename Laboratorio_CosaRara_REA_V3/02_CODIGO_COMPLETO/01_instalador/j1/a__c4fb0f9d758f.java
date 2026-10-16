// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import F0.i;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f1.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f3399m;

    public a(d dVar) {
        i.e(dVar, "trustRootIndex");
        this.f3399m = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && i.a(((a) obj).f3399m, this.f3399m);
    }

    @Override // f1.d
    public final List h(List list, String str) throws SSLPeerUnverifiedException {
        i.e(list, "chain");
        i.e(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        i.d(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z2 = false;
        for (int i2 = 0; i2 < 9; i2++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            i.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate x509CertificateA = this.f3399m.a(x509Certificate);
            if (x509CertificateA != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateA)) {
                    arrayList.add(x509CertificateA);
                }
                if (i.a(x509CertificateA.getIssuerDN(), x509CertificateA.getSubjectDN())) {
                    try {
                        x509CertificateA.verify(x509CertificateA.getPublicKey());
                        return arrayList;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                z2 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                i.d(it, "queue.iterator()");
                while (true) {
                    if (!it.hasNext()) {
                        if (z2) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                    }
                    Object next = it.next();
                    i.c(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (i.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                            break;
                        } catch (GeneralSecurityException unused2) {
                            continue;
                        }
                    }
                }
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final int hashCode() {
        return this.f3399m.hashCode();
    }
}
