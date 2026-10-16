// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import androidx.activity.i;
import p000a.b;

/* JADX INFO: renamed from: f.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0120j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0121k f2502a;

    public C0120j(AbstractActivityC0121k abstractActivityC0121k) {
        this.f2502a = abstractActivityC0121k;
    }

    @Override // p000a.b
    public final void a(i iVar) {
        AbstractActivityC0121k abstractActivityC0121k = this.f2502a;
        AbstractC0125o delegate = abstractActivityC0121k.getDelegate();
        delegate.a();
        abstractActivityC0121k.getSavedStateRegistry().a("androidx:appcompat");
        delegate.d();
    }
}
