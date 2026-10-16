// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import H.C0028c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import k1.G;
import k1.I;
import k1.n;
import k1.o;
import k1.u;
import k1.v;
import k1.z;
import p036u0.l;

/* JADX INFO: loaded from: classes.dex */
public final class f extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z f3546e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f3547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p034t0.g f3549d;

    static {
        String str = z.f3517b;
        f3546e = C0028c.q("/", false);
    }

    public f(ClassLoader classLoader) {
        v vVar = o.f3497a;
        F0.i.e(vVar, "systemFileSystem");
        this.f3547b = classLoader;
        this.f3548c = vVar;
        this.f3549d = new p034t0.g(new W.e(4, this));
    }

    @Override // k1.o
    public final void a(z zVar) throws IOException {
        F0.i.e(zVar, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // k1.o
    public final List d(z zVar) throws FileNotFoundException {
        F0.i.e(zVar, "dir");
        z zVar2 = f3546e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f3518a.p();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = false;
        for (p034t0.d dVar : j()) {
            o oVar = (o) dVar.f4126a;
            z zVar3 = (z) dVar.f4127b;
            try {
                List listD = oVar.d(zVar3.d(strP));
                ArrayList<z> arrayList = new ArrayList();
                for (Object obj : listD) {
                    if (C0028c.h((z) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(p036u0.h.q(arrayList));
                for (z zVar4 : arrayList) {
                    F0.i.e(zVar4, "<this>");
                    String strReplace = M0.e.c0(zVar4.f3518a.p(), zVar3.f3518a.p()).replace('\\', '/');
                    F0.i.d(strReplace, "replace(...)");
                    arrayList2.add(zVar2.d(strReplace));
                }
                l.r(arrayList2, linkedHashSet);
                z2 = true;
            } catch (IOException unused) {
            }
        }
        if (z2) {
            return p036u0.f.B(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + zVar);
    }

    @Override // k1.o
    public final n f(z zVar) {
        F0.i.e(zVar, "path");
        if (!C0028c.h(zVar)) {
            return null;
        }
        z zVar2 = f3546e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f3518a.p();
        for (p034t0.d dVar : j()) {
            n nVarF = ((o) dVar.f4126a).f(((z) dVar.f4127b).d(strP));
            if (nVarF != null) {
                return nVarF;
            }
        }
        return null;
    }

    @Override // k1.o
    public final u g(z zVar) throws FileNotFoundException {
        if (!C0028c.h(zVar)) {
            throw new FileNotFoundException("file not found: " + zVar);
        }
        z zVar2 = f3546e;
        zVar2.getClass();
        String strP = c.b(zVar2, zVar, true).c(zVar2).f3518a.p();
        for (p034t0.d dVar : j()) {
            try {
                return ((o) dVar.f4126a).g(((z) dVar.f4127b).d(strP));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + zVar);
    }

    @Override // k1.o
    public final G h(z zVar) throws IOException {
        F0.i.e(zVar, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // k1.o
    public final I i(z zVar) throws FileNotFoundException {
        F0.i.e(zVar, "file");
        if (!C0028c.h(zVar)) {
            throw new FileNotFoundException("file not found: " + zVar);
        }
        z zVar2 = f3546e;
        zVar2.getClass();
        InputStream resourceAsStream = this.f3547b.getResourceAsStream(c.b(zVar2, zVar, false).c(zVar2).f3518a.p());
        if (resourceAsStream != null) {
            return f1.l.W(resourceAsStream);
        }
        throw new FileNotFoundException("file not found: " + zVar);
    }

    public final List j() {
        return (List) this.f3549d.getValue();
    }
}
