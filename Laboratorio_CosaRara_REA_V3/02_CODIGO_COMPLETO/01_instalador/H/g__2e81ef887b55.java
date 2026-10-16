// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import p013i.D;

/* JADX INFO: loaded from: classes.dex */
public final class g extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2790b;

    public g(Context context, b bVar) {
        this.f2789a = context;
        this.f2790b = bVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f2790b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f2790b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new D(this.f2789a, this.f2790b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f2790b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f2790b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f2790b.f2776a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f2790b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f2790b.f2777b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f2790b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f2790b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f2790b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f2790b.l(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f2790b.f2776a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f2790b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z2) {
        this.f2790b.p(z2);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i2) {
        this.f2790b.k(i2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i2) {
        this.f2790b.n(i2);
    }
}
