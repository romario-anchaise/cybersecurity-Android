// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p034t0.g f1137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1138c;

    public i(p034t0.b bVar, p034t0.g gVar, boolean z2) {
        this.f1136a = bVar;
        this.f1137b = gVar;
        this.f1138c = z2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, t0.b] */
    @Override // Z.f
    public final g a(Object obj, p010f0.m mVar) {
        Uri uri = (Uri) obj;
        if (F0.i.a(uri.getScheme(), "http") || F0.i.a(uri.getScheme(), "https")) {
            return new l(uri.toString(), mVar, this.f1136a, this.f1137b, this.f1138c);
        }
        return null;
    }
}
