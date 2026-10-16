// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import android.graphics.Bitmap;
import p010f0.p;

/* JADX INFO: loaded from: classes.dex */
public final class h extends p044y0.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p010f0.i f668f;
    public c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k f671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f672k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, p044y0.c cVar) {
        super(cVar);
        this.f671j = kVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        this.f670i = obj;
        this.f672k |= Integer.MIN_VALUE;
        return k.a(this.f671j, null, this);
    }
}
