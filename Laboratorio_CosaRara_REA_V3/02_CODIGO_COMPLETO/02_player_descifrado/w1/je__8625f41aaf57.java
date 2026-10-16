// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class je implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f4375f;

    public /* synthetic */ je(cf cfVar, int i3, long j3, int i4) {
        this.f4372c = i4;
        this.f4373d = cfVar;
        this.f4374e = i3;
        this.f4375f = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4372c) {
            case 0:
                cf cfVar = this.f4373d;
                if (this.f4374e == cfVar.f3720o0 && cfVar.f3722p0 == this.f4375f) {
                    cfVar.f3722p0 = 0L;
                    if (!cfVar.v0()) {
                        cfVar.J("registration_retry", false);
                        break;
                    }
                }
                break;
            default:
                cf cfVar2 = this.f4373d;
                if (this.f4374e == cfVar2.f3699d0 && cfVar2.f3701e0 == this.f4375f) {
                    cfVar2.f3701e0 = 0L;
                    if (!cfVar2.u0()) {
                        cfVar2.J("persisted_backoff", false);
                        break;
                    }
                }
                break;
        }
    }
}
