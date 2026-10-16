// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements AutoCloseable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa f5464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final aa f5465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HandlerThread f5466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HandlerThread f5467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f5468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f5469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v f5470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v f5471k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f5474o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f5476q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f5477r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f5478s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f5479t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f5480u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5463c = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IdentityHashMap f5472l = new IdentityHashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TreeSet f5473m = new TreeSet();
    public final TreeSet n = new TreeSet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f5475p = 1;

    public x(aa aaVar, aa aaVar2, long j3) {
        this.f5464d = aaVar;
        this.f5465e = aaVar2;
        this.f5474o = j3;
        HandlerThread handlerThread = new HandlerThread("a11y-critical");
        this.f5466f = handlerThread;
        HandlerThread handlerThread2 = new HandlerThread("a11y-collection");
        this.f5467g = handlerThread2;
        handlerThread.start();
        handlerThread2.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f5468h = handler;
        Handler handler2 = new Handler(handlerThread2.getLooper());
        this.f5469i = handler2;
        this.f5470j = new v(true, 64, handler, this);
        this.f5471k = new v(false, 128, handler2, this);
    }

    public static boolean F(v vVar) {
        try {
            return vVar.f5273d.post(vVar.f5275f);
        } catch (Throwable unused) {
            vVar.n++;
            return false;
        }
    }

    public static void K(ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((t) obj).b();
        }
    }

    public static long M(long j3) {
        if (j3 <= 0) {
            return 0L;
        }
        long j4 = j3 / 1000;
        return j3 % 1000 == 0 ? j4 : j4 + 1;
    }

    public final void A(v vVar) {
        synchronized (this.f5463c) {
            vVar.f5278i++;
        }
    }

    public final void B(v vVar) {
        synchronized (this.f5463c) {
            vVar.n++;
        }
    }

    public final void C(v vVar, t tVar) {
        if (tVar == null) {
            return;
        }
        long j3 = tVar.f5118j;
        if (vVar.f5270a) {
            this.f5473m.remove(Long.valueOf(j3));
        } else {
            this.n.remove(Long.valueOf(j3));
        }
    }

    public final boolean D(long j3, Runnable runnable) {
        if (runnable == null) {
            o2.i("task required");
            return false;
        }
        long[] jArr = new long[1];
        q.r rVar = new q.r(this, runnable, new Runnable[]{rVar}, jArr, 1);
        synchronized (this.f5463c) {
            try {
                if (this.f5480u) {
                    return false;
                }
                jArr[0] = this.f5474o;
                ((List) this.f5472l.computeIfAbsent(runnable, new d2.i(2))).add(rVar);
                try {
                    if (this.f5469i.postDelayed(rVar, Math.max(0L, j3))) {
                        return true;
                    }
                    this.f5471k.n++;
                } catch (Throwable unused) {
                    this.f5471k.n++;
                }
                IdentityHashMap identityHashMap = this.f5472l;
                List list = (List) identityHashMap.get(runnable);
                if (list != null) {
                    list.remove(rVar);
                    if (list.isEmpty()) {
                        identityHashMap.remove(runnable);
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean E(Runnable runnable) {
        if (runnable == null) {
            o2.i("task required");
            return false;
        }
        synchronized (this.f5463c) {
            try {
                if (this.f5480u) {
                    return false;
                }
                long j3 = this.f5474o;
                u uVar = new u(this, j3, this.f5475p - 1, runnable, 0);
                synchronized (this.f5463c) {
                    if (this.f5480u || j3 != this.f5474o) {
                        return false;
                    }
                    try {
                        if (this.f5468h.post(uVar)) {
                            return true;
                        }
                        this.f5470j.n++;
                    } catch (Throwable unused) {
                        this.f5470j.n++;
                    }
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void G(t tVar) {
        try {
            this.f5465e.a(tVar);
            tVar.b();
        } catch (Throwable th) {
            try {
                Log.e("A11yEventPipeline", "collection processor failed sequence=" + tVar.f5118j, th);
                B(this.f5471k);
            } finally {
                tVar.b();
            }
        }
    }

    public final void H(t tVar) {
        try {
            if (this.f5464d.b(tVar)) {
                y(this.f5471k, tVar);
                return;
            }
            synchronized (this.f5463c) {
                try {
                    this.f5478s++;
                    if (tVar.n.get()) {
                        this.f5476q = Math.max(this.f5476q, tVar.f5118j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            tVar.b();
        } catch (Throwable th2) {
            Log.e("A11yEventPipeline", "critical processor failed sequence=" + tVar.f5118j, th2);
            B(this.f5470j);
            tVar.b();
        }
    }

    public final void I(long j3) {
        long jM = M(j3);
        if (jM < 0) {
            return;
        }
        synchronized (this.f5463c) {
            this.f5479t = Math.max(this.f5479t, jM);
        }
    }

    public final void J(v vVar, long j3) {
        long jM = M(Math.max(0L, System.nanoTime() - j3));
        synchronized (this.f5463c) {
            vVar.f5282m = Math.max(vVar.f5282m, jM);
        }
    }

    public final w L() {
        boolean z2 = this.f5480u;
        long j3 = this.f5477r;
        v vVar = this.f5470j;
        long j4 = vVar.f5277h;
        long j5 = vVar.f5278i;
        long j6 = vVar.f5279j;
        v vVar2 = this.f5471k;
        return new w(this.f5474o, z2, j3, j4, j5, j6, vVar2.f5277h, vVar2.f5278i, vVar2.f5279j, vVar.f5274e.size(), vVar2.f5274e.size(), vVar.f5280k, vVar2.f5280k, vVar.f5281l, vVar2.f5281l, vVar.f5282m, vVar2.f5282m, this.f5478s, vVar.n, vVar2.n, this.f5479t);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f5463c) {
            try {
                if (this.f5480u) {
                    return;
                }
                this.f5480u = true;
                w(this.f5470j, arrayList);
                w(this.f5471k, arrayList);
                this.f5473m.clear();
                this.n.clear();
                this.f5470j.f5276g = false;
                this.f5471k.f5276g = false;
                this.f5472l.clear();
                this.f5463c.notifyAll();
                this.f5468h.removeCallbacksAndMessages(null);
                this.f5469i.removeCallbacksAndMessages(null);
                K(arrayList);
                this.f5466f.quitSafely();
                this.f5467g.quitSafely();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final w d() {
        w wVarL;
        synchronized (this.f5463c) {
            wVarL = L();
            v vVar = this.f5470j;
            vVar.f5281l = 0L;
            v vVar2 = this.f5471k;
            vVar2.f5281l = 0L;
            vVar.f5282m = 0L;
            vVar2.f5282m = 0L;
            this.f5479t = 0L;
        }
        return wVarL;
    }

    public final void w(v vVar, ArrayList arrayList) {
        while (!vVar.f5274e.isEmpty()) {
            t tVar = (t) vVar.f5274e.removeFirst();
            C(vVar, tVar);
            arrayList.add(tVar);
            vVar.f5278i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x009e A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e9 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fb A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010c A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x011b A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0123 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0009, B:6:0x0011, B:9:0x001b, B:15:0x0027, B:16:0x002d, B:18:0x0033, B:20:0x003d, B:22:0x0047, B:25:0x004e, B:58:0x00e9, B:60:0x00fb, B:62:0x0117, B:64:0x011b, B:66:0x0123, B:68:0x012a, B:69:0x012f, B:61:0x010c, B:30:0x0066, B:35:0x007d, B:33:0x0072, B:37:0x0088, B:39:0x0092, B:40:0x0098, B:42:0x009e, B:47:0x00ad, B:49:0x00b3, B:51:0x00c0, B:53:0x00ca, B:54:0x00d8, B:55:0x00de), top: B:74:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0129  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[LOOP:1: B:40:0x0098->B:86:?, LOOP_END, SYNTHETIC] */
    public final boolean y(v vVar, t tVar) {
        boolean z2;
        boolean z3;
        t tVar2;
        Iterator it;
        t tVar3;
        boolean z4;
        int iMax;
        ArrayList arrayList = new ArrayList(2);
        synchronized (this.f5463c) {
            try {
                z2 = false;
                if (this.f5480u || tVar.f5119k != this.f5474o) {
                    vVar.f5278i++;
                    arrayList.add(tVar);
                } else {
                    boolean z5 = tVar.f5109a == 2048;
                    t tVar4 = null;
                    if (!z5) {
                        tVar2 = null;
                        break;
                    }
                    Iterator it2 = vVar.f5274e.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            tVar2 = null;
                            break;
                        }
                        tVar2 = (t) it2.next();
                        if (tVar2.f5109a == 2048 && Objects.equals(tVar2.f5110b, tVar.f5110b)) {
                            it2.remove();
                            break;
                        }
                    }
                    if (tVar2 != null) {
                        C(vVar, tVar2);
                        vVar.f5277h++;
                        arrayList.add(tVar2);
                        vVar.f5274e.addLast(tVar);
                    } else if (z5) {
                        int size = vVar.f5274e.size();
                        int i3 = vVar.f5271b;
                        if (i3 <= 1) {
                            iMax = 1;
                        } else {
                            iMax = vVar.f5271b - Math.max(1, i3 / 4);
                        }
                        if (size >= iMax) {
                            vVar.f5277h++;
                            arrayList.add(tVar);
                        } else {
                            if (!z5 && vVar.f5274e.size() >= vVar.f5271b) {
                                it = vVar.f5274e.iterator();
                                while (it.hasNext()) {
                                    tVar3 = (t) it.next();
                                    if (tVar3.f5109a == 2048) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        it.remove();
                                        tVar4 = tVar3;
                                        break;
                                    }
                                }
                                if (tVar4 != null) {
                                    C(vVar, tVar4);
                                    vVar.f5277h++;
                                    arrayList.add(tVar4);
                                }
                            }
                            if (!z5 || vVar.f5274e.size() < vVar.f5272c) {
                                vVar.f5274e.addLast(tVar);
                            } else {
                                vVar.f5278i++;
                                vVar.f5279j++;
                                arrayList.add(tVar);
                            }
                        }
                    } else {
                        if (!z5) {
                            it = vVar.f5274e.iterator();
                            while (it.hasNext()) {
                                tVar3 = (t) it.next();
                                if (tVar3.f5109a == 2048) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    it.remove();
                                    tVar4 = tVar3;
                                    break;
                                }
                            }
                            if (tVar4 != null) {
                                C(vVar, tVar4);
                                vVar.f5277h++;
                                arrayList.add(tVar4);
                            }
                        }
                        if (z5) {
                        }
                        vVar.f5274e.addLast(tVar);
                    }
                    z3 = true;
                    if (z3) {
                        vVar.f5280k = Math.max(vVar.f5280k, vVar.f5274e.size());
                        if (vVar.f5270a) {
                            this.f5477r++;
                            this.f5473m.add(Long.valueOf(tVar.f5118j));
                        } else {
                            this.n.add(Long.valueOf(tVar.f5118j));
                        }
                        if (vVar.f5276g) {
                            z2 = z3;
                        } else {
                            vVar.f5276g = true;
                            if (F(vVar)) {
                                z2 = z3;
                            } else {
                                w(vVar, arrayList);
                                vVar.f5276g = false;
                            }
                        }
                    } else {
                        z2 = z3;
                    }
                    this.f5463c.notifyAll();
                }
                z3 = false;
                if (z3) {
                    vVar.f5280k = Math.max(vVar.f5280k, vVar.f5274e.size());
                    if (vVar.f5270a) {
                        this.f5477r++;
                        this.f5473m.add(Long.valueOf(tVar.f5118j));
                    } else {
                        this.n.add(Long.valueOf(tVar.f5118j));
                    }
                    if (vVar.f5276g) {
                        vVar.f5276g = true;
                        if (F(vVar)) {
                            w(vVar, arrayList);
                            vVar.f5276g = false;
                        } else {
                            z2 = z3;
                        }
                    } else {
                        z2 = z3;
                    }
                } else {
                    z2 = z3;
                }
                this.f5463c.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        K(arrayList);
        return z2;
    }

    public final boolean z(v vVar, t tVar) {
        boolean z2;
        synchronized (this.f5463c) {
            try {
                z2 = !this.f5480u && tVar.f5119k == this.f5474o && (vVar.f5270a || tVar.f5118j >= this.f5476q);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
