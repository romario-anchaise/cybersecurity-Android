// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f3798a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b8 f3803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c2.m f3804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d2.o f3809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d2.o f3810m;
    public d2.o n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f3799b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3800c = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3811o = 16;

    public d8(m0 m0Var) {
        this.f3798a = m0Var;
    }

    public static String A(c2.m mVar) {
        if (mVar == null) {
            return null;
        }
        return "windowId=" + mVar.f440c + " viewId=" + mVar.f439b;
    }

    public static void l(ff ffVar, int i3) {
        if (ffVar == null) {
            return;
        }
        try {
            sf[] sfVarArr = ffVar.f4056a;
            AtomicInteger atomicInteger = ffVar.f4057b;
            sf sfVar = sfVarArr[0];
            if (sfVar != null) {
                sf.d(sfVar, i3);
            } else {
                atomicInteger.compareAndSet(0, i3);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        d2.o oVar = this.f3809l;
        if (oVar != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
            } catch (Throwable unused) {
            }
        }
        this.f3809l = null;
        this.f3808k = 0L;
        d2.o oVar2 = this.f3810m;
        if (oVar2 != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar2.f603d);
            } catch (Throwable unused2) {
            }
        }
        this.f3810m = null;
        d2.o oVar3 = this.n;
        if (oVar3 != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar3.f603d);
            } catch (Throwable unused3) {
            }
        }
        this.n = null;
        this.f3811o = 16L;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet<b8> linkedHashSet = this.f3799b;
        for (b8 b8Var : linkedHashSet) {
            b8Var.f3582g = true;
            b8Var.f3579d = null;
            b8Var.f3580e = null;
            b8Var.f3581f = null;
            b8Var.f3583h = false;
            arrayList.add(b8Var.f3577b);
        }
        linkedHashSet.clear();
        this.f3803f = null;
        return arrayList;
    }

    public final boolean c(b8 b8Var) {
        return (b8Var == null || b8Var.f3582g || !this.f3799b.contains(b8Var) || b8Var.f3576a.f3664a != this.f3801d || this.f3800c == 8) ? false : true;
    }

    public final void d(int i3) {
        if (this.f3800c == 8) {
            return;
        }
        this.f3800c = 8;
        long j3 = this.f3802e + 1;
        this.f3802e = j3;
        a();
        f();
        g();
        y();
        ArrayList arrayListB = b();
        int size = arrayListB.size();
        boolean z2 = false;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayListB.get(i4);
            i4++;
            l((ff) obj, i3);
        }
        this.f3810m = u(1000L, new z7(this, j3, 3));
        try {
            m0 m0Var = this.f3798a;
            z7 z7Var = new z7(this, j3, 4);
            m0Var.getClass();
            z2 = m0.z(j3, z7Var);
        } catch (Throwable unused) {
        }
        if (this.f3810m == null || !z2) {
            q("recovery_start_failed");
        }
    }

    public final void e(int i3) {
        if (this.f3799b.isEmpty()) {
            return;
        }
        f();
        g();
        ArrayList arrayListB = b();
        y();
        int size = arrayListB.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayListB.get(i4);
            i4++;
            l((ff) obj, i3);
        }
    }

    public final c8 f() {
        for (b8 b8Var : this.f3799b) {
            if (!b8Var.f3582g) {
                return b8Var.f3576a;
            }
        }
        return null;
    }

    public final int g() {
        Iterator it = this.f3799b.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((b8) it.next()).f3584i);
        }
        return iMax;
    }

    public final void h() {
        c2.m mVar;
        boolean z2;
        if (this.f3800c != 2 || (mVar = this.f3804g) == null || this.f3805h) {
            return;
        }
        if (t(mVar)) {
            if (v(2, this.f3802e)) {
                return;
            }
            d(4);
            return;
        }
        d2.o oVar = this.n;
        if (oVar != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
            } catch (Throwable unused) {
            }
        }
        this.n = null;
        this.f3805h = true;
        long j3 = this.f3802e;
        f();
        g();
        A(this.f3804g);
        y();
        try {
            m0 m0Var = this.f3798a;
            z7 z7Var = new z7(this, j3, 2);
            m0Var.getClass();
            z2 = m0.z(j3, z7Var);
        } catch (Throwable unused2) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        d(4);
    }

    public final void i() {
        boolean z2;
        if (this.f3800c != 6 || this.f3806i) {
            return;
        }
        c2.m mVar = this.f3804g;
        if (mVar != null && t(mVar)) {
            if (v(6, this.f3802e)) {
                return;
            }
            d(4);
            return;
        }
        d2.o oVar = this.n;
        if (oVar != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
            } catch (Throwable unused) {
            }
        }
        this.n = null;
        this.f3806i = true;
        long j3 = this.f3802e;
        try {
            m0 m0Var = this.f3798a;
            z7 z7Var = new z7(this, j3, 5);
            m0Var.getClass();
            z2 = m0.z(j3, z7Var);
        } catch (Throwable unused2) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        d(4);
    }

    public final void j() {
        c2.m mVarK;
        long j3;
        int i3 = this.f3800c;
        if (i3 == 7 || i3 == 8) {
            try {
                m0 m0Var = this.f3798a;
                long j4 = this.f3801d;
                m0Var.getClass();
                mVarK = m0.k(j4);
            } catch (Throwable unused) {
                mVarK = null;
            }
            if (mVarK == null || !z(mVarK)) {
                int i4 = this.f3800c;
                if (v(i4, this.f3802e)) {
                    return;
                }
                if (i4 == 8) {
                    q("recovery_visibility_retry_schedule_failed");
                    return;
                } else {
                    d(4);
                    return;
                }
            }
            a();
            this.f3804g = null;
            this.f3805h = false;
            this.f3806i = false;
            this.f3800c = 1;
            f();
            g();
            A(mVarK);
            y();
            f();
            g();
            y();
            LinkedHashSet<b8> linkedHashSet = this.f3799b;
            if (linkedHashSet.isEmpty()) {
                return;
            }
            for (b8 b8Var : linkedHashSet) {
                if (!b8Var.f3582g) {
                    j3 = b8Var.f3578c;
                    w(j3);
                }
            }
            j3 = 8000;
            w(j3);
        }
    }

    public final void k(long j3) {
        c2.m mVarK;
        m0 m0Var = this.f3798a;
        if (j3 == this.f3802e && this.f3800c == 2 && this.f3804g == null && !this.f3799b.isEmpty()) {
            f();
            c2.m mVarL = null;
            try {
                long j4 = this.f3801d;
                m0Var.getClass();
                mVarK = m0.k(j4);
            } catch (Throwable unused) {
                mVarK = null;
            }
            if (!z(mVarK)) {
                g();
                y();
                if (v(2, j3)) {
                    return;
                }
                d(4);
                return;
            }
            d2.o oVar = this.n;
            if (oVar != null) {
                try {
                    wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
                } catch (Throwable unused2) {
                }
            }
            this.n = null;
            g();
            A(mVarK);
            y();
            try {
                long j5 = this.f3801d;
                m0Var.getClass();
                mVarL = m0.l(j5, j3);
            } catch (Throwable unused3) {
            }
            if (mVarL == null || !z(mVarL) || mVarL.f439b != mVarK.f439b || mVarL.f440c != mVarK.f440c) {
                d(4);
                return;
            }
            this.f3804g = mVarL;
            g();
            A(mVarL);
            y();
            h();
        }
    }

    public final void m(long j3) {
        r();
        if (j3 <= 0) {
            o2.i("generation required");
            return;
        }
        a();
        e(6);
        this.f3801d = j3;
        this.f3803f = null;
        this.f3804g = null;
        this.f3805h = false;
        this.f3806i = false;
        this.f3807j = false;
        this.f3800c = 1;
        this.f3802e++;
        y();
    }

    public final void n(int i3, long j3) {
        int i4;
        String str;
        r();
        if (j3 == this.f3802e && (i4 = this.f3800c) == i3) {
            if (i4 == 8) {
                d2.o oVar = this.f3810m;
                if (oVar != null) {
                    try {
                        wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
                    } catch (Throwable unused) {
                    }
                }
                this.f3810m = null;
                y();
                j();
                return;
            }
            switch (i3) {
                case 1:
                    str = "BLOCKED";
                    break;
                case 2:
                    str = "PREPARING";
                    break;
                case 3:
                    str = "READY";
                    break;
                case 4:
                    str = "ACTIVE";
                    break;
                case 5:
                    str = "INPUT_DRAINING";
                    break;
                case 6:
                    str = "DRAINING";
                    break;
                case 7:
                    str = "REARMING";
                    break;
                case 8:
                    str = "FAIL_CLOSED";
                    break;
                default:
                    throw null;
            }
            str.toLowerCase();
            d(14);
        }
    }

    public final void o() {
        r();
        int i3 = this.f3800c;
        if (i3 == 2) {
            if (this.f3804g == null) {
                k(this.f3802e);
                return;
            } else {
                h();
                return;
            }
        }
        if (i3 == 6) {
            i();
        } else if (i3 == 7 || i3 == 8) {
            j();
        }
    }

    public final void p() {
        if (this.f3800c == 3 && this.f3803f == null) {
            for (b8 b8Var : this.f3799b) {
                f2 f2Var = b8Var.f3579d;
                if (!b8Var.f3582g && f2Var != null) {
                    b8Var.f3579d = null;
                    b8Var.f3583h = true;
                    this.f3803f = b8Var;
                    this.f3800c = 4;
                    y();
                    f2Var.run();
                    return;
                }
            }
        }
    }

    public final void q(String str) {
        if (this.f3807j) {
            return;
        }
        this.f3807j = true;
        a();
        f();
        g();
        y();
        try {
            this.f3798a.getClass();
            wf.P(str);
        } catch (Throwable unused) {
        }
    }

    public final void r() {
        this.f3798a.getClass();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        o2.k("overlay punch coordinator must run on main thread");
    }

    public final b8 s(c8 c8Var, long j3, ff ffVar) {
        r();
        long j4 = c8Var.f3664a;
        if (j4 > 0 && j4 == this.f3801d && j3 > 0 && this.f3800c != 8) {
            LinkedHashSet<b8> linkedHashSet = this.f3799b;
            for (b8 b8Var : linkedHashSet) {
                if (b8Var.f3582g || !c8Var.equals(b8Var.f3576a)) {
                }
            }
            if (this.f3800c != 1 && this.f3808k > 0) {
                this.f3798a.getClass();
                if (SystemClock.uptimeMillis() >= this.f3808k) {
                    l(ffVar, 14);
                    return null;
                }
            }
            long jMin = Math.min(8000L, j3);
            b8 b8Var2 = new b8(c8Var, jMin, ffVar);
            linkedHashSet.add(b8Var2);
            y();
            if (this.f3800c == 1) {
                w(jMin);
            }
            return b8Var2;
        }
        l(ffVar, 13);
        return null;
    }

    public final boolean t(c2.m mVar) {
        int i3;
        AccessibilityService accessibilityService;
        try {
            this.f3798a.getClass();
            if (Looper.myLooper() == Looper.getMainLooper() && mVar != null && (i3 = mVar.f440c) >= 0) {
                List<AccessibilityWindowInfo> windows = null;
                if (Looper.myLooper() == Looper.getMainLooper() && (accessibilityService = wf.f5443f) != null) {
                    try {
                        windows = accessibilityService.getWindows();
                    } catch (Throwable unused) {
                    }
                }
                if (windows == null) {
                    return true;
                }
                for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                    if (accessibilityWindowInfo != null && accessibilityWindowInfo.getId() == i3) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable unused2) {
            return true;
        }
    }

    public final d2.o u(long j3, Runnable runnable) {
        try {
            m0 m0Var = this.f3798a;
            long jMax = Math.max(1L, j3);
            m0Var.getClass();
            if (wf.f5438a.postDelayed(runnable, Math.max(0L, jMax))) {
                return new d2.o(21, runnable);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean v(int i3, long j3) {
        if (j3 == this.f3802e && this.f3800c == i3 && this.n == null) {
            long jMax = Math.max(16L, Math.min(250L, this.f3811o));
            d2.o oVarU = u(jMax, new a8(this, j3, i3));
            if (oVarU == null) {
                return false;
            }
            this.n = oVarU;
            this.f3811o = Math.min(250L, jMax >= 125 ? 250L : jMax * 2);
        }
        return true;
    }

    public final void w(long j3) {
        if (this.f3801d <= 0 || this.f3799b.isEmpty()) {
            return;
        }
        this.f3800c = 2;
        long j4 = this.f3802e + 1;
        this.f3802e = j4;
        this.f3804g = null;
        this.f3805h = false;
        this.f3806i = false;
        a();
        long jMin = Math.min(8000L, Math.max(1L, j3));
        this.f3798a.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.f3808k = jUptimeMillis <= Long.MAX_VALUE - jMin ? jUptimeMillis + jMin : Long.MAX_VALUE;
        this.f3809l = u(jMin, new z7(this, j4, 0));
        d2.o oVarU = u(1000L, new z7(this, j4, 1));
        this.f3810m = oVarU;
        if (this.f3809l == null || oVarU == null) {
            d(4);
        } else {
            k(j4);
        }
    }

    public final void x() {
        if (this.f3801d <= 0) {
            a();
            this.f3800c = 1;
            return;
        }
        this.f3800c = 6;
        long j3 = this.f3802e + 1;
        this.f3802e = j3;
        this.f3805h = false;
        this.f3806i = false;
        d2.o oVar = this.f3809l;
        if (oVar != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
            } catch (Throwable unused) {
            }
        }
        this.f3809l = null;
        this.f3808k = 0L;
        d2.o oVar2 = this.f3810m;
        if (oVar2 != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar2.f603d);
            } catch (Throwable unused2) {
            }
        }
        this.f3810m = null;
        d2.o oVar3 = this.n;
        if (oVar3 != null) {
            try {
                wf.f5438a.removeCallbacks((Runnable) oVar3.f603d);
            } catch (Throwable unused3) {
            }
        }
        this.n = null;
        this.f3811o = 16L;
        d2.o oVarU = u(1000L, new z7(this, j3, 7));
        this.f3810m = oVarU;
        if (oVarU == null) {
            d(4);
            return;
        }
        f();
        g();
        y();
        i();
    }

    public final void y() {
        try {
            this.f3798a.getClass();
            Handler handler = wf.f5438a;
        } catch (Throwable unused) {
        }
    }

    public final boolean z(c2.m mVar) {
        return mVar != null && mVar.f438a == this.f3801d && mVar.f439b > 0 && mVar.f440c >= 0;
    }
}
