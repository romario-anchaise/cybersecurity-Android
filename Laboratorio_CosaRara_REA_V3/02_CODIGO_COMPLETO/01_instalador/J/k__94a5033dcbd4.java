// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;
import p013i.A;
import p013i.B;
import p013i.C;
import p013i.G;
import p013i.n;
import p013i.p;
import p013i.q;
import p013i.v;
import p013i.z;

/* JADX INFO: renamed from: j.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0154k implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f3208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutInflater f3209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f3210e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C f3212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0152j f3213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f3214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3221q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public C0146g f3223s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public C0146g f3224t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RunnableC0150i f3225u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public C0148h f3226v;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3211f = R.layout.abc_action_menu_layout;
    public final int g = R.layout.abc_action_menu_item_layout;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SparseBooleanArray f3222r = new SparseBooleanArray();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final C0005e f3227w = new C0005e(19, this);

    public C0154k(Context context) {
        this.f3206a = context;
        this.f3209d = LayoutInflater.from(context);
    }

    @Override // p013i.A
    public final void a(n nVar, boolean z2) {
        e();
        C0146g c0146g = this.f3224t;
        if (c0146g != null && c0146g.b()) {
            c0146g.f3004i.dismiss();
        }
        z zVar = this.f3210e;
        if (zVar != null) {
            zVar.a(nVar, z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(p pVar, View view, ViewGroup viewGroup) {
        B b2;
        View actionView = pVar.getActionView();
        if (actionView == null || pVar.e()) {
            if (view instanceof B) {
                b2 = (B) view;
            } else {
                b2 = (B) this.f3209d.inflate(this.g, viewGroup, false);
            }
            b2.c(pVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) b2;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f3212h);
            if (this.f3226v == null) {
                this.f3226v = new C0148h(this);
            }
            actionMenuItemView.setPopupCallback(this.f3226v);
            actionView = (View) b2;
        }
        actionView.setVisibility(pVar.f2959C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C0158m)) {
            actionView.setLayoutParams(ActionMenuView.l(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013i.A
    public final void c() {
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f3212h;
        ArrayList arrayList = null;
        boolean z2 = false;
        if (viewGroup != null) {
            n nVar = this.f3208c;
            if (nVar != null) {
                nVar.i();
                ArrayList arrayListL = this.f3208c.l();
                int size = arrayListL.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    p pVar = (p) arrayListL.get(i3);
                    if (pVar.f()) {
                        View childAt = viewGroup.getChildAt(i2);
                        p itemData = childAt instanceof B ? ((B) childAt).getItemData() : null;
                        View viewB = b(pVar, childAt, viewGroup);
                        if (pVar != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewB);
                            }
                            ((ViewGroup) this.f3212h).addView(viewB, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i2) == this.f3213i) {
                    i2++;
                } else {
                    viewGroup.removeViewAt(i2);
                }
            }
        }
        ((View) this.f3212h).requestLayout();
        n nVar2 = this.f3208c;
        if (nVar2 != null) {
            nVar2.i();
            ArrayList arrayList2 = nVar2.f2938i;
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                q qVar = ((p) arrayList2.get(i4)).f2957A;
            }
        }
        n nVar3 = this.f3208c;
        if (nVar3 != null) {
            nVar3.i();
            arrayList = nVar3.f2939j;
        }
        if (this.f3216l && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z2 = !((p) arrayList.get(0)).f2959C;
            } else if (size3 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f3213i == null) {
                this.f3213i = new C0152j(this, this.f3206a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f3213i.getParent();
            if (viewGroup3 != this.f3212h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f3213i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f3212h;
                C0152j c0152j = this.f3213i;
                actionMenuView.getClass();
                C0158m c0158mK = ActionMenuView.k();
                c0158mK.f3241a = true;
                actionMenuView.addView(c0152j, c0158mK);
            }
        } else {
            C0152j c0152j2 = this.f3213i;
            if (c0152j2 != null) {
                Object parent = c0152j2.getParent();
                Object obj = this.f3212h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f3213i);
                }
            }
        }
        ((ActionMenuView) this.f3212h).setOverflowReserved(this.f3216l);
    }

    @Override // p013i.A
    public final boolean d(p pVar) {
        return false;
    }

    public final boolean e() {
        Object obj;
        RunnableC0150i runnableC0150i = this.f3225u;
        if (runnableC0150i != null && (obj = this.f3212h) != null) {
            ((View) obj).removeCallbacks(runnableC0150i);
            this.f3225u = null;
            return true;
        }
        C0146g c0146g = this.f3223s;
        if (c0146g == null) {
            return false;
        }
        if (c0146g.b()) {
            c0146g.f3004i.dismiss();
        }
        return true;
    }

    @Override // p013i.A
    public final boolean f() {
        int size;
        ArrayList arrayListL;
        int i2;
        boolean z2;
        n nVar = this.f3208c;
        if (nVar != null) {
            arrayListL = nVar.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i3 = this.f3220p;
        int i4 = this.f3219o;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f3212h;
        int i5 = 0;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z2 = true;
            if (i5 >= size) {
                break;
            }
            p pVar = (p) arrayListL.get(i5);
            int i8 = pVar.f2983y;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z3 = true;
            }
            if (this.f3221q && pVar.f2959C) {
                i3 = 0;
            }
            i5++;
        }
        if (this.f3216l && (z3 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = this.f3222r;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            p pVar2 = (p) arrayListL.get(i10);
            int i12 = pVar2.f2983y;
            boolean z4 = (i12 & 2) == i2 ? z2 : false;
            int i13 = pVar2.f2961b;
            if (z4) {
                View viewB = b(pVar2, null, viewGroup);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z2);
                }
                pVar2.g(z2);
            } else {
                if ((i12 & 1) == z2) {
                    boolean z5 = sparseBooleanArray.get(i13);
                    boolean z6 = ((i9 > 0 || z5) && i4 > 0) ? z2 : false;
                    if (z6) {
                        View viewB2 = b(pVar2, null, viewGroup);
                        viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        int measuredWidth2 = viewB2.getMeasuredWidth();
                        i4 -= measuredWidth2;
                        if (i11 == 0) {
                            i11 = measuredWidth2;
                        }
                        z6 &= i4 + i11 > 0;
                    }
                    if (z6 && i13 != 0) {
                        sparseBooleanArray.put(i13, true);
                    } else if (z5) {
                        sparseBooleanArray.put(i13, false);
                        for (int i14 = 0; i14 < i10; i14++) {
                            p pVar3 = (p) arrayListL.get(i14);
                            if (pVar3.f2961b == i13) {
                                if (pVar3.f()) {
                                    i9++;
                                }
                                pVar3.g(false);
                            }
                        }
                    }
                    if (z6) {
                        i9--;
                    }
                    pVar2.g(z6);
                } else {
                    pVar2.g(false);
                }
                i10++;
                i2 = 2;
                z2 = true;
            }
            i10++;
            i2 = 2;
            z2 = true;
        }
        return z2;
    }

    @Override // p013i.A
    public final void g(Context context, n nVar) {
        this.f3207b = context;
        LayoutInflater.from(context);
        this.f3208c = nVar;
        Resources resources = context.getResources();
        if (!this.f3217m) {
            this.f3216l = true;
        }
        int i2 = 2;
        this.f3218n = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
            i2 = 5;
        } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
            i2 = 4;
        } else if (i3 >= 360) {
            i2 = 3;
        }
        this.f3220p = i2;
        int measuredWidth = this.f3218n;
        if (this.f3216l) {
            if (this.f3213i == null) {
                C0152j c0152j = new C0152j(this, this.f3206a);
                this.f3213i = c0152j;
                if (this.f3215k) {
                    c0152j.setImageDrawable(this.f3214j);
                    this.f3214j = null;
                    this.f3215k = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3213i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f3213i.getMeasuredWidth();
        } else {
            this.f3213i = null;
        }
        this.f3219o = measuredWidth;
        float f2 = resources.getDisplayMetrics().density;
    }

    @Override // p013i.A
    public final void h(z zVar) {
        throw null;
    }

    public final boolean i() {
        C0146g c0146g = this.f3223s;
        return c0146g != null && c0146g.b();
    }

    @Override // p013i.A
    public final boolean j(p pVar) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013i.A
    public final boolean k(G g) {
        boolean z2;
        if (!g.hasVisibleItems()) {
            return false;
        }
        G g2 = g;
        while (true) {
            n nVar = g2.f2863z;
            if (nVar == this.f3208c) {
                break;
            }
            g2 = (G) nVar;
        }
        ViewGroup viewGroup = (ViewGroup) this.f3212h;
        View view = null;
        view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof B) && ((B) childAt).getItemData() == g2.f2862A) {
                    view = childAt;
                    break;
                }
            }
        }
        if (view == null) {
            return false;
        }
        g.f2862A.getClass();
        int size = g.f2936f.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z2 = false;
                break;
            }
            MenuItem item = g.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i3++;
        }
        C0146g c0146g = new C0146g(this, this.f3207b, g, view);
        this.f3224t = c0146g;
        c0146g.g = z2;
        v vVar = c0146g.f3004i;
        if (vVar != null) {
            vVar.o(z2);
        }
        C0146g c0146g2 = this.f3224t;
        if (!c0146g2.b()) {
            if (c0146g2.f3001e == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c0146g2.d(0, 0, false, false);
        }
        z zVar = this.f3210e;
        if (zVar != null) {
            zVar.j(g);
        }
        return true;
    }

    public final boolean l() {
        n nVar;
        if (!this.f3216l || i() || (nVar = this.f3208c) == null || this.f3212h == null || this.f3225u != null) {
            return false;
        }
        nVar.i();
        if (nVar.f2939j.isEmpty()) {
            return false;
        }
        RunnableC0150i runnableC0150i = new RunnableC0150i(this, new C0146g(this, this.f3207b, this.f3208c, this.f3213i));
        this.f3225u = runnableC0150i;
        ((View) this.f3212h).post(runnableC0150i);
        return true;
    }
}
