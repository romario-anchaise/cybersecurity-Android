// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import java.io.Closeable;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import w2.n;
import w2.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w2.h f3292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Closeable f3294g;

    public a(int i3, boolean z2) {
        this.f3290c = i3;
        switch (i3) {
            case 1:
                this.f3291d = z2;
                w2.h hVar = new w2.h();
                this.f3292e = hVar;
                Inflater inflater = new Inflater(true);
                this.f3293f = inflater;
                this.f3294g = new n(new r(hVar), inflater);
                break;
            default:
                this.f3291d = z2;
                w2.h hVar2 = new w2.h();
                this.f3292e = hVar2;
                Deflater deflater = new Deflater(-1, true);
                this.f3293f = deflater;
                this.f3294g = new o2.e(hVar2, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.f3290c) {
            case 0:
                ((o2.e) this.f3294g).close();
                break;
            default:
                ((n) this.f3294g).close();
                break;
        }
    }
}
