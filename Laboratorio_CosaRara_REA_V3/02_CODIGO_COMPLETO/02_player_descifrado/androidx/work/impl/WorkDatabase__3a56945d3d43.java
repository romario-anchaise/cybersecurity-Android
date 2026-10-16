// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl;

import android.database.Cursor;
import android.os.Looper;
import g.b;
import g.f;
import i1.q;
import i1.r;
import i1.s;
import j.d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k.c;
import q1.e;
import w1.o2;
import y.i;
import y.l;
import y.m;
import y.p;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f212c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f215f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f219j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f213d = d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f216g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReentrantReadWriteLock f217h = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ThreadLocal f218i = new ThreadLocal();

    public WorkDatabase() {
        Collections.synchronizedMap(new LinkedHashMap()).getClass();
        this.f219j = new LinkedHashMap();
    }

    public static Object q(Class cls, d dVar) {
        if (cls.isInstance(dVar)) {
            return dVar;
        }
        if (dVar instanceof b) {
            return q(cls, ((b) dVar).d());
        }
        return null;
    }

    public final void a() {
        if (!this.f214e && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            o2.k("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (h().r().C() || this.f218i.get() == null) {
            return;
        }
        o2.k("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public final void c() {
        a();
        a();
        c cVarR = h().r();
        this.f213d.c(cVarR);
        if (cVarR.D()) {
            cVarR.w();
        } else {
            cVarR.d();
        }
    }

    public abstract f d();

    public abstract d e(d.b bVar);

    public abstract y.c f();

    public List g(Map map) {
        map.getClass();
        return q.f2104c;
    }

    public final d h() {
        d dVar = this.f212c;
        if (dVar != null) {
            return dVar;
        }
        e.c("internalOpenHelper");
        throw null;
    }

    public Set i() {
        return s.f2106c;
    }

    public Map j() {
        return r.f2105c;
    }

    public final void k() {
        h().r().z();
        if (h().r().C()) {
            return;
        }
        f fVar = this.f213d;
        if (fVar.f1387e.compareAndSet(false, true)) {
            Executor executor = fVar.f1383a.f211b;
            if (executor != null) {
                executor.execute(fVar.f1394l);
            } else {
                e.c("internalQueryExecutor");
                throw null;
            }
        }
    }

    public abstract y.e l();

    public final Cursor m(j.f fVar) {
        a();
        b();
        return h().r().E(fVar);
    }

    public final Object n(Callable callable) {
        c();
        try {
            Object objCall = callable.call();
            o();
            return objCall;
        } finally {
            k();
        }
    }

    public final void o() {
        h().r().F();
    }

    public abstract i p();

    public abstract l r();

    public abstract m s();

    public abstract p t();

    public abstract y.r u();
}
