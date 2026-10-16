// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends x0.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Logger f3424m = Logger.getLogger(s.class.getName());
    public static final a1.c n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f3425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f3428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f3429f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f3431h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f3430g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3432i = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3433j = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3434k = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3435l = new ConcurrentLinkedQueue();

    static {
        a1.c cVar = new a1.c();
        cVar.put("connect", 1);
        cVar.put("connect_error", 1);
        cVar.put("disconnect", 1);
        cVar.put("disconnecting", 1);
        cVar.put("newListener", 1);
        cVar.put("removeListener", 1);
        n = cVar;
    }

    public s(k kVar, String str, b bVar) {
        this.f3428e = kVar;
        this.f3427d = str;
        this.f3429f = bVar.f3375r;
    }

    public static void e(s sVar) {
        f3424m.fine("transport is open - connecting");
        Map map = sVar.f3429f;
        if (map != null) {
            sVar.l(new e1.d(0, new JSONObject(map)));
        } else {
            sVar.l(new e1.d(0));
        }
    }

    public static void f(s sVar, e1.d dVar) {
        if (sVar.f3427d.equals(dVar.f696c)) {
            switch (dVar.f694a) {
                case 0:
                    Object obj = dVar.f697d;
                    if ((obj instanceof JSONObject) && ((JSONObject) obj).has("sid")) {
                        try {
                            ((JSONObject) dVar.f697d).getString("sid");
                            sVar.k();
                        } catch (JSONException unused) {
                            return;
                        }
                    } else {
                        super.a("connect_error", new t("It seems you are trying to reach a Socket.IO server in v2.x with a v3.x client, which is not possible"));
                    }
                    break;
                case 1:
                    Logger logger = f3424m;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine("server disconnect (" + sVar.f3427d + ")");
                    }
                    sVar.h();
                    sVar.j("io server disconnect");
                    break;
                case 2:
                case 5:
                    ArrayList arrayList = new ArrayList(Arrays.asList(m((JSONArray) dVar.f697d)));
                    Logger logger2 = f3424m;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(String.format("emitting event %s", arrayList));
                    }
                    if (dVar.f695b >= 0) {
                        logger2.fine("attaching ack callback to event");
                        arrayList.add(new r(new boolean[]{false}, dVar.f695b, sVar));
                    }
                    if (!sVar.f3425b) {
                        sVar.f3432i.add(arrayList);
                        break;
                    } else if (!arrayList.isEmpty()) {
                        if (!sVar.f3434k.isEmpty()) {
                            Object[] array = arrayList.toArray();
                            Iterator it = sVar.f3434k.iterator();
                            while (it.hasNext()) {
                                ((x0.a) it.next()).a(array);
                            }
                        }
                        super.a(arrayList.remove(0).toString(), arrayList.toArray());
                        break;
                    }
                    break;
                case 3:
                case 6:
                    Logger logger3 = f3424m;
                    a aVar = (a) sVar.f3430g.remove(Integer.valueOf(dVar.f695b));
                    if (aVar != null) {
                        if (logger3.isLoggable(Level.FINE)) {
                            logger3.fine(String.format("calling ack %s with %s", Integer.valueOf(dVar.f695b), dVar.f697d));
                        }
                        aVar.a(m((JSONArray) dVar.f697d));
                    } else if (logger3.isLoggable(Level.FINE)) {
                        logger3.fine("bad ack " + dVar.f695b);
                    }
                    break;
                case 4:
                    sVar.h();
                    super.a("connect_error", dVar.f697d);
                    break;
            }
        }
    }

    public static Object[] m(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i3 = 0; i3 < length; i3++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i3);
            } catch (JSONException e3) {
                f3424m.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e3);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i3] = obj2;
        }
        return objArr;
    }

    @Override // x0.c
    public final void a(String str, Object... objArr) {
        if (n.containsKey(str)) {
            throw new RuntimeException(a0.a.h("'", str, "' is a reserved event name"));
        }
        f1.b.a(new q.g(this, objArr, str));
    }

    public final void h() {
        o oVar = this.f3431h;
        if (oVar != null) {
            Iterator<E> it = oVar.iterator();
            while (it.hasNext()) {
                ((m) it.next()).destroy();
            }
            this.f3431h = null;
        }
        k kVar = this.f3428e;
        synchronized (kVar.f3407p) {
            try {
                Iterator it2 = kVar.f3407p.values().iterator();
                while (it2.hasNext()) {
                    if (((s) it2.next()).f3431h != null) {
                        k.f3393r.fine("socket is still active, skipping close");
                        return;
                    }
                }
                k.f3393r.fine("disconnect");
                kVar.f3395c = true;
                kVar.f3396d = false;
                if (kVar.f3408q != 3) {
                    kVar.e();
                }
                kVar.f3399g.f3276d = 0;
                kVar.f3408q = 1;
                j jVar = kVar.f3405m;
                if (jVar != null) {
                    f1.b.a(new y0.e(jVar, 3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        f1.b.a(new p(this, 1));
    }

    public final void j(String str) {
        Logger logger = f3424m;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("close (" + str + ")");
        }
        this.f3425b = false;
        super.a("disconnect", str);
        ConcurrentHashMap concurrentHashMap = this.f3430g;
        for (a aVar : concurrentHashMap.values()) {
        }
        concurrentHashMap.clear();
    }

    public final void k() {
        this.f3425b = true;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f3433j;
        ConcurrentLinkedQueue concurrentLinkedQueue2 = this.f3432i;
        while (true) {
            List list = (List) concurrentLinkedQueue2.poll();
            if (list == null) {
                break;
            } else {
                super.a((String) list.get(0), list.toArray());
            }
        }
        concurrentLinkedQueue2.clear();
        while (true) {
            e1.d dVar = (e1.d) concurrentLinkedQueue.poll();
            if (dVar == null) {
                concurrentLinkedQueue.clear();
                super.a("connect", new Object[0]);
                return;
            }
            l(dVar);
        }
    }

    public final void l(e1.d dVar) {
        if (dVar.f694a == 2) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.f3435l;
            if (!concurrentLinkedQueue.isEmpty()) {
                Object[] objArrM = m((JSONArray) dVar.f697d);
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ((x0.a) it.next()).a(objArrM);
                }
            }
        }
        dVar.f696c = this.f3427d;
        this.f3428e.f(dVar);
    }
}
