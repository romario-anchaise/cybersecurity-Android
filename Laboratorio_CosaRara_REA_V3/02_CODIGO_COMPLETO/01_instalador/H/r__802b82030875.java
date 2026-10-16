// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f225a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f230f;

    public r(w wVar) {
        this.f226b = wVar;
        this.f227c = wVar;
    }

    public final int a(int i2) {
        SparseArray sparseArray = this.f227c.f244a;
        w wVar = sparseArray == null ? null : (w) sparseArray.get(i2);
        int i3 = 1;
        int i4 = 2;
        if (this.f225a == 2) {
            if (wVar != null) {
                this.f227c = wVar;
                this.f230f++;
            } else if (i2 == 65038) {
                b();
            } else if (i2 != 65039) {
                w wVar2 = this.f227c;
                if (wVar2.f245b != null) {
                    i4 = 3;
                    if (this.f230f != 1) {
                        this.f228d = wVar2;
                        b();
                    } else if (c()) {
                        this.f228d = this.f227c;
                        b();
                    } else {
                        b();
                    }
                } else {
                    b();
                }
            }
            i3 = i4;
        } else if (wVar == null) {
            b();
        } else {
            this.f225a = 2;
            this.f227c = wVar;
            this.f230f = 1;
            i3 = i4;
        }
        this.f229e = i2;
        return i3;
    }

    public final void b() {
        this.f225a = 1;
        this.f227c = this.f226b;
        this.f230f = 0;
    }

    public final boolean c() {
        I.a aVarC = this.f227c.f245b.c();
        int iA = aVarC.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarC.f5d).get(iA + aVarC.f2a) == 0) || this.f229e == 65039;
    }
}
