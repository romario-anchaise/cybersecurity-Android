// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.os.Bundle;
import android.os.ResultReceiver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends ResultReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f426d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super(null);
        this.f425c = atomicBoolean;
        this.f426d = countDownLatch;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        this.f425c.set(i3 == -1);
        this.f426d.countDown();
    }
}
