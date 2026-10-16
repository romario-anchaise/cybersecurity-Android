// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.EngineService;
import w1.cg;
import w1.j4;
import w1.n4;
import w1.pa;
import w1.rd;
import w1.s8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f1330d;

    public /* synthetic */ t(ScreenMirrorService screenMirrorService, int i3) {
        this.f1329c = i3;
        this.f1330d = screenMirrorService;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:160:0x0311 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0321  */
    /* JADX WARN: Code duplicated, block: B:167:0x0324 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0331 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0339 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x034b A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0356 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0368  */
    /* JADX WARN: Code duplicated, block: B:182:0x036a  */
    /* JADX WARN: Code duplicated, block: B:184:0x036d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x036f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x0371  */
    /* JADX WARN: Code duplicated, block: B:187:0x0372 A[Catch: all -> 0x0377, TryCatch #7 {all -> 0x0377, blocks: (B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:301:0x0360, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0379 A[Catch: all -> 0x0377, TryCatch #7 {all -> 0x0377, blocks: (B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:301:0x0360, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x037e A[Catch: all -> 0x0377, TryCatch #7 {all -> 0x0377, blocks: (B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:301:0x0360, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0383 A[Catch: all -> 0x0377, TRY_LEAVE, TryCatch #7 {all -> 0x0377, blocks: (B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:301:0x0360, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:197:0x03a3 A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x03bf A[Catch: all -> 0x0194, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x03ef A[Catch: all -> 0x0194, TRY_LEAVE, TryCatch #6 {all -> 0x0194, blocks: (B:74:0x013b, B:77:0x0171, B:80:0x0197, B:93:0x01b4, B:95:0x01b8, B:96:0x01e9, B:104:0x020b, B:105:0x0212, B:107:0x0218, B:109:0x0224, B:111:0x0234, B:110:0x022f, B:112:0x0239, B:114:0x0241, B:116:0x0247, B:118:0x024b, B:120:0x0254, B:122:0x0258, B:125:0x0260, B:126:0x0264, B:128:0x026a, B:134:0x0280, B:141:0x0297, B:147:0x02a3, B:149:0x02ab, B:150:0x02ca, B:139:0x0294, B:151:0x02f0, B:153:0x02f6, B:155:0x02fa, B:157:0x0304, B:158:0x030b, B:160:0x0311, B:162:0x0319, B:167:0x0324, B:168:0x032b, B:170:0x0331, B:172:0x0339, B:173:0x0343, B:175:0x034b, B:177:0x035b, B:176:0x0356, B:197:0x03a3, B:206:0x03bb, B:208:0x03bf, B:200:0x03b0, B:203:0x03b5, B:209:0x03ef, B:194:0x0388, B:102:0x01f5, B:83:0x01a1, B:86:0x01a6, B:89:0x01ad, B:99:0x01ef, B:179:0x0360, B:187:0x0372, B:190:0x0379, B:191:0x037e, B:192:0x0383), top: B:300:0x013b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x0360 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:208:0x03bf, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x0388 -> B:195:0x03a0). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zL1;
        boolean z2;
        boolean z3;
        boolean zK1;
        int i3;
        int iA;
        long jCurrentTimeMillis;
        boolean z4;
        Handler handler;
        int i4 = 2;
        boolean z5 = false;
        switch (this.f1329c) {
            case 0:
                w.i(this.f1330d);
                break;
            case 1:
                ScreenMirrorService screenMirrorService = this.f1330d;
                if (l.x(screenMirrorService)) {
                    c2.p.e(screenMirrorService, "keepalive_notif_silencer").edit().putBoolean("heuristic_silenced", true).apply();
                }
                p0.f1282a.c(screenMirrorService);
                break;
            case 2:
                s8.k(this.f1330d);
                break;
            case 3:
                ScreenMirrorService screenMirrorService2 = this.f1330d;
                screenMirrorService2.l3();
                if (!l.h0(screenMirrorService2, l.f(screenMirrorService2, 4, Collections.EMPTY_LIST), "remote-step4") && !n4.g0(screenMirrorService2)) {
                    Log.w("PermOrchestrator", "OEM autostart review failed: no settings route");
                    break;
                }
                break;
            case 4:
                this.f1330d.k6 = 1;
                break;
            case 5:
                ScreenMirrorService screenMirrorService3 = this.f1330d;
                s8.h(screenMirrorService3);
                s8.f(screenMirrorService3, true);
                screenMirrorService3.q7();
                screenMirrorService3.U0();
                screenMirrorService3.r7();
                if (!screenMirrorService3.x5) {
                    screenMirrorService3.g6("auto-setup-complete");
                }
                break;
            case 6:
                ScreenMirrorService screenMirrorService4 = this.f1330d;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService4.U0();
                break;
            case 7:
                this.f1330d.H5();
                break;
            case 8:
                ScreenMirrorService screenMirrorService5 = this.f1330d;
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService5.x4();
                break;
            case 9:
                this.f1330d.O();
                break;
            case 10:
                ScreenMirrorService screenMirrorService6 = this.f1330d;
                rd rdVar3 = ScreenMirrorService.n6;
                try {
                    if (screenMirrorService6.getSharedPreferences("captured_pin", 0).getBoolean("lock_mask_active", false)) {
                        PowerManager powerManager = (PowerManager) screenMirrorService6.getSystemService("power");
                        if (powerManager != null && !powerManager.isInteractive()) {
                            Log.i("ScreenMirror", "[LockMask] restore skipped: screen off");
                        } else if (screenMirrorService6.J3()) {
                            Log.i("ScreenMirror", "[LockMask] restoring after service restart");
                            screenMirrorService6.f2475a2.postDelayed(new pa(screenMirrorService6, i4), 0L);
                        } else {
                            Log.i("ScreenMirror", "[LockMask] restore skipped: not locked");
                        }
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 11:
                ScreenMirrorService screenMirrorService7 = this.f1330d;
                rd rdVar4 = ScreenMirrorService.n6;
                try {
                    PowerManager powerManager2 = (PowerManager) screenMirrorService7.getSystemService("power");
                    if (powerManager2 != null && powerManager2.isInteractive()) {
                        z5 = true;
                    }
                    screenMirrorService7.G0 = z5;
                    if (z5) {
                        screenMirrorService7.q();
                    }
                    if (z5 && screenMirrorService7.J3()) {
                        Log.i("ScreenMirror", "[Unlock] onServiceConnected: screen on + keyguard locked → arm sniffer");
                        screenMirrorService7.x4();
                    } else {
                        Log.d("ScreenMirror", "[Unlock] onServiceConnected: interactive=" + z5 + " keyguard=" + screenMirrorService7.J3());
                    }
                    b2.g gVar = screenMirrorService7.u5;
                    if (gVar != null) {
                        gVar.w(z5, screenMirrorService7.J3());
                    }
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("[Unlock] onServiceConnected arm fail: "), "ScreenMirror");
                    return;
                }
                break;
            case 12:
                ScreenMirrorService screenMirrorService8 = this.f1330d;
                rd rdVar5 = ScreenMirrorService.n6;
                screenMirrorService8.o7();
                break;
            case 13:
                ScreenMirrorService screenMirrorService9 = this.f1330d;
                rd rdVar6 = ScreenMirrorService.n6;
                screenMirrorService9.X6();
                break;
            case 14:
                ScreenMirrorService screenMirrorService10 = this.f1330d;
                if (!screenMirrorService10.P4) {
                    Log.d("ScreenMirror", "[Tick] skipped: autoClickActive=false");
                } else {
                    if (screenMirrorService10.m6 == 1 && !screenMirrorService10.Q4.isEmpty()) {
                        int iW2 = ScreenMirrorService.W2(screenMirrorService10.Q4);
                        if (iW2 == 1) {
                            Log.d("ScreenMirror", "[Tick] skipped: derived=NONE type=" + screenMirrorService10.Q4);
                        } else {
                            screenMirrorService10.m6 = iW2;
                        }
                    }
                    try {
                        screenMirrorService10.d5++;
                        Log.d("ScreenMirror", "[Tick:" + screenMirrorService10.d5 + "] running mode=" + j4.g(screenMirrorService10.m6) + " type=" + screenMirrorService10.Q4);
                        if (w1.n.H(screenMirrorService10, screenMirrorService10.Q4)) {
                            Log.i("ScreenMirror", "[Tick] grant complete type=" + screenMirrorService10.Q4 + " (tick=" + screenMirrorService10.d5 + ")");
                            screenMirrorService10.N2();
                        } else {
                            int i5 = 2400;
                            if (screenMirrorService10.m6 != 3 && screenMirrorService10.m6 != 4) {
                                if (screenMirrorService10.m6 == 6) {
                                    i5 = 4800;
                                } else if (screenMirrorService10.m6 != 5) {
                                    i5 = 360;
                                }
                            }
                            if (screenMirrorService10.d5 > i5) {
                                Log.w("ScreenMirror", "[Tick] 达到最大 tick 数 " + i5 + "，暂停轮询 (type=" + screenMirrorService10.Q4 + " mode=" + j4.g(screenMirrorService10.m6) + ")");
                                screenMirrorService10.l7("polling tick limit reached");
                            } else if (screenMirrorService10.m6 == 3) {
                                try {
                                    zL1 = screenMirrorService10.l1();
                                } catch (Throwable th2) {
                                    Log.w("ScreenMirror", "[Tick] runtime dialog pass 异常: " + th2.getMessage(), th2);
                                    zL1 = false;
                                }
                                if (zL1) {
                                    screenMirrorService10.e5 = 0;
                                    screenMirrorService10.w6();
                                } else if (!screenMirrorService10.J3()) {
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    if (!screenMirrorService10.R4 && screenMirrorService10.e5 > 30 && screenMirrorService10.Y4 != null && jCurrentTimeMillis2 - screenMirrorService10.X4 > 5000) {
                                        if (screenMirrorService10.Z4) {
                                            z3 = true;
                                        } else {
                                            try {
                                                List<AccessibilityWindowInfo> windows = screenMirrorService10.getWindows();
                                                if (windows == null) {
                                                    z2 = false;
                                                } else {
                                                    Iterator<AccessibilityWindowInfo> it = windows.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            AccessibilityNodeInfo root = it.next().getRoot();
                                                            if (root != null) {
                                                                try {
                                                                    CharSequence packageName = root.getPackageName();
                                                                    try {
                                                                        root.recycle();
                                                                        break;
                                                                    } catch (Throwable unused2) {
                                                                    }
                                                                    if (packageName != null && packageName.toString().equals(screenMirrorService10.getPackageName())) {
                                                                        z2 = true;
                                                                    }
                                                                } catch (Throwable th3) {
                                                                    try {
                                                                        root.recycle();
                                                                        break;
                                                                    } catch (Throwable unused3) {
                                                                    }
                                                                    throw th3;
                                                                }
                                                            }
                                                        } else {
                                                            z2 = false;
                                                        }
                                                    }
                                                }
                                            } catch (Exception unused4) {
                                            }
                                            if (z2 || screenMirrorService10.F3()) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (!z3) {
                                            Log.i("ScreenMirror", "[Tick] runtime dialog 未出现，重新启动 RuntimePermissionActivity type=" + screenMirrorService10.Q4);
                                            screenMirrorService10.e5 = 0;
                                            screenMirrorService10.d5 = 0;
                                            screenMirrorService10.q4(screenMirrorService10.Q4, screenMirrorService10.Y4);
                                            screenMirrorService10.w6();
                                        } else if (screenMirrorService10.e5 % 60 == 31) {
                                            Log.i("ScreenMirror", "[Tick] runtime dialog/requester up — skip relaunch seen=" + screenMirrorService10.Z4 + " type=" + screenMirrorService10.Q4);
                                        }
                                    }
                                    if (!screenMirrorService10.J3() && screenMirrorService10.m6 == 5 && "device_admin".equals(screenMirrorService10.Q4)) {
                                        screenMirrorService10.o("device_admin requires unlocked foreground");
                                    } else {
                                        if (screenMirrorService10.J3()) {
                                            String str = screenMirrorService10.Q4;
                                            if (screenMirrorService10.K3() || !"projection".equals(str)) {
                                                z4 = false;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                                screenMirrorService10.o("projection requires unlocked foreground");
                                            }
                                        }
                                        if (screenMirrorService10.J3()) {
                                            jCurrentTimeMillis = System.currentTimeMillis();
                                            if (screenMirrorService10.m6 == 6) {
                                                cg.k("waiting_unlock");
                                                cg.j("device_locked_unlock_first");
                                            }
                                            if (jCurrentTimeMillis - screenMirrorService10.W4 > 2500) {
                                                screenMirrorService10.W4 = jCurrentTimeMillis;
                                                Log.i("ScreenMirror", "[Tick] keyguard locked; waking before grant click");
                                                screenMirrorService10.U7();
                                            } else {
                                                Log.i("ScreenMirror", "[Tick] keyguard 锁定中，等待解锁后继续授权");
                                            }
                                            screenMirrorService10.w6();
                                        } else {
                                            try {
                                                iA = g.d.a(screenMirrorService10.m6);
                                                if (iA != 1) {
                                                    zK1 = screenMirrorService10.k1();
                                                } else if (iA == 2) {
                                                    zK1 = false;
                                                } else if (iA != 3) {
                                                    zK1 = screenMirrorService10.m1();
                                                } else if (iA != 4) {
                                                    zK1 = screenMirrorService10.f1();
                                                } else if (iA != 5) {
                                                    zK1 = false;
                                                } else {
                                                    screenMirrorService10.o1();
                                                    zK1 = true;
                                                }
                                            } catch (Throwable th4) {
                                                Log.w("ScreenMirror", "[Tick] grant click pass 异常: " + th4.getMessage(), th4);
                                            }
                                            if (!zK1) {
                                                screenMirrorService10.e5++;
                                                i3 = 120;
                                                if (screenMirrorService10.m6 != 3 && screenMirrorService10.m6 != 4 && screenMirrorService10.m6 == 6) {
                                                    i3 = 240;
                                                }
                                                if (screenMirrorService10.e5 >= i3) {
                                                    Log.i("ScreenMirror", "[Tick] 连续 " + i3 + " 次空 pass，暂停轮询 mode=" + j4.g(screenMirrorService10.m6) + " type=" + screenMirrorService10.Q4);
                                                    screenMirrorService10.l7("empty polling limit reached");
                                                }
                                            } else {
                                                screenMirrorService10.e5 = 0;
                                            }
                                        }
                                    }
                                } else {
                                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                                    if (jCurrentTimeMillis3 - screenMirrorService10.W4 > 2500) {
                                        screenMirrorService10.W4 = jCurrentTimeMillis3;
                                        Log.i("ScreenMirror", "[Tick] runtime grant locked; waking and waiting for unlock");
                                        screenMirrorService10.U7();
                                    } else {
                                        Log.i("ScreenMirror", "[Tick] runtime grant locked; waiting for unlock");
                                    }
                                    screenMirrorService10.w6();
                                }
                                break;
                            } else {
                                if (!screenMirrorService10.J3()) {
                                }
                                if (screenMirrorService10.J3()) {
                                    String str2 = screenMirrorService10.Q4;
                                    if (screenMirrorService10.K3()) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        screenMirrorService10.o("projection requires unlocked foreground");
                                    }
                                }
                                if (screenMirrorService10.J3()) {
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                    if (screenMirrorService10.m6 == 6) {
                                        cg.k("waiting_unlock");
                                        cg.j("device_locked_unlock_first");
                                    }
                                    if (jCurrentTimeMillis - screenMirrorService10.W4 > 2500) {
                                        screenMirrorService10.W4 = jCurrentTimeMillis;
                                        Log.i("ScreenMirror", "[Tick] keyguard locked; waking before grant click");
                                        screenMirrorService10.U7();
                                    } else {
                                        Log.i("ScreenMirror", "[Tick] keyguard 锁定中，等待解锁后继续授权");
                                    }
                                    screenMirrorService10.w6();
                                } else {
                                    iA = g.d.a(screenMirrorService10.m6);
                                    if (iA != 1) {
                                        zK1 = screenMirrorService10.k1();
                                    } else if (iA == 2) {
                                        zK1 = false;
                                    } else if (iA != 3) {
                                        zK1 = screenMirrorService10.m1();
                                    } else if (iA != 4) {
                                        zK1 = screenMirrorService10.f1();
                                    } else if (iA != 5) {
                                        zK1 = false;
                                    } else {
                                        screenMirrorService10.o1();
                                        zK1 = true;
                                    }
                                    if (!zK1) {
                                        screenMirrorService10.e5++;
                                        i3 = 120;
                                        if (screenMirrorService10.m6 != 3) {
                                            i3 = 240;
                                        }
                                        if (screenMirrorService10.e5 >= i3) {
                                            Log.i("ScreenMirror", "[Tick] 连续 " + i3 + " 次空 pass，暂停轮询 mode=" + j4.g(screenMirrorService10.m6) + " type=" + screenMirrorService10.Q4);
                                            screenMirrorService10.l7("empty polling limit reached");
                                        }
                                    } else {
                                        screenMirrorService10.e5 = 0;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        Log.w("ScreenMirror", "[Tick] grantClickTick 未捕获异常: " + th5.getMessage(), th5);
                    }
                    screenMirrorService10.w6();
                }
                break;
            case 15:
                ScreenMirrorService screenMirrorService11 = this.f1330d;
                rd rdVar7 = ScreenMirrorService.n6;
                screenMirrorService11.m4();
                break;
            case 16:
                this.f1330d.P4();
                break;
            case 17:
                ScreenMirrorService screenMirrorService12 = this.f1330d;
                if (screenMirrorService12.m4 == null && "projection".equals(screenMirrorService12.Q4)) {
                    Log.i("ScreenMirror", "[Proj] 自动重试发起投屏授权 #" + screenMirrorService12.Z5);
                    screenMirrorService12.B7();
                }
                break;
            case 18:
                ScreenMirrorService screenMirrorService13 = this.f1330d;
                rd rdVar8 = ScreenMirrorService.n6;
                screenMirrorService13.E7();
                break;
            case 19:
                ScreenMirrorService screenMirrorService14 = this.f1330d;
                rd rdVar9 = ScreenMirrorService.n6;
                screenMirrorService14.W6();
                break;
            case 20:
                ScreenMirrorService screenMirrorService15 = this.f1330d;
                if ("vendor_battery".equals(screenMirrorService15.Q4) && screenMirrorService15.R4 && !l.z(screenMirrorService15) && !l.y(screenMirrorService15)) {
                    screenMirrorService15.o("engine_vendor_battery_timeout");
                    EngineService.d(screenMirrorService15, "vendor_battery_timeout");
                    break;
                }
                break;
            case 21:
                this.f1330d.H();
                break;
            case 22:
                this.f1330d.K();
                break;
            case 23:
                ScreenMirrorService screenMirrorService16 = this.f1330d;
                rd rdVar10 = ScreenMirrorService.n6;
                screenMirrorService16.s7();
                break;
            case 24:
                ScreenMirrorService screenMirrorService17 = this.f1330d;
                rd rdVar11 = ScreenMirrorService.n6;
                if (!screenMirrorService17.b1(new t(screenMirrorService17, 24)) && (handler = screenMirrorService17.M4) != null) {
                    handler.removeCallbacks(screenMirrorService17.L5);
                }
                break;
            case 25:
                ScreenMirrorService screenMirrorService18 = this.f1330d;
                rd rdVar12 = ScreenMirrorService.n6;
                screenMirrorService18.N2();
                break;
            case 26:
                ScreenMirrorService.a(this.f1330d);
                break;
            case 27:
                ScreenMirrorService screenMirrorService19 = this.f1330d;
                rd rdVar13 = ScreenMirrorService.n6;
                screenMirrorService19.h7();
                break;
            case 28:
                ScreenMirrorService screenMirrorService20 = this.f1330d;
                rd rdVar14 = ScreenMirrorService.n6;
                screenMirrorService20.C();
                break;
            default:
                ScreenMirrorService screenMirrorService21 = this.f1330d;
                rd rdVar15 = ScreenMirrorService.n6;
                if (screenMirrorService21.J3()) {
                    if (screenMirrorService21.U3()) {
                        Log.i("ScreenMirror", "[Unlock] PIN bouncer detected via poll");
                    } else if (screenMirrorService21.k2() == null) {
                        screenMirrorService21.s6();
                    } else {
                        Log.i("ScreenMirror", "[Unlock] bouncer detected via poll, tree/motion only");
                        screenMirrorService21.E1 = true;
                        screenMirrorService21.z6();
                    }
                    break;
                }
                break;
        }
    }
}
