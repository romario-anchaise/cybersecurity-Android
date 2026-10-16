// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l2;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f2418e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2419f;

    public c(e eVar, String str) {
        this.f2414a = eVar;
        this.f2415b = str;
    }

    public final void a() {
        byte[] bArr = j2.b.f2361a;
        synchronized (this.f2414a) {
            if (b()) {
                this.f2414a.d(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f2417d;
        if (aVar != null && aVar.f2409b) {
            this.f2419f = true;
        }
        ArrayList arrayList = this.f2418e;
        boolean z2 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f2409b) {
                a aVar2 = (a) arrayList.get(size);
                if (e.f2422i.isLoggable(Level.FINE)) {
                    q2.c.a(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(a aVar, long j3) {
        aVar.getClass();
        synchronized (this.f2414a) {
            if (!this.f2416c) {
                if (d(aVar, j3, false)) {
                    this.f2414a.d(this);
                }
            } else if (aVar.f2409b) {
                if (e.f2422i.isLoggable(Level.FINE)) {
                    q2.c.a(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.f2422i.isLoggable(Level.FINE)) {
                    q2.c.a(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[LOOP:0: B:23:0x0063->B:27:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[EDGE_INSN: B:39:0x0079->B:29:0x0079 BREAK  A[LOOP:0: B:23:0x0063->B:27:0x0075], SYNTHETIC] */
    public final boolean d(a aVar, long j3, boolean z2) {
        int size;
        int size2;
        int i3;
        Object obj;
        String strConcat;
        aVar.getClass();
        c cVar = aVar.f2410c;
        if (cVar != this) {
            if (cVar != null) {
                o2.k("task is in multiple queues");
                return false;
            }
            aVar.f2410c = this;
        }
        long jNanoTime = System.nanoTime();
        long j4 = jNanoTime + j3;
        ArrayList arrayList = this.f2418e;
        int iIndexOf = arrayList.indexOf(aVar);
        if (iIndexOf == -1) {
            aVar.f2411d = j4;
            if (e.f2422i.isLoggable(Level.FINE)) {
                if (z2) {
                    strConcat = "run again after ".concat(q2.c.l(j4 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(q2.c.l(j4 - jNanoTime));
                }
                q2.c.a(aVar, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i3 = 0;
            while (true) {
                if (i3 < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i3);
                i3++;
                if (((a) obj).f2411d - jNanoTime > j3) {
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, aVar);
            if (size2 == 0) {
                return true;
            }
        } else if (aVar.f2411d > j4) {
            arrayList.remove(iIndexOf);
            aVar.f2411d = j4;
            if (e.f2422i.isLoggable(Level.FINE)) {
                if (z2) {
                    strConcat = "run again after ".concat(q2.c.l(j4 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(q2.c.l(j4 - jNanoTime));
                }
                q2.c.a(aVar, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i3 = 0;
            while (true) {
                if (i3 < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i3);
                i3++;
                if (((a) obj).f2411d - jNanoTime > j3) {
                    break;
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, aVar);
            if (size2 == 0) {
                return true;
            }
        } else if (e.f2422i.isLoggable(Level.FINE)) {
            q2.c.a(aVar, this, "already scheduled");
            return false;
        }
        return false;
    }

    public final void e() {
        byte[] bArr = j2.b.f2361a;
        synchronized (this.f2414a) {
            this.f2416c = true;
            if (b()) {
                this.f2414a.d(this);
            }
        }
    }

    public final String toString() {
        return this.f2415b;
    }
}
