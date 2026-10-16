// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IInterface;
import android.os.Parcel;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.n1;
import java.util.ArrayDeque;
import lyr.stable.runtime.ScreenMirrorService;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1487c;

    public void a(com.google.android.gms.common.internal.a aVar, u0.b bVar) {
        IInterface iInterface;
        n1 n1Var = (n1) ((n1) this.f1487c).f905c;
        n1Var.getClass();
        j0.d dVar = (j0.d) aVar;
        synchronized (dVar.f482f) {
            if (dVar.f489m == 5) {
                throw new DeadObjectException();
            }
            if (!dVar.j()) {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
            iInterface = dVar.f486j;
            h0.o.d(iInterface, "Client is connected but service is null");
        }
        j0.a aVar2 = (j0.a) iInterface;
        h0.i iVar = (h0.i) n1Var.f905c;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar2.f2308b);
        int i3 = p0.b.f2870a;
        if (iVar == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            iVar.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar2.f2307a.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            u0.e eVar = bVar.f3250a;
            synchronized (eVar.f3256a) {
                eVar.b();
                eVar.f3258c = true;
                eVar.f3259d = null;
            }
            eVar.f3257b.e(eVar);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public boolean b(String str, int i3) {
        int i4;
        if (c(i3)) {
            Bundle bundle = null;
            if (i3 == 3) {
                i4 = 4096;
            } else if (i3 == 4) {
                i4 = 8192;
            } else if (i3 == 5) {
                bundle = new Bundle();
                bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
                i4 = 2097152;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) this.f1486b;
            try {
                boolean zPerformAction = bundle == null ? accessibilityNodeInfo.performAction(i4) : accessibilityNodeInfo.performAction(i4, bundle);
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f1487c;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.a6(zPerformAction);
                return zPerformAction;
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("[ControlAction] node action failed: "), "ScreenMirror");
                return false;
            }
        }
        return false;
    }

    public boolean c(int i3) {
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) this.f1486b;
        if (this.f1485a) {
            return false;
        }
        try {
            if (accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isVisibleToUser()) {
                if (i3 == 3 || i3 == 4) {
                    return accessibilityNodeInfo.isScrollable();
                }
                if (i3 != 5) {
                    return false;
                }
                return accessibilityNodeInfo.isEditable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void d(u0.d dVar) {
        synchronized (this.f1486b) {
            try {
                if (((ArrayDeque) this.f1487c) == null) {
                    this.f1487c = new ArrayDeque();
                }
                ((ArrayDeque) this.f1487c).add(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(u0.e eVar) {
        u0.d dVar;
        synchronized (this.f1486b) {
            if (((ArrayDeque) this.f1487c) != null && !this.f1485a) {
                this.f1485a = true;
                while (true) {
                    synchronized (this.f1486b) {
                        try {
                            dVar = (u0.d) ((ArrayDeque) this.f1487c).poll();
                            if (dVar == null) {
                                this.f1485a = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    switch (dVar.f3252a) {
                        case 0:
                            synchronized (dVar.f3254c) {
                                break;
                            }
                            dVar.f3253b.execute(new j(dVar, eVar, 4));
                            break;
                        default:
                            if (!eVar.a()) {
                                synchronized (dVar.f3254c) {
                                    break;
                                }
                                dVar.f3253b.execute(new j(dVar, eVar, 5));
                            } else {
                                continue;
                            }
                            break;
                    }
                }
            }
        }
    }
}
