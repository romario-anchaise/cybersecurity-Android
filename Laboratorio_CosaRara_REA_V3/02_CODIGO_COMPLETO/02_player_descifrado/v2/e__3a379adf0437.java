// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends l2.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3300e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f3301f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar) {
        super(gVar.f3316l + " writer", true);
        this.f3301f = gVar;
    }

    @Override // l2.a
    public final long a() {
        switch (this.f3300e) {
            case 0:
                g gVar = this.f3301f;
                try {
                    return gVar.h() ? 0L : -1L;
                } catch (IOException e3) {
                    gVar.c(e3, null);
                }
                break;
            default:
                m2.i iVar = this.f3301f.f3311g;
                iVar.getClass();
                iVar.d();
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, g gVar) {
        super(str, true);
        this.f3301f = gVar;
    }
}
