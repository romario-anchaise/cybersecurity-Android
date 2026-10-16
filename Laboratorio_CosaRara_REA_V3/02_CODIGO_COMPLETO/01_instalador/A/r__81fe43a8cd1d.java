// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f64a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f65b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f66c = new HashMap();

    public r(Runnable runnable) {
        this.f64a = runnable;
    }

    public final void a() {
        this.f65b.remove((Object) null);
        C0017q c0017q = (C0017q) this.f66c.remove(null);
        if (c0017q != null) {
            c0017q.f62a.c(c0017q.f63b);
            c0017q.f63b = null;
        }
        this.f64a.run();
    }
}
