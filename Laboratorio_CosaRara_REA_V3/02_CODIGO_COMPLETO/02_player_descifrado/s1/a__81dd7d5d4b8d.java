// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s1;

import java.util.Iterator;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3231e;

    public a(int i3, int i4, int i5) {
        if (i5 == 0) {
            o2.i("Step must be non-zero.");
            throw null;
        }
        if (i5 == Integer.MIN_VALUE) {
            o2.i("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f3229c = i3;
        this.f3230d = m0.a.i(i3, i4, i5);
        this.f3231e = i5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f3229c == aVar.f3229c && this.f3230d == aVar.f3230d && this.f3231e == aVar.f3231e;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3229c * 31) + this.f3230d) * 31) + this.f3231e;
    }

    public boolean isEmpty() {
        int i3 = this.f3230d;
        int i4 = this.f3231e;
        int i5 = this.f3229c;
        if (i4 > 0) {
            return i5 > i3;
        }
        return i5 < i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f3229c, this.f3230d, this.f3231e);
    }

    public String toString() {
        StringBuilder sb;
        int i3 = this.f3230d;
        int i4 = this.f3231e;
        int i5 = this.f3229c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i5);
            sb.append("..");
            sb.append(i3);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i5);
            sb.append(" downTo ");
            sb.append(i3);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
