// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f3497a;

    static {
        v vVar;
        try {
            Class.forName("java.nio.file.Files");
            vVar = new w();
        } catch (ClassNotFoundException unused) {
            vVar = new v();
        }
        f3497a = vVar;
        String str = z.f3517b;
        String property = System.getProperty("java.io.tmpdir");
        F0.i.d(property, "getProperty(...)");
        C0028c.q(property, false);
        ClassLoader classLoader = l1.f.class.getClassLoader();
        F0.i.d(classLoader, "getClassLoader(...)");
        new l1.f(classLoader);
    }

    public abstract void a(z zVar);

    public final void b(z zVar) {
        F0.i.e(zVar, "path");
        a(zVar);
    }

    public final boolean c(z zVar) {
        F0.i.e(zVar, "path");
        return f(zVar) != null;
    }

    public abstract List d(z zVar);

    public final n e(z zVar) throws FileNotFoundException {
        F0.i.e(zVar, "path");
        n nVarF = f(zVar);
        if (nVarF != null) {
            return nVarF;
        }
        throw new FileNotFoundException("no such file: " + zVar);
    }

    public abstract n f(z zVar);

    public abstract u g(z zVar);

    public abstract G h(z zVar);

    public abstract I i(z zVar);
}
