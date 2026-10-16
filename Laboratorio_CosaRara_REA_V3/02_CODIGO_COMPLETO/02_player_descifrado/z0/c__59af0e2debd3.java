// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import g0.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6285b;

    public /* synthetic */ c(e eVar, int i3) {
        this.f6284a = i3;
        this.f6285b = eVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f6284a) {
            case 0:
                f1.b.a(new j(this, objArr, 20));
                break;
            case 1:
                this.f6285b.a("requestHeaders", objArr[0]);
                break;
            case 2:
                f1.b.a(new j(this, objArr, 21));
                break;
            case 3:
                f1.b.a(new j(this, objArr, 22));
                break;
            default:
                f1.b.a(new j(this, objArr, 23));
                break;
        }
    }
}
