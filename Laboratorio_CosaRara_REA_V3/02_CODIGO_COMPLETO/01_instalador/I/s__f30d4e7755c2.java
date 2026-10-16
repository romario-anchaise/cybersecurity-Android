// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class s implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f2989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f2990b;

    public s(u uVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2990b = uVar;
        this.f2989a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f2989a.onMenuItemActionCollapse(this.f2990b.f(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f2989a.onMenuItemActionExpand(this.f2990b.f(menuItem));
    }
}
