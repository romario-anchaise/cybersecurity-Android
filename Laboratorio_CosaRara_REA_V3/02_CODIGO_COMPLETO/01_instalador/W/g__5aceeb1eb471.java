// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ g[] f753e;

    static {
        g gVar = new g("MEMORY_CACHE", 0);
        f749a = gVar;
        g gVar2 = new g("MEMORY", 1);
        f750b = gVar2;
        g gVar3 = new g("DISK", 2);
        f751c = gVar3;
        g gVar4 = new g("NETWORK", 3);
        f752d = gVar4;
        f753e = new g[]{gVar, gVar2, gVar3, gVar4};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f753e.clone();
    }
}
