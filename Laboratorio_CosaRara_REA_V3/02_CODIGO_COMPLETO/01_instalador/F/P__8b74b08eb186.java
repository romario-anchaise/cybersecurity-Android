// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.C0005e;
import A.I;
import A.J;
import A.L;
import A.X;
import A.g0;
import A.h0;
import H.s;
import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p011h.a;
import p011h.b;
import p011h.k;
import p011h.l;
import p013i.n;
import p013i.p;
import p015j.InterfaceC0142e;
import p015j.InterfaceC0165p0;
import p015j.m1;
import p015j.r1;

/* JADX INFO: loaded from: classes.dex */
public final class P extends AbstractC0111a implements InterfaceC0142e {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final AccelerateInterpolator f2436y = new AccelerateInterpolator();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final DecelerateInterpolator f2437z = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f2440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f2441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0165p0 f2442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActionBarContextView f2443f;
    public final View g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public O f2445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public O f2446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s f2447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f2449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2450n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2451o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2452p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2453q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2454r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public l f2455s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2456t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2457u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final N f2458v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final N f2459w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0005e f2460x;

    public P(Activity activity, boolean z2) {
        new ArrayList();
        this.f2449m = new ArrayList();
        this.f2450n = 0;
        this.f2451o = true;
        this.f2454r = true;
        this.f2458v = new N(this, 0);
        this.f2459w = new N(this, 1);
        this.f2460x = new C0005e(16, this);
        View decorView = activity.getWindow().getDecorView();
        q(decorView);
        if (z2) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    @Override // p009f.AbstractC0111a
    public final boolean b() {
        m1 m1Var;
        InterfaceC0165p0 interfaceC0165p0 = this.f2442e;
        if (interfaceC0165p0 == null || (m1Var = ((r1) interfaceC0165p0).f3276a.f1429M) == null || m1Var.f3251b == null) {
            return false;
        }
        m1 m1Var2 = ((r1) interfaceC0165p0).f3276a.f1429M;
        p pVar = m1Var2 == null ? null : m1Var2.f3251b;
        if (pVar == null) {
            return true;
        }
        pVar.collapseActionView();
        return true;
    }

    @Override // p009f.AbstractC0111a
    public final void c(boolean z2) {
        if (z2 == this.f2448l) {
            return;
        }
        this.f2448l = z2;
        ArrayList arrayList = this.f2449m;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // p009f.AbstractC0111a
    public final int d() {
        return ((r1) this.f2442e).f3277b;
    }

    @Override // p009f.AbstractC0111a
    public final Context e() {
        if (this.f2439b == null) {
            TypedValue typedValue = new TypedValue();
            this.f2438a.getTheme().resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f2439b = new ContextThemeWrapper(this.f2438a, i2);
            } else {
                this.f2439b = this.f2438a;
            }
        }
        return this.f2439b;
    }

    @Override // p009f.AbstractC0111a
    public final void g() {
        r(this.f2438a.getResources().getBoolean(com.o2s2m.gae1fc3b2uc0u.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // p009f.AbstractC0111a
    public final boolean i(int i2, KeyEvent keyEvent) {
        n nVar;
        O o2 = this.f2445i;
        if (o2 == null || (nVar = o2.f2433d) == null) {
            return false;
        }
        nVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return nVar.performShortcut(i2, keyEvent, 0);
    }

    @Override // p009f.AbstractC0111a
    public final void l(boolean z2) {
        if (this.f2444h) {
            return;
        }
        int i2 = z2 ? 4 : 0;
        r1 r1Var = (r1) this.f2442e;
        int i3 = r1Var.f3277b;
        this.f2444h = true;
        r1Var.a((i2 & 4) | (i3 & (-5)));
    }

    @Override // p009f.AbstractC0111a
    public final void m(boolean z2) {
        l lVar;
        this.f2456t = z2;
        if (z2 || (lVar = this.f2455s) == null) {
            return;
        }
        lVar.a();
    }

    @Override // p009f.AbstractC0111a
    public final void n(CharSequence charSequence) {
        r1 r1Var = (r1) this.f2442e;
        if (r1Var.g) {
            return;
        }
        r1Var.f3282h = charSequence;
        if ((r1Var.f3277b & 8) != 0) {
            Toolbar toolbar = r1Var.f3276a;
            toolbar.setTitle(charSequence);
            if (r1Var.g) {
                X.i(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // p009f.AbstractC0111a
    public final b o(s sVar) {
        O o2 = this.f2445i;
        if (o2 != null) {
            o2.a();
        }
        this.f2440c.setHideOnContentScrollEnabled(false);
        this.f2443f.e();
        O o3 = new O(this, this.f2443f.getContext(), sVar);
        n nVar = o3.f2433d;
        nVar.w();
        try {
            boolean zF = ((a) o3.f2434e.f232b).f(o3, nVar);
            nVar.v();
            if (!zF) {
                return null;
            }
            this.f2445i = o3;
            o3.h();
            this.f2443f.c(o3);
            p(true);
            return o3;
        } catch (Throwable th) {
            nVar.v();
            throw th;
        }
    }

    public final void p(boolean z2) {
        h0 h0VarI;
        h0 h0VarI2;
        if (z2) {
            if (!this.f2453q) {
                this.f2453q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2440c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                s(false);
            }
        } else if (this.f2453q) {
            this.f2453q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2440c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            s(false);
        }
        ActionBarContainer actionBarContainer = this.f2441d;
        WeakHashMap weakHashMap = X.f14a;
        if (!I.c(actionBarContainer)) {
            if (z2) {
                ((r1) this.f2442e).f3276a.setVisibility(4);
                this.f2443f.setVisibility(0);
                return;
            } else {
                ((r1) this.f2442e).f3276a.setVisibility(0);
                this.f2443f.setVisibility(8);
                return;
            }
        }
        if (z2) {
            r1 r1Var = (r1) this.f2442e;
            h0VarI = X.a(r1Var.f3276a);
            h0VarI.a(0.0f);
            h0VarI.c(100L);
            h0VarI.d(new k(r1Var, 4));
            h0VarI2 = this.f2443f.i(0, 200L);
        } else {
            r1 r1Var2 = (r1) this.f2442e;
            h0 h0VarA = X.a(r1Var2.f3276a);
            h0VarA.a(1.0f);
            h0VarA.c(200L);
            h0VarA.d(new k(r1Var2, 0));
            h0VarI = this.f2443f.i(8, 100L);
            h0VarI2 = h0VarA;
        }
        l lVar = new l();
        ArrayList arrayList = lVar.f2834a;
        arrayList.add(h0VarI);
        View view = (View) h0VarI.f44a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) h0VarI2.f44a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(h0VarI2);
        lVar.b();
    }

    public final void q(View view) {
        InterfaceC0165p0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.decor_content_parent);
        this.f2440c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.action_bar);
        if (callbackFindViewById instanceof InterfaceC0165p0) {
            wrapper = (InterfaceC0165p0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f2442e = wrapper;
        this.f2443f = (ActionBarContextView) view.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.action_bar_container);
        this.f2441d = actionBarContainer;
        InterfaceC0165p0 interfaceC0165p0 = this.f2442e;
        if (interfaceC0165p0 == null || this.f2443f == null || actionBarContainer == null) {
            throw new IllegalStateException(P.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((r1) interfaceC0165p0).f3276a.getContext();
        this.f2438a = context;
        if ((((r1) this.f2442e).f3277b & 4) != 0) {
            this.f2444h = true;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        this.f2442e.getClass();
        r(context.getResources().getBoolean(com.o2s2m.gae1fc3b2uc0u.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f2438a.obtainStyledAttributes(null, p007e.a.f2226a, com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2440c;
            if (!actionBarOverlayLayout2.f1332h) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f2457u = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f2441d;
            WeakHashMap weakHashMap = X.f14a;
            L.s(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void r(boolean z2) {
        if (z2) {
            this.f2441d.setTabContainer(null);
            ((r1) this.f2442e).getClass();
        } else {
            ((r1) this.f2442e).getClass();
            this.f2441d.setTabContainer(null);
        }
        this.f2442e.getClass();
        ((r1) this.f2442e).f3276a.setCollapsible(false);
        this.f2440c.setHasNonEmbeddedTabs(false);
    }

    public final void s(boolean z2) {
        boolean z3 = this.f2453q || !this.f2452p;
        View view = this.g;
        final C0005e c0005e = this.f2460x;
        if (!z3) {
            if (this.f2454r) {
                this.f2454r = false;
                l lVar = this.f2455s;
                if (lVar != null) {
                    lVar.a();
                }
                int i2 = this.f2450n;
                N n2 = this.f2458v;
                if (i2 != 0 || (!this.f2456t && !z2)) {
                    n2.a();
                    return;
                }
                this.f2441d.setAlpha(1.0f);
                this.f2441d.setTransitioning(true);
                l lVar2 = new l();
                float f2 = -this.f2441d.getHeight();
                if (z2) {
                    int[] iArr = {0, 0};
                    this.f2441d.getLocationInWindow(iArr);
                    f2 -= iArr[1];
                }
                h0 h0VarA = X.a(this.f2441d);
                h0VarA.e(f2);
                final View view2 = (View) h0VarA.f44a.get();
                if (view2 != null) {
                    g0.a(view2.animate(), c0005e != null ? new ValueAnimator.AnimatorUpdateListener(view2) { // from class: A.e0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) ((p009f.P) this.f35a.f34b).f2441d.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z4 = lVar2.f2838e;
                ArrayList arrayList = lVar2.f2834a;
                if (!z4) {
                    arrayList.add(h0VarA);
                }
                if (this.f2451o && view != null) {
                    h0 h0VarA2 = X.a(view);
                    h0VarA2.e(f2);
                    if (!lVar2.f2838e) {
                        arrayList.add(h0VarA2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f2436y;
                boolean z5 = lVar2.f2838e;
                if (!z5) {
                    lVar2.f2836c = accelerateInterpolator;
                }
                if (!z5) {
                    lVar2.f2835b = 250L;
                }
                if (!z5) {
                    lVar2.f2837d = n2;
                }
                this.f2455s = lVar2;
                lVar2.b();
                return;
            }
            return;
        }
        if (this.f2454r) {
            return;
        }
        this.f2454r = true;
        l lVar3 = this.f2455s;
        if (lVar3 != null) {
            lVar3.a();
        }
        this.f2441d.setVisibility(0);
        int i3 = this.f2450n;
        N n3 = this.f2459w;
        if (i3 == 0 && (this.f2456t || z2)) {
            this.f2441d.setTranslationY(0.0f);
            float f3 = -this.f2441d.getHeight();
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f2441d.getLocationInWindow(iArr2);
                f3 -= iArr2[1];
            }
            this.f2441d.setTranslationY(f3);
            l lVar4 = new l();
            h0 h0VarA3 = X.a(this.f2441d);
            h0VarA3.e(0.0f);
            final View view3 = (View) h0VarA3.f44a.get();
            if (view3 != null) {
                g0.a(view3.animate(), c0005e != null ? new ValueAnimator.AnimatorUpdateListener(view3) { // from class: A.e0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) ((p009f.P) this.f35a.f34b).f2441d.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z6 = lVar4.f2838e;
            ArrayList arrayList2 = lVar4.f2834a;
            if (!z6) {
                arrayList2.add(h0VarA3);
            }
            if (this.f2451o && view != null) {
                view.setTranslationY(f3);
                h0 h0VarA4 = X.a(view);
                h0VarA4.e(0.0f);
                if (!lVar4.f2838e) {
                    arrayList2.add(h0VarA4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f2437z;
            boolean z7 = lVar4.f2838e;
            if (!z7) {
                lVar4.f2836c = decelerateInterpolator;
            }
            if (!z7) {
                lVar4.f2835b = 250L;
            }
            if (!z7) {
                lVar4.f2837d = n3;
            }
            this.f2455s = lVar4;
            lVar4.b();
        } else {
            this.f2441d.setAlpha(1.0f);
            this.f2441d.setTranslationY(0.0f);
            if (this.f2451o && view != null) {
                view.setTranslationY(0.0f);
            }
            n3.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2440c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = X.f14a;
            J.c(actionBarOverlayLayout);
        }
    }

    public P(Dialog dialog) {
        new ArrayList();
        this.f2449m = new ArrayList();
        this.f2450n = 0;
        this.f2451o = true;
        this.f2454r = true;
        this.f2458v = new N(this, 0);
        this.f2459w = new N(this, 1);
        this.f2460x = new C0005e(16, this);
        q(dialog.getWindow().getDecorView());
    }
}
