// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.util.HashMap;
import p018k0.m;
import p018k0.y;
import p020l0.b;
import s0.a;

/* JADX INFO: renamed from: n0.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0238u extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3964d;

    public C0238u(Class cls) {
        this.f3961a = 1;
        this.f3962b = new HashMap();
        this.f3963c = new HashMap();
        this.f3964d = new HashMap();
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new b0(cls))) {
                Enum r4 = (Enum) field.get(null);
                String strName = r4.name();
                String string = r4.toString();
                b bVar = (b) field.getAnnotation(b.class);
                if (bVar != null) {
                    strName = bVar.value();
                    for (String str : bVar.alternate()) {
                        ((HashMap) this.f3962b).put(str, r4);
                    }
                }
                ((HashMap) this.f3962b).put(strName, r4);
                ((HashMap) this.f3963c).put(string, r4);
                ((HashMap) this.f3964d).put(r4, strName);
            }
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        switch (this.f3961a) {
            case 0:
                return ((y) this.f3963c).a(aVar);
            default:
                if (aVar.J() == 9) {
                    aVar.F();
                    return null;
                }
                String strH = aVar.H();
                Enum r1 = (Enum) ((HashMap) this.f3962b).get(strH);
                return r1 == null ? (Enum) ((HashMap) this.f3963c).get(strH) : r1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    @Override // p018k0.y
    public final void b(s0.b bVar, Object obj) {
        y yVarC;
        switch (this.f3961a) {
            case 0:
                Type type = (Type) this.f3964d;
                Type type2 = (obj == null || !((type instanceof Class) || (type instanceof TypeVariable))) ? type : obj.getClass();
                y yVar = (y) this.f3963c;
                if (type2 != type) {
                    y yVarB = ((m) this.f3962b).b(new p032r0.a(type2));
                    if (yVarB instanceof AbstractC0233o) {
                        y yVar2 = yVar;
                        while ((yVar2 instanceof AbstractC0237t) && (yVarC = ((AbstractC0237t) yVar2).c()) != yVar2) {
                            yVar2 = yVarC;
                        }
                        if (yVar2 instanceof AbstractC0233o) {
                            yVar = yVarB;
                        }
                    } else {
                        yVar = yVarB;
                    }
                }
                yVar.b(bVar, obj);
                break;
            default:
                Enum r6 = (Enum) obj;
                bVar.D(r6 == null ? null : (String) ((HashMap) this.f3964d).get(r6));
                break;
        }
    }

    public C0238u(m mVar, y yVar, Type type) {
        this.f3961a = 0;
        this.f3962b = mVar;
        this.f3963c = yVar;
        this.f3964d = type;
    }
}
