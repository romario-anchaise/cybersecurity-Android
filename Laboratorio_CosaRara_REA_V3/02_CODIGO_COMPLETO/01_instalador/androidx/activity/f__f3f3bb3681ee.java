// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.N;
import androidx.lifecycle.T;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class f implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.h f1248b;

    public /* synthetic */ f(androidx.fragment.app.h hVar, int i2) {
        this.f1247a = i2;
        this.f1248b = hVar;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        switch (this.f1247a) {
            case 0:
                if (enumC0076n == EnumC0076n.ON_DESTROY) {
                    this.f1248b.mContextAwareHelper.f1157b = null;
                    if (this.f1248b.isChangingConfigurations()) {
                        return;
                    }
                    T viewModelStore = this.f1248b.getViewModelStore();
                    for (N n2 : viewModelStore.f1668a.values()) {
                        n2.f1662c = true;
                        HashMap map = n2.f1660a;
                        if (map != null) {
                            synchronized (map) {
                                try {
                                    Iterator it = n2.f1660a.values().iterator();
                                    while (it.hasNext()) {
                                        N.a(it.next());
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        LinkedHashSet linkedHashSet = n2.f1661b;
                        if (linkedHashSet != null) {
                            synchronized (linkedHashSet) {
                                try {
                                    Iterator it2 = n2.f1661b.iterator();
                                    while (it2.hasNext()) {
                                        N.a((Closeable) it2.next());
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            n2.f1661b.clear();
                        }
                        n2.b();
                    }
                    viewModelStore.f1668a.clear();
                    return;
                }
                return;
            case 1:
                if (enumC0076n == EnumC0076n.ON_STOP) {
                    Window window = this.f1248b.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                        return;
                    }
                    return;
                }
                return;
            default:
                androidx.fragment.app.h hVar = this.f1248b;
                hVar.ensureViewModelStore();
                hVar.getLifecycle().c(this);
                return;
        }
    }
}
