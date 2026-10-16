// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

/* JADX INFO: loaded from: classes.dex */
public final class w extends F0.j implements E0.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f577c = new w(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f578d = new w(2, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w f579e = new w(2, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f580b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(int i2, int i3) {
        super(i2);
        this.f580b = i3;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        switch (this.f580b) {
            case 0:
                return obj;
            case 1:
                androidx.fragment.app.y.a(obj);
                return null;
            default:
                return (y) obj;
        }
    }
}
