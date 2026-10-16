// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

/* JADX INFO: loaded from: classes.dex */
public final class G extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3765d;

    public G(boolean z2) {
        this.f3765d = z2;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        if (obj == null) {
            return;
        }
        l2.d(obj.toString(), null, this.f3765d);
    }
}
