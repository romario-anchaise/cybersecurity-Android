// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import p018k0.m;
import p018k0.y;
import p018k0.z;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public class P implements z {
    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Class superclass = aVar.f4029a;
        if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
            return null;
        }
        if (!superclass.isEnum()) {
            superclass = superclass.getSuperclass();
        }
        return new C0238u(superclass);
    }
}
