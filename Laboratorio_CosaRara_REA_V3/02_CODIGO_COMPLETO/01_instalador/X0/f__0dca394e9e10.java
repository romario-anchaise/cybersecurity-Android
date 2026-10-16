// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: X0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0059f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0059f f961c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1.d f963b;

    static {
        ArrayList arrayList = new ArrayList();
        p036u0.p pVar = p036u0.p.f4148a;
        int size = arrayList.size();
        Set set = pVar;
        if (size != 0) {
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(p036u0.q.p(arrayList.size()));
                p036u0.f.A(arrayList, linkedHashSet);
                set = linkedHashSet;
            } else {
                Set setSingleton = Collections.singleton(arrayList.get(0));
                F0.i.d(setSingleton, "singleton(...)");
                set = setSingleton;
            }
        }
        f961c = new C0059f(set, null);
    }

    public C0059f(Set set, f1.d dVar) {
        this.f962a = set;
        this.f963b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0059f) {
            C0059f c0059f = (C0059f) obj;
            if (F0.i.a(c0059f.f962a, this.f962a) && F0.i.a(c0059f.f963b, this.f963b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f962a.hashCode() + 1517) * 41;
        f1.d dVar = this.f963b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }
}
