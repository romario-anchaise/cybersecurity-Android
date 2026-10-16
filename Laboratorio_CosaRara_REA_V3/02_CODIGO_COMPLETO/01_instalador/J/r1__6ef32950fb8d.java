// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.X;
import C.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.o2s2m.gae1fc3b2uc0u.R;
import p007e.a;

/* JADX INFO: loaded from: classes.dex */
public final class r1 implements InterfaceC0165p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f3276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f3278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f3279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f3280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f3281f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f3282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f3283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CharSequence f3284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f3285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0154k f3287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Drawable f3289o;

    public r1(Toolbar toolbar, boolean z2) {
        Drawable drawable;
        this.f3288n = 0;
        this.f3276a = toolbar;
        this.f3282h = toolbar.getTitle();
        this.f3283i = toolbar.getSubtitle();
        this.g = this.f3282h != null;
        this.f3281f = toolbar.getNavigationIcon();
        h hVarP = h.p(toolbar.getContext(), null, a.f2226a, R.attr.actionBarStyle);
        int i2 = 15;
        this.f3289o = hVarP.l(15);
        if (z2) {
            TypedArray typedArray = (TypedArray) hVarP.f112b;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.g = true;
                this.f3282h = text;
                if ((this.f3277b & 8) != 0) {
                    Toolbar toolbar2 = this.f3276a;
                    toolbar2.setTitle(text);
                    if (this.g) {
                        X.i(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.f3283i = text2;
                if ((this.f3277b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableL = hVarP.l(20);
            if (drawableL != null) {
                this.f3280e = drawableL;
                c();
            }
            Drawable drawableL2 = hVarP.l(17);
            if (drawableL2 != null) {
                this.f3279d = drawableL2;
                c();
            }
            if (this.f3281f == null && (drawable = this.f3289o) != null) {
                this.f3281f = drawable;
                int i3 = this.f3277b & 4;
                Toolbar toolbar3 = this.f3276a;
                if (i3 != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f3278c;
                if (view != null && (this.f3277b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f3278c = viewInflate;
                if (viewInflate != null && (this.f3277b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                a(this.f3277b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.d();
                toolbar.f1454t.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f1446l = resourceId2;
                C0143e0 c0143e0 = toolbar.f1437b;
                if (c0143e0 != null) {
                    c0143e0.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f1447m = resourceId3;
                C0143e0 c0143e1 = toolbar.f1438c;
                if (c0143e1 != null) {
                    c0143e1.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f3289o = toolbar.getNavigationIcon();
            } else {
                i2 = 11;
            }
            this.f3277b = i2;
        }
        hVarP.r();
        if (R.string.abc_action_bar_up_description != this.f3288n) {
            this.f3288n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i4 = this.f3288n;
                this.f3284j = i4 != 0 ? toolbar.getContext().getString(i4) : null;
                b();
            }
        }
        this.f3284j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new q1(this));
    }

    public final void a(int i2) {
        View view;
        int i3 = this.f3277b ^ i2;
        this.f3277b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    b();
                }
                int i4 = this.f3277b & 4;
                Toolbar toolbar = this.f3276a;
                if (i4 != 0) {
                    Drawable drawable = this.f3281f;
                    if (drawable == null) {
                        drawable = this.f3289o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                c();
            }
            int i5 = i3 & 8;
            Toolbar toolbar2 = this.f3276a;
            if (i5 != 0) {
                if ((i2 & 8) != 0) {
                    toolbar2.setTitle(this.f3282h);
                    toolbar2.setSubtitle(this.f3283i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f3278c) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f3277b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f3284j);
            Toolbar toolbar = this.f3276a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f3288n);
            } else {
                toolbar.setNavigationContentDescription(this.f3284j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i2 = this.f3277b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f3280e) == null) {
            drawable = this.f3279d;
        }
        this.f3276a.setLogo(drawable);
    }
}
