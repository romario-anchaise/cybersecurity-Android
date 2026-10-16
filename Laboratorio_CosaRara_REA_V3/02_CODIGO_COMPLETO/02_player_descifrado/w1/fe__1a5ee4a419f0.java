// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.text.BreakIterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class fe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4055h;

    public fe(String str, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4) {
        this.f4048a = str;
        this.f4049b = i3;
        this.f4050c = i4;
        this.f4051d = i5;
        this.f4052e = i6;
        this.f4053f = z2;
        this.f4054g = z3;
        this.f4055h = z4;
    }

    public static fe a(ud udVar, String str, int i3, int i4, int i5, int i6, boolean z2) {
        int i7;
        int i8;
        int i9 = udVar.f5250b;
        String str2 = udVar.f5254f;
        int i10 = udVar.f5249a;
        int i11 = udVar.f5253e;
        c(i3, i4, str);
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        if (z2 && Math.min(i5, i6) == iMin && Math.max(i5, i6) == iMax) {
            i7 = i5;
            iMax = i6;
        } else {
            i7 = iMin;
        }
        if (i10 != 13) {
            int i12 = -1;
            switch (i10) {
                case 1:
                    break;
                case 2:
                case 3:
                    int iFollowing = iMax;
                    int iPreceding = iMin;
                    if (iPreceding == iFollowing) {
                        BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.ROOT);
                        characterInstance.setText(str);
                        if (i10 == 2) {
                            for (int i13 = 0; i13 < i11; i13++) {
                                if (iPreceding <= 0 || (iPreceding = characterInstance.preceding(iPreceding)) == -1) {
                                    iPreceding = 0;
                                }
                            }
                        } else {
                            for (int i14 = 0; i14 < i11; i14++) {
                                int length = str.length();
                                if (iFollowing >= length || (iFollowing = characterInstance.following(iFollowing)) == -1) {
                                    iFollowing = length;
                                }
                            }
                        }
                    }
                    int i15 = iPreceding;
                    return new fe(str.substring(0, i15).concat(str.substring(iFollowing)), i15, i15, i15, i15, true, true, false);
                case 4:
                    int i16 = iMax;
                    int i17 = i7;
                    if ((i9 & 1) != 0) {
                        return d(i17, b(i16, i11, str), str);
                    }
                    if (iMin != iMax) {
                        if (i11 >= 0) {
                            i8 = iMax;
                        }
                        if (i11 < 0) {
                            i8 = iMin;
                            i12 = 1;
                        }
                        i8 = iMin;
                        i11 += i12;
                    } else {
                        i8 = iMin;
                    }
                    int iB = b(i8, i11, str);
                    return d(iB, iB, str);
                case 5:
                case 6:
                    int i18 = i7;
                    int length2 = i10 != 5 ? str.length() : 0;
                    return (i9 & 1) != 0 ? d(i18, length2, str) : d(length2, length2, str);
                case 7:
                    return new fe(str, iMin, iMax, i7, iMax, false, false, true);
                case 8:
                    return d(0, str.length(), str);
                default:
                    o2.i("unsupported TextEdit operation");
                    return null;
            }
        }
        String str3 = str.substring(0, iMin) + str2 + str.substring(iMax);
        int length3 = str2.length() + iMin;
        return new fe(str3, length3, length3, length3, length3, true, true, false);
    }

    public static int b(int i3, int i4, String str) {
        int iFollowing;
        int iAbs = Math.abs(i4);
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.ROOT);
        characterInstance.setText(str);
        for (int i5 = 0; i5 < iAbs; i5++) {
            if (i4 >= 0) {
                int length = str.length();
                if (i3 < length && (iFollowing = characterInstance.following(i3)) != -1) {
                    length = iFollowing;
                }
                i3 = length;
            } else if (i3 <= 0 || (i3 = characterInstance.preceding(i3)) == -1) {
                i3 = 0;
            }
        }
        return i3;
    }

    public static void c(int i3, int i4, String str) {
        if (i3 < 0 || i4 < 0 || i3 > str.length() || i4 > str.length()) {
            o2.i("invalid TextEdit selection");
            return;
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.ROOT);
        characterInstance.setText(str);
        if (characterInstance.isBoundary(i3) && characterInstance.isBoundary(i4)) {
            return;
        }
        o2.i("invalid TextEdit selection");
    }

    public static fe d(int i3, int i4, String str) {
        return new fe(str, Math.min(i3, i4), Math.max(i3, i4), i3, i4, false, true, false);
    }
}
