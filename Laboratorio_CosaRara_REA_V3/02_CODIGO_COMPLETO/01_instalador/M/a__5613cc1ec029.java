// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3667e;

    public a(int i2) {
        this.f3663a = i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3664b < this.f3663a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objE;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f3664b;
        switch (this.f3666d) {
            case 0:
                objE = ((e) this.f3667e).e(i2);
                break;
            case 1:
                objE = ((e) this.f3667e).h(i2);
                break;
            default:
                objE = ((f) this.f3667e).f3679b[i2];
                break;
        }
        this.f3664b++;
        this.f3665c = true;
        return objE;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3665c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i2 = this.f3664b - 1;
        this.f3664b = i2;
        switch (this.f3666d) {
            case 0:
                ((e) this.f3667e).f(i2);
                break;
            case 1:
                ((e) this.f3667e).f(i2);
                break;
            default:
                ((f) this.f3667e).a(i2);
                break;
        }
        this.f3663a--;
        this.f3665c = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f3680c);
        this.f3666d = 2;
        this.f3667e = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i2) {
        this(eVar.f3689c);
        this.f3666d = i2;
        switch (i2) {
            case 1:
                this.f3667e = eVar;
                this(eVar.f3689c);
                break;
            default:
                this.f3667e = eVar;
                break;
        }
    }
}
