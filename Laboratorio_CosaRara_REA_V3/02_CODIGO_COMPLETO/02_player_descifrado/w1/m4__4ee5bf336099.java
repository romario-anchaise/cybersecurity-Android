// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m4 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ScheduledExecutorService f4502v = Executors.newSingleThreadScheduledExecutor(new a2.l(20));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final o2 f4503w = new o2(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f4 f4506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f4508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4512i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c4 f4515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c4 f4516m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4519q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4522t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f4523u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f4504a = new EnumMap(e4.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumMap f4505b = new EnumMap(e4.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o2 f4513j = new o2(4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g4 f4514k = f4503w;

    public m4() {
        for (e4 e4Var : e4.values()) {
            this.f4504a.put(e4Var, new ArrayDeque());
        }
        this.f4505b.put(e4.f3868c, 16);
        this.f4505b.put(e4.f3869d, 6);
        this.f4505b.put(e4.f3870e, 4);
        this.f4505b.put(e4.f3871f, 2);
    }

    public static boolean a(m4 m4Var, f4 f4Var, long j3, boolean z2) {
        synchronized (m4Var) {
            if (f4Var == m4Var.f4506c && f4Var.f3987h == 3) {
                long j4 = f4Var.f3989j;
                if (j3 == j4 && j4 == m4Var.f4517o) {
                    m4Var.d();
                    m4Var.f4506c = null;
                    m4Var.f4517o = 0L;
                    f4Var.f3987h = 4;
                    f4Var.f3990k = null;
                    n nVar = f4Var.f3984e;
                    try {
                        if (z2) {
                            nVar.Z();
                        } else {
                            nVar.Y();
                        }
                    } catch (Throwable unused) {
                    }
                    m4Var.g();
                    return true;
                }
            }
            if (f4Var.f3987h == 4) {
                m4Var.f4522t++;
            }
            return false;
        }
    }

    public static void i(c4 c4Var) {
        if (c4Var == null) {
            return;
        }
        try {
            c4Var.cancel();
        } catch (Throwable unused) {
        }
    }

    public static void j(f4 f4Var, int i3) {
        try {
            f4Var.f3984e.c0(i3);
        } catch (Throwable unused) {
        }
    }

    public final synchronized d4 b(Object obj) throws Throwable {
        Throwable th;
        try {
            if (obj == null) {
                throw new IllegalArgumentException("owner required");
            }
            try {
                Object obj2 = this.f4508e;
                if (obj2 == null || obj2 == obj) {
                    this.f4508e = obj;
                    long j3 = this.f4523u + 1;
                    this.f4523u = j3;
                    this.f4509f = j3;
                    d4 d4Var = new d4(this, false, obj, j3);
                    d4Var.a(5000L);
                    return d4Var;
                }
                try {
                    throw new IllegalStateException("remote sequence already owned");
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
            throw th;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final boolean c(f4 f4Var, int i3) {
        if (f4Var == null) {
            return false;
        }
        synchronized (this) {
            try {
                int i4 = f4Var.f3987h;
                h2 h2Var = null;
                if (i4 != 2) {
                    if (i4 == 3 && this.f4506c == f4Var) {
                        d();
                        this.f4506c = null;
                        this.f4517o = 0L;
                        f4Var.f3987h = 4;
                        f4Var.f3988i.f4240a = i3 == 3 ? 8 : 7;
                        h2 h2Var2 = f4Var.f3990k;
                        f4Var.f3990k = null;
                        h2Var = h2Var2;
                    }
                    return false;
                }
                if (!((ArrayDeque) this.f4504a.get(f4Var.f3981b)).remove(f4Var)) {
                    return false;
                }
                f4Var.f3987h = 4;
                f4Var.f3988i.f4240a = i3 == 3 ? 8 : 7;
                i(h2Var);
                j(f4Var, i3);
                g();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        c4 c4Var = this.f4515l;
        this.f4515l = null;
        this.f4519q = 0L;
        i(c4Var);
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this) {
            try {
                if (this.f4510g) {
                    return;
                }
                this.f4510g = true;
                d();
                c4 c4Var = this.f4516m;
                this.f4516m = null;
                i(c4Var);
                f4 f4Var = this.f4506c;
                if (f4Var != null) {
                    this.f4506c = null;
                    this.f4517o = 0L;
                    f4Var.f3987h = 4;
                    i4 i4Var = f4Var.f3988i;
                    if (i4Var != null) {
                        i4Var.f4240a = 8;
                    }
                    h2 h2Var = f4Var.f3990k;
                    f4Var.f3990k = null;
                    arrayList2.add(h2Var);
                    arrayList.add(f4Var);
                }
                int i3 = 0;
                for (e4 e4Var : e4.values()) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f4504a.get(e4Var);
                    while (!arrayDeque.isEmpty()) {
                        f4 f4Var2 = (f4) arrayDeque.removeFirst();
                        f4Var2.f3987h = 4;
                        f4Var2.f3988i.f4240a = 8;
                        arrayList.add(f4Var2);
                    }
                }
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    i((c4) obj);
                }
                int size2 = arrayList.size();
                while (i3 < size2) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    j((f4) obj2, 3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f() {
        o2 o2Var;
        if (this.f4520r <= 0 || (o2Var = this.f4513j) == null) {
            return false;
        }
        if (o2Var.m() < this.f4520r) {
            l();
            return true;
        }
        this.f4520r = 0L;
        c4 c4Var = this.f4516m;
        this.f4516m = null;
        i(c4Var);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0120, code lost:
    
        if (r5 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0124, code lost:
    
        i(r14);
        r3 = g.d.a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x012b, code lost:
    
        if (r3 == 1) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x012d, code lost:
    
        r0 = r0.f3984e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x012f, code lost:
    
        if (r3 == 2) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0131, code lost:
    
        r0.b0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0136, code lost:
    
        r0.a0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x013b, code lost:
    
        r0.f3984e.Z();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.m4.g():void");
    }

    public final f4 h() {
        Object obj = this.f4508e;
        e4 e4Var = e4.f3869d;
        EnumMap enumMap = this.f4504a;
        if (obj != null) {
            if (f()) {
                return null;
            }
            Object obj2 = this.f4508e;
            Iterator it = ((ArrayDeque) enumMap.get(e4Var)).iterator();
            while (it.hasNext()) {
                f4 f4Var = (f4) it.next();
                if (f4Var.f3980a == obj2) {
                    it.remove();
                    return f4Var;
                }
            }
            return null;
        }
        f4 f4Var2 = (f4) ((ArrayDeque) enumMap.get(e4.f3868c)).pollFirst();
        if (f4Var2 != null) {
            return f4Var2;
        }
        if (this.f4507d != 0 || f()) {
            return null;
        }
        f4 f4Var3 = (f4) ((ArrayDeque) enumMap.get(e4Var)).pollFirst();
        if (f4Var3 != null) {
            return f4Var3;
        }
        f4 f4Var4 = (f4) ((ArrayDeque) enumMap.get(e4.f3870e)).pollFirst();
        return f4Var4 != null ? f4Var4 : (f4) ((ArrayDeque) enumMap.get(e4.f3871f)).pollFirst();
    }

    public final boolean k(f4 f4Var, boolean z2) {
        m4 m4Var;
        if (this.f4514k == null || this.f4513j == null) {
            return false;
        }
        long j3 = f4Var.f3989j;
        long j4 = this.f4518p + 1;
        this.f4518p = j4;
        this.f4519q = j4;
        try {
            m4Var = this;
            try {
                c4 c4VarC = this.f4514k.c(z2 ? 10000L : Math.max(2000L, Math.min(10000L, f4Var.f3985f + 2000)), new e2.j1(m4Var, f4Var, j3, j4));
                if (m4Var.f4506c == f4Var && f4Var.f3987h == 3 && m4Var.f4517o == j3 && m4Var.f4519q == j4) {
                    m4Var.f4515l = c4VarC;
                    return true;
                }
                i(c4VarC);
                return true;
            } catch (Throwable unused) {
                if (m4Var.f4519q != j4) {
                    return false;
                }
                m4Var.f4515l = null;
                m4Var.f4519q = 0L;
                return false;
            }
        } catch (Throwable unused2) {
            m4Var = this;
        }
    }

    public final void l() {
        o2 o2Var;
        if (this.f4514k == null || (o2Var = this.f4513j) == null) {
            return;
        }
        long j3 = this.f4520r;
        if (j3 <= 0 || this.f4516m != null || this.f4510g) {
            return;
        }
        try {
            this.f4516m = this.f4514k.c(Math.max(1L, j3 - o2Var.m()), new a2.b(20, this));
        } catch (Throwable unused) {
            this.f4516m = null;
            this.f4520r = 0L;
        }
    }

    public final int m(f4 f4Var) {
        int i3;
        int i4;
        int i5;
        synchronized (this) {
            try {
                i3 = 1;
                if (f4Var.f3987h != 1) {
                    throw new IllegalStateException("request already submitted");
                }
                if (this.f4510g) {
                    f4Var.f3987h = 4;
                    i3 = 3;
                    i4 = 8;
                } else {
                    ArrayDeque arrayDeque = (ArrayDeque) this.f4504a.get(f4Var.f3981b);
                    if (arrayDeque.size() >= ((Integer) this.f4505b.get(f4Var.f3981b)).intValue()) {
                        f4Var.f3987h = 4;
                        i4 = 7;
                    } else {
                        f4Var.f3987h = 2;
                        i4 i4Var = new i4();
                        i4Var.f4240a = 2;
                        f4Var.f3988i = i4Var;
                        arrayDeque.addLast(f4Var);
                        i3 = 0;
                        i4 = 0;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i3 != 0) {
            j(f4Var, i3);
            return i4;
        }
        g();
        synchronized (this) {
            i5 = f4Var.f3988i.f4240a;
        }
        return i5;
    }
}
