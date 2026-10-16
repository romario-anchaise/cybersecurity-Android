// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f1495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f1497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f1499e;

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        f1495a = charArray;
        int length = charArray.length;
        f1496b = length;
        f1497c = 0;
        f1499e = new HashMap(length);
        for (int i3 = 0; i3 < f1496b; i3++) {
            f1499e.put(Character.valueOf(f1495a[i3]), Integer.valueOf(i3));
        }
    }

    public static String a(long j3) {
        StringBuilder sb = new StringBuilder();
        do {
            int i3 = f1496b;
            sb.insert(0, f1495a[(int) (j3 % ((long) i3))]);
            j3 /= (long) i3;
        } while (j3 > 0);
        return sb.toString();
    }

    public static String b() {
        String strA = a(new Date().getTime());
        if (!strA.equals(f1498d)) {
            f1497c = 0;
            f1498d = strA;
            return strA;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strA);
        sb.append(".");
        int i3 = f1497c;
        f1497c = i3 + 1;
        sb.append(a(i3));
        return sb.toString();
    }
}
