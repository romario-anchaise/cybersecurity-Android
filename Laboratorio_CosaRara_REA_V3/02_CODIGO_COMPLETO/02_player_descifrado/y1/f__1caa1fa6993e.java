// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import c2.m;
import e2.n1;
import i2.w;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import lyr.stable.runtime.ScreenMirrorService;
import w1.g2;
import w1.le;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f6142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f6143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f6144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0.d f6145d = new d0.d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f6146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f6147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f6148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f6149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f6150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f6151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f6152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashSet f6153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile y.i f6154m;
    public volatile boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f6155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f6156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f6157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f6158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f6159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f6160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f6161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6162v;

    public f(ScreenMirrorService screenMirrorService) {
        m mVar = new m();
        mVar.f438a = -1L;
        mVar.f439b = -1L;
        this.f6147f = mVar;
        this.f6148g = new Object();
        this.f6149h = new Object();
        this.f6150i = new AtomicBoolean();
        this.f6151j = new AtomicBoolean();
        this.f6152k = new AtomicInteger();
        this.f6153l = new LinkedHashSet();
        this.f6154m = new y.i(j.f6206a, Collections.EMPTY_SET);
        this.f6162v = 1;
        this.f6159s = -1L;
        this.f6160t = -1L;
        this.f6161u = -1L;
        this.f6142a = screenMirrorService;
        HandlerThread handlerThread = new HandlerThread("a11y-defense-inspection");
        this.f6143b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f6144c = handler;
        this.f6157q = i(true);
        this.f6146e = new b(new o2(29), new q.c(handler), new n1(this));
    }

    public final void a() {
        this.f6151j.set(false);
        this.f6152k.incrementAndGet();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0044  */
    /* JADX WARN: Code duplicated, block: B:32:0x0046  */
    /* JADX WARN: Code duplicated, block: B:33:0x0048  */
    /* JADX WARN: Code duplicated, block: B:34:0x0049  */
    /* JADX WARN: Code duplicated, block: B:37:0x004e A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0018, B:28:0x003d, B:37:0x004e, B:42:0x0059, B:39:0x0053, B:40:0x0056, B:45:0x005c, B:13:0x001d, B:14:0x0020), top: B:49:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0053 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0018, B:28:0x003d, B:37:0x004e, B:42:0x0059, B:39:0x0053, B:40:0x0056, B:45:0x005c, B:13:0x001d, B:14:0x0020), top: B:49:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0056 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0018, B:28:0x003d, B:37:0x004e, B:42:0x0059, B:39:0x0053, B:40:0x0056, B:45:0x005c, B:13:0x001d, B:14:0x0020), top: B:49:0x0003 }] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
    
        if (r11 != 2) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f6149h
            monitor-enter(r0)
            int r1 = r10.f6162v     // Catch: java.lang.Throwable -> L12
            if (r11 == r1) goto L14
            r10.f6162v = r11     // Catch: java.lang.Throwable -> L12
            r1 = -1
            r10.f6159s = r1     // Catch: java.lang.Throwable -> L12
            r10.f6160t = r1     // Catch: java.lang.Throwable -> L12
            r10.f6161u = r1     // Catch: java.lang.Throwable -> L12
            goto L14
        L12:
            r10 = move-exception
            goto L5e
        L14:
            r1 = 4
            r2 = 3
            if (r11 != r2) goto L1b
            long r3 = r10.f6159s     // Catch: java.lang.Throwable -> L12
            goto L22
        L1b:
            if (r11 != r1) goto L20
            long r3 = r10.f6160t     // Catch: java.lang.Throwable -> L12
            goto L22
        L20:
            long r3 = r10.f6161u     // Catch: java.lang.Throwable -> L12
        L22:
            if (r11 == r2) goto L2a
            if (r11 != r1) goto L27
            goto L2a
        L27:
            r5 = 750(0x2ee, double:3.705E-321)
            goto L2c
        L2a:
            r5 = 80
        L2c:
            if (r11 == 0) goto L5b
            r7 = 0
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 < 0) goto L5b
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L39
            goto L5b
        L39:
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 < 0) goto L44
            long r3 = r12 - r3
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L44
            goto L5b
        L44:
            if (r11 == r2) goto L4c
            if (r11 != r1) goto L49
            goto L4c
        L49:
            r3 = 2
            if (r11 != r3) goto L5b
        L4c:
            if (r11 != r2) goto L51
            r10.f6159s = r12     // Catch: java.lang.Throwable -> L12
            goto L58
        L51:
            if (r11 != r1) goto L56
            r10.f6160t = r12     // Catch: java.lang.Throwable -> L12
            goto L58
        L56:
            r10.f6161u = r12     // Catch: java.lang.Throwable -> L12
        L58:
            r10 = 1
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            return r10
        L5b:
            r10 = 0
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            return r10
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.b(int, long):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d c(AccessibilityEvent accessibilityEvent, boolean z2) {
        AccessibilityNodeInfo source;
        CharSequence packageName;
        CharSequence className;
        CharSequence packageName2;
        CharSequence className2;
        String viewIdResourceName;
        CharSequence text;
        CharSequence contentDescription;
        boolean zIsClickable;
        boolean zIsCheckable;
        boolean zIsChecked;
        boolean zIsEnabled;
        long j3;
        int childCount;
        AccessibilityNodeInfo child;
        d dVar = new d();
        boolean z3 = true;
        w wVar = new w(1);
        dVar.f6138e = wVar;
        if (accessibilityEvent != null) {
            wVar.f2269a = j.q(accessibilityEvent.getPackageName());
            wVar.f2270b = j.q(accessibilityEvent.getClassName());
            try {
                List<CharSequence> text2 = accessibilityEvent.getText();
                if (text2 != null) {
                    for (CharSequence charSequence : text2) {
                        g gVar = new g();
                        gVar.f6173k = true;
                        gVar.f6166d = j.q(charSequence);
                        dVar.d(new h(gVar), null);
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                CharSequence contentDescription2 = accessibilityEvent.getContentDescription();
                if (contentDescription2 != null) {
                    g gVar2 = new g();
                    gVar2.f6173k = true;
                    gVar2.f6167e = contentDescription2.toString();
                    dVar.d(new h(gVar2), null);
                }
            } catch (Throwable unused2) {
            }
        }
        if (z2) {
            source = null;
        } else {
            try {
                source = this.f6142a.getRootInActiveWindow();
            } catch (Throwable unused3) {
                source = null;
            }
        }
        if (source == null && accessibilityEvent != null) {
            try {
                source = accessibilityEvent.getSource();
            } catch (Throwable unused4) {
            }
        }
        if (source == null) {
            dVar.w();
            return dVar;
        }
        ArrayList arrayList = dVar.f6136c;
        arrayList.add(source);
        try {
            packageName = source.getPackageName();
        } catch (Throwable unused5) {
            packageName = "";
        }
        if (packageName != null && packageName.length() > 0) {
            wVar.f2269a = j.q(packageName);
        }
        if (accessibilityEvent == null) {
            try {
                className = source.getClassName();
            } catch (Throwable unused6) {
                className = "";
            }
            wVar.f2270b = j.q(className);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        arrayDeque.add(new e(0, source));
        long jNanoTime = System.nanoTime();
        int i4 = 0;
        while (!arrayDeque.isEmpty() && i4 < 320) {
            long j4 = 6000000;
            if (System.nanoTime() - jNanoTime >= 6000000) {
                break;
            }
            e eVar = (e) arrayDeque.removeFirst();
            AccessibilityNodeInfo accessibilityNodeInfo = eVar.f6140a;
            int i5 = eVar.f6141b;
            g gVar3 = new g();
            gVar3.f6173k = z3;
            try {
                packageName2 = accessibilityNodeInfo.getPackageName();
            } catch (Throwable unused7) {
                packageName2 = "";
            }
            gVar3.f6163a = j.q(packageName2);
            try {
                className2 = accessibilityNodeInfo.getClassName();
            } catch (Throwable unused8) {
                className2 = "";
            }
            gVar3.f6164b = j.q(className2);
            try {
                viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (viewIdResourceName == null) {
                    viewIdResourceName = "";
                }
            } catch (Throwable unused9) {
            }
            gVar3.f6165c = viewIdResourceName.toString();
            try {
                text = accessibilityNodeInfo.getText();
            } catch (Throwable unused10) {
                text = "";
            }
            gVar3.f6166d = j.q(text);
            try {
                contentDescription = accessibilityNodeInfo.getContentDescription();
            } catch (Throwable unused11) {
                contentDescription = "";
            }
            gVar3.f6167e = j.q(contentDescription);
            try {
                zIsClickable = accessibilityNodeInfo.isClickable();
            } catch (Throwable unused12) {
                zIsClickable = i3;
            }
            gVar3.f6170h = zIsClickable;
            try {
                zIsCheckable = accessibilityNodeInfo.isCheckable();
            } catch (Throwable unused13) {
                zIsCheckable = i3;
            }
            gVar3.f6171i = zIsCheckable;
            try {
                zIsChecked = accessibilityNodeInfo.isChecked();
            } catch (Throwable unused14) {
                zIsChecked = i3;
            }
            gVar3.f6172j = zIsChecked;
            try {
                zIsEnabled = accessibilityNodeInfo.isEnabled();
            } catch (Throwable unused15) {
                zIsEnabled = i3;
            }
            gVar3.f6173k = zIsEnabled;
            try {
                Bundle extras = accessibilityNodeInfo.getExtras();
                if (extras == null || extras.isEmpty()) {
                    j3 = j4;
                    break;
                }
                Iterator<String> it = extras.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        j3 = j4;
                        break;
                    }
                    j3 = j4;
                    String next = it.next();
                    if (next == null) {
                        break;
                    }
                    int i6 = i3 + 1;
                    if (i3 >= 12) {
                        break;
                    }
                    try {
                        Object obj = extras.get(next);
                        if (obj != null) {
                            String lowerCase = next.toLowerCase(Locale.ROOT);
                            String strFlattenToString = obj instanceof ComponentName ? ((ComponentName) obj).flattenToString() : obj instanceof CharSequence ? obj.toString() : "";
                            if (!strFlattenToString.isEmpty()) {
                                if (lowerCase.contains("component")) {
                                    gVar3.f6168f = strFlattenToString.toString();
                                    ArrayList arrayList2 = (ArrayList) wVar.f2271c;
                                    String strTrim = strFlattenToString.toString().trim();
                                    if (!strTrim.isEmpty()) {
                                        arrayList2.add(strTrim);
                                    }
                                } else if (lowerCase.contains("target_package") || lowerCase.endsWith(".package_name") || lowerCase.endsWith(":package_name")) {
                                    gVar3.f6169g = strFlattenToString.toString();
                                    ArrayList arrayList3 = (ArrayList) wVar.f2272d;
                                    String strTrim2 = strFlattenToString.toString().trim();
                                    if (!strTrim2.isEmpty()) {
                                        arrayList3.add(strTrim2);
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused16) {
                    }
                    i3 = i6;
                    j4 = j3;
                }
            } catch (Throwable unused17) {
            }
            dVar.d(new h(gVar3), accessibilityNodeInfo);
            i4++;
            if (i5 < 40) {
                try {
                    childCount = accessibilityNodeInfo.getChildCount();
                } catch (Throwable unused18) {
                    childCount = 0;
                }
                for (int i7 = 0; i7 < childCount && arrayDeque.size() + i4 < 320 && System.nanoTime() - jNanoTime < j3; i7++) {
                    try {
                        child = accessibilityNodeInfo.getChild(i7);
                    } catch (Throwable unused19) {
                        child = null;
                    }
                    if (child != null) {
                        arrayList.add(child);
                        arrayDeque.addLast(new e(i5 + 1, child));
                    }
                }
            }
            z3 = true;
            i3 = 0;
        }
        dVar.w();
        return dVar;
    }

    public final int d(d dVar, a aVar) {
        if (!f()) {
            if (this.f6157q) {
                return (this.f6155o || this.f6156p) ? 2 : 1;
            }
            return 3;
        }
        int i3 = aVar.f6123a;
        if (i3 == 2) {
            int i4 = aVar.f6124b;
            ArrayList arrayList = dVar.f6137d;
            AccessibilityNodeInfo accessibilityNodeInfo = (i4 < 0 || i4 >= arrayList.size()) ? null : (AccessibilityNodeInfo) arrayList.get(i4);
            if (accessibilityNodeInfo != null) {
                try {
                    if (this.f6145d.f(accessibilityNodeInfo, 16, new g2(3, this))) {
                        this.f6158r = SystemClock.uptimeMillis();
                        return 5;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!b(aVar.f6123a, SystemClock.uptimeMillis())) {
                return 9;
            }
            g();
            return 6;
        }
        if (i3 == 3) {
            if (!b(aVar.f6123a, SystemClock.uptimeMillis())) {
                return 9;
            }
            g();
            return 7;
        }
        if (i3 != 4) {
            return 1;
        }
        if (!b(aVar.f6123a, SystemClock.uptimeMillis())) {
            return 9;
        }
        g();
        return 8;
    }

    public final boolean e() {
        if (!this.f6157q) {
            return false;
        }
        boolean zI = i(this.f6157q);
        if (!zI) {
            this.f6157q = false;
            this.f6146e.b();
            this.f6147f.a();
            try {
                this.f6144c.post(new c(this, 1));
            } catch (Throwable unused) {
            }
        }
        return zI;
    }

    public final boolean f() {
        return this.n && !this.f6155o && !this.f6156p && this.f6157q;
    }

    public final void g() {
        if (f() && this.f6150i.compareAndSet(false, true)) {
            this.f6158r = SystemClock.uptimeMillis();
            Log.i("A11ySelfDefense", "BACK x3");
            for (int i3 = 1; i3 <= 3; i3++) {
                try {
                    if (!this.f6145d.d(this.f6142a, 1, new g2(3, this))) {
                        break;
                    }
                } catch (Throwable th) {
                    try {
                        Log.d("A11ySelfDefense", "BACK attempt=" + i3 + " failed: " + th.getMessage());
                    } catch (Throwable th2) {
                        this.f6150i.set(false);
                        throw th2;
                    }
                }
            }
            this.f6150i.set(false);
        }
    }

    public final void h(int i3) {
        synchronized (this.f6149h) {
            try {
                if (i3 == this.f6162v) {
                    return;
                }
                this.f6162v = i3;
                this.f6159s = -1L;
                this.f6160t = -1L;
                this.f6161u = -1L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(boolean z2) {
        try {
            PowerManager powerManager = (PowerManager) this.f6142a.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isInteractive();
            }
        } catch (Throwable unused) {
        }
        return z2;
    }

    public final void j() {
        LinkedHashSet linkedHashSet;
        synchronized (this.f6148g) {
            linkedHashSet = new LinkedHashSet(this.f6153l);
        }
        PackageManager packageManager = this.f6142a.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = this.f6142a.getApplicationInfo();
                CharSequence charSequenceLoadLabel = applicationInfo != null ? applicationInfo.loadLabel(packageManager) : null;
                if (charSequenceLoadLabel != null) {
                    String strTrim = charSequenceLoadLabel.toString().trim();
                    if (!strTrim.isEmpty()) {
                        linkedHashSet.add(strTrim);
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(j.f6206a, "lyr.stable.runtime.ScreenMirrorService"), 128);
                CharSequence charSequenceLoadLabel2 = serviceInfo != null ? serviceInfo.loadLabel(packageManager) : null;
                if (charSequenceLoadLabel2 != null) {
                    String strTrim2 = charSequenceLoadLabel2.toString().trim();
                    if (!strTrim2.isEmpty()) {
                        linkedHashSet.add(strTrim2);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        this.f6154m = new y.i(j.f6206a, linkedHashSet);
        Collections.unmodifiableSet(new LinkedHashSet(linkedHashSet));
    }

    public final void k() {
        synchronized (this.f6149h) {
            this.f6162v = 1;
            this.f6159s = -1L;
            this.f6160t = -1L;
            this.f6161u = -1L;
        }
    }

    public final void l() {
        int i3 = 1;
        if (this.f6151j.compareAndSet(false, true)) {
            this.f6144c.postDelayed(new le(this, this.f6152k.incrementAndGet(), i3, 2), ((long) 1) * 16);
        }
    }

    public final void m(boolean z2) {
        this.f6156p = z2;
        if (z2) {
            this.f6146e.b();
            this.f6147f.a();
            try {
                this.f6144c.post(new c(this, 1));
            } catch (Throwable unused) {
            }
        }
    }

    public final void n(boolean z2) {
        this.f6157q = z2;
        if (z2) {
            return;
        }
        this.f6146e.b();
        this.f6147f.a();
        try {
            this.f6144c.post(new c(this, 1));
        } catch (Throwable unused) {
        }
    }
}
