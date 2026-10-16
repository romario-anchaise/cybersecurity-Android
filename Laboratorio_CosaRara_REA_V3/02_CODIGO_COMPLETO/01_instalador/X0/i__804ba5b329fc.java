// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: X0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0062i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f983a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Serializable f986d;

    public j a() {
        return new j(this.f983a, this.f984b, (String[]) this.f985c, (String[]) this.f986d);
    }

    public void b(C0061h... c0061hArr) {
        F0.i.e(c0061hArr, "cipherSuites");
        if (!this.f983a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(c0061hArr.length);
        for (C0061h c0061h : c0061hArr) {
            arrayList.add(c0061h.f982a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void c(String... strArr) {
        F0.i.e(strArr, "cipherSuites");
        if (!this.f983a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.f985c = (String[]) strArr.clone();
    }

    public void d(I... iArr) {
        if (!this.f983a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (I i2 : iArr) {
            arrayList.add(i2.f934a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Serializable, java.lang.String[]] */
    public void e(String... strArr) {
        F0.i.e(strArr, "tlsVersions");
        if (!this.f983a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.f986d = (String[]) strArr.clone();
    }
}
