// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f2746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ g[] f2747c;

    static {
        g gVar = new g("FILL", 0);
        f2745a = gVar;
        g gVar2 = new g("FIT", 1);
        f2746b = gVar2;
        f2747c = new g[]{gVar, gVar2};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f2747c.clone();
    }
}
