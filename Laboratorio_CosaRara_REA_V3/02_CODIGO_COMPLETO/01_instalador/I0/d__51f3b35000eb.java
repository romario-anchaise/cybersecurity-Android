// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p014i0;

import p010f0.e;
import p010f0.j;
import p010f0.q;
import p012h0.a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3014b;

    public d(a aVar, j jVar) {
        this.f3013a = aVar;
        this.f3014b = jVar;
    }

    @Override // p014i0.f
    public final void a() {
        j jVar = this.f3014b;
        boolean z2 = jVar instanceof q;
        a aVar = this.f3013a;
        if (z2) {
            aVar.i(((q) jVar).f2683a);
        } else if (jVar instanceof e) {
            aVar.i(((e) jVar).f2618a);
        }
    }
}
