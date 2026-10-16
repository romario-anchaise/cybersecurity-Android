// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aa implements l4, g4, p1.a, of {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3491d;

    public /* synthetic */ aa(ScreenMirrorService screenMirrorService, int i3) {
        this.f3490c = i3;
        this.f3491d = screenMirrorService;
    }

    private final String f() {
        r1 r1Var;
        ScreenMirrorService screenMirrorService = this.f3491d;
        synchronized (wf.f5439b) {
            wf.T(screenMirrorService);
            long jCurrentTimeMillis = System.currentTimeMillis();
            r1 r1VarS = wf.S(jCurrentTimeMillis);
            boolean zA = r1VarS.a(jCurrentTimeMillis);
            if (r1VarS.a(jCurrentTimeMillis)) {
                r1Var = r1VarS;
            } else {
                long jMax = Math.max(1L, jCurrentTimeMillis);
                r1Var = new r1(true, jMax, jMax > 9223372036851175807L ? Long.MAX_VALUE : 3600000 + jMax);
            }
            try {
                wf.h(screenMirrorService, r1Var);
                if (!zA) {
                    SharedPreferences sharedPreferencesM = wf.m();
                    if (!((sharedPreferencesM == null || !r1Var.f4975c) ? false : sharedPreferencesM.edit().putBoolean("desired", true).putLong("started_at_ms", r1Var.f4973a).putLong("expires_at_ms", r1Var.f4974b).commit())) {
                        wf.E("black", "black_lease_persist_failed");
                        return wf.x("black_lease_persist_failed");
                    }
                }
                return wf.j0();
            } catch (Throwable th) {
                wf.r();
                wf.t();
                if (zA) {
                    wf.d(r1Var);
                    wf.c0();
                } else {
                    wf.o();
                    wf.f5459w = false;
                    wf.f5455s = !wf.q().isEmpty();
                    Handler handler = wf.f5438a;
                }
                wf.l0();
                return wf.x(th.getMessage() != null ? th.getMessage() : "show_failed");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x016c A[Catch: all -> 0x016e, DONT_GENERATE, TryCatch #8 {all -> 0x016e, blocks: (B:104:0x0166, B:106:0x016c, B:110:0x0171, B:111:0x0178), top: B:564:0x0166 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0171 A[Catch: all -> 0x016e, TryCatch #8 {all -> 0x016e, blocks: (B:104:0x0166, B:106:0x016c, B:110:0x0171, B:111:0x0178), top: B:564:0x0166 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x01a7 A[Catch: all -> 0x01b1, TryCatch #12 {, blocks: (B:130:0x01a3, B:132:0x01a7, B:135:0x01ae), top: B:572:0x01a3 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c1 A[Catch: all -> 0x01dc, TRY_LEAVE, TryCatch #31 {, blocks: (B:145:0x01bb, B:148:0x01c1), top: B:608:0x01bb, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x01c8 A[Catch: all -> 0x01e1, TryCatch #0 {all -> 0x01e1, blocks: (B:143:0x01b8, B:144:0x01ba, B:149:0x01c5, B:151:0x01c8, B:154:0x01d1, B:156:0x01dd, B:157:0x01de, B:145:0x01bb, B:148:0x01c1), top: B:548:0x01b8, inners: #31 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:182:0x0224  */
    /* JADX WARN: Code duplicated, block: B:187:0x0230  */
    /* JADX WARN: Code duplicated, block: B:197:0x024c A[Catch: all -> 0x024e, DONT_GENERATE, TryCatch #27 {all -> 0x024e, blocks: (B:195:0x0248, B:197:0x024c, B:201:0x0250, B:202:0x0271), top: B:601:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0250 A[Catch: all -> 0x024e, TryCatch #27 {all -> 0x024e, blocks: (B:195:0x0248, B:197:0x024c, B:201:0x0250, B:202:0x0271), top: B:601:0x0248 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0274  */
    /* JADX WARN: Code duplicated, block: B:206:0x027a  */
    /* JADX WARN: Code duplicated, block: B:207:0x0283  */
    /* JADX WARN: Code duplicated, block: B:210:0x028b  */
    /* JADX WARN: Code duplicated, block: B:218:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:220:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:228:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:231:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:232:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:235:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:240:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:243:0x0301 A[Catch: all -> 0x02ff, TryCatch #18 {all -> 0x02ff, blocks: (B:238:0x02f8, B:257:0x032a, B:243:0x0301, B:245:0x0307, B:246:0x030b, B:248:0x0311, B:251:0x031a, B:263:0x0338, B:254:0x0321), top: B:584:0x02f8, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x0307 A[Catch: all -> 0x02ff, TryCatch #18 {all -> 0x02ff, blocks: (B:238:0x02f8, B:257:0x032a, B:243:0x0301, B:245:0x0307, B:246:0x030b, B:248:0x0311, B:251:0x031a, B:263:0x0338, B:254:0x0321), top: B:584:0x02f8, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x0311 A[Catch: all -> 0x02ff, TryCatch #18 {all -> 0x02ff, blocks: (B:238:0x02f8, B:257:0x032a, B:243:0x0301, B:245:0x0307, B:246:0x030b, B:248:0x0311, B:251:0x031a, B:263:0x0338, B:254:0x0321), top: B:584:0x02f8, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x035e  */
    /* JADX WARN: Code duplicated, block: B:282:0x0375  */
    /* JADX WARN: Code duplicated, block: B:284:0x0386  */
    /* JADX WARN: Code duplicated, block: B:285:0x038f  */
    /* JADX WARN: Code duplicated, block: B:288:0x0397  */
    /* JADX WARN: Code duplicated, block: B:289:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:295:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:298:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:300:0x03de  */
    /* JADX WARN: Code duplicated, block: B:301:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:304:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:305:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:307:0x0409  */
    /* JADX WARN: Code duplicated, block: B:314:0x041d  */
    /* JADX WARN: Code duplicated, block: B:316:0x0424  */
    /* JADX WARN: Code duplicated, block: B:318:0x0428  */
    /* JADX WARN: Code duplicated, block: B:320:0x042e  */
    /* JADX WARN: Code duplicated, block: B:321:0x0437  */
    /* JADX WARN: Code duplicated, block: B:324:0x043f  */
    /* JADX WARN: Code duplicated, block: B:328:0x044c  */
    /* JADX WARN: Code duplicated, block: B:334:0x045d  */
    /* JADX WARN: Code duplicated, block: B:336:0x0463  */
    /* JADX WARN: Code duplicated, block: B:348:0x0490  */
    /* JADX WARN: Code duplicated, block: B:356:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:357:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:360:0x04df  */
    /* JADX WARN: Code duplicated, block: B:361:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:364:0x04e7 A[Catch: all -> 0x0509, TryCatch #23 {all -> 0x0509, blocks: (B:354:0x049c, B:358:0x04d5, B:362:0x04e2, B:364:0x04e7, B:368:0x050e, B:370:0x051a, B:373:0x0520, B:374:0x0525), top: B:594:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:367:0x050c  */
    /* JADX WARN: Code duplicated, block: B:369:0x0518 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:370:0x051a A[Catch: all -> 0x0509, TryCatch #23 {all -> 0x0509, blocks: (B:354:0x049c, B:358:0x04d5, B:362:0x04e2, B:364:0x04e7, B:368:0x050e, B:370:0x051a, B:373:0x0520, B:374:0x0525), top: B:594:0x049c }] */
    /* JADX WARN: Code duplicated, block: B:378:0x0531 A[Catch: all -> 0x053e, TRY_LEAVE, TryCatch #17 {all -> 0x053e, blocks: (B:376:0x052b, B:378:0x0531), top: B:582:0x052b }] */
    /* JADX WARN: Code duplicated, block: B:397:0x057a  */
    /* JADX WARN: Code duplicated, block: B:398:0x057c  */
    /* JADX WARN: Code duplicated, block: B:403:0x0586  */
    /* JADX WARN: Code duplicated, block: B:411:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:414:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:416:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:427:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:428:0x05da  */
    /* JADX WARN: Code duplicated, block: B:429:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:438:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:443:0x0606  */
    /* JADX WARN: Code duplicated, block: B:445:0x060c  */
    /* JADX WARN: Code duplicated, block: B:447:0x061a  */
    /* JADX WARN: Code duplicated, block: B:449:0x0622  */
    /* JADX WARN: Code duplicated, block: B:452:0x0647  */
    /* JADX WARN: Code duplicated, block: B:453:0x066a  */
    /* JADX WARN: Code duplicated, block: B:455:0x0670  */
    /* JADX WARN: Code duplicated, block: B:456:0x068d  */
    /* JADX WARN: Code duplicated, block: B:458:0x0695  */
    /* JADX WARN: Code duplicated, block: B:479:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:483:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:489:0x0706  */
    /* JADX WARN: Code duplicated, block: B:491:0x070c  */
    /* JADX WARN: Code duplicated, block: B:492:0x0711  */
    /* JADX WARN: Code duplicated, block: B:496:0x071f  */
    /* JADX WARN: Code duplicated, block: B:503:0x073a  */
    /* JADX WARN: Code duplicated, block: B:508:0x074b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:548:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:559:0x0327 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x056a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:570:0x0547 A[EXC_TOP_SPLITTER, PHI: r8
  0x0547: PHI (r8v35 android.view.accessibility.AccessibilityNodeInfo) = (r8v34 android.view.accessibility.AccessibilityNodeInfo), (r8v37 android.view.accessibility.AccessibilityNodeInfo) binds: [B:392:0x056d, B:384:0x0545] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x052b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0542 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x049c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x0330 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0496 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x033b A[EXC_TOP_SPLITTER, PHI: r8
  0x033b: PHI (r8v25 android.view.accessibility.AccessibilityNodeInfo) = (r8v26 android.view.accessibility.AccessibilityNodeInfo), (r8v27 android.view.accessibility.AccessibilityNodeInfo) binds: [B:270:0x0359, B:264:0x0339] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x072b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x072d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:? A[LOOP:0: B:494:0x0719->B:618:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x0748 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0746 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:? A[LOOP:1: B:501:0x0734->B:621:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x031a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x0319 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:364:0x04e7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:449:0x0622, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:452:0x0647, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:455:0x0670, please report this as an issue */
    public void a(t tVar) throws Throwable {
        long j3;
        long j4;
        long j5;
        AccessibilityNodeInfo accessibilityNodeInfo;
        int windowId;
        AccessibilityNodeInfo parent;
        boolean z2;
        e2.s1 s1Var;
        e2.y1 y1Var;
        e2.a0 a0Var;
        m6 m6Var;
        q5 q5Var;
        ScreenMirrorService screenMirrorService;
        int eventType;
        long jElapsedRealtime;
        boolean z3;
        AccessibilityNodeInfo rootInActiveWindow;
        List<AccessibilityWindowInfo> windows;
        AccessibilityNodeInfo root;
        boolean z4;
        String string;
        CharSequence packageName;
        String string2;
        String str;
        boolean zContains;
        AtomicBoolean atomicBoolean;
        boolean z5;
        AccessibilityNodeInfo rootInActiveWindow2;
        AccessibilityNodeInfo source;
        boolean z6;
        boolean z7;
        String str2;
        boolean z8;
        CharSequence packageName2;
        CharSequence className;
        String string3;
        String string4;
        Iterator it;
        boolean z9;
        Iterator it2;
        boolean z10;
        boolean z11;
        int i3;
        long jCurrentTimeMillis;
        String string5;
        String string6;
        String strValueOf;
        String string7;
        String string8;
        boolean z12;
        boolean z13;
        String string9;
        Handler handler;
        long j6;
        ScreenMirrorService screenMirrorService2 = this.f3491d;
        x xVar = screenMirrorService2.G2;
        if (xVar != null) {
            synchronized (xVar.f5463c) {
                j6 = xVar.f5474o;
            }
            if (j6 == tVar.f5119k && Thread.currentThread() != xVar.f5467g) {
                o2.k("accessibility collection work ran outside a11y-collection");
                return;
            }
        }
        Object andSet = tVar.f5121m.getAndSet(null);
        yc ycVar = andSet instanceof yc ? (yc) andSet : null;
        if (ycVar == null || screenMirrorService2.X || screenMirrorService2.Y || tVar.f5122o.get()) {
            return;
        }
        if (ycVar.f5648e) {
            screenMirrorService2.q3(tVar.a());
            return;
        }
        if (ycVar.f5649f) {
            screenMirrorService2.p3(tVar.a());
            return;
        }
        if (!screenMirrorService2.v3(tVar)) {
            if (screenMirrorService2.M3(tVar)) {
                screenMirrorService2.q3(tVar.a());
                return;
            } else {
                if (screenMirrorService2.L3(tVar)) {
                    screenMirrorService2.p3(tVar.a());
                    return;
                }
                return;
            }
        }
        AccessibilityEvent accessibilityEventA = tVar.a();
        if (screenMirrorService2.w3(ycVar.f5646c)) {
            zc zcVar = ycVar.f5644a;
            int i4 = zcVar.f5733a;
            int i5 = ycVar.f5645b;
            long j7 = ycVar.f5647d;
            if (j7 < 0) {
                j4 = 0;
            } else {
                int eventType2 = accessibilityEventA.getEventType();
                if (ScreenMirrorService.Q3(eventType2)) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    ArrayList arrayList = new ArrayList();
                    try {
                        try {
                            AccessibilityNodeInfo source2 = accessibilityEventA.getSource();
                            long j8 = source2 != null ? 1L : 0L;
                            j4 = 0;
                            j5 = 0;
                            accessibilityNodeInfo = source2;
                            int i6 = 0;
                            j3 = j7;
                            j7 = j8;
                            for (int i7 = 8; accessibilityNodeInfo != null && i6 < i7; i7 = 8) {
                                try {
                                    Rect rect = new Rect();
                                    try {
                                        accessibilityNodeInfo.getBoundsInScreen(rect);
                                    } catch (Throwable unused) {
                                    }
                                    String str3 = "";
                                    try {
                                        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                                        if (viewIdResourceName != null) {
                                            str3 = viewIdResourceName;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    String str4 = str3;
                                    try {
                                        windowId = accessibilityNodeInfo.getWindowId();
                                    } catch (Throwable unused3) {
                                        windowId = -1;
                                    }
                                    int i8 = windowId;
                                    if (!rect.isEmpty()) {
                                        arrayList.add(new r6(i8, rect.left, rect.top, rect.right, rect.bottom, str4));
                                    }
                                    i6++;
                                    if (i6 < 8) {
                                        try {
                                            parent = accessibilityNodeInfo.getParent();
                                        } catch (Throwable unused4) {
                                            parent = null;
                                        }
                                    } else {
                                        parent = null;
                                    }
                                    if (parent == accessibilityNodeInfo) {
                                        parent = null;
                                    } else if (parent != null) {
                                        j7++;
                                    }
                                    try {
                                        accessibilityNodeInfo.recycle();
                                        j5++;
                                    } catch (Throwable unused5) {
                                    }
                                    accessibilityNodeInfo = parent;
                                } catch (Throwable unused6) {
                                    try {
                                        Log.d("ScreenMirror", "node scene hint ignored");
                                        if (accessibilityNodeInfo != null) {
                                            accessibilityNodeInfo.recycle();
                                            j5++;
                                        }
                                        ScreenMirrorService.K6.d(j7, j5);
                                        synchronized (screenMirrorService2.q3) {
                                            try {
                                                if (j3 != screenMirrorService2.r3) {
                                                    screenMirrorService2.s3 = new g2.a1(jUptimeMillis, eventType2, arrayList);
                                                    screenMirrorService2.Y5("node_scene_hint", false);
                                                }
                                                z2 = i4 == 1 ? true : true;
                                                if (z2) {
                                                    synchronized (s1Var) {
                                                        if (s1Var.f997k) {
                                                            y1Var = null;
                                                        } else {
                                                            y1Var = null;
                                                        }
                                                        if (y1Var != null) {
                                                            synchronized (y1Var.f1091c) {
                                                                if (y1Var.f1089a) {
                                                                    a0Var = null;
                                                                } else {
                                                                    a0Var = (e2.a0) y1Var.f1092d;
                                                                }
                                                                if (a0Var != null) {
                                                                    e2.s sVar = a0Var.f710i;
                                                                    sVar.getClass();
                                                                    sVar.l(e2.b.f713d);
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    synchronized (s1Var) {
                                                        if (s1Var.f997k) {
                                                            y1Var = null;
                                                        } else {
                                                            y1Var = null;
                                                        }
                                                        if (y1Var != null) {
                                                            try {
                                                                synchronized (y1Var.f1091c) {
                                                                    if (y1Var.f1089a) {
                                                                        a0Var = null;
                                                                    } else {
                                                                        a0Var = (e2.a0) y1Var.f1092d;
                                                                    }
                                                                    if (a0Var != null) {
                                                                        e2.s sVar2 = a0Var.f710i;
                                                                        sVar2.getClass();
                                                                        sVar2.l(e2.b.f713d);
                                                                    }
                                                                }
                                                            } catch (Throwable unused7) {
                                                            }
                                                        }
                                                    }
                                                }
                                                if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                    if (!zcVar.f5737e) {
                                                        try {
                                                            screenMirrorService2.u().l(accessibilityEventA);
                                                        } catch (Throwable th) {
                                                            a0.a.p(th, new StringBuilder("[AppPin] event fail: "), "ScreenMirror");
                                                        }
                                                    }
                                                    if (screenMirrorService2.R5 != null) {
                                                        if (i4 == 16) {
                                                            z12 = false;
                                                        } else {
                                                            z12 = false;
                                                        }
                                                        if (i4 == 8) {
                                                            z13 = false;
                                                        } else {
                                                            z13 = false;
                                                        }
                                                        if (z12) {
                                                            synchronized (screenMirrorService2.f2479c) {
                                                                if (screenMirrorService2.f2486e == null) {
                                                                    HandlerThread handlerThread = new HandlerThread("softkb-bubble");
                                                                    handlerThread.start();
                                                                    screenMirrorService2.f2483d = handlerThread;
                                                                    Handler handler2 = new Handler(handlerThread.getLooper());
                                                                    screenMirrorService2.f2486e = handler2;
                                                                    screenMirrorService2.f2506j = 0;
                                                                    screenMirrorService2.f2476b = false;
                                                                    handler2.post(screenMirrorService2.f2502i);
                                                                }
                                                                if (i4 == 2048) {
                                                                    if (accessibilityEventA.getPackageName() != null) {
                                                                        string9 = accessibilityEventA.getPackageName().toString();
                                                                    } else {
                                                                        string9 = "";
                                                                    }
                                                                    if (j5.s(string9)) {
                                                                        handler.post(screenMirrorService2.f2498h);
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            synchronized (screenMirrorService2.f2479c) {
                                                                try {
                                                                    if (screenMirrorService2.f2486e == null) {
                                                                        HandlerThread handlerThread2 = new HandlerThread("softkb-bubble");
                                                                        handlerThread2.start();
                                                                        screenMirrorService2.f2483d = handlerThread2;
                                                                        Handler handler3 = new Handler(handlerThread2.getLooper());
                                                                        screenMirrorService2.f2486e = handler3;
                                                                        screenMirrorService2.f2506j = 0;
                                                                        screenMirrorService2.f2476b = false;
                                                                        handler3.post(screenMirrorService2.f2502i);
                                                                    }
                                                                    if (i4 == 2048) {
                                                                        if (accessibilityEventA.getPackageName() != null) {
                                                                            string9 = accessibilityEventA.getPackageName().toString();
                                                                        } else {
                                                                            string9 = "";
                                                                        }
                                                                        if (j5.s(string9)) {
                                                                            handler.post(screenMirrorService2.f2498h);
                                                                        }
                                                                    }
                                                                } catch (Throwable th2) {
                                                                    throw th2;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                        m6Var = screenMirrorService2.X0;
                                                        q5Var = m6Var.f4531b;
                                                        screenMirrorService = m6Var.f4530a;
                                                        if (q5Var.f4902d) {
                                                            jElapsedRealtime = SystemClock.elapsedRealtime();
                                                            z3 = z2;
                                                            if (m6Var.f4532c == j4) {
                                                                m6Var.f4532c = jElapsedRealtime;
                                                            }
                                                            if (jElapsedRealtime - m6Var.f4532c > 20000) {
                                                                Log.i("NativeConfirmFallback", "20000ms timeout; exiting native-confirm fallback");
                                                                long j9 = j4;
                                                                m6Var.f4532c = j9;
                                                                m6Var.f4533d = j9;
                                                                q5Var.a();
                                                            } else if (jElapsedRealtime - m6Var.f4533d >= 60) {
                                                                m6Var.f4533d = jElapsedRealtime;
                                                                try {
                                                                    rootInActiveWindow = screenMirrorService.getRootInActiveWindow();
                                                                    if (rootInActiveWindow != null) {
                                                                        try {
                                                                            if (m6.b(rootInActiveWindow)) {
                                                                                windows = screenMirrorService.getWindows();
                                                                                if (windows != null) {
                                                                                    while (r0.hasNext()) {
                                                                                        if (accessibilityWindowInfo != null) {
                                                                                            try {
                                                                                                if (m6.b(root)) {
                                                                                                    try {
                                                                                                        root.recycle();
                                                                                                    } catch (Throwable unused8) {
                                                                                                    }
                                                                                                } else {
                                                                                                    root.recycle();
                                                                                                }
                                                                                            } catch (Throwable th3) {
                                                                                                try {
                                                                                                    root.recycle();
                                                                                                } catch (Throwable unused9) {
                                                                                                }
                                                                                                throw th3;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (rootInActiveWindow != null) {
                                                                                    try {
                                                                                        rootInActiveWindow.recycle();
                                                                                    } catch (Throwable unused10) {
                                                                                    }
                                                                                }
                                                                            }
                                                                            Log.i("NativeConfirmFallback", "fallback navigation click succeeded");
                                                                            if (rootInActiveWindow != null) {
                                                                                rootInActiveWindow.recycle();
                                                                            }
                                                                        } catch (Throwable th4) {
                                                                            th = th4;
                                                                            try {
                                                                                Log.w("NativeConfirmFallback", "scan fail: " + th.getMessage());
                                                                                if (rootInActiveWindow != null) {
                                                                                    rootInActiveWindow.recycle();
                                                                                }
                                                                            } catch (Throwable th5) {
                                                                                if (rootInActiveWindow != null) {
                                                                                    try {
                                                                                        rootInActiveWindow.recycle();
                                                                                    } catch (Throwable unused11) {
                                                                                    }
                                                                                }
                                                                                throw th5;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        windows = screenMirrorService.getWindows();
                                                                        if (windows != null) {
                                                                            while (r0.hasNext()) {
                                                                                if (accessibilityWindowInfo != null) {
                                                                                    if (m6.b(root)) {
                                                                                        root.recycle();
                                                                                        Log.i("NativeConfirmFallback", "fallback navigation click succeeded");
                                                                                    } else {
                                                                                        root.recycle();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        if (rootInActiveWindow != null) {
                                                                            rootInActiveWindow.recycle();
                                                                        }
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    rootInActiveWindow = null;
                                                                }
                                                            }
                                                        } else {
                                                            z3 = z2;
                                                        }
                                                        if (z3) {
                                                            screenMirrorService2.a0(accessibilityEventA);
                                                            if (screenMirrorService2.R5 != null) {
                                                                screenMirrorService2.R5.B(accessibilityEventA);
                                                            }
                                                            if (i4 == 32) {
                                                                screenMirrorService2.N7(accessibilityEventA.getPackageName());
                                                                r4 r4VarB = r4.b();
                                                                if (accessibilityEventA.getPackageName() != null) {
                                                                    string5 = accessibilityEventA.getPackageName().toString();
                                                                } else {
                                                                    string5 = "";
                                                                }
                                                                if (accessibilityEventA.getClassName() != null) {
                                                                    string6 = accessibilityEventA.getClassName().toString();
                                                                } else {
                                                                    string6 = "";
                                                                }
                                                                if (accessibilityEventA.getText() != null) {
                                                                    z4 = false;
                                                                    strValueOf = "";
                                                                } else {
                                                                    z4 = false;
                                                                    strValueOf = "";
                                                                }
                                                                r4VarB.c(screenMirrorService2, string5, string6, strValueOf);
                                                                if (screenMirrorService2.R5 != null) {
                                                                    j5 j5Var = screenMirrorService2.R5;
                                                                    j5Var.getClass();
                                                                    j5Var.l(new u4(j5Var, 1));
                                                                    if (accessibilityEventA.getPackageName() != null) {
                                                                        string7 = accessibilityEventA.getPackageName().toString();
                                                                    } else {
                                                                        string7 = "";
                                                                    }
                                                                    if (accessibilityEventA.getClassName() != null) {
                                                                        string8 = accessibilityEventA.getClassName().toString();
                                                                    } else {
                                                                        string8 = "";
                                                                    }
                                                                    j5 j5Var2 = screenMirrorService2.R5;
                                                                    j5Var2.getClass();
                                                                    j5Var2.l(new b5(j5Var2, string7, string8, 0));
                                                                }
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            if (screenMirrorService2.N5 != null) {
                                                                screenMirrorService2.N5.a(accessibilityEventA);
                                                            }
                                                            screenMirrorService2.X0(accessibilityEventA, i5);
                                                        } else {
                                                            z4 = false;
                                                            if (n.N(i4)) {
                                                                if (zcVar.f5737e) {
                                                                    screenMirrorService2.o3(accessibilityEventA);
                                                                } else {
                                                                    if (accessibilityEventA.getPackageName() != null) {
                                                                        string = accessibilityEventA.getPackageName().toString();
                                                                    } else {
                                                                        string = "";
                                                                    }
                                                                    if (t4.d(string)) {
                                                                        screenMirrorService2.o3(accessibilityEventA);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                            if (!z3) {
                                                                screenMirrorService2.X0(accessibilityEventA, i5);
                                                            }
                                                            packageName = accessibilityEventA.getPackageName();
                                                            if (packageName != null) {
                                                                string2 = packageName.toString();
                                                            } else {
                                                                string2 = "";
                                                            }
                                                            str = string2;
                                                            if (ScreenMirrorService.B3(i5)) {
                                                                return;
                                                            }
                                                            zContains = str.contains("permissioncontroller");
                                                            atomicBoolean = t8.f5166c;
                                                            if (atomicBoolean.get()) {
                                                                z5 = z4;
                                                            } else {
                                                                z5 = z4;
                                                            }
                                                            if (z5) {
                                                                source = accessibilityEventA.getSource();
                                                                if (zContains) {
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append("[PermEvent] type=0x");
                                                                    sb.append(Integer.toHexString(i4));
                                                                    sb.append(" allScrollOff=");
                                                                    sb.append(atomicBoolean.get());
                                                                    sb.append(" autoRun=");
                                                                    sb.append(t8.f5164a.get());
                                                                    sb.append(" clicker=");
                                                                    if (screenMirrorService2.M5 != null) {
                                                                        z6 = true;
                                                                    } else {
                                                                        z6 = z4;
                                                                    }
                                                                    sb.append(z6);
                                                                    sb.append(" source=");
                                                                    if (source != null) {
                                                                        z7 = true;
                                                                    } else {
                                                                        z7 = z4;
                                                                    }
                                                                    sb.append(z7);
                                                                    if (source != null) {
                                                                        str2 = " srcPkg=" + ((Object) source.getPackageName()) + " cls=" + ((Object) source.getClassName());
                                                                    } else {
                                                                        str2 = "";
                                                                    }
                                                                    sb.append(str2);
                                                                    Log.i("ScreenMirror", sb.toString());
                                                                    if (z5) {
                                                                        screenMirrorService2.M5.l(source);
                                                                    }
                                                                    rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                                                                    if (rootInActiveWindow2 != null) {
                                                                        if (!atomicBoolean.get()) {
                                                                            l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                                                                        }
                                                                    }
                                                                    if (source != null) {
                                                                        source.recycle();
                                                                    }
                                                                    if (rootInActiveWindow2 != null) {
                                                                        rootInActiveWindow2.recycle();
                                                                    }
                                                                } else {
                                                                    if (z5) {
                                                                        screenMirrorService2.M5.l(source);
                                                                    }
                                                                    rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                                                                    if (rootInActiveWindow2 != null) {
                                                                        if (!atomicBoolean.get()) {
                                                                            l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                                                                        }
                                                                    }
                                                                    if (source != null) {
                                                                        source.recycle();
                                                                    }
                                                                    if (rootInActiveWindow2 != null) {
                                                                        rootInActiveWindow2.recycle();
                                                                    }
                                                                }
                                                            } else {
                                                                try {
                                                                    source = accessibilityEventA.getSource();
                                                                    if (zContains) {
                                                                        try {
                                                                            StringBuilder sb2 = new StringBuilder();
                                                                            sb2.append("[PermEvent] type=0x");
                                                                            sb2.append(Integer.toHexString(i4));
                                                                            sb2.append(" allScrollOff=");
                                                                            sb2.append(atomicBoolean.get());
                                                                            sb2.append(" autoRun=");
                                                                            sb2.append(t8.f5164a.get());
                                                                            sb2.append(" clicker=");
                                                                            if (screenMirrorService2.M5 != null) {
                                                                                z6 = true;
                                                                            } else {
                                                                                z6 = z4;
                                                                            }
                                                                            sb2.append(z6);
                                                                            sb2.append(" source=");
                                                                            if (source != null) {
                                                                                z7 = true;
                                                                            } else {
                                                                                z7 = z4;
                                                                            }
                                                                            sb2.append(z7);
                                                                            if (source != null) {
                                                                                str2 = " srcPkg=" + ((Object) source.getPackageName()) + " cls=" + ((Object) source.getClassName());
                                                                            } else {
                                                                                str2 = "";
                                                                            }
                                                                            sb2.append(str2);
                                                                            Log.i("ScreenMirror", sb2.toString());
                                                                            if (z5) {
                                                                                screenMirrorService2.M5.l(source);
                                                                            }
                                                                            rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                                                                            if (rootInActiveWindow2 != null) {
                                                                                try {
                                                                                    if (!atomicBoolean.get()) {
                                                                                        l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                                                                                    }
                                                                                } catch (Throwable th7) {
                                                                                    th = th7;
                                                                                    try {
                                                                                        Log.d("ScreenMirror", "handleAutoPermissions error: " + th.getMessage());
                                                                                        if (source != null) {
                                                                                            try {
                                                                                                source.recycle();
                                                                                            } catch (Throwable unused12) {
                                                                                            }
                                                                                        }
                                                                                        if (rootInActiveWindow2 != null) {
                                                                                            try {
                                                                                                rootInActiveWindow2.recycle();
                                                                                            } catch (Throwable unused13) {
                                                                                            }
                                                                                        }
                                                                                    } catch (Throwable th8) {
                                                                                        if (source != null) {
                                                                                            try {
                                                                                                source.recycle();
                                                                                            } catch (Throwable unused14) {
                                                                                            }
                                                                                        }
                                                                                        if (rootInActiveWindow2 == null) {
                                                                                            throw th8;
                                                                                        }
                                                                                        try {
                                                                                            rootInActiveWindow2.recycle();
                                                                                            throw th8;
                                                                                        } catch (Throwable unused15) {
                                                                                            throw th8;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (source != null) {
                                                                                try {
                                                                                    source.recycle();
                                                                                } catch (Throwable unused16) {
                                                                                }
                                                                            }
                                                                            if (rootInActiveWindow2 != null) {
                                                                                rootInActiveWindow2.recycle();
                                                                            }
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            rootInActiveWindow2 = null;
                                                                            Log.d("ScreenMirror", "handleAutoPermissions error: " + th.getMessage());
                                                                            if (source != null) {
                                                                                source.recycle();
                                                                            }
                                                                            if (rootInActiveWindow2 != null) {
                                                                                rootInActiveWindow2.recycle();
                                                                            }
                                                                            if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                                                if (i4 != 32) {
                                                                                }
                                                                                if (screenMirrorService2.N5 != null) {
                                                                                    screenMirrorService2.N5.a(accessibilityEventA);
                                                                                }
                                                                                if (screenMirrorService2.m6 == 1) {
                                                                                    if (screenMirrorService2.Q4.isEmpty()) {
                                                                                        z8 = true;
                                                                                    } else {
                                                                                        z8 = true;
                                                                                    }
                                                                                    if (screenMirrorService2.m4 != null) {
                                                                                        return;
                                                                                    }
                                                                                    packageName2 = accessibilityEventA.getPackageName();
                                                                                    className = accessibilityEventA.getClassName();
                                                                                    if (packageName2 == null) {
                                                                                        return;
                                                                                    }
                                                                                    string3 = packageName2.toString();
                                                                                    if (className != null) {
                                                                                        string4 = className.toString();
                                                                                    } else {
                                                                                        string4 = "";
                                                                                    }
                                                                                    it = ScreenMirrorService.v6.iterator();
                                                                                    while (true) {
                                                                                        if (!it.hasNext()) {
                                                                                            z9 = z4;
                                                                                        } else if (string3.contains((String) it.next())) {
                                                                                            z9 = z8;
                                                                                        }
                                                                                    }
                                                                                    it2 = ScreenMirrorService.w6.iterator();
                                                                                    while (true) {
                                                                                        if (!it2.hasNext()) {
                                                                                            z10 = z4;
                                                                                        } else if (string4.contains((String) it2.next())) {
                                                                                            z10 = z8;
                                                                                        }
                                                                                    }
                                                                                    if (z9) {
                                                                                    }
                                                                                    screenMirrorService2.v6(2);
                                                                                    return;
                                                                                }
                                                                                if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                                                    if (screenMirrorService2.m6 != 4) {
                                                                                    }
                                                                                    z11 = screenMirrorService2.P4;
                                                                                    i3 = screenMirrorService2.m6;
                                                                                    if (!z11) {
                                                                                        screenMirrorService2.v6(i3);
                                                                                        return;
                                                                                    }
                                                                                    if (i3 != 4) {
                                                                                    }
                                                                                    if (screenMirrorService2.m6 != 5) {
                                                                                    }
                                                                                    if (screenMirrorService2.m6 == 3) {
                                                                                        if (!str.isEmpty()) {
                                                                                            jCurrentTimeMillis = System.currentTimeMillis();
                                                                                            if (jCurrentTimeMillis - screenMirrorService2.c5 <= 2000) {
                                                                                                Log.d("ScreenMirror", "[PermEvent] ev type=" + i4 + " pkg=" + str);
                                                                                                screenMirrorService2.c5 = jCurrentTimeMillis;
                                                                                                screenMirrorService2.b5 = str;
                                                                                            } else {
                                                                                                Log.d("ScreenMirror", "[PermEvent] ev type=" + i4 + " pkg=" + str);
                                                                                                screenMirrorService2.c5 = jCurrentTimeMillis;
                                                                                                screenMirrorService2.b5 = str;
                                                                                            }
                                                                                        }
                                                                                        if (ScreenMirrorService.Z3(str)) {
                                                                                            screenMirrorService2.Z4 = true;
                                                                                            Log.i("ScreenMirror", "[PermEvent] permCtrl event type=" + i4 + " pkg=" + str);
                                                                                            screenMirrorService2.D7(accessibilityEventA);
                                                                                            return;
                                                                                        }
                                                                                        if (ScreenMirrorService.S3(str)) {
                                                                                            Log.d("ScreenMirror", "[PermEvent] non-runtime dialog pkg=" + str + " type=" + i4);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        if (z5) {
                                                                            screenMirrorService2.M5.l(source);
                                                                        }
                                                                        rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                                                                        if (rootInActiveWindow2 != null) {
                                                                            if (!atomicBoolean.get()) {
                                                                                l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                                                                            }
                                                                        }
                                                                        if (source != null) {
                                                                            source.recycle();
                                                                        }
                                                                        if (rootInActiveWindow2 != null) {
                                                                            rootInActiveWindow2.recycle();
                                                                        }
                                                                    }
                                                                } catch (Throwable th10) {
                                                                    th = th10;
                                                                    rootInActiveWindow2 = null;
                                                                    source = null;
                                                                }
                                                            }
                                                            if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                                return;
                                                            }
                                                            if (i4 != 32) {
                                                            }
                                                            if (screenMirrorService2.N5 != null) {
                                                                screenMirrorService2.N5.a(accessibilityEventA);
                                                            }
                                                            if (screenMirrorService2.m6 == 1) {
                                                                if (screenMirrorService2.Q4.isEmpty()) {
                                                                    z8 = true;
                                                                } else {
                                                                    z8 = true;
                                                                }
                                                                if (screenMirrorService2.m4 != null) {
                                                                    return;
                                                                }
                                                                packageName2 = accessibilityEventA.getPackageName();
                                                                className = accessibilityEventA.getClassName();
                                                                if (packageName2 == null) {
                                                                    return;
                                                                }
                                                                string3 = packageName2.toString();
                                                                if (className != null) {
                                                                    string4 = className.toString();
                                                                } else {
                                                                    string4 = "";
                                                                }
                                                                it = ScreenMirrorService.v6.iterator();
                                                                while (true) {
                                                                    if (!it.hasNext()) {
                                                                        z9 = z4;
                                                                    } else if (string3.contains((String) it.next())) {
                                                                        z9 = z8;
                                                                    }
                                                                }
                                                                it2 = ScreenMirrorService.w6.iterator();
                                                                while (true) {
                                                                    if (!it2.hasNext()) {
                                                                        z10 = z4;
                                                                    } else if (string4.contains((String) it2.next())) {
                                                                        z10 = z8;
                                                                    }
                                                                }
                                                                if (z9) {
                                                                }
                                                                screenMirrorService2.v6(2);
                                                                return;
                                                            }
                                                            if (screenMirrorService2.w3(ycVar.f5646c)) {
                                                                return;
                                                            }
                                                            if (screenMirrorService2.m6 != 4) {
                                                            }
                                                            z11 = screenMirrorService2.P4;
                                                            i3 = screenMirrorService2.m6;
                                                            if (!z11) {
                                                                screenMirrorService2.v6(i3);
                                                                return;
                                                            }
                                                            if (i3 != 4) {
                                                            }
                                                            if (screenMirrorService2.m6 != 5) {
                                                            }
                                                            if (screenMirrorService2.m6 == 3) {
                                                                if (!str.isEmpty()) {
                                                                    jCurrentTimeMillis = System.currentTimeMillis();
                                                                    if (jCurrentTimeMillis - screenMirrorService2.c5 <= 2000) {
                                                                        Log.d("ScreenMirror", "[PermEvent] ev type=" + i4 + " pkg=" + str);
                                                                        screenMirrorService2.c5 = jCurrentTimeMillis;
                                                                        screenMirrorService2.b5 = str;
                                                                    } else {
                                                                        Log.d("ScreenMirror", "[PermEvent] ev type=" + i4 + " pkg=" + str);
                                                                        screenMirrorService2.c5 = jCurrentTimeMillis;
                                                                        screenMirrorService2.b5 = str;
                                                                    }
                                                                }
                                                                if (ScreenMirrorService.Z3(str)) {
                                                                    screenMirrorService2.Z4 = true;
                                                                    Log.i("ScreenMirror", "[PermEvent] permCtrl event type=" + i4 + " pkg=" + str);
                                                                    screenMirrorService2.D7(accessibilityEventA);
                                                                    return;
                                                                }
                                                                if (ScreenMirrorService.S3(str)) {
                                                                    Log.d("ScreenMirror", "[PermEvent] non-runtime dialog pkg=" + str + " type=" + i4);
                                                                }
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } catch (Throwable th11) {
                                                throw th11;
                                            }
                                        }
                                    } catch (Throwable th12) {
                                        if (accessibilityNodeInfo != null) {
                                            try {
                                                accessibilityNodeInfo.recycle();
                                                j5++;
                                            } catch (Throwable unused17) {
                                            }
                                        }
                                        ScreenMirrorService.K6.d(j7, j5);
                                        throw th12;
                                    }
                                }
                            }
                            if (accessibilityNodeInfo != null) {
                                accessibilityNodeInfo.recycle();
                                j5++;
                            }
                        } catch (Throwable unused18) {
                        }
                    } catch (Throwable unused19) {
                        j3 = j7;
                        j4 = 0;
                        j7 = 0;
                        j5 = 0;
                        accessibilityNodeInfo = null;
                    }
                    ScreenMirrorService.K6.d(j7, j5);
                    synchronized (screenMirrorService2.q3) {
                        if (j3 != screenMirrorService2.r3) {
                            screenMirrorService2.s3 = new g2.a1(jUptimeMillis, eventType2, arrayList);
                            screenMirrorService2.Y5("node_scene_hint", false);
                        }
                    }
                } else {
                    j4 = 0;
                }
            }
            if (i4 == 1 && i4 != 2) {
                switch (i4) {
                    case 4:
                    case 8:
                    case 16:
                    case 32:
                    case 128:
                    case 256:
                    case 16384:
                    case 32768:
                    case 65536:
                    case 1048576:
                    case 2097152:
                        z2 = true;
                        break;
                    default:
                        z2 = false;
                        break;
                }
            }
            if ((z2 || n.N(i4)) && ((i4 == 2048 || i4 == 32 || i4 == 1) && (s1Var = screenMirrorService2.a4) != null)) {
                synchronized (s1Var) {
                    if (s1Var.f997k || s1Var.f990d == e2.q1.f931d) {
                        y1Var = null;
                    } else {
                        y1Var = s1Var.f991e;
                    }
                }
                if (y1Var != null) {
                    synchronized (y1Var.f1091c) {
                        if (y1Var.f1089a) {
                            a0Var = null;
                        } else {
                            a0Var = (e2.a0) y1Var.f1092d;
                        }
                    }
                    if (a0Var != null && !a0Var.f704c.get()) {
                        e2.s sVar3 = a0Var.f710i;
                        sVar3.getClass();
                        sVar3.l(e2.b.f713d);
                    }
                }
            }
            if (screenMirrorService2.w3(ycVar.f5646c)) {
                return;
            }
            if (!zcVar.f5737e && (i4 == 1 || i4 == 32 || i4 == 4194304 || i4 == 2048)) {
                screenMirrorService2.u().l(accessibilityEventA);
            }
            if (screenMirrorService2.R5 != null && !zcVar.f5737e) {
                if (i4 == 16 || !accessibilityEventA.isPassword()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (i4 == 8 || !accessibilityEventA.isPassword()) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if ((z12 || z13 || i4 == 2048) && screenMirrorService2.R5.f4309c.b(System.currentTimeMillis())) {
                    synchronized (screenMirrorService2.f2479c) {
                        if (screenMirrorService2.f2486e == null) {
                            HandlerThread handlerThread3 = new HandlerThread("softkb-bubble");
                            handlerThread3.start();
                            screenMirrorService2.f2483d = handlerThread3;
                            Handler handler4 = new Handler(handlerThread3.getLooper());
                            screenMirrorService2.f2486e = handler4;
                            screenMirrorService2.f2506j = 0;
                            screenMirrorService2.f2476b = false;
                            handler4.post(screenMirrorService2.f2502i);
                        }
                    }
                    if (i4 == 2048) {
                        if (accessibilityEventA.getPackageName() != null) {
                            string9 = accessibilityEventA.getPackageName().toString();
                        } else {
                            string9 = "";
                        }
                        if (j5.s(string9) && (handler = screenMirrorService2.f2486e) != null) {
                            handler.post(screenMirrorService2.f2498h);
                        }
                    }
                }
            }
            if (screenMirrorService2.w3(ycVar.f5646c)) {
                return;
            }
            m6Var = screenMirrorService2.X0;
            q5Var = m6Var.f4531b;
            screenMirrorService = m6Var.f4530a;
            if (q5Var.f4902d && ((eventType = accessibilityEventA.getEventType()) == 32 || eventType == 2048 || eventType == 4194304)) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                z3 = z2;
                if (m6Var.f4532c == j4) {
                    m6Var.f4532c = jElapsedRealtime;
                }
                if (jElapsedRealtime - m6Var.f4532c > 20000) {
                    Log.i("NativeConfirmFallback", "20000ms timeout; exiting native-confirm fallback");
                    long j10 = j4;
                    m6Var.f4532c = j10;
                    m6Var.f4533d = j10;
                    q5Var.a();
                } else if (jElapsedRealtime - m6Var.f4533d >= 60) {
                    m6Var.f4533d = jElapsedRealtime;
                    rootInActiveWindow = screenMirrorService.getRootInActiveWindow();
                    if (rootInActiveWindow != null) {
                        if (m6.b(rootInActiveWindow)) {
                            windows = screenMirrorService.getWindows();
                            if (windows != null) {
                                for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                                    if (accessibilityWindowInfo != null && (root = accessibilityWindowInfo.getRoot()) != null) {
                                        if (m6.b(root)) {
                                            root.recycle();
                                        } else {
                                            root.recycle();
                                        }
                                    }
                                }
                            }
                            if (rootInActiveWindow != null) {
                                rootInActiveWindow.recycle();
                            }
                        }
                        Log.i("NativeConfirmFallback", "fallback navigation click succeeded");
                        if (rootInActiveWindow != null) {
                            rootInActiveWindow.recycle();
                        }
                    } else {
                        windows = screenMirrorService.getWindows();
                        if (windows != null) {
                            while (r0.hasNext()) {
                                if (accessibilityWindowInfo != null) {
                                    if (m6.b(root)) {
                                        root.recycle();
                                        Log.i("NativeConfirmFallback", "fallback navigation click succeeded");
                                    } else {
                                        root.recycle();
                                    }
                                }
                            }
                        }
                        if (rootInActiveWindow != null) {
                            rootInActiveWindow.recycle();
                        }
                    }
                }
            } else {
                z3 = z2;
            }
            if (z3) {
                screenMirrorService2.a0(accessibilityEventA);
                if (screenMirrorService2.R5 != null && (i4 == 16 || i4 == 8 || i4 == 1)) {
                    screenMirrorService2.R5.B(accessibilityEventA);
                }
                if (i4 == 32) {
                    screenMirrorService2.N7(accessibilityEventA.getPackageName());
                    r4 r4VarB2 = r4.b();
                    if (accessibilityEventA.getPackageName() != null) {
                        string5 = accessibilityEventA.getPackageName().toString();
                    } else {
                        string5 = "";
                    }
                    if (accessibilityEventA.getClassName() != null) {
                        string6 = accessibilityEventA.getClassName().toString();
                    } else {
                        string6 = "";
                    }
                    if (accessibilityEventA.getText() != null || accessibilityEventA.getText().isEmpty()) {
                        z4 = false;
                        strValueOf = "";
                    } else {
                        z4 = false;
                        strValueOf = String.valueOf(accessibilityEventA.getText().get(0));
                    }
                    r4VarB2.c(screenMirrorService2, string5, string6, strValueOf);
                    if (screenMirrorService2.R5 != null) {
                        j5 j5Var3 = screenMirrorService2.R5;
                        j5Var3.getClass();
                        j5Var3.l(new u4(j5Var3, 1));
                        if (accessibilityEventA.getPackageName() != null) {
                            string7 = accessibilityEventA.getPackageName().toString();
                        } else {
                            string7 = "";
                        }
                        if (accessibilityEventA.getClassName() != null) {
                            string8 = accessibilityEventA.getClassName().toString();
                        } else {
                            string8 = "";
                        }
                        j5 j5Var4 = screenMirrorService2.R5;
                        j5Var4.getClass();
                        j5Var4.l(new b5(j5Var4, string7, string8, 0));
                    }
                } else {
                    z4 = false;
                }
                if (screenMirrorService2.N5 != null && !ScreenMirrorService.B3(i5)) {
                    screenMirrorService2.N5.a(accessibilityEventA);
                }
                screenMirrorService2.X0(accessibilityEventA, i5);
            } else {
                z4 = false;
                if (n.N(i4)) {
                    if (zcVar.f5737e) {
                        screenMirrorService2.o3(accessibilityEventA);
                    } else {
                        if (accessibilityEventA.getPackageName() != null) {
                            string = accessibilityEventA.getPackageName().toString();
                        } else {
                            string = "";
                        }
                        if (t4.d(string)) {
                            screenMirrorService2.o3(accessibilityEventA);
                        }
                    }
                }
            }
            if (screenMirrorService2.w3(ycVar.f5646c)) {
                return;
            }
            if (!z3 && n.N(i4)) {
                screenMirrorService2.X0(accessibilityEventA, i5);
            }
            packageName = accessibilityEventA.getPackageName();
            if (packageName != null) {
                string2 = packageName.toString();
            } else {
                string2 = "";
            }
            str = string2;
            if (ScreenMirrorService.B3(i5) && screenMirrorService2.w3(ycVar.f5646c)) {
                zContains = str.contains("permissioncontroller");
                atomicBoolean = t8.f5166c;
                if (atomicBoolean.get() || !t8.f5164a.get()) {
                    z5 = z4;
                } else {
                    z5 = true;
                }
                if (z5 || zContains) {
                    source = accessibilityEventA.getSource();
                    if (zContains) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("[PermEvent] type=0x");
                        sb3.append(Integer.toHexString(i4));
                        sb3.append(" allScrollOff=");
                        sb3.append(atomicBoolean.get());
                        sb3.append(" autoRun=");
                        sb3.append(t8.f5164a.get());
                        sb3.append(" clicker=");
                        if (screenMirrorService2.M5 != null) {
                            z6 = true;
                        } else {
                            z6 = z4;
                        }
                        sb3.append(z6);
                        sb3.append(" source=");
                        if (source != null) {
                            z7 = true;
                        } else {
                            z7 = z4;
                        }
                        sb3.append(z7);
                        if (source != null) {
                            str2 = " srcPkg=" + ((Object) source.getPackageName()) + " cls=" + ((Object) source.getClassName());
                        } else {
                            str2 = "";
                        }
                        sb3.append(str2);
                        Log.i("ScreenMirror", sb3.toString());
                        if (z5 && screenMirrorService2.M5 != null && source != null) {
                            screenMirrorService2.M5.l(source);
                        }
                        rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                        if (rootInActiveWindow2 != null) {
                            if (!atomicBoolean.get()) {
                                l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                            }
                        }
                        if (source != null) {
                            source.recycle();
                        }
                        if (rootInActiveWindow2 != null) {
                            rootInActiveWindow2.recycle();
                        }
                    } else {
                        if (z5) {
                            screenMirrorService2.M5.l(source);
                        }
                        rootInActiveWindow2 = screenMirrorService2.getRootInActiveWindow();
                        if (rootInActiveWindow2 != null) {
                            if (!atomicBoolean.get()) {
                                l6.d("app_auto_allow_per_job", 3, new pa(screenMirrorService2, 11));
                            }
                        }
                        if (source != null) {
                            source.recycle();
                        }
                        if (rootInActiveWindow2 != null) {
                            rootInActiveWindow2.recycle();
                        }
                    }
                }
                if (screenMirrorService2.w3(ycVar.f5646c)) {
                    return;
                }
                if (i4 != 32 || i4 == 2048) {
                    if (screenMirrorService2.N5 != null && f2.l.q(screenMirrorService2) && !z3 && !ScreenMirrorService.B3(i5)) {
                        screenMirrorService2.N5.a(accessibilityEventA);
                    }
                    if (screenMirrorService2.m6 == 1) {
                        if (screenMirrorService2.Q4.isEmpty() || n.H(screenMirrorService2, screenMirrorService2.Q4)) {
                            z8 = true;
                        } else {
                            int iW2 = ScreenMirrorService.W2(screenMirrorService2.Q4);
                            CharSequence packageName3 = accessibilityEventA.getPackageName();
                            String string10 = packageName3 != null ? packageName3.toString() : "";
                            if (iW2 == 4 && ScreenMirrorService.c4(string10)) {
                                screenMirrorService2.v6(iW2);
                                screenMirrorService2.m1();
                                return;
                            }
                            if (iW2 == 3 && ScreenMirrorService.Z3(string10)) {
                                screenMirrorService2.Z4 = true;
                                screenMirrorService2.v6(iW2);
                                screenMirrorService2.D7(accessibilityEventA);
                                return;
                            } else {
                                z8 = true;
                                if (iW2 == 5 && (ScreenMirrorService.c4(string10) || ScreenMirrorService.S3(string10))) {
                                    screenMirrorService2.v6(iW2);
                                    return;
                                }
                            }
                        }
                        if (screenMirrorService2.m4 != null && "projection".equals(screenMirrorService2.Q4)) {
                            packageName2 = accessibilityEventA.getPackageName();
                            className = accessibilityEventA.getClassName();
                            if (packageName2 == null) {
                                return;
                            }
                            string3 = packageName2.toString();
                            if (className != null) {
                                string4 = className.toString();
                            } else {
                                string4 = "";
                            }
                            it = ScreenMirrorService.v6.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z9 = z4;
                                } else if (string3.contains((String) it.next())) {
                                    z9 = z8;
                                }
                            }
                            it2 = ScreenMirrorService.w6.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z10 = z4;
                                } else if (string4.contains((String) it2.next())) {
                                    z10 = z8;
                                }
                            }
                            if (!z9 || z10) {
                                screenMirrorService2.v6(2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (screenMirrorService2.w3(ycVar.f5646c)) {
                        return;
                    }
                    if (screenMirrorService2.m6 != 4 && "vendor_battery".equals(screenMirrorService2.Q4) && screenMirrorService2.y3() && screenMirrorService2.N5 != null) {
                        if (screenMirrorService2.N5.d(accessibilityEventA) == 3) {
                            screenMirrorService2.N2();
                            return;
                        }
                        return;
                    }
                    z11 = screenMirrorService2.P4;
                    i3 = screenMirrorService2.m6;
                    if (!z11) {
                        screenMirrorService2.v6(i3);
                        return;
                    }
                    if (i3 != 4 && i4 == 2048) {
                        CharSequence packageName4 = accessibilityEventA.getPackageName();
                        if (packageName4 == null || !ScreenMirrorService.c4(packageName4.toString())) {
                            return;
                        }
                        screenMirrorService2.m1();
                        return;
                    }
                    if (screenMirrorService2.m6 != 5 && i4 == 2048) {
                        screenMirrorService2.f1();
                        return;
                    }
                    if (screenMirrorService2.m6 == 3) {
                        if (!str.isEmpty()) {
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis - screenMirrorService2.c5 <= 2000 || !str.equals(screenMirrorService2.b5)) {
                                Log.d("ScreenMirror", "[PermEvent] ev type=" + i4 + " pkg=" + str);
                                screenMirrorService2.c5 = jCurrentTimeMillis;
                                screenMirrorService2.b5 = str;
                            }
                        }
                        if (ScreenMirrorService.Z3(str)) {
                            screenMirrorService2.Z4 = true;
                            Log.i("ScreenMirror", "[PermEvent] permCtrl event type=" + i4 + " pkg=" + str);
                            screenMirrorService2.D7(accessibilityEventA);
                            return;
                        }
                        if (ScreenMirrorService.S3(str)) {
                            Log.d("ScreenMirror", "[PermEvent] non-runtime dialog pkg=" + str + " type=" + i4);
                        }
                    }
                }
            }
        }
    }

    public boolean b(t tVar) {
        zc zcVar;
        yc ycVar;
        boolean z2;
        Character chI1;
        String str;
        long j3;
        ScreenMirrorService screenMirrorService = this.f3491d;
        x xVar = screenMirrorService.G2;
        if (xVar != null) {
            synchronized (xVar.f5463c) {
                j3 = xVar.f5474o;
            }
            if (j3 == tVar.f5119k && Thread.currentThread() != xVar.f5466f) {
                o2.k("accessibility critical work ran outside a11y-critical");
                return false;
            }
        }
        if (screenMirrorService.X || screenMirrorService.Y) {
            tVar.n.set(true);
            return false;
        }
        if (!tVar.f5116h && !screenMirrorService.f2534q2 && tVar.f5115g && t4.d(tVar.f5110b)) {
            AccessibilityEvent accessibilityEventA = tVar.a();
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i3 = tVar.f5109a;
            if (i3 == 16) {
                if ((tVar.f5113e || ((str = tVar.f5111c) != null && str.contains("PasswordTextView"))) && accessibilityEventA.getAddedCount() > 0) {
                    screenMirrorService.f2529p1 = jUptimeMillis + 3000;
                    screenMirrorService.U0.s();
                    int iW7 = ScreenMirrorService.w7(accessibilityEventA);
                    if (iW7 > 1) {
                        screenMirrorService.U0.E(iW7);
                    }
                }
            } else if (i3 == 1 && (chI1 = ScreenMirrorService.I1(accessibilityEventA)) != null && (screenMirrorService.n1 || jUptimeMillis <= screenMirrorService.f2529p1)) {
                screenMirrorService.U0.s();
                y8 y8Var = screenMirrorService.U0;
                char cCharValue = chI1.charValue();
                long j4 = tVar.f5112d;
                boolean zT = y8Var.t(cCharValue, -1.0f, -1.0f, j4 > 0 ? j4 : jUptimeMillis, false);
                if (zT) {
                    tVar.f5122o.set(true);
                }
                Log.i("ScreenMirror", "[PinFusion] critical digit accepted=" + zT);
            }
        }
        int i4 = tVar.f5109a;
        String str2 = tVar.f5110b;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = tVar.f5111c;
        if (str3 == null) {
            str3 = "";
        }
        zc zcVar2 = new zc(i4, str2, str3, tVar.f5114f, tVar.f5115g, tVar.f5116h);
        boolean zV3 = screenMirrorService.v3(tVar);
        boolean z3 = !zV3 && screenMirrorService.M3(tVar);
        boolean z4 = (zV3 || z3 || !screenMirrorService.L3(tVar)) ? false : true;
        if (zV3 || z3 || z4) {
            if (z3 || z4) {
                zcVar = zcVar2;
                ycVar = new yc(zcVar, tVar.f5119k, z3, z4);
            } else {
                ycVar = screenMirrorService.l5(tVar.a(), zcVar2, tVar.f5119k);
            }
            if (ycVar == null) {
                zcVar = zcVar2;
                tVar.n.set(true);
                return false;
            }
            if (!ycVar.f5648e && !ycVar.f5649f && !screenMirrorService.v3(tVar)) {
                boolean zM3 = screenMirrorService.M3(tVar);
                if (zM3 || !screenMirrorService.L3(tVar)) {
                    zcVar = zcVar2;
                    zcVar = zcVar2;
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (zM3 || z2) {
                    zcVar = zcVar2;
                    ycVar = new yc(zcVar, tVar.f5119k, zM3, z2);
                } else {
                    boolean z5 = tVar.f5115g;
                    boolean zJ3 = screenMirrorService.J3();
                    boolean z6 = tVar.f5116h;
                    boolean z7 = screenMirrorService.Y1 != null;
                    if (!z5 || zJ3 || z6 || z7) {
                        tVar.n.set(true);
                        return false;
                    }
                }
            }
            zcVar = zcVar2;
            zcVar = zcVar2;
            zcVar = zcVar2;
            if (tVar.f5120l.get() == null) {
                o2.k("event already recycled");
                return false;
            }
            AtomicReference atomicReference = tVar.f5121m;
            while (!atomicReference.compareAndSet(null, ycVar)) {
                if (atomicReference.get() != null) {
                    o2.k("continuation state already set");
                    return false;
                }
            }
            return true;
        }
        boolean z8 = tVar.f5115g;
        boolean zJ4 = screenMirrorService.J3();
        boolean z9 = tVar.f5116h;
        boolean z10 = screenMirrorService.Y1 != null;
        if (!z8 || zJ4 || z9 || z10) {
            tVar.n.set(true);
            return false;
        }
        return false;
    }

    @Override // w1.g4
    public c4 c(long j3, Runnable runnable) {
        rd rdVar = ScreenMirrorService.n6;
        return new b4(this.f3491d.u6(Math.max(0L, j3), runnable), 1);
    }

    @Override // p1.a
    public Object d() {
        ScreenMirrorService screenMirrorService;
        switch (this.f3490c) {
            case 14:
                ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
                if (screenMirrorServiceU2 != null && screenMirrorServiceU2 == (screenMirrorService = this.f3491d) && screenMirrorService.f2537s.get()) {
                    return new fc(screenMirrorService, screenMirrorService.Z.get());
                }
                return null;
            default:
                return this.f3491d.u5();
        }
    }

    @Override // w1.l4
    public k4 e() {
        int i3 = this.f3490c;
        k4 k4Var = k4.f4389c;
        ScreenMirrorService screenMirrorService = this.f3491d;
        switch (i3) {
            case 4:
                rd rdVar = ScreenMirrorService.n6;
                return screenMirrorService.J3() ? k4Var : k4.a(13);
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService.getClass();
                return !c2.c.f(screenMirrorService) ? k4Var : k4.a(12);
        }
    }

    public b6 g() {
        List<AccessibilityWindowInfo> windows;
        AccessibilityNodeInfo root;
        ScreenMirrorService screenMirrorService = this.f3491d;
        int i3 = screenMirrorService.O3;
        int i4 = screenMirrorService.P3;
        n0 n0Var = new n0(m0.f4489d);
        Pattern pattern = c6.f3659a;
        try {
            windows = screenMirrorService.getWindows();
        } catch (Throwable unused) {
            windows = Collections.EMPTY_LIST;
        }
        z5 z5Var = new z5(i3, i4);
        a6 a6Var = z5Var.f5696e;
        boolean z2 = false;
        if (windows != null) {
            for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                if (!n0Var.d()) {
                    break;
                }
                if (accessibilityWindowInfo != null) {
                    try {
                        if (accessibilityWindowInfo.getType() == 4) {
                            continue;
                        } else {
                            try {
                                root = accessibilityWindowInfo.getRoot();
                                if (root != null) {
                                    try {
                                        String strJ = c6.j(root.getPackageName());
                                        if (!c6.g(strJ)) {
                                            try {
                                                if (accessibilityWindowInfo.getType() == 3) {
                                                }
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                        c6.i(root, strJ, 0, z5Var, n0Var);
                                    } catch (Throwable unused3) {
                                    }
                                    c6.h(root);
                                    if (!n0Var.a()) {
                                        break;
                                    }
                                }
                                c6.h(root);
                            } catch (Throwable unused4) {
                                root = null;
                            }
                        }
                    } catch (Throwable unused5) {
                    }
                }
            }
        }
        HashMap map = new HashMap();
        for (Map.Entry entry : z5Var.f5694c.entrySet()) {
            if (((a6) entry.getValue()).f3467a != null) {
                map.put((Integer) entry.getKey(), new Rect(((a6) entry.getValue()).f3467a));
            }
        }
        if (z5Var.f5698g || z5Var.f5699h || z5Var.f5700i || (map.size() >= 2 && a6Var.f3467a == null)) {
            z2 = true;
        }
        boolean z3 = z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jMax = Math.max(0L, System.nanoTime() - n0Var.f4589b) / 1000000;
        int i5 = n0Var.f4592e;
        return new b6(jUptimeMillis, jMax, i5, n0Var.f4591d, n0Var.f4593f, z3, z5Var.f5698g, z5Var.f5699h, map, z5Var.f5695d.f3467a, a6Var.f3467a, z5Var.f5701j, c6.d(i5, z5Var.f5702k));
    }

    @Override // w1.of
    public String run() {
        uf ufVar;
        String strX;
        String strJ0;
        switch (this.f3490c) {
            case 18:
                ScreenMirrorService screenMirrorService = this.f3491d;
                synchronized (wf.f5439b) {
                    try {
                        try {
                            wf.f5443f = screenMirrorService;
                            wf.f5461y = 99;
                            wf.v(screenMirrorService);
                            if (wf.f5447j == null) {
                                ufVar = new uf(screenMirrorService);
                                ufVar.setImportantForAccessibility(4);
                                wf.c(ufVar, "update");
                                wf.f5447j = ufVar;
                            } else {
                                ufVar = null;
                            }
                            try {
                                x8 x8Var = wf.f5440c;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                synchronized (x8Var) {
                                    x8Var.f5515a = true;
                                    x8Var.f5516b = true;
                                    if (x8Var.f5517c <= 0) {
                                        x8Var.f5517c = Math.max(1L, jCurrentTimeMillis);
                                    }
                                    break;
                                }
                                wf.m0();
                                wf.e();
                                wf.l0();
                                wf.L();
                                Handler handler = wf.f5438a;
                                d2.r rVar = wf.U;
                                handler.removeCallbacks(rVar);
                                wf.q0();
                                handler.postDelayed(rVar, 1000L);
                                handler.removeCallbacks(wf.R);
                                wf.f(screenMirrorService);
                                strX = wf.j0();
                            } catch (Throwable th) {
                                th = th;
                                if (ufVar != null) {
                                    wf.U(ufVar);
                                    if (wf.f5447j == ufVar) {
                                        wf.f5447j = null;
                                    }
                                    x8 x8Var2 = wf.f5440c;
                                    synchronized (x8Var2) {
                                        x8Var2.f5515a = false;
                                        x8Var2.f5516b = false;
                                        x8Var2.f5517c = 0L;
                                    }
                                }
                                if (wf.q().isEmpty()) {
                                    wf.F("update_show_failed");
                                }
                                strX = wf.x(th.getMessage() != null ? th.getMessage() : "show_failed");
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            ufVar = null;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                    break;
                }
                return strX;
            case 19:
                return f();
            default:
                ScreenMirrorService screenMirrorService2 = this.f3491d;
                synchronized (wf.f5439b) {
                    wf.f5443f = screenMirrorService2;
                    wf.M(screenMirrorService2);
                    strJ0 = wf.j0();
                    break;
                }
                return strJ0;
        }
    }
}
