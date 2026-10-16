// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl;

import android.content.Context;
import d.b;
import e2.n1;
import g.f;
import g.j;
import j.d;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c;
import y.e;
import y.h;
import y.i;
import y.l;
import y.m;
import y.p;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile p f220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile c f221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile r f222m;
    public volatile i n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile l f223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile m f224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile e f225q;

    @Override // androidx.work.impl.WorkDatabase
    public final f d() {
        return new f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.work.impl.WorkDatabase
    public final d e(b bVar) {
        return ((j.c) bVar.f512g).a(new j.b((Context) bVar.f511f, bVar.f506a, new j(bVar, new n1(this)), false, false));
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c f() {
        c cVar;
        if (this.f221l != null) {
            return this.f221l;
        }
        synchronized (this) {
            try {
                if (this.f221l == null) {
                    this.f221l = new c(this);
                }
                cVar = this.f221l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final List g(Map map) {
        return Arrays.asList(new q.e(13, 14, 9), new q.e());
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Set i() {
        return new HashSet();
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Map j() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(p.class, list);
        map.put(c.class, list);
        map.put(r.class, list);
        map.put(i.class, list);
        map.put(l.class, list);
        map.put(m.class, list);
        map.put(e.class, list);
        map.put(y.f.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e l() {
        e eVar;
        if (this.f225q != null) {
            return this.f225q;
        }
        synchronized (this) {
            try {
                if (this.f225q == null) {
                    e eVar2 = new e();
                    eVar2.f5976c = this;
                    eVar2.f5977d = new y.b(this);
                    this.f225q = eVar2;
                }
                eVar = this.f225q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final i p() {
        i iVar;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            try {
                if (this.n == null) {
                    i iVar2 = new i();
                    iVar2.f5983a = this;
                    iVar2.f5984b = new y.b(this, 2);
                    iVar2.f5985c = new h(this, 0);
                    iVar2.f5986d = new h(this, 1);
                    this.n = iVar2;
                }
                iVar = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final l r() {
        l lVar;
        if (this.f223o != null) {
            return this.f223o;
        }
        synchronized (this) {
            try {
                if (this.f223o == null) {
                    l lVar2 = new l();
                    lVar2.f5991c = this;
                    lVar2.f5992d = new y.b(this, 3);
                    this.f223o = lVar2;
                }
                lVar = this.f223o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m s() {
        m mVar;
        if (this.f224p != null) {
            return this.f224p;
        }
        synchronized (this) {
            try {
                if (this.f224p == null) {
                    this.f224p = new m(this);
                }
                mVar = this.f224p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final p t() {
        p pVar;
        if (this.f220k != null) {
            return this.f220k;
        }
        synchronized (this) {
            try {
                if (this.f220k == null) {
                    this.f220k = new p(this);
                }
                pVar = this.f220k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final r u() {
        r rVar;
        if (this.f222m != null) {
            return this.f222m;
        }
        synchronized (this) {
            try {
                if (this.f222m == null) {
                    r rVar2 = new r();
                    rVar2.f6032a = this;
                    rVar2.f6033b = new y.b(this, 6);
                    rVar2.f6034c = new h(this, 16);
                    this.f222m = rVar2;
                }
                rVar = this.f222m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }
}
