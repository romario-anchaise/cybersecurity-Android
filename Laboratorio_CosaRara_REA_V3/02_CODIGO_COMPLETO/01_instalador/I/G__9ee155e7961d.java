// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import F0.h;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class G extends n implements SubMenu {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final p f2862A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n f2863z;

    public G(Context context, n nVar, p pVar) {
        super(context);
        this.f2863z = nVar;
        this.f2862A = pVar;
    }

    @Override // p013i.n
    public final boolean d(p pVar) {
        return this.f2863z.d(pVar);
    }

    @Override // p013i.n
    public final boolean e(n nVar, MenuItem menuItem) {
        return super.e(nVar, menuItem) || this.f2863z.e(nVar, menuItem);
    }

    @Override // p013i.n
    public final boolean f(p pVar) {
        return this.f2863z.f(pVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f2862A;
    }

    @Override // p013i.n
    public final String j() {
        p pVar = this.f2862A;
        int i2 = pVar != null ? pVar.f2960a : 0;
        if (i2 == 0) {
            return null;
        }
        return h.b(i2, "android:menu:actionviewstates:");
    }

    @Override // p013i.n
    public final n k() {
        return this.f2863z.k();
    }

    @Override // p013i.n
    public final boolean m() {
        return this.f2863z.m();
    }

    @Override // p013i.n
    public final boolean n() {
        return this.f2863z.n();
    }

    @Override // p013i.n
    public final boolean o() {
        return this.f2863z.o();
    }

    @Override // p013i.n, android.view.Menu
    public final void setGroupDividerEnabled(boolean z2) {
        this.f2863z.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f2862A.setIcon(drawable);
        return this;
    }

    @Override // p013i.n, android.view.Menu
    public final void setQwertyMode(boolean z2) {
        this.f2863z.setQwertyMode(z2);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i2) {
        u(0, null, i2, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i2) {
        u(i2, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i2) {
        this.f2862A.setIcon(i2);
        return this;
    }
}
