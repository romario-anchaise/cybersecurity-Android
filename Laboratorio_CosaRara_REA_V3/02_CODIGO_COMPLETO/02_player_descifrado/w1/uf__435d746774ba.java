// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class uf extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f5256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f5257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f5258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f5259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f5260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f5261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f5262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f5263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f5264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f5265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f5266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5268m;
    public final tf n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a2.i f5269o;

    public uf(ScreenMirrorService screenMirrorService) {
        Drawable drawable;
        super(screenMirrorService);
        this.f5258c = new Paint(1);
        this.f5259d = new TextPaint(1);
        this.f5264i = new LinearInterpolator();
        this.f5266k = 1.0f;
        this.n = new tf(this, 1);
        this.f5269o = new a2.i(18, this);
        this.f5256a = screenMirrorService;
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        int I = n4.I(str == null ? "" : str.trim().toLowerCase(Locale.ROOT));
        if (I == 0) {
            I = n4.I(str2 != null ? str2.trim().toLowerCase(Locale.ROOT) : "");
        }
        if (I != 0) {
            try {
                drawable = screenMirrorService.getDrawable(I);
            } catch (Throwable unused) {
                Log.w("UpdateNotice", "brand update logo unavailable: " + I);
                drawable = null;
            }
        } else {
            drawable = null;
        }
        drawable = drawable == null ? screenMirrorService.getDrawable(R.drawable.system_update_logo) : drawable;
        this.f5257b = drawable;
        this.f5258c.setColor(-1);
        this.f5258c.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f5259d.setColor(Color.rgb(245, 173, 66));
        this.f5259d.setTypeface(Typeface.create("sans-serif", 0));
        this.f5259d.setTextSize(TypedValue.applyDimension(2, 12, screenMirrorService.getResources().getDisplayMetrics()));
        setBackgroundColor(0);
        setLayerType(2, null);
        setWillNotDraw(false);
        FrameLayout frameLayout = new FrameLayout(screenMirrorService);
        this.f5260e = frameLayout;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.rgb(58, 58, 61));
        gradientDrawable.setCornerRadius(wf.u(screenMirrorService, 3));
        frameLayout.setBackground(gradientDrawable);
        frameLayout.setClipToOutline(true);
        View view = new View(screenMirrorService);
        this.f5262g = view;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        view.setBackground(gradientDrawable2);
        view.setPivotX(0.0f);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        View view2 = new View(screenMirrorService);
        this.f5263h = view2;
        view2.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, Color.argb(90, 255, 255, 255), 0}));
        frameLayout.addView(view2, new FrameLayout.LayoutParams(wf.u(screenMirrorService, 58), -1));
        addView(frameLayout);
        ScreenMirrorService screenMirrorService2 = this.f5256a;
        LinearLayout linearLayout = new LinearLayout(screenMirrorService2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(wf.u(screenMirrorService2, 24), wf.u(screenMirrorService2, 22), wf.u(screenMirrorService2, 24), wf.u(screenMirrorService2, 20));
        linearLayout.setElevation(wf.u(screenMirrorService2, 12));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.rgb(30, 30, 32));
        gradientDrawable3.setCornerRadius(wf.u(screenMirrorService2, 20));
        gradientDrawable3.setStroke(wf.u(screenMirrorService2, 1), Color.rgb(72, 72, 76));
        linearLayout.setBackground(gradientDrawable3);
        linearLayout.setClipToOutline(true);
        if (drawable != null) {
            drawable = drawable.getConstantState() != null ? drawable.getConstantState().newDrawable(getResources()).mutate() : drawable;
            ImageView imageView = new ImageView(screenMirrorService2);
            imageView.setImageDrawable(drawable);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wf.u(screenMirrorService2, 200), wf.u(screenMirrorService2, 52));
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
        }
        TextView textViewB = b(R.string.update_overlay_intro_title, 20, -1, true);
        textViewB.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = wf.u(screenMirrorService2, 16);
        linearLayout.addView(textViewB, layoutParams2);
        TextView textViewB2 = b(R.string.update_overlay_intro_changes_label, 12, Color.rgb(245, 173, 66), true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = wf.u(screenMirrorService2, 22);
        linearLayout.addView(textViewB2, layoutParams3);
        TextView textViewB3 = b(R.string.update_overlay_intro_changes, 14, Color.rgb(226, 226, 230), false);
        textViewB3.setLineSpacing(wf.u(screenMirrorService2, 2), 1.05f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = wf.u(screenMirrorService2, 6);
        linearLayout.addView(textViewB3, layoutParams4);
        View view3 = new View(screenMirrorService2);
        view3.setBackgroundColor(Color.rgb(62, 62, 66));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, wf.u(screenMirrorService2, 1));
        layoutParams5.topMargin = wf.u(screenMirrorService2, 18);
        linearLayout.addView(view3, layoutParams5);
        TextView textViewB4 = b(R.string.update_overlay_intro_notice_label, 12, Color.rgb(245, 173, 66), true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = wf.u(screenMirrorService2, 16);
        linearLayout.addView(textViewB4, layoutParams6);
        TextView textViewB5 = b(R.string.update_overlay_intro_notice, 14, Color.rgb(226, 226, 230), false);
        textViewB5.setLineSpacing(wf.u(screenMirrorService2, 2), 1.05f);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = wf.u(screenMirrorService2, 6);
        linearLayout.addView(textViewB5, layoutParams7);
        TextView textViewB6 = b(R.string.update_overlay_intro_countdown, 13, -1, true);
        this.f5265j = textViewB6;
        textViewB6.setText(screenMirrorService2.getString(R.string.update_overlay_intro_countdown, 5));
        this.f5265j.setGravity(17);
        this.f5265j.setPadding(wf.u(screenMirrorService2, 12), wf.u(screenMirrorService2, 8), wf.u(screenMirrorService2, 12), wf.u(screenMirrorService2, 8));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(Color.rgb(50, 50, 54));
        gradientDrawable4.setCornerRadius(wf.u(screenMirrorService2, 18));
        this.f5265j.setBackground(gradientDrawable4);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = wf.u(screenMirrorService2, 20);
        linearLayout.addView(this.f5265j, layoutParams8);
        this.f5261f = linearLayout;
        linearLayout.setVisibility(4);
        addView(linearLayout);
    }

    public static void a(uf ufVar) {
        View view = ufVar.f5263h;
        View view2 = ufVar.f5262g;
        if (ufVar.isAttachedToWindow() && ufVar.getVisibility() == 0) {
            boolean z2 = ufVar.f5267l;
            FrameLayout frameLayout = ufVar.f5260e;
            if (z2) {
                frameLayout.setVisibility(4);
                ufVar.e();
                ufVar.invalidate();
                return;
            }
            frameLayout.setVisibility(0);
            float fQ = wf.Q();
            ufVar.f5266k = fQ;
            view2.animate().cancel();
            view2.setScaleX(fQ / 100.0f);
            ufVar.f5268m = false;
            view.animate().cancel();
            view.setVisibility(4);
            w8 w8VarD = wf.f5440c.d();
            boolean z3 = w8VarD.f5408a;
            long jH0 = n4.H0(System.currentTimeMillis(), z3 ? w8VarD.f5412e : wf.D, z3 ? 3600000L : wf.E);
            if (fQ >= 100.0f || jH0 <= 0 || !ValueAnimator.areAnimatorsEnabled()) {
                ufVar.invalidate();
                return;
            }
            ufVar.f5268m = true;
            view.setVisibility(0);
            view2.animate().scaleX(1.0f).setDuration(jH0).setInterpolator(ufVar.f5264i).start();
            ufVar.f5269o.run();
            ufVar.invalidate();
        }
    }

    public final TextView b(int i3, int i4, int i5, boolean z2) {
        TextView textView = new TextView(this.f5256a);
        textView.setText(i3);
        textView.setTextColor(i5);
        textView.setTextSize(2, i4);
        textView.setTypeface(Typeface.create(z2 ? "sans-serif-medium" : "sans-serif", 0));
        textView.setIncludeFontPadding(false);
        return textView;
    }

    public final void c(boolean z2) {
        if (this.f5267l == z2) {
            if (z2) {
                f();
                return;
            }
            return;
        }
        this.f5267l = z2;
        tf tfVar = this.n;
        removeCallbacks(tfVar);
        LinearLayout linearLayout = this.f5261f;
        linearLayout.animate().cancel();
        LinearInterpolator linearInterpolator = this.f5264i;
        FrameLayout frameLayout = this.f5260e;
        if (z2) {
            e();
            frameLayout.setVisibility(4);
            f();
            linearLayout.setAlpha(ValueAnimator.areAnimatorsEnabled() ? 0.0f : 1.0f);
            linearLayout.setVisibility(0);
            if (ValueAnimator.areAnimatorsEnabled()) {
                linearLayout.animate().alpha(1.0f).setDuration(200L).setInterpolator(linearInterpolator).start();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            w8 w8VarD = wf.f5440c.d();
            long jH0 = n4.H0(jCurrentTimeMillis, w8VarD.f5408a ? w8VarD.f5412e : wf.D, 5000L);
            if (jH0 > 0) {
                postDelayed(tfVar, jH0);
            }
        } else {
            frameLayout.setVisibility(0);
            if (ValueAnimator.areAnimatorsEnabled() && linearLayout.getVisibility() == 0) {
                linearLayout.animate().alpha(0.0f).setDuration(200L).setInterpolator(linearInterpolator).withEndAction(new tf(this, 2)).start();
            } else {
                linearLayout.setVisibility(4);
            }
            if (isAttachedToWindow() && getVisibility() == 0) {
                post(new tf(this, 0));
            }
        }
        invalidate();
    }

    public final void d(float f3) {
        float fMax = Math.max(1.0f, Math.min(100.0f, f3));
        int iG = n4.G(this.f5266k);
        int iG2 = n4.G(fMax);
        long jCurrentTimeMillis = System.currentTimeMillis();
        w8 w8VarD = wf.f5440c.d();
        long j3 = w8VarD.f5408a ? w8VarD.f5412e : wf.D;
        boolean z2 = j3 > 0 && Math.max(0L, jCurrentTimeMillis - j3) < 5000;
        boolean z3 = z2 != this.f5267l;
        c(z2);
        this.f5266k = fMax;
        boolean zAreAnimatorsEnabled = ValueAnimator.areAnimatorsEnabled();
        View view = this.f5262g;
        if (!zAreAnimatorsEnabled) {
            e();
            view.setScaleX(fMax / 100.0f);
        }
        if (fMax >= 100.0f) {
            view.animate().cancel();
            view.setScaleX(1.0f);
            e();
        }
        if (this.f5267l) {
            f();
        }
        if (iG != iG2 || z3 || this.f5267l) {
            invalidate();
        }
    }

    public final void e() {
        this.f5268m = false;
        this.f5262g.animate().cancel();
        View view = this.f5263h;
        view.animate().cancel();
        view.setVisibility(4);
    }

    public final void f() {
        if (this.f5265j == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        w8 w8VarD = wf.f5440c.d();
        long jH0 = n4.H0(jCurrentTimeMillis, w8VarD.f5408a ? w8VarD.f5412e : wf.D, 5000L);
        this.f5265j.setText(this.f5256a.getString(R.string.update_overlay_intro_countdown, Integer.valueOf(Math.max(1, jH0 <= 0 ? 0 : (int) Math.min(2147483647L, (jH0 + 999) / 1000)))));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new tf(this, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.n);
        this.f5261f.animate().cancel();
        e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f3;
        int i3;
        int i4;
        int i5;
        super.onDraw(canvas);
        if (this.f5267l) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float f4 = getResources().getDisplayMetrics().density;
        float f5 = width;
        float fMin = Math.min(Math.max(200.0f * f4, 0.72f * f5), 280.0f * f4);
        float f6 = (f5 - fMin) / 2.0f;
        Drawable drawable = this.f5257b;
        ScreenMirrorService screenMirrorService = this.f5256a;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float fMax = Math.max(1, intrinsicWidth);
            float fMax2 = Math.max(1, intrinsicHeight);
            float f7 = fMax / fMax2;
            float f8 = 72.0f * f4;
            f3 = 2.0f;
            float fMin2 = Math.min(f4 * 220.0f, fMin * 0.82f);
            if (f7 < 1.25f) {
                float f9 = f4 * 76.0f;
                fMin2 = Math.min(fMin2, f9);
                f8 = f9;
            }
            float fMin3 = Math.min(fMin2 / fMax, f8 / fMax2);
            float f10 = fMax * fMin3;
            float f11 = fMax2 * fMin3;
            float fU = ((height / 2.0f) - wf.u(screenMirrorService, 10)) - wf.u(screenMirrorService, 29);
            float f12 = (f5 - f10) / 2.0f;
            drawable.setBounds(Math.round(f12), Math.round(fU - f11), Math.round(f12 + f10), Math.round(fU));
            drawable.draw(canvas);
        } else {
            f3 = 2.0f;
        }
        float f13 = height / f3;
        float fU2 = f13 - wf.u(screenMirrorService, 10);
        int i6 = 2;
        float fApplyDimension = TypedValue.applyDimension(2, 15, screenMirrorService.getResources().getDisplayMetrics());
        Paint paint = this.f5258c;
        paint.setTextSize(fApplyDimension);
        paint.setTextAlign(Paint.Align.CENTER);
        int iG = n4.G(this.f5266k);
        if (iG <= 30) {
            i3 = 1;
        } else if (iG <= 40) {
            i3 = 2;
        } else if (iG <= 79) {
            i3 = 3;
        } else {
            i3 = iG <= 94 ? 4 : 5;
        }
        int iA = g.d.a(i3);
        if (iA == 0) {
            i4 = R.string.update_overlay_status_downloading;
        } else if (iA == 1) {
            i4 = R.string.update_overlay_status_verifying;
        } else if (iA != 2) {
            i4 = iA != 3 ? R.string.update_overlay_status_finishing : R.string.update_overlay_status_optimizing;
        } else {
            i4 = R.string.update_overlay_status_installing;
        }
        canvas.drawText(screenMirrorService.getString(i4), f5 / f3, fU2, paint);
        float fU3 = (f13 - wf.u(screenMirrorService, 10)) + wf.u(screenMirrorService, 25);
        paint.setTextSize(TypedValue.applyDimension(2, 14, screenMirrorService.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(screenMirrorService.getString(R.string.update_overlay_percent, Integer.valueOf(n4.G(this.f5266k))), f6, fU3, paint);
        int iG2 = n4.G(this.f5266k);
        if (iG2 <= 40) {
            i6 = 1;
        } else if (iG2 > 94) {
            i6 = 3;
        }
        int iA2 = g.d.a(i6);
        if (iA2 != 0) {
            i5 = iA2 != 1 ? R.string.update_overlay_guidance_finishing : R.string.update_overlay_guidance_device_on;
        } else {
            i5 = R.string.update_overlay_guidance_network;
        }
        String string = screenMirrorService.getString(i5);
        int iU = wf.u(screenMirrorService, 32);
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(string, 0, string.length(), this.f5259d, Math.max(1, width - (iU * 2))).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).setMaxLines(3).build();
        float fU4 = (height - wf.u(screenMirrorService, 40)) - staticLayoutBuild.getHeight();
        int iSave = canvas.save();
        canvas.translate(iU, fU4);
        staticLayoutBuild.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        FrameLayout frameLayout = this.f5260e;
        float measuredWidth = frameLayout.getMeasuredWidth();
        float f3 = (i7 - measuredWidth) / 2.0f;
        ScreenMirrorService screenMirrorService = this.f5256a;
        float fU = ((i8 / 2.0f) - wf.u(screenMirrorService, 10)) + wf.u(screenMirrorService, 25) + wf.u(screenMirrorService, 12);
        frameLayout.layout(Math.round(f3), Math.round(fU), Math.round(f3 + measuredWidth), frameLayout.getMeasuredHeight() + Math.round(fU));
        View view = this.f5262g;
        view.setPivotX(0.0f);
        view.setPivotY(frameLayout.getMeasuredHeight() / 2.0f);
        LinearLayout linearLayout = this.f5261f;
        int measuredWidth2 = (i7 - linearLayout.getMeasuredWidth()) / 2;
        int measuredHeight = (i8 - linearLayout.getMeasuredHeight()) / 2;
        linearLayout.layout(measuredWidth2, measuredHeight, linearLayout.getMeasuredWidth() + measuredWidth2, linearLayout.getMeasuredHeight() + measuredHeight);
        if (z2 && isAttachedToWindow() && getVisibility() == 0) {
            post(new tf(this, 0));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        int iResolveSize = View.resolveSize(getSuggestedMinimumWidth(), i3);
        int iResolveSize2 = View.resolveSize(getSuggestedMinimumHeight(), i4);
        setMeasuredDimension(iResolveSize, iResolveSize2);
        float f3 = getResources().getDisplayMetrics().density;
        int iMax = Math.max(1, Math.round(Math.min(Math.max(200.0f * f3, iResolveSize * 0.72f), f3 * 280.0f)));
        ScreenMirrorService screenMirrorService = this.f5256a;
        this.f5260e.measure(View.MeasureSpec.makeMeasureSpec(iMax, 1073741824), View.MeasureSpec.makeMeasureSpec(wf.u(screenMirrorService, 6), 1073741824));
        this.f5261f.measure(View.MeasureSpec.makeMeasureSpec(Math.max(1, Math.min(wf.u(screenMirrorService, 320), iResolveSize - wf.u(screenMirrorService, 40))), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(1, iResolveSize2 - wf.u(screenMirrorService, 48)), Integer.MIN_VALUE));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view != this) {
            return;
        }
        if (i3 == 0 && isAttachedToWindow()) {
            post(new tf(this, 0));
        } else {
            e();
        }
    }
}
