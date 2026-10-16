// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p040w0;

import E0.p;
import F0.i;
import p029q.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f4158a;

    public a(h hVar) {
        this.f4158a = hVar;
    }

    @Override // p040w0.g
    public final h getKey() {
        return this.f4158a;
    }

    @Override // p040w0.i
    public g j(h hVar) {
        return p028p0.a.g(this, hVar);
    }

    @Override // p040w0.i
    public final Object n(Object obj, p pVar) {
        return pVar.c(obj, this);
    }

    @Override // p040w0.i
    public i r(h hVar) {
        return p028p0.a.n(this, hVar);
    }

    @Override // p040w0.i
    public final i t(i iVar) {
        i.e(iVar, "context");
        return j.n(this, iVar);
    }
}
