// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import M0.m;
import M0.o;
import N0.AbstractC0049v;
import N0.V;
import N0.f0;
import N0.r;
import T0.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import k1.B;
import k1.C;
import k1.C0187c;
import k1.K;
import k1.v;
import k1.x;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable, Flushable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final M0.d f867q = new M0.d("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f873f;
    public final R0.d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public B f876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f881o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f882p;

    public g(long j2, T0.c cVar, v vVar, z zVar) {
        this.f868a = zVar;
        this.f869b = j2;
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f870c = zVar.d("journal");
        this.f871d = zVar.d("journal.tmp");
        this.f872e = zVar.d("journal.bkp");
        this.f873f = new LinkedHashMap(0, 0.75f, true);
        f0 f0Var = new f0(null);
        cVar.getClass();
        p040w0.i iVarN = p029q.j.n(f0Var, l.f618c.w(1));
        this.g = new R0.d(iVarN.j(r.f453b) == null ? iVarN.t(new V(null)) : iVarN);
        this.f882p = new e(vVar);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0116 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x000f, B:11:0x0016, B:13:0x001c, B:15:0x002c, B:23:0x003b, B:25:0x0053, B:29:0x0070, B:31:0x007e, B:33:0x0085, B:26:0x0059, B:28:0x0069, B:37:0x00a5, B:39:0x00ac, B:42:0x00b1, B:44:0x00c2, B:47:0x00c7, B:52:0x0102, B:54:0x010d, B:58:0x0116, B:48:0x00df, B:50:0x00f4, B:51:0x00ff, B:36:0x0095, B:61:0x011b, B:62:0x0122), top: B:65:0x0001 }] */
    public static final void a(g gVar, b bVar, boolean z2) {
        synchronized (gVar) {
            c cVar = bVar.f850a;
            if (!F0.i.a(cVar.g, bVar)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!z2 || cVar.f859f) {
                for (int i2 = 0; i2 < 2; i2++) {
                    gVar.f882p.b((z) cVar.f857d.get(i2));
                }
            } else {
                for (int i3 = 0; i3 < 2; i3++) {
                    if (bVar.f852c[i3] && !gVar.f882p.c((z) cVar.f857d.get(i3))) {
                        bVar.a(false);
                        return;
                    }
                }
                for (int i4 = 0; i4 < 2; i4++) {
                    z zVar = (z) cVar.f857d.get(i4);
                    z zVar2 = (z) cVar.f856c.get(i4);
                    if (gVar.f882p.c(zVar)) {
                        gVar.f882p.j(zVar, zVar2);
                    } else {
                        e eVar = gVar.f882p;
                        z zVar3 = (z) cVar.f856c.get(i4);
                        if (!eVar.c(zVar3)) {
                            p016j0.f.a(eVar.h(zVar3));
                        }
                    }
                    long j2 = cVar.f855b[i4];
                    Long l2 = gVar.f882p.e(zVar2).f3493d;
                    long jLongValue = l2 != null ? l2.longValue() : 0L;
                    cVar.f855b[i4] = jLongValue;
                    gVar.f874h = (gVar.f874h - j2) + jLongValue;
                }
            }
            cVar.g = null;
            if (cVar.f859f) {
                gVar.x(cVar);
                return;
            }
            gVar.f875i++;
            B b2 = gVar.f876j;
            F0.i.b(b2);
            if (z2 || cVar.f858e) {
                cVar.f858e = true;
                b2.k("CLEAN");
                b2.o(32);
                b2.k(cVar.f854a);
                for (long j3 : cVar.f855b) {
                    b2.o(32);
                    b2.l(j3);
                }
                b2.o(10);
            } else {
                gVar.f873f.remove(cVar.f854a);
                b2.k("REMOVE");
                b2.o(32);
                b2.k(cVar.f854a);
                b2.o(10);
            }
            b2.flush();
            if (gVar.f874h > gVar.f869b) {
                gVar.r();
            } else if (gVar.f875i >= 2000) {
                gVar.r();
            }
        }
    }

    public static void z(String str) {
        M0.d dVar = f867q;
        dVar.getClass();
        F0.i.e(str, "input");
        if (((Pattern) dVar.f374b).matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    public final synchronized void A() {
        p034t0.h hVar;
        try {
            B b2 = this.f876j;
            if (b2 != null) {
                b2.close();
            }
            B bE = f1.l.e(this.f882p.h(this.f871d));
            Throwable th = null;
            try {
                bE.k("libcore.io.DiskLruCache");
                bE.o(10);
                bE.k("1");
                bE.o(10);
                bE.l(1);
                bE.o(10);
                bE.l(2);
                bE.o(10);
                bE.o(10);
                for (c cVar : this.f873f.values()) {
                    if (cVar.g != null) {
                        bE.k("DIRTY");
                        bE.o(32);
                        bE.k(cVar.f854a);
                        bE.o(10);
                    } else {
                        bE.k("CLEAN");
                        bE.o(32);
                        bE.k(cVar.f854a);
                        for (long j2 : cVar.f855b) {
                            bE.o(32);
                            bE.l(j2);
                        }
                        bE.o(10);
                    }
                }
                hVar = p034t0.h.f4132b;
                try {
                    bE.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    bE.close();
                } catch (Throwable th4) {
                    p029q.j.a(th3, th4);
                }
                hVar = null;
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            F0.i.b(hVar);
            if (this.f882p.c(this.f870c)) {
                this.f882p.j(this.f870c, this.f872e);
                this.f882p.j(this.f871d, this.f870c);
                this.f882p.b(this.f872e);
            } else {
                this.f882p.j(this.f871d, this.f870c);
            }
            this.f876j = t();
            this.f875i = 0;
            this.f877k = false;
            this.f881o = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f878l && !this.f879m) {
                for (c cVar : (c[]) this.f873f.values().toArray(new c[0])) {
                    b bVar = cVar.g;
                    if (bVar != null) {
                        c cVar2 = bVar.f850a;
                        if (F0.i.a(cVar2.g, bVar)) {
                            cVar2.f859f = true;
                        }
                    }
                }
                y();
                AbstractC0049v.b(this.g);
                B b2 = this.f876j;
                F0.i.b(b2);
                b2.close();
                this.f876j = null;
                this.f879m = true;
                return;
            }
            this.f879m = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized b f(String str) {
        try {
            if (this.f879m) {
                throw new IllegalStateException("cache is closed");
            }
            z(str);
            n();
            c cVar = (c) this.f873f.get(str);
            if ((cVar != null ? cVar.g : null) != null) {
                return null;
            }
            if (cVar != null && cVar.f860h != 0) {
                return null;
            }
            if (!this.f880n && !this.f881o) {
                B b2 = this.f876j;
                F0.i.b(b2);
                b2.k("DIRTY");
                b2.o(32);
                b2.k(str);
                b2.o(10);
                b2.flush();
                if (this.f877k) {
                    return null;
                }
                if (cVar == null) {
                    cVar = new c(this, str);
                    this.f873f.put(str, cVar);
                }
                b bVar = new b(this, cVar);
                cVar.g = bVar;
                return bVar;
            }
            r();
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.f878l) {
            if (this.f879m) {
                throw new IllegalStateException("cache is closed");
            }
            y();
            B b2 = this.f876j;
            F0.i.b(b2);
            b2.flush();
        }
    }

    public final synchronized d j(String str) {
        d dVarA;
        if (this.f879m) {
            throw new IllegalStateException("cache is closed");
        }
        z(str);
        n();
        c cVar = (c) this.f873f.get(str);
        if (cVar != null && (dVarA = cVar.a()) != null) {
            boolean z2 = true;
            this.f875i++;
            B b2 = this.f876j;
            F0.i.b(b2);
            b2.k("READ");
            b2.o(32);
            b2.k(str);
            b2.o(10);
            if (this.f875i < 2000) {
                z2 = false;
            }
            if (z2) {
                r();
            }
            return dVarA;
        }
        return null;
    }

    public final synchronized void n() {
        try {
            if (this.f878l) {
                return;
            }
            this.f882p.b(this.f871d);
            if (this.f882p.c(this.f872e)) {
                if (this.f882p.c(this.f870c)) {
                    this.f882p.b(this.f872e);
                } else {
                    this.f882p.j(this.f872e, this.f870c);
                }
            }
            if (this.f882p.c(this.f870c)) {
                try {
                    v();
                    u();
                    this.f878l = true;
                    return;
                } catch (IOException unused) {
                    try {
                        close();
                        f1.l.u(this.f882p, this.f868a);
                        this.f879m = false;
                        A();
                        this.f878l = true;
                    } catch (Throwable th) {
                        this.f879m = false;
                        throw th;
                    }
                }
            }
            A();
            this.f878l = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void r() {
        AbstractC0049v.i(this.g, null, new f(this, null), 3);
    }

    public final B t() {
        e eVar = this.f882p;
        eVar.getClass();
        z zVar = this.f870c;
        F0.i.e(zVar, "file");
        eVar.getClass();
        F0.i.e(zVar, "file");
        eVar.f865b.getClass();
        File fileE = zVar.e();
        Logger logger = x.f3514a;
        return f1.l.e(new h(new C0187c(new FileOutputStream(fileE, true), 1, new K()), new o(2, this)));
    }

    public final void u() {
        Iterator it = this.f873f.values().iterator();
        long j2 = 0;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i2 = 0;
            if (cVar.g == null) {
                while (i2 < 2) {
                    j2 += cVar.f855b[i2];
                    i2++;
                }
            } else {
                cVar.g = null;
                while (i2 < 2) {
                    z zVar = (z) cVar.f856c.get(i2);
                    e eVar = this.f882p;
                    eVar.b(zVar);
                    eVar.b((z) cVar.f857d.get(i2));
                    i2++;
                }
                it.remove();
            }
        }
        this.f874h = j2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    public final void v() throws Throwable {
        p034t0.h hVar;
        C cF = f1.l.f(this.f882p.i(this.f870c));
        Throwable th = null;
        try {
            String strY = cF.y(Long.MAX_VALUE);
            String strY2 = cF.y(Long.MAX_VALUE);
            String strY3 = cF.y(Long.MAX_VALUE);
            String strY4 = cF.y(Long.MAX_VALUE);
            String strY5 = cF.y(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(strY) || !"1".equals(strY2) || !F0.i.a(String.valueOf(1), strY3) || !F0.i.a(String.valueOf(2), strY4) || strY5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strY + ", " + strY2 + ", " + strY3 + ", " + strY4 + ", " + strY5 + ']');
            }
            int i2 = 0;
            while (true) {
                try {
                    w(cF.y(Long.MAX_VALUE));
                    i2++;
                } catch (EOFException unused) {
                    this.f875i = i2 - this.f873f.size();
                    if (cF.a()) {
                        this.f876j = t();
                    } else {
                        A();
                    }
                    hVar = p034t0.h.f4132b;
                    try {
                        cF.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (th == null) {
                        throw th;
                    }
                    F0.i.b(hVar);
                }
            }
        } catch (Throwable th3) {
            try {
                cF.close();
            } catch (Throwable th4) {
                p029q.j.a(th3, th4);
            }
            th = th3;
            hVar = null;
            if (th == null) {
                throw th;
            }
            F0.i.b(hVar);
        }
    }

    public final void w(String str) throws IOException {
        String strSubstring;
        int iX = M0.e.X(str, ' ', 0, false, 6);
        if (iX == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iX + 1;
        int iX2 = M0.e.X(str, ' ', i2, false, 4);
        LinkedHashMap linkedHashMap = this.f873f;
        if (iX2 == -1) {
            strSubstring = str.substring(i2);
            F0.i.d(strSubstring, "substring(...)");
            if (iX == 6 && m.R(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iX2);
            F0.i.d(strSubstring, "substring(...)");
        }
        Object cVar = linkedHashMap.get(strSubstring);
        if (cVar == null) {
            cVar = new c(this, strSubstring);
            linkedHashMap.put(strSubstring, cVar);
        }
        c cVar2 = (c) cVar;
        if (iX2 == -1 || iX != 5 || !m.R(str, "CLEAN", false)) {
            if (iX2 == -1 && iX == 5 && m.R(str, "DIRTY", false)) {
                cVar2.g = new b(this, cVar2);
                return;
            } else {
                if (iX2 != -1 || iX != 4 || !m.R(str, "READ", false)) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String strSubstring2 = str.substring(iX2 + 1);
        F0.i.d(strSubstring2, "substring(...)");
        List listE0 = M0.e.e0(strSubstring2, new char[]{' '});
        cVar2.f858e = true;
        cVar2.g = null;
        int size = listE0.size();
        cVar2.f861i.getClass();
        if (size != 2) {
            throw new IOException("unexpected journal line: " + listE0);
        }
        try {
            int size2 = listE0.size();
            for (int i3 = 0; i3 < size2; i3++) {
                cVar2.f855b[i3] = Long.parseLong((String) listE0.get(i3));
            }
        } catch (NumberFormatException unused) {
            throw new IOException("unexpected journal line: " + listE0);
        }
    }

    public final void x(c cVar) {
        B b2;
        int i2 = cVar.f860h;
        String str = cVar.f854a;
        if (i2 > 0 && (b2 = this.f876j) != null) {
            b2.k("DIRTY");
            b2.o(32);
            b2.k(str);
            b2.o(10);
            b2.flush();
        }
        if (cVar.f860h > 0 || cVar.g != null) {
            cVar.f859f = true;
            return;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.f882p.b((z) cVar.f856c.get(i3));
            long j2 = this.f874h;
            long[] jArr = cVar.f855b;
            this.f874h = j2 - jArr[i3];
            jArr[i3] = 0;
        }
        this.f875i++;
        B b3 = this.f876j;
        if (b3 != null) {
            b3.k("REMOVE");
            b3.o(32);
            b3.k(str);
            b3.o(10);
        }
        this.f873f.remove(str);
        if (this.f875i >= 2000) {
            r();
        }
    }

    public final void y() {
        while (this.f874h > this.f869b) {
            for (c cVar : this.f873f.values()) {
                if (!cVar.f859f) {
                    x(cVar);
                }
            }
            return;
        }
        this.f880n = false;
    }
}
