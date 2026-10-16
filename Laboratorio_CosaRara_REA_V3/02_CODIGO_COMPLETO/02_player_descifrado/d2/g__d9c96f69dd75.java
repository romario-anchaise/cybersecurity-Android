// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Clock;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements AutoCloseable {
    public static final HashMap A = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Clock f563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayBlockingQueue f565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o2 f570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f572m;
    public final b2.a n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f573o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f574p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicLong f575q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f576r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicReference f578t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f580v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f581w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Thread f582x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f583y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile d f584z;

    public g(File file, Clock clock, o2 o2Var) {
        b bVar = new b(0);
        b2.a aVar = new b2.a(2);
        this.f573o = new AtomicLong();
        this.f574p = new AtomicLong();
        this.f575q = new AtomicLong();
        this.f576r = new AtomicLong();
        this.f577s = new AtomicLong();
        this.f578t = new AtomicReference();
        this.f584z = new d(null, (System.currentTimeMillis() & 2305843009213693951L) << 1, false, 0L);
        if (clock == null) {
            throw new NullPointerException("directory, clock, and transitionObserver are required");
        }
        this.f562c = file;
        this.f563d = clock;
        this.f564e = new l(file);
        this.f565f = new ArrayBlockingQueue(8192);
        this.f566g = 128;
        this.f567h = 100000000L;
        this.f568i = 1000000000L;
        this.f569j = bVar;
        this.f570k = o2Var;
        this.n = aVar;
        this.f571l = new c(this, clock, 0);
        this.f572m = new f(this);
    }

    public static long B(Clock clock, ZoneId zoneId) {
        return Math.max(60000L, clock.instant().atZone(zoneId).toLocalDate().plusDays(1L).atStartOfDay(zoneId).toInstant().toEpochMilli() - clock.millis());
    }

    public final void A(e eVar) throws IOException {
        if (eVar.f555f == 0) {
            return;
        }
        eVar.f553d.flush();
        b2.a aVar = this.n;
        FileDescriptor fd = eVar.f552c.getFD();
        aVar.getClass();
        fd.sync();
        long j3 = eVar.f555f;
        eVar.f555f = 0L;
        eVar.f554e = eVar.f551b.length();
        this.f574p.addAndGet(j3);
        this.f577s.set(this.f563d.millis());
        this.f578t.set(null);
        d dVar = this.f584z;
        if (dVar.f548c || !eVar.f550a.equals(dVar.f546a)) {
            return;
        }
        long j4 = dVar.f549d;
        long j5 = eVar.f554e;
        if (j4 == j5) {
            return;
        }
        this.f584z = new d(dVar.f546a, dVar.f547b, false, j5);
        this.f569j.getClass();
    }

    public final synchronized void C(w wVar) {
        try {
            if (wVar == null) {
                throw new NullPointerException("record");
            }
            if (!this.f580v && !this.f581w) {
                if (!this.f565f.offer(wVar)) {
                    if (((w) this.f565f.poll()) != null) {
                        this.f575q.incrementAndGet();
                    }
                    if (!this.f565f.offer(wVar)) {
                        this.f575q.incrementAndGet();
                        return;
                    }
                }
                this.f573o.incrementAndGet();
                return;
            }
            this.f575q.incrementAndGet();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final e D(String str) {
        File file = this.f562c;
        if (!file.isDirectory() && !file.mkdirs() && !file.isDirectory()) {
            E(new IOException("cannot create keylog directory"));
            return null;
        }
        try {
            File file2 = new File(file, str.concat(".ndjson"));
            this.f564e.c(file2);
            FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
            return new e(str, file2, fileOutputStream, new BufferedOutputStream(fileOutputStream, 65536), file2.length());
        } catch (IOException e3) {
            E(e3);
            return null;
        }
    }

    public final void E(Throwable th) {
        this.f576r.incrementAndGet();
        this.f578t.set(th == null ? "IOException" : th.getClass().getSimpleName());
    }

    public final void F() {
        String str = this.f583y;
        if (str == null) {
            return;
        }
        HashMap map = A;
        synchronized (map) {
            try {
                if (map.get(str) == this) {
                    map.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f583y = null;
    }

    public final synchronized void G() {
        if (this.f579u) {
            return;
        }
        try {
            String canonicalPath = this.f562c.getCanonicalPath();
            HashMap map = A;
            synchronized (map) {
                try {
                    g gVar = (g) map.get(canonicalPath);
                    if (gVar != null && gVar != this) {
                        throw new IllegalStateException("keylog writer already active for directory " + canonicalPath);
                    }
                    map.put(canonicalPath, this);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f583y = canonicalPath;
            this.f579u = true;
            try {
                this.f564e.d();
            } catch (IOException e3) {
                E(e3);
            }
            this.f572m.c();
            if (this.f565f.isEmpty()) {
                this.f572m.b(null);
            }
            Thread thread = new Thread(new a2.b(6, this), "keylog-daily-writer");
            this.f582x = thread;
            thread.setDaemon(true);
            this.f582x.start();
        } catch (IOException e4) {
            throw new IllegalStateException("cannot resolve keylog directory", e4);
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (this.f581w) {
                    return;
                }
                this.f580v = true;
                G();
                Thread thread = this.f582x;
                thread.interrupt();
                boolean z2 = false;
                while (thread.isAlive()) {
                    try {
                        thread.join();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
                synchronized (this) {
                    this.f581w = true;
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        d dVar = this.f584z;
        if (dVar.f548c) {
            return;
        }
        this.f584z = new d(dVar.f546a, dVar.f547b + 1, true, dVar.f549d);
        this.f569j.getClass();
    }

    public final void w(e eVar, IOException e3) {
        if (eVar == null) {
            if (e3 != null) {
                E(e3);
                return;
            }
            return;
        }
        if (e3 == null) {
            try {
                A(eVar);
            } catch (IOException e4) {
                e3 = e4;
            }
        }
        try {
            eVar.f553d.close();
        } catch (IOException e5) {
            if (e3 == null) {
                e3 = e5;
            } else {
                e3.addSuppressed(e5);
            }
        }
        if (e3 != null) {
            E(e3);
        }
    }

    public final void y(String str, long j3) {
        d dVar = this.f584z;
        this.f584z = new d(str, dVar.f547b + (dVar.f548c ? 1L : 2L), false, j3);
        this.f569j.getClass();
    }

    public final boolean z(long j3) {
        if (TimeUnit.NANOSECONDS == null) {
            throw new NullPointerException("unit");
        }
        if (j3 < 0) {
            o2.i("timeout must be non-negative");
            return false;
        }
        synchronized (this) {
            try {
                if (this.f581w) {
                    return true;
                }
                this.f580v = true;
                G();
                Thread thread = this.f582x;
                thread.interrupt();
                boolean z2 = false;
                if (thread == Thread.currentThread()) {
                    return false;
                }
                long jNanoTime = System.nanoTime();
                while (thread.isAlive()) {
                    long jNanoTime2 = j3 - (System.nanoTime() - jNanoTime);
                    if (jNanoTime2 <= 0) {
                        break;
                    }
                    long j4 = jNanoTime2 / 1000000;
                    try {
                        thread.join(j4, (int) (jNanoTime2 - TimeUnit.MILLISECONDS.toNanos(j4)));
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
                boolean zIsAlive = thread.isAlive();
                boolean z3 = !zIsAlive;
                if (!zIsAlive) {
                    synchronized (this) {
                        this.f581w = true;
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                return z3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
