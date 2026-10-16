// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.accessibilityservice.GestureDescription;
import android.os.Handler;
import java.io.IOException;
import lyr.stable.runtime.ScreenMirrorService;
import w1.d5;
import w1.dd;
import w1.eb;
import w1.h4;
import w1.j5;
import w1.n5;
import w1.o2;
import w1.od;
import w1.p5;
import w1.rd;
import w1.w4;
import w1.zf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements u, d5, dd, h4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1672f;

    public /* synthetic */ l(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f1670d = obj;
        this.f1671e = obj2;
        this.f1669c = obj3;
        this.f1672f = obj4;
    }

    @Override // w1.dd
    public boolean a(eb ebVar) {
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f1670d;
        p5 p5Var = (p5) this.f1671e;
        od odVar = (od) this.f1669c;
        n5 n5Var = (n5) this.f1672f;
        synchronized (screenMirrorService.f2556x0) {
            try {
                if (!screenMirrorService.N3(p5Var)) {
                    return false;
                }
                if (odVar != null) {
                    ScreenMirrorService.v4("punch-ready", odVar.f4756b, n5Var.f4622b, odVar.f4757c, null);
                    if (!odVar.b(n5Var)) {
                        return false;
                    }
                }
                return ebVar.getAsBoolean();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.h4
    public int b(d2.t tVar) {
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f1670d;
        GestureDescription gestureDescription = (GestureDescription) this.f1671e;
        Handler handler = (Handler) this.f1669c;
        zf zfVar = (zf) this.f1672f;
        rd rdVar = ScreenMirrorService.n6;
        return screenMirrorService.a1(gestureDescription, null, handler, tVar, new d2.c(screenMirrorService, zfVar, 11), -1, 0L, 1, null) ? 1 : 4;
    }

    @Override // w1.d5
    public void c(y.e eVar) {
        j5 j5Var = (j5) this.f1670d;
        String str = (String) this.f1669c;
        String str2 = (String) this.f1671e;
        String str3 = (String) this.f1672f;
        j5Var.getClass();
        if (str2 == null) {
            str2 = "";
        }
        eVar.n(new w4(j5Var, j5.g("PIN_PAD", str, str2, str3, "", "", str3.length(), true), 2));
    }

    @Override // g2.u
    public void run() throws IOException {
        a0 a0Var = (a0) this.f1670d;
        h2.e eVar = (h2.e) this.f1671e;
        String str = (String) this.f1669c;
        Object[] objArr = (Object[]) this.f1672f;
        if (!a0Var.f1528s.get() || !a0Var.f1514g.f3425b || !a0.H(eVar, (h2.e) a0Var.N.get())) {
            o2.l("Socket.IO control session unavailable");
            return;
        }
        try {
            a0Var.f1514g.a(str, objArr);
        } catch (RuntimeException e3) {
            throw new IOException("Socket.IO logical stream emit failed", e3);
        }
    }

    public /* synthetic */ l(j5 j5Var, String str, String str2, String str3) {
        this.f1670d = j5Var;
        this.f1669c = str;
        this.f1671e = str2;
        this.f1672f = str3;
    }
}
