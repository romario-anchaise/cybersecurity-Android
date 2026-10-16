// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import H.s;
import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import p013i.l;
import p013i.n;
import p015j.C0154k;

/* JADX INFO: loaded from: classes.dex */
public final class f extends b implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f2784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContextView f2785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f2786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference f2787f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f2788h;

    @Override // p011h.b
    public final void a() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.f2786e.e(this);
    }

    @Override // p011h.b
    public final View b() {
        WeakReference weakReference = this.f2787f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // p011h.b
    public final n c() {
        return this.f2788h;
    }

    @Override // p011h.b
    public final MenuInflater d() {
        return new j(this.f2785d.getContext());
    }

    @Override // p011h.b
    public final CharSequence e() {
        return this.f2785d.getSubtitle();
    }

    @Override // p013i.l
    public final void f(n nVar) {
        h();
        C0154k c0154k = this.f2785d.f1308d;
        if (c0154k != null) {
            c0154k.l();
        }
    }

    @Override // p011h.b
    public final CharSequence g() {
        return this.f2785d.getTitle();
    }

    @Override // p011h.b
    public final void h() {
        this.f2786e.c(this, this.f2788h);
    }

    @Override // p011h.b
    public final boolean i() {
        return this.f2785d.f1322s;
    }

    @Override // p011h.b
    public final void j(View view) {
        this.f2785d.setCustomView(view);
        this.f2787f = view != null ? new WeakReference(view) : null;
    }

    @Override // p011h.b
    public final void k(int i2) {
        l(this.f2784c.getString(i2));
    }

    @Override // p011h.b
    public final void l(CharSequence charSequence) {
        this.f2785d.setSubtitle(charSequence);
    }

    @Override // p013i.l
    public final boolean m(n nVar, MenuItem menuItem) {
        return ((a) this.f2786e.f232b).a(this, menuItem);
    }

    @Override // p011h.b
    public final void n(int i2) {
        o(this.f2784c.getString(i2));
    }

    @Override // p011h.b
    public final void o(CharSequence charSequence) {
        this.f2785d.setTitle(charSequence);
    }

    @Override // p011h.b
    public final void p(boolean z2) {
        this.f2777b = z2;
        this.f2785d.setTitleOptional(z2);
    }
}
