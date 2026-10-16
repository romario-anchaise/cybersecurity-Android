// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p030q0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f4023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.C0000a f4024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.a f4025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f4026d;

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f4023a = z2;
        if (z2) {
            f4024b = a.f4017b;
            f4025c = b.f4019b;
            f4026d = d.f4021b;
        } else {
            f4024b = null;
            f4025c = null;
            f4026d = null;
        }
    }
}
