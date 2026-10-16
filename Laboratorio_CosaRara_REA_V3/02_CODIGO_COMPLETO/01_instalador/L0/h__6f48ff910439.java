// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M0.c f353a;

    public h(M0.c cVar) {
        this.f353a = cVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new M0.b(this.f353a);
    }
}
