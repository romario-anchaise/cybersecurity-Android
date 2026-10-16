// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p025o;

import f1.l;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Future {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3981d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f3982e = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f3983f;
    public static final Object g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f3984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f3985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile f f3986c;

    static {
        l eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "c"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f3983f = eVar;
        if (th != null) {
            f3982e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    public static void b(g gVar) {
        f fVar;
        c cVar;
        do {
            fVar = gVar.f3986c;
        } while (!f3983f.i(gVar, fVar, f.f3978c));
        while (fVar != null) {
            Thread thread = fVar.f3979a;
            if (thread != null) {
                fVar.f3979a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f3980b;
        }
        do {
            cVar = gVar.f3985b;
        } while (!f3983f.g(gVar, cVar));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f3973a;
            cVar.f3973a = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            cVar2 = cVar2.f3973a;
            try {
                throw null;
            } catch (RuntimeException e2) {
                f3982e.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e2);
            }
        }
    }

    public static Object c(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            CancellationException cancellationException = ((a) obj).f3971a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof b) {
            ((b) obj).getClass();
            throw new ExecutionException((Throwable) null);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    public static Object d(g gVar) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = gVar.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objD = d(this);
            sb.append("SUCCESS, result=[");
            sb.append(objD == this ? "this future" : String.valueOf(objD));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        a aVar;
        Object obj = this.f3984a;
        if (obj != null) {
            return false;
        }
        if (f3981d) {
            aVar = new a(z2, new CancellationException("Future.cancel() was called."));
        } else {
            aVar = z2 ? a.f3969b : a.f3970c;
        }
        if (!f3983f.h(this, obj, aVar)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(f fVar) {
        fVar.f3979a = null;
        while (true) {
            f fVar2 = this.f3986c;
            if (fVar2 == f.f3978c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f3980b;
                if (fVar2.f3979a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f3980b = fVar4;
                    if (fVar3.f3979a == null) {
                    }
                } else if (!f3983f.i(this, fVar2, fVar4)) {
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f3984a;
        if (obj != null) {
            return c(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar = this.f3986c;
            f fVar2 = f.f3978c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                while (true) {
                    l lVar = f3983f;
                    lVar.P(fVar3, fVar);
                    if (lVar.i(this, fVar, fVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f3984a;
                            if (obj2 != null) {
                                return c(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        e(fVar3);
                        break;
                    }
                    fVar = this.f3986c;
                    if (fVar == fVar2) {
                    }
                }
            }
            return c(this.f3984a);
        }
        while (nanos > 0) {
            Object obj3 = this.f3984a;
            if (obj3 != null) {
                return c(obj3);
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
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z2) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z2) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3984a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3984a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f3984a instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
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
        if (!Thread.interrupted()) {
            Object obj2 = this.f3984a;
            if (obj2 != null) {
                return c(obj2);
            }
            f fVar = this.f3986c;
            f fVar2 = f.f3978c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                do {
                    l lVar = f3983f;
                    lVar.P(fVar3, fVar);
                    if (lVar.i(this, fVar, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3984a;
                            } else {
                                e(fVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return c(obj);
                    }
                    fVar = this.f3986c;
                } while (fVar != fVar2);
            }
            return c(this.f3984a);
        }
        throw new InterruptedException();
    }
}
