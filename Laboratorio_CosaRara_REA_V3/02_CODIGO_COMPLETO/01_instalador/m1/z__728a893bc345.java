// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class z extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ W f3876e;

    public /* synthetic */ z(W w2, int i2) {
        this.f3875d = i2;
        this.f3876e = w2;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        switch (this.f3875d) {
            case 0:
                Iterable iterable = (Iterable) obj;
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        this.f3876e.a(l2, it.next());
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f3876e.a(l2, Array.get(obj, i2));
                    }
                    break;
                }
                break;
        }
    }
}
