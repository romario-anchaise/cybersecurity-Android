// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f363a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public J0.c f366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f368f;

    public b(c cVar) {
        this.f368f = cVar;
        int i2 = cVar.f370b;
        int length = cVar.f369a.length();
        if (length < 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > length) {
            i2 = length;
        }
        this.f364b = i2;
        this.f365c = i2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:17:0x006f  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    /* JADX WARN: Type inference failed for: r0v1, types: [E0.p, F0.j] */
    public final void a() {
        p034t0.d dVar;
        int i2 = this.f365c;
        if (i2 < 0) {
            this.f363a = 0;
            this.f366d = null;
            return;
        }
        c cVar = this.f368f;
        int i3 = cVar.f371c;
        CharSequence charSequence = cVar.f369a;
        if (i3 > 0) {
            int i4 = this.f367e + 1;
            this.f367e = i4;
            if (i4 >= i3) {
                this.f366d = new J0.c(this.f364b, e.V(charSequence), 1);
                this.f365c = -1;
            } else if (i2 > charSequence.length() && (dVar = (p034t0.d) cVar.f372d.c(charSequence, Integer.valueOf(this.f365c))) != null) {
                int iIntValue = ((Number) dVar.f4126a).intValue();
                int iIntValue2 = ((Number) dVar.f4127b).intValue();
                this.f366d = f1.d.F(this.f364b, iIntValue);
                int i5 = iIntValue + iIntValue2;
                this.f364b = i5;
                this.f365c = i5 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.f366d = new J0.c(this.f364b, e.V(charSequence), 1);
                this.f365c = -1;
            }
        } else if (i2 > charSequence.length()) {
            this.f366d = new J0.c(this.f364b, e.V(charSequence), 1);
            this.f365c = -1;
        } else {
            int iIntValue3 = ((Number) dVar.f4126a).intValue();
            int iIntValue4 = ((Number) dVar.f4127b).intValue();
            this.f366d = f1.d.F(this.f364b, iIntValue3);
            int i6 = iIntValue3 + iIntValue4;
            this.f364b = i6;
            this.f365c = i6 + (iIntValue4 == 0 ? 1 : 0);
        }
        this.f363a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f363a == -1) {
            a();
        }
        return this.f363a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f363a == -1) {
            a();
        }
        if (this.f363a == 0) {
            throw new NoSuchElementException();
        }
        J0.c cVar = this.f366d;
        F0.i.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f366d = null;
        this.f363a = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
