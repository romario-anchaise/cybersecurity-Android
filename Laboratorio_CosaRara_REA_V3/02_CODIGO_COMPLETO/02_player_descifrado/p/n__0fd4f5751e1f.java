// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lyr.stable.runtime.keepalive.ConnectionKeepAliveWorker;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UUID f2858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y.o f2859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f2860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2861e;

    public n(Class cls, byte b3) {
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.f2858b = uuidRandomUUID;
        String string = this.f2858b.toString();
        string.getClass();
        this.f2859c = new y.o(string, 0, cls.getName(), null, null, null, 0L, 0L, 0L, null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 1048570, 0);
        String[] strArr = {cls.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(q2.c.v(1));
        linkedHashSet.add(strArr[0]);
        this.f2860d = linkedHashSet;
    }

    public final u a() {
        u oVar;
        switch (this.f2861e) {
            case 0:
                if (this.f2857a && this.f2859c.f6008j.f2835c) {
                    o2.i("Cannot set backoff criteria on an idle mode job");
                    oVar = null;
                } else {
                    oVar = new o(this.f2858b, this.f2859c, this.f2860d);
                }
                break;
            default:
                if (this.f2857a && this.f2859c.f6008j.f2835c) {
                    o2.i("Cannot set backoff criteria on an idle mode job");
                } else {
                    y.o oVar2 = this.f2859c;
                    if (!oVar2.f6014q) {
                        oVar = new t(this.f2858b, oVar2, this.f2860d);
                    } else {
                        o2.i("PeriodicWorkRequests cannot be expedited");
                    }
                }
                oVar = null;
                break;
        }
        d dVar = this.f2859c.f6008j;
        boolean z2 = !dVar.f2840h.isEmpty() || dVar.f2836d || dVar.f2834b || dVar.f2835c;
        y.o oVar3 = this.f2859c;
        if (oVar3.f6014q) {
            if (z2) {
                o2.i("Expedited jobs only support network and storage constraints");
                return null;
            }
            if (oVar3.f6005g > 0) {
                o2.i("Expedited jobs cannot be delayed");
                return null;
            }
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        uuidRandomUUID.getClass();
        this.f2858b = uuidRandomUUID;
        String string = uuidRandomUUID.toString();
        string.getClass();
        y.o oVar4 = this.f2859c;
        oVar4.getClass();
        String str = oVar4.f6001c;
        int i3 = oVar4.f6000b;
        String str2 = oVar4.f6002d;
        e eVar = new e(oVar4.f6003e);
        e eVar2 = new e(oVar4.f6004f);
        long j3 = oVar4.f6005g;
        long j4 = oVar4.f6006h;
        long j5 = oVar4.f6007i;
        u uVar = oVar;
        d dVar2 = oVar4.f6008j;
        dVar2.getClass();
        this.f2859c = new y.o(string, i3, str, str2, eVar, eVar2, j3, j4, j5, new d(dVar2.f2833a, dVar2.f2834b, dVar2.f2835c, dVar2.f2836d, dVar2.f2837e, dVar2.f2838f, dVar2.f2839g, dVar2.f2840h), oVar4.f6009k, oVar4.f6010l, oVar4.f6011m, oVar4.n, oVar4.f6012o, oVar4.f6013p, oVar4.f6014q, oVar4.f6015r, oVar4.f6016s, 524288, 0);
        return uVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Class cls) {
        this(cls, (byte) 0);
        this.f2861e = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(ConnectionKeepAliveWorker.class, (byte) 0);
        this.f2861e = 1;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        timeUnit.getClass();
        timeUnit.getClass();
        y.o oVar = this.f2859c;
        oVar.getClass();
        String str = y.o.f5998u;
        oVar.f6006h = 900000L;
        if (300000 > 900000) {
            m.d().g(str, "Flex duration greater than interval duration; Changed to 900000");
        }
        oVar.f6007i = y.f.f(300000L, 300000L, oVar.f6006h);
    }
}
