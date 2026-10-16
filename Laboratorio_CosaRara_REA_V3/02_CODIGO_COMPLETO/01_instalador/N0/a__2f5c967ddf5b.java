// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p022m0.d;
import p032r0.a;

/* JADX INFO: renamed from: n0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0219a implements z {
    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Type type = aVar.f4030b;
        boolean z2 = type instanceof GenericArrayType;
        if (!z2 && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type genericComponentType = z2 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
        return new C0220b(mVar, mVar.b(new a(genericComponentType)), d.h(genericComponentType));
    }
}
