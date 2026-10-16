// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;
import org.json.JSONException;
import org.json.JSONObject;
import w1.ba;
import w1.o2;
import w1.pb;
import w1.ve;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ve f1650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w0.s f1651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z0 f1652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f1653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExecutorService f1654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f1655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f1656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f1657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f1658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f1659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f1660m;
    public final AtomicBoolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicInteger f1661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f1662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicLong f1663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f1664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f1665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicReference f1666t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f1667u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f1668v;

    public k0(String str, h2.e eVar, ve veVar, SocketFactory socketFactory) {
        z0 z0Var = new z0();
        this.f1653f = new o0(0);
        this.f1654g = Executors.newSingleThreadExecutor(new a2.l(10));
        this.f1655h = Executors.newSingleThreadScheduledExecutor(new a2.l(11));
        this.f1657j = new AtomicBoolean();
        this.f1658k = new AtomicBoolean();
        this.f1659l = new AtomicBoolean();
        this.f1660m = new AtomicBoolean();
        this.n = new AtomicBoolean();
        this.f1661o = new AtomicInteger();
        this.f1662p = new AtomicLong();
        this.f1663q = new AtomicLong();
        this.f1664r = new AtomicLong();
        this.f1665s = new AtomicBoolean();
        AtomicReference atomicReference = new AtomicReference(y());
        this.f1666t = atomicReference;
        this.f1667u = new Object();
        this.f1668v = new HashMap();
        Objects.requireNonNull(str, "gatewayUrl");
        Objects.requireNonNull(eVar, "credentials");
        this.f1656i = new AtomicReference(eVar);
        this.f1650c = veVar;
        this.f1652e = z0Var;
        r0 r0Var = (r0) atomicReference.get();
        if (r0Var == null) {
            throw new NullPointerException("next");
        }
        z0Var.t(r0Var);
        try {
            w0.s sVarA = w0.c.a(new URI(a0.h(str)), J(socketFactory));
            this.f1651d = sVarA;
            final int i3 = 4;
            sVarA.c("connect", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i3) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
            final int i4 = 5;
            sVarA.c("disconnect", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i4) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
            final int i5 = 0;
            sVarA.c("connect_error", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i5) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
            final int i6 = 1;
            sVarA.c("media:registered", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i6) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
            final int i7 = 2;
            sVarA.c("server:busy", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i7) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
            final int i8 = 3;
            sVarA.c("media:keyframe", new x0.a(this) { // from class: g2.e0

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k0 f1589b;

                {
                    this.f1589b = this;
                }

                @Override // x0.a
                public final void a(Object[] objArr) {
                    switch (i8) {
                        case 0:
                            k0 k0Var = this.f1589b;
                            if (k0Var.f1657j.get()) {
                                k0Var.G("connect_error");
                                return;
                            }
                            return;
                        case 1:
                            k0 k0Var2 = this.f1589b;
                            k0Var2.H(k0Var2.f1662p.get(), objArr);
                            return;
                        case 2:
                            this.f1589b.G("server_busy");
                            return;
                        case 3:
                            k0 k0Var3 = this.f1589b;
                            if (k0Var3.C()) {
                                JSONObject jSONObjectA = k0.A(objArr);
                                h2.e eVar2 = (h2.e) k0Var3.f1656i.get();
                                if (jSONObjectA == null || eVar2 == null) {
                                    return;
                                }
                                try {
                                    if (k0.S("version", jSONObjectA) == 1 && k0.T("generation", jSONObjectA) == eVar2.f1982d && k0.U("kind", jSONObjectA).equals("h264")) {
                                        k0Var3.N();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        case 4:
                            k0 k0Var4 = this.f1589b;
                            synchronized (k0Var4) {
                                if (k0Var4.f1657j.get()) {
                                    k0Var4.f1659l.set(false);
                                    k0Var4.f1663q.incrementAndGet();
                                    k0Var4.f1665s.set(false);
                                    k0Var4.d();
                                    k0Var4.f1653f.a();
                                    k0Var4.f1666t.set(k0.y());
                                    k0Var4.f1652e.t(k0.y());
                                    k0Var4.n.set(false);
                                    try {
                                        k0Var4.f1651d.a("media:register", k0.M((h2.e) k0Var4.f1656i.get()), new k(k0Var4, k0Var4.f1662p.incrementAndGet(), 1));
                                        break;
                                    } catch (RuntimeException unused2) {
                                        k0Var4.G("registration_emit_failed");
                                    }
                                    return;
                                }
                                return;
                            }
                        default:
                            k0 k0Var5 = this.f1589b;
                            synchronized (k0Var5) {
                                try {
                                    if (k0Var5.f1657j.get()) {
                                        k0Var5.f1662p.incrementAndGet();
                                        k0Var5.f1659l.set(false);
                                        k0Var5.f1663q.incrementAndGet();
                                        k0Var5.f1665s.set(false);
                                        k0Var5.d();
                                        k0Var5.f1653f.a();
                                        k0Var5.f1666t.set(k0.y());
                                        k0Var5.f1652e.t(k0.y());
                                        String strValueOf = (objArr == null || objArr.length <= 0) ? "media disconnected" : String.valueOf(objArr[0]);
                                        IOException iOException = new IOException("Socket.IO media disconnected: ".concat(strValueOf));
                                        Log.w("SocketMediaClient", "media transport disconnected reason=".concat(strValueOf));
                                        ve veVar2 = k0Var5.f1650c;
                                        if (veVar2 != null) {
                                            try {
                                                veVar2.f5338c.f3702f.execute(new q.r(veVar2, k0Var5, strValueOf, iOException, 5));
                                                break;
                                            } catch (RuntimeException unused3) {
                                            }
                                        }
                                        if ("io server disconnect".equalsIgnoreCase(strValueOf)) {
                                            AtomicBoolean atomicBoolean = k0Var5.n;
                                            if (atomicBoolean.compareAndSet(false, true)) {
                                                try {
                                                    k0Var5.f1655h.schedule(new f0(k0Var5, 0), Math.min(10000L, 1000 << Math.min(k0Var5.f1661o.getAndIncrement(), 4)), TimeUnit.MILLISECONDS);
                                                } catch (RejectedExecutionException unused4) {
                                                    atomicBoolean.set(false);
                                                }
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                    }
                }
            });
        } catch (URISyntaxException e3) {
            throw new IllegalArgumentException("invalid gateway URL", e3);
        }
    }

    public static JSONObject A(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        for (Object obj : objArr) {
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
        }
        return null;
    }

    public static int B(JSONObject jSONObject, String str, int i3) throws IOException {
        int iS = S(str, jSONObject);
        if (iS > 0 && iS <= i3) {
            return iS;
        }
        o2.l(str.concat(" media window out of range"));
        return 0;
    }

    public static r0 F(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            o2.l("media registration required");
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mediaTransport");
        if (jSONObjectOptJSONObject == null) {
            o2.l("media transport capability required");
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("windows");
        if (jSONObjectOptJSONObject2 != null) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(jSONObjectOptJSONObject.opt("frameEvents")) && bool.equals(jSONObjectOptJSONObject.opt("perKindCredits"))) {
                try {
                    int iS = S("maxFrameBytes", jSONObjectOptJSONObject);
                    if (S("version", jSONObjectOptJSONObject) != 2 || iS <= 0 || iS > 33554432) {
                        throw new IOException("invalid media transport version or frame limit");
                    }
                    return new r0(true, B(jSONObjectOptJSONObject2, "h264", 8), B(jSONObjectOptJSONObject2, "webp", 2), B(jSONObjectOptJSONObject2, "nodes", 2), B(jSONObjectOptJSONObject2, "camera", 2), iS);
                } catch (IllegalArgumentException e3) {
                    throw new IOException("invalid media transport grant", e3);
                }
            }
        }
        o2.l("current media transport capability required");
        return null;
    }

    public static w0.b J(SocketFactory socketFactory) {
        w0.b bVar = new w0.b();
        bVar.f6099b = "/stream/socket.io/";
        bVar.f6069k = new String[]{"websocket"};
        bVar.f3376s = true;
        bVar.n = true;
        bVar.f3372o = Integer.MAX_VALUE;
        bVar.f3373p = 1000L;
        bVar.f3374q = 10000L;
        bVar.f3375r = Collections.singletonMap("role", "media");
        i2.t tVar = new i2.t();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        tVar.f2234w = j2.b.b(0L, timeUnit);
        timeUnit.getClass();
        tVar.f2235x = j2.b.b(0L, timeUnit);
        if (socketFactory != null) {
            tVar.a(socketFactory);
        }
        i2.u uVar = new i2.u(tVar);
        bVar.f6107j = uVar;
        bVar.f6106i = uVar;
        return bVar;
    }

    public static boolean L(JSONObject jSONObject, h2.e eVar) {
        return jSONObject != null && S("version", jSONObject) == 1 && U("deviceId", jSONObject).equals(eVar.f1979a) && U("sessionId", jSONObject).equals(eVar.f1980b) && T("generation", jSONObject) == eVar.f1982d && T("serverTime", jSONObject) >= 0;
    }

    public static JSONObject M(h2.e eVar) {
        try {
            return new JSONObject().put("version", 1).put("deviceId", eVar.f1979a).put("sessionId", eVar.f1980b).put("mediaToken", eVar.f1981c).put("generation", eVar.f1982d).put("mediaTransport", P());
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static JSONObject P() {
        try {
            return new JSONObject().put("version", 2).put("frameEvents", true).put("perKindCredits", true).put("windows", new JSONObject().put("h264", 8).put("webp", 2).put("nodes", 2).put("camera", 2)).put("maxFrameBytes", 33554432);
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static boolean Q(h2.e eVar, h2.e eVar2) {
        return eVar != null && eVar2 != null && eVar.f1982d == eVar2.f1982d && eVar.f1979a.equals(eVar2.f1979a) && eVar.f1980b.equals(eVar2.f1980b);
    }

    public static int S(String str, JSONObject jSONObject) throws IOException {
        long jT = T(str, jSONObject);
        if (jT >= -2147483648L && jT <= 2147483647L) {
            return (int) jT;
        }
        o2.l(str.concat(" out of range"));
        return 0;
    }

    public static long T(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (!(objOpt instanceof Number)) {
            o2.l(str.concat(" must be an integer"));
            return 0L;
        }
        Number number = (Number) objOpt;
        long jLongValue = number.longValue();
        if (number.doubleValue() == jLongValue) {
            return jLongValue;
        }
        o2.l(str.concat(" must be an integer"));
        return 0L;
    }

    public static String U(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        o2.l(str.concat(" must be a string"));
        return null;
    }

    public static r0 y() {
        return new r0(true, 8, 2, 2, 2, 33554432);
    }

    public final boolean C() {
        return this.f1657j.get() && this.f1659l.get() && this.f1651d.f3425b;
    }

    public final void D() {
        if (((r0) this.f1666t.get()).f1723a) {
            long jNanoTime = System.nanoTime();
            AtomicLong atomicLong = this.f1664r;
            long j3 = atomicLong.get();
            if ((j3 == 0 || jNanoTime >= j3) && atomicLong.compareAndSet(j3, jNanoTime + 15000000000L)) {
                for (Map.Entry entry : R().f1646h.entrySet()) {
                    i0 i0Var = (i0) entry.getValue();
                    StringBuilder sb = new StringBuilder("Socket.IO media lane stats kind=");
                    sb.append((String) entry.getKey());
                    sb.append(" produced=");
                    long j4 = i0Var.f1612a;
                    long j5 = i0Var.f1626p;
                    sb.append(j4);
                    sb.append(" sent=");
                    sb.append(i0Var.f1613b);
                    sb.append(" superseded=");
                    sb.append(i0Var.f1614c);
                    sb.append(" failed=");
                    sb.append(i0Var.f1615d);
                    sb.append(" queuedBytes=");
                    sb.append(i0Var.f1619h);
                    sb.append(" inFlightBytes=");
                    sb.append(i0Var.f1620i);
                    sb.append(" enqueueToSendUs=");
                    sb.append(i0Var.f1627q);
                    sb.append(" sendUs=");
                    sb.append(i0Var.f1630t);
                    sb.append(" ackP50Ms=");
                    sb.append(i0Var.f1624m);
                    sb.append(" ackP95Ms=");
                    sb.append(i0Var.n);
                    sb.append(" latestDrops=");
                    sb.append(i0Var.f1616e);
                    sb.append(" boundsDrops=");
                    sb.append(i0Var.f1617f);
                    sb.append(" framesAdmitted=");
                    sb.append(Math.max(0L, i0Var.f1618g - j5));
                    sb.append(" timeouts=");
                    sb.append(i0Var.f1625o);
                    sb.append(" nacks=");
                    sb.append(j5);
                    Log.i("SocketMediaClient", sb.toString());
                }
            }
        }
    }

    public final void E() {
        boolean z2;
        z0 z0Var = this.f1652e;
        synchronized (z0Var.f1834a) {
            z2 = z0Var.f1852t;
            z0Var.f1852t = false;
        }
        if (z2) {
            N();
        }
    }

    public final void G(String str) {
        ve veVar = this.f1650c;
        if (veVar != null) {
            try {
                veVar.f5338c.f3702f.execute(new e2.q0(veVar, this, str, 20));
            } catch (RuntimeException unused) {
            }
        }
    }

    public final synchronized void H(long j3, Object... objArr) {
        try {
            if (j3 == this.f1662p.get() && this.f1657j.get() && this.f1651d.f3425b) {
                JSONObject jSONObjectA = A(objArr);
                h2.e eVar = (h2.e) this.f1656i.get();
                try {
                    if (L(jSONObjectA, eVar)) {
                        if (this.f1659l.get()) {
                            return;
                        }
                        try {
                            r0 r0VarF = F(jSONObjectA);
                            this.f1661o.set(0);
                            this.f1663q.incrementAndGet();
                            d();
                            this.f1653f.a();
                            this.f1666t.set(r0VarF);
                            this.f1652e.t(r0VarF);
                            if (j3 == this.f1662p.get() && this.f1657j.get() && this.f1651d.f3425b) {
                                this.f1659l.set(true);
                                Log.i("SocketMediaClient", "media transport negotiated " + r0VarF);
                                Log.i("SocketMediaClient", "Socket.IO media v2 negotiated media_transport_version=2");
                                ve veVar = this.f1650c;
                                if (veVar != null) {
                                    try {
                                        veVar.f5338c.f3702f.execute(new e2.q0(veVar, this, eVar, 19));
                                    } catch (RuntimeException unused) {
                                        G("registered_callback_failed");
                                    }
                                }
                                O();
                                return;
                            }
                            this.f1666t.set(y());
                            this.f1652e.t(y());
                        } catch (IOException unused2) {
                            G("media_v2_required");
                            this.f1651d.i();
                        }
                    }
                } catch (IOException unused3) {
                    G("invalid_registration");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final m0 I(int i3) {
        if (C()) {
            long j3 = this.f1663q.get();
            return new m0(i3, new x1.e(this, j3, 3), new pb(this, j3, 2));
        }
        o2.l("Socket.IO media not registered");
        return null;
    }

    public final void K() {
        s0 s0Var;
        long j3;
        long j4;
        while (C()) {
            z0 z0Var = this.f1652e;
            synchronized (z0Var.f1834a) {
                try {
                    if (z0Var.f1842i.f1723a) {
                        q0 q0VarK = z0Var.k();
                        if (q0VarK == null) {
                            s0Var = null;
                        } else {
                            byte[] bArr = (byte[]) q0VarK.f1715a.f1707c.get(0);
                            z0Var.g(bArr, q0VarK.f1715a.f1705a.f1759c);
                            long j5 = z0Var.f1846m + 1;
                            z0Var.f1846m = j5;
                            z0Var.f1841h.getClass();
                            long jNanoTime = System.nanoTime();
                            z0Var.n(q0VarK, jNanoTime);
                            z0Var.f1836c.put(Long.valueOf(j5), new t0(q0VarK, 0, true, jNanoTime));
                            long j6 = z0Var.f1844k;
                            p0 p0Var = q0VarK.f1715a;
                            s0Var = new s0(j5, j6, p0Var.f1705a.f1759c, p0Var.f1706b, bArr, true);
                        }
                    } else {
                        s0Var = z0Var.l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (s0Var == null) {
                return;
            }
            h2.e eVar = (h2.e) this.f1656i.get();
            if (C()) {
                long j7 = s0Var.f1729b;
                z0 z0Var2 = this.f1652e;
                synchronized (z0Var2.f1834a) {
                    j3 = z0Var2.f1844k;
                }
                if (j7 == j3 && Q((h2.e) this.f1656i.get(), eVar)) {
                    try {
                        h0 h0Var = new h0(s0Var, eVar, (r0) this.f1666t.get(), this.f1655h.schedule(new g0(this, s0Var, 1), 8000L, TimeUnit.MILLISECONDS));
                        synchronized (this.f1667u) {
                            this.f1668v.put(Long.valueOf(s0Var.f1728a), h0Var);
                        }
                        if (C()) {
                            long j8 = s0Var.f1729b;
                            z0 z0Var3 = this.f1652e;
                            synchronized (z0Var3.f1834a) {
                                j4 = z0Var3.f1844k;
                            }
                            if (j8 == j4 && Q((h2.e) this.f1656i.get(), eVar)) {
                                try {
                                    this.f1651d.a(s0Var.f1731d, s0Var.f1732e, new i(this, s0Var, 2));
                                    this.f1652e.f(s0Var.f1728a);
                                } catch (RuntimeException unused) {
                                    h0 h0VarW = w(s0Var.f1728a);
                                    if (h0VarW != null) {
                                        z(h0VarW, 3);
                                        G("emit_failed");
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        h0 h0VarW2 = w(s0Var.f1728a);
                        if (h0VarW2 != null) {
                            z(h0VarW2, 3);
                            return;
                        }
                        return;
                    } catch (RejectedExecutionException unused2) {
                        this.f1652e.c(3, s0Var.f1728a, false);
                        return;
                    }
                }
            }
            this.f1652e.c(3, s0Var.f1728a, false);
            return;
        }
    }

    public final void N() {
        ve veVar;
        AtomicBoolean atomicBoolean = this.f1665s;
        if (atomicBoolean.compareAndSet(false, true) && (veVar = this.f1650c) != null) {
            try {
                veVar.f5338c.f3702f.execute(new ba(veVar, this, 13));
            } catch (RuntimeException unused) {
                atomicBoolean.set(false);
            }
        }
    }

    public final void O() {
        if (C()) {
            AtomicBoolean atomicBoolean = this.f1660m;
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    this.f1654g.execute(new f0(this, 1));
                } catch (RejectedExecutionException unused) {
                    atomicBoolean.set(false);
                }
            }
        }
    }

    public final j0 R() {
        j0 j0Var;
        z0 z0Var = this.f1652e;
        synchronized (z0Var.f1834a) {
            try {
                EnumMap enumMap = new EnumMap(v0.class);
                for (v0 v0Var : v0.values()) {
                    enumMap.put(v0Var, new x0((w0) z0Var.f1838e.get(v0Var)));
                }
                j0Var = new j0(z0Var.f1844k, z0Var.f1842i.f1723a, z0Var.f1848p, z0Var.f1849q, z0Var.f1850r, z0Var.f1851s, enumMap);
            } catch (Throwable th) {
                throw th;
            }
        }
        return new j0(j0Var);
    }

    public final boolean V(h2.e eVar) {
        if (eVar == null) {
            return false;
        }
        while (true) {
            AtomicReference atomicReference = this.f1656i;
            h2.e eVar2 = (h2.e) atomicReference.get();
            if (!Q(eVar2, eVar)) {
                return false;
            }
            while (!atomicReference.compareAndSet(eVar2, eVar)) {
                if (atomicReference.get() != eVar2) {
                }
            }
            return true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        r0 r0Var;
        if (this.f1658k.compareAndSet(false, true)) {
            this.f1657j.set(false);
            this.f1659l.set(false);
            this.f1662p.incrementAndGet();
            this.f1663q.incrementAndGet();
            this.f1665s.set(false);
            d();
            this.f1653f.a();
            z0 z0Var = this.f1652e;
            synchronized (z0Var.f1834a) {
                r0Var = z0Var.f1842i;
            }
            z0Var.t(r0Var);
            this.f1651d.f5835a.clear();
            this.f1651d.i();
            this.f1654g.shutdownNow();
            this.f1655h.shutdownNow();
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1667u) {
            try {
                Iterator it = this.f1668v.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((h0) it.next()).f1608d);
                }
                this.f1668v.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((ScheduledFuture) obj).cancel(false);
        }
    }

    public final h0 w(long j3) {
        synchronized (this.f1667u) {
            try {
                h0 h0Var = (h0) this.f1668v.remove(Long.valueOf(j3));
                if (h0Var == null) {
                    return null;
                }
                h0Var.f1608d.cancel(false);
                return h0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(h0 h0Var, int i3) {
        y0 y0Var;
        s0 s0Var = h0Var.f1605a;
        boolean z2 = s0Var.f1733f;
        z0 z0Var = this.f1652e;
        long j3 = s0Var.f1728a;
        if (!z2) {
            if (i3 == 0) {
                z0Var.getClass();
                throw new NullPointerException("failure");
            }
            z0Var.c(i3, j3, false);
            E();
            return;
        }
        z0Var.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (z0Var.f1834a) {
            try {
                t0 t0Var = (t0) z0Var.f1836c.get(Long.valueOf(j3));
                if (t0Var == null) {
                    y0Var = new y0(Collections.EMPTY_LIST);
                } else {
                    v0 v0Var = t0Var.f1743a.f1715a.f1705a.f1759c;
                    if (v0Var == v0.f1766d) {
                        z0Var.f1852t = true;
                    }
                    if (i3 == 1) {
                        z0Var.m(t0Var);
                        ((w0) z0Var.f1838e.get(v0Var)).f1792p++;
                    } else if (i3 == 2) {
                        ((w0) z0Var.f1838e.get(v0Var)).f1791o++;
                    }
                    Iterator it = z0Var.f1836c.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        t0 t0Var2 = (t0) entry.getValue();
                        if (t0Var2.f1743a.f1715a.f1705a.f1759c == v0Var) {
                            it.remove();
                            z0Var.p((byte[]) t0Var2.f1743a.f1715a.f1707c.get(t0Var2.f1744b), v0Var);
                            arrayList2.add((Long) entry.getKey());
                            arrayList.add(t0Var2.f1743a.f1715a);
                        }
                    }
                    Iterator it2 = z0Var.f1835b.iterator();
                    while (it2.hasNext()) {
                        q0 q0Var = (q0) it2.next();
                        if (q0Var.f1715a.f1705a.f1759c == v0Var) {
                            it2.remove();
                            z0Var.q(q0Var.f1715a);
                            arrayList.add(q0Var.f1715a);
                        }
                    }
                    q0 q0Var2 = z0Var.f1843j;
                    if (q0Var2 != null && q0Var2.f1715a.f1705a.f1759c == v0Var) {
                        z0Var.r(q0Var2, q0Var2.f1717c + 1);
                        arrayList.add(z0Var.f1843j.f1715a);
                        z0Var.f1843j = null;
                    }
                    z0Var.o(arrayList);
                    z0Var.h();
                    z0.d(arrayList);
                    y0Var = new y0(Collections.unmodifiableList(arrayList2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        List list = y0Var.f1829c;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            synchronized (this.f1667u) {
                try {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        h0 h0Var2 = (h0) this.f1668v.remove((Long) it3.next());
                        if (h0Var2 != null) {
                            arrayList3.add(h0Var2.f1608d);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            int size = arrayList3.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList3.get(i4);
                i4++;
                ((ScheduledFuture) obj).cancel(false);
            }
        }
        E();
    }
}
