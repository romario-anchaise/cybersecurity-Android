// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements j.f, j.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final TreeMap f1416k = new TreeMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f1418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f1419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double[] f1420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f1421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[][] f1422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f1423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1424j;

    public k(int i3) {
        this.f1417c = i3;
        int i4 = i3 + 1;
        this.f1423i = new int[i4];
        this.f1419e = new long[i4];
        this.f1420f = new double[i4];
        this.f1421g = new String[i4];
        this.f1422h = new byte[i4][];
    }

    public static final k y(String str, int i3) {
        TreeMap treeMap = f1416k;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
            if (entryCeilingEntry == null) {
                k kVar = new k(i3);
                kVar.f1418d = str;
                kVar.f1424j = i3;
                return kVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            k kVar2 = (k) entryCeilingEntry.getValue();
            kVar2.getClass();
            kVar2.f1418d = str;
            kVar2.f1424j = i3;
            return kVar2;
        }
    }

    @Override // j.f
    public final String d() {
        String str = this.f1418d;
        if (str != null) {
            return str;
        }
        o2.k("Required value was null.");
        return null;
    }

    @Override // j.e
    public final void h(int i3, long j3) {
        this.f1423i[i3] = 2;
        this.f1419e[i3] = j3;
    }

    @Override // j.e
    public final void j(int i3, byte[] bArr) {
        this.f1423i[i3] = 5;
        this.f1422h[i3] = bArr;
    }

    @Override // j.e
    public final void l(int i3) {
        this.f1423i[i3] = 1;
    }

    @Override // j.e
    public final void m(String str, int i3) {
        str.getClass();
        this.f1423i[i3] = 4;
        this.f1421g[i3] = str;
    }

    @Override // j.e
    public final void o(int i3, double d3) {
        this.f1423i[i3] = 3;
        this.f1420f[i3] = d3;
    }

    @Override // j.f
    public final void w(j.e eVar) {
        int i3 = this.f1424j;
        if (1 > i3) {
            return;
        }
        int i4 = 1;
        while (true) {
            int i5 = this.f1423i[i4];
            if (i5 == 1) {
                eVar.l(i4);
            } else if (i5 == 2) {
                eVar.h(i4, this.f1419e[i4]);
            } else if (i5 == 3) {
                eVar.o(i4, this.f1420f[i4]);
            } else if (i5 == 4) {
                String str = this.f1421g[i4];
                if (str == null) {
                    o2.i("Required value was null.");
                    return;
                }
                eVar.m(str, i4);
            } else if (i5 == 5) {
                byte[] bArr = this.f1422h[i4];
                if (bArr == null) {
                    o2.i("Required value was null.");
                    return;
                }
                eVar.j(i4, bArr);
            }
            if (i4 == i3) {
                return;
            } else {
                i4++;
            }
        }
    }

    public final void z() {
        TreeMap treeMap = f1416k;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1417c), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                it.getClass();
                while (true) {
                    int i3 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i3;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
