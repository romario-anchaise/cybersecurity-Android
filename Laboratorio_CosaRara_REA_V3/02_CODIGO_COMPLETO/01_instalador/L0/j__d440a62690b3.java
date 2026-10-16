// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import M0.o;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M0.c f356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f357b;

    public j(M0.c cVar, o oVar) {
        this.f356a = cVar;
        this.f357b = oVar;
    }

    @Override // L0.c
    public final Iterator iterator() {
        return new i(this);
    }
}
