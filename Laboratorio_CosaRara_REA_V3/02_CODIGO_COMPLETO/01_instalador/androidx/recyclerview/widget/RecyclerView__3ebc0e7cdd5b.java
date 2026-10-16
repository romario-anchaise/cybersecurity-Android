// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import A.C0020u;
import A.C0023x;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public static final int[] f1758A0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public static final float f1759B0 = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public static final boolean f1760C0 = true;
    public static final boolean D0 = true;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final boolean f1761E0 = true;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public static final Class[] f1762F0;
    public static final C G0;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public static final Z f1763H0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static boolean f1764y0 = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static boolean f1765z0 = false;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f1766A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final AccessibilityManager f1767B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f1768C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f1769D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f1770E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f1771F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public J f1772G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public EdgeEffect f1773H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public EdgeEffect f1774I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public EdgeEffect f1775J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public EdgeEffect f1776K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public K f1777L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f1778M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f1779N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public VelocityTracker f1780O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f1781P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f1782Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f1783R;
    public int S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f1784T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final int f1785U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final int f1786V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final float f1787W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1788a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final float f1789a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f1790b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1791b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U f1792c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final b0 f1793c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public X f1794d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public RunnableC0101t f1795d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0084b f1796e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final r f1797e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0086d f1798f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Y f1799f0;
    public final H.s g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Q f1800g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1801h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public ArrayList f1802h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final B f1803i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f1804i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f1805j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f1806j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f1807k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final D f1808k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f1809l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f1810l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public F f1811m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public e0 f1812m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public N f1813n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int[] f1814n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f1815o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public C0020u f1816o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f1817p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f1818p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f1819q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int[] f1820q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public C0098p f1821r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int[] f1822r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1823s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final ArrayList f1824s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1825t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final B f1826t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1827u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f1828u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1829v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1830v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1831w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f1832w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1833x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final D f1834x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1835y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1836z;

    static {
        Class cls = Integer.TYPE;
        f1762F0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        G0 = new C();
        f1763H0 = new Z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet) throws NoSuchMethodException {
        float fA;
        int i2;
        char c2;
        Object[] objArr;
        Constructor constructor;
        super(context, attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle);
        int i3 = 1;
        this.f1790b = new W(this);
        this.f1792c = new U(this);
        this.g = new H.s(9);
        this.f1803i = new B(this, 0);
        this.f1805j = new Rect();
        this.f1807k = new Rect();
        this.f1809l = new RectF();
        this.f1815o = new ArrayList();
        this.f1817p = new ArrayList();
        this.f1819q = new ArrayList();
        this.f1829v = 0;
        this.f1768C = false;
        this.f1769D = false;
        this.f1770E = 0;
        this.f1771F = 0;
        this.f1772G = f1763H0;
        C0093k c0093k = new C0093k();
        c0093k.f1714a = null;
        c0093k.f1715b = new ArrayList();
        c0093k.f1716c = 120L;
        c0093k.f1717d = 120L;
        c0093k.f1718e = 250L;
        c0093k.f1719f = 250L;
        c0093k.g = true;
        c0093k.f1972h = new ArrayList();
        c0093k.f1973i = new ArrayList();
        c0093k.f1974j = new ArrayList();
        c0093k.f1975k = new ArrayList();
        c0093k.f1976l = new ArrayList();
        c0093k.f1977m = new ArrayList();
        c0093k.f1978n = new ArrayList();
        c0093k.f1979o = new ArrayList();
        c0093k.f1980p = new ArrayList();
        c0093k.f1981q = new ArrayList();
        c0093k.f1982r = new ArrayList();
        this.f1777L = c0093k;
        this.f1778M = 0;
        this.f1779N = -1;
        this.f1787W = Float.MIN_VALUE;
        this.f1789a0 = Float.MIN_VALUE;
        this.f1791b0 = true;
        this.f1793c0 = new b0(this);
        this.f1797e0 = f1761E0 ? new r() : null;
        Y y2 = new Y();
        y2.f1875a = 0;
        y2.f1876b = 0;
        y2.f1877c = 1;
        y2.f1878d = 0;
        y2.f1879e = false;
        y2.f1880f = false;
        y2.g = false;
        y2.f1881h = false;
        y2.f1882i = false;
        y2.f1883j = false;
        this.f1799f0 = y2;
        this.f1804i0 = false;
        this.f1806j0 = false;
        D d2 = new D(this);
        this.f1808k0 = d2;
        this.f1810l0 = false;
        this.f1814n0 = new int[2];
        this.f1818p0 = new int[2];
        this.f1820q0 = new int[2];
        this.f1822r0 = new int[2];
        this.f1824s0 = new ArrayList();
        this.f1826t0 = new B(this, i3);
        this.f1830v0 = 0;
        this.f1832w0 = 0;
        this.f1834x0 = new D(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1784T = viewConfiguration.getScaledTouchSlop();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Method method = A.a0.f20a;
            fA = A.Y.a(viewConfiguration);
        } else {
            fA = A.a0.a(viewConfiguration, context);
        }
        this.f1787W = fA;
        this.f1789a0 = i4 >= 26 ? A.Y.b(viewConfiguration) : A.a0.a(viewConfiguration, context);
        this.f1785U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1786V = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1788a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f1777L.f1714a = d2;
        this.f1796e = new C0084b(new D(this));
        this.f1798f = new C0086d(new D(this));
        WeakHashMap weakHashMap = A.X.f14a;
        if ((i4 >= 26 ? A.N.c(this) : 0) == 0 && i4 >= 26) {
            A.N.m(this, 8);
        }
        if (A.G.c(this) == 0) {
            A.G.s(this, 1);
        }
        this.f1767B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new e0(this));
        int[] iArr = P.a.f513a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle, 0);
        A.X.g(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1801h = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(F0.h.c(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            i2 = 4;
            c2 = 2;
            new C0098p(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.o2s2m.gae1fc3b2uc0u.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.o2s2m.gae1fc3b2uc0u.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.o2s2m.gae1fc3b2uc0u.R.dimen.fastscroll_margin));
        } else {
            i2 = 4;
            c2 = 2;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(strTrim, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(N.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(f1762F0);
                        objArr = new Object[i2];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c2] = Integer.valueOf(com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e2) {
                        try {
                            objArr = null;
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strTrim, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((N) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strTrim, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strTrim, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strTrim, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e8);
                }
            }
        }
        int[] iArr2 = f1758A0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle, 0);
        A.X.g(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, com.o2s2m.gae1fc3b2uc0u.R.attr.recyclerViewStyle);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        setTag(com.o2s2m.gae1fc3b2uc0u.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    public static RecyclerView D(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewD = D(viewGroup.getChildAt(i2));
            if (recyclerViewD != null) {
                return recyclerViewD;
            }
        }
        return null;
    }

    public static c0 I(View view) {
        if (view == null) {
            return null;
        }
        return ((O) view.getLayoutParams()).f1754a;
    }

    private C0020u getScrollingChildHelper() {
        if (this.f1816o0 == null) {
            this.f1816o0 = new C0020u(this);
        }
        return this.f1816o0;
    }

    public static void i(c0 c0Var) {
        WeakReference<RecyclerView> weakReference = c0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == c0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            c0Var.mNestedRecyclerView = null;
        }
    }

    public static int l(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i3) {
        if (i2 > 0 && edgeEffect != null && f1.l.z(edgeEffect) != 0.0f) {
            int iRound = Math.round(f1.l.K(edgeEffect, ((-i2) * 4.0f) / i3, 0.5f) * ((-i3) / 4.0f));
            if (iRound != i2) {
                edgeEffect.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || edgeEffect2 == null || f1.l.z(edgeEffect2) == 0.0f) {
            return i2;
        }
        float f2 = i3;
        int iRound2 = Math.round(f1.l.K(edgeEffect2, (i2 * 4.0f) / f2, 0.5f) * (f2 / 4.0f));
        if (iRound2 != i2) {
            edgeEffect2.finish();
        }
        return i2 - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z2) {
        f1764y0 = z2;
    }

    public static void setVerboseLoggingEnabled(boolean z2) {
        f1765z0 = z2;
    }

    public final View A(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[SYNTHETIC] */
    public final boolean B(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f1819q;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0098p c0098p = (C0098p) arrayList.get(i2);
            int i3 = c0098p.f2022v;
            if (i3 == 1) {
                boolean zB = c0098p.b(motionEvent.getX(), motionEvent.getY());
                boolean zA = c0098p.a(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zB || zA)) {
                    if (zA) {
                        c0098p.f2023w = 1;
                        c0098p.f2016p = (int) motionEvent.getX();
                    } else if (zB) {
                        c0098p.f2023w = 2;
                        c0098p.f2013m = (int) motionEvent.getY();
                    }
                    c0098p.d(2);
                    if (action != 3) {
                        this.f1821r = c0098p;
                        return true;
                    }
                }
            } else if (i3 != 2) {
                continue;
            } else if (action != 3) {
                this.f1821r = c0098p;
                return true;
            }
        }
        return false;
    }

    public final void C(int[] iArr) {
        int iE = this.f1798f.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iE; i4++) {
            c0 c0VarI = I(this.f1798f.d(i4));
            if (!c0VarI.shouldIgnore()) {
                int layoutPosition = c0VarI.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public final c0 E(int i2) {
        c0 c0Var = null;
        if (this.f1768C) {
            return null;
        }
        int iH = this.f1798f.h();
        for (int i3 = 0; i3 < iH; i3++) {
            c0 c0VarI = I(this.f1798f.g(i3));
            if (c0VarI != null && !c0VarI.isRemoved() && F(c0VarI) == i2) {
                C0086d c0086d = this.f1798f;
                if (!c0086d.f1908c.contains(c0VarI.itemView)) {
                    return c0VarI;
                }
                c0Var = c0VarI;
            }
        }
        return c0Var;
    }

    public final int F(c0 c0Var) {
        if (c0Var.hasAnyOfTheFlags(524) || !c0Var.isBound()) {
            return -1;
        }
        C0084b c0084b = this.f1796e;
        int i2 = c0Var.mPosition;
        ArrayList arrayList = (ArrayList) c0084b.f1893c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0083a c0083a = (C0083a) arrayList.get(i3);
            int i4 = c0083a.f1887a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = c0083a.f1888b;
                    if (i5 <= i2) {
                        int i6 = c0083a.f1890d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = c0083a.f1888b;
                    if (i7 == i2) {
                        i2 = c0083a.f1890d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (c0083a.f1890d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (c0083a.f1888b <= i2) {
                i2 += c0083a.f1890d;
            }
        }
        return i2;
    }

    public final long G(c0 c0Var) {
        return this.f1811m.hasStableIds() ? c0Var.getItemId() : c0Var.mPosition;
    }

    public final c0 H(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return I(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect J(View view) {
        O o2 = (O) view.getLayoutParams();
        boolean z2 = o2.f1756c;
        Rect rect = o2.f1755b;
        if (!z2) {
            return rect;
        }
        if (this.f1799f0.f1880f && (o2.f1754a.isUpdated() || o2.f1754a.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f1817p;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Rect rect2 = this.f1805j;
            rect2.set(0, 0, 0, 0);
            ((C0098p) arrayList.get(i2)).getClass();
            ((O) view.getLayoutParams()).f1754a.getLayoutPosition();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        o2.f1756c = false;
        return rect;
    }

    public final boolean K() {
        return !this.f1827u || this.f1768C || this.f1796e.j();
    }

    public final boolean L() {
        return this.f1770E > 0;
    }

    public final void M() {
        int iH = this.f1798f.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ((O) this.f1798f.g(i2).getLayoutParams()).f1756c = true;
        }
        ArrayList arrayList = this.f1792c.f1868c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            O o2 = (O) ((c0) arrayList.get(i3)).itemView.getLayoutParams();
            if (o2 != null) {
                o2.f1756c = true;
            }
        }
    }

    public final void N(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iH = this.f1798f.h();
        for (int i5 = 0; i5 < iH; i5++) {
            c0 c0VarI = I(this.f1798f.g(i5));
            if (c0VarI != null && !c0VarI.shouldIgnore()) {
                int i6 = c0VarI.mPosition;
                Y y2 = this.f1799f0;
                if (i6 >= i4) {
                    if (f1765z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + c0VarI + " now at position " + (c0VarI.mPosition - i3));
                    }
                    c0VarI.offsetPosition(-i3, z2);
                    y2.f1879e = true;
                } else if (i6 >= i2) {
                    if (f1765z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + c0VarI + " now REMOVED");
                    }
                    c0VarI.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    y2.f1879e = true;
                }
            }
        }
        U u2 = this.f1792c;
        ArrayList arrayList = u2.f1868c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c0 c0Var = (c0) arrayList.get(size);
            if (c0Var != null) {
                int i7 = c0Var.mPosition;
                if (i7 >= i4) {
                    if (f1765z0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + c0Var + " now at position " + (c0Var.mPosition - i3));
                    }
                    c0Var.offsetPosition(-i3, z2);
                } else if (i7 >= i2) {
                    c0Var.addFlags(8);
                    u2.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void O() {
        this.f1770E++;
    }

    public final void P(boolean z2) {
        int i2;
        AccessibilityManager accessibilityManager;
        int i3 = this.f1770E - 1;
        this.f1770E = i3;
        if (i3 < 1) {
            if (f1764y0 && i3 < 0) {
                throw new IllegalStateException(F0.h.c(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.f1770E = 0;
            if (z2) {
                int i4 = this.f1836z;
                this.f1836z = 0;
                if (i4 != 0 && (accessibilityManager = this.f1767B) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    B.b.b(accessibilityEventObtain, i4);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f1824s0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c0 c0Var = (c0) arrayList.get(size);
                    if (c0Var.itemView.getParent() == this && !c0Var.shouldIgnore() && (i2 = c0Var.mPendingAccessibilityState) != -1) {
                        View view = c0Var.itemView;
                        WeakHashMap weakHashMap = A.X.f14a;
                        A.G.s(view, i2);
                        c0Var.mPendingAccessibilityState = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void Q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1779N) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f1779N = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.f1783R = x2;
            this.f1781P = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.S = y2;
            this.f1782Q = y2;
        }
    }

    public final void R() {
        if (this.f1810l0 || !this.f1823s) {
            return;
        }
        WeakHashMap weakHashMap = A.X.f14a;
        A.G.m(this, this.f1826t0);
        this.f1810l0 = true;
    }

    public final void S() {
        boolean z2;
        boolean z3 = false;
        if (this.f1768C) {
            C0084b c0084b = this.f1796e;
            c0084b.q((ArrayList) c0084b.f1893c);
            c0084b.q((ArrayList) c0084b.f1894d);
            c0084b.f1891a = 0;
            if (this.f1769D) {
                this.f1813n.T();
            }
        }
        if (this.f1777L == null || !this.f1813n.s0()) {
            this.f1796e.d();
        } else {
            this.f1796e.p();
        }
        boolean z4 = this.f1804i0 || this.f1806j0;
        boolean z5 = this.f1827u && this.f1777L != null && ((z2 = this.f1768C) || z4 || this.f1813n.f1745e) && (!z2 || this.f1811m.hasStableIds());
        Y y2 = this.f1799f0;
        y2.f1882i = z5;
        if (z5 && z4 && !this.f1768C && this.f1777L != null && this.f1813n.s0()) {
            z3 = true;
        }
        y2.f1883j = z3;
    }

    public final void T(boolean z2) {
        this.f1769D = z2 | this.f1769D;
        this.f1768C = true;
        int iH = this.f1798f.h();
        for (int i2 = 0; i2 < iH; i2++) {
            c0 c0VarI = I(this.f1798f.g(i2));
            if (c0VarI != null && !c0VarI.shouldIgnore()) {
                c0VarI.addFlags(6);
            }
        }
        M();
        U u2 = this.f1792c;
        ArrayList arrayList = u2.f1868c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            c0 c0Var = (c0) arrayList.get(i3);
            if (c0Var != null) {
                c0Var.addFlags(6);
                c0Var.addChangePayload(null);
            }
        }
        F f2 = u2.f1872h.f1811m;
        if (f2 == null || !f2.hasStableIds()) {
            u2.f();
        }
    }

    public final void U(c0 c0Var, C0023x c0023x) {
        c0Var.setFlags(0, 8192);
        boolean z2 = this.f1799f0.g;
        H.s sVar = this.g;
        if (z2 && c0Var.isUpdated() && !c0Var.isRemoved() && !c0Var.shouldIgnore()) {
            ((p021m.g) sVar.f233c).b(G(c0Var), c0Var);
        }
        p021m.i iVar = (p021m.i) sVar.f232b;
        l0 l0VarA = (l0) iVar.get(c0Var);
        if (l0VarA == null) {
            l0VarA = l0.a();
            iVar.put(c0Var, l0VarA);
        }
        l0VarA.f1992b = c0023x;
        l0VarA.f1991a |= 4;
    }

    public final int V(int i2, float f2) {
        float height = f2 / getHeight();
        float width = i2 / getWidth();
        EdgeEffect edgeEffect = this.f1773H;
        float f3 = 0.0f;
        if (edgeEffect == null || f1.l.z(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1775J;
            if (edgeEffect2 != null && f1.l.z(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.f1775J.onRelease();
                } else {
                    float fK = f1.l.K(this.f1775J, width, height);
                    if (f1.l.z(this.f1775J) == 0.0f) {
                        this.f1775J.onRelease();
                    }
                    f3 = fK;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f1773H.onRelease();
            } else {
                float f4 = -f1.l.K(this.f1773H, -width, 1.0f - height);
                if (f1.l.z(this.f1773H) == 0.0f) {
                    this.f1773H.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getWidth());
    }

    public final int W(int i2, float f2) {
        float width = f2 / getWidth();
        float height = i2 / getHeight();
        EdgeEffect edgeEffect = this.f1774I;
        float f3 = 0.0f;
        if (edgeEffect == null || f1.l.z(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1776K;
            if (edgeEffect2 != null && f1.l.z(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.f1776K.onRelease();
                } else {
                    float fK = f1.l.K(this.f1776K, height, 1.0f - width);
                    if (f1.l.z(this.f1776K) == 0.0f) {
                        this.f1776K.onRelease();
                    }
                    f3 = fK;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f1774I.onRelease();
            } else {
                float f4 = -f1.l.K(this.f1774I, -height, width);
                if (f1.l.z(this.f1774I) == 0.0f) {
                    this.f1774I.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getHeight());
    }

    public final void X(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f1805j;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof O) {
            O o2 = (O) layoutParams;
            if (!o2.f1756c) {
                int i2 = rect.left;
                Rect rect2 = o2.f1755b;
                rect.left = i2 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f1813n.g0(this, view, this.f1805j, !this.f1827u, view2 == null);
    }

    public final void Y() {
        VelocityTracker velocityTracker = this.f1780O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        f0(0);
        EdgeEffect edgeEffect = this.f1773H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f1773H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1774I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f1774I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1775J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f1775J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1776K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f1776K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = A.X.f14a;
            A.G.k(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:36:0x0107 A[DONT_INVERT, PHI: r4
  0x0107: PHI (r4v10 boolean) = (r4v8 boolean), (r4v11 boolean) binds: [B:34:0x00ee, B:32:0x00ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0109  */
    /* JADX WARN: Code duplicated, block: B:41:0x0111  */
    public final boolean Z(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        m();
        F f2 = this.f1811m;
        int[] iArr = this.f1822r0;
        if (f2 != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            a0(i2, i3, iArr);
            int i9 = iArr[0];
            int i10 = iArr[1];
            i5 = i9;
            i6 = i10;
            i7 = i2 - i9;
            i8 = i3 - i10;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.f1817p.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        s(i5, i6, i7, i8, this.f1818p0, i4, iArr);
        int i11 = iArr[0];
        int i12 = i7 - i11;
        int i13 = iArr[1];
        int i14 = i8 - i13;
        boolean z3 = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.f1783R;
        int[] iArr2 = this.f1818p0;
        int i16 = iArr2[0];
        this.f1783R = i15 - i16;
        int i17 = this.S;
        int i18 = iArr2[1];
        this.S = i17 - i18;
        int[] iArr3 = this.f1820q0;
        iArr3[0] = iArr3[0] + i16;
        iArr3[1] = iArr3[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && (motionEvent.getSource() & 8194) != 8194) {
                float x2 = motionEvent.getX();
                float f3 = i12;
                float y2 = motionEvent.getY();
                float f4 = i14;
                if (f3 < 0.0f) {
                    v();
                    f1.l.K(this.f1773H, (-f3) / getWidth(), 1.0f - (y2 / getHeight()));
                } else {
                    if (f3 > 0.0f) {
                        w();
                        f1.l.K(this.f1775J, f3 / getWidth(), y2 / getHeight());
                    } else {
                        z2 = false;
                    }
                    if (f4 < 0.0f) {
                        x();
                        f1.l.K(this.f1774I, (-f4) / getHeight(), x2 / getWidth());
                    } else if (f4 > 0.0f) {
                        u();
                        f1.l.K(this.f1776K, f4 / getHeight(), 1.0f - (x2 / getWidth()));
                    } else if (z2 || f3 != 0.0f || f4 != 0.0f) {
                        WeakHashMap weakHashMap = A.X.f14a;
                        A.G.k(this);
                    }
                    z2 = true;
                    if (z2) {
                        WeakHashMap weakHashMap2 = A.X.f14a;
                        A.G.k(this);
                    } else {
                        WeakHashMap weakHashMap3 = A.X.f14a;
                        A.G.k(this);
                    }
                }
                z2 = true;
                if (f4 < 0.0f) {
                    x();
                    f1.l.K(this.f1774I, (-f4) / getHeight(), x2 / getWidth());
                } else if (f4 > 0.0f) {
                    u();
                    f1.l.K(this.f1776K, f4 / getHeight(), 1.0f - (x2 / getWidth()));
                } else if (z2) {
                    WeakHashMap weakHashMap4 = A.X.f14a;
                    A.G.k(this);
                } else {
                    WeakHashMap weakHashMap5 = A.X.f14a;
                    A.G.k(this);
                }
                z2 = true;
                if (z2) {
                    WeakHashMap weakHashMap6 = A.X.f14a;
                    A.G.k(this);
                } else {
                    WeakHashMap weakHashMap7 = A.X.f14a;
                    A.G.k(this);
                }
            }
            k(i2, i3);
        }
        if (i5 != 0 || i6 != 0) {
            t(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z3 && i5 == 0 && i6 == 0) ? false : true;
    }

    public final void a0(int i2, int i3, int[] iArr) {
        c0 c0Var;
        C0086d c0086d = this.f1798f;
        d0();
        O();
        int i4 = p039w.j.f4157a;
        p039w.i.a("RV Scroll");
        Y y2 = this.f1799f0;
        z(y2);
        U u2 = this.f1792c;
        int iI0 = i2 != 0 ? this.f1813n.i0(i2, u2, y2) : 0;
        int iJ0 = i3 != 0 ? this.f1813n.j0(i3, u2, y2) : 0;
        p039w.i.b();
        int iE = c0086d.e();
        for (int i5 = 0; i5 < iE; i5++) {
            View viewD = c0086d.d(i5);
            c0 c0VarH = H(viewD);
            if (c0VarH != null && (c0Var = c0VarH.mShadowingHolder) != null) {
                View view = c0Var.itemView;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        P(true);
        e0(false);
        if (iArr != null) {
            iArr[0] = iI0;
            iArr[1] = iJ0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        N n2 = this.f1813n;
        if (n2 != null) {
            n2.getClass();
        }
        super.addFocusables(arrayList, i2, i3);
    }

    public final boolean b0(EdgeEffect edgeEffect, int i2, int i3) {
        if (i2 > 0) {
            return true;
        }
        float fZ = f1.l.z(edgeEffect) * i3;
        float fAbs = Math.abs(-i2) * 0.35f;
        float f2 = this.f1788a * 0.015f;
        double dLog = Math.log(fAbs / f2);
        double d2 = f1759B0;
        return ((float) (Math.exp((d2 / (d2 - 1.0d)) * dLog) * ((double) f2))) < fZ;
    }

    public final void c0(int i2, int i3, boolean z2) {
        N n2 = this.f1813n;
        if (n2 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1833x) {
            return;
        }
        int i4 = !n2.c() ? 0 : i2;
        int i5 = !this.f1813n.d() ? 0 : i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        if (z2) {
            int i6 = i4 != 0 ? 1 : 0;
            if (i5 != 0) {
                i6 |= 2;
            }
            getScrollingChildHelper().g(i6, 1);
        }
        b0 b0Var = this.f1793c0;
        RecyclerView recyclerView = b0Var.g;
        int iAbs = Math.abs(i4);
        int iAbs2 = Math.abs(i5);
        boolean z3 = iAbs > iAbs2;
        int width = z3 ? recyclerView.getWidth() : recyclerView.getHeight();
        if (!z3) {
            iAbs = iAbs2;
        }
        int iMin = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        Interpolator interpolator = b0Var.f1900d;
        C c2 = G0;
        if (interpolator != c2) {
            b0Var.f1900d = c2;
            b0Var.f1899c = new OverScroller(recyclerView.getContext(), c2);
        }
        b0Var.f1898b = 0;
        b0Var.f1897a = 0;
        recyclerView.setScrollState(2);
        b0Var.f1899c.startScroll(0, 0, i4, i5, iMin);
        if (b0Var.f1901e) {
            b0Var.f1902f = true;
            return;
        }
        RecyclerView recyclerView2 = b0Var.g;
        recyclerView2.removeCallbacks(b0Var);
        WeakHashMap weakHashMap = A.X.f14a;
        A.G.m(recyclerView2, b0Var);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof O) && this.f1813n.e((O) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        N n2 = this.f1813n;
        if (n2 != null && n2.c()) {
            return this.f1813n.i(this.f1799f0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        N n2 = this.f1813n;
        if (n2 != null && n2.c()) {
            return this.f1813n.j(this.f1799f0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        N n2 = this.f1813n;
        if (n2 != null && n2.c()) {
            return this.f1813n.k(this.f1799f0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        N n2 = this.f1813n;
        if (n2 != null && n2.d()) {
            return this.f1813n.l(this.f1799f0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        N n2 = this.f1813n;
        if (n2 != null && n2.d()) {
            return this.f1813n.m(this.f1799f0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        N n2 = this.f1813n;
        if (n2 != null && n2.d()) {
            return this.f1813n.n(this.f1799f0);
        }
        return 0;
    }

    public final void d0() {
        int i2 = this.f1829v + 1;
        this.f1829v = i2;
        if (i2 != 1 || this.f1833x) {
            return;
        }
        this.f1831w = false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        ArrayList arrayList = this.f1817p;
        int size = arrayList.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C0098p c0098p = (C0098p) arrayList.get(i2);
            if (c0098p.f2017q != c0098p.f2019s.getWidth() || c0098p.f2018r != c0098p.f2019s.getHeight()) {
                c0098p.f2017q = c0098p.f2019s.getWidth();
                c0098p.f2018r = c0098p.f2019s.getHeight();
                c0098p.d(0);
            } else if (c0098p.f2000A != 0) {
                if (c0098p.f2020t) {
                    int i3 = c0098p.f2017q;
                    int i4 = c0098p.f2006e;
                    int i5 = i3 - i4;
                    int i6 = c0098p.f2012l;
                    int i7 = c0098p.f2011k;
                    int i8 = i6 - (i7 / 2);
                    StateListDrawable stateListDrawable = c0098p.f2004c;
                    stateListDrawable.setBounds(0, 0, i4, i7);
                    int i9 = c0098p.f2018r;
                    Drawable drawable = c0098p.f2005d;
                    drawable.setBounds(0, 0, c0098p.f2007f, i9);
                    RecyclerView recyclerView = c0098p.f2019s;
                    WeakHashMap weakHashMap = A.X.f14a;
                    if (A.H.d(recyclerView) == 1) {
                        drawable.draw(canvas);
                        canvas.translate(i4, i8);
                        canvas.scale(-1.0f, 1.0f);
                        stateListDrawable.draw(canvas);
                        canvas.scale(-1.0f, 1.0f);
                        canvas.translate(-i4, -i8);
                    } else {
                        canvas.translate(i5, 0.0f);
                        drawable.draw(canvas);
                        canvas.translate(0.0f, i8);
                        stateListDrawable.draw(canvas);
                        canvas.translate(-i5, -i8);
                    }
                }
                if (c0098p.f2021u) {
                    int i10 = c0098p.f2018r;
                    int i11 = c0098p.f2009i;
                    int i12 = i10 - i11;
                    int i13 = c0098p.f2015o;
                    int i14 = c0098p.f2014n;
                    int i15 = i13 - (i14 / 2);
                    StateListDrawable stateListDrawable2 = c0098p.g;
                    stateListDrawable2.setBounds(0, 0, i14, i11);
                    int i16 = c0098p.f2017q;
                    Drawable drawable2 = c0098p.f2008h;
                    drawable2.setBounds(0, 0, i16, c0098p.f2010j);
                    canvas.translate(0.0f, i12);
                    drawable2.draw(canvas);
                    canvas.translate(i15, 0.0f);
                    stateListDrawable2.draw(canvas);
                    canvas.translate(-i15, -i12);
                }
            }
        }
        EdgeEffect edgeEffect = this.f1773H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f1801h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f1773H;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f1774I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f1801h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1774I;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f1775J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1801h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f1775J;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f1776K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1801h) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1776K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.f1777L == null || arrayList.size() <= 0 || !this.f1777L.f()) ? z2 : true) {
            WeakHashMap weakHashMap2 = A.X.f14a;
            A.G.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e0(boolean z2) {
        if (this.f1829v < 1) {
            if (f1764y0) {
                throw new IllegalStateException(F0.h.c(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.f1829v = 1;
        }
        if (!z2 && !this.f1833x) {
            this.f1831w = false;
        }
        if (this.f1829v == 1) {
            if (z2 && this.f1831w && !this.f1833x && this.f1813n != null && this.f1811m != null) {
                o();
            }
            if (!this.f1833x) {
                this.f1831w = false;
            }
        }
        this.f1829v--;
    }

    public final void f0(int i2) {
        getScrollingChildHelper().h(i2);
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0198  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i2) {
        View viewN;
        int i3;
        byte b2;
        boolean z2;
        this.f1813n.getClass();
        boolean z3 = true;
        boolean z4 = (this.f1811m == null || this.f1813n == null || L() || this.f1833x) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        Y y2 = this.f1799f0;
        U u2 = this.f1792c;
        if (z4 && (i2 == 2 || i2 == 1)) {
            if (this.f1813n.d()) {
                if (focusFinder.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f1813n.c()) {
                RecyclerView recyclerView = this.f1813n.f1742b;
                WeakHashMap weakHashMap = A.X.f14a;
                z2 = focusFinder.findNextFocus(this, view, (A.H.d(recyclerView) == 1) ^ (i2 == 2) ? 66 : 17) == null;
            }
            if (z2) {
                m();
                if (A(view) == null) {
                    return null;
                }
                d0();
                this.f1813n.N(view, i2, u2, y2);
                e0(false);
            }
            viewN = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z4) {
                m();
                if (A(view) == null) {
                    return null;
                }
                d0();
                viewN = this.f1813n.N(view, i2, u2, y2);
                e0(false);
            } else {
                viewN = viewFindNextFocus;
            }
        }
        if (viewN != null && !viewN.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i2);
            }
            X(viewN, null);
            return view;
        }
        if (viewN == null || viewN == this || viewN == view) {
            z3 = false;
        } else if (A(viewN) == null) {
            z3 = false;
        } else if (view != null && A(view) != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = this.f1805j;
            rect.set(0, 0, width, height);
            int width2 = viewN.getWidth();
            int height2 = viewN.getHeight();
            Rect rect2 = this.f1807k;
            rect2.set(0, 0, width2, height2);
            offsetDescendantRectToMyCoords(view, rect);
            offsetDescendantRectToMyCoords(viewN, rect2);
            RecyclerView recyclerView2 = this.f1813n.f1742b;
            WeakHashMap weakHashMap2 = A.X.f14a;
            int i4 = A.H.d(recyclerView2) == 1 ? -1 : 1;
            int i5 = rect.left;
            int i6 = rect2.left;
            if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
                i3 = 1;
            } else {
                int i7 = rect.right;
                int i8 = rect2.right;
                i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
            }
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                b2 = 1;
            } else {
                int i11 = rect.bottom;
                int i12 = rect2.bottom;
                b2 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? (byte) -1 : (byte) 0;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 17) {
                        if (i2 != 33) {
                            if (i2 != 66) {
                                if (i2 != 130) {
                                    StringBuilder sb = new StringBuilder("Invalid direction: ");
                                    sb.append(i2);
                                    throw new IllegalArgumentException(F0.h.c(this, sb));
                                }
                                if (b2 <= 0) {
                                    z3 = false;
                                }
                            } else if (i3 <= 0) {
                                z3 = false;
                            }
                        } else if (b2 >= 0) {
                            z3 = false;
                        }
                    } else if (i3 >= 0) {
                        z3 = false;
                    }
                } else if (b2 <= 0 && (b2 != 0 || i3 * i4 <= 0)) {
                    z3 = false;
                }
            } else if (b2 >= 0 && (b2 != 0 || i3 * i4 >= 0)) {
                z3 = false;
            }
        }
        return z3 ? viewN : super.focusSearch(view, i2);
    }

    public final void g(c0 c0Var) {
        View view = c0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.f1792c.l(H(view));
        if (c0Var.isTmpDetached()) {
            this.f1798f.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z2) {
            this.f1798f.a(view, -1, true);
            return;
        }
        C0086d c0086d = this.f1798f;
        int iIndexOfChild = c0086d.f1906a.f1703a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            c0086d.f1907b.i(iIndexOfChild);
            c0086d.i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        N n2 = this.f1813n;
        if (n2 != null) {
            return n2.q();
        }
        throw new IllegalStateException(F0.h.c(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        N n2 = this.f1813n;
        if (n2 != null) {
            return n2.r(getContext(), attributeSet);
        }
        throw new IllegalStateException(F0.h.c(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public F getAdapter() {
        return this.f1811m;
    }

    @Override // android.view.View
    public int getBaseline() {
        N n2 = this.f1813n;
        if (n2 == null) {
            return super.getBaseline();
        }
        n2.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1801h;
    }

    public e0 getCompatAccessibilityDelegate() {
        return this.f1812m0;
    }

    public J getEdgeEffectFactory() {
        return this.f1772G;
    }

    public K getItemAnimator() {
        return this.f1777L;
    }

    public int getItemDecorationCount() {
        return this.f1817p.size();
    }

    public N getLayoutManager() {
        return this.f1813n;
    }

    public int getMaxFlingVelocity() {
        return this.f1786V;
    }

    public int getMinFlingVelocity() {
        return this.f1785U;
    }

    public long getNanoTime() {
        if (f1761E0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public P getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1791b0;
    }

    public T getRecycledViewPool() {
        return this.f1792c.c();
    }

    public int getScrollState() {
        return this.f1778M;
    }

    public final void h(String str) {
        if (L()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(F0.h.c(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.f1771F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(F0.h.c(this, new StringBuilder(""))));
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f1823s;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f1833x;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f80d;
    }

    public final void j() {
        int iH = this.f1798f.h();
        for (int i2 = 0; i2 < iH; i2++) {
            c0 c0VarI = I(this.f1798f.g(i2));
            if (!c0VarI.shouldIgnore()) {
                c0VarI.clearOldPosition();
            }
        }
        U u2 = this.f1792c;
        ArrayList arrayList = u2.f1868c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((c0) arrayList.get(i3)).clearOldPosition();
        }
        ArrayList arrayList2 = u2.f1866a;
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ((c0) arrayList2.get(i4)).clearOldPosition();
        }
        ArrayList arrayList3 = u2.f1867b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ((c0) u2.f1867b.get(i5)).clearOldPosition();
            }
        }
    }

    public final void k(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1773H;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.f1773H.onRelease();
            zIsFinished = this.f1773H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1775J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f1775J.onRelease();
            zIsFinished |= this.f1775J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1774I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f1774I.onRelease();
            zIsFinished |= this.f1774I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1776K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f1776K.onRelease();
            zIsFinished |= this.f1776K.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = A.X.f14a;
            A.G.k(this);
        }
    }

    public final void m() {
        C0086d c0086d = this.f1798f;
        C0084b c0084b = this.f1796e;
        if (!this.f1827u || this.f1768C) {
            int i2 = p039w.j.f4157a;
            p039w.i.a("RV FullInvalidate");
            o();
            p039w.i.b();
            return;
        }
        if (c0084b.j()) {
            int i3 = c0084b.f1891a;
            if ((i3 & 4) == 0 || (i3 & 11) != 0) {
                if (c0084b.j()) {
                    int i4 = p039w.j.f4157a;
                    p039w.i.a("RV FullInvalidate");
                    o();
                    p039w.i.b();
                    return;
                }
                return;
            }
            int i5 = p039w.j.f4157a;
            p039w.i.a("RV PartialInvalidate");
            d0();
            O();
            c0084b.p();
            if (!this.f1831w) {
                int iE = c0086d.e();
                for (int i6 = 0; i6 < iE; i6++) {
                    c0 c0VarI = I(c0086d.d(i6));
                    if (c0VarI != null && !c0VarI.shouldIgnore() && c0VarI.isUpdated()) {
                        o();
                    }
                }
                c0084b.c();
            }
            e0(true);
            P(true);
            p039w.i.b();
        }
    }

    public final void n(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = A.X.f14a;
        setMeasuredDimension(N.f(i2, paddingRight, A.G.e(this)), N.f(i3, getPaddingBottom() + getPaddingTop(), A.G.d(this)));
    }

    /* JADX WARN: Code duplicated, block: B:172:0x0350  */
    /* JADX WARN: Code duplicated, block: B:194:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:196:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:202:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:204:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:207:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:210:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:213:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:216:0x03e4 A[LOOP:5: B:209:0x03d0->B:216:0x03e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:219:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:222:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:225:0x0401 A[LOOP:6: B:218:0x03ed->B:225:0x0401, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:227:0x0406  */
    /* JADX WARN: Code duplicated, block: B:258:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x03e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x0404 A[EDGE_INSN: B:262:0x0404->B:226:0x0404 BREAK  A[LOOP:6: B:218:0x03ed->B:225:0x0401], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [int] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
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
    public final void o() {
        c0 c0Var;
        int i2;
        int iB;
        int i3;
        int iMin;
        c0 c0VarE;
        c0 c0VarE2;
        int i4;
        View viewFindViewById;
        C0023x c0023x;
        ?? r3;
        boolean zG;
        Object obj;
        if (this.f1811m == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1813n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        Y y2 = this.f1799f0;
        boolean z2 = false;
        y2.f1881h = false;
        int i5 = 1;
        boolean z3 = this.f1828u0 && !(this.f1830v0 == getWidth() && this.f1832w0 == getHeight());
        this.f1830v0 = 0;
        this.f1832w0 = 0;
        this.f1828u0 = false;
        if (y2.f1877c == 1) {
            p();
            this.f1813n.k0(this);
            q();
        } else {
            C0084b c0084b = this.f1796e;
            if ((((ArrayList) c0084b.f1894d).isEmpty() || ((ArrayList) c0084b.f1893c).isEmpty()) && !z3 && this.f1813n.f1752m == getWidth() && this.f1813n.f1753n == getHeight()) {
                this.f1813n.k0(this);
            } else {
                this.f1813n.k0(this);
                q();
            }
        }
        y2.a(4);
        d0();
        O();
        y2.f1877c = 1;
        boolean z4 = y2.f1882i;
        U u2 = this.f1792c;
        H.s sVar = this.g;
        if (z4) {
            int iE = this.f1798f.e() - 1;
            while (iE >= 0) {
                c0 c0VarI = I(this.f1798f.d(iE));
                if (!c0VarI.shouldIgnore()) {
                    long jG = G(c0VarI);
                    this.f1777L.getClass();
                    C0023x c0023x2 = new C0023x();
                    c0023x2.a(c0VarI);
                    p021m.g gVar = (p021m.g) sVar.f233c;
                    int iB2 = p023n.a.b(gVar.f3682b, gVar.f3684d, jG);
                    if (iB2 < 0 || (obj = gVar.f3683c[iB2]) == p021m.h.f3685a) {
                        obj = null;
                    }
                    c0 c0Var2 = (c0) obj;
                    if (c0Var2 == null || c0Var2.shouldIgnore()) {
                        sVar.l(c0VarI, c0023x2);
                    } else {
                        p021m.i iVar = (p021m.i) sVar.f232b;
                        l0 l0Var = (l0) iVar.get(c0Var2);
                        int i6 = (l0Var == null || (l0Var.f1991a & i5) == 0) ? 0 : i5;
                        l0 l0Var2 = (l0) iVar.get(c0VarI);
                        int i7 = (l0Var2 == null || (l0Var2.f1991a & i5) == 0) ? 0 : i5;
                        if (i6 == 0 || c0Var2 != c0VarI) {
                            C0023x c0023xE = sVar.E(c0Var2, 4);
                            sVar.l(c0VarI, c0023x2);
                            C0023x c0023xE2 = sVar.E(c0VarI, 8);
                            if (c0023xE == null) {
                                int iE2 = this.f1798f.e();
                                for (int i8 = 0; i8 < iE2; i8++) {
                                    c0 c0VarI2 = I(this.f1798f.d(i8));
                                    if (c0VarI2 != c0VarI && G(c0VarI2) == jG) {
                                        F f2 = this.f1811m;
                                        if (f2 == null || !f2.hasStableIds()) {
                                            StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                            sb.append(c0VarI2);
                                            sb.append(" \n View Holder 2:");
                                            sb.append(c0VarI);
                                            throw new IllegalStateException(F0.h.c(this, sb));
                                        }
                                        StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                        sb2.append(c0VarI2);
                                        sb2.append(" \n View Holder 2:");
                                        sb2.append(c0VarI);
                                        throw new IllegalStateException(F0.h.c(this, sb2));
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0VarI + y());
                            } else {
                                c0Var2.setIsRecyclable(false);
                                if (i6 != 0) {
                                    g(c0Var2);
                                }
                                if (c0Var2 != c0VarI) {
                                    if (i7 != 0) {
                                        g(c0VarI);
                                    }
                                    c0Var2.mShadowedHolder = c0VarI;
                                    g(c0Var2);
                                    u2.l(c0Var2);
                                    c0VarI.setIsRecyclable(false);
                                    c0VarI.mShadowingHolder = c0Var2;
                                }
                                if (this.f1777L.a(c0Var2, c0VarI, c0023xE, c0023xE2)) {
                                    R();
                                }
                            }
                        } else {
                            sVar.l(c0VarI, c0023x2);
                        }
                    }
                }
                iE--;
                i5 = 1;
            }
            p021m.i iVar2 = (p021m.i) sVar.f232b;
            int i9 = iVar2.f3689c - 1;
            while (i9 >= 0) {
                c0 c0Var3 = (c0) iVar2.e(i9);
                l0 l0Var3 = (l0) iVar2.f(i9);
                int i10 = l0Var3.f1991a;
                int i11 = i10 & 3;
                D d2 = this.f1834x0;
                if (i11 == 3) {
                    RecyclerView recyclerView = d2.f1703a;
                    recyclerView.f1813n.e0(c0Var3.itemView, recyclerView.f1792c);
                    r3 = z2;
                } else if ((i10 & 1) != 0) {
                    C0023x c0023x3 = l0Var3.f1992b;
                    if (c0023x3 == null) {
                        RecyclerView recyclerView2 = d2.f1703a;
                        recyclerView2.f1813n.e0(c0Var3.itemView, recyclerView2.f1792c);
                        r3 = z2;
                    } else {
                        d2.g(c0Var3, c0023x3, l0Var3.f1993c);
                        r3 = z2;
                    }
                } else if ((i10 & 14) == 14) {
                    d2.f(c0Var3, l0Var3.f1992b, l0Var3.f1993c);
                    r3 = z2;
                } else {
                    if ((i10 & 12) == 12) {
                        C0023x c0023x4 = l0Var3.f1992b;
                        C0023x c0023x5 = l0Var3.f1993c;
                        d2.getClass();
                        c0Var3.setIsRecyclable(z2);
                        RecyclerView recyclerView3 = d2.f1703a;
                        if (!recyclerView3.f1768C) {
                            C0093k c0093k = (C0093k) recyclerView3.f1777L;
                            c0093k.getClass();
                            int i12 = c0023x4.f86a;
                            int i13 = c0023x5.f86a;
                            if (i12 == i13 && c0023x4.f87b == c0023x5.f87b) {
                                c0093k.c(c0Var3);
                                zG = false;
                            } else {
                                zG = c0093k.g(c0Var3, i12, c0023x4.f87b, i13, c0023x5.f87b);
                            }
                            if (zG) {
                                recyclerView3.R();
                            }
                        } else if (recyclerView3.f1777L.a(c0Var3, c0Var3, c0023x4, c0023x5)) {
                            recyclerView3.R();
                        }
                        r3 = 0;
                    } else {
                        if ((i10 & 4) != 0) {
                            c0023x = null;
                            d2.g(c0Var3, l0Var3.f1992b, null);
                        } else {
                            c0023x = null;
                            if ((i10 & 8) != 0) {
                                d2.f(c0Var3, l0Var3.f1992b, l0Var3.f1993c);
                            }
                        }
                        r3 = 0;
                    }
                    l0Var3.f1991a = r3;
                    l0Var3.f1992b = c0023x;
                    l0Var3.f1993c = c0023x;
                    l0.f1990d.e(l0Var3);
                    i9--;
                    z2 = false;
                }
                c0023x = null;
                l0Var3.f1991a = r3;
                l0Var3.f1992b = c0023x;
                l0Var3.f1993c = c0023x;
                l0.f1990d.e(l0Var3);
                i9--;
                z2 = false;
            }
        }
        this.f1813n.d0(u2);
        y2.f1875a = y2.f1878d;
        this.f1768C = false;
        this.f1769D = false;
        y2.f1882i = false;
        y2.f1883j = false;
        this.f1813n.f1745e = false;
        ArrayList arrayList = u2.f1867b;
        if (arrayList != null) {
            arrayList.clear();
        }
        N n2 = this.f1813n;
        if (n2.f1749j) {
            n2.f1748i = 0;
            n2.f1749j = false;
            u2.m();
        }
        this.f1813n.Y(y2);
        P(true);
        e0(false);
        ((p021m.i) sVar.f232b).clear();
        p021m.g gVar2 = (p021m.g) sVar.f233c;
        int i14 = gVar2.f3684d;
        Object[] objArr = gVar2.f3683c;
        for (int i15 = 0; i15 < i14; i15++) {
            objArr[i15] = null;
        }
        View view = null;
        gVar2.f3684d = 0;
        gVar2.f3681a = false;
        int[] iArr = this.f1814n0;
        int i16 = iArr[0];
        int i17 = iArr[1];
        C(iArr);
        if ((iArr[0] == i16 && iArr[1] == i17) ? false : true) {
            t(0, 0);
        }
        if (this.f1791b0 && this.f1811m != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (isFocused()) {
                if (y2.f1885l == -1) {
                    c0Var = null;
                } else {
                    c0Var = null;
                }
                if (c0Var != null) {
                    if (this.f1798f.e() > 0) {
                        i2 = y2.f1884k;
                        if (i2 == -1) {
                            i2 = 0;
                        }
                        iB = y2.b();
                        i3 = i2;
                        while (true) {
                            if (i3 < iB) {
                                c0VarE2 = E(i3);
                                if (c0VarE2 != null) {
                                    if (c0VarE2.itemView.hasFocusable()) {
                                        view = c0VarE2.itemView;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            for (iMin = Math.min(iB, i2) - 1; iMin >= 0; iMin--) {
                                c0VarE = E(iMin);
                                if (c0VarE == null) {
                                    break;
                                    break;
                                } else {
                                    if (c0VarE.itemView.hasFocusable()) {
                                        view = c0VarE.itemView;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else if (this.f1798f.f1908c.contains(c0Var.itemView)) {
                    if (this.f1798f.e() > 0) {
                        i2 = y2.f1884k;
                        if (i2 == -1) {
                            i2 = 0;
                        }
                        iB = y2.b();
                        i3 = i2;
                        while (true) {
                            if (i3 < iB) {
                                c0VarE2 = E(i3);
                                if (c0VarE2 != null) {
                                    if (c0VarE2.itemView.hasFocusable()) {
                                        view = c0VarE2.itemView;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                c0VarE = E(iMin);
                                if (c0VarE == null) {
                                    break;
                                    break;
                                } else {
                                    if (c0VarE.itemView.hasFocusable()) {
                                        view = c0VarE.itemView;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else if (this.f1798f.e() > 0) {
                    i2 = y2.f1884k;
                    if (i2 == -1) {
                        i2 = 0;
                    }
                    iB = y2.b();
                    i3 = i2;
                    while (true) {
                        if (i3 < iB) {
                            c0VarE2 = E(i3);
                            if (c0VarE2 != null) {
                                if (c0VarE2.itemView.hasFocusable()) {
                                    view = c0VarE2.itemView;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            c0VarE = E(iMin);
                            if (c0VarE == null) {
                                break;
                                break;
                            } else {
                                if (c0VarE.itemView.hasFocusable()) {
                                    view = c0VarE.itemView;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (view != null) {
                    i4 = y2.f1886m;
                    if (i4 != -1) {
                        view = viewFindViewById;
                    }
                    view.requestFocus();
                }
            } else if (this.f1798f.f1908c.contains(getFocusedChild())) {
                if (y2.f1885l == -1 && this.f1811m.hasStableIds()) {
                    long j2 = y2.f1885l;
                    F f3 = this.f1811m;
                    if (f3 == null || !f3.hasStableIds()) {
                        c0Var = null;
                    } else {
                        int iH = this.f1798f.h();
                        c0Var = null;
                        for (int i18 = 0; i18 < iH; i18++) {
                            c0 c0VarI3 = I(this.f1798f.g(i18));
                            if (c0VarI3 != null && !c0VarI3.isRemoved() && c0VarI3.getItemId() == j2) {
                                if (!this.f1798f.f1908c.contains(c0VarI3.itemView)) {
                                    c0Var = c0VarI3;
                                    break;
                                }
                                c0Var = c0VarI3;
                            }
                        }
                    }
                } else {
                    c0Var = null;
                }
                if (c0Var != null) {
                    if (this.f1798f.e() > 0) {
                        i2 = y2.f1884k;
                        if (i2 == -1) {
                            i2 = 0;
                        }
                        iB = y2.b();
                        i3 = i2;
                        while (true) {
                            if (i3 < iB) {
                                c0VarE2 = E(i3);
                                if (c0VarE2 != null) {
                                    if (c0VarE2.itemView.hasFocusable()) {
                                        view = c0VarE2.itemView;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                c0VarE = E(iMin);
                                if (c0VarE == null) {
                                    break;
                                    break;
                                } else {
                                    if (c0VarE.itemView.hasFocusable()) {
                                        view = c0VarE.itemView;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else if (this.f1798f.f1908c.contains(c0Var.itemView) && c0Var.itemView.hasFocusable()) {
                    view = c0Var.itemView;
                } else if (this.f1798f.e() > 0) {
                    i2 = y2.f1884k;
                    if (i2 == -1) {
                        i2 = 0;
                    }
                    iB = y2.b();
                    i3 = i2;
                    while (true) {
                        if (i3 < iB) {
                            c0VarE2 = E(i3);
                            if (c0VarE2 != null) {
                                if (c0VarE2.itemView.hasFocusable()) {
                                    view = c0VarE2.itemView;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            c0VarE = E(iMin);
                            if (c0VarE == null) {
                                break;
                            }
                            if (c0VarE.itemView.hasFocusable()) {
                                view = c0VarE.itemView;
                                break;
                            }
                        }
                    }
                }
                if (view != null) {
                    i4 = y2.f1886m;
                    if (i4 != -1 && (viewFindViewById = view.findViewById(i4)) != null && viewFindViewById.isFocusable()) {
                        view = viewFindViewById;
                    }
                    view.requestFocus();
                }
            }
        }
        y2.f1885l = -1L;
        y2.f1884k = -1;
        y2.f1886m = -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.f1770E = 0;
        this.f1823s = true;
        this.f1827u = this.f1827u && !isLayoutRequested();
        this.f1792c.d();
        N n2 = this.f1813n;
        if (n2 != null) {
            n2.f1746f = true;
        }
        this.f1810l0 = false;
        if (f1761E0) {
            ThreadLocal threadLocal = RunnableC0101t.f2037e;
            RunnableC0101t runnableC0101t = (RunnableC0101t) threadLocal.get();
            this.f1795d0 = runnableC0101t;
            if (runnableC0101t == null) {
                RunnableC0101t runnableC0101t2 = new RunnableC0101t();
                runnableC0101t2.f2039a = new ArrayList();
                runnableC0101t2.f2042d = new ArrayList();
                this.f1795d0 = runnableC0101t2;
                WeakHashMap weakHashMap = A.X.f14a;
                Display displayB = A.H.b(this);
                if (isInEditMode() || displayB == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayB.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                RunnableC0101t runnableC0101t3 = this.f1795d0;
                runnableC0101t3.f2041c = (long) (1.0E9f / refreshRate);
                threadLocal.set(runnableC0101t3);
            }
            RunnableC0101t runnableC0101t4 = this.f1795d0;
            runnableC0101t4.getClass();
            boolean z2 = f1764y0;
            ArrayList arrayList = runnableC0101t4.f2039a;
            if (z2 && arrayList.contains(this)) {
                throw new IllegalStateException("RecyclerView already present in worker list!");
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        U u2;
        RunnableC0101t runnableC0101t;
        super.onDetachedFromWindow();
        K k2 = this.f1777L;
        if (k2 != null) {
            k2.e();
        }
        int i2 = 0;
        setScrollState(0);
        b0 b0Var = this.f1793c0;
        b0Var.g.removeCallbacks(b0Var);
        b0Var.f1899c.abortAnimation();
        this.f1823s = false;
        N n2 = this.f1813n;
        if (n2 != null) {
            n2.f1746f = false;
            n2.M(this);
        }
        this.f1824s0.clear();
        removeCallbacks(this.f1826t0);
        this.g.getClass();
        while (l0.f1990d.a() != null) {
        }
        int i3 = 0;
        while (true) {
            u2 = this.f1792c;
            ArrayList arrayList = u2.f1868c;
            if (i3 >= arrayList.size()) {
                break;
            }
            f1.d.f(((c0) arrayList.get(i3)).itemView);
            i3++;
        }
        u2.e(u2.f1872h.f1811m, false);
        while (i2 < getChildCount()) {
            int i4 = i2 + 1;
            View childAt = getChildAt(i2);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            F.a aVar = (F.a) childAt.getTag(com.o2s2m.gae1fc3b2uc0u.R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new F.a();
                childAt.setTag(com.o2s2m.gae1fc3b2uc0u.R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList2 = aVar.f160a;
            int iP = p036u0.g.p(arrayList2);
            if (-1 < iP) {
                arrayList2.get(iP).getClass();
                throw new ClassCastException();
            }
            i2 = i4;
        }
        if (!f1761E0 || (runnableC0101t = this.f1795d0) == null) {
            return;
        }
        boolean zRemove = runnableC0101t.f2039a.remove(this);
        if (f1764y0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.f1795d0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f1817p;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0098p) arrayList.get(i2)).getClass();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float axisValue;
        if (this.f1813n != null && !this.f1833x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.f1813n.d() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f1813n.c() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f1813n.d()) {
                    f2 = -axisValue2;
                } else if (this.f1813n.c()) {
                    axisValue = axisValue2;
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f2 = 0.0f;
                axisValue = 0.0f;
            }
            if (f2 != 0.0f || axisValue != 0.0f) {
                int i2 = (int) (axisValue * this.f1787W);
                int i3 = (int) (f2 * this.f1789a0);
                N n2 = this.f1813n;
                if (n2 == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.f1833x) {
                    int[] iArr = this.f1822r0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zC = n2.c();
                    boolean zD = this.f1813n.d();
                    int i4 = zD ? (zC ? 1 : 0) | 2 : zC ? 1 : 0;
                    float y2 = motionEvent.getY();
                    float x2 = motionEvent.getX();
                    int iV = i2 - V(i2, y2);
                    int iW = i3 - W(i3, x2);
                    getScrollingChildHelper().g(i4, 1);
                    if (r(zC ? iV : 0, zD ? iW : 0, 1, this.f1822r0, this.f1818p0)) {
                        iV -= iArr[0];
                        iW -= iArr[1];
                    }
                    Z(zC ? iV : 0, zD ? iW : 0, motionEvent, 1);
                    RunnableC0101t runnableC0101t = this.f1795d0;
                    if (runnableC0101t != null && (iV != 0 || iW != 0)) {
                        runnableC0101t.a(this, iV, iW);
                    }
                    f0(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        if (this.f1833x) {
            return false;
        }
        this.f1821r = null;
        if (B(motionEvent)) {
            Y();
            setScrollState(0);
            return true;
        }
        N n2 = this.f1813n;
        if (n2 == null) {
            return false;
        }
        boolean zC = n2.c();
        boolean zD = this.f1813n.d();
        if (this.f1780O == null) {
            this.f1780O = VelocityTracker.obtain();
        }
        this.f1780O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f1835y) {
                this.f1835y = false;
            }
            this.f1779N = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.f1783R = x2;
            this.f1781P = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.S = y2;
            this.f1782Q = y2;
            EdgeEffect edgeEffect = this.f1773H;
            if (edgeEffect == null || f1.l.z(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                z2 = false;
            } else {
                f1.l.K(this.f1773H, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                z2 = true;
            }
            EdgeEffect edgeEffect2 = this.f1775J;
            boolean z4 = z2;
            if (edgeEffect2 != null && f1.l.z(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                z4 = z2;
                z4 = z2;
                f1.l.K(this.f1775J, 0.0f, motionEvent.getY() / getHeight());
                z4 = true;
            }
            z4 = z2;
            z4 = z2;
            z4 = z2;
            EdgeEffect edgeEffect3 = this.f1774I;
            boolean z5 = z4;
            if (edgeEffect3 != null && f1.l.z(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                z5 = z4;
                z5 = z4;
                f1.l.K(this.f1774I, 0.0f, motionEvent.getX() / getWidth());
                z5 = true;
            }
            z5 = z4;
            z5 = z4;
            z5 = z4;
            EdgeEffect edgeEffect4 = this.f1776K;
            boolean z6 = z5;
            if (edgeEffect4 != null && f1.l.z(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                z6 = z5;
                z6 = z5;
                f1.l.K(this.f1776K, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                z6 = true;
            }
            if (z6 || this.f1778M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                f0(1);
            }
            int[] iArr = this.f1820q0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zC;
            if (zD) {
                i2 = (zC ? 1 : 0) | 2;
            }
            getScrollingChildHelper().g(i2, 0);
        } else if (actionMasked == 1) {
            this.f1780O.clear();
            f0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1779N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1779N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f1778M != 1) {
                int i3 = x3 - this.f1781P;
                int i4 = y3 - this.f1782Q;
                if (!zC || Math.abs(i3) <= this.f1784T) {
                    z3 = false;
                } else {
                    this.f1783R = x3;
                    z3 = true;
                }
                if (zD && Math.abs(i4) > this.f1784T) {
                    this.S = y3;
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            Y();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.f1779N = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f1783R = x4;
            this.f1781P = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.S = y4;
            this.f1782Q = y4;
        } else if (actionMasked == 6) {
            Q(motionEvent);
        }
        return this.f1778M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = p039w.j.f4157a;
        p039w.i.a("RV OnLayout");
        o();
        p039w.i.b();
        this.f1827u = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        N n2 = this.f1813n;
        if (n2 == null) {
            n(i2, i3);
            return;
        }
        boolean zG = n2.G();
        boolean z2 = false;
        Y y2 = this.f1799f0;
        if (zG) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f1813n.f1742b.n(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.f1828u0 = z2;
            if (z2 || this.f1811m == null) {
                return;
            }
            if (y2.f1877c == 1) {
                p();
            }
            this.f1813n.l0(i2, i3);
            y2.f1881h = true;
            q();
            this.f1813n.n0(i2, i3);
            if (this.f1813n.q0()) {
                this.f1813n.l0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                y2.f1881h = true;
                q();
                this.f1813n.n0(i2, i3);
            }
            this.f1830v0 = getMeasuredWidth();
            this.f1832w0 = getMeasuredHeight();
            return;
        }
        if (this.f1825t) {
            this.f1813n.f1742b.n(i2, i3);
            return;
        }
        if (this.f1766A) {
            d0();
            O();
            S();
            P(true);
            if (y2.f1883j) {
                y2.f1880f = true;
            } else {
                this.f1796e.d();
                y2.f1880f = false;
            }
            this.f1766A = false;
            e0(false);
        } else if (y2.f1883j) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        F f2 = this.f1811m;
        if (f2 != null) {
            y2.f1878d = f2.getItemCount();
        } else {
            y2.f1878d = 0;
        }
        d0();
        this.f1813n.f1742b.n(i2, i3);
        e0(false);
        y2.f1880f = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (L()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof X)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        X x2 = (X) parcelable;
        this.f1794d = x2;
        super.onRestoreInstanceState(x2.f184a);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        X x2 = new X(super.onSaveInstanceState());
        X x3 = this.f1794d;
        if (x3 != null) {
            x2.f1874c = x3.f1874c;
        } else {
            N n2 = this.f1813n;
            if (n2 != null) {
                x2.f1874c = n2.a0();
            } else {
                x2.f1874c = null;
            }
        }
        return x2;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.f1776K = null;
        this.f1774I = null;
        this.f1775J = null;
        this.f1773H = null;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x034c  */
    /* JADX WARN: Code duplicated, block: B:196:0x038e  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f8 A[PHI: r0
  0x01f8: PHI (r0v58 int) = (r0v43 int), (r0v62 int) binds: [B:90:0x01e1, B:94:0x01f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zB;
        int i2;
        int iMax;
        int i3;
        boolean z2;
        if (this.f1833x || this.f1835y) {
            return false;
        }
        C0098p c0098p = this.f1821r;
        if (c0098p == null) {
            zB = motionEvent.getAction() == 0 ? false : B(motionEvent);
        } else {
            if (c0098p.f2022v != 0) {
                if (motionEvent.getAction() == 0) {
                    boolean zB2 = c0098p.b(motionEvent.getX(), motionEvent.getY());
                    boolean zA = c0098p.a(motionEvent.getX(), motionEvent.getY());
                    if (zB2 || zA) {
                        if (zA) {
                            c0098p.f2023w = 1;
                            c0098p.f2016p = (int) motionEvent.getX();
                        } else if (zB2) {
                            c0098p.f2023w = 2;
                            c0098p.f2013m = (int) motionEvent.getY();
                        }
                        c0098p.d(2);
                    }
                } else if (motionEvent.getAction() == 1 && c0098p.f2022v == 2) {
                    c0098p.f2013m = 0.0f;
                    c0098p.f2016p = 0.0f;
                    c0098p.d(1);
                    c0098p.f2023w = 0;
                } else if (motionEvent.getAction() == 2 && c0098p.f2022v == 2) {
                    c0098p.e();
                    int i4 = c0098p.f2023w;
                    int i5 = c0098p.f2003b;
                    if (i4 == 1) {
                        float x2 = motionEvent.getX();
                        int[] iArr = c0098p.f2025y;
                        iArr[0] = i5;
                        int i6 = c0098p.f2017q - i5;
                        iArr[1] = i6;
                        float fMax = Math.max(i5, Math.min(i6, x2));
                        if (Math.abs(c0098p.f2015o - fMax) >= 2.0f) {
                            int iC = C0098p.c(c0098p.f2016p, fMax, iArr, c0098p.f2019s.computeHorizontalScrollRange(), c0098p.f2019s.computeHorizontalScrollOffset(), c0098p.f2017q);
                            if (iC != 0) {
                                c0098p.f2019s.scrollBy(iC, 0);
                            }
                            c0098p.f2016p = fMax;
                        }
                    }
                    if (c0098p.f2023w == 2) {
                        float y2 = motionEvent.getY();
                        int[] iArr2 = c0098p.f2024x;
                        iArr2[0] = i5;
                        int i7 = c0098p.f2018r - i5;
                        iArr2[1] = i7;
                        float fMax2 = Math.max(i5, Math.min(i7, y2));
                        if (Math.abs(c0098p.f2012l - fMax2) >= 2.0f) {
                            int iC2 = C0098p.c(c0098p.f2013m, fMax2, iArr2, c0098p.f2019s.computeVerticalScrollRange(), c0098p.f2019s.computeVerticalScrollOffset(), c0098p.f2018r);
                            if (iC2 != 0) {
                                c0098p.f2019s.scrollBy(0, iC2);
                            }
                            c0098p.f2013m = fMax2;
                        }
                    }
                }
            }
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f1821r = null;
            }
            zB = true;
        }
        if (zB) {
            Y();
            setScrollState(0);
            return true;
        }
        N n2 = this.f1813n;
        if (n2 == null) {
            return false;
        }
        boolean zC = n2.c();
        boolean zD = this.f1813n.d();
        if (this.f1780O == null) {
            this.f1780O = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int[] iArr3 = this.f1820q0;
        if (actionMasked == 0) {
            iArr3[1] = 0;
            iArr3[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(iArr3[0], iArr3[1]);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f1780O.addMovement(motionEventObtain);
                VelocityTracker velocityTracker = this.f1780O;
                int i8 = this.f1786V;
                velocityTracker.computeCurrentVelocity(1000, i8);
                float f2 = zC ? -this.f1780O.getXVelocity(this.f1779N) : 0.0f;
                float f3 = zD ? -this.f1780O.getYVelocity(this.f1779N) : 0.0f;
                if (f2 == 0.0f && f3 == 0.0f) {
                    setScrollState(0);
                } else {
                    int i9 = (int) f2;
                    int iMax2 = (int) f3;
                    N n3 = this.f1813n;
                    if (n3 == null) {
                        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    } else if (!this.f1833x) {
                        boolean zC2 = n3.c();
                        boolean zD2 = this.f1813n.d();
                        int i10 = this.f1785U;
                        if (!zC2 || Math.abs(i9) < i10) {
                            i9 = 0;
                        }
                        if (!zD2 || Math.abs(iMax2) < i10) {
                            iMax2 = 0;
                        }
                        if (i9 != 0 || iMax2 != 0) {
                            if (i9 == 0) {
                                iMax = 0;
                            } else {
                                EdgeEffect edgeEffect = this.f1773H;
                                if (edgeEffect == null || f1.l.z(edgeEffect) == 0.0f) {
                                    EdgeEffect edgeEffect2 = this.f1775J;
                                    if (edgeEffect2 == null || f1.l.z(edgeEffect2) == 0.0f) {
                                        iMax = 0;
                                    } else if (b0(this.f1775J, i9, getWidth())) {
                                        this.f1775J.onAbsorb(i9);
                                        i9 = 0;
                                    }
                                } else {
                                    int i11 = -i9;
                                    if (b0(this.f1773H, i11, getWidth())) {
                                        this.f1773H.onAbsorb(i11);
                                        i9 = 0;
                                    }
                                }
                                iMax = i9;
                                i9 = 0;
                            }
                            if (iMax2 == 0) {
                                i3 = iMax2;
                                iMax2 = 0;
                            } else {
                                EdgeEffect edgeEffect3 = this.f1774I;
                                if (edgeEffect3 == null || f1.l.z(edgeEffect3) == 0.0f) {
                                    EdgeEffect edgeEffect4 = this.f1776K;
                                    if (edgeEffect4 == null || f1.l.z(edgeEffect4) == 0.0f) {
                                        i3 = iMax2;
                                        iMax2 = 0;
                                    } else if (b0(this.f1776K, iMax2, getHeight())) {
                                        this.f1776K.onAbsorb(iMax2);
                                        iMax2 = 0;
                                    }
                                } else {
                                    int i12 = -iMax2;
                                    if (b0(this.f1774I, i12, getHeight())) {
                                        this.f1774I.onAbsorb(i12);
                                        iMax2 = 0;
                                    }
                                }
                                i3 = 0;
                            }
                            b0 b0Var = this.f1793c0;
                            if (iMax != 0 || iMax2 != 0) {
                                int i13 = -i8;
                                iMax = Math.max(i13, Math.min(iMax, i8));
                                iMax2 = Math.max(i13, Math.min(iMax2, i8));
                                b0Var.a(iMax, iMax2);
                            }
                            if (i9 != 0 || i3 != 0) {
                                float f4 = i9;
                                float f5 = i3;
                                if (!dispatchNestedPreFling(f4, f5)) {
                                    boolean z3 = zC2 || zD2;
                                    dispatchNestedFling(f4, f5, z3);
                                    int i14 = zC2;
                                    if (z3) {
                                        if (zD2) {
                                            i14 = (zC2 ? 1 : 0) | 2;
                                        }
                                        getScrollingChildHelper().g(i14, 1);
                                        int i15 = -i8;
                                        b0Var.a(Math.max(i15, Math.min(i9, i8)), Math.max(i15, Math.min(i3, i8)));
                                    }
                                }
                            } else if (iMax == 0 && iMax2 == 0) {
                            }
                        }
                    }
                    setScrollState(0);
                }
                Y();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1779N);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1779N + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax3 = this.f1783R - x3;
                int iMax4 = this.S - y3;
                if (this.f1778M != 1) {
                    if (zC) {
                        iMax3 = iMax3 > 0 ? Math.max(0, iMax3 - this.f1784T) : Math.min(0, iMax3 + this.f1784T);
                        if (iMax3 != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (zD) {
                        iMax4 = iMax4 > 0 ? Math.max(0, iMax4 - this.f1784T) : Math.min(0, iMax4 + this.f1784T);
                        if (iMax4 != 0) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        setScrollState(1);
                    }
                }
                if (this.f1778M == 1) {
                    int[] iArr4 = this.f1822r0;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    int iV = iMax3 - V(iMax3, motionEvent.getY());
                    int iW = iMax4 - W(iMax4, motionEvent.getX());
                    boolean zR = r(zC ? iV : 0, zD ? iW : 0, 0, this.f1822r0, this.f1818p0);
                    int[] iArr5 = this.f1818p0;
                    if (zR) {
                        iV -= iArr4[0];
                        iW -= iArr4[1];
                        iArr3[0] = iArr3[0] + iArr5[0];
                        iArr3[1] = iArr3[1] + iArr5[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i16 = iV;
                    int i17 = iW;
                    this.f1783R = x3 - iArr5[0];
                    this.S = y3 - iArr5[1];
                    if (Z(zC ? i16 : 0, zD ? i17 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    RunnableC0101t runnableC0101t = this.f1795d0;
                    if (runnableC0101t != null && (i16 != 0 || i17 != 0)) {
                        runnableC0101t.a(this, i16, i17);
                    }
                }
            } else if (actionMasked == 3) {
                Y();
                setScrollState(0);
            } else if (actionMasked == 5) {
                this.f1779N = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f1783R = x4;
                this.f1781P = x4;
                int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.S = y4;
                this.f1782Q = y4;
            } else if (actionMasked == 6) {
                Q(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.f1779N = motionEvent.getPointerId(0);
        int x5 = (int) (motionEvent.getX() + 0.5f);
        this.f1783R = x5;
        this.f1781P = x5;
        int y5 = (int) (motionEvent.getY() + 0.5f);
        this.S = y5;
        this.f1782Q = y5;
        if (zD) {
            i2 = zC;
            i2 = (zC ? 1 : 0) | 2;
        }
        i2 = zC;
        getScrollingChildHelper().g(i2, 0);
        this.f1780O.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public final void p() {
        c0 c0VarH;
        l0 l0Var;
        View viewA;
        Y y2 = this.f1799f0;
        y2.a(1);
        z(y2);
        y2.f1881h = false;
        d0();
        H.s sVar = this.g;
        ((p021m.i) sVar.f232b).clear();
        p021m.g gVar = (p021m.g) sVar.f233c;
        int i2 = gVar.f3684d;
        Object[] objArr = gVar.f3683c;
        int i3 = 0;
        while (true) {
            c0VarH = null;
            if (i3 >= i2) {
                break;
            }
            objArr[i3] = null;
            i3++;
        }
        gVar.f3684d = 0;
        gVar.f3681a = false;
        O();
        S();
        View focusedChild = (this.f1791b0 && hasFocus() && this.f1811m != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewA = A(focusedChild)) != null) {
            c0VarH = H(viewA);
        }
        if (c0VarH == null) {
            y2.f1885l = -1L;
            y2.f1884k = -1;
            y2.f1886m = -1;
        } else {
            y2.f1885l = this.f1811m.hasStableIds() ? c0VarH.getItemId() : -1L;
            y2.f1884k = this.f1768C ? -1 : c0VarH.isRemoved() ? c0VarH.mOldPosition : c0VarH.getAbsoluteAdapterPosition();
            View focusedChild2 = c0VarH.itemView;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            y2.f1886m = id;
        }
        y2.g = y2.f1882i && this.f1806j0;
        this.f1806j0 = false;
        this.f1804i0 = false;
        y2.f1880f = y2.f1883j;
        y2.f1878d = this.f1811m.getItemCount();
        C(this.f1814n0);
        boolean z2 = y2.f1882i;
        p021m.i iVar = (p021m.i) sVar.f232b;
        if (z2) {
            int iE = this.f1798f.e();
            for (int i4 = 0; i4 < iE; i4++) {
                c0 c0VarI = I(this.f1798f.d(i4));
                if (!c0VarI.shouldIgnore() && (!c0VarI.isInvalid() || this.f1811m.hasStableIds())) {
                    K k2 = this.f1777L;
                    K.b(c0VarI);
                    c0VarI.getUnmodifiedPayloads();
                    k2.getClass();
                    C0023x c0023x = new C0023x();
                    c0023x.a(c0VarI);
                    l0 l0VarA = (l0) iVar.get(c0VarI);
                    if (l0VarA == null) {
                        l0VarA = l0.a();
                        iVar.put(c0VarI, l0VarA);
                    }
                    l0VarA.f1992b = c0023x;
                    l0VarA.f1991a |= 4;
                    if (y2.g && c0VarI.isUpdated() && !c0VarI.isRemoved() && !c0VarI.shouldIgnore() && !c0VarI.isInvalid()) {
                        gVar.b(G(c0VarI), c0VarI);
                    }
                }
            }
        }
        if (y2.f1883j) {
            int iH = this.f1798f.h();
            for (int i5 = 0; i5 < iH; i5++) {
                c0 c0VarI2 = I(this.f1798f.g(i5));
                if (f1764y0 && c0VarI2.mPosition == -1 && !c0VarI2.isRemoved()) {
                    throw new IllegalStateException(F0.h.c(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if (!c0VarI2.shouldIgnore()) {
                    c0VarI2.saveOldPosition();
                }
            }
            boolean z3 = y2.f1879e;
            y2.f1879e = false;
            this.f1813n.X(this.f1792c, y2);
            y2.f1879e = z3;
            for (int i6 = 0; i6 < this.f1798f.e(); i6++) {
                c0 c0VarI3 = I(this.f1798f.d(i6));
                if (!c0VarI3.shouldIgnore() && ((l0Var = (l0) iVar.get(c0VarI3)) == null || (l0Var.f1991a & 4) == 0)) {
                    K.b(c0VarI3);
                    boolean zHasAnyOfTheFlags = c0VarI3.hasAnyOfTheFlags(8192);
                    K k3 = this.f1777L;
                    c0VarI3.getUnmodifiedPayloads();
                    k3.getClass();
                    C0023x c0023x2 = new C0023x();
                    c0023x2.a(c0VarI3);
                    if (zHasAnyOfTheFlags) {
                        U(c0VarI3, c0023x2);
                    } else {
                        l0 l0VarA2 = (l0) iVar.get(c0VarI3);
                        if (l0VarA2 == null) {
                            l0VarA2 = l0.a();
                            iVar.put(c0VarI3, l0VarA2);
                        }
                        l0VarA2.f1991a |= 2;
                        l0VarA2.f1992b = c0023x2;
                    }
                }
            }
            j();
        } else {
            j();
        }
        P(true);
        e0(false);
        y2.f1877c = 2;
    }

    public final void q() {
        d0();
        O();
        Y y2 = this.f1799f0;
        y2.a(6);
        this.f1796e.d();
        y2.f1878d = this.f1811m.getItemCount();
        y2.f1876b = 0;
        if (this.f1794d != null && this.f1811m.canRestoreState()) {
            Parcelable parcelable = this.f1794d.f1874c;
            if (parcelable != null) {
                this.f1813n.Z(parcelable);
            }
            this.f1794d = null;
        }
        y2.f1880f = false;
        this.f1813n.X(this.f1792c, y2);
        y2.f1879e = false;
        y2.f1882i = y2.f1882i && this.f1777L != null;
        y2.f1877c = 4;
        P(true);
        e0(false);
    }

    public final boolean r(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, i4, iArr, iArr2);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z2) {
        c0 c0VarI = I(view);
        if (c0VarI != null) {
            if (c0VarI.isTmpDetached()) {
                c0VarI.clearTmpDetachFlag();
            } else if (!c0VarI.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(c0VarI);
                throw new IllegalArgumentException(F0.h.c(this, sb));
            }
        } else if (f1764y0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(F0.h.c(this, sb2));
        }
        view.clearAnimation();
        c0 c0VarI2 = I(view);
        F f2 = this.f1811m;
        if (f2 != null && c0VarI2 != null) {
            f2.onViewDetachedFromWindow(c0VarI2);
        }
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        this.f1813n.getClass();
        if (!L() && view2 != null) {
            X(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f1813n.g0(this, view, rect, z2, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        ArrayList arrayList = this.f1819q;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0098p) arrayList.get(i2)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f1829v != 0 || this.f1833x) {
            this.f1831w = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().d(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        N n2 = this.f1813n;
        if (n2 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1833x) {
            return;
        }
        boolean zC = n2.c();
        boolean zD = this.f1813n.d();
        if (zC || zD) {
            if (!zC) {
                i2 = 0;
            }
            if (!zD) {
                i3 = 0;
            }
            Z(i2, i3, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!L()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int iA = accessibilityEvent != null ? B.b.a(accessibilityEvent) : 0;
            this.f1836z |= iA != 0 ? iA : 0;
        }
    }

    public void setAccessibilityDelegateCompat(e0 e0Var) {
        this.f1812m0 = e0Var;
        A.X.h(this, e0Var);
    }

    public void setAdapter(F f2) {
        setLayoutFrozen(false);
        F f3 = this.f1811m;
        W w2 = this.f1790b;
        if (f3 != null) {
            f3.unregisterAdapterDataObserver(w2);
            this.f1811m.onDetachedFromRecyclerView(this);
        }
        K k2 = this.f1777L;
        if (k2 != null) {
            k2.e();
        }
        N n2 = this.f1813n;
        U u2 = this.f1792c;
        if (n2 != null) {
            n2.c0(u2);
            this.f1813n.d0(u2);
        }
        u2.f1866a.clear();
        u2.f();
        C0084b c0084b = this.f1796e;
        c0084b.q((ArrayList) c0084b.f1893c);
        c0084b.q((ArrayList) c0084b.f1894d);
        c0084b.f1891a = 0;
        F f4 = this.f1811m;
        this.f1811m = f2;
        if (f2 != null) {
            f2.registerAdapterDataObserver(w2);
            f2.onAttachedToRecyclerView(this);
        }
        N n3 = this.f1813n;
        if (n3 != null) {
            n3.L();
        }
        F f5 = this.f1811m;
        u2.f1866a.clear();
        u2.f();
        u2.e(f4, true);
        T tC = u2.c();
        if (f4 != null) {
            tC.f1864b--;
        }
        if (tC.f1864b == 0) {
            int i2 = 0;
            while (true) {
                SparseArray sparseArray = tC.f1863a;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                S s2 = (S) sparseArray.valueAt(i2);
                Iterator it = s2.f1837a.iterator();
                while (it.hasNext()) {
                    f1.d.f(((c0) it.next()).itemView);
                }
                s2.f1837a.clear();
                i2++;
            }
        }
        if (f5 != null) {
            tC.f1864b++;
        }
        u2.d();
        this.f1799f0.f1879e = true;
        T(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(I i2) {
        if (i2 == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f1801h) {
            this.f1776K = null;
            this.f1774I = null;
            this.f1775J = null;
            this.f1773H = null;
        }
        this.f1801h = z2;
        super.setClipToPadding(z2);
        if (this.f1827u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(J j2) {
        j2.getClass();
        this.f1772G = j2;
        this.f1776K = null;
        this.f1774I = null;
        this.f1775J = null;
        this.f1773H = null;
    }

    public void setHasFixedSize(boolean z2) {
        this.f1825t = z2;
    }

    public void setItemAnimator(K k2) {
        K k3 = this.f1777L;
        if (k3 != null) {
            k3.e();
            this.f1777L.f1714a = null;
        }
        this.f1777L = k2;
        if (k2 != null) {
            k2.f1714a = this.f1808k0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        U u2 = this.f1792c;
        u2.f1870e = i2;
        u2.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(N n2) {
        RecyclerView recyclerView;
        if (n2 == this.f1813n) {
            return;
        }
        setScrollState(0);
        b0 b0Var = this.f1793c0;
        b0Var.g.removeCallbacks(b0Var);
        b0Var.f1899c.abortAnimation();
        N n3 = this.f1813n;
        U u2 = this.f1792c;
        if (n3 != null) {
            K k2 = this.f1777L;
            if (k2 != null) {
                k2.e();
            }
            this.f1813n.c0(u2);
            this.f1813n.d0(u2);
            u2.f1866a.clear();
            u2.f();
            if (this.f1823s) {
                N n4 = this.f1813n;
                n4.f1746f = false;
                n4.M(this);
            }
            this.f1813n.o0(null);
            this.f1813n = null;
        } else {
            u2.f1866a.clear();
            u2.f();
        }
        C0086d c0086d = this.f1798f;
        c0086d.f1907b.h();
        ArrayList arrayList = c0086d.f1908c;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = c0086d.f1906a.f1703a;
            if (size < 0) {
                break;
            }
            c0 c0VarI = I((View) arrayList.get(size));
            if (c0VarI != null) {
                c0VarI.onLeftHiddenState(recyclerView);
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            c0 c0VarI2 = I(childAt);
            F f2 = recyclerView.f1811m;
            if (f2 != null && c0VarI2 != null) {
                f2.onViewDetachedFromWindow(c0VarI2);
            }
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f1813n = n2;
        if (n2 != null) {
            if (n2.f1742b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(n2);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(F0.h.c(n2.f1742b, sb));
            }
            n2.o0(this);
            if (this.f1823s) {
                this.f1813n.f1746f = true;
            }
        }
        u2.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        C0020u scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f80d) {
            WeakHashMap weakHashMap = A.X.f14a;
            A.L.z(scrollingChildHelper.f79c);
        }
        scrollingChildHelper.f80d = z2;
    }

    public void setOnFlingListener(P p2) {
    }

    @Deprecated
    public void setOnScrollListener(Q q2) {
        this.f1800g0 = q2;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f1791b0 = z2;
    }

    public void setRecycledViewPool(T t2) {
        U u2 = this.f1792c;
        RecyclerView recyclerView = u2.f1872h;
        u2.e(recyclerView.f1811m, false);
        T t3 = u2.g;
        if (t3 != null) {
            t3.f1864b--;
        }
        u2.g = t2;
        if (t2 != null && recyclerView.getAdapter() != null) {
            u2.g.f1864b++;
        }
        u2.d();
    }

    @Deprecated
    public void setRecyclerListener(V v2) {
    }

    public void setScrollState(int i2) {
        if (i2 == this.f1778M) {
            return;
        }
        if (f1765z0) {
            Log.d("RecyclerView", "setting scroll state to " + i2 + " from " + this.f1778M, new Exception());
        }
        this.f1778M = i2;
        if (i2 != 2) {
            b0 b0Var = this.f1793c0;
            b0Var.g.removeCallbacks(b0Var);
            b0Var.f1899c.abortAnimation();
        }
        N n2 = this.f1813n;
        if (n2 != null) {
            n2.b0(i2);
        }
        ArrayList arrayList = this.f1802h0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Q) this.f1802h0.get(size)).getClass();
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.f1784T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.f1784T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.f1792c.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().g(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.f1833x) {
            h("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.f1833x = false;
                if (this.f1831w && this.f1813n != null && this.f1811m != null) {
                    requestLayout();
                }
                this.f1831w = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f1833x = true;
            this.f1835y = true;
            setScrollState(0);
            b0 b0Var = this.f1793c0;
            b0Var.g.removeCallbacks(b0Var);
            b0Var.f1899c.abortAnimation();
        }
    }

    public final void t(int i2, int i3) {
        this.f1771F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        Q q2 = this.f1800g0;
        if (q2 != null) {
            q2.a(this);
        }
        ArrayList arrayList = this.f1802h0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Q) this.f1802h0.get(size)).a(this);
            }
        }
        this.f1771F--;
    }

    public final void u() {
        if (this.f1776K != null) {
            return;
        }
        ((Z) this.f1772G).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1776K = edgeEffect;
        if (this.f1801h) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void v() {
        if (this.f1773H != null) {
            return;
        }
        ((Z) this.f1772G).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1773H = edgeEffect;
        if (this.f1801h) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void w() {
        if (this.f1775J != null) {
            return;
        }
        ((Z) this.f1772G).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1775J = edgeEffect;
        if (this.f1801h) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.f1774I != null) {
            return;
        }
        ((Z) this.f1772G).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1774I = edgeEffect;
        if (this.f1801h) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String y() {
        return " " + super.toString() + ", adapter:" + this.f1811m + ", layout:" + this.f1813n + ", context:" + getContext();
    }

    public final void z(Y y2) {
        if (getScrollState() != 2) {
            y2.getClass();
            return;
        }
        OverScroller overScroller = this.f1793c0.f1899c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        y2.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        N n2 = this.f1813n;
        if (n2 != null) {
            return n2.s(layoutParams);
        }
        throw new IllegalStateException(F0.h.c(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
