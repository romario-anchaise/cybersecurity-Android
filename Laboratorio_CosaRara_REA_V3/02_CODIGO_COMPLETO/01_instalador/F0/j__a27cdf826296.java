// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements f, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f176a;

    public j(int i2) {
        this.f176a = i2;
    }

    @Override // F0.f
    public final int e() {
        return this.f176a;
    }

    public final String toString() {
        o.f181a.getClass();
        String strA = p.a(this);
        i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
