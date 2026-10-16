// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import H.C0028c;
import java.io.EOFException;
import java.util.ArrayList;
import k1.C0193i;
import k1.C0196l;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0196l f3536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0196l f3537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0196l f3538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0196l f3539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0196l f3540e;

    static {
        C0196l c0196l = C0196l.f3483d;
        f3536a = C0028c.p("/");
        f3537b = C0028c.p("\\");
        f3538c = C0028c.p("/\\");
        f3539d = C0028c.p(".");
        f3540e = C0028c.p("..");
    }

    public static final int a(z zVar) {
        if (zVar.f3518a.c() == 0) {
            return -1;
        }
        C0196l c0196l = zVar.f3518a;
        if (c0196l.h(0) != 47) {
            if (c0196l.h(0) != 92) {
                if (c0196l.c() <= 2 || c0196l.h(1) != 58 || c0196l.h(2) != 92) {
                    return -1;
                }
                char cH = (char) c0196l.h(0);
                return (('a' > cH || cH >= '{') && ('A' > cH || cH >= '[')) ? -1 : 3;
            }
            if (c0196l.c() > 2 && c0196l.h(1) == 92) {
                C0196l c0196l2 = f3537b;
                F0.i.e(c0196l2, "other");
                int iE = c0196l.e(c0196l2.f3484a, 2);
                return iE == -1 ? c0196l.c() : iE;
            }
        }
        return 1;
    }

    public static final z b(z zVar, z zVar2, boolean z2) {
        F0.i.e(zVar, "<this>");
        F0.i.e(zVar2, "child");
        if (a(zVar2) != -1 || zVar2.g() != null) {
            return zVar2;
        }
        C0196l c0196lC = c(zVar);
        if (c0196lC == null && (c0196lC = c(zVar2)) == null) {
            c0196lC = f(z.f3517b);
        }
        C0193i c0193i = new C0193i();
        c0193i.N(zVar.f3518a);
        if (c0193i.f3482b > 0) {
            c0193i.N(c0196lC);
        }
        c0193i.N(zVar2.f3518a);
        return d(c0193i, z2);
    }

    public static final C0196l c(z zVar) {
        C0196l c0196l = zVar.f3518a;
        C0196l c0196l2 = f3536a;
        if (C0196l.f(c0196l, c0196l2) != -1) {
            return c0196l2;
        }
        C0196l c0196l3 = f3537b;
        if (C0196l.f(zVar.f3518a, c0196l3) != -1) {
            return c0196l3;
        }
        return null;
    }

    public static final z d(C0193i c0193i, boolean z2) throws EOFException {
        C0196l c0196l;
        C0196l c0196l2;
        char cX;
        C0196l c0196l3;
        C0196l c0196lD;
        C0193i c0193i2 = new C0193i();
        C0196l c0196lE = null;
        int i2 = 0;
        while (true) {
            if (!c0193i.z(f3536a)) {
                c0196l = f3537b;
                if (!c0193i.z(c0196l)) {
                    break;
                }
            }
            byte B2 = c0193i.B();
            if (c0196lE == null) {
                c0196lE = e(B2);
            }
            i2++;
        }
        boolean z3 = i2 >= 2 && F0.i.a(c0196lE, c0196l);
        C0196l c0196l4 = f3538c;
        if (z3) {
            F0.i.b(c0196lE);
            c0193i2.N(c0196lE);
            c0193i2.N(c0196lE);
        } else if (i2 > 0) {
            F0.i.b(c0196lE);
            c0193i2.N(c0196lE);
        } else {
            long jY = c0193i.y(c0196l4);
            if (c0196lE == null) {
                c0196lE = jY == -1 ? f(z.f3517b) : e(c0193i.x(jY));
            }
            if (F0.i.a(c0196lE, c0196l)) {
                c0196l2 = c0196lE;
                if (c0193i.f3482b >= 2 && c0193i.x(1L) == 58 && (('a' <= (cX = (char) c0193i.x(0L)) && cX < '{') || ('A' <= cX && cX < '['))) {
                    if (jY == 2) {
                        c0193i2.i(c0193i, 3L);
                    } else {
                        c0193i2.i(c0193i, 2L);
                    }
                }
            } else {
                c0196l2 = c0196lE;
            }
            c0196lE = c0196l2;
        }
        boolean z4 = c0193i2.f3482b > 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            boolean zW = c0193i.w();
            c0196l3 = f3539d;
            if (zW) {
                break;
            }
            long jY2 = c0193i.y(c0196l4);
            if (jY2 == -1) {
                c0196lD = c0193i.D(c0193i.f3482b);
            } else {
                c0196lD = c0193i.D(jY2);
                c0193i.B();
            }
            C0196l c0196l5 = f3540e;
            if (F0.i.a(c0196lD, c0196l5)) {
                if (!z4 || !arrayList.isEmpty()) {
                    if (!z2 || (!z4 && (arrayList.isEmpty() || F0.i.a(p036u0.f.x(arrayList), c0196l5)))) {
                        arrayList.add(c0196lD);
                    } else if ((!z3 || arrayList.size() != 1) && !arrayList.isEmpty()) {
                        arrayList.remove(p036u0.g.p(arrayList));
                    }
                }
            } else if (!F0.i.a(c0196lD, c0196l3) && !F0.i.a(c0196lD, C0196l.f3483d)) {
                arrayList.add(c0196lD);
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                c0193i2.N(c0196lE);
            }
            c0193i2.N((C0196l) arrayList.get(i3));
        }
        if (c0193i2.f3482b == 0) {
            c0193i2.N(c0196l3);
        }
        return new z(c0193i2.D(c0193i2.f3482b));
    }

    public static final C0196l e(byte b2) {
        if (b2 == 47) {
            return f3536a;
        }
        if (b2 == 92) {
            return f3537b;
        }
        throw new IllegalArgumentException(F0.h.b(b2, "not a directory separator: "));
    }

    public static final C0196l f(String str) {
        if (F0.i.a(str, "/")) {
            return f3536a;
        }
        if (F0.i.a(str, "\\")) {
            return f3537b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
