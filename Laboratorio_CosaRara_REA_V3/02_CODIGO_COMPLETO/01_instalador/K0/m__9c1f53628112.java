// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import H.s;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p022m0.h;
import p022m0.j;
import p024n0.C0220b;
import p024n0.C0222d;
import p024n0.C0225g;
import p024n0.C0227i;
import p024n0.C0229k;
import p024n0.C0230l;
import p024n0.C0231m;
import p024n0.C0236s;
import p024n0.C0240w;
import p024n0.S;
import p024n0.T;
import p024n0.c0;
import p030q0.e;
import p032r0.a;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f3415h = i.f3407d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f3416i = h.f3405a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f3417j = x.f3429a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f3418k = x.f3430b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f3419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f3421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0227i f3422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3424f;
    public final i g;

    public m() {
        h hVar = h.f3709c;
        Map mapEmptyMap = Collections.emptyMap();
        Collections.emptyList();
        Collections.emptyList();
        List listEmptyList = Collections.emptyList();
        List listEmptyList2 = Collections.emptyList();
        this.f3419a = new ThreadLocal();
        this.f3420b = new ConcurrentHashMap();
        s sVar = new s(mapEmptyMap, 12, listEmptyList2);
        this.f3421c = sVar;
        this.f3424f = true;
        this.g = f3415h;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0.f3892A);
        t tVar = x.f3429a;
        x xVar = f3417j;
        arrayList.add(xVar == tVar ? C0231m.f3936c : new C0229k(1, xVar));
        arrayList.add(hVar);
        arrayList.addAll(listEmptyList);
        arrayList.add(c0.f3908p);
        arrayList.add(c0.g);
        arrayList.add(c0.f3897d);
        arrayList.add(c0.f3898e);
        arrayList.add(c0.f3899f);
        C0240w c0240w = c0.f3903k;
        arrayList.add(new T(Long.TYPE, Long.class, c0240w));
        arrayList.add(new T(Double.TYPE, Double.class, new j(0)));
        arrayList.add(new T(Float.TYPE, Float.class, new j(1)));
        u uVar = x.f3430b;
        x xVar2 = f3418k;
        arrayList.add(xVar2 == uVar ? C0230l.f3934b : new C0229k(0, new C0230l(xVar2)));
        arrayList.add(c0.f3900h);
        arrayList.add(c0.f3901i);
        arrayList.add(new S(AtomicLong.class, new k(new k(c0240w, 0), 2), 0));
        arrayList.add(new S(AtomicLongArray.class, new k(new k(c0240w, 1), 2), 0));
        arrayList.add(c0.f3902j);
        arrayList.add(c0.f3904l);
        arrayList.add(c0.f3909q);
        arrayList.add(c0.f3910r);
        arrayList.add(new S(BigDecimal.class, c0.f3905m, 0));
        arrayList.add(new S(BigInteger.class, c0.f3906n, 0));
        arrayList.add(new S(j.class, c0.f3907o, 0));
        arrayList.add(c0.f3911s);
        arrayList.add(c0.f3912t);
        arrayList.add(c0.f3914v);
        arrayList.add(c0.f3915w);
        arrayList.add(c0.f3917y);
        arrayList.add(c0.f3913u);
        arrayList.add(c0.f3895b);
        arrayList.add(C0225g.f3922c);
        arrayList.add(c0.f3916x);
        if (e.f4023a) {
            arrayList.add(e.f4025c);
            arrayList.add(e.f4024b);
            arrayList.add(e.f4026d);
        }
        arrayList.add(C0220b.f3885c);
        arrayList.add(c0.f3894a);
        arrayList.add(new C0222d(0, sVar));
        arrayList.add(new C0222d(1, sVar));
        C0227i c0227i = new C0227i(sVar);
        this.f3422d = c0227i;
        arrayList.add(c0227i);
        arrayList.add(c0.f3893B);
        arrayList.add(new C0236s(sVar, f3416i, hVar, c0227i, listEmptyList2));
        this.f3423e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final y b(a aVar) {
        boolean z2;
        ConcurrentHashMap concurrentHashMap = this.f3420b;
        y yVar = (y) concurrentHashMap.get(aVar);
        if (yVar != null) {
            return yVar;
        }
        ThreadLocal threadLocal = this.f3419a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z2 = true;
        } else {
            y yVar2 = (y) map.get(aVar);
            if (yVar2 != null) {
                return yVar2;
            }
            z2 = false;
        }
        try {
            l lVar = new l();
            map.put(aVar, lVar);
            Iterator it = this.f3423e.iterator();
            y yVarB = null;
            while (it.hasNext()) {
                yVarB = ((z) it.next()).b(this, aVar);
                if (yVarB != null) {
                    if (lVar.f3414a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    lVar.f3414a = yVarB;
                    map.put(aVar, yVarB);
                    break;
                }
            }
            if (z2) {
                threadLocal.remove();
            }
            if (yVarB != null) {
                if (z2) {
                    concurrentHashMap.putAll(map);
                }
                return yVarB;
            }
            throw new IllegalArgumentException("GSON (2.11.0) cannot handle " + aVar);
        } catch (Throwable th) {
            if (z2) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f3423e + ",instanceCreators:" + this.f3421c + "}";
    }
}
