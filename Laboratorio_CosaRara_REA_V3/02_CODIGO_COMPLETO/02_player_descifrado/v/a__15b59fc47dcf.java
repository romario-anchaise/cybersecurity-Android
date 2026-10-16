// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v;

import w.e;
import y.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3267f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(e eVar, int i3) {
        super(eVar);
        this.f3267f = i3;
    }

    @Override // v.b
    public final boolean a(o oVar) {
        int i3 = this.f3267f;
        oVar.getClass();
        switch (i3) {
            case 0:
                return oVar.f6008j.f2834b;
            case 1:
                return oVar.f6008j.f2836d;
            case 2:
                return oVar.f6008j.f2833a == 2;
            case 3:
                int i4 = oVar.f6008j.f2833a;
                return i4 == 3 || i4 == 6;
            default:
                return oVar.f6008j.f2837e;
        }
    }

    @Override // v.b
    public final boolean b(Object obj) {
        boolean zBooleanValue;
        switch (this.f3267f) {
            case 0:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 1:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 2:
                u.a aVar = (u.a) obj;
                aVar.getClass();
                return (aVar.f3245a && aVar.f3246b) ? false : true;
            case 3:
                u.a aVar2 = (u.a) obj;
                aVar2.getClass();
                return !aVar2.f3245a || aVar2.f3247c;
            default:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !zBooleanValue;
    }
}
