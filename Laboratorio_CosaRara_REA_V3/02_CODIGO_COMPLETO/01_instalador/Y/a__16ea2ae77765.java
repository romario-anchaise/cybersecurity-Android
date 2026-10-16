// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Y;

import F0.h;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import f1.d;
import f1.l;
import g0.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f1110e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1111f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f1115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Drawable f1116l;

    public a(Drawable drawable, Drawable drawable2, g gVar, int i2, boolean z2, boolean z3) {
        this.f1106a = gVar;
        this.f1107b = i2;
        this.f1108c = z2;
        this.f1109d = z3;
        this.f1111f = a(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.g = a(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.f1113i = 255;
        this.f1115k = drawable != null ? drawable.mutate() : null;
        Drawable drawableMutate = drawable2 != null ? drawable2.mutate() : null;
        this.f1116l = drawableMutate;
        if (i2 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
        Drawable drawable3 = this.f1115k;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (drawableMutate == null) {
            return;
        }
        drawableMutate.setCallback(this);
    }

    public final int a(Integer num, Integer num2) {
        if (this.f1109d || ((num == null || num.intValue() != -1) && (num2 == null || num2.intValue() != -1))) {
            return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
        }
        return -1;
    }

    public final void b(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dJ = d.j(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.f1106a);
        double d2 = 2;
        int iS = l.S((((double) iWidth) - (((double) intrinsicWidth) * dJ)) / d2);
        int iS2 = l.S((((double) iHeight) - (dJ * ((double) intrinsicHeight))) / d2);
        drawable.setBounds(rect.left + iS, rect.top + iS2, rect.right - iS, rect.bottom - iS2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable;
        int i2 = this.f1114j;
        if (i2 == 0) {
            Drawable drawable2 = this.f1115k;
            if (drawable2 != null) {
                drawable2.setAlpha(this.f1113i);
                int iSave = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave);
                }
            }
            return;
        }
        Drawable drawable3 = this.f1116l;
        if (i2 == 2) {
            if (drawable3 != null) {
                drawable3.setAlpha(this.f1113i);
                int iSave2 = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                    canvas.restoreToCount(iSave2);
                }
            }
            return;
        }
        double dUptimeMillis = (SystemClock.uptimeMillis() - this.f1112h) / ((double) this.f1107b);
        double d2 = 0.0d;
        if (dUptimeMillis >= 0.0d) {
            d2 = dUptimeMillis > 1.0d ? 1.0d : dUptimeMillis;
        }
        int i3 = this.f1113i;
        int i4 = (int) (d2 * ((double) i3));
        if (this.f1108c) {
            i3 -= i4;
        }
        boolean z2 = dUptimeMillis >= 1.0d;
        if (!z2 && (drawable = this.f1115k) != null) {
            drawable.setAlpha(i3);
            int iSave3 = canvas.save();
            try {
                drawable.draw(canvas);
                canvas.restoreToCount(iSave3);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave3);
                throw th;
            }
        }
        if (drawable3 != null) {
            drawable3.setAlpha(i4);
            int iSave4 = canvas.save();
            try {
                drawable3.draw(canvas);
                canvas.restoreToCount(iSave4);
            } catch (Throwable th2) {
                canvas.restoreToCount(iSave4);
                throw th2;
            }
        }
        if (!z2) {
            invalidateSelf();
            return;
        }
        this.f1114j = 2;
        this.f1115k = null;
        ArrayList arrayList = this.f1110e;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1113i;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        int i2 = this.f1114j;
        if (i2 == 0) {
            Drawable drawable = this.f1115k;
            if (drawable != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        Drawable drawable2 = this.f1116l;
        if (i2 != 1) {
            if (i2 == 2 && drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (drawable2 != null && (colorFilter = drawable2.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable3 = this.f1115k;
        if (drawable3 != null) {
            return drawable3.getColorFilter();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f1111f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f1115k;
        int i2 = this.f1114j;
        if (i2 == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        Drawable drawable2 = this.f1116l;
        if (i2 == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f1114j == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            b(drawable, rect);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 != null) {
            b(drawable2, rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        Drawable drawable = this.f1115k;
        boolean level = drawable != null ? drawable.setLevel(i2) : false;
        Drawable drawable2 = this.f1116l;
        return level || (drawable2 != null ? drawable2.setLevel(i2) : false);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1115k;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.f1116l;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (i2 < 0 || i2 >= 256) {
            throw new IllegalArgumentException(h.b(i2, "Invalid alpha: ").toString());
        }
        this.f1113i = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 == null) {
            return;
        }
        drawable2.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            drawable.setTint(i2);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 != null) {
            drawable2.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1115k;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.f1116l;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Object obj = this.f1115k;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.f1116l;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.f1114j != 0) {
            return;
        }
        this.f1114j = 1;
        this.f1112h = SystemClock.uptimeMillis();
        ArrayList arrayList = this.f1110e;
        if (arrayList.size() <= 0) {
            invalidateSelf();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Object obj = this.f1115k;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.f1116l;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.f1114j != 2) {
            this.f1114j = 2;
            this.f1115k = null;
            ArrayList arrayList = this.f1110e;
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
