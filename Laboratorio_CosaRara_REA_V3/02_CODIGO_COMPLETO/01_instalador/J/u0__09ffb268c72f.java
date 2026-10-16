// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import p035u.a;
import p035u.b;

/* JADX INFO: renamed from: j.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0174u0 extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f3306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3307b;

    public final void a(Canvas canvas) {
        this.f3306a.draw(canvas);
    }

    public final void b(float f2, float f3) {
        b.e(this.f3306a, f2, f3);
    }

    public final void c(int i2, int i3, int i4, int i5) {
        b.f(this.f3306a, i2, i3, i4, i5);
    }

    public final boolean d(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f3306a.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f3307b) {
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.f3306a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f3306a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f3306a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f3306a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f3306a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f3306a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f3306a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f3306a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f3306a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f3306a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return a.d(this.f3306a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f3306a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f3306a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f3306a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        return this.f3306a.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f3306a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        a.e(this.f3306a, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i2) {
        this.f3306a.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3306a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z2) {
        this.f3306a.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z2) {
        this.f3306a.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f2, float f3) {
        if (this.f3307b) {
            b(f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
        if (this.f3307b) {
            c(i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.f3307b) {
            return this.f3306a.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        b.g(this.f3306a, i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        b.h(this.f3306a, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        b.i(this.f3306a, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z3) {
        if (this.f3307b) {
            return d(z2, z3);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
