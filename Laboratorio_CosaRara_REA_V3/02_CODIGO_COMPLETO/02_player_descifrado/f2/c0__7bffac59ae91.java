// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {
    public static volatile long A = 0;
    public static volatile long B = 0;
    public static final long[] C = new long[g.d.b(12).length];
    public static volatile int D = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f1138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f1139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f1140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f1141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f1142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f1143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f1144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f1145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f1146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f1147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f1148l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f1149m;
    public static volatile boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile boolean f1150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f1151p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile long f1152q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile long f1153r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile long f1154s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile long f1155t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile long f1156u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile long f1157v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile long f1158w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static volatile long f1159x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile long f1160y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile long f1161z;

    public static boolean a() {
        return f1137a || f1138b || f1139c || f1140d || f1141e || f1142f || f1143g || f1144h || f1145i || f1146j || n || f1151p;
    }

    public static synchronized void b(int i3) {
        if (i3 == 0) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            switch (g.d.a(i3)) {
                case 4:
                    f1137a = true;
                    f1153r = jCurrentTimeMillis;
                    D = 2;
                    d(jCurrentTimeMillis, 10000L);
                    break;
                case 5:
                    f1138b = true;
                    f1154s = jCurrentTimeMillis;
                    D = 3;
                    d(jCurrentTimeMillis, 2000L);
                    break;
                case 6:
                    d(jCurrentTimeMillis, 10000L);
                    return;
                case 7:
                    n = true;
                    f1150o = false;
                    f1161z = jCurrentTimeMillis;
                    D = 11;
                    d(jCurrentTimeMillis, 5000L);
                    break;
                case 8:
                    f1140d = true;
                    f1155t = jCurrentTimeMillis;
                    D = 4;
                    d(jCurrentTimeMillis, 6000L);
                    break;
                case 9:
                    return;
                case 10:
                    f1142f = true;
                    f1160y = jCurrentTimeMillis;
                    D = 10;
                    d(jCurrentTimeMillis, 10000L);
                    break;
                case 11:
                default:
                    return;
                case 12:
                    f1151p = true;
                    A = jCurrentTimeMillis;
                    D = 12;
                    d(jCurrentTimeMillis, 3000L);
                    break;
                case 13:
                    f1146j = true;
                    f1159x = jCurrentTimeMillis;
                    D = 9;
                    d(jCurrentTimeMillis, 3000L);
                    break;
                case 14:
                    f1139c = true;
                    f1156u = jCurrentTimeMillis;
                    D = 6;
                    d(jCurrentTimeMillis, 5000L);
                    break;
                case 15:
                    f1143g = true;
                    f1144h = false;
                    f1158w = jCurrentTimeMillis;
                    D = 8;
                    d(jCurrentTimeMillis, 5000L);
                    break;
                case 16:
                    f1145i = true;
                    f1157v = jCurrentTimeMillis;
                    D = 7;
                    d(jCurrentTimeMillis, 5000L);
                    break;
            }
            f1152q = jCurrentTimeMillis;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static long c(int i3) {
        switch (g.d.a(i3)) {
            case 1:
                return f1153r;
            case 2:
                return f1154s;
            case 3:
                return f1155t;
            case 4:
                return 0L;
            case 5:
                return f1156u;
            case 6:
                return f1157v;
            case 7:
                return f1158w;
            case 8:
                return f1159x;
            case 9:
                return f1160y;
            case 10:
                return f1161z;
            case 11:
                return A;
            default:
                return f1152q;
        }
    }

    public static void d(long j3, long j4) {
        long j5 = j3 + j4;
        if (j5 > B) {
            B = j5;
        }
    }

    public static synchronized void e(int i3) {
        if (i3 == 0 || i3 == 1) {
            return;
        }
        try {
            switch (g.d.a(i3)) {
                case 1:
                    f1137a = false;
                    break;
                case 2:
                    f1138b = false;
                    f1147k = false;
                    break;
                case 3:
                    f1140d = false;
                    f1141e = false;
                    break;
                case 5:
                    f1139c = false;
                    break;
                case 6:
                    f1145i = false;
                    break;
                case 7:
                    f1143g = false;
                    f1144h = false;
                    break;
                case 8:
                    f1146j = false;
                    f1149m = false;
                    break;
                case 9:
                    f1142f = false;
                    f1148l = false;
                    break;
                case 10:
                    n = false;
                    f1150o = false;
                    k0.f1229i++;
                    k0.f1228h = false;
                    break;
                case 11:
                    f1151p = false;
                    break;
            }
            long j3 = 0;
            if (!a()) {
                B = 0L;
                D = 1;
                f1152q = 0L;
            } else if (!g(D)) {
                long j4 = Long.MIN_VALUE;
                int i4 = 1;
                for (int i5 : g.d.b(12)) {
                    if (i5 != 1 && g(i5)) {
                        long jC = c(i5);
                        if (jC >= j4) {
                            i4 = i5;
                            j4 = jC;
                        }
                    }
                }
                D = i4;
                if (i4 != 1) {
                    j3 = j4;
                }
                f1152q = j3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static long f(int i3) {
        if (i3 == 0) {
            return 0L;
        }
        int iA = g.d.a(i3);
        if (iA == 3) {
            return 1500L;
        }
        if (iA == 5) {
            return 600L;
        }
        if (iA != 7) {
            return iA != 9 ? 0L : 800L;
        }
        return 1000L;
    }

    public static boolean g(int i3) {
        if (i3 == 0) {
            return false;
        }
        switch (g.d.a(i3)) {
            case 1:
                return f1137a;
            case 2:
                return f1138b;
            case 3:
                return f1140d || f1141e;
            case 4:
            default:
                return false;
            case 5:
                return f1139c;
            case 6:
                return f1145i;
            case 7:
                return f1143g;
            case 8:
                return f1146j;
            case 9:
                return f1142f;
            case 10:
                return n;
            case 11:
                return f1151p;
        }
    }

    public static long h(long j3) {
        long jMin = Long.MAX_VALUE;
        for (int i3 : g.d.b(12)) {
            if (i3 != 1 && g(i3)) {
                long jMax = Math.max(0L, (f(i3) + c(i3)) - j3);
                if (jMax < jMin) {
                    jMin = jMax;
                }
            }
        }
        long jMax2 = Math.max(0L, B - j3);
        if (System.currentTimeMillis() < B && jMax2 < jMin) {
            jMin = Math.min(jMax2, 800L);
        }
        if (jMin == Long.MAX_VALUE) {
            return 0L;
        }
        return jMin;
    }

    public static synchronized void i(int i3) {
        if (i3 == 0 || i3 == 1) {
            return;
        }
        C[g.d.a(i3)] = System.currentTimeMillis();
    }

    public static synchronized void j() {
        f1137a = false;
        f1138b = false;
        f1139c = false;
        f1140d = false;
        f1141e = false;
        f1142f = false;
        f1143g = false;
        f1144h = false;
        f1145i = false;
        f1146j = false;
        f1147k = false;
        f1148l = false;
        f1149m = false;
        n = false;
        f1150o = false;
        k0.f1229i++;
        k0.f1228h = false;
        f1151p = false;
        D = 1;
        f1152q = 0L;
        f1153r = 0L;
        f1154s = 0L;
        f1155t = 0L;
        f1156u = 0L;
        f1157v = 0L;
        f1158w = 0L;
        f1159x = 0L;
        f1160y = 0L;
        f1161z = 0L;
        A = 0L;
        B = 0L;
        Arrays.fill(C, 0L);
    }

    public static boolean k() {
        return a() || System.currentTimeMillis() < B;
    }
}
