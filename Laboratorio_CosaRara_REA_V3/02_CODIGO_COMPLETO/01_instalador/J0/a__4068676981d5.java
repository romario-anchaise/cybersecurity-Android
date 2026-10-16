// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J0;

import java.util.Iterator;
import p029q.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f280c;

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f278a = i2;
        this.f279b = j.k(i2, i3, i4);
        this.f280c = i4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f278a != aVar.f278a || this.f279b != aVar.f279b || this.f280c != aVar.f280c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f278a * 31) + this.f279b) * 31) + this.f280c;
    }

    public boolean isEmpty() {
        int i2 = this.f280c;
        int i3 = this.f279b;
        int i4 = this.f278a;
        if (i2 > 0) {
            if (i4 <= i3) {
                return false;
            }
        } else if (i4 >= i3) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f278a, this.f279b, this.f280c);
    }

    public String toString() {
        StringBuilder sb;
        int i2 = this.f279b;
        int i3 = this.f278a;
        int i4 = this.f280c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i2);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i2);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
