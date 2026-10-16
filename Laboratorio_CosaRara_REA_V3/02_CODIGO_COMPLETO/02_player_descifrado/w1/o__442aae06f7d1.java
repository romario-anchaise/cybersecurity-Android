// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayDeque;
import lyr.stable.runtime.A11yBridgeService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A11yBridgeService f4670a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(A11yBridgeService a11yBridgeService) {
        super(Looper.getMainLooper());
        this.f4670a = a11yBridgeService;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3;
        o oVar;
        if (message == null || message.sendingUid != Process.myUid() || (i3 = message.what) < 1 || i3 > 38) {
            StringBuilder sb = new StringBuilder("rejected command what=");
            sb.append(message != null ? message.what : -1);
            sb.append(" uid=");
            sb.append(message != null ? message.sendingUid : -1);
            Log.w("A11yBridgeService", sb.toString());
            return;
        }
        try {
            Bundle data = message.getData();
            boolean zM = n.M(data);
            int i4 = message.what;
            if (!zM) {
                Log.w("A11yBridgeService", "rejected invalid command data what=" + i4);
                return;
            }
            p pVar = new p(i4, new Bundle(data), SystemClock.elapsedRealtime());
            int i5 = A11yBridgeService.f2430e;
            A11yBridgeService a11yBridgeService = this.f4670a;
            if (a11yBridgeService.a(pVar)) {
                return;
            }
            ArrayDeque arrayDeque = a11yBridgeService.f2431a;
            if (arrayDeque.size() >= 64) {
                arrayDeque.removeFirst();
                Log.w("A11yBridgeService", "service-wait queue full; dropped oldest command");
            }
            arrayDeque.addLast(pVar);
            if (a11yBridgeService.f2434d || (oVar = a11yBridgeService.f2432b) == null) {
                return;
            }
            a11yBridgeService.f2434d = true;
            oVar.postDelayed(new a2.b(12, a11yBridgeService), 250L);
        } catch (Throwable th) {
            Log.w("A11yBridgeService", "rejected unparcelable command", th);
        }
    }
}
