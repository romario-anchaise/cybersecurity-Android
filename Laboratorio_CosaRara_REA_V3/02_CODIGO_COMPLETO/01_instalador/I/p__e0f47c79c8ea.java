// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.C0005e;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import f1.l;
import java.util.ArrayList;
import p035u.b;
import p037v.a;

/* JADX INFO: loaded from: classes.dex */
public final class p implements a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public q f2957A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f2958B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f2965f;
    public Intent g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f2966h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f2968j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f2970l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final n f2972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public G f2973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f2974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f2975q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f2976r;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2983y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f2984z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2967i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2969k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2971m = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f2977s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f2978t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2979u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2980v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2981w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2982x = 16;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f2959C = false;

    public p(n nVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f2972n = nVar;
        this.f2960a = i3;
        this.f2961b = i2;
        this.f2962c = i4;
        this.f2963d = i5;
        this.f2964e = charSequence;
        this.f2983y = i6;
    }

    public static void c(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    @Override // p037v.a
    public final q a() {
        return this.f2957A;
    }

    @Override // p037v.a
    public final a b(q qVar) {
        this.f2984z = null;
        this.f2957A = qVar;
        this.f2972n.p(true);
        q qVar2 = this.f2957A;
        if (qVar2 != null) {
            qVar2.f2987c = new C0005e(18, this);
            qVar2.f2985a.setVisibilityListener(qVar2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f2983y & 8) == 0) {
            return false;
        }
        if (this.f2984z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2958B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2972n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f2981w && (this.f2979u || this.f2980v)) {
            drawable = drawable.mutate();
            if (this.f2979u) {
                b.h(drawable, this.f2977s);
            }
            if (this.f2980v) {
                b.i(drawable, this.f2978t);
            }
            this.f2981w = false;
        }
        return drawable;
    }

    public final boolean e() {
        q qVar;
        if ((this.f2983y & 8) == 0) {
            return false;
        }
        if (this.f2984z == null && (qVar = this.f2957A) != null) {
            this.f2984z = qVar.a(this);
        }
        return this.f2984z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2958B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2972n.f(this);
        }
        return false;
    }

    public final boolean f() {
        return (this.f2982x & 32) == 32;
    }

    public final void g(boolean z2) {
        if (z2) {
            this.f2982x |= 32;
        } else {
            this.f2982x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f2984z;
        if (view != null) {
            return view;
        }
        q qVar = this.f2957A;
        if (qVar == null) {
            return null;
        }
        View viewA = qVar.a(this);
        this.f2984z = viewA;
        return viewA;
    }

    @Override // p037v.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f2969k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2968j;
    }

    @Override // p037v.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f2975q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f2961b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f2970l;
        if (drawable != null) {
            return d(drawable);
        }
        int i2 = this.f2971m;
        if (i2 == 0) {
            return null;
        }
        Drawable drawableA = l.A(this.f2972n.f2931a, i2);
        this.f2971m = 0;
        this.f2970l = drawableA;
        return d(drawableA);
    }

    @Override // p037v.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2977s;
    }

    @Override // p037v.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2978t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f2960a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p037v.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2967i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2966h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f2962c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f2973o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f2964e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2965f;
        return charSequence != null ? charSequence : this.f2964e;
    }

    @Override // p037v.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2976r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f2973o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f2959C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f2982x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f2982x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f2982x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        q qVar = this.f2957A;
        if (qVar == null || !qVar.f2985a.overridesItemVisibility()) {
            return (this.f2982x & 8) == 0;
        }
        return (this.f2982x & 8) == 0 && this.f2957A.f2985a.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i2;
        this.f2984z = view;
        this.f2957A = null;
        if (view != null && view.getId() == -1 && (i2 = this.f2960a) > 0) {
            view.setId(i2);
        }
        n nVar = this.f2972n;
        nVar.f2940k = true;
        nVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.f2968j == c2) {
            return this;
        }
        this.f2968j = Character.toLowerCase(c2);
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z2) {
        int i2 = this.f2982x;
        int i3 = (z2 ? 1 : 0) | (i2 & (-2));
        this.f2982x = i3;
        if (i2 != i3) {
            this.f2972n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z2) {
        int i2 = this.f2982x;
        if ((i2 & 4) != 0) {
            n nVar = this.f2972n;
            nVar.getClass();
            ArrayList arrayList = nVar.f2936f;
            int size = arrayList.size();
            nVar.w();
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = (p) arrayList.get(i3);
                if (pVar.f2961b == this.f2961b && (pVar.f2982x & 4) != 0 && pVar.isCheckable()) {
                    boolean z3 = pVar == this;
                    int i4 = pVar.f2982x;
                    int i5 = (z3 ? 2 : 0) | (i4 & (-3));
                    pVar.f2982x = i5;
                    if (i4 != i5) {
                        pVar.f2972n.p(false);
                    }
                }
            }
            nVar.v();
        } else {
            int i6 = (i2 & (-3)) | (z2 ? 2 : 0);
            this.f2982x = i6;
            if (i2 != i6) {
                this.f2972n.p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f2982x |= 16;
        } else {
            this.f2982x &= -17;
        }
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2971m = 0;
        this.f2970l = drawable;
        this.f2981w = true;
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2977s = colorStateList;
        this.f2979u = true;
        this.f2981w = true;
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2978t = mode;
        this.f2980v = true;
        this.f2981w = true;
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        if (this.f2966h == c2) {
            return this;
        }
        this.f2966h = c2;
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2958B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2974p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3) {
        this.f2966h = c2;
        this.f2968j = Character.toLowerCase(c3);
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f2983y = i2;
        n nVar = this.f2972n;
        nVar.f2940k = true;
        nVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2964e = charSequence;
        this.f2972n.p(false);
        G g = this.f2973o;
        if (g != null) {
            g.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2965f = charSequence;
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z2) {
        int i2 = this.f2982x;
        int i3 = (z2 ? 0 : 8) | (i2 & (-9));
        this.f2982x = i3;
        if (i2 != i3) {
            n nVar = this.f2972n;
            nVar.f2937h = true;
            nVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f2964e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // p037v.a, android.view.MenuItem
    public final a setContentDescription(CharSequence charSequence) {
        this.f2975q = charSequence;
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final a setTooltipText(CharSequence charSequence) {
        this.f2976r = charSequence;
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f2968j == c2 && this.f2969k == i2) {
            return this;
        }
        this.f2968j = Character.toLowerCase(c2);
        this.f2969k = KeyEvent.normalizeMetaState(i2);
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f2966h == c2 && this.f2967i == i2) {
            return this;
        }
        this.f2966h = c2;
        this.f2967i = KeyEvent.normalizeMetaState(i2);
        this.f2972n.p(false);
        return this;
    }

    @Override // p037v.a, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f2966h = c2;
        this.f2967i = KeyEvent.normalizeMetaState(i2);
        this.f2968j = Character.toLowerCase(c3);
        this.f2969k = KeyEvent.normalizeMetaState(i3);
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.f2970l = null;
        this.f2971m = i2;
        this.f2981w = true;
        this.f2972n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        setTitle(this.f2972n.f2931a.getString(i2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        int i3;
        Context context = this.f2972n.f2931a;
        View viewInflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false);
        this.f2984z = viewInflate;
        this.f2957A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i3 = this.f2960a) > 0) {
            viewInflate.setId(i3);
        }
        n nVar = this.f2972n;
        nVar.f2940k = true;
        nVar.p(true);
        return this;
    }
}
