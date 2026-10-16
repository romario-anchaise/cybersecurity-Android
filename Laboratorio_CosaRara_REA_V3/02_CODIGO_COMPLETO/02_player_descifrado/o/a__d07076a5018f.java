// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.b f2775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f2776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f2777c;

    public a(c.b bVar, c.b bVar2, c.b bVar3) {
        this.f2775a = bVar;
        this.f2776b = bVar2;
        this.f2777c = bVar3;
    }

    public abstract b a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        c.b bVar = this.f2777c;
        Class cls2 = (Class) bVar.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        bVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        c.b bVar = this.f2775a;
        Method method = (Method) bVar.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        bVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        c.b bVar = this.f2776b;
        Method method = (Method) bVar.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, a.class);
        bVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i3);

    public final Parcelable f(Parcelable parcelable, int i3) {
        if (!e(i3)) {
            return parcelable;
        }
        return ((b) this).f2779e.readParcelable(b.class.getClassLoader());
    }

    public final c g() {
        String string = ((b) this).f2779e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (c) c(string).invoke(null, a());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    public abstract void h(int i3);

    public final void i(c cVar) {
        if (cVar == null) {
            ((b) this).f2779e.writeString(null);
            return;
        }
        try {
            ((b) this).f2779e.writeString(b(cVar.getClass()).getName());
            b bVarA = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, bVarA);
                Parcel parcel = bVarA.f2779e;
                int i3 = bVarA.f2783i;
                if (i3 >= 0) {
                    int i4 = bVarA.f2778d.get(i3);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i4);
                    parcel.writeInt(iDataPosition - i4);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
            } catch (InvocationTargetException e6) {
                if (!(e6.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
                }
                throw ((RuntimeException) e6.getCause());
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e7);
        }
    }
}
