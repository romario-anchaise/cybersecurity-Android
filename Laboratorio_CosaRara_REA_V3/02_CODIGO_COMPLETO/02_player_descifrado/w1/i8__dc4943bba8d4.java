// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4275i = "";

    public i8(long j3, String str, boolean z2, boolean z3) {
        this.f4267a = j3;
        this.f4268b = str;
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            int i3 = -1;
            int iCharCount = 0;
            int i4 = 0;
            int i5 = 0;
            while (iCharCount < str.length()) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCharCount > i4 && !j8.B(iCodePointAt) && i3 != 8205 && iCodePointAt != 8205 && ((i3 != 13 || iCodePointAt != 10) && (i3 < 127462 || i3 > 127487 || iCodePointAt < 127462 || iCodePointAt > 127487 || i5 % 2 != 1))) {
                    arrayList.add(Integer.valueOf(iCharCount));
                    i5 = 0;
                    i4 = iCharCount;
                }
                if (iCodePointAt >= 127462 && iCodePointAt <= 127487) {
                    i5++;
                } else if (!j8.B(iCodePointAt) && iCodePointAt != 8205) {
                    i5 = 0;
                }
                iCharCount += Character.charCount(iCodePointAt);
                i3 = iCodePointAt;
            }
            arrayList.add(Integer.valueOf(str.length()));
        }
        this.f4269c = arrayList;
        this.f4270d = z2;
        this.f4271e = z3;
    }
}
