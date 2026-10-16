// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j8 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4347c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q.c f4348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dc f4349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i8 f4351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f4352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4353i;

    public j8(q.c cVar, dc dcVar) {
        this.f4348d = cVar;
        this.f4349e = dcVar;
    }

    public static boolean B(int i3) {
        int type = Character.getType(i3);
        if (type == 6 || type == 8 || type == 7) {
            return true;
        }
        if (i3 >= 65024 && i3 <= 65039) {
            return true;
        }
        if (i3 >= 917760 && i3 <= 917999) {
            return true;
        }
        if (i3 < 127995 || i3 > 127999) {
            return i3 >= 917536 && i3 <= 917631;
        }
        return true;
    }

    public final boolean A(i8 i8Var) {
        return !this.f4353i && this.f4351g == i8Var && this.f4350f == i8Var.f4267a;
    }

    public final boolean C(String str, boolean z2, boolean z3) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        synchronized (this.f4347c) {
            try {
                if (this.f4353i) {
                    return false;
                }
                this.f4350f++;
                w();
                i8 i8Var = new i8(this.f4350f, str, z2, z3);
                this.f4351g = i8Var;
                h8 h8Var = new h8(this, i8Var, 0);
                this.f4352h = h8Var;
                this.f4348d.f3005a.post(h8Var);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0154 A[Catch: all -> 0x0176, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0176, blocks: (B:23:0x003c, B:32:0x005c, B:35:0x0068, B:38:0x0070, B:39:0x0072, B:71:0x00c1, B:72:0x00de, B:80:0x00eb, B:82:0x00ff, B:83:0x0103, B:84:0x0105, B:100:0x0140, B:105:0x0154, B:108:0x0160, B:110:0x0162, B:115:0x0169, B:116:0x016a, B:119:0x0171, B:73:0x00df, B:75:0x00e5, B:79:0x00ea, B:40:0x0073, B:42:0x0079, B:46:0x007f, B:48:0x0083, B:50:0x008b, B:60:0x00a4, B:61:0x00a7, B:64:0x00ad, B:55:0x0096, B:58:0x009e, B:70:0x00c0, B:65:0x00b0, B:67:0x00b6, B:111:0x0163, B:112:0x0166, B:85:0x0106, B:87:0x010c, B:91:0x0110, B:96:0x0123, B:98:0x013d, B:97:0x012d), top: B:142:0x003c, inners: #5, #9, #10 }] */
    public final void D(i8 i8Var) {
        jc jcVar;
        String string;
        synchronized (this.f4347c) {
            try {
                if (A(i8Var)) {
                    this.f4352h = null;
                    ScreenMirrorService screenMirrorService = this.f4349e.f3821a;
                    rd rdVar = ScreenMirrorService.n6;
                    AccessibilityNodeInfo accessibilityNodeInfoF2 = screenMirrorService.F2();
                    if (accessibilityNodeInfoF2 == null) {
                        jcVar = null;
                    } else {
                        String strX7 = ScreenMirrorService.x7(accessibilityNodeInfoF2);
                        CharSequence packageName = accessibilityNodeInfoF2.getPackageName();
                        jcVar = new jc(strX7, packageName == null ? "" : packageName.toString(), accessibilityNodeInfoF2);
                    }
                    try {
                        if (jcVar == null) {
                            y(i8Var);
                            return;
                        }
                        try {
                            try {
                                AccessibilityNodeInfo accessibilityNodeInfo = jcVar.f4368e;
                                try {
                                    if (accessibilityNodeInfo.refresh() && accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocused() && jcVar.f4367d.contentEquals(accessibilityNodeInfo.getPackageName())) {
                                        String str = jcVar.f4366c;
                                        String str2 = jcVar.f4367d;
                                        if (str.isEmpty() || str2 == null || str2.isEmpty()) {
                                            y(i8Var);
                                        } else {
                                            synchronized (this.f4347c) {
                                                try {
                                                    if (A(i8Var)) {
                                                        String str3 = i8Var.f4273g;
                                                        if (str3 == null) {
                                                            i8Var.f4273g = str;
                                                            i8Var.f4274h = str2;
                                                            if (i8Var.f4270d) {
                                                                AccessibilityNodeInfo accessibilityNodeInfo2 = jcVar.f4368e;
                                                                try {
                                                                    if (accessibilityNodeInfo2.isShowingHintText()) {
                                                                        string = "";
                                                                    } else {
                                                                        CharSequence text = accessibilityNodeInfo2.getText();
                                                                        string = text == null ? null : text.toString();
                                                                    }
                                                                } catch (Throwable unused) {
                                                                }
                                                                if (string == null) {
                                                                    z(i8Var);
                                                                } else {
                                                                    i8Var.f4275i = string;
                                                                }
                                                            }
                                                        } else {
                                                            if (str3.equals(str)) {
                                                                if (!i8Var.f4274h.equals(str2)) {
                                                                }
                                                            }
                                                            z(i8Var);
                                                        }
                                                        boolean zPerformAction = false;
                                                        String strConcat = i8Var.f4275i.concat(i8Var.f4268b.substring(0, ((Integer) i8Var.f4269c.get(i8Var.f4272f)).intValue()));
                                                        synchronized (this.f4347c) {
                                                            try {
                                                                if (A(i8Var)) {
                                                                    Bundle bundle = new Bundle();
                                                                    bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", strConcat);
                                                                    if (jcVar.f4368e.performAction(2097152, bundle)) {
                                                                        synchronized (this.f4347c) {
                                                                            try {
                                                                                if (A(i8Var)) {
                                                                                    int i3 = 1;
                                                                                    int i4 = i8Var.f4272f + 1;
                                                                                    i8Var.f4272f = i4;
                                                                                    boolean z2 = i4 == i8Var.f4269c.size();
                                                                                    if (z2) {
                                                                                        this.f4351g = null;
                                                                                        this.f4350f++;
                                                                                    } else {
                                                                                        h8 h8Var = new h8(this, i8Var, i3);
                                                                                        this.f4352h = h8Var;
                                                                                        this.f4348d.f3005a.postDelayed(h8Var, 100L);
                                                                                    }
                                                                                    if (z2) {
                                                                                        if (i8Var.f4271e) {
                                                                                            try {
                                                                                                zPerformAction = jcVar.f4368e.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER.getId());
                                                                                            } catch (Throwable unused2) {
                                                                                            }
                                                                                            if (zPerformAction) {
                                                                                                ScreenMirrorService screenMirrorService2 = this.f4349e.f3821a;
                                                                                                rd rdVar2 = ScreenMirrorService.n6;
                                                                                                screenMirrorService2.a6(true);
                                                                                            }
                                                                                        } else {
                                                                                            ScreenMirrorService screenMirrorService3 = this.f4349e.f3821a;
                                                                                            rd rdVar3 = ScreenMirrorService.n6;
                                                                                            screenMirrorService3.a6(true);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th) {
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        y(i8Var);
                                                                    }
                                                                }
                                                            } catch (Throwable th2) {
                                                                throw th2;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    throw th3;
                                                }
                                            }
                                        }
                                        jcVar.close();
                                        return;
                                    }
                                    y(i8Var);
                                } catch (Throwable unused3) {
                                }
                            } catch (Throwable unused4) {
                                y(i8Var);
                            }
                            jcVar.close();
                        } catch (Throwable th4) {
                            try {
                                jcVar.close();
                            } catch (Throwable unused5) {
                            }
                            throw th4;
                        }
                    } catch (Throwable unused6) {
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f4347c) {
            try {
                if (this.f4353i) {
                    return;
                }
                this.f4353i = true;
                this.f4350f++;
                this.f4351g = null;
                w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.f4347c) {
            this.f4350f++;
            this.f4351g = null;
            w();
        }
    }

    public final void w() {
        Runnable runnable = this.f4352h;
        if (runnable != null) {
            this.f4348d.f3005a.removeCallbacks(runnable);
        }
        this.f4352h = null;
    }

    public final void y(i8 i8Var) {
        synchronized (this.f4347c) {
            z(i8Var);
        }
    }

    public final void z(i8 i8Var) {
        if (A(i8Var)) {
            this.f4350f++;
            this.f4351g = null;
            w();
        }
    }
}
