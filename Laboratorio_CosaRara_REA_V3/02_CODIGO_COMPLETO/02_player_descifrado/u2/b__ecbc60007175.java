// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u2;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import q1.e;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3265a;

    public b(X509Certificate... x509CertificateArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            subjectX500Principal.getClass();
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f3265a = linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof b) && e.a(((b) obj).f3265a, this.f3265a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f3265a.hashCode();
    }
}
