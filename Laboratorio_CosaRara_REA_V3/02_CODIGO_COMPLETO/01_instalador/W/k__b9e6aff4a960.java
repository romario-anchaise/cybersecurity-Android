// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ k[] f762b;

    /* JADX INFO: Fake field, exist only in values array */
    k EF0;

    static {
        k kVar = new k("IGNORE", 0);
        k kVar2 = new k("RESPECT_PERFORMANCE", 1);
        f761a = kVar2;
        f762b = new k[]{kVar, kVar2, new k("RESPECT_ALL", 2)};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f762b.clone();
    }
}
