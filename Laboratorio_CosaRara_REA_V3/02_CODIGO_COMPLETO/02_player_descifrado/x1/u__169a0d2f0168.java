// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f5933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f5935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f5937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f5938i;

    public /* synthetic */ u(w wVar, String str, String str2, String str3, boolean z2, long j3, int i3) {
        this.f5932c = i3;
        this.f5933d = wVar;
        this.f5934e = str;
        this.f5935f = str2;
        this.f5936g = str3;
        this.f5937h = z2;
        this.f5938i = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5932c) {
            case 0:
                this.f5933d.i(this.f5934e, this.f5935f, this.f5936g, this.f5937h, this.f5938i);
                break;
            default:
                this.f5933d.i(this.f5934e, this.f5935f, this.f5936g, this.f5937h, this.f5938i);
                break;
        }
    }
}
