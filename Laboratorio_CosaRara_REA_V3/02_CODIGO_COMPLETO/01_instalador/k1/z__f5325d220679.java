// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3517b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0196l f3518a;

    static {
        String str = File.separator;
        F0.i.d(str, "separator");
        f3517b = str;
    }

    public z(C0196l c0196l) {
        F0.i.e(c0196l, "bytes");
        this.f3518a = c0196l;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = l1.c.a(this);
        C0196l c0196l = this.f3518a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < c0196l.c() && c0196l.h(iA) == 92) {
            iA++;
        }
        int iC = c0196l.c();
        int i2 = iA;
        while (iA < iC) {
            if (c0196l.h(iA) == 47 || c0196l.h(iA) == 92) {
                arrayList.add(c0196l.m(i2, iA));
                i2 = iA + 1;
            }
            iA++;
        }
        if (i2 < c0196l.c()) {
            arrayList.add(c0196l.m(i2, c0196l.c()));
        }
        return arrayList;
    }

    public final z b() {
        C0196l c0196l = l1.c.f3539d;
        C0196l c0196l2 = this.f3518a;
        if (F0.i.a(c0196l2, c0196l)) {
            return null;
        }
        C0196l c0196l3 = l1.c.f3536a;
        if (F0.i.a(c0196l2, c0196l3)) {
            return null;
        }
        C0196l c0196l4 = l1.c.f3537b;
        if (F0.i.a(c0196l2, c0196l4)) {
            return null;
        }
        C0196l c0196l5 = l1.c.f3540e;
        c0196l2.getClass();
        F0.i.e(c0196l5, "suffix");
        int iC = c0196l2.c();
        byte[] bArr = c0196l5.f3484a;
        if (c0196l2.k(iC - bArr.length, c0196l5, bArr.length) && (c0196l2.c() == 2 || c0196l2.k(c0196l2.c() - 3, c0196l3, 1) || c0196l2.k(c0196l2.c() - 3, c0196l4, 1))) {
            return null;
        }
        int iJ = C0196l.j(c0196l2, c0196l3);
        if (iJ == -1) {
            iJ = C0196l.j(c0196l2, c0196l4);
        }
        if (iJ == 2 && g() != null) {
            if (c0196l2.c() == 3) {
                return null;
            }
            return new z(C0196l.n(c0196l2, 0, 3, 1));
        }
        if (iJ == 1) {
            F0.i.e(c0196l4, "prefix");
            if (c0196l2.k(0, c0196l4, c0196l4.c())) {
                return null;
            }
        }
        if (iJ != -1 || g() == null) {
            if (iJ == -1) {
                return new z(c0196l);
            }
            return iJ == 0 ? new z(C0196l.n(c0196l2, 0, 1, 1)) : new z(C0196l.n(c0196l2, 0, iJ, 1));
        }
        if (c0196l2.c() == 2) {
            return null;
        }
        return new z(C0196l.n(c0196l2, 0, 2, 1));
    }

    public final z c(z zVar) {
        F0.i.e(zVar, "other");
        int iA = l1.c.a(this);
        C0196l c0196l = this.f3518a;
        z zVar2 = iA == -1 ? null : new z(c0196l.m(0, iA));
        int iA2 = l1.c.a(zVar);
        C0196l c0196l2 = zVar.f3518a;
        if (!F0.i.a(zVar2, iA2 != -1 ? new z(c0196l2.m(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + zVar).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = zVar.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i2 = 0;
        while (i2 < iMin && F0.i.a(arrayListA.get(i2), arrayListA2.get(i2))) {
            i2++;
        }
        if (i2 == iMin && c0196l.c() == c0196l2.c()) {
            return C0028c.q(".", false);
        }
        if (arrayListA2.subList(i2, arrayListA2.size()).indexOf(l1.c.f3540e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + zVar).toString());
        }
        C0193i c0193i = new C0193i();
        C0196l c0196lC = l1.c.c(zVar);
        if (c0196lC == null && (c0196lC = l1.c.c(this)) == null) {
            c0196lC = l1.c.f(f3517b);
        }
        int size = arrayListA2.size();
        for (int i3 = i2; i3 < size; i3++) {
            c0193i.N(l1.c.f3540e);
            c0193i.N(c0196lC);
        }
        int size2 = arrayListA.size();
        while (i2 < size2) {
            c0193i.N((C0196l) arrayListA.get(i2));
            c0193i.N(c0196lC);
            i2++;
        }
        return l1.c.d(c0193i, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        z zVar = (z) obj;
        F0.i.e(zVar, "other");
        return this.f3518a.compareTo(zVar.f3518a);
    }

    public final z d(String str) {
        F0.i.e(str, "child");
        C0193i c0193i = new C0193i();
        c0193i.U(str);
        return l1.c.b(this, l1.c.d(c0193i, false), false);
    }

    public final File e() {
        return new File(this.f3518a.p());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && F0.i.a(((z) obj).f3518a, this.f3518a);
    }

    public final Path f() {
        Path path = Paths.get(this.f3518a.p(), new String[0]);
        F0.i.d(path, "get(...)");
        return path;
    }

    public final Character g() {
        C0196l c0196l = l1.c.f3536a;
        C0196l c0196l2 = this.f3518a;
        if (C0196l.f(c0196l2, c0196l) != -1 || c0196l2.c() < 2 || c0196l2.h(1) != 58) {
            return null;
        }
        char cH = (char) c0196l2.h(0);
        if (('a' > cH || cH >= '{') && ('A' > cH || cH >= '[')) {
            return null;
        }
        return Character.valueOf(cH);
    }

    public final int hashCode() {
        return this.f3518a.hashCode();
    }

    public final String toString() {
        return this.f3518a.p();
    }
}
