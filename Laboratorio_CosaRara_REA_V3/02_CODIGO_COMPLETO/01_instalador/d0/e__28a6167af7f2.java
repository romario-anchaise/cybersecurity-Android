// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import H.s;
import androidx.recyclerview.widget.j0;
import b1.p;

/* JADX INFO: loaded from: classes.dex */
public final class e extends j0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f2205h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i2, s sVar) {
        super(i2);
        this.f2205h = sVar;
    }

    @Override // androidx.recyclerview.widget.j0
    public final void c(Object obj, Object obj2, Object obj3) {
        d dVar = (d) obj2;
        ((p) this.f2205h.f232b).f((a) obj, dVar.f2202a, dVar.f2203b, dVar.f2204c);
    }

    @Override // androidx.recyclerview.widget.j0
    public final int m(Object obj, Object obj2) {
        return ((d) obj2).f2204c;
    }
}
