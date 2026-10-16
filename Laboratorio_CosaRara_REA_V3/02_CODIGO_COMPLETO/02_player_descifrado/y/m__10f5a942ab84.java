// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.work.impl.WorkDatabase_Impl;
import f2.c0;
import f2.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements a1.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f5995e;

    public m(i iVar, u.b bVar) {
        iVar.getClass();
        w.e eVar = (w.e) iVar.f5983a;
        eVar.getClass();
        v.a aVar = new v.a(eVar, 0);
        w.a aVar2 = (w.a) iVar.f5984b;
        aVar2.getClass();
        v.a aVar3 = new v.a(aVar2, 1);
        w.e eVar2 = (w.e) iVar.f5986d;
        eVar2.getClass();
        v.a aVar4 = new v.a(eVar2, 4);
        w.e eVar3 = (w.e) iVar.f5985c;
        eVar3.getClass();
        v.b[] bVarArr = {aVar, aVar3, aVar4, new v.a(eVar3, 2), new v.a(eVar3, 3), new v.d(eVar3), new v.c(eVar3)};
        this.f5993c = bVar;
        this.f5994d = bVarArr;
        this.f5995e = new Object();
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, ArrayList arrayList2, int i3, boolean z2) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null || i3 > 8) {
            return;
        }
        if (!z2) {
            String strReplaceAll = n(accessibilityNodeInfo).toLowerCase(Locale.ROOT).replaceAll("[\\s_\\-·•]+", "");
            if (strReplaceAll.length() >= 4) {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    String str = (String) obj;
                    if (strReplaceAll.contains(str) || str.contains(strReplaceAll)) {
                        arrayList2.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
                        break;
                    }
                }
            }
        } else {
            String strReplaceAll2 = n(accessibilityNodeInfo).toLowerCase(Locale.ROOT).replaceAll("[\\s_\\-·•]+", "");
            if (strReplaceAll2.length() >= 4) {
                int size2 = arrayList.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj2 = arrayList.get(i5);
                    i5++;
                    if (strReplaceAll2.equals((String) obj2)) {
                        arrayList2.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
                        break;
                    }
                }
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            try {
                child = accessibilityNodeInfo.getChild(i6);
                try {
                    f(child, arrayList, arrayList2, i3 + 1, z2);
                    q(child);
                } catch (Throwable th) {
                    th = th;
                    q(child);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                child = null;
            }
        }
    }

    public static AccessibilityNodeInfo j(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 12) {
            if (accessibilityNodeInfo.isScrollable()) {
                return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoJ = j(i3 + 1, child);
                        if (accessibilityNodeInfoJ != null) {
                            q(child);
                            return accessibilityNodeInfoJ;
                        }
                        q(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        q(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo k(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (accessibilityNodeInfo.isCheckable()) {
            return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                try {
                    AccessibilityNodeInfo accessibilityNodeInfoK = k(child);
                    if (accessibilityNodeInfoK != null) {
                        q(child);
                        return accessibilityNodeInfoK;
                    }
                    q(child);
                } catch (Throwable th) {
                    th = th;
                    accessibilityNodeInfo2 = child;
                    q(accessibilityNodeInfo2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0019  */
    public static boolean m(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        boolean z2;
        AccessibilityNodeInfo accessibilityNodeInfoK = k(accessibilityNodeInfo);
        if (accessibilityNodeInfoK != null) {
            try {
                if (accessibilityNodeInfoK.isCheckable() && accessibilityNodeInfoK.isChecked()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } finally {
                q(accessibilityNodeInfoK);
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    public static String n(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null) {
            sb.append(text);
            sb.append(' ');
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null) {
            sb.append(contentDescription);
        }
        return sb.toString();
    }

    public static ArrayList o(AccessibilityService accessibilityService) {
        ArrayList arrayList = new ArrayList();
        try {
            CharSequence charSequenceLoadLabel = accessibilityService.getApplicationInfo().loadLabel(accessibilityService.getPackageManager());
            if (charSequenceLoadLabel != null && charSequenceLoadLabel.length() > 0) {
                arrayList.add(charSequenceLoadLabel.toString());
            }
        } catch (Throwable unused) {
        }
        arrayList.add(accessibilityService.getPackageName());
        return arrayList;
    }

    public static void q(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    @Override // a1.e
    public void a(Object obj) {
        z0.g gVar = (z0.g) this.f5993c;
        try {
            if (obj instanceof String) {
                v2.g gVar2 = gVar.n;
                gVar2.getClass();
                w2.k kVar = w2.k.f5778f;
                gVar2.g(1, e0.i.d((String) obj));
            } else if (obj instanceof byte[]) {
                v2.g gVar3 = gVar.n;
                byte[] bArr = (byte[]) obj;
                w2.k kVar2 = new w2.k(Arrays.copyOf(bArr, bArr.length));
                gVar3.getClass();
                gVar3.g(2, kVar2);
            }
        } catch (IllegalStateException unused) {
            z0.g.f6295o.fine("websocket closed before we could write");
        }
        int[] iArr = (int[]) this.f5994d;
        int i3 = iArr[0] - 1;
        iArr[0] = i3;
        if (i3 == 0) {
            ((a2.i) this.f5995e).run();
        }
    }

    public boolean b(String str) {
        v.b bVar;
        boolean z2;
        str.getClass();
        synchronized (this.f5995e) {
            try {
                v.b[] bVarArr = (v.b[]) this.f5994d;
                int length = bVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        bVar = null;
                        break;
                    }
                    bVar = bVarArr[i3];
                    bVar.getClass();
                    Object obj = bVar.f3271d;
                    if (obj != null && bVar.b(obj) && bVar.f3270c.contains(str)) {
                        break;
                    }
                    i3++;
                }
                if (bVar != null) {
                    p.m.d().a(u.c.f3249a, "Work " + str + " constrained by " + bVar.getClass().getSimpleName());
                }
                z2 = bVar == null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public boolean c(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) throws Throwable {
        boolean z2 = false;
        if (accessibilityNodeInfo == null) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfoI = i(accessibilityNodeInfo, f2.l.V(arrayList), arrayList);
        if (accessibilityNodeInfoI != null) {
            try {
                if (m(accessibilityNodeInfoI) && e(accessibilityNodeInfoI, false)) {
                    z2 = true;
                }
            } finally {
                q(accessibilityNodeInfoI);
            }
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    public int d(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, int i3, boolean z2) throws Throwable {
        int i4;
        int i5;
        boolean z3;
        s sVar = (s) this.f5995e;
        if (accessibilityNodeInfo == null) {
            return 5;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AccessibilityNodeInfo accessibilityNodeInfoI = i(accessibilityNodeInfo, f2.l.V(arrayList), arrayList);
        boolean zE = false;
        boolean z4 = accessibilityNodeInfoI != null;
        if (sVar != null) {
            if (z4) {
                sVar.f1325c = true;
                sVar.f1323a = 0;
                sVar.f1324b++;
            } else if (!sVar.f1325c) {
                i4 = 2;
                i5 = 3;
                if (jCurrentTimeMillis - sVar.f1328f < (z2 ? 900L : 2000L)) {
                    z3 = false;
                } else {
                    if (jCurrentTimeMillis - sVar.f1327e < (z2 ? 900L : 2000L)) {
                        z3 = false;
                    } else {
                        int i6 = sVar.f1323a + 1;
                        sVar.f1323a = i6;
                        if (i6 >= (z2 ? 1 : 3)) {
                            if (sVar.f1324b < (z2 ? 1 : 2) + (z2 ? 1 : 3)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            z3 = false;
                        }
                    }
                }
            }
            z3 = false;
            i4 = 2;
            i5 = 3;
        } else {
            z3 = false;
            i4 = 2;
            i5 = 3;
        }
        try {
            if (accessibilityNodeInfoI == null) {
                if (z3) {
                    AccessibilityNodeInfo accessibilityNodeInfoJ = j(0, accessibilityNodeInfo);
                    if (accessibilityNodeInfoJ != null) {
                        try {
                            zE = ((d0.d) this.f5993c).e(4096, accessibilityNodeInfoJ);
                        } catch (Throwable th) {
                            q(accessibilityNodeInfoJ);
                            throw th;
                        }
                    }
                    q(accessibilityNodeInfoJ);
                    if (zE) {
                        sVar.f1327e = jCurrentTimeMillis;
                        q(accessibilityNodeInfoI);
                        return 4;
                    }
                }
                q(accessibilityNodeInfoI);
                return 5;
            }
            if (m(accessibilityNodeInfoI)) {
                q(accessibilityNodeInfoI);
                return i4;
            }
            if (i3 == 4) {
                if (jCurrentTimeMillis - c0.C[g.d.a(12)] < 2000) {
                    q(accessibilityNodeInfoI);
                    return i5;
                }
            }
            if (sVar == null || jCurrentTimeMillis - sVar.f1326d < 1200) {
                q(accessibilityNodeInfoI);
                return 5;
            }
            if (!e(accessibilityNodeInfoI, true)) {
                q(accessibilityNodeInfoI);
                return 6;
            }
            sVar.f1326d = jCurrentTimeMillis;
            if (i3 == 4) {
                c0.i(12);
            }
            q(accessibilityNodeInfoI);
            return 1;
        } catch (Throwable th2) {
            q(accessibilityNodeInfoI);
            throw th2;
        }
    }

    public boolean e(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) throws Throwable {
        float fMax;
        d0.d dVar = (d0.d) this.f5993c;
        AccessibilityNodeInfo accessibilityNodeInfoK = k(accessibilityNodeInfo);
        if (accessibilityNodeInfoK != null) {
            if (z2) {
                try {
                    if (accessibilityNodeInfoK.isCheckable() && accessibilityNodeInfoK.isChecked()) {
                        return true;
                    }
                } finally {
                    q(accessibilityNodeInfoK);
                }
            }
            if (dVar.e(16, accessibilityNodeInfoK)) {
                return true;
            }
        }
        if (accessibilityNodeInfo.isClickable() && dVar.e(16, accessibilityNodeInfo)) {
            return true;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int i3 = rect.left;
        int i4 = rect.right;
        if (accessibilityNodeInfoK != null) {
            fMax = (i3 + i4) / 2.0f;
        } else {
            fMax = i4 - (Math.max(1, i4 - i3) * 0.18f);
        }
        return h(fMax, rect.centerY());
    }

    public void g(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f5993c;
        workDatabase_Impl.b();
        h hVar = (h) this.f5994d;
        k.i iVarA = hVar.a();
        if (str == null) {
            iVarA.l(1);
        } else {
            iVarA.m(str, 1);
        }
        workDatabase_Impl.c();
        try {
            iVarA.d();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.m(iVarA);
        }
    }

    public boolean h(float f3, float f4) {
        try {
            Path path = new Path();
            path.moveTo(f3, f4);
            return ((d0.d) this.f5993c).a((AccessibilityService) this.f5994d, new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), null);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("tap failed: "), "CalisePopOwnApp");
            return false;
        }
    }

    public AccessibilityNodeInfo i(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, ArrayList arrayList2) throws Throwable {
        ArrayList arrayList3 = new ArrayList();
        int i3 = 0;
        f(accessibilityNodeInfo, arrayList, arrayList3, 0, true);
        AccessibilityNodeInfo accessibilityNodeInfoL = l(arrayList3);
        int size = arrayList3.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList3.get(i4);
            i4++;
            q((AccessibilityNodeInfo) obj);
        }
        if (accessibilityNodeInfoL != null) {
            return accessibilityNodeInfoL;
        }
        arrayList3.clear();
        f(accessibilityNodeInfo, arrayList, arrayList3, 0, false);
        AccessibilityNodeInfo accessibilityNodeInfoL2 = l(arrayList3);
        int size2 = arrayList3.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList3.get(i5);
            i5++;
            q((AccessibilityNodeInfo) obj2);
        }
        if (accessibilityNodeInfoL2 != null) {
            return accessibilityNodeInfoL2;
        }
        int size3 = arrayList2.size();
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            String str = (String) obj3;
            if (str != null) {
                String strTrim = str.trim();
                if (strTrim.length() < 4) {
                    continue;
                } else {
                    try {
                        List listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(strTrim);
                        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
                            try {
                                AccessibilityNodeInfo accessibilityNodeInfoL3 = l(listFindAccessibilityNodeInfosByText);
                                if (accessibilityNodeInfoL3 != null) {
                                    return accessibilityNodeInfoL3;
                                }
                                Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByText.iterator();
                                while (it.hasNext()) {
                                    q(it.next());
                                }
                            } finally {
                                Iterator<AccessibilityNodeInfo> it2 = listFindAccessibilityNodeInfosByText.iterator();
                                while (it2.hasNext()) {
                                    q(it2.next());
                                }
                            }
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public AccessibilityNodeInfo l(List list) throws Throwable {
        int i3;
        AccessibilityNodeInfo accessibilityNodeInfo;
        try {
            i3 = ((AccessibilityService) this.f5994d).getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
            i3 = 1920;
        }
        Iterator it = list.iterator();
        do {
            accessibilityNodeInfo = null;
            if (!it.hasNext()) {
                break;
            }
            AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) it.next();
            AccessibilityNodeInfo accessibilityNodeInfoObtain = accessibilityNodeInfo2 == null ? null : AccessibilityNodeInfo.obtain(accessibilityNodeInfo2);
            int i4 = 0;
            while (true) {
                if (accessibilityNodeInfoObtain == null || i4 > 8) {
                    q(accessibilityNodeInfoObtain);
                } else {
                    Rect rect = new Rect();
                    accessibilityNodeInfoObtain.getBoundsInScreen(rect);
                    int i5 = rect.top;
                    int iHeight = rect.height();
                    boolean z2 = i5 == 0 && iHeight > 300;
                    boolean z3 = iHeight > Math.round(((float) Math.max(1, i3)) * 0.35f);
                    if (!z2 && !z3) {
                        AccessibilityNodeInfo accessibilityNodeInfoK = k(accessibilityNodeInfoObtain);
                        q(accessibilityNodeInfoK);
                        if (accessibilityNodeInfoK != null || accessibilityNodeInfoObtain.isClickable()) {
                            accessibilityNodeInfo = accessibilityNodeInfoObtain;
                        }
                    }
                    AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                    q(accessibilityNodeInfoObtain);
                    i4++;
                    accessibilityNodeInfoObtain = parent;
                }
            }
        } while (accessibilityNodeInfo == null);
        return accessibilityNodeInfo;
    }

    public void p(androidx.lifecycle.a aVar) {
        androidx.lifecycle.i iVar = (androidx.lifecycle.i) this.f5995e;
        if (iVar != null) {
            iVar.run();
        }
        androidx.lifecycle.i iVar2 = new androidx.lifecycle.i((androidx.lifecycle.e) this.f5993c, aVar);
        this.f5995e = iVar2;
        ((Handler) this.f5994d).postAtFrontOfQueue(iVar2);
    }

    public void r(Collection collection) {
        collection.getClass();
        synchronized (this.f5995e) {
            try {
                for (v.b bVar : (v.b[]) this.f5994d) {
                    if (bVar.f3272e != null) {
                        bVar.f3272e = null;
                        bVar.d(null, bVar.f3271d);
                    }
                }
                for (v.b bVar2 : (v.b[]) this.f5994d) {
                    bVar2.c(collection);
                }
                for (v.b bVar3 : (v.b[]) this.f5994d) {
                    if (bVar3.f3272e != this) {
                        bVar3.f3272e = this;
                        bVar3.d(this, bVar3.f3271d);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s() {
        synchronized (this.f5995e) {
            for (v.b bVar : (v.b[]) this.f5994d) {
                ArrayList arrayList = bVar.f3269b;
                if (!arrayList.isEmpty()) {
                    arrayList.clear();
                    bVar.f3268a.b(bVar);
                }
            }
        }
    }

    public void t() {
        s sVar = (s) this.f5995e;
        sVar.f1323a = 0;
        sVar.f1324b = 0;
        sVar.f1325c = false;
        sVar.f1326d = 0L;
        sVar.f1327e = 0L;
        sVar.f1328f = System.currentTimeMillis();
    }

    public m(Set set, String str, String str2) {
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.f5994d = str2;
        this.f5995e = s0.a.f3228a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f5993c = Collections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public m(WorkDatabase_Impl workDatabase_Impl) {
        this.f5993c = workDatabase_Impl;
        new b(workDatabase_Impl, 4);
        this.f5994d = new h(workDatabase_Impl, 2);
        this.f5995e = new h(workDatabase_Impl, 3);
    }

    public m(AccessibilityService accessibilityService) {
        this.f5993c = new d0.d();
        s sVar = new s();
        this.f5995e = sVar;
        this.f5994d = accessibilityService;
        sVar.f1328f = System.currentTimeMillis();
    }

    public m(androidx.lifecycle.f fVar) {
        this.f5993c = new androidx.lifecycle.e(fVar);
        this.f5994d = new Handler();
    }

    public /* synthetic */ m(Object obj, Serializable serializable, Object obj2) {
        this.f5993c = obj;
        this.f5994d = serializable;
        this.f5995e = obj2;
    }
}
