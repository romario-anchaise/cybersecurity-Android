// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ b[] f715f;

    static {
        b bVar = new b("HEARTBEAT", 0);
        f712c = bVar;
        b bVar2 = new b("CONTENT", 1);
        f713d = bVar2;
        b bVar3 = new b("POST_CONTROL", 2);
        f714e = bVar3;
        f715f = new b[]{bVar, bVar2, bVar3};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f715f.clone();
    }
}
