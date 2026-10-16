// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.i;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4140c;

    public b(c cVar, int i2, int i3) {
        i.e(cVar, "list");
        this.f4138a = cVar;
        this.f4139b = i2;
        int iA = cVar.a();
        if (i2 < 0 || i3 > iA) {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + iA);
        }
        if (i2 <= i3) {
            this.f4140c = i3 - i2;
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
    }

    @Override // p036u0.c
    public final int a() {
        return this.f4140c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        int i3 = this.f4140c;
        if (i2 >= 0 && i2 < i3) {
            return this.f4138a.get(this.f4139b + i2);
        }
        throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
    }
}
