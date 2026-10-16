// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import H.s;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import p018k0.m;
import p018k0.y;
import p018k0.z;
import p022m0.d;
import p032r0.a;

/* JADX INFO: renamed from: n0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0222d implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f3920b;

    public /* synthetic */ C0222d(int i2, s sVar) {
        this.f3919a = i2;
        this.f3920b = sVar;
    }

    @Override // p018k0.z
    public final y b(m mVar, a aVar) {
        Type[] actualTypeArguments;
        s sVar = this.f3920b;
        Type type = Object.class;
        switch (this.f3919a) {
            case 0:
                Class cls = aVar.f4029a;
                if (!Collection.class.isAssignableFrom(cls)) {
                    return null;
                }
                Type type2 = aVar.f4030b;
                if (type2 instanceof WildcardType) {
                    type2 = ((WildcardType) type2).getUpperBounds()[0];
                }
                d.b(Collection.class.isAssignableFrom(cls));
                Type typeJ = d.j(type2, cls, d.g(type2, cls, Collection.class), new HashMap());
                type = typeJ instanceof ParameterizedType ? ((ParameterizedType) typeJ).getActualTypeArguments()[0] : Object.class;
                return new C0221c(mVar, type, mVar.b(new a(type)), sVar.t(aVar));
            default:
                Class cls2 = aVar.f4029a;
                if (!Map.class.isAssignableFrom(cls2)) {
                    return null;
                }
                Type type3 = aVar.f4030b;
                if (type3 == Properties.class) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (type3 instanceof WildcardType) {
                        type3 = ((WildcardType) type3).getUpperBounds()[0];
                    }
                    d.b(Map.class.isAssignableFrom(cls2));
                    Type typeJ2 = d.j(type3, cls2, d.g(type3, cls2, Map.class), new HashMap());
                    actualTypeArguments = typeJ2 instanceof ParameterizedType ? ((ParameterizedType) typeJ2).getActualTypeArguments() : new Type[]{type, type};
                }
                Type type4 = actualTypeArguments[0];
                return new C0228j(this, mVar, actualTypeArguments[0], (type4 == Boolean.TYPE || type4 == Boolean.class) ? c0.f3896c : mVar.b(new a(type4)), actualTypeArguments[1], mVar.b(new a(actualTypeArguments[1])), sVar.t(aVar));
        }
    }
}
