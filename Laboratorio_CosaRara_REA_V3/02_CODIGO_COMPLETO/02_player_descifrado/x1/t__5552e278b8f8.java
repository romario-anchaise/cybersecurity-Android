// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f5928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f5930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5931g;

    public /* synthetic */ t(w wVar, long j3, String str, String str2, int i3) {
        this.f5927c = i3;
        this.f5928d = wVar;
        this.f5930f = j3;
        this.f5929e = str;
        this.f5931g = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5927c) {
            case 0:
                this.f5928d.h(this.f5930f, this.f5929e, this.f5931g);
                break;
            case 1:
                this.f5928d.h(this.f5930f, this.f5929e, this.f5931g);
                break;
            case 2:
                w wVar = this.f5928d;
                long j3 = this.f5930f;
                String str = this.f5929e;
                String str2 = this.f5931g;
                if (wVar.f5946d == j3 && wVar.f5947e < j3 && wVar.f5948f < j3) {
                    wVar.l("self_uninstall_trampoline_not_foreground", str, null, "connection_service", str2);
                    wVar.j(str, str2);
                    break;
                }
                break;
            default:
                w wVar2 = this.f5928d;
                long j4 = this.f5930f;
                String str3 = this.f5929e;
                String str4 = this.f5931g;
                if (wVar2.f5946d == j4 && wVar2.f5948f < j4) {
                    wVar2.l("self_uninstall_prompt_not_observed", str3, null, "connection_service", str4);
                    wVar2.j(str3, str4);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ t(w wVar, String str, long j3, String str2, int i3) {
        this.f5927c = i3;
        this.f5928d = wVar;
        this.f5929e = str;
        this.f5930f = j3;
        this.f5931g = str2;
    }
}
