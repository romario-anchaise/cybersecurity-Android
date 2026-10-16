// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

/* JADX INFO: loaded from: classes.dex */
public final class k extends p044y0.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f1142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public X.i f1143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1144f;
    public /* synthetic */ Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ l f1145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1146i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, p044y0.c cVar) {
        super(cVar);
        this.f1145h = lVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.g = obj;
        this.f1146i |= Integer.MIN_VALUE;
        return this.f1145h.a(this);
    }
}
