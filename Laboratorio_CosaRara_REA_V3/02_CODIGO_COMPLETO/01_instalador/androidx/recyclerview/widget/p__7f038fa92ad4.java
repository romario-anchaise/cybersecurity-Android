// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: androidx.recyclerview.widget.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0098p {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final int[] f1998C = {R.attr.state_pressed};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final int[] f1999D = new int[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f2000A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final RunnableC0094l f2001B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f2004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f2005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2007f;
    public final StateListDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f2008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2015o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2016p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RecyclerView f2019s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f2026z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2017q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2018r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2020t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2021u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2022v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2023w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f2024x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f2025y = new int[2];

    public C0098p(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2026z = valueAnimatorOfFloat;
        this.f2000A = 0;
        RunnableC0094l runnableC0094l = new RunnableC0094l(0, this);
        this.f2001B = runnableC0094l;
        C0095m c0095m = new C0095m(this);
        this.f2004c = stateListDrawable;
        this.f2005d = drawable;
        this.g = stateListDrawable2;
        this.f2008h = drawable2;
        this.f2006e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f2007f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f2009i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f2010j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f2002a = i3;
        this.f2003b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new C0096n(this));
        valueAnimatorOfFloat.addUpdateListener(new C0097o(this));
        RecyclerView recyclerView2 = this.f2019s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            N n2 = recyclerView2.f1813n;
            if (n2 != null) {
                n2.b("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.f1817p;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.M();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f2019s;
            recyclerView3.f1819q.remove(this);
            if (recyclerView3.f1821r == this) {
                recyclerView3.f1821r = null;
            }
            ArrayList arrayList2 = this.f2019s.f1802h0;
            if (arrayList2 != null) {
                arrayList2.remove(c0095m);
            }
            this.f2019s.removeCallbacks(runnableC0094l);
        }
        this.f2019s = recyclerView;
        if (recyclerView != null) {
            N n3 = recyclerView.f1813n;
            if (n3 != null) {
                n3.b("Cannot add item decoration during a scroll  or layout");
            }
            ArrayList arrayList3 = recyclerView.f1817p;
            if (arrayList3.isEmpty()) {
                recyclerView.setWillNotDraw(false);
            }
            arrayList3.add(this);
            recyclerView.M();
            recyclerView.requestLayout();
            this.f2019s.f1819q.add(this);
            RecyclerView recyclerView4 = this.f2019s;
            if (recyclerView4.f1802h0 == null) {
                recyclerView4.f1802h0 = new ArrayList();
            }
            recyclerView4.f1802h0.add(c0095m);
        }
    }

    public static int c(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public final boolean a(float f2, float f3) {
        if (f3 >= this.f2018r - this.f2009i) {
            int i2 = this.f2015o;
            int i3 = this.f2014n;
            if (f2 >= i2 - (i3 / 2) && f2 <= (i3 / 2) + i2) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(float f2, float f3) {
        RecyclerView recyclerView = this.f2019s;
        WeakHashMap weakHashMap = A.X.f14a;
        boolean z2 = A.H.d(recyclerView) == 1;
        int i2 = this.f2006e;
        if (z2) {
            if (f2 > i2) {
                return false;
            }
        } else if (f2 < this.f2017q - i2) {
            return false;
        }
        int i3 = this.f2012l;
        int i4 = this.f2011k / 2;
        return f3 >= ((float) (i3 - i4)) && f3 <= ((float) (i4 + i3));
    }

    public final void d(int i2) {
        RunnableC0094l runnableC0094l = this.f2001B;
        StateListDrawable stateListDrawable = this.f2004c;
        if (i2 == 2 && this.f2022v != 2) {
            stateListDrawable.setState(f1998C);
            this.f2019s.removeCallbacks(runnableC0094l);
        }
        if (i2 == 0) {
            this.f2019s.invalidate();
        } else {
            e();
        }
        if (this.f2022v == 2 && i2 != 2) {
            stateListDrawable.setState(f1999D);
            this.f2019s.removeCallbacks(runnableC0094l);
            this.f2019s.postDelayed(runnableC0094l, 1200);
        } else if (i2 == 1) {
            this.f2019s.removeCallbacks(runnableC0094l);
            this.f2019s.postDelayed(runnableC0094l, 1500);
        }
        this.f2022v = i2;
    }

    public final void e() {
        int i2 = this.f2000A;
        ValueAnimator valueAnimator = this.f2026z;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f2000A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
