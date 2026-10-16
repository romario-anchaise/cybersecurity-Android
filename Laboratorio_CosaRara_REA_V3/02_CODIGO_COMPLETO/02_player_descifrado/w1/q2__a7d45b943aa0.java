// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.Iterator;
import java.util.List;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q2 implements l4, h4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t2 f4888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s2 f4889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g0.s[] f4890e;

    public /* synthetic */ q2(t2 t2Var, s2 s2Var, g0.s[] sVarArr) {
        this.f4888c = t2Var;
        this.f4889d = s2Var;
        this.f4890e = sVarArr;
    }

    @Override // w1.h4
    public int b(d2.t tVar) {
        t2 t2Var = this.f4888c;
        s2 s2Var = this.f4889d;
        int iF = t2Var.f(s2Var);
        if (iF != 0) {
            t2Var.j(s2Var, 5, 1, iF);
            return 4;
        }
        g0.s[] sVarArr = this.f4890e;
        g0.s sVar = sVarArr[0];
        sVarArr[0] = null;
        if (sVar == null) {
            return 4;
        }
        try {
            p1 p1VarA = q1.a();
            try {
                n2 n2Var = s2Var.f5039a;
                int i3 = sVar.b(n2Var.f4616s, n2Var.f4615r) ? 2 : 3;
                p1VarA.close();
                if (!sVar.f1485a) {
                    sVar.f1485a = true;
                    try {
                        ((AccessibilityNodeInfo) sVar.f1486b).recycle();
                    } catch (Throwable unused) {
                    }
                }
                return i3;
            } catch (Throwable th) {
                try {
                    p1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (!sVar.f1485a) {
                sVar.f1485a = true;
                try {
                    ((AccessibilityNodeInfo) sVar.f1486b).recycle();
                } catch (Throwable unused2) {
                }
            }
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:134:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0157 A[Catch: all -> 0x015b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x015b, blocks: (B:83:0x011e, B:85:0x012c, B:87:0x0132, B:89:0x0138, B:91:0x013c, B:93:0x0140, B:95:0x0146, B:99:0x0157), top: B:129:0x011e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v17, types: [android.view.accessibility.AccessibilityNodeInfo] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    @Override // w1.l4
    public k4 e() {
        k4 k4VarA;
        j7 j7Var;
        AccessibilityNodeInfo accessibilityNodeInfoA;
        boolean z2;
        AccessibilityNodeInfo rootInActiveWindow;
        AccessibilityNodeInfo root;
        int layer;
        t2 t2Var = this.f4888c;
        s2 s2Var = this.f4889d;
        g0.s[] sVarArr = this.f4890e;
        k4 k4Var = k4.f4389c;
        k4 k4VarO = t2Var.o(s2Var);
        if (!k4VarO.f4390a) {
            return k4VarO;
        }
        int iM = t2Var.m(s2Var.f5039a);
        if (iM != 0) {
            return k4.a(iM);
        }
        if (t2Var.i(s2Var)) {
            return k4.a(15);
        }
        r1 r1VarA = t2Var.f5132b.a();
        if (r1VarA != null) {
            n2 n2Var = s2Var.f5039a;
            long j3 = n2Var.f4612o;
            if (j3 == 0 || r1VarA.f4973a != j3) {
                k4VarA = k4.a(6);
            } else {
                k4VarA = ((n2Var.f4600b & 4) == 0 || (!r1VarA.f4975c && r1VarA.f4974b == n2Var.f4613p)) ? k4Var : k4.a(7);
            }
        } else {
            k4VarA = k4.a(6);
        }
        if (!k4VarA.f4390a) {
            return k4VarA;
        }
        dc dcVar = t2Var.f5132b;
        String str = s2Var.f5039a.f4614q;
        ScreenMirrorService screenMirrorService = dcVar.f3821a;
        o7 o7Var = screenMirrorService.I3;
        g0.s sVar = null;
        if (o7Var != null && (j7Var = o7Var.f4733l) != null && (accessibilityNodeInfoA = j7Var.a()) != 0 && ((g7) o7Var.f4738r.get(str)) != null) {
            try {
                List<AccessibilityWindowInfo> windows = screenMirrorService.getWindows();
                try {
                    if (windows != null) {
                        Iterator<AccessibilityWindowInfo> it = windows.iterator();
                        z2 = false;
                        int i3 = 0;
                        while (true) {
                            if (it.hasNext()) {
                                AccessibilityWindowInfo next = it.next();
                                if (next != null && !n4.N0(next.getType(), next.isFocused(), next.isActive(), false) && (root = next.getRoot()) != null) {
                                    try {
                                        layer = next.getLayer();
                                    } catch (Throwable unused) {
                                        layer = i3;
                                    }
                                    accessibilityNodeInfoA = ScreenMirrorService.B2(root, "w" + i3, layer, str);
                                    if (accessibilityNodeInfoA == 0) {
                                        try {
                                            root.recycle();
                                        } catch (Throwable unused2) {
                                        }
                                        i3++;
                                        z2 = true;
                                    } else if (accessibilityNodeInfoA != root) {
                                        root.recycle();
                                        accessibilityNodeInfoA = accessibilityNodeInfoA;
                                    }
                                }
                            }
                            if (accessibilityNodeInfoA != 0) {
                                try {
                                    accessibilityNodeInfoA.refresh();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    try {
                                        Rect rect = new Rect();
                                        accessibilityNodeInfoA.getBoundsInScreen(rect);
                                        if (accessibilityNodeInfoA.isVisibleToUser() || !accessibilityNodeInfoA.isEnabled() || rect.isEmpty() || rect.right <= 0 || rect.bottom <= 0 || rect.left >= screenMirrorService.O3 || rect.top >= screenMirrorService.P3) {
                                            accessibilityNodeInfoA.recycle();
                                        } else {
                                            sVar = new g0.s();
                                            sVar.f1487c = screenMirrorService;
                                            sVar.f1486b = accessibilityNodeInfoA;
                                        }
                                    } catch (Throwable unused4) {
                                        accessibilityNodeInfoA.recycle();
                                    }
                                } catch (Throwable unused5) {
                                }
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2 || (rootInActiveWindow = screenMirrorService.getRootInActiveWindow()) == null) {
                        accessibilityNodeInfoA = 0;
                    } else {
                        accessibilityNodeInfoA = ScreenMirrorService.B2(rootInActiveWindow, "active", 0, str);
                        if (accessibilityNodeInfoA == 0) {
                            try {
                                rootInActiveWindow.recycle();
                            } catch (Throwable unused6) {
                            }
                            accessibilityNodeInfoA = 0;
                        } else if (accessibilityNodeInfoA != rootInActiveWindow) {
                            rootInActiveWindow.recycle();
                            accessibilityNodeInfoA = accessibilityNodeInfoA;
                        }
                    }
                } catch (Throwable unused7) {
                }
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("[NodeAction] resolve failed: "), "ScreenMirror");
            }
            if (accessibilityNodeInfoA != 0) {
                accessibilityNodeInfoA.refresh();
                Rect rect2 = new Rect();
                accessibilityNodeInfoA.getBoundsInScreen(rect2);
                if (accessibilityNodeInfoA.isVisibleToUser()) {
                    accessibilityNodeInfoA.recycle();
                } else {
                    accessibilityNodeInfoA.recycle();
                }
            }
        }
        if (sVar == null) {
            return k4.a(8);
        }
        if (sVar.c(s2Var.f5039a.f4615r)) {
            sVarArr[0] = sVar;
            return k4Var;
        }
        if (!sVar.f1485a) {
            sVar.f1485a = true;
            try {
                ((AccessibilityNodeInfo) sVar.f1486b).recycle();
            } catch (Throwable unused8) {
            }
        }
        return k4.a(9);
    }
}
