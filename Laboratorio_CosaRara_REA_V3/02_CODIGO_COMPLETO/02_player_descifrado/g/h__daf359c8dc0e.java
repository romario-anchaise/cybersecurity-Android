// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends RemoteCallbackList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f1396a;

    public h(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f1396a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        ((c) iInterface).getClass();
        obj.getClass();
        this.f1396a.f200b.remove((Integer) obj);
    }
}
