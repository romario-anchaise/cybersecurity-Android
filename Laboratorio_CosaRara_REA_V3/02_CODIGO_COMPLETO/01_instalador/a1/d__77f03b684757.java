// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a1;

import A.C0005e;
import F0.h;
import F0.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f1235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f1236i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0005e f1237a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1240d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1238b = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f1241e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f1242f = new ArrayList();
    public final D.b g = new D.b(1, this);

    static {
        String str = Y0.b.g + " TaskRunner";
        i.e(str, "name");
        f1235h = new d(new C0005e(new Y0.a(str, true)));
        Logger logger = Logger.getLogger(d.class.getName());
        i.d(logger, "getLogger(TaskRunner::class.java.name)");
        f1236i = logger;
    }

    public d(C0005e c0005e) {
        this.f1237a = c0005e;
    }

    public static final void a(d dVar, a aVar) {
        dVar.getClass();
        byte[] bArr = Y0.b.f1119a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f1223a);
        try {
            long jA = aVar.a();
            synchronized (dVar) {
                dVar.b(aVar, jA);
            }
        } finally {
            synchronized (dVar) {
                dVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void b(a aVar, long j2) {
        byte[] bArr = Y0.b.f1119a;
        c cVar = aVar.f1225c;
        i.b(cVar);
        if (cVar.f1232d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z2 = cVar.f1234f;
        cVar.f1234f = false;
        cVar.f1232d = null;
        this.f1241e.remove(cVar);
        if (j2 != -1 && !z2 && !cVar.f1231c) {
            cVar.d(aVar, j2, true);
        }
        if (cVar.f1233e.isEmpty()) {
            return;
        }
        this.f1242f.add(cVar);
    }

    public final a c() {
        boolean z2;
        this = this;
        byte[] bArr = Y0.b.f1119a;
        while (true) {
            ArrayList arrayList = this.f1242f;
            if (arrayList.isEmpty()) {
                return null;
            }
            C0005e c0005e = this.f1237a;
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                a aVar2 = (a) ((c) it.next()).f1233e.get(0);
                long jMax = Math.max(0L, aVar2.f1226d - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z2 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            ArrayList arrayList2 = this.f1241e;
            if (aVar != null) {
                byte[] bArr2 = Y0.b.f1119a;
                aVar.f1226d = -1L;
                c cVar = aVar.f1225c;
                i.b(cVar);
                cVar.f1233e.remove(aVar);
                arrayList.remove(cVar);
                cVar.f1232d = aVar;
                arrayList2.add(cVar);
                if (z2 || (!this.f1239c && !arrayList.isEmpty())) {
                    D.b bVar = this.g;
                    i.e(bVar, "runnable");
                    ((ThreadPoolExecutor) c0005e.f34b).execute(bVar);
                }
                return aVar;
            }
            if (this.f1239c) {
                if (jMin < this.f1240d - jNanoTime) {
                    notify();
                }
                return null;
            }
            this.f1239c = true;
            this.f1240d = jNanoTime + jMin;
            try {
                try {
                    long j2 = jMin / 1000000;
                    long j3 = jMin - (1000000 * j2);
                    if (j2 > 0 || jMin > 0) {
                        wait(j2, (int) j3);
                    }
                } catch (InterruptedException unused) {
                    for (int size = arrayList2.size() - 1; -1 < size; size--) {
                        ((c) arrayList2.get(size)).b();
                    }
                    int i2 = -1;
                    for (int size2 = arrayList.size() - 1; i2 < size2; size2--) {
                        c cVar2 = (c) arrayList.get(size2);
                        cVar2.b();
                        if (cVar2.f1233e.isEmpty()) {
                            arrayList.remove(size2);
                        }
                        i2 = -1;
                    }
                }
                this.f1239c = false;
            } catch (Throwable th) {
                this.f1239c = false;
                throw th;
            }
        }
    }

    public final void d(c cVar) {
        i.e(cVar, "taskQueue");
        byte[] bArr = Y0.b.f1119a;
        if (cVar.f1232d == null) {
            boolean zIsEmpty = cVar.f1233e.isEmpty();
            ArrayList arrayList = this.f1242f;
            if (zIsEmpty) {
                arrayList.remove(cVar);
            } else {
                i.e(arrayList, "<this>");
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        boolean z2 = this.f1239c;
        C0005e c0005e = this.f1237a;
        if (z2) {
            notify();
            return;
        }
        D.b bVar = this.g;
        i.e(bVar, "runnable");
        ((ThreadPoolExecutor) c0005e.f34b).execute(bVar);
    }

    public final c e() {
        int i2;
        synchronized (this) {
            i2 = this.f1238b;
            this.f1238b = i2 + 1;
        }
        return new c(this, h.b(i2, "Q"));
    }
}
