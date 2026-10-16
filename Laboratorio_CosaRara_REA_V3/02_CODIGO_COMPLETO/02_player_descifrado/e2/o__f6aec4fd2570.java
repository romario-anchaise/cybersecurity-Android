// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f908c;

    public o(ScheduledExecutorService scheduledExecutorService, ArrayList arrayList, g gVar) {
        this.f906a = scheduledExecutorService;
        this.f907b = arrayList;
        this.f908c = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return q1.e.a(this.f906a, oVar.f906a) && this.f907b.equals(oVar.f907b) && q1.e.a(this.f908c, oVar.f908c);
    }

    public final int hashCode() {
        ScheduledExecutorService scheduledExecutorService = this.f906a;
        int iHashCode = (this.f907b.hashCode() + ((scheduledExecutorService == null ? 0 : scheduledExecutorService.hashCode()) * 31)) * 31;
        g gVar = this.f908c;
        return iHashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public final String toString() {
        return "StopAction(ticker=" + this.f906a + ", barriers=" + this.f907b + ", wakeupCancel=" + this.f908c + ")";
    }
}
