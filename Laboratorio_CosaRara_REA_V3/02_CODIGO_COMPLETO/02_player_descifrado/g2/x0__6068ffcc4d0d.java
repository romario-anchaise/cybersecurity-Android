// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f1815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f1817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1819m;
    public final long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f1820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f1821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f1822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f1823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f1824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f1825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f1826u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f1827v;

    public x0(w0 w0Var) {
        this.f1807a = w0Var.f1781d;
        this.f1808b = w0Var.f1782e;
        this.f1809c = w0Var.f1783f;
        this.f1810d = w0Var.f1784g;
        this.f1811e = w0Var.f1778a;
        this.f1812f = w0Var.f1779b;
        long j3 = w0Var.f1780c;
        this.f1813g = j3;
        this.f1814h = w0Var.f1786i;
        this.f1815i = w0Var.f1788k;
        this.f1816j = w0Var.f1790m;
        this.f1817k = j3 == 0 ? 0L : w0Var.f1789l / j3;
        this.f1818l = w0Var.n;
        this.f1819m = w0Var.b(50);
        this.n = w0Var.b(95);
        this.f1820o = w0Var.f1791o;
        this.f1821p = w0Var.f1792p;
        this.f1822q = w0Var.f1795s;
        long j4 = w0Var.f1793q;
        this.f1823r = j4 == 0 ? 0L : w0Var.f1794r / j4;
        this.f1824s = w0Var.f1796t;
        this.f1825t = w0Var.f1799w;
        long j5 = w0Var.f1797u;
        this.f1826u = j5 != 0 ? w0Var.f1798v / j5 : 0L;
        this.f1827v = w0Var.f1800x;
    }

    public final String toString() {
        return "{produced=" + this.f1807a + ",sent=" + this.f1808b + ",superseded=" + this.f1809c + ",failed=" + this.f1810d + ",dropLatest=" + this.f1811e + ",dropBounds=" + this.f1812f + ",queuedBytes=" + this.f1814h + ",inFlightBytes=" + this.f1815i + ",ackP50Ms=" + this.f1819m + ",ackP95Ms=" + this.n + ",timeouts=" + this.f1820o + ",nacks=" + this.f1821p + "}";
    }
}
