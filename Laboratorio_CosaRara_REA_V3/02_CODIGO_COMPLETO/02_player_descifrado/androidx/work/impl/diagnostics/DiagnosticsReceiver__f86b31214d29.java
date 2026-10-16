// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.OverwritingInputMerger;
import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.Collections;
import java.util.List;
import p.m;
import p.n;
import p.o;
import q.q;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f235a = m.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        m mVarD = m.d();
        String str = f235a;
        mVarD.a(str, "Requesting diagnostics");
        try {
            q qVarA = q.a(context);
            n nVar = new n(DiagnosticsWorker.class);
            nVar.f2859c.f6002d = OverwritingInputMerger.class.getName();
            List listSingletonList = Collections.singletonList((o) nVar.a());
            if (listSingletonList.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new q.m(qVarA, null, 2, listSingletonList, 0).a();
        } catch (IllegalStateException e3) {
            m.d().c(str, "WorkManager is not initialized", e3);
        }
    }
}
