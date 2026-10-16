// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f4034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4037f;

    public a(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f4032a = f2;
        this.f4033b = f3;
        this.f4034c = f4;
        this.f4035d = f5;
        this.f4036e = f6;
        this.f4037f = f7;
    }

    public static a a(int i2) {
        o oVar = o.f4064k;
        float fB = b.b(Color.red(i2));
        float fB2 = b.b(Color.green(i2));
        float fB3 = b.b(Color.blue(i2));
        float[][] fArr = b.f4041d;
        float[] fArr2 = fArr[0];
        float f2 = (fArr2[2] * fB3) + (fArr2[1] * fB2) + (fArr2[0] * fB);
        float[] fArr3 = fArr[1];
        float f3 = (fArr3[2] * fB3) + (fArr3[1] * fB2) + (fArr3[0] * fB);
        float[] fArr4 = fArr[2];
        float f4 = (fB3 * fArr4[2]) + (fB2 * fArr4[1]) + (fB * fArr4[0]);
        float[][] fArr5 = b.f4038a;
        float[] fArr6 = fArr5[0];
        float f5 = (fArr6[2] * f4) + (fArr6[1] * f3) + (fArr6[0] * f2);
        float[] fArr7 = fArr5[1];
        float f6 = (fArr7[2] * f4) + (fArr7[1] * f3) + (fArr7[0] * f2);
        float[] fArr8 = fArr5[2];
        float f7 = (f4 * fArr8[2]) + (f3 * fArr8[1]) + (f2 * fArr8[0]);
        float[] fArr9 = oVar.g;
        float f8 = fArr9[0] * f5;
        float f9 = fArr9[1] * f6;
        float f10 = fArr9[2] * f7;
        float fAbs = Math.abs(f8);
        float f11 = oVar.f4071h;
        float fPow = (float) Math.pow(((double) (fAbs * f11)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f9) * f11)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f10) * f11)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f8) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f9) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f10) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d2 = fSignum3;
        float f12 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d2)) / 11.0f;
        float f13 = ((float) (((double) (fSignum + fSignum2)) - (d2 * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f14)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = fAtan2;
        float f18 = (3.1415927f * f17) / 180.0f;
        float f19 = f16 * oVar.f4066b;
        float f20 = oVar.f4065a;
        float f21 = oVar.f4068d;
        float fPow4 = ((float) Math.pow(f19 / f20, oVar.f4073j * f21)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f22 = f20 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, oVar.f4070f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f17) < 20.14d ? 360.0f + f17 : f17)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * oVar.f4069e) * oVar.f4067c) * ((float) Math.sqrt((f13 * f13) + (f12 * f12)))) / (f15 + 0.305f), 0.9d));
        float fSqrt = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float f23 = oVar.f4072i * fSqrt;
        Math.sqrt((fPow5 * f21) / f22);
        float f24 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f23 * 0.0228f) + 1.0f)) * 43.85965f;
        double d3 = f18;
        return new a(f17, fSqrt, fPow4, f24, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
    }

    public static a b(float f2, float f3, float f4) {
        o oVar = o.f4064k;
        float f5 = oVar.f4068d;
        double d2 = ((double) f2) / 100.0d;
        Math.sqrt(d2);
        float f6 = oVar.f4065a + 4.0f;
        float f7 = oVar.f4072i * f3;
        Math.sqrt(((f3 / ((float) Math.sqrt(d2))) * oVar.f4068d) / f6);
        float f8 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        float fLog = ((float) Math.log((((double) f7) * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (3.1415927f * f4) / 180.0f;
        return new a(f4, f3, f2, f8, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    public final int c(o oVar) {
        float fSqrt;
        float f2 = this.f4033b;
        double d2 = f2;
        float f3 = this.f4034c;
        if (d2 != 0.0d) {
            double d3 = f3;
            if (d3 == 0.0d) {
                fSqrt = 0.0f;
            } else {
                fSqrt = f2 / ((float) Math.sqrt(d3 / 100.0d));
            }
        } else {
            fSqrt = 0.0f;
        }
        float fPow = (float) Math.pow(((double) fSqrt) / Math.pow(1.64d - Math.pow(0.29d, oVar.f4070f), 0.73d), 1.1111111111111112d);
        double d4 = (this.f4032a * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + d4) + 3.8d)) * 0.25f;
        float fPow2 = oVar.f4065a * ((float) Math.pow(((double) f3) / 100.0d, (1.0d / ((double) oVar.f4068d)) / ((double) oVar.f4073j)));
        float f4 = fCos * 3846.1538f * oVar.f4069e * oVar.f4067c;
        float f5 = fPow2 / oVar.f4066b;
        float fSin = (float) Math.sin(d4);
        float fCos2 = (float) Math.cos(d4);
        float f6 = (((0.305f + f5) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (f4 * 23.0f)));
        float f7 = fCos2 * f6;
        float f8 = f6 * fSin;
        float f9 = f5 * 460.0f;
        float f10 = ((288.0f * f8) + ((451.0f * f7) + f9)) / 1403.0f;
        float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
        float f12 = ((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f;
        float fMax = (float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10))));
        float fSignum = Math.signum(f10);
        float f13 = 100.0f / oVar.f4071h;
        float fPow3 = fSignum * f13 * ((float) Math.pow(fMax, 2.380952380952381d));
        float fSignum2 = Math.signum(f11) * f13 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f12) * f13 * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12)))), 2.380952380952381d));
        float[] fArr = oVar.g;
        float f14 = fPow3 / fArr[0];
        float f15 = fSignum2 / fArr[1];
        float f16 = fSignum3 / fArr[2];
        float[][] fArr2 = b.f4039b;
        float[] fArr3 = fArr2[0];
        float f17 = (fArr3[2] * f16) + (fArr3[1] * f15) + (fArr3[0] * f14);
        float[] fArr4 = fArr2[1];
        float f18 = (fArr4[2] * f16) + (fArr4[1] * f15) + (fArr4[0] * f14);
        float[] fArr5 = fArr2[2];
        return p033t.a.a(f17, f18, (f16 * fArr5[2]) + (f15 * fArr5[1]) + (f14 * fArr5[0]));
    }
}
