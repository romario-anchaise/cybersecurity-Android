// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import X0.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p021m.g;
import p021m.h;
import p021m.j;
import p023n.a;
import p031r.c;
import p035u.b;

/* JADX INFO: loaded from: classes.dex */
public final class Q0 {
    public static Q0 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f3103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap f3104b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f3105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f3107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f3101f = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final P0 f3102h = new P0(6);

    public static synchronized Q0 b() {
        try {
            if (g == null) {
                g = new Q0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        P0 p1 = f3102h;
        p1.getClass();
        int i3 = (31 + i2) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) p1.g(Integer.valueOf(mode.hashCode() + i3));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i2) {
        Drawable drawableNewDrawable;
        Object obj;
        if (this.f3105c == null) {
            this.f3105c = new TypedValue();
        }
        TypedValue typedValue = this.f3105c;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            g gVar = (g) this.f3104b.get(context);
            drawableNewDrawable = null;
            if (gVar != null) {
                int iB = a.b(gVar.f3682b, gVar.f3684d, j2);
                if (iB < 0 || (obj = gVar.f3683c[iB]) == h.f3685a) {
                    obj = null;
                }
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawableNewDrawable = constantState.newDrawable(context.getResources());
                    } else {
                        int iB2 = a.b(gVar.f3682b, gVar.f3684d, j2);
                        if (iB2 >= 0) {
                            Object[] objArr = gVar.f3683c;
                            Object obj2 = objArr[iB2];
                            Object obj3 = h.f3685a;
                            if (obj2 != obj3) {
                                objArr[iB2] = obj3;
                                gVar.f3681a = true;
                            }
                        }
                    }
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableD = null;
        if (this.f3107e != null) {
            if (i2 == R.drawable.abc_cab_background_top_material) {
                layerDrawableD = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i2 == R.drawable.abc_ratingbar_material) {
                layerDrawableD = y.d(this, context, R.dimen.abc_star_big);
            } else if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableD = y.d(this, context, R.dimen.abc_star_medium);
            } else if (i2 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableD = y.d(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableD != null) {
            layerDrawableD.setChangingConfigurations(typedValue.changingConfigurations);
            synchronized (this) {
                try {
                    Drawable.ConstantState constantState2 = layerDrawableD.getConstantState();
                    if (constantState2 != null) {
                        g gVar2 = (g) this.f3104b.get(context);
                        if (gVar2 == null) {
                            gVar2 = new g();
                            this.f3104b.put(context, gVar2);
                        }
                        gVar2.b(j2, new WeakReference(constantState2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return layerDrawableD;
    }

    public final synchronized Drawable c(Context context, int i2) {
        return d(context, i2, false);
    }

    public final synchronized Drawable d(Context context, int i2, boolean z2) {
        Drawable drawableA;
        try {
            if (!this.f3106d) {
                this.f3106d = true;
                Drawable drawableC = c(context, R.drawable.abc_vector_test);
                if (drawableC == null || (!(drawableC instanceof T.a) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.f3106d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(context, i2);
            if (drawableA == null) {
                drawableA = c.b(context, i2);
            }
            if (drawableA != null) {
                drawableA = g(context, i2, z2, drawableA);
            }
            if (drawableA != null) {
                AbstractC0167q0.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(Context context, int i2) {
        ColorStateList colorStateList;
        j jVar;
        Object obj;
        WeakHashMap weakHashMap = this.f3103a;
        ColorStateList colorStateListE = null;
        if (weakHashMap == null || (jVar = (j) weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            int iA = a.a(jVar.f3692c, i2, jVar.f3690a);
            if (iA < 0 || (obj = jVar.f3691b[iA]) == h.f3686b) {
                obj = null;
            }
            colorStateList = (ColorStateList) obj;
        }
        if (colorStateList == null) {
            y yVar = this.f3107e;
            if (yVar != null) {
                colorStateListE = yVar.e(context, i2);
            }
            if (colorStateListE != null) {
                if (this.f3103a == null) {
                    this.f3103a = new WeakHashMap();
                }
                j jVar2 = (j) this.f3103a.get(context);
                if (jVar2 == null) {
                    jVar2 = new j();
                    this.f3103a.put(context, jVar2);
                }
                jVar2.b(i2, colorStateListE);
            }
            colorStateList = colorStateListE;
        }
        return colorStateList;
    }

    public final Drawable g(Context context, int i2, boolean z2, Drawable drawable) {
        boolean z3;
        int iRound;
        PorterDuffColorFilter porterDuffColorFilterE;
        int i3 = R.attr.colorControlNormal;
        int i4 = R.attr.colorControlActivated;
        ColorStateList colorStateListF = f(context, i2);
        PorterDuff.Mode mode = null;
        if (colorStateListF != null) {
            int[] iArr = AbstractC0167q0.f3268a;
            Drawable drawableMutate = drawable.mutate();
            b.h(drawableMutate, colorStateListF);
            if (this.f3107e != null && i2 == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawableMutate;
            }
            b.i(drawableMutate, mode);
            return drawableMutate;
        }
        if (this.f3107e != null) {
            if (i2 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int iC = g1.c(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = C0171t.f3300b;
                y.g(drawableFindDrawableByLayerId, iC, mode2);
                y.g(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), g1.c(context, R.attr.colorControlNormal), mode2);
                y.g(layerDrawable.findDrawableByLayerId(android.R.id.progress), g1.c(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i2 == R.drawable.abc_ratingbar_material || i2 == R.drawable.abc_ratingbar_indicator_material || i2 == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int iB = g1.b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = C0171t.f3300b;
                y.g(drawableFindDrawableByLayerId2, iB, mode3);
                y.g(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), g1.c(context, R.attr.colorControlActivated), mode3);
                y.g(layerDrawable2.findDrawableByLayerId(android.R.id.progress), g1.c(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        y yVar = this.f3107e;
        boolean z4 = false;
        if (yVar != null) {
            PorterDuff.Mode mode4 = C0171t.f3300b;
            if (y.a((int[]) yVar.f1099c, i2)) {
                z3 = true;
                iRound = -1;
            } else {
                if (!y.a((int[]) yVar.f1100d, i2)) {
                    boolean zA = y.a((int[]) yVar.f1101e, i2);
                    i4 = android.R.attr.colorBackground;
                    if (zA) {
                        mode4 = PorterDuff.Mode.MULTIPLY;
                    } else if (i2 == R.drawable.abc_list_divider_mtrl_alpha) {
                        iRound = Math.round(40.8f);
                        i3 = android.R.attr.colorForeground;
                        z3 = true;
                    } else {
                        if (i2 != R.drawable.abc_dialog_material_background) {
                            i3 = 0;
                            z3 = false;
                        }
                        iRound = -1;
                    }
                }
                i3 = i4;
                z3 = true;
                iRound = -1;
            }
            if (z3) {
                int[] iArr2 = AbstractC0167q0.f3268a;
                Drawable drawableMutate2 = drawable.mutate();
                int iC2 = g1.c(context, i3);
                synchronized (C0171t.class) {
                    porterDuffColorFilterE = e(iC2, mode4);
                }
                drawableMutate2.setColorFilter(porterDuffColorFilterE);
                if (iRound != -1) {
                    drawableMutate2.setAlpha(iRound);
                }
                z4 = true;
            }
        }
        if (z4 || !z2) {
            return drawable;
        }
        return null;
    }
}
