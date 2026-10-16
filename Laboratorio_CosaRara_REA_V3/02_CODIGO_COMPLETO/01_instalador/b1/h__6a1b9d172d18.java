// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class h extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2129a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar, Object obj) {
        super(jVar);
        F0.i.e(jVar, "referent");
        this.f2129a = obj;
    }
}
