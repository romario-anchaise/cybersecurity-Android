// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0042n extends F0.j implements E0.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0042n f445c = new C0042n(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0042n f446d = new C0042n(2, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f447b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0042n(int i2, int i3) {
        super(i2);
        this.f447b = i3;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        switch (this.f447b) {
            case 0:
                return ((p040w0.i) obj).t((p040w0.g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                return bool;
            default:
                return ((p040w0.i) obj).t((p040w0.g) obj2);
        }
    }
}
