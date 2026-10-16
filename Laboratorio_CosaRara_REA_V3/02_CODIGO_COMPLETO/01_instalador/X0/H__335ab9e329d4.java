// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0054a f926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f928c;

    public H(C0054a c0054a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        F0.i.e(inetSocketAddress, "socketAddress");
        this.f926a = c0054a;
        this.f927b = proxy;
        this.f928c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof H) {
            H h2 = (H) obj;
            if (F0.i.a(h2.f926a, this.f926a) && F0.i.a(h2.f927b, this.f927b) && F0.i.a(h2.f928c, this.f928c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f928c.hashCode() + ((this.f927b.hashCode() + ((this.f926a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f928c + '}';
    }
}
