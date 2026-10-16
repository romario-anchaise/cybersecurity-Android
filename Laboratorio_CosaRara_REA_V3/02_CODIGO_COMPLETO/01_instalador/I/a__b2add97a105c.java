// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p031r.c;
import p035u.b;
import p037v.a;

/* JADX INFO: renamed from: i.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0127a implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f2864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f2865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f2866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f2867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char f2869f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f2870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f2871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f2872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f2874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f2875m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2876n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2877o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2878p;

    @Override // p037v.a
    public final q a() {
        return null;
    }

    @Override // p037v.a
    public final a b(q qVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f2870h;
        if (drawable != null) {
            if (this.f2876n || this.f2877o) {
                this.f2870h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f2870h = drawableMutate;
                if (this.f2876n) {
                    b.h(drawableMutate, this.f2874l);
                }
                if (this.f2877o) {
                    b.i(this.f2870h, this.f2875m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // p037v.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2869f;
    }

    @Override // p037v.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f2872j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f2870h;
    }

    @Override // p037v.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2874l;
    }

    @Override // p037v.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2875m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f2866c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p037v.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2868e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2867d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f2864a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2865b;
        return charSequence != null ? charSequence : this.f2864a;
    }

    @Override // p037v.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2873k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f2878p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f2878p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f2878p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f2878p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        this.f2869f = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z2) {
        this.f2878p = (z2 ? 1 : 0) | (this.f2878p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z2) {
        this.f2878p = (z2 ? 2 : 0) | (this.f2878p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f2872j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z2) {
        this.f2878p = (z2 ? 16 : 0) | (this.f2878p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2870h = drawable;
        c();
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2874l = colorStateList;
        this.f2876n = true;
        c();
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2875m = mode;
        this.f2877o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f2866c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        this.f2867d = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3) {
        this.f2867d = c2;
        this.f2869f = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2864a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2865b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f2873k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z2) {
        this.f2878p = (this.f2878p & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f2869f = Character.toLowerCase(c2);
        this.g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final a setContentDescription(CharSequence charSequence) {
        this.f2872j = charSequence;
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        this.f2867d = c2;
        this.f2868e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        this.f2864a = this.f2871i.getResources().getString(i2);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final a setTooltipText(CharSequence charSequence) {
        this.f2873k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.f2870h = c.b(this.f2871i, i2);
        c();
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f2867d = c2;
        this.f2868e = KeyEvent.normalizeMetaState(i2);
        this.f2869f = Character.toLowerCase(c3);
        this.g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i2) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        return this;
    }
}
