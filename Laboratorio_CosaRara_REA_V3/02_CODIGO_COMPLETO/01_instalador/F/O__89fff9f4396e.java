// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import H.s;
import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import p011h.a;
import p011h.b;
import p011h.j;
import p013i.l;
import p013i.n;
import p015j.C0154k;

/* JADX INFO: loaded from: classes.dex */
public final class O extends b implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f2433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f2434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference f2435f;
    public final /* synthetic */ P g;

    public O(P p2, Context context, s sVar) {
        this.g = p2;
        this.f2432c = context;
        this.f2434e = sVar;
        n nVar = new n(context);
        nVar.f2941l = 1;
        this.f2433d = nVar;
        nVar.f2935e = this;
    }

    @Override // p011h.b
    public final void a() {
        P p2 = this.g;
        if (p2.f2445i != this) {
            return;
        }
        if (p2.f2452p) {
            p2.f2446j = this;
            p2.f2447k = this.f2434e;
        } else {
            this.f2434e.e(this);
        }
        this.f2434e = null;
        p2.p(false);
        ActionBarContextView actionBarContextView = p2.f2443f;
        if (actionBarContextView.f1314k == null) {
            actionBarContextView.e();
        }
        p2.f2440c.setHideOnContentScrollEnabled(p2.f2457u);
        p2.f2445i = null;
    }

    @Override // p011h.b
    public final View b() {
        WeakReference weakReference = this.f2435f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // p011h.b
    public final n c() {
        return this.f2433d;
    }

    @Override // p011h.b
    public final MenuInflater d() {
        return new j(this.f2432c);
    }

    @Override // p011h.b
    public final CharSequence e() {
        return this.g.f2443f.getSubtitle();
    }

    @Override // p013i.l
    public final void f(n nVar) {
        if (this.f2434e == null) {
            return;
        }
        h();
        C0154k c0154k = this.g.f2443f.f1308d;
        if (c0154k != null) {
            c0154k.l();
        }
    }

    @Override // p011h.b
    public final CharSequence g() {
        return this.g.f2443f.getTitle();
    }

    @Override // p011h.b
    public final void h() {
        if (this.g.f2445i != this) {
            return;
        }
        n nVar = this.f2433d;
        nVar.w();
        try {
            this.f2434e.c(this, nVar);
        } finally {
            nVar.v();
        }
    }

    @Override // p011h.b
    public final boolean i() {
        return this.g.f2443f.f1322s;
    }

    @Override // p011h.b
    public final void j(View view) {
        this.g.f2443f.setCustomView(view);
        this.f2435f = new WeakReference(view);
    }

    @Override // p011h.b
    public final void k(int i2) {
        l(this.g.f2438a.getResources().getString(i2));
    }

    @Override // p011h.b
    public final void l(CharSequence charSequence) {
        this.g.f2443f.setSubtitle(charSequence);
    }

    @Override // p013i.l
    public final boolean m(n nVar, MenuItem menuItem) {
        s sVar = this.f2434e;
        if (sVar != null) {
            return ((a) sVar.f232b).a(this, menuItem);
        }
        return false;
    }

    @Override // p011h.b
    public final void n(int i2) {
        o(this.g.f2438a.getResources().getString(i2));
    }

    @Override // p011h.b
    public final void o(CharSequence charSequence) {
        this.g.f2443f.setTitle(charSequence);
    }

    @Override // p011h.b
    public final void p(boolean z2) {
        this.f2777b = z2;
        this.g.f2443f.setTitleOptional(z2);
    }
}
