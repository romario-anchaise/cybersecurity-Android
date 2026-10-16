// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q1 f930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q1 f931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q1 f932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ q1[] f933f;

    static {
        q1 q1Var = new q1("NONE", 0);
        f930c = q1Var;
        q1 q1Var2 = new q1("PROJECTION", 1);
        f931d = q1Var2;
        q1 q1Var3 = new q1("WEBP", 2);
        f932e = q1Var3;
        f933f = new q1[]{q1Var, q1Var2, q1Var3};
    }

    public static q1 valueOf(String str) {
        return (q1) Enum.valueOf(q1.class, str);
    }

    public static q1[] values() {
        return (q1[]) f933f.clone();
    }
}
