// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u2;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import q1.e;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends m0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f3264c;

    public a(b bVar) {
        bVar.getClass();
        this.f3264c = bVar;
    }

    @Override // m0.a
    public final List b(String str, List list) throws SSLPeerUnverifiedException {
        list.getClass();
        str.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        objRemoveFirst.getClass();
        arrayList.add(objRemoveFirst);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < 9) {
            Object obj = arrayList.get(arrayList.size() - 1);
            obj.getClass();
            X509Certificate x509Certificate = (X509Certificate) obj;
            b bVar = this.f3264c;
            bVar.getClass();
            Set set = (Set) bVar.f3265a.get(x509Certificate.getIssuerX500Principal());
            X509Certificate x509Certificate2 = null;
            Object obj2 = null;
            if (set != null) {
                for (Object obj3 : set) {
                    try {
                        x509Certificate.verify(((X509Certificate) obj3).getPublicKey());
                        obj2 = obj3;
                        break;
                    } catch (Exception unused) {
                    }
                }
                x509Certificate2 = (X509Certificate) obj2;
            }
            if (x509Certificate2 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509Certificate2)) {
                    arrayList.add(x509Certificate2);
                }
                if (e.a(x509Certificate2.getIssuerDN(), x509Certificate2.getSubjectDN())) {
                    try {
                        x509Certificate2.verify(x509Certificate2.getPublicKey());
                        return arrayList;
                    } catch (GeneralSecurityException unused2) {
                    }
                }
                z2 = true;
                i3++;
                z2 = z2;
            } else {
                Iterator it = arrayDeque.iterator();
                it.getClass();
                while (true) {
                    if (!it.hasNext()) {
                        if (!z2) {
                            throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                        }
                        return arrayList;
                    }
                    Object next = it.next();
                    next.getClass();
                    X509Certificate x509Certificate3 = (X509Certificate) next;
                    if (e.a(x509Certificate.getIssuerDN(), x509Certificate3.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate3.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate3);
                            break;
                        } catch (GeneralSecurityException unused3) {
                            continue;
                        }
                    }
                }
                i3++;
                z2 = z2;
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && e.a(((a) obj).f3264c, this.f3264c);
    }

    public final int hashCode() {
        return this.f3264c.hashCode();
    }
}
