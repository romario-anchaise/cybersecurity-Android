// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1951c;

    public /* synthetic */ d(long j3) {
        this.f1951c = j3;
    }

    public static String a(long j3) {
        if (j3 >= 0) {
            q2.c.g(10);
            String string = Long.toString(j3, 10);
            string.getClass();
            return string;
        }
        long j4 = 10;
        long j5 = ((j3 >>> 1) / j4) << 1;
        long j6 = j3 - (j5 * j4);
        if (j6 >= j4) {
            j6 -= j4;
            j5++;
        }
        q2.c.g(10);
        String string2 = Long.toString(j5, 10);
        string2.getClass();
        q2.c.g(10);
        String string3 = Long.toString(j6, 10);
        string3.getClass();
        return string2.concat(string3);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j3 = ((d) obj).f1951c;
        long j4 = this.f1951c ^ Long.MIN_VALUE;
        long j5 = j3 ^ Long.MIN_VALUE;
        if (j4 < j5) {
            return -1;
        }
        return j4 == j5 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f1951c == ((d) obj).f1951c;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1951c);
    }

    public final String toString() {
        return a(this.f1951c);
    }
}
