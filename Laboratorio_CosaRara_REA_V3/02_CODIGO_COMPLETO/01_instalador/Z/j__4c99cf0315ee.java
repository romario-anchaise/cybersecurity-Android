// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

/* JADX INFO: loaded from: classes.dex */
public final class j extends p044y0.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f1139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l f1140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1141f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, p044y0.c cVar) {
        super(cVar);
        this.f1140e = lVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f1139d = obj;
        this.f1141f |= Integer.MIN_VALUE;
        return this.f1140e.b(null, this);
    }
}
