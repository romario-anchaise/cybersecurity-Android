// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1790m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f1791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f1792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f1793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f1794r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f1796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f1797u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f1798v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f1799w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1800x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long[] f1801y = new long[64];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1802z;

    public final void a() {
        if (this.f1785h < 0) {
            this.f1785h = 0;
        }
        if (this.f1786i < 0) {
            this.f1786i = 0L;
        }
        if (this.f1787j < 0) {
            this.f1787j = 0;
        }
        if (this.f1788k < 0) {
            this.f1788k = 0L;
        }
    }

    public final long b(int i3) {
        int i4 = this.f1802z;
        if (i4 == 0) {
            return 0L;
        }
        long[] jArrCopyOf = Arrays.copyOf(this.f1801y, i4);
        Arrays.sort(jArrCopyOf);
        return jArrCopyOf[Math.max(0, Math.min(jArrCopyOf.length - 1, ((int) Math.ceil(((double) (i3 * jArrCopyOf.length)) / 100.0d)) - 1))];
    }
}
