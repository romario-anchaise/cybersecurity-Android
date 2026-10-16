// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b2.e;
import com.google.android.gms.common.api.Scope;
import e0.d;
import e0.f;
import e2.n1;
import f0.c;
import h0.a0;
import h0.b;
import h0.b0;
import h0.n;
import h0.o;
import h0.r;
import h0.s;
import h0.t;
import h0.u;
import h0.v;
import h0.w;
import h0.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import w1.o2;
import y.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d[] f476x = new d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IInterface f486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t f488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f489m;
    public final n1 n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n1 f490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile String f493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e0.b f494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile w f496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set f498w;

    public a(Context context, Looper looper, int i3, m mVar, c cVar, f0.d dVar) {
        synchronized (a0.f1856g) {
            try {
                if (a0.f1857h == null) {
                    a0.f1857h = new a0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a0 a0Var = a0.f1857h;
        Object obj = e0.e.f670c;
        o.c(cVar);
        o.c(dVar);
        n1 n1Var = new n1(cVar);
        n1 n1Var2 = new n1(dVar);
        String str = (String) mVar.f5994d;
        this.f477a = null;
        this.f482f = new Object();
        this.f483g = new Object();
        this.f487k = new ArrayList();
        this.f489m = 1;
        this.f494s = null;
        this.f495t = false;
        this.f496u = null;
        this.f497v = new AtomicInteger(0);
        o.d(context, "Context must not be null");
        this.f479c = context;
        o.d(looper, "Looper must not be null");
        o.d(a0Var, "Supervisor must not be null");
        this.f480d = a0Var;
        this.f481e = new r(this, looper);
        this.f491p = i3;
        this.n = n1Var;
        this.f490o = n1Var2;
        this.f492q = str;
        Set set = (Set) mVar.f5993c;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                o2.k("Expanding scopes is not permitted, use implied scopes instead");
                throw null;
            }
        }
        this.f498w = set;
    }

    public abstract IInterface a(IBinder iBinder);

    public final void b(String str) {
        this.f477a = str;
        this.f497v.incrementAndGet();
        ArrayList arrayList = this.f487k;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    h0.m mVar = (h0.m) arrayList.get(i3);
                    synchronized (mVar) {
                        mVar.f1911a = null;
                    }
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f483g) {
            this.f484h = null;
        }
        n(1, null);
    }

    public abstract d[] c();

    public abstract Bundle d();

    public abstract int e();

    public final void f(h0.e eVar, Set set) {
        Bundle bundleD = d();
        String str = this.f493r;
        int i3 = this.f491p;
        int i4 = f.f672a;
        Scope[] scopeArr = h0.d.f1872q;
        Bundle bundle = new Bundle();
        d[] dVarArr = h0.d.f1873r;
        h0.d dVar = new h0.d(6, i3, i4, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        dVar.f1877f = this.f479c.getPackageName();
        dVar.f1880i = bundleD;
        if (set != null) {
            dVar.f1879h = (Scope[]) set.toArray(new Scope[0]);
        }
        if (l()) {
            dVar.f1881j = new Account("<<default account>>", "com.google");
            if (eVar != null) {
                dVar.f1878g = ((b0) eVar).f1865a;
            }
        }
        dVar.f1882k = f476x;
        dVar.f1883l = c();
        try {
            try {
                synchronized (this.f483g) {
                    try {
                        n nVar = this.f484h;
                        if (nVar != null) {
                            nVar.a(new s(this, this.f497v.get()), dVar);
                        } else {
                            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (RemoteException | RuntimeException e3) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
                int i5 = this.f497v.get();
                u uVar = new u(this, 8, null, null);
                r rVar = this.f481e;
                rVar.sendMessage(rVar.obtainMessage(1, i5, -1, uVar));
            }
        } catch (DeadObjectException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            int i6 = this.f497v.get();
            r rVar2 = this.f481e;
            rVar2.sendMessage(rVar2.obtainMessage(6, i6, 3));
        } catch (SecurityException e5) {
            throw e5;
        }
    }

    public abstract String g();

    public abstract String h();

    public abstract boolean i();

    public final boolean j() {
        boolean z2;
        synchronized (this.f482f) {
            z2 = this.f489m == 4;
        }
        return z2;
    }

    public final boolean k() {
        boolean z2;
        synchronized (this.f482f) {
            int i3 = this.f489m;
            z2 = true;
            if (i3 != 2 && i3 != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    public boolean l() {
        return false;
    }

    public final /* synthetic */ boolean m(int i3, int i4, IInterface iInterface) {
        synchronized (this.f482f) {
            try {
                if (this.f489m != i3) {
                    return false;
                }
                n(i4, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(int i3, IInterface iInterface) {
        e eVar;
        if ((i3 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f482f) {
            try {
                this.f489m = i3;
                this.f486j = iInterface;
                Bundle bundle = null;
                if (i3 == 1) {
                    t tVar = this.f488l;
                    if (tVar != null) {
                        a0 a0Var = this.f480d;
                        String str = this.f478b.f273c;
                        o.c(str);
                        this.f478b.getClass();
                        if (this.f492q == null) {
                            this.f479c.getClass();
                        }
                        a0Var.b(str, tVar, this.f478b.f272b);
                        this.f488l = null;
                    }
                } else if (i3 == 2 || i3 == 3) {
                    t tVar2 = this.f488l;
                    if (tVar2 != null && (eVar = this.f478b) != null) {
                        String str2 = eVar.f273c;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str2);
                        sb.append(" on com.google.android.gms");
                        Log.e("GmsClient", sb.toString());
                        a0 a0Var2 = this.f480d;
                        String str3 = this.f478b.f273c;
                        o.c(str3);
                        this.f478b.getClass();
                        if (this.f492q == null) {
                            this.f479c.getClass();
                        }
                        a0Var2.b(str3, tVar2, this.f478b.f272b);
                        this.f497v.incrementAndGet();
                    }
                    t tVar3 = new t(this, this.f497v.get());
                    this.f488l = tVar3;
                    this.f478b = new e(h(), i(), 6);
                    if (e() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f478b.f273c)));
                    }
                    a0 a0Var3 = this.f480d;
                    String str4 = this.f478b.f273c;
                    o.c(str4);
                    this.f478b.getClass();
                    String name = this.f492q;
                    if (name == null) {
                        name = this.f479c.getClass().getName();
                    }
                    e0.b bVarA = a0Var3.a(new x(str4, this.f478b.f272b), tVar3, name);
                    if (!(bVarA.f659d == 0)) {
                        String str5 = this.f478b.f273c;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str5);
                        sb2.append(" on com.google.android.gms");
                        Log.w("GmsClient", sb2.toString());
                        int i4 = bVarA.f659d;
                        if (i4 == -1) {
                            i4 = 16;
                        }
                        if (bVarA.f660e != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", bVarA.f660e);
                        }
                        int i5 = this.f497v.get();
                        v vVar = new v(this, i4, bundle);
                        r rVar = this.f481e;
                        rVar.sendMessage(rVar.obtainMessage(7, i5, -1, vVar));
                    }
                } else if (i3 == 4) {
                    o.c(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
