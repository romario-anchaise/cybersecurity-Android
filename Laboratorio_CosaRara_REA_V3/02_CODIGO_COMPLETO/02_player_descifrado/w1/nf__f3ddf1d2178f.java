// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import com.os9sp.yfwkcq0dwfxaf.R;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class nf extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y3 f4664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f4665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextPaint f4666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f4667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f4668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bitmap f4669f;

    public nf(ScreenMirrorService screenMirrorService, y3 y3Var) {
        super(screenMirrorService);
        TextPaint textPaint = new TextPaint(1);
        this.f4665b = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        this.f4666c = textPaint2;
        Paint paint = new Paint(3);
        this.f4667d = paint;
        this.f4668e = new RectF();
        this.f4664a = y3Var;
        textPaint.setColor(-1);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextSize(TypedValue.applyDimension(2, 18.0f, screenMirrorService.getResources().getDisplayMetrics()));
        textPaint2.setColor(Color.argb(170, 255, 255, 255));
        textPaint2.setTypeface(Typeface.DEFAULT);
        textPaint2.setTextSize(TypedValue.applyDimension(2, 14.0f, screenMirrorService.getResources().getDisplayMetrics()));
        paint.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        paint.setAlpha(Math.round(236.0f));
        this.f4669f = BitmapFactory.decodeResource(screenMirrorService.getResources(), R.drawable.fingerprint_rear);
        setBackgroundColor(0);
        setImportantForAccessibility(4);
    }

    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v5 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: float
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @Override // android.view.View
    public final void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.nf.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        invalidate();
    }
}
