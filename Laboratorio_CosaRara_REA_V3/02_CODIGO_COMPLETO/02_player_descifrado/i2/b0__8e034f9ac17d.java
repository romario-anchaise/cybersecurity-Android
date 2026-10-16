// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f2121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f2122c;

    public b0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        inetSocketAddress.getClass();
        this.f2120a = aVar;
        this.f2121b = proxy;
        this.f2122c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return b0Var.f2120a.equals(this.f2120a) && b0Var.f2121b.equals(this.f2121b) && q1.e.a(b0Var.f2122c, this.f2122c);
    }

    public final int hashCode() {
        return this.f2122c.hashCode() + ((this.f2121b.hashCode() + ((this.f2120a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f2122c + '}';
    }
}
