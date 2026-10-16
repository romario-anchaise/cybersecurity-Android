// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.fragment.app.m f1258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f1259b;

    public n(o oVar, androidx.fragment.app.m mVar) {
        this.f1259b = oVar;
        this.f1258a = mVar;
    }

    @Override // androidx.activity.a
    public final void cancel() {
        o oVar = this.f1259b;
        ArrayDeque arrayDeque = oVar.f1261b;
        androidx.fragment.app.m mVar = this.f1258a;
        arrayDeque.remove(mVar);
        mVar.f1561b.remove(this);
        if (p039w.b.a()) {
            mVar.f1562c = null;
            oVar.b();
        }
    }
}
