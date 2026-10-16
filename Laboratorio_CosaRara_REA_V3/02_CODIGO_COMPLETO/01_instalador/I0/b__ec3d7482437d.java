// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p014i0;

import android.graphics.drawable.Drawable;
import p010f0.e;
import p010f0.j;
import p010f0.q;
import p012h0.a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3012d;

    public b(a aVar, j jVar, int i2, boolean z2) {
        this.f3009a = aVar;
        this.f3010b = jVar;
        this.f3011c = i2;
        this.f3012d = z2;
        if (i2 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override // p014i0.f
    public final void a() {
        a aVar = this.f3009a;
        Drawable drawable = aVar.f2841b.getDrawable();
        j jVar = this.f3010b;
        boolean z2 = jVar instanceof q;
        Y.a aVar2 = new Y.a(drawable, jVar.a(), jVar.b().f2660w, this.f3011c, (z2 && ((q) jVar).g) ? false : true, this.f3012d);
        if (z2) {
            aVar.i(aVar2);
        } else if (jVar instanceof e) {
            aVar.i(aVar2);
        }
    }
}
