// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import g.g;
import g.h;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f200b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f201c = new h(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f202d = new g(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        return this.f202d;
    }
}
