// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f6219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f6220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f6221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f6222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f6223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f6224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ k[] f6225i;

    static {
        k kVar = new k("AOSP", 0);
        f6219c = kVar;
        k kVar2 = new k("SAMSUNG", 1);
        f6220d = kVar2;
        k kVar3 = new k("MIUI", 2);
        f6221e = kVar3;
        k kVar4 = new k("COLOR_OS", 3);
        f6222f = kVar4;
        k kVar5 = new k("VIVO", 4);
        f6223g = kVar5;
        k kVar6 = new k("HUAWEI", 5);
        f6224h = kVar6;
        f6225i = new k[]{kVar, kVar2, kVar3, kVar4, kVar5, kVar6, new k("UNKNOWN", 6)};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f6225i.clone();
    }
}
