// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6055d;

    public f(e eVar, g0.j jVar, e eVar2) {
        this.f6052a = 1;
        this.f6055d = eVar;
        this.f6054c = jVar;
        this.f6053b = eVar2;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f6052a) {
            case 0:
                l lVar = (l) this.f6054c;
                x0.a[] aVarArr = (x0.a[]) this.f6055d;
                lVar.b("upgrade", aVarArr[0]);
                lVar.b("upgradeError", aVarArr[0]);
                ((e) this.f6053b).run();
                break;
            case 1:
                if (!((e) this.f6055d).f6051d.f6075e) {
                    ((e) this.f6053b).run();
                } else {
                    ((g0.j) this.f6054c).run();
                }
                break;
            default:
                o[] oVarArr = (o[]) this.f6053b;
                boolean[] zArr = (boolean[]) this.f6054c;
                if (!zArr[0]) {
                    zArr[0] = true;
                    ((Runnable[]) this.f6055d)[0].run();
                    o oVar = oVarArr[0];
                    oVar.getClass();
                    f1.b.a(new m(oVar, 1));
                    oVarArr[0] = null;
                    break;
                }
                break;
        }
    }

    public /* synthetic */ f(Object obj, Object[] objArr, Object obj2, int i3) {
        this.f6052a = i3;
        this.f6054c = obj;
        this.f6055d = objArr;
        this.f6053b = obj2;
    }
}
