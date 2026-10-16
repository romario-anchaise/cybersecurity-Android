// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3392a;

    public /* synthetic */ i(k kVar) {
        this.f3392a = kVar;
    }

    public void a(Object[] objArr) {
        k kVar;
        int length = objArr.length;
        int i3 = 0;
        while (true) {
            kVar = this.f3392a;
            if (i3 >= length) {
                break;
            }
            Object obj = objArr[i3];
            if (obj instanceof String) {
                j jVar = kVar.f3405m;
                jVar.getClass();
                f1.b.a(new g0.j(jVar, (String) obj, 12));
            } else if (obj instanceof byte[]) {
                j jVar2 = kVar.f3405m;
                jVar2.getClass();
                f1.b.a(new g0.j(jVar2, (byte[]) obj, 13));
            }
            i3++;
        }
        kVar.f3397e = false;
        ArrayList arrayList = kVar.f3402j;
        if (arrayList.isEmpty() || kVar.f3397e) {
            return;
        }
        kVar.f((e1.d) arrayList.remove(0));
    }
}
