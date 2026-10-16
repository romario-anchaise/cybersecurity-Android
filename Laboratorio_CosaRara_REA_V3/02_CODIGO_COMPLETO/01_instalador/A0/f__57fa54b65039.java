// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import p044y0.c;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f1198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f1199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1200f;
    public final /* synthetic */ h g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1201h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, c cVar) {
        super(cVar);
        this.g = hVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f1200f = obj;
        this.f1201h |= Integer.MIN_VALUE;
        return this.g.d(null, this);
    }
}
