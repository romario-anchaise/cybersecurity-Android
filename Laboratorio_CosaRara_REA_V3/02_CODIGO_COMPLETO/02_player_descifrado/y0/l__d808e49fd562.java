// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import i2.d0;
import i2.t;
import i2.u;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends x0.c {
    public static final Logger A = Logger.getLogger(l.class.getName());
    public static final AtomicInteger B = new AtomicInteger();
    public static u C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f6082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f6083m;
    public final String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f6084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap f6085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f6086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f6087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedList f6088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o f6089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ScheduledFuture f6090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d0 f6091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f6092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ScheduledExecutorService f6093x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f6094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6095z;

    public l(URI uri, k kVar) {
        HashMap map;
        String strDecode;
        if (uri != null) {
            kVar = kVar == null ? new k() : kVar;
            kVar.f6070l = uri.getHost();
            kVar.f6101d = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            kVar.f6103f = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                kVar.f6071m = rawQuery;
            }
        }
        this.f6088s = new LinkedList();
        this.f6094y = new g(this, 0);
        String strSubstring = kVar.f6070l;
        if (strSubstring != null) {
            if (strSubstring.split(":").length > 2) {
                int iIndexOf = strSubstring.indexOf(91);
                strSubstring = iIndexOf != -1 ? strSubstring.substring(iIndexOf + 1) : strSubstring;
                int iLastIndexOf = strSubstring.lastIndexOf(93);
                if (iLastIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
            }
            kVar.f6098a = strSubstring;
        }
        boolean z2 = kVar.f6101d;
        this.f6072b = z2;
        if (kVar.f6103f == -1) {
            kVar.f6103f = z2 ? 443 : 80;
        }
        String str = kVar.f6098a;
        this.f6082l = str == null ? "localhost" : str;
        this.f6076f = kVar.f6103f;
        String str2 = kVar.f6071m;
        if (str2 != null) {
            map = new HashMap();
            for (String str3 : str2.split("&")) {
                String[] strArrSplit = str3.split("=");
                try {
                    String strDecode2 = URLDecoder.decode(strArrSplit[0], "UTF-8");
                    if (strArrSplit.length > 1) {
                        try {
                            strDecode = URLDecoder.decode(strArrSplit[1], "UTF-8");
                        } catch (UnsupportedEncodingException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        strDecode = "";
                    }
                    map.put(strDecode2, strDecode);
                } catch (UnsupportedEncodingException e4) {
                    throw new RuntimeException(e4);
                }
            }
        } else {
            map = new HashMap();
        }
        this.f6087r = map;
        this.f6073c = true;
        StringBuilder sb = new StringBuilder();
        String str4 = kVar.f6099b;
        sb.append((str4 == null ? "/engine.io" : str4).replaceAll("/$", ""));
        sb.append("/");
        this.f6083m = sb.toString();
        String str5 = kVar.f6100c;
        this.n = str5 == null ? "t" : str5;
        this.f6074d = kVar.f6102e;
        String[] strArr = kVar.f6069k;
        this.f6084o = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        this.f6085p = new HashMap();
        int i3 = kVar.f6104g;
        this.f6077g = i3 == 0 ? 843 : i3;
        u uVar = kVar.f6107j;
        uVar = uVar == null ? null : uVar;
        this.f6092w = uVar;
        d0 d0Var = kVar.f6106i;
        d0 d0Var2 = d0Var != null ? d0Var : null;
        this.f6091v = d0Var2;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        if (uVar == null) {
            if (C == null) {
                t tVar = new t();
                timeUnit.getClass();
                tVar.f2234w = j2.b.b(1L, timeUnit);
                C = new u(tVar);
            }
            this.f6092w = C;
        }
        if (d0Var2 == null) {
            if (C == null) {
                t tVar2 = new t();
                timeUnit.getClass();
                tVar2.f2234w = j2.b.b(1L, timeUnit);
                C = new u(tVar2);
            }
            this.f6091v = C;
        }
    }

    public static void e(l lVar, o oVar) {
        lVar.getClass();
        Level level = Level.FINE;
        Logger logger = A;
        if (logger.isLoggable(level)) {
            logger.fine("setting transport " + oVar.f6109c);
        }
        if (lVar.f6089t != null) {
            if (logger.isLoggable(level)) {
                logger.fine("clearing existing transport " + lVar.f6089t.f6109c);
            }
            lVar.f6089t.f5835a.clear();
        }
        lVar.f6089t = oVar;
        oVar.c("drain", new g(lVar, 4));
        oVar.c("packet", new g(lVar, 3));
        oVar.c("error", new g(lVar, 2));
        oVar.c("close", new g(lVar, 1));
    }

    public final o f(String str) {
        o eVar;
        Level level = Level.FINE;
        Logger logger = A;
        if (logger.isLoggable(level)) {
            logger.fine("creating transport '" + str + "'");
        }
        HashMap map = new HashMap(this.f6087r);
        map.put("EIO", String.valueOf(4));
        map.put("transport", str);
        String str2 = this.f6081k;
        if (str2 != null) {
            map.put("sid", str2);
        }
        n nVar = (n) this.f6085p.get(str);
        n nVar2 = new n();
        nVar2.f6105h = map;
        nVar2.f6098a = nVar != null ? nVar.f6098a : this.f6082l;
        nVar2.f6103f = nVar != null ? nVar.f6103f : this.f6076f;
        nVar2.f6101d = nVar != null ? nVar.f6101d : this.f6072b;
        nVar2.f6099b = nVar != null ? nVar.f6099b : this.f6083m;
        nVar2.f6102e = nVar != null ? nVar.f6102e : this.f6074d;
        nVar2.f6100c = nVar != null ? nVar.f6100c : this.n;
        nVar2.f6104g = nVar != null ? nVar.f6104g : this.f6077g;
        nVar2.f6107j = nVar != null ? nVar.f6107j : this.f6092w;
        nVar2.f6106i = nVar != null ? nVar.f6106i : this.f6091v;
        if ("websocket".equals(str)) {
            eVar = new z0.g(nVar2);
            eVar.f6109c = "websocket";
        } else {
            if (!"polling".equals(str)) {
                throw new RuntimeException();
            }
            eVar = new z0.e(nVar2);
            eVar.f6109c = "polling";
        }
        a("transport", eVar);
        return eVar;
    }

    public final void g() {
        if (this.f6095z == 4 || !this.f6089t.f6108b || this.f6075e) {
            return;
        }
        LinkedList linkedList = this.f6088s;
        if (linkedList.size() != 0) {
            Level level = Level.FINE;
            Logger logger = A;
            if (logger.isLoggable(level)) {
                logger.fine(String.format("flushing %d packets in socket", Integer.valueOf(linkedList.size())));
            }
            this.f6078h = linkedList.size();
            o oVar = this.f6089t;
            a1.b[] bVarArr = (a1.b[]) linkedList.toArray(new a1.b[linkedList.size()]);
            oVar.getClass();
            f1.b.a(new g0.j(oVar, bVarArr, 15));
            a("flush", new Object[0]);
        }
    }

    public final void h(String str, Exception exc) {
        int i3 = this.f6095z;
        if (1 == i3 || 2 == i3 || 3 == i3) {
            Level level = Level.FINE;
            Logger logger = A;
            if (logger.isLoggable(level)) {
                logger.fine("socket close with reason: ".concat(str));
            }
            ScheduledFuture scheduledFuture = this.f6090u;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.f6093x;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.f6089t.f5835a.remove("close");
            o oVar = this.f6089t;
            oVar.getClass();
            f1.b.a(new m(oVar, 1));
            this.f6089t.f5835a.clear();
            this.f6095z = 4;
            this.f6081k = null;
            a("close", str, exc);
            this.f6088s.clear();
            this.f6078h = 0;
        }
    }

    public final void i(Exception exc) {
        Level level = Level.FINE;
        Logger logger = A;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("socket error %s", exc));
        }
        a("error", exc);
        h("transport error", exc);
    }

    public final void j(b bVar) {
        l lVar = this;
        lVar.a("handshake", bVar);
        String str = bVar.f6037a;
        lVar.f6081k = str;
        lVar.f6089t.f6110d.put("sid", str);
        List<String> listAsList = Arrays.asList(bVar.f6038b);
        ArrayList arrayList = new ArrayList();
        for (String str2 : listAsList) {
            if (lVar.f6084o.contains(str2)) {
                arrayList.add(str2);
            }
        }
        lVar.f6086q = arrayList;
        lVar.f6079i = bVar.f6039c;
        lVar.f6080j = bVar.f6040d;
        Logger logger = A;
        logger.fine("socket open");
        int i3 = 2;
        lVar.f6095z = 2;
        "websocket".equals(lVar.f6089t.f6109c);
        int i4 = 0;
        lVar.a("open", new Object[0]);
        lVar.g();
        if (lVar.f6095z == 2 && lVar.f6073c && (lVar.f6089t instanceof z0.b)) {
            logger.fine("starting upgrade probes");
            ArrayList arrayList2 = lVar.f6086q;
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                int i6 = i5 + 1;
                String str3 = (String) arrayList2.get(i5);
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine("probing transport '" + str3 + "'");
                }
                o[] oVarArr = {lVar.f(str3)};
                boolean[] zArr = {false};
                Runnable[] runnableArr = {dVar};
                i iVar = new i(zArr, str3, oVarArr, lVar, runnableArr);
                f fVar = new f(zArr, runnableArr, oVarArr, i3);
                j jVar = new j(oVarArr, fVar, str3, lVar);
                c cVar = new c(jVar, i4);
                c cVar2 = new c(jVar, 1);
                w0.e eVar = new w0.e(oVarArr, fVar);
                d dVar = new d(oVarArr, iVar, jVar, cVar, this, cVar2, eVar);
                lVar = this;
                oVarArr[0].d("open", iVar);
                oVarArr[0].d("error", jVar);
                oVarArr[0].d("close", cVar);
                lVar.d("close", cVar2);
                lVar.d("upgrading", eVar);
                o oVar = oVarArr[0];
                oVar.getClass();
                f1.b.a(new m(oVar, i4));
                i5 = i6;
            }
        }
        if (4 == lVar.f6095z) {
            return;
        }
        lVar.k();
        g gVar = lVar.f6094y;
        lVar.b("heartbeat", gVar);
        lVar.c("heartbeat", gVar);
    }

    public final void k() {
        ScheduledFuture scheduledFuture = this.f6090u;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        long j3 = this.f6079i + this.f6080j;
        ScheduledExecutorService scheduledExecutorService = this.f6093x;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.f6093x = Executors.newSingleThreadScheduledExecutor(new f1.a(1));
        }
        this.f6090u = this.f6093x.schedule(new e(this, 1), j3, TimeUnit.MILLISECONDS);
    }

    public final void l(a1.b bVar) {
        int i3 = this.f6095z;
        if (3 == i3 || 4 == i3) {
            return;
        }
        a("packetCreate", bVar);
        this.f6088s.offer(bVar);
        g();
    }
}
