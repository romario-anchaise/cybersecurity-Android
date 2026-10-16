// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e4 f3868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e4 f3869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e4 f3870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e4 f3871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ e4[] f3872g;

    static {
        e4 e4Var = new e4("SECURITY", 0);
        f3868c = e4Var;
        e4 e4Var2 = new e4("REMOTE", 1);
        f3869d = e4Var2;
        e4 e4Var3 = new e4("AUTOMATION", 2);
        f3870e = e4Var3;
        e4 e4Var4 = new e4("BACKGROUND", 3);
        f3871f = e4Var4;
        f3872g = new e4[]{e4Var, e4Var2, e4Var3, e4Var4};
    }

    public static e4 valueOf(String str) {
        return (e4) Enum.valueOf(e4.class, str);
    }

    public static e4[] values() {
        return (e4[]) f3872g.clone();
    }
}
