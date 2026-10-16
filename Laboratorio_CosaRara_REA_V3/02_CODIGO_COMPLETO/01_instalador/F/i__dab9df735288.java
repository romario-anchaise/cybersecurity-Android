// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.InterfaceC0013m;
import A.M;
import A.X;
import F0.i;
import H.t;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.o;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.w;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import java.util.WeakHashMap;
import p011h.a;
import p011h.b;

/* JADX INFO: renamed from: f.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC0119i extends Dialog implements DialogInterface, InterfaceC0122l, InterfaceC0082u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f2497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f2498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f2499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final A f2500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0118h f2501e;

    /* JADX WARN: Type inference failed for: r2v3, types: [f.A] */
    public DialogC0119i(ContextThemeWrapper contextThemeWrapper, int i2) {
        int i3;
        int iG = g(contextThemeWrapper, i2);
        if (iG == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i3 = typedValue.resourceId;
        } else {
            i3 = iG;
        }
        super(contextThemeWrapper, i3);
        this.f2498b = new o(new t(4, this));
        this.f2500d = new InterfaceC0013m() { // from class: f.A
            @Override // A.InterfaceC0013m
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f2397a.i(keyEvent);
            }
        };
        AbstractC0125o abstractC0125oB = b();
        if (iG == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iG = typedValue2.resourceId;
        }
        ((z) abstractC0125oB).f2566T = iG;
        abstractC0125oB.d();
        this.f2501e = new C0118h(getContext(), this, getWindow());
    }

    public static void a(DialogC0119i dialogC0119i) {
        i.e(dialogC0119i, "this$0");
        super.onBackPressed();
    }

    public static int g(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        z zVar = (z) b();
        zVar.x();
        ((ViewGroup) zVar.f2548A.findViewById(android.R.id.content)).addView(view, layoutParams);
        zVar.f2583m.a(zVar.f2582l.getCallback());
    }

    public final AbstractC0125o b() {
        if (this.f2499c == null) {
            F f2 = AbstractC0125o.f2503a;
            this.f2499c = new z(getContext(), getWindow(), this, this);
        }
        return this.f2499c;
    }

    public final w c() {
        w wVar = this.f2497a;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        this.f2497a = wVar2;
        return wVar2;
    }

    public final void d(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            o oVar = this.f2498b;
            oVar.f1264e = onBackInvokedDispatcher;
            oVar.b();
        }
        c().f(EnumC0076n.ON_CREATE);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        b().e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.m(this.f2500d, getWindow().getDecorView(), this, keyEvent);
    }

    public final void e(Bundle bundle) {
        b().a();
        d(bundle);
        b().d();
    }

    public final void f() {
        c().f(EnumC0076n.ON_DESTROY);
        this.f2497a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i2) {
        z zVar = (z) b();
        zVar.x();
        return zVar.f2582l.findViewById(i2);
    }

    @Override // androidx.lifecycle.InterfaceC0082u
    public final AbstractC0078p getLifecycle() {
        return c();
    }

    public final void h(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().l(charSequence);
    }

    public final boolean i(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        b().b();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f2498b.a();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i2;
        ListAdapter listAdapter;
        View viewFindViewById;
        e(bundle);
        C0118h c0118h = this.f2501e;
        c0118h.f2476b.setContentView(c0118h.f2490q);
        Window window = c0118h.f2477c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        window.setFlags(131072, 131072);
        viewGroup.setVisibility(8);
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupA = C0118h.a(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupA2 = C0118h.a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupA3 = C0118h.a(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0118h.f2482i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0118h.f2482i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupA2.findViewById(android.R.id.message);
        c0118h.f2486m = textView;
        if (textView != null) {
            textView.setVisibility(8);
            c0118h.f2482i.removeView(c0118h.f2486m);
            if (c0118h.f2479e != null) {
                ViewGroup viewGroup2 = (ViewGroup) c0118h.f2482i.getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(c0118h.f2482i);
                viewGroup2.removeViewAt(iIndexOfChild);
                viewGroup2.addView(c0118h.f2479e, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroupA2.setVisibility(8);
            }
        }
        Button button = (Button) viewGroupA3.findViewById(android.R.id.button1);
        c0118h.f2480f = button;
        ViewOnClickListenerC0113c viewOnClickListenerC0113c = c0118h.f2496w;
        button.setOnClickListener(viewOnClickListenerC0113c);
        if (TextUtils.isEmpty(null)) {
            c0118h.f2480f.setVisibility(8);
            i2 = 0;
        } else {
            c0118h.f2480f.setText((CharSequence) null);
            c0118h.f2480f.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroupA3.findViewById(android.R.id.button2);
        c0118h.g = button2;
        button2.setOnClickListener(viewOnClickListenerC0113c);
        if (TextUtils.isEmpty(null)) {
            c0118h.g.setVisibility(8);
        } else {
            c0118h.g.setText((CharSequence) null);
            c0118h.g.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroupA3.findViewById(android.R.id.button3);
        c0118h.f2481h = button3;
        button3.setOnClickListener(viewOnClickListenerC0113c);
        if (TextUtils.isEmpty(null)) {
            c0118h.f2481h.setVisibility(8);
        } else {
            c0118h.f2481h.setText((CharSequence) null);
            c0118h.f2481h.setVisibility(0);
            i2 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        c0118h.f2475a.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i2 == 1) {
                Button button4 = c0118h.f2480f;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i2 == 2) {
                Button button5 = c0118h.g;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i2 == 4) {
                Button button6 = c0118h.f2481h;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i2 == 0) {
            viewGroupA3.setVisibility(8);
        }
        if (c0118h.f2487n != null) {
            viewGroupA.addView(c0118h.f2487n, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0118h.f2484k = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(c0118h.f2478d) || !c0118h.f2494u) {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0118h.f2484k.setVisibility(8);
                viewGroupA.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0118h.f2485l = textView2;
                textView2.setText(c0118h.f2478d);
                Drawable drawable = c0118h.f2483j;
                if (drawable != null) {
                    c0118h.f2484k.setImageDrawable(drawable);
                } else {
                    c0118h.f2485l.setPadding(c0118h.f2484k.getPaddingLeft(), c0118h.f2484k.getPaddingTop(), c0118h.f2484k.getPaddingRight(), c0118h.f2484k.getPaddingBottom());
                    c0118h.f2484k.setVisibility(8);
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i3 = (viewGroupA == null || viewGroupA.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupA3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupA2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i3 != 0) {
            NestedScrollView nestedScrollView2 = c0118h.f2482i;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = c0118h.f2479e != null ? viewGroupA.findViewById(R.id.titleDividerNoCustom) : null;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupA2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0118h.f2479e;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z3 || i3 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i3 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f1266a, alertController$RecycleListView.getPaddingRight(), z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f1267b);
            }
        }
        if (!z2) {
            View view = c0118h.f2479e;
            if (view == null) {
                view = c0118h.f2482i;
            }
            if (view != null) {
                int i4 = (z3 ? 2 : 0) | i3;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = X.f14a;
                M.d(view, i4, 3);
                if (viewFindViewById11 != null) {
                    viewGroupA2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupA2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c0118h.f2479e;
        if (alertController$RecycleListView2 == null || (listAdapter = c0118h.f2488o) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i5 = c0118h.f2489p;
        if (i5 > -1) {
            alertController$RecycleListView2.setItemChecked(i5, true);
            alertController$RecycleListView2.setSelection(i5);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2501e.f2482i;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2501e.f2482i;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        c().f(EnumC0076n.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        f();
        z zVar = (z) b();
        zVar.B();
        AbstractC0111a abstractC0111a = zVar.f2585o;
        if (abstractC0111a != null) {
            abstractC0111a.m(false);
        }
    }

    @Override // p009f.InterfaceC0122l
    public final b onWindowStartingSupportActionMode(a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public final void setContentView(int i2) {
        b().i(i2);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i2) {
        super.setTitle(i2);
        b().l(getContext().getString(i2));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        b().j(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().k(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        h(charSequence);
        C0118h c0118h = this.f2501e;
        c0118h.f2478d = charSequence;
        TextView textView = c0118h.f2485l;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // p009f.InterfaceC0122l
    public final void onSupportActionModeFinished(b bVar) {
    }

    @Override // p009f.InterfaceC0122l
    public final void onSupportActionModeStarted(b bVar) {
    }
}
