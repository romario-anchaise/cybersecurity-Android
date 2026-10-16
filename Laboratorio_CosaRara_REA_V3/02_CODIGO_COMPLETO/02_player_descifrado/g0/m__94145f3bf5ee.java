// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y.l f1479b;

    public m(y.l lVar) {
        this.f1479b = lVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            Object obj = this.f1479b.f5992d;
            throw null;
        }
    }
}
