// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import V.b;
import p010f0.i;
import p010f0.m;
import p044y0.c;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f1189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f1190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f1191f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f1192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public V.c f1193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f1195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h f1196l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1197m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, c cVar) {
        super(cVar);
        this.f1196l = hVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f1195k = obj;
        this.f1197m |= Integer.MIN_VALUE;
        return this.f1196l.c(null, null, null, null, null, this);
    }
}
