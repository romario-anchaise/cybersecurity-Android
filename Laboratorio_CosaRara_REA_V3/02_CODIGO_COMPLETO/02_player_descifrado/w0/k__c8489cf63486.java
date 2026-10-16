// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends x0.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f3393r = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v0.a f3399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f3400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final URI f3401i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f3404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f3405m;
    public final e0.i n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final y.e f3406o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3408q;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f3402j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList f3403k = new LinkedList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f3407p = new ConcurrentHashMap();

    public k(URI uri, b bVar) {
        if (bVar.f6099b == null) {
            bVar.f6099b = "/socket.io";
        }
        if (bVar.f6106i == null) {
            bVar.f6106i = null;
        }
        if (bVar.f6107j == null) {
            bVar.f6107j = null;
        }
        this.f3404l = bVar;
        this.f3394b = bVar.n;
        int i3 = bVar.f3372o;
        this.f3398f = i3 == 0 ? Integer.MAX_VALUE : i3;
        long j3 = bVar.f3373p;
        j3 = j3 == 0 ? 1000L : j3;
        v0.a aVar = this.f3399g;
        if (aVar != null) {
            aVar.f3273a = j3;
        }
        long j4 = bVar.f3374q;
        j4 = j4 == 0 ? 5000L : j4;
        if (aVar != null) {
            aVar.f3274b = j4;
        }
        if (aVar != null) {
            aVar.f3275c = 0.5d;
        }
        v0.a aVar2 = new v0.a();
        aVar2.f3273a = j3;
        aVar2.f3274b = j4;
        if (0.5d < 0.0d || 0.5d >= 1.0d) {
            o2.i("jitter must be between 0 and 1");
            throw null;
        }
        aVar2.f3275c = 0.5d;
        this.f3399g = aVar2;
        this.f3400h = 20000L;
        this.f3408q = 1;
        this.f3401i = uri;
        this.f3397e = false;
        this.n = new e0.i();
        y.e eVar = new y.e();
        eVar.f5976c = null;
        this.f3406o = eVar;
    }

    public final void e() {
        f3393r.fine("cleanup");
        while (true) {
            m mVar = (m) this.f3403k.poll();
            if (mVar == null) {
                break;
            } else {
                mVar.destroy();
            }
        }
        y.e eVar = this.f3406o;
        eVar.f5977d = null;
        this.f3402j.clear();
        this.f3397e = false;
        y.c cVar = (y.c) eVar.f5976c;
        if (cVar != null) {
            cVar.f5972d = null;
            cVar.f5973e = new ArrayList();
        }
        eVar.f5977d = null;
    }

    public final void f(e1.d dVar) {
        Level level = Level.FINE;
        Logger logger = f3393r;
        if (logger.isLoggable(level)) {
            logger.fine("writing packet " + dVar);
        }
        if (this.f3397e) {
            this.f3402j.add(dVar);
            return;
        }
        this.f3397e = true;
        i iVar = new i(this);
        this.n.getClass();
        int i3 = dVar.f694a;
        if ((i3 == 2 || i3 == 3) && c1.a.a(dVar.f697d)) {
            dVar.f694a = dVar.f694a == 2 ? 5 : 6;
        }
        Logger logger2 = e1.c.f693a;
        if (logger2.isLoggable(level)) {
            logger2.fine("encoding packet " + dVar);
        }
        int i4 = dVar.f694a;
        if (5 != i4 && 6 != i4) {
            iVar.a(new String[]{e0.i.c(dVar)});
            return;
        }
        Logger logger3 = e1.a.f692a;
        ArrayList arrayList = new ArrayList();
        dVar.f697d = e1.a.a(dVar.f697d, arrayList);
        dVar.f698e = arrayList.size();
        byte[][] bArr = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        String strC = e0.i.c(dVar);
        ArrayList arrayList2 = new ArrayList(Arrays.asList(bArr));
        arrayList2.add(0, strC);
        iVar.a(arrayList2.toArray());
    }

    public final void g() {
        if (this.f3396d || this.f3395c) {
            return;
        }
        v0.a aVar = this.f3399g;
        int i3 = aVar.f3276d;
        int i4 = this.f3398f;
        Logger logger = f3393r;
        if (i3 >= i4) {
            logger.fine("reconnect failed");
            aVar.f3276d = 0;
            a("reconnect_failed", new Object[0]);
            this.f3396d = false;
            return;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(aVar.f3273a);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2);
        int i5 = aVar.f3276d;
        aVar.f3276d = i5 + 1;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf2.pow(i5));
        if (aVar.f3275c != 0.0d) {
            double dRandom = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(dRandom).multiply(BigDecimal.valueOf(aVar.f3275c)).multiply(new BigDecimal(bigIntegerMultiply)).toBigInteger();
            bigIntegerMultiply = (((int) Math.floor(dRandom * 10.0d)) & 1) == 0 ? bigIntegerMultiply.subtract(bigInteger) : bigIntegerMultiply.add(bigInteger);
        }
        long jLongValue = bigIntegerMultiply.min(BigInteger.valueOf(aVar.f3274b)).max(BigInteger.valueOf(aVar.f3273a)).longValue();
        logger.fine(String.format("will wait %dms before reconnect attempt", Long.valueOf(jLongValue)));
        this.f3396d = true;
        Timer timer = new Timer();
        timer.schedule(new g(1, this), jLongValue);
        this.f3403k.add(new h(timer, 1));
    }
}
