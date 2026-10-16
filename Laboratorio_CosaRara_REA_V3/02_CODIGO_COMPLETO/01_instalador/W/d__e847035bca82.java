// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

/* JADX INFO: loaded from: classes.dex */
public final class d extends p044y0.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public U0.d f740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f741f;
    public final /* synthetic */ f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f742h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, p044y0.c cVar) {
        super(cVar);
        this.g = fVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f741f = obj;
        this.f742h |= Integer.MIN_VALUE;
        return this.g.a(this);
    }
}
