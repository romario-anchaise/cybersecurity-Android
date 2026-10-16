// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h1;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import p029q.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2842a = new a();

    @Override // java.net.ProxySelector
    public final List select(URI uri) {
        if (uri != null) {
            return j.m(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null");
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }
}
