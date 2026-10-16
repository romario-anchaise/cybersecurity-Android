// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class t implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f2991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f2992b;

    public t(u uVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2992b = uVar;
        this.f2991a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f2991a.onMenuItemClick(this.f2992b.f(menuItem));
    }
}
