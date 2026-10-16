// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ee implements AutoCloseable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final SecureRandom f3927p = new SecureRandom();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dc f3929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ib f3930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ib f3931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dc f3932g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public be f3936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public vd f3937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g0.j f3938m;
    public boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3939o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3928c = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayDeque f3933h = new ArrayDeque();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f3934i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque f3935j = new ArrayDeque();

    public ee(dc dcVar, ib ibVar, ib ibVar2, dc dcVar2) {
        this.f3929d = dcVar;
        this.f3930e = ibVar;
        this.f3931f = ibVar2;
        this.f3932g = dcVar2;
    }

    public static byte[] B(String str) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static boolean E(String str) {
        if (!str.isEmpty()) {
            int iCharCount = 0;
            while (iCharCount < str.length()) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt == 42 || iCodePointAt == 8226 || iCodePointAt == 9679 || iCodePointAt == 8729 || iCodePointAt == 9642 || iCodePointAt == 183) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            return true;
        }
        return false;
    }

    public static boolean J(kc kcVar, int i3, int i4, String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = kcVar.f4415d;
        if (i3 == 0 && i4 == 0 && str.isEmpty()) {
            return true;
        }
        return accessibilityNodeInfo.getTextSelectionStart() == i3 && accessibilityNodeInfo.getTextSelectionEnd() == i4;
    }

    public static boolean K(be beVar, int i3, int i4) {
        return beVar.f3624i && Math.min(i3, i4) == Math.min(beVar.f3622g, beVar.f3623h) && Math.max(i3, i4) == Math.max(beVar.f3622g, beVar.f3623h);
    }

    public final void A(vd vdVar, kc kcVar) throws Throwable {
        be beVar = vdVar.f5336c;
        String str = (String) kcVar.f4416e;
        if (str.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        AccessibilityNodeInfo accessibilityNodeInfo = kcVar.f4415d;
        try {
            if (accessibilityNodeInfo.refresh() && accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocused()) {
                synchronized (this.f3928c) {
                    try {
                        if (this.f3939o || beVar.f3618c) {
                            throw new wd();
                        }
                        String str2 = beVar.f3619d;
                        if (str2 == null) {
                            beVar.f3619d = str;
                        } else if (!str2.equals(str)) {
                            throw new wd();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ud udVar = vdVar.f5335b;
                int i3 = udVar.f5249a;
                if (i3 == 12) {
                    synchronized (this.f3928c) {
                        if (this.f3939o || beVar.f3618c || this.f3936k != beVar) {
                            throw new wd();
                        }
                        zd zdVar = beVar.f3627l;
                        if (zdVar == null || !zdVar.f5739a.equals(vdVar.f5335b.f5254f)) {
                            throw new xd();
                        }
                        d(beVar);
                    }
                    C(vdVar, 4, 0, false);
                    return;
                }
                if ((i3 == 9 || i3 == 10) && kcVar.f4415d.isPassword()) {
                    throw new UnsupportedOperationException();
                }
                p2.x xVarF = F(beVar, kcVar);
                int i4 = xVarF.f2996a;
                int i5 = xVarF.f2997b;
                String str3 = (String) xVarF.f2998c;
                int i6 = udVar.f5249a;
                if ((i6 == 9 || i6 == 10) && i4 != i5 && !ScreenMirrorService.n(16384, kcVar.f4415d)) {
                    throw new UnsupportedOperationException();
                }
                int i7 = udVar.f5249a;
                if (i7 == 9 || i7 == 10) {
                    w(vdVar, beVar, kcVar, str3, i4, i5);
                    return;
                }
                if (i7 != 11) {
                    try {
                        fe feVarA = fe.a(udVar, str3, i4, i5, beVar.f3622g, beVar.f3623h, beVar.f3624i);
                        synchronized (this.f3928c) {
                            try {
                                if (this.f3939o || beVar.f3618c || this.f3936k != beVar) {
                                    throw new wd();
                                }
                                y(beVar, kcVar, str3, i4, i5);
                                if (!feVarA.f4055h) {
                                    if (feVarA.f4053f && !ScreenMirrorService.n(2097152, kcVar.f4415d)) {
                                        throw new UnsupportedOperationException();
                                    }
                                    if (feVarA.f4053f && !kcVar.w(feVarA.f4048a)) {
                                        D(vdVar);
                                        return;
                                    }
                                    boolean zD = (!feVarA.f4054g || J(kcVar, feVarA.f4049b, feVarA.f4050c, feVarA.f4048a)) ? false : kcVar.d(feVarA.f4049b, feVarA.f4050c);
                                    if (feVarA.f4054g && !zD && !J(kcVar, feVarA.f4049b, feVarA.f4050c, feVarA.f4048a)) {
                                        if (feVarA.f4053f) {
                                            kcVar.w(str3);
                                            kcVar.d(i4, i5);
                                        }
                                        D(vdVar);
                                        return;
                                    }
                                } else if (!kcVar.f4415d.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER.getId())) {
                                    C(vdVar, 5, 9, false);
                                    return;
                                }
                                beVar.f3620e = feVarA.f4048a;
                                beVar.f3621f = true;
                                beVar.f3622g = feVarA.f4051d;
                                beVar.f3623h = feVarA.f4052e;
                                beVar.f3624i = true;
                                beVar.f3625j = feVarA.f4053f || feVarA.f4054g;
                                this.f3929d.getClass();
                                beVar.f3626k = SystemClock.uptimeMillis() + 800;
                                d(beVar);
                                C(vdVar, 4, 0, true);
                                return;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (IllegalArgumentException unused) {
                        throw new yd();
                    }
                }
                synchronized (this.f3928c) {
                    try {
                        if (this.f3939o || beVar.f3618c || this.f3936k != beVar) {
                            throw new wd();
                        }
                        zd zdVar2 = beVar.f3627l;
                        d(beVar);
                        if (zdVar2 != null) {
                            this.f3929d.getClass();
                            if (SystemClock.uptimeMillis() <= zdVar2.f5744f && zdVar2.f5739a.equals(vdVar.f5335b.f5254f)) {
                                int iMin = Math.min(i4, i5);
                                int iMax = Math.max(i4, i5);
                                if (!zdVar2.f5740b.equals((String) kcVar.f4416e) || iMin != zdVar2.f5741c || iMax != zdVar2.f5742d || !MessageDigest.isEqual(zdVar2.f5743e, B(str3.substring(iMin, iMax)))) {
                                    throw new xd();
                                }
                                try {
                                    y(beVar, kcVar, str3, i4, i5);
                                    if (!ScreenMirrorService.n(2097152, kcVar.f4415d) || !ScreenMirrorService.n(131072, kcVar.f4415d)) {
                                        throw new UnsupportedOperationException();
                                    }
                                    String strConcat = str3.substring(0, iMin).concat(str3.substring(iMax));
                                    if (!kcVar.w(strConcat)) {
                                        D(vdVar);
                                        return;
                                    }
                                    if (!kcVar.d(iMin, iMin)) {
                                        kcVar.w(str3);
                                        kcVar.d(i4, i5);
                                        D(vdVar);
                                        return;
                                    }
                                    beVar.f3620e = strConcat;
                                    beVar.f3621f = true;
                                    beVar.f3622g = iMin;
                                    beVar.f3623h = iMin;
                                    beVar.f3624i = true;
                                    beVar.f3625j = true;
                                    this.f3929d.getClass();
                                    beVar.f3626k = SystemClock.uptimeMillis() + 800;
                                    C(vdVar, 4, 0, true);
                                    return;
                                } catch (wd unused2) {
                                    throw new xd();
                                }
                            }
                        }
                        throw new xd();
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        throw new ce();
    }

    public final void C(vd vdVar, int i3, int i4, boolean z2) {
        g0.j jVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        synchronized (this.f3928c) {
            try {
                ae aeVar = (ae) this.f3934i.get(Integer.valueOf(vdVar.f5334a));
                if (aeVar != null) {
                    aeVar.f3513c = true;
                    aeVar.f3514d = i3;
                    aeVar.f3515e = i4;
                }
                if (this.f3937l == vdVar && (jVar = this.f3938m) != null) {
                    Handler handler = this.f3929d.f3821a.f2541t;
                    if (handler != null) {
                        handler.removeCallbacks(jVar);
                    }
                    this.f3938m = null;
                }
                if (this.f3937l == vdVar) {
                    this.f3937l = null;
                }
                if (i3 != 4) {
                    G(vdVar.f5336c, arrayDeque);
                }
                I();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3930e.a(vdVar.f5334a, i3, i4);
        if (i3 == 4 && z2) {
            ScreenMirrorService screenMirrorService = this.f3932g.f3821a;
            rd rdVar = ScreenMirrorService.n6;
            screenMirrorService.a6(true);
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            C((vd) it.next(), 5, i4, false);
        }
    }

    public final void D(vd vdVar) {
        C(vdVar, 3, 4, false);
    }

    public final p2.x F(be beVar, kc kcVar) {
        String string;
        String str;
        String str2;
        AccessibilityNodeInfo accessibilityNodeInfo = kcVar.f4415d;
        try {
            if (accessibilityNodeInfo.isShowingHintText()) {
                string = "";
            } else {
                CharSequence text = accessibilityNodeInfo.getText();
                string = text == null ? null : text.toString();
            }
        } catch (Throwable unused) {
        }
        int textSelectionStart = kcVar.f4415d.getTextSelectionStart();
        int textSelectionEnd = kcVar.f4415d.getTextSelectionEnd();
        if (string != null && string.isEmpty() && textSelectionStart == -1 && textSelectionEnd == -1) {
            textSelectionStart = 0;
            textSelectionEnd = 0;
        }
        synchronized (this.f3928c) {
            if (beVar.f3625j && beVar.f3621f && beVar.f3624i) {
                String str3 = beVar.f3620e;
                int i3 = beVar.f3622g;
                int i4 = beVar.f3623h;
                long j3 = beVar.f3626k;
                if (string != null && !E(string)) {
                    boolean zEquals = string.equals(str3);
                    boolean z2 = Math.min(textSelectionStart, textSelectionEnd) == Math.min(i3, i4) && Math.max(textSelectionStart, textSelectionEnd) == Math.max(i3, i4);
                    if (!zEquals || !z2) {
                        this.f3929d.getClass();
                        if (SystemClock.uptimeMillis() < j3) {
                            throw new ce();
                        }
                        throw new wd();
                    }
                    synchronized (this.f3928c) {
                        try {
                            if (beVar.f3626k == j3) {
                                beVar.f3625j = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }
        boolean z3 = string != null && E(string);
        if (kcVar.f4415d.isPassword()) {
            if (beVar.f3621f && (str2 = beVar.f3620e) != null && textSelectionStart >= 0 && textSelectionEnd >= 0 && textSelectionStart <= str2.length() && textSelectionEnd <= str2.length() && K(beVar, textSelectionStart, textSelectionEnd) && string != null) {
                if (!string.equals(beVar.f3620e)) {
                    if (z3) {
                        String str4 = beVar.f3620e;
                        if (string.codePointCount(0, string.length()) == str4.codePointCount(0, str4.length())) {
                        }
                    }
                    if (string != null) {
                    }
                    throw new de();
                }
                string = beVar.f3620e;
            } else {
                if (string != null || !string.isEmpty()) {
                    throw new de();
                }
                string = "";
            }
        } else if (string == null || z3) {
            if (z3 && beVar.f3621f && (str = beVar.f3620e) != null && textSelectionStart >= 0 && textSelectionEnd >= 0 && textSelectionStart <= str.length() && textSelectionEnd <= str.length() && K(beVar, textSelectionStart, textSelectionEnd)) {
                String str5 = beVar.f3620e;
                if (string.codePointCount(0, string.length()) == str5.codePointCount(0, str5.length())) {
                    string = beVar.f3620e;
                }
            }
            throw new de();
        }
        try {
            fe.c(textSelectionStart, textSelectionEnd, string);
            return new p2.x(textSelectionStart, textSelectionEnd, string);
        } catch (IllegalArgumentException unused2) {
            throw new yd();
        }
    }

    public final void G(be beVar, ArrayDeque arrayDeque) {
        if (beVar == null || beVar.f3618c) {
            return;
        }
        beVar.f3618c = true;
        d(beVar);
        Long lValueOf = Long.valueOf(beVar.f3616a);
        ArrayDeque arrayDeque2 = this.f3935j;
        arrayDeque2.addLast(lValueOf);
        while (arrayDeque2.size() > 256) {
            arrayDeque2.removeFirst();
        }
        Iterator it = this.f3933h.iterator();
        while (it.hasNext()) {
            vd vdVar = (vd) it.next();
            if (vdVar.f5336c == beVar) {
                it.remove();
                arrayDeque.addLast(vdVar);
            }
        }
    }

    public final boolean H(vd vdVar) {
        Handler handler;
        this.f3929d.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis() - vdVar.f5337d;
        if (jUptimeMillis >= 800 || vdVar.f5336c.f3618c) {
            return false;
        }
        g0.j jVar = new g0.j(this, vdVar, 10);
        synchronized (this.f3928c) {
            try {
                if (!this.f3939o && !vdVar.f5336c.f3618c && this.f3937l == vdVar) {
                    g0.j jVar2 = this.f3938m;
                    if (jVar2 != null && (handler = this.f3929d.f3821a.f2541t) != null) {
                        handler.removeCallbacks(jVar2);
                    }
                    this.f3938m = jVar;
                    dc dcVar = this.f3929d;
                    long jMin = Math.min(40L, 800 - jUptimeMillis);
                    Handler handler2 = dcVar.f3821a.f2541t;
                    if (handler2 != null) {
                        handler2.postDelayed(jVar, jMin);
                    }
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void I() {
        if (this.f3939o || this.n || this.f3937l != null || this.f3933h.isEmpty()) {
            return;
        }
        this.n = true;
        v8 v8Var = new v8(9, this);
        Handler handler = this.f3929d.f3821a.f2541t;
        if (handler != null) {
            handler.post(v8Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0095 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0099  */
    /* JADX WARN: Code duplicated, block: B:51:0x009d A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b1 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c8 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:8:0x0015, B:67:0x010b, B:69:0x0117, B:70:0x0133, B:14:0x0021, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0043, B:27:0x004c, B:31:0x0055, B:33:0x005b, B:38:0x006c, B:40:0x0072, B:44:0x0083, B:45:0x0086, B:48:0x0095, B:51:0x009d, B:55:0x00ab, B:56:0x00b1, B:60:0x00be, B:62:0x00c1, B:63:0x00c8), top: B:81:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0103  */
    public final void L(int i3, ud udVar) {
        boolean z2;
        long j3;
        be beVar;
        int i4;
        int i5;
        int i6;
        long j4;
        long j5;
        int size;
        int i7;
        if (i3 <= 0 || i3 > 65535) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        synchronized (this.f3928c) {
            try {
                z2 = false;
                if (this.f3939o) {
                    i6 = 13;
                } else {
                    ae aeVar = (ae) this.f3934i.get(Integer.valueOf(i3));
                    if (aeVar == null) {
                        be beVar2 = this.f3936k;
                        if (beVar2 != null) {
                            j3 = 1;
                            if (beVar2.f3616a == udVar.f5251c) {
                                beVar = beVar2;
                                i4 = 0;
                                i5 = -1;
                            }
                            if (i5 < 0) {
                                z2 = false;
                                i6 = i4;
                            } else if (beVar.f3618c) {
                                i6 = 33;
                                i5 = 5;
                            } else {
                                j4 = udVar.f5252d;
                                j5 = beVar.f3617b;
                                if (j4 < j5) {
                                    i6 = 31;
                                } else if (j4 > j5) {
                                    G(beVar, arrayDeque);
                                    i6 = 32;
                                } else {
                                    size = this.f3933h.size();
                                    if (this.f3937l == null) {
                                        i7 = 0;
                                    } else {
                                        i7 = 1;
                                    }
                                    if (size + i7 >= 32) {
                                        G(beVar, arrayDeque);
                                        i6 = 38;
                                    } else {
                                        beVar.f3617b += j3;
                                        this.f3934i.put(Integer.valueOf(i3), new ae(udVar.f5251c, udVar.f5252d));
                                        M();
                                        ArrayDeque arrayDeque2 = this.f3933h;
                                        this.f3929d.getClass();
                                        arrayDeque2.addLast(new vd(i3, udVar, beVar, SystemClock.uptimeMillis()));
                                        this.f3930e.a(i3, 0, 0);
                                        I();
                                        i5 = 0;
                                        i6 = i4;
                                        z2 = true;
                                    }
                                }
                            }
                        } else {
                            j3 = 1;
                        }
                        if (udVar.f5252d != j3 || this.f3935j.contains(Long.valueOf(udVar.f5251c))) {
                            beVar = beVar2;
                            i4 = 32;
                            i5 = 5;
                        } else {
                            if (beVar2 != null) {
                                G(beVar2, arrayDeque);
                            }
                            beVar2 = new be(udVar.f5251c);
                            this.f3936k = beVar2;
                            beVar = beVar2;
                            i4 = 0;
                            i5 = -1;
                        }
                        if (i5 < 0) {
                            z2 = false;
                            i6 = i4;
                        } else if (beVar.f3618c) {
                            i6 = 33;
                            i5 = 5;
                        } else {
                            j4 = udVar.f5252d;
                            j5 = beVar.f3617b;
                            if (j4 < j5) {
                                i6 = 31;
                            } else if (j4 > j5) {
                                G(beVar, arrayDeque);
                                i6 = 32;
                            } else {
                                size = this.f3933h.size();
                                if (this.f3937l == null) {
                                    i7 = 0;
                                } else {
                                    i7 = 1;
                                }
                                if (size + i7 >= 32) {
                                    G(beVar, arrayDeque);
                                    i6 = 38;
                                } else {
                                    beVar.f3617b += j3;
                                    this.f3934i.put(Integer.valueOf(i3), new ae(udVar.f5251c, udVar.f5252d));
                                    M();
                                    ArrayDeque arrayDeque3 = this.f3933h;
                                    this.f3929d.getClass();
                                    arrayDeque3.addLast(new vd(i3, udVar, beVar, SystemClock.uptimeMillis()));
                                    this.f3930e.a(i3, 0, 0);
                                    I();
                                    i5 = 0;
                                    i6 = i4;
                                    z2 = true;
                                }
                            }
                        }
                    } else if (aeVar.f3511a == udVar.f5251c && aeVar.f3512b == udVar.f5252d) {
                        boolean z3 = aeVar.f3513c;
                        i5 = z3 ? aeVar.f3514d : 0;
                        i6 = z3 ? aeVar.f3515e : 0;
                        z2 = false;
                    } else {
                        i6 = 12;
                    }
                    if (i5 != -1 && i5 != 0 && !this.f3934i.containsKey(Integer.valueOf(i3))) {
                        ae aeVar2 = new ae(udVar.f5251c, udVar.f5252d);
                        aeVar2.f3513c = true;
                        aeVar2.f3514d = i5;
                        aeVar2.f3515e = i6;
                        this.f3934i.put(Integer.valueOf(i3), aeVar2);
                        M();
                    }
                }
                i5 = 5;
                if (i5 != -1) {
                    ae aeVar3 = new ae(udVar.f5251c, udVar.f5252d);
                    aeVar3.f3513c = true;
                    aeVar3.f3514d = i5;
                    aeVar3.f3515e = i6;
                    this.f3934i.put(Integer.valueOf(i3), aeVar3);
                    M();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            C((vd) it.next(), 5, 33, false);
        }
        if (z2) {
            return;
        }
        this.f3930e.a(i3, i5, i6);
    }

    public final void M() {
        LinkedHashMap linkedHashMap = this.f3934i;
        if (linkedHashMap.size() <= 256) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (linkedHashMap.size() > 256 && it.hasNext()) {
            if (((ae) ((Map.Entry) it.next()).getValue()).f3513c) {
                it.remove();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        ArrayDeque arrayDeque = new ArrayDeque();
        synchronized (this.f3928c) {
            try {
                if (this.f3939o) {
                    return;
                }
                this.f3939o = true;
                be beVar = this.f3936k;
                if (beVar != null) {
                    d(beVar);
                }
                arrayDeque.addAll(this.f3933h);
                this.f3933h.clear();
                g0.j jVar = this.f3938m;
                if (jVar != null) {
                    Handler handler = this.f3929d.f3821a.f2541t;
                    if (handler != null) {
                        handler.removeCallbacks(jVar);
                    }
                    this.f3938m = null;
                }
                vd vdVar = this.f3937l;
                if (vdVar != null) {
                    vdVar.f5336c.f3618c = true;
                    this.f3937l = null;
                }
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    C((vd) it.next(), 5, 13, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(be beVar) {
        zd zdVar;
        if (beVar == null || (zdVar = beVar.f3627l) == null) {
            return;
        }
        beVar.f3627l = null;
        e2.q0 q0Var = zdVar.f5745g;
        if (q0Var != null) {
            Handler handler = this.f3929d.f3821a.f2541t;
            if (handler != null) {
                handler.removeCallbacks(q0Var);
            }
            zdVar.f5745g = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    public final void w(vd vdVar, be beVar, kc kcVar, String str, int i3, int i4) throws Throwable {
        int i5;
        int i6;
        zd zdVar;
        int i7;
        l2 l2Var;
        Object obj;
        boolean z2;
        if (kcVar.f4415d.isPassword()) {
            throw new UnsupportedOperationException();
        }
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        int i8 = iMin == iMax ? 1 : 0;
        if (i8 == 0 && !ScreenMirrorService.n(16384, kcVar.f4415d)) {
            throw new UnsupportedOperationException();
        }
        String strSubstring = i8 != 0 ? "" : str.substring(iMin, iMax);
        int i9 = vdVar.f5335b.f5249a == 9 ? 1 : 2;
        if (i9 == 2) {
            Object obj2 = this.f3928c;
            synchronized (obj2) {
                try {
                    try {
                        zd zdVar2 = beVar.f3627l;
                        if (zdVar2 != null) {
                            this.f3929d.getClass();
                            obj = obj2;
                            z2 = SystemClock.uptimeMillis() <= zdVar2.f5744f;
                            if (zdVar2 != null && !z2) {
                                d(beVar);
                            }
                            if (z2) {
                                C(vdVar, 5, 35, false);
                                return;
                            }
                        } else {
                            obj = obj2;
                        }
                        if (zdVar2 != null) {
                            d(beVar);
                        }
                        if (z2) {
                            C(vdVar, 5, 35, false);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            throw th;
        }
        String string = "";
        try {
            if (i8 == 0) {
                if (i9 == 2) {
                    byte[] bArr = new byte[16];
                    f3927p.nextBytes(bArr);
                    StringBuilder sb = new StringBuilder(32);
                    for (int i10 = 0; i10 < 16; i10++) {
                        byte b3 = bArr[i10];
                        sb.append(Character.forDigit((b3 >>> 4) & 15, 16));
                        sb.append(Character.forDigit(b3 & 15, 16));
                    }
                    string = sb.toString();
                    String str2 = (String) kcVar.f4416e;
                    byte[] bArrB = B(strSubstring);
                    this.f3929d.getClass();
                    i6 = 5;
                    i5 = 2;
                    zdVar = new zd(string, str2, iMin, iMax, bArrB, SystemClock.uptimeMillis() + 5000);
                } else {
                    i5 = 2;
                }
                String str3 = string;
                int i11 = vdVar.f5334a;
                ud udVar = vdVar.f5335b;
                int i12 = i9;
                byte[] bArrJ = n4.J(i12, i8, i11, udVar.f5251c, udVar.f5252d, str3, strSubstring);
                synchronized (this.f3928c) {
                    try {
                        if (!this.f3939o || beVar.f3618c || this.f3936k != beVar) {
                            throw new wd();
                        }
                        i7 = i6;
                        y(beVar, kcVar, str, i3, i4);
                        d(beVar);
                        if (i12 == i5) {
                            beVar.f3627l = zdVar;
                            if (zdVar != null) {
                                e2.q0 q0Var = new e2.q0(this, beVar, zdVar, 15);
                                zdVar.f5745g = q0Var;
                                Handler handler = this.f3929d.f3821a.f2541t;
                                if (handler != null) {
                                    handler.postDelayed(q0Var, 5000L);
                                }
                            }
                        }
                        beVar.f3620e = str;
                        beVar.f3621f = true;
                        beVar.f3622g = i3;
                        beVar.f3623h = i4;
                        beVar.f3624i = true;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                ib ibVar = this.f3931f;
                ScreenMirrorService screenMirrorService = ibVar.f4279a;
                OutputStream outputStream = ibVar.f4280b;
                synchronized (screenMirrorService.B) {
                    l2Var = (l2) screenMirrorService.C.get(outputStream);
                }
                if (l2Var != null && l2Var.d(bArrJ)) {
                    C(vdVar, 4, i8 != 0 ? 34 : 0, false);
                    return;
                }
                screenMirrorService.I4(outputStream, new IOException("TextEdit result queue unavailable"));
                synchronized (this.f3928c) {
                    try {
                        if (beVar.f3627l == zdVar) {
                            d(beVar);
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                C(vdVar, i7, 13, false);
                return;
            }
            i5 = 2;
            int i13 = vdVar.f5334a;
            ud udVar2 = vdVar.f5335b;
            int i14 = i9;
            byte[] bArrJ2 = n4.J(i14, i8, i13, udVar2.f5251c, udVar2.f5252d, str3, strSubstring);
            synchronized (this.f3928c) {
                if (!this.f3939o) {
                }
                throw new wd();
            }
        } catch (IllegalArgumentException unused) {
            throw new UnsupportedOperationException();
        }
        i6 = 5;
        zdVar = null;
        String str4 = string;
    }

    public final void y(be beVar, kc kcVar, String str, int i3, int i4) {
        AccessibilityNodeInfo accessibilityNodeInfo = kcVar.f4415d;
        try {
            if (accessibilityNodeInfo.refresh() && accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocused()) {
                p2.x xVarF = F(beVar, kcVar);
                if (xVarF.f2996a != i3 || xVarF.f2997b != i4) {
                    throw new wd();
                }
                if (!str.equals((String) xVarF.f2998c)) {
                    throw new wd();
                }
                return;
            }
        } catch (Throwable unused) {
        }
        throw new ce();
    }

    public final void z(vd vdVar) {
        if (vdVar.f5336c.f3618c) {
            C(vdVar, 5, 33, false);
            return;
        }
        this.f3929d.getClass();
        if (SystemClock.uptimeMillis() - vdVar.f5337d > 4000) {
            C(vdVar, 5, 15, false);
            return;
        }
        ScreenMirrorService screenMirrorService = this.f3932g.f3821a;
        rd rdVar = ScreenMirrorService.n6;
        AccessibilityNodeInfo accessibilityNodeInfoF2 = screenMirrorService.F2();
        kc kcVar = accessibilityNodeInfoF2 == null ? null : new kc(accessibilityNodeInfoF2, ScreenMirrorService.x7(accessibilityNodeInfoF2));
        if (kcVar == null) {
            if (H(vdVar)) {
                return;
            }
            C(vdVar, 5, 8, false);
            return;
        }
        try {
            A(vdVar, kcVar);
        } catch (wd unused) {
            C(vdVar, 5, 33, false);
        } catch (UnsupportedOperationException unused2) {
            C(vdVar, 5, 9, false);
        } catch (yd unused3) {
            if (!H(vdVar)) {
                C(vdVar, 5, 29, false);
            }
        } catch (de unused4) {
            if (!H(vdVar)) {
                C(vdVar, 5, 30, false);
            }
        } catch (ce unused5) {
            if (!H(vdVar)) {
                C(vdVar, 5, 8, false);
            }
        } catch (xd unused6) {
            C(vdVar, 5, 29, false);
        } catch (Throwable unused7) {
            D(vdVar);
        } finally {
            kcVar.close();
        }
    }
}
