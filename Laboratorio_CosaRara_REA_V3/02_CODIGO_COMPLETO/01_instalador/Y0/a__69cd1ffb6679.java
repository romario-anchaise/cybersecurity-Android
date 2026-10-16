// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p044y0;

import F0.i;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p029q.j;
import p040w0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d, d, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4195a;

    public a(d dVar) {
        this.f4195a = dVar;
    }

    public d a(Object obj, d dVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Override // p040w0.d
    public final void b(Object obj) {
        d dVar = this;
        while (true) {
            a aVar = (a) dVar;
            d dVar2 = aVar.f4195a;
            i.b(dVar2);
            try {
                obj = aVar.f(obj);
                if (obj == p042x0.a.f4189a) {
                    return;
                }
            } catch (Throwable th) {
                obj = j.b(th);
            }
            aVar.h();
            if (!(dVar2 instanceof a)) {
                dVar2.b(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    @Override // p044y0.d
    public final d d() {
        d dVar = this.f4195a;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    public abstract Object f(Object obj);

    public String toString() {
        int iIntValue;
        String strC;
        StringBuilder sb = new StringBuilder("Continuation at ");
        e eVar = (e) getClass().getAnnotation(e.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (eVar != null) {
            int iV = eVar.v();
            if (iV > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i2 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
            g1.i iVar = f.f4200b;
            g1.i iVar2 = f.f4199a;
            if (iVar == null) {
                try {
                    g1.i iVar3 = new g1.i(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    f.f4200b = iVar3;
                    iVar = iVar3;
                } catch (Exception unused2) {
                    f.f4200b = iVar2;
                    iVar = iVar2;
                }
            }
            if (iVar != iVar2) {
                Method method = iVar.f2770a;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = iVar.f2771b;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = iVar.f2772c;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strC = eVar.c();
            } else {
                strC = str + '/' + eVar.c();
            }
            name = new StackTraceElement(strC, eVar.m(), eVar.f(), i2);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }

    public void h() {
    }
}
