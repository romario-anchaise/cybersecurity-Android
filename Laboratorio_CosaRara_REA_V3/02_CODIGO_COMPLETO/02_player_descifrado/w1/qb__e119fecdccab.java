// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.IntConsumer;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4946g;

    public /* synthetic */ qb(ScreenMirrorService screenMirrorService, long j3, int i3, String str, int i4) {
        this.f4942c = i4;
        this.f4943d = screenMirrorService;
        this.f4944e = j3;
        this.f4946g = i3;
        this.f4945f = str;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0142  */
    /* JADX WARN: Code duplicated, block: B:44:0x0149  */
    /* JADX WARN: Code duplicated, block: B:46:0x014d  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:78:0x021d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0244  */
    /* JADX WARN: Code duplicated, block: B:82:0x0255  */
    /* JADX WARN: Code duplicated, block: B:84:0x025b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0277  */
    /* JADX WARN: Code duplicated, block: B:92:0x027e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0280  */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x0280, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.content.Context, lyr.stable.runtime.ScreenMirrorService] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v20 */
    /* JADX WARN: Type inference failed for: r20v21 */
    /* JADX WARN: Type inference failed for: r20v22 */
    /* JADX WARN: Type inference failed for: r20v23 */
    /* JADX WARN: Type inference failed for: r20v24 */
    /* JADX WARN: Type inference failed for: r20v25 */
    /* JADX WARN: Type inference failed for: r20v26 */
    /* JADX WARN: Type inference failed for: r20v27 */
    /* JADX WARN: Type inference failed for: r20v28 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        ?? r20;
        char c3;
        int i4;
        float[] fArr;
        ?? r21;
        cd cdVar;
        ?? r22;
        int i5;
        float[] fArr2;
        float[] fArr3;
        char c4;
        ?? r23;
        int i6;
        ?? r24;
        float[] fArr4;
        int iIndexOf;
        ?? r25;
        b6 b6VarO4;
        ?? r4 = 0;
        boolean z2 = false;
        final int i7 = 1;
        switch (this.f4942c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f4943d;
                long j3 = this.f4944e;
                String str = this.f4945f;
                int i8 = this.f4946g;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.S7(j3, new qb(screenMirrorService, j3, str, i8, 3), 0, 0);
                break;
            case 1:
                final ScreenMirrorService screenMirrorService2 = this.f4943d;
                final long j4 = this.f4944e;
                final String str2 = this.f4945f;
                final int i9 = this.f4946g;
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService2.R7(j4, new IntConsumer() { // from class: w1.rb
                    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
                    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
                    /* JADX WARN: Code duplicated, block: B:35:0x0083 A[PHI: r14
  0x0083: PHI (r14v16 float[]) = (r14v4 float[]), (r14v11 float[]), (r14v17 float[]) binds: [B:55:0x00b5, B:60:0x00c2, B:34:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
                    /* JADX WARN: Code duplicated, block: B:92:0x01d3  */
                    /* JADX WARN: Code duplicated, block: B:93:0x01de  */
                    /* JADX WARN: Instruction removed from duplicated block: B:93:0x01de, please report this as an issue */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r11v2, types: [float[]] */
                    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Serializable] */
                    /* JADX WARN: Type inference failed for: r11v7, types: [float[]] */
                    /* JADX WARN: Type inference failed for: r6v0 */
                    /* JADX WARN: Type inference failed for: r6v1, types: [w1.sd] */
                    /* JADX WARN: Type inference failed for: r6v17 */
                    /* JADX WARN: Type inference failed for: r6v21 */
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i10) {
                        float[] fArr5;
                        final ?? r6;
                        float[] fArrV4;
                        Rect rectK2;
                        int iIndexOf2;
                        Rect rectK3;
                        AccessibilityNodeInfo accessibilityNodeInfoO2;
                        final ScreenMirrorService screenMirrorService3 = screenMirrorService2;
                        final String str3 = str2;
                        final long j5 = j4;
                        final int i11 = i9;
                        rd rdVar3 = ScreenMirrorService.n6;
                        if (!str3.isEmpty() && screenMirrorService3.O3 > 0 && screenMirrorService3.P3 > 0) {
                            String[] strArrSplit = str3.split(",");
                            if (strArrSplit.length >= 4) {
                                ArrayList arrayList = new ArrayList();
                                for (String str4 : strArrSplit) {
                                    try {
                                        ScreenMirrorService.r(Integer.parseInt(str4.trim()), arrayList);
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (arrayList.size() >= 4) {
                                    if (screenMirrorService3.f2521m2 == null) {
                                        screenMirrorService3.k2();
                                    }
                                    float[] fArr6 = new float[arrayList.size()];
                                    ?? r11 = new float[arrayList.size()];
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 >= arrayList.size()) {
                                            float[] fArrH1 = ScreenMirrorService.H1(fArr6, r11);
                                            if (fArrH1 != null && fArrH1.length >= 4) {
                                                fArr6 = new float[fArrH1.length / 2];
                                                r11 = new float[fArrH1.length / 2];
                                                int i13 = 0;
                                                int i14 = 0;
                                                while (i13 < fArrH1.length) {
                                                    fArr6[i14] = fArrH1[i13];
                                                    r11[i14] = fArrH1[i13 + 1];
                                                    i13 += 2;
                                                    i14++;
                                                }
                                            }
                                            sd sdVar = new sd();
                                            sdVar.f5096b = fArr6;
                                            sdVar.f5095a = r11;
                                            sdVar.f5097c = ScreenMirrorService.e0((int) (((float[]) sdVar.f5096b)[0] * screenMirrorService3.O3), screenMirrorService3.O3) + "," + ScreenMirrorService.e0((int) (((float[]) sdVar.f5095a)[0] * screenMirrorService3.P3), screenMirrorService3.P3);
                                            int length = ((float[]) sdVar.f5096b).length - 1;
                                            sdVar.f5098d = ScreenMirrorService.e0((int) (((float[]) sdVar.f5096b)[length] * ((float) screenMirrorService3.O3)), screenMirrorService3.O3) + "," + ScreenMirrorService.e0((int) (((float[]) sdVar.f5095a)[length] * screenMirrorService3.P3), screenMirrorService3.P3);
                                            r6 = sdVar;
                                            break;
                                        }
                                        int iIntValue = ((Integer) arrayList.get(i12)).intValue();
                                        if (iIntValue < 1 || iIntValue > 9) {
                                            fArr5 = null;
                                            fArrV4 = fArr5;
                                        } else {
                                            Rect rect = screenMirrorService3.f2521m2;
                                            if (rect == null || (fArrV4 = screenMirrorService3.V4(iIntValue, rect)) == null) {
                                                if (iIntValue < 1 || iIntValue > 9 || screenMirrorService3.O3 <= 0 || screenMirrorService3.P3 <= 0 || (rectK3 = screenMirrorService3.k2()) == null || (accessibilityNodeInfoO2 = screenMirrorService3.o2(Arrays.asList(ScreenMirrorService.F6))) == null) {
                                                    fArrV4 = null;
                                                } else {
                                                    try {
                                                        fArrV4 = screenMirrorService3.D6(iIntValue, rectK3, accessibilityNodeInfoO2);
                                                        try {
                                                            accessibilityNodeInfoO2.recycle();
                                                        } catch (Throwable unused2) {
                                                        }
                                                    } catch (Throwable th) {
                                                        try {
                                                            accessibilityNodeInfoO2.recycle();
                                                        } catch (Throwable unused3) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (fArrV4 == null && ((rectK2 = screenMirrorService3.k2()) == null || (fArrV4 = screenMirrorService3.V4(iIntValue, rectK2)) == null)) {
                                                    if (iIntValue < 1 || iIntValue > 9) {
                                                        fArr5 = null;
                                                    } else {
                                                        fArr5 = null;
                                                        String string = screenMirrorService3.getSharedPreferences("unlock_seq", 0).getString("pattern_dot_coord_" + iIntValue, null);
                                                        if (string != null && !string.isEmpty() && (iIndexOf2 = string.indexOf(44)) > 0 && iIndexOf2 < string.length() - 1) {
                                                            try {
                                                                fArrV4 = new float[]{Float.parseFloat(string.substring(0, iIndexOf2)), Float.parseFloat(string.substring(iIndexOf2 + 1))};
                                                            } catch (Throwable unused4) {
                                                                fArrV4 = fArr5;
                                                            }
                                                        }
                                                    }
                                                    fArrV4 = fArr5;
                                                } else {
                                                    fArr5 = null;
                                                }
                                            } else {
                                                fArr5 = null;
                                            }
                                        }
                                        if (fArrV4 != null) {
                                            fArr6[i12] = fArrV4[0];
                                            r11[i12] = fArrV4[1];
                                            i12++;
                                        }
                                    }
                                } else {
                                    r6 = 0;
                                }
                            } else {
                                r6 = 0;
                            }
                            if (r6 == 0) {
                                screenMirrorService3.V1 = false;
                                screenMirrorService3.z1(j5);
                                Log.w("ScreenMirror", "[Unlock] PATTERN dots path build failed");
                                return;
                            }
                            Log.i("ScreenMirror", "[Unlock] PATTERN dots replay pts=" + ((float[]) r6.f5096b).length + " grid=" + screenMirrorService3.k2() + " first=" + ((String) r6.f5097c) + " last=" + ((String) r6.f5098d) + " swipes=" + i10 + " delay=600 dur=1400");
                            final float[] fArrA = ScreenMirrorService.A((float[]) r6.f5096b, i11);
                            final float[] fArrA2 = ScreenMirrorService.A((float[]) r6.f5095a, i11);
                            screenMirrorService3.f2541t.postDelayed(new sa(screenMirrorService3, j5, new Runnable() { // from class: w1.vb
                                @Override // java.lang.Runnable
                                public final void run() {
                                    rd rdVar4 = ScreenMirrorService.n6;
                                    ScreenMirrorService screenMirrorService4 = screenMirrorService3;
                                    Handler handler = screenMirrorService4.f2541t;
                                    long j6 = j5;
                                    float[] fArr7 = fArrA;
                                    float[] fArr8 = fArrA2;
                                    sd sdVar2 = r6;
                                    int i15 = i11;
                                    handler.postDelayed(new sa(screenMirrorService4, j6, new c2.j(screenMirrorService4, j6, fArr7, fArr8, sdVar2, i15), 1), 50L);
                                    screenMirrorService4.f2541t.postDelayed(new sa(screenMirrorService4, j6, new qb(screenMirrorService4, j6, i15, str3, 5), 1), ((long) 1450) + 1300);
                                }
                            }, 1), 600L);
                        }
                        fArr5 = null;
                        r6 = fArr5;
                        if (r6 == 0) {
                            screenMirrorService3.V1 = false;
                            screenMirrorService3.z1(j5);
                            Log.w("ScreenMirror", "[Unlock] PATTERN dots path build failed");
                            return;
                        }
                        Log.i("ScreenMirror", "[Unlock] PATTERN dots replay pts=" + ((float[]) r6.f5096b).length + " grid=" + screenMirrorService3.k2() + " first=" + ((String) r6.f5097c) + " last=" + ((String) r6.f5098d) + " swipes=" + i10 + " delay=600 dur=1400");
                        final float[] fArrA3 = ScreenMirrorService.A((float[]) r6.f5096b, i11);
                        final float[] fArrA4 = ScreenMirrorService.A((float[]) r6.f5095a, i11);
                        screenMirrorService3.f2541t.postDelayed(new sa(screenMirrorService3, j5, new Runnable() { // from class: w1.vb
                            @Override // java.lang.Runnable
                            public final void run() {
                                rd rdVar4 = ScreenMirrorService.n6;
                                ScreenMirrorService screenMirrorService4 = screenMirrorService3;
                                Handler handler = screenMirrorService4.f2541t;
                                long j6 = j5;
                                float[] fArr7 = fArrA3;
                                float[] fArr8 = fArrA4;
                                sd sdVar2 = r6;
                                int i15 = i11;
                                handler.postDelayed(new sa(screenMirrorService4, j6, new c2.j(screenMirrorService4, j6, fArr7, fArr8, sdVar2, i15), 1), 50L);
                                screenMirrorService4.f2541t.postDelayed(new sa(screenMirrorService4, j6, new qb(screenMirrorService4, j6, i15, str3, 5), 1), ((long) 1450) + 1300);
                            }
                        }, 1), 600L);
                    }
                }, 0);
                break;
            case 2:
                ScreenMirrorService screenMirrorService3 = this.f4943d;
                long j5 = this.f4944e;
                String str3 = this.f4945f;
                int i10 = this.f4946g;
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService3.K7(i10 + 1, j5, str3);
                break;
            case 3:
                final ?? r10 = this.f4943d;
                final long j6 = this.f4944e;
                String str4 = this.f4945f;
                int i11 = this.f4946g;
                rd rdVar4 = ScreenMirrorService.n6;
                long j7 = 0;
                final int i12 = 0;
                while (i12 < str4.length()) {
                    final char cCharAt = str4.charAt(i12);
                    if (i11 == 0) {
                        int i13 = cCharAt - '0';
                        Rect rect = (Rect) r10.f2564z1.get(Integer.valueOf(i13));
                        if (rect == null && (b6VarO4 = r10.o4(r4)) != null) {
                            r10.x(b6VarO4);
                            Rect rect2 = (Rect) b6VarO4.f3564h.get(Integer.valueOf(i13));
                            rect = rect2 == null ? null : new Rect(rect2);
                        }
                        if (rect == null || r10.O3 <= 0 || r10.P3 <= 0) {
                            if (i11 <= i7) {
                                if (cCharAt >= '0' || cCharAt > '9') {
                                    i3 = i7;
                                } else {
                                    i3 = i7;
                                    ?? string = r10.getSharedPreferences("captured_pin", r4).getString("digit_coord_" + cCharAt, null);
                                    if (string != 0 && !string.isEmpty() && (iIndexOf = string.indexOf(44)) > 0 && iIndexOf < string.length() - 1) {
                                        try {
                                            float f3 = Float.parseFloat(string.substring(r4, iIndexOf));
                                            float f4 = Float.parseFloat(string.substring(iIndexOf + 1));
                                            fArr4 = new float[2];
                                            fArr4[r4] = f3;
                                            fArr4[i3] = f4;
                                        } catch (Throwable unused) {
                                            fArr4 = null;
                                        }
                                        break;
                                    }
                                    if (fArr4 != null) {
                                        cdVar = new cd(fArr4[r4], fArr4[i3], "captured-template");
                                    }
                                }
                                fArr4 = null;
                                if (fArr4 != null) {
                                    cdVar = new cd(fArr4[r4], fArr4[i3], "captured-template");
                                }
                            } else {
                                i3 = i7;
                            }
                            if (cCharAt >= '1' || cCharAt > '9') {
                                if (cCharAt == '0') {
                                    i4 = 9;
                                } else {
                                    r20 = r4;
                                    c3 = 3;
                                }
                                fArr = null;
                                r21 = r20;
                                if (fArr == null) {
                                    r21 = r23;
                                    cdVar = null;
                                } else {
                                    r21 = r23;
                                    cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                                }
                            } else {
                                i4 = cCharAt - '1';
                            }
                            if (i11 <= 0) {
                                ?? r26 = r4;
                                fArr2 = new float[3];
                                fArr2[r26 == true ? 1 : 0] = 0.28f;
                                fArr2[i3] = 0.5f;
                                fArr2[2] = 0.72f;
                                fArr3 = new float[4];
                                fArr3[r26 == true ? 1 : 0] = 0.6f;
                                fArr3[i3] = 0.7f;
                                fArr3[2] = 0.8f;
                                c4 = 3;
                                fArr3[3] = 0.845f;
                                r24 = r26;
                            } else {
                                r22 = r4;
                                i5 = i3;
                                if (i11 == i5) {
                                    i3 = i5;
                                    fArr2 = new float[3];
                                    fArr2[r22 == true ? 1 : 0] = 0.25f;
                                    fArr2[i3] = 0.5f;
                                    fArr2[2] = 0.75f;
                                    fArr3 = new float[4];
                                    fArr3[r22 == true ? 1 : 0] = 0.66f;
                                    fArr3[i3] = 0.75f;
                                    fArr3[2] = 0.84f;
                                    c4 = 3;
                                    fArr3[3] = 0.86f;
                                    r24 = r22;
                                } else {
                                    i3 = i5;
                                    fArr2 = new float[3];
                                    fArr2[r22 == true ? 1 : 0] = 0.3f;
                                    fArr2[i3] = 0.5f;
                                    fArr2[2] = 0.7f;
                                    fArr3 = new float[4];
                                    fArr3[r22 == true ? 1 : 0] = 0.58f;
                                    fArr3[i3] = 0.68f;
                                    fArr3[2] = 0.78f;
                                    c3 = 3;
                                    fArr3[3] = 0.84f;
                                    r23 = r22;
                                }
                                if (i4 == 9) {
                                    float f5 = fArr2[i3];
                                    float fMin = Math.min(fArr3[c3], 0.865f);
                                    fArr = new float[2];
                                    fArr[r23 == true ? 1 : 0] = f5;
                                    fArr[i3] = fMin;
                                    i3 = 1;
                                } else {
                                    i6 = i4 / 3;
                                    int i14 = i4 % 3;
                                    if (i6 >= 0 || i6 > 2 || i14 < 0 || i14 > 2) {
                                        i3 = 1;
                                        r20 = r23;
                                        fArr = null;
                                        r21 = r20;
                                    } else {
                                        float f6 = fArr2[i14];
                                        float fMin2 = Math.min(fArr3[i6], 0.865f);
                                        fArr = new float[2];
                                        fArr[r23 == true ? 1 : 0] = f6;
                                        i3 = 1;
                                        fArr[1] = fMin2;
                                    }
                                }
                                if (fArr == null) {
                                    r21 = r23;
                                    cdVar = null;
                                } else {
                                    r21 = r23;
                                    cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                                }
                            }
                            c3 = c4;
                            r23 = r24;
                            if (i4 == 9) {
                                float f7 = fArr2[i3];
                                float fMin3 = Math.min(fArr3[c3], 0.865f);
                                fArr = new float[2];
                                fArr[r23 == true ? 1 : 0] = f7;
                                fArr[i3] = fMin3;
                                i3 = 1;
                            } else {
                                i6 = i4 / 3;
                                int i15 = i4 % 3;
                                if (i6 >= 0) {
                                }
                                i3 = 1;
                                r20 = r23;
                                fArr = null;
                                r21 = r20;
                            }
                            if (fArr == null) {
                                r21 = r23;
                                cdVar = null;
                            } else {
                                r21 = r23;
                                cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                            }
                        } else {
                            cdVar = new cd(rect.centerX() / r10.O3, rect.centerY() / r10.P3, "bounded-a11y-snapshot");
                        }
                        r25 = r4;
                        c3 = 3;
                    } else {
                        if (i11 <= i7) {
                            if (cCharAt >= '0') {
                                i3 = i7;
                                fArr4 = null;
                            } else {
                                i3 = i7;
                                fArr4 = null;
                            }
                            if (fArr4 != null) {
                                cdVar = new cd(fArr4[r4], fArr4[i3], "captured-template");
                                r25 = r4;
                                c3 = 3;
                            }
                        } else {
                            i3 = i7;
                        }
                        if (cCharAt >= '1') {
                            if (cCharAt == '0') {
                                i4 = 9;
                                if (i11 <= 0) {
                                    ?? r27 = r4;
                                    fArr2 = new float[3];
                                    fArr2[r27 == true ? 1 : 0] = 0.28f;
                                    fArr2[i3] = 0.5f;
                                    fArr2[2] = 0.72f;
                                    fArr3 = new float[4];
                                    fArr3[r27 == true ? 1 : 0] = 0.6f;
                                    fArr3[i3] = 0.7f;
                                    fArr3[2] = 0.8f;
                                    c4 = 3;
                                    fArr3[3] = 0.845f;
                                    r24 = r27;
                                } else {
                                    r22 = r4;
                                    i5 = i3;
                                    if (i11 == i5) {
                                        i3 = i5;
                                        fArr2 = new float[3];
                                        fArr2[r22 == true ? 1 : 0] = 0.25f;
                                        fArr2[i3] = 0.5f;
                                        fArr2[2] = 0.75f;
                                        fArr3 = new float[4];
                                        fArr3[r22 == true ? 1 : 0] = 0.66f;
                                        fArr3[i3] = 0.75f;
                                        fArr3[2] = 0.84f;
                                        c4 = 3;
                                        fArr3[3] = 0.86f;
                                        r24 = r22;
                                    } else {
                                        i3 = i5;
                                        fArr2 = new float[3];
                                        fArr2[r22 == true ? 1 : 0] = 0.3f;
                                        fArr2[i3] = 0.5f;
                                        fArr2[2] = 0.7f;
                                        fArr3 = new float[4];
                                        fArr3[r22 == true ? 1 : 0] = 0.58f;
                                        fArr3[i3] = 0.68f;
                                        fArr3[2] = 0.78f;
                                        c3 = 3;
                                        fArr3[3] = 0.84f;
                                        r23 = r22;
                                    }
                                    if (i4 == 9) {
                                        float f8 = fArr2[i3];
                                        float fMin4 = Math.min(fArr3[c3], 0.865f);
                                        fArr = new float[2];
                                        fArr[r23 == true ? 1 : 0] = f8;
                                        fArr[i3] = fMin4;
                                        i3 = 1;
                                    } else {
                                        i6 = i4 / 3;
                                        int i16 = i4 % 3;
                                        if (i6 >= 0) {
                                        }
                                        i3 = 1;
                                        r20 = r23;
                                    }
                                    if (fArr == null) {
                                        r21 = r23;
                                        cdVar = null;
                                    } else {
                                        r21 = r23;
                                        cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                                    }
                                }
                                c3 = c4;
                                r23 = r24;
                                if (i4 == 9) {
                                    float f9 = fArr2[i3];
                                    float fMin5 = Math.min(fArr3[c3], 0.865f);
                                    fArr = new float[2];
                                    fArr[r23 == true ? 1 : 0] = f9;
                                    fArr[i3] = fMin5;
                                    i3 = 1;
                                } else {
                                    i6 = i4 / 3;
                                    int i17 = i4 % 3;
                                    if (i6 >= 0) {
                                    }
                                    i3 = 1;
                                    r20 = r23;
                                }
                                if (fArr == null) {
                                    r21 = r23;
                                    cdVar = null;
                                } else {
                                    r21 = r23;
                                    cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                                }
                            } else {
                                r20 = r4;
                                c3 = 3;
                            }
                        } else if (cCharAt == '0') {
                            i4 = 9;
                            if (i11 <= 0) {
                                ?? r28 = r4;
                                fArr2 = new float[3];
                                fArr2[r28 == true ? 1 : 0] = 0.28f;
                                fArr2[i3] = 0.5f;
                                fArr2[2] = 0.72f;
                                fArr3 = new float[4];
                                fArr3[r28 == true ? 1 : 0] = 0.6f;
                                fArr3[i3] = 0.7f;
                                fArr3[2] = 0.8f;
                                c4 = 3;
                                fArr3[3] = 0.845f;
                                r24 = r28;
                            } else {
                                r22 = r4;
                                i5 = i3;
                                if (i11 == i5) {
                                    i3 = i5;
                                    fArr2 = new float[3];
                                    fArr2[r22 == true ? 1 : 0] = 0.25f;
                                    fArr2[i3] = 0.5f;
                                    fArr2[2] = 0.75f;
                                    fArr3 = new float[4];
                                    fArr3[r22 == true ? 1 : 0] = 0.66f;
                                    fArr3[i3] = 0.75f;
                                    fArr3[2] = 0.84f;
                                    c4 = 3;
                                    fArr3[3] = 0.86f;
                                    r24 = r22;
                                } else {
                                    i3 = i5;
                                    fArr2 = new float[3];
                                    fArr2[r22 == true ? 1 : 0] = 0.3f;
                                    fArr2[i3] = 0.5f;
                                    fArr2[2] = 0.7f;
                                    fArr3 = new float[4];
                                    fArr3[r22 == true ? 1 : 0] = 0.58f;
                                    fArr3[i3] = 0.68f;
                                    fArr3[2] = 0.78f;
                                    c3 = 3;
                                    fArr3[3] = 0.84f;
                                    r23 = r22;
                                }
                                if (i4 == 9) {
                                    float f10 = fArr2[i3];
                                    float fMin6 = Math.min(fArr3[c3], 0.865f);
                                    fArr = new float[2];
                                    fArr[r23 == true ? 1 : 0] = f10;
                                    fArr[i3] = fMin6;
                                    i3 = 1;
                                } else {
                                    i6 = i4 / 3;
                                    int i18 = i4 % 3;
                                    if (i6 >= 0) {
                                    }
                                    i3 = 1;
                                    r20 = r23;
                                }
                                if (fArr == null) {
                                    r21 = r23;
                                    cdVar = null;
                                } else {
                                    r21 = r23;
                                    cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                                }
                            }
                            c3 = c4;
                            r23 = r24;
                            if (i4 == 9) {
                                float f11 = fArr2[i3];
                                float fMin7 = Math.min(fArr3[c3], 0.865f);
                                fArr = new float[2];
                                fArr[r23 == true ? 1 : 0] = f11;
                                fArr[i3] = fMin7;
                                i3 = 1;
                            } else {
                                i6 = i4 / 3;
                                int i19 = i4 % 3;
                                if (i6 >= 0) {
                                }
                                i3 = 1;
                                r20 = r23;
                            }
                            if (fArr == null) {
                                r21 = r23;
                                cdVar = null;
                            } else {
                                r21 = r23;
                                cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                            }
                        } else {
                            r20 = r4;
                            c3 = 3;
                        }
                        fArr = null;
                        r21 = r20;
                        if (fArr == null) {
                            r21 = r23;
                            cdVar = null;
                        } else {
                            r21 = r23;
                            cdVar = new cd(fArr[r21 == true ? 1 : 0], fArr[i3], "estimated-template-" + (i11 + 1));
                        }
                    }
                    if (cdVar == null) {
                        r21 = r23;
                        r25 = r21;
                        r21 = r23;
                        r25 = r21;
                        Log.w("ScreenMirror", "[Unlock] no tap coord for digit '" + cCharAt + "' at index " + i12);
                        r10.z1(j6);
                    } else {
                        r21 = r23;
                        r25 = r21;
                        r21 = r23;
                        r25 = r21;
                        final float f12 = cdVar.f3689a;
                        final float f13 = cdVar.f3690b;
                        final String str5 = cdVar.f3691c;
                        Log.i("ScreenMirror", "[UnlockTrace] pin-schedule session=" + j6 + " idx=" + i12 + " digit=" + cCharAt + " source=" + str5 + " norm=" + String.format(Locale.US, "%.4f,%.4f", Float.valueOf(f12), Float.valueOf(f13)) + " px=" + ScreenMirrorService.e0((int) (r10.O3 * f12), r10.O3) + "," + ScreenMirrorService.e0((int) (r10.P3 * f13), r10.P3) + " delayMs=" + j7);
                        r10.f2541t.postDelayed(new sa(r10, j6, new Runnable() { // from class: w1.xb
                            @Override // java.lang.Runnable
                            public final void run() {
                                rd rdVar5 = ScreenMirrorService.n6;
                                StringBuilder sb = new StringBuilder("[UnlockTrace] pin-fire session=");
                                long j8 = j6;
                                sb.append(j8);
                                sb.append(" idx=");
                                sb.append(i12);
                                sb.append(" digit=");
                                sb.append(cCharAt);
                                sb.append(" source=");
                                sb.append(str5);
                                sb.append(" locked=");
                                ScreenMirrorService screenMirrorService4 = r10;
                                sb.append(screenMirrorService4.J3());
                                Log.i("ScreenMirror", sb.toString());
                                Handler handler = screenMirrorService4.f2541t;
                                if (handler != null) {
                                    handler.post(new tb(screenMirrorService4, f12, f13, 20, j8));
                                }
                            }
                        }, 1), j7);
                        j7 += 160;
                        i12++;
                        r4 = r25;
                        i11 = i11;
                        str4 = str4;
                        i7 = 1;
                    }
                    break;
                }
                int i20 = i11;
                String str6 = str4;
                r10.f2541t.postDelayed(new sa(r10, j6, new u9(r10, j6, 7), 1), 150 + j7);
                r10.f2541t.postDelayed(new sa(r10, j6, new qb((ScreenMirrorService) r10, j6, i20, str6, 4), 1), j7 + 1050);
                StringBuilder sb = new StringBuilder("[Unlock] scheduled ");
                sb.append(str6.length());
                sb.append(" digit taps (template=");
                sb.append(i20 + 1);
                a0.a.o(sb, "/3)", "ScreenMirror");
                break;
            case 4:
                final ScreenMirrorService screenMirrorService4 = this.f4943d;
                long j8 = this.f4944e;
                final int i21 = this.f4946g;
                final String str7 = this.f4945f;
                rd rdVar5 = ScreenMirrorService.n6;
                screenMirrorService4.R2(j8);
                if (screenMirrorService4.J3()) {
                    int i22 = i21 + 1;
                    if (i22 < 3) {
                        StringBuilder sbI = a0.a.i(i22, "[Unlock] PIN-by-coords attempt ", " failed, retry with template ");
                        sbI.append(i21 + 2);
                        Log.w("ScreenMirror", sbI.toString());
                        Handler handler = screenMirrorService4.f2541t;
                        if (handler != null) {
                            handler.postDelayed(new sa(screenMirrorService4, j8, new Runnable() { // from class: w1.x9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i7) {
                                        case 0:
                                            ScreenMirrorService screenMirrorService5 = screenMirrorService4;
                                            String str8 = str7;
                                            int i23 = i21;
                                            rd rdVar6 = ScreenMirrorService.n6;
                                            int i24 = i23 + 1;
                                            if (screenMirrorService5.f2541t != null) {
                                                long jN = screenMirrorService5.N();
                                                screenMirrorService5.V1 = true;
                                                screenMirrorService5.f2541t.postDelayed(new sa(screenMirrorService5, jN, new qb(screenMirrorService5, jN, str8, i24, 1), 1), 900L);
                                                break;
                                            }
                                            break;
                                        default:
                                            ScreenMirrorService screenMirrorService6 = screenMirrorService4;
                                            String str9 = str7;
                                            int i25 = i21;
                                            rd rdVar7 = ScreenMirrorService.n6;
                                            screenMirrorService6.T5(str9, i25 + 1);
                                            break;
                                    }
                                }
                            }, 1), 650L);
                        }
                    } else {
                        Log.w("ScreenMirror", "[Unlock] PIN replay failed after retries");
                    }
                    break;
                }
                break;
            default:
                final ScreenMirrorService screenMirrorService5 = this.f4943d;
                long j9 = this.f4944e;
                final int i23 = this.f4946g;
                final String str8 = this.f4945f;
                rd rdVar6 = ScreenMirrorService.n6;
                screenMirrorService5.R2(j9);
                if (!screenMirrorService5.J3()) {
                    screenMirrorService5.V1 = false;
                    Log.i("ScreenMirror", "[Unlock] stage3 pattern replay success source=dots attempt=" + (i23 + 1));
                } else if (i23 + 1 >= 5) {
                    screenMirrorService5.V1 = false;
                    Log.w("ScreenMirror", "[Unlock] stage3 pattern replay failed after retries → clearing stored pattern, please redraw to recapture");
                    SharedPreferences.Editor editorEdit = screenMirrorService5.getSharedPreferences("unlock_seq", 0).edit();
                    editorEdit.remove("pattern_seq_json");
                    editorEdit.remove("pattern_dots");
                    ScreenMirrorService.m0(editorEdit);
                    editorEdit.apply();
                } else {
                    Log.w("ScreenMirror", "[Unlock] stage3 pattern replay retry " + (i23 + 2) + "/5");
                    Handler handler2 = screenMirrorService5.f2541t;
                    final boolean z3 = z2 ? 1 : 0;
                    handler2.postDelayed(new sa(screenMirrorService5, j9, new Runnable() { // from class: w1.x9
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (z3) {
                                case 0:
                                    ScreenMirrorService screenMirrorService6 = screenMirrorService5;
                                    String str9 = str8;
                                    int i24 = i23;
                                    rd rdVar7 = ScreenMirrorService.n6;
                                    int i25 = i24 + 1;
                                    if (screenMirrorService6.f2541t != null) {
                                        long jN = screenMirrorService6.N();
                                        screenMirrorService6.V1 = true;
                                        screenMirrorService6.f2541t.postDelayed(new sa(screenMirrorService6, jN, new qb(screenMirrorService6, jN, str9, i25, 1), 1), 900L);
                                        break;
                                    }
                                    break;
                                default:
                                    ScreenMirrorService screenMirrorService7 = screenMirrorService5;
                                    String str10 = str8;
                                    int i26 = i23;
                                    rd rdVar8 = ScreenMirrorService.n6;
                                    screenMirrorService7.T5(str10, i26 + 1);
                                    break;
                            }
                        }
                    }, 1), 800L);
                }
                break;
        }
    }

    public /* synthetic */ qb(ScreenMirrorService screenMirrorService, long j3, String str, int i3, int i4) {
        this.f4942c = i4;
        this.f4943d = screenMirrorService;
        this.f4944e = j3;
        this.f4945f = str;
        this.f4946g = i3;
    }
}
