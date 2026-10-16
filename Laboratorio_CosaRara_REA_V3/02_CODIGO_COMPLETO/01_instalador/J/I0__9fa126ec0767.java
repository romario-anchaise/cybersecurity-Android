// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.I;
import A.X;
import D.o;
import D.p;
import E.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import f1.l;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p007e.a;
import p013i.E;

/* JADX INFO: loaded from: classes.dex */
public abstract class I0 implements E {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Method f3053A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Method f3054z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f3056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0178w0 f3057c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3060f;
    public int g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3064k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f3067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f3068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AdapterView.OnItemClickListener f3069p;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f3074u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Rect f3076w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3077x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final A f3078y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3058d = -2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3059e = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3061h = 1002;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3065l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f3066m = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final F0 f3070q = new F0(this, 1);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final H0 f3071r = new H0(this);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final G0 f3072s = new G0(this);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final F0 f3073t = new F0(this, 0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f3075v = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f3054z = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f3053A = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public I0(Context context, AttributeSet attributeSet, int i2) {
        int resourceId;
        this.f3055a = context;
        this.f3074u = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2239o, i2, 0);
        this.f3060f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f3062i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        A a2 = new A(context, attributeSet, i2, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.f2243s, i2, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            p.c(a2, typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        a2.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : l.A(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f3078y = a2;
        a2.setInputMethodMode(1);
    }

    @Override // p013i.E
    public final boolean b() {
        return this.f3078y.isShowing();
    }

    public final void c(int i2) {
        this.f3060f = i2;
    }

    public final int d() {
        return this.f3060f;
    }

    @Override // p013i.E
    public final void dismiss() {
        A a2 = this.f3078y;
        a2.dismiss();
        a2.setContentView(null);
        this.f3057c = null;
        this.f3074u.removeCallbacks(this.f3070q);
    }

    @Override // p013i.E
    public final C0178w0 e() {
        return this.f3057c;
    }

    @Override // p013i.E
    public final void i() {
        int i2;
        int iMakeMeasureSpec;
        int paddingBottom;
        C0178w0 c0178w0;
        int i3 = 0;
        C0178w0 c0178w1 = this.f3057c;
        A a2 = this.f3078y;
        Context context = this.f3055a;
        if (c0178w1 == null) {
            C0178w0 c0178w0Q = q(context, !this.f3077x);
            this.f3057c = c0178w0Q;
            c0178w0Q.setAdapter(this.f3056b);
            this.f3057c.setOnItemClickListener(this.f3069p);
            this.f3057c.setFocusable(true);
            this.f3057c.setFocusableInTouchMode(true);
            this.f3057c.setOnItemSelectedListener(new C0(i3, this));
            this.f3057c.setOnScrollListener(this.f3072s);
            a2.setContentView(this.f3057c);
        }
        Drawable background = a2.getBackground();
        Rect rect = this.f3075v;
        if (background != null) {
            background.getPadding(rect);
            int i4 = rect.top;
            i2 = rect.bottom + i4;
            if (!this.f3062i) {
                this.g = -i4;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        int iA = D0.a(a2, this.f3068o, this.g, a2.getInputMethodMode() == 2);
        int i5 = this.f3058d;
        if (i5 == -1) {
            paddingBottom = iA + i2;
        } else {
            int i6 = this.f3059e;
            if (i6 != -2) {
                iMakeMeasureSpec = i6 != -1 ? View.MeasureSpec.makeMeasureSpec(i6, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            }
            int iA2 = this.f3057c.a(iMakeMeasureSpec, iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f3057c.getPaddingBottom() + this.f3057c.getPaddingTop() + i2 : 0);
        }
        boolean z2 = this.f3078y.getInputMethodMode() == 2;
        p.d(a2, this.f3061h);
        if (a2.isShowing()) {
            View view = this.f3068o;
            WeakHashMap weakHashMap = X.f14a;
            if (I.b(view)) {
                int width = this.f3059e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f3068o.getWidth();
                }
                if (i5 == -1) {
                    i5 = z2 ? paddingBottom : -1;
                    if (z2) {
                        a2.setWidth(this.f3059e == -1 ? -1 : 0);
                        a2.setHeight(0);
                    } else {
                        a2.setWidth(this.f3059e == -1 ? -1 : 0);
                        a2.setHeight(-1);
                    }
                } else if (i5 == -2) {
                    i5 = paddingBottom;
                }
                a2.setOutsideTouchable(true);
                a2.update(this.f3068o, this.f3060f, this.g, width < 0 ? -1 : width, i5 < 0 ? -1 : i5);
                return;
            }
            return;
        }
        int width2 = this.f3059e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f3068o.getWidth();
        }
        if (i5 == -1) {
            i5 = -1;
        } else if (i5 == -2) {
            i5 = paddingBottom;
        }
        a2.setWidth(width2);
        a2.setHeight(i5);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f3054z;
            if (method != null) {
                try {
                    method.invoke(a2, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            E0.b(a2, true);
        }
        a2.setOutsideTouchable(true);
        a2.setTouchInterceptor(this.f3071r);
        if (this.f3064k) {
            p.c(a2, this.f3063j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f3053A;
            if (method2 != null) {
                try {
                    method2.invoke(a2, this.f3076w);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            E0.a(a2, this.f3076w);
        }
        o.a(a2, this.f3068o, this.f3060f, this.g, this.f3065l);
        this.f3057c.setSelection(-1);
        if ((!this.f3077x || this.f3057c.isInTouchMode()) && (c0178w0 = this.f3057c) != null) {
            c0178w0.setListSelectionHidden(true);
            c0178w0.requestLayout();
        }
        if (this.f3077x) {
            return;
        }
        this.f3074u.post(this.f3073t);
    }

    public final int j() {
        if (this.f3062i) {
            return this.g;
        }
        return 0;
    }

    public final void k(Drawable drawable) {
        this.f3078y.setBackgroundDrawable(drawable);
    }

    public final void l(int i2) {
        this.g = i2;
        this.f3062i = true;
    }

    public final Drawable m() {
        return this.f3078y.getBackground();
    }

    public void o(ListAdapter listAdapter) {
        b bVar = this.f3067n;
        if (bVar == null) {
            this.f3067n = new b(1, this);
        } else {
            ListAdapter listAdapter2 = this.f3056b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f3056b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f3067n);
        }
        C0178w0 c0178w0 = this.f3057c;
        if (c0178w0 != null) {
            c0178w0.setAdapter(this.f3056b);
        }
    }

    public C0178w0 q(Context context, boolean z2) {
        return new C0178w0(context, z2);
    }

    public final void r(int i2) {
        Drawable background = this.f3078y.getBackground();
        if (background == null) {
            this.f3059e = i2;
            return;
        }
        Rect rect = this.f3075v;
        background.getPadding(rect);
        this.f3059e = rect.left + rect.right + i2;
    }
}
