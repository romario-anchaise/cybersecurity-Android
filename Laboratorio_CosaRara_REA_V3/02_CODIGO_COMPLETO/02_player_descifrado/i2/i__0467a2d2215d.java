// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f2165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f2166f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f2169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f2170d;

    static {
        h hVar = h.f2161r;
        h hVar2 = h.f2162s;
        h hVar3 = h.f2163t;
        h hVar4 = h.f2156l;
        h hVar5 = h.n;
        h hVar6 = h.f2157m;
        h hVar7 = h.f2158o;
        h hVar8 = h.f2160q;
        h hVar9 = h.f2159p;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.f2154j, h.f2155k, h.f2152h, h.f2153i, h.f2150f, h.f2151g, h.f2149e};
        b2.c cVar = new b2.c();
        cVar.b((h[]) Arrays.copyOf(hVarArr, 9));
        c0 c0Var = c0.f2123d;
        c0 c0Var2 = c0.f2124e;
        cVar.d(c0Var, c0Var2);
        cVar.f261b = true;
        cVar.a();
        b2.c cVar2 = new b2.c();
        cVar2.b((h[]) Arrays.copyOf(hVarArr2, 16));
        cVar2.d(c0Var, c0Var2);
        cVar2.f261b = true;
        f2165e = cVar2.a();
        b2.c cVar3 = new b2.c();
        cVar3.b((h[]) Arrays.copyOf(hVarArr2, 16));
        cVar3.d(c0Var, c0Var2, c0.f2125f, c0.f2126g);
        cVar3.f261b = true;
        cVar3.a();
        f2166f = new i(false, false, null, null);
    }

    public i(boolean z2, boolean z3, String[] strArr, String[] strArr2) {
        this.f2167a = z2;
        this.f2168b = z3;
        this.f2169c = strArr;
        this.f2170d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f2169c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f2146b.c(str));
        }
        return i1.i.E(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f2167a) {
            return false;
        }
        String[] strArr = this.f2170d;
        if (strArr != null && !j2.b.j(strArr, sSLSocket.getEnabledProtocols(), k1.a.f2399b)) {
            return false;
        }
        String[] strArr2 = this.f2169c;
        return strArr2 == null || j2.b.j(strArr2, sSLSocket.getEnabledCipherSuites(), h.f2147c);
    }

    public final List c() {
        String[] strArr = this.f2170d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(c.d(str));
        }
        return i1.i.E(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z2 = iVar.f2167a;
        boolean z3 = this.f2167a;
        if (z3 != z2) {
            return false;
        }
        if (z3) {
            return Arrays.equals(this.f2169c, iVar.f2169c) && Arrays.equals(this.f2170d, iVar.f2170d) && this.f2168b == iVar.f2168b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f2167a) {
            return 17;
        }
        String[] strArr = this.f2169c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f2170d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f2168b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f2167a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f2168b + ')';
    }
}
