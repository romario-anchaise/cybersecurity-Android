// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.IOException;
import java.io.Serializable;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Serializable f5636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5637h;

    public /* synthetic */ y9(g.j jVar, int i3, int i4, IOException iOException, h2.g gVar) {
        this.f5632c = 2;
        this.f5633d = jVar;
        this.f5634e = i3;
        this.f5635f = i4;
        this.f5636g = iOException;
        this.f5637h = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5632c;
        Object obj = this.f5637h;
        Object obj2 = this.f5636g;
        int i4 = this.f5635f;
        int i5 = this.f5634e;
        Object obj3 = this.f5633d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                ((ScreenMirrorService) obj3).R5((float[]) obj2, (float[]) obj, i5, i4 + 1);
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                ((ScreenMirrorService) obj3).j6(i5, i4, (String) obj2, (String) obj);
                break;
            default:
                ((cf) ((g.j) obj3).f1415d).U(i5, i4, (IOException) obj2, (h2.g) obj);
                break;
        }
    }

    public /* synthetic */ y9(ScreenMirrorService screenMirrorService, Serializable serializable, Serializable serializable2, int i3, int i4, int i5) {
        this.f5632c = i5;
        this.f5633d = screenMirrorService;
        this.f5636g = serializable;
        this.f5637h = serializable2;
        this.f5634e = i3;
        this.f5635f = i4;
    }
}
