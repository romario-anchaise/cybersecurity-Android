// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3289g;

    public c(String str) {
        this.f3285c = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3;
        int i4;
        int i5 = this.f3286d;
        if (i5 != 0) {
            return i5 == 1;
        }
        if (this.f3289g < 0) {
            this.f3286d = 2;
            return false;
        }
        String str = this.f3285c;
        int length = str.length();
        int length2 = str.length();
        for (int i6 = this.f3287e; i6 < length2; i6++) {
            char cCharAt = str.charAt(i6);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i3 = (cCharAt == '\r' && (i4 = i6 + 1) < str.length() && str.charAt(i4) == '\n') ? 2 : 1;
                length = i6;
                this.f3286d = 1;
                this.f3289g = i3;
                this.f3288f = length;
                return true;
            }
        }
        i3 = -1;
        this.f3286d = 1;
        this.f3289g = i3;
        this.f3288f = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3286d = 0;
        int i3 = this.f3288f;
        int i4 = this.f3287e;
        this.f3287e = this.f3289g + i3;
        return this.f3285c.subSequence(i4, i3).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
