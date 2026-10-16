// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

/* JADX INFO: loaded from: classes.dex */
public final class o extends F0.j implements E0.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f379c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(int i2, Object obj) {
        super(1);
        this.f378b = i2;
        this.f379c = obj;
    }

    @Override // E0.l
    public final Object d(Object obj) {
        switch (this.f378b) {
            case 0:
                J0.c cVar = (J0.c) obj;
                F0.i.e(cVar, "it");
                String str = (String) this.f379c;
                F0.i.e(str, "<this>");
                return str.subSequence(cVar.f278a, cVar.f279b + 1).toString();
            case 1:
                ((U0.d) this.f379c).b();
                return p034t0.h.f4132b;
            case 2:
                ((X.g) this.f379c).f877k = true;
                return p034t0.h.f4132b;
            default:
                return obj == ((p036u0.c) this.f379c) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
