// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import y.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f187a = new m(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        this.f187a.p(a.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f187a.p(a.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        a aVar = a.ON_STOP;
        m mVar = this.f187a;
        mVar.p(aVar);
        mVar.p(a.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i3) {
        this.f187a.p(a.ON_START);
        super.onStart(intent, i3);
    }
}
