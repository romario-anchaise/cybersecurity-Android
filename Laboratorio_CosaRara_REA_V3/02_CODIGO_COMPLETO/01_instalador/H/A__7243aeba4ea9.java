// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class A extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f186b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f185a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f187c = 1.0f;

    public A(q qVar) {
        p028p0.a.a(qVar, "metadata cannot be null");
        this.f186b = qVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        l.a().getClass();
        q qVar = this.f186b;
        x xVar = qVar.f223b;
        Typeface typeface = (Typeface) xVar.f249d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) xVar.f247b, qVar.f222a * 2, 2, f2, i5, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f185a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        q qVar = this.f186b;
        I.a aVarC = qVar.c();
        int iA = aVarC.a(14);
        this.f187c = fAbs / (iA != 0 ? ((ByteBuffer) aVarC.f5d).getShort(iA + aVarC.f2a) : (short) 0);
        I.a aVarC2 = qVar.c();
        int iA2 = aVarC2.a(14);
        if (iA2 != 0) {
            ((ByteBuffer) aVarC2.f5d).getShort(iA2 + aVarC2.f2a);
        }
        I.a aVarC3 = qVar.c();
        int iA3 = aVarC3.a(12);
        short s2 = (short) ((iA3 != 0 ? ((ByteBuffer) aVarC3.f5d).getShort(iA3 + aVarC3.f2a) : (short) 0) * this.f187c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s2;
    }
}
