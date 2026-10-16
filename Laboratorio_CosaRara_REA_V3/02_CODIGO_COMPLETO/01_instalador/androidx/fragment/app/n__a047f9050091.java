// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import N0.C0041m;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p021m.i f1564b = new p021m.i(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f1565a;

    public n(r rVar) {
        this.f1565a = rVar;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        p021m.i iVar = f1564b;
        p021m.i iVar2 = (p021m.i) iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new p021m.i(0);
            iVar.put(classLoader, iVar2);
        }
        Class cls = (Class) iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e2) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        } catch (ClassNotFoundException e3) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": make sure class name exists"), e3);
        }
    }

    public final void a(String str) {
        try {
            if (c(this.f1565a.f1580l.f1548a.getClassLoader(), str).getConstructor(null).newInstance(null) == null) {
            } else {
                throw new ClassCastException();
            }
        } catch (IllegalAccessException e2) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (InstantiationException e3) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (NoSuchMethodException e4) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new C0041m(F0.h.e("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
        }
    }
}
