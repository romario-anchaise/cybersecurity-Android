// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4651c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONArray f4653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f4654f;

    public /* synthetic */ nb(ScreenMirrorService screenMirrorService, long j3, JSONArray jSONArray) {
        this.f4652d = screenMirrorService;
        this.f4654f = j3;
        this.f4653e = jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:25:0x0083  */
    /* JADX WARN: Code duplicated, block: B:27:0x0089  */
    /* JADX WARN: Code duplicated, block: B:28:0x008c  */
    /* JADX WARN: Code duplicated, block: B:33:0x009a  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x0105  */
    /* JADX WARN: Code duplicated, block: B:48:0x010e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0060, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        long jMax;
        int length;
        ScreenMirrorService screenMirrorService;
        long j3;
        JSONObject jSONObjectOptJSONObject;
        int i4;
        int iOptInt;
        int i5;
        JSONObject jSONObjectOptJSONObject2;
        long j4;
        long jOptLong;
        JSONObject jSONObjectOptJSONObject3;
        nb nbVar = this;
        int i6 = nbVar.f4651c;
        JSONArray jSONArray = nbVar.f4653e;
        switch (i6) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                ScreenMirrorService screenMirrorService2 = this.f4652d;
                long j5 = this.f4654f;
                screenMirrorService2.S7(j5, new nb(screenMirrorService2, jSONArray, j5), 0, 0);
                break;
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                int i7 = 0;
                int i8 = 0;
                while (i8 < jSONArray.length() && (jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i8)) != null && jSONObjectOptJSONObject3.optInt("k", 0) == 2) {
                    if (!(jSONObjectOptJSONObject3.optInt("k", -1) != 2 ? false : ScreenMirrorService.h4((float) jSONObjectOptJSONObject3.optDouble("x", 0.0d), (float) jSONObjectOptJSONObject3.optDouble("y", 0.0d), (float) jSONObjectOptJSONObject3.optDouble("x2", 0.0d), (float) jSONObjectOptJSONObject3.optDouble("y2", 0.0d), jSONObjectOptJSONObject3.optInt("ms", 280)))) {
                        if (i8 > 0) {
                            Log.i("ScreenMirror", "[Unlock] skip " + i8 + " leading bouncer-opening swipe(s)");
                        }
                        i3 = 0;
                        jMax = 0;
                        while (true) {
                            length = jSONArray.length();
                            screenMirrorService = nbVar.f4652d;
                            j3 = nbVar.f4654f;
                            if (i8 < length) {
                                jSONObjectOptJSONObject = jSONArray.optJSONObject(i8);
                                if (jSONObjectOptJSONObject == null) {
                                    i4 = i8;
                                } else {
                                    i4 = i8;
                                    iOptInt = jSONObjectOptJSONObject.optInt("k", i7);
                                    if (iOptInt != 0 || iOptInt == 1) {
                                        screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new tb(screenMirrorService, j3, (float) jSONObjectOptJSONObject.optDouble("x", 0.0d), (float) jSONObjectOptJSONObject.optDouble("y", 0.0d), jSONObjectOptJSONObject.optInt("ms", 20)), 1), jMax);
                                        i3++;
                                        i5 = i4 + 1;
                                        if (i5 < jSONArray.length()) {
                                            jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i5);
                                            if (jSONObjectOptJSONObject2 != null) {
                                                j4 = 0;
                                                jOptLong = jSONObjectOptJSONObject2.optLong("dt", 0L);
                                            } else {
                                                j4 = 0;
                                                jOptLong = 0;
                                            }
                                            if (jOptLong <= j4) {
                                                jOptLong = 160;
                                            }
                                            jMax += Math.max(50L, Math.min(jOptLong, 130L));
                                        }
                                    }
                                    i8 = i4 + 1;
                                    nbVar = this;
                                    i7 = 0;
                                }
                                i8 = i4 + 1;
                                nbVar = this;
                                i7 = 0;
                            } else if (i3 == 0) {
                                long j6 = jMax + 900;
                                screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new u9(screenMirrorService, j3, 6), 1), j6);
                                StringBuilder sb = new StringBuilder("[Unlock] replay ");
                                sb.append(i3);
                                sb.append(" taps over ~");
                                sb.append(j6);
                                a0.a.o(sb, "ms", "ScreenMirror");
                            } else {
                                Log.w("ScreenMirror", "[Unlock] no tap gestures to replay");
                                screenMirrorService.z1(j3);
                            }
                        }
                    } else {
                        i8++;
                    }
                    break;
                }
                if (i8 > 0) {
                    Log.i("ScreenMirror", "[Unlock] skip " + i8 + " leading bouncer-opening swipe(s)");
                }
                i3 = 0;
                jMax = 0;
                while (true) {
                    length = jSONArray.length();
                    screenMirrorService = nbVar.f4652d;
                    j3 = nbVar.f4654f;
                    if (i8 < length) {
                        jSONObjectOptJSONObject = jSONArray.optJSONObject(i8);
                        if (jSONObjectOptJSONObject == null) {
                            i4 = i8;
                        } else {
                            i4 = i8;
                            iOptInt = jSONObjectOptJSONObject.optInt("k", i7);
                            if (iOptInt != 0) {
                                screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new tb(screenMirrorService, j3, (float) jSONObjectOptJSONObject.optDouble("x", 0.0d), (float) jSONObjectOptJSONObject.optDouble("y", 0.0d), jSONObjectOptJSONObject.optInt("ms", 20)), 1), jMax);
                                i3++;
                                i5 = i4 + 1;
                                if (i5 < jSONArray.length()) {
                                    jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i5);
                                    if (jSONObjectOptJSONObject2 != null) {
                                        j4 = 0;
                                        jOptLong = jSONObjectOptJSONObject2.optLong("dt", 0L);
                                    } else {
                                        j4 = 0;
                                        jOptLong = 0;
                                    }
                                    if (jOptLong <= j4) {
                                        jOptLong = 160;
                                    }
                                    jMax += Math.max(50L, Math.min(jOptLong, 130L));
                                }
                            } else {
                                screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new tb(screenMirrorService, j3, (float) jSONObjectOptJSONObject.optDouble("x", 0.0d), (float) jSONObjectOptJSONObject.optDouble("y", 0.0d), jSONObjectOptJSONObject.optInt("ms", 20)), 1), jMax);
                                i3++;
                                i5 = i4 + 1;
                                if (i5 < jSONArray.length()) {
                                    jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i5);
                                    if (jSONObjectOptJSONObject2 != null) {
                                        j4 = 0;
                                        jOptLong = jSONObjectOptJSONObject2.optLong("dt", 0L);
                                    } else {
                                        j4 = 0;
                                        jOptLong = 0;
                                    }
                                    if (jOptLong <= j4) {
                                        jOptLong = 160;
                                    }
                                    jMax += Math.max(50L, Math.min(jOptLong, 130L));
                                }
                            }
                            i8 = i4 + 1;
                            nbVar = this;
                            i7 = 0;
                        }
                        i8 = i4 + 1;
                        nbVar = this;
                        i7 = 0;
                    } else if (i3 == 0) {
                        long j7 = jMax + 900;
                        screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new u9(screenMirrorService, j3, 6), 1), j7);
                        StringBuilder sb2 = new StringBuilder("[Unlock] replay ");
                        sb2.append(i3);
                        sb2.append(" taps over ~");
                        sb2.append(j7);
                        a0.a.o(sb2, "ms", "ScreenMirror");
                    } else {
                        Log.w("ScreenMirror", "[Unlock] no tap gestures to replay");
                        screenMirrorService.z1(j3);
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ nb(ScreenMirrorService screenMirrorService, JSONArray jSONArray, long j3) {
        this.f4652d = screenMirrorService;
        this.f4653e = jSONArray;
        this.f4654f = j3;
    }
}
