// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import A.G;
import A.X;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.WeakHashMap;
import p015j.C0178w0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f124r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListView f127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f130f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C0178w0 f140q;

    public h(C0178w0 c0178w0) {
        a aVar = new a();
        aVar.f118e = Long.MIN_VALUE;
        aVar.g = -1L;
        aVar.f119f = 0L;
        this.f125a = aVar;
        this.f126b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f129e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f130f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f132i = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f133j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f134k = fArr5;
        this.f127c = c0178w0;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = ((int) ((1575.0f * f2) + 0.5f)) / 1000.0f;
        fArr5[0] = f3;
        fArr5[1] = f3;
        float f4 = ((int) ((f2 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f4;
        fArr4[1] = f4;
        this.g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f131h = f124r;
        aVar.f114a = 500;
        aVar.f115b = 500;
        this.f140q = c0178w0;
    }

    public static float b(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        return f2 < f3 ? f3 : f2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float a(int i2, float f2, float f3, float f4) {
        float fB;
        float interpolation;
        float fB2 = b(this.f129e[i2] * f3, 0.0f, this.f130f[i2]);
        float fC = c(f3 - f2, fB2) - c(f2, fB2);
        AccelerateInterpolator accelerateInterpolator = this.f126b;
        if (fC >= 0.0f) {
            if (fC > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fC);
            } else {
                fB = 0.0f;
            }
            if (fB == 0.0f) {
                return 0.0f;
            }
            float f5 = this.f132i[i2];
            float f6 = this.f133j[i2];
            float f7 = this.f134k[i2];
            float f8 = f5 * f4;
            return fB > 0.0f ? b(fB * f8, f6, f7) : -b((-fB) * f8, f6, f7);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fC);
        fB = b(interpolation, -1.0f, 1.0f);
        if (fB == 0.0f) {
            return 0.0f;
        }
        float f9 = this.f132i[i2];
        float f10 = this.f133j[i2];
        float f11 = this.f134k[i2];
        float f12 = f9 * f4;
        if (fB > 0.0f) {
        }
    }

    public final float c(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.f138o && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    public final void d() {
        int i2 = 0;
        if (this.f136m) {
            this.f138o = false;
            return;
        }
        a aVar = this.f125a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (jCurrentAnimationTimeMillis - aVar.f118e);
        int i4 = aVar.f115b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.f121i = i2;
        aVar.f120h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        C0178w0 c0178w0;
        int count;
        a aVar = this.f125a;
        float f2 = aVar.f117d;
        int iAbs = (int) (f2 / Math.abs(f2));
        Math.abs(aVar.f116c);
        if (iAbs == 0 || (count = (c0178w0 = this.f140q).getCount()) == 0) {
            return false;
        }
        int childCount = c0178w0.getChildCount();
        int firstVisiblePosition = c0178w0.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i2 >= count && c0178w0.getChildAt(childCount - 1).getBottom() <= c0178w0.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && c0178w0.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        int i3 = 0;
        if (!this.f139p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                d();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    d();
                }
            }
            return false;
        }
        this.f137n = true;
        this.f135l = false;
        float x2 = motionEvent.getX();
        float width = view.getWidth();
        ListView listView = this.f127c;
        float fA = a(0, x2, width, listView.getWidth());
        float fA2 = a(1, motionEvent.getY(), view.getHeight(), listView.getHeight());
        a aVar = this.f125a;
        aVar.f116c = fA;
        aVar.f117d = fA2;
        if (!this.f138o && e()) {
            if (this.f128d == null) {
                this.f128d = new b(i3, this);
            }
            this.f138o = true;
            this.f136m = true;
            if (this.f135l || (i2 = this.f131h) <= 0) {
                this.f128d.run();
            } else {
                b bVar = this.f128d;
                long j2 = i2;
                WeakHashMap weakHashMap = X.f14a;
                G.n(listView, bVar, j2);
            }
            this.f135l = true;
        }
        return false;
    }
}
