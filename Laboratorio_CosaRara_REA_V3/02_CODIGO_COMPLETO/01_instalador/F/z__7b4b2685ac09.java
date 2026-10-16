// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.G;
import A.I;
import A.InterfaceC0013m;
import A.J;
import A.L;
import A.X;
import A.h0;
import D.p;
import H.s;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.lifecycle.EnumC0077o;
import androidx.lifecycle.InterfaceC0082u;
import f1.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import p011h.a;
import p011h.b;
import p011h.e;
import p011h.j;
import p013i.l;
import p013i.n;
import p015j.C0146g;
import p015j.C0154k;
import p015j.C0171t;
import p015j.InterfaceC0163o0;
import p015j.r1;
import p015j.y1;
import p021m.i;
import p039w.f;
import p039w.g;
import p039w.h;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractC0125o implements l, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final i f2544h0 = new i(0);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int[] f2545i0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final boolean f2546j0 = !"robolectric".equals(Build.FINGERPRINT);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f2547k0 = true;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ViewGroup f2548A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public TextView f2549B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public View f2550C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f2551D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f2552E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f2553F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f2554G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f2555H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f2556I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f2557J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f2558K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public y[] f2559L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public y f2560M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f2561N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f2562O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f2563P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f2564Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public Configuration f2565R;
    public final int S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f2566T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public int f2567U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f2568V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public v f2569W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public v f2570X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public boolean f2571Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f2572Z;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2574b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Rect f2575c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Rect f2576d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public C f2577e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public OnBackInvokedDispatcher f2578f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public OnBackInvokedCallback f2579g0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f2580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f2581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Window f2582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u f2583m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f2584n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AbstractC0111a f2585o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j f2586p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f2587q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public InterfaceC0163o0 f2588r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q f2589s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q f2590t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f2591u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ActionBarContextView f2592v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PopupWindow f2593w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RunnableC0126p f2594x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2596z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h0 f2595y = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final RunnableC0126p f2573a0 = new RunnableC0126p(this, 0);

    public z(Context context, Window window, InterfaceC0122l interfaceC0122l, Object obj) {
        AbstractActivityC0121k abstractActivityC0121k = null;
        this.S = -100;
        this.f2581k = context;
        this.f2584n = interfaceC0122l;
        this.f2580j = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AbstractActivityC0121k)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    abstractActivityC0121k = (AbstractActivityC0121k) context;
                    break;
                }
            }
            if (abstractActivityC0121k != null) {
                this.S = ((z) abstractActivityC0121k.getDelegate()).S;
            }
        }
        if (this.S == -100) {
            i iVar = f2544h0;
            Integer num = (Integer) iVar.get(this.f2580j.getClass().getName());
            if (num != null) {
                this.S = num.intValue();
                iVar.remove(this.f2580j.getClass().getName());
            }
        }
        if (window != null) {
            p(window);
        }
        C0171t.c();
    }

    public static g q(Context context) {
        g gVar;
        g gVar2;
        if (Build.VERSION.SDK_INT >= 33 || (gVar = AbstractC0125o.f2505c) == null) {
            return null;
        }
        g gVarB = s.b(context.getApplicationContext().getResources().getConfiguration());
        h hVar = gVar.f4155a;
        if (hVar.f4156a.isEmpty()) {
            gVar2 = g.f4154b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            while (i2 < gVarB.f4155a.f4156a.size() + hVar.f4156a.size()) {
                Locale locale = i2 < hVar.f4156a.size() ? hVar.f4156a.get(i2) : gVarB.f4155a.f4156a.get(i2 - hVar.f4156a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            gVar2 = new g(new h(f.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return gVar2.f4155a.f4156a.isEmpty() ? gVarB : gVar2;
    }

    public static Configuration u(Context context, int i2, g gVar, Configuration configuration, boolean z2) {
        int i3;
        if (i2 == 1) {
            i3 = 16;
        } else if (i2 != 2) {
            i3 = z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i3 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            s.d(configuration2, gVar);
        }
        return configuration2;
    }

    public final y A(int i2) {
        y[] yVarArr = this.f2559L;
        if (yVarArr == null || yVarArr.length <= i2) {
            y[] yVarArr2 = new y[i2 + 1];
            if (yVarArr != null) {
                System.arraycopy(yVarArr, 0, yVarArr2, 0, yVarArr.length);
            }
            this.f2559L = yVarArr2;
            yVarArr = yVarArr2;
        }
        y yVar = yVarArr[i2];
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y();
        yVar2.f2529a = i2;
        yVar2.f2541n = false;
        yVarArr[i2] = yVar2;
        return yVar2;
    }

    public final void B() {
        x();
        if (this.f2553F && this.f2585o == null) {
            Object obj = this.f2580j;
            if (obj instanceof Activity) {
                this.f2585o = new P((Activity) obj, this.f2554G);
            } else if (obj instanceof Dialog) {
                this.f2585o = new P((Dialog) obj);
            }
            AbstractC0111a abstractC0111a = this.f2585o;
            if (abstractC0111a != null) {
                abstractC0111a.l(this.f2574b0);
            }
        }
    }

    public final void C(int i2) {
        this.f2572Z = (1 << i2) | this.f2572Z;
        if (this.f2571Y) {
            return;
        }
        View decorView = this.f2582l.getDecorView();
        RunnableC0126p runnableC0126p = this.f2573a0;
        WeakHashMap weakHashMap = X.f14a;
        G.m(decorView, runnableC0126p);
        this.f2571Y = true;
    }

    public final int D(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return z(context).e();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f2570X == null) {
                    this.f2570X = new v(this, context);
                }
                return this.f2570X.e();
            }
        }
        return i2;
    }

    public final boolean E() {
        boolean z2 = this.f2561N;
        this.f2561N = false;
        y yVarA = A(0);
        if (yVarA.f2540m) {
            if (!z2) {
                t(yVarA, true);
            }
            return true;
        }
        b bVar = this.f2591u;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        B();
        AbstractC0111a abstractC0111a = this.f2585o;
        return abstractC0111a != null && abstractC0111a.b();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0173, code lost:
    
        if (r3.f2923f.getCount() > 0) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F(p009f.y r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p009f.z.F(f.y, android.view.KeyEvent):void");
    }

    public final boolean G(y yVar, int i2, KeyEvent keyEvent) {
        n nVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((yVar.f2538k || H(yVar, keyEvent)) && (nVar = yVar.f2535h) != null) {
            return nVar.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    public final boolean H(y yVar, KeyEvent keyEvent) {
        InterfaceC0163o0 interfaceC0163o0;
        InterfaceC0163o0 interfaceC0163o1;
        Resources.Theme themeNewTheme;
        InterfaceC0163o0 interfaceC0163o2;
        InterfaceC0163o0 interfaceC0163o3;
        if (this.f2564Q) {
            return false;
        }
        if (yVar.f2538k) {
            return true;
        }
        y yVar2 = this.f2560M;
        if (yVar2 != null && yVar2 != yVar) {
            t(yVar2, false);
        }
        Window.Callback callback = this.f2582l.getCallback();
        int i2 = yVar.f2529a;
        if (callback != null) {
            yVar.g = callback.onCreatePanelView(i2);
        }
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (interfaceC0163o3 = this.f2588r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0163o3;
            actionBarOverlayLayout.k();
            ((r1) actionBarOverlayLayout.f1330e).f3286l = true;
        }
        if (yVar.g == null && (!z2 || !(this.f2585o instanceof K))) {
            n nVar = yVar.f2535h;
            if (nVar == null || yVar.f2542o) {
                if (nVar == null) {
                    Context context = this.f2581k;
                    if ((i2 == 0 || i2 == 108) && this.f2588r != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            e eVar = new e(context, 0);
                            eVar.getTheme().setTo(themeNewTheme);
                            context = eVar;
                        }
                    }
                    n nVar2 = new n(context);
                    nVar2.f2935e = this;
                    n nVar3 = yVar.f2535h;
                    if (nVar2 != nVar3) {
                        if (nVar3 != null) {
                            nVar3.r(yVar.f2536i);
                        }
                        yVar.f2535h = nVar2;
                        p013i.j jVar = yVar.f2536i;
                        if (jVar != null) {
                            nVar2.b(jVar, nVar2.f2931a);
                        }
                    }
                    if (yVar.f2535h == null) {
                        return false;
                    }
                }
                if (z2 && (interfaceC0163o1 = this.f2588r) != null) {
                    if (this.f2589s == null) {
                        this.f2589s = new q(this, 2);
                    }
                    ((ActionBarOverlayLayout) interfaceC0163o1).l(yVar.f2535h, this.f2589s);
                }
                yVar.f2535h.w();
                if (!callback.onCreatePanelMenu(i2, yVar.f2535h)) {
                    n nVar4 = yVar.f2535h;
                    if (nVar4 != null) {
                        if (nVar4 != null) {
                            nVar4.r(yVar.f2536i);
                        }
                        yVar.f2535h = null;
                    }
                    if (z2 && (interfaceC0163o0 = this.f2588r) != null) {
                        ((ActionBarOverlayLayout) interfaceC0163o0).l(null, this.f2589s);
                    }
                    return false;
                }
                yVar.f2542o = false;
            }
            yVar.f2535h.w();
            Bundle bundle = yVar.f2543p;
            if (bundle != null) {
                yVar.f2535h.s(bundle);
                yVar.f2543p = null;
            }
            if (!callback.onPreparePanel(0, yVar.g, yVar.f2535h)) {
                if (z2 && (interfaceC0163o2 = this.f2588r) != null) {
                    ((ActionBarOverlayLayout) interfaceC0163o2).l(null, this.f2589s);
                }
                yVar.f2535h.v();
                return false;
            }
            yVar.f2535h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            yVar.f2535h.v();
        }
        yVar.f2538k = true;
        yVar.f2539l = false;
        this.f2560M = yVar;
        return true;
    }

    public final void I() {
        if (this.f2596z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void J() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z2 = false;
            if (this.f2578f0 != null && (A(0).f2540m || this.f2591u != null)) {
                z2 = true;
            }
            if (z2 && this.f2579g0 == null) {
                this.f2579g0 = t.b(this.f2578f0, this);
            } else {
                if (z2 || (onBackInvokedCallback = this.f2579g0) == null) {
                    return;
                }
                t.c(this.f2578f0, onBackInvokedCallback);
            }
        }
    }

    @Override // p009f.AbstractC0125o
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f2581k);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof z) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // p009f.AbstractC0125o
    public final void b() {
        if (this.f2585o != null) {
            B();
            if (this.f2585o.f()) {
                return;
            }
            C(0);
        }
    }

    @Override // p009f.AbstractC0125o
    public final void d() throws IllegalAccessException {
        String strJ;
        this.f2562O = true;
        o(false, true);
        y();
        Object obj = this.f2580j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strJ = p029q.j.j(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
                strJ = null;
            }
            if (strJ != null) {
                AbstractC0111a abstractC0111a = this.f2585o;
                if (abstractC0111a == null) {
                    this.f2574b0 = true;
                } else {
                    abstractC0111a.l(true);
                }
            }
            synchronized (AbstractC0125o.f2509h) {
                AbstractC0125o.g(this);
                AbstractC0125o.g.add(new WeakReference(this));
            }
        }
        this.f2565R = new Configuration(this.f2581k.getResources().getConfiguration());
        this.f2563P = true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // p009f.AbstractC0125o
    public final void e() {
        if (this.f2580j instanceof Activity) {
            synchronized (AbstractC0125o.f2509h) {
                AbstractC0125o.g(this);
            }
        }
        if (this.f2571Y) {
            this.f2582l.getDecorView().removeCallbacks(this.f2573a0);
        }
        this.f2564Q = true;
        if (this.S != -100) {
            Object obj = this.f2580j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f2544h0.put(this.f2580j.getClass().getName(), Integer.valueOf(this.S));
            } else {
                f2544h0.remove(this.f2580j.getClass().getName());
            }
        } else {
            f2544h0.remove(this.f2580j.getClass().getName());
        }
        AbstractC0111a abstractC0111a = this.f2585o;
        if (abstractC0111a != null) {
            abstractC0111a.h();
        }
        v vVar = this.f2569W;
        if (vVar != null) {
            vVar.c();
        }
        v vVar2 = this.f2570X;
        if (vVar2 != null) {
            vVar2.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.i() != false) goto L20;
     */
    @Override // p013i.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(p013i.n r6) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p009f.z.f(i.n):void");
    }

    @Override // p009f.AbstractC0125o
    public final boolean h(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.f2557J && i2 == 108) {
            return false;
        }
        if (this.f2553F && i2 == 1) {
            this.f2553F = false;
        }
        if (i2 == 1) {
            I();
            this.f2557J = true;
            return true;
        }
        if (i2 == 2) {
            I();
            this.f2551D = true;
            return true;
        }
        if (i2 == 5) {
            I();
            this.f2552E = true;
            return true;
        }
        if (i2 == 10) {
            I();
            this.f2555H = true;
            return true;
        }
        if (i2 == 108) {
            I();
            this.f2553F = true;
            return true;
        }
        if (i2 != 109) {
            return this.f2582l.requestFeature(i2);
        }
        I();
        this.f2554G = true;
        return true;
    }

    @Override // p009f.AbstractC0125o
    public final void i(int i2) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f2548A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f2581k).inflate(i2, viewGroup);
        this.f2583m.a(this.f2582l.getCallback());
    }

    @Override // p009f.AbstractC0125o
    public final void j(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f2548A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f2583m.a(this.f2582l.getCallback());
    }

    @Override // p009f.AbstractC0125o
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.f2548A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f2583m.a(this.f2582l.getCallback());
    }

    @Override // p009f.AbstractC0125o
    public final void l(CharSequence charSequence) {
        this.f2587q = charSequence;
        InterfaceC0163o0 interfaceC0163o0 = this.f2588r;
        if (interfaceC0163o0 != null) {
            interfaceC0163o0.setWindowTitle(charSequence);
            return;
        }
        AbstractC0111a abstractC0111a = this.f2585o;
        if (abstractC0111a != null) {
            abstractC0111a.n(charSequence);
            return;
        }
        TextView textView = this.f2549B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002a  */
    @Override // p013i.l
    public final boolean m(n nVar, MenuItem menuItem) {
        y yVar;
        Window.Callback callback = this.f2582l.getCallback();
        if (callback != null && !this.f2564Q) {
            n nVarK = nVar.k();
            y[] yVarArr = this.f2559L;
            int length = yVarArr != null ? yVarArr.length : 0;
            for (int i2 = 0; i2 < length; i2++) {
                yVar = yVarArr[i2];
                if (yVar != null && yVar.f2535h == nVarK) {
                    if (yVar != null) {
                        return callback.onMenuItemSelected(yVar.f2529a, menuItem);
                    }
                }
            }
            yVar = null;
            if (yVar != null) {
                return callback.onMenuItemSelected(yVar.f2529a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0155  */
    /* JADX WARN: Type inference failed for: r3v1, types: [f.l, java.lang.Object] */
    @Override // p009f.AbstractC0125o
    public final b n(a aVar) {
        b bVarOnWindowStartingSupportActionMode;
        boolean z2;
        ViewGroup viewGroup;
        int i2 = 1;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        b bVar = this.f2591u;
        if (bVar != null) {
            bVar.a();
        }
        s sVar = new s(this, aVar, 11, false);
        B();
        AbstractC0111a abstractC0111a = this.f2585o;
        ?? r3 = this.f2584n;
        if (abstractC0111a != null) {
            b bVarO = abstractC0111a.o(sVar);
            this.f2591u = bVarO;
            if (bVarO != null) {
                r3.onSupportActionModeStarted(bVarO);
            }
        }
        if (this.f2591u == null) {
            h0 h0Var = this.f2595y;
            if (h0Var != null) {
                h0Var.b();
            }
            b bVar2 = this.f2591u;
            if (bVar2 != null) {
                bVar2.a();
            }
            if (this.f2564Q) {
                bVarOnWindowStartingSupportActionMode = null;
            } else {
                try {
                    bVarOnWindowStartingSupportActionMode = r3.onWindowStartingSupportActionMode(sVar);
                } catch (AbstractMethodError unused) {
                    bVarOnWindowStartingSupportActionMode = null;
                }
            }
            if (bVarOnWindowStartingSupportActionMode != null) {
                this.f2591u = bVarOnWindowStartingSupportActionMode;
            } else {
                if (this.f2592v == null) {
                    boolean z3 = this.f2556I;
                    Context context = this.f2581k;
                    if (z3) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            e eVar = new e(context, 0);
                            eVar.getTheme().setTo(themeNewTheme);
                            context = eVar;
                        }
                        this.f2592v = new ActionBarContextView(context, null);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, com.o2s2m.gae1fc3b2uc0u.R.attr.actionModePopupWindowStyle);
                        this.f2593w = popupWindow;
                        p.d(popupWindow, 2);
                        this.f2593w.setContentView(this.f2592v);
                        this.f2593w.setWidth(-1);
                        context.getTheme().resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarSize, typedValue, true);
                        this.f2592v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.f2593w.setHeight(-2);
                        this.f2594x = new RunnableC0126p(this, i2);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.f2548A.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            B();
                            AbstractC0111a abstractC0111a2 = this.f2585o;
                            Context contextE = abstractC0111a2 != null ? abstractC0111a2.e() : null;
                            if (contextE != null) {
                                context = contextE;
                            }
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                            this.f2592v = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.f2592v != null) {
                    h0 h0Var2 = this.f2595y;
                    if (h0Var2 != null) {
                        h0Var2.b();
                    }
                    this.f2592v.e();
                    Context context2 = this.f2592v.getContext();
                    ActionBarContextView actionBarContextView = this.f2592v;
                    p011h.f fVar = new p011h.f();
                    fVar.f2784c = context2;
                    fVar.f2785d = actionBarContextView;
                    fVar.f2786e = sVar;
                    n nVar = new n(actionBarContextView.getContext());
                    nVar.f2941l = 1;
                    fVar.f2788h = nVar;
                    nVar.f2935e = fVar;
                    if (((a) sVar.f232b).f(fVar, nVar)) {
                        fVar.h();
                        this.f2592v.c(fVar);
                        this.f2591u = fVar;
                        if (!this.f2596z || (viewGroup = this.f2548A) == null) {
                            z2 = false;
                        } else {
                            WeakHashMap weakHashMap = X.f14a;
                            if (I.c(viewGroup)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        if (z2) {
                            this.f2592v.setAlpha(0.0f);
                            h0 h0VarA = X.a(this.f2592v);
                            h0VarA.a(1.0f);
                            this.f2595y = h0VarA;
                            h0VarA.d(new r(i2, this));
                        } else {
                            this.f2592v.setAlpha(1.0f);
                            this.f2592v.setVisibility(0);
                            if (this.f2592v.getParent() instanceof View) {
                                View view = (View) this.f2592v.getParent();
                                WeakHashMap weakHashMap2 = X.f14a;
                                J.c(view);
                            }
                        }
                        if (this.f2593w != null) {
                            this.f2582l.getDecorView().post(this.f2594x);
                        }
                    } else {
                        this.f2591u = null;
                    }
                }
            }
            b bVar3 = this.f2591u;
            if (bVar3 != null) {
                r3.onSupportActionModeStarted(bVar3);
            }
            J();
            this.f2591u = this.f2591u;
        }
        J();
        return this.f2591u;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00e4  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean o(boolean z2, boolean z3) throws IllegalAccessException {
        int i2;
        boolean z4;
        Object obj;
        Object obj2;
        boolean z5 = true;
        z5 = true;
        z5 = true;
        z5 = true;
        z5 = true;
        z5 = true;
        z5 = true;
        if (this.f2564Q) {
            return false;
        }
        int i3 = this.S;
        if (i3 == -100) {
            i3 = AbstractC0125o.f2504b;
        }
        int i4 = i3;
        Context context = this.f2581k;
        int iD = D(context, i4);
        int i5 = Build.VERSION.SDK_INT;
        LongSparseArray longSparseArray = null;
        g gVarQ = i5 < 33 ? q(context) : null;
        if (!z3 && gVarQ != null) {
            gVarQ = s.b(context.getResources().getConfiguration());
        }
        Configuration configurationU = u(context, iD, gVarQ, null, false);
        boolean z6 = this.f2568V;
        Object obj3 = this.f2580j;
        if (z6 || !(obj3 instanceof Activity)) {
            this.f2568V = true;
            i2 = this.f2567U;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i2 = 0;
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj3.getClass()), i5 >= 29 ? 269221888 : 786432);
                    if (activityInfo != null) {
                        this.f2567U = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    this.f2567U = 0;
                }
                this.f2568V = true;
                i2 = this.f2567U;
            }
        }
        Configuration configuration = this.f2565R;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i6 = configuration.uiMode & 48;
        int i7 = configurationU.uiMode & 48;
        g gVarB = s.b(configuration);
        g gVarB2 = gVarQ == null ? null : s.b(configurationU);
        int i8 = i6 != i7 ? 512 : 0;
        if (gVarB2 != null && !gVarB.equals(gVarB2)) {
            i8 |= 8196;
        }
        if (((~i2) & i8) != 0 && z2 && this.f2562O && ((f2546j0 || this.f2563P) && (obj3 instanceof Activity))) {
            Activity activity = (Activity) obj3;
            if (activity.isChild()) {
                z4 = false;
            } else {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new W0.f(activity, z5 ? 1 : 0));
                }
                z4 = true;
            }
        } else {
            z4 = false;
        }
        if (z4 || i8 == 0) {
            z5 = z4;
        } else {
            boolean z7 = (i2 & i8) == i8;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i7;
            if (gVarB2 != null) {
                s.d(configuration2, gVarB2);
            }
            resources.updateConfiguration(configuration2, null);
            int i9 = Build.VERSION.SDK_INT;
            if (i9 < 26 && i9 < 28) {
                if (!d.f2718l) {
                    try {
                        Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                        d.f2717k = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e3);
                    }
                    d.f2718l = true;
                }
                Field field = d.f2717k;
                if (field != null) {
                    try {
                        obj = field.get(resources);
                    } catch (IllegalAccessException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e4);
                        obj = null;
                    }
                    if (obj != null) {
                        if (!d.f2713f) {
                            try {
                                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                d.f2712e = declaredField2;
                                declaredField2.setAccessible(true);
                            } catch (NoSuchFieldException e5) {
                                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e5);
                            }
                            d.f2713f = true;
                        }
                        Field field2 = d.f2712e;
                        if (field2 != null) {
                            try {
                                obj2 = field2.get(obj);
                            } catch (IllegalAccessException e6) {
                                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e6);
                                obj2 = null;
                            }
                        } else {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            if (!d.f2714h) {
                                try {
                                    d.g = Class.forName("android.content.res.ThemedResourceCache");
                                } catch (ClassNotFoundException e7) {
                                    Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e7);
                                }
                                d.f2714h = true;
                            }
                            Class cls = d.g;
                            if (cls != null) {
                                if (!d.f2716j) {
                                    try {
                                        Field declaredField3 = cls.getDeclaredField("mUnthemedEntries");
                                        d.f2715i = declaredField3;
                                        declaredField3.setAccessible(true);
                                    } catch (NoSuchFieldException e8) {
                                        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e8);
                                    }
                                    d.f2716j = true;
                                }
                                Field field3 = d.f2715i;
                                if (field3 != null) {
                                    try {
                                        longSparseArray = (LongSparseArray) field3.get(obj2);
                                    } catch (IllegalAccessException e9) {
                                        Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e9);
                                    }
                                    if (longSparseArray != null) {
                                        H.a(longSparseArray);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int i10 = this.f2566T;
            if (i10 != 0) {
                context.setTheme(i10);
                context.getTheme().applyStyle(this.f2566T, true);
            }
            if (z7 && (obj3 instanceof Activity)) {
                Activity activity2 = (Activity) obj3;
                if (activity2 instanceof InterfaceC0082u) {
                    if (((InterfaceC0082u) activity2).getLifecycle().b().compareTo(EnumC0077o.f1683c) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.f2563P && !this.f2564Q) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
        }
        if (z5 && (obj3 instanceof AbstractActivityC0121k)) {
            if ((i8 & 512) != 0) {
                ((AbstractActivityC0121k) obj3).onNightModeChanged(iD);
            }
            if ((i8 & 4) != 0) {
                ((AbstractActivityC0121k) obj3).onLocalesChanged(gVarQ);
            }
        }
        if (z5 && gVarB2 != null) {
            s.c(s.b(context.getResources().getConfiguration()));
        }
        if (i4 == 0) {
            z(context).h();
        } else {
            v vVar = this.f2569W;
            if (vVar != null) {
                vVar.c();
            }
        }
        if (i4 == 3) {
            if (this.f2570X == null) {
                this.f2570X = new v(this, context);
            }
            this.f2570X.h();
        } else {
            v vVar2 = this.f2570X;
            if (vVar2 != null) {
                vVar2.c();
            }
        }
        return z5;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: f.C
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: f.C
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v7 ??, new type: android.content.res.TypedArray
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v9 ??, new type: android.content.res.TypedArray
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r10v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v4 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r20v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r20v0 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r20v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r20v0 ??, new type: android.content.Context
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r10v3 ??, new type: android.content.Context
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // android.view.LayoutInflater.Factory2
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instruction units count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p009f.z.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    public final void p(Window window) {
        Drawable drawableD;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f2582l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof u) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        u uVar = new u(this, callback);
        this.f2583m = uVar;
        window.setCallback(uVar);
        int[] iArr = f2545i0;
        Context context = this.f2581k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawableD = null;
        } else {
            C0171t c0171tA = C0171t.a();
            synchronized (c0171tA) {
                drawableD = c0171tA.f3302a.d(context, resourceId, true);
            }
        }
        if (drawableD != null) {
            window.setBackgroundDrawable(drawableD);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f2582l = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f2578f0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f2579g0) != null) {
            t.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f2579g0 = null;
        }
        Object obj = this.f2580j;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f2578f0 = t.a(activity);
            } else {
                this.f2578f0 = null;
            }
        } else {
            this.f2578f0 = null;
        }
        J();
    }

    public final void r(int i2, y yVar, n nVar) {
        if (nVar == null) {
            if (yVar == null && i2 >= 0) {
                y[] yVarArr = this.f2559L;
                if (i2 < yVarArr.length) {
                    yVar = yVarArr[i2];
                }
            }
            if (yVar != null) {
                nVar = yVar.f2535h;
            }
        }
        if ((yVar == null || yVar.f2540m) && !this.f2564Q) {
            u uVar = this.f2583m;
            Window.Callback callback = this.f2582l.getCallback();
            uVar.getClass();
            try {
                uVar.f2521e = true;
                callback.onPanelClosed(i2, nVar);
            } finally {
                uVar.f2521e = false;
            }
        }
    }

    public final void s(n nVar) {
        C0154k c0154k;
        if (this.f2558K) {
            return;
        }
        this.f2558K = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f2588r;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((r1) actionBarOverlayLayout.f1330e).f3276a.f1436a;
        if (actionMenuView != null && (c0154k = actionMenuView.f1356t) != null) {
            c0154k.e();
            C0146g c0146g = c0154k.f3224t;
            if (c0146g != null && c0146g.b()) {
                c0146g.f3004i.dismiss();
            }
        }
        Window.Callback callback = this.f2582l.getCallback();
        if (callback != null && !this.f2564Q) {
            callback.onPanelClosed(108, nVar);
        }
        this.f2558K = false;
    }

    public final void t(y yVar, boolean z2) {
        x xVar;
        InterfaceC0163o0 interfaceC0163o0;
        if (z2 && yVar.f2529a == 0 && (interfaceC0163o0 = this.f2588r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0163o0;
            actionBarOverlayLayout.k();
            if (((r1) actionBarOverlayLayout.f1330e).f3276a.p()) {
                s(yVar.f2535h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f2581k.getSystemService("window");
        if (windowManager != null && yVar.f2540m && (xVar = yVar.f2533e) != null) {
            windowManager.removeView(xVar);
            if (z2) {
                r(yVar.f2529a, yVar, null);
            }
        }
        yVar.f2538k = false;
        yVar.f2539l = false;
        yVar.f2540m = false;
        yVar.f2534f = null;
        yVar.f2541n = true;
        if (this.f2560M == yVar) {
            this.f2560M = null;
        }
        if (yVar.f2529a == 0) {
            J();
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    public final boolean v(KeyEvent keyEvent) {
        View decorView;
        boolean z2;
        boolean zV;
        boolean zH;
        ActionMenuView actionMenuView;
        C0154k c0154k;
        Object obj = this.f2580j;
        if (((obj instanceof InterfaceC0013m) || (obj instanceof DialogC0119i)) && (decorView = this.f2582l.getDecorView()) != null && d.l(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82) {
            u uVar = this.f2583m;
            Window.Callback callback = this.f2582l.getCallback();
            uVar.getClass();
            try {
                uVar.f2520d = true;
                boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                uVar.f2520d = false;
                if (zDispatchKeyEvent) {
                    return true;
                }
            } catch (Throwable th) {
                uVar.f2520d = false;
                throw th;
            }
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                this.f2561N = (keyEvent.getFlags() & 128) != 0;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                y yVarA = A(0);
                if (yVarA.f2540m) {
                    return true;
                }
                H(yVarA, keyEvent);
                return true;
            }
        } else if (keyCode != 4) {
            if (keyCode == 82) {
                if (this.f2591u != null) {
                    return true;
                }
                y yVarA2 = A(0);
                InterfaceC0163o0 interfaceC0163o0 = this.f2588r;
                Context context = this.f2581k;
                if (interfaceC0163o0 != null) {
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0163o0;
                    actionBarOverlayLayout.k();
                    Toolbar toolbar = ((r1) actionBarOverlayLayout.f1330e).f3276a;
                    if (toolbar.getVisibility() != 0 || (actionMenuView = toolbar.f1436a) == null || !actionMenuView.f1355s || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                        z2 = yVarA2.f2540m;
                        if (!z2 || yVarA2.f2539l) {
                            t(yVarA2, true);
                            zV = z2;
                        } else {
                            if (yVarA2.f2538k) {
                                if (yVarA2.f2542o) {
                                    yVarA2.f2538k = false;
                                    zH = H(yVarA2, keyEvent);
                                } else {
                                    zH = true;
                                }
                                if (zH) {
                                    F(yVarA2, keyEvent);
                                    zV = true;
                                }
                            }
                            zV = false;
                        }
                    } else {
                        ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.f2588r;
                        actionBarOverlayLayout2.k();
                        if (((r1) actionBarOverlayLayout2.f1330e).f3276a.p()) {
                            ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.f2588r;
                            actionBarOverlayLayout3.k();
                            ActionMenuView actionMenuView2 = ((r1) actionBarOverlayLayout3.f1330e).f3276a.f1436a;
                            if (actionMenuView2 != null && (c0154k = actionMenuView2.f1356t) != null && c0154k.e()) {
                                zV = true;
                            }
                        } else if (!this.f2564Q && H(yVarA2, keyEvent)) {
                            ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.f2588r;
                            actionBarOverlayLayout4.k();
                            zV = ((r1) actionBarOverlayLayout4.f1330e).f3276a.v();
                        }
                        zV = false;
                    }
                } else {
                    z2 = yVarA2.f2540m;
                    if (z2) {
                    }
                    t(yVarA2, true);
                    zV = z2;
                }
                if (!zV) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                    return true;
                }
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                return true;
            }
        } else if (E()) {
            return true;
        }
        return false;
    }

    public final void w(int i2) {
        y yVarA = A(i2);
        if (yVarA.f2535h != null) {
            Bundle bundle = new Bundle();
            yVarA.f2535h.t(bundle);
            if (bundle.size() > 0) {
                yVarA.f2543p = bundle;
            }
            yVarA.f2535h.w();
            yVarA.f2535h.clear();
        }
        yVarA.f2542o = true;
        yVarA.f2541n = true;
        if ((i2 == 108 || i2 == 0) && this.f2588r != null) {
            y yVarA2 = A(0);
            yVarA2.f2538k = false;
            H(yVarA2, null);
        }
    }

    public final void x() {
        ViewGroup viewGroup;
        int i2 = 1;
        int i3 = 0;
        if (this.f2596z) {
            return;
        }
        int[] iArr = p007e.a.f2234j;
        Context context = this.f2581k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            h(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            h(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            h(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            h(10);
        }
        this.f2556I = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        y();
        this.f2582l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f2557J) {
            viewGroup = this.f2555H ? (ViewGroup) layoutInflaterFrom.inflate(com.o2s2m.gae1fc3b2uc0u.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.o2s2m.gae1fc3b2uc0u.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f2556I) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.o2s2m.gae1fc3b2uc0u.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f2554G = false;
            this.f2553F = false;
        } else if (this.f2553F) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.o2s2m.gae1fc3b2uc0u.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new e(context, typedValue.resourceId) : context).inflate(com.o2s2m.gae1fc3b2uc0u.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0163o0 interfaceC0163o0 = (InterfaceC0163o0) viewGroup.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.decor_content_parent);
            this.f2588r = interfaceC0163o0;
            interfaceC0163o0.setWindowCallback(this.f2582l.getCallback());
            if (this.f2554G) {
                ((ActionBarOverlayLayout) this.f2588r).j(109);
            }
            if (this.f2551D) {
                ((ActionBarOverlayLayout) this.f2588r).j(2);
            }
            if (this.f2552E) {
                ((ActionBarOverlayLayout) this.f2588r).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f2553F + ", windowActionBarOverlay: " + this.f2554G + ", android:windowIsFloating: " + this.f2556I + ", windowActionModeOverlay: " + this.f2555H + ", windowNoTitle: " + this.f2557J + " }");
        }
        q qVar = new q(this, i3);
        WeakHashMap weakHashMap = X.f14a;
        L.u(viewGroup, qVar);
        if (this.f2588r == null) {
            this.f2549B = (TextView) viewGroup.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.title);
        }
        Method method = y1.f3354a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e3);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.o2s2m.gae1fc3b2uc0u.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f2582l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f2582l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new q(this, i2));
        this.f2548A = viewGroup;
        Object obj = this.f2580j;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f2587q;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC0163o0 interfaceC0163o1 = this.f2588r;
            if (interfaceC0163o1 != null) {
                interfaceC0163o1.setWindowTitle(title);
            } else {
                AbstractC0111a abstractC0111a = this.f2585o;
                if (abstractC0111a != null) {
                    abstractC0111a.n(title);
                } else {
                    TextView textView = this.f2549B;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f2548A.findViewById(R.id.content);
        View decorView = this.f2582l.getDecorView();
        contentFrameLayout2.g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = X.f14a;
        if (I.c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f2596z = true;
        y yVarA = A(0);
        if (this.f2564Q || yVarA.f2535h != null) {
            return;
        }
        C(108);
    }

    public final void y() {
        if (this.f2582l == null) {
            Object obj = this.f2580j;
            if (obj instanceof Activity) {
                p(((Activity) obj).getWindow());
            }
        }
        if (this.f2582l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final w z(Context context) {
        if (this.f2569W == null) {
            if (C.h.f110d == null) {
                Context applicationContext = context.getApplicationContext();
                C.h.f110d = new C.h(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f2569W = new v(this, C.h.f110d);
        }
        return this.f2569W;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
