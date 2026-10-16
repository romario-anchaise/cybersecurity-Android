// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f988f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f992d;

    static {
        C0061h c0061h = C0061h.f979r;
        C0061h c0061h2 = C0061h.f980s;
        C0061h c0061h3 = C0061h.f981t;
        C0061h c0061h4 = C0061h.f973l;
        C0061h c0061h5 = C0061h.f975n;
        C0061h c0061h6 = C0061h.f974m;
        C0061h c0061h7 = C0061h.f976o;
        C0061h c0061h8 = C0061h.f978q;
        C0061h c0061h9 = C0061h.f977p;
        C0061h[] c0061hArr = {c0061h, c0061h2, c0061h3, c0061h4, c0061h5, c0061h6, c0061h7, c0061h8, c0061h9, C0061h.f971j, C0061h.f972k, C0061h.f969h, C0061h.f970i, C0061h.f968f, C0061h.g, C0061h.f967e};
        C0062i c0062i = new C0062i();
        c0062i.b((C0061h[]) Arrays.copyOf(new C0061h[]{c0061h, c0061h2, c0061h3, c0061h4, c0061h5, c0061h6, c0061h7, c0061h8, c0061h9}, 9));
        I i2 = I.f929b;
        I i3 = I.f930c;
        c0062i.d(i2, i3);
        if (!c0062i.f983a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0062i.f984b = true;
        c0062i.a();
        C0062i c0062i2 = new C0062i();
        c0062i2.b((C0061h[]) Arrays.copyOf(c0061hArr, 16));
        c0062i2.d(i2, i3);
        if (!c0062i2.f983a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0062i2.f984b = true;
        f987e = c0062i2.a();
        C0062i c0062i3 = new C0062i();
        c0062i3.b((C0061h[]) Arrays.copyOf(c0061hArr, 16));
        c0062i3.d(i2, i3, I.f931d, I.f932e);
        if (!c0062i3.f983a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections");
        }
        c0062i3.f984b = true;
        c0062i3.a();
        f988f = new j(false, false, null, null);
    }

    public j(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f989a = z2;
        this.f990b = z3;
        this.f991c = strArr;
        this.f992d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f991c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0061h.f964b.c(str));
        }
        return p036u0.f.B(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f989a) {
            return false;
        }
        String[] strArr = this.f992d;
        if (strArr != null && !Y0.b.j(strArr, sSLSocket.getEnabledProtocols(), p038v0.a.f4149b)) {
            return false;
        }
        String[] strArr2 = this.f991c;
        return strArr2 == null || Y0.b.j(strArr2, sSLSocket.getEnabledCipherSuites(), C0061h.f965c);
    }

    public final List c() {
        String[] strArr = this.f992d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(f1.d.n(str));
        }
        return p036u0.f.B(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        boolean z2 = jVar.f989a;
        boolean z3 = this.f989a;
        if (z3 != z2) {
            return false;
        }
        return !z3 || (Arrays.equals(this.f991c, jVar.f991c) && Arrays.equals(this.f992d, jVar.f992d) && this.f990b == jVar.f990b);
    }

    public final int hashCode() {
        if (!this.f989a) {
            return 17;
        }
        String[] strArr = this.f991c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f992d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f990b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f989a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f990b + ')';
    }
}
