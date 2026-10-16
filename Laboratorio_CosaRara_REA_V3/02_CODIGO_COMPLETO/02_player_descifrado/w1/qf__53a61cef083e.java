// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.Choreographer;
import android.view.View;
import com.os9sp.yfwkcq0dwfxaf.R;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class qf extends View implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f4958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f4959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f4960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f4961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f4962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f4963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y3 f4964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f4966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f4967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4968k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4969l;

    public qf(ScreenMirrorService screenMirrorService, y3 y3Var) {
        super(screenMirrorService);
        Paint paint = new Paint(1);
        this.f4958a = paint;
        Paint paint2 = new Paint(3);
        this.f4959b = paint2;
        TextPaint textPaint = new TextPaint(1);
        this.f4960c = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        this.f4961d = textPaint2;
        this.f4963f = new RectF();
        this.f4964g = y3Var;
        setBackgroundColor(0);
        setLayerType(1, null);
        setImportantForAccessibility(2);
        setFocusable(false);
        setClickable(false);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(wf.u(screenMirrorService, 1));
        paint2.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        paint2.setAlpha(Math.round(236.0f));
        textPaint.setColor(-1);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setLetterSpacing(0.025f);
        textPaint2.setColor(-1);
        textPaint2.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        textPaint2.setLetterSpacing(0.025f);
        this.f4962e = BitmapFactory.decodeResource(screenMirrorService.getResources(), R.drawable.fingerprint_rear);
        float fU = wf.u(screenMirrorService, 64);
        this.f4965h = fU;
        this.f4966i = fU * 0.62f;
        this.f4967j = wf.u(screenMirrorService, 38);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j3) {
        if (this.f4968k) {
            this.f4969l = j3 / 1000000;
            invalidate();
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4969l = SystemClock.uptimeMillis();
        this.f4968k = true;
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f4968k = false;
        Choreographer.getInstance().removeFrameCallback(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long j3 = this.f4969l;
        y3 y3Var = this.f4964g;
        String str = y3Var.f5577b;
        int i3 = 0;
        float fMax = Math.max(0, canvas.getWidth()) * 0.5f;
        int iMax = Math.max(0, canvas.getHeight());
        float fMax2 = Math.max(0, iMax) * 0.66f;
        float f3 = iMax;
        float f4 = 2.0f;
        float f5 = this.f4965h;
        float fMax3 = Math.max(0.0f, Math.min(f5, f3 / 2.0f));
        float fMax4 = Math.max(fMax3, Math.min(f3 - fMax3, fMax2));
        float f6 = f5 / 2.0f;
        float f7 = fMax - f6;
        float f8 = fMax4 - f6;
        float f9 = f6 + fMax;
        float f10 = f6 + fMax4;
        RectF rectF = this.f4963f;
        rectF.set(f7, f8, f9, f10);
        while (i3 < 2) {
            float f11 = f4;
            float fFloorMod = Math.floorMod(j3 + (i3 == 0 ? 0L : 1600L), 3200L) / 3200.0f;
            float fMax5 = Math.max(0.0f, Math.min(1.0f, fFloorMod));
            int iRound = Math.round((1.0f - fMax5) * Math.min(1.0f, fMax5 / 0.16f) * 58.0f);
            Paint paint = this.f4958a;
            paint.setAlpha(iRound);
            float fMax6 = 1.0f - Math.max(0.0f, Math.min(1.0f, fFloorMod));
            canvas.drawCircle(fMax, fMax4, (((1.0f - (fMax6 * fMax6)) * 1.12f) + 0.78f) * this.f4966i, paint);
            i3++;
            f4 = f11;
        }
        float f12 = f4;
        Bitmap bitmap = this.f4962e;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rectF, this.f4959b);
        }
        int iRound2 = Math.round((((float) ((1.0d - Math.cos(((Math.floorMod(j3, 2800L) / 2800.0d) * 3.141592653589793d) * 2.0d)) * 0.5d)) * 76.0f) + 133.0f);
        TextPaint textPaint = this.f4960c;
        textPaint.setAlpha(iRound2);
        TextPaint textPaint2 = this.f4961d;
        textPaint2.setAlpha(iRound2);
        textPaint.setTextSize(n.g(32.0f, Math.min(Math.max(1, canvas.getWidth()), Math.max(1, canvas.getHeight())) * 0.044f, 56.0f));
        textPaint2.setTextSize(n.g(24.0f, Math.min(Math.max(1, canvas.getWidth()), Math.max(1, canvas.getHeight())) * 0.032f, 42.0f));
        int iK = n.k(canvas.getWidth(), canvas.getHeight());
        StaticLayout staticLayoutA = wf.a(y3Var.f5585j, textPaint, iK, 2, n.g(32.0f, Math.min(Math.max(1, canvas.getWidth()), Math.max(1, canvas.getHeight())) * 0.044f, 56.0f) * 1.12f);
        StaticLayout staticLayoutA2 = wf.a(y3Var.f5586k, textPaint2, iK, 3, n.g(24.0f, Math.min(Math.max(1, canvas.getWidth()), Math.max(1, canvas.getHeight())) * 0.032f, 42.0f) * 1.2f);
        float fG = n.g(8.0f, Math.min(Math.max(1, canvas.getWidth()), Math.max(1, canvas.getHeight())) * 0.012f, 16.0f);
        float height = staticLayoutA.getHeight() + fG + staticLayoutA2.getHeight();
        float fL0 = n.l0(canvas.getWidth(), canvas.getHeight());
        float f13 = iK;
        float fMax7 = Math.max(fL0, Math.min(fMax - (f13 / f12), Math.max(fL0, (canvas.getWidth() - fL0) - f13)));
        float f14 = this.f4967j;
        float f15 = f10 + f14;
        float fMax8 = Math.max(fL0, (canvas.getHeight() - fL0) - height);
        if (f15 > fMax8) {
            f15 = (f8 - f14) - height;
        }
        float fMax9 = Math.max(fL0, Math.min(f15, fMax8));
        int iSave = canvas.save();
        canvas.translate(fMax7, fMax9);
        staticLayoutA.draw(canvas);
        canvas.translate(0.0f, staticLayoutA.getHeight() + fG);
        staticLayoutA2.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
