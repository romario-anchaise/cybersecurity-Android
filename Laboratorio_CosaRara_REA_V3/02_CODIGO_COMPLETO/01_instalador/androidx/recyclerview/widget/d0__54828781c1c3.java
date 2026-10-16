// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0003c;
import A.C0005e;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends C0003c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f1911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHashMap f1912e = new WeakHashMap();

    public d0(e0 e0Var) {
        this.f1911d = e0Var;
    }

    @Override // A.C0003c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        return c0003c != null ? c0003c.a(view, accessibilityEvent) : this.f28a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // A.C0003c
    public final C0005e b(View view) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        return c0003c != null ? c0003c.b(view) : super.b(view);
    }

    @Override // A.C0003c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        if (c0003c != null) {
            c0003c.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // A.C0003c
    public final void d(View view, B.m mVar) {
        e0 e0Var = this.f1911d;
        boolean zK = e0Var.f1916d.K();
        View.AccessibilityDelegate accessibilityDelegate = this.f28a;
        AccessibilityNodeInfo accessibilityNodeInfo = mVar.f103a;
        if (!zK) {
            RecyclerView recyclerView = e0Var.f1916d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().Q(view, mVar);
                C0003c c0003c = (C0003c) this.f1912e.get(view);
                if (c0003c != null) {
                    c0003c.d(view, mVar);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // A.C0003c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        if (c0003c != null) {
            c0003c.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // A.C0003c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        C0003c c0003c = (C0003c) this.f1912e.get(viewGroup);
        return c0003c != null ? c0003c.f(viewGroup, view, accessibilityEvent) : this.f28a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // A.C0003c
    public final boolean g(View view, int i2, Bundle bundle) {
        e0 e0Var = this.f1911d;
        if (!e0Var.f1916d.K()) {
            RecyclerView recyclerView = e0Var.f1916d;
            if (recyclerView.getLayoutManager() != null) {
                C0003c c0003c = (C0003c) this.f1912e.get(view);
                if (c0003c != null) {
                    if (c0003c.g(view, i2, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i2, bundle)) {
                    return true;
                }
                U u2 = recyclerView.getLayoutManager().f1742b.f1792c;
                return false;
            }
        }
        return super.g(view, i2, bundle);
    }

    @Override // A.C0003c
    public final void h(View view, int i2) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        if (c0003c != null) {
            c0003c.h(view, i2);
        } else {
            super.h(view, i2);
        }
    }

    @Override // A.C0003c
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        C0003c c0003c = (C0003c) this.f1912e.get(view);
        if (c0003c != null) {
            c0003c.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
