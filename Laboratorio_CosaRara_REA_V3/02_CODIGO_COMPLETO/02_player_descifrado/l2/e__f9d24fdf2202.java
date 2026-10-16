// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l2;

import a2.i;
import java.util.ArrayList;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f2421h = new e(new d(new j2.a(j2.b.f2367g + " TaskRunner", true)));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f2422i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2423a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2426d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2424b = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f2427e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f2428f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f2429g = new i(10, this);

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        logger.getClass();
        f2422i = logger;
    }

    public e(d dVar) {
        this.f2423a = dVar;
    }

    public static final void a(e eVar, a aVar) {
        byte[] bArr = j2.b.f2361a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f2408a);
        try {
            long jA = aVar.a();
            synchronized (eVar) {
                eVar.b(aVar, jA);
            }
        } finally {
            synchronized (eVar) {
                eVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void b(a aVar, long j3) {
        byte[] bArr = j2.b.f2361a;
        c cVar = aVar.f2410c;
        cVar.getClass();
        if (cVar.f2417d != aVar) {
            o2.k("Check failed.");
            return;
        }
        boolean z2 = cVar.f2419f;
        cVar.f2419f = false;
        cVar.f2417d = null;
        this.f2427e.remove(cVar);
        if (j3 != -1 && !z2 && !cVar.f2416c) {
            cVar.d(aVar, j3, true);
        }
        if (cVar.f2418e.isEmpty()) {
            return;
        }
        this.f2428f.add(cVar);
    }

    public final a c() {
        long j3;
        a aVar;
        boolean z2;
        byte[] bArr = j2.b.f2361a;
        while (true) {
            ArrayList arrayList = this.f2428f;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i3 = 0;
            a aVar2 = null;
            while (true) {
                if (i3 >= size) {
                    j3 = jNanoTime;
                    aVar = null;
                    z2 = false;
                    break;
                }
                Object obj = arrayList.get(i3);
                i3++;
                a aVar3 = (a) ((c) obj).f2418e.get(0);
                j3 = jNanoTime;
                aVar = null;
                long jMax = Math.max(0L, aVar3.f2411d - j3);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z2 = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
                jNanoTime = j3;
            }
            ArrayList arrayList2 = this.f2427e;
            if (aVar2 != null) {
                byte[] bArr2 = j2.b.f2361a;
                aVar2.f2411d = -1L;
                c cVar = aVar2.f2410c;
                cVar.getClass();
                cVar.f2418e.remove(aVar2);
                arrayList.remove(cVar);
                cVar.f2417d = aVar2;
                arrayList2.add(cVar);
                if (z2 || (!this.f2425c && !arrayList.isEmpty())) {
                    i iVar = this.f2429g;
                    iVar.getClass();
                    this.f2423a.f2420a.execute(iVar);
                }
                return aVar2;
            }
            if (this.f2425c) {
                if (jMin >= this.f2426d - j3) {
                    return aVar;
                }
                notify();
                return aVar;
            }
            this.f2425c = true;
            this.f2426d = j3 + jMin;
            try {
                try {
                    long j4 = jMin / 1000000;
                    long j5 = jMin - (1000000 * j4);
                    if (j4 > 0 || jMin > 0) {
                        wait(j4, (int) j5);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((c) arrayList2.get(size2)).b();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        c cVar2 = (c) arrayList.get(size3);
                        cVar2.b();
                        if (cVar2.f2418e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
                this.f2425c = false;
            } catch (Throwable th) {
                this.f2425c = false;
                throw th;
            }
        }
    }

    public final void d(c cVar) {
        cVar.getClass();
        byte[] bArr = j2.b.f2361a;
        if (cVar.f2417d == null) {
            boolean zIsEmpty = cVar.f2418e.isEmpty();
            ArrayList arrayList = this.f2428f;
            if (zIsEmpty) {
                arrayList.remove(cVar);
            } else {
                arrayList.getClass();
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (this.f2425c) {
            notify();
            return;
        }
        i iVar = this.f2429g;
        iVar.getClass();
        this.f2423a.f2420a.execute(iVar);
    }

    public final c e() {
        int i3;
        synchronized (this) {
            i3 = this.f2424b;
            this.f2424b = i3 + 1;
        }
        return new c(this, a0.a.g("Q", i3));
    }
}
