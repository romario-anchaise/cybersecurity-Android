// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;
import m1.C0205i;
import m1.C0206j;
import m1.InterfaceC0203g;
import m1.y;
import p018k0.p;

/* JADX INFO: loaded from: classes.dex */
public final class f implements o, InterfaceC0203g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3702b;

    public /* synthetic */ f(int i2, Type type) {
        this.f3701a = i2;
        this.f3702b = type;
    }

    @Override // m1.InterfaceC0203g
    public Type d() {
        switch (this.f3701a) {
            case 2:
                break;
        }
        return this.f3702b;
    }

    @Override // m1.InterfaceC0203g
    public Object k(y yVar) {
        switch (this.f3701a) {
            case 2:
                C0206j c0206j = new C0206j(yVar);
                yVar.r(new C0205i(c0206j, 0));
                return c0206j;
            default:
                C0206j c0206j2 = new C0206j(yVar);
                yVar.r(new C0205i(c0206j2, 1));
                return c0206j2;
        }
    }

    @Override // p022m0.o
    public Object o() {
        switch (this.f3701a) {
            case 0:
                Type type = this.f3702b;
                if (!(type instanceof ParameterizedType)) {
                    throw new p("Invalid EnumSet type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new p("Invalid EnumSet type: " + type.toString());
            default:
                Type type3 = this.f3702b;
                if (!(type3 instanceof ParameterizedType)) {
                    throw new p("Invalid EnumMap type: " + type3.toString());
                }
                Type type4 = ((ParameterizedType) type3).getActualTypeArguments()[0];
                if (type4 instanceof Class) {
                    return new EnumMap((Class) type4);
                }
                throw new p("Invalid EnumMap type: " + type3.toString());
        }
    }
}
