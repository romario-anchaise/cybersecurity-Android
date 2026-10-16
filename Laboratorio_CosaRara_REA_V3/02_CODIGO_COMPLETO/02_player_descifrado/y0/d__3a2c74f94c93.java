// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o[] f6043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f6044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f6045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f6046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f6047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f6048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ w0.e f6049i;

    public d(o[] oVarArr, i iVar, j jVar, c cVar, l lVar, c cVar2, w0.e eVar) {
        this.f6043c = oVarArr;
        this.f6044d = iVar;
        this.f6045e = jVar;
        this.f6046f = cVar;
        this.f6047g = lVar;
        this.f6048h = cVar2;
        this.f6049i = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o[] oVarArr = this.f6043c;
        oVarArr[0].b("open", this.f6044d);
        oVarArr[0].b("error", this.f6045e);
        oVarArr[0].b("close", this.f6046f);
        c cVar = this.f6048h;
        l lVar = this.f6047g;
        lVar.b("close", cVar);
        lVar.b("upgrading", this.f6049i);
    }
}
