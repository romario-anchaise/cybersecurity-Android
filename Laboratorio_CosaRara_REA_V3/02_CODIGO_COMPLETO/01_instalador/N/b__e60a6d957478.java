// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N;

import H.C0028c;
import androidx.lifecycle.N;
import p021m.j;

/* JADX INFO: loaded from: classes.dex */
public class b extends N {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0028c f380e = new C0028c(7);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f381d = new j();

    @Override // androidx.lifecycle.N
    public final void b() {
        j jVar = this.f381d;
        int i2 = jVar.f3692c;
        if (i2 > 0) {
            jVar.f3691b[0].getClass();
            throw new ClassCastException();
        }
        Object[] objArr = jVar.f3691b;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        jVar.f3692c = 0;
    }
}
