// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Future {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f28f = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f29g = Logger.getLogger(j.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q2.c f30h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f31i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f32c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f33d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile i f34e;

    static {
        q2.c hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, i.class, "e"), AtomicReferenceFieldUpdater.newUpdater(j.class, e.class, "d"), AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "c"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f30h = hVar;
        if (th != null) {
            f29g.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f31i = new Object();
    }

    public static void c(j jVar) {
        e eVar;
        e eVar2;
        e eVar3 = null;
        while (true) {
            i iVar = jVar.f34e;
            if (f30h.f(jVar, iVar, i.f25c)) {
                while (iVar != null) {
                    Thread thread = iVar.f26a;
                    if (thread != null) {
                        iVar.f26a = null;
                        LockSupport.unpark(thread);
                    }
                    iVar = iVar.f27b;
                }
                do {
                    eVar = jVar.f33d;
                } while (!f30h.d(jVar, eVar, e.f14d));
                while (true) {
                    eVar2 = eVar3;
                    eVar3 = eVar;
                    if (eVar3 == null) {
                        break;
                    }
                    eVar = eVar3.f17c;
                    eVar3.f17c = eVar2;
                }
                while (eVar2 != null) {
                    eVar3 = eVar2.f17c;
                    Runnable runnable = eVar2.f15a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        jVar = gVar.f23c;
                        if (jVar.f32c == gVar) {
                            if (f30h.e(jVar, gVar, f(gVar.f24d))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, eVar2.f16b);
                    }
                    eVar2 = eVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            f29g.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f11b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f13a);
        }
        if (obj == f31i) {
            return null;
        }
        return obj;
    }

    public static Object f(j jVar) {
        Object obj;
        if (jVar != null) {
            Object obj2 = jVar.f32c;
            if (!(obj2 instanceof b)) {
                return obj2;
            }
            b bVar = (b) obj2;
            if (bVar.f10a) {
                return bVar.f11b != null ? new b(false, bVar.f11b) : b.f9d;
            }
            return obj2;
        }
        boolean z2 = jVar.f32c instanceof b;
        boolean z3 = true;
        if ((!f28f) && z2) {
            return b.f9d;
        }
        boolean z4 = false;
        while (true) {
            try {
                try {
                    obj = jVar.get();
                    break;
                } catch (CancellationException e3) {
                    if (z2) {
                        return new b(false, e3);
                    }
                    return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + jVar, e3));
                } catch (ExecutionException e4) {
                    return new d(e4.getCause());
                } catch (Throwable th) {
                    return new d(th);
                }
            } catch (InterruptedException unused) {
                z4 = z3;
            } catch (Throwable th2) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return obj == null ? f31i : obj;
    }

    public final void a(StringBuilder sb) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e3) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e3.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e4) {
                sb.append("FAILURE, cause=[");
                sb.append(e4.getCause());
                sb.append("]");
                return;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    public final void b(Runnable runnable, Executor executor) {
        executor.getClass();
        e eVar = this.f33d;
        e eVar2 = e.f14d;
        if (eVar != eVar2) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.f17c = eVar;
                if (f30h.d(this, eVar, eVar3)) {
                    return;
                } else {
                    eVar = this.f33d;
                }
            } while (eVar != eVar2);
        }
        d(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        b bVar;
        Object obj = this.f32c;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f28f) {
            bVar = new b(z2, new CancellationException("Future.cancel() was called."));
        } else {
            bVar = z2 ? b.f8c : b.f9d;
        }
        boolean z3 = false;
        while (true) {
            if (f30h.e(this, obj, bVar)) {
                c(this);
                if (!(obj instanceof g)) {
                    break;
                }
                this = ((g) obj).f24d;
                if (this == null) {
                    this.cancel(z2);
                    break;
                }
                obj = this.f32c;
                if (!(obj == null) && !(obj instanceof g)) {
                    break;
                }
                z3 = true;
            } else {
                obj = this.f32c;
                if (!(obj instanceof g)) {
                    return z3;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g() {
        Object obj = this.f32c;
        if (obj instanceof g) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            j jVar = ((g) obj).f24d;
            sb.append(jVar == this ? "this future" : String.valueOf(jVar));
            sb.append("]");
            return sb.toString();
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z2;
        i iVar = i.f25c;
        long nanos = timeUnit.toNanos(j3);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f32c;
        if ((obj != null) && (!(obj instanceof g))) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar2 = this.f34e;
            if (iVar2 != iVar) {
                i iVar3 = new i();
                z2 = true;
                while (true) {
                    q2.c cVar = f30h;
                    cVar.y(iVar3, iVar2);
                    if (cVar.f(this, iVar2, iVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(iVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f32c;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(iVar3);
                        break;
                    }
                    iVar2 = this.f34e;
                    if (iVar2 == iVar) {
                    }
                }
            }
            return e(this.f32c);
        }
        z2 = true;
        while (nanos > 0) {
            Object obj3 = this.f32c;
            if ((obj3 != null ? z2 : false) && (!(obj3 instanceof g))) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbJ = a.j(j3, "Waited ", " ");
        sbJ.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbJ.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string3.concat(" (plus ");
            long j4 = -nanos;
            long jConvert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
            long nanos2 = j4 - timeUnit.toNanos(jConvert);
            boolean z3 = (jConvert == 0 || nanos2 > 1000) ? z2 : false;
            if (jConvert > 0) {
                String strConcat2 = strConcat + jConvert + " " + lowerCase;
                if (z3) {
                    strConcat2 = strConcat2.concat(",");
                }
                strConcat = strConcat2.concat(" ");
            }
            if (z3) {
                strConcat = strConcat + nanos2 + " nanoseconds ";
            }
            string3 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(string3 + " for " + string);
    }

    public final void h(i iVar) {
        iVar.f26a = null;
        while (true) {
            i iVar2 = this.f34e;
            if (iVar2 == i.f25c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f27b;
                if (iVar2.f26a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f27b = iVar4;
                    if (iVar3.f26a == null) {
                    }
                } else if (!f30h.f(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f32c instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f32c;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f32c instanceof b) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e3) {
                strG = "Exception thrown from implementation: " + e3.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strG);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        i iVar = i.f25c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f32c;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar2 = this.f34e;
            if (iVar2 != iVar) {
                i iVar3 = new i();
                do {
                    q2.c cVar = f30h;
                    cVar.y(iVar3, iVar2);
                    if (cVar.f(this, iVar2, iVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f32c;
                            } else {
                                h(iVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar2 = this.f34e;
                } while (iVar2 != iVar);
            }
            return e(this.f32c);
        }
        throw new InterruptedException();
    }
}
