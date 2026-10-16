// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.H;
import A.X;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;
import p015j.C0178w0;
import p015j.O0;

/* JADX INFO: loaded from: classes.dex */
public final class F extends v implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f2846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2848f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final O0 f2849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0130d f2850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0131e f2851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w f2852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f2853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f2854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public z f2855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewTreeObserver f2856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2860s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2861t;

    public F(int i2, Context context, View view, n nVar, boolean z2) {
        int i3 = 1;
        this.f2850i = new ViewTreeObserverOnGlobalLayoutListenerC0130d(i3, this);
        this.f2851j = new ViewOnAttachStateChangeListenerC0131e(this, i3);
        this.f2844b = context;
        this.f2845c = nVar;
        this.f2847e = z2;
        this.f2846d = new k(nVar, LayoutInflater.from(context), z2, R.layout.abc_popup_menu_item_layout);
        this.g = i2;
        Resources resources = context.getResources();
        this.f2848f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2853l = view;
        this.f2849h = new O0(context, null, i2);
        nVar.b(this, context);
    }

    @Override // p013i.A
    public final void a(n nVar, boolean z2) {
        if (nVar != this.f2845c) {
            return;
        }
        dismiss();
        z zVar = this.f2855n;
        if (zVar != null) {
            zVar.a(nVar, z2);
        }
    }

    @Override // p013i.E
    public final boolean b() {
        return !this.f2857p && this.f2849h.f3078y.isShowing();
    }

    @Override // p013i.A
    public final void c() {
        this.f2858q = false;
        k kVar = this.f2846d;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // p013i.E
    public final void dismiss() {
        if (b()) {
            this.f2849h.dismiss();
        }
    }

    @Override // p013i.E
    public final C0178w0 e() {
        return this.f2849h.f3057c;
    }

    @Override // p013i.A
    public final boolean f() {
        return false;
    }

    @Override // p013i.A
    public final void h(z zVar) {
        this.f2855n = zVar;
    }

    @Override // p013i.E
    public final void i() {
        View view;
        if (b()) {
            return;
        }
        if (this.f2857p || (view = this.f2853l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f2854m = view;
        O0 o2 = this.f2849h;
        o2.f3078y.setOnDismissListener(this);
        o2.f3069p = this;
        o2.f3077x = true;
        o2.f3078y.setFocusable(true);
        View view2 = this.f2854m;
        boolean z2 = this.f2856o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f2856o = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f2850i);
        }
        view2.addOnAttachStateChangeListener(this.f2851j);
        o2.f3068o = view2;
        o2.f3065l = this.f2860s;
        boolean z3 = this.f2858q;
        Context context = this.f2844b;
        k kVar = this.f2846d;
        if (!z3) {
            this.f2859r = v.m(kVar, context, this.f2848f);
            this.f2858q = true;
        }
        o2.r(this.f2859r);
        o2.f3078y.setInputMethodMode(2);
        Rect rect = this.f2995a;
        o2.f3076w = rect != null ? new Rect(rect) : null;
        o2.i();
        C0178w0 c0178w0 = o2.f3057c;
        c0178w0.setOnKeyListener(this);
        if (this.f2861t) {
            n nVar = this.f2845c;
            if (nVar.f2942m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0178w0, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(nVar.f2942m);
                }
                frameLayout.setEnabled(false);
                c0178w0.addHeaderView(frameLayout, null, false);
            }
        }
        o2.o(kVar);
        o2.i();
    }

    @Override // p013i.A
    public final boolean k(G g) {
        if (g.hasVisibleItems()) {
            View view = this.f2854m;
            y yVar = new y(this.g, this.f2844b, view, g, this.f2847e);
            z zVar = this.f2855n;
            yVar.f3003h = zVar;
            v vVar = yVar.f3004i;
            if (vVar != null) {
                vVar.h(zVar);
            }
            boolean zU = v.u(g);
            yVar.g = zU;
            v vVar2 = yVar.f3004i;
            if (vVar2 != null) {
                vVar2.o(zU);
            }
            yVar.f3005j = this.f2852k;
            this.f2852k = null;
            this.f2845c.c(false);
            O0 o2 = this.f2849h;
            int width = o2.f3060f;
            int iJ = o2.j();
            int i2 = this.f2860s;
            View view2 = this.f2853l;
            WeakHashMap weakHashMap = X.f14a;
            if ((Gravity.getAbsoluteGravity(i2, H.d(view2)) & 7) == 5) {
                width += this.f2853l.getWidth();
            }
            if (!yVar.b()) {
                if (yVar.f3001e != null) {
                    yVar.d(width, iJ, true, true);
                }
            }
            z zVar2 = this.f2855n;
            if (zVar2 != null) {
                zVar2.j(g);
            }
            return true;
        }
        return false;
    }

    @Override // p013i.v
    public final void n(View view) {
        this.f2853l = view;
    }

    @Override // p013i.v
    public final void o(boolean z2) {
        this.f2846d.f2926c = z2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2857p = true;
        this.f2845c.c(true);
        ViewTreeObserver viewTreeObserver = this.f2856o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2856o = this.f2854m.getViewTreeObserver();
            }
            this.f2856o.removeGlobalOnLayoutListener(this.f2850i);
            this.f2856o = null;
        }
        this.f2854m.removeOnAttachStateChangeListener(this.f2851j);
        w wVar = this.f2852k;
        if (wVar != null) {
            wVar.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // p013i.v
    public final void p(int i2) {
        this.f2860s = i2;
    }

    @Override // p013i.v
    public final void q(int i2) {
        this.f2849h.f3060f = i2;
    }

    @Override // p013i.v
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f2852k = (w) onDismissListener;
    }

    @Override // p013i.v
    public final void s(boolean z2) {
        this.f2861t = z2;
    }

    @Override // p013i.v
    public final void t(int i2) {
        this.f2849h.l(i2);
    }

    @Override // p013i.v
    public final void l(n nVar) {
    }
}
