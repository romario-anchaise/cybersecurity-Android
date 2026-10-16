// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c2 f737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c2 f738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ c2[] f739e;

    static {
        c2 c2Var = new c2("FIRST_FRAME_PUBLISHED", 0);
        f737c = c2Var;
        c2 c2Var2 = new c2("PERSISTENT_FAILURE", 1);
        f738d = c2Var2;
        f739e = new c2[]{c2Var, c2Var2};
    }

    public static c2 valueOf(String str) {
        return (c2) Enum.valueOf(c2.class, str);
    }

    public static c2[] values() {
        return (c2[]) f739e.clone();
    }
}
