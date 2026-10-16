// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import p044y0.c;

/* JADX INFO: loaded from: classes.dex */
public final class i extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f1213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f1214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1215f;
    public final /* synthetic */ j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1216h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, c cVar) {
        super(cVar);
        this.g = jVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f1215f = obj;
        this.f1216h |= Integer.MIN_VALUE;
        return this.g.b(null, this);
    }
}
