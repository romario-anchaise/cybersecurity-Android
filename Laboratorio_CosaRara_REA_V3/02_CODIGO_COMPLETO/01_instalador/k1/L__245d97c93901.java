// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class L extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z f3460e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f3461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3463d;

    static {
        String str = z.f3517b;
        f3460e = C0028c.q("/", false);
    }

    public L(z zVar, o oVar, LinkedHashMap linkedHashMap) {
        this.f3461b = zVar;
        this.f3462c = oVar;
        this.f3463d = linkedHashMap;
    }

    @Override // k1.o
    public final void a(z zVar) throws IOException {
        F0.i.e(zVar, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override // k1.o
    public final List d(z zVar) throws IOException {
        F0.i.e(zVar, "dir");
        z zVar2 = f3460e;
        zVar2.getClass();
        l1.g gVar = (l1.g) this.f3463d.get(l1.c.b(zVar2, zVar, true));
        if (gVar != null) {
            return p036u0.f.B(gVar.f3556h);
        }
        throw new IOException("not a directory: " + zVar);
    }

    @Override // k1.o
    public final n f(z zVar) throws Throwable {
        n nVarF;
        Throwable th;
        F0.i.e(zVar, "path");
        z zVar2 = f3460e;
        zVar2.getClass();
        l1.g gVar = (l1.g) this.f3463d.get(l1.c.b(zVar2, zVar, true));
        Throwable th2 = null;
        if (gVar == null) {
            return null;
        }
        boolean z2 = gVar.f3551b;
        n nVar = new n(!z2, z2, null, z2 ? null : Long.valueOf(gVar.f3553d), null, gVar.f3555f, null);
        long j2 = gVar.g;
        if (j2 == -1) {
            return nVar;
        }
        u uVarG = this.f3462c.g(this.f3461b);
        try {
            C cF = f1.l.f(uVarG.f(j2));
            try {
                nVarF = l1.b.f(cF, nVar);
                F0.i.b(nVarF);
                try {
                    cF.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    cF.close();
                } catch (Throwable th5) {
                    p029q.j.a(th4, th5);
                }
                th = th4;
                nVarF = null;
            }
            if (th != null) {
                throw th;
            }
            F0.i.b(nVarF);
            try {
                uVarG.close();
            } catch (Throwable th6) {
                th2 = th6;
            }
            if (th2 != null) {
                throw th2;
            }
            F0.i.b(nVarF);
            return nVarF;
        } catch (Throwable th7) {
            if (uVarG != null) {
                try {
                    uVarG.close();
                } catch (Throwable th8) {
                    p029q.j.a(th7, th8);
                }
            }
            nVarF = null;
            th2 = th7;
        }
    }

    @Override // k1.o
    public final u g(z zVar) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // k1.o
    public final G h(z zVar) throws IOException {
        F0.i.e(zVar, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // k1.o
    public final I i(z zVar) throws Throwable {
        Throwable th;
        C cF;
        F0.i.e(zVar, "file");
        z zVar2 = f3460e;
        zVar2.getClass();
        l1.g gVar = (l1.g) this.f3463d.get(l1.c.b(zVar2, zVar, true));
        if (gVar == null) {
            throw new FileNotFoundException("no such file: " + zVar);
        }
        u uVarG = this.f3462c.g(this.f3461b);
        try {
            cF = f1.l.f(uVarG.f(gVar.g));
            try {
                uVarG.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (uVarG != null) {
                try {
                    uVarG.close();
                } catch (Throwable th4) {
                    p029q.j.a(th3, th4);
                }
            }
            th = th3;
            cF = null;
        }
        if (th != null) {
            throw th;
        }
        F0.i.b(cF);
        l1.b.f(cF, null);
        int i2 = gVar.f3554e;
        long j2 = gVar.f3553d;
        if (i2 == 0) {
            return new l1.e(cF, j2, true);
        }
        return new l1.e(new t(f1.l.f(new l1.e(cF, gVar.f3552c, true)), new Inflater(true)), j2, false);
    }
}
