// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0052y extends AbstractC0029a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f465d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0052y(p040w0.i iVar, boolean z2, int i2) {
        super(iVar, z2);
        this.f465d = i2;
    }

    @Override // N0.a0
    public boolean z(Throwable th) {
        switch (this.f465d) {
            case 1:
                AbstractC0049v.f(this.f416c, th);
                return true;
            default:
                return super.z(th);
        }
    }
}
