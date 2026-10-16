// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

/* JADX INFO: loaded from: classes.dex */
public final class d extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f604d;

    static {
        int i2 = k.f613c;
        int i3 = k.f614d;
        long j2 = k.f615e;
        String str = k.f611a;
        d dVar = new d();
        dVar.f606c = new b(i2, i3, j2, str);
        f604d = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // N0.AbstractC0045q
    public final String toString() {
        return "Dispatchers.Default";
    }
}
