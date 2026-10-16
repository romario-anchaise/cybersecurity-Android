// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class P extends S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static P f1665c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f1666b;

    public P(Application application) {
        this.f1666b = application;
    }

    public final N a(Class cls, Application application) {
        if (!AbstractC0063a.class.isAssignableFrom(cls)) {
            return super.b(cls);
        }
        try {
            N n2 = (N) cls.getConstructor(Application.class).newInstance(application);
            F0.i.d(n2, "{\n                try {\n…          }\n            }");
            return n2;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        }
    }

    @Override // androidx.lifecycle.S, androidx.lifecycle.Q
    public final N b(Class cls) {
        Application application = this.f1666b;
        if (application != null) {
            return a(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.Q
    public final N c(Class cls, M.c cVar) {
        if (this.f1666b != null) {
            return b(cls);
        }
        Application application = (Application) cVar.f359a.get(O.f1663a);
        if (application != null) {
            return a(cls, application);
        }
        if (AbstractC0063a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.b(cls);
    }
}
