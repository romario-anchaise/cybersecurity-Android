// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x5 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f5493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f5494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f5495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d2.o f5500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y5 f5501i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(y5 y5Var, ScreenMirrorService screenMirrorService, d2.o oVar) {
        super(screenMirrorService);
        this.f5501i = y5Var;
        Paint paint = new Paint(1);
        this.f5493a = paint;
        Paint paint2 = new Paint(1);
        this.f5494b = paint2;
        Paint paint3 = new Paint(1);
        this.f5495c = paint3;
        this.f5496d = new ArrayList();
        this.f5497e = -1.0f;
        this.f5498f = -1.0f;
        this.f5500h = oVar;
        paint.setColor(-1275068417);
        paint.setStyle(Paint.Style.FILL);
        paint2.setColor(-11688961);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        paint2.setStrokeWidth(y5Var.a(2));
        paint3.setColor(-867326977);
        paint3.setStyle(style);
        paint3.setStrokeWidth(y5Var.a(3));
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setStrokeJoin(Paint.Join.ROUND);
    }

    public final float a(int i3) {
        return ((((i3 - 1) % 3) + 0.5f) * getWidth()) / 3.0f;
    }

    public final float b(int i3) {
        return ((((i3 - 1) / 3) + 0.5f) * getHeight()) / 3.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y5 y5Var = this.f5501i;
        float fA = y5Var.a(5);
        ArrayList arrayList = this.f5496d;
        if (arrayList.size() >= 1) {
            Path path = new Path();
            path.moveTo(a(((Integer) arrayList.get(0)).intValue()), b(((Integer) arrayList.get(0)).intValue()));
            for (int i3 = 1; i3 < arrayList.size(); i3++) {
                path.lineTo(a(((Integer) arrayList.get(i3)).intValue()), b(((Integer) arrayList.get(i3)).intValue()));
            }
            if (this.f5499g) {
                float f3 = this.f5497e;
                if (f3 >= 0.0f) {
                    path.lineTo(f3, this.f5498f);
                }
            }
            if (arrayList.size() >= 2 || this.f5499g) {
                canvas.drawPath(path, this.f5495c);
            }
        }
        for (int i4 = 1; i4 <= 9; i4++) {
            if (arrayList.contains(Integer.valueOf(i4))) {
                float fA2 = a(i4);
                float fB = b(i4);
                float fA3 = y5Var.a(11);
                Paint paint = this.f5494b;
                canvas.drawCircle(fA2, fB, fA3, paint);
                canvas.drawCircle(a(i4), b(i4), y5Var.a(6), paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(a(i4), b(i4), y5Var.a(6), paint);
                paint.setStyle(Paint.Style.STROKE);
            } else {
                canvas.drawCircle(a(i4), b(i4), fA, this.f5493a);
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f5496d;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f5499g = false;
                this.f5497e = -1.0f;
                this.f5498f = -1.0f;
                invalidate();
                if (arrayList.size() < 4 || this.f5500h == null) {
                    postDelayed(new a2.b(24, this), 200L);
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (i3 > 0) {
                        sb.append(',');
                    }
                    sb.append(arrayList.get(i3));
                }
                postDelayed(new a2.h(this, sb.toString(), 25), 260L);
                return true;
            }
            if (actionMasked == 3) {
                this.f5499g = false;
                arrayList.clear();
                this.f5497e = -1.0f;
                this.f5498f = -1.0f;
                invalidate();
                return true;
            }
        } else {
            arrayList.clear();
            this.f5499g = true;
        }
        this.f5497e = motionEvent.getX();
        float y2 = motionEvent.getY();
        this.f5498f = y2;
        float f3 = this.f5497e;
        float width = (getWidth() / 3.0f) * 0.42f;
        int i4 = 1;
        while (true) {
            if (i4 > 9) {
                i4 = -1;
                break;
            }
            float fA = f3 - a(i4);
            float fB = y2 - b(i4);
            if ((fB * fB) + (fA * fA) <= width * width) {
                break;
            }
            i4++;
        }
        if (i4 > 0 && !arrayList.contains(Integer.valueOf(i4))) {
            arrayList.add(Integer.valueOf(i4));
        }
        invalidate();
        return true;
    }
}
