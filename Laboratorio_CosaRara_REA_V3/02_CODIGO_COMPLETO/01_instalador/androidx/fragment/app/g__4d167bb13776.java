// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.os.Handler;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public final class g implements U, InterfaceC0082u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f1548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f1550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0121k f1551d;

    public g(AbstractActivityC0121k abstractActivityC0121k) {
        this.f1551d = abstractActivityC0121k;
        Handler handler = new Handler();
        this.f1550c = new s();
        this.f1548a = abstractActivityC0121k;
        this.f1549b = handler;
    }

    @Override // androidx.lifecycle.InterfaceC0082u
    public final AbstractC0078p getLifecycle() {
        return this.f1551d.mFragmentLifecycleRegistry;
    }

    @Override // androidx.lifecycle.U
    public final T getViewModelStore() {
        return this.f1551d.getViewModelStore();
    }
}
