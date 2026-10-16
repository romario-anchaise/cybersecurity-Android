// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f4645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4646i;

    public n8(int i3, int i4, int i5, int i6, int i7, int i8, String str, long j3) {
        this.f4638a = i3;
        this.f4639b = i4;
        this.f4640c = i5;
        this.f4641d = i6;
        this.f4642e = i7;
        this.f4643f = i8;
        this.f4644g = str;
        this.f4645h = b(str);
        this.f4646i = Math.max(0L, j3);
    }

    public static float b(String str) {
        if ("viewId".equals(str)) {
            return 0.95f;
        }
        if ("className".equals(str)) {
            return 0.85f;
        }
        if ("systemUiSquare".equals(str)) {
            return 0.82f;
        }
        if ("clickableSquare".equals(str)) {
            return 0.65f;
        }
        if ("cached".equals(str)) {
            return 0.55f;
        }
        return "approx".equals(str) ? 0.4f : 0.0f;
    }

    public static n8 c(int i3, int i4, int i5, int i6, int i7, int i8, String str, long j3) {
        if (i7 <= 0 || i8 <= 0 || i3 < 0 || i4 < 0 || i5 <= i3 || i6 <= i4 || i5 > i7 || i6 > i8 || b(str) <= 0.0f) {
            return null;
        }
        return new n8(i3, i4, i5, i6, i7, i8, str, j3);
    }

    public static String d(float f3) {
        return String.format(Locale.US, "%.6f", Float.valueOf(f3)).replaceAll("0+$", "").replaceAll("\\.$", "");
    }

    public static boolean e(int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i5 - i3;
        int i10 = i6 - i4;
        if (i7 > 0 && i8 > 0 && i9 > 0 && i10 > 0 && Math.max(i9, i10) / Math.min(i9, i10) <= 1.35f) {
            float f3 = i9;
            float f4 = i7;
            if (f3 >= 0.45f * f4 && f3 <= f4 * 0.9f) {
                float f5 = i10;
                float f6 = i8;
                if (f5 >= 0.18f * f6 && f5 <= 0.55f * f6 && i4 >= 0.25f * f6 && i6 <= f6 * 0.92f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(StringBuilder sb) {
        sb.append(",\"pattern\":{\"bounds\":[");
        int i3 = this.f4638a;
        sb.append(i3);
        sb.append(',');
        int i4 = this.f4639b;
        sb.append(i4);
        sb.append(',');
        int i5 = this.f4640c;
        sb.append(i5);
        sb.append(',');
        int i6 = this.f4641d;
        sb.append(i6);
        sb.append("],\"points\":[");
        float f3 = (i5 - i3) / 3.0f;
        float f4 = (i6 - i4) / 3.0f;
        for (int i7 = 0; i7 < 3; i7++) {
            for (int i8 = 0; i8 < 3; i8++) {
                if (i7 != 0 || i8 != 0) {
                    sb.append(',');
                }
                float f5 = (((i8 + 0.5f) * f3) + i3) / this.f4642e;
                float f6 = (((i7 + 0.5f) * f4) + i4) / this.f4643f;
                sb.append('[');
                sb.append(d(f5));
                sb.append(',');
                sb.append(d(f6));
                sb.append(']');
            }
        }
        sb.append("],\"source\":\"");
        sb.append(this.f4644g);
        sb.append("\",\"confidence\":");
        sb.append(d(this.f4645h));
        sb.append(",\"ageMs\":");
        sb.append(this.f4646i);
        sb.append('}');
    }
}
