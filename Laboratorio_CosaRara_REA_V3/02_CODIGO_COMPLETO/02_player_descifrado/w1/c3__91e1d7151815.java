// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyDisplayInfo;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c3 extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a3 f3654a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c3(b3 b3Var, a3 a3Var) {
        super(b3Var);
        this.f3654a = a3Var;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        if (telephonyDisplayInfo != null) {
            this.f3654a.accept(telephonyDisplayInfo.getOverrideNetworkType());
        }
    }
}
